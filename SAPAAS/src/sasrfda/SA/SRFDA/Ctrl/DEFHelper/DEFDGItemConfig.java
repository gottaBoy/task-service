/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Ctrl.DEFHelper;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;

public class DEFDGItemConfig
extends XMLConfig {
    public static final String TAG_DEFDGITEM = "SRFDADEFDGITEM";
    public static final String TAG_OBJECT = "OBJECT";
    public static final String TAG_LOGICNAME = "LOGICNAME";
    public static final String TAG_ITEMFORMAT = "ITEMFORMAT";
    public static final String TAG_EDITORSTYLE = "EDITORSTYLE";
    public static final String TAG_CUSTOM = "CUSTOM";
    public static final String TAG_ALIGN = "ALIGN";
    protected String strObject = "";
    protected String strLogicName = "";
    protected String strItemFormat = "%1$s";
    protected String strEditorStyle = "";
    protected String strCustom = "";
    protected String strAlign = "";
    protected boolean bDefaultItemFormat = true;

    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)TAG_OBJECT, (String)strName, (boolean)true) == 0) {
            this.setObject(strValue);
            return;
        }
        if (StringHelper.Compare((String)TAG_LOGICNAME, (String)strName, (boolean)true) == 0) {
            this.setLogicName(strValue);
            return;
        }
        if (StringHelper.Compare((String)TAG_ITEMFORMAT, (String)strName, (boolean)true) == 0) {
            this.setItemFormat(strValue);
            return;
        }
        if (StringHelper.Compare((String)TAG_EDITORSTYLE, (String)strName, (boolean)true) == 0) {
            this.setEditorStyle(strValue);
            return;
        }
        if (StringHelper.Compare((String)TAG_CUSTOM, (String)strName, (boolean)true) == 0) {
            this.setCustom(strValue);
            return;
        }
        if (StringHelper.Compare((String)TAG_ALIGN, (String)strName, (boolean)true) == 0) {
            this.setAlign(strValue);
            return;
        }
        super.OnSetProperty(strName, strValue);
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

    public String getItemFormat() {
        return this.strItemFormat;
    }

    public void setItemFormat(String strItemFormat) {
        this.bDefaultItemFormat = false;
        this.strItemFormat = strItemFormat;
    }

    public String getEditorStyle() {
        return this.strEditorStyle;
    }

    public void setEditorStyle(String strEditorStyle) {
        this.strEditorStyle = strEditorStyle;
    }

    public String getCustom() {
        return this.strCustom;
    }

    public void setCustom(String strCustom) {
        this.strCustom = strCustom;
    }

    public String getAlign() {
        return this.strAlign;
    }

    public void setAlign(String strAlign) {
        this.strAlign = strAlign;
    }

    public boolean getDefaultItemFormat() {
        return this.bDefaultItemFormat;
    }
}

