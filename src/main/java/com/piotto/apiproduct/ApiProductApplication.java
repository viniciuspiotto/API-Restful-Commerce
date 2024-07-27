package com.piotto.apiproduct;

import com.piotto.apiproduct.domain.Category;
import com.piotto.apiproduct.domain.City;
import com.piotto.apiproduct.domain.Product;
import com.piotto.apiproduct.domain.State;
import com.piotto.apiproduct.repositories.CategoryRepository;
import com.piotto.apiproduct.repositories.CityRepository;
import com.piotto.apiproduct.repositories.ProductRepository;
import com.piotto.apiproduct.repositories.StateRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class ApiProductApplication implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final StateRepository stateRepository;
    private final CityRepository cityRepository;

    public ApiProductApplication(CategoryRepository categoryRepository, ProductRepository productRepository, StateRepository stateRepository, CityRepository cityRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
        this.stateRepository = stateRepository;
        this.cityRepository = cityRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(ApiProductApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Category cat1 = new Category(null, "Informatica");
        Category cat2 = new Category(null, "Escritorio");

        Product p1 = new Product(null, "Computer", 2000.0);
        Product p2 = new Product(null, "Impressora", 800.0);
        Product p3 = new Product(null, "Mouse", 80.0);

        cat1.getProducts().addAll(Arrays.asList(p1, p2, p3));
        cat2.getProducts().add(p2);

        p1.getCategories().add(cat1);
        p2.getCategories().addAll(Arrays.asList(cat1, cat2));
        p3.getCategories().add(cat1);

        categoryRepository.saveAll(Arrays.asList(cat1, cat2));
        productRepository.saveAll(Arrays.asList(p1, p2, p3));

        State sta1 = new State(null, "Minas Gerais");
        State sta2 = new State(null, "Sao Paulo");

        City c1 = new City(null, "Uberlandia", sta1);
        City c2 = new City(null, "Sao Paulo", sta2);
        City c3 = new City(null, "Campinas", sta2);

        sta1.getCities().add(c1);
        sta2.getCities().addAll(Arrays.asList(c2, c3));

        stateRepository.saveAll(Arrays.asList(sta1, sta2));
        cityRepository.saveAll(Arrays.asList(c1, c2, c3));
    }
}
