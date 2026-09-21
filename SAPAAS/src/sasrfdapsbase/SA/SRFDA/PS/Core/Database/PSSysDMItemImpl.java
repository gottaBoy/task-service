/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.core.ISystem
 */
package SA.SRFDA.PS.Core.Database;

import SA.SRFDA.PS.Core.Database.IPSSysDMItem;
import SA.SRFDA.PS.Core.Database.PSSysDMItemBaseImpl;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSSysDMItem;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.core.ISystem;

@PSModelIgnoreMeta
public class PSSysDMItemImpl
extends PSSysDMItemBaseImpl
implements IPSSysDMItem {
    private IPSSystem iPSSystem = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem, PSSysDMItem psSysDMItem) throws Exception {
        this.setPSSystem(iPSSystem);
        this.init(iDAGlobalHelper, psSysDMItem);
    }

    protected void setPSSystem(IPSSystem iPSSystem) {
        this.iPSSystem = iPSSystem;
    }

    @Override
    public IPSSystem getPSSystem() {
        return this.iPSSystem;
    }

    public ISystem getSystem() {
        return this.getPSSystem();
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSSystem().getPSSysModelInstId();
    }

    @Override
    public String getModelType() {
        return "PSSYSDMITEM";
    }
}

