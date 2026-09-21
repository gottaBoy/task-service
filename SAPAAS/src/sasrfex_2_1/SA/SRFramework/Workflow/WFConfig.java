/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.Workflow;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.Workflow.BaseWFConfig;
import SA.SRFramework.Workflow.WFEntitiesConfig;
import org.w3c.dom.Node;

public class WFConfig
extends BaseWFConfig {
    public static final String TAG_WORKFLOW = "SRFEXWORKFLOW";
    protected WFEntitiesConfig entitiesConfig = new WFEntitiesConfig();

    public void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare((String)strName, (String)"SRFEXWFENTITIES", (boolean)true) == 0) {
            this.entitiesConfig.LoadConfig(xmlNode);
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    public WFEntitiesConfig getEntitiesConfig() {
        return this.entitiesConfig;
    }
}

