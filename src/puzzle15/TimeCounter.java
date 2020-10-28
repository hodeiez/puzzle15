package puzzle15;

import javafx.application.Platform;
import javafx.scene.control.Label;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Hodei Eceiza
 * Date: 10/27/2020
 * Time: 20:45
 * Project: puzzle15
 * Copyright: MIT
 */
public class TimeCounter {
private Timer timer;
private TimerTask task;
private int timeStart =0;
private String showTime;


    public String getShowTime() {
        return showTime;
    }

    public void runTimer(Label timerLabel,boolean stop){
    timer = new Timer();
          timer.scheduleAtFixedRate(new TimerTask(){

        @Override
        public void run() {
            timeStart++;

            Platform.runLater(
                    new Runnable() {
                        public void run() {
                          timerLabel.setText(String.format("H:%d M:%d S:%d", timeStart /3600, (timeStart /60)%60, timeStart %60));
                        }
                    }
            );
        }
    },0, 1000);
          if(stop){
              timeStart =0;
              timer.cancel();
              timer.purge();}
        //timer.scheduleAtFixedRate(task,0,1000);

    }

}
