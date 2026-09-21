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

public abstract class PSDEFieldCreateDefaultInputTipUIActionModelBase
extends DEUIActionModelBase<PSDEField> {
    private static final Log log = LogFactory.getLog(PSDEFieldCreateDefaultInputTipUIActionModelBase.class);

    public PSDEFieldCreateDefaultInputTipUIActionModelBase() {
        this.setId("B32BA890-992B-45C2-90F7-EDABEA4DF48E");
        this.setName("CreateDefaultInputTip");
        this.setActionTarget("MULTIKEY");
        this.setDEActionName("CreateDefaultInputTip");
        this.setReloadData(true);
    }
}

