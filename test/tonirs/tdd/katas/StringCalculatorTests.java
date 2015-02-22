package tonirs.tdd.katas;

import org.junit.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class StringCalculatorTests {

    private StringCalculator stringCalculator;

    @BeforeClass
    public static void oneTimeSetUp() {
        System.out.println("@BeforeClass - oneTimeSetUp");
    }

    @AfterClass
    public static void oneTimeTearDown() {
        System.out.println("@AfterClass - oneTimeTearDown");
    }

    @Before
    public void setUp() {
        stringCalculator = new StringCalculator();
        System.out.println("@Before - setUp");
    }

    @After
    public void tearDown() {
        System.out.println("@After - tearDown");
    }

    @Test
    public void test() {
        assertThat(stringCalculator.add(""), is(equalTo(0)));
    }
}
