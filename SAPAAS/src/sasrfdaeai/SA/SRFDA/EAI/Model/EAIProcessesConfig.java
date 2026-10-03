/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLCollectionExConfig
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.EAI.Model;

import SA.SRFDA.EAI.Model.EAIBaseProcessConfig;
import SA.SRFDA.EAI.Model.EAIChainingProcessConfig;
import SA.SRFDA.EAI.Model.EAIDecideProcessConfig;
import SA.SRFDA.EAI.Model.EAIInboundProcessConfig;
import SA.SRFDA.EAI.Model.EAIMulticastingProcessConfig;
import SA.SRFDA.EAI.Model.EAIOutboundProcessConfig;
import SA.SRFDA.EAI.Model.EAIProcessConfig;
import SA.SRFramework.Base.XMLCollectionExConfig;
import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.Vector;
import org.w3c.dom.Node;

public class EAIProcessesConfig
extends XMLCollectionExConfig<EAIBaseProcessConfig> {
    public static String TAG_EAIPROCESSES = "SRFEXEAIPROCESSES";
    protected static TreeMap<String, String> childNodeMap = new TreeMap();
    private EAIBaseProcessConfig processConfig = null;

    static {
        childNodeMap.put(EAIInboundProcessConfig.TAG_EAIINBOUNDPROCESS, EAIInboundProcessConfig.class.getName());
        childNodeMap.put(EAIOutboundProcessConfig.TAG_EAIOUTBOUNDPROCESS, EAIOutboundProcessConfig.class.getName());
        childNodeMap.put(EAIDecideProcessConfig.TAG_EAIDECISION, EAIDecideProcessConfig.class.getName());
        childNodeMap.put(EAIChainingProcessConfig.TAG_EAICHAINING, EAIChainingProcessConfig.class.getName());
        childNodeMap.put(EAIMulticastingProcessConfig.TAG_EAIMULTICASTING, EAIMulticastingProcessConfig.class.getName());
        childNodeMap.put(EAIProcessConfig.TAG_EAIPROCESS, EAIProcessConfig.class.getName());
    }

    public EAIProcessesConfig(EAIBaseProcessConfig processConfig) {
        this.processConfig = processConfig;
    }

    protected boolean OnChildNodeLoaded(EAIBaseProcessConfig childNode) {
        childNode.setParentProcessConfig(this.processConfig);
        return super.OnChildNodeLoaded(childNode);
    }

    public void GetProcessInbounds(String strProcessId, Vector<XMLConfig> list) {
        Iterator iterator = this.iterator();
        while (iterator.hasNext()) {
            EAIBaseProcessConfig realProcessConfig;
            EAIBaseProcessConfig processConfig = (EAIBaseProcessConfig)((Object)iterator.next());
            if (processConfig instanceof EAIProcessConfig) {
                realProcessConfig = (EAIProcessConfig)processConfig;
                if (StringHelper.Compare((String)((EAIProcessConfig)realProcessConfig).getNext(), (String)strProcessId, (boolean)true) != 0) continue;
                list.add(realProcessConfig);
                continue;
            }
            if (processConfig instanceof EAIDecideProcessConfig) {
                realProcessConfig = (EAIDecideProcessConfig)processConfig;
                ((EAIDecideProcessConfig)realProcessConfig).getConnectionsConfig().GetProcessInbounds(strProcessId, list);
                continue;
            }
            if (processConfig instanceof EAIChainingProcessConfig) {
                realProcessConfig = (EAIChainingProcessConfig)processConfig;
                ((EAIChainingProcessConfig)realProcessConfig).getConnectionsConfig().GetProcessInbounds(strProcessId, list);
                continue;
            }
            if (!(processConfig instanceof EAIMulticastingProcessConfig)) continue;
            realProcessConfig = (EAIMulticastingProcessConfig)processConfig;
            ((EAIMulticastingProcessConfig)realProcessConfig).getConnectionsConfig().GetProcessInbounds(strProcessId, list);
        }
    }

    public EAIBaseProcessConfig FindProcessConfig(String strProcessId) {
        Iterator iterator = this.iterator();
        while (iterator.hasNext()) {
            EAIBaseProcessConfig processConfig = (EAIBaseProcessConfig)((Object)iterator.next());
            if (StringHelper.Compare((String)processConfig.getID(), (String)strProcessId, (boolean)true) != 0) continue;
            return processConfig;
        }
        return null;
    }

    public void OnLoadNode(String strName, Node xmlNode) {
        XMLConfig childNode;
        String strObject;
        if (childNodeMap.containsKey(strName) && !StringHelper.IsNullOrEmpty((String)(strObject = childNodeMap.get(strName))) && (childNode = EAIProcessesConfig.CreateChildNode((String)strObject)) != null) {
            childNode.LoadConfig(xmlNode);
            if (this.OnChildNodeLoaded((EAIBaseProcessConfig)childNode)) {
                this.add((EAIBaseProcessConfig)childNode);
                return;
            }
        }
        super.OnLoadNode(strName, xmlNode);
    }
}
