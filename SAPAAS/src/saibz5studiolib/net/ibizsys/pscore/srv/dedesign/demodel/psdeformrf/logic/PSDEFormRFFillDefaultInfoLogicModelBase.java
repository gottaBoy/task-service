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
package net.ibizsys.pscore.srv.dedesign.demodel.psdeformrf.logic;

import net.ibizsys.paas.core.IActionContext;
import net.ibizsys.paas.demodel.DELogicModelBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFormRF;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEFormRFFillDefaultInfoLogicModelBase
extends DELogicModelBase<PSDEFormRF> {
    private static final Log log = LogFactory.getLog(PSDEFormRFFillDefaultInfoLogicModelBase.class);

    public PSDEFormRFFillDefaultInfoLogicModelBase() {
        this.setId("A4830A0D-5BC9-468B-BA21-15859988A064");
        this.setName("FillDefaultInfo");
        this.setDefaultParamName("Default");
    }

    protected void onExecute(IActionContext iActionContext) throws Exception {
        this.executeBegin(iActionContext);
    }

    protected void executeBegin(IActionContext iActionContext) throws Exception {
        PSDEFormRF pSDEFormRF = (PSDEFormRF)iActionContext.getParam("Default");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        if (PSDEFormRFFillDefaultInfoLogicModelBase.testCond((Object)pSDEFormRF.get("PSDEFORMRFNAME"), (String)"EQ", (Object)"") || PSDEFormRFFillDefaultInfoLogicModelBase.testCond((Object)pSDEFormRF.get("PSDEFORMRFNAME"), (String)"ISNULL", (Object)"")) {
            this.executePrepareparam1(iActionContext);
        }
    }

    protected void executePrepareparam1(IActionContext iActionContext) throws Exception {
        PSDEFormRF pSDEFormRF = (PSDEFormRF)iActionContext.getParam("Default");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        pSDEFormRF.set("PSDEFORMRFNAME", pSDEFormRF.get("MINORPSDEFORMNAME"));
    }
}

