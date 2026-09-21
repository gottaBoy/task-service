/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.demodel.DEUIActionModelBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psder.uiaction;

import net.ibizsys.paas.demodel.DEUIActionModelBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDER;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSDERCreateDefaultVRUIActionModelBase
extends DEUIActionModelBase<PSDER> {
    private static final Log log = LogFactory.getLog(PSDERCreateDefaultVRUIActionModelBase.class);

    public PSDERCreateDefaultVRUIActionModelBase() {
        this.setId("43E9ED5A-10D9-4509-AA20-44846A8CD059");
        this.setName("CreateDefaultVR");
        this.setActionTarget("MULTIKEY");
        this.setDEActionName("CreateDefaultVR");
        this.setSuccessMsg("\u5efa\u7acb\u9ed8\u8ba4\u503c\u89c4\u5219\u6210\u529f\uff01");
    }
}

