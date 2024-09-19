import java.util.ArrayList;
import java.util.List;

// Classe Banco
class Banco {
    private String nomeBanco;
    private String agencia;
    private int numeroConta;
    private String tipoConta;

    public Banco(String nomeBanco, String agencia, int numeroConta, String tipoConta) {
        this.nomeBanco = nomeBanco;
        this.agencia = agencia;
        this.numeroConta = numeroConta;
        this.tipoConta = tipoConta;
    }

    public void receberPagamento(double valor) {
        System.out.println("Pagamento recebido: " + valor);
    }

    public void efetuarPagamento(double valor) {
        System.out.println("Pagamento efetuado: " + valor);
    }

    public void mostrarSaldo() {
        System.out.println("Saldo atual: [mostrar saldo aqui]");
    }
}

// Classe Pessoa
abstract class Pessoa {
    protected String nome;
    protected String email;
    protected int telefone;

    public Pessoa(String nome, String email, int telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public void cadastrar() {
        System.out.println("Pessoa cadastrada: " + nome);
    }

    public void excluir() {
        System.out.println("Pessoa excluída: " + nome);
    }

    public void editar() {
        System.out.println("Pessoa editada: " + nome);
    }
}

// Pessoa Física (herda de Pessoa)
class PessoaFisica extends Pessoa {
    private int cpf;
    private int rg;
    private List<PessoaFisica> dependentes = new ArrayList<>();

    public PessoaFisica(String nome, String email, int telefone, int cpf, int rg) {
        super(nome, email, telefone);
        this.cpf = cpf;
        this.rg = rg;
    }

    public void relatorioGastoMes() {
        System.out.println("Relatório de gasto mensal para " + nome);
    }

    public void adicionarDependente(PessoaFisica dependente) {
        dependentes.add(dependente);
        System.out.println("Dependente adicionado: " + dependente.nome);
    }
}

// Pessoa Jurídica (herda de Pessoa)
class PessoaJuridica extends Pessoa {
    private String cnpj;

    public PessoaJuridica(String nome, String email, int telefone, String cnpj) {
        super(nome, email, telefone);
        this.cnpj = cnpj;
    }

    public void realizarCompra() {
        System.out.println("Compra realizada pela empresa: " + nome);
    }
}

// Classe Produto
class Produto {
    private String nome;
    private int idProduto;
    private String tipoProduto;
    private String validadeProduto;
    private double preco;

    public Produto(String nome, int idProduto, String tipoProduto, String validadeProduto, double preco) {
        this.nome = nome;
        this.idProduto = idProduto;
        this.tipoProduto = tipoProduto;
        this.validadeProduto = validadeProduto;
        this.preco = preco;
    }

    public void disponibilidade() {
        System.out.println("Produto disponível: " + nome);
    }

    public void relatorioMes() {
        System.out.println("Relatório do produto: " + nome);
    }
}

// Classe Estoque
class Estoque {
    private int quantidadeProdutos;
    private List<Produto> produtos = new ArrayList<>();

    public Estoque(int quantidadeProdutos) {
        this.quantidadeProdutos = quantidadeProdutos;
    }

    public void cadastrarProduto(Produto produto) {
        produtos.add(produto);
        System.out.println("Produto cadastrado: " + produto);
    }

    public void relatorioPosicaoEstoque() {
        System.out.println("Relatório de posição de estoque.");
    }

    public void validarEntradaProduto(Produto produto) {
        System.out.println("Validação de entrada do produto: " + produto);
    }

    public void excluirProduto(Produto produto) {
        produtos.remove(produto);
        System.out.println("Produto excluído.");
    }

    public void editarProduto(Produto produto) {
        System.out.println("Produto editado: " + produto);
    }
}

// Classe VendaProduto
class VendaProduto {
    private int id;
    private String nomeProduto;
    private float valorProduto;
    private String formaPagamento;

    public VendaProduto(int id, String nomeProduto, float valorProduto, String formaPagamento) {
        this.id = id;
        this.nomeProduto = nomeProduto;
        this.valorProduto = valorProduto;
        this.formaPagamento = formaPagamento;
    }

    public void realizarVenda() {
        System.out.println("Venda realizada: " + nomeProduto);
    }

    public void cancelarVenda() {
        System.out.println("Venda cancelada.");
    }

    public void mostrarCarrinho() {
        System.out.println("Mostrando carrinho de vendas.");
    }
}

// Classe Main para testar o sistema
public class Main {
    public static void main(String[] args) {
        // Criando banco
        Banco banco = new Banco("Banco Bradesco", "1234", 56789, "Corrente");
        banco.mostrarSaldo();

        // Criando pessoa física
        PessoaFisica pessoa1 = new PessoaFisica("João", "joao@gmail.com", 987654321, 123456789, 987654321);
        pessoa1.cadastrar();
        pessoa1.relatorioGastoMes();

        // Criando pessoa jurídica
        PessoaJuridica empresa = new PessoaJuridica("Empresa Pirate", "contato@empresa.com", 123456789, "12.345.678/0001-99");
        empresa.realizarCompra();

        // Criando produto
        Produto produto = new Produto("Notebook", 1, "Eletrônico", "2025-12-31", 2500.00);
        produto.disponibilidade();

        // Cadastrando produto no estoque
        Estoque estoque = new Estoque(100);
        estoque.cadastrarProduto(produto);
        estoque.relatorioPosicaoEstoque();

        // Realizando venda
        VendaProduto venda = new VendaProduto(1, "Notebook", 2500.00f, "Cartão");
        venda.realizarVenda();
        venda.mostrarCarrinho();
    }
}
