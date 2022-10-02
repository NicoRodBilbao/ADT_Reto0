package adt_reto0;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.function.Function;
import java.util.ArrayList;

public class FileManager<T> {

	private String filePath = "bankrecords.dat";
	private File records;
	private Class<T> c;

	public FileManager(Class<T> c) {
		this.c = c;
		this.fileCheck();
	}

	/**
	* Checks whether the record exists
	* (if it doesn't exists it creates it)
	* and checks if the File containing the
	* record can be read and written to
	* @return	true if everything is fine
	*/
	private boolean fileCheck() {
		if(!records.exists())
			records = new File(filePath);
		return records.canRead()
			&& records.canWrite();
	}

	/**
	* Adds an object to the record, putting it
	* at the end of said record
	* @param obj 	Object of the type T
	*/
	public void addObject(T obj) {
		if(fileCheck()) {
			try {
				FileOutputStream fout = new FileOutputStream(records);
				ObjectOutputStream oos = new ObjectOutputStream(fout);
				oos.writeObject(obj);
				oos.close();
			} catch (IOException e) {
				ExceptionManager em = new ExceptionManager();
				em.throwException(e);
			}
		}
	}
	
	/**
	* Returns the last object of the record matching the
	* function of the T type
 	* @param	func	The function used to filter
	* @return			Object of the type T matching the filter,
	* 					if none found returns null
	*/
	
	public T getLastMatch(Function<T, Boolean> func) {
		if(fileCheck()) {
			try {
				FileInputStream fin = new FileInputStream(records);
				ObjectInputStream ois = new ObjectInputStream(fin);
				T result = null;
				try {
					while(true) {
						T obj = this.c.cast(ois.readObject());
						if(func.apply(obj))
							result = obj;
					}
				} catch (EOFException e) {
					ois.close();
					return result;
				}
			} catch (IOException e) {
				ExceptionManager em = new ExceptionManager();
				em.throwException(e);
			} catch (ClassNotFoundException e) {
				ExceptionManager em = new ExceptionManager();
				em.throwException(e);
			}
		}
		return null;
	}
	
	/**
	* Get a list of all matching objects in the record
	* @param 	func	A function to filter elements
	* @return 			An ArrayList of type T
	*/
	public ArrayList<T> getAllMatches(Function<T, Boolean> func) {
		ArrayList<T> result = new ArrayList<T>();
		if(fileCheck()) {
			try {
				FileInputStream fin = new FileInputStream(records);
				ObjectInputStream ois = new ObjectInputStream(fin);
				try {
					while(true) {
						T obj = this.c.cast(ois.readObject());
						if(func.apply(obj))
							result.add(obj);
					}
				} catch (EOFException e) {
					ois.close();
					return result;
				}
			} catch (IOException e) {
				ExceptionManager em = new ExceptionManager();
				em.throwException(e);
			} catch (ClassNotFoundException e) {
				ExceptionManager em = new ExceptionManager();
				em.throwException(e);
			}
		}
		return result;
	}
}
