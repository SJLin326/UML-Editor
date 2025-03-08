package interfaces;

import component.Port;
import component.Shape;
import component.Line.AssociationLine;

public class AssociationLineStrategy implements CreateLineInterface {
    @Override
    public Shape createLine(Port startPort, Port endPort) {
        return new AssociationLine(startPort, endPort);
    }
}