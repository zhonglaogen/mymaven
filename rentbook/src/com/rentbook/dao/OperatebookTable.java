package com.rentbook.dao;

import com.rentbook.entity.Book;

import java.util.List;

public interface OperatebookTable {
    public List<Book> getAllBooks();
    public Book findBookById(String bookid);
}
