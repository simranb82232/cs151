package trs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.*;

public class User {
	private String id;
	private String password;
	public User (String user, String pwd) {
		id = user;
		password = pwd;
	}
	public boolean authenticate(String pwd) {
		if (password == pwd) {
			return true;
		}
		return false;
	}
	public boolean signIn() throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("users.txt")); 
		String i; 
		while ((i=br.readLine()) != null) {
			if (i.equals(id)) {
				if (br.readLine().equals(password)) {
					br.close();
					return true;
					}
				br.close();
				return false;
				}
		}
		br.close();
		return false;
	}
	public boolean signUp() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("users.txt")); 
			String i; 
			while ((i=br.readLine()) != null) {
				if (i.equals(id)) {
					br.close();
					return false;
					}
			}
			br.close();
		    FileWriter fw = new FileWriter("users.txt",true); 
		    fw.write("\n" + id + "\n" + password);
		    fw.close();
		}
		catch(IOException ioe)
		{
		    System.out.println("IOException: " + ioe.getMessage());
		}
		return true;
	}
}
