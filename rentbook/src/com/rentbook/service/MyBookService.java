package com.rentbook.service;

import com.rentbook.dao.imp.MyOperateBook;
import com.rentbook.dao.imp.MyOperateRecords;
import com.rentbook.entity.Book;
import com.rentbook.entity.Record;

import java.util.List;

public class MyBookService {
    private MyOperateBook myOperateBook=new MyOperateBook();


    public List<Book> getBooks(){
        return myOperateBook.getAllBooks();
    }
    public Book getBook(String id){
        return myOperateBook.findBookById(id);
    }

    /**
     * 同步？？
     * @param record
     * @return
     */

}
