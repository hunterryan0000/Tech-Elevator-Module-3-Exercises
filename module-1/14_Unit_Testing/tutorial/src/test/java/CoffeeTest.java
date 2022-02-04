import com.techelevator.Coffee;
import org.junit.Assert;
import org.junit.Test;

public class CoffeeTest {
    @Test
    public void constructor_should_set_properties() {
        // Arrange - since we are testing a constructor, there's nothing to set up

        // Act - call the constructor by creating a new object, passing valid parameters
        Coffee coffee = new Coffee("Large", "bland", new String[]{"cream", "sugar",
                "chocolate", "whip-cream", "life"}, 10.57);
        // Assert - verify the properties are set appropriately
        Assert.assertEquals("Large", coffee.getSize());
        Assert.assertEquals("bland", coffee.getBlend());
        Assert.assertEquals(10.57, coffee.getPrice(), 0.00);
        Assert.assertEquals(5, coffee.getAdditions().length);
    }
}
