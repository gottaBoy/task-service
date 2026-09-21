/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.EAI.Model;

import SA.SRFDA.EAI.Model.DBOPProcessesConfig;
import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;
import org.w3c.dom.Node;

public class DBOPPKGConfig
extends XMLConfig {
    public static String TAG_SRFDBOPPKG = "SRFDBOPPKG";
    protected DBOPProcessesConfig processesConfig = null;

    public DBOPPKGConfig() {
        this.setNodeName(TAG_SRFDBOPPKG);
        this.processesConfig = new DBOPProcessesConfig();
    }

    public DBOPProcessesConfig getProcessesConfig() {
        return this.processesConfig;
    }

    protected void OnLoadNode(String arg0, Node arg1) {
        if (StringHelper.Compare((String)arg0, (String)"SRFDBOPPROCS", (boolean)true) == 0) {
            this.processesConfig.LoadConfig(arg1);
        }
        super.OnLoadNode(arg0, arg1);
    }
}

