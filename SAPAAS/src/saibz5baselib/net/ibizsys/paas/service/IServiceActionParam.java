/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.service;

import net.ibizsys.paas.entity.IEntity;

public interface IServiceActionParam<ET extends IEntity> {
    public String getAction();

    public ET getEntity();

    public void doBeforeAction(ET var1) throws Exception;

    public void doAfterAction(ET var1) throws Exception;

    public boolean testAction(ET var1) throws Exception;
}

