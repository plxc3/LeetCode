import org.junit.*;
import static org.junit.Assert.assertEquals;


class Calculation{
    public int add(int a,int b){
        return a+b;
    }

    public int sub(int a,int b){
        return a-b;
    }
    public int mult(int a, int b){
        return a*b;
    }

    public int divi(int a,int b){
        if(b==0){
            throw new IllegalArgumentException("参数不正确，除数不能为0！");
        }
        return a/b;
    }
}


public class CalculationTest  {
    private Calculation calculation = null;

    @Before
    public void setUp()  {
        calculation = new Calculation();
    }

    @After
    public void tearDown()  {
    }

    @Test
    public void testAdd(){
        assertEquals(calculation.add(1,1),3);
    }

}


