

public class Calculator {

    public int add(String numbers){

        String delimiter = ",|\n";
        int result = 0;
        String[] arrayOfNumbers = numbers.split(delimiter);
        int iterationLength = arrayOfNumbers.length;
        if(numbers.length()<iterationLength){
            iterationLength = numbers.length();
        }

        for(int i=0;i<iterationLength; i++){
            result+= Integer.valueOf(arrayOfNumbers[i]);
        }
        return result;
    }

}
