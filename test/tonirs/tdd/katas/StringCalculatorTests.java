package tonirs.tdd.katas;

import org.junit.*;

import static org.junit.Assert.assertTrue;

public class StringCalculatorTests {

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
        assertTrue(0, stringCalculator.add(""));
    }
}
