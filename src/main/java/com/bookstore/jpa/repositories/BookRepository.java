package com.bookstore.jpa.repositories;

import com.bookstore.jpa.models.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.awt.print.Book;
import java.util.List;
import java.util.UUID;

public interface BookRepository extends JpaRepository<BookModel, UUID> {

    BookModel findBookModelTitle(String title);

    @Query(value = "SELECT * FROM tb_book WHERE publisher_id =:id", nativeQuery = true )
    List<BookModel> findBooksByPublisher(@Param("id") UUID id);

}
