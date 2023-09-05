@us01

Feature: US01 DB dogrulama testleri

  Scenario Outline: US01 DB'de SSN numaralarini dogrulama

    Given Kullanici database baglantisi olusturur
    When  Kullanici sorguyu db'ye gonderir ve "<ssn>" ssn numarali kullanici verilerini alir
    Then  Kullanici db verisini dogrular "<ssn>"

    Examples: test data
      | ssn |
      |123-45-6789|

  Scenario Outline: US02 DB'de e-mail dogrulama

    Given Kullanici database baglantisi olusturur
    When  Kullanici sorguyu db'ye gonderir ve kullanici verilerini "<login>" girisiyle alir
    When  Kullanici db verisini dogrularr "<email>"

  Examples:
      |email|login|
      |kurt89@hotmail.com|kurt890|
