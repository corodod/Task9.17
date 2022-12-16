import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Locale;

/*
17.	Реализовать метод пузырьковой сортировки элементов списка с индексами от index1 до index2 включительно:
public static void sort(List<Integer> list, int index1, int index2)
В собственной реализации не использовать существующие методы sort, а также не создавать новых списков или массивов.
Если index1 < index2, до числа в диапазоне [index1 – index2] должны быть упорядочены по возрастанию, если index1 > index2,
до числа в диапазоне [index2 – index1] должны быть упорядочены по убыванию, например:
({ 4, 7, 1, 3, 5, 6, 5, 2, 10, 7 }, 1, 4) → { 4, 1, 3, 5, 7, 6, 5, 2, 10, 7 }
({ 4, 7, 1, 3, 5, 6, 5, 2, 10, 7 }, 8, 2) → { 4, 7, 10, 6, 5, 5, 3, 2, 1, 7 }

Также учесть возможность задания index1 и index2 за пределами допустимых значений индексов элементов для переданного списка.
В этом случае заменить неправильные индексы первым или, соответственно, последним индексом из допустимых для переданного списка.


 */
public class Main {
    public static void main(String[] args) throws Exception {
        TestOpa.runTest();
        Locale.setDefault(Locale.ROOT);
        //SwingUtils.setLookAndFeelByName("Windows");
        //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        //SwingUtils.setDefaultFont("Microsoft Sans Serif", 18);

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new FrameMain().setVisible(true);
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

}