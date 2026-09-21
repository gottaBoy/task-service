/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.counter.IPSSysCounter
 *  net.ibizsys.model.core.IPSModelObject
 */
package net.ibizsys.model.control.counter;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSObjectImpl;
import net.ibizsys.model.control.counter.IPSSysCounter;
import net.ibizsys.model.control.counter.IPSSysCounterItemRuntime;
import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.entity.PSSysCounterItem;

public class PSSysCounterItemImpl
extends PSObjectImpl
implements IPSSysCounterItemRuntime {
    private IPSSysCounter iPSSysCounter = null;
    private PSSysCounterItem psSysCounterItem = null;

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSSysCounter iPSSysCounter, PSSysCounterItem psSysCounterItem) throws Exception {
        this.setPSModelStorageContext(iPSModelStorageContext);
        this.iPSSysCounter = iPSSysCounter;
        this.psSysCounterItem = psSysCounterItem;
        this.setPSObjectData(psSysCounterItem);
        this.setId(psSysCounterItem.getPSSYSCOUNTERITEMID());
        this.setName(psSysCounterItem.getPSSYSCOUNTERITEMNAME());
        this.onInit();
    }

    public String getLogicName() {
        return this.psSysCounterItem.getLOGICNAME();
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSSysModelInstId((IPSModelObject)this.getPSSysCounter());
    }

    public IPSSysCounter getPSSysCounter() {
        return this.iPSSysCounter;
    }
}

