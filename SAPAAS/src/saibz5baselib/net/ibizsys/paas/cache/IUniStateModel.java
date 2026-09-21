/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.cache;

import net.ibizsys.paas.cache.IUniState;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.sysmodel.ISystemModel;

public interface IUniStateModel
extends IUniState {
    public void init(ISystemModel var1) throws Exception;

    public String[] getFolderFields();

    public String[] getStateFields();

    public boolean contains(Object var1) throws Exception;

    public IEntity get(Object var1) throws Exception;

    public IEntity get(Object var1, boolean var2) throws Exception;

    public Object get(Object var1, String var2) throws Exception;

    public Object get(Object var1, String var2, boolean var3) throws Exception;

    public void remove(Object var1) throws Exception;

    public IEntity update(Object var1) throws Exception;

    public void update(IEntity var1) throws Exception;

    public boolean isEnabled();
}

