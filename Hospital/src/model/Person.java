package model;

/**
 * The Person class represents an abstract person with basic information like id, name, gender,...
 * It serves as a base for more specific person subclasses.
 * @author tahoa
 */
public abstract class Person {
    String id, name, gender, address, phone;  
    int age;

    /**
     * Default constructor for the Person class.
     */
    public Person() {
    }
    

    /**
     * Parameterized constructor for the Person class.
     * @param id
     * @param name
     * @param age
     * @param gender
     * @param address
     * @param phone 
     */
    public Person(String id, String name,int age, String gender, String address, String phone) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.phone = phone;
    }
    
    /**
     * Parameterized constructor for the Person class.
     * @param name
     * @param age
     * @param gender
     * @param address
     * @param phone 
     */
    public Person(String name, int age, String gender, String address, String phone) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.phone = phone;
    }

    /**
     * Get the ID of the person.
     * @return the ID of the person.
     */
    public String getId() {
        return id;
    }

    /**
     * Get the name of the person.
     * @return the name of the person.
     */
    public String getName() {
        return name;
    }
    
    /**
     * Get the age of the person.
     * @return the age of the person.
     */
    public int getAge() {
        return age;
    }

    /**
     * Get the gender of the person.
     * @return the gender of the person.
     */
    public String getGender() {
        return gender;
    }

    /**
     * Get the address of the person.
     * @return the address of the person.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Get the phone of the person
     * @return the phone of the person.
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Set the ID of the person.
     * @param id the ID of the person.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Set the name of the person.
     * @param name the name of the person.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Set the gender of the person.
     * @param gender the gender of the person.
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Set the address of the person.
     * @param address the address of the person.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Set the phone of the person.
     * @param phone the phone of the person.
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Set the age of the person. 
     * @param age the age of the person.
     */
    public void setAge(int age) {
        this.age = age;
    }

    
    @Override
    /** 
     * Get a string to representation of the Person project.
     * @return a string to representation of the Person project.
     */
    public String toString() {
        return id +", " + name + ", " + age + ", " + gender + ", " + address + ", " + phone;
    }
    
    
}
