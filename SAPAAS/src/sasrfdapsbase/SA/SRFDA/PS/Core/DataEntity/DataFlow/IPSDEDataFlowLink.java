/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.DataEntity.DataFlow;

import SA.SRFDA.PS.Core.DataEntity.DataFlow.IPSDEDataFlow;
import SA.SRFDA.PS.Core.DataEntity.DataFlow.IPSDEDataFlowNode;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Data.PSDELogicLink;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u5b9e\u4f53\u6570\u636e\u6d41\u903b\u8f91\u8fde\u63a5\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3")
public interface IPSDEDataFlowLink
extends IPSModelObject {
    public static final String LINKTYPE_DATASTREAM = "DATASTREAM";
    public static final String LINKTYPE_DATASTREAM2 = "DATASTREAM2";
    public static final int LINKMODE_DATASTREAM = 11;
    public static final int LINKMODE_DATASTREAM2 = 12;

    public void init(ISRFDAGlobalHelper var1, IPSDEDataFlow var2, PSDELogicLink var3) throws Exception;

    public String getLinkType();

    public IPSDEDataFlowNode getDstPSDEDataFlowNode() throws Exception;

    public IPSDEDataFlowNode getSrcPSDEDataFlowNode() throws Exception;

    public IPSDEDataFlow getPSDEDataFlow();
}

