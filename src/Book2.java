import java.io.Serializable;

/**
 * Created by sergey on 05.04.17.
 */
public class Book2 implements Serializable {
    private String author;
    private String title;
    private int year;
    private String isbn;
    private int pagesNum;
    private static long serialVersionUID = 2L;

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public Book2(String author, String title, int year, String isbn) {
        this.author = author;
        this.title = title;
        this.year = year;
        this.isbn = isbn;
    }

    @Override
    public int hashCode() {
        return isbn.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;

        if (!(obj instanceof Book2))
            return false;

        if (!this.isbn.equals(((Book2) obj).isbn))
            return false;

        return true;
    }


    public int getPagesNum() {
        return pagesNum;
    }

    public void setPagesNum(int pagesNum) {
        this.pagesNum = pagesNum;
    }

    @Override
    public String toString() {
        return author + "@" + title + "@" + year + "@" + isbn;
    }
}
