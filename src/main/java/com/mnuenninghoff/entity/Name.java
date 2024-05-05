package com.mnuenninghoff.entity;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Name.
 */
public class Name{

	@JsonProperty("names")
	private List<String> names;

	@JsonProperty("count")
	private int count;

	/**
	 * Set names.
	 *
	 * @param names the names
	 */
	public void setNames(List<String> names){
		this.names = names;
	}

	/**
	 * Get names list.
	 *
	 * @return the list
	 */
	public List<String> getNames(){
		return names;
	}

	/**
	 * Set count.
	 *
	 * @param count the count
	 */
	public void setCount(int count){
		this.count = count;
	}

	/**
	 * Get count int.
	 *
	 * @return the int
	 */
	public int getCount(){
		return count;
	}

	@Override
 	public String toString(){
		return 
			"Name{" + 
			"names = '" + names + '\'' + 
			",count = '" + count + '\'' + 
			"}";
		}
}