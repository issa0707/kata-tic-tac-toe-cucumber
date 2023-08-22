package kata;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class BoardTest {

    //- Board.listRepresentation() => List<List<String>>
    //- Test unitaire : empty board => 1,2,3,4,5,6,7,8,9
    //- Play X => changer la représentation en reflétant le board
    //- Board::isEndOfGame()
    @Nested
    public class Representation_of {
        @Test
        void empty_board() {
            var board = emptyBoard();
            var listRepresentation = board.listRepresentation();
            assertThat(listRepresentation).isEqualTo(List.of(
                    List.of("1", "2", "3"),
                    List.of("4", "5", "6"),
                    List.of("7", "8", "9")
            ));
        }

        @Test
        void initial_board() {
            var board = new Board(List.of(
                    List.of("1", "2", "3"),
                    List.of("4", "X", "6"),
                    List.of("7", "8", "9")
            ));
            var listRepresentation = board.listRepresentation();
            assertThat(listRepresentation).isEqualTo(List.of(
                    List.of("1", "2", "3"),
                    List.of("4", "X", "6"),
                    List.of("7", "8", "9")
            ));
            // Choix de la structure interne
            // Quelles caractéristiques on cherche?
            //
            // Liste à un niveau
            // ["1", "2", "3", "4", "5", "6", "7", "8", "9"]
            // Modification assez facile
            // - constructeur : convertir list[][] -> list[]
            // - jouer à position 5 : list[4] = "X"
            // - format de sortie : -> partitionner par 3
            //
            // Représentation actuelle
            // [
            //   ["1","2","3"],
            //   ["4","5","6"],
            //   ["7","8","9"],
            // ]
            // - constructeur : gratuit (clonage) -> liste mutable?
            // - jouer à position 5
            //   - convertir : en i = 1, j = 1
            //   - list[i][j] = "X"
            // - format de sortie : gratuit
            // - PLus facile à se représenter pour un humain
        }
    }

    @Nested
    public class Player_plays {

        @Test
        void X_on_non_taken_field_1() {
            var board = emptyBoard();
            board.playerPlays(1);
            assertThat(board.listRepresentation())
                    .isEqualTo(List.of(
                            List.of("X", "2", "3"),
                            List.of("4", "5", "6"),
                            List.of("7", "8", "9")
                    ));
        }
    }

    @Nested
    public class End_of_Game {
        @Test
        void when_empty_board() {
            Board board = emptyBoard();
            assertThat(board.isEndOfGame()).isFalse();
        }
    }

    private static Board emptyBoard() {
        return new Board(List.of(
                List.of("1", "2", "3"),
                List.of("4", "5", "6"),
                List.of("7", "8", "9")
        ));
    }
}


//    @ParameterizedTest
//    @org.junit.jupiter.params.provider.CsvSource(
//            value = {"1|[['X','2','3'],['4','5','6'],['7','8','9']]"}, delimiter = '|'
//    )
//    void test_1692729241802(Integer field,List<List<String>> expectedRepresentation) {
//        var board = new Board(List.of(
//                List.of("1", "2", "3"),
//                List.of("4", "5", "6"),
//                List.of("7", "8", "9")
//        ));
//        board.playerPlays(1);
//        assertThat(board.listRepresentation())
//                .isEqualTo(expectedRepresentation);
//    }
