/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.IDERBase
 */
package net.ibizsys.model.der;

import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.paas.core.IDERBase;

public interface IPSDERBase
extends IPSModelObject,
IDERBase {
    public IPSDataEntity getMajorPSDataEntity();

    public IPSDataEntity getMinorPSDataEntity();

    public String getMajorPSDEId();

    public String getMinorPSDEId();

    public String getCodeName();

    public String getMinorCodeName();

    public String getLogicName();

    public int getOrderValue();
}

