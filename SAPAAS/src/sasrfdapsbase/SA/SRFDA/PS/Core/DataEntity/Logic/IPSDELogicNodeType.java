/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.PS.Core.DataEntity.DataFlow.IPSDEDataFlowNode;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicNode;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEMSLogicNode;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEUILogicNode;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSDELogicNode;
import SA.SRFDA.PS.Data.PSDELogicNodeType;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelIgnoreMeta
public interface IPSDELogicNodeType
extends IPSObject {
    public void init(ISRFDAGlobalHelper var1, PSDELogicNodeType var2) throws Exception;

    public IPSDELogicNode createPSDELogicNode(PSDELogicNode var1) throws Exception;

    public IPSDEUILogicNode createPSDEUILogicNode(PSDELogicNode var1) throws Exception;

    public IPSDEMSLogicNode createPSDEMSLogicNode(PSDELogicNode var1) throws Exception;

    public IPSDEDataFlowNode createPSDEDataFlowNode(PSDELogicNode var1) throws Exception;

    public int getLogicHolder();
}

