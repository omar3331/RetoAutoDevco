# Autor: Omar Murcia Carvajal
  # Se realiza el feature para realizar la búsqueda de viaje local
  # por la opci+on alquileres de vacación en la página travelocity


Feature: Search vacation rentals travelocity page

  @tag1
  Scenario: Search vacations rentals near home in travelocity page
    Given the user in in travelocity page, access to the option travel locally
    When he search vacation rentals in "armenia" city and select one of them
    Then he can see the important information of he selected

  @tag2
  Scenario: Fail to Search vacations rentals nera home
    Given the user in in travelocity page, access to the option travel locally
    When he search without introduce a city
    Then he can see the error message "Please select a destination" in the screen