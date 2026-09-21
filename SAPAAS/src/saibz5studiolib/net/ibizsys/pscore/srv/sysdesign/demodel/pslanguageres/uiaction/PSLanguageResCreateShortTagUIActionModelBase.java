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

public abstract class PSLanguageResCreateShortTagUIActionModelBase
extends DEUIActionModelBase<PSLanguageRes> {
    private static final Log log = LogFactory.getLog(PSLanguageResCreateShortTagUIActionModelBase.class);

    public PSLanguageResCreateShortTagUIActionModelBase() {
        this.setId("FFCFD729-A24B-4E3C-8F16-B0B6298FC6C9");
        this.setName("CreateShortTag");
        this.setActionTarget("MULTIKEY");
        this.setDEActionName("CREATESHORTTAG");
        this.setReloadData(true);
    }
}

