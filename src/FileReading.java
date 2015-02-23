import java.io.*;
import java.util.*;

/**
 * Created by Sviridov Sergey on 10.12.2014.
 * Рассматриваем задание №1.
 */
public class FileReading {
    static ArrayList<Integer> list=new ArrayList<Integer>(); //создаем массив для считывания и хранения массива целых чисел из файла
    //использую ArrayList, т.к. неизвестно кол-во элементов, которое получим из файла (ArrayList имеет свойство динамически расширяться при необходимости)
    public static int singleNumber (ArrayList<Integer> list){
//создаем метод, в котором будем находить число, представленное в единичном экземпляре
        int x;
        int y=0;
        for (int i=0;i<list.size();i++){
            x= Collections.frequency(list,list.get(i));//воспользуемся методом, который определяет кол-во элементов в коллекции
            if (x==1){//находим элемент, который представлен один раз
                y=list.get(i);
                i=list.size();//т.к. наш элемент единственный(по условию) и мы его нашли, то нет необходимости проходить до конца массива
            }
        }
        return y;
    }
    public static void main(String[] args) throws FileNotFoundException, IOException {
        //Считываем данные из файла построчно, одновременно отделяем целые числа от остальных символов, которые могут быть в файле
        Scanner file=new Scanner(new File("D:\\practice\\FileYaml.yml"));

        while (file.hasNext()) {
            try {
                list.add(Integer.valueOf(file.next()));
            } catch (NumberFormatException e) {
                System.err.println("This is not a number");//если символ не является целым числом, выбрасываем оповещение
            }
        }
        System.out.println(list);//визуальная проверка массива
        System.out.println ("Число, которое представлено в единичном варианте "+ singleNumber(list));
    }
}
