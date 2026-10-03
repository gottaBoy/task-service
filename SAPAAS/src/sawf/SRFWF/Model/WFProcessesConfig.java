/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLCollectionExConfig
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 */
package SRFWF.Model;

import SA.SRFramework.Base.XMLCollectionExConfig;
import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;
import SRFWF.Model.WFBaseProcessConfig;
import SRFWF.Model.WFDecideProcessConfig;
import SRFWF.Model.WFEmbedWorkflowConfig;
import SRFWF.Model.WFEndProcessConfig;
import SRFWF.Model.WFGroupProcessConfig;
import SRFWF.Model.WFHopProcessConfig;
import SRFWF.Model.WFInteractiveProcessConfig;
import SRFWF.Model.WFParallelSubWFConfig;
import SRFWF.Model.WFProcessConfig;
import SRFWF.Model.WFStartProcessConfig;
import java.util.TreeMap;
import org.w3c.dom.Node;

public class WFProcessesConfig
extends XMLCollectionExConfig<WFBaseProcessConfig> {
    public static String TAG_WFPROCESSES = "SRFEXWFPROCESSES";
    protected static TreeMap<String, String> childNodeMap = new TreeMap();
    private WFBaseProcessConfig processConfig = null;

    static {
        childNodeMap.put(WFStartProcessConfig.TAG_WFSTART, WFStartProcessConfig.class.getName());
        childNodeMap.put("SRFEXWFINTERACTIVE", WFInteractiveProcessConfig.class.getName());
        childNodeMap.put(WFEndProcessConfig.TAG_WFEND, WFEndProcessConfig.class.getName());
        childNodeMap.put(WFDecideProcessConfig.TAG_WFDECISION, WFDecideProcessConfig.class.getName());
        childNodeMap.put(WFProcessConfig.TAG_WFPROCESS, WFProcessConfig.class.getName());
        childNodeMap.put("SRFEXWFPPROCESS", WFProcessConfig.class.getName());
        childNodeMap.put(WFGroupProcessConfig.TAG_WFGROUPPROCESS, WFGroupProcessConfig.class.getName());
        childNodeMap.put(WFHopProcessConfig.TAG_WFHOP, WFHopProcessConfig.class.getName());
        childNodeMap.put("SRFEXWFEMBEDWORKFLOW", WFEmbedWorkflowConfig.class.getName());
        childNodeMap.put("SRFEXWFPARALLELSUBWF", WFParallelSubWFConfig.class.getName());
    }

    public WFProcessesConfig(WFBaseProcessConfig processConfig) {
        this.processConfig = processConfig;
    }

    protected boolean OnChildNodeLoaded(WFBaseProcessConfig childNode) {
        childNode.setParentProcessConfig(this.processConfig);
        return super.OnChildNodeLoaded(childNode);
    }

    public void OnLoadNode(String strName, Node xmlNode) {
        XMLConfig childNode;
        String strObject;
        if (childNodeMap.containsKey(strName) && !StringHelper.IsNullOrEmpty((String)(strObject = childNodeMap.get(strName))) && (childNode = WFProcessesConfig.CreateChildNode((String)strObject)) != null) {
            childNode.LoadConfig(xmlNode);
            if (this.OnChildNodeLoaded((WFBaseProcessConfig)childNode)) {
                this.add((WFBaseProcessConfig)childNode);
                return;
            }
        }
        super.OnLoadNode(strName, xmlNode);
    }
}

