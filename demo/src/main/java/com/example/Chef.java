package com.example;
import java.util.*;

class Chef implements Runnable{
    PriorityQueue<Order>  PendingOrders;
 
    public Chef(PriorityQueue<Order>  PendingOrders) {
        this.PendingOrders = PendingOrders;
    }

    @Override
    public void run() {
        while (true) {
            try {
                cook();
                Thread.sleep(100);
            } catch (InterruptedException e) {  e.printStackTrace(); }
        }
    }
    
    private void cook() throws InterruptedException {
  
        synchronized (PendingOrders) {
            while (PendingOrders.size() == 0) {
                System.out.println(Thread.currentThread().getName()+", Queue is empty, Chef is waiting for "
                                + "Customer to place the order");
                PendingOrders.wait(); //will enter the block state and will now wait for chef to produc some.
            }


            System.out.println("Chef started preparing the order..");
            Thread.sleep((long)(2000)); //Chef started preparing the order
            Order order=PendingOrders.poll();
            System.out.println(Thread.currentThread().getName()+", COOKED : "+ order.ordernumber);
            // PendingOrders.remove(order);
            PendingOrders.notify();
        }
     }
}



// package com.example;
// import java.util.*;

// class Chef implements Runnable{
//     List<Integer> PendingOrders;
 
//     public Chef(List<Integer>   PendingOrders) {
//         this.PendingOrders = PendingOrders;
//     }

//     @Override
//     public void run() {
//         while (true) {
//             try {
//                 cook();
//                 Thread.sleep(100);
//             } catch (InterruptedException e) {  e.printStackTrace(); }
//         }
//     }
    
//     private void cook() throws InterruptedException {
  
//         synchronized (PendingOrders) {
//             while (PendingOrders.size() == 0) {
//                 System.out.println(Thread.currentThread().getName()+", Queue is empty, Chef is waiting for "
//                                 + "Customer to place the order");
//                 PendingOrders.wait(); //will enter the block state and will now wait for chef to produc some.
//             }


//             System.out.println("Chef started preparing the order..");
//             Thread.sleep((long)(2000)); //Chef started preparing the order
//             System.out.println(Thread.currentThread().getName()+", COOKED : "+ PendingOrders.remove(0));
//             PendingOrders.notify();
//         }
//      }
// }