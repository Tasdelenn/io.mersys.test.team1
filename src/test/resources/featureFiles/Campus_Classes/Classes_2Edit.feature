Feature: Classes Functionality

  @Classes
  Scenario: Edit A Class

    #Given Login to Campus
    Given Click on the element in the left Nav
      | setupOne    |
      | schoolSetup |
      | classes     |

    When Sort elements by created time

    And Click on the element in the Dialog
      | editButton |

    And User sending the keys in Dialog content
      | nameInput | TS Batch 20 Team1 |
      | shortName | B20 T1            |

    And Click on the element in the Form Content
      | gradeLevel             |
      | selectGradeLevel       |
      | classTeacher           |
      | selectTeacher          |
      | schoolLocation         |
      | selectSchoolLocation   |
      | schoolDepartment       |
      | selectSchoolDepartment |
      | schoolSection          |
      | selectSchoolSection    |

    And Click on the element in the Dialog content
      | active     |
      | saveButton |

    Then Success message should be displayed

#    When Make maximum the number of the element (size) in the page
#    And Find the just added item in to the page without search
#    And Find the just added item in to the page without search
