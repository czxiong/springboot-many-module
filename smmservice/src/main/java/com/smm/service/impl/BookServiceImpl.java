package com.smm.service.impl;

import com.smm.bean.Book;
import com.smm.bean.PageParam;
import com.smm.dao.BookDao;
import com.smm.enums.ResultEnum;
import com.smm.service.BookService;
import com.smm.util.CustomException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Resource
    private BookDao bookDao;

    @Override
    public void saveBook(Book book) {
        bookDao.save(book);
    }

    @Override
    public void deleteBook(Integer id) {
        bookDao.delete(id);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.save(book);
    }

    @Override
    public Book selectBookOne(Integer id) throws Exception {
        Book book = bookDao.findOne(id);
        if(null == book){
            throw new CustomException(ResultEnum.NOT_FOUND_DATA);
        }
        return book;
    }

    @Override
    public List<Book> selectBookList() throws Exception {
        List<Book> book = bookDao.findAll();
        if(null == book || book.size() == 0){
            throw new CustomException(ResultEnum.NOT_FOUND_DATA);
        }
        return book;
    }

    @Override
    public List<Book> selectBookByPage(PageParam pageParam) throws Exception {
        Pageable pageable = null;
        if("DESC".equals(pageParam.getOrderType())){
            pageable = new PageRequest(pageParam.getPageNo(),pageParam.getPageSize(), Sort.Direction.DESC,pageParam.getOrderValue());
        }else{
            pageable = new PageRequest(pageParam.getPageNo(),pageParam.getPageSize(), Sort.Direction.ASC,pageParam.getOrderValue());
        }
        Page<Book> book = bookDao.findAll(pageable);
        if(null == book.getContent() || book.getContent().size() == 0){
            throw new CustomException(ResultEnum.NOT_FOUND_DATA);
        }
        return book.getContent();
    }
}
