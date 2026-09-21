/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.demodel.DEUIActionModelBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pslanguageres.uiaction;

import net.ibizsys.paas.demodel.DEUIActionModelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSLanguageResAutoFillModuleUIActionModelBase
extends DEUIActionModelBase<PSLanguageRes> {
    private static final Log log = LogFactory.getLog(PSLanguageResAutoFillModuleUIActionModelBase.class);

    public PSLanguageResAutoFillModuleUIActionModelBase() {
        this.setId("0779E1F2-B0CC-4787-9D47-A8191197F35D");
        this.setName("AutoFillModule");
        this.setActionTarget("NONE");
        this.setDEActionName("AUTOFILLMODULE");
        this.setReloadData(true);
    }
}

