package books;

import java.io.*;

import java.util.Scanner;
import java.util.StringTokenizer;

public class pri {
private demo1[] sI = new demo1[100000];
	
    private String pri_key,b_id,title,authorname,rating,voters_count,gender,hometown,books_num,works_count,publisher;
	int reccount = 0;
    int reccount1=0;
public void getData(){
    		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
    		System.out.println("Enter the primary key: ");
   		 pri_key = scanner.next();
		System.out.println("Enter the b_id: ");
		 b_id = scanner.next();
		 System.out.println("Enter the title: ");
 		title = scanner.next();
 		System.out.println("Enter the authorname: ");
 		authorname = scanner.next();
 		System.out.println("Enter the rating: ");
 		rating = scanner.next();
 		System.out.println("Enter the voters_count: ");
 		voters_count = scanner.next();
 		System.out.println("Enter the gender: ");
 		gender= scanner.next();
 		System.out.println("Enter the hometown: ");
 		hometown = scanner.next();
 		System.out.println("Enter the books_num: ");
 		books_num= scanner.next();
 		   System.out.println("Enter the works_count: ");
 		   works_count = scanner.next();
 		System.out.println("Enter the publisher: ");
 		publisher = scanner.next();

		
}
public void add(){
	 String data=pri_key+","+b_id +","+  title +","+ authorname +","+ rating +","+voters_count +","+ gender +","+ hometown +"," + books_num +","+ works_count +"," +publisher+ ","+"";

 try{			
			RandomAccessFile recordfile = new RandomAccessFile ("C:\\Users\\DELL\\Desktop\\augmented.csv","rw");
			recordfile.seek(recordfile.length());
			long pos = recordfile.getFilePointer();
			recordfile.writeBytes(data+"\n");
			recordfile.close();
			
			RandomAccessFile indexfile = new RandomAccessFile ("index.txt","rw");
			indexfile.seek(indexfile.length());
			indexfile.writeBytes(pri_key+","+pos+"\n");
			indexfile.close();
			
			RandomAccessFile indexfile1 = new RandomAccessFile ("index1.txt","rw");
			indexfile1.seek(indexfile1.length());
			indexfile1.writeBytes(b_id+","+pos+"\n");
			indexfile1.close();
		}
		catch(IOException e){
			System.out.println(e);
		}
		
 
}                     
    public void priIndex(){

		String line,prikey = null,pos = null;
		int count = 0;
		int sIIndex = 0;
		reccount=0;
		RandomAccessFile indfile;
		try {
			indfile = new RandomAccessFile("index.txt","rw");

			try {
				
				while((line = indfile.readLine())!= null){
                                     if(line.contains("*")) {
	                		continue;
	                	}
					count = 0;
                                                 
                                       
	          
					
					StringTokenizer st = new StringTokenizer(line,",");
					while (st.hasMoreTokens()){
					 count+=1;
					 if(count==1)
				    prikey = st.nextToken();
					 pos = st.nextToken();
                                         
				    }
					sI[sIIndex] = new demo1();
					sI[sIIndex].setRecPos(pos);
					sI[sIIndex].setprikey(prikey);
					reccount++;
					sIIndex++;
                                        if(sIIndex==100000)
                                        {
                                            break;
                                        }
                                }
			} catch (IOException e) {
				
				e.printStackTrace();
				return;
			}
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			return;
		} 
		
		System.out.println("total records" + reccount);
		if (reccount==1) { return;}
		sortIndex();
	}
   
	
	public void sortIndex() {
		demo1 temp = new demo1();
		
		for(int i=0; i<reccount; i++)
		    {	
				for(int j=i+1; j<reccount; j++) {
					if(sI[i].getprikey().compareTo(sI[j].getprikey())  > 0)
		            {
		                temp.setprikey(sI[i].getprikey()); 
				        temp.setRecPos(sI[i].getRecPos());
				
			        	sI[i].setprikey(sI[j].getprikey());
			        	sI[i].setRecPos(sI[j].getRecPos());
				
			        	sI[j].setprikey(temp.getprikey());
			        	sI[j].setRecPos(temp.getRecPos());
		            }
				}
					
			}	
		
	}
	
        public void search(){
            System.out.println("Enter the primary key to search: ");
					Scanner scanner = new Scanner(System.in);
					String prikey = scanner.next();
					System.out.println(reccount);
					int pos = binarySearch(sI, 0, reccount-1, prikey);
                                        
					
					if (pos == -1) {
						System.out.println("Record not found in the record file");
						return ;
					}
					
					RandomAccessFile recordfile;
					try {
						recordfile = new RandomAccessFile ("C:\\Users\\DELL\\Desktop\\augmented.csv","rw");
						try {
							recordfile.seek(Long.parseLong(sI[pos].getRecPos()));
							String record = recordfile.readLine();
							StringTokenizer st = new StringTokenizer(record,",");
							
							int count = 0;
                                                        
		               	    
		                	while (st.hasMoreTokens()){
		                		     count+=1;
		                  	    	 if(count==1){
		                  	    	 String tmp_prikey = st.nextToken();
                                                 if(tmp_prikey.contains("*"))
                                                 {
                                                     System.out.println("it has been deleted");
                                                     break;
                                                 }
						System.out.println("prikey: "+tmp_prikey);
		                  	         this.pri_key = tmp_prikey;
		                  	    	
		                  	          String tmp_country = st.nextToken();
		                     	      System.out.println("b_id: "+tmp_country);
		                     	      this.b_id = tmp_country;
		                     	       
		                     	     String tmp_year = st.nextToken();
		                                System.out.println("title: "+tmp_year);
		                                this.title = tmp_year;
		                           
		                                 String tmp_commodity = st.nextToken();
		                                 System.out.println("authorname: "+tmp_commodity);
		                                 this.authorname = tmp_commodity;
		                               
		                                 String tmp_flow = st.nextToken();
		                                 System.out.println("rating: "+tmp_flow);
		                                 this.rating = tmp_flow;
		                             
		                                 String tmp_trade = st.nextToken();
		                                 System.out.println("voters_count: "+tmp_trade);
		                                 this.voters_count = tmp_trade;
		                           
		                                String tmp_a = st.nextToken();
		                                 System.out.println("gender: "+tmp_a);
		                                 this.gender = tmp_a;
		                             
		                                 String tmp_b = st.nextToken();
		                                 System.out.println("hometown: "+tmp_b);
		                                 this.hometown = tmp_b;
		                           
		                                String tmp_c = st.nextToken();
		                                 System.out.println("books_num: "+tmp_c);
		                                 this.books_num = tmp_c;
		                             
		                                 String tmp_d = st.nextToken();
		                                 System.out.println("works_count: "+tmp_d);
		                                 this.works_count = tmp_d;
		                           
		                                String tmp_e = st.nextToken();
		                                 System.out.println("publisher: "+tmp_e);
		                                 this.publisher = tmp_e;
		                               
		                     	     
		                     	      System.out.println();
		                  	    	 	
		                  	    	 	
		                  	    	 	
                                                       
                                                       
		                  	    	 			                  	    	 }

		                  	    	 else
		                  	    		 break;
		                       }
		                	
						} 
							catch (NumberFormatException e) {
							
							e.printStackTrace();
						} 
						catch (IOException e) {
							
							e.printStackTrace();
						}
						
						
						}
												
	                	catch (FileNotFoundException e) {
						
						e.printStackTrace();
					}
        }
        
        int binarySearch(demo1 s[], int l, int r, String prikey) {
    	
    	int mid;
    	while (l<=r) {
            
    		mid = (l+r)/2;
    		if(s[mid].getprikey().compareTo(prikey)==0) {return mid;}
    		if(s[mid].getprikey().compareTo(prikey)<0) l = mid + 1;
    		if(s[mid].getprikey().compareTo(prikey)>0) r = mid - 1;
    	}
    	return -1;
    }
       

  public  void indexing() 
  {
         try{
        RandomAccessFile hey=new RandomAccessFile("C:\\Users\\DELL\\Desktop\\augmented.csv","rw");
  
    			

        RandomAccessFile indexfile=new RandomAccessFile("i=index.txt","rw");
        String line;
 long       pos=hey.getFilePointer();
        while((line = hey.readLine())!=null)
        {
            if(line.contains("*")) {
	                		continue;
	                	}

            String[] columns=line.split(",");
                                 

                        

         
            indexfile.writeBytes(columns[0]+","+pos+"\n");
            pos=hey.getFilePointer();
        } indexfile.close();
        hey.close();
                
        
         
       
         }
    
    catch(IOException e)
    {
        System.out.println(e);
    }
  }
  
 public   void delete() throws IOException {
         System.out.println("Enter the primary key to delete record ");
					Scanner scanner = new Scanner(System.in);
					String prikey = scanner.next();
        int pos = binarySearch(sI, 0, reccount-1, prikey);
					
					if (pos == -1) {
						System.out.println("Record not found in the record file");
						return ;
					}
                                        RandomAccessFile recordfile;
                                        
					
						recordfile = new RandomAccessFile ("C:\\Users\\DELL\\Desktop\\augmented.csv","rw");
						try {
							recordfile.seek(Long.parseLong(sI[pos].getRecPos()));
                                                        recordfile.writeBytes("*");
                                                        recordfile.close();
                                                
                                                        }    
                                                            
                                             catch (NumberFormatException e) {
							
							e.printStackTrace();
						} 
						catch (IOException e) {
							
							e.printStackTrace();
						}
						
						
						}
							


}
