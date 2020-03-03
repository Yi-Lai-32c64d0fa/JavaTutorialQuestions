package Recap.qf79bPerfectPalindromicCubes;

public class MySolution {

    public static boolean checkPalindromeCube(int i) {
        int cube = (int) Math.pow(i, 3);
        String stringRep = String.valueOf(cube);
        boolean result = true;
        for(int j = 0; j < stringRep.length(); j++) {
            result &= stringRep.charAt(j) == stringRep.charAt(stringRep.length() - j - 1);
        }
        return result;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1_500; i++ ){
            if(MySolution.checkPalindromeCube(i)) {
                int cube = (int) Math.pow(i, 3);
                System.out.println(i + "cubed is " + cube);
            }
        }
    }
}
