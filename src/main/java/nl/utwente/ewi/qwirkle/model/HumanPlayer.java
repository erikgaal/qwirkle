package nl.utwente.ewi.qwirkle.model;

import nl.utwente.ewi.qwirkle.client.UI.IUserInterface;

import java.util.List;
import java.util.Map;

public class HumanPlayer extends Player {
    public HumanPlayer(IUserInterface ui, String name) throws PlayerNameInvalidException {
        super(ui, name);
    }

    @Override
    public Board.MoveType getMoveType() {
        return ui.getMoveType(this);
    }

    @Override
    public List<Tile> getTradeMove() {
        return ui.getMoveTrade(this);
    }

    @Override
    public Map<Coordinate, Tile> getPutMove() {
        return ui.getMovePut(this);
    }

    @Override
    public String toString() {
        return null;
    }
}