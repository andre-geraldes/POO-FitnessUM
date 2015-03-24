package novo_tp_poo;


/**
 * Classe Rede de utilizadores.
 * 
 * @author Grupo22 
 * @version 1.0
 */

import java.util.*;
import java.io.*;

public class Rede implements Serializable
{
    private TreeMap<String,Utilizador> utilizadores;
    
   /**
    * Construtores
    * 1 - Vazio
    */
   public Rede() {
       this.utilizadores = new TreeMap<String,Utilizador>();
   }
   
   /**
    * 2 - Copia
    */
   public Rede(Rede r) {
       this.utilizadores = r.getUtilizadores();
   }
   
   /**
    * Metodos
    * 1 - Gets
    */
   public TreeMap<String,Utilizador> getUtilizadores() {
       TreeMap<String,Utilizador> aux = new TreeMap<String,Utilizador>();
       
       for(Utilizador u : this.utilizadores.values()) {
           aux.put(u.getEmail(),u.clone());
       }
       return aux;
   }
   
   public Utilizador getUtilizador(String email) {
       return this.utilizadores.get(email);
   }
   
   /**
    * 2 - Existe utilizador
    */
   public boolean existeUtilizador(String email) {
       return this.utilizadores.containsKey(email);
   }
   
   /**
    * 3 - Adicionar/Remover utilizadores
    */
   public void addUtilizador(Utilizador u) throws Excepcoes {
       if(this.utilizadores.containsKey(u.getEmail())) {
           throw new Excepcoes(u.getEmail());
       } else {
           this.utilizadores.put(u.getEmail(),u.clone());
       }
   }
   
   public void addUtilizadores(Set<Utilizador> utl) throws Excepcoes {
       for(Utilizador u : utl) {
           this.utilizadores.put(u.getEmail(),u.clone());
       }
   }
   
   public void remUtilizador(String email) throws Excepcoes {
       if(existeUtilizador(email)) {
           utilizadores.remove(email);
       } else {
           throw new Excepcoes(email);
       }
   }
   
   /**
    * 4 - toString
    */
   public String toString() {
       StringBuilder sb = new StringBuilder("--- Utilizadores ---\n");
       
       for(Utilizador u : this.utilizadores.values()) {
           sb.append(u.toString() + "\n");
       }
       
       return sb.toString();
   }
   
   /**
    * 5 - Equals
    */
   public boolean equals(Object obj) {
       if(this == obj) {return true;} 
       if((obj == null) || (this.getClass() != obj.getClass())) {
            return false;
        }
       Rede r = (Rede) obj;
       return this.utilizadores.equals(r.getUtilizadores());
  }  
   
  /**
   * 6 - Clone
   */ 
  public Rede clone() {
      return new Rede(this);
  } 
  
  /**
   * 7 - Guardar em ficheiro
   */
  public void gravaObj() throws IOException {
      FileOutputStream estado = new FileOutputStream("Estado.ser");
      ObjectOutputStream oos = new ObjectOutputStream(estado);
      oos.writeObject(utilizadores);
      oos.flush(); 
      oos.close();
  }
  
  /**
   * 8 - Carregar ficheiro
   */
      public void carregaObj() throws IOException {
       try{ 
           FileInputStream carreg = new FileInputStream("Estado.ser"); 
           ObjectInputStream ois = new ObjectInputStream(carreg); 
           utilizadores = new TreeMap<String,Utilizador>((TreeMap<String,Utilizador>)ois.readObject());
           ois.close(); 
        } catch(Throwable e){
            System.out.println("ERRO: " + e.getMessage()); 
        } 
    }
}


