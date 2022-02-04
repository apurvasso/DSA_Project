import java.util.*;

public class ArrayList {
    //Java Program to demonstrate the conversion of String into int
//using Integer.parseInt() method

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String s="200";//Declaring String variable
        int i=Integer.parseInt(s);//Converting String into int using Integer.parseInt()
        System.out.println(i);   //Printing value of i

        int ans = 0;
        ans += i;
        System.out.println(ans);
        List<String> liststr = new java.util.ArrayList<>();
        int n;
        System.out.println("enter size of arraylist");
        n = sc.nextInt();
        for(int j = 0;j<n;j++){
            for(int k = 0;k<n;k++) {
                liststr.add(sc.next());
            }
        }
        Iterator iter = null;
        for(int j = 0;j<n;j++){
            for(int k = 0;k<n;k++) {
                iter = liststr.iterator();
            }
        }
        while(iter.hasNext()){
            String str = String.valueOf(iter.next());
            String[] words = str.split("\\s");
            //  int[] nnn = Integer.parseInt(Arrays.stream(words).reduce());
            for(int k =0;k<words.length;k++){
                int inn = Integer.parseInt(words[k]);
            }
            int in = 0;
            //System.out.print(iter.next()+ " ");
            for(int j=0;j<n;j++){
                in = Integer.parseInt(str);
            }
            System.out.print(in + " ");
        }

    }
}
