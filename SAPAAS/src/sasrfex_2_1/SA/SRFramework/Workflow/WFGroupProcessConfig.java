/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.Workflow;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.Workflow.WFProcessConfig;
import java.util.ArrayList;
import org.w3c.dom.Node;

public class WFGroupProcessConfig
extends WFProcessConfig {
    public static final String TAG_WFGROUPPROCESS = "SRFEXWFGROUPPROCESS";
    protected ArrayList entities = new ArrayList();

    @Override
    public void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare((String)strName, (String)TAG_WFGROUPPROCESS, (boolean)true) == 0) {
            WFProcessConfig processConfig = new WFProcessConfig();
            if (processConfig.LoadConfig(xmlNode)) {
                this.entities.add(processConfig);
            }
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    public ArrayList getChildList() {
        return this.entities;
    }
}

