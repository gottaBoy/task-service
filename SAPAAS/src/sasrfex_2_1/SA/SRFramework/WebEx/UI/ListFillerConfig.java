/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.UI;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;

public class ListFillerConfig
extends XMLConfig {
    public static final String TAG_LISTFILLER = "SRFEXLISTFILLER";
    public static final String TAG_EMPTYSUPPORTED = "EMPTYSUPPORTED";
    public static final String TAG_EMPTYTEXT = "EMPTYTEXT";
    public static final String TAG_EMPTYATFIRST = "EMPTYATFIRST";
    public static final String TAG_CODELIST = "CODELIST";
    public static final String TAG_CODELISTPARAM = "CODELISTPARAM";
    public static final String TAG_RAWCODELIST = "RAWCODELIST";
    protected boolean bEmptySupported = false;
    protected String strEmptyText = "-";
    protected boolean bEmptyAtFirst = false;
    protected String strCodeList = "";
    protected String strCodeListParam = "";
    protected String strRawCodeList = "";
    protected boolean bListFill = false;

    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_EMPTYSUPPORTED, (boolean)true) == 0) {
            this.bEmptySupported = ListFillerConfig.GetValue((String)strValue, (boolean)this.bEmptySupported);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_EMPTYATFIRST, (boolean)true) == 0) {
            this.bEmptyAtFirst = ListFillerConfig.GetValue((String)strValue, (boolean)this.bEmptyAtFirst);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_EMPTYTEXT, (boolean)true) == 0) {
            this.strEmptyText = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_CODELIST, (boolean)true) == 0) {
            this.strCodeList = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_CODELISTPARAM, (boolean)true) == 0) {
            this.strCodeListParam = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_RAWCODELIST, (boolean)true) == 0) {
            this.strRawCodeList = strValue;
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public String getEmptyText() {
        return this.strEmptyText;
    }

    public void setEmptyText(String strEmptyText) {
        this.strEmptyText = strEmptyText;
    }

    public String getCodeList() {
        return this.strCodeList;
    }

    public void setCodeList(String strCodeList) {
        this.strCodeList = strCodeList;
    }

    public boolean getEmptyAtFirst() {
        return this.bEmptyAtFirst;
    }

    public void setEmptyAtFirst(boolean bEmptyAtFirst) {
        this.bEmptyAtFirst = bEmptyAtFirst;
    }

    public boolean getEmptySupported() {
        return this.bEmptySupported;
    }

    public void setEmptySupported(boolean bEmptySupported) {
        this.bEmptySupported = bEmptySupported;
    }

    public String getRawCodeList() {
        return this.strRawCodeList;
    }

    public void setRawCodeList(String strRawCodeList) {
        this.strRawCodeList = strRawCodeList;
    }

    public boolean isFill() {
        return this.bListFill;
    }

    public void setFill(boolean bListFill) {
        this.bListFill = bListFill;
    }

    public String getCodeListParam() {
        return this.strCodeListParam;
    }

    public void setCodeListParam(String strCodeListParam) {
        this.strCodeListParam = strCodeListParam;
    }
}

