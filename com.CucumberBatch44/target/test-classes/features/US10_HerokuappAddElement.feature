Feature:  US10 Herokuapp sayfasında add butonu testi

  Scenario: TC15 sonradan görülen elemanlar çalışmalı

  Given  kullanici "HerokuappElementUrl" sayfasina gider
    #https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
  When  add element butonuna basar
  Then Delete butonu gorununceye kadar bekler
  And Delete butonunun gorundugunu test eder
  Then Delete butonuna basarak butonu siler
    And 5 saniye bekler
  And  kullanici sayfayi kapatir

    #“Add Element” butona basin
    #“Delete” butonu gorunur oluncaya kadar bekleyin
    #“Delete” butonunun gorunur oldugunu test edin
    #Delete butonuna basarak butonu silin
    #Delete butonunun gorunmedigini test edin


