/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.form.IPSDEFDLogic
 *  net.ibizsys.model.control.form.IPSDEFormDetail
 */
package net.ibizsys.model.control.form;

import net.ibizsys.model.IPSModelObjectRuntime;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSObjectImpl;
import net.ibizsys.model.control.form.IPSDEFDLogic;
import net.ibizsys.model.control.form.IPSDEFDLogicRuntime;
import net.ibizsys.model.control.form.IPSDEFormDetail;
import net.ibizsys.model.entity.PSDEFDLogic;

public abstract class PSDEFDLogicImpl
extends PSObjectImpl
implements IPSDEFDLogic,
IPSDEFDLogicRuntime {
    protected IPSDEFormDetail iPSDEFormDetail = null;
    protected PSDEFDLogic psDEFDLogic = null;
    protected IPSDEFDLogic parentPSDEFDLogic = null;

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSDEFormDetail iPSDEFormDetail, IPSDEFDLogic parentPSDEFDLogic, PSDEFDLogic psDEFDLogic) throws Exception {
        this.setPSModelStorageContext(iPSModelStorageContext);
        this.iPSDEFormDetail = iPSDEFormDetail;
        this.psDEFDLogic = psDEFDLogic;
        this.parentPSDEFDLogic = parentPSDEFDLogic;
        this.setId(this.psDEFDLogic.getPSDEFDLOGICID());
        this.setName(this.psDEFDLogic.getPSDEFDLOGICNAME());
        this.onInit();
    }

    public String getLogicCat() {
        return this.psDEFDLogic.getLOGICCAT();
    }

    public String getLogicType() {
        return this.psDEFDLogic.getLOGICTYPE();
    }

    public IPSDEFormDetail getPSDEFormDetail() {
        return this.iPSDEFormDetail;
    }

    @Override
    public String getPSSysModelInstId() {
        return ((IPSModelObjectRuntime)this.iPSDEFormDetail).getPSSysModelInstId();
    }
}

