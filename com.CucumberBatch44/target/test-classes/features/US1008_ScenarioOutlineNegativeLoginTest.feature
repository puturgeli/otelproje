Feature: US1008 Scenario Outline Kullanarak Farkli Degerlerle Negatif Login Testi

@hotel1
  Scenario Outline:TC13 farklı kullanıcı adı ve password

    Given kullanici "HMYCUrl" sayfasina gider
    Then login linkine Tiklanir
    And scenario outline'dan username olarak "<username>" yazar
    Then scenario outline'dan password olarak "<password>" yazar
    And kullanici "login" butonuna basar
    Then giris yapilmadigi test eder
    And kullanici sayfayi kapatir






    Examples:
    |username| |password|
    |MANAGER | |MANAGER1|
    |MANager | |manager1|
    |Man ager| |MANager1|
    |manAger1| |MAN ager*1|
