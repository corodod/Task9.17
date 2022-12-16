import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.Arrays;

/*
equals
Возвращает true, если два указанных массива целых чисел равны друг другу. Два массива считаются равными,
если оба массива содержат одинаковое количество элементов и все соответствующие пары элементов в двух массивах равны.
Другими словами, два массива равны, если они содержат одни и те же элементы в одном и том же порядке.
Кроме того, две ссылки на массивы считаются равными, если обе имеют значение null.




КОВЕРЭЙДЖ
процент покртыия кодом
 */
public class TestOpa {//
    public static String testPath1In = ".\\Input1.txt", testPath1Out = ".\\Output1.txt", getTestPath1Out = ".\\OutputReady1.txt";
    public static String testPath2In = ".\\Input2.txt", testPath2Out = ".\\Output2.txt", getTestPath2Out = ".\\OutputReady2.txt";
    public static String testPath3In = ".\\Input3.txt", testPath3Out = ".\\Output3.txt", getTestPath3Out = ".\\OutputReady3.txt";

    public static void runTest() throws FileNotFoundException {
        testAnswer(testPath1In, testPath1Out, getTestPath1Out);
        testAnswer(testPath2In, testPath2Out, getTestPath2Out);
        testAnswer(testPath3In, testPath3Out, getTestPath3Out);
    }

    public static void testAnswer(String in, String out, String outReady) /*throws FileNotFoundException*/ {
        try {
            int[][] data = ArrayUtils.readIntArray2FromFile(in);// двумерный массив инпут который есть множесто
            //assert data != null;// Такая штука чтобы норм было, джава сама написала уже не нужна
            if (data == null) {
                System.out.println("Данных нет");
            } else {
                int[] result = MainLogicTask.Process(data);//почти всегда сюда будет заходить
                ArrayUtils.writeArrayToFile(out, result);// в файл тут запишет результат
                boolean flag = testAnswerCheck("" + Paths.get(outReady).toAbsolutePath(), "" + Paths.get(out).toAbsolutePath());// здесь видимо ерунда
                if (flag) System.out.println("Все хорошо, тест пройден");
                else System.out.println("Все плохо, тест не пройден");
            }

        } catch (Exception e) { // TODO

        }
//        int[][] data = ArrayUtils.readIntArray2FromFile(in);// двумерный массив инпут который есть множесто
//        //assert data != null;// Такая штука чтобы норм было, джава сама написала уже не нужна
//        if(data == null){
//            System.out.println("Данных нет");
//        }else{
//            int[] result = MainLogicTask.Process(data);//почти всегда сюда будет заходить
//            ArrayUtils.writeArrayToFile(out,result);// в файл тут запишет результат
//            boolean flag = testAnswerCheck(""+Paths.get(outReady).toAbsolutePath(),""+Paths.get(out).toAbsolutePath());// здесь видимо ерунда
//            if(flag) System.out.println("Все хорошо");
//            else System.out.println("Все плохо");
//        }
    }

    public static boolean testAnswerCheck(String pathTest, String pathAns) {// pathTest  адрес файла где ответ лежит
        int[] testAnswer = ArrayUtils.readIntArrayFromFile(pathTest);
        int[] resultAnswer = ArrayUtils.readIntArrayFromFile(pathAns);
//        System.out.println("148");
//        System.out.println(testAnswer);
//        System.out.println("148");
//        System.out.println(Arrays.toString(resultAnswer));
//        System.out.println("148");
        return Arrays.equals(testAnswer, resultAnswer);
    }
}
/*

 */

