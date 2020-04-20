package part2;

import java.io.*;
import java.util.*;
import java.util.Observable;

public class DataModel extends Observable {
	private int[] data;
	private int size;
	public DataModel() {
		data = new int[10];
		size = 0;
	}
	public void add(int num) {
		if(data.length == size) {
			int[] newData = new int[2 * size];
			System.arraycopy(data, 0, newData, 0, size);
			data = newData;		
		}
		data[size++] = num;
	}
	public void set(int index, int num) {
		data[index] = num;
		setChanged();
		notifyObservers(index);
	}
	public int get(int index) {
		return data[index];
	}
	public int getSize() {
		return size;
	}
	public void save(String file) {
		PrintWriter writer;
		try {
			writer = new PrintWriter(file);
			for(int i = 0; i < getSize(); i++) {
				writer.println(data[i]);
			}
			writer.close();
		} catch (Exception e){
			System.out.println("File error.");
		}
	}
}