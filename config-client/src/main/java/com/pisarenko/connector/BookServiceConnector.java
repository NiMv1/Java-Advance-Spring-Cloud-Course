package com.pisarenko.connector;

import com.pisarenko.config.FeignConfig;
import com.pisarenko.model.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(
        name = "book-service",
        url = "${book-service.url}",
        configuration = FeignConfig.class
)
public interface BookServiceConnector {

    @GetMapping("/show")
    List<Book> getAllBooksList();
}
