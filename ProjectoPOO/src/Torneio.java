
import java.io.Serializable;
import java.util.Vector;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ARFB
 */
public class Torneio implements Serializable {  
    private static int id=0;
    private int id_torneio;
    private String nome;
    private int premio1;
    private int premio2;
    private String local;
    private int ano;
    private int setPlayer1;
    private int setPlayer2;
    private String vencedor;
    private Vector<Jogador> Jogadores;
    private String estado;
    
    public Torneio(){
        ++id;
        id_torneio=id;
        nome="";
        premio1=0;
        premio2=0;
        setPlayer1=0;
        setPlayer2=0;
        local="";
        vencedor="";
        Jogadores = new Vector<Jogador>(2);
        estado="POR JOGAR";     
    }
    public Torneio(String nome, int premio1 , int premio2,String local,int ano){
        ++id;
        id_torneio=id;
        this.nome = nome;
        this.premio1 = premio1;
        this.premio2 = premio2;
        this.local = local;
        this.ano = ano;
        vencedor="";
        Jogadores = new Vector<Jogador>(2);
        estado="POR JOGAR";
     
    }
    
    public void removerJOGADOR(int id){
        int bandeira=0;
        
        for(int i= 0; i<Jogadores.size();i++){
        
        if(Jogadores.elementAt(i).getIDD()==id){
        Jogadores.removeElementAt(i);
        
                System.out.println("Jogador Removido");
        }}
    }

   
    public void addVENCEDOR(String vencedor){
        this.vencedor=vencedor;
    }
    
    public String getEstado(){
        return estado;
    }
    
    public void changeEstado(int estado){
        if(estado==0){
            this.estado="Por Jogar";
        }
        else 
            this.estado="FINALIZADO";
    }
    
    public boolean Cheio(){
        if(Jogadores.size()==2){
            return true;
        }
        return false;
    }
    
    public boolean verificaJOGADOR(Jogador J){
        for(int i=0;i<Jogadores.size();i++){
            if(Jogadores.elementAt(i).equals(J)){
                
                return true;
            }
        }
        return false;
    }
    
    public void addJogador(Jogador J){
        if(Jogadores.size()<2){
            Jogadores.addElement(J);
        }
        else
            System.out.println("Jogo já com 2 jogadores inscritos");
    }
    
    public int verificaVencedor(){
        if(setPlayer1==2){

            return 0;
        }
        if(setPlayer2==2){

            return 1;
        }
        
      return 2;  
    }
    
    public static int getID(){
        return id;
    }
    public int getIDD(){
        return id_torneio;
    }
    
    public static void setID(int idu){
        id=idu;
    }
    
    public String getNome(){
        return nome;
    }
    public int getSetPlayer1(){
        return setPlayer1;
    }
    
    public int getSetPlayer2(){
        return setPlayer2;
    }
    
    public void addSet1(){
        setPlayer1++;
    }
    
    public void addSet2(){
        setPlayer2++;
    }
    
    public boolean verificaJogo(int set){
        
        if(set>2){
            return true;
        }
        return false;   
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public int getPremio1(){
        return premio1;
    }
    
    public void setPremio1(int premio1){
        this.premio1 = premio1;
    }
    
    public int getPremio2(){
        return premio2;
    }
    
    public void setPremio2(int premio2){
        this.premio2 = premio2;
    }
   
    public String getLocal(){
        return local;
    }
    
    public void setLocal(String local){
        this.local = local;
    }
    
    public Vector<Jogador> getJogador(){
        return Jogadores;
    }
    
    public void setJogador(Vector<Jogador> Jogadores){
       this.Jogadores=(Vector<Jogador>)Jogadores.clone();    
    }
    
    public void setAno(int ano){
        this.ano=ano;
    }
    
    public int getAno(){
        return ano;
    }
    
    public int returnID0(){
        return Jogadores.elementAt(0).getIDD();
    }
    
    public int returnID1(){
        return Jogadores.elementAt(1).getIDD();
    }
    
    @Override
    public String toString() {
        String d="\n\nID :" + id_torneio + "\nTorneio :" + nome + "\nLOCAL :"+ local + "\nANO:" + ano + "\nPREMIOS:\n" + premio1+"€" +"\n"
                + premio2 +"€"+"\n\n" + "\nEstado:"+ estado + "\n\nVENCEDOR: "+ vencedor;
        
        for(int i=0;i<Jogadores.size();i++){
            
            d = d + "\nJogador :" + Jogadores.elementAt(i).getNome() + " ID: " + Jogadores.elementAt(i).getIDD();
        }
                
        return d;
    
    
}}
