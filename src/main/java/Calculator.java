

public class Calculator {

    public int add(String numbers){

        String delimiter = ",";
        int result = 0;
        String[] arrayOfNumbers = numbers.split(delimiter);
        int maxNumbers = 2;
        int iterationLength = arrayOfNumbers.length;
        if(numbers.length()<iterationLength){
            iterationLength = numbers.length();
        }
        else if(iterationLength > maxNumbers){
            iterationLength = maxNumbers;
        }

        for(int i=0;i<iterationLength; i++){
            result+= Integer.valueOf(arrayOfNumbers[i]);
        }
        return result;
    }

}
