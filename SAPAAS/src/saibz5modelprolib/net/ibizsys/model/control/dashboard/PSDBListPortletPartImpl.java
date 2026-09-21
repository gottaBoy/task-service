/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.IPSControl
 *  net.ibizsys.model.control.dashboard.IPSDBListPortletPart
 *  net.ibizsys.model.control.list.IPSList
 */
package net.ibizsys.model.control.dashboard;

import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.dashboard.IPSDBListPortletPart;
import net.ibizsys.model.control.dashboard.PSDBSysPortletPartImpl;
import net.ibizsys.model.control.list.IPSList;
import net.ibizsys.model.control.list.PSDEListParamImpl;
import net.ibizsys.model.res.IPSSysDEListPortlet;

public class PSDBListPortletPartImpl
extends PSDBSysPortletPartImpl
implements IPSDBListPortletPart {
    public static final String LISTNAME = "_list";
    private IPSList iPSList = null;

    @Override
    protected void onInit() throws Exception {
        IPSSysDEListPortlet iPSSysDEListPortlet = (IPSSysDEListPortlet)this.iPSSysPortlet;
        PSDEListParamImpl psDEListParamImpl = new PSDEListParamImpl();
        psDEListParamImpl.setPSDEListId(iPSSysDEListPortlet.getPSDEListId());
        psDEListParamImpl.setPSDEDataSetId(iPSSysDEListPortlet.getPSDEDataSetId());
        psDEListParamImpl.setActiveDataPSDELogicId(iPSSysDEListPortlet.getActiveDataPSDELogicId());
        if (iPSSysDEListPortlet.getHeight() > 0) {
            psDEListParamImpl.setHeight(Double.valueOf(iPSSysDEListPortlet.getHeight()));
        }
        this.iPSList = (IPSList)this.registerPSControl(String.valueOf(this.getName()) + LISTNAME, "LIST", psDEListParamImpl);
        super.onInit();
    }

    public IPSList getPSList() {
        return this.iPSList;
    }

    @Override
    public IPSControl getContentPSControl() {
        return this.getPSList();
    }
}

