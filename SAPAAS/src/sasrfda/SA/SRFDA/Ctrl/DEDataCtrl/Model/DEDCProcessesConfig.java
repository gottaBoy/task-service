/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLCollectionExConfig
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Ctrl.DEDataCtrl.Model;

import SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCBaseProcessConfig;
import SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCChainingProcessConfig;
import SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCDecideProcessConfig;
import SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCEndProcessConfig;
import SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCHopProcessConfig;
import SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCMulticastingProcessConfig;
import SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCProcessConfig;
import SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCStartProcessConfig;
import SA.SRFramework.Base.XMLCollectionExConfig;
import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.TreeMap;
import org.w3c.dom.Node;

public class DEDCProcessesConfig
extends XMLCollectionExConfig<DEDCBaseProcessConfig> {
    public static String TAG_DEDCPROCESSES = "SRFEXDEDCPROCESSES";
    protected static TreeMap<String, String> childNodeMap = new TreeMap();
    private DEDCBaseProcessConfig processConfig = null;
    private DEDCStartProcessConfig startProcessConfig = null;
    private Hashtable<String, DEDCBaseProcessConfig> processConfigMap = new Hashtable();

    static {
        childNodeMap.put(DEDCStartProcessConfig.TAG_DEDCSTARTPROCESS, DEDCStartProcessConfig.class.getName());
        childNodeMap.put(DEDCEndProcessConfig.TAG_DEDCENDPROCESS, DEDCEndProcessConfig.class.getName());
        childNodeMap.put(DEDCDecideProcessConfig.TAG_DEDCDECISION, DEDCDecideProcessConfig.class.getName());
        childNodeMap.put(DEDCChainingProcessConfig.TAG_DEDCCHAINING, DEDCChainingProcessConfig.class.getName());
        childNodeMap.put(DEDCMulticastingProcessConfig.TAG_DEDCMULTICASTING, DEDCMulticastingProcessConfig.class.getName());
        childNodeMap.put(DEDCProcessConfig.TAG_DEDCPROCESS, DEDCProcessConfig.class.getName());
        childNodeMap.put(DEDCHopProcessConfig.TAG_DEDCHOP, DEDCHopProcessConfig.class.getName());
    }

    public DEDCProcessesConfig(DEDCBaseProcessConfig processConfig) {
        this.processConfig = processConfig;
    }

    protected boolean OnChildNodeLoaded(DEDCBaseProcessConfig childNode) {
        childNode.setParentProcessConfig(this.processConfig);
        return super.OnChildNodeLoaded(childNode);
    }

    public void OnLoadNode(String strName, Node xmlNode) {
        XMLConfig childNode;
        String strObject;
        if (childNodeMap.containsKey(strName) && !StringHelper.IsNullOrEmpty((String)(strObject = childNodeMap.get(strName))) && (childNode = DEDCProcessesConfig.CreateChildNode((String)strObject)) != null) {
            childNode.LoadConfig(xmlNode);
            if (this.OnChildNodeLoaded((DEDCBaseProcessConfig)childNode)) {
                this.add((DEDCBaseProcessConfig)childNode);
                return;
            }
        }
        super.OnLoadNode(strName, xmlNode);
    }

    public DEDCBaseProcessConfig FindProcessConfig(String strProcessId) {
        return this.processConfigMap.get(strProcessId);
    }

    public DEDCStartProcessConfig GetStartProcessConfig() {
        return this.startProcessConfig;
    }

    protected boolean OnLoadConfig() {
        boolean bRet = super.OnLoadConfig();
        if (!bRet) {
            return bRet;
        }
        Iterator iterator = this.iterator();
        while (iterator.hasNext()) {
            DEDCBaseProcessConfig processConfig = (DEDCBaseProcessConfig)((Object)iterator.next());
            if (processConfig instanceof DEDCStartProcessConfig) {
                this.startProcessConfig = (DEDCStartProcessConfig)processConfig;
                continue;
            }
            this.processConfigMap.put(processConfig.getID(), processConfig);
        }
        return true;
    }
}
