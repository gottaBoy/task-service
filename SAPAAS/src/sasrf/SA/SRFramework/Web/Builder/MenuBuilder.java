/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Web.Builder;

import SA.SRFramework.Web.Builder.UIBuilder;
import SA.SRFramework.Web.UI.MenuConfig;
import java.lang.reflect.Method;

public class MenuBuilder
extends UIBuilder {
    protected MenuConfig menuConfig = null;

    public void setMConfig(MenuConfig value) {
        this.menuConfig = value;
    }

    public MenuConfig getMConfig() {
        return this.menuConfig;
    }

    protected static Object GetParamValue(String strParamId, Object objContext) {
        Object objValue = null;
        try {
            String propertyMethod = "get" + strParamId.substring(0, 1).toUpperCase() + strParamId.substring(1, strParamId.length());
            Method prop = objContext.getClass().getMethod(propertyMethod, new Class[0]);
            objValue = prop.invoke(objContext, new Object[0]);
            if (objValue == null) {
                objValue = "";
            }
        }
        catch (Exception ex) {
            ex.printStackTrace(System.out);
            return "";
        }
        return objValue;
    }
}

