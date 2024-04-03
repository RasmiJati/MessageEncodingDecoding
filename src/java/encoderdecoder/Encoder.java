/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encoderdecoder;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author admin
 */
public class Encoder {

    public Encoder() {
    }

    public String encodeBase64(String plainText) {

//        convert plain text into 8 bit binary representation as per ASCII Character codes
        StringBuilder binaryString = new StringBuilder();
        for (char c : plainText.toCharArray()) {
            try {
                String binary = Integer.toBinaryString(c);
                while (binary.length() < 8) {
                    binary = "0" + binary;
                }
                binaryString.append(binary);
            } catch (NumberFormatException e) {
                System.out.println("Invalid character: " + c + ". Skipping...");
            }
        }
        System.out.println("=======================================================================");
        System.out.println("Binary Representation for \"" + plainText + "\":");
        System.out.println(binaryString.toString().trim());
        System.out.println("=======================================================================");

        StringBuilder encodedString = new StringBuilder();
        int index = 0;

        System.out.println("Grouped Binary Representation:");

        while (index < binaryString.length()) {
            String group = binaryString.substring(index, Math.min(index + 6, binaryString.length()));

            // Add padding to make sure each group contains 6 bits
            while (group.length() < 6) {
                group += "0";
            }
            try {

                int decimalValue = Integer.parseInt(group, 2);
                char base64Char = getBase64Char(decimalValue);
                encodedString.append(base64Char);
                index += 6;
                System.out.print(group.trim() + "\t"); // Trim to remove the trailing space
            } catch (NumberFormatException e) {
                System.out.println("Invalid binary format: " + group + ". Skipping...");
                index += 6;
            }
        }
        System.out.println("");
        System.out.println("=======================================================================");

        // Add padding if necessary
        while (encodedString.length() % 4 != 0) {
            encodedString.append("=");
        }

        return encodedString.toString();
    }

    public char getBase64Char(int decimalValue) {
        if (decimalValue >= 0 && decimalValue <= 25) {
            return (char) (decimalValue + 'A');
        } else if (decimalValue >= 26 && decimalValue <= 51) {
            return (char) (decimalValue - 26 + 'a');
        } else if (decimalValue >= 52 && decimalValue <= 61) {
            return (char) (decimalValue - 52 + '0');
        } else if (decimalValue == 62) {
            return '+';
        } else {
            return '/';
        }
    }
}
