package main.java.movie;

public class Movie {

    private String name;
    private String directedBy;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirectedBy() {
        return directedBy;
    }

    public void setDirectedBy(String directedBy) {
        this.directedBy = directedBy;
    }

    @Override
    public String toString() {
        return "Movie [name=" + name + ", directedBy=" + directedBy + "]";
    }
}
