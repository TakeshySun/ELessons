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
        System.out.println(listEmails());
        System.out.println(listBankCard());
        System.out.println(listIp());
    }

    public static List<String> getCorrectValues(List<String> emails, String regEx){
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

    public static List<String> listEmails(){
        //Email List
        List<String> emails = new ArrayList<>();
        emails.add("one@domain.com");
        emails.add("two@domain.co.in");
        emails.add("user1@domain.com");
        emails.add("user2.name@domain.com");
        emails.add("user#@domain.co.in");
        emails.add("sd_sd@d_d.com");
        //Invalid emails
        emails.add("user@domaincom");
        emails.add("fail#domain.com");
        emails.add("@gmail.com");
        emails.add("ff,ff@.");
        emails.add(" @ . ");
        emails.add(" @k. ");
        emails.add("@k.");
        emails.add("^@::.com");
        //Pattern
        String regex = "^(.+\\S)@(\\w+)\\.(.+\\S)$";
        //Method
        return getCorrectValues(emails, regex);
    }

    public static List<String> listBankCard(){
        List<String> cards = new ArrayList<>();
        cards.add("1456-4444-5555-6666");
        cards.add("145-4444-5555-6666");
        cards.add("1456-444-5555-6666");
        cards.add("1456-4444-555-6666");
        cards.add("1456-4444-5555-666");
        cards.add("aaaa-dddd-dddd-dddd");
        cards.add("4444 4444 4444 4444");
        cards.add("4444444444444444");
        cards.add("abfd444444444444");
        cards.add("aaaa bbbb bbbb bbbb");

        //Pattern
        String regex = "^(\\d{4}).?(\\d{4}).?(\\d{4}).?(\\d{4})$";
        return getCorrectValues(cards, regex);
    }

    public static List<String> listIp(){
        List<String> listIp = new ArrayList<>();
        listIp.add("115.42.150.37");
        listIp.add("192.168.0.1");
        listIp.add("110.234.52.124");
        //Ivalid
        listIp.add("210.110");
        listIp.add("255");
        listIp.add("y.y.y.y");
        listIp.add("255.0.0.y");
        listIp.add("666.10.10.20");
        listIp.add("4444.11.11.11");
        listIp.add("33.3333.33.3");
        //Pattern
        String regex = String.format("^%1$s\\.%1$s\\.%1$s\\.%1$s$", "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)");

        return getCorrectValues(listIp, regex);
    }
}
