/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Ctrl.DEFHelper;

import SA.SRFDA.Ctrl.DEFHelper.BaseDEFHelper;
import SA.SRFDA.Ctrl.DEFHelper.DEFDGItemConfig;
import SA.SRFDA.Ctrl.DEFHelper.DEFDTColumnConfig;
import SA.SRFDA.Ctrl.DEFHelper.DEFFormItemConfig;
import SA.SRFDA.Ctrl.DEFHelper.DEFMobileSettingConfig;
import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;
import org.w3c.dom.Node;

public class DEFHelperConfig
extends XMLConfig {
    public static final String TAG_DEFHELPER = "SRFDADEFHELPER";
    public static final String TAG_OBJECT = "OBJECT";
    public static final String TAG_LOGICNAME = "LOGICNAME";
    public static final String TAG_STDDATATYPE = "STDDATATYPE";
    public static final String TAG_FORMITEMSTYLE = "FORMITEMSTYLE";
    public static final String TAG_CODELIST = "CODELIST";
    public static final String TAG_STRINGLENGTH = "STRINGLENGTH";
    public static final String TAG_UNIT = "UNIT";
    public static final String TAG_VALUERULE = "VALUERULE";
    public static final String TAG_VALUERULEINFO = "VALUERULEINFO";
    public static final String TAG_CUSTOMVALUERULE = "CUSTOMVALUERULE";
    public static final String TAG_PRECISION = "PRECISION";
    public static final String TAG_UNITWIDTH = "UNITWIDTH";
    protected String strObject = BaseDEFHelper.class.getName();
    protected String strLogicName = "";
    protected String strStdDataType = "";
    protected String strFormItemStyle = "";
    protected String strCodeList = "";
    protected int nStringLength = 200;
    protected String strUnit = "";
    protected int nUnitWidth = 0;
    protected String strValueRule = "";
    protected String strCustomValueRule = "";
    protected String strValueRuleInfo = "";
    protected int nPrecision = -1;
    protected DEFFormItemConfig formItemConfig = new DEFFormItemConfig();
    protected DEFDTColumnConfig dtColumnConfig = new DEFDTColumnConfig();
    protected DEFDGItemConfig dgItemConfig = new DEFDGItemConfig();
    protected DEFMobileSettingConfig mobileSettingConfig = new DEFMobileSettingConfig();

    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)TAG_OBJECT, (String)strName, (boolean)true) == 0) {
            this.setObject(strValue);
            return;
        }
        if (StringHelper.Compare((String)TAG_LOGICNAME, (String)strName, (boolean)true) == 0) {
            this.setLogicName(strValue);
            return;
        }
        if (StringHelper.Compare((String)TAG_STDDATATYPE, (String)strName, (boolean)true) == 0) {
            this.setStdDataType(strValue);
            return;
        }
        if (StringHelper.Compare((String)TAG_FORMITEMSTYLE, (String)strName, (boolean)true) == 0) {
            this.setFormItemStyle(strValue);
            return;
        }
        if (StringHelper.Compare((String)TAG_CODELIST, (String)strName, (boolean)true) == 0) {
            this.setCodeList(strValue);
            return;
        }
        if (StringHelper.Compare((String)TAG_UNIT, (String)strName, (boolean)true) == 0) {
            this.setUnit(strValue);
            return;
        }
        if (StringHelper.Compare((String)TAG_STRINGLENGTH, (String)strName, (boolean)true) == 0) {
            this.setStringLength(DEFHelperConfig.GetValue((String)strValue, (int)this.getStringLength()));
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_UNITWIDTH, (boolean)true) == 0) {
            this.setUnitWidth(DEFHelperConfig.GetValue((String)strValue, (int)this.getUnitWidth()));
            return;
        }
        if (StringHelper.Compare((String)TAG_VALUERULE, (String)strName, (boolean)true) == 0) {
            this.setValueRule(strValue);
            return;
        }
        if (StringHelper.Compare((String)TAG_CUSTOMVALUERULE, (String)strName, (boolean)true) == 0) {
            this.setCustomValueRule(strValue);
            return;
        }
        if (StringHelper.Compare((String)TAG_VALUERULEINFO, (String)strName, (boolean)true) == 0) {
            this.setValueRuleInfo(strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_PRECISION, (boolean)true) == 0) {
            this.nPrecision = DEFHelperConfig.GetValue((String)strValue, (int)-1);
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare((String)strName, (String)"SRFDADEFFORMITEM", (boolean)true) == 0) {
            this.formItemConfig.LoadConfig(xmlNode);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)"SRFDADEFDTCOLUMN", (boolean)true) == 0) {
            this.dtColumnConfig.LoadConfig(xmlNode);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)"SRFDADEFDGITEM", (boolean)true) == 0) {
            this.dgItemConfig.LoadConfig(xmlNode);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)"SRFDADEFMOBILESETTING", (boolean)true) == 0) {
            this.mobileSettingConfig.LoadConfig(xmlNode);
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    public DEFFormItemConfig getFormItemConfig() {
        return this.formItemConfig;
    }

    public DEFDTColumnConfig getDTColumnConfig() {
        return this.dtColumnConfig;
    }

    public DEFDGItemConfig getDGItemConfig() {
        return this.dgItemConfig;
    }

    public DEFMobileSettingConfig getMobileSettingConfig() {
        return this.mobileSettingConfig;
    }

    public String getObject() {
        return this.strObject;
    }

    public void setObject(String strObject) {
        this.strObject = strObject;
    }

    public String getLogicName() {
        return this.strLogicName;
    }

    public void setLogicName(String strLogicName) {
        this.strLogicName = strLogicName;
    }

    public String getStdDataType() {
        return this.strStdDataType;
    }

    public String getFormItemStyle() {
        return this.strFormItemStyle;
    }

    public void setStdDataType(String strStdDataType) {
        this.strStdDataType = strStdDataType;
    }

    public void setFormItemStyle(String strFormItemStyle) {
        this.strFormItemStyle = strFormItemStyle;
    }

    public String getCodeList() {
        return this.strCodeList;
    }

    public void setCodeList(String strCodeList) {
        this.strCodeList = strCodeList;
    }

    public int getStringLength() {
        return this.nStringLength;
    }

    public void setStringLength(int stringLength) {
        this.nStringLength = stringLength;
    }

    public String getUnit() {
        return this.strUnit;
    }

    public void setUnit(String strUnit) {
        this.strUnit = strUnit;
    }

    public int getUnitWidth() {
        return this.nUnitWidth;
    }

    public void setUnitWidth(int unitWidth) {
        this.nUnitWidth = unitWidth;
        if (this.nUnitWidth < 0) {
            this.nUnitWidth = 0;
        }
    }

    public String getValueRule() {
        return this.strValueRule;
    }

    public String getCustomValueRule() {
        return this.strCustomValueRule;
    }

    public void setValueRule(String strValueRule) {
        this.strValueRule = strValueRule;
    }

    public void setCustomValueRule(String strCustomValueRule) {
        this.strCustomValueRule = strCustomValueRule;
    }

    public String getValueRuleInfo() {
        return this.strValueRuleInfo;
    }

    public void setValueRuleInfo(String strValueRuleInfo) {
        this.strValueRuleInfo = strValueRuleInfo;
    }

    public int getPrecision() {
        return this.nPrecision;
    }

    public void setPrecision(int nPrecision) {
        this.nPrecision = nPrecision;
    }
}

