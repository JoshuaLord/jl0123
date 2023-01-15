package main.tools.brands;

public class DefaultBrand implements Brand {
    private String identifier;
    private String name;

    public DefaultBrand( String identifier ) {
        this.identifier = identifier;
        this.name = generateName();
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getName() {
        return name;
    }

    private String generateName() {
        switch ( identifier ) {
            case "S":
                return "Stihl";
            case "W":
                return "Werner";
            case "D":
                return "DeWalt";
            case "R":
                return "Ridgid";
            default:
                System.out.println( "Unable to generate brand name from identifier: " + identifier );
                return null;
        }
    }
}
