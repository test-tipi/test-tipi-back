package co.com.tipi.test.modules.person.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PersonDTO implements Serializable {
    @JsonProperty(value="id")
    private Integer id;
    
    @JsonProperty(value="name")
    private String name;
    
    @JsonProperty(value="last_name")
    private String lastName;
    
    @JsonProperty(value="age")
    private Integer age;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the age
	 */
	public Integer getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "PersonDTO [id=" + id + ", name=" + name + ", lastName=" + lastName + ", age=" + age + "]";
	}
    
    
}