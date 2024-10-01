import java.util.List;

public interface SistemaCadastro {

    void cadastrarProduto(String nome, double preco);

    Produto pesquisarProduto(int id);

    boolean removerProduto(int id);

    void cadastar(String nome, double preco);

    Produto pesquisar(int id);

    boolean remover(int id);

    List<Produto> listarProdutos();

    boolean atualizarProduto(int id, String novoNome, double novopreco);

    void cadastarProduto(String nome, double v);
}
