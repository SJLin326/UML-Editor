package interfaces;

import component.Port;
import component.Shape;
import component.Line.GeneralizationLine;

public class GeneralizationLineStrategy implements CreateLineInterface {
    @Override
    public Shape createLine(Port startPort, Port endPort) {
        return new GeneralizationLine(startPort, endPort);
    }
}