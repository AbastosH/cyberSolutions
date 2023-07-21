#language: pt
Funcionalidade: Automacao do Formulario de Registro

  Esquema do Cenario: Preencher Formulario de Registro

    Dado que eu esteja na pagina de Registro
    Quando eu insiro "<primeiro_nome>" no campo Primeiro Nome
    E eu insiro "<ultimo_nome>" no campo Ultimo Nome
    E eu insiro "<endereco>" no campo Endereco
    E eu insiro "<email>" no campo Email
    E eu insiro "<telefone>" no campo Telefone
    E eu seleciono "<genero>" no campo Genero
    E eu seleciono "<hobbies>" no campo Hobbies
    E eu escolho "<linguas>" no campo Languages
    E eu seleciono "<habilidades>" no campo Habilidades
    E eu seleciono "<pais1>" no campo country*
    E eu seleciono "<pais>" no campo Selecionar Pais
    E eu insiro "<data_nascimento>" no campo Data de Nascimento
    E eu insiro "<senha>" no campo Senha
    E eu insiro "<confirma_senha>" no campo Confirmar Senha
    E eu devo clicar em Enviar
    Entao a aplicacao envia o formulario por falta de campos preenchidos

    Exemplos:
      | primeiro_nome | ultimo_nome | endereco   | email              | telefone     | genero | hobbies |linguas| habilidades | pais1 |pais    | data_nascimento | senha | confirma_senha |
      | Nome1         | Sobrenome1  | Endereco1  | email1@example.com | 1234567890   | Male   | Cricket |Arabic| Java        |  Denmark |Japan  | 1990-January-11      | pass1 | pass1          |
