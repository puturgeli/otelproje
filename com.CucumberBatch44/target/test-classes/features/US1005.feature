Feature: US1005 Positive Login Test


  @hotel
  Scenario: 
    Given kullanici "HMYCUrl" sayfasina gider
    Then login linkine Tiklanir
    And kullanici kullaniciadini girer
    Then kullanici kullanicipasword girer
    And kullanici "login" butonuna basar
    Then basarili girisyapildi yazisi gorulur
   # Then kullanici sayfayi kapatir

  Scenario:TC02 Single Room Reservation
    Given kullanici sigleRoom butonuna tiklar
    Then kullanici "2" siradaki otele tiklar
    And  kullanici checkin tarihini girer
   # Then kullanici checkOut tarihini girer
    And kullanici yetiskin sayisini secer
    Then kullanici cocuk sayisini secer
    And kullanici kredikart adini girer
    Then kullanici kredikart numarasini girer
    And kullanici kartin gecerlilik tarihini secer
    Then  kullanici kartin gecerlilik ayini secer
    And kullanici krediKart CVV numarasını yazar
    Then kullanici mesaj formuna mesaj yazar
    And Kullanici Book this room butonuna basar.
    Then kullanici basariliKayit yapildi yazasini görür
    And kullanici popupda ok butonuna basar




