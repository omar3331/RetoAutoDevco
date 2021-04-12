# Autor: Omar Murcia Carvajal
  # Se realiza el feature para realizar la búsqueda y seleccionar las cosas
  # para hacer en una determinada ciudad en la página travelocity

Feature: Select things to do in travelocity page

  Scenario: Select things to do in a city
    Given the user is in travelocity page, select things to do in "roma"
    When he select things to do of Attractions
    Then he can see the information of his selection