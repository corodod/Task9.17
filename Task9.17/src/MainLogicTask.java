import java.util.Arrays;

import static java.lang.Math.abs;

public class MainLogicTask {
    public static int[] Process(int[][] arr) {

        int index1 = arr[1][0];
        int index2 = arr[1][1];
        int[] rab = arr[0];
        int countReplace = abs(index2-index1)-1;
        if (index2 > rab.length - 1){// arr в rabochi везде
            index2 = rab.length - 1;
        }
        if (index1 < 0){
            index1 = 0;
        }
        if(index1<index2){// по возврастанию
            for(int j = 0; j < countReplace; j++){
                for(int i = index1; i < index2;i++){
                    if(rab[i] > rab[i+1]){
                        int h = rab[i+1];
                        rab[i+1] = rab[i];
                        rab[i] = h;
                    }
                }
            }
        }
        if (index1>index2){//  по убыванию
            for(int j = 0; j < countReplace; j++){
                for(int i = index2; i < index1;i++){
                    if(rab[i] < rab[i+1]){
                        int h = rab[i+1];
                        rab[i+1] = rab[i];
                        rab[i] = h;
                    }
                }
            }
        }
//        else{
//            System.out.println("Введены некоректные данные");
//
//        }
        return rab;
        //System.out.println(Arrays.toString(rab));
//        for (int i = 0; i < arr.length; i++) {
//            arr[i]++;
//        }
    }
}
