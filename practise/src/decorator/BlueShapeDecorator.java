package decorator;

public class BlueShapeDecorator extends ShapeDecorator {
    public BlueShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        super.draw();
        System.out.println("Border Color: Blue");
    }
}
