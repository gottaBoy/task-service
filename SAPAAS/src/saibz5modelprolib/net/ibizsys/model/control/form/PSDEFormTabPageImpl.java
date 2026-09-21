/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.form.IPSDEFormDetail
 *  net.ibizsys.model.control.form.IPSDEFormTabPage
 */
package net.ibizsys.model.control.form;

import java.util.Iterator;
import net.ibizsys.model.control.form.IPSDEFormDetail;
import net.ibizsys.model.control.form.IPSDEFormTabPage;
import net.ibizsys.model.control.form.PSDEFormBaseGroupPanelImpl;

public class PSDEFormTabPageImpl
extends PSDEFormBaseGroupPanelImpl
implements IPSDEFormTabPage {
    public Iterator<IPSDEFormDetail> getPSDEFormDetails() {
        return this.psDEFormDetailList.iterator();
    }

    public boolean isEnableAnchor() {
        return false;
    }

    public int getBuildInActions() {
        return 0;
    }

    public boolean isEnableBuildInAction(int nAction) {
        return false;
    }

    public int getPSDEFormDetailCount() {
        return this.psDEFormDetailList.size();
    }

    public IPSDEFormDetail getPSDEFormDetail(int nIndex) throws Exception {
        return (IPSDEFormDetail)this.psDEFormDetailList.get(nIndex);
    }
}

