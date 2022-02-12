Feature:Parametre ile İstenen Sayfaya Gitme


  Scenario: TC06 Eski Usul Amazona gitme

    Given kullanici amazon sayfasina gider
   # Then kullanici techproeducation sayfasına gider

  Scenario: TC07 parametre ile istenen sayfaya gitme
    Given kullanici "AmazonUrl" sayfasina gider
    And kullanici "TechproUrl" sayfasina gider
    Then kullanici "BestbuyUrl" sayfasina gider
    And kullanici sayfayi kapatir