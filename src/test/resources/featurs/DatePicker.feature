#language: pt
Funcionalidade: Automacao de escolha de Data no Datapicker

 Esquema do Cenario: Escolher Datapicker1

    Dado que estou na aba de Datepicker
    Quando abro o calendario1
    E seleciono a "<data>"
    Entao deve mostrar a "<data>" que selecionei

   Exemplos:
   |data|
   |31-December-1997|



Esquema do Cenario: Escolher data no Datepicker2
  Dado que estou na aba de Datepicker
  Quando abro o calendario2
  E seleciono a "<data>" no segundo calendario
  Entao deve mostrar a "<data>" que selecionei no segundo calendario

  Exemplos:
  |data|
  |12/31/1997|