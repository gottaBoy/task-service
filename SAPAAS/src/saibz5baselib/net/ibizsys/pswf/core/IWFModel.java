/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pswf.core;

import java.util.Iterator;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.core.IModelBase;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.sysmodel.ISystemModel;
import net.ibizsys.pswf.core.IWFService;
import net.ibizsys.pswf.core.IWFVersionModel;

public interface IWFModel
extends IModelBase {
    public static final String WFENGINETYPE_EMBEDDED = "EMBEDDED";
    public static final String WFENGINETYPE_ACTIVITI = "ACTIVITI";
    public static final String WFENGINETYPE_ACTIVITI_REMOTE = "ACTIVITI_REMOTE";

    public ISystemModel getSystemModel();

    public IEntity createEntity(String var1) throws Exception;

    public ICodeList getWFStepCodeList();

    public ICodeList getEntityStateCodeList();

    public Iterator<String> getEntityWFStates();

    public IWFVersionModel getLastWFVersionModel();

    public IWFVersionModel getLastWFVersionModel(String var1) throws Exception;

    public IWFVersionModel getWFVersionModelByWFVersion(int var1) throws Exception;

    public IWFVersionModel getWFVersionModel(String var1) throws Exception;

    public boolean isEntityWFState(String var1);

    public IWFService getWFService();

    public String getEntityWFState();

    public String getRemindMsgTemplId();

    public String getWXAccountId();

    public String getWXEntAppId();

    public Object getRuntimeId();

    public void setRuntimeId(Object var1);

    public String getWFEngineType();

    public String getNameLanResTag();

    public String getWFEngineCat();

    public String getDefaultDEName();
}

