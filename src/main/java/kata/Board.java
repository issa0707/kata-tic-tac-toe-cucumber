package kata;

import java.util.ArrayList;
import java.util.List;


public class Board {


    // ["1", "2", "3", "4", "5", "6", "7", "8", "9"]
    // acc  , current => collect : allAll
    // []
    // []                , ["1","2","3"]     => ["1", "2", "3"]
    // ["1", "2", "3"]   , ["4","5","6"]     => ["1", "2", "3", "4", "5", "6"]
    // ["1", "2", "3","4", "5", "6"], ["7","8","9"]     =>
    List<String> fields;

    public Board(List<List<String>> boardRepresentation) {

        // Arrays
        // - collect, tolist, join ...
        //   - Collectors.
        // - dropWhile
        // - flatMap
        // - forEach
        // - reduce
        // - mapmulti -> dans l'autre sens?
        this.fields = boardRepresentation.stream().reduce(new ArrayList<>(),
                (List<String> acc, List<String> current) -> {
                    acc.addAll(current);
                    return acc;
                });
    }

    // ✅ - extract var : joeurX.equals("X" 👈 )
    // ✅ - move line up
    // ✅ - extract method
    // ✅ - inline variable
    // ✅ - joueurX -> field
    // ✅ - renommer les variables en anglais pour cohérence
    // ❌ - 2eme boucle renommage
    // - Extraire une méthode pour déterminer qui joue
    public void playerPlays(int fieldNumber) {
        int indexOfMyList = fieldNumber - 1;

        // currentPlayerSymbol()?
        // computeCurrentPlayerSymbol()?
        fields.set(indexOfMyList, currentPlayerSymbol());
    }

    private String currentPlayerSymbol() {
        int xCount = countSymbol("X");
        int oCount = countSymbol("O");

        if (xCount > oCount) {
            return "O";
        } else if (xCount < oCount) {
            return "X";
        }
        // Si égalité : premier joueur
        return "X";
    }

    private int countSymbol(String playerSymbol) {
        int count = 0;
        for (String field : fields) {
            if (field.equals(playerSymbol)) {
                count++;
            }
        }
        return count;

        // 👉 Collapse loop with stream count
        //  return (int) fields.stream()
        //            .filter(field -> field.equals(playerSymbol))
        //            .count();
    }

    public boolean isEndOfGame() {
        return false;
    }

    public List<List<String>> listRepresentation() {
        // Arrays
        // - collect, tolist, join ...
        //   - Collectors.
        // - dropWhile
        // - flatMap
        // - forEach
        // - reduce
        // - mapmulti -> dans l'autre sens? ==> non

        // protonpack
        // vavr

        List<List<String>> initialAcc = new ArrayList<>();
        initialAcc.add(new ArrayList<>());
        this.fields.forEach(s -> {
            int size = initialAcc.size();
            List<String> row = initialAcc.get(size - 1); // getLastElement()

            if (row.size() == 3) {
                row = new ArrayList<>();
                initialAcc.add(row);
            }
            row.add(s);
        });
        return initialAcc;
    }
}
