package com.kirillpolyakov.util;

import org.w3c.dom.Node;

import java.util.*;
import java.util.stream.Collectors;

public class Util {

    /**
     * Вам даны два целочисленных массива nums1 и nums2, отсортированные в порядке неубывания,
     * и два целых числа m и n, представляющие количество элементов в nums1 и nums2 соответственно.
     * <p>
     * Объедините nums1 и nums2 в один массив, отсортированный в неубывающем порядке.
     * <p>
     * Окончательно отсортированный массив не должен возвращаться функцией, а должен храниться
     * внутри массива nums1. Чтобы учесть это, nums1 имеет длину m + n, где первые m элементов
     * обозначают элементы, которые следует объединить, а последние n элементов имеют значение
     * 0 и их следует игнорировать. nums2 имеет длину n.
     * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
     * Output: [1,2,2,3,5,6]
     */

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

    /**
     * Учитывая целочисленный массив nums и целочисленное значение, удалите все вхождения val
     * в nums на месте. Порядок элементов может быть изменен. Затем верните количество элементов в виде чисел, которые не равны val.
     * <p>
     * Учитывайте количество элементов в nums, которые не равны val be k. Чтобы вас приняли,
     * вам необходимо сделать следующее:
     * <p>
     * Измените массив nums так, чтобы первые k элементов nums содержали элементы, не равные
     * val. Остальные элементы nums не важны, как и размер nums.
     * Вернуть К.
     * Input: nums = [3,2,2,3], val = 3
     * Output: 2, nums = [2,2,_,_]
     */
    public static int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k++] = nums[i];
            }
        }
        return k;
    }

    /**
     * Учитывая целочисленный массив чисел, отсортированный в неубывающем порядке,
     * удалите дубликаты на месте так, чтобы каждый уникальный элемент появлялся
     * только один раз. Относительный порядок элементов должен оставаться неизменным.
     * Затем верните количество уникальных элементов в числах.
     * Считайте, что количество уникальных элементов чисел равно k. Чтобы вас приняли, вам нужно сделать следующее:
     * Измените массив nums так, чтобы первые k элементов nums содержали уникальные элементы
     * в том порядке, в котором они присутствовали в nums изначально. Остальные элементы nums не важны, как и размер nums.
     * Вернуть К.
     * <p>
     * Input: nums = [0,0,1,1,1,2,2,3,3,4]
     * Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
     * Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
     * It does not matter what you leave beyond the returned k (hence they are underscores).
     */
    public static int removeDuplicates(int[] nums) {
        int k = 1;
        int num = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != num) {
                nums[k++] = nums[i];
                num = nums[i];
            }

        }
        return k;
    }

    /**
     * Учитывая массив nums размера n, верните элемент большинства.
     * <p>
     * Мажоритарным элементом является элемент, который появляется более ⌊n / 2⌋ раз.
     * Вы можете предположить, что элемент большинства всегда существует в массиве.
     * Input: nums = [3,2,3]
     * Output: 3
     * Input: nums = [1,1,1,2,2,2,2]
     * Output: 2
     */

    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int count = 1;
        int maxCount = 0;
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
                if (count > maxCount) {
                    maxCount = count;
                    max = nums[i];
                }
                continue;
            }
            if (count > maxCount) {
                maxCount = count;
            }
            count = 1;
        }
        return max;
    }

    /**
     * Вам дан массив цен, где цены[i] — цена данной акции на i-й день.
     * <p>
     * Вы хотите максимизировать свою прибыль, выбрав один день для
     * покупки одной акции и выбрав другой день в будущем для продажи этой акции.
     * <p>
     * Верните максимальную прибыль, которую вы можете получить от
     * этой сделки. Если вы не можете получить прибыль, верните 0.
     * Input: prices = [7,1,5,3,6,4]
     * Output: 5
     * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
     * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
     * <p>
     * Input: prices = [7,6,4,3,1]
     * Output: 0
     * Explanation: In this case, no transactions are done and the max profit = 0.
     */

    public int maxProfit(int[] prices) {
        int profit;
        int max = 0;
        int smallest = Integer.MAX_VALUE;
        for (int price : prices) {
            if (price < smallest) {
                smallest = price;
            }
            profit = price - smallest;
            if (profit > max) {
                max = profit;
            }
        }
        return max;
    }

    /**
     * Римские цифры представлены семью различными символами: I, V, X, L, C, D и M.
     * Значение символа
     * я 1
     * В 5
     * х 10
     * л 50
     * С 100
     * Д 500
     * М 1000
     * Например, 2 записывается как II римскими цифрами, состоящими из двух единиц.
     * 12 записывается как XII, то есть просто X + II. Число 27 записывается как XXVII, то есть XX+V+II.
     * Римские цифры обычно пишутся от большей к меньшей слева направо. Однако цифра четыре не IIII.
     * Вместо этого цифра четыре пишется как IV. Поскольку единица стоит перед пятеркой, мы вычитаем
     * ее, получая четыре. Тот же принцип применим и к числу девять, которое пишется как IX.
     * Есть шесть случаев, когда используется вычитание:
     * I можно поставить перед V (5) и X (10), чтобы получилось 4 и 9.
     * X можно поставить перед L (50) и C (100), чтобы получилось 40 и 90.
     * C можно поставить перед D (500) и M (1000), чтобы получилось 400 и 900.
     * Дана римская цифра, преобразуйте ее в целое число.
     * Example 1:
     * Input: s = "III"
     * Output: 3
     * Explanation: III = 3.
     * Example 2:
     * Input: s = "LVIII"
     * Output: 58
     * Explanation: L = 50, V= 5, III = 3.
     * Example 3:
     * Input: s = "MCMXCIV"
     * Output: 1994
     * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
     */
    public static int romanToInt(String s) {
        int sum = 0;
        char ch = 'Q';
        for (int i = s.length() - 1; i >= 0; i--) {
            if (i != s.length() - 1 ) {
                ch = s.charAt(i + 1);
            }
            switch (s.charAt(i)) {
                case 'I' -> {
                    if (ch == 'V' || ch == 'X') {
                        sum -= 1;
                        continue;
                    }
                    sum += 1;
                }
                case 'V' -> sum += 5;
                case 'X' -> {
                    if (ch == 'L' || ch == 'C') {
                        sum -= 10;
                        continue;
                    }
                    sum += 10;
                }
                case 'L' -> sum += 50;
                case 'C' -> {
                    if (ch == 'D' || ch == 'M') {
                        sum -= 100;
                        continue;
                    }
                    sum += 100;
                }
                case 'D' -> sum += 500;
                case 'M' -> sum += 1000;
            }
        }
        return sum;
    }

    /**
     * Дана строка s, состоящая из слов и пробелов, верните длину последнего слова в строке.
     * <p>
     * Слово – это максимум
     * подстрока
     * состоящий только из символов, не являющихся пробелами.
     * "   fly me   to   the moon"
     */

    public static int lengthOfLastWord(String s) {
        s = s.strip();
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                return count;
            }
            count++;
        }
        return count;
    }

    /**
     * Напишите функцию для поиска самой длинной строки общего префикса среди массива строк.
     * <p>
     * Если общего префикса нет, верните пустую строку ""
     * Input: strs = ["flower","flow","flight"]
     * Output: "fl"
     */

    public static String longestCommonPrefix(String[] strs) {
        StringBuilder res = new StringBuilder();
        int count = 0;
        try {
            for (int i = 0; i < strs[0].length(); i++) {
                char ch = strs[0].charAt(i);
                for (String str : strs) {
                    if (str.charAt(i) == ch) {
                        count++;
                    }
                }
                if (count == strs.length) {
                    res.append(ch);
                    count = 0;
                    continue;
                }
                return res.toString();
            }
        } catch (IndexOutOfBoundsException e) {
            return res.toString();
        }
        return res.toString();
    }


















    /*public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        int min = Arrays.stream(strs).mapToInt(String::length).min().orElse(0);
        int j = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (j < min) {
            char ch = strs[0].charAt(j);
            for (String str : strs) {
                if (str.charAt(j) != ch) {
                    return stringBuilder.toString();
                }
            }
            j++;
            stringBuilder.append(ch);
        }
        return stringBuilder.toString();
    }*/



    /**
     * Вам даны две строки word1 и word2. Объедините строки,
     * добавляя буквы в чередующемся порядке, начиная со слова1.
     * Если строка длиннее другой, добавьте дополнительные буквы
     * в конец объединенной строки.
     * <p>
     * Верните объединенную строку.
     */
    /*public static String mergeAlternately(String word1, String word2) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        int j = 0;
        while (i < word1.length() || j < word2.length()) {
            if (i <= word1.length() - 1) {
                stringBuilder.append(word1.charAt(i));

            }
            if (j <= word2.length() - 1) {
                stringBuilder.append(word2.charAt(j));

            }
            i++;
            j++;
        }
        return stringBuilder.toString();
    }*/

    /**
     * Есть n детей с конфетами. Вам дан целочисленный массив candies,
     * где каждая конфета[i] представляет количество конфет, которые
     * есть у i-го ребенка, и целое число extraCandies, обозначающее
     * количество дополнительных конфет, которые у вас есть.
     * <p>
     * Возвращает логический массив result длины n, где result[i]
     * имеет значение true, если после предоставления i-му ребенку
     * всех дополнительных конфет у него будет наибольшее количество
     * конфет среди всех детей, или false в противном случае.
     * <p>
     * Обратите внимание, что несколько детей могут получить
     * наибольшее количество конфет.
     */
    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = Arrays.stream(candies).max().orElse(0) + extraCandies;
        List<Boolean> res = new ArrayList<>();
        for (int count : candies) {
            if (count + extraCandies == max) {
                res.add(true);
                continue;
            }
            res.add(false);
        }
        return res;
    }


    /**
     * У вас есть длинная клумба, на которой часть участков засажена, а часть нет.
     * Однако цветы нельзя сажать на соседних участках.
     * <p>
     * Учитывая целочисленный массив клумбы, содержащий 0 и 1, где 0 означает пусто,
     * а 1 означает не пусто, и целое число n, верните true, если на клумбе можно
     * посадить n новых цветов, не нарушая правило отсутствия соседних цветов,
     * и false в противном случае.
     */
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                if (i == 0) {
                    if (flowerbed.length == 1) {
                        count++;
                    } else {
                        if (flowerbed[i + 1] == 0) {
                            count++;
                            flowerbed[i] = 1;
                        }
                    }

                } else if (i == flowerbed.length - 1) {
                    if (flowerbed[i - 1] == 0) {
                        count++;
                        flowerbed[i] = 1;
                    }
                } else if (flowerbed[i + 1] == 0 && flowerbed[i - 1] == 0) {
                    count++;
                    flowerbed[i] = 1;
                }
            }
        }
        return count >= n;
    }

    /**
     * Учитывая строку s, поменяйте местами только все гласные в строке и верните ее.
     * Гласные: «a», «e», «i», «o» и «u», и они могут встречаться как в нижнем, так и в верхнем регистре более одного раза.
     */
    /**
     * s = "hello"
     * s = "leetcode" leotcede
     */
    public static String reverseVowels(String s) {
        Set<Character> vowels = new HashSet<>(List.of('a', 'e', 'i', 'o', 'u'));
        char[] chars = s.toCharArray();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (vowels.contains(Character.toLowerCase(chars[i]))) {
                count++;
            }
        }
        int[] indexes = new int[count];
        for (int i = 0, j = 0; i < chars.length; i++) {
            if (vowels.contains(Character.toLowerCase(chars[i]))) {
                indexes[j++] = i;
            }
        }
        //leetcode
        for (int i = 0; i < indexes.length / 2; i++) {
            char temp = chars[indexes[i]];
            chars[indexes[i]] = chars[indexes[indexes.length - 1 - i]];
            chars[indexes[indexes.length - 1 - i]] = temp;
        }
        return new String(chars);
    }

    /**
     * Учитывая входную строку s, измените порядок слов на обратный.
     * <p>
     * Слово определяется как последовательность символов, не являющихся
     * пробелами. Слова в s будут разделены хотя бы одним пробелом.
     * <p>
     * Возвращает строку слов в обратном порядке, объединенную одним пробелом.
     * <p>
     * Обратите внимание, что s может содержать начальные или конечные пробелы
     * или несколько пробелов между двумя словами. Возвращаемая строка должна
     * содержать только один пробел, разделяющий слова. Не включайте лишних пробелов.
     * <p>
     * Input: s = "the sky is blue"
     * Output: "blue is sky the"
     */
    public static String reverseWords(String s) {
        String[] split = s.split("\\s*(\\s)\\s*");
        System.out.println(Arrays.toString(split));
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = split.length - 1; i >= 0; i--) {
            stringBuilder.append(split[i].strip()).append(" ");
        }
        return stringBuilder.toString().strip();
    }

    /**
     * Учитывая целочисленный массив nums, верните ответ массива, такой,
     * что ответ[i] равен произведению всех элементов nums, кроме nums[i].
     * <p>
     * Произведение любого префикса или суффикса чисел гарантированно
     * вписывается в 32-битное целое число.
     * <p>
     * Вы должны написать алгоритм, который работает за время O(n)
     * и не использует операцию деления.
     * Input: nums = [1,2,3,4]
     * Output: [24,12,8,6]
     */
    public static int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int multi = 1;
        for (int num : nums) {
            multi *= num;
        }
        for (int i = 0; i < nums.length; i++) {
            res[i] = multi * nums.length;
        }

        return res;
    }

    /**
     * Учитывая целочисленный массив nums, верните true,
     * если существует тройка индексов (i, j, k) такая,
     * что i < j < k и nums[i] < nums[j] < nums[k].
     * Если таких индексов не существует, верните false.
     * nums = [1,2,3,4,5]
     * [2,1,5,0,4,6]
     * 0 4
     */
    public static boolean increasingTriplet(int[] nums) {
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num < a) {
                a = num;
            } else if (num < b) {
                b = num;
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * Учитывая целочисленный массив nums, переместите все 0 в его конец,
     * сохраняя относительный порядок ненулевых элементов.
     * Input: nums = [0,1,0,3,12]
     */
    public static void moveZeroes(int[] nums) {
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == 0) {
                for (int j = i; j < nums.length - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                nums[nums.length - 1] = 0;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    /**
     * Учитывая две строки s и t, верните true, если s является
     * подпоследовательностью t, или false в противном случае.
     * <p>
     * Подпоследовательность строки — это новая строка, которая
     * формируется из исходной строки путем удаления некоторых
     * (может быть и ни одного) символов без нарушения относительного
     * положения остальных символов. (т. е. «ace» является подпоследовательностью
     * «abcde», а «aec» — нет).
     * ""leeeeetcode""
     * ""leeeeeetcode""
     */
    public static boolean isSubsequence(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        if (sLen > tLen) {
            return false;
        }
        int i = 0;
        int j = 0;
        int total = 0;
        while (i < sLen && j < tLen) {
            if (s.charAt(i) == t.charAt(j)) {
                total++;
                i++;
                j++;
            } else j++;
        }
        return total == sLen;
    }

    /**
     * Вам дан целочисленный массив nums, состоящий из n элементов, и целое число k.
     * <p>
     * Найдите непрерывный подмассив длиной k, имеющий максимальное среднее значение,
     * и верните это значение. Принимается любой ответ с ошибкой расчета менее 10-5.
     * Input: nums = [1,12,-5,-6,50,3], k = 4
     * Output: 12.75000
     * Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
     */

    public static double findMaxAverage(int[] nums, int k) {
        double[] mass = new double[nums.length - k + 1];
        for (int i = 0; i <= nums.length - k; i++) {
            double sum = 0;
            for (int j = i; j < k + i; j++) {
                sum += nums[j];
            }
            mass[i] = sum / k;
        }
        return Arrays.stream(mass).max().orElse(0);
    }

    /**
     * Учитывая массив целых чисел nums и целочисленную цель,
     * верните индексы двух чисел так, чтобы их сумма составляла цель.
     * <p>
     * Вы можете предположить, что каждый вход будет иметь ровно одно решение,
     * и вы не можете использовать один и тот же элемент дважды.
     * <p>
     * Вы можете вернуть ответ в любом порядке.
     * Input: nums = [2,7,11,15], target = 9
     * Output: [0,1]
     */
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{nums[i], nums[j]};
                }
            }
        }
        return new int[]{};
    }


    /**
     * Учитывая отсортированный массив различных целых чисел и целевое значение,
     * верните индекс, если цель найдена. Если нет, верните индекс там, где он был бы,
     * если бы он был вставлен по порядку.
     * <p>
     * Вы должны написать алгоритм со сложностью выполнения O(log n).
     */
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    /**
     * Учитывая целое число x, верните true, если x является
     * палиндром
     * и false в противном случае.
     */
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            if (chars[i] != chars[chars.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }


    /**
     * Учитывая числа целочисленного массива, отсортированные в неубывающем порядке,
     * удалите несколько дубликатов на месте так, чтобы каждый уникальный элемент появлялся
     * не более двух раз. Относительный порядок элементов должен оставаться неизменным.
     * <p>
     * Поскольку в некоторых языках изменить длину массива невозможно, вместо этого
     * необходимо поместить результат в первую часть массива nums. Более формально,
     * если после удаления дубликатов осталось k элементов, то первые k элементов nums
     * должны содержать окончательный результат. Не имеет значения, что вы оставите после первых k элементов.
     * <p>
     * Возвращает k после размещения окончательного результата в первых k слотах чисел.
     * <p>
     * Не выделяйте дополнительное пространство для другого массива. Вы должны сделать это,
     * изменив входной массив на месте с дополнительной памятью O (1).
     * Input: nums = [1,1,1,2,2,3]
     * Output: 5, nums = [1,1,2,2,3,_]
     */
    public static int removeDuplicates2(int[] mass) {
        int k = 0;
        Set<Integer> nums1 = new HashSet<>();
        Set<Integer> nums2 = new HashSet<>();
        for (int i = 0; i < mass.length; i++) {
            if (!nums1.contains(mass[i])) {
                nums1.add(mass[i]);
                mass[k++] = mass[i];
                continue;
            }
            if (!nums2.contains(mass[i])) {
                nums2.add(mass[i]);
                mass[k++] = mass[i];
            }
        }
        return k;
    }

    /**
     * Учитывая целочисленный массив nums, поверните массив вправо на k шагов, где k неотрицательно.
     * Input: nums = [1,2,3,4,5,6,7], k = 3
     * Output: [5,6,7,1,2,3,4]
     * <p>
     * [1,2]   k = 3
     * 2, 1
     */
    public static void rotate(int[] nums, int k) {
        int[] buffer;
        if (k < nums.length) {
            buffer = new int[nums.length - k];
            System.arraycopy(nums, 0, buffer, 0, nums.length - k);
            System.arraycopy(nums, nums.length - k, nums, 0, k);
            System.arraycopy(buffer, 0, nums, k, nums.length - k);
        } else {
            buffer = new int[nums.length - (k % nums.length)];
            System.arraycopy(nums, 0, buffer, 0, nums.length - k % nums.length);
            System.out.println(Arrays.toString(buffer));
            System.arraycopy(nums, nums.length - k % nums.length, nums, 0, k % nums.length);
            System.arraycopy(buffer, 0, nums, k % nums.length, nums.length - k % nums.length);
        }
        System.out.println(Arrays.toString(nums));
    }






    /**
     * Учитывая две строки, игла и стог сена, верните индекс первого вхождения
     * иглы в стоге сена или -1, если игла не является частью стога сена.
     * Input: haystack = "sadbutsad", needle = "sad"
     * Output: 0
     * Explanation: "sad" occurs at index 0 and 6.
     * The first occurrence is at index 0, so we return 0.
     */
    public static int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()) {
            return -1;
        }
        if (needle.length() == 1 && haystack.length() == 1) {
            if (needle.charAt(0) == haystack.charAt(0)) {
                return 0;
            }
            return -1;
        }
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                if (needle.length() == 1) {
                    return i;
                } else {
                    if (haystack.length() - i >= needle.length()) {
                        int count = 1;
                        for (int j = 1; j < needle.length(); j++) {
                            if (haystack.charAt(j + i) == needle.charAt(j)) {
                                count++;
                                if (count == needle.length()) {
                                    return i;
                                }
                            } else {
                                break;
                            }
                        }
                    }
                }
            }
        }
        return -1;
    }

    /**
     * Фраза является палиндромом, если после преобразования всех заглавных
     * букв в строчные и удаления всех небуквенно-цифровых символов она читается
     * одинаково и вперед, и назад. Буквенно-цифровые символы включают буквы и цифры.
     * <p>
     * Учитывая строку s, верните true, если это палиндром, или false в противном случае.
     * Input: s = "A man, a plan, a canal: Panama"
     * Output: true
     * Explanation: "amanaplanacanalpanama" is a palindrome.
     */
    public static boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        StringBuilder stringBuilder = new StringBuilder(s).reverse();
        return s.equals(stringBuilder.toString());
    }

    /**
     * Учитывая две строки ransomNote и Magazine, верните true, если
     * ransomNote можно создать с использованием букв из журнала, и false в противном случае.
     * <p>
     * Каждое письмо в журнале можно использовать в заметке о выкупе только один раз.
     * Input: ransomNote = "aa", magazine = "aab"
     * Output: true
     */
    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<String, Long> ransomMap = Arrays.stream(ransomNote.split(""))
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()));
        Map<String, Long> magazineMap = Arrays.stream(magazine.split(""))
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()));
        for (String s : ransomMap.keySet()) {
            if (!magazineMap.containsKey(s) || magazineMap.get(s) < ransomMap.get(s)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Даны две строки s и t. Определите, изоморфны ли они.
     * <p>
     * Две строки s и t изоморфны, если символы в s можно заменить, чтобы получить t.
     * <p>
     * Все вхождения символа должны быть заменены другим символом с сохранением порядка символов.
     * Никакие два символа не могут сопоставляться одному и тому же символу, но символ может сопоставляться сам с собой.
     * Input: s = "egg", t = "add"
     * Output: true
     * Input: s = "foo", t = "bar"
     * Output: false
     * <p>
     * "badc"
     * "baba"
     */
    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                if (map.values().contains(t.charAt(i))) {
                    return false;
                }
                map.put(s.charAt(i), t.charAt(i));
                continue;
            }
            if (map.get(s.charAt(i)) != t.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Учитывая шаблон и строку s, определите, соответствует ли s тому же шаблону.
     * <p>
     * Здесь следовать означает полное совпадение, такое, что
     * существует биекция между буквой в образце и непустым словом в s.
     * Input: pattern = "abba", s = "dog cat cat dog"
     * Output: true
     */
    public static boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        String[] split = s.split(" ");
        if (pattern.length() != split.length) {
            return false;
        }
        for (int i = 0; i < pattern.length(); i++) {
            if (!map.containsKey(pattern.charAt(i))) {
                if (map.values().contains(split[i])) {
                    return false;
                }
                map.put(pattern.charAt(i), split[i]);
                continue;
            }
            if (!map.get(pattern.charAt(i)).equals(split[i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * Учитывая две строки s и t, верните true, если
     * t является анаграммой s, и false в противном случае.
     * <p>
     * Анаграмма — это слово или фраза, образованная путем перестановки букв
     * другого слова или фразы, обычно с использованием всех исходных букв ровно один раз.
     */
    public boolean isAnagram(String s, String t) {
        char[] chars1 = s.toCharArray();
        Arrays.sort(chars1);
        char[] chars2 = t.toCharArray();
        Arrays.sort(chars2);
        return Arrays.equals(chars1, chars2);
    }

    /**
     * Напишите алгоритм, определяющий, является ли число n счастливым.
     * Счастливое число — это число, определяемое следующим процессом:
     * Начиная с любого положительного целого числа, замените число суммой квадратов его цифр.
     * Повторяйте процесс до тех пор, пока число не станет равным 1 (где оно и останется),
     * или пока он не будет повторяться бесконечно в цикле, который не включает 1.
     * Счастливыми являются те числа, для которых этот процесс заканчивается на 1.
     * Возвращайте true, если n — счастливое число, и false, если нет.
     * Example 1:
     * <p>
     * Input: n = 19
     * Output: true
     * Explanation:
     * 12 + 92 = 82
     * 82 + 22 = 68
     * 62 + 82 = 100
     * 12 + 02 + 02 = 1
     */
    public static boolean isHappy(int n) {
        int limit = 1000;
        while (n != 1 || limit != 0) {
            int sum = 0;
            while (n != 0) {
                sum += Math.pow(n % 10, 2);
                n /= 10;
            }
            n = sum;
            limit--;
        }
        return true;
    }

    /**
     * Учитывая целочисленный массив nums и целое число k, верните true, если в массиве
     * есть два различных индекса i и j, такие что nums[i] == nums[j] и abs(i - j) <= k.
     * Example 2:
     * <p>
     * Input: nums = [1,0,1,1], k = 1
     * Output: true
     * Example 3:
     * <p>
     * Input: nums = [1,2,3,1,2,3], k = 2
     * Output: false
     */
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, List<Integer>> intIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> indexes = intIndex.getOrDefault(nums[i], new ArrayList<>());
            if (!indexes.isEmpty()) {
                for (Integer index : indexes) {
                    if (Math.abs(i - index) <= k) {
                        return true;
                    }
                }
            }
            indexes.add(i);
            intIndex.put(nums[i], indexes);
        }
        return false;
    }

    /**
     * Вам дан отсортированный уникальный целочисленный массив чисел.
     * <p>
     * Диапазон [a,b] — это набор всех целых чисел от a до b (включительно).
     * <p>
     * Возвращает наименьший отсортированный список диапазонов, который точно
     * охватывает все числа в массиве. То есть каждый элемент nums охватывается
     * ровно одним из диапазонов, и не существует целого числа x такого, что x
     * находится в одном из диапазонов, но не в nums.
     * Input: nums = [0,2,3,7,8,10]
     * Output: ["0","2->4","6","8->9"]
     * Explanation: The ranges are:
     * [0,0] --> "0"
     * [2,4] --> "2->4"
     * [6,6] --> "6"
     * [8,9] --> "8->9"
     */
    public static List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }
        if (nums.length == 1) {
            res.add(String.valueOf(nums[0]));
            return res;
        }
        int index = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] + 1 != nums[i]) {
                if (index == nums[i - 1]) {
                    res.add(String.valueOf(index));
                } else {
                    res.add(index + "->" + nums[i - 1]);
                }
                index = nums[i];
            }
            if (i == nums.length - 1) {
                if (index == nums[i]) {
                    res.add(String.valueOf(index));
                    continue;
                }
                res.add(index + "->" + nums[i]);
            }
        }
        return res;
    }

    /**
     * Учитывая строку s, содержащую только символы '(', ')', '{', '}', '[' и ']',
     * определите, является ли входная строка допустимой.
     * <p>
     * Входная строка действительна, если:
     * <p>
     * Открытые скобки должны закрываться скобками того же типа.
     * Открытые скобки должны закрываться в правильном порядке.
     * Каждой закрывающей скобке соответствует открытая скобка того же типа.
     */
    public static boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            if (map.containsKey(ch) && stack.isEmpty()) {
                return false;
            }
            if (map.containsValue(ch)) {
                stack.push(ch);
            }
            if (map.containsKey(ch) && stack.pop() != map.get(ch)) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    /**
     * Учитывая заголовок, заголовок связанного списка, определите, есть ли в связанном списке цикл.
     * <p>
     * В связанном списке существует цикл, если в списке есть некоторый узел, к
     * которому можно снова добраться, непрерывно следуя по следующему указателю.
     * Внутри pos используется для обозначения индекса узла, к которому подключен
     * следующий указатель хвоста. Обратите внимание, что pos не передается в качестве параметра.
     * <p>
     * Возвращайте true, если в связанном списке есть цикл. В противном случае верните false.
     */


    /*class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }*/
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (true) {
            slow = slow.next;
            fast = fast.next;
            if (fast == null) {
                return false;
            }
            fast = fast.next;
            if (fast == slow) {
                return true;
            }
        }
    }


    /**
     * Вам даны заголовки двух отсортированных связанных списков list1 и list2.
     * <p>
     * Объедините два списка в один отсортированный список. Список должен быть составлен путем сращивания узлов первых двух списков.
     * <p>
     * Возвращает заголовок объединенного связанного списка.
     * Input: list1 = [1,2,4], list2 = [1,3,4]
     * Output: [1,1,2,3,4,4]
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }
        ListNode i = list1;
        ListNode j = list2;
        ListNode res = new ListNode();
        ListNode head = res;
        while (i != null || j != null) {
            if (i == null) {
                res.val = j.val;
                j = j.next;
                if (j != null) {
                    res.next = new ListNode();
                    res = res.next;
                }
                continue;
            }
            if (j == null) {
                res.val = i.val;
                i = i.next;
                if (i != null) {
                    res.next = new ListNode();
                    res = res.next;
                }
                continue;
            }
            if (i.val <= j.val) {
                res.val = i.val;
                i = i.next;
            } else {
                res.val = j.val;
                j = j.next;
            }
            res.next = new ListNode();
            res = res.next;
        }
        return head;
    }

    /**
     * Учитывая корень двоичного дерева, верните его максимальную глубину.
     * Максимальная глубина двоичного дерева — это количество узлов
     * на самом длинном пути от корневого узла до самого дальнего листового узла.
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}