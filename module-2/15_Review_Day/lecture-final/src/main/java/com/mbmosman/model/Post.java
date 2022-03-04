package com.mbmosman.model;

import java.time.LocalDate;

public class Post {

        private int id;
        private String title;
        private String text;
        private LocalDate createDate;

        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        public String getTitle() {
                return title;
        }

        public void setTitle(String title) {
                this.title = title;
        }

        public String getText() {
                return text;
        }

        public void setText(String text) {
                this.text = text;
        }

        public LocalDate getCreateDate() {
                return createDate;
        }

        public void setCreateDate(LocalDate createDate) {
                this.createDate = createDate;
        }
}
