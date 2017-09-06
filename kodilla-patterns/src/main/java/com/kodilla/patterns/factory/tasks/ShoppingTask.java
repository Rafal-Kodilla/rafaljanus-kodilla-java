package com.kodilla.patterns.factory.tasks;

public class ShoppingTask implements Task{
    private String taskName;
    private String whatToBuy;
    private double quantity;
    private boolean isExecuted = false;

    public ShoppingTask(String taskName, String whatToBuy, double quantity) {
        this.taskName = taskName;
        this.whatToBuy = whatToBuy;
        this.quantity = quantity;
    }

    public void executeTask(){
        System.out.println("Następujące zadanie " + taskName + " jest w trakcie realizacji...");
        isExecuted = true;
    }

    public String getTaskName(){
        return taskName;
    }

    public boolean isTaskExecuted(){
        return isExecuted;
    }


}
