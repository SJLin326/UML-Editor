package interfaces;

import component.Shape;
import component.basicObject.UseCaseObject;

public class UseCaseObjectStrategy implements CreateObjectInterface {
        @Override
        public Shape createObject(int x, int y) {
            return new UseCaseObject(x, y);
        }
}