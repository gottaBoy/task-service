/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.demodel.DEUIActionModelBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.wxdesign.demodel.pswxmenu.uiaction;

import net.ibizsys.paas.demodel.DEUIActionModelBase;
import net.ibizsys.pscore.srv.wxdesign.entity.PSWXMenu;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSWXMenuPreviewSaveUIActionModelBase
extends DEUIActionModelBase<PSWXMenu> {
    private static final Log log = LogFactory.getLog(PSWXMenuPreviewSaveUIActionModelBase.class);

    public PSWXMenuPreviewSaveUIActionModelBase() {
        this.setId("2DE60821-787A-410A-B8DF-03516914EEE1");
        this.setName("PreviewSave");
        this.setActionTarget("SINGLEKEY");
        this.setDEActionName("PreviewSave");
    }
}

