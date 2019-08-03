package az.com.app.main;

import az.com.app.model.Book;
import az.com.app.service.IBookService;
import az.com.app.service.impl.IBookServiceImpl;

import java.sql.SQLException;
import java.util.List;


public class Main {
    public static void main(String[] args) throws SQLException {
        IBookService service = new IBookServiceImpl();
        List<Book> bookList = service.fetchAllBooks();

        for (Book book : bookList) {
            System.out.printf("Book  ID : %d , TITLE: %s , AUTHOR: %s \n", book.getId(), book.getTitle(), book.getAuthor());
        }
    }
}
