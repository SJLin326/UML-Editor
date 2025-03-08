package interfaces;

import component.Shape;
import component.basicObject.ClassObject;

public class ClassObjectStrategy implements CreateObjectInterface {
    @Override
    public Shape createObject(int x, int y) {
        return new ClassObject(x, y);
    }
}