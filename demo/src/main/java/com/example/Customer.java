package com.example;

import java.util.List;

class Customer implements Runnable {
    private List<Integer> PendingOrders;
    int orderLimt;
    int size=5;
    int orderNo;
    public Customer(List<Integer> PendingOrders,int orderNo,int orderLimt) {
        this.PendingOrders = PendingOrders;
        this.orderNo=orderNo;
		this.orderLimt=orderLimt;
    }
 
    @Override
    public void run(){
        for(int i=0;i<orderLimt;i++){
            try {
                order(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    

    private void order(int i) throws InterruptedException {
    
        synchronized (PendingOrders) {
            while (PendingOrders.size() == size) {
                System.out.println(Thread.currentThread().getName()+", Queue is full, new order cant be placed..");
                       PendingOrders.wait();
            }
   
          int cookedItem = (size*orderNo)+ i;  
          
          System.out.println(Thread.currentThread().getName() +" placed order number : " + cookedItem);
          PendingOrders.add(cookedItem);
            Thread.sleep(1000);
            PendingOrders.notify();
        }
    }
 
}