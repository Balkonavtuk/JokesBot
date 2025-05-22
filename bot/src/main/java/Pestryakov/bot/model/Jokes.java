package Pestryakov.bot.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "jokes")
@Table(name = "jokes")
public class Jokes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    public Jokes(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Jokes() {
    }

    @Column
    private String content;

    // Геттеры
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    // Сеттеры
    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
