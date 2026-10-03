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
import SRFWF.Model.WFParamConfig;
import java.util.TreeMap;
import org.w3c.dom.Node;

public class WFParamsConfig
extends XMLCollectionExConfig<WFParamConfig> {
    private WFBaseProcessConfig processConfig = null;
    public static String TAG_WFPARAMS = "SRFEXWFPARAMS";
    protected static TreeMap<String, String> childNodeMap = new TreeMap();

    static {
        childNodeMap.put(WFParamConfig.TAG_WFPARAM, WFParamConfig.class.getName());
    }

    public WFParamsConfig(WFBaseProcessConfig processConfig) {
        this.processConfig = processConfig;
    }

    public void OnLoadNode(String strName, Node xmlNode) {
        XMLConfig childNode;
        String strObject;
        if (childNodeMap.containsKey(strName) && !StringHelper.IsNullOrEmpty((String)(strObject = childNodeMap.get(strName))) && (childNode = WFParamsConfig.CreateChildNode((String)strObject)) != null) {
            childNode.LoadConfig(xmlNode);
            if (this.OnChildNodeLoaded((WFParamConfig)childNode)) {
                this.add((WFParamConfig)childNode);
                return;
            }
        }
        super.OnLoadNode(strName, xmlNode);
    }
}

