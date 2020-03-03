public class Main {

    public static void main(String[] args) throws InterruptedException {

        Thread thread1 =  new NewThread();
        System.out.println("Thread1: "+ thread1.getState());

        thread1.start();
        System.out.println("Thread1: "+ thread1.getState());

        synchronized (thread1){
            Thread.sleep(1000);
            System.out.println("Thread1: "+ thread1.getState());
            thread1.notify();
        }

        System.out.println("Thread1: "+ thread1.getState());

        Thread.sleep(1000);
        System.out.println("Thread1: "+ thread1.getState());

        thread1.interrupt();
        Thread.sleep(1000);
        System.out.println("Thread1: " + thread1.getState());
    }
}
