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
package net.ibizsys.pscore.srv.sysdeploy.demodel.psdepslnprd.logic;

import net.ibizsys.paas.core.IActionContext;
import net.ibizsys.paas.demodel.DELogicModelBase;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnPrd;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDepSlnPrdFillMajorInfoLogicModelBase
extends DELogicModelBase<PSDepSlnPrd> {
    private static final Log log = LogFactory.getLog(PSDepSlnPrdFillMajorInfoLogicModelBase.class);

    public PSDepSlnPrdFillMajorInfoLogicModelBase() {
        this.setId("8CBD9933-3781-4E05-BDDA-6DF3FE8C1B38");
        this.setName("FillMajorInfo");
        this.setDefaultParamName("Default");
    }

    protected void onExecute(IActionContext iActionContext) throws Exception {
        this.executeBegin(iActionContext);
    }

    protected void executeBegin(IActionContext iActionContext) throws Exception {
        PSDepSlnPrd pSDepSlnPrd = (PSDepSlnPrd)iActionContext.getParam("Default");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        if (PSDepSlnPrdFillMajorInfoLogicModelBase.testCond((Object)pSDepSlnPrd.get("prdtype"), (String)"EQ", (Object)"DEVSLNSYSVER")) {
            this.executePrepareparam1(iActionContext);
        }
        if (PSDepSlnPrdFillMajorInfoLogicModelBase.testCond((Object)pSDepSlnPrd.get("prdtype"), (String)"EQ", (Object)"DCSYSRES")) {
            this.executePrepareparam2(iActionContext);
        }
    }

    protected void executePrepareparam2(IActionContext iActionContext) throws Exception {
        PSDepSlnPrd pSDepSlnPrd = (PSDepSlnPrd)iActionContext.getParam("Default");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        pSDepSlnPrd.set("PSDEPSLNPRDNAME", pSDepSlnPrd.get("PSDCSYSRESNAME"));
    }

    protected void executePrepareparam1(IActionContext iActionContext) throws Exception {
        PSDepSlnPrd pSDepSlnPrd = (PSDepSlnPrd)iActionContext.getParam("Default");
        SessionFactory sessionFactory = iActionContext.getSessionFactory();
        pSDepSlnPrd.set("psdepslnprdname", pSDepSlnPrd.get("psdevslnsysvername"));
    }
}

