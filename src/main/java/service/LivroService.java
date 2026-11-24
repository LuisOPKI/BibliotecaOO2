package service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.BancoDados;
import dao.LivroDAO;
import dto.LivroDTO;

public class LivroService {
	public int cadastrar(LivroDTO livro) throws SQLException, IOException {
		Connection conn = BancoDados.conectar();
		return new LivroDAO(conn).cadastrar(livro);
	}
	public List<LivroDTO> buscarTodos() throws SQLException, IOException {
		Connection conn = BancoDados.conectar();
		return new LivroDAO(conn).buscarTodos();
	}
	public LivroDTO buscarPorCodigo(int idLivro) throws SQLException, IOException {
		Connection conn = BancoDados.conectar();
		return new LivroDAO(conn).buscarPorCodigo(idLivro);
	}
	public int atualizar(LivroDTO livro) throws SQLException, IOException {
		Connection conn = BancoDados.conectar();
		return new LivroDAO(conn).cadastrar(livro);
	}
	public int excluir(int idLivro) throws SQLException, IOException {
		Connection conn = BancoDados.conectar();
		return new LivroDAO(conn).excluir(idLivro);
	}
}
