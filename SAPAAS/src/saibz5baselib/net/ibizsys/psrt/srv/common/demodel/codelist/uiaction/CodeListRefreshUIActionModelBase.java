/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.psrt.srv.common.demodel.codelist.uiaction;

import net.ibizsys.paas.demodel.DEUIActionModelBase;
import net.ibizsys.psrt.srv.common.entity.CodeList;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class CodeListRefreshUIActionModelBase
extends DEUIActionModelBase<CodeList> {
    private static final Log log = LogFactory.getLog(CodeListRefreshUIActionModelBase.class);

    public CodeListRefreshUIActionModelBase() {
        this.setId("21C9ECE1-5A81-4448-A892-B674240C1FCB");
        this.setName("Refresh");
        this.setActionTarget("MULTIKEY");
        this.setDEActionName("Refresh");
        this.setReloadData(true);
        this.setSuccessMsg("\u5237\u65b0\u4ee3\u7801\u8868\u6210\u529f\uff01");
    }
}

