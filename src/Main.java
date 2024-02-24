import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<String> inputStrings = new ArrayList<>();
        while(true){ //ввод строк

            String currInputString = sc.nextLine();
            if(currInputString == ""){
                break;
            }
            inputStrings.add(currInputString);

        }

        if(inputStrings.size() % 2 != 0){ //доввод строки, если их оказалось нечётное количество
            while (true) {
                System.out.println("Wrong amount of input strings: add one more string line");
                String otherInpString = sc.nextLine();
                if (otherInpString != "") {
                    inputStrings.add(otherInpString);
                    break;
                }
            }
        }
        System.out.println(inputStrings);

        ArrayList<String> outputStrings = new ArrayList<>();
        for(int i = 0; i < inputStrings.size(); i+=2){ //поиск строковых комбинаций Х для каждой пары значений А и В
            String stringA = inputStrings.get(i);
            String stringB = inputStrings.get(i + 1);
            String stringX = "";

            for(char j = 97; j < 123; j++){ //поиск каждого символа, встречающегося и в А и в В в алфавитном порядке
                if(stringA.contains("" + j) && stringB.contains("" + j) ){
                    int symbolAmountA = stringA.length() - stringA.replace("" + j,"").length(); //узнаём количество раз сколько встречается этот символ
                    int symbolAmountB = stringB.length() - stringB.replace("" + j,"").length();
                    while(symbolAmountA > 0 && symbolAmountB > 0){
                        stringX += j;
                        symbolAmountA--;
                        symbolAmountB--;
                    }

                }
            }
            outputStrings.add(stringX);
        }

        for(String currOutputStr: outputStrings){ //вывод получившихся строковых комбинаций Х
            System.out.println(currOutputStr);
        }

    }
}