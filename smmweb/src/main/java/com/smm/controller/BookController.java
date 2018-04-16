package com.smm.controller;

import com.smm.bean.Book;
import com.smm.bean.PageParam;
import com.smm.bean.R;
import com.smm.service.BookService;
import com.smm.util.ResultUtil;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

@RestController
@RequestMapping("book")
public class BookController {

    private static final Logger log = LoggerFactory.getLogger(BookController.class);

    @Resource
    private BookService bookService;

    @PostMapping
    @ApiOperation(value = "添加书籍")
    public R saveBook(@RequestBody Book book){
        book.setPublishTime(new Date());
        bookService.saveBook(book);
        return ResultUtil.ok();
    }

    @DeleteMapping(value = "{id}")
    @ApiOperation(value = "删除书籍",notes = "根据id删除书籍")
    public R deleteBook(@PathVariable("id") Integer id){
        bookService.deleteBook(id);
        return ResultUtil.ok();
    }

    @PutMapping
    @ApiOperation(value = "修改书籍")
    public R updateBook(@RequestBody Book book){
        book.setPublishTime(new Date());
        bookService.saveBook(book);
        return ResultUtil.ok();
    }

    @GetMapping(value = "{id}")
    @ApiOperation(value = "查询单个书籍",notes = "根据id查询单个书籍")
    public R selectBookOne(@PathVariable("id") Integer id) throws Exception{
        return ResultUtil.ok(bookService.selectBookOne(id));
    }

    @GetMapping
    @ApiOperation(value = "查询所有书籍")
    public R selectBookList() throws Exception{
        return ResultUtil.ok(bookService.selectBookList());
    }

    @PostMapping(value = "/page")
    @ApiOperation(value = "分页排序查询书籍")
    public R selectBookByPage(@RequestBody  PageParam pageParam)throws Exception{
        if(StringUtils.isBlank(pageParam.getOrderType())){
            pageParam.setOrderType("ASC");
        }
        if(StringUtils.isBlank(pageParam.getOrderValue())){
            pageParam.setOrderValue("id");
        }
        pageParam.setPageNo(pageParam.getPageNo()-1);
        return ResultUtil.ok(bookService.selectBookByPage(pageParam));
    }


}
