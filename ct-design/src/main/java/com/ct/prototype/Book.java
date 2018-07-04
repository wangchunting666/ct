package com.ct.prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Herdsric-M-003 on 2018/7/4.
 */
public class Book implements Cloneable{
    private String title;
    private ArrayList<String> image = new ArrayList<>();
    public Book(){super();}
    /*
    //浅拷贝
    @Override
    protected Book clone() {
        try {
            Book book = (Book) super.clone();
            return book;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    */
    //深拷贝
    @Override
    protected Book clone() {
        try {
            Book book = (Book) super.clone();
            book.image = (ArrayList<String>) this.image.clone();
            return book;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setImage(ArrayList<String> image) {
        this.image = image;
    }

    public List<String> getImage() {
        return image;
    }

    public void showBook(){
        System.out.println("---------------------start---------------------");
        System.out.println("title:"+title);
        for (String s:image){
            System.out.println("image name:"+s);
        }
        System.out.println("---------------------end---------------------");
    }

    public static void main(String[] args) {
        Book book1 = new Book();
        book1.setTitle("book1");
        book1.getImage().add("image1");
        book1.showBook();

        Book book2 = book1.clone();
        book2.showBook();

        book2.setTitle("book2");
        book2.showBook();
        book1.showBook();

        book2.getImage().add("image2");
        book2.showBook();
        book1.showBook();
    }
}
