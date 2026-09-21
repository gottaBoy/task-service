/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psba.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import net.ibizsys.psba.core.IBACallContext;
import net.ibizsys.psba.core.IBAColumn;
import net.ibizsys.psba.core.IBAScheme;
import net.ibizsys.psba.dao.IBAAsyncSelectHandler;
import net.ibizsys.psba.dao.IBASelectContext;
import net.ibizsys.psba.entity.IBAEntity;

public interface IBADialect {
    public String getBAType();

    public Object getFuncValue(String var1, String[] var2) throws Exception;

    public Object getFuncValue(String var1, boolean var2, String[] var3) throws Exception;

    public void install(Object var1, IBAScheme var2) throws Exception;

    public void executeCreateCmd(IBACallContext var1, Object var2, Map<IBAColumn, Object> var3, IBAEntity var4, String[] var5) throws Exception;

    public void executeUpdateCmd(IBACallContext var1, Object var2, Map<IBAColumn, Object> var3, IBAEntity var4, String[] var5) throws Exception;

    public void executeGetCmd(IBACallContext var1, Object var2, IBAEntity var3, String[] var4) throws Exception;

    public void executeRemoveCmd(IBACallContext var1, Object var2, IBAEntity var3) throws Exception;

    public ArrayList<IBAEntity> executeSelectCmd(IBACallContext var1, Object var2, IBASelectContext var3, IBAAsyncSelectHandler var4) throws Exception;

    public void executeBatchCreateCmd(IBACallContext var1, Object var2, List<Map<IBAColumn, Object>> var3, IBAEntity[] var4, String[] var5) throws Exception;
}

