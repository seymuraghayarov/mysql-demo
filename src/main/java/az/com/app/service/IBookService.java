package az.com.app.service;


import az.com.app.model.Book;

import java.sql.SQLException;
import java.util.List;

public interface IBookService {

    List<Book> fetchAllBooks() throws SQLException;
}
