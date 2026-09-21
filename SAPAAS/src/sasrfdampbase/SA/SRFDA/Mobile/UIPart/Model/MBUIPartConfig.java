/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.UI.BaseControlConfig
 */
package SA.SRFDA.Mobile.UIPart.Model;

import SA.SRFDA.Mobile.UIPart.Model.MBUIPartDSConfig;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.UI.BaseControlConfig;
import org.w3c.dom.Node;

public abstract class MBUIPartConfig
extends BaseControlConfig {
    protected MBUIPartDSConfig mbPartDSConfig = new MBUIPartDSConfig();

    public void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare((String)strName, (String)"SRFDAMBUIPARTDS", (boolean)true) == 0) {
            this.mbPartDSConfig.LoadConfig(xmlNode);
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    public MBUIPartDSConfig getDSConfig() {
        return this.mbPartDSConfig;
    }
}

