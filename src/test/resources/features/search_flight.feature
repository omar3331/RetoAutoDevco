#Autor: Omar Murcia Carvajal
  #Se realiza el feature para seleccionar un vuelo en la página travelocity

Feature: Select flights in travelocity

  @tag1
  Scenario Outline: Selecting the cheapest flight one way the next week
    Given the user is travelocity page, he select a travel between <origin> and <destiny>
    When he want the cheapest flight ticket
    Then he check if the selected flight is the "correct"

    Examples:
    |    origin   |   destiny    |
    |   medellin  |    bogota    |
    |     cali    | barranquilla |
    | Los Angeles |   Baltimore  |

  @tag2
  Scenario: Selecting the round trip
    Given the user want to select a round trip between "medellin" and "San Andres"
    When he selected the shortest flights
    Then he check both of them flights "selected"