package novo_tp_poo;

/**
 * Write a description of class Natacao here.
 * 
 * @author Grupo22 
 * @version 1.0
 */
public class Natacao extends Actividade implements Distancia, Tempo
{
    // instance variables
    private String desporto;
    private double duracao;
    private double calorias;
    private double distancia;
    private double vel_media;
    private double vel_maxima;
    
    /** 
    * Construtores
    * 1 - Parametrizado
    */
    public Natacao(String desp, double d, double km, double max)
    {
        this.desporto = desp;
        this.duracao = d;
        this.calorias = calculaCalorias();
        this.distancia = km;
        this.vel_media = calculaVel_media();
        this.vel_maxima = max;
    }
    
    /**
    * 2 - Copia
    */
    public Natacao(Natacao n)
    {
        this.desporto = n.getDesporto();
        this.duracao = n.getDuracao();
        this.calorias = n.getCalorias();
        this.distancia = n.getDistancia();
        this.vel_media = n.getVel_media();
        this.vel_maxima = n.getVel_maxima();
    }
    
     /**
    * Metodos
    * 1 - Gets
    */
    public String getDesporto()         {return this.desporto;}
    
    public double getDuracao()           {return this.duracao;}
    
    public double getCalorias()            {return this.calorias;}
    
    public double getDistancia()         {return this.distancia;}
    
    public double getVel_media()         {return this.vel_media;}
    
    public double getVel_maxima()        {return this.vel_maxima;}
    
    /**
    * 2 - Sets
    */
    public void setDesporto(String desp)    {this.desporto = desp;}
    
    public void setDuracao(double d)         {this.duracao = d;}
    
    public void setCalorias(double c)          {this.calorias = c;}
    
    public void setDistancia(double km)      {this.distancia = km;}
    
    public void setVel_media(double med)     {this.vel_media = med;}
   
    public void setVel_maxima(double max)    {this.vel_maxima = max;}
    
    /**
    * 3 - Outros
    */
   public double calculaCalorias() {
       this.calorias = 0.133 * this.duracao /*** (Peso)*/;
       return this.calorias;
   }
   
   public double calculaVel_media(){
       this.vel_media = this.distancia/this.duracao;
       return this.vel_media*60;
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
            Natacao u = (Natacao) o;
            return (this.desporto.equals(u.getDesporto()));
        }
            
    }
    
   /**
   * 5 - Clone
   */
   public Natacao clone()
   {
       return new Natacao(this);
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
        return new String("Desporto: " + this.getDesporto() + "\nDuracao: " + this.getDuracao() + "\nDistancia: " + this.getDistancia() + "\nCalorias: " + this.getCalorias() + "\nVelocidade média: " + this.getVel_media());
    }
}
