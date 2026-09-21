/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.form.IPSDEFIUpdateDetail
 *  net.ibizsys.model.control.form.IPSDEFormItemUpdate
 */
package net.ibizsys.model.control.form;

import net.ibizsys.model.IPSModelObjectRuntime;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSObjectImpl;
import net.ibizsys.model.control.form.IPSDEFIUpdateDetail;
import net.ibizsys.model.control.form.IPSDEFIUpdateDetailRuntime;
import net.ibizsys.model.control.form.IPSDEFormItemUpdate;
import net.ibizsys.model.entity.PSDEFIUDetail;

public class PSDEFIUpdateDetailImpl
extends PSObjectImpl
implements IPSDEFIUpdateDetail,
IPSDEFIUpdateDetailRuntime {
    protected IPSDEFormItemUpdate iPSDEFormItemUpdate;
    protected PSDEFIUDetail psDEFIUDetail;

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSDEFormItemUpdate iPSDEFormItemUpdate, PSDEFIUDetail psDEFIUDetail) throws Exception {
        this.setPSModelStorageContext(iPSModelStorageContext);
        this.iPSDEFormItemUpdate = iPSDEFormItemUpdate;
        this.psDEFIUDetail = psDEFIUDetail;
        this.setId(psDEFIUDetail.getPSDEFIUDETAILID());
        this.setName(psDEFIUDetail.getPSDEFIUDETAILNAME());
        this.onInit();
    }

    public String getPSDEFormDetailName() {
        return this.psDEFIUDetail.getPSDEFORMDETAILNAME();
    }

    public String getPSDEFormDetailId() {
        return this.psDEFIUDetail.getPSDEFORMDETAILID();
    }

    @Override
    public String getPSSysModelInstId() {
        return ((IPSModelObjectRuntime)this.iPSDEFormItemUpdate).getPSSysModelInstId();
    }
}

