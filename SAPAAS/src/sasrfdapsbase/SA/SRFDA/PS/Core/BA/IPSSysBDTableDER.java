/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.psba.core.IBATableDER
 */
package SA.SRFDA.PS.Core.BA;

import SA.SRFDA.PS.Core.BA.IPSSysBDTable;
import SA.SRFDA.PS.Core.BA.IPSSysBDTableObject;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDER1N;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSSysBDTableDER;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.psba.core.IBATableDER;

@PSModelIgnoreMeta
public interface IPSSysBDTableDER
extends IPSSysBDTableObject,
IBATableDER {
    public void init(ISRFDAGlobalHelper var1, IPSSysBDTable var2, PSSysBDTableDER var3) throws Exception;

    public IPSDER1N getPSDER1N();
}

