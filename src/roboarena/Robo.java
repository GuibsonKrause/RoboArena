/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roboarena;

/**
 *
 * @author 
 */
public abstract class Robo {

    private String nome;
    private String[] movimento;
    private char tpLetra;
    private int moedas = 0;

    

    public int getMoedas() {
        return moedas;
    }

    public void setMoedas(int moedas) {
        this.moedas = moedas;
    }

    public void incrementaMoeda() {
        this.moedas++;
    }

    public Robo(String nome, String movimento, char tpLetra) {
        this.nome = nome;
        this.tpLetra = tpLetra;

        int tam = movimento.length();
        this.movimento = new String[tam];
        this.movimento = movimento.split("");

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String[] getMovimento() {
        return movimento;
    }

    public void setMovimento(String[] movimento) {
        this.movimento = movimento;
    }

    public String[] movimentar() {
        return this.movimento;
    }

    public char getTpLetra() {
        return tpLetra;
    }

    public void setTpLetra(char tpLetra) {
        this.tpLetra = tpLetra;
    }

    public String tipoRobo() {
        return this.getClass().getSimpleName();
    }

    @Override
    public String toString() {
        return tipoRobo() + " " + nome + " " + moedas + "   " ;
    }

    public abstract char rotacionar(Arena a, char tpLetra);

}
