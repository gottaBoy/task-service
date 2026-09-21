/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLCollectionExConfig
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Ctrl.DEFHelper;

import SA.SRFDA.Ctrl.DEFHelper.DEFHelperConfig;
import SA.SRFDA.Web.Utility.GlobalHelperEx;
import SA.SRFramework.Base.XMLCollectionExConfig;
import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;
import java.util.Hashtable;
import java.util.TreeMap;
import org.w3c.dom.Node;

public class DEFHelperMgr
extends XMLCollectionExConfig<DEFHelperConfig> {
    protected Hashtable<String, DEFHelperConfig> defHelperMap = new Hashtable();
    protected static TreeMap<String, String> childNodeMap = new TreeMap();
    protected GlobalHelperEx globalHelperEx = null;

    static {
        childNodeMap.put("SRFDADEFHELPER", DEFHelperConfig.class.getName());
    }

    public void setGlobalHelperEx(GlobalHelperEx globalHelperEx) {
        this.globalHelperEx = globalHelperEx;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public DEFHelperConfig FindDEFHelper(String strDEFHelperId) {
        strDEFHelperId = strDEFHelperId.toUpperCase();
        Hashtable<String, DEFHelperConfig> hashtable = this.defHelperMap;
        synchronized (hashtable) {
            return this.defHelperMap.get(strDEFHelperId);
        }
    }

    public void OnLoadNode(String strName, Node xmlNode) {
        XMLConfig childNode;
        String strObject;
        if (childNodeMap.containsKey(strName) && !StringHelper.IsNullOrEmpty((String)(strObject = childNodeMap.get(strName))) && (childNode = DEFHelperMgr.CreateChildNode((String)strObject)) != null) {
            childNode.LoadConfig(xmlNode);
            if (this.OnChildNodeLoaded((Object)((DEFHelperConfig)childNode))) {
                this.add((Object)((DEFHelperConfig)childNode));
                DEFHelperConfig defHelperConfig = (DEFHelperConfig)childNode;
                this.defHelperMap.put(defHelperConfig.getID().toUpperCase(), defHelperConfig);
                return;
            }
        }
        super.OnLoadNode(strName, xmlNode);
    }
}

