package org.benomine.rest.utils;

public class Calculs {
    public static double ConvertFToC(double temp) {
        return Math.round(((temp - 32) / 1.8)*1e2)/1e2;
    }

    public static double ConvertCToF(double temp) {
        return Math.round((1.8 * temp + 32)*1e2)/1e2;
    }

}
