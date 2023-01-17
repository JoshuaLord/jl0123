package test.tools.brand;

import main.tools.brands.*;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class DefaultBrandFactoryTest {
    final BrandFactory brandFactory = new DefaultBrandFactory();

    @Test
    public void testGenerateBrand() {
        assertTrue( brandFactory.generateBrand( "S" ) instanceof StihlBrand);
        assertTrue( brandFactory.generateBrand( "W" ) instanceof WernerBrand);
        assertTrue( brandFactory.generateBrand( "D" ) instanceof DeWaltBrand);
        assertTrue( brandFactory.generateBrand( "R" ) instanceof RidgidBrand);
    }
}
