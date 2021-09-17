# language: en
Feature: Find things in Wikipedia
  As John Doe I want to look up in wikipedia what it means to be a John Doe

  Scenario: Look John Doe up
    Given John Doe has access to wikipedia
    When he looks up the meaning of his name
    Then he shall be enlightened