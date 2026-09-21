/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.CollectionXMLConfig
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.UI;

import SA.SRFramework.Base.CollectionXMLConfig;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.UI.UserConfigMgrItemConfig;
import org.w3c.dom.Node;

public class UserConfigMgr
extends CollectionXMLConfig {
    public void OnLoadNode(String strName, Node xmlNode) {
        UserConfigMgrItemConfig userConfigMgrItem;
        if (StringHelper.Compare((String)strName, (String)"SRFEXUSERCONFIGMGRITEM", (boolean)true) == 0 && (userConfigMgrItem = new UserConfigMgrItemConfig()).LoadConfig(xmlNode)) {
            this.arrayList.add(userConfigMgrItem);
        }
        super.OnLoadNode(strName, xmlNode);
    }
}

