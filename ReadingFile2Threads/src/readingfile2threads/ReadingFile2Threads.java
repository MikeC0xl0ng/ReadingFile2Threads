package readingfile2threads;

/**
 *
 * @author Nick
 */
public class ReadingFile2Threads {

    public static void main(String[] args) {
        
        FileReader highPriorityThread = new FileReader(Thread.NORM_PRIORITY + 3);
        FileReader lowPriorityThread = new FileReader(Thread.NORM_PRIORITY - 3);
        highPriorityThread.start();
        lowPriorityThread.start();
        
        try{
            Thread.sleep(5000);
        }catch(Exception ex){}
        
        lowPriorityThread.stop();
        highPriorityThread.stop();
        System.out.println("High priority Thread's record is " + highPriorityThread.recordOfReadFiles);
        System.out.println("Low priority Thread's record is " + lowPriorityThread.recordOfReadFiles);
    }
    
}
