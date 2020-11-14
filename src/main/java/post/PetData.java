package post;

import java.util.List;


public class PetData {

	public Integer id;
	public Category category;
	public String name;
	public List<String> photoUrls = null;
	public Tags tags;
	public String status;

	public PetData() {
	}

	public PetData(Integer id, Category category, String name, List<String> photoUrls, Tags tags, String status) {
	super();
	this.id = id;
	this.category = category;
	this.name = name;
	this.photoUrls = photoUrls;
	this.tags = tags;
	this.status = status;
	}
		

}
