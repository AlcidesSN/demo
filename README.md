# Projeto demo, Estudo sobre CRUD e SpringBot
## Como funciona

Inciando o codigo e abrindo o Aplicativo POSTMAN ou similar, podemos postar algumas coisas, vamos começar pelo Funcionario colocando o tipo `get` e o link como `localhost:8080/funcionarios` ou `localhost:8081/funcionarios` ,dependendo de qual porta abrir quando iniciar o codigo, quando dermos enviar ou send receberemos o seguinte:
```json
[]
```
 
Isso que dizer que a tabela refente a funcionarios esta fazia, vamos popular mudando de get para post e colocando algumas informaçoes no body.
Colocando as seguntes infomaçoes:
```json
{
 "nome": "Lucas",
 "sobrenome": "Hugaro",
 "cpf": "12345678900",
 "telefone": "987654321001",
 "salario": 1600.00,
 "cargaHoraria": 40.00
}
```
Recebemos de volta:
```json
{
 "nome": "Lucas",
 "sobrenome": "Hugaro",
 "cpf": "12345678900",
 "telefone": "987654321001",
 "id": 1,
 "salario": 1600.00,
 "cargaHoraria": 40.00
}
```
Essa informação de retorno quer dizer que esse funcionario foi cadastrado, vamos colocar mais alguns para pupular.
Observase que ao tentar colocar a seguinte informação:
```json
{
 "nome": "Alcides",
 "sobrenome": "Sandoi",
 "cpf": "985632147121",
 "telefone": "523698741236",
 "salario": 3000.00,
 "cargaHoraria": 46.00
}
```
É recebido uma mensagem de erro avisando que o CPF de não esta no padrão, ou seja, não tem exatamente 11 caracteres, a mensagem de erro é a seguinte:
```json
{
 "cpf": "O tamanho do cpf deve ser entre 11 e 11"
}
```
Agora queremos criar um Animal para pupular as tabelas colocando no get e o link `localhost:8080/animais` ou `localhost:8081/animais` recebemos de volta um confirmação que a tabela esta vazia
```json
[]
```
Vamos popular essa tabela tambem, colocando as segunters informaçoes:
```json
{
 "nome": "Apolo",
 "raca": "Golden Rettriver",
 "idade": "2",
 "descriçao": "Não é agressivo mas é bastante agitado."
}
```
Quando eviamos essa informação recebemos de volta a confirmação contendo o segunte.
```json
{
 "id": 1,
 "nome": "Apolo",
 "raca": "Golden Rettriver",
 "idade": "2",
 "descriçao": "Não é agressivo mas é bastante agitado."
}
```
Podemos colocar mais animais mas para esse teste é o suficiente.
Agora vamos popular a tabela cliente, colocando em post e indo no link  `localhost:8080/Clientes` ou `localhost:8081/clientes` com as seguntes informaçoes:
```json
{
 "nome": "Alcides",
 "sobrenome": "Sandoi",
 "cpf": "12365478902",
 "telefone": "523698741236",
 "animal": 1,
 "residencia": "Rua Alindo inesistente N° -5 "
}
```
Observase que colocamos um numero no campo correspondente a Animal, esse numero é referente ao `id` que são atribuidos aos Animais quando enviamos salvamos eles.
Agora queremos criar um agendamento de `banho e tosa` do `Apolo` no dia `04/04/2024` feito pelo `Lucas` vamos a colocar novamente em post e mudar o link para  `localhost:8080/agendamentos` ou `localhost:8081/agendamentos` e colocar as seguintes infomaçoes:
```json
{
 "servico": "banho e tosa",
 "animal": 1,
 "funcionario": 1,
 "data": "04/04/2024"
}
```
Pronto o agendamento esta marcado.
Note que novamnte para referenciar o animal e dessa vez tambem para referenciar o funcionario usamos o seu `id`, nessa tabela se o `id` referente ao animal ou funcionario não exitir ele acusa o seguinte erro:
```json
O funcionario ou Animal não existem porfavor verifiquem e fação a requisição novamente.
```
Caso queiramos modificar alguma informação por exemplo, quero mudar a idade do animal Apolo devemos fazer os seguinte.
Primeiro mudar de post ou get que estvamos usando, para put e colocar o link  `localhost:8080/animais/1` ou `localhost:8081/animais/1`.
Mas fica a pergunta para que esse `/1` que foi adiciona? 
A resposta é: para so codigo saber quem ele vai modificar no caso o `id` do Apolo é `1` se o id fosse outro nos colocariamos ele.
Então no body colocaremos o segunte:
```json
{
 "nome": "Apolo",
 "raca": "Golden Rettriver",
 "idade": "4",
 "descriçao": "Não é agressivo mas é bastante agitado."
}
```
E ele retornará o sengunte confirmando a edição dos dados:
```json
{
 "id": 1,
 "nome": "Apolo",
 "raca": "Golden Rettriver",
 "idade": "4",
 "descriçao": "Não é agressivo mas é bastante agitado."
}
```
O caso é parecido caso queira apagar alguma coisa por exemplo, o cliente quer cancelar o agendamento do banho e tosa.
faremos o seguinte modificaremos de o tipo de requisição para delete e colocaremos o `id` do agendamemento, para esse caso ficara da seguinte forma  `localhost:8080/agendamentos/1` ou `localhost:8081/agendamentos/1`.
Quando dermos enviar as infomaçoes seram apagadas e receberemos a segunte confimação:
```json
O id 1 foi apagado com sucesso.
```
## Videos de explicação
### Detalhando um pouco o codigo
https://github.com/AlcidesSN/demo/assets/55538342/1fc8529a-727e-4735-af55-36d3e9816239

### Como a Orientação a Objeto me ajudou no projeto
https://github.com/AlcidesSN/demo/assets/55538342/b887f16f-eb59-4071-8234-8df3336de10a
