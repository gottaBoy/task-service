/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.SubSys;

import SA.SRFDA.PS.Core.Database.PSSysDMItemBaseImpl;
import SA.SRFDA.PS.Core.SubSys.IPSSubSys;
import SA.SRFDA.PS.Core.SubSys.IPSSubSysDMItem;
import SA.SRFDA.PS.Core.SubSys.IPSSubSysVer;
import SA.SRFDA.PS.Data.PSSysDMItem;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public class PSSubSysDMItemImpl
extends PSSysDMItemBaseImpl
implements IPSSubSysDMItem {
    private IPSSubSysVer iPSSubSysVer = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSubSysVer iPSSubSysVerVer, PSSysDMItem psSysDMItem) throws Exception {
        this.setPSSubSysVer(this.iPSSubSysVer);
        this.init(iDAGlobalHelper, psSysDMItem);
    }

    protected void setPSSubSysVer(IPSSubSysVer iPSSubSysVer) {
        this.iPSSubSysVer = iPSSubSysVer;
    }

    @Override
    public IPSSubSys getPSSubSys() {
        return this.getPSSubSysVer().getPSSubSys();
    }

    @Override
    public IPSSubSysVer getPSSubSysVer() {
        return this.iPSSubSysVer;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSSubSysVer().getPSSysModelInstId();
    }
}

