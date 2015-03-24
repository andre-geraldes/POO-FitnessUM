package novo_tp_poo;

/**
 * Class Musculacao.
 * 
 * @author Grupo22 
 * @version 1.0
 */
public class Musculacao extends Actividade implements Tempo
{
    // instance variables
    private String desporto;
    private double duracao;
    private double calorias;
    
    /** 
    * Construtores
    * 1 - Parametrizado
    */
    public Musculacao(String desp, double d)
    {
        this.desporto = desp;
        this.duracao = d;
        this.calorias = calculaCalorias();
    }
    
    /**
    * 2 - Copia
    */
    public Musculacao(Musculacao m)
    {
        this.desporto = m.getDesporto();
        this.duracao = m.getDuracao();
        this.calorias = m.getCalorias();
    }
    
     /**
    * Metodos
    * 1 - Gets
    */
    public String getDesporto()     {return this.desporto;}
    
    public double getDuracao()      {return this.duracao;}
    
    public double getCalorias()        {return this.calorias;}
    
     /**
    * 2 - Sets
    */
    public void setDesporto(String desp)    {this.desporto = desp;}
    
    public void setDuracao(double d)       {this.duracao = d;}
    
    public void setCalorias(double c)         {this.calorias = c;}
    
    /**
    * 3 - Outros
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
            Musculacao u = (Musculacao) o;
            return (this.desporto.equals(u.getDesporto()));
        }
            
    }
   
   /**
    * 5 - Clone
   */ 
   public Musculacao clone()
   {
       return new Musculacao(this);
   }
   
   /**
    * 6 - toString
    */
   public String toString() {
        return new String ("Desporto: " + this.getDesporto() + ".");
    }
    
    /**
     * toString mais detalhado
     */
    public String toStringD() {
        return new String("Desporto: " + this.getDesporto() + "\nDuracao: " + this.getDuracao() + "\nCalorias: " + this.getCalorias());
    }
}
