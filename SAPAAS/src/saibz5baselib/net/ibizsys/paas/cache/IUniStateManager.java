/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.cache;

import net.ibizsys.paas.cache.IUniState;
import net.ibizsys.paas.entity.IEntity;

public interface IUniStateManager {
    public void regUniState(IUniState var1) throws Exception;

    public void unregUniState(IUniState var1) throws Exception;

    public boolean containsUniState(IUniState var1) throws Exception;

    public boolean getEntity(IUniState var1, IEntity var2) throws Exception;

    public boolean getEntity(IUniState var1, IEntity var2, boolean var3) throws Exception;

    public Object getEntityState(IUniState var1, Object var2, String var3) throws Exception;

    public Object getEntityState(IUniState var1, Object var2, String var3, boolean var4) throws Exception;

    public boolean containsEntity(IUniState var1, IEntity var2) throws Exception;

    public boolean containsEntity(IUniState var1, Object var2) throws Exception;

    public void removeEntity(IUniState var1, IEntity var2) throws Exception;

    public void removeEntity(IUniState var1, Object var2) throws Exception;

    public void updateEntity(IUniState var1, IEntity var2) throws Exception;
}

