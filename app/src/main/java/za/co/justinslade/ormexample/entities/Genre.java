package za.co.justinslade.ormexample.entities;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;


@Entity
public class Genre {

    @Id(autoincrement = true)
    Long id;
    String name;
}
    @Generated(hash = 1579712615)
    public Genre(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    @Generated(hash = 235763487)
    public Genre() {
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
