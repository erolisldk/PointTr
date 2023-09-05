@us01

Feature: US01 Api dogrulama testleri

  Scenario: US01 API kullanarak kayitli kisiler olusturun ve dogrulayin.

    Given Kullanici path params olusturur..
    And   Kullanici expected data olusturur.
    When  Kullanici request gonderir response alir.
    And   Kullanici kayitlari dogrular.


  Scenario: US01 Swagger dokumani kullanarak tüm kayit bilgilerini alin ve dogrulayin

    Given Swagger dokumaninda gerekli bilgiler bulunmamaktadir
