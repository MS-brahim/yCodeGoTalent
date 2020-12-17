<<<<<<< HEAD:YoucodeTalents/src/com/youcode/models/Category.java
package com.youcode.models;
=======
package com.codeSource.model;
>>>>>>> BRAHIM:yc_go_talent/src/com/codeSource/model/Category.java

public class Category {
	
	private long id;
	private String name;
	public Category(long id, String name) {
		this.id = id;
		this.name = name;
	}
	public Category() {}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + "]";
	}
	
	
	
}

