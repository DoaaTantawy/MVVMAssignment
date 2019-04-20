package iti.mvvmassignment.model;

public class CounterModel {
    private int count;

    public CounterModel(){

        count=0;
    }

    //increasing the count by 1 when called.
    public void incrementCount(){
        count++;
    }

    public int getCount(){

        // Delaying the response by 1 second.
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return count;
    }
}
