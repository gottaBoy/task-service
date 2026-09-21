/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.SubSys;

import SA.SRFDA.PS.Core.Database.IPSSysDMItemBase;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.SubSys.IPSSubSysObject;
import SA.SRFDA.PS.Core.SubSys.IPSSubSysVer;
import SA.SRFDA.PS.Data.PSSysDMItem;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelIgnoreMeta
public interface IPSSubSysDMItem
extends IPSSysDMItemBase,
IPSSubSysObject {
    public void init(ISRFDAGlobalHelper var1, IPSSubSysVer var2, PSSysDMItem var3) throws Exception;

    public IPSSubSysVer getPSSubSysVer();
}

