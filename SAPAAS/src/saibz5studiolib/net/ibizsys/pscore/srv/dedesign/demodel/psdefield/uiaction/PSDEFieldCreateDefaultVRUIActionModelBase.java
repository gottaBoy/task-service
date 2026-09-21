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

public abstract class PSDEFieldCreateDefaultVRUIActionModelBase
extends DEUIActionModelBase<PSDEField> {
    private static final Log log = LogFactory.getLog(PSDEFieldCreateDefaultVRUIActionModelBase.class);

    public PSDEFieldCreateDefaultVRUIActionModelBase() {
        this.setId("905B90D1-F76C-428E-A9EF-C925FB8EE317");
        this.setName("CreateDefaultVR");
        this.setActionTarget("MULTIKEY");
        this.setDEActionName("CreateDefaultVR");
        this.setReloadData(true);
    }
}

