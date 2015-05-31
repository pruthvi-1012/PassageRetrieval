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
import java.util.ArrayList;
import java.util.Date;
import java.io.*;

public class GetDocId {
	
public String DocId(String[][] Doc, int i)	
{
	String Name = null ;


	
	try
	{
		
 	 
		for	(int j=0 ; j<Doc[i].length ; j++)
		{
		   
			
			
			if(Doc[i][j]!=null)
			{
			
				String[] Parts = Doc[i][j].split(" ");	
			
				for(int k=0 ; k < Parts.length ; k++)
				{					
					if(Parts[k].trim().equals("<DOCNO>"))
					{
				
						Name = Parts[k+1];
										
					} 
				}
			}	
		}
		
	}
	catch(Exception e)
	{
		
		System.out.println(e);
		e.printStackTrace();
		
	}
	
	
return Name;
}

}
