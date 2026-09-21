/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFramework.WebEx;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import SA.SRFramework.WebEx.Builder.BaseBuilder;
import SA.SRFramework.WebEx.Builder.ControlPanelBuilder;
import SA.SRFramework.WebEx.ISRFExFormItem;
import SA.SRFramework.WebEx.SRFExBasePanel;
import SA.SRFramework.WebEx.SRFExCheckBox;
import SA.SRFramework.WebEx.SRFExCheckBoxList;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.SRFExDatePicker;
import SA.SRFramework.WebEx.SRFExDatePickerEx;
import SA.SRFramework.WebEx.SRFExDropDownList;
import SA.SRFramework.WebEx.SRFExFileUploader;
import SA.SRFramework.WebEx.SRFExFormImageLink;
import SA.SRFramework.WebEx.SRFExHidden;
import SA.SRFramework.WebEx.SRFExHtmlEditor;
import SA.SRFramework.WebEx.SRFExHtmlEditorEx;
import SA.SRFramework.WebEx.SRFExListBox;
import SA.SRFramework.WebEx.SRFExListBoxPickup;
import SA.SRFramework.WebEx.SRFExPicker;
import SA.SRFramework.WebEx.SRFExPickerEx;
import SA.SRFramework.WebEx.SRFExPicture;
import SA.SRFramework.WebEx.SRFExRadioButtonList;
import SA.SRFramework.WebEx.SRFExRaw;
import SA.SRFramework.WebEx.SRFExSpan;
import SA.SRFramework.WebEx.SRFExTextBox;
import SA.SRFramework.WebEx.UI.CheckBoxConfig;
import SA.SRFramework.WebEx.UI.CheckBoxListConfig;
import SA.SRFramework.WebEx.UI.ControlPanelConfig;
import SA.SRFramework.WebEx.UI.DatePickerConfig;
import SA.SRFramework.WebEx.UI.DatePickerExConfig;
import SA.SRFramework.WebEx.UI.DropDownListConfig;
import SA.SRFramework.WebEx.UI.FileUploaderConfig;
import SA.SRFramework.WebEx.UI.FormImageLinkConfig;
import SA.SRFramework.WebEx.UI.FormItemConfig;
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
import SA.SRFramework.WebEx.UI.UserControlItemConfig;
import SA.SRFramework.WebEx.UI.UserControlMgr;
import java.io.Writer;
import java.util.ArrayList;
import java.util.TreeMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SRFExControlPanel
extends SRFExBasePanel {
    protected ControlPanelConfig controlPanelConfig = null;
    private static final Log log = LogFactory.getLog(SRFExControlPanel.class);
    protected ControlPanelBuilder controlPanelBuilder = null;
    public static String BUILDER_CONTROLPANEL = "CONTROLPANEL";
    private static TreeMap<String, String> childControls = new TreeMap();

    static {
        childControls.put(ListBoxPickupConfig.class.getName(), SRFExListBoxPickup.class.getName());
        childControls.put(RawConfig.class.getName(), SRFExRaw.class.getName());
        childControls.put(PickerExConfig.class.getName(), SRFExPickerEx.class.getName());
        childControls.put(DatePickerExConfig.class.getName(), SRFExDatePickerEx.class.getName());
        childControls.put(DatePickerConfig.class.getName(), SRFExDatePicker.class.getName());
        childControls.put(ListBoxConfig.class.getName(), SRFExListBox.class.getName());
        childControls.put(CheckBoxListConfig.class.getName(), SRFExCheckBoxList.class.getName());
        childControls.put(CheckBoxConfig.class.getName(), SRFExCheckBox.class.getName());
        childControls.put(RadioButtonListConfig.class.getName(), SRFExRadioButtonList.class.getName());
        childControls.put(PickerConfig.class.getName(), SRFExPicker.class.getName());
        childControls.put(DropDownListConfig.class.getName(), SRFExDropDownList.class.getName());
        childControls.put(TextBoxConfig.class.getName(), SRFExTextBox.class.getName());
        childControls.put(TextAreaConfig.class.getName(), SRFExTextBox.class.getName());
        childControls.put(SpanConfig.class.getName(), SRFExSpan.class.getName());
        childControls.put(SpanExConfig.class.getName(), SRFExSpan.class.getName());
        childControls.put(HiddenConfig.class.getName(), SRFExHidden.class.getName());
        childControls.put(FormImageLinkConfig.class.getName(), SRFExFormImageLink.class.getName());
        childControls.put(HtmlEditorConfig.class.getName(), SRFExHtmlEditor.class.getName());
        childControls.put(HtmlEditorExConfig.class.getName(), SRFExHtmlEditorEx.class.getName());
        childControls.put(FileUploaderConfig.class.getName(), SRFExFileUploader.class.getName());
        childControls.put(PictureConfig.class.getName(), SRFExPicture.class.getName());
    }

    public ControlPanelConfig getControlPanelConfig() {
        return this.controlPanelConfig;
    }

    @Override
    protected void OnSetConfig() {
        super.OnSetConfig();
        this.controlPanelConfig = null;
        if (this.config != null && this.config instanceof ControlPanelConfig) {
            this.controlPanelConfig = (ControlPanelConfig)this.config;
        }
    }

    @Override
    protected void OnReloadConfig() {
        super.OnReloadConfig();
        this.RemoveControls();
        if (this.controlPanelConfig != null) {
            String strErrorRegionId = StringHelper.Format((String)"E%1$s", (Object)this.getUniqueID());
            ArrayList controls = this.controlPanelConfig.getControls();
            int i = 0;
            while (i < controls.size()) {
                Object objControl = controls.get(i);
                SRFExControl childControl = this.CreateControl(objControl);
                if (childControl != null) {
                    ISRFExFormItem formItem;
                    FormItemConfig formItemConfig;
                    childControl.setConfig((XMLConfig)controls.get(i));
                    if (this.getControlPanelConfig().getAutoErrorRegion() && childControl instanceof ISRFExFormItem && (formItemConfig = (formItem = (ISRFExFormItem)((Object)childControl)).getFormItemConfig()) != null && StringHelper.Length((String)formItemConfig.getErrorRegionId()) == 0) {
                        formItemConfig.setErrorRegionId(strErrorRegionId);
                    }
                    this.AddControl(childControl);
                }
                ++i;
            }
        }
    }

    protected SRFExControl CreateControl(Object objControl) {
        if (objControl == null) {
            return null;
        }
        String strClassName = objControl.getClass().getName();
        if (objControl instanceof PickerExConfig) {
            PickerExConfig pickerExConfig = (PickerExConfig)((Object)objControl);
            pickerExConfig.setCompatible(true);
        }
        if (childControls.containsKey(strClassName)) {
            return (SRFExControl)ObjectHelper.Create(childControls.get(strClassName));
        }
        if (objControl instanceof UserControlConfig) {
            UserControlConfig userControlConfig = (UserControlConfig)((Object)objControl);
            UserControlMgr userControlMgr = this.getPage().getWebContext().getGlobalConfigMgr().GetUserControlMgr();
            if (userControlMgr == null) {
                return null;
            }
            UserControlItemConfig userControlItemConfig = userControlMgr.FindUserControlItemConfig(userControlConfig.getTagName());
            if (userControlItemConfig == null) {
                return null;
            }
            Object obj = ObjectHelper.Create(userControlItemConfig.getControlObject());
            if (obj == null) {
                return null;
            }
            if (obj instanceof SRFExControl) {
                return (SRFExControl)obj;
            }
            return null;
        }
        String strClass = objControl.getClass().getName();
        UserControlMgr userControlMgr = this.getPage().getWebContext().getGlobalConfigMgr().GetUserControlMgr();
        if (userControlMgr == null) {
            return null;
        }
        UserControlItemConfig userControlItemConfig = userControlMgr.FindUserControlItemConfig(strClass);
        if (userControlItemConfig == null) {
            return null;
        }
        Object obj = ObjectHelper.Create(userControlItemConfig.getControlObject());
        if (obj == null) {
            return null;
        }
        if (obj instanceof SRFExControl) {
            return (SRFExControl)obj;
        }
        return null;
    }

    @Override
    protected void OnRender(Writer writer) {
        try {
            this.PrepareBuilder();
            if (this.controlPanelBuilder == null) {
                return;
            }
            this.controlPanelBuilder.RenderBegin(writer, this);
            super.OnRender(writer);
            this.controlPanelBuilder.RenderEnd(writer, this);
        }
        catch (Exception ex) {
            log.error((Object)this, (Throwable)ex);
        }
    }

    protected void PrepareBuilder() {
        if (this.controlPanelBuilder != null) {
            return;
        }
        BaseBuilder builder = this.getPage().getWebContext().FindBuilder(BUILDER_CONTROLPANEL, this.getControlPanelConfig().getRenderMode());
        if (builder == null) {
            return;
        }
        if (builder instanceof ControlPanelBuilder) {
            this.controlPanelBuilder = (ControlPanelBuilder)builder;
        }
    }
}

