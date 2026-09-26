package academiadeherois;

import herois.Heroi;

public class AcademiaDeHerois {
    /*
Esta Classe é como um armazem, aqui ela importa a Classe Heroi para que seja possivel criar o cadastro dos herois a partir daqui, listar os herois que existem e
buscar os herois pelo nome, alguem disso, esse import utiliza de array para que seja possivel criar no maximo 20 herois.
Tamebem temos atributos especificos para esta classe, que são totalHerois, totalMissoesConcluidas, para que no metodo relatorio seja possivel
retornar a quantidade de heroi que possui.
    */
    private Heroi[] herois = new Heroi[20];
    private int totalHerois, totalMissoesConcluidas;


    public int getTotalHerois() {
        return totalHerois;
    }


    public int getTotalMissoesConcluidas() {
        return totalMissoesConcluidas;
    }

    public void setTotalMissoesConcluidas(int totalMissoesConcluidas) {
        this.totalMissoesConcluidas = totalMissoesConcluidas;
    }


    public void cadastrarHerois(Heroi heroi) {
        if (totalHerois == herois.length) {
            System.out.println("Foi atingido o limite de 20 herois");
        } else {
            herois[totalHerois] = heroi;
            totalHerois++;
        }

    }

    public void listarHerois() {
        if (totalHerois == 0) {
            System.out.println("Não há nenhum heroi cadastrado");
        } else {
            System.out.println("Os herois cadastardos sao: " );
            for (int i = 0; i < totalHerois; i++) {
                herois[i].exibirStats();
            }
        }
    }

    public Heroi buscarHeroiPeloNome(String nome){
        for (int i = 0 ; i < totalHerois; i++){
            if (herois[i].getNome().equalsIgnoreCase(nome)){
                System.out.println("\n Heroi encontrado: \n" );
                herois[i].exibirStats();
                return herois[i];
            }
        }
        System.out.println("Heroi não encontrado.");
        return null;
    }

    public void relatorio() {
        int totalGuerreiro = 0;
        int totalMago = 0;
        int totalArqueiro = 0;
        int somaNiveis = 0;
        Heroi maisForte = herois[0];
        for (int i =0 ; i < totalHerois; i++){
            if (herois[i].getClasse().equals("Guerreiro")){
                totalGuerreiro++;
            } else if (herois[i].getClasse().equals("Mago")){
                totalMago++;
            } else if (herois[i].getClasse().equals("Arqueiro")) {
                totalArqueiro++;
            }
            somaNiveis += herois[i].getNivel();
            if (herois[i].calcularPontosCombate() > maisForte.calcularPontosCombate()) {
                maisForte = herois[i];
            }
        }
        double media = (double) somaNiveis /totalHerois;
        System.out.println("\n========= RELATÓRIO =========\n");
        System.out.println("Total de Heróis: " + totalHerois);
        System.out.println("Quantidade de Guerreiros: " + totalGuerreiro);
        System.out.println("Quantidade de Magos: " + totalMago);
        System.out.println("Quantidade de Arqueiros: " + totalArqueiro);
        System.out.println("Média de Nível: " + media);
        System.out.println("Herói mais forte: " + maisForte.getNome() + " Pontos De Combate: " + maisForte.calcularPontosCombate());
        System.out.println("Missões concluídas: " +totalMissoesConcluidas);
    }
    public void registrarMissaoConcluida(){
        totalMissoesConcluidas++;
    }
}