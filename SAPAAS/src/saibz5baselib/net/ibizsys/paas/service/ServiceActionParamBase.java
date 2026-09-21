/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.service;

import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IServiceActionParam;

public class ServiceActionParamBase<ET extends IEntity>
implements IServiceActionParam<ET> {
    private String strAction = null;
    private ET et = null;

    @Override
    public String getAction() {
        return this.strAction;
    }

    public void setAction(String strAction) {
        this.strAction = strAction;
    }

    @Override
    public boolean testAction(ET et) throws Exception {
        return true;
    }

    @Override
    public ET getEntity() {
        return this.et;
    }

    void setEntity(ET et) {
        this.et = et;
    }

    @Override
    public void doBeforeAction(ET et) throws Exception {
    }

    @Override
    public void doAfterAction(ET et) throws Exception {
    }
}

