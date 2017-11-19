package LogAnalysis.logGenerator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Scanner;

import com.machine.learning.decisiontrees.DecisionTree;

public class RunDecisionTree {
	public static void main(String[] args) throws Exception {
		String psvFileName = "context.psv";
		createPSV(psvFileName);
		
		DecisionTree tree = new DecisionTree();
		tree.train(new File(psvFileName));
		System.out.println(tree.classify("T1243"));
	}
	
	static void createPSV(String fileName) throws Exception {
		Table table =  loadTable("fca.txt");
		
		FileOutputStream outputStream = new FileOutputStream(fileName);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-8");
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
		
        bufferedWriter.append("TID|Class\n");
        for(int i=0; i<table.tableData.length; i++){
        	for(int j=0; j<table.tableData[0].length; j++){
        		if(table.tableData[i][j] == 1){
        			bufferedWriter.append(table.rowTitles[i]+"|"+table.columnTitles[j]+"\n");
        		}
        	}
        }
        
        bufferedWriter.close();
	}
	
	static Table loadTable(String fileName) throws Exception {
		Scanner scanner  = new Scanner(new FileInputStream(fileName));
		
		String columnTitlesLine = scanner.nextLine();
		columnTitlesLine = columnTitlesLine.substring(1, columnTitlesLine.indexOf("]"));
		//System.out.println(columnTitlesLine);
		String[] columnTitles = columnTitlesLine.split(", ");
		//print(columnTitles);
		
		String rowTitlesLine = scanner.nextLine();
		rowTitlesLine = rowTitlesLine.substring(1, rowTitlesLine.indexOf("]"));
		//System.out.println(rowTitlesLine);
		String[] rowTitles = rowTitlesLine.split(", ");
		//print(rowTitles);
		
		int[][] tableData = new int[rowTitles.length][columnTitles.length];
		for(int i=0; i<tableData.length; i++){
			for(int j=0; j<tableData[0].length; j++){
				tableData[i][j] = scanner.nextInt();
			}
		}
		
		scanner.close();
		
		return new Table(columnTitles, rowTitles, tableData);
	}
	
	static void print(String[] strs){
		for(String str: strs){
			System.out.println(str);
		}
	}
}

class Table{
	String[] columnTitles;
	String[] rowTitles;
	int[][] tableData;
	
	Table(String[] columnTitles, String[] rowTitles, int[][] tableData){
		this.columnTitles = columnTitles;
		this.rowTitles = rowTitles;
		this.tableData = tableData;
	}
}

class Graph{
	String node;
	
	Graph(){
		
	}
}
