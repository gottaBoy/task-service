/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Web.UI;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Web.UI.ContentTypeHelper;

public class ParamConfig
extends XMLConfig {
    protected static String MUST = "MUST";
    protected static String MUSTNOT = "MUSTNOT";
    protected static String VALUE = "VALUE";
    protected static String TYPE = "TYPE";
    protected static String INFOTYPE = "INFOTYPE";
    protected static String VALUEFORMAT = "VALUEFORMAT";
    protected static String ITEMFORMAT = "ITEMFORMAT";
    protected static String DEFAULT = "DEFAULT";
    protected static String ENCODE = "ENCODE";
    protected boolean bMust = false;
    protected boolean bMustNot = false;
    protected String strParamValue = "";
    protected String strParamType = "";
    protected int contentType = 0;
    protected String strValueFormat = "";
    protected String strDefaultValue = "";
    protected boolean bEncode = false;

    @Override
    protected void OnSetProperty(String strName, String strValue) {
        if (strName.compareToIgnoreCase(MUST) == 0) {
            this.bMust = ParamConfig.GetValue(strValue, false);
            return;
        }
        if (strName.compareToIgnoreCase(MUSTNOT) == 0) {
            this.bMustNot = ParamConfig.GetValue(strValue, false);
            return;
        }
        if (strName.compareToIgnoreCase(ENCODE) == 0) {
            this.bEncode = ParamConfig.GetValue(strValue, this.bEncode);
            return;
        }
        if (strName.compareToIgnoreCase(VALUE) == 0) {
            this.strParamValue = strValue;
            return;
        }
        if (strName.compareToIgnoreCase(TYPE) == 0) {
            this.strParamType = strValue;
            return;
        }
        if (strName.compareToIgnoreCase(VALUEFORMAT) == 0 || strName.compareToIgnoreCase(ITEMFORMAT) == 0) {
            this.strValueFormat = strValue;
            return;
        }
        if (strName.compareToIgnoreCase(INFOTYPE) == 0) {
            this.contentType = ContentTypeHelper.FromString(strValue);
            return;
        }
        if (strName.compareToIgnoreCase(DEFAULT) == 0) {
            this.strDefaultValue = strValue;
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public boolean getMust() {
        return this.bMust;
    }

    public boolean getEncode() {
        return this.bEncode;
    }

    public boolean getMustNot() {
        return this.bMustNot;
    }

    public String getParamValue() {
        return this.strParamValue;
    }

    public String getParamType() {
        return this.strParamType;
    }

    public String getValueFormat() {
        return this.strValueFormat;
    }

    public String getDefaultValue() {
        return this.strDefaultValue;
    }

    public int getFormat() {
        return this.contentType;
    }
}

