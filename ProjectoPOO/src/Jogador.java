
import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ARFB
 */





public class Jogador implements Serializable {
    
    private static int id=0;
    private int id_jogador;
    private String nome;
    private int idade;
    private int bi;
    private String nacionalidade;
    private int wins;
    private int loses;
    private int premios;
    

    public Jogador(){
        ++id;
        id_jogador=id;
        nome = "";
        idade = 0;
        bi = 0;
        nacionalidade = "";
        wins = 0;
        loses =0;
        premios =0;
                    }

    public Jogador(String nome,int idade,int bi,String nacionalidade){
        ++id;
        this.id_jogador=id;
        this.nome = nome;
        this.idade = idade;
        this.bi = bi;
        this.nacionalidade = nacionalidade;
        wins=0;
        loses=0;
        premios=0;
        
    }
    
    
    public void addPREMIO(int premio){
        this.premios=this.premios+premio;
    }
    
    public int getPremios(){
        return premios;
    }
    
    public void addPremio(int premio){
        this.premios+=premio;
    }
    
    public static int getID(){
        return id;
    }
    public int getIDD(){
        return id_jogador;
    }
    
    public static void setID(int idu){
        id=idu;
    }
    public String getNome(){
        return nome;
    }
    
    public void setNome(String nome){
        this.nome=nome;
    }
    
    public int getIdade(){
        return idade;
    }
    
    public void setIdade(int idade){
        this.idade=idade;
    }
    
    public int getBi(){
        return bi;
    }
    
    public void setBi(int bi){
        this.bi=bi;
    }
    
    public String getNacionalidade(){
        return nacionalidade;
    }
    
    public void setNacionalidade(String nacionalidade){
        this.nacionalidade=nacionalidade;
    }
    
    public int getWins(){
        return wins;
    }
    
    public void setWins(int wins){
        this.wins=this.wins+1;
    }
    
    public int getLoses(){
        return loses;
    }
    
    public void setLoses(int loses){
        this.loses=this.loses+1;
    }
    
    @Override
    public boolean equals (Object o){
        if(o!=null && (o instanceof Jogador)){
            Jogador p=(Jogador) o;
            return(this.nome.equals(p.nome) && this.idade==idade && this.bi == bi 
                    && this.nacionalidade == nacionalidade && this.wins==wins && this.loses==loses);
        }
        else
            return false;
                 
    }

    @Override
    public Object clone() {
        Jogador j=new Jogador();
        this.nome=j.nome;
        this.idade=j.idade;
        this.bi = j.bi;
        this.nacionalidade = j.nacionalidade;
        this.wins = j.wins;
        this.loses= j.loses;
        return j;
    }
    
    @Override
    public String toString(){
        return "\n\nID:" + id_jogador + "\nNome :" + nome + "\nIdade :" + idade + "\nBi :"+ bi +
                "\nNacionalidade :"+ nacionalidade + "\nWins :"+ wins + "\nLoses :"+loses + "\nValor em premios :" + premios+"€";
    } 

}