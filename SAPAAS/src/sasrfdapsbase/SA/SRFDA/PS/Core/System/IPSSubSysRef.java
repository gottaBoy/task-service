/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.System;

import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.SubSys.IPSSubSys;
import SA.SRFDA.PS.Core.SubSys.IPSSubSysVer;
import SA.SRFDA.PS.Data.PSSysRef;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelIgnoreMeta
public interface IPSSubSysRef
extends IPSSystemObject {
    public void init(ISRFDAGlobalHelper var1, IPSSystem var2, PSSysRef var3) throws Exception;

    public IPSSubSys getPSSubSys();

    public String getPKGCodeName(String var1) throws Exception;

    public IPSSubSysVer getPSSubSysVer();
}

