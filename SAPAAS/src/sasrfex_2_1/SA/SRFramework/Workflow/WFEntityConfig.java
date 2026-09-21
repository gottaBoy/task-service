/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.Workflow;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.Workflow.BaseWFConfig;
import SA.SRFramework.Workflow.WFParamsConfig;
import org.w3c.dom.Node;

public class WFEntityConfig
extends BaseWFConfig {
    public static final String TAG_NEXT = "NEXT";
    protected String strNext = "";
    protected WFParamsConfig paramsConfig = null;

    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_NEXT, (boolean)true) == 0) {
            this.strNext = strValue;
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare((String)strName, (String)"SRFEXWFPARAMS", (boolean)true) == 0) {
            if (this.paramsConfig == null) {
                this.paramsConfig = new WFParamsConfig();
            }
            this.paramsConfig.LoadConfig(xmlNode);
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    public String getNext() {
        return this.strNext;
    }

    public void setNext(String value) {
        this.strNext = value;
    }

    public WFParamsConfig getParams() {
        return this.paramsConfig;
    }
}

