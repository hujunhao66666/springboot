package com.kuang.service;

import com.kuang.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookService {
    int addBook(Books books);
    int deleteBook( int id);
    int updateBook(Books books);
    Books queryBook(int id);
    List<Books> queryAllBook();
    Books queryBookByName(String name);
}
