# language: en
Feature: Find some other things in Wikipedia
  As Jane Doe I want to look up in wikipedia what it means to be a John Doe

  @Pending
  Scenario: Look Jane Doe up
    Given John Doe has access to wikipedia
    When he looks up the meaning of his name
    Then he shall be enlightened