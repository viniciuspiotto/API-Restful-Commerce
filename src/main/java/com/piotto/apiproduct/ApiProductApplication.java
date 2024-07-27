package com.piotto.apiproduct;

import com.piotto.apiproduct.domain.*;
import com.piotto.apiproduct.domain.enums.ClientType;
import com.piotto.apiproduct.repositories.*;
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
    private final ClientRepository clientRepository;
    private final AddressRepository addressRepository;

    public ApiProductApplication(CategoryRepository categoryRepository, ProductRepository productRepository, StateRepository stateRepository, CityRepository cityRepository, ClientRepository clientRepository, AddressRepository addressRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
        this.stateRepository = stateRepository;
        this.cityRepository = cityRepository;
        this.clientRepository = clientRepository;
        this.addressRepository = addressRepository;
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

        Client cli1 = new Client(null, "Maria Silva", "maria@gmail.com", "17236123123", ClientType.INDIVIDUAL);
        cli1.getPhones().addAll(Arrays.asList("172371231", "123123123"));

        Address e1 = new Address(null, "Rua Flores", "300", "Apartment 303", "Jardim", "12312314", cli1, c1);
        Address e2 = new Address(null, "Avenida Matos", "105", "Room 800", "Centro", "38209123", cli1, c2);

        cli1.getAddresses().addAll(Arrays.asList(e1, e2));

        clientRepository.save(cli1);
        addressRepository.saveAll(Arrays.asList(e1, e2));
    }
}
