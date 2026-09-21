/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Web.UI.TextBoxModeHelper
 */
package SA.SRFramework.WebEx.UI;

import SA.SRFramework.Web.UI.TextBoxModeHelper;
import SA.SRFramework.WebEx.UI.BaseInputConfig;
import java.util.HashMap;

public class TextBoxConfig
extends BaseInputConfig {
    public static final String TAG_TEXTBOX = "SRFEXTEXTBOX";
    public static final String TAG_TEXTAREA = "SRFEXTEXTAREA";
    public static final String TAG_TEXT = "TEXT";
    public static final String TAG_MAXLENGTH = "MAXLENGTH";
    public static final String TAG_TEXTBOXMODE = "TEXTBOXMODE";
    public static final String TAG_READONLYCSSCLASS = "READONLYCSSCLASS";
    public static final String TAG_TEXTALIGN = "TEXTALIGN";
    public static final String TEXTALIGN_LEFT = "LEFT";
    public static final String TEXTALIGN_CENTER = "CENTER";
    public static final String TEXTALIGN_RIGHT = "RIGHT";
    public static final String TAG_ROWS = "ROWS";
    public static final String TAG_ACMODE = "ACMODE";
    public static final String TAG_ACPARAMS = "ACPARAMS";
    public static final String TAG_ACPARAMSEX = "ACPARAMSEX";
    public static final String TAG_ACFILLPARAMSEX = "ACFILLPARAMSEX";
    public static final String TAG_ACAPPENDFORMPARAMS = "ACAPPENDFORMPARAMS";
    public static final String TAG_ACFILLPARAMS = "ACFILLPARAMS";
    public static final String TAG_ACDATAURL = "ACDATAURL";
    public static final String TAG_ACMINCHARS = "ACMINCHARS";
    public static final String TAG_ACLISTWIDTH = "ACLISTWIDTH";
    public static final String TAG_ACREALTEXT = "ACREALTEXT";
    public static final String TAG_ACFORCESELECTION = "FORCESELECTION";
    public static final String TAG_ACAPPENDPARAMS = "ACAPPENDPARAMS";
    public static final String TAG_ACUSERPARAMS = "ACUSERPARAMS";
    public static final String TAG_ACHIDETRIGGER = "ACHIDETRIGGER";
    public static final String TAG_ACAFTERSELECTCODE = "ACAFTERSELECTCODE";
    public static final String TAG_ACTRIGGERASALL = "ACTRIGGERASALL";
    public static final String TAG_ACTPL = "ACTPL";
    public static final String TAG_ACCARETFORMPARAMS = "ACCARETFORMPARAMS";
    public static final String TAG_ACAPPENDURLPARAMS = "ACAPPENDURLPARAMS";
    public static final String TAG_ACWIDTHMODE = "ACWIDTHMODE";
    public static final String TAG_CARETGROUP = "CARETGROUP";
    public static final String TAG_CARETGROUPPARAM = "CARETGROUPPARAM";
    public static final String TAG_CARETDESC = "CARETDESC";
    public static final String TAG_CARETINPUTWIDTH = "CARETINPUTWIDTH";
    public static final String TAG_CARETDESCWIDTH = "CARETDESCWIDTH";
    public static final String TAG_CARETRETURN = "CARETRETURN";
    public static final String TAG_SYNTAXHIGHLIGHT = "SYNTAXHIGHLIGHT";
    public static final String SYNTAXHIGHLIGHT_HTML = "HTML";
    protected int textBoxMode = 3;
    protected int nRows = 5;
    protected String strACMode = "";
    protected String strACParams = "";
    protected String strACFillParams = "";
    protected String strACFillParamsEx = "";
    protected String strACDataURL = "";
    protected int nACMinChars = 2;
    protected boolean bACForceSelection = false;
    protected String strACAppendParams = "";
    protected String strACUserParams = "";
    protected int nACListWidth = 0;
    protected boolean bACHideTrigger = true;
    protected String strACAfterSelectCode = "";
    protected boolean bACTriggerAsAll = false;
    protected String strACAppendFormParams = "";
    protected String strReadOnlyCssClass = "";
    protected int nMaxLength = 0;
    protected boolean bACWidthMode = false;
    protected String strACTPL = "";
    protected String strACAppendURLParams = "";
    protected String strSyntaxHighlight = "";
    protected boolean bCaretDesc = false;
    protected String strCaretGroup = "";
    protected String strCaretGroupParam = "";
    protected int nCaretInputWidth = 150;
    protected int nCaretDescWidth = 150;
    protected boolean bCaretReturn = false;
    protected boolean bACRealText = false;
    protected String strTextAlign = "";

    public TextBoxConfig() {
        this.strCssClass = "sx-input";
        this.strReadOnlyCssClass = "sx-input-readonly";
    }

    @Override
    protected void OnSetPropertyEx(HashMap<String, String> attrMap) {
        if (attrMap.size() == 0) {
            return;
        }
        String strValue = "";
        strValue = attrMap.remove(TAG_TEXT);
        if (strValue != null) {
            this.setValue(strValue);
        }
        if ((strValue = attrMap.remove(TAG_TEXTBOXMODE)) != null) {
            this.textBoxMode = TextBoxModeHelper.FromString((String)strValue);
        }
        if ((strValue = attrMap.remove(TAG_MAXLENGTH)) != null) {
            this.nMaxLength = TextBoxConfig.GetValue((String)strValue, (int)this.nMaxLength);
        }
        if ((strValue = attrMap.remove(TAG_ACMODE)) != null) {
            this.strACMode = strValue;
        }
        if ((strValue = attrMap.remove(TAG_ACWIDTHMODE)) != null) {
            this.bACWidthMode = TextBoxConfig.GetValue((String)strValue, (boolean)this.bACWidthMode);
        }
        if ((strValue = attrMap.remove(TAG_ACPARAMS)) != null) {
            this.strACParams = strValue;
        }
        if ((strValue = attrMap.remove(TAG_ACPARAMSEX)) != null) {
            this.strACAppendFormParams = strValue;
        }
        if ((strValue = attrMap.remove(TAG_ACAPPENDFORMPARAMS)) != null) {
            this.strACAppendFormParams = strValue;
        }
        if ((strValue = attrMap.remove(TAG_ACFILLPARAMS)) != null) {
            this.strACFillParams = strValue;
        }
        if ((strValue = attrMap.remove(TAG_ACFILLPARAMSEX)) != null) {
            this.strACFillParamsEx = strValue;
        }
        if ((strValue = attrMap.remove(TAG_ACDATAURL)) != null) {
            this.strACDataURL = strValue;
        }
        if ((strValue = attrMap.remove(TAG_ACLISTWIDTH)) != null) {
            this.nACListWidth = TextBoxConfig.GetValue((String)strValue, (int)this.nACListWidth);
        }
        if ((strValue = attrMap.remove(TAG_ACMINCHARS)) != null) {
            this.nACMinChars = TextBoxConfig.GetValue((String)strValue, (int)this.nACMinChars);
        }
        if ((strValue = attrMap.remove(TAG_ACFORCESELECTION)) != null) {
            this.bACForceSelection = TextBoxConfig.GetValue((String)strValue, (boolean)this.bACForceSelection);
        }
        if ((strValue = attrMap.remove(TAG_ACAPPENDPARAMS)) != null) {
            this.strACAppendParams = strValue;
        }
        if ((strValue = attrMap.remove(TAG_ACUSERPARAMS)) != null) {
            this.strACUserParams = strValue;
        }
        if ((strValue = attrMap.remove(TAG_ACHIDETRIGGER)) != null) {
            this.bACHideTrigger = TextBoxConfig.GetValue((String)strValue, (boolean)this.bACHideTrigger);
        }
        if ((strValue = attrMap.remove(TAG_ACAFTERSELECTCODE)) != null) {
            this.strACAfterSelectCode = strValue;
        }
        if ((strValue = attrMap.remove(TAG_ACTRIGGERASALL)) != null) {
            this.bACTriggerAsAll = TextBoxConfig.GetValue((String)strValue, (boolean)this.bACTriggerAsAll);
        }
        if ((strValue = attrMap.remove(TAG_READONLYCSSCLASS)) != null) {
            this.setReadonlyCssClass(strValue);
        }
        if ((strValue = attrMap.remove(TAG_ACTPL)) != null) {
            this.setACTPL(strValue);
        }
        if ((strValue = attrMap.remove(TAG_ACAPPENDURLPARAMS)) != null) {
            this.setACAppendURLParams(strValue);
        }
        if ((strValue = attrMap.remove(TAG_SYNTAXHIGHLIGHT)) != null) {
            this.setSyntaxHighlight(strValue);
        }
        if ((strValue = attrMap.remove(TAG_CARETDESC)) != null) {
            this.setCaretDesc(TextBoxConfig.GetValue((String)strValue, (boolean)this.bCaretDesc));
        }
        if ((strValue = attrMap.remove(TAG_CARETGROUP)) != null) {
            this.setCaretGroup(strValue);
        }
        if ((strValue = attrMap.remove(TAG_CARETGROUPPARAM)) != null) {
            this.setCaretGroupParam(strValue);
        }
        if ((strValue = attrMap.remove(TAG_CARETINPUTWIDTH)) != null) {
            this.setCaretInputWidth(TextBoxConfig.GetValue((String)strValue, (int)this.nCaretInputWidth));
        }
        if ((strValue = attrMap.remove(TAG_CARETDESCWIDTH)) != null) {
            this.setCaretDescWidth(TextBoxConfig.GetValue((String)strValue, (int)this.nCaretDescWidth));
        }
        if ((strValue = attrMap.remove(TAG_CARETRETURN)) != null) {
            this.setCaretReturn(TextBoxConfig.GetValue((String)strValue, (boolean)this.bCaretReturn));
        }
        if ((strValue = attrMap.remove(TAG_ACREALTEXT)) != null) {
            this.setACRealText(TextBoxConfig.GetValue((String)strValue, (boolean)this.isACRealText()));
        }
        if ((strValue = attrMap.remove(TAG_TEXTALIGN)) != null) {
            this.setTextAlign(strValue);
        }
        super.OnSetPropertyEx(attrMap);
    }

    public int getTextMode() {
        return this.textBoxMode;
    }

    public void setTextMode(int value) {
        this.textBoxMode = value;
    }

    public int getACMinChars() {
        return this.nACMinChars;
    }

    public void setACMinChars(int value) {
        this.nACMinChars = value;
    }

    public int getACListWidth() {
        return this.nACListWidth;
    }

    public void setACListWidth(int value) {
        this.nACListWidth = value;
    }

    public int getRows() {
        return this.nRows;
    }

    public void setRows(int value) {
        this.nRows = value;
    }

    public String getACMode() {
        return this.strACMode;
    }

    public void setACMode(String value) {
        this.strACMode = value;
    }

    public String getACDataURL() {
        return this.strACDataURL;
    }

    public void setACDataURL(String strACDataURL) {
        this.strACDataURL = strACDataURL;
    }

    public void setACAppendParams(String strACAppendParams) {
        this.strACAppendParams = strACAppendParams;
    }

    public String getACAppendParams() {
        return this.strACAppendParams;
    }

    public void setACUserParams(String strACUserParams) {
        this.strACUserParams = strACUserParams;
    }

    public String getACUserParams() {
        return this.strACUserParams;
    }

    public boolean getACForceSelection() {
        return this.bACForceSelection;
    }

    public void setACForceSelection(boolean bACForceSelection) {
        this.bACForceSelection = bACForceSelection;
    }

    public String getText() {
        return this.getValue();
    }

    public void setText(String value) {
        this.setValue(value);
    }

    public String getACParams() {
        return this.strACParams;
    }

    public void setACParams(String value) {
        this.strACParams = value;
    }

    public String getACFillParams() {
        return this.strACFillParams;
    }

    public void setACFillParams(String value) {
        this.strACFillParams = value;
    }

    public boolean getACHideTrigger() {
        return this.bACHideTrigger;
    }

    public void setACHideTrigger(boolean bACHideTrigger) {
        this.bACHideTrigger = bACHideTrigger;
    }

    public String getACAfterSelectCode() {
        return this.strACAfterSelectCode;
    }

    public void setACAfterSelectCode(String value) {
        this.strACAfterSelectCode = value;
    }

    public boolean isACTriggerAsAll() {
        return this.bACTriggerAsAll;
    }

    public void setACTriggerAsAll(boolean triggerAsAll) {
        this.bACTriggerAsAll = triggerAsAll;
    }

    public String getACAppendFormParams() {
        return this.strACAppendFormParams;
    }

    public void setACAppendFormParams(String strACAppendFormParams) {
        this.strACAppendFormParams = strACAppendFormParams;
    }

    public String getReadonlyCssClass() {
        return this.strReadOnlyCssClass;
    }

    public void setReadonlyCssClass(String strReadOnlyCssClass) {
        this.strReadOnlyCssClass = strReadOnlyCssClass;
    }

    public int getMaxLength() {
        return this.nMaxLength;
    }

    public void setMaxLength(int maxLength) {
        this.nMaxLength = maxLength;
        if (this.nMaxLength < 0) {
            this.nMaxLength = 0;
        }
    }

    public boolean isACWidthMode() {
        return this.bACWidthMode;
    }

    public void setACWidthMode(boolean widthMode) {
        this.bACWidthMode = widthMode;
    }

    public String getACTPL() {
        return this.strACTPL;
    }

    public void setACTPL(String strACTPL) {
        this.strACTPL = strACTPL;
    }

    public String getACFillParamsEx() {
        return this.strACFillParamsEx;
    }

    public void setACFillParamsEx(String strACFillParamsEx) {
        this.strACFillParamsEx = strACFillParamsEx;
    }

    public String getACAppendURLParams() {
        return this.strACAppendURLParams;
    }

    public void setACAppendURLParams(String strACAppendURLParams) {
        this.strACAppendURLParams = strACAppendURLParams;
    }

    public String getSyntaxHighlight() {
        return this.strSyntaxHighlight;
    }

    public void setSyntaxHighlight(String strSyntaxHighlight) {
        this.strSyntaxHighlight = strSyntaxHighlight;
    }

    public boolean isCaretDesc() {
        return this.bCaretDesc;
    }

    public String getCaretGroup() {
        return this.strCaretGroup;
    }

    public void setCaretDesc(boolean bCaretDesc) {
        this.bCaretDesc = bCaretDesc;
    }

    public void setCaretGroup(String strCaretGroup) {
        this.strCaretGroup = strCaretGroup;
    }

    public String getCaretGroupParam() {
        return this.strCaretGroupParam;
    }

    public void setCaretGroupParam(String strCaretGroupParam) {
        this.strCaretGroupParam = strCaretGroupParam;
    }

    public int getCaretInputWidth() {
        return this.nCaretInputWidth;
    }

    public void setCaretInputWidth(int nCaretInputWidth) {
        this.nCaretInputWidth = nCaretInputWidth;
    }

    public int getCaretDescWidth() {
        return this.nCaretDescWidth;
    }

    public void setCaretDescWidth(int nCaretDescWidth) {
        this.nCaretDescWidth = nCaretDescWidth;
    }

    public boolean isCaretReturn() {
        return this.bCaretReturn;
    }

    public void setCaretReturn(boolean bCaretReturn) {
        this.bCaretReturn = bCaretReturn;
    }

    public boolean isACRealText() {
        return this.bACRealText;
    }

    public void setACRealText(boolean bACRealText) {
        this.bACRealText = bACRealText;
    }

    public String getTextAlign() {
        return this.strTextAlign;
    }

    public void setTextAlign(String strTextAlign) {
        this.strTextAlign = strTextAlign;
    }
}

