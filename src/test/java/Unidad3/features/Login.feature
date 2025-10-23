#Autor: Domingo Saavedra
#ID HDU AZURE: SEG-10
#Fecha creación: 16-10-2025
Feature: Inicio de sesion
  Como cliente del demo web shop
  deseo logearme
  para acumular puntos cuando haga compras

  @Smoke
  Scenario: despliegue modal de login
    Given el usuario se encuentra en el home
    When selecciona link log in
    Then se visualiza modal de inicio de sesion
    And caja de texto para el ingreso del mail
    And caja de texto para el ingreso del password
    And boton iniciar sesion

  @Smoke
  Scenario Outline: Error login
    Given el usuario se encuentra en el home
    And selecciona link log in
    When se ingresa mail "<mail>"
    And se ingresa password "<password>"
    And presiona boton Log in
    Then se visualiza mensaje de error "<error>"

    Examples:
      | mail  |   password    |   error     |
      | dania@algo.net | 123a56 | Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect |
      | dania@algo.net | 123a56 | Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect |


    @Smoke
    Scenario Outline: login exitoso
    Given el usuario se encuentra en el home
    And selecciona link log in
    When se ingresa mail "<mail>"
    And se ingresa password "<password>"
    And presiona boton Log in
    Then se visualiza el home del sitio
    And y se visualiza el usuario logeado

    Examples:
      | mail  |   password    |
      | dania@algo.cl | 123456 |
      | dania@algo.cl | 123456 |