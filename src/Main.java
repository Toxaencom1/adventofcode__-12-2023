import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
--- Day 1: Trebuchet?! ---
Something is wrong with global snow production, and you've been selected to take a look. The Elves have even given you a map; on it, they've used stars to mark the top fifty locations that are likely to be having problems.

You've been doing this long enough to know that to restore snow operations, you need to check all fifty stars by December 25th.

Collect stars by solving puzzles. Two puzzles will be made available on each day in the Advent calendar; the second puzzle is unlocked when you complete the first. Each puzzle grants one star. Good luck!

You try to ask why they can't just use a weather machine ("not powerful enough") and where they're even sending you ("the sky") and why your map looks mostly blank ("you sure ask a lot of questions") and hang on did you just say the sky ("of course, where do you think snow comes from") when you realize that the Elves are already loading you into a trebuchet ("please hold still, we need to strap you in").

As they're making the final adjustments, they discover that their calibration document (your puzzle input) has been amended by a very young Elf who was apparently just excited to show off her art skills. Consequently, the Elves are having trouble reading the values on the document.

The newly-improved calibration document consists of lines of text; each line originally contained a specific calibration value that the Elves now need to recover. On each line, the calibration value can be found by combining the first digit and the last digit (in that order) to form a single two-digit number.

For example:

1abc2
pqr3stu8vwx
a1b2c3d4e5f
treb7uchet
In this example, the calibration values of these four lines are 12, 38, 15, and 77. Adding these together produces 142.

Consider your entire calibration document. What is the sum of all of the calibration values?

Your puzzle answer was 55123.

--- Part Two ---
Your calculation isn't quite right. It looks like some of the digits are actually spelled out with letters: one, two, three, four, five, six, seven, eight, and nine also count as valid "digits".

Equipped with this new information, you now need to find the real first and last digit on each line. For example:

two1nine
eightwothree
abcone2threexyz
xtwone3four
4nineeightseven2
zoneight234
7pqrstsixteen
In this example, the calibration values are 29, 83, 13, 24, 42, 14, and 76. Adding these together produces 281.

What is the sum of all of the calibration values?

Your puzzle answer was 55260.

Both parts of this puzzle are complete! They provide two gold stars: **
 */

public class Main {
    public static void main(String[] args) {
        int sum = 0;
        String s = A1.s2;
        List<String> s1 = new ArrayList<>(List.of(s.split("\n")));

        for (String str : s1) {
            StringBuilder sb = new StringBuilder();
            Pattern pattern1 = Pattern.compile(
                    "one|two|three|four|five|six|seven|eight|nine|\\d");
            Pattern pattern2 = Pattern.compile(
                    "one(ight)?|two(ne)?|three|four|five|six|seven(ine)?|eight(wo)?|nine|\\d");
            Matcher matcher1 = pattern1.matcher(str);
            Matcher matcher2 = pattern2.matcher(str);
            String lastMatch = null;
            if (matcher1.find()) {
                sb.append(matcher1.group());
            }
            while (matcher2.find()) {
                lastMatch = matcher2.group();
            }
            sb.append(lastMatch);
            System.out.print(str + " ");
            str = sb.toString()
                    .replace("one", "1")
                    .replace("1ight", "8")
                    .replace("eightwo", "2")
                    .replace("two", "2")
                    .replace("tw1", "1")
                    .replace("three", "3")
                    .replace("four", "4")
                    .replace("five", "5")
                    .replace("six", "6")
                    .replace("seven", "7")
                    .replace("7ine", "9")
                    .replace("eight", "8")
                    .replace("nine", "9");

            int num = Integer.parseInt(str);
            System.out.print(num + " | sum is: "+sum+" + "+num+" = ");
            sum += num;
            System.out.println(sum);
        }
        System.out.println("\nResult is: " + sum);
    }
}
