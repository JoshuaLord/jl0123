package main.tools;

import main.tools.brands.Brand;
import main.tools.types.ToolType;

public interface Tool {

    public void setCode( String code );
    public String getCode();

    public void setToolType( ToolType type );
    public ToolType getToolType();

    public void setBrand( Brand brand );
    public Brand getBrand();

}
