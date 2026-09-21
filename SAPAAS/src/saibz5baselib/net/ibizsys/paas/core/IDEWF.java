/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.core;

import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.core.IDataEntityObject;
import net.ibizsys.paas.entity.IEntity;

public interface IDEWF
extends IDataEntityObject {
    public void init(IDataEntity var1) throws Exception;

    public String getWorkflowId();

    public String getWFStepField();

    public String getWFStateField();

    public String getUDStateField();

    public String getWFInstField();

    public String getEntityWFState();

    public String getWFActorsField();

    public String getWFRetField();

    public boolean testDataInWF(IEntity var1) throws Exception;

    public String getWFEditViewPDTParam(IEntity var1, boolean var2) throws Exception;

    public String getWFEditViewPDTParam(IEntity var1, boolean var2, int var3) throws Exception;

    public String getWFStartName();

    public String getWFVerField();

    public String getWorkflowField();

    public String getWFMode();
}

