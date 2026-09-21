/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.dataentity.field.IPSDEFUIMode
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.dataentity.field;

import java.util.ArrayList;
import net.ibizsys.model.dataentity.field.IPSDEFUIMode;
import net.ibizsys.model.dataentity.field.IPSDEFUIModeRuntime;
import net.ibizsys.model.dataentity.field.IPSDEFieldRuntime;
import net.ibizsys.model.dataentity.field.PSDEFieldGlobalModelBase;
import net.ibizsys.model.entity.PSDEFUIMode;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEFUIModeGlobalModel
extends PSDEFieldGlobalModelBase<String, PSDEFUIMode, IPSDEFUIMode> {
    private static final Log log = LogFactory.getLog(PSDEFUIModeGlobalModel.class);

    @Override
    protected PSDEFUIMode getObject(String strPSDEFUIModeId) {
        log.error((Object)StringHelper.format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5b9e\u4f53\u5c5e\u6027\u8868\u5355\u9879\u914d\u7f6e[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDEFUIModeId, (Object)"\u4e0d\u652f\u6301\u6307\u5b9a\u83b7\u53d6"));
        return null;
    }

    @Override
    protected IPSDEFUIMode onCreateModelHelper(PSDEFUIMode vt) throws Exception {
        IPSDEFUIMode iPSDEFUIMode = ((IPSDEFieldRuntime)this.getPSDEField()).createPSDEFUIMode(vt);
        ((IPSDEFUIModeRuntime)iPSDEFUIMode).init(this.getPSModelStorageContext(), this.iPSDEField, vt);
        return iPSDEFUIMode;
    }

    @Override
    protected Boolean testObjectRenew(PSDEFUIMode obj) {
        return false;
    }

    @Override
    protected void onPreloadModels() {
        super.onPreloadModels();
        ArrayList<PSDEFUIMode> psDEFUIModeList = ((IPSDEFieldRuntime)this.getPSDEField()).getPSDEFieldData().getPSDEFUIModes(false);
        if (psDEFUIModeList == null) {
            return;
        }
        PSDEFUIMode defaultPSDEFUIMode = null;
        PSDEFUIMode mobileDefaultPSDEFUIMode = null;
        for (PSDEFUIMode psDEFUIMode : psDEFUIModeList) {
            this.setModel(psDEFUIMode.getPSDEFFORMITEMID(), psDEFUIMode, null);
            if (StringHelper.compare((String)psDEFUIMode.getFTMODE(), (String)"DEFAULT", (boolean)true) == 0) {
                defaultPSDEFUIMode = psDEFUIMode;
                this.setModel(psDEFUIMode.getFTMODE(), psDEFUIMode, null);
                continue;
            }
            if (StringHelper.compare((String)psDEFUIMode.getFTMODE(), (String)"MOBILEDEFAULT", (boolean)true) != 0) continue;
            mobileDefaultPSDEFUIMode = psDEFUIMode;
            this.setModel(psDEFUIMode.getFTMODE(), psDEFUIMode, null);
        }
        if (mobileDefaultPSDEFUIMode == null && defaultPSDEFUIMode != null) {
            mobileDefaultPSDEFUIMode = new PSDEFUIMode();
            try {
                defaultPSDEFUIMode.copyTo((IDataObject)mobileDefaultPSDEFUIMode, false);
            }
            catch (Exception ex) {
                log.error((Object)ex);
            }
            mobileDefaultPSDEFUIMode.setFTMODE("MOBILEDEFAULT");
            this.setModel(mobileDefaultPSDEFUIMode.getFTMODE(), mobileDefaultPSDEFUIMode, null);
        }
    }

    @Override
    protected String getObjectId(PSDEFUIMode vt) {
        return vt.getPSDEFFORMITEMID();
    }

    @Override
    protected String getModelInfo() {
        if (this.iPSDEField != null) {
            return this.iPSDEField.getName();
        }
        return super.getModelInfo();
    }
}

