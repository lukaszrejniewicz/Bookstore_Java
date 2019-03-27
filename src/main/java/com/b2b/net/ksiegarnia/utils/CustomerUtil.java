package com.b2b.net.ksiegarnia.utils;

import com.b2b.net.ksiegarnia.domain.Book;
import com.b2b.net.ksiegarnia.domain.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class CustomerUtil {

    // Metoda zlicza ilu mężczyzn kupiło książki
    int countHowManyMen(Map<String, Customer> customerMap) {

        int counter = 0;

        for (String key : customerMap.keySet()) {
            if (!customerMap.get(key).getName().endsWith("A")) {
                counter++;
            }
        }
        return counter;
    }

    // metoda znajduje nastarszego i najmłodszego klienta
    public List<Customer> findTheYoungestAndTheOldestCustomers(Map<String, Customer> customerMap) {
        List<Customer> customers = new ArrayList<>();
        List<String> pesels = new ArrayList<>();

        for (String key : customerMap.keySet()) {
            pesels.add(key);
        }
        Collections.sort(pesels);
        for (String customer : customerMap.keySet()) {
            if (pesels.get(0).equals(customer)) {
                customers.add(customerMap.get(customer));
            }
            if (pesels.get(pesels.size() - 1).equals(customer)) {
                customers.add(customerMap.get(customer));
            }
        }
        return customers;
    }

    // metoda sprawdzajaca ile kupiono książek powyżej średniej ceny
    public int howManyBooksWereBoughtAboveTheAveregePrice(Map<String, List<Book>> bookMap) {
        int howManyBooks = 0;
        double sum = 0;
        int counter = 0;

        for (List<Book> value : bookMap.values()) {
            for (Book book : value) {
                sum += book.getPrice();
                counter++;
            }
        }
        double avarage = sum / counter;

        for (List<Book> value : bookMap.values()) {
            for (Book book : value) {
                if (book.getPrice() > avarage) {
                    howManyBooks++;
                }
            }
        }
        return howManyBooks;
    }


    public List<String> findPeselLukasza(Map<String, Customer> customerMap) {
        List<String> lukasz = new ArrayList<>();

        for (String key : customerMap.keySet()) {
            if (customerMap.get(key).getName().equals("LUKASZ")) {
                lukasz.add(customerMap.get(key).getPesel());
            }
        }

        return lukasz;
    }

    public List<String> nameWithLastnameCustomersWhoBuyBooksAbove100(Map<String, List<Book>> bookMap, Map<String, Customer> customerMap) {
        String customerData = "";
        List<String> customers = new ArrayList<>();

        for (String key : customerMap.keySet()) {
            for (Book book : bookMap.get(key)) {
                if (book.getPrice() > 100) {
                    customerData = customerMap.get(key).getName() + " " + customerMap.get(key).getSurname();
                    customers.add(customerData);
                }
            }
        }
        return customers;
    }

    //Metoda zwraca liste kupców z roku 92
    public List<Customer> findCustomersFrom92Year(Map<String, Customer> customerMap) {
        List<Customer> customers = new ArrayList<>();

        for (String key : customerMap.keySet()) {
            if (customerMap.get(key).getPesel().charAt(0) == '9' && customerMap.get(key).getPesel().charAt(1) == '2') {
                customers.add(customerMap.get(key));
            }
        }
        return customers;
    }
}
