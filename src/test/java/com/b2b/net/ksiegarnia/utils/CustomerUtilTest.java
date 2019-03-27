package com.b2b.net.ksiegarnia.utils;

import com.b2b.net.ksiegarnia.domain.Book;
import com.b2b.net.ksiegarnia.domain.Customer;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;


class CustomerUtilTest {

    private CustomerReader reader = new CustomerReader();
    private BookReader bookReader = new BookReader();
    private CustomerUtil util = new CustomerUtil();

    @Test
    void countHowManyMenFirstTest() throws IOException, URISyntaxException {
        Map<String, Customer> map = reader.fillStructureCustomers();
        assertEquals(57, util.countHowManyMen(map));
    }

    @Test
    void countHowManyMenSecondTest() throws IOException, URISyntaxException {
        Map<String, Customer> map = new HashMap<>();
        Customer customer1 = new Customer("92061754985", "KASZUBOWSKA", "ANTONINA");
        Customer customer2 = new Customer("92061937214", "MORAWIEC", "DAWID");
        Customer customer3 = new Customer("92062548936", "OGONOWSKA", "JULIUSZ");
        Customer customer4 = new Customer("92062762152", "SZYMONIAK", "JAN");

        map.put("92061754985", customer1);
        map.put("92061937214", customer2);
        map.put("92062548936", customer3);
        map.put("92062762152", customer4);

        assertEquals(3, util.countHowManyMen(map));
    }

    @Test
    public void findTheYoungestAndTheOldestCustomers() throws IOException, URISyntaxException {
        Map<String, Customer> customerMap = reader.fillStructureCustomers();
        List<Customer> customers = util.findTheYoungestAndTheOldestCustomers(customerMap);
        assertEquals(customers, util.findTheYoungestAndTheOldestCustomers(customerMap));
        assertEquals(customers, util.findTheYoungestAndTheOldestCustomers(customerMap));
        assertEquals(2, customers.size());

    }

    @Test
    public void findTheYoungestAndTheOldestCustomersSecondTest() throws IOException, URISyntaxException {

        Map<String, Customer> map = new HashMap<>();
        Customer customer1 = new Customer("92061754985", "KASZUBOWSKA", "ANTONINA");
        Customer customer2 = new Customer("92061937214", "MORAWIEC", "DAWID");
        Customer customer3 = new Customer("92062548936", "OGONOWSKA", "JULIUSZ");
        Customer customer4 = new Customer("92062762152", "SZYMONIAK", "JAN");

        map.put("92061754985", customer1);
        map.put("92061937214", customer2);
        map.put("92062548936", customer3);
        map.put("92062762152", customer4);

        List<Customer> customers = util.findTheYoungestAndTheOldestCustomers(map);
        assertEquals(customers, util.findTheYoungestAndTheOldestCustomers(map));
        assertEquals(customers, util.findTheYoungestAndTheOldestCustomers(map));
        assertEquals(2, customers.size());
    }

    @Test
    public void howManyBooksWereBoughtAboveTheAveregePriceFirstTest() throws IOException, URISyntaxException {
        Map<String, List<Book>> bookMap = bookReader.fillStructureBook();
        int howManyCustomers = util.howManyBooksWereBoughtAboveTheAveregePrice(bookMap);
        assertEquals(48, howManyCustomers);
    }

    @Test
    public void howManyBooksWereBoughtAboveTheAveregePriceSecondTest() throws IOException, URISyntaxException {

        Map<String, List<Book>> map = new HashMap<>();

        Book book1 = new Book("92112635683", "OPTYMALIZACJA ALGORYTMOW I", 100);
        Book book2 = new Book("92121027392", "AUDYT BEZPIECZENSTWA SIECI", 50);
        Book book3 = new Book("92121586455", "MERNICTWO ELEKTRYCZNE II", 30);
        Book book4 = new Book("92122718336", "CHEMIA KWANTOWA I", 20);
        Book book5 = new Book("92122755816", "ELEKTRONIKA CYFROWA II	", 110);

        List<Book> listOfBooksCustomer1 = new ArrayList<>();
        listOfBooksCustomer1.add(book1);
        listOfBooksCustomer1.add(book2);

        List<Book> listOfBooksCustomer2 = new ArrayList<>();
        listOfBooksCustomer2.add(book5);
        listOfBooksCustomer2.add(book4);
        listOfBooksCustomer2.add(book3);

        List<Book> listOfBooksCustomer3 = new ArrayList<>();
        listOfBooksCustomer3.add(book1);
        listOfBooksCustomer3.add(book2);
        listOfBooksCustomer3.add(book3);
        listOfBooksCustomer3.add(book4);
        listOfBooksCustomer3.add(book5);

        map.put("92112635683", listOfBooksCustomer1);
        map.put("92121027392", listOfBooksCustomer2);
        map.put("92121586455", listOfBooksCustomer3);

        int howManyCustomers = util.howManyBooksWereBoughtAboveTheAveregePrice(map);
        assertEquals(4, howManyCustomers);
    }

    @Test
    public void findPeselLukaszaFirstTest() throws IOException, URISyntaxException {
        Map<String, Customer> customerMap = reader.fillStructureCustomers();
        List<String> customers = util.findPeselLukasza(customerMap);
        assertEquals(customers, util.findPeselLukasza(customerMap));
        assertEquals(1, customers.size());
    }

    @Test
    public void findPeselLukaszaSecondTest() throws IOException, URISyntaxException {

        Map<String, Customer> map = new HashMap<>();
        Customer customer1 = new Customer("92061754985", "KASZUBOWSKA", "ANTONINA");
        Customer customer2 = new Customer("92061937214", "MORAWIEC", "LUKASZ");
        Customer customer3 = new Customer("92062548936", "OGONOWSKA", "JULIUSZ");
        Customer customer4 = new Customer("92062762152", "SZYMONIAK", "LUKASZ");

        map.put("92061754985", customer1);
        map.put("92061937214", customer2);
        map.put("92062548936", customer3);
        map.put("92062762152", customer4);

        List<String> customers = util.findPeselLukasza(map);
        assertEquals(customers, util.findPeselLukasza(map));
        assertEquals(2, customers.size());
    }

    @Test
    public void nameWithLastnameCustomersWhoBuyBooksAbove100FirstTest() throws IOException, URISyntaxException {
        Map<String, Customer> customerMap = reader.fillStructureCustomers();
        Map<String, List<Book>> bookMap = bookReader.fillStructureBook();
        List<String> customers = util.nameWithLastnameCustomersWhoBuyBooksAbove100(bookMap, customerMap);
        assertEquals(customers, util.nameWithLastnameCustomersWhoBuyBooksAbove100(bookMap, customerMap));
        assertEquals(5, customers.size());
    }

    @Test
    public void nameWithLastnameCustomersWhoBuyBooksAbove100SecondTest() throws IOException, URISyntaxException {

        Map<String, List<Book>> map = new HashMap<>();
        Map<String, Customer> customerMap = new HashMap<>();

        Book book1 = new Book("OPTYMALIZACJA ALGORYTMOW I", "92112635683", 110);
        Book book2 = new Book("AUDYT BEZPIECZENSTWA SIECI", "92121027392", 50);
        Book book3 = new Book("MERNICTWO ELEKTRYCZNE II", "92121586455", 30);
        Book book4 = new Book("ELEKTRONIKA CYFROWA II	", "92122755816", 110);

        Customer customer1 = new Customer("92061754985", "KASZUBOWSKA", "ANTONINA");
        Customer customer2 = new Customer("92061937214", "MORAWIEC", "LUKASZ");
        Customer customer3 = new Customer("92062548936", "OGONOWSKA", "JULIUSZ");
        Customer customer4 = new Customer("92062762152", "SZYMONIAK", "LUKASZ");


        List<Book> listOfBooksCustomer1 = new ArrayList<>();
        listOfBooksCustomer1.add(book1);

        List<Book> listOfBooksCustomer2 = new ArrayList<>();
        listOfBooksCustomer2.add(book2);

        List<Book> listOfBooksCustomer3 = new ArrayList<>();
        listOfBooksCustomer3.add(book3);

        List<Book> listOfBooksCustomer4 = new ArrayList<>();
        listOfBooksCustomer3.add(book4);

        map.put("92112635683", listOfBooksCustomer1);
        map.put("92061937214", listOfBooksCustomer2);
        map.put("92062548936", listOfBooksCustomer3);
        map.put("92062762152", listOfBooksCustomer4);

        customerMap.put("92112635683", customer1);
        customerMap.put("92061937214", customer2);
        customerMap.put("92062548936", customer3);
        customerMap.put("92062762152", customer4);


        List<String> customers = util.nameWithLastnameCustomersWhoBuyBooksAbove100(map, customerMap);
        assertEquals(customers, util.nameWithLastnameCustomersWhoBuyBooksAbove100(map, customerMap));
        assertEquals(2, customers.size());
    }

    @Test
    public void findCustomersFrom92YearFirstTest() throws IOException, URISyntaxException {
        Map<String, Customer> customerMap = reader.fillStructureCustomers();
        List<Customer> customers = util.findCustomersFrom92Year(customerMap);
        assertEquals(customers, util.findCustomersFrom92Year(customerMap));
        assertEquals(41, customers.size());
    }

    @Test
    public void findCustomersFrom92YearSecondTest() throws IOException, URISyntaxException {

        Map<String, Customer> customerMap = new HashMap<>();

        Customer customer1 = new Customer("92061754985", "KASZUBOWSKA", "ANTONINA");
        Customer customer2 = new Customer("92061937214", "MORAWIEC", "LUKASZ");
        Customer customer3 = new Customer("95062548936", "OGONOWSKA", "JULIUSZ");
        Customer customer4 = new Customer("92062762152", "SZYMONIAK", "LUKASZ");
        Customer customer5 = new Customer("91005342211", "JURAS", "JAN");

        customerMap.put("92061754985", customer1);
        customerMap.put("92061937214", customer2);
        customerMap.put("95062548936", customer3);
        customerMap.put("92062762152", customer4);
        customerMap.put("91005342211", customer5);

        List<Customer> customers = util.findCustomersFrom92Year(customerMap);
        assertEquals(customers, util.findCustomersFrom92Year(customerMap));
        assertEquals(3, customers.size());
    }

}