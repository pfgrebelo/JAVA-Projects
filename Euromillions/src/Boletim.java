import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Boletim {

    private int[] nums1 = new int[5];
    private int[] stars1 = new int[2];
    private int[] nums2 = new int[5];
    private int[] stars2 = new int[2];
    private int[] nums3 = new int[5];
    private int[] stars3 = new int[2];
    private int[] nums4 = new int[5];
    private int[] stars4 = new int[2];
    private int[] nums5 = new int[5];
    private int[] stars5 = new int[2];

    public Boletim() {          //CONSTRUTOR VAZIO
        int[] nums1 = new int[]{};
        int[] stars1 = new int[]{};
        int[] nums2 = new int[]{};
        int[] stars2 = new int[]{};
        int[] nums3 = new int[]{};
        int[] stars3 = new int[]{};
        int[] nums4 = new int[]{};
        int[] stars4 = new int[]{};
        int[] nums5 = new int[]{};
        int[] stars5 = new int[]{};
    }

    //CONSTRUTOR 1CHAVE
    public Boletim(int[] nums1, int[] stars1) {
        this.nums1 = nums1;
        this.stars1 = stars1;
    }

    //CONSTRUTOR 2 CHAVES
    public Boletim(int[] nums1, int[] stars1, int[] nums2, int[] stars2) {
        this.nums1 = nums1;
        this.stars1 = stars1;
        this.nums2 = nums2;
        this.stars2 = stars2;
    }

    //CONSTRUTOR 3 CHAVES
    public Boletim(int[] nums1, int[] stars1, int[] nums2, int[] stars2, int[] nums3, int[] stars3) {
        this.nums1 = nums1;
        this.stars1 = stars1;
        this.nums2 = nums2;
        this.stars2 = stars2;
        this.setNums3(nums3);
        this.setStars3(stars3);
    }

    //CONSTRUTOR 4 CHAVES
    public Boletim(int[] nums1, int[] stars1, int[] nums2, int[] stars2, int[] nums3, int[] stars3, int[] nums4, int[] stars4) {
        this.nums1 = nums1;
        this.stars1 = stars1;
        this.nums2 = nums2;
        this.stars2 = stars2;
        this.setNums3(nums3);
        this.setStars3(stars3);
        this.setNums4(nums4);
        this.setStars4(stars4);
    }

    //CONSTRUTOR 5 CHAVES
    public Boletim(int[] nums1, int[] stars1, int[] nums2, int[] stars2, int[] nums3, int[] stars3, int[] nums4, int[] stars4, int[] nums5, int[] stars5) {
        this.nums1 = nums1;
        this.stars1 = stars1;
        this.nums2 = nums2;
        this.stars2 = stars2;
        this.setNums3(nums3);
        this.setStars3(stars3);
        this.setNums4(nums4);
        this.setStars4(stars4);
        this.setNums5(nums5);
        this.setStars5(stars5);
    }

    public boolean duplicate(int[] array, int n) {  //VERIFICA DUPLICADOS
        for (int i = 0; i < array.length; i++) {
            if (array[i] == n) {
                return true;
            }
        }
        return false;
    }

    //BOLETIM COM 1 CHAVE
    public void geraNumerosBoletim() {      //GERA BOLETIM COM 1 CHAVE
        Random rnd = new Random();
        int num;
        for (int i = 0; i < getNums1().length; i++) {       //GERA NUMEROS CHAVE 1
            num = rnd.nextInt(1, 51);
            while (duplicate(getNums1(), num)) {
                num = rnd.nextInt(1, 51);
            }
            getNums1()[i] = num;
        }
        for (int i = 0; i < getStars1().length; i++) {      //GERA ESTRELAS CHAVE 1
            num = rnd.nextInt(1, 12);
            while (duplicate(getStars1(), num)) {
                num = rnd.nextInt(1, 12);
            }
            getStars1()[i] = num;
        }
    }       //GERA BOLETIM COM 1 CHAVE

    public void escolheNumerosBoletim() {      //UTILIZADOR ESCOLHE BOLETIM COM 1 CHAVE
        Scanner in = new Scanner(System.in);
        int num;
        Arrays.fill(nums1, 0);
        Arrays.fill(stars1, 0);
        System.out.println("---Chave 1---");
        for (int i = 0; i < getNums1().length; i++) {
            System.out.println("Introduz o " + (i + 1) + "o numero:");
            num = in.nextInt();
            if (num <= 0 || num > 50) {
                System.out.println("Numero invalido, tem de ser entre 1 e 50.");
                System.out.println("Introduz o " + (i + 1) + "o numero:");
                num = in.nextInt();
            }
            if (duplicate(getNums1(), num)) {
                System.out.println("Numero repetido, tem de escolher um numero diferente.");
                System.out.println("Introduz o " + (i + 1) + "o numero:");
                num = in.nextInt();
            }
            getNums1()[i] = num;
        }
        for (int i = 0; i < getStars1().length; i++) {
            System.out.println("Introduz a " + (i + 1) + "a estrela:");
            num = in.nextInt();
            if (num <= 0 || num > 11) {
                System.out.println("Estrela invalida, tem de ser entre 1 e 11.");
                System.out.println("Introduz a " + (i + 1) + "a estrela:");
                num = in.nextInt();
            }
            if (duplicate(getStars1(), num)) {
                System.out.println("Estrela repetida, tem de escolher uma estrela diferente.");
                System.out.println("Introduz a " + (i + 1) + "a estrela:");
                num = in.nextInt();
            }
            getStars1()[i] = num;
        }
    }       //UTILIZADOR ESCOLHE BOLETIM COM 1 CHAVE

    public void escolheNumerosBoletim2Chaves() {      //UTILIZADOR ESCOLHE BOLETIM COM 2 CHAVES
        Scanner in = new Scanner(System.in);
        int num;
        Arrays.fill(nums1, 0);
        Arrays.fill(stars1, 0);
        Arrays.fill(nums2, 0);
        Arrays.fill(stars2, 0);
        System.out.println("---Chave 1---");
        for (int i = 0; i < getNums1().length; i++) {
            System.out.println("Introduz o " + (i + 1) + "o numero:");
            num = in.nextInt();
            if (num <= 0 || num > 50) {
                System.out.println("Numero invalido, tem de ser entre 1 e 50.");
                System.out.println("Introduz o " + (i + 1) + "o numero:");
                num = in.nextInt();
            }
            if (duplicate(getNums1(), num)) {
                System.out.println("Numero repetido, tem de escolher um numero diferente.");
                System.out.println("Introduz o " + (i + 1) + "o numero:");
                num = in.nextInt();
            }
            getNums1()[i] = num;
        }
        for (int i = 0; i < getStars1().length; i++) {
            System.out.println("Introduz a " + (i + 1) + "a estrela:");
            num = in.nextInt();
            if (num <= 0 || num > 11) {
                System.out.println("Estrela invalida, tem de ser entre 1 e 11.");
                System.out.println("Introduz a " + (i + 1) + "a estrela:");
                num = in.nextInt();
            }
            if (duplicate(getStars1(), num)) {
                System.out.println("Estrela repetida, tem de escolher uma estrela diferente.");
                System.out.println("Introduz a " + (i + 1) + "a estrela:");
                num = in.nextInt();
            }
            getStars1()[i] = num;
        }
        System.out.println("---Chave 2---");
        for (int i = 0; i < getNums2().length; i++) {
            System.out.println("Introduz o " + (i + 1) + "o numero:");
            num = in.nextInt();
            if (num <= 0 || num > 50) {
                System.out.println("Numero invalido, tem de ser entre 1 e 50.");
                System.out.println("Introduz o " + (i + 1) + "o numero:");
                num = in.nextInt();
            }
            if (duplicate(getNums2(), num)) {
                System.out.println("Numero repetido, tem de escolher um numero diferente.");
                System.out.println("Introduz o " + (i + 1) + "o numero:");
                num = in.nextInt();
            }
            getNums2()[i] = num;
        }
        for (int i = 0; i < getStars2().length; i++) {
            System.out.println("Introduz a " + (i + 1) + "a estrela:");
            num = in.nextInt();
            if (num <= 0 || num > 11) {
                System.out.println("Estrela invalida, tem de ser entre 1 e 11.");
                System.out.println("Introduz a " + (i + 1) + "a estrela:");
                num = in.nextInt();
            }
            if (duplicate(getStars2(), num)) {
                System.out.println("Estrela repetida, tem de escolher uma estrela diferente.");
                System.out.println("Introduz a " + (i + 1) + "a estrela:");
                num = in.nextInt();
            }
            getStars2()[i] = num;
        }
    }       //UTILIZADOR ESCOLHE BOLETIM COM 2 CHAVES

    public void escolheNumerosBoletim3Chaves() {      //UTILIZADOR ESCOLHE BOLETIM COM 3 CHAVES
        Scanner in = new Scanner(System.in);
        int num;
        Arrays.fill(nums1, 0);
        Arrays.fill(stars1, 0);
        Arrays.fill(nums2, 0);
        Arrays.fill(stars2, 0);
        Arrays.fill(nums3, 0);
        Arrays.fill(stars3, 0);
        System.out.println("---Chave 1---");
        for (int i = 0; i < getNums1().length; i++) {
            System.out.println("Introduz o " + (i + 1) + "o numero:");
            num = in.nextInt();
            if (num <= 0 || num > 50) {
                System.out.println("Numero invalido, tem de ser entre 1 e 50.");
                System.out.println("Introduz o " + (i + 1) + "o numero:");
                num = in.nextInt();
            }
            if (duplicate(getNums1(), num)) {
                System.out.println("Numero repetido, tem de escolher um numero diferente.");
                System.out.println("Introduz o " + (i + 1) + "o numero:");
                num = in.nextInt();
            }
            getNums1()[i] = num;
        }
        for (int i = 0; i < getStars1().length; i++) {
            System.out.println("Introduz a " + (i + 1) + "a estrela:");
            num = in.nextInt();
            if (num <= 0 || num > 11) {
                System.out.println("Estrela invalida, tem de ser entre 1 e 11.");
                System.out.println("Introduz a " + (i + 1) + "a estrela:");
                num = in.nextInt();
            }
            if (duplicate(getStars1(), num)) {
                System.out.println("Estrela repetida, tem de escolher uma estrela diferente.");
                System.out.println("Introduz a " + (i + 1) + "a estrela:");
                num = in.nextInt();
            }
            getStars1()[i] = num;
        }
        System.out.println("---Chave 2---");
        for (int i = 0; i < getNums2().length; i++) {
            System.out.println("Introduz o " + (i + 1) + "o numero:");
            num = in.nextInt();
            if (num <= 0 || num > 50) {
                System.out.println("Numero invalido, tem de ser entre 1 e 50.");
                System.out.println("Introduz o " + (i + 1) + "o numero:");
                num = in.nextInt();
            }
            if (duplicate(getNums2(), num)) {
                System.out.println("Numero repetido, tem de escolher um numero diferente.");
                System.out.println("Introduz o " + (i + 1) + "o numero:");
                num = in.nextInt();
            }
            getNums2()[i] = num;
        }
        for (int i = 0; i < getStars2().length; i++) {
            System.out.println("Introduz a " + (i + 1) + "a estrela:");
            num = in.nextInt();
            if (num <= 0 || num > 11) {
                System.out.println("Estrela invalida, tem de ser entre 1 e 11.");
                System.out.println("Introduz a " + (i + 1) + "a estrela:");
                num = in.nextInt();
            }
            if (duplicate(getStars2(), num)) {
                System.out.println("Estrela repetida, tem de escolher uma estrela diferente.");
                System.out.println("Introduz a " + (i + 1) + "a estrela:");
                num = in.nextInt();
            }
            getStars2()[i] = num;
        }
        System.out.println("---Chave 3---");
        for (int i = 0; i < getNums3().length; i++) {
            System.out.println("Introduz o " + (i + 1) + "o numero:");
            num = in.nextInt();
            if (num <= 0 || num > 50) {
                System.out.println("Numero invalido, tem de ser entre 1 e 50.");
                System.out.println("Introduz o " + (i + 1) + "o numero:");
                num = in.nextInt();
            }
            if (duplicate(getNums3(), num)) {
                System.out.println("Numero repetido, tem de escolher um numero diferente.");
                System.out.println("Introduz o " + (i + 1) + "o numero:");
                num = in.nextInt();
            }
            getNums3()[i] = num;
        }
        for (int i = 0; i < getStars3().length; i++) {
            System.out.println("Introduz a " + (i + 1) + "a estrela:");
            num = in.nextInt();
            if (num <= 0 || num > 11) {
                System.out.println("Estrela invalida, tem de ser entre 1 e 11.");
                System.out.println("Introduz a " + (i + 1) + "a estrela:");
                num = in.nextInt();
            }
            if (duplicate(getStars3(), num)) {
                System.out.println("Estrela repetida, tem de escolher uma estrela diferente.");
                System.out.println("Introduz a " + (i + 1) + "a estrela:");
                num = in.nextInt();
            }
            getStars3()[i] = num;
        }
    }       //UTILIZADOR ESCOLHE BOLETIM COM 3 CHAVES

    public void escolheNumerosBoletim4Chaves() {      //UTILIZADOR ESCOLHE BOLETIM COM 4 CHAVES
        Scanner in = new Scanner(System.in);
        int num;
        Arrays.fill(nums1, 0);
        Arrays.fill(stars1, 0);
        Arrays.fill(nums2, 0);
        Arrays.fill(stars2, 0);
        Arrays.fill(nums3, 0);
        Arrays.fill(stars3, 0);
        Arrays.fill(nums4, 0);
        Arrays.fill(stars4, 0);
        System.out.println("---Chave 1---");
        for (int i = 0; i < getNums1().length; i++) {
            System.out.println("Introduz o " + (i + 1) + "o numero:");
            num = in.nextInt();
            if (num <= 0 || num > 50) {
                System.out.println("Numero invalido, tem de ser entre 1 e 50.");
                System.out.println("Introduz o " + (i + 1) + "o numero:");
                num = in.nextInt();
            }
            if (duplicate(getNums1(), num)) {
                System.out.println("Numero repetido, tem de escolher um numero diferente.");
                System.out.println("Introduz o " + (i + 1) + "o numero:");
                num = in.nextInt();
            }
            getNums1()[i] = num;
        }
        for (int i = 0; i < getStars1().length; i++) {
            System.out.println("Introduz a " + (i + 1) + "a estrela:");
            num = in.nextInt();
            if (num <= 0 || num > 11) {
                System.out.println("Estrela invalida, tem de ser entre 1 e 11.");
                System.out.println("Introduz a " + (i + 1) + "a estrela:");
                num = in.nextInt();
            }
            if (duplicate(getStars1(), num)) {
                System.out.println("Estrela repetida, tem de escolher uma estrela diferente.");
                System.out.println("Introduz a " + (i + 1) + "a estrela:");
                num = in.nextInt();
            }
            getStars1()[i] = num;
        }
        System.out.println("---Chave 2---");
        for (int i = 0; i < getNums2().length; i++) {
            System.out.println("Introduz o " + (i + 1) + "o numero:");
            num = in.nextInt();
            if (num <= 0 || num > 50) {
                System.out.println("Numero invalido, tem de ser entre 1 e 50.");
                System.out.println("Introduz o " + (i + 1) + "o numero:");
                num = in.nextInt();
            }
            if (duplicate(getNums2(), num)) {
                System.out.println("Numero repetido, tem de escolher um numero diferente.");
                System.out.println("Introduz o " + (i + 1) + "o numero:");
                num = in.nextInt();
            }
            getNums2()[i] = num;
        }
        for (int i = 0; i < getStars2().length; i++) {
            System.out.println("Introduz a " + (i + 1) + "a estrela:");
            num = in.nextInt();
            if (num <= 0 || num > 11) {
                System.out.println("Estrela invalida, tem de ser entre 1 e 11.");
                System.out.println("Introduz a " + (i + 1) + "a estrela:");
                num = in.nextInt();
            }
            if (duplicate(getStars2(), num)) {
                System.out.println("Estrela repetida, tem de escolher uma estrela diferente.");
                System.out.println("Introduz a " + (i + 1) + "a estrela:");
                num = in.nextInt();
            }
            getStars2()[i] = num;
        }
        System.out.println("---Chave 3---");
        for (int i = 0; i < getNums3().length; i++) {
            System.out.println("Introduz o " + (i + 1) + "o numero:");
            num = in.nextInt();
            if (num <= 0 || num > 50) {
                System.out.println("Numero invalido, tem de ser entre 1 e 50.");
                System.out.println("Introduz o " + (i + 1) + "o numero:");
                num = in.nextInt();
            }
            if (duplicate(getNums3(), num)) {
                System.out.println("Numero repetido, tem de escolher um numero diferente.");
                System.out.println("Introduz o " + (i + 1) + "o numero:");
                num = in.nextInt();
            }
            getNums3()[i] = num;
        }
        for (int i = 0; i < getStars3().length; i++) {
            System.out.println("Introduz a " + (i + 1) + "a estrela:");
            num = in.nextInt();
            if (num <= 0 || num > 11) {
                System.out.println("Estrela invalida, tem de ser entre 1 e 11.");
                System.out.println("Introduz a " + (i + 1) + "a estrela:");
                num = in.nextInt();
            }
            if (duplicate(getStars3(), num)) {
                System.out.println("Estrela repetida, tem de escolher uma estrela diferente.");
                System.out.println("Introduz a " + (i + 1) + "a estrela:");
                num = in.nextInt();
            }
            getStars3()[i] = num;
        }
        System.out.println("---Chave 4---");
        for (int i = 0; i < getNums4().length; i++) {
            System.out.println("Introduz o " + (i + 1) + "o numero:");
            num = in.nextInt();
            if (num <= 0 || num > 50) {
                System.out.println("Numero invalido, tem de ser entre 1 e 50.");
                System.out.println("Introduz o " + (i + 1) + "o numero:");
                num = in.nextInt();
            }
            if (duplicate(getNums4(), num)) {
                System.out.println("Numero repetido, tem de escolher um numero diferente.");
                System.out.println("Introduz o " + (i + 1) + "o numero:");
                num = in.nextInt();
            }
            getNums4()[i] = num;
        }
        for (int i = 0; i < getStars4().length; i++) {
            System.out.println("Introduz a " + (i + 1) + "a estrela:");
            num = in.nextInt();
            if (num <= 0 || num > 11) {
                System.out.println("Estrela invalida, tem de ser entre 1 e 11.");
                System.out.println("Introduz a " + (i + 1) + "a estrela:");
                num = in.nextInt();
            }
            if (duplicate(getStars4(), num)) {
                System.out.println("Estrela repetida, tem de escolher uma estrela diferente.");
                System.out.println("Introduz a " + (i + 1) + "a estrela:");
                num = in.nextInt();
            }
            getStars4()[i] = num;
        }
    }       //UTILIZADOR ESCOLHE BOLETIM COM 4 CHAVES
    public void escolheNumerosBoletim5Chaves() {      //UTILIZADOR ESCOLHE BOLETIM COM 5 CHAVES
        Scanner in = new Scanner(System.in);
        int num;
        Arrays.fill(nums1, 0);
        Arrays.fill(stars1, 0);
        Arrays.fill(nums2, 0);
        Arrays.fill(stars2, 0);
        Arrays.fill(nums3, 0);
        Arrays.fill(stars3, 0);
        Arrays.fill(nums4, 0);
        Arrays.fill(stars4, 0);
        Arrays.fill(nums5, 0);
        Arrays.fill(stars5, 0);
        System.out.println("---Chave 1---");
        for (int i = 0; i < getNums1().length; i++) {
            System.out.println("Introduz o " + (i + 1) + "o numero:");
            num = in.nextInt();
            if (num <= 0 || num > 50) {
                System.out.println("Numero invalido, tem de ser entre 1 e 50.");
                System.out.println("Introduz o " + (i + 1) + "o numero:");
                num = in.nextInt();
            }
            if (duplicate(getNums1(), num)) {
                System.out.println("Numero repetido, tem de escolher um numero diferente.");
                System.out.println("Introduz o " + (i + 1) + "o numero:");
                num = in.nextInt();
            }
            getNums1()[i] = num;
        }
        for (int i = 0; i < getStars1().length; i++) {
            System.out.println("Introduz a " + (i + 1) + "a estrela:");
            num = in.nextInt();
            if (num <= 0 || num > 11) {
                System.out.println("Estrela invalida, tem de ser entre 1 e 11.");
                System.out.println("Introduz a " + (i + 1) + "a estrela:");
                num = in.nextInt();
            }
            if (duplicate(getStars1(), num)) {
                System.out.println("Estrela repetida, tem de escolher uma estrela diferente.");
                System.out.println("Introduz a " + (i + 1) + "a estrela:");
                num = in.nextInt();
            }
            getStars1()[i] = num;
        }
        System.out.println("---Chave 2---");
        for (int i = 0; i < getNums2().length; i++) {
            System.out.println("Introduz o " + (i + 1) + "o numero:");
            num = in.nextInt();
            if (num <= 0 || num > 50) {
                System.out.println("Numero invalido, tem de ser entre 1 e 50.");
                System.out.println("Introduz o " + (i + 1) + "o numero:");
                num = in.nextInt();
            }
            if (duplicate(getNums2(), num)) {
                System.out.println("Numero repetido, tem de escolher um numero diferente.");
                System.out.println("Introduz o " + (i + 1) + "o numero:");
                num = in.nextInt();
            }
            getNums2()[i] = num;
        }
        for (int i = 0; i < getStars2().length; i++) {
            System.out.println("Introduz a " + (i + 1) + "a estrela:");
            num = in.nextInt();
            if (num <= 0 || num > 11) {
                System.out.println("Estrela invalida, tem de ser entre 1 e 11.");
                System.out.println("Introduz a " + (i + 1) + "a estrela:");
                num = in.nextInt();
            }
            if (duplicate(getStars2(), num)) {
                System.out.println("Estrela repetida, tem de escolher uma estrela diferente.");
                System.out.println("Introduz a " + (i + 1) + "a estrela:");
                num = in.nextInt();
            }
            getStars2()[i] = num;
        }
        System.out.println("---Chave 3---");
        for (int i = 0; i < getNums3().length; i++) {
            System.out.println("Introduz o " + (i + 1) + "o numero:");
            num = in.nextInt();
            if (num <= 0 || num > 50) {
                System.out.println("Numero invalido, tem de ser entre 1 e 50.");
                System.out.println("Introduz o " + (i + 1) + "o numero:");
                num = in.nextInt();
            }
            if (duplicate(getNums3(), num)) {
                System.out.println("Numero repetido, tem de escolher um numero diferente.");
                System.out.println("Introduz o " + (i + 1) + "o numero:");
                num = in.nextInt();
            }
            getNums3()[i] = num;
        }
        for (int i = 0; i < getStars3().length; i++) {
            System.out.println("Introduz a " + (i + 1) + "a estrela:");
            num = in.nextInt();
            if (num <= 0 || num > 11) {
                System.out.println("Estrela invalida, tem de ser entre 1 e 11.");
                System.out.println("Introduz a " + (i + 1) + "a estrela:");
                num = in.nextInt();
            }
            if (duplicate(getStars3(), num)) {
                System.out.println("Estrela repetida, tem de escolher uma estrela diferente.");
                System.out.println("Introduz a " + (i + 1) + "a estrela:");
                num = in.nextInt();
            }
            getStars3()[i] = num;
        }
        System.out.println("---Chave 4---");
        for (int i = 0; i < getNums4().length; i++) {
            System.out.println("Introduz o " + (i + 1) + "o numero:");
            num = in.nextInt();
            if (num <= 0 || num > 50) {
                System.out.println("Numero invalido, tem de ser entre 1 e 50.");
                System.out.println("Introduz o " + (i + 1) + "o numero:");
                num = in.nextInt();
            }
            if (duplicate(getNums4(), num)) {
                System.out.println("Numero repetido, tem de escolher um numero diferente.");
                System.out.println("Introduz o " + (i + 1) + "o numero:");
                num = in.nextInt();
            }
            getNums4()[i] = num;
        }
        for (int i = 0; i < getStars4().length; i++) {
            System.out.println("Introduz a " + (i + 1) + "a estrela:");
            num = in.nextInt();
            if (num <= 0 || num > 11) {
                System.out.println("Estrela invalida, tem de ser entre 1 e 11.");
                System.out.println("Introduz a " + (i + 1) + "a estrela:");
                num = in.nextInt();
            }
            if (duplicate(getStars4(), num)) {
                System.out.println("Estrela repetida, tem de escolher uma estrela diferente.");
                System.out.println("Introduz a " + (i + 1) + "a estrela:");
                num = in.nextInt();
            }
            getStars4()[i] = num;
        }
        System.out.println("---Chave 5---");
        for (int i = 0; i < getNums5().length; i++) {
            System.out.println("Introduz o " + (i + 1) + "o numero:");
            num = in.nextInt();
            if (num <= 0 || num > 50) {
                System.out.println("Numero invalido, tem de ser entre 1 e 50.");
                System.out.println("Introduz o " + (i + 1) + "o numero:");
                num = in.nextInt();
            }
            if (duplicate(getNums5(), num)) {
                System.out.println("Numero repetido, tem de escolher um numero diferente.");
                System.out.println("Introduz o " + (i + 1) + "o numero:");
                num = in.nextInt();
            }
            getNums5()[i] = num;
        }
        for (int i = 0; i < getStars5().length; i++) {
            System.out.println("Introduz a " + (i + 1) + "a estrela:");
            num = in.nextInt();
            if (num <= 0 || num > 11) {
                System.out.println("Estrela invalida, tem de ser entre 1 e 11.");
                System.out.println("Introduz a " + (i + 1) + "a estrela:");
                num = in.nextInt();
            }
            if (duplicate(getStars5(), num)) {
                System.out.println("Estrela repetida, tem de escolher uma estrela diferente.");
                System.out.println("Introduz a " + (i + 1) + "a estrela:");
                num = in.nextInt();
            }
            getStars5()[i] = num;
        }
    }       //UTILIZADOR ESCOLHE BOLETIM COM 5 CHAVES

    public void mostraBoletim() {               //MOSTRA BOLETIM COM 1 CHAVE
        System.out.println("---Chave 1---");
        System.out.println("Numeros:\r");
        for (int i = 0; i < getNums1().length; i++) {
            Arrays.sort(getNums1());
            System.out.print(getNums1()[i] + "\t");
        }
        System.out.println("\r");
        System.out.println("Estrelas:\r");
        for (int i = 0; i < getStars1().length; i++) {
            Arrays.sort(getStars1());
            System.out.print(getStars1()[i] + "\t");
        }
        System.out.println("\r");
    }

    //BOLETIM COM 2 CHAVES
    public void geraNumerosBoletim2Chaves() {       //GERA BOLETIM COM 2 CHAVES
        Random rnd = new Random();
        int num;
        for (int i = 0; i < getNums1().length; i++) {       //GERA NUMEROS CHAVE 1
            num = rnd.nextInt(1, 51);
            while (duplicate(getNums1(), num)) {
                num = rnd.nextInt(1, 51);
            }
            getNums1()[i] = num;
        }
        for (int i = 0; i < getStars1().length; i++) {      //GERA ESTRELAS CHAVE 1
            num = rnd.nextInt(1, 12);
            while (duplicate(getStars1(), num)) {
                num = rnd.nextInt(1, 12);
            }
            getStars1()[i] = num;
        }
        for (int i = 0; i < getNums2().length; i++) {       //GERA NUMEROS CHAVE 2
            num = rnd.nextInt(1, 51);
            while (duplicate(getNums2(), num)) {
                num = rnd.nextInt(1, 51);
            }
            getNums2()[i] = num;
        }
        for (int i = 0; i < getStars2().length; i++) {      //GERA ESTRELAS CHAVE 2
            num = rnd.nextInt(1, 12);
            while (duplicate(getStars2(), num)) {
                num = rnd.nextInt(1, 12);
            }
            getStars2()[i] = num;
        }
    }       //GERA BOLETIM COM 2 CHAVES

    public void mostraBoletim2Chaves() {        //MOSTRA BOLETIM COM 2 CHAVES
        System.out.println("---Chave 1---");
        System.out.println("Numeros:\r");
        for (int i = 0; i < getNums1().length; i++) {
            Arrays.sort(getNums1());
            System.out.print(getNums1()[i] + "\t");
        }
        System.out.println("\r");
        System.out.println("Estrelas:\r");
        for (int i = 0; i < getStars1().length; i++) {
            Arrays.sort(getStars1());
            System.out.print(getStars1()[i] + "\t");
        }
        System.out.println("\r");
        System.out.println("---Chave 2---");
        System.out.println("Numeros:\r");
        for (int i = 0; i < getNums2().length; i++) {
            Arrays.sort(getNums2());
            System.out.print(getNums2()[i] + "\t");
        }
        System.out.println("\r");
        System.out.println("Estrelas:\r");
        for (int i = 0; i < getStars2().length; i++) {
            Arrays.sort(getStars2());
            System.out.print(getStars2()[i] + "\t");
        }
        System.out.println("\r");
    }       //MOSTRA BOLETIM COM 2 CHAVES

    //BOLETIM COM 3 CHAVES
    public void geraNumerosBoletim3Chaves() {       //GERA BOLETIM COM 3 CHAVES
        Random rnd = new Random();
        int num;
        for (int i = 0; i < getNums1().length; i++) {       //GERA NUMEROS CHAVE 1
            num = rnd.nextInt(1, 51);
            while (duplicate(getNums1(), num)) {
                num = rnd.nextInt(1, 51);
            }
            getNums1()[i] = num;
        }
        for (int i = 0; i < getStars1().length; i++) {      //GERA ESTRELAS CHAVE 1
            num = rnd.nextInt(1, 12);
            while (duplicate(getStars1(), num)) {
                num = rnd.nextInt(1, 12);
            }
            getStars1()[i] = num;
        }
        for (int i = 0; i < getNums2().length; i++) {       //GERA NUMEROS CHAVE 2
            num = rnd.nextInt(1, 51);
            while (duplicate(getNums2(), num)) {
                num = rnd.nextInt(1, 51);
            }
            getNums2()[i] = num;
        }
        for (int i = 0; i < getStars2().length; i++) {      //GERA ESTRELAS CHAVE 2
            num = rnd.nextInt(1, 12);
            while (duplicate(getStars2(), num)) {
                num = rnd.nextInt(1, 12);
            }
            getStars2()[i] = num;
        }
        for (int i = 0; i < getNums3().length; i++) {       //GERA NUMEROS CHAVE 3
            num = rnd.nextInt(1, 51);
            while (duplicate(getNums3(), num)) {
                num = rnd.nextInt(1, 51);
            }
            getNums3()[i] = num;
        }
        for (int i = 0; i < getStars3().length; i++) {      //GERA ESTRELAS CHAVE 3
            num = rnd.nextInt(1, 12);
            while (duplicate(getStars3(), num)) {
                num = rnd.nextInt(1, 12);
            }
            getStars3()[i] = num;
        }
    }       //GERA BOLETIM COM 3 CHAVES

    public void mostraBoletim3Chaves() {        //MOSTRA BOLETIM COM 3 CHAVES
        System.out.println("---Chave 1---");
        System.out.println("Numeros:\r");
        for (int i = 0; i < getNums1().length; i++) {
            Arrays.sort(getNums1());
            System.out.print(getNums1()[i] + "\t");
        }
        System.out.println("\r");
        System.out.println("Estrelas:\r");
        for (int i = 0; i < getStars1().length; i++) {
            Arrays.sort(getStars1());
            System.out.print(getStars1()[i] + "\t");
        }
        System.out.println("\r");
        System.out.println("---Chave 2---");
        System.out.println("Numeros:\r");
        for (int i = 0; i < getNums2().length; i++) {
            Arrays.sort(getNums2());
            System.out.print(getNums2()[i] + "\t");
        }
        System.out.println("\r");
        System.out.println("Estrelas:\r");
        for (int i = 0; i < getStars2().length; i++) {
            Arrays.sort(getStars2());
            System.out.print(getStars2()[i] + "\t");
        }
        System.out.println("\r");
        System.out.println("---Chave 3---");
        System.out.println("Numeros:\r");
        for (int i = 0; i < getNums3().length; i++) {
            Arrays.sort(getNums3());
            System.out.print(getNums3()[i] + "\t");
        }
        System.out.println("\r");
        System.out.println("Estrelas:\r");
        for (int i = 0; i < getStars3().length; i++) {
            Arrays.sort(getStars3());
            System.out.print(getStars3()[i] + "\t");
        }
        System.out.println("\r");
    }       //MOSTRA BOLETIM COM 3 CHAVES

    //BOLETIM COM 4 CHAVES
    public void geraNumerosBoletim4Chaves() {       //GERA BOLETIM COM 4 CHAVES
        Random rnd = new Random();
        int num;
        for (int i = 0; i < getNums1().length; i++) {       //GERA NUMEROS CHAVE 1
            num = rnd.nextInt(1, 51);
            while (duplicate(getNums1(), num)) {
                num = rnd.nextInt(1, 51);
            }
            getNums1()[i] = num;
        }
        for (int i = 0; i < getStars1().length; i++) {      //GERA ESTRELAS CHAVE 1
            num = rnd.nextInt(1, 12);
            while (duplicate(getStars1(), num)) {
                num = rnd.nextInt(1, 12);
            }
            getStars1()[i] = num;
        }
        for (int i = 0; i < getNums2().length; i++) {       //GERA NUMEROS CHAVE 2
            num = rnd.nextInt(1, 51);
            while (duplicate(getNums2(), num)) {
                num = rnd.nextInt(1, 51);
            }
            getNums2()[i] = num;
        }
        for (int i = 0; i < getStars2().length; i++) {      //GERA ESTRELAS CHAVE 2
            num = rnd.nextInt(1, 12);
            while (duplicate(getStars2(), num)) {
                num = rnd.nextInt(1, 12);
            }
            getStars2()[i] = num;
        }
        for (int i = 0; i < getNums3().length; i++) {       //GERA NUMEROS CHAVE 3
            num = rnd.nextInt(1, 51);
            while (duplicate(getNums3(), num)) {
                num = rnd.nextInt(1, 51);
            }
            getNums3()[i] = num;
        }
        for (int i = 0; i < getStars3().length; i++) {      //GERA ESTRELAS CHAVE 3
            num = rnd.nextInt(1, 12);
            while (duplicate(getStars3(), num)) {
                num = rnd.nextInt(1, 12);
            }
            getStars3()[i] = num;
        }
        for (int i = 0; i < getNums4().length; i++) {       //GERA NUMEROS CHAVE 4
            num = rnd.nextInt(1, 51);
            while (duplicate(getNums4(), num)) {
                num = rnd.nextInt(1, 51);
            }
            getNums4()[i] = num;
        }
        for (int i = 0; i < getStars4().length; i++) {      //GERA ESTRELAS CHAVE 4
            num = rnd.nextInt(1, 12);
            while (duplicate(getStars4(), num)) {
                num = rnd.nextInt(1, 12);
            }
            getStars4()[i] = num;
        }
    }       //GERA BOLETIM COM 4 CHAVES

    public void mostraBoletim4Chaves() {            //MOSTRA BOLETIM COM 4 CHAVES
        System.out.println("---Chave 1---");
        System.out.println("Numeros:\r");
        for (int i = 0; i < getNums1().length; i++) {
            Arrays.sort(getNums1());
            System.out.print(getNums1()[i] + "\t");
        }
        System.out.println("\r");
        System.out.println("Estrelas:\r");
        for (int i = 0; i < getStars1().length; i++) {
            Arrays.sort(getStars1());
            System.out.print(getStars1()[i] + "\t");
        }
        System.out.println("\r");
        System.out.println("---Chave 2---");
        System.out.println("Numeros:\r");
        for (int i = 0; i < getNums2().length; i++) {
            Arrays.sort(getNums2());
            System.out.print(getNums2()[i] + "\t");
        }
        System.out.println("\r");
        System.out.println("Estrelas:\r");
        for (int i = 0; i < getStars2().length; i++) {
            Arrays.sort(getStars2());
            System.out.print(getStars2()[i] + "\t");
        }
        System.out.println("\r");
        System.out.println("---Chave 3---");
        System.out.println("Numeros:\r");
        for (int i = 0; i < getNums3().length; i++) {
            Arrays.sort(getNums3());
            System.out.print(getNums3()[i] + "\t");
        }
        System.out.println("\r");
        System.out.println("Estrelas:\r");
        for (int i = 0; i < getStars3().length; i++) {
            Arrays.sort(getStars3());
            System.out.print(getStars3()[i] + "\t");
        }
        System.out.println("\r");
        System.out.println("---Chave 4---");
        System.out.println("Numeros:\r");
        for (int i = 0; i < getNums4().length; i++) {
            Arrays.sort(getNums4());
            System.out.print(getNums4()[i] + "\t");
        }
        System.out.println("\r");
        System.out.println("Estrelas:\r");
        for (int i = 0; i < getStars4().length; i++) {
            Arrays.sort(getStars4());
            System.out.print(getStars4()[i] + "\t");
        }
        System.out.println("\r");
    }       //MOSTRA BOLETIM COM 4 CHAVES

    //BOLETIM COM 5 CHAVES
    public void geraNumerosBoletim5Chaves() {       //GERA BOLETIM COM 5 CHAVES
        Random rnd = new Random();
        int num;
        for (int i = 0; i < getNums1().length; i++) {       //GERA NUMEROS CHAVE 1
            num = rnd.nextInt(1, 51);
            while (duplicate(getNums1(), num)) {
                num = rnd.nextInt(1, 51);
            }
            getNums1()[i] = num;
        }
        for (int i = 0; i < getStars1().length; i++) {      //GERA ESTRELAS CHAVE 1
            num = rnd.nextInt(1, 12);
            while (duplicate(getStars1(), num)) {
                num = rnd.nextInt(1, 12);
            }
            getStars1()[i] = num;
        }
        for (int i = 0; i < getNums2().length; i++) {       //GERA NUMEROS CHAVE 2
            num = rnd.nextInt(1, 51);
            while (duplicate(getNums2(), num)) {
                num = rnd.nextInt(1, 51);
            }
            getNums2()[i] = num;
        }
        for (int i = 0; i < getStars2().length; i++) {      //GERA ESTRELAS CHAVE 2
            num = rnd.nextInt(1, 12);
            while (duplicate(getStars2(), num)) {
                num = rnd.nextInt(1, 12);
            }
            getStars2()[i] = num;
        }
        for (int i = 0; i < getNums3().length; i++) {       //GERA NUMEROS CHAVE 3
            num = rnd.nextInt(1, 51);
            while (duplicate(getNums3(), num)) {
                num = rnd.nextInt(1, 51);
            }
            getNums3()[i] = num;
        }
        for (int i = 0; i < getStars3().length; i++) {      //GERA ESTRELAS CHAVE 3
            num = rnd.nextInt(1, 12);
            while (duplicate(getStars3(), num)) {
                num = rnd.nextInt(1, 12);
            }
            getStars3()[i] = num;
        }
        for (int i = 0; i < getNums4().length; i++) {       //GERA NUMEROS CHAVE 4
            num = rnd.nextInt(1, 51);
            while (duplicate(getNums4(), num)) {
                num = rnd.nextInt(1, 51);
            }
            getNums4()[i] = num;
        }
        for (int i = 0; i < getStars4().length; i++) {      //GERA ESTRELAS CHAVE 4
            num = rnd.nextInt(1, 12);
            while (duplicate(getStars4(), num)) {
                num = rnd.nextInt(1, 12);
            }
            getStars4()[i] = num;
        }
        for (int i = 0; i < getNums5().length; i++) {       //GERA NUMEROS CHAVE 5
            num = rnd.nextInt(1, 51);
            while (duplicate(getNums5(), num)) {
                num = rnd.nextInt(1, 51);
            }
            getNums5()[i] = num;
        }
        for (int i = 0; i < getStars5().length; i++) {      //GERA ESTRELAS CHAVE 5
            num = rnd.nextInt(1, 12);
            while (duplicate(getStars5(), num)) {
                num = rnd.nextInt(1, 12);
            }
            getStars5()[i] = num;
        }
    }       //GERA BOLETIM COM 5 CHAVES

    public void mostraBoletim5Chaves() {            //MOSTRA BOLETIM COM 5 CHAVES
        System.out.println("---Chave 1---");
        System.out.println("Numeros:\r");
        for (int i = 0; i < getNums1().length; i++) {
            Arrays.sort(getNums1());
            System.out.print(getNums1()[i] + "\t");
        }
        System.out.println("\r");
        System.out.println("Estrelas:\r");
        for (int i = 0; i < getStars1().length; i++) {
            Arrays.sort(getStars1());
            System.out.print(getStars1()[i] + "\t");
        }
        System.out.println("\r");
        System.out.println("---Chave 2---");
        System.out.println("Numeros:\r");
        for (int i = 0; i < getNums2().length; i++) {
            Arrays.sort(getNums2());
            System.out.print(getNums2()[i] + "\t");
        }
        System.out.println("\r");
        System.out.println("Estrelas:\r");
        for (int i = 0; i < getStars2().length; i++) {
            Arrays.sort(getStars2());
            System.out.print(getStars2()[i] + "\t");
        }
        System.out.println("\r");
        System.out.println("---Chave 3---");
        System.out.println("Numeros:\r");
        for (int i = 0; i < getNums3().length; i++) {
            Arrays.sort(getNums3());
            System.out.print(getNums3()[i] + "\t");
        }
        System.out.println("\r");
        System.out.println("Estrelas:\r");
        for (int i = 0; i < getStars3().length; i++) {
            Arrays.sort(getStars3());
            System.out.print(getStars3()[i] + "\t");
        }
        System.out.println("\r");
        System.out.println("---Chave 4---");
        System.out.println("Numeros:\r");
        for (int i = 0; i < getNums4().length; i++) {
            Arrays.sort(getNums4());
            System.out.print(getNums4()[i] + "\t");
        }
        System.out.println("\r");
        System.out.println("Estrelas:\r");
        for (int i = 0; i < getStars4().length; i++) {
            Arrays.sort(getStars4());
            System.out.print(getStars4()[i] + "\t");
        }
        System.out.println("\r");
        System.out.println("---Chave 5---");
        System.out.println("Numeros:\r");
        for (int i = 0; i < getNums5().length; i++) {
            Arrays.sort(getNums5());
            System.out.print(getNums5()[i] + "\t");
        }
        System.out.println("\r");
        System.out.println("Estrelas:\r");
        for (int i = 0; i < getStars5().length; i++) {
            Arrays.sort(getStars5());
            System.out.print(getStars5()[i] + "\t");
        }
        System.out.println("\r");
    }       //MOSTRA BOLETIM COM 5 CHAVES

    //REFACTOR < ENCAPSULATE FIELDS
    public int[] getNums1() {
        return nums1;
    }

    public void setNums1(int[] nums1) {
        this.nums1 = nums1;
    }

    public int[] getStars1() {
        return stars1;
    }

    public void setStars1(int[] stars1) {
        this.stars1 = stars1;
    }

    public int[] getNums2() {
        return nums2;
    }

    public void setNums2(int[] nums2) {
        this.nums2 = nums2;
    }

    public int[] getStars2() {
        return stars2;
    }

    public void setStars2(int[] stars2) {
        this.stars2 = stars2;
    }

    public int[] getNums3() {
        return nums3;
    }

    public void setNums3(int[] nums3) {
        this.nums3 = nums3;
    }

    public int[] getStars3() {
        return stars3;
    }

    public void setStars3(int[] stars3) {
        this.stars3 = stars3;
    }

    public int[] getNums4() {
        return nums4;
    }

    public void setNums4(int[] nums4) {
        this.nums4 = nums4;
    }

    public int[] getStars4() {
        return stars4;
    }

    public void setStars4(int[] stars4) {
        this.stars4 = stars4;
    }

    public int[] getNums5() {
        return nums5;
    }

    public void setNums5(int[] nums5) {
        this.nums5 = nums5;
    }

    public int[] getStars5() {
        return stars5;
    }

    public void setStars5(int[] stars5) {
        this.stars5 = stars5;
    }
}
