
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import static java.time.Clock.system;
import java.util.Vector;
import myinputs.Ler;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ARFB
 */
public class MENU {
    
    public static void main(String[] args) throws IOException, ClassNotFoundException  {
        int opcao = -1;
       
        Vector<Jogador> JOGADORES = new Vector<Jogador>(); 
        Vector<Torneio> TORNEIOS = new Vector<Torneio>();
        
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("jogadores.dat"));
            JOGADORES = ((Vector<Jogador>) ois.readObject());
            Jogador.setID(ois.readInt());
            ois.close();
        } catch (IOException IOler) {
            System.out.println(IOler.getMessage());
        } catch (ClassNotFoundException IOler) {
            System.out.println(IOler.getMessage());
        }
        
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("torneios.dat"));
            TORNEIOS = ((Vector<Torneio>) ois.readObject());
            Torneio.setID(ois.readInt());
            ois.close();
        } catch (IOException IOler) {
            System.out.println(IOler.getMessage());
        } catch (ClassNotFoundException IOler) {
            System.out.println(IOler.getMessage());
        }
        
        
while (opcao != -9) {
    
            System.out.println("-------TÉNIS-------");
            System.out.println("- 1.   Jogador    -");
            System.out.println("- 2.   Torneio    -");
            System.out.println("- 3. Estatisticas -");
            System.out.println("- 4.     LIVE     -");
            System.out.println("- 0.  Sair/Save   -");
            System.out.println("-------------------");
            opcao = myinputs.Ler.umInt();
            
            if(opcao<0 || opcao >4){
                opcao=8;
            }
            switch(opcao){
                
                
    case 0: 
            Guardar j = new Guardar();
            Guardar t = new Guardar();
            j.GUARDA_JOGADORES(JOGADORES);
            t.GUARDA_TORNEIOS(TORNEIOS);
            opcao=-9;
            break;
    case 1: 
            
            menuJogador(JOGADORES,TORNEIOS);
            break;
    
    case 2:
            menuTorneio(TORNEIOS,JOGADORES);
            break;
    
    case 3:
        
            menuEstatisticas(JOGADORES,TORNEIOS);
            break;
            
      case 4:
            menuLIVE(TORNEIOS,JOGADORES);
            break;
            
      
      
}}
    }
    public static void menuJogador(Vector<Jogador> JOGADORES, Vector<Torneio> TORNEIOS){
        int flag=1;
            System.out.println("---------JOGADOR----------");
            System.out.println("- 1.  Criar Jogador      -");
            System.out.println("- 2. Alterar Jogador     -");
            System.out.println("- 3. Remover Jogador     -");
            System.out.println("- 4. Consultar Jogadores -");
            System.out.println("- 0.       Voltar        -");
            System.out.println("--------------------------");
     
            int opcaoJ = myinputs.Ler.umInt();
            
            while (opcaoJ!=0){
                
                if(opcaoJ<0 || opcaoJ>4){
                    opcaoJ=3;
                    break;
                }
            
            switch(opcaoJ){
                case 0:
                    opcaoJ=0;
                    break;
                case 1: 
            
                    
                    
            
                    System.out.println("------CriarJOGADOR-----");
                    System.out.println("-    Inserir Nome     -");
                    System.out.println("-    Inserir Idade    -");
                    System.out.println("-     Inserir BI      -");
                    System.out.println("-Inserir Nacionalidade-");
                    System.out.println("-----------------------");
                    String nomeJ = myinputs.Ler.umaString();
                    int idadeJ =myinputs.Ler.umInt();
                    int biJ = myinputs.Ler.umInt();
                    String nacionalidadeJ = myinputs.Ler.umaString();
                    Jogador J= new Jogador();
                    J.setBi(biJ);
                    J.setIdade(idadeJ);
                    J.setNacionalidade(nacionalidadeJ);
                    J.setNome(nomeJ);
                    JOGADORES.addElement(J);
                    opcaoJ=0;
                    break;
                    
                case 2: 
                        System.out.println("---------AlterarJOGADOR----------");
                        System.out.println("-       Identifique o ID :      -");
                        System.out.println("---------------------------------");
                        int id = myinputs.Ler.umInt();
                    
                        
                        
                        int opcaoAJ=-1;
                        while(opcaoAJ!=0){
                        System.out.println("---------AlterarJOGADOR----------");
                        System.out.println("-  1.    Alterar Nome           -");
                        System.out.println("-  2.    Alterar Idade          -");
                        System.out.println("-  3.    Alterar Bi             -");
                        System.out.println("-  4.    Alterar Nacionalidade  -");
                        System.out.println("---------------------------------");
                        opcaoAJ=myinputs.Ler.umInt();
                        if(opcaoAJ<0 || opcaoAJ>4){
                            opcaoAJ=3;
                            break;
                        }
                        switch(opcaoAJ){
                        
                            case 1:
                                
                                for(int i=0;i<JOGADORES.size();i++){
                                    
                                    if(id== JOGADORES.elementAt(i).getIDD()){
                                        System.out.println("Introduza o novo nome:");
                                        String nome = myinputs.Ler.umaString();
                                        JOGADORES.elementAt(i).setNome(nome);
                                        opcaoAJ=0;
                                        flag=0;
                                        break;
                                    }
                                }
                                        if (flag==1){
                                        System.out.println("ID de Jogador não existe!!");
                                        opcaoAJ=0;
                                        break;
                                        }
                                         opcaoAJ=0;
                                        break;
                       
                            case 2:
                                for(int i=0;i<JOGADORES.size();i++){
                                    
                                    if(id== JOGADORES.elementAt(i).getIDD()){
                                        System.out.println("Introduza a nova idade:");
                                        int idade=myinputs.Ler.umInt();
                                        JOGADORES.elementAt(i).setIdade(idade);
                                        opcaoAJ=0;
                                        flag=0;
                                        break;
                                    }}
                                if(flag==1){
                                    System.out.println("ID de Jogador não existe!!");
                                    opcaoAJ=0;    
                                    break;  
                                }
                                    opcaoAJ=0;    
                                    break;
                                
                            case 3: for(int i=0;i<JOGADORES.size();i++){
                                    
                                    if(id== JOGADORES.elementAt(i).getIDD()){
                                        System.out.println("Introduza o novo BI:");
                                        int bi=myinputs.Ler.umInt();
                                        JOGADORES.elementAt(i).setBi(bi);
                                        opcaoAJ=0;
                                        flag=0;
                                        break;
                                    }}
                            
                            if(flag==1){
                                    System.out.println("ID de Jogador não existe!!");
                                    opcaoAJ=0;
                                    break;
                            }
                            opcaoAJ=0;
                                    break;
                            
                            case 4:
                                 for(int i=0;i<JOGADORES.size();i++){
                                    flag = 1;
                                    if(id== JOGADORES.elementAt(i).getIDD()){
                                        System.out.println("Introduza a nova nacionalidade:");
                                        String Nacionalidade=myinputs.Ler.umaString();
                                        JOGADORES.elementAt(i).setNacionalidade(Nacionalidade);
                                        opcaoAJ=0;
                                        flag=0;
                                        break;
                                    }}
                        {
                            
                            if(flag == 1){
                                System.out.println("ID de Jogador não existe!!");
                                opcaoAJ=0;
                                break;}
                        }
                        }}
                        opcaoAJ=0;
                        opcaoJ=0;
                        break;
                            
                case 3:
                    System.out.println("-------------------------");
                    System.out.println("-   Identifique o ID :  -");
                    System.out.println("-------------------------");
                    int idRemove = myinputs.Ler.umInt();
                    flag = 1;
                    for(int i=0;i<JOGADORES.size();i++){
                            
                            if(JOGADORES.elementAt(i).getIDD() == idRemove){
                            System.out.println(JOGADORES.elementAt(i).toString());
                            JOGADORES.removeElementAt(i);
                            System.out.println("Jogador Removido com sucesso"); 
                            opcaoAJ=0;
                            flag =0 ;
                            break;
                        }
                         }
                         if(flag == 1){
                    System.out.println("ID de Jogador não existe!!");
                    opcaoAJ=0;
                         }
            
                    opcaoJ=0;
                    break;
                   
                    
            
                 case 4:
                        int bandeira=0;
                     for(int i =0;i<JOGADORES.size();i++){
                                System.out.println(JOGADORES.elementAt(i).toString());
                                bandeira++;
                            }
                     if(bandeira==0){
                         System.out.println("Não existem jogadores");
                     }
                            opcaoJ=0;
                            opcaoAJ=0;
                            break;
                            
                }
            }
            
            }
    
    
public static void menuTorneio(Vector<Torneio> TORNEIOS, Vector<Jogador> JOGADORES){
                    int flag=1;
                
                
                    System.out.println("---------TORNEIO----------");
                    System.out.println("- 1.   Criar Torneio     -");
                    System.out.println("- 2.  Alterar Torneio    -");
                    System.out.println("- 3.  Remover Torneio    -");
                    System.out.println("- 4. Consultar Torneios  -");
                    System.out.println("- 5. Inscrever Jogadores -");
                    System.out.println("- 0.       Voltar        -");
                    System.out.println("--------------------------");
                    int opcaoT = myinputs.Ler.umInt();
                    if(opcaoT<0 || opcaoT>5){
                        opcaoT=0;
                    }
                    while (opcaoT!=0){
                    
                        switch(opcaoT){
                        
                        case 0:
                                opcaoT=0;
                                break;
                        case 1:
                            
                            System.out.println("----CriarTORNEIO----");
                            System.out.println("-   Inserir Nome   -");
                            System.out.println("-   Inserir Local  -");
                            System.out.println("-   Inserir Ano    -");
                            System.out.println("- Inserir 1ºPremio -");
                            System.out.println("- Inserir 2ºPremio -");
                            System.out.println("--------------------");
                            String nomeT= myinputs.Ler.umaString();
                            String localT=myinputs.Ler.umaString();
                            int anoT=myinputs.Ler.umInt();
                            int premio1T = Ler.umInt();
                            int premio2T = Ler.umInt();
                            Torneio T =new Torneio();
                            T.setNome(nomeT);
                            T.setLocal(localT);
                            T.setPremio1(premio1T);
                            T.setPremio2(premio2T);
                            
                            T.setAno(anoT);
                            TORNEIOS.addElement(T);
                           
                                  System.out.println("Torneio Criado");
                                    
                            opcaoT=0;
                            break;
                        case 2: 
                            int posicao=0;
                            int opcaoAT=1;
                            String d="FINALIZADO";
                                    System.out.println("---------AlterarTORNEIO----------");
                                    System.out.println("-       Identifique o ID :      -");
                                    System.out.println("---------------------------------");
                                    int id = myinputs.Ler.umInt();
                    
                                    
                                    
                                    for(int i=0;i<TORNEIOS.size();i++){
                                        if(TORNEIOS.elementAt(i).getIDD()==id){
                                        posicao = i;
                                        }
                                    }
                                    if(TORNEIOS.elementAt(posicao).getEstado().equals(d)){
                                    System.out.println("Impossivel alterar, Torneio já finalizado");
                                    opcaoAT=0;
                        }
                                    
                                    
                                    
                                    
                                    while(opcaoAT!=0){
                                    System.out.println("------AlterarTORNEIO------");
                                    System.out.println("- 1.    Alterar Nome     -");
                                    System.out.println("- 2.    Alterar Local    -");
                                    System.out.println("- 3.     Alterar Ano     -");
                                    System.out.println("- 4.   Alterar 1ºPremio  -");
                                    System.out.println("- 5.   Alterar 2ºPremio  -");
                                    System.out.println("- 6.    Remover Jogador  -");
                                    System.out.println("--------------------------");
                                    opcaoAT = myinputs.Ler.umInt();
                                    
                        switch(opcaoAT){
                         
                            
                            case 1 : 
                                    for(int i=0;i<TORNEIOS.size();i++){
                                    
                                    if(id== TORNEIOS.elementAt(i).getIDD()){
                                    System.out.println("Introduza o novo nome:");
                                    String nome=myinputs.Ler.umaString();
                                    TORNEIOS.elementAt(i).setNome(nome);
                                    opcaoAT=0;
                                    opcaoT=0;
                                    flag=0;
                                    break;
                                    }
                                    }
                                    if(flag==1){
                                        System.out.println("O ID de Torneio não existe!");
                                        opcaoAT=0;
                                        opcaoT=0;
                                        break;
                                    }
                                    opcaoAT=0;
                                    break;
                                    
                            case 2:
                                    for(int i=0;i<TORNEIOS.size();i++){
                                    
                                    if(id== TORNEIOS.elementAt(i).getIDD()){
                                    System.out.println("Introduza o novo local:");
                                    String local=myinputs.Ler.umaString();
                                    TORNEIOS.elementAt(i).setLocal(local);
                                    opcaoAT=0;
                                    opcaoT=0;
                                    flag=0;
                                    break;
                                    }
                                    }
                                    if(flag==1){
                                        System.out.println("O ID de Torneio não existe!");
                                        opcaoAT=0;
                                        opcaoT=0;
                                        break;
                                    }
                                     opcaoAT=0;
                                    break;
                                    
                            case 3:
                                    for(int i=0;i<TORNEIOS.size();i++){
                                    
                                    if(id== TORNEIOS.elementAt(i).getIDD()){
                                    System.out.println("Introduza o novo ano:");
                                    int ano=myinputs.Ler.umInt();
                                    TORNEIOS.elementAt(i).setAno(ano);
                                    opcaoAT=0;
                                    opcaoT=0;
                                    flag=0;
                                    break;
                                    }
                                    }
                                    if(flag==1){
                                        System.out.println("O ID de Torneio não existe!");
                                        opcaoAT=0;
                                        opcaoT=0;
                                        break;
                                    }
                                     opcaoAT=0;
                                     opcaoT=0;
                                    break;
                            case 4:
                                   for(int i=0;i<TORNEIOS.size();i++){
                                    
                                    if(id== TORNEIOS.elementAt(i).getIDD()){
                                    System.out.println("Introduza o novo 1ºPremio:");
                                    int premio1=myinputs.Ler.umInt();
                                    TORNEIOS.elementAt(i).setPremio1(premio1);
                                    opcaoAT=0;
                                    opcaoT=0;
                                    flag=0;
                                    break;
                                    }
                                    }
                                   if(flag==1){
                                        System.out.println("O ID de Torneio não existe!");
                                        opcaoAT=0;
                                        opcaoT=0;
                                        break;
                                    }
                                    opcaoAT=0;
                                    break;
                            case 5:
                                    for(int i=0;i<TORNEIOS.size();i++){
                                    
                                    if(id== TORNEIOS.elementAt(i).getIDD()){
                                    System.out.println("Introduza o novo 2ºPremio:");
                                    int premio2=myinputs.Ler.umInt();
                                    TORNEIOS.elementAt(i).setPremio2(premio2);
                                    opcaoAT=0;
                                    opcaoT=0;
                                    flag=0;
                                    break;
                                    }
                                    }
                                    if(flag==1){
                                        System.out.println("O ID de Torneio não existe!");
                                        opcaoAT=0;
                                        opcaoT=0;
                                        break;
                                    }
                                    
                                     opcaoAT=0;
                                    break;
                           
                            case 6:
                                
                                System.out.println(TORNEIOS.elementAt(posicao).getJogador().toString());
                                    System.out.println("---------RemoverJOGADOR----------");
                                    System.out.println("-       Identifique o ID :      -");
                                    System.out.println("---------------------------------");
                                    int id_remover=myinputs.Ler.umInt();
                                    
                                
                                    TORNEIOS.elementAt(posicao).removerJOGADOR(id_remover);
                                    opcaoAT=0;
                                    opcaoT=0;
                                    break;
                        }}
                                    
                                    
                                    opcaoAT=0;
                                    opcaoT=0;
                                    break;
                        case 3:
                                    System.out.println("---------RemoverTORNEIO----------");
                                    System.out.println("-       Identifique o ID :      -");
                                    System.out.println("---------------------------------");
                                    int idRemove = myinputs.Ler.umInt();
                                    
                                    for(int i=0;i<TORNEIOS.size();i++){
                                            
                                        if(idRemove==TORNEIOS.elementAt(i).getIDD()){
                                            
                                            TORNEIOS.removeElementAt(i);
                                            System.out.println("Torneio removido com sucesso!!");
                                            flag=0;
                                            opcaoT=0;
                                            break;
                                    }
                                    }
                                    if(flag==1){
                                        System.out.println("O ID de Torneio não existe!");
                                        opcaoAT=0;
                                        break;
                                    }
                            opcaoT=0;
                            break;
                            
                        case 4: 
                            int bandeira=0;
                                   for(int i=0;i<TORNEIOS.size();i++){
                                       System.out.println(TORNEIOS.elementAt(i).toString());
                                       bandeira++;
                                   }
                                   if(bandeira==0){
                                       System.out.println("Não existem Torneios criados");
                                   }
                            opcaoT=0;
                            break;
                            
                            
                        case 5:
                            
                           bandeira=0;
                           int bandeiraj=0;
                           int posicao5=0;
                           int posicao_jogador=0;
                           boolean verifica;
                           
                            for(int i=0;i<TORNEIOS.size();i++){
                                System.out.println(TORNEIOS.elementAt(i).toString());
                                
                            }
                            
                            System.out.println("\n\n Insira o id do Torneio :");
                            int torneio=myinputs.Ler.umInt();
                            
                            for(int u=0;u<TORNEIOS.size();u++){
                                if(TORNEIOS.elementAt(u).getIDD()==torneio){
                                    posicao5=u;
                                    bandeira++;
                                }
                            }
                            
                            if(TORNEIOS.elementAt(posicao5).Cheio()==true){
                                System.out.println("Torneio já com 2 Jogadores inscritos");
                                opcaoT=0;
                                break;
                            }
                            
                            else{
                            
                            if(bandeira==0){
                                System.out.println("O ID de Torneio não existe!");
                                opcaoT=0;
                                break;
                            }
                            
                            
                            for(int i=0;i<JOGADORES.size();i++){
                                System.out.println(JOGADORES.elementAt(i).toString());
                                
                            }
                            bandeira=0;
                            System.out.println("\n\nInsira o id do Jogador :");
                            int id_jogador=myinputs.Ler.umInt();
                            
                            for(int i=0;i<JOGADORES.size();i++){
                                if(JOGADORES.elementAt(i).getIDD()==id_jogador){
                                    posicao_jogador=i;
                                    bandeira++;
                                    
                                }
                            }
                            if(bandeira==0){
                                System.out.println("Jogador não existe");
                                opcaoT=0;
                                break;
                            }
                            bandeira=0;
                            if(TORNEIOS.elementAt(posicao5).verificaJOGADOR(JOGADORES.elementAt(posicao_jogador))!=true && TORNEIOS.elementAt(posicao5).Cheio()!=true)   {   
                            TORNEIOS.elementAt(posicao5).addJogador(JOGADORES.elementAt(posicao_jogador));
                            System.out.println("Jogador inscrito");
                            bandeira++;
                            opcaoT=0;
                            break;
                           }
                          
                            if(bandeira==0){
                                System.out.println("Jogador não inscrito porque já esta no torneio!");
                            }
                            opcaoT=0;
                            break;
                           
                        }
                        
                    }}
            
}
            public static void menuEstatisticas(Vector<Jogador> JOGADORES,Vector<Torneio> TORNEIOS){
          
                
                    System.out.println("---------ESTATISTICAS----------");
                    System.out.println("- 1.       Mais Vitorias      -");
                    System.out.println("- 2.     Mais € em Premios    -");
                    System.out.println("- 3.       Mais Derrotas      -");
                    System.out.println("- 4.        NºTorneios        -");
                    System.out.println("- 5.    Mais Participações    -");
                    System.out.println("- 0.          Sair            -");
                    System.out.println("-------------------------------");
                    int opcaoE = myinputs.Ler.umInt();
                    
                    while(opcaoE!=0){
                        
                        switch(opcaoE){
                            
                            
                            case 0:
                                opcaoE=0;
                                break;
                                
                            case 1:
                                    int wins=0;
                                    int id_melhor=0;
                                
                                for(int i=0;i<JOGADORES.size();i++){
                                    if(JOGADORES.elementAt(i).getWins()>wins){
                                        wins=JOGADORES.elementAt(i).getWins();
                                        id_melhor=JOGADORES.elementAt(i).getIDD();
                                    }    
                                    }
                                
                                for(int i=0;i<JOGADORES.size();i++){
                                    if(JOGADORES.elementAt(i).getIDD()==id_melhor){
                                        System.out.println(JOGADORES.elementAt(i).getNome() + " com " + JOGADORES.elementAt(i).getWins() + " vitorias");
                                    }
                                }
                                
                                opcaoE=0;
                                break;
                                
                            case 2:
                                    int id=0;
                                    int ganhos=0;
                                    
                                    
                                    for(int i=0;i<JOGADORES.size();i++){
                                        if(JOGADORES.elementAt(i).getPremios()>ganhos){
                                            id=JOGADORES.elementAt(i).getIDD();
                                            ganhos=JOGADORES.elementAt(i).getPremios();
                                        }
                                    }
                                    for(int i=0;i<JOGADORES.size();i++){
                                    if(JOGADORES.elementAt(i).getIDD()==id){
                                        System.out.println(JOGADORES.elementAt(i).getNome() + " com " + JOGADORES.elementAt(i).getPremios() + "€");
                                    }
                                    opcaoE=0;
                                    break;
                        }
                                     opcaoE=0;
                                     break;
                                    
                            case 3:
                                
                                    int loses=0;
                                    int id_pior=0;
                                
                                for(int i=0;i<JOGADORES.size();i++){
                                    if(JOGADORES.elementAt(i).getLoses()>loses){
                                        loses=JOGADORES.elementAt(i).getLoses();
                                        id_pior=JOGADORES.elementAt(i).getIDD();
                                    }    
                                    }
                                
                                for(int i=0;i<JOGADORES.size();i++){
                                    if(JOGADORES.elementAt(i).getIDD()==id_pior){
                                        System.out.println(JOGADORES.elementAt(i).getNome() + " com " + JOGADORES.elementAt(i).getLoses() + " derrotas");
                                    }
                                }
                                 opcaoE=0;
                                 break;
                    
                        
                        
                            case 4:
                                int finalizados=0;
                                int porJogar=0;
                                for(int i=0;i<TORNEIOS.size();i++){
                                    if(TORNEIOS.elementAt(i).getEstado().equals("FINALIZADO")){
                                        finalizados++;
                                    }
                                    if(TORNEIOS.elementAt(i).getEstado().equals("POR JOGAR")){
                                        porJogar++;
                                    }
                                }
                                System.out.println("Num total de " + (finalizados+porJogar) +" Torneios Criados"+ "\n"+ porJogar + " Estão por Jogar"+ "\n"+ finalizados + " Já estão finalizados");
                                opcaoE=0;
                                break;
                                
                            case 5:
                                int total=0;
                                int w=0;
                                int d=0;
                                int posicao=0;
                                for(int i=0;i<JOGADORES.size();i++){
                                   d=JOGADORES.elementAt(i).getLoses();
                                   w=JOGADORES.elementAt(i).getWins();
                                   if((d+w)>total){
                                       posicao=i;
                                       total=(d+w);
                                       
                                   }
                                }
                                System.out.println("O Jogador com mais Participações é :" + JOGADORES.elementAt(posicao).getNome() + "\n Com : " + w +" Vitorias  e " + d + "Derrotas" );
                                opcaoE=0;
                                break;
                        }
                    
            }}
            
            public static void menuLIVE(Vector<Torneio> TORNEIOS,Vector<Jogador> JOGADORES){
                int posicao=0;
                int bandeira=1;
                int flag=0;
                
                while(bandeira!=0){
                    System.out.println("---------LIVE!---------");
                    System.out.println("- 1. Escolher Torneio -");
                    System.out.println("-----------------------");
                    int id_torneio = myinputs.Ler.umInt();
                    
                    for(int i=0;i<TORNEIOS.size();i++){
                        if(TORNEIOS.elementAt(i).getIDD()==id_torneio){
                            posicao=i;
                        }
                    }
                    if(TORNEIOS.elementAt(posicao).Cheio()!=true){
                        System.out.println("Jogo ainda sem 2 Jogadores inscritos!");
                         bandeira=1;
                         break; 
                    }
                   
                    else{
                   
                   int  id0=TORNEIOS.elementAt(posicao).returnID0();
                   int id1=TORNEIOS.elementAt(posicao).returnID1();
                    
                    
                   
                    while(TORNEIOS.elementAt(posicao).verificaVencedor()==2){
                    System.out.println("----------LIVE!-----------");
                    System.out.println("- 1. Para Set 1ºJogador-");
                    System.out.println("- 2. Para Set 2ºJogador-");
                    System.out.println("--------------------------");
                    int opcao=myinputs.Ler.umInt();
                    
                    if(opcao==1){
                        TORNEIOS.elementAt(posicao).addSet1();
                    }
                    if(opcao==2){
                        TORNEIOS.elementAt(posicao).addSet2();
                    }
                        System.out.println("-----------------------------------");
        System.out.println("Jogador->  "+TORNEIOS.elementAt(posicao).getJogador().elementAt(0).getNome() +
        "    SETS ->"+ TORNEIOS.elementAt(posicao).getSetPlayer1());
        System.out.println("Jogador->  "+TORNEIOS.elementAt(posicao).getJogador().elementAt(1).getNome() +
        "    SETS ->"+ TORNEIOS.elementAt(posicao).getSetPlayer2());
                        System.out.println("-----------------------------------");
                    flag=1;
                    }
                    int vencedor=TORNEIOS.elementAt(posicao).verificaVencedor();
                    int premio_v=TORNEIOS.elementAt(posicao).getPremio1();
                    int premio_d=TORNEIOS.elementAt(posicao).getPremio2();
                    if(flag==1){
                        
                        if(vencedor==1){
                            
                            for(int i=0;i<JOGADORES.size();i++){
                                if(JOGADORES.elementAt(i).getIDD()==id1){
                                    String nome= JOGADORES.elementAt(i).getNome();
                                    TORNEIOS.elementAt(posicao).addVENCEDOR(nome);
                                    System.out.println("Jogador :"+ JOGADORES.elementAt(i).getNome()+ " é o vencedor!!");
                                    JOGADORES.elementAt(i).setWins(1);
                                    JOGADORES.elementAt(i).addPREMIO(premio_v);
                                }
                                if(JOGADORES.elementAt(i).getIDD()==id0){
                                    JOGADORES.elementAt(i).setLoses(1);
                                    JOGADORES.elementAt(i).addPREMIO(premio_d);
                                }
                            }
                            }
                            
                        
                        
                        if(vencedor==0){
                            
                            for(int i=0;i<JOGADORES.size();i++){
                                if(JOGADORES.elementAt(i).getIDD()==id0){
                                    String nome= JOGADORES.elementAt(i).getNome();
                                    TORNEIOS.elementAt(posicao).addVENCEDOR(nome);
                                    System.out.println("Jogador :"+ JOGADORES.elementAt(i).getNome()+ " é o vencedor!!");
                                    JOGADORES.elementAt(i).setWins(1);
                                    JOGADORES.elementAt(i).addPREMIO(premio_v);
                                    
                                }
                                if(JOGADORES.elementAt(i).getIDD()==id1){
                                    JOGADORES.elementAt(i).setLoses(1);
                                    JOGADORES.elementAt(i).addPREMIO(premio_d);
                                }
                            }
                            }
                            
                        }
                        
                    }
                        
                    
            
                    
                    
                    System.out.println("PROVA FINALIZADA");
                    
                    TORNEIOS.elementAt(posicao).changeEstado(1);
                    bandeira=1;
                    break;
                        
          }
                   
            }
}
    
    

