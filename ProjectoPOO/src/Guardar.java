
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
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
public class Guardar {
    
    public void GUARDA_JOGADORES (Vector<Jogador> JOGADORES) throws IOException,ClassNotFoundException{
            
        File ficheiro = new File("jogadores.dat");
        
        
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(ficheiro));
        os.writeObject(JOGADORES);
        os.writeInt(Jogador.getID());
        os.flush();
        os.close();
    }
    
    public void GUARDA_TORNEIOS (Vector<Torneio> TORNEIOS) throws IOException,ClassNotFoundException{
            
        File ficheiro = new File("torneios.dat");
        
        
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(ficheiro));
        os.writeObject(TORNEIOS);
        os.writeInt(Torneio.getID());
        os.flush();
        os.close();
    }
}
