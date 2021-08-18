
# Eventos Cientificos API REST

O objetivo dessa API é cadastrar dados de eventos científicos, especificando os volumes de artigos de um determinado evento, informações dos artigos desse volume e dos autores de cada artigo.

O programa tem um swagger que pode ser acessado pela url http://localhost:8080/swagger-ui/ quando deployado localmente

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
Exemplo de resposta (200)

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
### GET api/volume/:Id/artigos - Lista todos os artigos de um determinado volume
Exemplo de resposta (200)
```
[
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
    "tituloOriginal": "string",
    "volume": {
      "artigos": [
        null
      ],
      "cidade": "string",
      "data": "string",
      "descIng": "string",
      "descPt": "string",
      "edicao": 0,
      "id": 0,
      "sigla": "string"
    }
  }
]
```
### GET api/volume/:Id - Lista um volume por Id
Exemplo de resposta (200)
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
``````

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

Exemplo de Body

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
cidade	| Cidade onde o evento será realizado |
data	| Data do evento |
descIng	| Descrição do evento em inglês |
descPt  | Descrição do evento em português |
edicao	| Número da edição desse evento |
id	| Id para identificação do volume no sistema (chave única) |
sigla	| Sigla do evento
artigos | informações referentes aos artigos e autores neles contidos |

Exemplo de Body

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
|id	|  Id para identificação do artigo no sistema (chave única) |
|idioma	 | Idioma do artigo |
|ordemVolume	| Ordem em que o artigo está armazenado no volume |
|pchaveIng	| Palavras chave do artigo em inglês|
|pchavePt	 | Palavras chave do artigo em português |
|quantidadePaginas | Quantidade de páginas do artigo|
|resumoIng	| Resumo do artigo em inglês|
|resumoPt	| Resumo do artigo em português|
|tituloIng	 | Título do artigo em inglês |
|tituloOriginal	| Título do artigo em português |

### GET api/artigos - Lista todos os artigos
Exemplo de resposta (200)

```
[
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
    "tituloOriginal": "string",
    "volume": {
      "artigos": [
        null
      ],
      "cidade": "string",
      "data": "string",
      "descIng": "string",
      "descPt": "string",
      "edicao": 0,
      "id": 0,
      "sigla": "string"
    }
  }
]
```

### GET api/artigo/:Id - Lista um determinado artigo por Id
Exemplo de resposta (200)

```
[
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
    "tituloOriginal": "string",
    "volume": {
      "artigos": [
        null
      ],
      "cidade": "string",
      "data": "string",
      "descIng": "string",
      "descPt": "string",
      "edicao": 0,
      "id": 0,
      "sigla": "string"
    }
  }
]
```

### GET api/artigo/:Id/autores - Lista todos os autores de um determinado artigo
Exemplo de resposta (200)

```
[
  {
    "afiliacaoIng": "string",
    "afiliacaoPt": "string",
    "artigo": {
      "autores": [
        null
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
      "tituloOriginal": "string",
      "volume": {
        "artigos": [
          null
        ],
        "cidade": "string",
        "data": "string",
        "descIng": "string",
        "descPt": "string",
        "edicao": 0,
        "id": 0,
        "sigla": "string"
      }
    },
    "email": "string",
    "id": 0,
    "meioNome": "string",
    "orcID": "string",
    "ordemArtigo": 0,
    "pais": "string",
    "primNome": "string",
    "ultiNome": "string"
  }
]
```

### POST api/artigo - Cria um artigo de um volume

| Body | Descrição |
| --- | --- |
|id	|  Id para identificação do artigo no sistema (chave única) |
|idioma	 | Idioma do artigo |
|ordemVolume	| Ordem em que o artigo está armazenado no volume |
|pchaveIng	| Palavras chave do artigo em inglês|
|pchavePt	 | Palavras chave do artigo em português |
|quantidadePaginas | Quantidade de páginas do artigo|
|resumoIng	| Resumo do artigo em inglês|
|resumoPt	| Resumo do artigo em português|
|tituloIng	 | Título do artigo em inglês |
|tituloOriginal	| Título do artigo em português |

Exemplo de Body

```json
 {
    "id": 0,
    "ordemVolume": 3,
    "idioma": "jp",
    "tituloIng": "test arcticle",
    "resumoPt": "artigo teste ",
    "resumoIng": "test arcticle",
    "pchavePt": "palavra chave ptbr",
    "pchaveIng": "key word english",
    "autores": [],
    "quantidadePaginas": 45,
    "tituloOriginal": "teste artigo"
  }
```

### PUT api/artigo - Atualiza um artigo de um volume

| Body | Descrição |
| --- | --- |
|id	|  Id para identificação do volume no sistema (chave única) |
|idioma	 | Idioma do artigo |
|ordemVolume	| Ordem em que o artigo está armazenado no volume |
|pchaveIng	| Palavras chave do artigo em inglês|
|pchavePt	 | Palavras chave do artigo em português |
|quantidadePaginas | Quantidade de páginas do artigo|
|resumoIng	| Resumo do artigo em inglês|
|resumoPt	| Resumo do artigo em português|
|tituloIng	 | Título do artigo em inglês |
|tituloOriginal	| Título do artigo em português |

Exemplo de Body

```json
 {
    "id": 0,
    "ordemVolume": 3,
    "idioma": "jp",
    "tituloIng": "test put",
    "resumoPt": "teste put ",
    "resumoIng": "teste put",
    "pchavePt": "teste put",
    "pchaveIng": "teste put",
    "autores": [],
    "quantidadePaginas": 45,
    "tituloOriginal": "teste put"
  }
```

### DELETE api/artigo/:Id - Deleta um determinado artigo por Id

### DELETE api/artigo/:Id/autores/:autorId - Deleta um determinado autor de um artigo

## Autor

Representa os autores dos artigos

| Atributo | Descrição |
| --- | --- |
|afiliacaoIng	| Afiliação do autor em inglês
|afiliacaoPt | Afiliação do autor em português
|artigo | Informações referentes ao artigo que o autor escreveu
|email	| Email do autor
|id	|  Id para identificação do autor no sistema (chave única) |
|meioNome	| Nome do meio do autor
|orcID	| Registro OrcID
|ordemArtigo | Ordem do artigo no volume
|pais	| País do autor
|primNome	| Primeiro nome do autor
|ultiNome	| Último nome do autor


### GET api/autores - Lista todos os autores 
Exemplo de resposta (200)

```json
[
  {
    "afiliacaoIng": "string",
    "afiliacaoPt": "string",
    "artigo": {
      "autores": [
        null
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
      "tituloOriginal": "string",
      "volume": {
        "artigos": [
          null
        ],
        "cidade": "string",
        "data": "string",
        "descIng": "string",
        "descPt": "string",
        "edicao": 0,
        "id": 0,
        "sigla": "string"
      }
    },
    "email": "string",
    "id": 0,
    "meioNome": "string",
    "orcID": "string",
    "ordemArtigo": 0,
    "pais": "string",
    "primNome": "string",
    "ultiNome": "string"
  }
]
```


### GET api/autor/:Id - Lista um determinado autor por Id
Exemplo de resposta (200)

```json
[
  {
    "afiliacaoIng": "string",
    "afiliacaoPt": "string",
    "artigo": {
      "autores": [
        null
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
      "tituloOriginal": "string",
      "volume": {
        "artigos": [
          null
        ],
        "cidade": "string",
        "data": "string",
        "descIng": "string",
        "descPt": "string",
        "edicao": 0,
        "id": 0,
        "sigla": "string"
      }
    },
    "email": "string",
    "id": 0,
    "meioNome": "string",
    "orcID": "string",
    "ordemArtigo": 0,
    "pais": "string",
    "primNome": "string",
    "ultiNome": "string"
  }
]
```

### POST api/autor - Cria um novo autor

| Body | Descrição |
| --- | --- |
|afiliacaoIng	| Afiliação do autor em inglês
|afiliacaoPt | Afiliação do autor em português
|artigo | Informações referentes ao artigo que o autor escreveu
|email	| Email do autor
|id	|  Id para identificação do autor no sistema (chave única) |
|meioNome	| Nome do meio do autor
|orcID	| Registro OrcID
|ordemArtigo | Ordem do artigo no volume
|pais	| País do autor
|primNome	| Primeiro nome do autor
|ultiNome	| Último nome do autor

Exemplo de Body

```json
 {
    "id": 0,
    "ordemArtigo": 1,
    "email": "testepost@uff.br",
    "primNome": "teste",
    "meioNome": "metodo",
    "ultiNome": "post",
    "afiliacaoPt": "uff",
    "afiliacaoIng": "uff",
    "pais": "br",
    "orcID": "1234-4351-4532-1234"
  }
```

### PUT api/autor - Atualiza um autor 

| Body | Descrição |
| --- | --- |
|afiliacaoIng	| Afiliação do autor em inglês
|afiliacaoPt | Afiliação do autor em português
|artigo | Informações referentes ao artigo que o autor escreveu
|email	| Email do autor
|id	|  Id para identificação do autor no sistema (chave única) |
|meioNome	| Nome do meio do autor
|orcID	| Registro OrcID
|ordemArtigo | Ordem do artigo no volume
|pais	| País do autor
|primNome	| Primeiro nome do autor
|ultiNome	| Último nome do autor

Exemplo de Body

```json
 {
    "id": 0,
    "ordemArtigo": 1,
    "email": "testeput@uff.br",
    "primNome": "teste",
    "meioNome": "metodo",
    "ultiNome": "put",
    "afiliacaoPt": "put",
    "afiliacaoIng": "put",
    "pais": "br",
    "orcID": "1234-4351-4532-1234"
  }
```

### DELETE api/autor/:Id - Deleta um determinado autor por Id
