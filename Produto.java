import java.io.Serializable;

public class Produto implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String nome;
    private double preco;

    public Produto(int id, String nome, double preco){
        this.id = String.valueOf(id);
        this.nome = nome;
        this.preco = preco;
    }

    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id = id;
    }
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public double getPreco(){
        return preco;
    }
    public void setPreco(Double preco){
        this.preco = preco;
    }



}
