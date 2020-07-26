package maven.firstproject.data;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Scanner;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;

public class ResourceFileReader {
	
	public String readResource(final String fileName, Charset charset) throws IOException {
        return Resources.toString(Resources.getResource(fileName), charset);
	}
	
	public String GetFileContent(String fileName, String extension){
		try {
			return this.readResource("maven/firstproject/update/" + fileName + extension, Charsets.UTF_8);
		} catch (IOException e) {
			System.out.println(e);
		}
		return null;
	}
	
	public String GetSQLFileContent(String fileName)
	{
		String sql = ""; 
		
		try {
			Scanner reader = new Scanner(GetFileContent(fileName, ".sql"));
			
			while(reader.hasNextLine())
			{
				sql += reader.nextLine();
			}
			reader.close();
		} catch (Exception e)
		{
			System.out.println("SQL file not found: " + fileName);
			System.out.println(e);
		}
		
		return sql;
	}
}
