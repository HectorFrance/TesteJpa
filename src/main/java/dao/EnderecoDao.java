package dao;

import java.util.List;

import model.Endereco;


public interface EnderecoDao {
	
	public void salvar(Endereco endereco);
	public void alterar(Endereco endereco);
	public void remover(int numero);
	public Endereco pesquisar(int numero);
	public List<Endereco> listarTodos();
}
