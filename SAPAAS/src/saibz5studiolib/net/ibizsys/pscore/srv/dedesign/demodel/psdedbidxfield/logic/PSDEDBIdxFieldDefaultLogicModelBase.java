/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.IActionContext
 *  net.ibizsys.paas.demodel.DELogicModelBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdedbidxfield.logic;

import net.ibizsys.paas.core.IActionContext;
import net.ibizsys.paas.demodel.DELogicModelBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDBIdxField;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEDBIdxFieldDefaultLogicModelBase
extends DELogicModelBase<PSDEDBIdxField> {
    private static final Log log = LogFactory.getLog(PSDEDBIdxFieldDefaultLogicModelBase.class);

    public PSDEDBIdxFieldDefaultLogicModelBase() {
        this.setId("CDD8260F-EDAB-4690-BF6E-C746BC1A6DDF");
        this.setName("Default");
        this.setDefaultParamName("Default");
    }

    protected void onExecute(IActionContext iActionContext) throws Exception {
        this.executeBegin(iActionContext);
    }

    protected void executeBegin(IActionContext iActionContext) throws Exception {
        PSDEDBIdxField pSDEDBIdxField = (PSDEDBIdxField)iActionContext.getParam("Default");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        this.executePrepareparam1(iActionContext);
    }

    protected void executePrepareparam1(IActionContext iActionContext) throws Exception {
        PSDEDBIdxField pSDEDBIdxField = (PSDEDBIdxField)iActionContext.getParam("Default");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        pSDEDBIdxField.set("PSDEDBIDXFIELDNAME", pSDEDBIdxField.get("PSDEFNAME"));
    }
}

