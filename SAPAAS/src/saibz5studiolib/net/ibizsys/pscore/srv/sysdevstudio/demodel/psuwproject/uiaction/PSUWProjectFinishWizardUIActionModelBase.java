/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.demodel.DEUIActionModelBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.sysdevstudio.demodel.psuwproject.uiaction;

import net.ibizsys.paas.demodel.DEUIActionModelBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSUWProject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSUWProjectFinishWizardUIActionModelBase
extends DEUIActionModelBase<PSUWProject> {
    private static final Log log = LogFactory.getLog(PSUWProjectFinishWizardUIActionModelBase.class);

    public PSUWProjectFinishWizardUIActionModelBase() {
        this.setId("C2810B96-2D63-4A8C-B6C3-C2D1E98FE1AD");
        this.setName("FinishWizard");
        this.setActionTarget("SINGLEKEY");
        this.setDEActionName("Finish");
        this.setDataAccessAction("UPDATE");
        this.setSuccessMsg("\u5b8c\u6210\u5411\u5bfc\u6210\u529f");
    }
}

