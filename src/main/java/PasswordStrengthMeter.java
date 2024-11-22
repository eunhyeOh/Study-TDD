package main.java;

import main.java.PasswordStrength;

public class PasswordStrengthMeter {
    public PasswordStrength meter(String s){

        if(s == null || s.isEmpty()) return PasswordStrength.INVALID;

        int metCounts = GetMetCriteriaCounts(s);

        if (metCounts <= 1) return PasswordStrength.WEAK;
        if (metCounts == 2) return PasswordStrength.NORMAL;

        return PasswordStrength.STRONG;
    }

    //암호 규칙 : 충족 조건의 갯수 구하기
    private int GetMetCriteriaCounts(String s){
        int metCounts = 0;

        if(s.length() >= 8) metCounts++;
        if(meetsContainingNumberCriteria(s)) metCounts++;
        if(meetsContainingUppercaseCriteria(s)) metCounts++;

        return metCounts;
    }
    //숫자가 포함되는지 확인
    private boolean meetsContainingNumberCriteria(String s){
        for(char ch: s.toCharArray()){
            if(ch >= '0' && ch <= '9'){
                return true;
            }
        }
        return false;
    }

    //대문자 포함되는지 확인
    private boolean meetsContainingUppercaseCriteria(String s){
        for(char ch: s.toCharArray()){
            if(Character.isUpperCase(ch)){
                return true;
            }
        }
        return false;
    }
}

