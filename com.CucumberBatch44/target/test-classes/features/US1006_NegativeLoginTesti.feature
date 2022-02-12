Feature: US1006 Negatif Login Testi


  Scenario: TC09 yanlis username,dogru sifre ile giris yapilamaz
    Given kullanici "HMYCUrl" sayfasina gider
    Then login linkine Tiklanir
    And kullanici username olarak "HMYCWrongUserName" girer
    Then kullanici password olarak "HMYCValidUserPas" girer
    And kullanici "login" butonuna basar
    Then giris yapilmadigi test eder
    And  kullanici sayfayi kapatir

  Scenario: TC10 dogru username, yanlis sifre ile giris yapilamaz
    Given kullanici "HMYCUrl" sayfasina gider
    Then login linkine Tiklanir
    And kullanici username olarak "HMYCValidUserid" girer
    Then kullanici password olarak "HMYCWrongUserPass" girer
    And kullanici "login" butonuna basar
    Then giris yapilmadigi test eder
    And  kullanici sayfayi kapatir

  Scenario: TC11 yanlis username, yanlis sifre ile giris yapilamaz

  Scenario: TC10 dogru username, yanlis sifre ile giris yapilamaz
    Given kullanici "HMYCUrl" sayfasina gider
    Then login linkine Tiklanir
    And kullanici username olarak "HMYCWrongUserName" girer
    Then kullanici password olarak "HMYCWrongUserPass" girer
    And kullanici "login" butonuna basar
    Then giris yapilmadigi test eder
    And  kullanici sayfayi kapatir