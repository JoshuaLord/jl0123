package main.tools.brands;

public class RidgidBrand implements Brand {

    String identifier = "R";
    String name = "Ridgid";
    @Override
    public String getIdentifier() {
        return identifier;
    }

    @Override
    public String getName() {
        return name;
    }
}
