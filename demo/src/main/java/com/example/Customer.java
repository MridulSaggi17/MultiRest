package com.example;

import java.util.*;

class Customer implements Runnable {
    PriorityQueue<Order>  PendingOrders; //Creating shared object
    int orderLimt;
    boolean priority;
    int orderNo;
    public Customer(PriorityQueue<Order>  PendingOrders,int orderNo,int orderLimt,boolean priority) {
        this.PendingOrders = PendingOrders;
        this.priority=priority;
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
            while (PendingOrders.size() ==5) {
                System.out.println(Thread.currentThread().getName()+", Queue is full, new order cant be placed..");
                       PendingOrders.wait();
            }
   
          int cookedItem = (5*orderNo)+ i;  
        //   create a order
        Order customersOrder=new Order(priority, cookedItem);
        PendingOrders.add(customersOrder);
          
          System.out.println(Thread.currentThread().getName() +" placed order number : " + cookedItem);

            Thread.sleep(1000);
            PendingOrders.notify();
        }
    }
 
}


// package com.example;

// import java.util.*;

// class Customer implements Runnable {
//     List<Integer> PendingOrders = new LinkedList<Integer>(); //Creating shared object
//     int orderLimt;
//     boolean priority;
//     int orderNo;
//     public Customer(List<Integer>  PendingOrders,int orderNo,int orderLimt,boolean priority) {
//         this.PendingOrders = PendingOrders;
//         this.priority=priority;
//         this.orderNo=orderNo;
// 		this.orderLimt=orderLimt;
//     }
 
//     @Override
//     public void run(){
//         for(int i=0;i<orderLimt;i++){
//             try {
//                 order(i);
//             } catch (InterruptedException e) {
//                 e.printStackTrace();
//             }
//         }
//     }
    

//     private void order(int i) throws InterruptedException {
    
//         synchronized (PendingOrders) {
//             while (PendingOrders.size() ==5) {
//                 System.out.println(Thread.currentThread().getName()+", Queue is full, new order cant be placed..");
//                        PendingOrders.wait();
//             }
   
//           int cookedItem = (5*orderNo)+ i;  
//         //   create a order
//         // Order customersOrder=new Order(priority, cookedItem);
//         PendingOrders.add(cookedItem);
          
//           System.out.println(Thread.currentThread().getName() +" placed order number : " + cookedItem);

//             Thread.sleep(1000);
//             PendingOrders.notify();
//         }
//     }
 
// }