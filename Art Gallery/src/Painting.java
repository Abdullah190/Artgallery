import java.util.Random;
import java.util.Scanner;

public class Painting {

    private String painting_id;
    private String artist_id;
    private int costprice;
    private String status;
    private String p_name;
    private String Style;

    //constructors

    public Painting()
    {
        painting_id=" ";
        artist_id=" ";
        costprice=0;
        status=" ";
        p_name=" ";
        Style=" ";
    }

    public Painting(String id1,String Artist_id1,int costprice1,String status1,String p_name1,String Style1)
    {
        painting_id=id1;
        artist_id=Artist_id1;
        costprice=costprice1;
        status=status1;
        p_name=p_name1;
        Style=Style1;
    }


    //setters

    public void setPainting_id(String painting_id1)
    {
        painting_id=painting_id1;
    }

    public void setArtist_idP(String artist_id1) {
        artist_id = artist_id1;
    }

    public void setCostprice(int costprice1) {
        costprice = costprice1;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setStyle(String style) {
        Style = style;
    }
// getters


    public String getArtist_id2() {
        return artist_id;
    }

    public int getCostprice() {
        return costprice;
    }

    public String getPainting_id() {
        return painting_id;
    }

    public String getP_name() {
        return p_name;
    }

    public String getStatus() {
        return status;
    }

    public String getStyle() {
        return Style;
    }


}
