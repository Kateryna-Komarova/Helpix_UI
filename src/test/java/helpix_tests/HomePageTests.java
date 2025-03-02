package helpix_tests;

import helpix_pages.HomePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase {

    @BeforeMethod
    public void setUp() {
        driver.get("https://preview.helpix.io/"); // Загружаем начальную страницу перед каждым тестом
    }

    @Test
    public void homePageIsPresent() {
        new HomePage(driver).verifyHomePage();
    }
    @Test
    public void openListingInListViewPositiveTest() {
        new HomePage(driver).openListingInListView().verifyListingName();
    }
    @Test
    public void openListingInGridViewPositiveTest(){
        new HomePage(driver).openListingInGridView().verifyGridListingName();

    }
}
