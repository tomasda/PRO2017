package hexadecimal;

/**
 *
 * @author Tomás Delgado Acosta.
 */
public class HexadecimalConverter {

    String[] HDC;

    public HexadecimalConverter() {
        HDC = new String[16];

        for (int i = 0; i < 10; i++) {
            HDC[i] = Integer.toString(i);
        }
        HDC[10] = "A";
        HDC[11] = "B";
        HDC[12] = "C";
        HDC[13] = "D";
        HDC[14] = "E";
        HDC[15] = "F";

    }

    public String DecToHex(int dec) {
        int i = 0;
        String valor = "";
        do {
            i = dec % 16;
            valor = HDC[i] + valor;
            dec = dec / 16;
        } while (dec > 0);
        return valor;
    }

    public int Hex(String hex) {
        int i = 0;
        int valor = -1;
        while (i < 16) {
            if (hex.equals(HDC[i])) {
                valor = i;
                i = 16;
            }
            i++;
        }
        return valor;
    }

    public int HexToDec(String hex) {
        int i = 0;
        int valor = 0;
        int leng = hex.length();
        for (int a = 0; a < leng; a++) {
            i = Hex(hex.substring(leng - a - 1, leng - a));
            valor = valor + (i * (int) Math.pow(16, a));
        }
        return valor;
    }
}
