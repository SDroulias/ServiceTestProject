package me.sdroulias.ServiceTestProject.exception;

public class ProductNotFoundException extends Exception{
    private int productId;

    public ProductNotFoundException(int productId){
        super(String.format("Product with id: '%s' was not found", productId));
    }

}
