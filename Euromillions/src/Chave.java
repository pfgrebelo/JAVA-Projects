import java.util.Arrays;
import java.util.Random;

public class Chave {
    private int[] nums = new int[5];
    private int[] stars = new int[2];

    public Chave() {
        int[] nums = new int[]{};
        int[] stars = new int[]{};
    }

    public Chave(int[] nums, int[] stars) {
        this.nums = nums;
        this.stars = stars;
    }

    public boolean duplicate(int[] array, int n) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == n) {
                return true;
            }
        }
        return false;
    }

    public void geraNumeros() {
        Random rnd = new Random();
        int num;
        for (int i = 0; i < getNums().length; i++) {
            num = rnd.nextInt(1, 51);
            while (duplicate(getNums(), num)) {
                num = rnd.nextInt(1, 51);
            }
            getNums()[i] = num;
        }
    }

    public void geraEstrelas() {
        Random rnd = new Random();
        int num;
        for (int i = 0; i < getStars().length; i++) {
            num = rnd.nextInt(1, 12);
            while (duplicate(getStars(), num)) {
                num = rnd.nextInt(1, 12);
            }
            getStars()[i] = num;
        }
    }

    public void mostraChave() {
        System.out.println("------CHAVE VENCEDORA------");
        System.out.println("Numeros:\r");
        for (int i = 0; i < getNums().length; i++) {
            Arrays.sort(getNums());
            System.out.print(getNums()[i] + "\t");
        }
        System.out.println("\r");
        System.out.println("Estrelas:\r");
        for (int i = 0; i < getStars().length; i++) {
            Arrays.sort(getStars());
            System.out.print(getStars()[i] + "\t");
        }
        System.out.println("\r");
    }

    public int[] getNums() {
        return nums;
    }

    public void setNums(int[] nums) {
        this.nums = nums;
    }

    public int[] getStars() {
        return stars;
    }

    public void setStars(int[] stars) {
        this.stars = stars;
    }
}
