import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.*;


public class Exercises2 {

    /*
    Given an array of integers nums and an integer target, return indices of the two numbers
    such that they add up to target.

    You may assume that each input would have exactly one solution, and you may not use the same element twice.
    You can return the answer in any order.
    */

    public int[] twoSum(int[] nums, int target) {
        int arraySize = nums.length;
        int[] expected = new int[2];

        for(int i = 0 ; i < arraySize ; i++){
            for(int j = i+1 ; j < arraySize ; j++){
                if(nums[i] + nums[j] == target){
                    expected[0] = i;
                    expected[1] = j;
                    break;
                }
            }
        }
        return expected;
    }

    /*
    Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

    Symbol       Value
    I             1
    V             5
    X             10
    L             50
    C             100
    D             500
    M             1000

    For example, 2 is written as II in Roman numeral, just two ones added together.
    12 is written as XII, which is simply X + II.
    The number 27 is written as XXVII, which is XX + V + II.

    Roman numerals are usually written largest to smallest from left to right.
    However, the numeral for four is not IIII.
    Instead, the number four is written as IV.
    Because the one is before the five we subtract it making four.
    The same principle applies to the number nine, which is written as IX.
    There are six instances where subtraction is used:

    I can be placed before V (5) and X (10) to make 4 and 9.
    X can be placed before L (50) and C (100) to make 40 and 90.
    C can be placed before D (500) and M (1000) to make 400 and 900.

    Given a roman numeral, convert it to an integer.
    */

    public long romanToInt(String s) {
        long answer = 0;
        for(int i = 0 ; i < s.length() ; ++i){
            if(s.charAt(i) == 'I' || s.charAt(i) == 'X' || s.charAt(i) =='C'){
                if(i < s.length() - 1 && (s.charAt(i+1) == 'V' || s.charAt(i+1) == 'L' || s.charAt(i+1) == 'D' || s.charAt(i+1) == 'X' || s.charAt(i+1) == 'C' || s.charAt(i+1) == 'M')){
                    if(s.charAt(i) == 'I' && s.charAt(i+1) == 'V'){
                        answer += 4;
                        i++;
                    }
                    else if(s.charAt(i) == 'I' && s.charAt(i+1) == 'X'){
                        answer += 9;
                        i++;
                    }
                    else if(s.charAt(i) == 'X' && s.charAt(i+1) == 'L'){
                        answer += 40;
                        i++;
                    }
                    else if(s.charAt(i) == 'X' && s.charAt(i+1) == 'C'){
                        answer += 90;
                        i++;
                    }
                    else if(s.charAt(i) == 'C' && s.charAt(i+1) == 'D'){
                        answer += 400;
                        i++;
                    }
                    else if(s.charAt(i) == 'C' && s.charAt(i+1) == 'M'){
                        answer += 900;
                        i++;
                    }
                }
                else{
                    if(s.charAt(i) == 'I'){
                        answer += 1;
                    }
                    else if(s.charAt(i) == 'X'){
                        answer += 10;
                    }
                    else if(s.charAt(i) == 'C'){
                        System.out.println("Happy");
                        answer += 100;
                    }
                }
            }
            else{
                if(s.charAt(i) == 'V'){
                    answer += 5;
                    continue;
                }
                else if(s.charAt(i) == 'L'){
                    answer += 50;
                    continue;
                }
                else if(s.charAt(i) == 'D'){
                    answer += 500;
                    continue;
                }
                else if(s.charAt(i) == 'M'){
                    answer += 1000;
                    continue;
                }
            }
        }
        return answer;
    }

    /*
    Given an array nums of distinct integers, return all the possible permutations.
    You can return the answer in any order.
    */

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> outer = new ArrayList<>();
        recursivePermute(nums, new ArrayList<>(), outer);
        return outer;
    }

    private void recursivePermute(int[] nums, List<Integer> inner, List<List<Integer>> outer) {
        if (inner.size() == nums.length) {
            outer.add(new ArrayList<>(inner));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (inner.contains(nums[i])) {
                    continue;
                }
                inner.add(nums[i]);
                recursivePermute(nums, inner, outer);
                inner.remove(inner.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arraySize;
        arraySize = in.nextInt();
        int[] nums = new int[arraySize];

        //first ex

        for(int i = 0 ; i < arraySize ; i++){
            nums[i] = in.nextInt();
        }
        int target = in.nextInt();
        Exercises2 obj = new Exercises2();
        int[] expected = obj.twoSum(nums , target);
        for(int i = 0 ; i < 2 ; i++){
            System.out.println(expected[i]);
        }


        String s = in.nextLine();
        System.out.println(obj.romanToInt(s));

        int[] numbers = {1, 2, 3};
        List<List<Integer>> permutations = obj.permute(numbers);





    }
}