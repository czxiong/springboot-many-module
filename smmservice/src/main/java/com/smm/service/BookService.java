package com.smm.service;

import com.smm.bean.Book;
import com.smm.bean.PageParam;

import java.util.List;

public interface BookService {

    void saveBook(Book book);

    void deleteBook(Integer id);

    void updateBook(Book book);

    Book selectBookOne(Integer id) throws Exception;

    List<Book> selectBookList() throws Exception;

    List<Book> selectBookByPage(PageParam page)throws Exception;

}
