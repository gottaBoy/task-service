/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.ModelBase3Impl
 *  net.ibizsys.paas.sysmodel.IDynaSystemSetting
 */
package net.ibizsys.paas.sysmodel;

import java.util.HashMap;
import net.ibizsys.paas.core.ModelBase3Impl;
import net.ibizsys.paas.sysmodel.IDynaSystemSetting;
import net.ibizsys.paas.sysmodel.IDynaSystemStorage;

public class MultiDynaSystemStorageBase
extends ModelBase3Impl
implements IDynaSystemStorage {
    private HashMap<String, IDynaSystemStorage> dynaSystemStorageMap = new HashMap();
    private IDynaSystemSetting iDynaSystemSetting = null;

    @Override
    public void init(IDynaSystemSetting iDynaSystemSetting) throws Exception {
        this.iDynaSystemSetting = iDynaSystemSetting;
    }

    @Override
    public IDynaSystemSetting getDynaSystemSetting() {
        return this.iDynaSystemSetting;
    }

    @Override
    public void installAll() throws Exception {
    }

    @Override
    public void installAllWorkflows() throws Exception {
    }

    @Override
    public void installAllCodeLists() throws Exception {
    }

    @Override
    public void syncAll() throws Exception {
    }

    @Override
    public void syncAllViews() throws Exception {
    }

    @Override
    public void syncAllWorkflows() throws Exception {
    }

    @Override
    public void syncAllCodeLists() throws Exception {
    }

    @Override
    public void syncView(String strViewId) throws Exception {
    }

    @Override
    public void syncWorkflow(String strWorkflowId) throws Exception {
    }

    @Override
    public void syncCodeList(String strCodeListId) throws Exception {
    }
}

