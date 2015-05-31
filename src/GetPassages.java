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


public class GetPassages {
	
	public String[][] DocPassagesList(String[][] DocData, int i) throws IOException
	{
		
		String[][] Passage = new String[512][50] ;
		
		int c = 0 , d=0 , flag1 = 0 , flag2 = 0, check = 0, flag3 = 0, lineCount = 0;
		
		try
		{
					
			for	(int j=0 ; j< DocData[i].length ; j++)
			{
			   
				
				
				if(DocData[i][j]!=null)
				{	
				
						if(DocData[i][j].trim().equals("<TEXT>"))
						{
					
							
							if(!DocData[i][j+1].trim().equals("<P>"))
							{
								
								flag1 = 1;
								
								flag3 = 1;
								
								j++;
								
								
							}
							else
							{
							
								flag1 = 1 ;
								
							}
							
							                
						
						} 
						else if(DocData[i][j].trim().equals("</TEXT>"))
						{
														
							break;
							
						}
						
						
						if(flag1 == 1)
						{
							
							if(DocData[i][j].trim().equals("<P>"))      /* With <P> Start */
							{
								
								flag2 = 1;
								
								j++;
							
							}
							else if(DocData[i][j].trim().equals("</P>"))
							{
									
								flag2 = 0;
								
								c++;

								d=0;
								
							}
							
							
							if(flag2 == 1)
							{
											
								Passage[c][d] = DocData[i][j];
								
								d++;	
							
							}											/* With <P> End */
							
							
							if(flag3 == 1)								/* Without <P> Start */
							{
								
								if(lineCount < 5)
								{
								
									Passage[c][d] = DocData[i][j];
												
									if(DocData[i][j].charAt((DocData[i][j].length()-1))=='.')
											
									{
									
										lineCount = lineCount + 1 ;
										
									}
									
									d++;
							
								}
								else
								{
									
									lineCount = 0 ;
																		
									c++;
									
									d=0;
									
								}
									
							}											/* Without <P> End */
								
						}
							
						
					
					}	
			}
	

	    }
		catch(Exception e)
		{
		
		System.out.println(e);
		e.printStackTrace();
		
		}
		return Passage;

}

}
