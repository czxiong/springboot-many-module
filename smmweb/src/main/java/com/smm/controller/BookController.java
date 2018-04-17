package com.smm.controller;

import com.smm.bean.Book;
import com.smm.bean.PageParam;
import com.smm.bean.R;
import com.smm.service.BookService;
import com.smm.util.ResultUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.java.Log;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

@RestController
@RequestMapping("book")
@Log
public class BookController {

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
    public R deleteBook(@ApiParam(name = "id",value = "主键id",required = true) @PathVariable("id") Integer id){
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
    public R selectBookOne(@ApiParam(name = "id",value = "主键id",required = true) @PathVariable("id") Integer id) throws Exception{
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
