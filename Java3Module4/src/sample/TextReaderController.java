package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    private ListView<String> textCountDisplay;

    private final LinkedList<File> fileLinkedList=new LinkedList<>();
    private ObservableList<String> countedWords=FXCollections.observableArrayList();
    private FileWordCountTask fWCTask;

    public TextReaderController(){
    }

    public void initialize(){textCountDisplay.setItems(countedWords);}

    @FXML
    public void AddFileButtonPressed(javafx.event.ActionEvent event) throws IOException {
        FileChooser fileChooser=new FileChooser();
        fileChooser.setTitle("Select Files");
        File selectedFile=fileChooser.showOpenDialog(null);

        fileLinkedList.addLast(selectedFile.getAbsoluteFile());
        textCountDisplay.getItems().add(selectedFile.getName());

        
    @FXML
    public void CountWordsButtonPressed(javafx.event.ActionEvent event) throws IOException {
        countedWords.clear();

        try{
            int index=1;
            while(index<fileLinkedList.size()-1) {
                fWCTask = new FileWordCountTask(fileLinkedList.componentAt(index));
            }

            int count=0;
            while(count<fileLinkedList.size()){
                textCountDisplay.getItems().add(String.valueOf(fWCTask));
                count++;
            }

        }
        catch (Exception e){

        }

    }
}
