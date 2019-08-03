package az.com.app.service.impl;

import az.com.app.connection.impl.DbConnection;
import az.com.app.model.Book;
import az.com.app.service.IBookService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class IBookServiceImpl implements IBookService {

    public static final String BOOK_SELECT_SQL = "SELECT * FROM elibrary.Book";

    private DbConnection connection = new DbConnection();

    public List<Book> fetchAllBooks() throws SQLException {
        List<Book> bookList = new ArrayList<Book>();
        if (connection.connect()) {
            Statement statement = connection.getStatement();
            ResultSet resultSet = statement.executeQuery(BOOK_SELECT_SQL);
            while (resultSet.next()) {
                int bookId = resultSet.getInt(1);
                String bookTitle = resultSet.getString(2);
                String bookAuthor = resultSet.getString(3);
                Book book = new Book(bookId, bookTitle, bookAuthor);
                bookList.add(book);
            }
        }
        return bookList;
    }
}
