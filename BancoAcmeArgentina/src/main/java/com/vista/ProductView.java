package com.vista;

import com.controller.ProductDAO;
import com.controller.ProductDAOImp;
import com.model.Product;
import com.util.Common;

public class ProductView {

    private ProductDAO productDAO;

    public ProductView() {
        this.productDAO = new ProductDAOImp();
    }

    public void productOptions(){
        int opt;

        System.out.println("*************PRODUCTO*************\n");
        do {
            System.out.println("1- Crear Producto ");
            System.out.println("2- Buscar un producto ");
            System.out.println("3- Listar todos los productos ");
            System.out.println("4- Actualizar producto ");
            System.out.println("5- Eliminar producto ");
            System.out.println("0- Volver ");
            opt = Common.input.nextInt();

            switch (opt){
                case 1:
                {
                    saveProduct();
                    break;
                }
                case 2:{
                    findOneProduct();
                    break;
                }
                case 3:{
                    findAllProducts();
                    break;
                }
                case 4:{
                    updateProduct();
                    break;
                }
                case 5: {
                    deleteProduct();
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

    private void saveProduct(){
        System.out.println("Codigo: ");
        Integer code = Common.input.nextInt();
        System.out.println("Nombre del producto: ");
        String name = Common.input.next();
        System.out.println("Stock: ");
        Integer stock = Common.input.nextInt();
        System.out.println("Valor en puntos: ");
        Integer points = Common.input.nextInt();
        Product product = new Product(code,name,stock,points);
        this.productDAO.create(product);
    }

    private void deleteProduct(){
        System.out.println("Ingrese codigo del cliente a eliminar: ");
        Integer code = Common.input.nextInt();

        this.productDAO.delete(code);
    }

    private void updateProduct(){
        System.out.println("Ingrese codigo del producto a actualizar: ");
        Integer code = Common.input.nextInt();

        System.out.println("Nombre: ");
        String name = Common.input.next();
        System.out.println("Stock: ");
        Integer stock = Common.input.nextInt();
        System.out.println("Valor en puntos: ");
        Integer points = Common.input.nextInt();
        Product product = new Product(code,name,stock,points);
        this.productDAO.update(code,product);
    }

    private void findOneProduct(){
        System.out.println("Ingrese codigo: ");
        Integer code = Common.input.nextInt();
        System.out.println(this.productDAO.findById(code).toString());
    }

    private void findAllProducts(){
        System.out.println(this.productDAO.findAll().toString());
    }
}
