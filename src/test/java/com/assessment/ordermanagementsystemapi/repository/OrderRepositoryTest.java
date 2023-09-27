package com.assessment.ordermanagementsystemapi.repository;

import com.assessment.ordermanagementsystemapi.entity.Customer;
import com.assessment.ordermanagementsystemapi.entity.Order;
import com.assessment.ordermanagementsystemapi.entity.OrderLine;
import com.assessment.ordermanagementsystemapi.entity.Product;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;
import java.util.List;

@DataJpaTest
class OrderRepositoryTest {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrderLineRepository orderLineRepository;

    @BeforeEach
    public void setUp(){

        Customer customer = new Customer();
        customer.setFullName("John Doe");
        customer.setEmail("johndoe@example.com");
        customer.setTelephone("123-456-7890");
        customer.setRegistrationCode("CUSTOMER123");
        customerRepository.save(customer);

        Product product1 = new Product();
        product1.setName("Jolt Cola");
        product1.setSkuCode("G7119");
        product1.setUnitPrice(19.99);
        productRepository.save(product1);

        Product product2 = new Product();
        product2.setName("Cheese");
        product2.setSkuCode("T8589");
        product2.setUnitPrice(25.68);
        productRepository.save(product2);

        Order order = new Order();
        order.setSubmissionDate(new Date(2023-04-13));
        order.setCustomer(customer);
        orderRepository.save(order);

        OrderLine orderLine1 = new OrderLine();
        orderLine1.setProduct(product1);
        orderLine1.setQuantity(20);
        orderLine1.setOrder(order);
        orderLineRepository.save(orderLine1);

        OrderLine orderLine2 = new OrderLine();
        orderLine2.setProduct(product2);
        orderLine2.setQuantity(10);
        orderLine2.setOrder(order);
        orderLineRepository.save(orderLine2);
    }

    @Test
    void findOrdersBySubmissionDate() {
        //Given
        Date submissionDate = new Date(2023-04-13);
        //When
        List<Order> foundOrders = orderRepository.findOrdersBySubmissionDate(submissionDate);
        //Then
        Assertions.assertThat(foundOrders).isNotEmpty();
    }

    @Test
    void findByCustomer() {
        String customerName = "John Doe";
        List<Order> foundOrders = orderRepository.findByCustomer(customerName);

        Assertions.assertThat(foundOrders).isNotEmpty();
        Assertions.assertThat(foundOrders.get(0).getCustomer().getFullName()).isEqualTo(customerName);
    }

    @Test
    void findByProduct() {
        String productName = "Jolt Cola";
        List<Order> foundOrders = orderRepository.findByProduct(productName);

        Assertions.assertThat(foundOrders).isNotEmpty();
    }
}