package by.it.yakovets.jd01_14;

import java.io.*;

public class TaskA {

    private static String dir(Class<?> cl) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String classDir = cl.getName().replace(cl.getSimpleName(), "").replace(".", File.separator);
        return path + classDir;
    }

    public static void main(String[] args) {

        try (DataOutputStream dos = new DataOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(dir(TaskA.class))))) {

            {
                for (int i = 0; i < 20; i++) {
                    dos.writeInt((int) (Math.random() * 25));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        try (DataInputStream inp = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream(dir(TaskA.class) + "dataTaskA.bin")));
             PrintWriter out2 = new PrintWriter(new FileWriter(dir(TaskA.class) + "resultTaskA.txt"))) {
            double sum = 0;
            double count = 0;
            while (inp.available() > 0) {
                int i = inp.readInt();
                System.out.print(i + " ");
                out2.print(i + " ");
                sum = sum + i;
                count++;
            }
            System.out.println("\navg=" + sum / count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
