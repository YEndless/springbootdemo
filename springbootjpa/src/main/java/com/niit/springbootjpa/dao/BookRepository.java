package com.niit.springbootjpa.dao;

import com.niit.springbootjpa.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Book 数据持久层操作接口
 */
public interface BookRepository extends JpaRepository<Book, Long> {
}
