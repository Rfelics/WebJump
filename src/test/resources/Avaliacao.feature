#language:pt

Funcionalidade: Fazer ações e validações dos cenários da avaliação

  Contexto: Acessar site fazer validações

  @Cenario1
  Cenário: Acessar site e clicar nos botoes one, two e four com sucesso e validar ausencia dos mesmos

    Dado que acesse o site
    E valido que estou na tela WEBJUMP
    Quando clicar nos botoes "one", "two" e "four"
    Entao valido que nao apresenta botoes na tela

  @Cenario2
  Cenário: Acessar site e clicar nos botoes one, two e four dentro do IFrame e valido a ausencia dos mesmos

    Dado que acesse o site
    E valido que estou na tela WEBJUMP
    Quando clicar nos botoes "one", "two" e "four" dentro do Iframe
    Entao valido que nao apresenta mais nenhum desses botoes em tela

  @Cenario3
  Cenario: Preencher campo "YourFirstName", clicar no botao "one", validar presenca de botao "OptionThree", selecionar botao "ExampleTwo" e validar imagem

    Dado que acesse o site
    E valido que estou na tela WEBJUMP
    Quando escrever texto no campo "YourFirstName"
    E clicar no botao "One"
    E clicar no cheque "OptionThree"
    E selecionar a opcao  "ExampleTwo"
    Entao valido a imagem do logo do "Selenium Webdriver"
