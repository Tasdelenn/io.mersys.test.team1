Feature: School Locations under School Setup Functionality

  @Regression @SchoolLocations @SchoolLocationsNegative
  Scenario: Add School Locations

    And Click on the element in the left Nav
      | setupOne    |
      | schoolSetup |
      | locations   |

    And Click on the element in the Dialog content
      | addButton |

    And User sending the keys in Dialog content
      | nameInput | Team1School |
      | capacity  | 35          |
      | shortName | T1S         |

    Then User should choose the location type Laboratory

    And Click on the element in the Dialog content
      | saveButton |

    Then Success message should be displayed


  @Regression @SchoolLocationsNegative
  Scenario: Negative Add School Locations

    And Click on the element in the left Nav
      | setupOne    |
      | schoolSetup |
      | locations   |

    And Click on the element in the Dialog content
      | addButton |

    And User sending the keys in Dialog content
      | nameInput | Team1School |
      | capacity  | 35          |
      | shortName | T1S         |

    Then User should choose the location type Laboratory

    And Click on the element in the Dialog content
      | saveButton |

    Then Already exists message should be displayed


  @Regression @SchoolLocations @SchoolLocationsNegative
  Scenario: Edit School Locations

    And Click on the element in the left Nav
      | setupOne    |
      | schoolSetup |
      | locations   |

    And Click on the element in the Dialog content
      | editButton |

    And User sending the keys in Dialog content
      | nameInput | Team1SchoolDüzenlendi |
      | capacity  | 5000          |
      | shortName | T1SD         |

    Then User should choose the location type Classroom

    And Click on the element in the Dialog content
      | saveButton |

    Then Success message should be displayed

