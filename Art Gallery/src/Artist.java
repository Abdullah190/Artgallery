public class Artist {


    private String artist_id;
    private String name;
    private String country;
    private String expertise;

    public Artist()
    {
        artist_id=" ";
        name=" ";
        country=" ";
        expertise=" ";
    }

    public Artist(String artist_id1,String name1,String country1,String expertise1)
    {
        artist_id=artist_id1;
        name=name1;
        country=country1;
        expertise=expertise1;
    }


    // /setters


    public void setArtist_idA(String artist_id1) {
        artist_id = artist_id1;
    }

    public void setCountry(String country1) {
        country = country1;
    }

    public void setExpertise(String expertise1) {
        expertise = expertise1;
    }

    public void setNameA(String name1) {
        name = name1;
    }

    //getters

    public String getArtist_id1() {
        return artist_id;
    }

    public String getCountry() {
        return country;
    }

    public String getExpertise() {
        return expertise;
    }

    public String getNameA() {
        return name;
    }

    public String toString(){
        return this.artist_id +"," + this.name +"," + this.country+ "," + this.expertise +",";
    }

}

