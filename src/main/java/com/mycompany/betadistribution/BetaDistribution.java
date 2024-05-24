/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.betadistribution;

/**
 *
 * @author Diego
 */
/*
 * La clase BetaDistribution proporciona métodos para calcular la función Beta,
 * la función Gamma y la densidad de probabilidad de la distribución Beta.
 */
public class BetaDistribution {

    /**
     * Calcula la función Beta B(a, b) utilizando la relación con la función
     * Gamma. La función Beta se define como B(a, b) = Γ(a) * Γ(b) / Γ(a + b).
     *
     * @param a El primer parámetro de la función Beta.
     * @param b El segundo parámetro de la función Beta.
     * @return El valor de la función Beta B(a, b).
     */
    public static double betaFunction(double a, double b) {
        return gammaFunction(a) * gammaFunction(b) / gammaFunction(a + b);
    }

    /**
     * Calculamos la función Gamma Γ(x). Esta basada en la relación Γ(x) = (x - 1)
     * * Γ(x - 1) con los casos base Γ(0) = 1 y Γ(1) = 1.
     *
     * @param x El valor para el cual se calcula la función Gamma.
     * @return El valor de la función Gamma Γ(x).
     */
    public static double gammaFunction(double x) {
        if (x == 0 || x == 1) {
            return 1;
        } else {
            return (x - 1) * gammaFunction(x - 1);
        }
    }

    /**
     * Calcula la densidad de probabilidad de la distribución Beta en un punto
     * dado x. La densidad se define como f(x; a, b) = (x^(a-1) * (1-x)^(b-1)) /
     * B(a, b), donde B(a, b) es la función Beta.
     *
     * @param x El punto en el cual se calcula la densidad de probabilidad.
     * @param a El primer parámetro de forma de la distribución Beta.
     * @param b El segundo parámetro de forma de la distribución Beta.
     * @return La densidad de probabilidad Beta en el punto x.
     */
    public static double betaDensity(double x, double a, double b) {
        return Math.pow(x, a - 1) * Math.pow(1 - x, b - 1) / betaFunction(a, b);
    }

    /** 
     * Método principal que ejecuta un ejemplo de uso de la clase
     * BetaDistribution. Calcula y muestra la densidad de probabilidad Beta para
     * los valores a = 2.0, b = 3.0 y x = 0.5.
     *
     * @param args Argumentos de la línea de comandos (no se utilizan).
     */
    public static void main(String[] args) {
        
        double a = 2.0;
        double b = 3.0;
        double x = 0.5;
        double density = betaDensity(x, a, b);
        System.out.println("La densidad de probabilidad Beta en x = " + x + " es: " + density);
    }
}
