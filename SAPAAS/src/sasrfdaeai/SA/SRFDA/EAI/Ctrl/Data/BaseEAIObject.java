/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.PropertiesHelper
 */
package SA.SRFDA.EAI.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import java.util.Properties;

public class BaseEAIObject
extends BaseDataEntity {
    public static final String TAG_PARAMS = "PARAMS";
    public static final String TAG_CONFIGWRITER = "CONFIGWRITER";
    private Properties params = null;

    public String getPARAMS() {
        return this.GetParamStringValue(TAG_PARAMS, "");
    }

    public void setPARAMS(String strValue) {
        this.SetParamValue(TAG_PARAMS, strValue);
    }

    public String getCONFIGWRITER() {
        return this.GetParamStringValue(TAG_CONFIGWRITER, this.OnGetDefaultConfigWriter());
    }

    public void setCONFIGWRITER(String strValue) {
        this.SetParamValue(TAG_CONFIGWRITER, strValue);
    }

    protected String OnGetDefaultConfigWriter() {
        return "";
    }

    public void BuildProperties() {
        try {
            if (this.params != null) {
                return;
            }
            String strParams = this.getPARAMS();
            this.params = !StringHelper.IsNullOrEmpty((String)strParams) ? PropertiesHelper.Load((String)strParams) : new Properties();
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public Properties getParams() {
        this.BuildProperties();
        return this.params;
    }

    public String GetParam(String strName, String strDefault) {
        return PropertiesHelper.GetProperty((Properties)this.getParams(), (String)strName, (String)strDefault);
    }
}

