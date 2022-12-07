Feature: Wyświetlenie się komunikatu OK. Good answer

  Jako uzytkownik
  chce moc wywolac sekwencje znakow b1/b2
  aby otrzymac komunikat OK. Good answer

  Scenario: Poprawne otrzymanie komunikatu OK. Good answer
    Given Uzytkownik znajduje sie na stronie "https://antycaptcha.amberteam.pl/exercises/exercise1"
    When Uzytkownik klika w przycik B1 lub B2 według sekwencji wyswitlonej w kolumnie Test Step
    And Uzytkownik klika w przycisk CHECK SOLUTION
    Then Uzytkownik otrzymuje informacje OK. Good answer

