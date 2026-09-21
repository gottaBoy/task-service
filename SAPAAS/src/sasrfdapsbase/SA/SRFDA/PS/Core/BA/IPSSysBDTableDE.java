/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.psba.core.IBATableDE
 */
package SA.SRFDA.PS.Core.BA;

import SA.SRFDA.PS.Core.BA.IPSBDTableDE;
import SA.SRFDA.PS.Core.BA.IPSSysBDTable;
import SA.SRFDA.PS.Core.BA.IPSSysBDTableObject;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Data.PSSysBDTableDE;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.psba.core.IBATableDE;

@PSModelPFIgnoreMeta
public interface IPSSysBDTableDE
extends IPSSysBDTableObject,
IBATableDE,
IPSBDTableDE {
    public void init(ISRFDAGlobalHelper var1, IPSSysBDTable var2, PSSysBDTableDE var3) throws Exception;

    public IPSDataEntity getPSDataEntity();
}

