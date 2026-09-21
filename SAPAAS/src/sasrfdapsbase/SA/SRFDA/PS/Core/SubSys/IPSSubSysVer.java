/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.SubSys;

import SA.SRFDA.PS.Core.SubSys.IPSSubSys;
import SA.SRFDA.PS.Core.SubSys.IPSSubSysDMItem;
import SA.SRFDA.PS.Core.SubSys.IPSSubSysObject;
import SA.SRFDA.PS.Data.PSSubSysVer;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;

public interface IPSSubSysVer
extends IPSSubSysObject {
    public void init(ISRFDAGlobalHelper var1, IPSSubSys var2, PSSubSysVer var3) throws Exception;

    public String getPSSystemId();

    public Iterator<IPSSubSysDMItem> getAllPSSubSysDMItems() throws Exception;
}

