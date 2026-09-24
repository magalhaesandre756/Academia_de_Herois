package GeralHerois;

public class GeralHerois {
    private String nome;
    private int nivel;
    private int vida;
    private int mana;
    private String classe;

    public String getNome() {
        return nome;
    }

    public int getNivel() {
        return nivel;
    }

    public int getVida() {
        return vida;
    }

    public int getMana() {
        return mana;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public GeralHerois(String nome, int nivel, int vida, int mana) {
        setNome(nome);
        setNivel(nivel);
        setVida(vida);
        setMana(mana);

    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }


    public void cadastrarHeroi(){

    }

    public void listarHeroi(){

    }

    public void buscarHeroiPeloNome(){

    }

    public void exibirStats(){
        System.out.println("Nome do heroi: " + nome);
        System.out.println("Nivel do heroi: " + nivel);
        System.out.println("Vida do heroi: " + vida);
        System.out.println("Mana do heroi: " + mana);
        System.out.println("Classe do heroi: " + this.classe);
    }
}
