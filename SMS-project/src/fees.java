import java.util.Scanner;
class StudentFees
{
   private double totalBalance;
 
   double getTotalBalance()
   {
      return totalBalance;
   }
   void setTotalBalance(double totalBalance)
   {
      this.totalBalance = totalBalance;
   }
   
   void viewAndPayBalance()
   {
         boolean done = false;
         String answer; 
         Scanner input = new Scanner(System.in);
         while(!done)
         {
             System.out.println("You have an outstanding balance of $" + String.format("%.2f", totalBalance));
             if(totalBalance > 0)
             {
               System.out.println("Would you like to make payment? (y/n) ");
               answer = input.next();
               if(answer.equals("y") || answer.equals("Y"))
               {
                  System.out.println("How much would you like to pay at this time: ");
                  double amountPaid = input.nextDouble();
                  if(amountPaid > totalBalance)
                     System.out.println("Error: Cannot pay an amount greater than the total balance. Please try again.\n");
                  else
                  {
                     totalBalance = totalBalance - amountPaid;
                     System.out.println("Thank you for submitting your payment!");     
                  }
    
               }
               else if(answer.equals("n") || answer.equals("N")) //ends function
                  done = true; 
               else
                  System.out.println("Error: Please try again and enter either \"y\" or \"n\"");
             }
             
             else
             {
               System.out.println("You have no outstanding balance at this time.");
               done = true;
             }
               
         } 
         input.close(); 
   }
      
}

   
