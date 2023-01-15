package main.tools.types;

public class DefaultToolTypeFactory implements ToolTypeFactory {
    @Override
    public ToolType generateToolType(String type) {
        switch (type) {
            case "CHN":
                return new Chainsaw();
            case "LAD":
                return new Ladder();
            case "JAK":
                return new Jackhammer();
            default:
                System.out.println( "Unable to generate tool type from: " + type );
                return null;
        }
    }
}
