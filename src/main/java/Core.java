import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Core {
    // Path to json language files folder
    //final String pathDict = "/home/maciej/Desktop/Pracaownia_programowania/src/main/dict/";

    public static void coreFunction(String pathDict){
        Scanner input = new Scanner(System.in);  //scanner object
        System.out.print("Enter word: ");
        String userInput = input.nextLine();  // save user input


        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false); // test czy działa json

        int howMany = 0;
        // list iteration handling
        try {
            LibHandle newlistOfFiles = mapper.readValue(new File("/home/maciej/Desktop/Pracaownia_programowania/src/main/dict/lib.json"), LibHandle.class);
            //System.out.println(Arrays.toString(newlistOfFiles.getListOfFiles())); // converting array string to string
            //Swithing lib

            int i = 0;
            //String pathName = new String();
            while (i < newlistOfFiles.getListOfFiles().length) {
                if (i == 0){
                    if (newlistOfFiles.getListOfFiles()[i].equals("lib.json")) {
                        //evalWords();
                        i++;
                    }
                }else{
                    String pathName = pathDict + newlistOfFiles.getListOfFiles()[i];
                        //System.out.println("Error loading lib.json. First object from listOfFiles does not match with Maim.java selftest.");
                    //Search througch one library
                    try {
                        LangLst lang = mapper.readValue(new File(pathName), LangLst.class);
                        //System.out.println("SearchLanguage loaded" + pathName);
                        int j = 0;
                        while (j < lang.getWords().length){
                            if (lang.getWords()[j].equals(userInput)){
                                System.out.println(lang.getWords()[j] + " found in: " + lang.getLanguage());
                                howMany++;

                            }
                            j++;
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    ///Search through one library
                    i++;
                    }
                }
            } catch (IOException e) {
                 e.printStackTrace();
                 System.out.println("Error handling lib.json");
            }
            // print how many
            if (howMany == 1){
                System.out.println("Word appeared in " + howMany + " language.");

            }else if (howMany > 1){
            System.out.println("Word appeared in " + howMany + " languages.");
            } else{
                System.out.println("Word didn't appear in any of stored languages");
            }
            /// print how many
        /// list iteration handling
    }
}


