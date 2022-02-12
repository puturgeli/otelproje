Feature: US011 WebUnivercity Window Handle

@webElement
  Scenario Outline: TC16 Reusable Method ile Window Handle Testi
  Given kullanici "WebUnivercityUrl" sayfasina gider
  #1."http://webdriveruniversity.com/" adresine gidin

  #2."Login Portal" a  kadar asagi inin
  And login portal'a kadar asagi iner
  #3."Login Portal" a tiklayin
  Then Login Portal'a tiklar
  #4.Diger window'a gecin
    Then diger windowa gecer
  And "<username>" ve "<password>" kutularina deger yazdirir
  #5."username" ve  "password" kutularina deger yazdirin
  Then login butonuna basar
  #6."login" butonuna basin

  And Popup'ta cikan yazinin "validation failed" oldugunu test edin

  #7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
  Then ok diyerek sayfaya geri doner
  #8.Ok diyerek Popup'i kapatin
  And  ilk sayfaya doner
  #9.Ilk sayfaya geri donun
  Then ilk sayfaya donuldugunu test eder
  #10.Ilk sayfaya donuldugunu test edin



  Examples:
    |username||password|
    |Mehmet  ||Donat   |
