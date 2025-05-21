# Spotifei
Uma plataforma de informações de áudios digitais, principalmente músicas.

# Relatório
## Aplicações e ferramentas usadas

* Linux Mint
* Java 17
* NetBeans
* PostgreSQL server

# Passo a passo do que foi feito
# 1. Montando a base de dados no PostgreSQL e estruturando o projeto

1. **Criação da base com PostgreSQL no bash**

   ```bash
   sudo -u postgres psql -c "CREATE DATABASE spotifei;"
   sudo -u postgres psql -c "CREATE USER eu WITH ENCRYPTED PASSWORD '1234';"
   sudo -u postgres psql -c "GRANT ALL PRIVILEGES ON DATABASE spotifei TO eu;"
   ```

2. **Aplicação do esquema criado**

   ```bash
   psql -h localhost -U eu -d spotifei -f db/schema.sql
   ```

3. **Insersão de dados fictícios**
    * Os dados fictícios foram todas músicas e artistas que tirei da minha playlist pessoal dos anos 70-80 ou músicas semelhantes.
    * Você pode checar essa playlist pesquisando por @castaldellibernardo no apple music.

   ```bash
   psql -h localhost -U eu -d spotifei -f db/seed.sql
   ```
   
3. **Estruturação dos arquivos respeitando a Arquitetura MVC**
    * Os arquivos não foram todos criados de uma vez, mas as pastas foram formatadas / criadas para comportar uma estrutura que se assemelhasse à:
```
spotifei/
├─ pom.xml
├─ db/
│  └─ schema.sql
│  └─ seed.sql
└─ src/
   └─ main/
      └─ java/
         └─ com/mycompany/spotifei/
            ├─ model/
            │   ├─ Conexao.java
            │   ├─ entity/
            │   │   ├─ Usuario.java
            │   │   ├─ Artista.java
            │   │   ├─ Musica.java
            │   │   └─ Playlist.java
            │   └─ dao/
            │       ├─ UsuarioDAO.java
            │       ├─ ArtistaDAO.java
            │       ├─ MusicaDAO.java
            │       ├─ CurtidaDAO.java
            │       ├─ PlaylistDAO.java
            │       └─ HistoricoDAO.java
            ├─ control/
            │   ├─ LoginController.java
            │   ├─ CadastroController.java
            │   ├─ MusicasController.java
            │   ├─ PlaylistController.java
            │   └─ HistoricoController.java
            └─ view/
                ├─ Login.java
                ├─ Cadastro.java
                ├─ Musicas.java
                ├─ Playlists.java
                └─ Historico.java
```

4. **Conexao.java e configuração de dependências**
    * Plugins e pom.xml configurados para compilar com Java 17 e rodar o exec:java com a classe principal Spotifei.

# 2. Desenvolvimento do Projeto.

### 1. Fluxo de Login e Cadastro

1. **UsuarioDAO**: (dao) `inserir()`, `queryEmail()`. Lógica de SELECTs e INSERTs para conexao com SQL. 
2. **LoginController** e **CadastroController**: (control) para controlar o view e repassar os dados do DAO.
3. **Login.java** e **Cadastro.java**: (view) telas para login e cadastro simples.

---

### 2. Tela de Músicas


* **MusicaDAO**: (dao) queryTitulo() ... . faz os SELECT … LIKE ? com JOIN artista e mapeia o resultados em jTables.
* **CurtidaDAO**: (dao) exists(), curtir(), descurtir(). Lê e grava na tabela curtidas para verificar e alternar o status de “Sim/Não”.
* **MusicasController**: (control) para controlar o view e repassar os dados do DAO.
* **Musicas.java**: (view) construtores sobrecarregados para modo de navegação (Curtir/Descurtir) e modo de seleção (para adicionar playlists).

---

### 3. Gerenciamento de Playlists

* **Playlist.java**: (objeto) simples com campos id, nome, usuarioId. Mínimo pras queries funcionarem.
* **PlaylistDAO**: (dao) métodos para lidar com as músicas e suas relações com as playlists (gera SELECT … JOIN musica).
* **PlaylistController**: (control) para controlar o view e repassar os dados do DAO.
* **Playlists.java**: (view) duas tabelas mostrando playlists (ID, Nome) e outra com músicas da playlist selecionada. Botões para interagir com esses objetos.

---

### 4. Histórico de Curtidas e Descurtidas

* **HistoricoDAO**: (dao) métodos para lidar com as queries no histórico.
* **HistoricoController** (control) para controlar o view e repassar os dados do DAO.
* **Historico.java**: (view) duas tabelas, uma para curtidas e outra para descurtidas, preenchidas no construtor.

---

# 3. Como Rodar

```bash
mvn clean compile exec:java
```

* A tela de **Login** aparece.
* Faça cadastro e login.
* Explore **Músicas** (buscar, curtir, descurtir).
* Gerencie **Playlists** (criar, renomear, excluir, adicionar/remover músicas).
* Veja seu **Histórico** de curtidas, descurtidas e buscas.
