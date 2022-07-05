package com.tdd.ch02;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PasswordStrengthMeterTest {

    private PasswordStrengthMeter meter = new PasswordStrengthMeter();

    private void assertStrength(String password, PasswordStrength expStr){
        PasswordStrength result = meter.meter(password);
        assertEquals(expStr, result);
    }

    @Test
    void name(){

    }

    @Test
    @DisplayName("암호 강도 테스트 1 : 모든 규칙 충족")
    void meetAllCriteria_Then_Strong(){

        assertStrength("ab12!@AB", PasswordStrength.STRONG);
        assertStrength("abv1!Add", PasswordStrength.STRONG);
    }

    @Test
    @DisplayName("암호 강도 테스트 2 : 길이가 8글자 미만, 나머지 조건 충족")
    void meetsOtherCriteria_except_for_Length_Then_Normal(){

        assertStrength("ab12!@A", PasswordStrength.NORMAL);
        assertStrength("AB12!c", PasswordStrength.NORMAL);
    }

    @Test
    @DisplayName("암호 강도 테스트 3 : 숫자 포함 X, 나머지 조건 충족")
    void meetsOtherCriteria_except_for_number_Then_Normal(){

        assertStrength("ab!@ABqwer", PasswordStrength.NORMAL);
    }

    @Test
    @DisplayName("암호 강도 테스트 4 : 값이 없는 경우1")
    void nullInput_Then_Invalid(){
        assertStrength(null, PasswordStrength.INVALID);
    }

    @Test
    @DisplayName("암호 강도 테스트 4 : 값이 없는 경우2")
    void emptyInput_Then_Invalid(){
        assertStrength("", PasswordStrength.INVALID);
    }

    @Test
    @DisplayName("암호 강도 테스트 5 : 대문자 포함 X, 나머지 조건 충족")
    void meetsOtherCriteria_except_for_Uppercase_Then_Normal(){
        assertStrength("ab12!@df", PasswordStrength.NORMAL);
    }

    @Test
    @DisplayName("암호 강도 테스트 6 : 길이가 8글자 이상, 나머지 조건 미충족")
    void meetsOnlyLengthCriteria_Then_Weak(){
        assertStrength("abdefghi", PasswordStrength.WEAK);
    }

    @Test
    @DisplayName("암호 강도 테스트 7 : 숫자 포함, 나머지 조건 미충족")
    void meetsOnlyNumCriteria_Then_Weak(){
        assertStrength("12345", PasswordStrength.WEAK);
    }

    @Test
    @DisplayName("암호 강도 테스트 8 : 대문자 포함, 나머지 조건 미충족")
    void meetsOnlyUpperCriteria_Then_Weak(){
        assertStrength("ABZEF", PasswordStrength.WEAK);
    }

    @Test
    @DisplayName("암호 강도 테스트 9 : 모든 규칙 미충족")
    void meetsNoCriteria_Then_Weak(){
        assertStrength("abc", PasswordStrength.WEAK);
    }
}
