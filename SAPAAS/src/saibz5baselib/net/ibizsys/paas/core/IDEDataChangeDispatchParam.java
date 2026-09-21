/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.core;

import java.util.Iterator;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.psrt.srv.common.entity.DEDataChg;

public interface IDEDataChangeDispatchParam {
    public DEDataChg getDEDataChg();

    public IDataEntity getDataEntity();

    public IEntity getEntity();

    public Iterator<IEntity> getRelatedEntities();
}

