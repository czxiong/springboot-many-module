package com.smm.controller;

import com.smm.bean.Book;
import com.smm.bean.PageParam;
import com.smm.bean.R;
import com.smm.service.BookService;
import com.smm.util.ResultUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

@RestController
@RequestMapping("book")
@Slf4j //添加日志组件 默认的logback就是基于Slf4j的，引入lombok即可使用
public class BookController {

    @Resource
    private BookService bookService;

    @PostMapping(value = "/add")
    @ApiOperation(value = "添加书籍")
    public R saveBook(@RequestBody Book book){
        book.setPublishTime(new Date());
        log.info("添加书籍参数： {}" , book);
        bookService.saveBook(book);
        return ResultUtil.ok();
    }

    @DeleteMapping(value = "del/{id}")
    @ApiOperation(value = "删除书籍",notes = "根据id删除书籍")
    public R deleteBook(@ApiParam(name = "id",value = "主键id",required = true) @PathVariable("id") Integer id){
        log.info("删除书籍参数：{}",id);
        bookService.deleteBook(id);
        return ResultUtil.ok();
    }

    @PutMapping(value = "/update")
    @ApiOperation(value = "修改书籍")
    public R updateBook(@RequestBody Book book){
        book.setPublishTime(new Date());
        log.info("修改书籍参数：{}",book);
        bookService.saveBook(book);
        return ResultUtil.ok();
    }

    @GetMapping(value = "/listone/{id}")
    @ApiOperation(value = "查询单个书籍",notes = "根据id查询单个书籍")
    public R selectBookOne(@ApiParam(name = "id",value = "主键id",required = true) @PathVariable("id") Integer id) throws Exception{
        log.info("查询单个书籍参数：{}",id);
        return ResultUtil.ok(bookService.selectBookOne(id));
    }

    @GetMapping(value = "/list")
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
        log.info("分页排序查询书籍参数：{}",pageParam);
        return ResultUtil.ok(bookService.selectBookByPage(pageParam));
    }


}
