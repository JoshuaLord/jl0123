package test.tools.types;

import main.tools.types.*;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class DefaultToolTypeFactoryTest {
    final ToolTypeFactory toolTypeFactory = new DefaultToolTypeFactory();

    @Test
    public void testGenerateToolType() {
        assertTrue( toolTypeFactory.generateToolType( "CHN" ) instanceof Chainsaw);
        assertTrue( toolTypeFactory.generateToolType( "JAK" ) instanceof Jackhammer);
        assertTrue( toolTypeFactory.generateToolType( "LAD" ) instanceof Ladder);
    }
}
