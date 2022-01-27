package com.mycompany.salud;

import java.util.Scanner;

public class Salud {
    
    private Scanner sc = new Scanner(System.in);
    
    private String dni;
    private String nombre;
    private int edad;
    private String sexo;
    private boolean creado=false;
    
    private float imc;
    private boolean primera_vez=true;
    
    // MENÚ OPCIÓN 1: Crear Perfil
    
    public Salud(){
        
    }
    
    public Salud(String dni, String nombre, int edad, String sexo){
        
        //Comprueba que todos los datos cumplen las condiciones y que son introducidos
        if(((compDni(dni)==true&&compNombre(nombre)==true)&&(compEdad(edad)==true&&compSexo(sexo)==true))==true){
            
            this.dni=dni;
            this.nombre=nombre;
            this.edad=edad;
            this.sexo=sexo;
            this.creado=true;
            
            System.out.println("\nPerfil creado con exito");
        }else{
            System.out.println("\nNo ha sido posible crear el perfil");
        }
    }
    
    public boolean compDni(String dni){
        
        int num_dni;
        String letra_dni="", comp_letra_dni="";
        
        try{ // ADICIONAL: Se agrega esta excepcion para que en el caso de que num_dni no sea un numero, o la letra no sea una letra, no se rompa el programa.
            num_dni = Integer.parseInt(dni.substring(0, 8))%23;
            letra_dni = dni.substring(8, 9);
        }catch(NumberFormatException e){
            num_dni = 23; // Un numero imposible.
            letra_dni="_"; // Un caracter imposible para un DNI.
        }

        switch (num_dni) { // Uso de switch para que se vea mas claro.
            case 0:
                comp_letra_dni="T";
                break;
            case 1:
                comp_letra_dni="R";
                break;
            case 2:
                comp_letra_dni="W";
                break;
            case 3:
                comp_letra_dni="A";
                break;
            case 4:
                comp_letra_dni="G";
                break;
            case 5:
                comp_letra_dni="M";
                break;
            case 6:
                comp_letra_dni="Y";
                break;
            case 7:
                comp_letra_dni="F";
                break;
            case 8:
                comp_letra_dni="P";
                break;
            case 9:
                comp_letra_dni="D";
                break;
            case 10:
                comp_letra_dni="X";
                break;
            case 11:
                comp_letra_dni="B";
                break;
            case 12:
                comp_letra_dni="N";
                break;
            case 13:
                comp_letra_dni="J";
                break;
            case 14:
                comp_letra_dni="Z";
                break;
            case 15:
                comp_letra_dni="S";
                break;
            case 16:
                comp_letra_dni="Q";
                break;
            case 17:
                comp_letra_dni="V";
                break;
            case 18:
                comp_letra_dni="H";
                break;
            case 19:
                comp_letra_dni="L";
                break;
            case 20:
                comp_letra_dni="C";
                break;
            case 21:
                comp_letra_dni="K";
                break;
            case 22:
                comp_letra_dni="E";
                break;
            default:
                break;
        }
        
        // Se comprueba que el DNI tiene 9 caracteres y que es verdadero, calculando la letra y comparandola con la que se introdujo.
        return dni.length()==9 && comp_letra_dni.equalsIgnoreCase(letra_dni);
        
    }
    
    public boolean compNombre(String nombre){
        return nombre.length()!=0; // Devuelve true si el nombre tiene al menos 1 caracter
    }
    
    public boolean compEdad(int edad){ 
        return edad>=5 && edad<=120; // Devuelve true si la edad esta entre 5 y 120
    }
    
    public boolean compSexo(String sexo){
        return "M".equalsIgnoreCase(sexo) || "F".equalsIgnoreCase(sexo); // Devuelve true si el usuario es masculino o femenino
    }
    
    // MENÚ OPCIÓN 2: Calculo IMC
    
    public String calculoIMC(){ // Calcula el IMC y lo muestra
        
        if(this.primera_vez == true){ // Controla que sea la primera vez en acceder, sino lo saltará
            System.out.println("Introduce tu altura en metros: (Ej: 1,70)");
            float altura = sc.nextFloat();
            
            System.out.println("Introduce tu peso en kilogramos: ");
            float peso = sc.nextFloat();
            
            this.imc = (float) (peso/Math.pow(altura, 2));
            
            this.primera_vez=false;
        }
        
        String msj;
        
        if(this.imc>30f){
            msj = "¡Tienes un IMC que indica obesidad!";
        }else if(this.imc>=25f){
            msj = "¡Tienes un IMC que indica sobrepeso!";
        }else if(this.imc>=18.5f){
            msj = "¡Tienes un IMC dentro de la normalidad!";
        }else{
            msj = "¡Tienes un IMC que indica delgadez!";
        }
        
        return "\n" + this.nombre + ", tu IMC es " + Float.toString(this.imc).substring(0, 4) + ". " + msj; // Delvuelve un String con el IMC y un mensaje que depende del IMC
        
    }
    
    // MENÚ OPCIÓN 3: Seguir hábitos saludables
    
    public void test(){ // Realiza el test y toda su logica
        
        boolean preg1, preg2, preg3, preg4, preg5, preg6;
        String res1, res2, res3, res4, res5, res6;
        
        System.out.println("\n¡Bienvenido al test " + this.nombre + "!");
        
        do{
            System.out.println("\n6/1 - ¿Fumas a menudo? \n a) Si \n b) Algunos días \n c) No");
            res1 = sc.next();
            preg1 = compRes(res1);
            
        }while(!preg1); // Si la respuesta es a b o c, termina el bucle y avanza a la siguiente pregunta
        
        do{
            System.out.println("\n6/2 - Cuánto alcohol bebes? \n a) Todos los días \n b) Sobretodo los fines de semana \n c) Muy poco");
            res2 = sc.next();
            preg2 = compRes(res2);
            
        }while(!preg2);
        
        do{
            System.out.println("\n6/3 -¿Cuántas horas duermes al día? \n a) Menos de 4 horas \n b) Entre 5 y 6 horas \n c) Más de 6 horas. ");
            res3 = sc.next();
            preg3 = compRes(res3);
            
        }while(!preg3);
        
        do{
            System.out.println("\n6/4 -¿Sueles estresarte y notar cansancio a lo largo del día? \n a) Es mi día a día \n b) A veces \n c) Muy poco");
            res4 = sc.next();
            preg4 = compRes(res4);
            
        }while(!preg4);
        
        do{
            System.out.println("\n6/5 -¿Cuál es tu forma física? \n a) Estoy muy desentrenado tanto en fuerza como en resistencia \n b) Forma física normal \n c) Muy buena forma física");
            res5 = sc.next();
            preg5 = compRes(res5);
            
        }while(!preg5);
        
        do{
            System.out.println("\n6/6-¿Cuántas veces practicas deporte a la semana? \n a) Entre 1 y 2 veces \n b) Entre 3 y 4 veces \n c) Todos los días");
            res6 = sc.next();
            preg6 = compRes(res6);
            
        }while(!preg6);
        
        // Comprueba si todas las respuestas son a o c
        if("a".equalsIgnoreCase(res1)&&"a".equalsIgnoreCase(res2)&&"a".equalsIgnoreCase(res3)&&"a".equalsIgnoreCase(res4)&&"a".equalsIgnoreCase(res5)&&"a".equalsIgnoreCase(res6)){
            
            System.out.println(this.nombre + " tus hábitos en el día a día son muy malos. Tu salud corre peligro, debes cambiar tus hábitos de forma drástica e inmediata para prevenir posibles enfermedades.");
            
        }else if("c".equalsIgnoreCase(res1)&&"c".equalsIgnoreCase(res2)&&"c".equalsIgnoreCase(res3)&&"c".equalsIgnoreCase(res4)&&"c".equalsIgnoreCase(res5)&&"c".equalsIgnoreCase(res6)){
            
            System.out.println("¡ENHORABUENA " + this.nombre + "! tus hábitos en el día a día son muy buenos. Debes seguir así y gozarás más fácilmente de una buena salud. Estás aumentando tu esperanza de vida más de 10 años.");
            
        }else{
            
            // Muestra un mensaje personalizado dependiendo de en que pregunta la respuesta haya sido b
            // Creo que deberia mostrar estos mensajes tambien en el caso de que se responda a, pero lo dejo asi porque es lo que pone en el ejercicio.
            System.out.println("Buenas " + this.nombre);
            if("b".equalsIgnoreCase(res1)){ System.out.println("No deberias fumar"); }
            if("b".equalsIgnoreCase(res2)){ System.out.println("Deberias beber menos alcohol"); }
            if("b".equalsIgnoreCase(res3)){ System.out.println("Deberias dormir mas"); }
            if("b".equalsIgnoreCase(res4)){ System.out.println("Debes trabajar en controlar el estres"); }
            if("b".equalsIgnoreCase(res5)){ System.out.println("¡Tienes que entrenar mas!"); }
            if("b".equalsIgnoreCase(res6)){ System.out.println("Hay que practicar mas deporte"); }
            
        }
   
    }
    
    public boolean compRes(String res){ // Comprueba que las respuestas son a b o c
        
        if(!("a".equalsIgnoreCase(res) || "b".equalsIgnoreCase(res) || "c".equalsIgnoreCase(res))){
            System.out.println("Error, solo se permiten (a b c)");  
        }
        
        return "a".equalsIgnoreCase(res) || "b".equalsIgnoreCase(res) || "c".equalsIgnoreCase(res); // Devuelve true si la respuesta es a b o c
    }
    
    // MENÚ OPCIÓN 4: Conocer si llevas una alimentación variada y rica para una buena salud.
    
    public void alimentacion(){ // Se realizan preguntas para determinar la calidad de la alimentacion del usuario
        
        System.out.println("Hola " + this.nombre + ", ¿Cuántas comidas realizas al día? (1,2,3,4,5,6,7,8,9 o 10)");
        int total_verduras=0, total_frutas=0, res_frutas, res_verduras, comida_basura, res = sc.nextInt();
        double percent;
        
        for(int i=1; i<=res; i++){ // Se hacen 2 preguntas por comidas al dia.
            
            System.out.println("Comida " + i);
            System.out.println("¿Cuántas porciones de verdura (guarnición, verdura cruda, ensalada)? (1,2,3,4,5…): ");
            res_frutas = sc.nextInt();
            System.out.println("¿Cuántas porciones de fruta (porción equivale a un puñado de uvas)? (1,2,3,4,5…): ");
            res_verduras = sc.nextInt();
            
            total_frutas+=res_frutas;
            total_verduras+=res_verduras;    
        }
        
        if(total_verduras>=3 && total_frutas>=5){ 
            
            System.out.println("Continua con el hábito de verduras y frutas."); 
            
        }else{
            
            if(total_frutas<5){ System.out.println("Es necesario comer al menos 5 piezas de fruta al día."); }
            if(total_verduras<3){ System.out.println("Es necesario comer al menos 3 piezas de verdura al día."); } 
        }
        
        System.out.println("¿Cuántas veces a la semana comes McDonals, Kebab o Burger King?: ");
        comida_basura = sc.nextInt();
        
        percent = comida_basura*100/(res*7);
        
        if(percent==0){
            System.out.println("El no comer comida rápida va a beneficiar tu salud a largo plazo.");
        }else if(percent<10){
            System.out.println("Tu porcentaje de comida rápida semanal ingerida es " + percent + "%.\nEstá dentro del límite recomendado siempre que hagas deporte y descanses lo suficiente.");
        }else if(percent<40){
            System.out.println("Tu porcentaje de comida rápida semanal ingerida es " + percent + "%.\nDeberías comer menos comida rápida para prevenir posibles problemas de salud.");
        }else{
            System.out.println("Tu porcentaje de comida rápida semanal ingerida es " + percent + "%.\nDebes cambiar tus hábitos, tu salud está en riesgo por tu alta ingesta de comida rápida.");
        }
        
    }
    
    //Getters
    
    public String getDni(){
        return this.dni; // Devuelve el DNI del perfil
    }
    
    public boolean getCreado(){
        return this.creado; // Devuelve si se ha creado o no el perfil
    }

}
