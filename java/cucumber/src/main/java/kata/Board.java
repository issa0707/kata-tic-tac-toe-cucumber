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

        System.out.println("");
        // this.fields = truc;
    }

    public void setPlayersTurnToX() {

    }

    public void playerPlays(int fieldNumber) {

    }

    public Boolean isEndOfGame() {
        return null;
    }

    public List<List<String>> listRepresentation() {

        // Arrays
        // - collect, tolist, join ...
        //   - Collectors.
        // - dropWhile
        // - flatMap
        // - forEach
        // - reduce
        // - mapmulti -> dans l'autre sens?

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
