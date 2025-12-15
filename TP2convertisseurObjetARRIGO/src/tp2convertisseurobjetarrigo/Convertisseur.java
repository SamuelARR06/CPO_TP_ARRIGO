/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp2convertisseurobjetarrigo;

/**
 *
 * @author samar
 */
public class Convertisseur {
    int nbConversions;

    public Convertisseur() {
        nbConversions = 0;
    }

    public double CelciusVersFahrenheit(double tCelcius) {
        nbConversions++;
        return tCelcius * 9.0 / 5.0 + 32;
    }

    public double FahrenheitVersCelcius(double tFahrenheit) {
        nbConversions++;
        return (tFahrenheit - 32) * 5.0 / 9.0;
    }

    public double CelciusVersKelvin(double tCelcius) {
        nbConversions++;
        return tCelcius + 273.15;
    }

    public double KelvinVersCelcius(double tKelvin) {
        nbConversions++;
        return tKelvin - 273.15;
    }

    @Override
    public String toString() {
        return "nb de conversions: " + nbConversions;
    }
}


