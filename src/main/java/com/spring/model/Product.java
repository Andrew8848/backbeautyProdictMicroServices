package com.spring.model;

import java.util.Map;

import javax.persistence.*;

@Entity
@Table(name="product")
public class Product {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ElementCollection
	@CollectionTable(name="base", joinColumns=@JoinColumn(name="product_id"))
	@OrderColumn(name="ind")
	@Lob
	private String[] base64;
	
	@ElementCollection
    @CollectionTable(name = "price", 
        joinColumns = {@JoinColumn(name = "product_id", referencedColumnName = "id")})
    @MapKeyColumn(name = "currency")
	@Column(name="value")
	private Map<String, Double> price;
	
	@ElementCollection
	@CollectionTable(name="type", joinColumns=@JoinColumn(name="product_id"))
	@OrderColumn(name="ind")
	private String[] type;
	
	@ElementCollection
    @CollectionTable(name = "name", 
        joinColumns = {@JoinColumn(name = "product_id", referencedColumnName = "id")})
    @MapKeyColumn(name = "language")
	@Column(name="value")
	private Map<String, String> name;
	
	@Column(name = "brand")
	private String brand;
	
	@ElementCollection
	@CollectionTable(name="volume", joinColumns=@JoinColumn(name="product_id"))
	@OrderColumn(name="ind")
	private String[] volume;
	
	@Column(name = "age")
	private String age;
	
	@ElementCollection
    @CollectionTable(name = "description", 
        joinColumns = {@JoinColumn(name = "product_id", referencedColumnName = "id")})
    @MapKeyColumn(name = "language")
	@Column(name="value", columnDefinition="TEXT")
	private Map<String, String> description;
	
	@ElementCollection
    @CollectionTable(name = "applying", 
        joinColumns = {@JoinColumn(name = "product_id", referencedColumnName = "id")})
    @MapKeyColumn(name = "language")
	@Column(name="value")
	private Map<String, String> applying;
	
	@ElementCollection
    @CollectionTable(name = "madeIn", 
        joinColumns = {@JoinColumn(name = "product_id", referencedColumnName = "id")})
    @MapKeyColumn(name = "language")
	@Column(name="value")
	private Map<String, String> madeIn;
	
	@ElementCollection
    @CollectionTable(name = "countryTM", 
        joinColumns = {@JoinColumn(name = "product_id", referencedColumnName = "id")})
    @MapKeyColumn(name = "language")
	@Column(name="value")
	private Map<String, String> countryTM;
	
	@ElementCollection
    @CollectionTable(name = "appointment", 
        joinColumns = {@JoinColumn(name = "product_id", referencedColumnName = "id")})
    @MapKeyColumn(name = "language")
	@Column(name="value")
	private Map<String, String> appointment;
	
	@ElementCollection
    @CollectionTable(name = "applicationTime", 
        joinColumns = {@JoinColumn(name = "product_id", referencedColumnName = "id")})
    @MapKeyColumn(name = "language")
	@Column(name="value")
	private Map<String, String> applicationTime;
	
	@ElementCollection
    @CollectionTable(name = "gender", 
        joinColumns = {@JoinColumn(name = "product_id", referencedColumnName = "id")})
    @MapKeyColumn(name = "language")
	@Column(name="value")
	private Map<String, String> gender;
	
	@ElementCollection
    @CollectionTable(name = "classification", 
        joinColumns = {@JoinColumn(name = "product_id", referencedColumnName = "id")})
    @MapKeyColumn(name = "language")
	@Column(name="value")
	private Map<String, String> classification;
	
	public Product() {
		
	}

	public Product(ProductForm productForm) {
		this.id = productForm.getId();
		this.base64 = productForm.getBase64();
		this.price = productForm.getPrice();
		this.type = productForm.getType();
		this.name = productForm.getName();
		this.brand = productForm.getBrand();
		this.volume = productForm.getVolume();
		this.age = productForm.getAge();
		this.description = productForm.getDescription();
		this.applying = productForm.getApplying();
		this.madeIn = productForm.getMadeIn();
		this.countryTM = productForm.getCountryTM();
		this.appointment = productForm.getAppointment();
		this.applicationTime = productForm.getApplicationTime();
		this.gender = productForm.getGender();
		this.classification = productForm.getClassification();
	}

	public Product(Long id, String[] base64, Map<String, Double> price, String[] type, Map<String, String> name, String brand, String[] volume, String age,
			Map<String, String> description, Map<String, String> applying, Map<String, String> madeIn, Map<String, String> countryTM, Map<String, String> appointment,
			Map<String, String> applicationTime, Map<String, String> gender, Map<String, String> classification) {
		super();
		this.id = id;
		this.base64 = base64;
		this.price = price;
		this.type = type;
		this.name = name;
		this.brand = brand;
		this.volume = volume;
		this.age = age;
		this.description = description;
		this.applying = applying;
		this.madeIn = madeIn;
		this.countryTM = countryTM;
		this.appointment = appointment;
		this.applicationTime = applicationTime;
		this.gender = gender;
		this.classification = classification;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String[] getBase64() {
		return base64;
	}
	public void setBase64(String[] base64) {
		this.base64 = base64;
	}
	public Map<String, Double> getPrice() {
		return price;
	}
	public void setPrice(Map<String, Double> price) {
		this.price = price;
	}
	public String[] getType() {
		return type;
	}
	public void setType(String[] type) {
		this.type = type;
	}
	public Map<String, String> getName() {
		return name;
	}
	public void setName(Map<String, String> name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String[] getVolume() {
		return volume;
	}
	public void setVolume(String[] volume) {
		this.volume = volume;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public Map<String, String> getDescription() {
		return description;
	}
	public void setDescription(Map<String, String> description) {
		this.description = description;
	}
	public Map<String, String> getApplying() {
		return applying;
	}
	public void setApplying(Map<String, String> applying) {
		this.applying = applying;
	}
	public Map<String, String> getMadeIn() {
		return madeIn;
	}
	public void setMadeIn(Map<String, String> madeIn) {
		this.madeIn = madeIn;
	}
	public Map<String, String> getCountryTM() {
		return countryTM;
	}
	public void setCountryTM(Map<String, String> countryTM) {
		this.countryTM = countryTM;
	}
	public Map<String, String> getAppointment() {
		return appointment;
	}
	public void setAppointment(Map<String, String> appointment) {
		this.appointment = appointment;
	}
	public Map<String, String> getApplicationTime() {
		return applicationTime;
	}
	public void setApplicationTime(Map<String, String> applicationTime) {
		this.applicationTime = applicationTime;
	}
	public Map<String, String> getGender() {
		return gender;
	}
	public void setGender(Map<String, String> gender) {
		this.gender = gender;
	}
	public Map<String, String> getClassification() {
		return classification;
	}
	public void setClassification(Map<String, String> classification) {
		this.classification = classification;
	}
}
