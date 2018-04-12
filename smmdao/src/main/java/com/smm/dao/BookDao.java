package com.smm.dao;

import com.smm.bean.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BookDao extends JpaRepository<Book,Integer>,JpaSpecificationExecutor<Book> {

}
