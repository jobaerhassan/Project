package com.example.tab_layout.fetchingFromApi;

public class ItemForApi {

        private long id;
        private String title,desc,imgLink;

        public ItemForApi(long id, String title, String desc, String imgLink) {
            this.id = id;
            this.title = title;
            this.desc = desc;
            this.imgLink= imgLink;
        }

        // Getters and setters for the fields

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImgLink() {
        return imgLink;
    }

    public void setImgLink(String imgLink) {
        this.imgLink = imgLink;
    }
}
