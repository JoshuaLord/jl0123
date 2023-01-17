package main.tools.brands;

public class WernerBrand implements Brand {

    String identifier = "W";
    String name = "Werner";
    @Override
    public String getIdentifier() {
        return identifier;
    }

    @Override
    public String getName() {
        return name;
    }
}
