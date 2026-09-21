/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pswf.core;

import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.pswf.core.IWFModel;
import org.hibernate.SessionFactory;

public interface IWFDEModel {
    public String getId();

    public String getName();

    public IWFModel getWFModel();

    public String getWFStepField();

    public String getWFStateField();

    public String getUDStateField();

    public String getWFRetField();

    public String getWorkflowId();

    public String getWorkflowField();

    public String getWFInstField();

    public String getEntityWFState();

    public String getWFActorsField();

    public boolean testDataInWF(IEntity var1) throws Exception;

    public String getWFEditViewPDTParam(IEntity var1, boolean var2) throws Exception;

    public boolean testUserWFSubmit(IEntity var1, String var2, SessionFactory var3) throws Exception;

    public String getWFStartName();

    public String getWFVerField();

    public String getWFMode();
}

