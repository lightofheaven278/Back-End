package ra;

import ra.Circle;

public class Cylinder extends Circle {
    private float height;

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void calVolume(float height, float radius){
        System.out.printf("The volume of cylinder is: %f", height*2*Math.PI*radius);
    };

}
