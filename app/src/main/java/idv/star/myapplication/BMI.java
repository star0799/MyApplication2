package idv.star.myapplication;

import java.io.Serializable;

/**
 * Created by STAR on 2015/7/5.
 */
public class BMI implements Serializable{
    private double height,weight;
    public BMI(){
    }

    public BMI(double height,double weight) {
        this.height = height;
        this.weight=weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
