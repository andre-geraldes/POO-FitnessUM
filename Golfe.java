package novo_tp_poo;

/**
 * Classe Golfe.
 * 
 * @author Grupo22 
 * @version 1.0
 */
public class Golfe extends Actividade implements Meteorologia, Distancia, Tempo
{
    //instance variables
    private String desporto;
    private String meteorologia;
    private double duracao;
    private double calorias;
    private double distancia;
    
    /**
     * Construtores
     * 1 - Parametrizado
     */
    public Golfe(String desp ,String m, double d, double km)
    {
        this.desporto = desp;
        this.meteorologia = m; 
        this.duracao = d;
        this.calorias = calculaCalorias();
        this.distancia = km;
    }
    
    /**
     * 2 - Copia 
     */
    public Golfe(Golfe g)
    {
        this.desporto = g.getDesporto();
        this.meteorologia = g.getMeteorologia();
        this.duracao = g.getDuracao();
        this.calorias = g.getCalorias();
        this.distancia = g.getDistancia();
    }
    
    /**
     * Metodos
     * 1 - Gets
     */
    public String getDesporto()         {return this.desporto;}
    
    public String getMeteorologia()     {return this.meteorologia;}
    
    public double getDuracao()          {return this.duracao;}
    
    public double getCalorias()            {return this.calorias;}
    
    public double getDistancia()        {return this.distancia;}
    
    /**
     * 2 - Sets
     */
    public void setDesporto(String desp)       {this.desporto = desp;}
    
    public void setMeteorologia(String m)   {this.meteorologia = m;}
    
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
            Golfe u = (Golfe) o;
            return (this.desporto.equals(u.getDesporto()));
        }
            
    }
    
    /**
     * 5 - Clone
     */
    public Golfe clone()
    {
        return new Golfe(this);
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
        return new String("Desporto: " + this.getDesporto() + "\nMeteo: " + this.getMeteorologia() + "\nDuracao: " + this.getDuracao() + "\nDistancia: " + this.getDistancia() + "\nCalorias: " + this.getCalorias());
    }
    
}
