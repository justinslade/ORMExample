package za.co.justinslade.ormexample.entities;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class BookGenres {
    @Id
    private Long id;
    private Long bookId;
    private Long genreId;
}
    @Generated(hash = 493225836)
    public BookGenres(Long id, Long bookId, Long genreId) {
        this.id = id;
        this.bookId = bookId;
        this.genreId = genreId;
    }
    @Generated(hash = 1191456180)
    public BookGenres() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getBookId() {
        return this.bookId;
    }
    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }
    public Long getGenreId() {
        return this.genreId;
    }
    public void setGenreId(Long genreId) {
        this.genreId = genreId;
    }

}
