package novo_tp_poo;

/**
 * Classe Ciclismo .
 * 
 * @author Grupo22 
 * @version 1.0
 */

public class Ciclismo extends Actividade implements Altimetria, Meteorologia, Distancia, Tempo
{
   private String desporto;
   private String meteorologia;
   private double distancia;
   private double velocidade;
   private double calorias;
   private double duracao; //minutos
   private double    subiu;
   private double    desceu;
   private double    altitudeMax;
   private double    altitudeMin;
   
   /** 
    * Construtores
    * 1 - Parametrizado
    */
    public Ciclismo(String desp, double d, double km, double amin, double amax, double des, double sub, String m)
    {
        this.desporto = desp;
        this.duracao = d;
        this.calorias = calculaCalorias();
        this.distancia = km;
        this.altitudeMin = amin;
        this.altitudeMax = amax;
        this.velocidade = calculaVelocidade();
        this.desceu = des;
        this.subiu = sub;
        this.meteorologia = m;
    }
   
   /**
    * 2 - Copia
    */
   public Ciclismo(Ciclismo a) {
      this.desporto     = a.getDesporto(); 
      this.meteorologia = a.getMeteorologia();
      this.distancia    = a.getDistancia();
      this.velocidade   = a.getVelocidade();
      this.duracao      = a.getDuracao();
      this.calorias     = a.getCalorias();
      this.subiu        = a.getSubiu();
      this.desceu       = a.getDesceu();
      this.altitudeMax  = a.getAltitudeMax();
      this.altitudeMin  = a.getAltitudeMin();
    }
   
    /**
    * Metodos
    * 1 - Gets
    */
   public String getDesporto()     {return this.desporto;}
    
   public String getMeteorologia() {return this.meteorologia;}
    
   public double getDistancia()     {return this.distancia;}
    
   public double getVelocidade()    {return this.velocidade;}
    
   public double getDuracao()         {return this.duracao;}
   
   public double getCalorias()        {return this.calorias;}
    
   public double getSubiu()           {return this.subiu;}
    
   public double getDesceu()          {return this.desceu;}
    
   public double getAltitudeMax()     {return this.altitudeMax;}
    
   public double getAltitudeMin()     {return this.altitudeMin;}
   
   /**
    * 2 - Sets
    */
   public void setDesporto(String d)     {this.desporto = d;}
    
   public void setMeteorologia(String m) {this.meteorologia = m;}
    
   public void setDistancia(double d)     {this.distancia = d;}
    
   public void setVelocidade(double v)    {this.velocidade = v;}
    
   public void setDuracao(double d)         {this.duracao = d;}
    
   public void setCalorias(double c)        {this.calorias = c;}
    
   public void setSubiu(double s)           {this.subiu = s;}
    
   public void setDesceu(double d)          {this.desceu = d;}
    
   public void setAltitudeMax(double a)     {this.altitudeMax = a;}
    
   public void setAltitudeMin(double a)     {this.altitudeMin = a;}
   
   /**
    * 3 - Outros
    */
   public double calculaCalorias(){
       if (this.velocidade <= 6.5) {this.calorias = 0.083 * this.duracao/** * (Peso)*/; return this.calorias;}
       else {this.calorias = 0.111 * this.duracao /*** (Peso)*/; return this.calorias;} 
   }
   
   public double calculaVelocidade(){
       this.velocidade = this.distancia/this.duracao;
       return this.velocidade*60;
   } 
   
   public String minToHoras(){
       int hora = 0, min = 0;
       
       hora = (int)this.duracao/60;
       min = (int)this.duracao % 60;
           
       return String.format("%d:%dh", hora, min);
    }
    
   /**
    * Funcao que se actividades sao do mesmo desporto 
    */
   public boolean mesmoDesporto(Actividade a) {
       return (a instanceof Ciclismo);
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
            Ciclismo c = (Ciclismo) o;
            return (super.getInicio().equals(c.getInicio()));
        }
            
    }
   
   /**
    * 5 - Clone
    */
   public Ciclismo clone() {
        return new Ciclismo(this);
    }
   
   /**
    * 6 - toString
    */
   public String toString() {
        return new String ("Desporto: " + this.getDesporto() + "" + ".");
    }
    
    /**
     * toString mais detalhado
     */
    public String toStringD() {
        return new String("Desporto: " + this.getDesporto() + "\nMeteo: " + this.getMeteorologia() + "\nDuracao: " + this.getDuracao() + "\nDistancia: " + this.getDistancia() + "\nCalorias: " + this.getCalorias() + "\nVelocidade média: " + this.getVelocidade());
    }
   
}


