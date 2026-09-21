/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.demodel.DEUIActionModelBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.helpdesign.demodel.pshelparticle.uiaction;

import net.ibizsys.paas.demodel.DEUIActionModelBase;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpArticle;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSHelpArticleInitModelUIActionModelBase
extends DEUIActionModelBase<PSHelpArticle> {
    private static final Log log = LogFactory.getLog(PSHelpArticleInitModelUIActionModelBase.class);

    public PSHelpArticleInitModelUIActionModelBase() {
        this.setId("60598AEE-5BE4-4D79-B9C2-EA11575DD72D");
        this.setName("InitModel");
        this.setActionTarget("MULTIKEY");
        this.setDEActionName("INITMODEL");
        this.setReloadData(true);
        this.setSuccessMsg("\u521d\u59cb\u5316\u6587\u6863\u5b8c\u6210\uff01");
    }
}

