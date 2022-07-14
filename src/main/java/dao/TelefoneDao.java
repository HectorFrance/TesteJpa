package dao;

import java.util.List;

import model.Telefone;

public interface TelefoneDao {
	public void salvar(Telefone telefone);
	public void alterar(Telefone telefone);
	public void remover(long numero);
	public Telefone pesquisar(long numero);
	public List<Telefone> listarTodos();
}
