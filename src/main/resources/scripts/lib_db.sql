create database Liv_DB;

use Liv_DB;

CREATE TABLE GeneroLivro (
	IdGenero BIGINT AUTO_INCREMENT NOT NULL,
	Nome VARCHAR(100) NOT NULL,
primary key (IdGenero)
) ENGINE=InnoDB;

CREATE TABLE Perfil(
	IdPerfil BIGINT AUTO_INCREMENT NOT NULL,
	Tipo VARCHAR(100) NOT null,
	PRIMARY key (IdPerfil)
) ENGINE=InnoDB;

create table Usuario(
	IdUsuario BIGINT auto_increment not null,
	Nome VARCHAR(255) not null,
	IdGoogle VARCHAR(500) not null,
	Email VARCHAR(155) not null,
	FotoPerfil VARCHAR(500) null,
primary key (IdUsuario)
) ENGINE=InnoDB;

create table Perfil_Usuario(
	IdUsuario BIGINT not null,
	IdPerfil BIGINT not null,
	foreign key (IdUsuario) references Usuario(IdUsuario),
	foreign key (IdPerfil) references Perfil(IdPerfil),
	primary KEY(IdUsuario, IdPerfil)
)ENGINE=InnoDB;

CREATE TABLE Livro (
	IdLivro BIGINT auto_increment not null,
	IdGenero BIGINT not null,
	Resumo TEXT null,
	Titulo VARCHAR(255) not null,
	Autor VARCHAR(155) not null,
	Editora VARCHAR(100) null,
	Ano INT null,
	FlagDisponivel BIT not null,
	foreign key (IdGenero) references GeneroLivro(IdGenero),
primary KEY(IdLivro)
) ENGINE=InnoDB;
ALTER TABLE Livro MAX_ROWS=100;

create table LocacaoLivro(
	IdLocacao BIGINT auto_increment not null,
	IdUsuario BIGINT not null,
	IdLivro BIGINT not null,
	DataLocado Date not null,
	DataDevolvido Date null,
	foreign key (IdUsuario) references Usuario(IdUsuario),
foreign key (IdLivro) references Livro(IdLivro),
primary key (IdLocacao)
) ENGINE=InnoDB;

INSERT INTO liv_db.generolivro (Nome) VALUES
('Ficção científica'), ('Fantasia'), ('Distopia'), ('Ação e aventura'),
('Horror'), ('Thriller e Suspense'), ('Ficção Policial'), ('Ficção histórica'),
('Romance'), ('Ficção Contemporânea'), ('Realismo mágico'), ('Graphic Novel'),
('Conto'), ('Infantil'), ('Memórias e autobiografia'), ('Biografia'),
('Gastronomia'), ('Arte e Fotografia'), ('Autoajuda'), ('História'),
('Viagem'), ('Crimes Reais'), ('Humor'), ('Religião e Espiritualidade'),
('Humanidades e Ciências Sociais'), ('Tecnologia e Ciência');

INSERT INTO liv_db.perfil (Tipo) VALUES ('Admin'), ('User');




