Feature: This feature verifies data ingested from csv file with data on acutal gov.uk website

  Scenario: verify data from csv files in gov.uk UI
    Given I invoke file retrieve service for csv files located in "/Users/shambugpujar/IdeaProjects/vehiclesearch/file-retriever-service/src/test/resources/data"
    When I search the vehicles from the file on UI
    Then UI should return vehicle details as per expected details in csv file


