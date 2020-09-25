package Lesson_1;
/*
Create method which will accept parameter string data and return reverted data
 */

public class Task_5 {

    public static void main(String[] args) {
        String data = "Some text to be reverted";
        System.out.println(revertString(data));

        Task_5 task_5 = new Task_5();
        task_5.revert(data);
    }

    static StringBuffer revertString(String x){
        StringBuffer y = new StringBuffer();
        y.append(x).reverse();

        return y;
    }
/*
почему тут ошибка, как избежать индекс -1 ?
 */
    void revert(String x){
        char[] y = x.toCharArray();
        for (int i = y.length-1; i < y.length+1; i--){
            System.out.print(y[i]);
        }
    }

}
