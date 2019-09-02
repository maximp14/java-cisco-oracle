package com.vista;

import com.controller.CheckCSV;
import com.util.Common;

public class Navigation {

    public Navigation() {
    }

    public void menu(){

        int opt;

        System.out.println("*************BIENVENIDO*************\n\n");
        do {
            System.out.println("1- Cliente ");
            System.out.println("2- Producto ");
            System.out.println("3- Canjes ");
            System.out.println("4- Carga de puntos ");
            System.out.println("0- Salir ");
            opt = Common.input.nextInt();

            switch (opt){
                case 1:
                {
                    ClientView clientView = new ClientView();
                    clientView.clientOptions();
                    break;
                }
                case 2:{
                    ProductView productView = new ProductView();
                    productView.productOptions();
                    break;
                }
                case 3:{
                    RedeemView redeemView = new RedeemView();
                    redeemView.reddemOptions();
                }
                case 4:{
                    loadCSV();
                    break;
                }
                case 0:{
                    break;
                }
                default:{
                    System.out.println("Invalid option, please try again ");
                }
            }
        }while (opt != 0);
    }


    private void loadCSV(){
        CheckCSV loadCSV = new CheckCSV();
        loadCSV.readFile();
    }
}
