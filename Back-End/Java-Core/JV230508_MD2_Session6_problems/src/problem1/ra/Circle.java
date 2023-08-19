package ra;

public class Circle {
    private float radius;
    private float color;

    public float getRadius() {
        return radius;
    }

    public float getColor() {
        return color;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public void setColor(float color) {
        this.color = color;
    }

    public Circle() {
    }

    public Circle(float radius, float color) {
        this.radius = radius;
        this.color = color;
    }
}
