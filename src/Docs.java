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

public class Docs {
	

	public String[][] DocsArray(int i, String files, File file) throws IOException
	{
		
		String[][] docData = new String[512][2048];

		
		try
		{
		
		
		String Path = file + "\\" + files;
		
		File f = new File(Path);
		
		FileInputStream fis = new FileInputStream(f);
	
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
	
		String Content = new String();
		
		int flag  =  0 , b  =  0 ;
		
		int j = 0 ;
		
		
		while((Content = br.readLine())!=null)
		{
			
		
			
			if(Content.trim().equals("<DOC>"))
			{
				
				flag = 1 ;
				
				docData[b][j] = " ";
				
			}
			
			
			
			if(flag == 1)
			{
				
				docData[b][j] = Content ;
				
				j++;
				
				
				if(Content.trim().equals("</DOC>"))
				{
				
					
					flag = 0 ; 
						
					b++;
					
					j=0;
					
				}
				
				
			} 
			
			
			
            
			
		}
		

		
	

	}
	catch(Exception e)
	{
		
		System.out.println(e);
		e.printStackTrace();
		
	}
		return docData;

}
}
