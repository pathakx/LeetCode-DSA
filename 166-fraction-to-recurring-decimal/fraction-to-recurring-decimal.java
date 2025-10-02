class Solution {
    public String fractionToDecimal(int numerator, int denominator) {

         if (numerator == 0) {
            return "0";
        }
        StringBuilder result = new StringBuilder();
         if ((numerator < 0) ^ (denominator < 0)) {
            result.append("-");
        }
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);
        result.append(num / den);
        long remainder = num % den;
        if (remainder == 0) {
            return result.toString();
        }

        result.append(".");

        HashMap<Long, Integer> remainderPositions = new HashMap<>();
        while (remainder != 0 && !remainderPositions.containsKey(remainder)) {
            remainderPositions.put(remainder, result.length()); 

            remainder *= 10; 
            result.append(remainder / den); // Append the next digit
            remainder %= den; // Update remainder
        }
        if (remainder == 0) {
            return result.toString();
        } else {
            // Recurring decimal detected
            int insertPos = remainderPositions.get(remainder);
            result.insert(insertPos, "(");
            result.append(")");
            return result.toString();
        }
    }   
}