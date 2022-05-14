package com.mycompany.digito_verificador;

import javax.swing.JOptionPane;

/**
 *
 * @author AlanB
 */
public class Digito_verificador {

    public static void main(String[] args) {

        // Le pido al usuario que ingrese un número y lo guardo
        String numeroStr = JOptionPane.showInputDialog(null, "Introducir número: ");
        // Invierto el número
        numeroStr = (InvertirNumeroStr(numeroStr));

        int total = 0;
        // Try para saber verificar que el número no contenga letras
        try {
            // Si la siguiente línea falla es porque número contiene letras
            Integer.parseInt(numeroStr);
            
            // Verifico que el número tenga mas de 6 dígitos
            if (numeroStr.length() >= 6) {
                
                // Muestro el número invertido
            JOptionPane.showMessageDialog(null, "Número invertido: " + numeroStr);

                int[] intArray = new int[20];

                // Recorro el string con el número proporcionado por el usuario
                for (int i = 0; i < numeroStr.length(); i++) {
                    // Convierto los números de char a int
                    int n = Character.getNumericValue(numeroStr.charAt(i));
                    // Los almaceno en el array
                    intArray[i] = n;
                }

                int a = 2;
                // Recorro el array para hacer la multiplicación de los índices y la suma
                for (int i = 0; i < intArray.length; i++) {
                    int multi = intArray[i] * a;
                    total += multi;
                    // Cuando "a" llega a 7 comienza de nuevo desde 1 pero a++ lo lleva de vuelta a 2
                    if (a == 7) {
                        a = 1;
                    }
                    a++;
                }

                JOptionPane.showMessageDialog(null, "Total: " + total);

                int resto = total % 11;
                int digito = 11 - resto;

                // Si el resultado("digito") es 11 entonces se intercambia por 0, si es 10 es 1
                switch (digito) {
                    case 11:
                        digito = 0;
                        JOptionPane.showMessageDialog(null, "Resultado: " + digito);
                        break;
                    case 10:
                        digito = 1;
                        JOptionPane.showMessageDialog(null, "Resultado: " + digito);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Resultado: " + digito);
                }

            } else {
                JOptionPane.showMessageDialog(null, "El número debe contener más de 6 dígitos");
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Debe introducir un número válido. ");
        }
    }

    // Método para invertir el número proporcionado por el usuario
    public static String InvertirNumeroStr(String numeroStr) {
        String numeroInvertido = "";
        for (int x = numeroStr.length() - 1; x >= 0; x--) {
            numeroInvertido = numeroInvertido + numeroStr.charAt(x);
        }
        return numeroInvertido;
    }

}
