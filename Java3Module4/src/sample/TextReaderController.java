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

        }
        else{
            System.out.println("Invalid file");
        }
    }

    public void Button2Action(javafx.event.ActionEvent event) throws IOException {


        }

}
