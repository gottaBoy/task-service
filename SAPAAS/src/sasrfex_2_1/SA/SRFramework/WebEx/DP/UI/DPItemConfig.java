/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 */
package SA.SRFramework.WebEx.DP.UI;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.WebEx.DP.UI.DPBaseGroupConfig;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class DPItemConfig
extends XMLConfig {
    public static final String TAG_COLSPAN = "COLSPAN";
    public static final String TAG_OUTERSTYLE = "OUTERSTYLE";
    public static final String TAG_BEGINHTML = "BEGINHTML";
    public static final String TAG_ENDHTML = "ENDHTML";
    protected String strBeginHTML = "";
    protected String strEndHTML = "";
    protected int nColSpan = 1;
    protected DPBaseGroupConfig parentGroupConfig = null;
    protected String strOuterStyle = "";

    protected void OnSetPropertyEx(HashMap<String, String> attrMap) {
        if (attrMap.size() == 0) {
            return;
        }
        String strValue = "";
        strValue = attrMap.remove(TAG_COLSPAN);
        if (strValue != null) {
            this.setColSpan(DPItemConfig.GetValue((String)strValue, (int)this.nColSpan));
        }
        if ((strValue = attrMap.remove(TAG_OUTERSTYLE)) != null) {
            this.setOuterStyle(strValue);
        }
        if ((strValue = attrMap.remove(TAG_BEGINHTML)) != null) {
            this.setBeginHTML(strValue);
        }
        if ((strValue = attrMap.remove(TAG_ENDHTML)) != null) {
            this.setEndHTML(strValue);
        }
        super.OnSetPropertyEx(attrMap);
    }

    public int getColSpan() {
        return this.nColSpan;
    }

    public void setColSpan(int colSpan) {
        this.nColSpan = colSpan;
        if (this.nColSpan <= 0) {
            this.nColSpan = 1;
        }
    }

    public DPBaseGroupConfig getParentGroupConfig() {
        return this.parentGroupConfig;
    }

    public void setParentGroupConfig(DPBaseGroupConfig parentGroupConfig) {
        this.parentGroupConfig = parentGroupConfig;
    }

    public void GetFormCtrlConfig(ArrayList list) {
        this.OnGetFormCtrlConfig(list);
    }

    protected void OnGetFormCtrlConfig(ArrayList list) {
    }

    protected void CloneCopy(Object dst) {
        super.CloneCopy(dst);
        DPItemConfig real = (DPItemConfig)((Object)dst);
        real.setBeginHTML(this.getBeginHTML());
        real.setEndHTML(this.strEndHTML);
        real.setColSpan(this.getColSpan());
        real.setOuterStyle(this.getOuterStyle());
    }

    public String getOuterStyle() {
        return this.strOuterStyle;
    }

    public void setOuterStyle(String strOuterStyle) {
        this.strOuterStyle = strOuterStyle;
    }

    public String getBeginHTML() {
        return this.strBeginHTML;
    }

    public String getEndHTML() {
        return this.strEndHTML;
    }

    public void setBeginHTML(String strBeginHTML) {
        this.strBeginHTML = strBeginHTML;
    }

    public void setEndHTML(String strEndHTML) {
        this.strEndHTML = strEndHTML;
    }
}

