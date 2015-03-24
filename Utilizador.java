package novo_tp_poo;

import java.util.*;
import java.io.*;
/**
 * Classe Utilizador.
 * 
 * @author Grupo22 
 * @version 1.0
 */

public class Utilizador implements Serializable
{
    /**
     * Variaveis de instancia
     */
    private String            email;
    private String            pw;
    private String            nome;
    private String            genero;
    private int               altura;
    private int               peso;
    private GregorianCalendar data;
    private String            favorito;
    
    private TreeMap<String,Utilizador> amigos      = new TreeMap<String,Utilizador>();
    private ArrayList<Utilizador>      pedidos     = new ArrayList<Utilizador>();
    
    private ArrayList<Actividade>      actividades = new ArrayList<Actividade>();
    //recordes
    //eventos
    
    /**
     * Contrutores
     * 1 - Vazio
     */
    public Utilizador()
    {
        this.email    = "";
        this.pw       = "";
        this.nome     = "";
        this.genero   = "";
        this.altura   = 1;
        this.peso     = 1;
        this.data     = new GregorianCalendar();
        this.favorito = "";
        
    }
    
    /**
     * 2 - Parametrizad
     */
    public Utilizador(String email, String pw, String nome, String genero, int altura, int peso, int dia, int mes, int ano, String actividade)
    {
        this.email    = email;
        this.pw       = pw;
        this.nome     = nome;
        this.genero   = genero;
        this.altura   = altura;
        this.peso     = peso;
        this.data     = new GregorianCalendar(ano,mes,dia);
        this.favorito = actividade;
        
    }
    
    /**
     * 3 - Copia
     */
    public Utilizador(Utilizador u)
    {
        this.email    = u.getEmail();
        this.pw       = u.getPw();
        this.nome     = u.getNome();
        this.genero   = u.getGenero();
        this.altura   = u.getAltura();
        this.peso     = u.getPeso();
        this.data     = u.getData();
        this.favorito = u.getFavorito();
        this.amigos   = u.getAmigos();
    }
    
    /**
     * Metodos
     * 1 -Gets
     */
    public String getEmail() {return this.email;}
    
    public String getPw()    {return this.pw;}
    
    public String getNome()  {return this.nome;}
    
    public String getGenero()  {return this.genero;}
    
    public int getAltura()   {return this.altura;}
    
    public int getPeso()     {return this.peso;}
    
    public GregorianCalendar getData()  {return this.data;}
    
    public String getFavorito()     {return this.favorito;}
    
    public TreeMap<String,Utilizador> getAmigos() {return this.amigos;}
    
    public ArrayList<Actividade> getActividades() {return this.actividades;}
    
    /**
     * 2 - Sets
     */
    public void setEmail(String e)        {this.email = e;}
    
    public void setPw(String p)           {this.pw = p;}
    
    public void setNome(String n)          {this.nome = n;}
    
    public void setGenero(String g)         {this.genero = g;}
    
    public void setAltura(int a)          {this.altura = a;}
    
    public void setPeso(int p)            {this.peso = p;}
    
    public void setData(GregorianCalendar d) {this.data = d;}
    
    public void setFavorito(String a)    {this.favorito = a;}
    
    public void setAmigos(TreeMap<String,Utilizador> a) {this.amigos = a;}
    
    /**
     * 3 - Outros
     */
    
    /**
     * Calcular idade
     */
    public int calculaIdade(){
        GregorianCalendar agora = new GregorianCalendar();
        int mes = this.getData().get(Calendar.MONTH);
        int dia = this.getData().get(Calendar.DAY_OF_MONTH);
        int ano = this.getData().get(Calendar.YEAR);
        int mesAtual = agora.get(Calendar.MONTH) + 1;
        int diaAtual = agora.get(Calendar.DAY_OF_MONTH);
        int anoAtual = agora.get(Calendar.YEAR); 
        int idade = anoAtual - ano - 1;
        
        if (mes == mesAtual){
            if (dia >= diaAtual) idade++;
        }
        else if (mes < mesAtual) idade++;
        
        return idade;
    }
    /**
     * Pedidos de Amizade
     * Envia pedido de amizade
     */
    public void enviaPedido(Utilizador u) throws Excepcoes {
        if(u.pedidos.contains(this)) {
            throw new Excepcoes("Ja enviou pedido a este utilizador.");
        } else {
            u.pedidos.add(this.clone());
        }
    }
    /**
     * Aceita pedido de amizade
     */
    public void aceitaPedido(Utilizador u) throws Excepcoes {
        if(this.pedidos.contains(u.clone())) {
            this.pedidos.remove(u.clone());
            this.addAmigo(u.clone());
            u.addAmigo(this);
        } else {
            throw new Excepcoes("Nao existe pedido de amizade deste utilizador.");
        }   
    }
    /**
     * Adiciona amigo
     */
    public void addAmigo(Utilizador a) throws Excepcoes {
        if (this.amigos.containsKey(a.getEmail())) {
            throw new Excepcoes("Ja tem este utilizador como amigo.");
        } else {
            this.amigos.put(a.getEmail(),a.clone());
        }
    }
    /**
     * Remover amigo
     */
    public void remAmigo(Utilizador a) throws Excepcoes {
        if(this.amigos.containsKey(a.getEmail())) {
            this.amigos.remove(a.getEmail());
        } else {
            throw new Excepcoes("Nao tem este utilizador como amigo.");
        }
    }
    /**
     * Retorna o ArrayList com os pedidos pendentes
     */
    public ArrayList<Utilizador> getPedidos() {
        return this.pedidos;
    }
    
    /**
     * Actividades 
     * Adiciona actividade
     */
    public void addActividade(Actividade a) {
        this.actividades.add(a);
    }
    /**
     * Remove actividade
     */
    public void removeActividade(int i) {
        this.actividades.remove(i);
    }
    /**
     * Dez actividades mais recentes
     */
    public ArrayList<Actividade> dezActividades(Utilizador u) {
        int i=0,size;
        Actividade a;
        size = u.actividades.size();
        ArrayList<Actividade> lista = new ArrayList<Actividade>(10);
        for(i=0;i<10 && i<size;i++){
            a = u.actividades.get(size-1-i);
            lista.add(a);
        }
        return lista;
    }
    /**
     * Actividade detalhada
     * indice ou data
     */
    public Actividade actividadeDetalhada(int indice) throws Excepcoes {
        if(this.actividades.size() < indice) {
            throw new Excepcoes("Indice invalido.");
        } else {
            return this.actividades.get(indice);
        }
    }
    /**
     * Verifica se um utilizador praticou determinada actividade
     */
    public boolean jaPraticou(Actividade a) {
        return this.actividades.contains(a);
    }
            
    /**
     * Eventos
     * Inscrever num evento
     */
    public void inscreveEvento(Evento e) throws Excepcoes {
        if(this.jaPraticou(e.getActividade())) {
            e.inscrever(this);
        } else {
            throw new Excepcoes("O utilizador nunca practicou esta modalidade.");
        }
        
    }
    
     /**
     * Aceder estatisticas em funcao distancia, tempo e calorias 
     */
    public String estatisticas() {
        double distancia=0;
        double tempo=0;
        double calorias=0;
        
        for(Actividade a : this.actividades) { 
            if(a instanceof Caminhada) {
                Caminhada novo = (Caminhada) a;
                distancia += novo.getDistancia();
                tempo += novo.getDuracao();
                calorias += novo.getCalorias();
            }
            else if(a instanceof Hoquei) {
                Hoquei novo = (Hoquei) a;
                distancia += novo.getDistancia();
                tempo += novo.getDuracao();
                calorias += novo.getCalorias();
            } 
            else if(a instanceof Tenis) {
                Tenis novo = (Tenis) a;
                tempo += novo.getDuracao();
                calorias += novo.getCalorias();
            } 
            else if(a instanceof Ciclismo) {
                Ciclismo novo = (Ciclismo) a;
                distancia += novo.getDistancia();
                tempo += novo.getDuracao();
                calorias += novo.getCalorias();
            } 
            else if(a instanceof Golfe) {
                Golfe novo = (Golfe) a;
                distancia += novo.getDistancia();
                tempo += novo.getDuracao();
                calorias += novo.getCalorias();
            } 
            else if(a instanceof Canoagem) {
                Canoagem novo = (Canoagem) a;
                distancia += novo.getDistancia();
                tempo += novo.getDuracao();
                calorias += novo.getCalorias();
            } 
            else if(a instanceof ArtesMarciais) {
                ArtesMarciais novo = (ArtesMarciais) a;
                tempo += novo.getDuracao();
                calorias += novo.getCalorias();
            } 
            else if(a instanceof Futsal) {
                Futsal novo = (Futsal) a;
                distancia += novo.getDistancia();
                tempo += novo.getDuracao();
                calorias += novo.getCalorias();
            } 
            else if(a instanceof Orientacao) {
                Orientacao novo = (Orientacao) a;
                distancia += novo.getDistancia();
                tempo += novo.getDuracao();
                calorias += novo.getCalorias();
            } 
            else if(a instanceof Corrida) {
                Corrida novo = (Corrida) a;
                distancia += novo.getDistancia();
                tempo += novo.getDuracao();
                calorias += novo.getCalorias();
            } 
            else if(a instanceof Musculacao) {
                Musculacao novo = (Musculacao) a;
                tempo += novo.getDuracao();
                calorias += novo.getCalorias();
            }
            else if (a instanceof Natacao) {
                Natacao novo = (Natacao) a;
                distancia += novo.getDistancia();
                tempo += novo.getDuracao();
                calorias += novo.getCalorias();
            } else {
                continue;
            }
        }
        tempo = tempo/60; //passa para horas
        return new String("Total distancia percorrida: " + distancia + " kms\nTotal tempo dispendido: " + tempo + " h\nTotal calorias gastas: " + calorias + " kcal.");
    }
    
    /**
     * Equals
     */
    public boolean equals (Object o) {
        if(this == o) {
            return true;
        }
        if((o == null) || (this.getClass() != o.getClass())) {
            return false;
        } else {
            Utilizador u = (Utilizador) o;
            return (this.email.equals(u.getEmail()));
        }
            
    }
    
    /**
     * Clone
     */
     public Utilizador clone() {
        return new Utilizador(this);
    }
    
    /**
     * Imprime TreeMap
     */
    public String imprimeTM(Map<String,Utilizador> m) {
        StringBuilder sb = new StringBuilder();
        for(Utilizador u : m.values()) {
            sb.append(u.toString() + "\n");
        }
        return sb.toString();
    }
    
    /**
     * Imprime ArrayList
     */
    public String imprimeALU(List<Utilizador> l) {
        StringBuilder sb = new StringBuilder();
        for(Utilizador u : l) {
            sb.append(u.toString() + "\n");
        }
        return sb.toString();
    }
    
    /**
     * Imprime ArrayList de actividades
     */
    public String imprimeALA(List<Actividade> l) {
        StringBuilder sb = new StringBuilder();
        int i = 1;
        for(Actividade u : l) {
            sb.append(i++ + " - " + u.toString() + "\n");
        }
        return sb.toString();
    }
    
    /**
     * Imprime actividades por ordem
     */
    public String imprimeAPO(int i) {
        int j=i;
        StringBuilder sb = new StringBuilder();
        Actividade a;
        
        while(j<(i+10) && j<this.actividades.size()) {
            a = this.actividades.get(j);
            sb.append(j+1 + " - " + a.toString() + "\n");
            j++;
        }
        return sb.toString();
    }
   
    /**
     * Imprime detalhes duma dada actividade a
     */
    public String imprimeAD(Actividade a) {
        if(a instanceof Caminhada) {
            Caminhada novo = (Caminhada) a;
            return novo.toStringD();
        }
        else if(a instanceof Hoquei) {
            Hoquei novo = (Hoquei) a;
            return novo.toStringD();
        } 
        else if(a instanceof Tenis) {
            Tenis novo = (Tenis) a;
            return novo.toStringD();
        } 
        else if(a instanceof Ciclismo) {
            Ciclismo novo = (Ciclismo) a;
            return novo.toStringD();
        } 
        else if(a instanceof Golfe) {
            Golfe novo = (Golfe) a;
            return novo.toStringD();
        } 
        else if(a instanceof Canoagem) {
            Canoagem novo = (Canoagem) a;
            return novo.toStringD();
        } 
        else if(a instanceof ArtesMarciais) {
            ArtesMarciais novo = (ArtesMarciais) a;
            return novo.toStringD();
        } 
        else if(a instanceof Futsal) {
            Futsal novo = (Futsal) a;
            return novo.toStringD();
        } 
        else if(a instanceof Orientacao) {
            Orientacao novo = (Orientacao) a;
            return novo.toStringD();
        } 
        else if(a instanceof Corrida) {
            Corrida novo = (Corrida) a;
            return novo.toStringD();
        } 
        else if(a instanceof Musculacao) {
            Musculacao novo = (Musculacao) a;
            return novo.toStringD();
        }
        else if (a instanceof Natacao) {
            Natacao novo = (Natacao) a;
            return novo.toStringD();
        } else {
            return new String();
        }
        
    }
    
    /**
     * toString
     */
    public String toString() {
        return new String ("Nome: " + this.getNome() + " Email: " + this.getEmail() + ".");
    }
}
