import java.io.*;
import java.util.*;
import java.util.Collection;
import java.util.HashSet;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Todo
{
  public static void main(String args[]) throws IOException
  {
	   if(args.length<=0)
	    {
		 System.out.println("Usage :-");
         System.out.println("$ ./todo add \"todo item\"  # Add a new todo");
         System.out.println("$ ./todo ls               # Show remaining todos");
         System.out.println("$ ./todo del NUMBER       # Delete a todo");
         System.out.println("$ ./todo done NUMBER      # Complete a todo");
 		 System.out.println("$ ./todo help             # Show usage");
 		 System.out.println("$ ./todo report           # Statistics");
	   }
	 try
	   {	 
		
		 String get_todo;
		 String get_info=args[0];
		
	
	     if(get_info.equals("help"))
	        {
	         	 System.out.println("Usage :-");
                 System.out.println("$ ./todo add \"todo item\"  # Add a new todo");
                 System.out.println("$ ./todo ls               # Show remaining todos");
                 System.out.println("$ ./todo del NUMBER       # Delete a todo");
                 System.out.println("$ ./todo done NUMBER      # Complete a todo");
 		         System.out.println("$ ./todo help             # Show usage");
 		         System.out.println("$ ./todo report           # Statistics");
	        }
			
          if(get_info.equals("add"))
	         {
				 	  
             
	           	  try
	            	  {
						  String get_info1=args[1];
		               	  FileWriter fw1=new FileWriter("Todo.txt",true);
		               	  FileWriter fw2=new FileWriter("todo1.txt",true);
		                  BufferedWriter bw1=new BufferedWriter(fw1);
		                  BufferedWriter bw2=new BufferedWriter(fw2);
                         for(int i=0;i<=0;i++)
						 {
			                   bw1.write(""+get_info1+" \n");			                 
							   bw2.write(""+get_info1+" \n");
						      System.out.println("Added todo: \""+get_info1+"\"");
						 }	   
			              bw1.close();
						  bw2.close();
		               }
		              catch(ArrayIndexOutOfBoundsException e)
		                {
			             System.out.println("Error: Missing todo string. Nothing added!");
						}
			  		   
	         }
	 
	        String print;
	      if(get_info.equals("ls"))
	       {
				
			
			   try
			   {
				   int line=0;
			
					   
			        ArrayList<String> tmp = new ArrayList<String>();
					FileReader fr1=new FileReader("todo1.txt");
		            BufferedReader br1=new BufferedReader(fr1);
					print=br1.readLine();
					if(print != null)
					{
					 while(print != null)
						{
							
							tmp.add(print);
							print=br1.readLine();
							line++;
						}
						try
						{
							Collections.reverse(tmp);
							
							
							for (int i=0;i<=tmp.size()-1;i++)
							{
								//System.out.println(tmp);
								System.out.println("["+(line -(i))+"] "+tmp.get(i));
							}
							
						}
						catch (IndexOutOfBoundsException e)
						{
							
						}
					}
					else{
						System.out.println("There are no pending todos!");
					}
					
	            }
				catch(FileNotFoundException e)
				{
                        System.out.println(e);
				}
				
		   }		
				
             if(get_info.equals("del"))
			 {
				
				int array_length=0;
				int array_length1=0;
				
				int read_line=0;
				String array_index="";
				String array_index1="";
				 try
				 {
				             int get_info2=Integer.parseInt(args[1]);
				             ArrayList<String> tmp = new ArrayList<String>(); 
							 ArrayList<String> tmp1  = new ArrayList<String>(); 
                             BufferedReader br1=new BufferedReader(new FileReader("Todo.txt"));    //input file
							 BufferedReader read_todo=new BufferedReader(new FileReader("todo1.txt"));    //output file
							 String str1=read_todo.readLine();
                             String str=br1.readLine();

				        while(str != null )
				       {
								tmp.add(str);
							tmp1.add(str1);
								
							    str=br1.readLine();
								str1=read_todo.readLine();
							
				        }  
							try
							{	
                                 Collections.reverse(tmp);
							 Collections.reverse(tmp1);
							//	 System.out.println(tmp);
							//	 System.out.println(tmp1);
								  array_index=tmp.get(get_info2-1);
								 array_index1=tmp1.get(get_info2-1);
							 //   System.out.println(array_index);

								for(int i=1;i<=tmp.size();i++)
								{
									array_length++;
									
								}
								for(int i=1;i<=tmp1.size();i++)
								{
									array_length1++;
									
								}
							//	System.out.println( array_length);
							//	System.out.println( array_length1);
							//	System.out.println(tmp);
                              
								
							    if(get_info2 <= array_length  )
								 {
									 tmp.remove(get_info2 -1);
									// tmp1.remove(get_info2-1);
								    // System.out.println(tmp);		
								//	 System.out.println(tmp1);

									System.out.println("Deleted todo #"+get_info2);
								   PrintWriter print_delete=new PrintWriter(new File("delete_todo.txt"));
										   print_delete.println(array_index);
										   print_delete.flush();
						                   print_delete.close();
								 

								 }
								 
							
							}
							catch(IndexOutOfBoundsException e)
							{
								System.out.println("Error: todo #"+get_info2+" does not exist. Nothing deleted.");
                            }
							
			           BufferedReader b2=new BufferedReader(new FileReader("Todo.txt"));
                       PrintWriter print_new=new PrintWriter(new File("todo1.txt")); 

					     String line = b2.readLine(); 
                      while(line != null)
					    {
						boolean flag = false; 
						BufferedReader br2 = new BufferedReader(new FileReader("delete_todo.txt"));
						String line2 = br2.readLine(); 
						while(line2 != null) 
                            { 
                                if(line.equals(line2)) 
                                  { 
                                      flag = true; 
                                      break; 
                                   } 
                                line2 = br2.readLine(); 
                             } 

							 if(!flag) 
							
                               print_new.println(line); 

 
                            line = b2.readLine(); 
                           
                        } 
	                    print_new.flush(); 
                        b2.close();  
	             	    print_new.close(); 


                        /*********************************************
                            ********************************************** */
			
     
                     	 try
                          {
                               FileReader f1=new FileReader("todo1.txt");
                            	BufferedReader bw=new BufferedReader(f1);
	                        	FileWriter f2=new FileWriter("Todo.txt");
                                PrintWriter pw=new PrintWriter(f2);
		
		                       String read=bw.readLine();
	                           while(read != null)
		                          {
	                            	//	System.out.println(read);
	                            		pw.println(read);
	                	            	read=bw.readLine();
			
	                            	}
	                          	pw.flush();
	             	            bw.close();
	            	            pw.close();
	                       }
                             catch(FileNotFoundException e)
                            	 {
	                             	 System.out.println("FileNotFound");
	                             }	 
	        
	
                    }
                    catch(ArrayIndexOutOfBoundsException e1)
			         	 {
				         	 System.out.println("Error: Missing NUMBER for deleting todo.");
				         }

	  
	        } 
      
		    if(get_info.equals("done"))
		       {
                 int index=0;
                 String index_string="";
				 
				 try
				 {
					   int get_info3=Integer.parseInt(args[1]);
					   ArrayList<String> temp = new ArrayList<String>(); 
                       BufferedReader buffer=new BufferedReader(new FileReader("Todo.txt"));
					   String read_string=buffer.readLine();
					   while(read_string !=null)
					   {
                           temp.add(read_string);

						   read_string=buffer.readLine();
					   }
                       
					   try
					   {
                          Collections.reverse(temp);
						//  System.out.println(temp);    

                          index_string=temp.get(get_info3 - 1);
						  for(int j=0;j<= temp.size();j++)
						  {
							  index++;
						  }
						//  System.out.println(index);

						  if(get_info3 <= index)
						  {
							  temp.remove(get_info3 -1);
							 // System.out.println(temp);

                              System.out.println("Marked todo #"+get_info3+" as done.");
                              PrintWriter print_delete=new PrintWriter(new FileWriter("Done.txt",true));
										   print_delete.println(index_string);
										   print_delete.flush();
						                   print_delete.close();
						  }
						  else{
							  System.out.println("Error: todo #"+get_info3+" does not exist.");
						  }

						  try
						  {
                               PrintWriter print1=new PrintWriter(new File("todo1.txt")); 
							   BufferedReader buffer1=new BufferedReader(new FileReader("Todo.txt"));
							   String read_line1=buffer1.readLine();
							   while(read_line1 != null)
							   {
								   boolean flag1=false;
								   BufferedReader buffer2 = new BufferedReader(new FileReader("done.txt")); 
								   String read_line2=buffer2.readLine();
                                   while(read_line2 != null)
								   {
                                       if(read_line1.equals(read_line2))
									   {
                                          flag1=true;
										  break;
									   }
									   read_line2=buffer2.readLine();
								   }
								  if(!flag1)
								  print1.println(read_line1);

								  read_line1=buffer1.readLine();

							   }
							   print1.flush();
							   buffer1.close();
							   print1.close();
							  //  System.out.println("File operation performed successfully"); 


								 try
                                   	{
                                       FileReader f1=new FileReader("todo1.txt");
                                    	BufferedReader bw=new BufferedReader(f1);
	                                	FileWriter f2=new FileWriter("Todo.txt");
                                      PrintWriter pw=new PrintWriter(f2);
		
	                                 	String read=bw.readLine();
	                                   while(read != null)
	                                	{
		                                	System.out.println(read);
		                                	pw.println(read);
		                                	read=bw.readLine();
			
		                                 }
	                                	pw.flush();
	                                 	bw.close();
	                                 	pw.close();
	                                  }
                                       catch(FileNotFoundException e)
                                    	 {
		                                    System.out.println("FileNotFound");
	                                     }	 

						  }
						  catch(FileNotFoundException e)
						  {

						  }

					   }
					   catch(ArrayIndexOutOfBoundsException e)
					   {
                             System.out.println("Error: todo #"+get_info3+" does not exist.");
					   }

				 }
                  catch(Exception e)
				  {
                     System.out.println("Error: Missing NUMBER for marking todo as done.");

				  }

			   }
			
		        	
							    
					         
                             

           if(get_info.equals("report"))
		   {
			   int lines1=0,lines2=0;
			   String line1,line2;
			   
			   try{
				         FileReader fr1=new FileReader("todo1.txt");
		                 BufferedReader br1=new BufferedReader(fr1);
				        while((line1=br1.readLine()) != null)
						{
							lines1++;
						}
				        br1.close();
					 //	System.out.println(lines1);
						
						FileReader fr2=new FileReader("Done.txt");
		                 BufferedReader br2=new BufferedReader(fr2);
				        while((line2=br2.readLine()) != null)
						{
							lines2++;
						}
				        br2.close();
					 //	System.out.println(lines2);
						
						SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd ");
						Date date=new Date();
					 //	System.out.println(formatter.format(date));
				    	System.out.println(""+formatter.format(date)+"Pending : "+lines1+" Completed : "+lines2);
					
					
			        }
			          catch(FileNotFoundException e1)
			              {
				   
			              }
		   }
		
	    }
	     catch(ArrayIndexOutOfBoundsException e1)
          {
	        
          }
  }	
 
}
