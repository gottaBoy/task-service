/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.UtilityEx.PropertiesHelper
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFDA.Ctrl.Data.AbstractDevCodeEngine;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import java.util.Properties;

public class DevCodeEngine
extends AbstractDevCodeEngine {
    private Properties codeEngineParams = null;

    public Properties GetCodeEngineParams() {
        if (this.codeEngineParams == null) {
            try {
                this.codeEngineParams = PropertiesHelper.Load((String)this.getCODEENGINEPARAM());
            }
            catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return this.codeEngineParams;
    }

    public String GetCodeEngineParam(String strName, String strDefault) {
        if (this.GetCodeEngineParams() == null) {
            return strDefault;
        }
        String strValue = PropertiesHelper.GetProperty((Properties)this.codeEngineParams, (String)strName);
        if (strValue == null) {
            return strDefault;
        }
        return strValue;
    }
}

