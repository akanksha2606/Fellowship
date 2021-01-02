import java.io.*;
class File_Demo
{
    public static void main(String args[]) 
	{
	   try
	   {
	      FileReader fr1=new FileReader("C:\\Users\\Dell\\Downloads\\fellowship-java\\java\\Todo.txt");
		  BufferedReader buffer=new BufferedReader(fr1);
		 String read=buffer.readLine();
		   while(print != null)
				       {
						 
				          for(int i = print.length()-3; i >= 0; i--)
				              {
								
								  tmp.add(print);
								  print=br1.readLine();
				             
				               }  
					    }
								for(int i=tmp.size()-3;i>=0;i--) 
								{
									 String str="["+(i+1)+"]"+""+tmp.get(i);
									 Collection<string> collection = new HashSet<>();
									 if(str.contains(get_info2))
									 {
										 string.remove(str);
										 
									 }
									 if(str.contains(get_info2)==false)
									 {
										 System.out.println("todo doen not exist");
										 
									 }
                                }
				                br1.close();
                                System.out.println("Hello World");
		  
	   }
	   catch(IOException e)
	   {
		   
	   }
	}
}