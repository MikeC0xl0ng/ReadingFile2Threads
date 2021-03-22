package readingfile2threads;

/**
 *
 * @author Nick
 */
public class FileReader implements Runnable{
    int recordOfReadFiles = 0;
    private Thread readRecord;
    private boolean inExecution = true;
    
    public FileReader(int priority){
        readRecord = new Thread(this);
        readRecord.setPriority(priority);
    }
    
    public void run(){
        while(inExecution){
            // code that must do smth
            // filerecord
            recordOfReadFiles++;
        }
    }
    
    public void start(){
        readRecord.start();
    }
    public void stop(){
        inExecution = false;
    }
}
