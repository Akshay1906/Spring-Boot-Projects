package com.example.Assignment5.Logics;

import org.springframework.stereotype.Component;

@Component
public class ReverseOrderOfWords {


    public String applyLogic(String str) {
        String ans = "";
        int i, j, end;
        end = str.length() - 1;
        for (i = end; i >= 0; i--) {
            if (end == 0)
                break;
            if (str.charAt(i) == ' ') {
                for (j = i + 1; j <= end; j++)
                    ans += ans.valueOf(str.charAt(j));
                ans += ans.valueOf(" ");
                end = i - 1;
            }
            if (i == 0) {
                while (i <= end) {
                    ans += ans.valueOf(str.charAt(i));
                    i++;
                }
                end = 0;
            }

        }
        return ans;
    }
}
