package Regular;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
1. Написать метод, который принимает 2 параметра
- List<String> values
- String pattern
 возвращает List<String> которые матчатся на паттерн

 2. Создать List<String> (валидных и невалидных значений) и Паттерг для валидации следующих значений
- e-mail

3. Вывести на экран только валидные значения с задания 2, используя метод с задания 1
 */
public class RegularPattern {
    public static void main(String[] args) {
        //Email List
        List<String> emails = new ArrayList<>();
        emails.add("one@domain.com");
        emails.add("two@domain.co.in");
        emails.add("user1@domain.com");
        emails.add("user2.name@domain.com");
        emails.add("user#@domain.co.in");
        emails.add("user@domaincom");
        //Invalid emails
        emails.add("fail#domain.com");
        emails.add("@gmail.com");
        //Pattern
        String regex = "^(.+)@(.+)$";
        //Method
        getCorrectEmails(emails, regex);
    }

    public static void getCorrectEmails(List<String> emails, String regEx){
        Pattern pattern = Pattern.compile(regEx);

        for(String email : emails){
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()){
                System.out.println(email +" : "+ matcher.matches());
            }
        }
    }


}
