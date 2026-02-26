package edu.eci.arsw.math;

public class CicloDeVida extends Thread {

    private int start;
    private int count;
    private int parte;

    public CicloDeVida(int start, int count, int parte) {
        this.start = start;
        this.count = count;
        this.parte = parte;
    }

    public void run(){
        calcularPiDigits();
    }

    public void calcularPiDigits(){
        int porciones = start / parte;
        int startPrueba = porciones;
        for(int i = 0; i < parte; i++){
            System.out.println(porciones);
            PiDigits.getDigits(startPrueba, count);
            porciones = porciones + startPrueba ;
            System.out.println(bytesToHex(PiDigits.getDigits(porciones, count)) + " hilo");
        }

    }
    private final static char[] hexArray = "0123456789ABCDEF".toCharArray();

    public static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<hexChars.length;i=i+2){
            //sb.append(hexChars[i]);
            sb.append(hexChars[i+1]);
        }
        return sb.toString();
    }
}
