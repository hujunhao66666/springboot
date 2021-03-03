package com.kuang.dao;

import com.kuang.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {
    int addBook(Books books);
    int deleteBook(@Param("bookID") int id);
    int updateBook(Books books);
    Books queryBook(@Param("bookID") int id);
    List<Books> queryAllBook();
    Books queryBookByName(@Param("bookName") String name);
}
