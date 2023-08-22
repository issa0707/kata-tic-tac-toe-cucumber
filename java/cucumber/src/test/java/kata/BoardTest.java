package kata;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BoardTest {

//- Board.listRepresentation() => List<List<String>>
//- Test unitaire : empty board => 1,2,3,4,5,6,7,8,9
//- Play X => changer la représentation en reflétant le board
//- Board::isEndOfGame()

    @Test
    void test_1692723123584() {
        var board = new Board(List.of(
                List.of("1", "2", "3"),
                List.of("4", "5", "6"),
                List.of("7", "8", "9")
        ));
        var listRepresentation = board.listRepresentation();
        assertThat(listRepresentation).isEqualTo(List.of(
                List.of("1", "2", "3"),
                List.of("4", "5", "6"),
                List.of("7", "8", "9")
        ));
    }


    @Test
    void test_1692723123584d() {
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
