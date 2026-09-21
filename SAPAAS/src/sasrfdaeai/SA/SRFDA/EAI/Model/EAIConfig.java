/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.EAI.Model;

import SA.SRFDA.EAI.Model.EAIBaseProcessConfig;
import SA.SRFDA.EAI.Model.EAIProcessesConfig;
import SA.SRFramework.Utility.StringHelper;
import org.w3c.dom.Node;

public class EAIConfig
extends EAIBaseProcessConfig {
    public static String TAG_EAISERVICE = "SRFEXEAISERVICE";
    protected EAIProcessesConfig eaiProcessesConfig = new EAIProcessesConfig(this);

    public void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare((String)strName, (String)EAIProcessesConfig.TAG_EAIPROCESSES, (boolean)true) == 0) {
            this.eaiProcessesConfig.LoadConfig(xmlNode);
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    public EAIProcessesConfig getProcessesConfig() {
        return this.eaiProcessesConfig;
    }
}

