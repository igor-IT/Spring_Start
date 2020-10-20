package stream;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class HomeworkStream {

    public static void main(String[] args) {
        printFrid13InYear(1900,2000);
    }

    public static void printFrid13InYear(int start, int end){
        LocalDate startD = LocalDate.of(start, 1, 13);
        LocalDate endD = LocalDate.of(end, 12, 13);
        Stream.iterate(startD,f->f.plusMonths(1))
                .limit(ChronoUnit.MONTHS.between(startD,endD))
                .filter(l->l.getDayOfWeek() == DayOfWeek.FRIDAY)
                .collect(Collectors.groupingBy(localDate -> localDate.getYear(),Collectors.counting()))
                .entrySet().stream().sorted((k,v)-> (int) ( k.getValue() - v.getValue()))
                .forEach(System.out::println);
    }
}

