package za.co.justinslade.ormexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.greenrobot.greendao.query.Join;
import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

import za.co.justinslade.ormexample.entities.Author;
import za.co.justinslade.ormexample.entities.Book;
import za.co.justinslade.ormexample.entities.BookDao;
import za.co.justinslade.ormexample.entities.BookGenres;
import za.co.justinslade.ormexample.entities.BookGenresDao;
import za.co.justinslade.ormexample.entities.DaoSession;
import za.co.justinslade.ormexample.entities.Genre;
import za.co.justinslade.ormexample.entities.GenreDao;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get DAO session
        DaoSession daoSession = ((MyApplication) getApplication()).getDaoSession();

        //Insert Author
        Author author = new Author();
        author.setName("JRR Tolken");
        daoSession.getAuthorDao().insert(author);

        //Insert Genre
        Genre genre = new Genre();
        genre.setName("Fantasy");
        daoSession.getGenreDao().insert(genre);

        //Insert Book
        Book book = new Book();
        book.setAuthor(author);
        book.setName("Lord of the rings");
        BookDao bookDao = daoSession.getBookDao();
        bookDao.insert(book);

        //Link book and genre

        BookGenres bookGenres = new BookGenres();
        bookGenres.setBookId(book.getId());
        bookGenres.setGenreId(genre.getId());
        daoSession.getBookGenresDao().insert(bookGenres);


        //Read by ID
        Book readBook = bookDao.load(1l);
        Author author1 = readBook.getAuthor();
        String name = readBook.getName();
        List<Genre> genres = readBook.getGenres();

        //Simple Query
        List<Book> list = bookDao.queryBuilder().where(BookDao.Properties.Name.like("%lord%")).list();

        //Query with Joins
        QueryBuilder<Book> bookQueryBuilder = bookDao.queryBuilder();
        Join bookBookGenresJoin = bookQueryBuilder.join(BookGenres.class, BookGenresDao.Properties.BookId);
        Join genreJoin = bookQueryBuilder.join(bookBookGenresJoin, BookGenresDao.Properties.GenreId, Genre.class, GenreDao.Properties.Id);
        genreJoin.where(GenreDao.Properties.Name.eq("Fantasy"));
        List<Book> list1 = bookQueryBuilder.list();


    }
}
