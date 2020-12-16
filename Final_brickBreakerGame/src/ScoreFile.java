

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime; 

public class ScoreFile {
private String username;
private Integer points;
private String diff;
private String dateTime;
	public ScoreFile(String name, Integer score, String difficulty) {
		username = name;
		points = score;
		diff = difficulty;
		try {
			File f = new File("score.txt");
		}catch(Exception e) {
			e.printStackTrace();
		}
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();  
		dateTime = dtf.format(now);
		
		try(FileWriter fw = new FileWriter("score.txt", true);
			    BufferedWriter bw = new BufferedWriter(fw);
			    PrintWriter out = new PrintWriter(bw))
			{
			    out.println(username+" "+points+" "+diff+" "+dateTime);
			} catch (Exception e) {
			    e.printStackTrace();
			}
	}
}
