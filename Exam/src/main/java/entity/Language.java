package entity;

public class Language {
	private String name;
	private Integer language_id;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getLanguage_id() {
		return language_id;
	}
	public void setLanguage_id(Integer language_id) {
		this.language_id = language_id;
	}
	public Language() {
		super();
	}
	public Language(String name, Integer language_id) {
		super();
		this.name = name;
		this.language_id = language_id;
	}
	
	
}
