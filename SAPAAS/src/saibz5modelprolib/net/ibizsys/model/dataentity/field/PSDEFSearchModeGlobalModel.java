/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.dataentity.field.IPSDEFSearchMode
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.dataentity.field;

import java.util.ArrayList;
import java.util.Vector;
import net.ibizsys.model.dataentity.field.IPSDEFSearchMode;
import net.ibizsys.model.dataentity.field.IPSDEFSearchModeRuntime;
import net.ibizsys.model.dataentity.field.IPSDEFieldRuntime;
import net.ibizsys.model.dataentity.field.PSDEFieldGlobalModelBase;
import net.ibizsys.model.entity.PSDEFSearchMode;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEFSearchModeGlobalModel
extends PSDEFieldGlobalModelBase<String, PSDEFSearchMode, IPSDEFSearchMode> {
    private static final Log log = LogFactory.getLog(PSDEFSearchModeGlobalModel.class);

    @Override
    protected PSDEFSearchMode getObject(String strPSDEFSearchModeId) {
        log.error((Object)StringHelper.format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5b9e\u4f53\u5c5e\u6027\u641c\u7d22\u6a21\u5f0f[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDEFSearchModeId, (Object)"\u4e0d\u652f\u6301\u6307\u5b9a\u83b7\u53d6"));
        return null;
    }

    @Override
    protected IPSDEFSearchMode onCreateModelHelper(PSDEFSearchMode vt) throws Exception {
        IPSDEFSearchMode iPSDEFSearchMode = ((IPSDEFieldRuntime)this.getPSDEField()).createPSDEFSearchMode(vt);
        ((IPSDEFSearchModeRuntime)iPSDEFSearchMode).init(this.getPSModelStorageContext(), this.iPSDEField, vt);
        return iPSDEFSearchMode;
    }

    @Override
    protected Boolean testObjectRenew(PSDEFSearchMode obj) {
        return false;
    }

    @Override
    protected void onPreloadModels() {
        super.onPreloadModels();
        try {
            this.getAllModelHelpers();
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
    }

    @Override
    protected IPSDEFSearchMode registerModel(PSDEFSearchMode vt) throws Exception {
        IPSDEFSearchMode iPSDEFSearchMode = (IPSDEFSearchMode)this.internalGetModelHelper(vt.getPSDEFSFITEMID());
        if (iPSDEFSearchMode != null) {
            return iPSDEFSearchMode;
        }
        this.setModel(vt.getPSDEFSFITEMID(), vt, null);
        this.setModel(vt.getPSDEFSFITEMNAME(), vt, null);
        return (IPSDEFSearchMode)this.findModelHelper(vt.getPSDEFSFITEMID());
    }

    @Override
    protected Vector<PSDEFSearchMode> getAllModels() throws Exception {
        Vector<PSDEFSearchMode> psDEFSearchModeList = new Vector<PSDEFSearchMode>();
        ArrayList<PSDEFSearchMode> psDEFSearchModeList2 = ((IPSDEFieldRuntime)this.getPSDEField()).getPSDEFieldData().getPSDEFSearchModes(false);
        if (psDEFSearchModeList2 == null) {
            return psDEFSearchModeList;
        }
        psDEFSearchModeList.addAll(psDEFSearchModeList2);
        return psDEFSearchModeList;
    }

    @Override
    protected String getObjectId(PSDEFSearchMode vt) {
        return vt.getPSDEFSFITEMID();
    }

    @Override
    protected String getModelInfo() {
        if (this.iPSDEField != null) {
            return this.iPSDEField.getName();
        }
        return super.getModelInfo();
    }
}

