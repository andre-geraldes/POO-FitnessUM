package novo_tp_poo;

/**
 * Class Futsal.
 * 
 * @author Grupo22 
 * @version 1.0
 */

public class Futsal extends Actividade implements Distancia, Tempo
{
    //instance variables
    private String desporto;
    private double duracao;
    private double calorias;
    private double distancia;
    
    /**
     * Construtores
     * 1 - Parametrizado
     */
    public Futsal(String desp, double d, double km)
    {
        this.desporto = desp; 
        this.duracao = d;
        this.calorias = calculaCalorias();
        this.distancia = km;
    }
    
    /**
     * 2 - Copia 
     */
    public Futsal(Futsal g)
    {
        this.desporto = g.getDesporto();
        this.duracao = g.getDuracao();
        this.calorias = g.getCalorias();
        this.distancia = g.getDistancia();
    }
    
    /**
     * Metodos
     * 1 - Gets
     */
    public String getDesporto()         {return this.desporto;}
    
    public double getDuracao()          {return this.duracao;}
    
    public double getCalorias()            {return this.calorias;}
    
    public double getDistancia()        {return this.distancia;}
    
    /**
     * 2 - Sets
     */
    public void setDesporto(String desp)       {this.desporto = desp;}
    
    public void setDuracao(double d)        {this.duracao = d;}
    
    public void setCalorias(double c)          {this.calorias = c;}
    
    public void setDistancia(double km)     {this.distancia = km;}
    
    /**
     * 3- Outros
     */
    public double calculaCalorias() {
       this.calorias = 0.075 * this.duracao /*** (Peso)*/;
       return this.calorias;
   }
   
   public String minToHoras(){
       int hora = 0, min = 0;
       
       hora = (int)this.duracao/60;
       min = (int)this.duracao % 60;
           
       return String.format("%d:%dh", hora, min);
    }
    
    /**
     * 4 - Equals
     */
     public boolean equals (Object o) {
        if(this == o) {
            return true;
        }
        if((o == null) || (this.getClass() != o.getClass())) {
            return false;
        } else {
            Futsal u = (Futsal) o;
            return (this.desporto.equals(u.getDesporto()));
        }
            
    }
    
    /**
     * 5 - Clone
     */
    public Futsal clone()
    {
        return new Futsal(this);
    }
    
    /**
     * 6 - toString
     */
    public String toString(){
        return new String("Desporto: " + this.getDesporto() + ".");
    }
    
    /**
     * toString mais detalhado
     */
    public String toStringD() {
        return new String("Desporto: " + this.getDesporto() + "\nDuracao: " + this.getDuracao() + "\nDistancia: " + this.getDistancia() + "\nCalorias: " + this.getCalorias());
    }
    
}

