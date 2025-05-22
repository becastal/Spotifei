CREATE TABLE usuario (
  id SERIAL PRIMARY KEY,
  nome VARCHAR(100) NOT NULL,
  email VARCHAR(150) UNIQUE NOT NULL,
  senha VARCHAR(255) NOT NULL
);

CREATE TABLE artista (
  id SERIAL PRIMARY KEY,
  nome VARCHAR(150) NOT NULL UNIQUE
);

CREATE TABLE musica (
  id SERIAL PRIMARY KEY,
  titulo VARCHAR(200) NOT NULL,
  genero VARCHAR(100),
  artista_id  INTEGER NOT NULL REFERENCES artista(id) ON DELETE CASCADE
);

CREATE TABLE playlist (
  id SERIAL PRIMARY KEY,
  nome VARCHAR(150) NOT NULL,
  usuario_id INTEGER NOT NULL REFERENCES usuario(id) ON DELETE CASCADE
);
CREATE TABLE playlist_musicas (
  playlist_id INTEGER REFERENCES playlist(id) ON DELETE CASCADE,
  musica_id INTEGER REFERENCES musica(id)   ON DELETE CASCADE,
  PRIMARY KEY (playlist_id, musica_id)
);

CREATE TABLE historico_buscas (
  id SERIAL PRIMARY KEY,
  usuario_id INTEGER NOT NULL REFERENCES usuario(id) ON DELETE CASCADE,
  descricao VARCHAR(250) NOT NULL DEFAULT '',
  buscado_em TIMESTAMP NOT NULL DEFAULT NOW()
);

CREATE TABLE curtidas (
  usuario_id INTEGER REFERENCES usuario(id) ON DELETE CASCADE,
  musica_id INTEGER REFERENCES musica(id)  ON DELETE CASCADE,
  curtido_em TIMESTAMP NOT NULL DEFAULT NOW(),
  PRIMARY KEY (usuario_id, musica_id)
);
CREATE TABLE descurtidas (
  usuario_id INTEGER REFERENCES usuario(id) ON DELETE CASCADE,
  musica_id INTEGER REFERENCES musica(id)  ON DELETE CASCADE,
  descurtido_em TIMESTAMP NOT NULL DEFAULT NOW(),
  PRIMARY KEY (usuario_id, musica_id)
);

