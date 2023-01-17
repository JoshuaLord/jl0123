package main.tools.brands;

public class DeWaltBrand implements Brand {

    String identifier = "D";
    String name = "DeWalt";
    @Override
    public String getIdentifier() {
        return identifier;
    }

    @Override
    public String getName() {
        return name;
    }
}
