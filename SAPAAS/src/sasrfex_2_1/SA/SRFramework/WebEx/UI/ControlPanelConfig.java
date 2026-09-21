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
import SA.SRFramework.UtilityEx.ObjectHelper;
import SA.SRFramework.WebEx.UI.BaseControlConfig;
import SA.SRFramework.WebEx.UI.BasePanelConfig;
import SA.SRFramework.WebEx.UI.CheckBoxConfig;
import SA.SRFramework.WebEx.UI.CheckBoxListConfig;
import SA.SRFramework.WebEx.UI.ControlConfigContext;
import SA.SRFramework.WebEx.UI.DatePickerConfig;
import SA.SRFramework.WebEx.UI.DatePickerExConfig;
import SA.SRFramework.WebEx.UI.DropDownListConfig;
import SA.SRFramework.WebEx.UI.FileUploaderConfig;
import SA.SRFramework.WebEx.UI.FormControlConfig;
import SA.SRFramework.WebEx.UI.FormImageLinkConfig;
import SA.SRFramework.WebEx.UI.HiddenConfig;
import SA.SRFramework.WebEx.UI.HtmlEditorConfig;
import SA.SRFramework.WebEx.UI.HtmlEditorExConfig;
import SA.SRFramework.WebEx.UI.ListBoxConfig;
import SA.SRFramework.WebEx.UI.ListBoxPickupConfig;
import SA.SRFramework.WebEx.UI.PickerConfig;
import SA.SRFramework.WebEx.UI.PickerExConfig;
import SA.SRFramework.WebEx.UI.PictureConfig;
import SA.SRFramework.WebEx.UI.RadioButtonListConfig;
import SA.SRFramework.WebEx.UI.RawConfig;
import SA.SRFramework.WebEx.UI.SpanConfig;
import SA.SRFramework.WebEx.UI.SpanExConfig;
import SA.SRFramework.WebEx.UI.TextAreaConfig;
import SA.SRFramework.WebEx.UI.TextBoxConfig;
import SA.SRFramework.WebEx.UI.UserControlConfig;
import java.util.ArrayList;
import org.w3c.dom.Node;

public class ControlPanelConfig
extends BasePanelConfig {
    public static final String TAG_CONTROLPANEL = "SRFEXCONTROLPANEL";
    public static final String TAG_CAPTIONONTOP = "CAPTIONONTOP";
    public static final String TAG_CAPTION = "CAPTION";
    public static final String TAG_CAPTIONCSSCLASS = "CAPTIONCSSCLASS";
    public static final String TAG_CAPTIONWIDTH = "CAPTIONWIDTH";
    public static final String TAG_ALLOWEMPTY = "ALLOWEMPTY";
    public static final String TAG_CAPTIONEXTSTYLE = "CAPTIONEXTSTYLE";
    public static final String TAG_AUTOERRORREGION = "AUTOERRORREGION";
    public static final String TAG_TIPS = "TIPS";
    public static final String TAG_TIPSID = "TIPSID";
    public static final String TAG_USERCONTROLEX = "SRFEXUSERCONTROLEX";
    public static final String TAG_SYNCCONTROLCONFIG = "SYNCCONTROLCONFIG";
    protected boolean bCaptionOnTop = false;
    protected ArrayList childControls = new ArrayList();
    protected String strCaption = "";
    protected String strCaptionCssClass = "";
    protected int nCaptionWidth = 0;
    protected boolean bAllowEmpty = true;
    protected String strCaptionExtStyle = "";
    protected boolean bAutoErrorRegion = true;
    protected boolean bSyncControlConfig = true;
    protected String strTips = "";
    protected String strTipsId = "";

    protected void SyncControlConfig(BaseControlConfig baseControlConfig) {
        FormControlConfig formControlConfig;
        if (!this.bSyncControlConfig) {
            return;
        }
        if (baseControlConfig instanceof FormControlConfig && (formControlConfig = (FormControlConfig)baseControlConfig).getFormItemConfig() != null) {
            if (!formControlConfig.getFormItemConfig().getAllowEmpty()) {
                this.setAllowEmpty(false);
            }
            if (StringHelper.Length((String)formControlConfig.getFormItemConfig().getName()) == 0) {
                formControlConfig.getFormItemConfig().setName(this.getCaption());
            }
        }
    }

    public void OnLoadNode(String strName, Node xmlNode) {
        ControlConfigContext controlConfigContext = this.getConfigContext();
        ControlConfigContext tempContext = null;
        if (controlConfigContext != null) {
            tempContext = controlConfigContext.Clone();
            tempContext.setParentUIStyle(controlConfigContext.getCurUIStyle());
            tempContext.setCurUIStyle(null);
            int nChildPos = 0;
            if (this.childControls != null) {
                nChildPos = this.childControls.size();
            }
            tempContext.setParam("CHILDPOS", nChildPos);
        }
        if (StringHelper.Compare((String)strName, (String)"SRFEXRAW", (boolean)true) == 0) {
            RawConfig rawConfig = new RawConfig();
            if (rawConfig.LoadConfig(xmlNode, tempContext)) {
                this.SyncControlConfig(rawConfig);
                this.childControls.add(rawConfig);
                if (controlConfigContext != null) {
                    tempContext.RemoveParam("CHILDPOS");
                    controlConfigContext.FromParamList(tempContext.getParamList());
                }
            }
            return;
        }
        if (StringHelper.Compare((String)strName, (String)"SRFEXPICKEREX", (boolean)true) == 0) {
            PickerExConfig pickerExConfig = new PickerExConfig();
            if (pickerExConfig.LoadConfig(xmlNode, tempContext)) {
                this.SyncControlConfig(pickerExConfig);
                this.childControls.add(pickerExConfig);
                if (controlConfigContext != null) {
                    tempContext.RemoveParam("CHILDPOS");
                    controlConfigContext.FromParamList(tempContext.getParamList());
                }
            }
            return;
        }
        if (StringHelper.Compare((String)strName, (String)"SRFEXSPANEX", (boolean)true) == 0) {
            SpanExConfig spanExConfig = new SpanExConfig();
            if (spanExConfig.LoadConfig(xmlNode, tempContext)) {
                this.childControls.add(spanExConfig);
                if (controlConfigContext != null) {
                    tempContext.RemoveParam("CHILDPOS");
                    controlConfigContext.FromParamList(tempContext.getParamList());
                }
            }
            return;
        }
        if (StringHelper.Compare((String)strName, (String)"SRFEXDATEPICKEREX", (boolean)true) == 0) {
            DatePickerExConfig datePickerExConfig = new DatePickerExConfig();
            if (datePickerExConfig.LoadConfig(xmlNode, tempContext)) {
                this.SyncControlConfig(datePickerExConfig);
                this.childControls.add(datePickerExConfig);
                if (controlConfigContext != null) {
                    tempContext.RemoveParam("CHILDPOS");
                    controlConfigContext.FromParamList(tempContext.getParamList());
                }
            }
            return;
        }
        if (StringHelper.Compare((String)strName, (String)"SRFEXDATEPICKER", (boolean)true) == 0) {
            DatePickerConfig datePickerConfig = new DatePickerConfig();
            if (datePickerConfig.LoadConfig(xmlNode, tempContext)) {
                this.SyncControlConfig(datePickerConfig);
                this.childControls.add(datePickerConfig);
                if (controlConfigContext != null) {
                    tempContext.RemoveParam("CHILDPOS");
                    controlConfigContext.FromParamList(tempContext.getParamList());
                }
            }
            return;
        }
        if (StringHelper.Compare((String)strName, (String)"SRFEXLISTBOX", (boolean)true) == 0) {
            ListBoxConfig listBoxConfig = new ListBoxConfig();
            if (listBoxConfig.LoadConfig(xmlNode, tempContext)) {
                this.SyncControlConfig(listBoxConfig);
                this.childControls.add(listBoxConfig);
                if (controlConfigContext != null) {
                    tempContext.RemoveParam("CHILDPOS");
                    controlConfigContext.FromParamList(tempContext.getParamList());
                }
            }
            return;
        }
        if (StringHelper.Compare((String)strName, (String)"SRFEXCHECKBOXLIST", (boolean)true) == 0) {
            CheckBoxListConfig checkBoxListConfig = new CheckBoxListConfig();
            if (checkBoxListConfig.LoadConfig(xmlNode, tempContext)) {
                this.SyncControlConfig(checkBoxListConfig);
                this.childControls.add(checkBoxListConfig);
                if (controlConfigContext != null) {
                    tempContext.RemoveParam("CHILDPOS");
                    controlConfigContext.FromParamList(tempContext.getParamList());
                }
            }
            return;
        }
        if (StringHelper.Compare((String)strName, (String)"SRFEXCHECKBOX", (boolean)true) == 0) {
            CheckBoxConfig checkBoxConfig = new CheckBoxConfig();
            if (checkBoxConfig.LoadConfig(xmlNode, tempContext)) {
                this.SyncControlConfig(checkBoxConfig);
                this.childControls.add(checkBoxConfig);
                if (controlConfigContext != null) {
                    tempContext.RemoveParam("CHILDPOS");
                    controlConfigContext.FromParamList(tempContext.getParamList());
                }
            }
            return;
        }
        if (StringHelper.Compare((String)strName, (String)"SRFEXRADIOBUTTONLIST", (boolean)true) == 0) {
            RadioButtonListConfig radioButtonListConfig = new RadioButtonListConfig();
            if (radioButtonListConfig.LoadConfig(xmlNode, tempContext)) {
                this.SyncControlConfig(radioButtonListConfig);
                this.childControls.add(radioButtonListConfig);
                if (controlConfigContext != null) {
                    tempContext.RemoveParam("CHILDPOS");
                    controlConfigContext.FromParamList(tempContext.getParamList());
                }
            }
            return;
        }
        if (StringHelper.Compare((String)strName, (String)"SRFEXPICKER", (boolean)true) == 0) {
            PickerConfig pickupConfig = new PickerConfig();
            if (pickupConfig.LoadConfig(xmlNode, tempContext)) {
                this.SyncControlConfig(pickupConfig);
                this.childControls.add(pickupConfig);
                if (controlConfigContext != null) {
                    tempContext.RemoveParam("CHILDPOS");
                    controlConfigContext.FromParamList(tempContext.getParamList());
                }
            }
            return;
        }
        if (StringHelper.Compare((String)strName, (String)"SRFEXHIDDEN", (boolean)true) == 0) {
            HiddenConfig hiddenConfig = new HiddenConfig();
            if (hiddenConfig.LoadConfig(xmlNode, tempContext)) {
                this.childControls.add(hiddenConfig);
                if (controlConfigContext != null) {
                    tempContext.RemoveParam("CHILDPOS");
                    controlConfigContext.FromParamList(tempContext.getParamList());
                }
            }
            return;
        }
        if (StringHelper.Compare((String)strName, (String)"SRFEXDROPDOWNLIST", (boolean)true) == 0) {
            DropDownListConfig dropDownListConfig = new DropDownListConfig();
            if (dropDownListConfig.LoadConfig(xmlNode, tempContext)) {
                this.SyncControlConfig(dropDownListConfig);
                this.childControls.add(dropDownListConfig);
                if (controlConfigContext != null) {
                    tempContext.RemoveParam("CHILDPOS");
                    controlConfigContext.FromParamList(tempContext.getParamList());
                }
            }
            return;
        }
        if (StringHelper.Compare((String)strName, (String)"SRFEXTEXTAREA", (boolean)true) == 0) {
            TextAreaConfig textAreaConfig = new TextAreaConfig();
            if (textAreaConfig.LoadConfig(xmlNode, tempContext)) {
                this.SyncControlConfig(textAreaConfig);
                this.childControls.add(textAreaConfig);
                if (controlConfigContext != null) {
                    tempContext.RemoveParam("CHILDPOS");
                    controlConfigContext.FromParamList(tempContext.getParamList());
                }
            }
            return;
        }
        if (StringHelper.Compare((String)strName, (String)"SRFEXTEXTBOX", (boolean)true) == 0) {
            TextBoxConfig textBoxConfig = new TextBoxConfig();
            if (textBoxConfig.LoadConfig(xmlNode, tempContext)) {
                this.SyncControlConfig(textBoxConfig);
                this.childControls.add(textBoxConfig);
                if (controlConfigContext != null) {
                    tempContext.RemoveParam("CHILDPOS");
                    controlConfigContext.FromParamList(tempContext.getParamList());
                }
            }
            return;
        }
        if (StringHelper.Compare((String)strName, (String)"SRFEXSPAN", (boolean)true) == 0) {
            SpanConfig spanConfig = new SpanConfig();
            if (spanConfig.LoadConfig(xmlNode, tempContext)) {
                this.childControls.add(spanConfig);
                if (controlConfigContext != null) {
                    tempContext.RemoveParam("CHILDPOS");
                    controlConfigContext.FromParamList(tempContext.getParamList());
                }
            }
            return;
        }
        if (StringHelper.Compare((String)strName, (String)"SRFEXFORMIMAGELINK", (boolean)true) == 0) {
            FormImageLinkConfig formImageLinkConfig = new FormImageLinkConfig();
            if (formImageLinkConfig.LoadConfig(xmlNode, tempContext)) {
                this.childControls.add(formImageLinkConfig);
                if (controlConfigContext != null) {
                    tempContext.RemoveParam("CHILDPOS");
                    controlConfigContext.FromParamList(tempContext.getParamList());
                }
            }
            return;
        }
        if (StringHelper.Compare((String)strName, (String)"SRFEXLISTBOXPICKUP", (boolean)true) == 0) {
            ListBoxPickupConfig listBoxPickupConfig = new ListBoxPickupConfig();
            if (listBoxPickupConfig.LoadConfig(xmlNode, tempContext)) {
                this.SyncControlConfig(listBoxPickupConfig);
                this.childControls.add(listBoxPickupConfig);
                if (controlConfigContext != null) {
                    tempContext.RemoveParam("CHILDPOS");
                    controlConfigContext.FromParamList(tempContext.getParamList());
                }
            }
            return;
        }
        if (StringHelper.Compare((String)strName, (String)"SRFEXRAW", (boolean)true) == 0) {
            RawConfig rawConfig = new RawConfig();
            if (rawConfig.LoadConfig(xmlNode, tempContext)) {
                this.childControls.add(rawConfig);
                if (controlConfigContext != null) {
                    tempContext.RemoveParam("CHILDPOS");
                    controlConfigContext.FromParamList(tempContext.getParamList());
                }
            }
            return;
        }
        if (StringHelper.Compare((String)strName, (String)"SRFEXHTMLEDITOR", (boolean)true) == 0) {
            HtmlEditorConfig htmlEditorConfig = new HtmlEditorConfig();
            if (htmlEditorConfig.LoadConfig(xmlNode, tempContext)) {
                this.childControls.add(htmlEditorConfig);
                if (controlConfigContext != null) {
                    tempContext.RemoveParam("CHILDPOS");
                    controlConfigContext.FromParamList(tempContext.getParamList());
                }
            }
            return;
        }
        if (StringHelper.Compare((String)strName, (String)"SRFEXHTMLEDITOREX", (boolean)true) == 0) {
            HtmlEditorExConfig htmlEditorConfig = new HtmlEditorExConfig();
            if (htmlEditorConfig.LoadConfig(xmlNode, tempContext)) {
                this.childControls.add(htmlEditorConfig);
                if (controlConfigContext != null) {
                    tempContext.RemoveParam("CHILDPOS");
                    controlConfigContext.FromParamList(tempContext.getParamList());
                }
            }
            return;
        }
        if (StringHelper.Compare((String)strName, (String)"SRFEXFILEUPLOADER", (boolean)true) == 0) {
            FileUploaderConfig fileUploaderConfig = new FileUploaderConfig();
            if (fileUploaderConfig.LoadConfig(xmlNode, tempContext)) {
                this.childControls.add(fileUploaderConfig);
                if (controlConfigContext != null) {
                    tempContext.RemoveParam("CHILDPOS");
                    controlConfigContext.FromParamList(tempContext.getParamList());
                }
            }
            return;
        }
        if (StringHelper.Compare((String)strName, (String)"SRFEXPICTURE", (boolean)true) == 0) {
            PictureConfig pictureConfig = new PictureConfig();
            if (pictureConfig.LoadConfig(xmlNode, tempContext)) {
                this.childControls.add(pictureConfig);
                if (controlConfigContext != null) {
                    tempContext.RemoveParam("CHILDPOS");
                    controlConfigContext.FromParamList(tempContext.getParamList());
                }
            }
            return;
        }
        if (StringHelper.Compare((String)strName, (String)"SRFEXUSERCONTROL", (boolean)true) == 0) {
            UserControlConfig userControlConfig = new UserControlConfig();
            if (userControlConfig.LoadConfig(xmlNode, tempContext)) {
                this.childControls.add(userControlConfig);
                if (controlConfigContext != null) {
                    tempContext.RemoveParam("CHILDPOS");
                    controlConfigContext.FromParamList(tempContext.getParamList());
                }
            }
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_USERCONTROLEX, (boolean)true) == 0) {
            XMLConfig xmlConfig = new XMLConfig();
            xmlConfig.LoadConfig(xmlNode);
            String strConfig = xmlConfig.GetExtValue("CONFIG", "");
            if (!StringHelper.IsNullOrEmpty((String)strConfig)) {
                XMLConfig realConfig;
                Object objConfig = ObjectHelper.Create(strConfig);
                if (objConfig == null) {
                    return;
                }
                if (objConfig instanceof XMLConfig && (realConfig = (XMLConfig)objConfig).LoadConfig(xmlNode)) {
                    this.childControls.add(realConfig);
                    if (controlConfigContext != null) {
                        tempContext.RemoveParam("CHILDPOS");
                        controlConfigContext.FromParamList(tempContext.getParamList());
                    }
                }
            }
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    @Override
    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_CAPTIONONTOP, (boolean)true) == 0) {
            this.bCaptionOnTop = ControlPanelConfig.GetValue((String)strValue, (boolean)this.bCaptionOnTop);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_CAPTION, (boolean)true) == 0) {
            this.strCaption = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_CAPTIONCSSCLASS, (boolean)true) == 0) {
            this.strCaptionCssClass = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_CAPTIONWIDTH, (boolean)true) == 0) {
            this.nCaptionWidth = ControlPanelConfig.GetValue((String)strValue, (int)this.nCaptionWidth);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_ALLOWEMPTY, (boolean)true) == 0) {
            this.bAllowEmpty = ControlPanelConfig.GetValue((String)strValue, (boolean)this.bAllowEmpty);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_CAPTIONEXTSTYLE, (boolean)true) == 0) {
            this.strCaptionExtStyle = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_AUTOERRORREGION, (boolean)true) == 0) {
            this.bAutoErrorRegion = ControlPanelConfig.GetValue((String)strValue, (boolean)this.bAutoErrorRegion);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_SYNCCONTROLCONFIG, (boolean)true) == 0) {
            this.bSyncControlConfig = ControlPanelConfig.GetValue((String)strValue, (boolean)this.bSyncControlConfig);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_TIPS, (boolean)true) == 0) {
            this.strTips = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_TIPSID, (boolean)true) == 0) {
            this.strTipsId = strValue;
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public ArrayList getControls() {
        return this.childControls;
    }

    public boolean getCaptionOnTop() {
        return this.bCaptionOnTop;
    }

    public void setCaptionOnTop(boolean bCaptionOnTop) {
        this.bCaptionOnTop = bCaptionOnTop;
    }

    public void setCaption(String strCaption) {
        this.strCaption = strCaption;
    }

    public String getCaption() {
        return this.strCaption;
    }

    public void setCaptionCssClass(String strCaptionCssClass) {
        this.strCaptionCssClass = strCaptionCssClass;
    }

    public String getCaptionCssClass() {
        return this.strCaptionCssClass;
    }

    public void setCaptionWidth(int nCaptionWidth) {
        this.nCaptionWidth = nCaptionWidth;
    }

    public int getCaptionWidth() {
        return this.nCaptionWidth;
    }

    public void setAllowEmpty(boolean bAllowEmpty) {
        this.bAllowEmpty = bAllowEmpty;
    }

    public boolean getAllowEmpty() {
        return this.bAllowEmpty;
    }

    public void setAutoErrorRegion(boolean bAutoErrorRegion) {
        this.bAutoErrorRegion = bAutoErrorRegion;
    }

    public boolean getAutoErrorRegion() {
        return this.bAutoErrorRegion;
    }

    public void setSyncControlConfig(boolean bSyncControlConfig) {
        this.bSyncControlConfig = bSyncControlConfig;
    }

    public boolean getSyncControlConfig() {
        return this.bSyncControlConfig;
    }

    public void setCaptionExtStyle(String strCaptionExtStyle) {
        this.strCaptionExtStyle = strCaptionExtStyle;
    }

    public String getCaptionExtStyle() {
        return this.strCaptionExtStyle;
    }

    public String getTips() {
        return this.strTips;
    }

    public void setTips(String strTips) {
        this.strTips = strTips;
    }

    public String getTipsId() {
        return this.strTipsId;
    }

    public void setTipsId(String strTipsId) {
        this.strTipsId = strTipsId;
    }

    public void SetControlFormId(String strFormId) {
        int i = 0;
        while (i < this.childControls.size()) {
            PickerExConfig pickerEx;
            FormControlConfig formControlConfig;
            BaseControlConfig baseControlConfig = (BaseControlConfig)((Object)this.childControls.get(i));
            if (baseControlConfig instanceof FormControlConfig && (formControlConfig = (FormControlConfig)baseControlConfig).getFormItemConfig() != null) {
                formControlConfig.getFormItemConfig().setFormId(strFormId);
            }
            if (baseControlConfig instanceof PickerExConfig && (pickerEx = (PickerExConfig)baseControlConfig).getTextBoxConfig() != null && pickerEx.getTextBoxConfig().getFormItemConfig() != null) {
                pickerEx.getTextBoxConfig().getFormItemConfig().setFormId(strFormId);
            }
            ++i;
        }
    }

    public void AddChildControl(BaseControlConfig baseControlConfig) {
        this.SyncControlConfig(baseControlConfig);
        this.childControls.add(baseControlConfig);
    }

    public void RemoveChildControl(BaseControlConfig baseControlConfig) {
        this.childControls.remove((Object)baseControlConfig);
    }
}

