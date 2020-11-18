package sample;

import javafx.concurrent.Task;

import java.io.*;

public class FileWordCountTask extends Task<Integer> {
    private int countWord=0;

    public FileWordCountTask(File fileLocation) throws IOException {

        FileInputStream fIS=new FileInputStream(fileLocation);
        InputStreamReader iSR=new InputStreamReader(fIS);
        BufferedReader reader=new BufferedReader(iSR);
        String line;
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
    protected Integer call()  {

        return countWord;
    }
}

