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
import SA.SRFramework.WebEx.UI.UserControlItemConfig;
import java.util.Hashtable;
import org.w3c.dom.Node;

public class UserControlMgr
extends CollectionXMLConfig {
    protected Hashtable hashTable = new Hashtable();

    public void OnLoadNode(String strName, Node xmlNode) {
        UserControlItemConfig userControlItemConfig;
        if (StringHelper.Compare((String)strName, (String)"SRFEXUSERCONTROLITEM", (boolean)true) == 0 && (userControlItemConfig = new UserControlItemConfig()).LoadConfig(xmlNode)) {
            this.arrayList.add(userControlItemConfig);
            if (StringHelper.IsNullOrEmpty((String)userControlItemConfig.getRenderMode())) {
                String strTagName = userControlItemConfig.getTagName().toUpperCase();
                this.hashTable.put(strTagName.toUpperCase(), userControlItemConfig);
            } else {
                String strTagName = StringHelper.Format((String)"%1$s_%2$s", (Object)userControlItemConfig.getTagName(), (Object)userControlItemConfig.getRenderMode());
                this.hashTable.put(strTagName.toUpperCase(), userControlItemConfig);
            }
        }
        super.OnLoadNode(strName, xmlNode);
    }

    public UserControlItemConfig FindUserControlItemConfig(String strTagName, String strRenderMode) {
        if (!StringHelper.IsNullOrEmpty((String)strRenderMode)) {
            strTagName = StringHelper.Format((String)"%1$s_%2$s", (Object)strTagName, (Object)strRenderMode);
        }
        return this.FindUserControlItemConfig(strTagName);
    }

    public UserControlItemConfig FindUserControlItemConfig(String strTagName) {
        if (this.hashTable.containsKey(strTagName = strTagName.toUpperCase())) {
            return (UserControlItemConfig)((Object)this.hashTable.get(strTagName));
        }
        return null;
    }

    public void RegisterUserControlItem(String strTagName, String strControlClass) {
        UserControlItemConfig userControlItemConfig = new UserControlItemConfig();
        userControlItemConfig.setControlObject(strControlClass);
        userControlItemConfig.setTagName(strTagName);
        this.arrayList.add(userControlItemConfig);
        this.hashTable.put(userControlItemConfig.getTagName().toUpperCase(), userControlItemConfig);
    }

    public void RegisterUserControlItem(String strTagName, String strRenderMode, String strControlClass) {
        UserControlItemConfig userControlItemConfig = new UserControlItemConfig();
        userControlItemConfig.setControlObject(strControlClass);
        userControlItemConfig.setTagName(strTagName);
        userControlItemConfig.setRenderMode(strRenderMode);
        this.arrayList.add(userControlItemConfig);
        if (StringHelper.IsNullOrEmpty((String)strRenderMode)) {
            this.hashTable.put(userControlItemConfig.getTagName().toUpperCase(), userControlItemConfig);
        } else {
            String strTagName2 = StringHelper.Format((String)"%1$s_%2$s", (Object)userControlItemConfig.getTagName(), (Object)userControlItemConfig.getRenderMode());
            this.hashTable.put(strTagName2.toUpperCase(), userControlItemConfig);
        }
    }
}

