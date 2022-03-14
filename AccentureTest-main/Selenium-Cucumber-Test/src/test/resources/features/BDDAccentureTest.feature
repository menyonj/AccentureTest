#Author: jsmenyon@gmail.com

@Todos
Feature: AccentureTest
  Preenchimento e envio de proposta pelo site  http://sampleapp.tricentis.com/101/app.php

  @Positivos
  Scenario: Testar envio de proposta de seguro para veiculo
    Given Que eu esteja na pagina da Tricents
    And Preencher o formulario, aba Enter Vehicle Data e pressione next
    And Preencher o formulario, aba Enter Insurant Data e pressione next
    And Preencher o formulario, aba Enter Product Data e pressione next
    And Preencher o formulario, aba Select Price Option e pressione next
    When Preencher o formulario, aba Send Quote e pressione Send
    Then validar a mensagem de envio com sucesso