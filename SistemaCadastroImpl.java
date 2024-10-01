
import java.io.*;
import java.util.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public abstract class SistemaCadastroImpl implements SistemaCadastro {
    private Map<Integer, Produto> produtos = new HashMap<>();
    private static final String FILE_NAME = "produtinhos.dat";


    public SistemaCadastroImpl() {
        carregarDados();
    }

    @Override
    public void cadastarProduto(String nome, double perco) {
        int id = produtos.size() + 1;
        double preco = 0.0;
        Produto produto = new Produto(id, nome, preco);
        produtos.put(id, produto);
        salvarDados();
    }

    @Override
    public Produto pesquisarProduto(int id) {
        return produtos.get(id);
    }

    @Override
    public boolean removerProduto(int id) {
        if (produtos.remove(id) != null){
            salvarDados();
            return true;
        }
        return false;
    }

    @Override
    public List<Produto> listarProdutos(){
        return new ArrayList<>(produtos.values());
    }

    @Override
    public boolean atualizarProduto(int id, String novoNome, double novopreco) {
        Produto produto = produtos.get(id);
        if (produto != null) {
            produto.setNome(novoNome);
            produto.setPreco(novopreco);
            salvarDados();
            return true;
        }
        return false;
    }

    private void salvarDados() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(produtos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void carregarDados() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            produtos = (Map<Integer, Produto>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Nenhum dado existente encontrado, começando novo cadastro.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
