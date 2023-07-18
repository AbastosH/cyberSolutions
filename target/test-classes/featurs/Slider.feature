#language: pt
Funcionalidade: Barra Slider

  Esquema do Cenario: Arrastar a barra slider até 50%

    Dado que estou na aba de Slider
    Quando movo o slider para <porcento>%
    Entao o slider handle fica na posicao <porcento>% da barra

    Exemplos:
    |porcento|
    |50|
    |102|

