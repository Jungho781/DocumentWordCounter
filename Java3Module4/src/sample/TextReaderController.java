package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.FileChooser;

import java.io.*;

public class TextReaderController {
    //Probably need a shared interface object to store the documents
    //Buttons should be called to add to or call from the object
    //If button1 is pressed during prompt, this happens; if button2 is pressed, that happens
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

        fileLinkedList.addLast(selectedFile);
        textCountDisplay.getItems().add(selectedFile.getName());

        /*I can get this do perform a word count but I suspect I need to separate the FIS
        * into another class that will process the chosen files. How do I get the new class
        * to remember the choices made in the first button action then process the documents?*/
//        if(selectedFile!=null) {
//            FileInputStream fis=new FileInputStream(selectedFile);
//            InputStreamReader isr=new InputStreamReader(fis);
//            BufferedReader reader=new BufferedReader(isr);
//            String line;
//            int countWord=0;
//            int paragraphCount=1;
//
//            while ((line=reader.readLine())!=null){
//                if(line.equals("")){
//                    paragraphCount++;
//                }
//                else {
//                    String[]wordList=line.split("\\s+");
//                    countWord+=wordList.length;
//                }
//            }
//            textCountDisplay.getItems().add(selectedFile.getName()+": "+countWord+" words");
//
////            textCountDisplay.getItems().add(selectedFile.getName());
//        }
//        else{
//            System.out.println("Invalid file");
//        }
    }

    //need to find how to get java to count # of words in a file
    //also need to get program to remember the files chosen
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
//            fWCTask.valueProperty().addListener((observable,oldValue,newValue)->{
//                countedWords.add(String.valueOf(newValue));
//                textCountDisplay.scrollTo(textCountDisplay.getItems().size());
//            });

        }
        catch (Exception e){

        }
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
