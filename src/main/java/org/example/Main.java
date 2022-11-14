package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Замена каждого второго вхождения Object-oriented programming на OOP");
        replace();

        String str = "Hello!!! I am a student of group 9305, Konstantin Nikolaenko. What is your name? ЛЭТИ agga fdfddfdf";

        //нижний регистр нужен для количества латинских слов, чтобы было два условия вместо 4.
        //не хотел повторяться, поэтому для других двух заданий также задействован нижний регистр, хотя там он особо не нужен.
        String strLower = str.toLowerCase();

        String[] strSplit = strLower.replace(".", "")
                .replace(",", "")
                .replace("!", "")
                .replace("?", "")
                .split(" ");

        System.out.println("\nСлово с минимальным количеством различных символов:");
        minDifChars(strSplit);

        System.out.print("\nКоличество латинских слов: ");
        countOfLatinWords(strSplit);

        System.out.println("Палиндромы:");
        palindromes(strSplit);
    }

    public static void palindromes(String[] strSplit){
        for(String s : strSplit){
            boolean output = true;

            for(int i = 0, j = s.length()-1; i < j; i++, j--){
                if(s.charAt(i) != s.charAt(j)) {
                    output = false;
                    break;
                }
            }

            if(output) System.out.println(s);
        }
    }

    public static void countOfLatinWords(String[] strSplit){
        int count = 0;

        for(int i = 0; i < strSplit.length; i++){
            count++;
            for(int j = 0; j < strSplit[i].length(); j++){
                if(strSplit[i].charAt(j) < 97 || strSplit[i].charAt(j) > 122){
                    count--;
                    break;
                }
            }
        }

        System.out.println(count);
    }

    public static void minDifChars(String[] strSplit){
        int min = 100;
        int index = 0;

        for(int i = 0; i < strSplit.length; i++){
            int count = countDifChars(strSplit[i]);
            if(count < min) {
                min = count;
                index = i;
            }
        }

        System.out.println("min = " + min);
        System.out.println("word: " + strSplit[index]);
    }

    public static int countDifChars(String s){
        int index = 0;
        String setChars = "";

        for(int j = 0; j < s.length(); j++)
            if(!isSymbol(setChars, s.charAt(j)))
                setChars += s.charAt(j);

        return setChars.length();
    }

    public static boolean isSymbol(String set, char c){
        boolean flag = false;

        for(int i = 0; i < set.length(); i++){
            if(c == set.charAt(i)){
                flag = true;
                break;
            }
        }

        return flag;
    }

    public static void replace(){
        String str = "Object-oriented programming is a programming language model " +
                "organized around objects rather than \"actions\" and data rather " +
                "than logic. Object-oriented programming blabla. Object-oriented programming bla. " +
                "Object-oriented programming.";

        String[] strings = str.split("\\.");
        String strFinal = "";

        for(int i = 0; i < strings.length; i++) {
            if((i % 2) == 1)
                strings[i] = strings[i].replace("Object-oriented programming", "OOP");
            strFinal += strings[i] + ". ";
        }

        System.out.println(strFinal);
    }
}