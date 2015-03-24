package novo_tp_poo;

/**
 * Classe Eventos.
 * 
 * @author Grupo22 
 * @version 1.0
 */

import java.util.*;
import java.io.*;

public class Evento implements Serializable
{
   private String            nome;
   private GregorianCalendar data; //rever
   private int               inscritos;
   private int               capacidade;
   private String            desporto;
   private Actividade        actividade;
   private ArrayList<Utilizador> confirmados;
  
   /**
    * Construtores
    * 1 - Parametrizado
    */
   public Evento(String nome, int dia, int mes, int ano, int cap, String desp) {
       this.nome         = nome;
       this.data         = new GregorianCalendar(ano,mes,dia);
       this.inscritos    = 0;
       this.capacidade   = cap;
       this.desporto     = desp;
       this.confirmados  = new ArrayList<Utilizador>();
   }
   
   /**
    * 2 - Copia
    */
   public Evento(Evento e) {
       this.nome        = e.getNome();
       this.data        = e.getData();
       this.inscritos   = e.getInscritos();
       this.capacidade  = e.getCapacidade();
       this.desporto    = e.getDesporto();
       this.confirmados = e.getConfirmados();
   }
   
   /**
    * Metodos
    * 1 - Gets 
    */
   public String getNome() {return this.nome;}
   
   public GregorianCalendar getData() {return this.data;}
   
   public int getInscritos() {return this.inscritos;}
   
   public int getCapacidade() {return this.capacidade;}
   
   public String getDesporto() {return this.desporto;}
   
   public Actividade getActividade() {return this.actividade;}
   
   public ArrayList<Utilizador> getConfirmados() {return this.confirmados;}
   
   /**
    * 2 - Sets
    */
   public void setNome(String n) {this.nome = n;}
   
   public void setData(GregorianCalendar d) {this.data = d;}
   
   public void setCapacidade(int c) {this.capacidade = c;}
   
   public void setDesporto(String d) {this.desporto = d;}
   
   /**
    * 3 - Outros metodos
    */
   public boolean semVagas() {
       return (this.inscritos == this.capacidade);
   }
   
   //caso em que o utilizador nao tem registo de certa actividade
   public void inscrever(Utilizador u) throws Excepcoes {
       if(this.semVagas()) {
           throw new Excepcoes("\nNao existem vagas disponives.");
       } else if(this.confirmados.contains(u.clone())) {
           throw new Excepcoes("\nUtilizador ja esta inscrito.");
       } else {
           this.confirmados.add(u.clone());
           this.inscritos += 1;
       }   
   }
   
   
       
   
   
   
}
