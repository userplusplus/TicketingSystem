/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticketingsystem;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;


public class TicketingSystem {
    
    static int counter = 0;
    //The counter used for numbering the tickets
    
    static Queue<Integer> queue = new LinkedList<>();
    //The queue which stores the numbers of all of the tickets
    
    
    public static void main(String[] args) {
        
        Timer timer = new Timer();
        timer.schedule(new SalesAssisstantTask(), 0, 5000);
        //run code in the SalesAssistantTask run() method every 5 seconds
        
        timer.schedule(new CustomerTask(), 0, 3000);
        //run code in the CustomerTask run() method every 3 seconds
        
    }
    
    
    public static class SalesAssisstantTask extends TimerTask { //inner class
       
        
        public void run() {
                
            System.out.println("\nSales Assistant is ready to"
                    + " see the next customer."); 
            
            try {
                System.out.println("The customer with ticket number " +
                    queue.remove() + " will be seen");
                //display and remove the next customer in line
                
                String str = "The customers with the following tickets"
                        + " are in the queue: [";
                //String to display queue contents
                Iterator<Integer> itr = queue.iterator();
                
                while(itr.hasNext()){
                    //Iterates through the queue using the iterator
                    
                    str += itr.next().toString();
                    //adds the value the iterator is at from the queue to
                    //the string
                            
                    if(itr.hasNext()){
                        str += ", ";
                        //adds a comma if there are more entries in the queue
                    }
                }
                str += "]\n";
                System.out.println(str);
                
            } catch ( NoSuchElementException e) {
                //If the queue is empty
                System.out.println("\nThere are no customers to see.\n");
            }
        }
    }
    
    
    public static class CustomerTask extends TimerTask { //inner class
       
        
        public void run() {
            counter++;
            //Add one to counter
            
            queue.add(counter);
            //Add one to queue
            
            System.out.println("Customer with ticket " + counter
                    + " is added to the queue."); 
            //Add a customer to the queue with a 'ticket' equal to the counter
        }
    }
    
}
    