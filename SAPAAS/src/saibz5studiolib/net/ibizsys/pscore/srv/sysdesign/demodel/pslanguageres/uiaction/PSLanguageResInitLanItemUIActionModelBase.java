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

public abstract class PSLanguageResInitLanItemUIActionModelBase
extends DEUIActionModelBase<PSLanguageRes> {
    private static final Log log = LogFactory.getLog(PSLanguageResInitLanItemUIActionModelBase.class);

    public PSLanguageResInitLanItemUIActionModelBase() {
        this.setId("578A4D33-C0BB-4804-B999-0D7FEC75DA7D");
        this.setName("InitLanItem");
        this.setActionTarget("MULTIKEY");
        this.setDEActionName("INITLANITEM");
        this.setReloadData(true);
    }
}

