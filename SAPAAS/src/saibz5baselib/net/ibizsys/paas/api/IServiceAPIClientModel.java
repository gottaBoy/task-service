/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.api;

import java.util.ArrayList;
import net.ibizsys.paas.api.FetchResult;
import net.ibizsys.paas.api.IServiceAPIClient;
import net.ibizsys.paas.api.IServiceCallContext;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.sysmodel.ISystemModel;

public interface IServiceAPIClientModel
extends IServiceAPIClient {
    public void init(ISystemModel var1) throws Exception;

    public String getUniqueTag();

    public void execute(String var1, IEntity var2) throws Exception;

    public ArrayList<IEntity> select(String var1, ISelectCond var2) throws Exception;

    public FetchResult fetch(String var1, IDEDataSetFetchContext var2) throws Exception;

    public void execute(IServiceCallContext var1, String var2, IEntity var3) throws Exception;

    public ArrayList<IEntity> select(IServiceCallContext var1, String var2, ISelectCond var3) throws Exception;

    public FetchResult fetch(IServiceCallContext var1, String var2, IDEDataSetFetchContext var3) throws Exception;
}

