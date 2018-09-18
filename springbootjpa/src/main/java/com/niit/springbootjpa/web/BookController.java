package com.niit.springbootjpa.web;

import com.niit.springbootjpa.entity.Book;
import com.niit.springbootjpa.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Book 控制层
 */
@Controller
@RequestMapping(value = "/book")
public class BookController {

    private static final String BOOK_FORM_PATH_NAME = "bookForm";
    private static final String BOOK_LIST_PATH_NAME = "bookList";
    private static final String REDIRECT_TO_BOOK_URL = "redirect:/book";

    @Resource
    BookService bookService;

    /**
     * 获取 Book 列表
     * 处理 "/book" 的 GET 请求，用来获取 Book 列表
     */
    @GetMapping()
    public String getBookList(ModelMap map) {
        map.addAttribute("bookList",bookService.findAll());
        return BOOK_LIST_PATH_NAME;
    }

    /**
     * 获取创建 Book 表单
     */
    @GetMapping(value = "/create")
    public String createBookForm(ModelMap map) {
        map.addAttribute("book", new Book());
        map.addAttribute("action", "create");
        return BOOK_FORM_PATH_NAME;
    }

    /**
     * 创建 Book
     * 处理 "/book/create" 的 POST 请求，用来新建 Book 信息
     * 通过 @ModelAttribute 绑定表单实体参数，也通过 @RequestParam 传递参数
     */
    @PostMapping(value = "/create")
    public String postBook(@ModelAttribute Book book) {
        bookService.insertByBook(book);
        return REDIRECT_TO_BOOK_URL;
    }

    /**
     * 获取更新 Book 表单
     *    处理 "/book/update/{id}" 的 GET 请求，通过 URL 中的 id 值获取 Book 信息
     *    URL 中的 id ，通过 @PathVariable 绑定参数
     */
    @GetMapping(value = "/update/{id}")
    public String getUser(@PathVariable Long id, ModelMap map) {
        map.addAttribute("book", bookService.findById(id));
        map.addAttribute("action", "update");
        return BOOK_FORM_PATH_NAME;
    }

    /**
     * 更新 Book
     * 处理 "/update" 的 PUT 请求，用来更新 Book 信息
     */
    @PutMapping(value = "/update")
    public String putBook(@ModelAttribute Book book) {
        bookService.update(book);
        return REDIRECT_TO_BOOK_URL;
    }

    /**
     * 删除 Book
     * 处理 "/book/{id}" 的 DELETE 请求，用来删除 Book 信息
     */
    @PostMapping(value = "/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookService.delete(id);
        return REDIRECT_TO_BOOK_URL;
    }

}
