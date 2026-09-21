/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.BaseDBCallerHelper
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.XML.SimpleXMLWriter
 */
package SA.SRFramework.CodeList;

import SA.SRFramework.CodeList.CodeItemConfig;
import SA.SRFramework.CodeList.ICodeListQuery;
import SA.SRFramework.CodeList.IUserCodeListQuery;
import SA.SRFramework.Data.BaseDBCallerHelper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.XML.SimpleXMLWriter;

public class CodeListConfig
extends CodeItemConfig {
    public static final String TAG_CODELIST = "SRFEXCODELIST";
    public static final String TAG_FILLER = "FILLER";
    public static final String TAG_EMPTYTEXT = "EMPTYTEXT";
    public static final String TAG_BLANKEMPTYTEXT = "BLANKEMPTYTEXT";
    public static final String TAG_NUMBERORMODE = "NUMBERORMODE";
    public static final String TAG_STRINGORMODE = "STRINGORMODE";
    public static final String TAG_SEPARATOR = "SEPARATOR";
    public static final String TAG_SEPERATOR = "SEPERATOR";
    public static final String TAG_VALUESEPARATOR = "VALUESEPARATOR";
    public static final String TAG_VALUESEPERATOR = "VALUESEPERATOR";
    public static final String TAG_DBCALLERMODE = "DBCALLERMODE";
    public static final String TAG_USERSCOPE = "USERSCOPE";
    protected String strFiller = "";
    protected String strEmptyText = "\u672a\u5b9a\u4e49";
    protected String strSeparator = "\u3001";
    protected String strValueSeparator = ";";
    protected boolean bNumberOrMode = false;
    protected boolean bStringOrMode = false;
    protected String strDBCallerMode = "";
    protected boolean bUserScope = false;
    protected ICodeListQuery iCodeListQuery = null;
    protected IUserCodeListQuery iUserCodeListQuery = null;
    protected BaseDBCallerHelper dbCallerHelper = null;
    protected boolean bBlankEmptyText = false;

    @Override
    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_FILLER, (boolean)true) == 0) {
            this.strFiller = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_EMPTYTEXT, (boolean)true) == 0) {
            this.strEmptyText = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_SEPARATOR, (boolean)true) == 0 || StringHelper.Compare((String)strName, (String)TAG_SEPERATOR, (boolean)true) == 0) {
            this.strSeparator = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_NUMBERORMODE, (boolean)true) == 0) {
            this.bNumberOrMode = CodeListConfig.GetValue((String)strValue, (boolean)this.bNumberOrMode);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_STRINGORMODE, (boolean)true) == 0) {
            this.bStringOrMode = CodeListConfig.GetValue((String)strValue, (boolean)this.bStringOrMode);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_DBCALLERMODE, (boolean)true) == 0) {
            this.strDBCallerMode = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_VALUESEPARATOR, (boolean)true) == 0 || StringHelper.Compare((String)strName, (String)TAG_VALUESEPERATOR, (boolean)true) == 0) {
            this.setValueSeparator(strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_USERSCOPE, (boolean)true) == 0) {
            this.bUserScope = CodeListConfig.GetValue((String)strValue, (boolean)this.bUserScope);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_BLANKEMPTYTEXT, (boolean)true) == 0) {
            this.bBlankEmptyText = CodeListConfig.GetValue((String)strValue, (boolean)this.bBlankEmptyText);
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public void SetRealTimeQueryParam(BaseDBCallerHelper dbCallerHelper, ICodeListQuery iCodeListQuery) {
        this.iCodeListQuery = iCodeListQuery;
        this.dbCallerHelper = dbCallerHelper;
    }

    public void SetUserCodeListQuery(IUserCodeListQuery iUserCodeListQuery) {
        this.iUserCodeListQuery = iUserCodeListQuery;
    }

    public String getFiller() {
        return this.strFiller;
    }

    public void setFiller(String strFiller) {
        this.strFiller = strFiller;
    }

    public String getEmptyText() {
        return this.strEmptyText;
    }

    public void setEmptyText(String strEmptyText) {
        this.strEmptyText = strEmptyText;
    }

    public String getEmptyTextWithStyle() {
        if (StringHelper.Length((String)this.getCssClass()) > 0) {
            return StringHelper.Format((String)"<span class='%1$s'>%2$s</span>", (Object)this.getCssClass(), (Object)this.strEmptyText);
        }
        return this.strEmptyText;
    }

    public String getSeparator() {
        return this.strSeparator;
    }

    public void setSeparator(String strSeparator) {
        this.strSeparator = strSeparator;
    }

    public String getSeperator() {
        return this.strSeparator;
    }

    public void setSeperator(String strSeparator) {
        this.strSeparator = strSeparator;
    }

    public boolean getNumberOrMode() {
        return this.bNumberOrMode;
    }

    public void setNumberOrMode(boolean bNumberOrMode) {
        this.bNumberOrMode = bNumberOrMode;
    }

    public boolean getStringOrMode() {
        return this.bStringOrMode;
    }

    public void setStringOrMode(boolean bStringOrMode) {
        this.bStringOrMode = bStringOrMode;
    }

    public String GetCodeListValueWithStyle(String strValue, boolean bRecursion) {
        return this.InternalGetCodeListValue(strValue, bRecursion, true);
    }

    protected String InternalGetCodeListValue(String strValue, boolean bRecursion, boolean bStyle) {
        if (StringHelper.Length((String)strValue) == 0) {
            if (bStyle) {
                return this.getEmptyTextWithStyle();
            }
            return this.getEmptyText();
        }
        if (this.bNumberOrMode) {
            String strOutput = "";
            int nValue = CodeListConfig.GetValue((String)strValue, (int)0);
            if (nValue == 0) {
                if (bStyle) {
                    return this.getEmptyTextWithStyle();
                }
                return this.getEmptyText();
            }
            int nTemp = 1;
            while (nValue >= nTemp) {
                if ((nValue & nTemp) > 0) {
                    CodeItemConfig temp = this.FindCodeItemConfigByValue(Integer.toString(nTemp), bRecursion);
                    if (temp == null) {
                        temp = this.RealTimeQuery(Integer.toString(nTemp));
                    }
                    if (temp == null) continue;
                    if (StringHelper.Length((String)strOutput) != 0) {
                        strOutput = String.valueOf(strOutput) + this.strSeparator;
                    }
                    strOutput = bStyle ? String.valueOf(strOutput) + temp.getTextWithStyle() : String.valueOf(strOutput) + temp.getText();
                }
                nTemp *= 2;
            }
            if (StringHelper.Length((String)strOutput) == 0) {
                if (bStyle) {
                    return this.getEmptyTextWithStyle();
                }
                return this.getEmptyText();
            }
            return strOutput;
        }
        if (this.bStringOrMode) {
            String strOutput = "";
            if (StringHelper.Length((String)strValue) == 0) {
                if (bStyle) {
                    return this.getEmptyTextWithStyle();
                }
                return this.getEmptyText();
            }
            String strTempSeparator = StringHelper.Format((String)"[%1$s]", (Object)this.getValueSeparator());
            String[] strParts = strValue.split(strTempSeparator);
            int nSize = strParts.length;
            int i = 0;
            while (i < nSize) {
                CodeItemConfig temp = this.FindCodeItemConfigByValue(strParts[i], bRecursion);
                if (temp == null) {
                    temp = this.RealTimeQuery(strParts[i]);
                }
                if (temp != null) {
                    if (StringHelper.Length((String)strOutput) != 0) {
                        strOutput = String.valueOf(strOutput) + this.strSeparator;
                    }
                    strOutput = bStyle ? String.valueOf(strOutput) + temp.getTextWithStyle() : String.valueOf(strOutput) + temp.getText();
                }
                ++i;
            }
            if (StringHelper.Length((String)strOutput) == 0) {
                if (bStyle) {
                    return this.getEmptyTextWithStyle();
                }
                return this.getEmptyText();
            }
            return strOutput;
        }
        CodeItemConfig codeItemConfig = this.FindCodeItemConfigByValue(strValue, bRecursion);
        if (codeItemConfig == null) {
            codeItemConfig = this.RealTimeQuery(strValue);
        }
        if (codeItemConfig != null) {
            if (bStyle) {
                return codeItemConfig.getTextWithStyle();
            }
            return codeItemConfig.getText();
        }
        if (bStyle) {
            return this.getEmptyTextWithStyle();
        }
        return this.getEmptyText();
    }

    protected CodeItemConfig RealTimeQuery(String strValue) {
        if (this.iCodeListQuery != null && this.dbCallerHelper != null) {
            CodeItemConfig codeItemConfig = this.iCodeListQuery.Query(this.dbCallerHelper, strValue);
            if (codeItemConfig != null) {
                this.AddCodeItemConfig(codeItemConfig);
            }
            return codeItemConfig;
        }
        if (this.iUserCodeListQuery != null) {
            CodeItemConfig codeItemConfig = this.iUserCodeListQuery.Query(strValue);
            if (codeItemConfig != null) {
                this.AddCodeItemConfig(codeItemConfig);
            }
            return codeItemConfig;
        }
        return null;
    }

    public String getDBCallerMode() {
        return this.strDBCallerMode;
    }

    public void setDBCallerMode(String strDBCallerMode) {
        this.strDBCallerMode = strDBCallerMode.toUpperCase();
    }

    public String getValueSeparator() {
        return this.strValueSeparator;
    }

    public void setValueSeparator(String strValueSeparator) {
        this.strValueSeparator = strValueSeparator;
    }

    public String getValueSeperator() {
        return this.strValueSeparator;
    }

    public void setValueSeperator(String strValueSeparator) {
        this.strValueSeparator = strValueSeparator;
    }

    public String GetCodeListValue(String strValue, boolean bRecursion) {
        return this.InternalGetCodeListValue(strValue, bRecursion, false);
    }

    public boolean isUserScope() {
        return this.bUserScope;
    }

    public void setUserScope(boolean bUserScope) {
        this.bUserScope = bUserScope;
    }

    public boolean isBlankEmptyText() {
        return this.bBlankEmptyText;
    }

    public void setBlankEmptyText(boolean bBlankEmptyText) {
        this.bBlankEmptyText = bBlankEmptyText;
    }

    public CodeListConfig clone() {
        CodeListConfig codeListConfig = new CodeListConfig();
        codeListConfig.setColor(this.getColor());
        codeListConfig.setCssClass(this.getCssClass());
        codeListConfig.setDBCallerMode(this.strDBCallerMode);
        codeListConfig.setEmptyText(this.strEmptyText);
        codeListConfig.setFiller(this.strFiller);
        codeListConfig.setIcon(this.strIcon);
        codeListConfig.setID(this.getID());
        codeListConfig.setNumberOrMode(this.bNumberOrMode);
        codeListConfig.setSeparator(this.strSeparator);
        codeListConfig.setStringOrMode(this.bStringOrMode);
        codeListConfig.setUserScope(this.bUserScope);
        codeListConfig.setText(this.getText());
        codeListConfig.setValueSeparator(this.strValueSeparator);
        codeListConfig.setBlankEmptyText(this.bBlankEmptyText);
        return codeListConfig;
    }

    public boolean Save(SimpleXMLWriter xmlWriter, boolean bSaveChild) {
        return this.Save(xmlWriter, TAG_CODELIST, bSaveChild);
    }

    @Override
    protected boolean SavePropertys(SimpleXMLWriter xmlWriter) {
        if (!StringHelper.IsNullOrEmpty((String)this.strEmptyText)) {
            xmlWriter.WriteAttributeString(TAG_EMPTYTEXT, this.strEmptyText);
        }
        if (this.bNumberOrMode) {
            xmlWriter.WriteAttributeString(TAG_NUMBERORMODE, "TRUE");
        }
        if (this.bStringOrMode) {
            xmlWriter.WriteAttributeString(TAG_STRINGORMODE, "TRUE");
        }
        if (this.isBlankEmptyText()) {
            xmlWriter.WriteAttributeString(TAG_BLANKEMPTYTEXT, "TRUE");
        }
        if (!StringHelper.IsNullOrEmpty((String)this.strSeparator)) {
            xmlWriter.WriteAttributeString(TAG_SEPERATOR, this.strSeparator);
        }
        return super.SavePropertys(xmlWriter);
    }
}

