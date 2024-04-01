package com.pisarenko.service;

import com.pisarenko.connector.BookServiceConnector;
import com.pisarenko.model.Book;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class BookService {

    @Value("${book-service.url}")
    private String bookServiceUrl;

    private RestTemplate restTemplate;
    private BookServiceConnector bookServiceConnector;

    public BookService(RestTemplate restTemplate, BookServiceConnector bookServiceConnector) {
        this.restTemplate = restTemplate;
        this.bookServiceConnector = bookServiceConnector;
    }

    public List<Book> getAllBooksByFeign() {
        return bookServiceConnector.getAllBooksList();
    }

    public String getAllBooksByRestTemplate() {
        return restTemplate.getForObject(bookServiceUrl+"/data", String.class);
    }
}
