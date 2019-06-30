import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    public int add(String numbers){

        String delimiter = ",|\n";
        String changeDelimiterPattern = "(//)(.+)(\n)(.+)";
        String secondChangeDelimiterPattern = "(//\\[)(.+)(\\]\n)(.+)";
        String thirdChangeDelimiterPattern = "(//)(((\\[)(.+)(\\])){2,})(\n)(.+)";
        int ignoreMoreThan = 1000;
        StringBuilder builder = new StringBuilder();
        if(numbers.matches(thirdChangeDelimiterPattern)){
            Pattern pattern = Pattern.compile(thirdChangeDelimiterPattern);
            Matcher matcher = pattern.matcher(numbers);
            if (matcher.find()){
                String delimiters = matcher.group(2);
                Pattern secondPattern = Pattern.compile("\\[(.+?)\\]");
                Matcher secondMatcher = secondPattern.matcher(delimiters);
                while (secondMatcher.find()){
                    String nextDelimiter = secondMatcher.group(1);
                    builder.append(nextDelimiter);
                    builder.append("|");
                }
            }
            builder.deleteCharAt(builder.length()-1);
            delimiter = builder.toString();
            builder = new StringBuilder();
            numbers = matcher.group(8);
        }
        else if(numbers.matches(changeDelimiterPattern)){

            Pattern pattern = numbers.matches(secondChangeDelimiterPattern) ? Pattern.compile(secondChangeDelimiterPattern)
                    : Pattern.compile(changeDelimiterPattern);
            Matcher matcher = pattern.matcher(numbers);
            if (matcher.find()){
                delimiter = matcher.group(2);
                numbers = matcher.group(4);
            }
        }
        int result = 0;
        String[] arrayOfNumbers = numbers.split(delimiter);
        int iterationLength = arrayOfNumbers.length;
        if(numbers.length()<iterationLength){
            iterationLength = numbers.length();
        }

        boolean wasNegative = false;
        for(int i=0;i<iterationLength; i++){
            result+= Integer.valueOf(arrayOfNumbers[i]) <= ignoreMoreThan ? Integer.valueOf(arrayOfNumbers[i]) : 0;
            if(Integer.valueOf(arrayOfNumbers[i])<0){
                wasNegative = true;
                builder.append(Integer.valueOf(arrayOfNumbers[i]));
                builder.append(", ");
            }
        }
        if(wasNegative){
            builder.insert(0, "Negative values were identified in function argument: ");
            throw new IllegalArgumentException(builder.toString());
        }
        return result;
    }

}
