/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.UI;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.UI.BaseControlConfig;
import SA.SRFramework.WebEx.UI.FormItemConfig;
import org.w3c.dom.Node;

public abstract class FormControlConfig
extends BaseControlConfig {
    protected FormItemConfig formItemConfig = null;

    public void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare((String)strName, (String)"SRFEXFORMITEM", (boolean)true) == 0) {
            if (this.formItemConfig == null) {
                this.formItemConfig = new FormItemConfig();
                this.formItemConfig.setControlConfig(this);
            }
            this.formItemConfig.LoadConfig(xmlNode);
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    public FormItemConfig getFormItemConfig() {
        return this.formItemConfig;
    }

    public void setFormItemConfig(FormItemConfig formItemConfig) {
        this.formItemConfig = formItemConfig;
    }

    public void InitFormItemConfig() {
        if (this.formItemConfig == null) {
            this.formItemConfig = new FormItemConfig();
            this.formItemConfig.setControlConfig(this);
        }
    }
}

