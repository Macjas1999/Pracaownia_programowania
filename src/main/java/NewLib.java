import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class NewLib {
    //final String pathDict = "/home/maciej/Desktop/Pracaownia_programowania/src/main/dict/";

    public static void newLibFunction(String pathDict) {
        try {
            Scanner input = new Scanner(System.in);  //scanner object
            System.out.print("Enter 1 for default path 2 choose path: ");
            String userInput = input.nextLine();  // save user input
            if (userInput.equals("1")) {
                System.out.print("Enter file name: ");
                String fileNameDictForLib = input.nextLine();
                String newFilePath = pathDict + fileNameDictForLib + ".json";
                File newFile = new File(newFilePath);
                if (newFile.createNewFile()) {
                    System.out.println("File created: " + newFile.getName());
                    //System.out.print("Language: ");


                    ObjectMapper mapper = new ObjectMapper();
                    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                    // test czy działa json
                    LangLst newListOfFiles = new LangLst();
                    try {
                        System.out.print("Language: ");
                        String lang = input.nextLine();
                        newListOfFiles.setLanguage(lang);
                        System.out.println("To end inserting new words pass: \"-q\"");
                        //System.out.println(newListOfFiles.getLanguage());
                        StringBuilder resultWords = new StringBuilder();
                        int i = 0;
                        while (true) {
                            String userInputWords = input.nextLine();
//                            String[] resultWordsList = new String[];
                            if (userInputWords.equals("-q")) {
                                //resultWords = resultWords;
                                break;
                            } else {


                                if (i == 0) {
                                    //resultWords = resultWords + "\"" + userInputWords + "\"";
                                    resultWords.append(userInputWords);


                                } else {
                                    //resultWords = resultWords + " , " + "\"" + userInputWords + "\"";
                                    resultWords.append(",").append(userInputWords);

                                }
                            }
                            i++;
                        }

                        System.out.println(resultWords);
//                        String[] array = yourString.split(wordSeparator);

                        String[] resultWordsList = resultWords.toString().split(",");
                        newListOfFiles.setWords(resultWordsList);

                        //System.out.println(newListOfFiles.getWords()[0]);
                        mapper.writeValue(newFile, newListOfFiles);


                        //LibHandle newlistOfFiles = mapper.writeValue(new File(newFilePath), LibHandle.class);
                        LibHandle newLibHandle = mapper.readValue(new File("/home/maciej/Desktop/Pracaownia_programowania/src/main/dict/lib.json"), LibHandle.class);
                        File libSource = new File("/home/maciej/Desktop/Pracaownia_programowania/src/main/dict/lib.json");
                        StringBuilder libUpdate = new StringBuilder();
                        i = 0;
                        while (i <= newLibHandle.getListOfFiles().length) {
                            if (i == 0) {
                                libUpdate = new StringBuilder("lib.json,");
                                i++;
                                //continue;
                            } else if (i < newLibHandle.getListOfFiles().length) {
                                libUpdate.append(newLibHandle.getListOfFiles()[i]).append(",");
                                i++;
                                //continue;
                            } else if (i == newLibHandle.getListOfFiles().length) {
                                libUpdate.append(fileNameDictForLib).append(".json");
                                i++;

                            }
                        }
                        String[] resultFileList = libUpdate.toString().split(",");
                        newLibHandle.setListOfFiles(resultFileList);
                        mapper.writeValue(libSource, newLibHandle);

                    } finally {
                        System.out.println("File changed");
                    }

                } else {
                    System.out.println("File already exists.");
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
