package codeDesign.factory2;

// 具体工厂
public class BroomFactory extends VehicleFactory {

    @Override
    public Moveable create() {
        return new Broom();
    }
}
