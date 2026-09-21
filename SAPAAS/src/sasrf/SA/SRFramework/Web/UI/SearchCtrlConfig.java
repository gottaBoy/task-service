/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Web.UI;

import SA.SRFramework.Web.UI.BaseFormItemConfig;
import SA.SRFramework.Web.UI.SearchCtrlModeHelper;

public class SearchCtrlConfig
extends BaseFormItemConfig {
    protected static String MODE = "MODE";
    protected static String RANGE = "RANGE";
    protected static String COMPAREERRORMSG = "COMPAREERRORMSG";
    protected static String COMPARECHECK = "COMPARECHECK";
    public static final String ENDOFDAY = "ENDOFDAY";
    protected int curSearchCtrlMode = 0;
    protected boolean bSearchRange = false;
    protected String strCompareErrorMsg = "";
    protected boolean bCompareCheck = true;

    public int getSearchMode() {
        return this.curSearchCtrlMode;
    }

    public String getCompareErrorMsg() {
        return this.strCompareErrorMsg;
    }

    public boolean getSearchRange() {
        return this.bSearchRange;
    }

    public boolean getCompareCheck() {
        return this.bCompareCheck;
    }

    @Override
    protected void OnSetProperty(String strName, String strValue) {
        if (strName.compareToIgnoreCase(MODE) == 0) {
            this.curSearchCtrlMode = SearchCtrlModeHelper.FromString(strValue);
            return;
        }
        if (strName.compareToIgnoreCase(RANGE) == 0) {
            this.bSearchRange = SearchCtrlConfig.GetValue(strValue, this.bSearchRange);
            return;
        }
        if (strName.compareToIgnoreCase(COMPAREERRORMSG) == 0) {
            this.strCompareErrorMsg = strValue;
            return;
        }
        if (strName.compareToIgnoreCase(COMPARECHECK) == 0) {
            this.bCompareCheck = SearchCtrlConfig.GetValue(strValue, true);
            return;
        }
        super.OnSetProperty(strName, strValue);
    }
}

