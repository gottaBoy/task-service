/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.sysmodel.IDynaSystemSetting
 */
package net.ibizsys.paas.sysmodel;

import net.ibizsys.paas.sysmodel.IDynaSystemSetting;

public interface IDynaSystemStorage {
    public void init(IDynaSystemSetting var1) throws Exception;

    public IDynaSystemSetting getDynaSystemSetting();

    public void installAll() throws Exception;

    public void installAllWorkflows() throws Exception;

    public void installAllCodeLists() throws Exception;

    public void syncAll() throws Exception;

    public void syncAllViews() throws Exception;

    public void syncAllWorkflows() throws Exception;

    public void syncAllCodeLists() throws Exception;

    public void syncView(String var1) throws Exception;

    public void syncWorkflow(String var1) throws Exception;

    public void syncCodeList(String var1) throws Exception;
}

