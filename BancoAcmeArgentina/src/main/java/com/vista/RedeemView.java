package com.vista;

import com.controller.Operation;
import com.util.Common;

public class RedeemView {

    Operation operation;

    public RedeemView(){
        this.operation = new Operation();
    }

    public void reddemOptions(){
        int opt;

        System.out.println("*************OPERACIONES*************\n");
        do {
            System.out.println("1- Canjear producto ");
            System.out.println("2- Buscar un producto ");
            System.out.println("3- Listar todos los productos ");
            System.out.println("4- Actualizar producto ");
            System.out.println("5- Eliminar producto ");
            System.out.println("0- Volver ");
            opt = Common.input.nextInt();

            switch (opt){
                case 1:
                {
                    redeemProduct();
                    break;
                }
                case 2:{
                    System.out.println(2);
                    break;
                }
                case 3:{
                    System.out.println(3);
                    break;
                }
                case 4:{
                    System.out.println(4);
                    break;
                }
                case 5: {
                    System.out.println(5);
                    break;
                }
                case 0:{
                    break;
                }
                default:{
                    System.out.println("Opcion invalida, intenta de nuevo ");
                }
            }
        }while (opt != 0);

    } ////////// END PRODUCT OPTIONS ////////////

    private void redeemProduct(){
        System.out.println("Dni del cliente: ");
        Integer dni = Common.input.nextInt();
        System.out.println("Codigo del producto: ");
        Integer code = Common.input.nextInt();
        System.out.println("Cantidad a canjear");
        Integer amount = Common.input.nextInt();

        this.operation.redeemProduct(dni,code,amount);
    }
}
