
# Eventos Cientificos API REST

O objetivo dessa API é cadastrar dados de eventos científicos, especificando os volumes de artigos de um determinado evento, informações dos artigos desse volume e dos autores de cada artigo.

## Volume

Representa o agregado de artigos aceitos em um dado evento

| Atributo | Descrição |
| --- | --- |
cidade	| Cidade onde o evento será realizado |
data	| Data do evento |
descIng	| Descrição do evento em inglês |
descPt  | Descrição do evento em português |
edicao	| Número da edição desse evento |
id	| Id para identificação do volume no sistema (chave única) |
sigla	| Sigla do evento

### GET api/volumes - Lista todos os volumes

``` Exemplo de resposta (200)
[
  {
    "artigos": [
      {
        "autores": [
          {
            "afiliacaoIng": "string",
            "afiliacaoPt": "string",
            "email": "string",
            "id": 0,
            "meioNome": "string",
            "orcID": "string",
            "ordemArtigo": 0,
            "pais": "string",
            "primNome": "string",
            "ultiNome": "string"
          }
        ],
        "id": 0,
        "idioma": "string",
        "ordemVolume": 0,
        "pchaveIng": "string",
        "pchavePt": "string",
        "quantidadePaginas": 0,
        "resumoIng": "string",
        "resumoPt": "string",
        "tituloIng": "string",
        "tituloOriginal": "string"
      }
    ],
    "cidade": "string",
    "data": "string",
    "descIng": "string",
    "descPt": "string",
    "edicao": 0,
    "id": 0,
    "sigla": "string"
  }
]
```

### GET api/volume/:Id - Lista um volume por Id

`````` Exemplo de resposta (200)
[
  {
    "artigos": [
      {
        "autores": [
          {
            "afiliacaoIng": "string",
            "afiliacaoPt": "string",
            "email": "string",
            "id": 0,
            "meioNome": "string",
            "orcID": "string",
            "ordemArtigo": 0,
            "pais": "string",
            "primNome": "string",
            "ultiNome": "string"
          }
        ],
        "id": 0,
        "idioma": "string",
        "ordemVolume": 0,
        "pchaveIng": "string",
        "pchavePt": "string",
        "quantidadePaginas": 0,
        "resumoIng": "string",
        "resumoPt": "string",
        "tituloIng": "string",
        "tituloOriginal": "string"
      }
    ],
    "cidade": "string",
    "data": "string",
    "descIng": "string",
    "descPt": "string",
    "edicao": 0,
    "id": 0,
    "sigla": "string"
  }
]
```

### POST api/volume - Cria um volume

| Body | Descrição |
| --- | --- |
cidade	| Cidade onde o evento será realizado |
data	| Data do evento |
descIng	| Descrição do evento em inglês |
descPt  | Descrição do evento em português |
edicao	| Número da edição desse evento |
id	| Id para identificação do volume no sistema (chave única) |
sigla	| Sigla do evento
artigos | informações referentes aos artigos e autores neles contidos |

``` Exemplo de Body
{
  "artigos": [
    {
      "autores": [
        {
          "afiliacaoIng": "uff",
          "afiliacaoPt": "uff",
          "email": "testepost@uff.br",
          "id": 0,
          "meioNome": "metodo",
          "orcID": "1234",
          "ordemArtigo": 1,
          "pais": "br",
          "primNome": "teste",
          "ultiNome": "post"
        }
      ],
      "id": 0,
      "idioma": "pt",
      "ordemVolume": 1,
      "pchaveIng": "keyword",
      "pchavePt": "palavrachave",
      "quantidadePaginas": 23,
      "resumoIng": "resume",
      "resumoPt": "resumo",
      "tituloIng": "title",
      "tituloOriginal": "titulo"
    }
  ],
  "cidade": "rio de janeiro",
  "data": "2021-03-04",
  "descIng": "description",
  "descPt": "descricao",
  "edicao": 2,
  "id": 0,
  "sigla": "et"
}
```

### PUT /volumes/:volumeId - Atualiza um volume

| Body | Descrição |
| --- | --- |
| initials | Sigla do evento (Máximo 32 caracteres) |
| edition | Número da edição do evento |
| city | Cidade onde foi realizado o evento |
| startDate | Data de início do evento |
| portugueseDescription | Descrição em português |
| englishDescription | Descrição em inglês |

```Exemplo de Body
{
  "artigos": [
    {
      "autores": [
        {
          "afiliacaoIng": "uff",
          "afiliacaoPt": "uff",
          "email": "testepost@uff.br",
          "id": 0,
          "meioNome": "metodo",
          "orcID": "1234",
          "ordemArtigo": 1,
          "pais": "br",
          "primNome": "teste",
          "ultiNome": "post"
        }
      ],
      "id": 0,
      "idioma": "pt",
      "ordemVolume": 1,
      "pchaveIng": "keyword",
      "pchavePt": "palavrachave",
      "quantidadePaginas": 23,
      "resumoIng": "resume",
      "resumoPt": "resumo",
      "tituloIng": "title",
      "tituloOriginal": "titulo"
    }
  ],
  "cidade": "teste put",
  "data": "2021-03-04",
  "descIng": "teste put",
  "descPt": "teste put",
  "edicao": 2,
  "id": 0,
  "sigla": "et"
}
```

### DELETE api/volume/:Id - Deleta um volume por Id

### DELETE api/volume/:Id/artigos/:artigoId - Deleta um artigo de um determinado volume por Id

## Artigo

Representa os artigos dos volumes

| Atributo | Descrição |
| --- | --- |
| id | Chave única para identificação do volume |
| volumeOrder | Ordem do artigo no volume |
| originalTitle | Título original |
| englishTitle | Título em inglês |
| originalSummary | Resumo original |
| englishSummary | Resumo em inglês  |
| language | Idioma do artigo ("pt", "en" ou "es") |
| originalKeywords | Palavras-chaves originais (separadas por ";")  |
| englishKeywords | Palavras-chaves em inglês (separadas por ";") |
| numberOfPages | Número de páginas |

### GET /volumes/:volumeId/articles - Lista todos os artigos de um volume

```json
[
  {
    "id": 3,
    "volumeOrder": 1,
    "language": "pt",
    "originalTitle": "Título 999",
    "englishTitle": "Title 999",
    "originalSummary": "Um sumário",
    "englishSummary": "One summary",
    "originalKeywords": "palavra,novo",
    "englishKeywords": "word,new",
    "numberOfPages": 10,
    "authors": [
      {
        "id": 5,
        "articleOrder": 1,
        "email": "email@email.com",
        "firstName": "Nome 1",
        "middleName": "Nome 2",
        "lastName": "Nome 3",
        "affiliation": "ABC",
        "englishAffiliation": "CBA",
        "country": "BR",
        "orcID": "1234-1234-1234-1234"
      }
    ]
  }
]
```

### GET /volumes/:volumeId/articles/:articleId - Lista um artigo de um volume

```json
{
  "id": 3,
  "volumeOrder": 1,
  "language": "pt",
  "originalTitle": "Título 1",
  "englishTitle": "Title 1",
  "originalSummary": "Um sumário",
  "englishSummary": "One summary",
  "originalKeywords": "palavra,novo",
  "englishKeywords": "word,new",
  "numberOfPages": 10,
  "authors": []
}
```

### POST /volumes/:volumeId/articles - Cria um artigo de um volume

| Body | Descrição |
| --- | --- |
| volumeOrder | Ordem do artigo no volume |
| originalTitle | Título original |
| englishTitle | Título em inglês |
| originalSummary | Resumo original |
| englishSummary | Resumo em inglês  |
| language | Idioma do artigo ("pt", "en" ou "es") |
| originalKeywords | Palavras-chaves originais (separadas por ";")  |
| englishKeywords | Palavras-chaves em inglês (separadas por ";") |
| numberOfPages | Número de páginas |

```json
{
  "id": 4,
  "volumeOrder": 2,
  "language": "pt",
  "originalTitle": "Título 2",
  "englishTitle": "Title 2",
  "originalSummary": "Um sumário",
  "englishSummary": "One summary",
  "originalKeywords": "palavra,novo",
  "englishKeywords": "word,new",
  "numberOfPages": 10,
  "authors": null
}
```

### PUT /volumes/:volumeId/articles/:articleId - Atualiza um artigo de um volume

| Body | Descrição |
| --- | --- |
| volumeOrder | Ordem do artigo no volume |
| originalTitle | Título original |
| englishTitle | Título em inglês |
| originalSummary | Resumo original |
| englishSummary | Resumo em inglês  |
| language | Idioma do artigo ("pt", "en" ou "es") |
| originalKeywords | Palavras-chaves originais (separadas por ";")  |
| englishKeywords | Palavras-chaves em inglês (separadas por ";") |
| numberOfPages | Número de páginas |

```json
{
  "id": 3,
  "volumeOrder": 1,
  "language": "pt",
  "originalTitle": "Título 999",
  "englishTitle": "Title 999",
  "originalSummary": "Um sumário",
  "englishSummary": "One summary",
  "originalKeywords": "palavra,novo",
  "englishKeywords": "word,new",
  "numberOfPages": 10,
  "authors": null
}
```

### DELETE /volumes/:volumeId/articles/:articleId - Deleta um artigo de um volume

```json
No Content
```

## Autor

Representa os autores dos artigos dos volumes

| Atributo | Descrição |
| --- | --- |
| id | Chave única para identificação do volume |
| articleOrder | Ordem do artigo no volume |
| email | E-mail do autor |
| firstName | Primeiro nome do autor |
| middleName | Nome do meio do autor |
| lastName | Sobrenome do autor  |
| affiliation | Afiliação do autor |
| englishAffiliation | Afiliação do autor em inglês  |
| country | País do autor ("BR", "PT", "US", "FR", "UK", ou "ES") |
| orcID | Regitro OrcID ("XXXX-XXXX-XXXX-XXXX") |

### GET /articles/:articleId/authors - Lista todos os autores de um artigo

```json
[
  {
    "id": 5,
    "articleOrder": 1,
    "email": "email@email.com",
    "firstName": "Nome 1",
    "middleName": "Nome 2",
    "lastName": "Nome 3",
    "affiliation": "ABC",
    "englishAffiliation": "CBA",
    "country": "BR",
    "orcID": "1234-1234-1234-1234"
  }
]
```

### GET /articles/:articleId/authors/:authorId - Lista um autor de um artigo

```json
{
  "id": 5,
  "articleOrder": 1,
  "email": "email@email.com",
  "firstName": "Nome 1",
  "middleName": "Nome 2",
  "lastName": "Nome 3",
  "affiliation": "ABC",
  "englishAffiliation": "CBA",
  "country": "BR",
  "orcID": "1234-1234-1234-1234"
}
```

### POST /articles/:articleId/authors - Cria um autor para um artigo

| Body | Descrição |
| --- | --- |
| articleOrder | Ordem do artigo no volume |
| email | E-mail do autor |
| firstName | Primeiro nome do autor |
| middleName | Nome do meio do autor |
| lastName | Sobrenome do autor  |
| affiliation | Afiliação do autor |
| englishAffiliation | Afiliação do autor em inglês  |
| country | País do autor ("BR", "PT", "US", "FR", "UK", ou "ES") |
| orcID | Regitro OrcID ("XXXX-XXXX-XXXX-XXXX") |

```json
{
  "id": 6,
  "articleOrder": 1,
  "email": "email@email.com",
  "firstName": "Nome 2",
  "middleName": "Nome 3",
  "lastName": "Nome 4",
  "affiliation": "ABC",
  "englishAffiliation": "CBA",
  "country": "BR",
  "orcID": "1234-1234-1234-1234"
}
```

### PUT /articles/:articleId/authors/:authorId - Atualiza um autor de um artigo

| Body | Descrição |
| --- | --- |
| articleOrder | Ordem do artigo no volume |
| email | E-mail do autor |
| firstName | Primeiro nome do autor |
| middleName | Nome do meio do autor |
| lastName | Sobrenome do autor  |
| affiliation | Afiliação do autor |
| englishAffiliation | Afiliação do autor em inglês  |
| country | País do autor ("BR", "PT", "US", "FR", "UK", ou "ES") |
| orcID | Regitro OrcID ("XXXX-XXXX-XXXX-XXXX") |

```json
{
  "id": 6,
  "articleOrder": 2,
  "email": "email222@email.com",
  "firstName": "Nome 1",
  "middleName": "Nome 2",
  "lastName": "Nome 3",
  "affiliation": "ABC",
  "englishAffiliation": "CBA",
  "country": "BR",
  "orcID": "1234-1234-1234-1234"
}
```

### DELETE /articles/:articleId/authors/:authorId - Deleta um autor de um artigo

```json
No Content
```
