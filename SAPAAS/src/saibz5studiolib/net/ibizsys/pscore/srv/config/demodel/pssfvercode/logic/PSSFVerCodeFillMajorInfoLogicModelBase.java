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
package net.ibizsys.pscore.srv.config.demodel.pssfvercode.logic;

import net.ibizsys.paas.core.IActionContext;
import net.ibizsys.paas.demodel.DELogicModelBase;
import net.ibizsys.pscore.srv.config.entity.PSSFVerCode;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSFVerCodeFillMajorInfoLogicModelBase
extends DELogicModelBase<PSSFVerCode> {
    private static final Log log = LogFactory.getLog(PSSFVerCodeFillMajorInfoLogicModelBase.class);

    public PSSFVerCodeFillMajorInfoLogicModelBase() {
        this.setId("8A10D9B0-3954-4F7A-A9A2-199D28B7E7C8");
        this.setName("FillMajorInfo");
        this.setDefaultParamName("Default");
    }

    protected void onExecute(IActionContext iActionContext) throws Exception {
        this.executeBegin(iActionContext);
    }

    protected void executeBegin(IActionContext iActionContext) throws Exception {
        PSSFVerCode pSSFVerCode = (PSSFVerCode)iActionContext.getParam("Default");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        this.executePrepareparam1(iActionContext);
    }

    protected void executePrepareparam1(IActionContext iActionContext) throws Exception {
        PSSFVerCode pSSFVerCode = (PSSFVerCode)iActionContext.getParam("Default");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        pSSFVerCode.set("PSSFVERCODENAME", pSSFVerCode.get("PSSFCODETYPENAME"));
    }
}

