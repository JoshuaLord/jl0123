package main.tools.brands;

public class StihlBrand implements Brand {

    String identifier = "S";
    String name = "Stihl";
    @Override
    public String getIdentifier() {
        return identifier;
    }

    @Override
    public String getName() {
        return name;
    }
}
