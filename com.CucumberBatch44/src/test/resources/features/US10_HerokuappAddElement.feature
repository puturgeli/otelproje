Feature:  US10 Herokuapp sayfasında add butonu testi

  Scenario: TC15 sonradan görülen elemanlar çalışmalı

    Given  kullanici "HerokuappElementUrl" sayfasina gider
    #https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
     #“Add Element” butona basin
    When  add element butonuna basar
     #“Delete” butonu gorunur oluncaya kadar bekleyin
    Then Delete butonu gorununceye kadar bekler
      #“Delete” butonunun gorunur oldugunu test edin
    And Delete butonunun gorundugunu test eder
    #Delete butonuna basarak butonu silin
    Then Delete butonuna basarak butonu siler
    And 5 saniye bekler
     #Delete butonunun gorunmedigini test edin

    And  kullanici sayfayi kapatir







