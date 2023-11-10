package com.example.customcourseplanner.exceptions;

public class ElementNotFoundException extends RuntimeException{
    public ElementNotFoundException(){
        super();
    }

    public ElementNotFoundException(String message){
        super(message);
    }
}
