package nl.utwente.ewi.qwirkle.model;

import nl.utwente.ewi.qwirkle.client.GameController;
import nl.utwente.ewi.qwirkle.util.Logger;

import java.util.*;

public class DumbComputerPlayer extends Player {

    private Random rand = new Random();

    public DumbComputerPlayer(String name) {
        super(name);
    }

    @Override
    public Board.MoveType getMoveType() {
        return Board.MoveType.PUT;
    }

    @Override
    public List<Tile> getTradeMove() {
        int swap = rand.nextInt(getHand().size()) + 1;
        List<Tile> ret = getHand();
        Collections.shuffle(ret);
        for (int i = getHand().size(); i > swap; i--) {
            ret.remove(0);
        }
        return ret;
    }

    @Override
    public Map<Coordinate, Tile> getPutMove() {
        Board b = getGameController().getBoardCopy();
        List<Map<Coordinate, Tile>> moveList = new ArrayList<>();
        for (Tile t : getHand()) {
            int[] boundaries = b.getBoundaries();
            Logger.debug(boundaries[0] + " " + boundaries[1] + " " + boundaries[2] + " " + boundaries[3]);
            for (int x = boundaries[3]-1; x <= boundaries[1]+1; x++) {
                for (int y = boundaries[2]-1; y <= boundaries[0]+1; y++) {
                    Map<Coordinate, Tile> m = new HashMap<>();
                    m.put(new Coordinate(x, y), t);
                    if (b.validateMove(m)) {
                        moveList.add(m);
                    }
                }
            }
        }
        Collections.shuffle(moveList);
        return moveList.get(0);
    }

    @Override
    public String toString() {
        return "Dump Computer";
    }
}
