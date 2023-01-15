package main.tools;

import main.tools.Tool;

public interface ToolFactory {

    public Tool generateTool( String code );

}
