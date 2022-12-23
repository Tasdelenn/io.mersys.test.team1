Feature: Document Types under Parameters Setup Functionality

  Background:
    Given Navigate to Mersys Campus
    When Enter username and password and click login button
    Then User should be login successfuly


  @Smoke @Regression @DocumentTypes
  Scenario: Add Document Types

    And Click on the element in the left Nav
      | setupOne      |
      | parameters    |
      | documentTypes |

    And Click on the element in the Dialog content
      | addButton |

    And User sending the keys in Dialog content
      | nameInput   | MuharremTR2626                  |
      | description | Muharrem Karapazar Eskişehir 26 |

    And Click on the element in the Form Content
      | switchRequired            |
      | stageSelect               |
      | selectStudentRegistration |
      | selectCertificate         |

    And Click the TAB key

    And Click on the element in the Dialog content
      | saveButton |

    Then Success message should be displayed


  @Smoke @Regression @DocumentTypes
  Scenario: Edit Document Types

    And Click on the element in the left Nav
      | setupOne      |
      | parameters    |
      | documentTypes |

    And User sending the keys in Dialog content
      | searchInput | MuharremTR2626 |

    And Click on the element in the Dialog content
      | searchButton |
      | editButton   |

    And User sending the keys in Dialog content
      | nameInput   | MuharremTR2626Edit            |
      | description | M.K. Eskisehir 26 Duzenlendi. |

    And Click on the element in the Form Content
      | switchUseCamera  |
      | stageSelect      |
      | selectEmployment |
      | selectContract   |

    And Click the TAB key

    And Click on the element in the Dialog content
      | saveButton |

    Then Success message should be displayed

  @Smoke @Regression @DocumentTypes
  Scenario: Delete Document Types

    And Click on the element in the left Nav
      | setupOne      |
      | parameters    |
      | documentTypes |

    And User delete item from Dialog
      | MuharremTR2626Edit |

    Then Success message should be displayed


  @Regression @DocumentTypesNegative
  Scenario: Negative Delete Document Types

    And Click on the element in the left Nav
      | setupOne      |
      | parameters    |
      | documentTypes |

    And User sending the keys in Dialog content
      | searchInput | MuharremTR2626Edit |

    And Click on the element in the Dialog content
      | searchButton |

    Then Verify that there is no data to display
