package features;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TicTacToeStepdefs {
    private Board board;

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
        assertEquals( formatBoard(expectedBoardRepresentation),formatBoard(board));
    }
    private String formatBoard(Board board) {
        return board.listRepresentation();
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


    static class Board{

        public Board(List<List<String>> boardRepresentation) {

        }

        public void setPlayersTurnToX() {

        }

        public void playerPlays() {

        }

        public void playerPlays(int fieldNumber) {

        }

        public Boolean isEndOfGame() {
            return null;
        }

        public String listRepresentation() {
            return null;
        }
    }
}
