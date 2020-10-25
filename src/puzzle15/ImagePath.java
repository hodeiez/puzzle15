package puzzle15;

/**
 * Created by Hodei Eceiza
 * Date: 10/25/2020
 * Time: 22:04
 * Project: puzzle15
 * Copyright: MIT
 */
public class ImagePath {
    String pathString;
    String name;
ImagePath(String pathString,String name){
    this.pathString=pathString;
    this.name=name;
}
    public String getPathString() {
        return pathString;
    }

    public void setPathString(String pathString) {
        this.pathString = pathString;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
