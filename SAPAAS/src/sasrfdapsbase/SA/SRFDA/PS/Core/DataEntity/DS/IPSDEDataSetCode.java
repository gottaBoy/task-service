/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.core.IDEDataSetCode
 */
package SA.SRFDA.PS.Core.DataEntity.DS;

import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSDEDataSetCode;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.core.IDEDataSetCode;

@PSModelIgnoreMeta
public interface IPSDEDataSetCode
extends IPSObject,
IDEDataSetCode {
    public void init(ISRFDAGlobalHelper var1, IPSDEDataSet var2, PSDEDataSetCode var3) throws Exception;
}

