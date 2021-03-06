package readingfile2threads;

/**
 *
 * @author Nick
 */
public class ReadingFile2Threads {
    
    public static void main(String[] args) {
        
        FileReader highPriorityThread = new FileReader(Thread.NORM_PRIORITY + 4);
        FileReader lowPriorityThread = new FileReader(Thread.NORM_PRIORITY - 4);
        highPriorityThread.start();
        lowPriorityThread.start();
        
        try{
            Thread.sleep(3000);
        }catch(Exception ex){}
        
        lowPriorityThread.stop();
        highPriorityThread.stop();
        int highPriorityThreadRecord = highPriorityThread.recordOfReadFiles;
        int lowPriorityThreadRecord = lowPriorityThread.recordOfReadFiles;
        System.out.println("High priority Thread's record is " + highPriorityThreadRecord);
        System.out.println("Low priority Thread's record is  " + lowPriorityThreadRecord);
        
        double diff = highPriorityThreadRecord - lowPriorityThreadRecord;
        double boh = diff/lowPriorityThreadRecord;
        double percentageDiff = boh*100;
        System.out.println("High priority Thread read " + String.format("%.0f",diff) + " more than low priority Thread, which corresponds to " + String.format("%.2f",percentageDiff) + "%");
        
        System.exit(0);
    }
    
}
