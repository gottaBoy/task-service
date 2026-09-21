/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.demodel.DEUIActionModelBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.search.demodel.pssyssearchde.uiaction;

import net.ibizsys.paas.demodel.DEUIActionModelBase;
import net.ibizsys.pscore.srv.search.entity.PSSysSearchDE;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSSysSearchDEBuildSearchDEFieldsUIActionModelBase
extends DEUIActionModelBase<PSSysSearchDE> {
    private static final Log log = LogFactory.getLog(PSSysSearchDEBuildSearchDEFieldsUIActionModelBase.class);

    public PSSysSearchDEBuildSearchDEFieldsUIActionModelBase() {
        this.setId("52F9D35A-91CF-471B-83F5-B5547D9763EA");
        this.setName("BuildSearchDEFields");
        this.setActionTarget("SINGLEKEY");
        this.setDEActionName("BuildSearchDEFields");
        this.setReloadData(true);
    }
}

