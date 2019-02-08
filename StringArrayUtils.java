 import java.util.Arrays;

/**
 * Created by leon on 1/29/18.
 */
public class StringArrayUtils {
    /**
     * @param array array of String objects
     * @return first element of specified array
     */ // TODO
    public static String getFirstElement(String[] array) {
        return array[0];
    }

    /**
     * @param array array of String objects
     * @return second element in specified array
     */
    public static String getSecondElement(String[] array) {
        return array[1];
    }

    /**
     * @param array array of String objects
     * @return last element in specified array
     */ // TODO
    public static String getLastElement(String[] array) {
        return array[array.length - 1];
    }

    /**
     * @param array array of String objects
     * @return second to last element in specified array
     */ // TODO
    public static String getSecondToLastElement(String[] array) {
        return array[array.length - 2];
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return true if the array contains the specified `value`
     */ // TODO
    public static boolean contains(String[] array, String value) {
        boolean answer = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {answer = true;}
        }
        return answer;
    }

    /**
     * @param array of String objects
     * @return an array with identical contents in reverse order
     */ // TODO
    public static String[] reverse(String[] array) {
        String[] answer = new String[array.length];
        for (int i = 0; i < array.length; i++) {
            answer[i] = array[array.length - 1 - i];
        }
        return answer;
    }

    /**
     * @param array array of String objects
     * @return true if the order of the array is the same backwards and forwards
     */ // TODO
    public static boolean isPalindromic(String[] array) {
        return Arrays.equals(array, reverse(array));
    }

    /**
     * @param array array of String objects
     * @return true if each letter in the alphabet has been used in the array
     */ // TODO
    public static boolean isPangramic(String[] array) {
        boolean pangramic = true;
        //iterates to check all characters
        for (char i = 'a'; i <= 'z'; i++) {
            boolean charCheck = false;
            // Checks each string in array
            for (int j = 0; j < array.length; j++){
                for(int k = 0; k < array[j].length(); k++) {
                    if (array[j].charAt(k) == i || array[j].charAt(k) == (i - 32)) {
                        charCheck = true;
                        break;
                    }
                }
                //breaks to next charCheck
                if (charCheck == true) break;
            }
            // break to false if done checking strings for char i
            if (charCheck == false) {
                pangramic = false;
                break;
            }
        }
        return pangramic;
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return number of occurrences the specified `value` has occurred
     */ // TODO
    public static int getNumberOfOccurrences(String[] array, String value) {
        int counter = 0;
        for (int i = 0; i < array.length; i++){
            if (array[i] == value) counter++;
        }
        return counter;
    }

    /**
     * @param array         array of String objects
     * @param valueToRemove value to remove from array
     * @return array with identical contents excluding values of `value`
     */ // TODO
    public static String[] removeValue(String[] array, String valueToRemove) {
        String[] answer = new String[array.length - getNumberOfOccurrences(array, valueToRemove)];
        int j = 0;
        for (int i = 0; i < array.length; i++){
            if (!valueToRemove.equals(array[i])) {
                answer[j++] = array[i];
            }
        }
        return answer;
    }
    
    /**
     * @param array array of strings
     * @return int equal to number of duplicate instances
     */
    public static int numberOfDuplicates(String[] array) {
        int dup = 0;
        for (int i = 1; i < array.length; i++){
            if (array[i] == array[i-1]) dup++;
        }
        return dup;
    }

    /**
     * @param array array of chars
     * @return array of Strings with consecutive duplicates removes
     */ // TODO
    public static String[] removeConsecutiveDuplicates(String[] array) {
        String[] answer = new String[array.length - numberOfDuplicates(array)];
        int j = 1;
        answer[0] = array[0];
        for (int i = 1; i < array.length; i++){
            if (array[i] != array[i-1]) {
                answer[j++] = array[i];
            }
        }
        return answer;
    }

    /**
     * @param array array of chars
     * @return int of number of non consecutive characters
     */ 
    public static int packConsecutiveDuplicatesSize(String[] array) {
        int size = 1;
        for (int i = 0; i < array.length - 1; i++){
            if (array[i] != array[i+1]) size++;
        }
        return size;
    }
    
    /**
     * @param array array of chars
     * @return array of Strings with each consecutive duplicate occurrence concatenated as a single string in an array of Strings
     */ // TODO
    public static String[] packConsecutiveDuplicates(String[] array) {
        // introduce final return string
        String[] answer = new String[packConsecutiveDuplicatesSize(array)];
        // interating through array
        String temp = array[0];
        int j = 0;
        for (int i = 1; i < array.length; i++){
            if (array[i] == array[i-1]){
                temp = temp + array[i];
            }
            else {
                answer[j++] = temp;
                temp = array[i];
            }
        }
        answer[answer.length - 1] = temp;
        
        //return answer
        return answer;
    }


}
