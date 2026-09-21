/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.psrt.srv.common.demodel.org.uiaction;

import net.ibizsys.paas.demodel.DEUIActionModelBase;
import net.ibizsys.psrt.srv.common.entity.Org;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class OrgInitAllUIActionModelBase
extends DEUIActionModelBase<Org> {
    private static final Log log = LogFactory.getLog(OrgInitAllUIActionModelBase.class);

    public OrgInitAllUIActionModelBase() {
        this.setId("04647C73-AFFA-4495-9D53-D1B874C1AA15");
        this.setName("InitAll");
        this.setActionTarget("MULTIKEY");
        this.setDEActionName("InitAll");
        this.setSuccessMsg("\u521d\u59cb\u5316\u673a\u6784\u76f8\u5173\u6570\u636e\u5b8c\u6210\uff01");
    }
}

