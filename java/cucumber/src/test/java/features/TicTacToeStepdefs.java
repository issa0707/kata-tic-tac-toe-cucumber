package features;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import kata.Board;

import java.util.List;

import static java.util.stream.Collectors.joining;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TicTacToeStepdefs {
    private Board board;

    /**
     * <ul>
     *     <li>
     * Numbers means : non-taken field
     *     </li>
     *     <li>
     * "X" | "O" means : taken field by player
     *     </li>
     * </ul>
     * Example of board representation
     * <pre>
     * | 1 | 2 | 3 |
     * | 4 | 5 | 6 |
     * | 7 | 8 | 9 |
     * </pre>
     * <pre>
     * [
     *   ["1","2","3"],
     *   ["4","5","6"],
     *   ["7","8","9"],
     * ]
     * </pre>
     * @param boardRepresentation visual representation of a tic tac toe board
     */
    @Given("this board")
    public void thisBoard(List<List<String>> boardRepresentation) {
        this.board = new Board(boardRepresentation);
    }

    @And("it's the turn of player X")
    public void itSTheTurnOfPlayerX() {
        board.setPlayersTurnToX();
    }

    @When("it play on cell {int}")
    public void itPlayOnCell(int fieldNumber) {
        board.playerPlays(fieldNumber);
    }

    @Then("the board is now")
    public void theBoardIsNow(List<List<String>> expectedBoardRepresentation) {
        assertEquals( formatBoard(expectedBoardRepresentation), formatBoard(board.listRepresentation()));
    }

    private String formatBoard(List<List<String>> board) {
        return board.stream()
                .map(rows -> rows.stream()
                        .collect(joining(" | ","| "," |")))
                .collect(joining("\n"));
    }

    @And("it's not the end of game.")
    public void itSNotTheEndOfGame() {
        Boolean endOfGame = board.isEndOfGame();
        assertEquals(false, endOfGame);
    }


}
