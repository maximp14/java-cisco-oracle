package com.vista;

import com.controller.CustomerDAO;
import com.controller.CustomerDAOImp;

import com.controller.Operation;
import com.model.Customer;

import com.util.Common;
import com.util.Validation;

public class ClientView {

    private CustomerDAO customerDAO;

    public ClientView() {
        this.customerDAO = new CustomerDAOImp();
    }

    public void clientOptions(){
        int opt;

        System.out.println("*************CLIENTE*************\n");
        do {
            System.out.println("1- Crear Cliente ");
            System.out.println("2- Buscar un Cliente ");
            System.out.println("3- Listar todos los clients ");
            System.out.println("4- Actualizar cliente ");
            System.out.println("5- Eliminar cliente ");
            System.out.println("6- Canjear producto ");
            System.out.println("0- Volver ");
            opt = Common.input.nextInt();

            switch (opt){
                case 1:
                {
                    saveCustomer();
                    break;
                }
                case 2:{
                    findOneCustomer();
                    break;
                }
                case 3:{
                    findAllCustomers();
                    break;
                }
                case 4:{
                    updateCustomer();
                    break;
                }
                case 5: {
                    deleteCustomer();
                    break;
                }
                case 6:{
                    redeemProduct();
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

    } ////////// END CLIENT OPTIONS ////////////

    private void saveCustomer(){
        String phoneNumber;
        String email;
        int aux,aux2;
        System.out.println("Nombre: ");
        String name = Common.input.next();
        System.out.println("Apellido: ");
        String lastName = Common.input.next();
        System.out.println("DNI: ");
        Integer dni = Common.input.nextInt();
        do {
            aux = 0;
            System.out.println("Numero de telefono: (codigo-numero) ");
            phoneNumber = Common.input.next();
            if (Validation.phoneValidation(phoneNumber)){
                aux = 1;
            }else System.out.println("Numero incorrecto, intenta de nuevo ");
        }while (aux != 1);
        do {
            aux2 =0;
            System.out.println("Email: ");
            email = Common.input.next();
            if (Validation.emailValidation(email)) {
                aux2 = 1;
            }else System.out.println("Email incorrecto, intenta de nuevo");
        }while (aux2 != 1);

        Customer customer = new Customer(dni,name,lastName,phoneNumber,email);
        this.customerDAO.create(customer);
    }

    private void deleteCustomer(){
        System.out.println("Ingrese dni del cliente a eliminar: ");
        Integer dni = Common.input.nextInt();

        this.customerDAO.delete(dni);
    }

    private void updateCustomer(){
        System.out.println("Ingrese dni del cliente a actualizar: ");
        Integer dni = Common.input.nextInt();

        System.out.println("Nombre: ");
        String name = Common.input.next();
        System.out.println("Apellido: ");
        String lastName = Common.input.next();
        System.out.println("Numero telefonico: ");
        String phoneNumber = Common.input.next();
        System.out.println("Email: ");
        String email = Common.input.next();
        Customer customer = new Customer(dni,name,lastName,phoneNumber,email);
        this.customerDAO.update(dni,customer);
    }

    private void findOneCustomer(){
        System.out.println("Ingrese DNI: ");
        Integer dni = Common.input.nextInt();
        System.out.println(this.customerDAO.findById(dni).toString());
    }

    private void findAllCustomers(){
        System.out.println(this.customerDAO.findAll().toString());
    }

    private void redeemProduct(){
        System.out.println("Ingrese dni del cliente: ");
        Integer dni = Common.input.nextInt();
        System.out.println("Ingrese codigo del producto: ");
        Integer code = Common.input.nextInt();
        System.out.println("Cantidad de productos a canjear: ");
        Integer amount = Common.input.nextInt();
        Operation redeem = new Operation();
        if(redeem.redeemProduct(dni,code,amount)){
            System.out.println("Producto canjeado");
        }else{
            System.out.println("El producto no se pudo canjear");
        }
    }
}
