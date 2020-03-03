public class NewThread extends Thread {
    @Override
    public void run() {
        try {
            synchronized (this){
                wait();
                wait(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("exception");
        }

    }
}
