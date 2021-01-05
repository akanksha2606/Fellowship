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
//----------------------------help without arguments------------------------------------------

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
//------------------------------help without argument code end---------------------------------	  

//**************************************main try started**************************************
	 try
	   {
               //-------------------------------help with argument--------------------------------------------

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
			//------------------------------add argument or todo in list-----------------------------------------
			
			         if(get_info.equals("add"))
	         {
				 	  
             
	           	  try
	            	  {
						  String get_info1=args[1];
		               	  FileWriter fw1=new FileWriter("Todo.txt",true);
		               //	  FileWriter fw2=new FileWriter("todo1.txt",true);
		                  BufferedWriter bw1=new BufferedWriter(fw1);
		               //   BufferedWriter bw2=new BufferedWriter(fw2);
                         for(int i=0;i<=0;i++)
						 {
			                   bw1.write(""+get_info1+" \n");			                 
							  // bw2.write(""+get_info1+" \n");
						      System.out.println("Added todo: \""+get_info1+"\"");
						 }	   
			              bw1.close();
						//  bw2.close();
		               }
		              catch(ArrayIndexOutOfBoundsException e)
		                {
			             System.out.println("Error: Missing todo string. Nothing added!");
						}
			  		   
	         }

			 //-----------------------------------add argument or todo list ends------------------------------------------------

			 //-------------------------------------ls command----------------------------------------------------------------
	 
	        String print;
	      if(get_info.equals("ls"))
	       {
				
			
			   try
			   {
				   int line=0;
			
					   
			        ArrayList<String> tmp = new ArrayList<String>();
					FileReader fr1=new FileReader("Todo.txt");
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
                       System.out.println("There are no pending todos!");
				}
				
		   }		

			//-------------------------------------------ls command ends------------------------------------------


            //------------------------------------------del commands started---------------------------------------------
             if(get_info.equals("del"))
			 {
				
				int array_length=0;
			
				
				String array_index="";
		
				 try
				 {
				             int get_info2=Integer.parseInt(args[1]);
				             ArrayList<String> tmp = new ArrayList<String>();  
                             BufferedReader br1=new BufferedReader(new FileReader("Todo.txt"));    //input file
						     String str=br1.readLine();
				        while(str != null )
				       {
								tmp.add(str);
						
							    str=br1.readLine();
				        }  
						try
							{	
                            
								for(int i=1;i<=tmp.size();i++)
								{
									array_length++;
									
								}
						
							    if(get_info2 <= array_length  )
								 {
									 tmp.remove(get_info2 - 1);
										
									System.out.println("Deleted todo #"+get_info2);
								 }
								 else{
									 System.out.println("Error: todo #"+get_info2+" does not exist. Nothing deleted.");
								 }
								 	
                                 PrintWriter print_delete=new PrintWriter(new File("Todo.txt"));
								 //Collections.reverse(tmp);
								 for(int i=0;i<=tmp.size()-1;i++)
								 {
									 print_delete.println(tmp.get(i));
								 }
					    		   print_delete.flush();
						        print_delete.close();
								 
							
							}
						catch(IndexOutOfBoundsException e)
							{
								System.out.println("Error: todo #"+get_info2+" does not exist. Nothing deleted.");
                            }
							
                }
                catch(IndexOutOfBoundsException e)
			         	 {
				         	 System.out.println("Error: Missing NUMBER for deleting todo.");
				         }

	  
	        } 
      
            //--------------------------------------------del command ends--------------------------------------------------


             //----------------------------------------done command started-----------------------------------------------
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
						   for(int j=1;j<= temp.size();j++)
						  {
							  index++;
						  }

                          index_string=temp.get(get_info3 - 1);
						  
						
						  if(get_info3 <= index)
						  {
							  temp.remove(index_string);
							  System.out.println(temp);

                              System.out.println("Marked todo #"+get_info3+" as done.");
                              PrintWriter print_done=new PrintWriter(new FileWriter("Done.txt",true));
										   print_done.println(index_string);
										   print_done.flush();
						                   print_done.close();
						  }
						  else{
							  System.out.println("Error: todo #"+get_info3+" does not exist.");
						  }
									System.out.println(temp);	   
                            
                            PrintWriter print1=new PrintWriter(new File("Todo.txt")); 
                            for(int j=0;j<=temp.size()-1;j++)
							{
								print1.println(temp.get(j));
							}                 
                            print1.flush();
							print1.close();

					   }
					   catch(IndexOutOfBoundsException e)
					   {
                             System.out.println("Error: todo #"+get_info3+" does not exist.");
					   }

				 }
                  catch(Exception e)
				  {
                     System.out.println("Error: Missing NUMBER for marking todo as done.");

				  }
			   }
			//---------------------------------done command ends-------------------------------
		 
		    //----------------------------------report---------------------------------------
           if(get_info.equals("report"))
		   {
			   int lines1=0,lines2=0;
			   String line1,line2;
			   
			   try{
				         FileReader fr1=new FileReader("Todo.txt");
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
		   //--------------------------------report ends--------------------------------
		
	    }     //*******************main try ends*********************************
	     catch(ArrayIndexOutOfBoundsException e1)
          {
	        
          }
  }	
 
}
