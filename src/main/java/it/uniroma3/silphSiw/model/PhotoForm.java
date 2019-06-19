package it.uniroma3.silphSiw.model;

import org.springframework.web.multipart.MultipartFile;

public class PhotoForm {

    private String name;
    private String desc;
    private Long album_id;
    private Long photographer_id;
    private MultipartFile file;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Long getAlbum_id() {
        return album_id;
    }

    public void setAlbum_id(Long album_id) {
        this.album_id = album_id;
    }

    public Long getPhotographer_id() {
        return photographer_id;
    }

    public void setPhotographer_id(Long photographer_id) {
        this.photographer_id = photographer_id;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
