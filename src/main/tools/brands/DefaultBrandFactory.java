package main.tools.brands;

public class DefaultBrandFactory implements BrandFactory {

    public Brand generateBrand(String identifier) {
        switch (identifier.toUpperCase()) {
            case "S":
                return new StihlBrand();
            case "W":
                return new WernerBrand();
            case "D":
                return new DeWaltBrand();
            case "R":
                return new RidgidBrand();
            default:
                System.out.println( "Unable to generate brand from: " + identifier );
                return null;
        }
    }

}
