package com.piotto.apiproduct;

import com.piotto.apiproduct.domain.*;
import com.piotto.apiproduct.domain.enums.ClientType;
import com.piotto.apiproduct.domain.enums.PaymentState;
import com.piotto.apiproduct.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Arrays;

@SpringBootApplication
public class ApiProductApplication implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final StateRepository stateRepository;
    private final CityRepository cityRepository;
    private final ClientRepository clientRepository;
    private final AddressRepository addressRepository;
    private final OrderRepository orderRepository;
    private final PaymentRepository paymentRepository;
    private final OrderItemRepository orderItemRepository;

    public ApiProductApplication(CategoryRepository categoryRepository, ProductRepository productRepository, StateRepository stateRepository, CityRepository cityRepository, ClientRepository clientRepository, AddressRepository addressRepository, OrderRepository orderRepository, PaymentRepository paymentRepository, OrderItemRepository orderItemRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
        this.stateRepository = stateRepository;
        this.cityRepository = cityRepository;
        this.clientRepository = clientRepository;
        this.addressRepository = addressRepository;
        this.orderRepository = orderRepository;
        this.paymentRepository = paymentRepository;
        this.orderItemRepository = orderItemRepository;
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

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");

        Order ord1 = new Order(null, sdf.parse("31/07/2017 10:32"), cli1, e1);
        Order ord2 = new Order(null, sdf.parse("10/10/2017 19:40"), cli1, e2);

        Payment paym1 = new CreditCardPayment(null, PaymentState.PAID, ord1, 6);
        ord1.setPayment(paym1);

        Payment paym2 = new BankSlipPayment(null, PaymentState.PENDING, ord2, sdf.parse("20/10/2017 00:00"), null);
        ord2.setPayment(paym2);

        cli1.getOrders().addAll(Arrays.asList(ord1, ord2));

        orderRepository.saveAll(Arrays.asList(ord1, ord2));
        paymentRepository.saveAll(Arrays.asList(paym1, paym2));

        OrderItem oi1 = new OrderItem(ord1, p1, 0.00, 1, 2000.00);
        OrderItem oi2 = new OrderItem(ord1, p3, 0.00, 2, 80.00);
        OrderItem oi3 = new OrderItem(ord2, p2, 100.00, 1, 800.00);

        ord1.getOrderItems().addAll(Arrays.asList(oi1, oi2));
        ord2.getOrderItems().add(oi3);

        p1.getOrderItems().add(oi1);
        p2.getOrderItems().add(oi3);
        p3.getOrderItems().add(oi2);

        orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3));
    }
}
