package com.b2b.net.ksiegarnia.utils;

import com.b2b.net.ksiegarnia.domain.Book;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookReader {

    public Map<String, List<Book>> fillStructureBook() throws URISyntaxException, IOException {
        Map<String, List<Book>> bookMap = new HashMap<>();
        List<String> lines = Files.readAllLines(Paths.get(getClass().getClassLoader().getResource("bookk.txt").toURI()));
        lines.remove(0);
        for (String line : lines) {
            String[] source = line.split("\t");
            Book book = new Book();
            book.setPesel(source[0]);
            book.setTitle(source[1]);
            book.setPrice(Double.parseDouble(source[2]));
            List<Book> bookList = new ArrayList<>();
            bookList.add(book);
            if (bookMap.containsKey(book.getPesel())) {
                bookList.addAll(bookMap.get(book.getPesel()));
            }
            bookMap.put(book.getPesel(), bookList);
        }
        return bookMap;
    }

}
