package test.tools;

import main.tools.DefaultToolFactory;
import main.tools.Tool;
import main.tools.ToolFactory;
import main.tools.brands.DeWaltBrand;
import main.tools.brands.RidgidBrand;
import main.tools.brands.StihlBrand;
import main.tools.brands.WernerBrand;
import main.tools.types.Chainsaw;
import main.tools.types.Jackhammer;
import main.tools.types.Ladder;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class DefaultToolFactoryTest {

    final ToolFactory toolFactory = new DefaultToolFactory();

    @Test
    public void testGenerateTool() {
        // CHNW - Chainsaw from Werner
        Tool wernerChainsaw = toolFactory.generateTool( "CHNW" );
        assertTrue( wernerChainsaw.getToolType() instanceof Chainsaw );
        assertTrue( wernerChainsaw.getBrand() instanceof WernerBrand);

        // JAKS - Jackhammer from Stihl
        Tool stihlJackhammer = toolFactory.generateTool( "JAKS" );
        assertTrue( stihlJackhammer.getToolType() instanceof Jackhammer);
        assertTrue( stihlJackhammer.getBrand() instanceof StihlBrand);

        // CHND - Chainsaw from DeWalt
        Tool deWaltChainsaw = toolFactory.generateTool( "CHND" );
        assertTrue( deWaltChainsaw.getToolType() instanceof Chainsaw );
        assertTrue( deWaltChainsaw.getBrand() instanceof DeWaltBrand);

        // LADR - Ladder from Ridgid
        Tool ridgidLadder = toolFactory.generateTool( "LADR" );
        assertTrue( ridgidLadder.getToolType() instanceof Ladder);
        assertTrue( ridgidLadder.getBrand() instanceof RidgidBrand);
    }
}
