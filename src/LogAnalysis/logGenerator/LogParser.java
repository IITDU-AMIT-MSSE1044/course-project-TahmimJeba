package LogAnalysis.logGenerator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;


public class LogParser {
	static String[] types = {"INFO", "DEBUG", "WARNING", "ERROR"};
	
	public static void main(String[] args) throws Exception {
		BufferedReader mainBR = new BufferedReader(new InputStreamReader(new FileInputStream("data.log")));
		String stringLine = mainBR.readLine();
		ArrayList<FCAObject> fCAObjects = new ArrayList<FCAObject>();
		while(stringLine!=null){
			fCAObjects.add(parseString(stringLine));
			stringLine = mainBR.readLine();
		}
		mainBR.close();
		
		// write
		FileOutputStream outputStream = new FileOutputStream("dataFCA.log");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-8");
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
        
        for(FCAObject fCAObject: fCAObjects){
        	bufferedWriter.append(fCAObject.threadID+","+fCAObject.type+"\n");
        }
		
		bufferedWriter.close();
		
		return ;
	}
	
	public static FCAObject parseString(String stringLine){
		String processID="";
		String threadID="";
		String type="";
		int start=0, end=0;
		
		start = stringLine.indexOf("PID:")+4;
		end = stringLine.indexOf(" ", start);
		processID = stringLine.substring(start, end);
		
		start = stringLine.indexOf("TID:")+4;
		end = stringLine.indexOf("]", start);
		threadID = stringLine.substring(start, end);
		
		start = stringLine.indexOf(">>")+3;
		end = stringLine.indexOf(" ", start);
		type = stringLine.substring(start, end);
		
		return new FCAObject(processID, threadID, type);
	}
}

class FCAObject{
	String processID;
	String threadID;
	String type;
	
	public FCAObject(String processID, String threadID, String type){
		this.processID = processID;
		this.threadID = threadID;
		this.type = type;
	}
}