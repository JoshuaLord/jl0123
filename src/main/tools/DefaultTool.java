package main.tools;

import main.tools.brands.Brand;
import main.tools.types.ToolType;

public class DefaultTool implements Tool {

    private String code;
    private ToolType type;
    private Brand brand;

    @Override
    public void setToolCode(String code) {
        this.code = code;
    }

    @Override
    public String getToolCode() {
        return code;
    }

    @Override
    public void setToolType(ToolType type) {
        this.type = type;
    }

    @Override
    public ToolType getToolType() {
        return type;
    }

    @Override
    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    @Override
    public Brand getBrand() {
        return brand;
    }
}
