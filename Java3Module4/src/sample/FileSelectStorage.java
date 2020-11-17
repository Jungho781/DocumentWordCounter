package sample;

import javafx.concurrent.Task;
import javafx.stage.FileChooser;

import java.io.File;

public class FileSelectStorage extends Task {
    public FileSelectStorage(File fileLocation){

        LinkedList<File>selectedDocs=new LinkedList<>();
        selectedDocs.addLast(fileLocation);

    }


    @Override
    protected Object call()  {

        return null;
    }
}
