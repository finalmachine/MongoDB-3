package com.gbi.mongodb3.domain;

import org.bson.Document;
// TODO 目前还是失败的
public class Human extends Document {
	
	private static final long serialVersionUID = 4913241539729847720L;

	// type int
	public static final String AGE = "age";
	
	// type com.gbi.study.domain.Human.Gender
	public static final String GENDER = "gender";
	
	// type String
	public static final String NAME = "name";
	
	public enum Gender {
		secret, male, female, middle;
	}

	public int getAge() {
		return (Integer) get(AGE);
	}

	public Gender getGender() {
		return (Gender) get(GENDER);
	}

	public String getName() {
		return (String) get(NAME);
	}

	public void setAge(int age) {
		put(AGE, age);
	}

	public void setGender(Gender gender) {
		put(GENDER, gender);
	}

	public void setName(String name) {
		put(NAME, name);
	}
	
	@Override
	public Object get(Object key) {
		System.out.println("use get");
		return super.get(key);
	}
	
	@Override
	public Object put(String key, Object value) {
		System.out.println("use put");
		return super.put(key, value);
	}
}
