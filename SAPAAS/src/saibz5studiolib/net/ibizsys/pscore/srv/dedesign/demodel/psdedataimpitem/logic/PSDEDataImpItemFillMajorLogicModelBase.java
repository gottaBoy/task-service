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
package net.ibizsys.pscore.srv.dedesign.demodel.psdedataimpitem.logic;

import net.ibizsys.paas.core.IActionContext;
import net.ibizsys.paas.demodel.DELogicModelBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataImpItem;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEDataImpItemFillMajorLogicModelBase
extends DELogicModelBase<PSDEDataImpItem> {
    private static final Log log = LogFactory.getLog(PSDEDataImpItemFillMajorLogicModelBase.class);

    public PSDEDataImpItemFillMajorLogicModelBase() {
        this.setId("04C970D4-562D-4E88-8727-E39AC26F138D");
        this.setName("FillMajor");
        this.setDefaultParamName("Default");
    }

    protected void onExecute(IActionContext iActionContext) throws Exception {
        this.executeBegin(iActionContext);
    }

    protected void executeBegin(IActionContext iActionContext) throws Exception {
        PSDEDataImpItem pSDEDataImpItem = (PSDEDataImpItem)iActionContext.getParam("Default");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        this.executePrepareparam1(iActionContext);
    }

    protected void executePrepareparam1(IActionContext iActionContext) throws Exception {
        PSDEDataImpItem pSDEDataImpItem = (PSDEDataImpItem)iActionContext.getParam("Default");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        pSDEDataImpItem.set("PSDEDATAIMPITEMNAME", pSDEDataImpItem.get("PSDEFNAME"));
    }
}

