package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.FileChooser;

import java.io.*;

public class TextReaderController {
    @FXML
    private Button addFileBtn;

    @FXML
    private Button countWordsBtn;

    @FXML
    private ListView textCountDisplay;


    public void Button1Action(javafx.event.ActionEvent event) throws IOException {
        FileChooser fileChooser=new FileChooser();
        File selectedFile=fileChooser.showOpenDialog(null);

        /*I can get this do perform a word count but I suspect I need to separate the FIS
        * into another class that will process the chosen files. How do I get the new class
        * to remember the choices made in the first button action then process the documents?*/
        if(selectedFile!=null) {
            FileInputStream fis=new FileInputStream(selectedFile);
            InputStreamReader isr=new InputStreamReader(fis);
            BufferedReader reader=new BufferedReader(isr);
            String line;
            int countWord=0;
            int paragraphCount=1;

            while ((line=reader.readLine())!=null){
                if(line.equals("")){
                    paragraphCount++;
                }
                else {
                    String[]wordList=line.split("\\s+");
                    countWord+=wordList.length;
                }
            }
            textCountDisplay.getItems().add(selectedFile.getName()+": "+countWord+" words");

//            textCountDisplay.getItems().add(selectedFile.getName());
        }
        else{
            System.out.println("Invalid file");
        }
    }

    //need to find how to get java to count # of words in a file
    //also need to get program to remember the files chosen
    public void Button2Action(javafx.event.ActionEvent event) throws IOException {
//        File file=new File();
//        FileInputStream fileInputStream=new FileInputStream(file);
//        InputStreamReader input =new InputStreamReader(fileInputStream);
//        BufferedReader reader=new BufferedReader(input);
//        String line;
//
//        int countWord=0;
//        int paragraphCount=1;
//
//        while((line=reader.readLine())!=null){
//            if(line.equals("")){
//                paragraphCount++;
//            }
//            else {
//                String[]wordList=line.split("\\s+");
//                countWord+=wordList.length;
//            }
        }

}
