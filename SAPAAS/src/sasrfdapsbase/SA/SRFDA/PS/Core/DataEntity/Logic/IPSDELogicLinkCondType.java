/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicLinkCond;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEMSLogicLinkCond;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEUILogicLinkCond;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSDELogicLinkCond;
import SA.SRFDA.PS.Data.PSDELogicLinkCondType;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelIgnoreMeta
public interface IPSDELogicLinkCondType
extends IPSObject {
    public void init(ISRFDAGlobalHelper var1, PSDELogicLinkCondType var2) throws Exception;

    public IPSDELogicLinkCond createPSDELogicLinkCond(PSDELogicLinkCond var1) throws Exception;

    public IPSDEUILogicLinkCond createPSDEUILogicLinkCond(PSDELogicLinkCond var1) throws Exception;

    public IPSDEMSLogicLinkCond createPSDEMSLogicLinkCond(PSDELogicLinkCond var1) throws Exception;
}

