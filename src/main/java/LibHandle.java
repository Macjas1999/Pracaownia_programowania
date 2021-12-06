import java.util.Arrays;

public class LibHandle {
    private  String[] listOfFiles;


    public String[] getListOfFiles() { return listOfFiles; }

    public void setListOfFiles(String[] listOfFiles) { this.listOfFiles = listOfFiles; }

    @Override
    public String toString() {
        return Arrays.toString(listOfFiles);
    }
}
