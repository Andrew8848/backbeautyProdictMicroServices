package com.spring;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

import com.spring.dao.DataStoreREST;
import com.spring.fixer.Fixer;
import com.spring.fixer.FixerFactory;
import com.spring.model.Product;
import com.spring.model.ProductForm;
import com.spring.repositories.ProductRepository;
import com.spring.security.OAuth2;


@SpringBootApplication
public class Application implements CommandLineRunner {

//	@Autowired
//	private ProductDAO productDao;
	
//	@Autowired
//	private ProductRepository productRepo;
	
	@Autowired
	private OAuth2 oa;
	
	@Autowired
	private FixerFactory ff;
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		ApplicationContext ctx = SpringApplication.run(Application.class, args);
	    DataStoreREST dbrest = new DataStoreREST();
		dbrest.setPath("src/main/resources/datastore.properties");
//		
		//Long i = (long) 1; 
        //System.out.println(dbrest.setEntity(new Product(1, 140, new String[]{"Nutrition", "Moisturizing"}, "Coconut body oil, brand", "Elit-Lab", "150ml", "18+", "Coconut oil is a unique natural product", "Body care", "Ukraine", "Ukraine", "nutrition, hydration", "universal", "for women", "professional")));
	    //System.out.println(dbrest.getEntityById((long)6, "Product", "Beauty"));
	}

	@Override
	public void run(String... args) throws Exception {
		oa.setProp("src/main/resources/OAuth.properties");
		Future<String> authBackground = oa.setRefreshingToken();
//		ff.setPath("src/main/resources/exchange-rates-eur.json");
//		Future<String> fixerBackground = ff.setDynamicExchangeRate();
		

//		Map<String, String> name = new HashMap();
//		name.put("en", "Russian name");
//		name.put("ru", "English name");
//		name.put("uk", "Ukreanian name");
//		Map<String, String> description = new HashMap();
//		description.put("en", "Russian description");
//		description.put("ru", "English description");
//		description.put("uk", "Ukreanian description");
//		Map<String, String> applying = new HashMap();
//		applying.put("en", "Russian applying");
//		applying.put("ru", "English applying");
//		applying.put("uk", "Ukreanian applying");
//		Map<String, String> madeIn = new HashMap();
//		madeIn.put("en", "Russian madeIn");
//		madeIn.put("ru", "English madeIn");
//		madeIn.put("uk", "Ukreanian madeIn");
//		Map<String, String> countryTM = new HashMap();
//		countryTM.put("en", "Russian countryTM");
//		countryTM.put("ru", "English countryTM");
//		countryTM.put("uk", "Ukreanian countryTM");
//		Map<String, String> appointment = new HashMap();
//		appointment.put("en", "Russian appointment");
//		appointment.put("ru", "English appointment");
//		appointment.put("uk", "Ukreanian appointment");
//		Map<String, String> applicationTime = new HashMap();
//		applicationTime.put("en", "Russian applicationTime");
//		applicationTime.put("ru", "English applicationTime");
//		applicationTime.put("uk", "Ukreanian applicationTime");
//		Map<String, String> gender = new HashMap();
//		gender.put("en", "Russian gender");
//		gender.put("ru", "English gender");
//		gender.put("uk", "Ukreanian gender");
//		Map<String, String> classification = new HashMap();
//		classification.put("en", "Russian classification");
//		classification.put("ru", "English classification");
//		classification.put("uk", "Ukreanian classification");
//		
//		Fixer ffixer = new FixerFactory().getCurrentRate();
//		String[] rates = {"EUR"};
//		
//		Product product = new Product(0, new String[]{"2342345tresg4324523et2weater"},
//				ffixer.getFormatedRank(140, Arrays.asList(rates)),
//				new String[]{"Nutrition", "Moisturizing"},
//				name,
//				"Brand",
//				new String[] {"150ml"},
//				"18+",
//				description,
//				applying,
//				madeIn,
//				countryTM,
//				appointment,
//				applicationTime,
//				gender,
//				classification);
		
//		productRepo.save(product);
		
//		productDao.setProduct(product);
		
//		System.out.println(productRepo.count());
//		for(int i = 1; i<=3; i++) {
//		DataStoreREST rest = new DataStoreREST();
//		
//		Product pr = rest.getEntityById(2, "Product", "Beauty");
//		
//		Map<String, Double> price = new HashMap<String, Double>();
//		price.put("EUR", pr.getPrice().get("EUR"));
//		pr.setPrice(price);
//		productRepo.save(pr);
//		}
//		productRepo.deleteById((long)2);
//		String[] baseTest = {"jiihio","guguigui"};
//		
//		
////		pr.setBase64(baseTest);
//		Map<String, String> description = new HashMap();
//		description.put("en", "Russian description");
//		description.put("ru", "English description");
//		description.put("uk", "Ukreanian description");
//		
////		pr.setDescription(description);
//		
////		Arrays.asList(pr.getBase64()()).stream().forEach(x -> System.out.println(x));;
//		
////		
//        String str[] = productRepo.findById(1).get().getBase64();
////		
//		Arrays.asList(str).stream().forEach(x -> System.out.println(x));
		
//		List<Integer> ids = new ArrayList<Integer>();
//		ids.add(1);
//		ids.add(3);
//		
//		productRepo.deleteById(2L);
//		productRepo.findAllById(ids).stream().forEach(x-> System.out.println(x.getBrand()));
//		productRepo.deleteById((long)2);
		
	}

}
