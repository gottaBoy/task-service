/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.SimpleXmlWriter
 */
package net.ibizsys.pscore.srv.xml;

import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.SimpleXmlWriter;
import net.ibizsys.pscore.srv.xml.CodeItemConfig;

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
    protected boolean bBlankEmptyText = false;

    @Override
    protected void onSetAttribute(String string, String string2) {
        if (StringHelper.compare((String)string, (String)TAG_FILLER, (boolean)true) == 0) {
            this.strFiller = string2;
            return;
        }
        if (StringHelper.compare((String)string, (String)TAG_EMPTYTEXT, (boolean)true) == 0) {
            this.strEmptyText = string2;
            return;
        }
        if (StringHelper.compare((String)string, (String)TAG_SEPARATOR, (boolean)true) == 0 || StringHelper.compare((String)string, (String)TAG_SEPERATOR, (boolean)true) == 0) {
            this.strSeparator = string2;
            return;
        }
        if (StringHelper.compare((String)string, (String)TAG_NUMBERORMODE, (boolean)true) == 0) {
            this.bNumberOrMode = CodeListConfig.getValue((String)string2, (boolean)this.bNumberOrMode);
            return;
        }
        if (StringHelper.compare((String)string, (String)TAG_STRINGORMODE, (boolean)true) == 0) {
            this.bStringOrMode = CodeListConfig.getValue((String)string2, (boolean)this.bStringOrMode);
            return;
        }
        if (StringHelper.compare((String)string, (String)TAG_DBCALLERMODE, (boolean)true) == 0) {
            this.strDBCallerMode = string2;
            return;
        }
        if (StringHelper.compare((String)string, (String)TAG_VALUESEPARATOR, (boolean)true) == 0 || StringHelper.compare((String)string, (String)TAG_VALUESEPERATOR, (boolean)true) == 0) {
            this.setValueSeparator(string2);
            return;
        }
        if (StringHelper.compare((String)string, (String)TAG_USERSCOPE, (boolean)true) == 0) {
            this.bUserScope = CodeListConfig.getValue((String)string2, (boolean)this.bUserScope);
            return;
        }
        if (StringHelper.compare((String)string, (String)TAG_BLANKEMPTYTEXT, (boolean)true) == 0) {
            this.bBlankEmptyText = CodeListConfig.getValue((String)string2, (boolean)this.bBlankEmptyText);
            return;
        }
        super.onSetAttribute(string, string2);
    }

    public String getFiller() {
        return this.strFiller;
    }

    public void setFiller(String string) {
        this.strFiller = string;
    }

    public String getEmptyText() {
        return this.strEmptyText;
    }

    public void setEmptyText(String string) {
        this.strEmptyText = string;
    }

    public String getEmptyTextWithStyle() {
        if (StringHelper.length((String)this.getCssClass()) > 0) {
            return StringHelper.format((String)"<span class='%1$s'>%2$s</span>", (Object)this.getCssClass(), (Object)this.strEmptyText);
        }
        return this.strEmptyText;
    }

    public String getSeparator() {
        return this.strSeparator;
    }

    public void setSeparator(String string) {
        this.strSeparator = string;
    }

    public String getSeperator() {
        return this.strSeparator;
    }

    public void setSeperator(String string) {
        this.strSeparator = string;
    }

    public boolean getNumberOrMode() {
        return this.bNumberOrMode;
    }

    public void setNumberOrMode(boolean bl) {
        this.bNumberOrMode = bl;
    }

    public boolean getStringOrMode() {
        return this.bStringOrMode;
    }

    public void setStringOrMode(boolean bl) {
        this.bStringOrMode = bl;
    }

    public String getCodeListValueWithStyle(String string, boolean bl) {
        return this.internalGetCodeListValue(string, bl, true);
    }

    protected String internalGetCodeListValue(String string, boolean bl, boolean bl2) {
        if (StringHelper.length((String)string) == 0) {
            if (bl2) {
                return this.getEmptyTextWithStyle();
            }
            return this.getEmptyText();
        }
        if (this.bNumberOrMode) {
            String string2 = "";
            int n = CodeListConfig.getValue((String)string, (int)0);
            if (n == 0) {
                if (bl2) {
                    return this.getEmptyTextWithStyle();
                }
                return this.getEmptyText();
            }
            int n2 = 1;
            while (n >= n2) {
                if ((n & n2) > 0) {
                    CodeItemConfig codeItemConfig = this.findCodeItemConfigByValue(Integer.toString(n2), bl);
                    if (codeItemConfig == null) {
                        codeItemConfig = this.realTimeQuery(Integer.toString(n2));
                    }
                    if (codeItemConfig == null) continue;
                    if (StringHelper.length((String)string2) != 0) {
                        string2 = string2 + this.strSeparator;
                    }
                    string2 = bl2 ? string2 + codeItemConfig.getTextWithStyle() : string2 + codeItemConfig.getText();
                }
                n2 *= 2;
            }
            if (StringHelper.length((String)string2) == 0) {
                if (bl2) {
                    return this.getEmptyTextWithStyle();
                }
                return this.getEmptyText();
            }
            return string2;
        }
        if (this.bStringOrMode) {
            String string3 = "";
            if (StringHelper.length((String)string) == 0) {
                if (bl2) {
                    return this.getEmptyTextWithStyle();
                }
                return this.getEmptyText();
            }
            String string4 = StringHelper.format((String)"[%1$s]", (Object)this.getValueSeparator());
            String[] stringArray = string.split(string4);
            int n = stringArray.length;
            for (int i = 0; i < n; ++i) {
                CodeItemConfig codeItemConfig = this.findCodeItemConfigByValue(stringArray[i], bl);
                if (codeItemConfig == null) {
                    codeItemConfig = this.realTimeQuery(stringArray[i]);
                }
                if (codeItemConfig == null) continue;
                if (StringHelper.length((String)string3) != 0) {
                    string3 = string3 + this.strSeparator;
                }
                string3 = bl2 ? string3 + codeItemConfig.getTextWithStyle() : string3 + codeItemConfig.getText();
            }
            if (StringHelper.length((String)string3) == 0) {
                if (bl2) {
                    return this.getEmptyTextWithStyle();
                }
                return this.getEmptyText();
            }
            return string3;
        }
        CodeItemConfig codeItemConfig = this.findCodeItemConfigByValue(string, bl);
        if (codeItemConfig == null) {
            codeItemConfig = this.realTimeQuery(string);
        }
        if (codeItemConfig != null) {
            if (bl2) {
                return codeItemConfig.getTextWithStyle();
            }
            return codeItemConfig.getText();
        }
        if (bl2) {
            return this.getEmptyTextWithStyle();
        }
        return this.getEmptyText();
    }

    protected CodeItemConfig realTimeQuery(String string) {
        return null;
    }

    public String getDBCallerMode() {
        return this.strDBCallerMode;
    }

    public void setDBCallerMode(String string) {
        this.strDBCallerMode = string.toUpperCase();
    }

    public String getValueSeparator() {
        return this.strValueSeparator;
    }

    public void setValueSeparator(String string) {
        this.strValueSeparator = string;
    }

    public String getValueSeperator() {
        return this.strValueSeparator;
    }

    public void setValueSeperator(String string) {
        this.strValueSeparator = string;
    }

    public String getCodeListValue(String string, boolean bl) {
        return this.internalGetCodeListValue(string, bl, false);
    }

    public boolean isUserScope() {
        return this.bUserScope;
    }

    public void setUserScope(boolean bl) {
        this.bUserScope = bl;
    }

    public boolean isBlankEmptyText() {
        return this.bBlankEmptyText;
    }

    public void setBlankEmptyText(boolean bl) {
        this.bBlankEmptyText = bl;
    }

    public CodeListConfig clone() {
        CodeListConfig codeListConfig = new CodeListConfig();
        codeListConfig.setColor(this.getColor());
        codeListConfig.setCssClass(this.getCssClass());
        codeListConfig.setDBCallerMode(this.strDBCallerMode);
        codeListConfig.setEmptyText(this.strEmptyText);
        codeListConfig.setFiller(this.strFiller);
        codeListConfig.setIcon(this.strIcon);
        codeListConfig.setId(this.getId());
        codeListConfig.setNumberOrMode(this.bNumberOrMode);
        codeListConfig.setSeparator(this.strSeparator);
        codeListConfig.setStringOrMode(this.bStringOrMode);
        codeListConfig.setUserScope(this.bUserScope);
        codeListConfig.setText(this.getText());
        codeListConfig.setValueSeparator(this.strValueSeparator);
        codeListConfig.setBlankEmptyText(this.bBlankEmptyText);
        return codeListConfig;
    }

    public boolean save(SimpleXmlWriter simpleXmlWriter, boolean bl) {
        return this.save(simpleXmlWriter, TAG_CODELIST, bl);
    }

    @Override
    protected boolean saveAttributes(SimpleXmlWriter simpleXmlWriter) {
        if (!StringHelper.isNullOrEmpty((String)this.strEmptyText)) {
            simpleXmlWriter.writeAttributeString(TAG_EMPTYTEXT, this.strEmptyText);
        }
        if (this.bNumberOrMode) {
            simpleXmlWriter.writeAttributeString(TAG_NUMBERORMODE, "TRUE");
        }
        if (this.bStringOrMode) {
            simpleXmlWriter.writeAttributeString(TAG_STRINGORMODE, "TRUE");
        }
        if (this.isBlankEmptyText()) {
            simpleXmlWriter.writeAttributeString(TAG_BLANKEMPTYTEXT, "TRUE");
        }
        if (!StringHelper.isNullOrEmpty((String)this.strSeparator)) {
            simpleXmlWriter.writeAttributeString(TAG_SEPERATOR, this.strSeparator);
        }
        return super.saveAttributes(simpleXmlWriter);
    }
}

