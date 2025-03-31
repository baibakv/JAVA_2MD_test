package lv.venta;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lv.venta.model.Product;
import lv.venta.repo.IProductRepo;

@SpringBootApplication
public class JavaMd2KvizikevicaTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaMd2KvizikevicaTestApplication.class, args);
	}
	
	
	@Bean
	public CommandLineRunner testDB(IProductRepo prodRepo) {
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				
			Product p1 = new Product ("Abols", "Garsigs", 0.99f, 4);
			Product p2 = new Product ("Gurķis", "Garš", 0.57f, 5);
			Product p3 = new Product ("Tomats", "Suligs", 1.79f, 1);
			//saglabas produktus ari DB
			prodRepo.save(p1);
			prodRepo.save(p2);
			prodRepo.save(p3);
			
			System.out.println("cik produkti eksiste?--> " + prodRepo.count());
			
			}
		};
	}
	
	
	
	
	
	
	
	
	

}
