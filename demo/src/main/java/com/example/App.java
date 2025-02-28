package com.example;
import java.util.*;



// Chef will be the consumer as he cant start cooking an order untill the customer has placed some order

public class App {
	 static int customers=0;
     public static void main(String args[]) throws InterruptedException {
	PriorityQueue<Order>  PendingOrders = new PriorityQueue<Order> (5, new OrderComparator()); //Creating shared object
	
	Chef chef1=new Chef(PendingOrders);
	Customer customer1=new Customer(PendingOrders,0,5,true);
	customers++;

     Thread chefThread1 = new Thread(chef1, "Chef1");
     Thread customerThread1 = new Thread(customer1, "Customer1");
     chefThread1.start();
     customerThread1.start();
     
     Chef chef2=new Chef(PendingOrders);
     Customer customer2=new Customer(PendingOrders,1,5,true);
	 customers++;

     Thread chefThread2 = new Thread(chef2, "Chef2");
     Thread customerThread2 = new Thread(customer2, "Customer2");
     chefThread2.start();
     customerThread2.start();	


     Customer customer3=new Customer(PendingOrders,2,2,false);
	 customers++;

     Thread customerThread3 = new Thread(customer3, "Customer3");
     customerThread3.start();	


	//  chef1.join();
	//  chef2.join();
	//  customer0.join();
	//  customer1.join();

 }
}


class OrderComparator implements Comparator<Order> 
{
    @Override
    // Override the compare method to define custom
    // comparison logic
    public int compare(Order p1, Order p2)
    {
        // Compare persons based on their priority
        if(p1.notVIP==true && p2.notVIP==true){
			// based on order number
			return 0;
		}
		else if(p1.notVIP==true) return 1;
		else return -1;
    }
}



// package com.example;
// import java.util.LinkedList;
// import java.util.List;



// // Chef will be the consumer as he cant start cooking an order untill the customer has placed some order

// public class App {
// 	 static int customers=0;
//      public static void main(String args[]) throws InterruptedException {
// 		 List<Integer> PendingOrders = new LinkedList<Integer>(); 
	
// 	Chef chef1=new Chef(PendingOrders);
// 	Customer customer1=new Customer(PendingOrders,0,5,true);
// 	customers++;

//      Thread chefThread0 = new Thread(chef1, "Chef1");
//      Thread customerThread0 = new Thread(customer1, "Customer1");
//      chefThread0.start();
//      customerThread0.start();
     
//      Chef chef2=new Chef(PendingOrders);
//      Customer customer2=new Customer(PendingOrders,1,5,false);
// 	 customers++;

//      Thread chefThread1 = new Thread(chef2, "Chef2");
//      Thread customerThread1 = new Thread(customer2, "Customer2");
//      chefThread1.start();
//      customerThread1.start();	

// 	//  chef1.join();
// 	//  chef2.join();
// 	//  customer0.join();
// 	//  customer1.join();

//  }
// }
