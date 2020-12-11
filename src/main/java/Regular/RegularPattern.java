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
        //Invalid emails
        emails.add("user@domaincom");
        emails.add("fail#domain.com");
        emails.add("@gmail.com");
        emails.add("ff,ff@.");
        emails.add(" @ . ");
        emails.add(" @k. ");
        emails.add("@k. ");
        //Pattern
        String regex = "^(.+\\S)@(.+\\S)\\.(.+\\S)$";
        //Method
        System.out.println(getCorrectEmails(emails, regex));
    }

    public static List<String> getCorrectEmails(List<String> emails, String regEx){
        Pattern pattern = Pattern.compile(regEx);
        List<String> matchesValue = new ArrayList<>();
        for(String email : emails){
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()){
                matchesValue.add(email);
            }
        }
        return matchesValue;

    }


}
