package net.unesc.utilidades;

import java.awt.Color;
import java.security.InvalidParameterException;

public class CorUtil {
    public static String colorParaHexadecimal(Color color) throws InvalidParameterException {
        if (color == null)
            throw new InvalidParameterException("A cor não pode ser nula ou vazia");
        return String.format("#%02x%02x%02x", color.getRed(), color.getGreen(), color.getBlue());
    }
}
