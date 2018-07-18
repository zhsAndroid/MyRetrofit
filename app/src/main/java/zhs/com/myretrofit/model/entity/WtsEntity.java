package zhs.com.myretrofit.model.entity;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Zhs on 2017/10/17.时间类
 */

public class WtsEntity implements Serializable {
    ArrayList<Integer> days;

    int start_time;

    int end_time;

    public ArrayList<Integer> getDays() {
        return days;
    }

    public void setDays(ArrayList<Integer> days) {
        this.days = days;
    }

    public int getStart_time() {
        return start_time;
    }

    public void setStart_time(int start_time) {
        this.start_time = start_time;
    }

    public int getEnd_time() {
        return end_time;
    }

    public void setEnd_time(int end_time) {
        this.end_time = end_time;
    }
}
