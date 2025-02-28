package com.example;

import java.util.LinkedList;
import java.util.List;



// Chef will be the consumer as he cant start cooking an order untill the customer has placed some order

public class App {
	 static int customers=0;
     public static void main(String args[]) throws InterruptedException {
	List<Integer> PendingOrders = new LinkedList<Integer>(); //Creating shared object
	
	Chef chef1=new Chef(PendingOrders);
	Customer customer1=new Customer(PendingOrders,0,5);
	customers++;

     Thread chefThread0 = new Thread(chef1, "Chef1");
     Thread customerThread0 = new Thread(customer1, "Customer1");
     chefThread0.start();
     customerThread0.start();
     
     Chef chef2=new Chef(PendingOrders);
     Customer customer2=new Customer(PendingOrders,1,5);
	 customers++;

     Thread chefThread1 = new Thread(chef2, "Chef2");
     Thread customerThread1 = new Thread(customer2, "Customer2");
     chefThread1.start();
     customerThread1.start();

	

	//  chef1.join();
	//  chef2.join();



	//  customer0.join();
	//  customer1.join();



	 
 }
}
