package novo_tp_poo;
/**
 * Abstract class Actividade
 * 
 * @author Grupo22
 * @version 1.0
 */
import java.util.GregorianCalendar;
import java.io.*;

public abstract class Actividade implements Serializable
{
   private GregorianCalendar inicio;
   private GregorianCalendar fim;
   /**
   public Actividade(GregorianCalendar i, GregorianCalendar f) {
       this.inicio = i;
       this.fim = f;
   }
   */
   public GregorianCalendar getInicio() {
       return this.inicio;
   }
   
   public GregorianCalendar getFim() {
       return this.fim;
   }
   
   public void setInicio() {
       inicio = new GregorianCalendar();
   }
   
   public void setFim() {
       fim = new GregorianCalendar();
   }
   
}
