package test.java.chap02;
import main.java.PasswordStrength;
import main.java.PasswordStrengthMeter;
import org.junit.jupiter.api.Test;
import  static org.junit.jupiter.api.Assertions.assertEquals;
public class PasswordStrengthMeterTest {

    /**
     * 1.길이는 8글자 이상
     * 2.0부터 9 사이의 숫자를 포함
     * 3.대문자 포함
     * 세 규칙을 모두 충족하면 암고 강함, 2개 규칙 충족시 보통, 1개 이하 약함
    */
    private PasswordStrengthMeter meter = new PasswordStrengthMeter();

    private void assertStrength(String password, PasswordStrength expStr){

        PasswordStrength result = meter.meter(password);
        assertEquals(expStr, result);
    }

    //강함 : 모든 조건 충족
    @Test
    void meetsAllCriteria_Then_Strong(){
        assertStrength("ab12!@AB",PasswordStrength.STRONG);
        assertStrength("abc1!Add",PasswordStrength.STRONG);
        //PasswordStrength result = meter.meter("abc1!Add");
        //assertEquals(PasswordStrength.STRONG, result);
    }

    //보통 : 길이가 8미만이고 나머지 조건은 충족하는 경우
    @Test
    void meetsOtherCriteria_except_for_Length_Then_Normal(){
        assertStrength("ab12!@A",PasswordStrength.NORMAL);
        assertStrength("Ab12!c",PasswordStrength.NORMAL);
    }

    //보통 : 숫자를 포함하지 않고 나머지 조건은 충족하는 경우
    @Test
    void meetsOtherCriteria_except_for_number_Then_Normal(){
        assertStrength("ab!@ABqwer",PasswordStrength.NORMAL);
    }

    //보통 : 대문자를 포함하지 않고 나머지 조건은 충족하는 경우
    @Test
    void meetsOtherCriteria_except_for_Uppercase_Then_Normal(){
        assertStrength("ab12!@df", PasswordStrength.NORMAL);
    }
    
    //약함 : 길이가 8글자 이상인 조건만 충족
    @Test
    void meetsOnlyLengthCriteria_Then_Weak(){
        assertStrength("abcdefghi", PasswordStrength.WEAK);
    }

    //약함 : 숫자 포함 조건만 충족
    @Test
    void meetsOnlyNumCriteria_Then_Weak(){
        assertStrength("12345", PasswordStrength.WEAK);
    }

    //약함 : 대문자 포함 조건만 충족
    @Test
    void meetsOnlyUpperCriteria_Then_Weak(){
        assertStrength("ABCDE", PasswordStrength.WEAK);
    }
    
    //약함 : 모든 조건 불충족
    @Test
    void meetsNoCriteria_Then_Weak(){
        assertStrength("abc", PasswordStrength.WEAK);
    }
    //null 대응
    @Test
    void nullInput_Then_Invalid(){
        assertStrength(null, PasswordStrength.INVALID);
    }

    //빈 문자열
    @Test
    void emptyInput_Then_Invalid(){
        assertStrength("", PasswordStrength.INVALID);
    }
    

}
