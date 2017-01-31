package za.co.justinslade.ormexample.entities;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;


@Entity
public class Author {
    @Id(autoincrement = true)
    private Long id;
    private String name;

    @Generated(hash = 1310344436)
    public Author(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    @Generated(hash = 64241762)
    public Author() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
