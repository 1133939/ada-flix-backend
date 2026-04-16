## ADA-FLIX-BACKEND
* Projeto backend feito em Java 21, utilizando Spring Boot, JPA, e banco de dados em memória H2 (SQL)

#### FLUXO
* No deploy do servidor é gerado o banco de dados e nele é inserido os **dados brutos** a partir dos 3 CSVs na pasta resources/data: movies.csv, ratings.csv, users.csv
* Após a carga dos dados brutos nas tabelas **FilmeCarga**, **UsuarioCarga** e **AvaliacaoFilmeCarga** é extraido as informações dessas tabelas para as entidades **Filme**, **Usuario** e **AvaliacaoFilme**.
* Após a carga nas entidades **Filme**, **Usuario** e **AvaliacaoFilme** são executadas queries do Data Mart retornando os dados e salvando nas tabelas **TopFilmesPorGenero**, **NumeroAvaliacoesPorPais**, **NotaMediaPorFaixaEtaria**

#### ACESSO AO BANCO DE DADOS
* Para acessar o banco de dados é necessário acessar a url:
    * http://localhost:8080/h2-console
    * JDBC URL: jdbc:h2:mem:mydb
    * username: sa
    * password: password

#### ENDPOINTS
* http://localhost:8080/flix/top-filmes-por-genero?genero=DRAMA
    * Retorna o top 10, se existir mais de 10 filmes na base deste genero
    * opcoes de genero:
        * DRAMA, ACAO, AVENTURA, COMEDIA, SCI-FI, ROMANCE, THRILLER, GUERRA, MISTERIO, CRIME, DOCUMENTARIO, FANTASIA
* http://localhost:8080/flix/nota-media-por-faixa-etaria?titulo=The Silent Code
    * Retorna a media das avaliacoes do filme do parametro separado por faixa etária
* http://localhost:8080/flix/numero-avaliacoes-por-pais?titulo=The Silent Code
    * Retorna a quantidade de avaliacoes por pais do filme do parametro
* http://localhost:8080/flix/cadastrar
    * Cadastrar um filme
        * exemplo json de request:
    ```json 
        {
            "titulo" : "Harry Potter e a Pedra Filosofal",
            "diretor" : "Silvio Santos",
            "anoLancamento" : 2001,
            "genero": "FANTASIA"
        }
    ```
        

* POST http://localhost:8080/flix/avaliar-filme
    * Avaliar um filme
        * exemplo json de request:
        ```json 
            {
                "idFilme" : 20,
                "idUsuario" : 1,
                "nota" : 4.5
            }
        ```
        

#### Como rodar
* Siga as instruções em:
    * https://github.com/1133939/ada-flix-deploy