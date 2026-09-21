/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Web.UI;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Data.DataTypeHelper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.Web.UI.WebCtrlStyleHelper;

public class WebCtrlConfig
extends XMLConfig {
    protected static String CAPTION = "CAPTION";
    protected static String GROUPCAPTION = "GROUPCAPTION";
    protected static String CUSTOMTAG = "CUSTOMTAG";
    protected static String DBFIELD = "DBFIELD";
    protected static String TYPE = "TYPE";
    protected static String DATATYPE = "DATATYPE";
    protected static String RERULE = "RERULE";
    protected static String VALUEERRORMSG = "VALUEERRORMSG";
    protected static String DEFAULT = "DEFAULT";
    protected static String MINVALUE = "MINVALUE";
    protected static String MAXVALUE = "MAXVALUE";
    protected int curWebCtrlStyle = 0;
    protected String strCaption = "";
    protected String strCustomTag = "";
    protected String strDBField = "";
    protected int curDataType = 25;
    protected String strRegExpRule = "";
    protected String strDefaultValue = "";
    protected String strMinValue = "";
    protected String strMaxValue = "";
    protected String strGroupCaption = "";

    public int getCtrlStyle() {
        return this.curWebCtrlStyle;
    }

    public String getCaption() {
        return this.strCaption;
    }

    public String getCustomTag() {
        return this.strCustomTag;
    }

    public String getDBField() {
        if (StringHelper.StringLength(this.strDBField) == 0) {
            return this.strId;
        }
        return this.strDBField;
    }

    public int getDBType() {
        return this.curDataType;
    }

    public String getRegExpRule() {
        return this.strRegExpRule;
    }

    public String getDefault() {
        return this.strDefaultValue;
    }

    public String getMinValue() {
        return this.strMinValue;
    }

    public String getMaxValue() {
        return this.strMaxValue;
    }

    public String getGroupCaption() {
        return this.strGroupCaption;
    }

    @Override
    protected void OnSetProperty(String strName, String strValue) {
        if (strName.compareToIgnoreCase(CAPTION) == 0) {
            this.strCaption = strValue;
            return;
        }
        if (strName.compareToIgnoreCase(GROUPCAPTION) == 0) {
            this.strGroupCaption = strValue;
            return;
        }
        if (strName.compareToIgnoreCase(CUSTOMTAG) == 0) {
            this.strCustomTag = strValue;
            return;
        }
        if (strName.compareToIgnoreCase(DBFIELD) == 0) {
            this.strDBField = strValue;
            return;
        }
        if (strName.compareToIgnoreCase(TYPE) == 0) {
            this.curWebCtrlStyle = WebCtrlStyleHelper.FromString(strValue);
            return;
        }
        if (strName.compareToIgnoreCase(DATATYPE) == 0) {
            this.curDataType = DataTypeHelper.FromString(strValue);
            return;
        }
        if (strName.compareToIgnoreCase(DEFAULT) == 0) {
            this.strDefaultValue = strValue;
            return;
        }
        if (strName.compareToIgnoreCase(MINVALUE) == 0) {
            this.strMinValue = strValue;
            return;
        }
        if (strName.compareToIgnoreCase(MAXVALUE) == 0) {
            this.strMaxValue = strValue;
            return;
        }
        super.OnSetProperty(strName, strValue);
    }
}

