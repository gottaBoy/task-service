/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.demodel;

import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.core.IDEActionWizard;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.core.ModelBase3Impl;
import net.ibizsys.paas.demodel.IDEActionWizardGroupModel;
import net.ibizsys.paas.demodel.IDEActionWizardModel;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.view.IViewWizard;

public class DEActionWizardGroupModel
extends ModelBase3Impl
implements IDEActionWizardGroupModel {
    private IDataEntityModel iDataEntity = null;
    private ArrayList<IDEActionWizard> deActionWizardList = new ArrayList();
    private ArrayList<IViewWizard> viewWizardList = new ArrayList();

    public void init(IDataEntity iDataEntity) throws Exception {
        this.iDataEntity = (IDataEntityModel)iDataEntity;
        this.onInit();
    }

    public void setId(String strId) {
        this.strId = strId;
    }

    public void setName(String strName) {
        this.strName = strName;
    }

    @Override
    public IDataEntity getDataEntity() {
        return this.iDataEntity;
    }

    @Override
    public Iterator<IDEActionWizard> getDEActionWizards() {
        return this.deActionWizardList.iterator();
    }

    @Override
    public Iterator<IViewWizard> getViewWizards() {
        return this.viewWizardList.iterator();
    }

    @Override
    public void registerDEActionWizardModel(IDEActionWizardModel iDEActionWizardModel) throws Exception {
        this.deActionWizardList.add(iDEActionWizardModel);
        this.viewWizardList.add(iDEActionWizardModel);
    }

    @Override
    public void fillViewWizards(IViewController iViewController, String strQuery, ArrayList<IViewWizard> viewWizardList) throws Exception {
        for (IDEActionWizard iDEActionWizard : this.deActionWizardList) {
            ((IDEActionWizardModel)iDEActionWizard).fillViewWizards(iViewController, strQuery, viewWizardList);
        }
    }

    @Override
    public IViewWizard getViewWizard(String strViewWizardId) throws Exception {
        for (IDEActionWizard iDEActionWizard : this.deActionWizardList) {
            if (StringHelper.compare(iDEActionWizard.getId(), strViewWizardId, false) != 0) continue;
            return iDEActionWizard;
        }
        throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u64cd\u4f5c\u5411\u5bfc\uff0c\u6807\u8bc6\u4e3a[%1$s]", strViewWizardId));
    }
}

