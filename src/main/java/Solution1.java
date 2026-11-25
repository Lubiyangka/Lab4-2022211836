import java.util.HashMap;
import java.util.Map;

/**
 * Converts a fraction to a decimal string, enclosing a repeating part in parentheses.
 */
public class Solution1 {
    public String fractionToDecimal(int numerator, int denominator) {
        if (denominator == 0) {
            throw new ArithmeticException("denominator must not be zero");
        }

        long numeratorLong = numerator;
        long denominatorLong = denominator;
        if (numeratorLong % denominatorLong == 0) {
            return String.valueOf(numeratorLong / denominatorLong);
        }

        StringBuilder result = new StringBuilder();
        if ((numeratorLong < 0) ^ (denominatorLong < 0)) {
            result.append('-');
        }

        numeratorLong = Math.abs(numeratorLong);
        denominatorLong = Math.abs(denominatorLong);
        result.append(numeratorLong / denominatorLong);
        result.append('.');

        long remainder = numeratorLong % denominatorLong;
        Map<Long, Integer> remainderIndexMap = new HashMap<>();
        while (remainder != 0) {
            Integer repeatIndex = remainderIndexMap.get(remainder);
            if (repeatIndex != null) {
                result.insert(repeatIndex.intValue(), '(');
                result.append(')');
                break;
            }

            remainderIndexMap.put(remainder, result.length());
            remainder *= 10;
            result.append(remainder / denominatorLong);
            remainder %= denominatorLong;
        }

        return result.toString();
    }
}
