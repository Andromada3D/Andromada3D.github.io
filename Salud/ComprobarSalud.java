package com.mycompany.salud;

/**
 * @author Alfonso Diaz Hernandez
 * @version 1.0
 */

import java.util.Scanner;

public class ComprobarSalud {
    
    private static Scanner sc = new Scanner(System.in);
    private static Salud p1 = new Salud(), p2 = new Salud();
    
    public static void main(String[] args) {
       
        boolean x=false;
        
        do{
        
            System.out.println("\n1- Crear perfil \n" + "2- Calculo del IMC \n" + "3- Seguir hábitos saludables. \n" + "4- Conocer si llevas una alimentación variada y rica para una buena salud. \n" + "5- Salir del programa\n");
            String res = sc.next();

            if("1".equals(res)){

                if(!maxPerfil()){
                
                    System.out.println("Introduce el DNI:");
                    String dni = sc.next();

                    System.out.println("Introduce el nombre:");
                    String nombre = sc.next();

                    System.out.println("Introduce la edad (5-120):");
                    int edad = sc.nextInt();

                    System.out.println("Introduce el sexo (M/F):");
                    String sexo = sc.next();  
                
                    if(ComprobarSalud.p1.getCreado()==false){

                        System.out.println("\nPerfil 1");
                        ComprobarSalud.p1 = new Salud(dni, nombre, edad, sexo);

                    }else{

                        System.out.println("\nPerfil 2");
                        
                        if(ComprobarSalud.p1.getDni().equals(dni)){
                            
                            System.out.println("\nEse DNI ya existe");
                            
                        }else{
                            
                            ComprobarSalud.p2 = new Salud(dni, nombre, edad, sexo);
                            
                        }
                    }
         
                }else{
                    System.out.println("\nMaximo de perfiles alcanzado");
                }

            }else if("2".equals(res)){

                if(existePerfil()){
                    
                    System.out.println("\nIntroduce el DNI de tu perfil: ");
                    String dni = sc.next();
                    
                    if(ComprobarSalud.p1.getDni().equals(dni)){
                        
                        System.out.println(ComprobarSalud.p1.calculoIMC());
                        
                    }else if(ComprobarSalud.p2.getDni().equals(dni)){
                        
                        System.out.println(ComprobarSalud.p2.calculoIMC());
                        
                    }else{
                        
                        System.out.println("No existe un perfil asociado a: " + dni);
                        
                    }
                    
                }else{
                    
                    System.out.println("No hay ningun perfil creado");
                    
                }
                
            }else if("3".equals(res)){

                if(existePerfil()){
                    
                    System.out.println("\nIntroduce el DNI de tu perfil: ");
                    String dni = sc.next();
                    
                    if(ComprobarSalud.p1.getDni().equals(dni)){
                        
                        ComprobarSalud.p1.test();
                        
                    }else if(ComprobarSalud.p2.getDni().equals(dni)){
                        
                        ComprobarSalud.p2.test();
                        
                    }else{
                        
                        System.out.println("No existe un perfil asociado a: " + dni);
                        
                    }
                }else{
                    
                    System.out.println("No hay ningun perfil creado");
                    
                }
            }else if("4".equals(res)){

                if(existePerfil()){
                
                    System.out.println("\nIntroduce el DNI de tu perfil: ");
                    String dni = sc.next();
                    
                    if(ComprobarSalud.p1.getDni().equals(dni)){
                        
                        ComprobarSalud.p1.alimentacion();
                        
                    }else if(ComprobarSalud.p2.getDni().equals(dni)){
                        
                        ComprobarSalud.p2.alimentacion();
                        
                    }else{
                        
                        System.out.println("No existe un perfil asociado a: " + dni);
                        
                    }
                    
                }else{
                    
                    System.out.println("No hay ningun perfil creado");
                    
                }
            }else if("5".equals(res)){
                
                System.out.println("¡Hasta la proxima!");
                x=true;
                
            }else{
                
                System.out.println("La opcion introducida no existe, prueba otra vez.");
                
            }
        
        }while(x!=true);
        
    }
    
    //Getters
    
    public static boolean maxPerfil(){ // Devuelve true si los dos perfiles están creados
        return ComprobarSalud.p1.getCreado()==true && ComprobarSalud.p2.getCreado()==true;
    }
    
    public static boolean existePerfil(){ // Devuelve true si al menos uno de los perfiles esta creado
        return ComprobarSalud.p1.getCreado()==true || ComprobarSalud.p2.getCreado()==true;
    }
    
}
