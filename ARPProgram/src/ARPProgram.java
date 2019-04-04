import java.io.BufferedReader;
import java.io.InputStreamReader;
 
class ARPProgram
{
	public static void main(String []args)throws Exception	
	{
			ProcessBuilder pb = new ProcessBuilder("arpe.bat");  
			pb.redirectErrorStream();                            
			Process p = pb.start();				
			BufferedReader br = new BufferedReader (new InputStreamReader(p.getInputStream()));
			String str="";
			br.readLine();
			br.readLine();
			br.readLine();
			while((str=br.readLine())!=null)
			{
				System.out.println(str);
			}                                              		    	     
	}
}