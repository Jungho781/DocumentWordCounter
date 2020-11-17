package sample;

import javafx.concurrent.Task;

import java.io.*;

public class FileWordCountTask extends Task {
    private final File[] files;

    public FileWordCountTask(File fileLocation) throws IOException {
        files=new File[10];
        FileInputStream fIS=new FileInputStream(fileLocation);
        InputStreamReader iSR=new InputStreamReader(fIS);
        BufferedReader reader=new BufferedReader(iSR);
        String line;
        int countWord=0;
        int paragraphCount=1;

        while((line=reader.readLine())!=null){
            if(line.equals("")){
                paragraphCount++;
            }
            else{
                String[]wordList=line.split("\\s+");
                countWord+=wordList.length;
            }
        }
    }

    @Override
    protected Object call()  {

        return null;
    }
}
