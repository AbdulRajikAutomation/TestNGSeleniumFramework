import org.testng.annotations.DataProvider;

public class using_dataProvider {

	@DataProvider(name = "loginData")
    public Object[][] getData() {
        // Define 10 sets of username and password
        return new Object[][] {
            {"user1", "password1"},
            {"user2", "password2"},
            {"user3", "password3"},
            {"user4", "password4"},
            {"user5", "password5"},
            {"user6", "password6"},
            {"user7", "password7"},
            {"user8", "password8"},
            {"user9", "password9"},
            {"user10", "password10"}
        };
    }
}
