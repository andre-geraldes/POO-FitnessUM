package novo_tp_poo;

/**
 * Class Canoagem.
 * 
 * @author Grupo22 
 * @version 1.0
 */
public class Canoagem extends Actividade implements Meteorologia, Distancia, Tempo
{
    // instance variables
    private String desporto;
    private double duracao;
    private double calorias;
    private double distancia;
    private double vel_media;
    private double vel_maxima;
    private double alt_min;
    private double alt_max;
    private double total_des;
    private String meteorologia;
    
    /** 
    * Construtores
    * 1 - Parametrizado
    */
    public Canoagem(String desp, double du, double km, double max, double amin, double amax, double des, String m)
    {
        this.desporto = desp;
        this.duracao = du;
        this.calorias = calculaCalorias();
        this.distancia = km;
        this.vel_media = calculaVel_media();
        this.vel_maxima = max;
        this.alt_min = amin;
        this.alt_max = amax;
        this.total_des = des;
        this.meteorologia = m;
    }
    
    /**
    * 2 - Copia
    */
    public Canoagem(Canoagem c)
    {
        this.desporto = c.getDesporto();
        this.duracao = c.getDuracao();
        this.calorias = c.getCalorias();
        this.distancia = c.getDistancia();
        this.vel_media = c.getVel_media();
        this.vel_maxima = c.getVel_maxima();
        this.alt_min = c.getAlt_min();
        this.alt_max = c.getAlt_max();
        this.total_des = c.getTotal_des();
        this.meteorologia = c.getMeteorologia();
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
    
    public double getAlt_min()           {return this.alt_min;}
    
    public double getAlt_max()           {return this.alt_max;}
    
    public double getTotal_des()         {return this.total_des;}
    
    public String getMeteorologia()     {return this.meteorologia;}
     
    /**
    * 2 - Sets
    */
    public void setDesporto(String desp)        {this.desporto = desp;}
    
    public void setDuracao(double d)             {this.duracao = d;}
    
    public void setCalorias(double c)              {this.calorias = c;}
    
    public void setDistancia(double km)          {this.distancia = km;}
    
    public void setVel_media(double med)         {this.vel_media = med;}
   
    public void setVel_maxima(double max)        {this.vel_maxima = max;}
    
    public void setAlt_min(double min)           {this.alt_min = min;}
    
    public void setAlt_max(double amax)          {this.alt_max = amax;}
    
    public void setTotal_des(double des)         {this.total_des = des;}
    
    public void setMeteorologia(String m)       {this.meteorologia = m;}
    
    
    /**
    * 3 - Outros
    */
   public double calculaCalorias() {
       this.calorias = 0.083 * this.duracao /*** (Peso)*/;
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
            Canoagem u = (Canoagem) o;
            return (this.desporto.equals(u.getDesporto()));
        }
    }
   
      
   /**
    * 5 - Clone
   */  
   public Canoagem clone()
   {
       return new Canoagem(this);
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
        return new String("Desporto: " + this.getDesporto() + "\nMeteo: " + this.getMeteorologia() + "\nDuracao: " + this.getDuracao() + "\nDistancia: " + this.getDistancia() + "\nCalorias: " + this.getCalorias() + "\nVelocidade média: " + this.getVel_media());
    }
}
