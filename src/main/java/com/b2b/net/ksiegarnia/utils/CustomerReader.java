package com.b2b.net.ksiegarnia.utils;

import com.b2b.net.ksiegarnia.domain.Customer;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerReader {

    public Map<String, Customer> fillStructureCustomers() throws URISyntaxException, IOException {
        Map<String, Customer> customerMap = new HashMap<>();
        List<String> lines = Files.readAllLines(Paths.get(getClass().getClassLoader().getResource("customerr.txt").toURI()));
        lines.remove(0);
        for (String line : lines) {
            String[] source = line.split("\t");
            Customer customer = new Customer(source[0], source[1], source[2]);
            customerMap.put(source[0], customer);
        }
        return customerMap;
    }

}
