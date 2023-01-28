Feature: Classes Functionality

  @Classes
  Scenario: Delete A Already Edited Class

    #Given Login to Campus
    Given Click on the element in the left Nav
      | setupOne    |
      | schoolSetup |
      | classes     |

    When Sort elements by created time

    And Click on the element in the Dialog
      | deleteButton |

    And Click on the element in the Dialog content
      | deleteDialogBtn |

    Then Success message should be displayed

#    ÖRNEK LİST OLUŞTURMA:
    And Make maximum the number of the element (size) in the page
    And Find the just added item in to the page without search
