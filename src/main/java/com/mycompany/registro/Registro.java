package com.mycompany.registro;
    import java.util.Scanner;
/**
 *
 * @author Carlos
 */
public class Registro {

    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        Usuario nu= new Usuario();
        DoublyLinkedList <Usuario> lista= new DoublyLinkedList<>();
        
        int opcion;
        String pa;
        String nombre;
        String user;
        String email;
        String contraseña;
        
        do {
            System.out.println("--------------------------------------");
            System.out.println("Ingrese una opcion:"
                    + "\n--------------------------------------"
                    + "\n  1. Registrar usuario."
                    + "\n  2. Entrar. "
                    + "\n  3. Mostrar usuarios registrados."
                    + "\n  4. Eliminar un usuario registrado."
                    + "\n  5. Salir"
                    + "\n--------------------------------------");
            opcion=in.nextInt();
            in.nextLine();
            
            switch(opcion){
                case 1:
                    System.out.println("Desea registrar un nuevo usuario: S/N");   
                    pa=in.nextLine().toUpperCase();
                    
                    while(pa.equals("S")){
                        System.out.println("Ingrese su nombre completo: ");
                            nombre=in.nextLine();
                        System.out.println("Ingrese su usuario: ");
                            user=in.nextLine();
                        System.out.println("Ingrese su e-mail: ");
                            email=in.nextLine();
                        System.out.println("Ingrese su contraseña: "
                                + "   \nNota* La contraseña debe contener:"
                                + "   \n(Minimo 8 caracteres, '/, _ , . , ')");
                            contraseña=in.nextLine();
                        String[] parte=contraseña.split("");
                        if(parte.length<8){
                            System.out.println("¡Error! ¡La contraseña debe contener minimo 8 caracteres!");
                            System.out.print("Ingresela de nuevo:");
                            contraseña=in.nextLine();
                        }
                        System.out.println("");
                        
                        nu=new Usuario(nombre,user,email,contraseña);
                        lista.addLast(nu);
                        
                        System.out.println("Desea ingresar un nuevo usuario: S/N");
                        pa=in.nextLine().toUpperCase();
                    }
                break;
                    
                case 2:
                    
                    System.out.println("Ingrese su usuario: ");
                    user=in.nextLine();
                    for(Usuario eu: lista)
                        if(user.equals(eu.getUser())){
                            System.out.println("Ingrese la contraseña: ");
                            contraseña=in.nextLine();
                            if (contraseña.equals(eu.getContraseña())) {
                                do{
                                    System.out.println("!Bienvenido! "+eu.getNombre());
                                    System.out.println("Que opcion deseas realizar en tu cuenta: "
                                            + "\n1. Cambiar contraseña."
                                            + "\n2. Salir del menu de inicio de sesion.");
                                    opcion=in.nextInt();
                                    in.nextLine();
                                    switch(opcion){
                                        case 1:
                                            System.out.println("Esta seguro que desea cambiar la contraseña: S/N");
                                            pa=in.nextLine().toUpperCase();
                                            if (pa.equals("S")) {
                                                System.out.println("Ingrese la nueva contraseña: ");
                                                contraseña=in.nextLine();
                                                eu.setContraseña(contraseña);
                                            }
                                        break;
                                    }
                                    if (opcion==2) {
                                        System.out.println("Ingrese x para salir: ");
                                        pa=in.nextLine().toUpperCase();
                                        if (pa!="X") {
                                            System.out.println("Caracter no valido.");
                                            System.out.println("Ingrese de nuevo:");
                                            pa=in.nextLine().toUpperCase();
                                        }
                                        break;
                                    }
                                    else System.out.println("Opcion no valida.");
                                }while(true);
                            }
                        }
                break;
                
                case 3:
                    int i=0;
                    System.out.println("Los usuarios son: ");
                    System.out.println("---------------------------------------------------");
                    for(Usuario usr:lista){
                        i+=1;
                        System.out.println("User No."+ i +": " +usr.toString());
                    }
                    System.out.println("---------------------------------------------------");
                break;
                    
                case 4:
                    System.out.println("Ingrese el numero de usuario que desea eliminar: ");
                    opcion=in.nextInt();
                    in.nextLine();
                    lista.remove(opcion);
                    System.out.println("El usuario fue eliminado con exito");
                    
                break;
                
                case 5:
                    System.exit(0);
                break;
            }
        } while (true);
        
    }
}
