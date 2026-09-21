/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.demodel.DEUIActionModelBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.appdesign.demodel.psapplocalde.uiaction;

import net.ibizsys.paas.demodel.DEUIActionModelBase;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppLocalDE;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSAppLocalDERebuildAllUIActionModelBase
extends DEUIActionModelBase<PSAppLocalDE> {
    private static final Log log = LogFactory.getLog(PSAppLocalDERebuildAllUIActionModelBase.class);

    public PSAppLocalDERebuildAllUIActionModelBase() {
        this.setId("440BDCFA-9979-43E9-8711-E3C5438ADB87");
        this.setName("RebuildAll");
        this.setActionTarget("NONE");
        this.setDEActionName("RebuildAll");
        this.setReloadData(true);
    }
}

