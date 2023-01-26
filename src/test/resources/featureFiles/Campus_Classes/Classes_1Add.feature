Feature: Classes Functionality

  Scenario: Add A Class

    #Given Login to Campus
    Given Click on the element in the left Nav
      | setupOne    |
      | schoolSetup |
      | classes     |

    When Click on the element in the Dialog content
      | addButton |

    And User sending the keys in Dialog content
      | nameInput | TS Batch 20 |
      | shortName | B20         |

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
