package LogAnalysis.logGenerator;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;


public class LogGenerator {
	public static void main(String[] args) throws Exception {
		FileOutputStream outputStream = new FileOutputStream("data.log");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-8");
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
        
		
		int loop = 10000;
		int time = 5348;
		
		String timeString;
		String threadID;
		String processID;
		String type;
		String message;
		
		String log;
		System.out.println("generating log...");
		for(int i=0; i<loop; i++){
			time+=getRandomNumber(17);
			timeString = createTime(time);
			threadID = "T"+(1207+(getRandomNumber(50)));
			processID = "A"+(898+(getRandomNumber(34)*getRandomNumber(89)));
			type = getRandomType();
			message = getRandomMessage();
			
			log = "["+timeString+"] [PID:"+processID+" TID:"+threadID+"] RandomLog >> "+type+" Message: "+message+"\n";
			//System.out.println(log);
			bufferedWriter.append(log);
		}
		System.out.println("finished!");
		
	    bufferedWriter.close();
	}
	
	static String createTime(int time){
		String timeString="";
		
		timeString += (time%1000)+":";
		timeString += ((time/1000)%30)+":";
		timeString += ((time/3000)%12)+":";
		timeString += (1970+(time/5000));
		
		return timeString;
	}
	
	static String[] types = {"INFO", "DEBUG", "WARNING", "ERROR"};
	static String getRandomType(){
		String type = types[0];
		
		int randomNumber = getRandomNumber(500);
		if(randomNumber>350){
			type = types[1];
			
			if(randomNumber<400){
				type = types[2];
				
				if(randomNumber%5 == 0){
					type = types[3];
				}
			}
		}
		
		return type;
	}
	
	static String getRandomMessage(){
		String randomString = "";
		int length = 15+getRandomNumber(40);
		for(int i=0; i<length; i++){
			randomString += (char)('a'+getRandomNumber(26));
			if(getRandomNumber(26)%5==0){
				randomString+=' ';
			}
		}
		return randomString;
	}
	
	static int seed=3;
	public static int getRandomNumber(int range){
		seed = (seed<<3) + (seed%53);
		int randomNumber = (seed<<15+53117) % range;
		if(randomNumber<0){
			randomNumber = -randomNumber;
		}
		return randomNumber;
	}
	
}
