import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FelineManeTest {
    private final String sex;
    private final boolean expectedResult;
    Feline feline;
    Lion lion;

    public FelineManeTest(String sex, boolean expectedResult) throws Exception {
        this.sex = sex;
        this.expectedResult = expectedResult;
        this.feline = new Feline();
        this.lion = new Lion(feline, sex);
    }

    @Parameterized.Parameters
    public static Object[][] getSex(){
        return new Object[][]{
                {"Самец", true},
                {"Самка", false}
        };
    }

    @Test
    public void hasManeTest(){
        boolean actualResult = lion.doesHaveMane();
        assertEquals(expectedResult, actualResult);
    }


}
