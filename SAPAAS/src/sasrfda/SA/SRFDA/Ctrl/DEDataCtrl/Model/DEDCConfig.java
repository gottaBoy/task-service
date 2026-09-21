/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Ctrl.DEDataCtrl.Model;

import SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCBaseProcessConfig;
import SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCProcessesConfig;
import SA.SRFramework.Utility.StringHelper;
import org.w3c.dom.Node;

public class DEDCConfig
extends DEDCBaseProcessConfig {
    public static String TAG_DEDCSERVICE = "SRFEXDEDCSERVICE";
    protected DEDCProcessesConfig dedcProcessesConfig = new DEDCProcessesConfig(this);

    @Override
    public void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare((String)strName, (String)DEDCProcessesConfig.TAG_DEDCPROCESSES, (boolean)true) == 0) {
            this.dedcProcessesConfig.LoadConfig(xmlNode);
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    public DEDCProcessesConfig getProcessesConfig() {
        return this.dedcProcessesConfig;
    }
}

