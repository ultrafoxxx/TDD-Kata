import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    public int add(String numbers){

        String delimiter = ",|\n";
        String changeDelimiterPattern = "(//)(.+)(\n)(.+)";
        int ignoreMoreThan = 1000;
        if(numbers.matches(changeDelimiterPattern)){
            Pattern pattern = Pattern.compile(changeDelimiterPattern);
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
        StringBuilder builder = new StringBuilder();
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
