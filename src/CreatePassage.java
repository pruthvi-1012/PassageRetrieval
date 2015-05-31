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



public class CreatePassage
{

public String DividePassages() throws IOException
{
		
	
	try
	{

    Docs d = new Docs();
    
    GetDocId Id = new GetDocId();
    
    GetPassages p = new GetPassages();
    
    CreateDocs cd = new CreateDocs();
		
	File file = new File("TREC");
	
	String[] files = null;
	
	String[][] DocData = null;

	String DocName = null ;
	
	String[][] DocPassages = null;
	
	int DocId = 1 ;
	
	
	File fileDirectory = new File("TREC_MODIFIED");
	
	
	if (fileDirectory.exists()) 
	{
		
		File[] Modified = fileDirectory.listFiles();

		for (int i = 0 ; i < Modified.length ; i++)
		{
			
			Modified[i].delete();
			
		}
		
	}  

	
	
	
	if (file.canRead()) 
	{
		if (file.isDirectory()) 
		{
			
			files = file.list();
		
		}
	}

	for (int i = 0 ; i < files.length ; i++)
	{

		
		String temp = files[i];
		
		DocData = d.DocsArray(i, temp , file);
	
		for(int j = 0 ; j < DocData.length ; j++)	
		{
			
			
			
			if((Id.DocId(DocData,j))!=null)
			{
				
				DocName = Id.DocId(DocData,j);
							
			}
		
			DocPassages = p.DocPassagesList(DocData,j);
			
			int NoOfPassages = 0;
		    
			for	(int x=0 ; x < DocPassages.length ; x++)

			{
					
					
				if(DocPassages[x][0]!=null)
					
				{
						
					NoOfPassages = x+1;	
					
								
				}
	
				
			}
					
			
			DocId = cd.Create(DocName, DocPassages, DocData, j, DocId, NoOfPassages);
			
			
		}
		
	}
	
	}
	catch(NullPointerException e)
	{
		
		System.out.println(e);
		e.printStackTrace();
		
	}
	
	return "TREC_MODIFIED" ;
}


}

