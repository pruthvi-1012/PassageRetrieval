import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Date;
import java.io.*;


public class CreateDocs {
	
	public int Create(String DocName , String[][] PassageList , String[][] DocData, int j, int DocId, int NoOfPassages) 
	
	
	{
		
		int result = 0 , k=0;
		
		String DocNo = "<DOCNO>" + " " + DocName.trim() + " " +"</DOCNO>"; 
		 
		String Directory = "TREC_MODIFIED";
		
		String FilesPath = Directory + "\\" + DocName;
		

		
		try
		{
		
			File fileDirectory = new File(Directory);
					    
			fileDirectory.mkdir();
	    	
	    				
			if (!fileDirectory.exists()) 
	    	{
			
	    		fileDirectory.createNewFile();
		
	    	}
			
			
			
				File files = new File(FilesPath);
		
	    		FileWriter fw = new FileWriter(files.getAbsoluteFile(),true);
		
	    		BufferedWriter bw = new BufferedWriter(fw);
					    		
	    		
	            for(int i=0 ; i<DocData[j].length ; i++)
	    		{
	    			
	    	     if(DocData[j][i]!=null)
	    			
	    	     {
	    	    	 
	    	     
	    			if(DocData[j][i].trim().equals(DocNo))
	    			{
	    					    				
	    				String temp = "<DOCNO>" + " " + DocName.trim() + "-" +(k+1) + " " +"</DOCNO>";
	    					    				
		    			bw.write(temp + "\n");
		    			
		    			if(DocId!=0)
		    			
		    			{
		    			
		    				String UDocIdtemp = "<DOCID>" + " " + DocId + " " + "</DOCID>";

	    				
		    				bw.write(UDocIdtemp + "\n");
		    			
	    				
		    				i = i + 1;
		    			
		    			}
	    			}
	    			else if(DocData[j][i].trim().equals("<TEXT>"))
	    			{
	    				

	    				
	    				bw.write(DocData[j][i] + "\n");

	    				bw.write("<P>" + "\n");
	    				
	    				for(int x=0 ; x < PassageList[k].length ; x++)
	    				{
	    					
	    					if(PassageList[k][x]!=null)	
	    					{

	    						
	    						bw.write(PassageList[k][x] + "\n");
	    					
	    						
	    					}
	    					
	    				
	    				}
	    				
	    				
	    				bw.write("</P>" + "\n");
	    				
	    				int temp = i; 
	    						
	    				while(!DocData[j][temp].trim().equals("</TEXT>"))
	    				{
	    					
	    					temp++;

	    				}
	    				
	    				bw.write("</TEXT>" + "\n");
	    				
	    				i = temp;

	    			}
	    			else
	    			{
	    				
	    				bw.write(DocData[j][i] + "\n");

	    				if(DocData[j][i].trim().equals("</DOC>"))
	    				{
	    					
	    				    					
	    					if(k==(NoOfPassages-1) || NoOfPassages==0)
	    					{
	    						
	    						System.out.println("Creating : " + DocName);
	    						
	    						break;
	    						
	    					}
	    					else
	    					{
	    						
	    						k = k+1;
	    						
	    						i = -1;
	    						
	    						DocId = DocId + 1 ;
	    						
	    					}
	    					
	    				}
	    				
	    				
	    			}
	    		}
	    				
	    		}
	    		
	    		bw.close();
		

		}
		catch(Exception e)
		{
		
			System.out.println(e);
			e.printStackTrace();
		
		}
		
		return DocId;
		
		
	}
	

}
