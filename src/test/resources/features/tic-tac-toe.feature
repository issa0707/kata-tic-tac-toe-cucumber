Feature: tic-tac-toe game
  The rules of the tic tac toe game are the following:

  * a game is over when all fields are taken
  * a game is over when all fields in a column are taken by a player
  * a game is over when all fields in a row are taken by a player
  * a game is over when all fields in a diagonal are taken by a player
  * ✅⚠️ a player can take a field if not already taken
  * ✅⚠️ players take turns taking fields until the game is over
  * ✅⚠️ there are two player in the game (X and O)

  TODO list :
  - assertion : comparer des boards

  Scenario: Play on non taken field
    Given this board
      | 1 | 2 | 3 |
      | 4 | 5 | 6 |
      | 7 | 8 | 9 |
#    And it's the turn of player X
    When it play on cell 5
    Then the board is now
      | 1 | 2 | 3 |
      | 4 | X | 6 |
      | 7 | 8 | 9 |
    And it's not the end of game.

  Scenario: O plays after X
    Given this board
      | 1 | 2 | 3 |
      | 4 | X | 6 |
      | 7 | 8 | 9 |
    When it play on cell 7
    Then the board is now
      | 1 | 2 | 3 |
      | 4 | X | 6 |
      | O | 8 | 9 |
    And it's not the end of game.


  Scenario: Player O tries to play on a taken field
    Given this board
      | 1 | 2 | 3 |
      | 4 | X | 6 |
      | 7 | 8 | 9 |
    When it play on cell 5
    Then the board is now
      | 1 | 2 | 3 |
      | 4 | X | 6 |
      | O | 8 | 9 |
    And it's not the end of game.