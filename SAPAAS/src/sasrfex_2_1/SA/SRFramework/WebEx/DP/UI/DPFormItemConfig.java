/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFramework.WebEx.DP.UI;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import SA.SRFramework.WebEx.DP.UI.DPBaseFormItemConfig;
import SA.SRFramework.WebEx.DP.UI.DPFormItemConfigUtility;
import SA.SRFramework.WebEx.UI.BaseControlConfig;
import SA.SRFramework.WebEx.UI.FileUploaderConfig;
import SA.SRFramework.WebEx.UI.FormControlConfig;
import SA.SRFramework.WebEx.UI.IPAddressTextBoxConfig;
import SA.SRFramework.WebEx.UI.MultiPickerConfig;
import SA.SRFramework.WebEx.UI.PictureConfig;
import SA.SRFramework.WebEx.UI.PictureUploaderConfig;
import java.util.Hashtable;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Node;

public class DPFormItemConfig
extends DPBaseFormItemConfig {
    public static final String TAG_DPFORMITEM = "SRFEXDPFORMITEM";
    public static final String TAG_USERCONTROLEX = "SRFEXUSERCONTROLEX";
    private static final Log log = LogFactory.getLog(DPFormItemConfig.class);
    protected static Hashtable<String, String> childItemMap = new Hashtable();
    protected static DPFormItemConfigUtility dpItemConfigHelper = new DPFormItemConfigUtility();

    static {
        childItemMap.put("SRFEXRAW", "SA.SRFramework.WebEx.UI.RawConfig");
        childItemMap.put("SRFEXPICKEREX", "SA.SRFramework.WebEx.UI.PickerExConfig");
        childItemMap.put("SRFEXSPANEX", "SA.SRFramework.WebEx.UI.SpanExConfig");
        childItemMap.put("SRFEXDATEPICKEREX", "SA.SRFramework.WebEx.UI.DatePickerExConfig");
        childItemMap.put("SRFEXDATEPICKER", "SA.SRFramework.WebEx.UI.DatePickerConfig");
        childItemMap.put("SRFEXLISTBOX", "SA.SRFramework.WebEx.UI.ListBoxConfig");
        childItemMap.put("SRFEXCHECKBOXLIST", "SA.SRFramework.WebEx.UI.CheckBoxListConfig");
        childItemMap.put("SRFEXCHECKBOX", "SA.SRFramework.WebEx.UI.CheckBoxConfig");
        childItemMap.put("SRFEXRADIOBUTTONLIST", "SA.SRFramework.WebEx.UI.RadioButtonListConfig");
        childItemMap.put("SRFEXPICKER", "SA.SRFramework.WebEx.UI.PickerConfig");
        childItemMap.put("SRFEXHIDDEN", "SA.SRFramework.WebEx.UI.HiddenConfig");
        childItemMap.put("SRFEXDROPDOWNLIST", "SA.SRFramework.WebEx.UI.DropDownListConfig");
        childItemMap.put("SRFEXTEXTAREA", "SA.SRFramework.WebEx.UI.TextAreaConfig");
        childItemMap.put("SRFEXTEXTBOX", "SA.SRFramework.WebEx.UI.TextBoxConfig");
        childItemMap.put("SRFEXSPAN", "SA.SRFramework.WebEx.UI.SpanConfig");
        childItemMap.put("SRFEXFORMIMAGELINK", "SA.SRFramework.WebEx.UI.FormImageLinkConfig");
        childItemMap.put("SRFEXLISTBOXPICKUP", "SA.SRFramework.WebEx.UI.ListBoxPickupConfig");
        childItemMap.put("SRFEXRAW", "SA.SRFramework.WebEx.UI.RawConfig");
        childItemMap.put("SRFEXHTMLEDITOR", "SA.SRFramework.WebEx.UI.HtmlEditorConfig");
        childItemMap.put("SRFEXHTMLEDITOREX", "SA.SRFramework.WebEx.UI.HtmlEditorExConfig");
        childItemMap.put("SRFEXUSERCONTROL", "SA.SRFramework.WebEx.UI.UserControlConfig");
        childItemMap.put("SRFEXFILEUPLOADER", FileUploaderConfig.class.getName());
        childItemMap.put("SRFEXPICTURE", PictureConfig.class.getName());
        childItemMap.put("SRFEXMULTIPICKER", MultiPickerConfig.class.getName());
        childItemMap.put("SRFEXIPADDRESSTEXTBOX", IPAddressTextBoxConfig.class.getName());
        childItemMap.put("SRFEXPICTUREUPLOADER", PictureUploaderConfig.class.getName());
    }

    public static void RegisterControl(String strTag, String strConfigName) {
        childItemMap.put(strTag, strConfigName);
    }

    public void OnLoadNode(String strName, Node xmlNode) {
        if (childItemMap.containsKey(strName = strName.toUpperCase()) && this.ctrlConfig == null) {
            BaseControlConfig itemConfig;
            String strObject = childItemMap.get(strName);
            Object objConfig = this.CreateObject(strObject);
            if (objConfig != null && objConfig instanceof BaseControlConfig && (itemConfig = (BaseControlConfig)((Object)objConfig)).LoadConfig(xmlNode)) {
                FormControlConfig formControlConfig;
                this.ctrlConfig = itemConfig;
                if (this.bSyncControlConfig && this.ctrlConfig instanceof FormControlConfig && (formControlConfig = (FormControlConfig)this.ctrlConfig).getFormItemConfig() != null) {
                    if (!formControlConfig.getFormItemConfig().getAllowEmpty()) {
                        this.setAllowEmpty(false);
                    }
                    if (StringHelper.Length((String)formControlConfig.getFormItemConfig().getName()) == 0) {
                        formControlConfig.getFormItemConfig().setName(this.getCaption());
                    }
                }
            }
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_USERCONTROLEX, (boolean)true) == 0 && this.ctrlConfig == null) {
            XMLConfig xmlConfig = new XMLConfig();
            xmlConfig.LoadConfig(xmlNode);
            String strConfig = xmlConfig.GetExtValue("CONFIG", "");
            if (!StringHelper.IsNullOrEmpty((String)strConfig)) {
                Object objConfig = ObjectHelper.Create(strConfig);
                if (objConfig == null) {
                    return;
                }
                if (objConfig instanceof BaseControlConfig) {
                    BaseControlConfig itemConfig = (BaseControlConfig)((Object)objConfig);
                    if (itemConfig.LoadConfig(xmlNode)) {
                        FormControlConfig formControlConfig;
                        this.ctrlConfig = itemConfig;
                        if (this.bSyncControlConfig && this.ctrlConfig instanceof FormControlConfig && (formControlConfig = (FormControlConfig)this.ctrlConfig).getFormItemConfig() != null) {
                            if (!formControlConfig.getFormItemConfig().getAllowEmpty()) {
                                this.setAllowEmpty(false);
                            }
                            if (StringHelper.Length((String)formControlConfig.getFormItemConfig().getName()) == 0) {
                                formControlConfig.getFormItemConfig().setName(this.getCaption());
                            }
                        }
                    }
                } else {
                    log.error((Object)StringHelper.Format((String)"[%1$s]\u6ca1\u6709\u4ece\u6307\u5b9a\u5bf9\u8c61\u7ee7\u627f", (Object)strConfig));
                }
            }
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    private Object CreateObject(String strObject) {
        return dpItemConfigHelper.CreateObject(strObject);
    }
}

