package com.mnuenninghoff.entity;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Name{

	@JsonProperty("names")
	private List<String> names;

	@JsonProperty("count")
	private int count;

	public void setNames(List<String> names){
		this.names = names;
	}

	public List<String> getNames(){
		return names;
	}

	public void setCount(int count){
		this.count = count;
	}

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