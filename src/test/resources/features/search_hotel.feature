# Autor: Omar Murcia Carvajal
  # Se realiza el feature para realizar la búsqueda y seleccionar
  # hotel en una determinada ciudad en la página travelocity


Feature: Search hotel travelocity page

  Scenario: Search hotel in a city in the travelocity page
    Given the user is in travelocity page, search hotel in "Egypt"
    When he activate some one filters and select the hotel
    Then he can see the selected hotel
