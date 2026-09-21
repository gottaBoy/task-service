/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.demodel.DEUIActionModelBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.devcenter.demodel.psdccodesnippet.uiaction;

import net.ibizsys.paas.demodel.DEUIActionModelBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCCodeSnippet;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSDCCodeSnippetPublishUIActionModelBase
extends DEUIActionModelBase<PSDCCodeSnippet> {
    private static final Log log = LogFactory.getLog(PSDCCodeSnippetPublishUIActionModelBase.class);

    public PSDCCodeSnippetPublishUIActionModelBase() {
        this.setId("23ACABDB-CF9D-4141-B930-45986EFE5E7B");
        this.setName("Publish");
        this.setActionTarget("MULTIKEY");
        this.setDEActionName("PUBLISH");
        this.setReloadData(true);
        this.setSuccessMsg("\u53d1\u5e03\u6a21\u677f\u6210\u529f\uff01");
    }
}

