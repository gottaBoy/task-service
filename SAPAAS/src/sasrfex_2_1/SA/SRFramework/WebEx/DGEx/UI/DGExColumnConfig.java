/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.DGEx.UI;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.DGEx.UI.DGExBaseColumnConfig;

public class DGExColumnConfig
extends DGExBaseColumnConfig {
    public static final String TAG_SRFEXDGEXCOLUMN = "SRFEXDGEXCOLUMN";
    public static final String TAG_CAPTION = "CAPTION";
    public static final String TAG_CAPTIONCSSCLASS = "CAPTIONCSSCLASS";
    public static final String TAG_SORTFIELD = "SORTFIELD";
    protected String strCaption = "";
    protected String strCaptionCssClass = "";
    protected String strSortField = "";

    @Override
    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_CAPTION, (boolean)true) == 0) {
            this.setCaption(strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_CAPTIONCSSCLASS, (boolean)true) == 0) {
            this.setCaptionCssClass(strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_SORTFIELD, (boolean)true) == 0) {
            this.setSortField(strValue);
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public String getCaption() {
        return this.strCaption;
    }

    public void setCaption(String strCaption) {
        this.strCaption = strCaption;
    }

    public String getCaptionCssClass() {
        return this.strCaptionCssClass;
    }

    public void setCaptionCssClass(String strCaptionCssClass) {
        this.strCaptionCssClass = strCaptionCssClass;
    }

    public String getSortField() {
        return this.strSortField;
    }

    public void setSortField(String strSortField) {
        this.strSortField = strSortField;
    }
}

