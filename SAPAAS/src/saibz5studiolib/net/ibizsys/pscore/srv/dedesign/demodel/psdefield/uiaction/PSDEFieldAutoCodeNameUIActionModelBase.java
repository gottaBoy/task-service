/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.demodel.DEUIActionModelBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdefield.uiaction;

import net.ibizsys.paas.demodel.DEUIActionModelBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSDEFieldAutoCodeNameUIActionModelBase
extends DEUIActionModelBase<PSDEField> {
    private static final Log log = LogFactory.getLog(PSDEFieldAutoCodeNameUIActionModelBase.class);

    public PSDEFieldAutoCodeNameUIActionModelBase() {
        this.setId("D196A523-A89B-47F8-9442-27CBC9C38185");
        this.setName("AutoCodeName");
        this.setActionTarget("MULTIKEY");
        this.setDEActionName("AUTOCODENAME");
        this.setReloadData(true);
    }
}

