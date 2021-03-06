package nl.utwente.ewi.qwirkle.server;

import nl.utwente.ewi.qwirkle.net.IProtocol;

/**
 * Thrown when a game specific error occurs. This class is made to be extended by more specific Exceptions.
 */
public class QwirkleException extends Exception {
    private IProtocol.Error error;

    public QwirkleException(IProtocol.Error error) {
        super();
        this.error = error;
    }

    public IProtocol.Error getError() {
        return error;
    }
}
