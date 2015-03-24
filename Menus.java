package projecto_bluej;

import java.util.*;
import java.io.*;
/**
 * Classe Menus.
 * 
 * @author Grupo22 
 * @version 1.0
 */
public class Menus
{
    private static Input inp;
    private static Rede rede = new Rede();
    private static Utilizador ut;
    private static Actividade act;
    
    /**
     * Menu Saudacao
     */
    public static void menuSaudacao() {
        System.out.println("    ______  _   __                                     __  __              "); 
        System.out.println("   / ____/ (_) / /_  _____   _____  _____  _____      / / / / ____ _____   ");
        System.out.println("  / /_    / / / __/ / __  / / _  / / ___/ / ___/     / / / / / __ `__  /   ");
        System.out.println(" / __/   / / / /_  / / / / /  __/ (__  ) (__  )     / /_/ / / / / / / /    ");
        System.out.println("/_/     /_/ /___/ /_/ /_/ /____/ /____/ /____/     /_____/ /_/ /_/ /_/ \n\n"); 
    }
    
        
    /**
     * Menu Inicial
     */
    public static void menuInicial() {
        int op = 0;
        System.out.println("--- Menu Inicial ---");
        System.out.println(" 1 - Login");
        System.out.println(" 2 - Registar");
        System.out.println(" 3 - Gravar");
        System.out.println(" 4 - Carregar");
        System.out.println(" 5 - Sair");
        
        op = inp.lerInt();
        switch(op) {
           case 1 : menuLogin(); break;
           case 2 : menuRegisto(); break;
           case 3 : { 
               try {
                   rede.gravaObj(); 
               } catch(IOException s) {
                   System.out.println(s);
               }
               menuInicial();
               break;
           } 
           case 4 :  { 
               try {
                   rede.carregaObj(); 
               } catch(IOException s) {
                   System.out.println(s);
               }
               menuInicial();
               break;
           } 
           case 5 :{
                System.out.println("Programa encerrado.");
                System.exit(0);
           } break;
           default : System.out.println("Opcao invalida.");
        }
        if(op < 1 || op > 5) {menuInicial();}
    }
    
    
    /**
     * Menu Login
     */
    public static void menuLogin() {
        String email,pw;
        boolean sair = false;
        
        System.out.println("\n--- MENU LOGIN ---");
        System.out.println("Email: ");
        email = inp.lerString();
        while(!rede.existeUtilizador(email) && !sair) {
            System.out.println("\nERRO: Dados incorretos. (Digite 'Sair' para  retornar ao menu inicial.");
            email = inp.lerString();
            if(email.equals("Sair")) {
                sair = true;
            }
        }
        if(!sair) {
            System.out.println("Password: ");
            pw = inp.lerString();
            ut = rede.getUtilizador(email);
            while(!pw.equals(ut.getPw())) {
                System.out.println("\nERRO: Email nao corresponde.");
                pw = inp.lerString();
            }
            menuUtilizador();
        } else {
            menuInicial();
        }
    }
    
    /**
     * Menu Registo
     */
    public static void menuRegisto() {
        String email,pw,nome,favorito,genero;
        int altura,peso,dia,mes,ano;
        GregorianCalendar data;
        Utilizador novo;       

        System.out.println("\n--- MENU REGISTO ---");
        
        System.out.println("Email: ");
        email = inp.lerString();
        while(rede.existeUtilizador(email) || email.equals("")) {
            System.out.println("\nERRO: Input invalido.");
            System.out.println("Email: ");
            email = inp.lerString();
        }
        
        System.out.println("Password (Min. 5 caracteres): ");
        pw = inp.lerString();
        //check
        while(pw.equals("") || pw.length() < 5) {
            System.out.println("\nERRO: Input invalido.");
            System.out.println("Password: ");
            pw = inp.lerString();
        }
        
        System.out.println("Nome: ");
        nome = inp.lerString();
        //check
        while(nome.equals("")) {
            System.out.println("\nERRO: Input invalido.");
            System.out.println("Nome: ");
            nome = inp.lerString();
        }
        
        System.out.println("Genero(M/F): ");
        genero = inp.lerString();
        //check
        while(!genero.equals("M") && !genero.equals("F")) {
            System.out.println("\nERRO: Input invalido.");
            System.out.println("Genero(M/F): ");
            genero = inp.lerString();
        }
        
        System.out.println("Altura: ");
        altura = inp.lerInt();
        while(altura < 1) {
            System.out.println("\nERRO: Input invalido.");
            altura = inp.lerInt();
        }
        
        System.out.println("Peso: ");
        peso = inp.lerInt();
        while(peso < 1) {
            System.out.println("\nERRO: Input invalido.");
            peso = inp.lerInt();
        }
        
        System.out.println("Data de Nascimento: ");
        System.out.println("Ano: ");
        ano = inp.lerInt();
        while (ano > 2014 || ano < 1850) {
            System.out.println("\nERRO: Input invalido.");
            System.out.println("Ano: ");
            ano = inp.lerInt();
        }
        System.out.println("M??s: ");
        mes = inp.lerInt();
        while (mes > 12 || mes <= 0) {
            System.out.println("\nERRO: Input invalido.");
            System.out.println("M??s: ");
            mes = inp.lerInt();
        }
        System.out.println("Dia: ");
        dia = inp.lerInt();
        if (mes == 2 && (( ((ano % 4) == 0) && (ano % 100 != 0) ) || ((ano % 400) == 0)))
            while (dia > 29 || dia <= 0) {
            System.out.println("\nERRO: Input invalido.");
            System.out.println("Dia: ");
            dia = inp.lerInt();
            }
        else if (mes == 2)
                    while (dia >= 29 || dia <= 0){
                        System.out.println("\nERRO: Input invalido.");
                        System.out.println("Dia: ");
                        dia = inp.lerInt();
                    }
        if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12)
            while (dia > 31 || dia <= 0){
                        System.out.println("\nERRO: Input invalido.");
                        System.out.println("Dia: ");
                        dia = inp.lerInt();
                    }
        else while (dia > 30 || dia <= 0){
                        System.out.println("\nERRO: Input invalido.");
                        System.out.println("Dia: ");
                        dia = inp.lerInt();
                    }
        //check
        
        System.out.println("Desporto Favorito: ");
        favorito = inp.lerString();
        while(favorito.equals("")) {
            System.out.println("\nERRO: Input invalido.");
            favorito = inp.lerString();
        }
        
        novo = new Utilizador(email,pw,nome,genero,altura,peso,dia,mes,ano,favorito);
        try {
            rede.addUtilizador(novo);
        } catch(Excepcoes e) {
            System.out.println("\nERRO: Ja existe um utilizador com esse email: " + e.getMessage());
        }
        System.out.println("Obrigado pelo seu registo!\n");
        menuInicial();
    }
    
    /**
     * Menu Utilizador
     */
    public static void menuUtilizador() {
        int op;
        System.out.println("--- MENU UTILIZADOR: " + ut.getNome() + " ---");
        System.out.println(" 1 - Actividades");
        System.out.println(" 2 - Amigos");
        System.out.println(" 3 - Historico de actividades");
        System.out.println(" 4 - Estatisticas");
        System.out.println(" 5 - Dados pessoais");
        System.out.println(" 6 - Voltar ao menu inicial.");
        
        op = inp.lerInt();
        
        switch(op) {
            case 1 : menuActividades(); break;
            case 2 : menuAmigos(); break;
            case 3 : menuHistorico(); break;
            case 4 : menuEstatisticas(); break;
            case 5 : menuDados(); break;
            case 6 : menuInicial(); break;
            default : {
                System.out.println("\nERRO: Op????o inv??lida\n");
            }
        }   
        if (op <= 0 || op > 6) menuUtilizador();
    }
    
    /**
     * Menu actividades
     */
    public static void menuActividades() {
        int op;
        
        System.out.println("--- MENU ACTIVIDADES ---");
        System.out.println("1 - Adicionar actividade;");
        System.out.println("2 - Consultar e remover actividades;");
        System.out.println("3 - Voltar ao menu anterior");
        
        op = inp.lerInt();
        
        switch(op) {
            case 1 : menuAdicionarActividade(); break;
            case 2 : menuRemoverActividade(); break;
            case 3 : menuUtilizador(); break;
            default : {
                System.out.println("\nERRO: Op????o inv??lida\n");
            }
        }   
        if (op <= 0 || op > 3) menuActividades();
        else if (op != 3) menuUtilizador();
        
    }
    
    /**
     * Menu adicionar actividade
     */
    public static void menuAdicionarActividade() {
        int op, calorias;    
        double duracao, distancia, vel_media, vel_max, alt_min, alt_max, total_des, total_sub;
        String desporto, meteorologia;
        
        System.out.println("--- REGISTO DE ATIVIDADES ---");
        System.out.println(" 0 - Voltar ao menu anterior");
        System.out.println(" 1 - Artes Marciais   7 - Golfe");
        System.out.println(" 2 - Caminhada        8 - H??quei em Patins");
        System.out.println(" 3 - Canoagem         9 - Muscula????o");
        System.out.println(" 4 - Ciclismo        10 - Nata????o ");
        System.out.println(" 5 - Corrida         11 - Orienta????o");
        System.out.println(" 6 - Futsal          12 - T??nis");
        
        op = inp.lerInt();
        
        switch(op) {
            case 1 : {
                desporto = "Artes Marciais";
                System.out.println("Duracao em minutos: ");
                duracao = inp.lerDouble();       
                ArtesMarciais novo = new ArtesMarciais(desporto,duracao);
                ut.addActividade(novo);
            }; break;
            case 2 : {
                desporto = "Caminhada";
                System.out.println("Duracao em minutos: ");
                duracao = inp.lerDouble();
                System.out.println("Distancia em km: ");
                distancia = inp.lerDouble();
                System.out.println("Altura maxima em metros: ");
                alt_max = inp.lerDouble();
                System.out.println("Altura minima em metros: ");
                alt_min = inp.lerDouble();
                System.out.println("Total subido em metros: ");
                total_sub = inp.lerDouble();
                System.out.println("Total descido em metros: ");
                total_des = inp.lerDouble();
                System.out.println("Meteorologia: ");
                meteorologia = inp.lerString();
                Caminhada novo = new Caminhada(desporto,duracao,distancia,alt_min,alt_max,total_sub,total_des,meteorologia);
                ut.addActividade(novo);
            }; break;
            case 3 : {
                desporto = "Canoagem";
                System.out.println("Duracao em minutos: ");
                duracao = inp.lerDouble();
                System.out.println("Distancia em km: ");
                distancia = inp.lerDouble();
                System.out.println("Altura maxima em metros: ");
                alt_max = inp.lerDouble();
                System.out.println("Altura minima em metros: ");
                alt_min = inp.lerDouble();
                System.out.println("Total descido em metros: ");
                total_des = inp.lerDouble();
                System.out.println("Velocidade maxima em km/h: ");
                vel_max = inp.lerDouble();
                System.out.println("Meteorologia: ");
                meteorologia = inp.lerString();
                Canoagem novo = new Canoagem(desporto,duracao,distancia,vel_max,alt_min,alt_max,total_des,meteorologia);
                ut.addActividade(novo);
            } ; break;
            case 4 : {
                desporto = "Ciclismo";
                System.out.println("Duracao em minutos: ");
                duracao = inp.lerDouble();
                System.out.println("Distancia em km: ");
                distancia = inp.lerDouble();
                System.out.println("Altura maxima em metros: ");
                alt_max = inp.lerDouble();
                System.out.println("Altura minima em metros: ");
                alt_min = inp.lerDouble();
                System.out.println("Total subido em metros: ");
                total_sub = inp.lerDouble();
                System.out.println("Total descido em metros: ");
                total_des = inp.lerDouble();
                System.out.println("Velocidade maxima em km/h: ");
                vel_max = inp.lerDouble();
                System.out.println("Meteorologia: ");
                meteorologia = inp.lerString();
                Ciclismo novo = new Ciclismo(desporto,duracao,distancia,alt_min,alt_max,total_des,total_sub,meteorologia);
                ut.addActividade(novo);
            } ; break;
            case 5 : {
                desporto = "Corrida";
                System.out.println("Duracao em minutos: ");
                duracao = inp.lerDouble();
                System.out.println("Distancia em km: ");
                distancia = inp.lerDouble();
                System.out.println("Altura maxima em metros: ");
                alt_max = inp.lerDouble();
                System.out.println("Altura minima em metros: ");
                alt_min = inp.lerDouble();
                System.out.println("Total subido em metros: ");
                total_sub = inp.lerDouble();
                System.out.println("Total descido em metros: ");
                total_des = inp.lerDouble();
                System.out.println("Velocidade maxima em km/h: ");
                vel_max = inp.lerDouble();
                System.out.println("Meteorologia: ");
                meteorologia = inp.lerString();
                Corrida novo = new Corrida(desporto,duracao,distancia,alt_min,alt_max,total_des,total_sub,meteorologia);
                ut.addActividade(novo);
            } ; break;
            case 6 : {
                desporto = "Futsal";
                System.out.println("Duracao em minutos: ");
                duracao = inp.lerDouble();
                System.out.println("Distancia em km: ");
                distancia = inp.lerDouble();
                System.out.println("Velocidade maxima em km/h: ");
                vel_max = inp.lerDouble();
                Futsal novo = new Futsal(desporto,duracao,distancia);
                ut.addActividade(novo);
            } ; break;
            case 7 : {
                desporto = "Golfe";
                System.out.println("Duracao em minutos: ");
                duracao = inp.lerDouble();
                System.out.println("Distancia em km: ");
                distancia = inp.lerDouble();
                System.out.println("Meteorologia: ");
                meteorologia = inp.lerString();
                Golfe novo = new Golfe(desporto,meteorologia,duracao,distancia);
                ut.addActividade(novo);
            } ; break;
            case 8 : {
                desporto = "Hoquei";
                System.out.println("Duracao em minutos: ");
                duracao = inp.lerDouble();
                System.out.println("Distancia em km: ");
                distancia = inp.lerDouble();
                System.out.println("Velocidade maxima em km/h: ");
                vel_max = inp.lerDouble();
                Hoquei novo = new Hoquei(desporto,duracao,distancia);
                ut.addActividade(novo);
            } ; break;
            case 9 : {
                desporto = "Musculacao";
                System.out.println("Duracao em minutos: ");
                duracao = inp.lerDouble();
                Musculacao novo = new Musculacao(desporto,duracao);
                ut.addActividade(novo);
            } ; break;
            case 10 : {
                desporto = "Natacao";
                System.out.println("Duracao em minutos: ");
                duracao = inp.lerDouble();
                System.out.println("Distancia em km: ");
                distancia = inp.lerDouble();
                System.out.println("Velocidade maxima em km/h: ");
                vel_max = inp.lerDouble();
                Natacao novo = new Natacao(desporto,duracao,distancia,vel_max);
                ut.addActividade(novo);
                
            } ; break;
            case 11 : {
                desporto = "Orientacao";
                System.out.println("Duracao em minutos: ");
                duracao = inp.lerDouble();
                System.out.println("Distancia em km: ");
                distancia = inp.lerDouble();
                System.out.println("Altura maxima em metros: ");
                alt_max = inp.lerDouble();
                System.out.println("Altura minima em metros: ");
                alt_min = inp.lerDouble();
                System.out.println("Total subido em metros: ");
                total_sub = inp.lerDouble();
                System.out.println("Total descido em metros: ");
                total_des = inp.lerDouble();
                System.out.println("Velocidade maxima em km/h: ");
                vel_max = inp.lerDouble();
                System.out.println("Meteorologia: ");
                meteorologia = inp.lerString();
                Orientacao novo = new Orientacao(desporto,duracao,distancia,alt_min,alt_max,total_des,total_sub,meteorologia);
                ut.addActividade(novo);
                
            } ; break;
            case 12 : {
                desporto = "Tenis";
                System.out.println("Duracao em minutos: ");
                duracao = inp.lerDouble();
                System.out.println("Meteorologia: ");
                meteorologia = inp.lerString();
                Tenis novo = new Tenis(desporto,meteorologia,duracao);
                ut.addActividade(novo);
                
            } ; break;
            case 0 : menuUtilizador(); break;
            default : {
                System.out.println("\nERRO: Opcao invalida\n");
            }
        }   
        if (op < 0 || op > 12) menuAdicionarActividade();
        if (op != 0) {
            System.out.println("\nActividade registada com sucesso!\n");
        }
    }
    
    /**
     * Menu remover actividade
     */
    public static void menuRemoverActividade() {
        int i = 0, nr;
        char op;
        boolean continua = true;
        System.out.println("--- CONSULTAR E REMOVER ACTIVIDADES ---");
        
        while (continua){
            System.out.println(ut.imprimeAPO(i));
            System.out.println("\nQuer continuar a consultar? (S/N)");
            op = inp.lerChar();
            while(op != 'S' && op != 'N') {
                System.out.println("\nERRO: Input invalido.");
                op = inp.lerChar();
            }
            if (op == 'S')
                i += 10;
            else continua = false;
        }
        
        System.out.println("\nQuer remover? (S/N)");
        op = inp.lerChar();
        while(op != 'S' && op != 'N') {
            System.out.println("\nERRO: Input invalido.");
            op = inp.lerChar();
        }
        if (op == 'S'){
            System.out.println("Que actividade quer remover? ");
            nr = inp.lerInt();
            while (nr < 0 || nr > ut.getActividades().size()){
                System.out.println("\nERRO: Input invalido.");
                nr = inp.lerInt();
            }
            ut.removeActividade(nr - 1);
        }
        
    }
    
     /**
     * Menu Amigos
     */
    public static void menuAmigos() {
        int op;
        System.out.println("--- MENU AMIGOS---");
        System.out.println(" 1 - Consultar amigos");
        System.out.println(" 2 - Adicionar amigo");
        System.out.println(" 3 - Remover amigo");
        System.out.println(" 4 - Pedidos de amizade");
        System.out.println(" 5 - Voltar ao menu anterior");
        
        op = inp.lerInt();
        
        switch(op) {
            case 1 : menuConsultaAmigos(); break;
            case 2 : menuAddAmigo(); break;
            case 3 : menuRemAmigo(); break;
            case 4 : menuPedidos(); break;
            case 5 : menuUtilizador(); break;
            default : {
                System.out.println("\nERRO: Op????o inv??lida\n");
            }
        }   
        if (op <= 0 || op > 5) menuAmigos();
        else if (op != 5) menuUtilizador();
    }
    
    /**
     * Menu consultar amigos
     */
    public static void menuConsultaAmigos() {
        String mail;
        boolean sair = false;
        
        System.out.println("\n--- LISTA DE AMIGOS: ---");
        System.out.println(ut.imprimeTM(ut.getAmigos()));
        
        System.out.println("Qual o mail do amigo?");
        mail = inp.lerString();
        while ((!rede.existeUtilizador(mail) || (ut.getEmail().equals(mail))  || !ut.getAmigos().containsKey(mail)) && !sair){
            System.out.println("ERRO: Utilizador inv??lido (Digite 'Sair' para voltar ao menu inicial.");
            mail = inp.lerString();
            if (mail.equals("Sair")) sair = true;
        }
        
        if (!sair){
            System.out.println("??ltimas dez actividades realizadas por " + rede.getUtilizador(mail).getNome());
            System.out.println(ut.imprimeALA(ut.dezActividades(rede.getUtilizador(mail))));
        }
    }
    
    /**
     * Menu adicionar amigo
     */
    public static void menuAddAmigo() {
        String mail;
        char op;
        boolean sair = false;
        
        System.out.println("Qual o mail do amigo?");
        mail = inp.lerString();
        while ((!rede.existeUtilizador(mail) || (ut.getEmail().equals(mail)) || ut.getAmigos().containsKey(mail)) && !sair){
            System.out.println("ERRO: Utilizador inv??lido (Digite 'Sair' para voltar ao menu inicial.");
            mail = inp.lerString();
            if (mail.equals("Sair")) sair = true;
        }
        if (!sair){
            System.out.println(rede.getUtilizador(mail).toString());
            
            System.out.println("\nEnviar pedido? (S/N)");
            op = inp.lerChar();
            while(op != 'S' && op != 'N') {
                System.out.println("\nERRO: Input invalido.");
                System.out.println("Enviar pedido? (S/N)");
                op = inp.lerChar();
            }
            if (op == 'S'){
                try {
                    ut.enviaPedido(rede.getUtilizador(mail));
                    System.out.println("Pedido enviado\n");
                } catch(Excepcoes e) {
                    System.out.println("\nERRO: " + e.getMessage());
                }
            }
        }
        }
    
    /**
     * Menu remover amigo
     */
    public static void menuRemAmigo() {
        String mail;
        char op;
        boolean sair = false;
        
        System.out.println("\n--- LISTA DE AMIGOS: ---");
        System.out.println(ut.imprimeTM(ut.getAmigos()));
        
        System.out.println("Qual o mail do amigo a remover?");
        mail = inp.lerString();
        while ((!rede.existeUtilizador(mail) || (ut.getEmail().equals(mail)) || !ut.getAmigos().containsKey(mail)) && !sair){
            System.out.println("ERRO: Utilizador inv??lido (Digite 'Sair' para voltar ao menu inicial.");
            mail = inp.lerString();
            if (mail.equals("Sair")) sair = true;
        }
        if (!sair){
            System.out.println(rede.getUtilizador(mail).toString());
            
            System.out.println("\nRemover amigo? (S/N)");
            op = inp.lerChar();
            while(op != 'S' && op != 'N') {
                System.out.println("\nERRO: Input invalido.");
                System.out.println("Remover amigo? (S/N)");
                op = inp.lerChar();
            }
        
            try {
                ut.remAmigo(rede.getUtilizador(mail));
                System.out.println("Amigo removido com sucesso\n");
            } catch(Excepcoes e) {
                System.out.println("\nERRO: " + e.getMessage());
            }
        }
        
        
    }
   
    /**
     * Menu de tratamento de pedidos
     */
    public static void menuPedidos() {
        String mail;
        boolean sair = false;
        System.out.println("--- PEDIDOS PENDENTES: ---");
        System.out.println(ut.imprimeALU(ut.getPedidos()));
       
        System.out.println("Qual o mail do amigo que deseja aceitar?");
        mail = inp.lerString();
        while ((!rede.existeUtilizador(mail) || (ut.getEmail().equals(mail))) && !sair){
            System.out.println("ERRO: Utilizador inv??lido (Digite 'Sair' para voltar ao menu inicial.");
            mail = inp.lerString();
            if (mail.equals("Sair")) sair = true;
        }
        
        if(!sair){
            try{
                ut.aceitaPedido(rede.getUtilizador(mail));
            } catch (Excepcoes e){
                System.out.println("\nERRO: " + e.getMessage());
            }
        }
    }
    
     /**
     * Menu Historico de actividades
     */
    public static void menuHistorico() {
        char op;
        int nr;
        String act = "";
        
        System.out.println("--- ??LTIMAS DEZ ACTIVIDADES REALIZADAS: ---");
        System.out.println(ut.imprimeALA(ut.dezActividades(ut)));
        
        System.out.println("Deseja ver os detalhes de alguma actividade? (S/N)");
        op = inp.lerChar();
        while(op != 'S' && op != 'N') {
            System.out.println("\nERRO: Input invalido.");
            op = inp.lerChar();
        }
        if (op == 'S') {
            System.out.println("Qual o n??mero da actividade?");
            nr = inp.lerInt();
            while (nr < 1 || nr > ut.getActividades().size() || nr > 10){
                System.out.println("\nERRO: Input invalido.");
                nr = inp.lerInt();
            }
            System.out.println(ut.imprimeAD(ut.getActividades().get(ut.getActividades().size() - nr)) + "\n");
            
        }
        menuUtilizador();
    }
    
    /**
     * Menu de estatisticas
     */
    public static void menuEstatisticas(){
        char op;
        System.out.println("--- ESTATISTICAS ---");
        System.out.println(ut.estatisticas() + "\n");
        menuUtilizador();
    }
    
    /**
     * Menu de edi????o de dados pessoais
     */
    public static void menuEditar(){
        String pw, favorito;
        int peso, op;
        
        System.out.println("--- EDITAR DADOS PESSOAIS ---");
        System.out.println(" 1 - Password");
        System.out.println(" 2 - Peso");
        System.out.println(" 3 - Desporto Favorito");
        System.out.println(" 4 - Voltar ao menu inicial");
        
        op = inp.lerInt();
        
        switch(op) {
            case 1 : {
                System.out.println("Qual a nova password?");
                pw = inp.lerString();
                while(pw.equals("")) {
                    System.out.println("\nERRO: Input invalido.");
                    System.out.println("Password: ");
                    pw = inp.lerString();
                }
                ut.setPw(pw);
            }break;
            case 2 : {
                System.out.println("Qual o peso atual?");
                peso = inp.lerInt();
                while(peso < 1) {
                        System.out.println("\nERRO: Input invalido.");
                        peso = inp.lerInt();
                        }
                ut.setPeso(peso);
            } break;
            case 3 : {
                System.out.println("Qual o novo desporto favorito?");
                favorito = inp.lerString();
                while(favorito.equals("")) {
                    System.out.println("\nERRO: Input invalido.");
                    favorito = inp.lerString();
                }
                ut.setFavorito(favorito);
            } break;
            case 4 : menuUtilizador(); break;
            default : {
                System.out.println("\nERRO: Op????o inv??lida\n");
            }
        }   
        if (op <= 0 || op > 4) menuEditar();
        else if (op != 4) menuUtilizador();
    }
    
    /**
     * Menu para visualiza????o de dados pessoais 
     */
    public static void menuDados (){
        char op;

        System.out.println("--- DADOS PESSOAIS: ---");
        System.out.println("Email: " + ut.getEmail());
        System.out.println("Nome: " + ut.getNome());
        if (ut.getGenero().equals("M")) System.out.println("G??nero: Masculino");
        else System.out.println("G??nero: Feminino");
        System.out.println("Altura: " + ut.getAltura() + " cm");
        System.out.println("Peso: " + ut.getPeso() + " kg");
        System.out.println("Idade: " + ut.calculaIdade() + " anos");
        System.out.println("Desporto favorito: " + ut.getFavorito());
        
        System.out.println("\n--- Deseja alterar dados pessoais? (S/N) ---");
        op = inp.lerChar();
        while(op != 'S' && op != 'N') {
            System.out.println("\nERRO: Input invalido.");
            op = inp.lerChar();
        }
        if (op == 'S') menuEditar();
        else menuUtilizador();
    }
}
