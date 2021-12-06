import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;


import java.io.IOException;

public class PDFCreator {

    public static void createPDF(String userInput)throws IOException {
        //Creating PDF document object
        PDDocument doc = new PDDocument();
        PDPage printNew = new PDPage();
        PDPageContentStream printNewStream = new PDPageContentStream(doc, printNew);
        printNewStream.showText(output core);


        //Saving the document
        doc.save("/eclipse-workspace/blank.pdf");
        PDPage blankPage = new PDPage();
        // inserting
        //    PDPageContentStream contentStream = new PDPageContentStream(doc, page);
        System.out.println("PDF created");

        //Closing the document
        doc.close();
    }
}
