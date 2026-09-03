package com.bonbonite.utils;

//Aquí se crea un correo aleatorio teniendo en cuenta hora actual del sistema para que siempre sea único
public class RandomData {
    public static String getUniqueEmail() {
        return "qa_" + System.currentTimeMillis() + "@pruebasqa.com";
    }

    //Se crea también número de documento único, tomando números desde la posición 3
    public static String getUniqueId() {
        return String.valueOf(System.currentTimeMillis()).substring(3);
    }
}