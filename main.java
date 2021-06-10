package books;

import java.io.IOException;
import java.util.Scanner;



public class main {
	public static void main(String args[]) throws IOException{
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		pri stu = new pri();
		sec stu1=new sec();
		stu.indexing();
		stu1.indexing();
                stu.priIndex();
                stu1.priIndex();
                do
                {
                	System.out.println("enter choice");
                	System.out.println("1.primary\n2.secondary");
                	int choice=scanner.nextInt();
                switch(choice){
                case 1:System.out.println("################################################");
                        System.out.println("Welcome");
                        System.out.println("________________________________________________");
	                System.out.println("Enter your Valuable choice: "); 
                        System.out.println("################################################");
			System.out.println("1>Enter details: \n2>Enter the primary key to Search: \n3>To Build Index of my Data:4>Enter the primary key to be Deleted: \n5>Exit");
		        System.out.println("################################################");

			
		
			int a=scanner.nextInt();
		
				switch(a)
				{
				
				case 1: long starttime =System.nanoTime();
                                        stu.getData();
                                        stu.add();
                                        stu.priIndex();
                                        long endtime =System.nanoTime();
                                        long totaltime=endtime-starttime;
                                        System.out.println(totaltime/1000000+"msec");
						break;
				case 2: long starttime1 =System.nanoTime();
                                    stu.search();
                                    long endtime1 =System.nanoTime();
                                        long totaltime1=endtime1-starttime1;
                                        System.out.println(totaltime1/1000000+"msec");
				    break;
				
				case 3:long starttime2 =System.nanoTime();
                                    stu.indexing();
                                    long endtime2 =System.nanoTime();
                                        long totaltime2=endtime2-starttime2;
                                        System.out.println(totaltime2/1000000+"msec");
						break;
                                case 4:long starttime4 =System.nanoTime();
                                    stu.delete();
                                    long endtime4=System.nanoTime();
                                        long totaltime4=endtime4-starttime4;
                                        System.out.println(totaltime4/1000000+"msec");
                                break;
				case 5: System.out.println("Exiting..");
						System.exit(0);
				default : System.out.println("Enter a valid choice!");
			}
				break;
                case 2:System.out.println("################################################");
                System.out.println("Welcome");
                System.out.println("________________________________________________");
            System.out.println("Enter your Valuable choice: "); 
                System.out.println("################################################");
                System.out.println("1>Enter details: \n2>Enter the secondary to Search: \n3>To Build Index of my Data:4>Enter the secondary key to be Deleted: \n5>Exit");
                System.out.println("################################################");
                int b=scanner.nextInt();
                switch(b)
                {
                case 1: long starttime =System.nanoTime();
                
                stu1.getData();
                stu1.add();
                stu1.priIndex();
                long endtime =System.nanoTime();
                long totaltime=endtime-starttime;
                System.out.println(totaltime/1000000+"msec");
break;
case 2: long starttime1 =System.nanoTime();
            stu1.search();
            long endtime1 =System.nanoTime();
                long totaltime1=endtime1-starttime1;
                System.out.println(totaltime1/1000000+"msec");
break;

case 3:long starttime2 =System.nanoTime();
            stu1.indexing();
            long endtime2 =System.nanoTime();
                long totaltime2=endtime2-starttime2;
                System.out.println(totaltime2/1000000+"msec");
break;

        case 4:long starttime4 =System.nanoTime();
            stu1.delete();
            long endtime4=System.nanoTime();
                long totaltime4=endtime4-starttime4;
                System.out.println(totaltime4/1000000+"msec");
        break;
case 5: System.out.println("Exiting..");
System.exit(0);
default : System.out.println("Enter a valid choice!");
                }
		}
   }while(true);


}

}

