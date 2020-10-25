package puzzle15;

import java.util.ArrayList;

/**
 * Created by Hodei Eceiza
 * Date: 10/25/2020
 * Time: 22:13
 * Project: puzzle15
 * Copyright: MIT
 */
public class ImageData {
   private ArrayList<ImagePath> imagePath=new ArrayList<>();

    ImageData(){
createBase();
    }
    ImageData(String imagePath,String name){
        setImagePath(new ImagePath(imagePath,name));
    }
    public ArrayList<ImagePath> getImageList() {
        return imagePath;
    }
    public void setImagePath(ImagePath created){
        imagePath.add(created);
    }
    private void createBase(){
        setImagePath(new ImagePath("puzzle15Draw.jpg","classic"));
        setImagePath(new ImagePath("countryside.jpg","landscape"));
        setImagePath(new ImagePath("https://media-exp1.licdn.com/dms/image/C4E03AQE88gdGS7iRcg/profile-displayphoto-shrink_400_400/0?e=1608768000&v=beta&t=vyTqYxYzmAYDrzkgQ5YBL6XyJejLI-vto7TK1SsEKz8","HodeiFromNet"));
        setImagePath(new ImagePath("https://media-exp1.licdn.com/dms/image/C4E03AQFLn250WvzsqA/profile-displayphoto-shrink_400_400/0?e=1608768000&v=beta&t=C4nmzM628lxwWtCDGu-ifMaZoaKnsNLSY9kF8pW2B-g","JohanFromNet"));
        setImagePath(new ImagePath("abrain.jpg","brain"));
        setImagePath(new ImagePath("pngBrain.png","pngBrain"));
    }

}
