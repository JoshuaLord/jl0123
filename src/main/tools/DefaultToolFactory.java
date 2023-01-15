package main.tools;

import main.tools.types.ToolTypeFactory;
import main.tools.brands.*;
import main.tools.types.DefaultToolTypeFactory;
import main.tools.types.ToolType;

public class DefaultToolFactory implements ToolFactory {

    ToolTypeFactory toolTypeFactory;
    Brand brand;

    public DefaultToolFactory() {
        toolTypeFactory = new DefaultToolTypeFactory();
    }

    @Override
    public Tool generateTool(String code) {

        ToolType type = toolTypeFactory.generateToolType( parseToolType( code ) );
        Brand brand = new DefaultBrand( parseBrand( code ) );

        Tool tool = new DefaultTool();
        tool.setCode( code );
        tool.setToolType( type );
        tool.setBrand( brand );

        return tool;
    }

    private String parseToolType( String code ) {
        return code.substring(0, 3);
    }

    private String parseBrand( String code ) {
        return code.substring(3, 4);
    }
}
