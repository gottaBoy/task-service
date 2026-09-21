/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.app.view.IPSAppDEWFView
 *  net.ibizsys.model.dataentity.IPSDataEntity
 *  net.ibizsys.model.dataentity.wf.IPSDEWF
 *  net.ibizsys.model.wf.IPSWFVersion
 *  net.ibizsys.model.wf.IPSWorkflow
 */
package net.ibizsys.model.app.view;

import net.ibizsys.model.app.view.IPSAppDEWFView;
import net.ibizsys.model.app.view.PSAppUtilViewImpl;
import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.dataentity.wf.IPSDEWF;
import net.ibizsys.model.wf.IPSWFVersion;
import net.ibizsys.model.wf.IPSWorkflow;

public class PSAppUtilWFViewImpl
extends PSAppUtilViewImpl
implements IPSAppDEWFView {
    public String getPSDEViewId() {
        return null;
    }

    public String getPSDEViewName() {
        return null;
    }

    @Override
    public IPSDataEntity getPSDataEntity() {
        return null;
    }

    public int getTempMode() {
        return 0;
    }

    public IPSDEWF getPSDEWF() {
        return null;
    }

    public IPSWFVersion getPSWFVersion() {
        return null;
    }

    public IPSWorkflow getPSWorkflow() {
        return null;
    }

    public boolean isWFIAMode() {
        return false;
    }

    @Override
    public boolean isEnableWF() {
        return true;
    }
}

