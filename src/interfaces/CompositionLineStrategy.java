package interfaces;

import component.Port;
import component.Shape;
import component.Line.CompositionLine;

public class CompositionLineStrategy implements CreateLineInterface {
    @Override
    public Shape createLine(Port startPort, Port endPort) {
        return new CompositionLine(startPort, endPort);
    }
}