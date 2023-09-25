package com.pursuit.springclass.config;

import com.pursuit.springclass.entities.*;
import com.pursuit.springclass.entities.enums.OrderStatus;
import com.pursuit.springclass.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    // database seeding
    @Override
    public void run(String... args) throws Exception {
        User user1 = new User(null, "Ronaldo Fenomeno", "ronaldo@gmail.com", "229869584", "123321");
        User user2 = new User(null, "Maria Julia", "maria@gmail.com", "22949139043", "1234323");

        Order order1 = new Order(null, Instant.now(), user1, OrderStatus.PAID);
        Order order2 = new Order(null, Instant.now(), user1, OrderStatus.WAITING_PAYMENT);
        Order order3 = new Order(null, Instant.now(), user2, OrderStatus.WAITING_PAYMENT);

        this.userRepository.saveAll(Arrays.asList(user1, user2));
        this.orderRepository.saveAll(Arrays.asList(order1, order2, order3));

        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Utilities");
        Category cat3 = new Category(null, "Computers");

        Product prod1 = new Product(null, "Macbook Pro", "A computer from Apple", 650.00, "https://randomImageGenerator/2312", order1);
        Product prod2 = new Product(null, "Toolbox", "Toolbox containing the following items: Screwdriver, Hammer and some nails", 15.00, "https://randomImageGenerator/5123", order3);

        this.categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        this.productRepository.saveAll(Arrays.asList(prod1, prod2));

        prod1.getCategories().add(cat1);
        prod1.getCategories().add(cat3);
        prod2.getCategories().add(cat2);

        this.productRepository.saveAll(Arrays.asList(prod1, prod2));

        OrderItem orderItem1 = new OrderItem(order1, prod1, 3, prod1.getPrice());
        OrderItem orderItem2 = new OrderItem(order2, prod1, 1, prod1.getPrice());
        OrderItem orderItem3 = new OrderItem(order1, prod2, 2, prod2.getPrice());

        this.orderItemRepository.saveAll(Arrays.asList(orderItem1, orderItem2, orderItem3));

        Payment payment1 = new Payment(null, Instant.now(), order1);
        order1.setPayment(payment1);

        this.orderRepository.save(order1);
    }
}
