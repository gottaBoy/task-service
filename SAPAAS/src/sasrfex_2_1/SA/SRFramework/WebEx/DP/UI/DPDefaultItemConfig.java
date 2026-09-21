/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.DP.UI;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;

public class DPDefaultItemConfig
extends XMLConfig {
    public static final String TAG_DPDEFAULTITEM = "SRFEXDEFAULTITEM";
    public static final String TAG_DVT = "DVT";
    public static final String TAG_DV = "DV";
    protected String strDVT = "";
    protected String strDV = "";

    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_DVT, (boolean)true) == 0) {
            this.strDVT = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_DV, (boolean)true) == 0) {
            this.strDV = strValue;
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public String getDVT() {
        return this.strDVT;
    }

    public void setDVT(String strDVT) {
        this.strDVT = strDVT;
    }

    public String getDV() {
        return this.strDV;
    }

    public void setDV(String strDV) {
        this.strDV = strDV;
    }
}

