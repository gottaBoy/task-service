/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.Workflow;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.Workflow.BaseWFConfig;
import SA.SRFramework.Workflow.WFDecisionConfig;
import SA.SRFramework.Workflow.WFEndConfig;
import SA.SRFramework.Workflow.WFEntityConfig;
import SA.SRFramework.Workflow.WFGroupProcessConfig;
import SA.SRFramework.Workflow.WFProcessConfig;
import SA.SRFramework.Workflow.WFStartConfig;
import java.util.ArrayList;
import org.w3c.dom.Node;

public class WFEntitiesConfig
extends BaseWFConfig {
    public static final String TAG_WFENTITIES = "SRFEXWFENTITIES";
    protected ArrayList entities = new ArrayList();
    protected WFStartConfig startConfig = null;

    public void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare((String)strName, (String)"SRFEXWFPROCESS", (boolean)true) == 0) {
            WFProcessConfig processConfig = new WFProcessConfig();
            if (processConfig.LoadConfig(xmlNode)) {
                this.entities.add(processConfig);
            }
            return;
        }
        if (StringHelper.Compare((String)strName, (String)"SRFEXWFDECISION", (boolean)true) == 0) {
            WFDecisionConfig decisionConfig = new WFDecisionConfig();
            if (decisionConfig.LoadConfig(xmlNode)) {
                this.entities.add(decisionConfig);
            }
            return;
        }
        if (StringHelper.Compare((String)strName, (String)"SRFEXWFGROUPPROCESS", (boolean)true) == 0) {
            WFGroupProcessConfig groupProcessConfig = new WFGroupProcessConfig();
            if (groupProcessConfig.LoadConfig(xmlNode)) {
                this.entities.add(groupProcessConfig);
            }
            return;
        }
        if (StringHelper.Compare((String)strName, (String)"SRFEXWFSTART", (boolean)true) == 0) {
            this.startConfig = null;
            this.startConfig = new WFStartConfig();
            if (!this.startConfig.LoadConfig(xmlNode)) {
                this.startConfig = null;
            }
            return;
        }
        if (StringHelper.Compare((String)strName, (String)"SRFEXWFEND", (boolean)true) == 0) {
            WFEndConfig sendConfig = new WFEndConfig();
            if (sendConfig.LoadConfig(xmlNode)) {
                this.entities.add(sendConfig);
            }
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    public WFStartConfig getStartConfig() {
        return this.startConfig;
    }

    public WFEntityConfig FindEntityConfig(String strId) {
        int nCount = this.entities.size();
        int i = 0;
        while (i < nCount) {
            WFEntityConfig entityConfig = (WFEntityConfig)((Object)this.entities.get(i));
            if (StringHelper.Compare((String)entityConfig.getID(), (String)strId, (boolean)true) == 0) {
                return entityConfig;
            }
            ++i;
        }
        return null;
    }
}

