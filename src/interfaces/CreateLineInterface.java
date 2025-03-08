package interfaces;

import component.Port;
import component.Shape;

public interface CreateLineInterface {
    public Shape createLine(Port startPort, Port endPort);
}