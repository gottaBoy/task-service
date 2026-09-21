/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.Workflow;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.Workflow.BaseWFConfig;
import SA.SRFramework.Workflow.WFParamConfig;
import java.util.ArrayList;
import org.w3c.dom.Node;

public class WFParamsConfig
extends BaseWFConfig {
    public static final String TAG_WFPARAMS = "SRFEXWFPARAMS";
    protected ArrayList params = new ArrayList();

    public void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare((String)strName, (String)"SRFEXWFPARAM", (boolean)true) == 0) {
            WFParamConfig paramConfig = new WFParamConfig();
            if (paramConfig.LoadConfig(xmlNode)) {
                this.params.add(paramConfig);
            }
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    public ArrayList getList() {
        return this.params;
    }
}

