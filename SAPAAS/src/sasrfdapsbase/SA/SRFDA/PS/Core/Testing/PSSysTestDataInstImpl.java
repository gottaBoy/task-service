/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.entity.IEntity
 */
package SA.SRFDA.PS.Core.Testing;

import SA.SRFDA.PS.Core.Testing.IPSSysTestDataInst;
import net.ibizsys.paas.entity.IEntity;

public class PSSysTestDataInstImpl
implements IPSSysTestDataInst {
    private int nIndex = 0;
    private IEntity iEntity = null;

    @Override
    public int getIndex() {
        return this.nIndex;
    }

    public void setIndex(int nIndex) {
        this.nIndex = nIndex;
    }

    @Override
    public IEntity getEntity() {
        return this.iEntity;
    }

    public void setEntity(IEntity iEntity) {
        this.iEntity = iEntity;
    }
}

