/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFramework.WebEx.DP;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.Builder.BaseBuilder;
import SA.SRFramework.WebEx.DP.DPEventCodeParser;
import SA.SRFramework.WebEx.DP.DPExBuilder;
import SA.SRFramework.WebEx.DP.IDPUserItem;
import SA.SRFramework.WebEx.DP.UI.DPBaseFormItemConfig;
import SA.SRFramework.WebEx.DP.UI.DPConfig;
import SA.SRFramework.WebEx.DP.UI.DPDataGridItemConfig;
import SA.SRFramework.WebEx.DP.UI.DPEventConfig;
import SA.SRFramework.WebEx.DP.UI.DPRawItemConfig;
import SA.SRFramework.WebEx.ISRFExFormItem;
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
import SA.SRFramework.WebEx.SRFExIPAddressTextBox;
import SA.SRFramework.WebEx.SRFExListBox;
import SA.SRFramework.WebEx.SRFExListBoxPickup;
import SA.SRFramework.WebEx.SRFExMultiPicker;
import SA.SRFramework.WebEx.SRFExPage;
import SA.SRFramework.WebEx.SRFExPicker;
import SA.SRFramework.WebEx.SRFExPickerEx;
import SA.SRFramework.WebEx.SRFExPicture;
import SA.SRFramework.WebEx.SRFExPictureUploader;
import SA.SRFramework.WebEx.SRFExRadioButtonList;
import SA.SRFramework.WebEx.SRFExRaw;
import SA.SRFramework.WebEx.SRFExSpan;
import SA.SRFramework.WebEx.SRFExTextBox;
import SA.SRFramework.WebEx.UI.BaseControlConfig;
import SA.SRFramework.WebEx.UI.CheckBoxConfig;
import SA.SRFramework.WebEx.UI.CheckBoxListConfig;
import SA.SRFramework.WebEx.UI.DatePickerConfig;
import SA.SRFramework.WebEx.UI.DatePickerExConfig;
import SA.SRFramework.WebEx.UI.DropDownListConfig;
import SA.SRFramework.WebEx.UI.FileUploaderConfig;
import SA.SRFramework.WebEx.UI.FormImageLinkConfig;
import SA.SRFramework.WebEx.UI.FormItemConfig;
import SA.SRFramework.WebEx.UI.HiddenConfig;
import SA.SRFramework.WebEx.UI.HtmlEditorConfig;
import SA.SRFramework.WebEx.UI.HtmlEditorExConfig;
import SA.SRFramework.WebEx.UI.IPAddressTextBoxConfig;
import SA.SRFramework.WebEx.UI.ListBoxConfig;
import SA.SRFramework.WebEx.UI.ListBoxPickupConfig;
import SA.SRFramework.WebEx.UI.MultiPickerConfig;
import SA.SRFramework.WebEx.UI.PickerConfig;
import SA.SRFramework.WebEx.UI.PickerExConfig;
import SA.SRFramework.WebEx.UI.PictureConfig;
import SA.SRFramework.WebEx.UI.PictureUploaderConfig;
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
import java.util.Hashtable;
import java.util.Iterator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SRFExDPEx
extends SRFExControl {
    protected DPConfig dpConfig = null;
    private static final Log log = LogFactory.getLog(SRFExDPEx.class);
    public static String BUILDER_DPEX = "DPEX";
    private static Hashtable<String, String> childControls = new Hashtable();

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
        childControls.put(MultiPickerConfig.class.getName(), SRFExMultiPicker.class.getName());
        childControls.put(IPAddressTextBoxConfig.class.getName(), SRFExIPAddressTextBox.class.getName());
        childControls.put(PictureUploaderConfig.class.getName(), SRFExPictureUploader.class.getName());
    }

    public static void RegisterControl(String strConfigName, String strControlName) {
        childControls.put(strConfigName, strControlName);
    }

    public DPConfig getDPConfig() {
        return this.dpConfig;
    }

    @Override
    protected void OnSetConfig() {
        super.OnSetConfig();
        this.dpConfig = null;
        if (this.config != null && this.config instanceof DPConfig) {
            this.dpConfig = (DPConfig)this.config;
        }
    }

    @Override
    protected void OnReloadConfig() {
        super.OnReloadConfig();
        this.RemoveControls();
        if (this.dpConfig != null) {
            ArrayList<Object> ctrlList;
            if (this.dpConfig.getDPHiddenGroupConfig() != null) {
                ctrlList = this.dpConfig.getDPHiddenGroupConfig().getHiddenConfigs();
                for (HiddenConfig hiddenConfig : ctrlList) {
                    SRFExControl childControl = this.CreateControl((Object)hiddenConfig);
                    if (childControl == null) continue;
                    childControl.setConfig(hiddenConfig);
                    this.AddControl(childControl);
                }
            }
            ctrlList = new ArrayList();
            this.dpConfig.GetFormCtrlConfig(ctrlList);
            int n = ctrlList.size();
            int i = 0;
            while (i < n) {
                Object objControl = ctrlList.get(i);
                SRFExControl childControl = null;
                if (objControl instanceof DPBaseFormItemConfig) {
                    DPBaseFormItemConfig dpFormItemConfig = null;
                    dpFormItemConfig = (DPBaseFormItemConfig)((Object)objControl);
                    if (dpFormItemConfig != null && dpFormItemConfig.getCtrlConfig() != null && (childControl = this.CreateControl((Object)dpFormItemConfig.getCtrlConfig())) != null) {
                        ISRFExFormItem formItem;
                        FormItemConfig formItemConfig;
                        childControl.setConfig(dpFormItemConfig.getCtrlConfig());
                        this.AddControl(childControl);
                        if (dpFormItemConfig.getAutoErrorRegion() && childControl instanceof ISRFExFormItem && (formItemConfig = (formItem = (ISRFExFormItem)((Object)childControl)).getFormItemConfig()) != null && StringHelper.Length((String)formItemConfig.getErrorRegionId()) == 0) {
                            formItemConfig.setErrorRegionId(StringHelper.Format((String)"E%1$s", (Object)childControl.getUniqueID()));
                        }
                    }
                } else if (objControl instanceof DPRawItemConfig) {
                    DPRawItemConfig rawItemConfig = (DPRawItemConfig)((Object)objControl);
                    String strUserObject = rawItemConfig.getCustom();
                    if (!StringHelper.IsNullOrEmpty((String)strUserObject)) {
                        Object obj = ObjectHelper.Create(strUserObject);
                        if (obj == null) {
                            log.error((Object)StringHelper.Format((String)"\u5efa\u7acb\u81ea\u5b9a\u4e49\u5bf9\u8c61[%1$s]\u5931\u8d25", (Object)strUserObject));
                        } else if (!(obj instanceof IDPUserItem)) {
                            log.error((Object)StringHelper.Format((String)"\u81ea\u5b9a\u4e49\u5bf9\u8c61[%1$s]\u6ca1\u6709\u5b9e\u73b0\u63a5\u53e3[IDPUserItem]", (Object)strUserObject));
                        } else {
                            IDPUserItem iDPUserItem = (IDPUserItem)obj;
                            childControl = iDPUserItem.CreateControl(this, rawItemConfig);
                            if (childControl == null) {
                                log.error((Object)StringHelper.Format((String)"\u81ea\u5b9a\u4e49\u5bf9\u8c61[%1$s]\u521b\u5efa\u5bf9\u8c61\u5931\u8d25", (Object)strUserObject));
                            } else {
                                this.AddControl(childControl);
                            }
                        }
                    }
                } else if (objControl instanceof DPDataGridItemConfig) {
                    DPDataGridItemConfig dpDataGridItemConfig = (DPDataGridItemConfig)((Object)objControl);
                    childControl = this.CreateControl((Object)dpDataGridItemConfig.getDPDataGridConfig());
                    if (childControl != null) {
                        childControl.setConfig(dpDataGridItemConfig.getDPDataGridConfig());
                        childControl.setID(dpDataGridItemConfig.getDataGridId());
                        this.AddControl(childControl);
                    }
                } else {
                    childControl = this.CreateControl(objControl);
                    if (childControl != null) {
                        childControl.setConfig((XMLConfig)objControl);
                        this.AddControl(childControl);
                    }
                }
                ++i;
            }
        }
    }

    protected SRFExControl CreateControl(Object objControl) {
        return SRFExDPEx.CreateControl(objControl, this.getPage());
    }

    protected static SRFExControl CreateControl(Object objControl, SRFExPage page) {
        Object obj;
        UserControlItemConfig userControlItemConfig;
        UserControlMgr userControlMgr;
        UserControlMgr userControlMgr2;
        UserControlItemConfig userControlItemConfig2;
        BaseControlConfig baseControlConfig;
        String strRenderMode;
        if (objControl == null) {
            return null;
        }
        String strClassName = objControl.getClass().getName();
        if (objControl instanceof PickerExConfig) {
            PickerExConfig pickerExConfig = (PickerExConfig)((Object)objControl);
            pickerExConfig.setCompatible(false);
        }
        if (objControl instanceof BaseControlConfig && !StringHelper.IsNullOrEmpty((String)(strRenderMode = (baseControlConfig = (BaseControlConfig)((Object)objControl)).getRenderMode())) && (userControlItemConfig2 = (userControlMgr2 = page.getWebContext().getGlobalConfigMgr().GetUserControlMgr()).FindUserControlItemConfig(((Object)((Object)baseControlConfig)).getClass().getName(), strRenderMode)) != null) {
            Object obj2 = ObjectHelper.Create(userControlItemConfig2.getControlObject());
            if (obj2 == null) {
                log.debug((Object)StringHelper.Format((String)"[%1$s]\u7c7b\u578b\u4e0d\u6b63\u786e\uff0c\u5ffd\u7565\u914d\u7f6e", (Object)userControlItemConfig2.getControlObject()));
            }
            if (obj2 instanceof SRFExControl) {
                return (SRFExControl)obj2;
            }
        }
        if (childControls.containsKey(strClassName)) {
            if (StringHelper.Compare((String)(strClassName = childControls.get(strClassName)), (String)"SA.SRFramework.WebEx.SRFExTextBox", (boolean)false) == 0) {
                return new SRFExTextBox();
            }
            if (StringHelper.Compare((String)strClassName, (String)"SA.SRFramework.WebEx.SRFExListBoxPickup", (boolean)false) == 0) {
                return new SRFExListBoxPickup();
            }
            if (StringHelper.Compare((String)strClassName, (String)"SA.SRFramework.WebEx.SRFExRaw", (boolean)false) == 0) {
                return new SRFExRaw();
            }
            if (StringHelper.Compare((String)strClassName, (String)"SA.SRFramework.WebEx.SRFExPickerEx", (boolean)false) == 0) {
                return new SRFExPickerEx();
            }
            if (StringHelper.Compare((String)strClassName, (String)"SA.SRFramework.WebEx.SRFExDatePickerEx", (boolean)false) == 0) {
                return new SRFExDatePickerEx();
            }
            if (StringHelper.Compare((String)strClassName, (String)"SA.SRFramework.WebEx.SRFExDatePicker", (boolean)false) == 0) {
                return new SRFExDatePicker();
            }
            if (StringHelper.Compare((String)strClassName, (String)"SA.SRFramework.WebEx.SRFExListBox", (boolean)false) == 0) {
                return new SRFExListBox();
            }
            if (StringHelper.Compare((String)strClassName, (String)"SA.SRFramework.WebEx.SRFExCheckBoxList", (boolean)false) == 0) {
                return new SRFExCheckBoxList();
            }
            if (StringHelper.Compare((String)strClassName, (String)"SA.SRFramework.WebEx.SRFExCheckBox", (boolean)false) == 0) {
                return new SRFExCheckBox();
            }
            if (StringHelper.Compare((String)strClassName, (String)"SA.SRFramework.WebEx.SRFExRadioButtonList", (boolean)false) == 0) {
                return new SRFExRadioButtonList();
            }
            if (StringHelper.Compare((String)strClassName, (String)"SA.SRFramework.WebEx.SRFExPicker", (boolean)false) == 0) {
                return new SRFExPicker();
            }
            if (StringHelper.Compare((String)strClassName, (String)"SA.SRFramework.WebEx.SRFExDropDownList", (boolean)false) == 0) {
                return new SRFExDropDownList();
            }
            if (StringHelper.Compare((String)strClassName, (String)"SA.SRFramework.WebEx.SRFExSpan", (boolean)false) == 0) {
                return new SRFExSpan();
            }
            if (StringHelper.Compare((String)strClassName, (String)"SA.SRFramework.WebEx.SRFExHidden", (boolean)false) == 0) {
                return new SRFExHidden();
            }
            if (StringHelper.Compare((String)strClassName, (String)"SA.SRFramework.WebEx.SRFExFormImageLink", (boolean)false) == 0) {
                return new SRFExFormImageLink();
            }
            if (StringHelper.Compare((String)strClassName, (String)"SA.SRFramework.WebEx.SRFExHtmlEditor", (boolean)false) == 0) {
                return new SRFExHtmlEditor();
            }
            if (StringHelper.Compare((String)strClassName, (String)"SA.SRFramework.WebEx.SRFExHtmlEditorEx", (boolean)false) == 0) {
                return new SRFExHtmlEditorEx();
            }
            if (StringHelper.Compare((String)strClassName, (String)"SA.SRFramework.WebEx.SRFExFileUploader", (boolean)false) == 0) {
                return new SRFExFileUploader();
            }
            if (StringHelper.Compare((String)strClassName, (String)"SA.SRFramework.WebEx.SRFExPicture", (boolean)false) == 0) {
                return new SRFExPicture();
            }
            if (StringHelper.Compare((String)strClassName, (String)"SA.SRFramework.WebEx.SRFExMultiPicker", (boolean)false) == 0) {
                return new SRFExMultiPicker();
            }
            if (StringHelper.Compare((String)strClassName, (String)"SA.SRFramework.WebEx.SRFExIPAddressTextBox", (boolean)false) == 0) {
                return new SRFExIPAddressTextBox();
            }
            if (StringHelper.Compare((String)strClassName, (String)"SA.SRFramework.WebEx.SRFExPictureUploader", (boolean)false) == 0) {
                return new SRFExPictureUploader();
            }
            return (SRFExControl)ObjectHelper.Create(strClassName);
        }
        if (objControl instanceof UserControlConfig) {
            UserControlConfig userControlConfig = (UserControlConfig)((Object)objControl);
            userControlMgr = page.getWebContext().getGlobalConfigMgr().GetUserControlMgr();
            if (userControlMgr == null) {
                return null;
            }
            userControlItemConfig = userControlMgr.FindUserControlItemConfig(userControlConfig.getTagName());
            if (userControlItemConfig == null) {
                log.debug((Object)StringHelper.Format((String)"\u65e0\u6cd5\u627e\u5230[%1$s]\u5bf9\u5e94\u7684\u7528\u6237\u63a7\u4ef6\u914d\u7f6e", (Object)userControlConfig.getTagName()));
                return null;
            }
            obj = ObjectHelper.Create(userControlItemConfig.getControlObject());
            if (obj == null) {
                return null;
            }
            if (obj instanceof SRFExControl) {
                return (SRFExControl)obj;
            }
            log.debug((Object)StringHelper.Format((String)"[%1$s]\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)userControlItemConfig.getControlObject()));
            return null;
        }
        String strClass = objControl.getClass().getName();
        userControlMgr = page.getWebContext().getGlobalConfigMgr().GetUserControlMgr();
        if (userControlMgr == null) {
            return null;
        }
        userControlItemConfig = userControlMgr.FindUserControlItemConfig(strClass);
        if (userControlItemConfig == null) {
            log.debug((Object)StringHelper.Format((String)"\u65e0\u6cd5\u627e\u5230[%1$s]\u5bf9\u5e94\u7684\u7528\u6237\u63a7\u4ef6\u914d\u7f6e", (Object)strClass));
            return null;
        }
        obj = ObjectHelper.Create(userControlItemConfig.getControlObject());
        if (obj == null) {
            return null;
        }
        if (obj instanceof SRFExControl) {
            return (SRFExControl)obj;
        }
        log.debug((Object)StringHelper.Format((String)"[%1$s]\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)userControlItemConfig.getControlObject()));
        return null;
    }

    @Override
    protected void OnRender(Writer writer) {
        DPExBuilder dpExBuilder = null;
        try {
            dpExBuilder = this.PrepareBuilder();
            if (dpExBuilder == null) {
                return;
            }
            try {
                this.getPage().DebugProcessTime("SRFExDPEx Render Start");
                dpExBuilder.Render(writer, this);
                this.getPage().DebugProcessTime("SRFExDPEx Render End");
                if (this.dpConfig.getDPEventsConfig() != null) {
                    Iterator iterator = this.dpConfig.getDPEventsConfig().iterator();
                    while (iterator.hasNext()) {
                        DPEventConfig dpEventConfig = (DPEventConfig)((Object)iterator.next());
                        String strFormItem = dpEventConfig.getFormItem();
                        String strEvent = dpEventConfig.getEvent();
                        String strCode = dpEventConfig.getNodeValue();
                        strCode = DPEventCodeParser.Parse(strCode, this.getPage());
                        if (StringHelper.IsNullOrEmpty((String)strFormItem)) continue;
                        SRFExControl control = this.getPage().getDefaultForm().FindControl(strFormItem);
                        if (control == null) {
                            this.getPage().PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u5b9a\u4f4d\u6307\u5b9a[%1$s]\u7684\u5bf9\u8c61", (Object)strFormItem));
                            continue;
                        }
                        StringBuilderEx script = new StringBuilderEx();
                        script.Append("Ext.EventManager.on('%1$s','%2$s',function(){%3$s});", control.getUniqueID(), strEvent, strCode);
                        this.getPage().RegisterOnReadyScript(3, script.toString());
                    }
                }
            }
            catch (Exception ex) {
                log.error((Object)this, (Throwable)ex);
            }
        }
        finally {
            if (dpExBuilder != null) {
                this.getPage().getWebContext().getCurBuilderConfig().ReleaseBuilder(BUILDER_DPEX, this.getDPConfig().getRenderMode(), dpExBuilder);
            }
        }
    }

    protected DPExBuilder PrepareBuilder() {
        BaseBuilder builder = this.getPage().getWebContext().getCurBuilderConfig().GetBuilderFromPool(BUILDER_DPEX, this.getDPConfig().getRenderMode());
        if (builder == null) {
            log.error((Object)StringHelper.Format((String)"\u52a8\u6001\u9762\u677f\u7ed8\u5236\u5668\u65e0\u6548"));
            return null;
        }
        if (builder instanceof DPExBuilder) {
            return (DPExBuilder)builder;
        }
        return null;
    }
}

