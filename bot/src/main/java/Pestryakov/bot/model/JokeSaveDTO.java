package Pestryakov.bot.model;

import lombok.Data;

public class JokeSaveDTO {

        private String title;

        private String content;

    public JokeSaveDTO(String title, String content) {
        this.content = content;
        this.title = title;
    }

    public JokeSaveDTO() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
