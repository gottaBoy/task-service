/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.DataEntity.DataFlow;

import SA.SRFDA.PS.Core.DataEntity.DataFlow.IPSDEDataFlow;
import SA.SRFDA.PS.Core.DataEntity.DataFlow.IPSDEDataFlowFilterCondContainer;
import SA.SRFDA.PS.Core.DataEntity.DataFlow.IPSDEDataFlowLink;
import SA.SRFDA.PS.Core.DataEntity.DataFlow.IPSDEDataFlowNodeFilter;
import SA.SRFDA.PS.Core.DataEntity.DataFlow.IPSDEDataFlowNodeParam;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Res.IPSSysSFPluginSupportable;
import SA.SRFDA.PS.Data.PSDELogicNode;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;
import java.util.Properties;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u6570\u636e\u6d41\u903b\u8f91\u8282\u70b9\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typefield="nodeType", implement="PSDEDataFlowNodeImpl")
@PSModelPFIgnoreMeta
public interface IPSDEDataFlowNode
extends IPSModelObject,
IPSSysSFPluginSupportable,
IPSDEDataFlowFilterCondContainer {
    public static final String NODETYPE_DFDEACTIONSINK = "DFDEACTIONSINK";
    public static final String NODETYPE_DFDELOGICSINK = "DFDELOGICSINK";
    public static final String NODETYPE_DFDEDATASETSOURCE = "DFDEDATASETSOURCE";
    public static final String NODETYPE_DFJOINPROCESS = "DFJOINPROCESS";
    public static final String NODETYPE_DFMERGEPROCESS = "DFMERGEPROCESS";
    public static final String NODETYPE_DFPREPAREPROCESS = "DFPREPAREPROCESS";
    public static final String NODETYPE_DFAGGREGATEPROCESS = "DFAGGREGATEPROCESS";
    public static final String NODETYPE_DFSORTPROCESS = "DFSORTROCESS";
    public static final String NODETYPE_DFSYSDATASYNCAGENTSOURCE = "DFSYSDATASYNCAGENTSOURCE";
    public static final String NODETYPE_DFSYSDATASYNCAGENTSINK = "DFSYSDATASYNCAGENTSINK";
    public static final String NODETYPE_DFSYSDBSCHEMESOURCE = "DFSYSDBSCHEMESOURCE";
    public static final String NODETYPE_DFSYSDBSCHEMESINK = "DFSYSDBSCHEMESINK";
    public static final String NODETYPE_DFSYSBDSCHEMESOURCE = "DFSYSBDSCHEMESOURCE";
    public static final String NODETYPE_DFSYSBDSCHEMESINK = "DFSYSBDSCHEMESINK";
    public static final String NODETYPE_DFSYSRESOURCESOURCE = "DFSYSRESOURCESOURCE";
    public static final String NODETYPE_DFSYSRESOURCESINK = "DFSYSRESOURCESINK";
    public static final String NODETYPE_DFSUBSYSSERVICEAPISOURCE = "DFSUBSYSSERVICEAPISOURCE";
    public static final String NODETYPE_DFSUBSYSSERVICEAPISINK = "DFSUBSYSSERVICEAPISINK";
    public static final String NODETYPE_DFDEDATAFLOWSINK = "DFDEDATAFLOWSINK";
    public static final String NODETYPE_DFPREDEFINEDSOURCE = "DFPREDEFINEDSOURCE";
    public static final String NODETYPE_DFDEDATASYNCSINK = "DFDEDATASYNCSINK";

    public void init(ISRFDAGlobalHelper var1, IPSDEDataFlow var2, PSDELogicNode var3) throws Exception;

    public String getNodeType();

    @Override
    public String getCodeName();

    public int getWidth();

    public int getHeight();

    public Iterator<? extends IPSDEDataFlowLink> getPSDEDataFlowLinks();

    public Iterator<? extends IPSDEDataFlowNodeParam> getPSDEDataFlowNodeParams();

    public IPSDEDataFlow getPSDEDataFlow();

    public int getLeftPos();

    public int getTopPos();

    public IPSDEDataFlowNodeFilter getPSDEDataFlowNodeFilter();

    public Properties getNodeParams();
}

