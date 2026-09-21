/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.DataEx;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;

public class SearchModelUserItemConfig
extends XMLConfig {
    public static final String TAG_SEARCHMODELUSERITEM = "SRFEXSEARCHMODELUSERITEM";
    public static final String TAG_DEFIELD = "DEFIELD";
    public static final String TAG_LOGIC = "LOGIC";
    protected String strDEField = "";
    protected String strLogic = "";

    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_DEFIELD, (boolean)true) == 0) {
            this.strDEField = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_LOGIC, (boolean)true) == 0) {
            this.strLogic = strValue;
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public String getDEField() {
        return this.strDEField;
    }

    public void setDEField(String strDEField) {
        this.strDEField = strDEField;
    }

    public String getLogic() {
        return this.strLogic;
    }

    public void setLogic(String strLogic) {
        this.strLogic = strLogic;
    }
}

