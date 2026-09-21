/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DEField;

import SA.SRFDA.PS.Core.DEField.IPSDEFUIMode;
import SA.SRFDA.PS.Core.DEField.PSDEFieldGlobalModelBase;
import SA.SRFDA.PS.Data.PSDEFUIMode;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.Vector;
import net.ibizsys.paas.util.KeyValueHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEFUIModeGlobalModel
extends PSDEFieldGlobalModelBase<String, PSDEFUIMode, IPSDEFUIMode> {
    private static final Log log = LogFactory.getLog(PSDEFUIModeGlobalModel.class);

    @Override
    protected PSDEFUIMode GetObject(String strPSDEFUIModeId) {
        if (this.isPrepareModels()) {
            return null;
        }
        log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u5c5e\u6027\u754c\u9762\u914d\u7f6e[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDEFUIModeId, (Object)"\u4e0d\u652f\u6301\u6307\u5b9a\u83b7\u53d6"));
        return null;
    }

    @Override
    protected IPSDEFUIMode OnCreateModelHelper(PSDEFUIMode vt) throws Exception {
        IPSDEFUIMode iPSDEFUIMode = this.getPSDEField().createPSDEFUIMode(vt);
        iPSDEFUIMode.init(this.iDAGlobalHelper, this.iPSDEField, vt);
        return iPSDEFUIMode;
    }

    @Override
    protected Boolean TestObjectRenew(PSDEFUIMode obj) {
        return false;
    }

    @Override
    protected void onPreloadModels() {
        super.onPreloadModels();
        PSDEFUIMode defaultPSDEFUIMode = null;
        PSDEFUIMode mobileDefaultPSDEFUIMode = null;
        ArrayList<PSDEFUIMode> psDEFUIModeList = this.getPSDEField().getPSDEFieldData().getPSDEFUIModes(false);
        if (psDEFUIModeList != null) {
            for (PSDEFUIMode psDEFUIMode : psDEFUIModeList) {
                this.setModel(psDEFUIMode.getPSDEFFORMITEMID(), psDEFUIMode, null);
                if (StringHelper.Compare((String)psDEFUIMode.getFTMODE(), (String)"DEFAULT", (boolean)true) == 0) {
                    defaultPSDEFUIMode = psDEFUIMode;
                    this.setModel(psDEFUIMode.getFTMODE(), psDEFUIMode, null);
                    continue;
                }
                if (StringHelper.Compare((String)psDEFUIMode.getFTMODE(), (String)"MOBILEDEFAULT", (boolean)true) == 0) {
                    mobileDefaultPSDEFUIMode = psDEFUIMode;
                    this.setModel(psDEFUIMode.getFTMODE(), psDEFUIMode, null);
                    continue;
                }
                if (StringHelper.Compare((String)psDEFUIMode.getFTMODE(), (String)"APPDEFAULT", (boolean)true) == 0) {
                    if (StringHelper.IsNullOrEmpty((String)psDEFUIMode.getPSSYSAPPID())) continue;
                    String strUIMode = StringHelper.Format((String)"%1$s:%2$s", (Object)psDEFUIMode.getFTMODE(), (Object)psDEFUIMode.getPSSYSAPPID());
                    this.setModel(strUIMode, psDEFUIMode, null);
                    continue;
                }
                if (StringHelper.Compare((String)psDEFUIMode.getFTMODE(), (String)"CUSTOM", (boolean)true) == 0) continue;
                this.setModel(psDEFUIMode.getFTMODE(), psDEFUIMode, null);
            }
        }
        if (defaultPSDEFUIMode == null) {
            defaultPSDEFUIMode = new PSDEFUIMode();
            defaultPSDEFUIMode.setPSDEFFORMITEMID(KeyValueHelper.genGuidEx());
            defaultPSDEFUIMode.setPSDEFFORMITEMNAME("\u9ed8\u8ba4");
            defaultPSDEFUIMode.setPSDEFID(this.getPSDEField().getId());
            defaultPSDEFUIMode.setPSDEFNAME(this.getPSDEField().getName());
            defaultPSDEFUIMode.setFTMODE("DEFAULT");
            this.setModel(defaultPSDEFUIMode.getFTMODE(), defaultPSDEFUIMode, null);
        }
        if (mobileDefaultPSDEFUIMode == null && defaultPSDEFUIMode != null) {
            mobileDefaultPSDEFUIMode = new PSDEFUIMode();
            defaultPSDEFUIMode.CopyTo(mobileDefaultPSDEFUIMode, false);
            mobileDefaultPSDEFUIMode.setFTMODE("MOBILEDEFAULT");
            mobileDefaultPSDEFUIMode.setCODENAME("");
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

    @Override
    protected Vector<PSDEFUIMode> getAllModels() throws Exception {
        Vector<PSDEFUIMode> psDEFUIModeList = new Vector<PSDEFUIMode>();
        ArrayList<PSDEFUIMode> psDEFUIModeList2 = this.getPSDEField().getPSDEFieldData().getPSDEFUIModes(false);
        if (psDEFUIModeList2 == null) {
            return psDEFUIModeList;
        }
        psDEFUIModeList.addAll(psDEFUIModeList2);
        return psDEFUIModeList;
    }

    @Override
    protected IPSDEFUIMode registerModel(PSDEFUIMode vt) throws Exception {
        IPSDEFUIMode iPSDEFUIMode = (IPSDEFUIMode)this.InternalGetModelHelper(vt.getPSDEFFORMITEMID());
        if (iPSDEFUIMode != null) {
            return iPSDEFUIMode;
        }
        this.setModel(vt.getPSDEFFORMITEMID(), vt, null);
        iPSDEFUIMode = (IPSDEFUIMode)this.FindModelHelper(vt.getPSDEFFORMITEMID());
        return iPSDEFUIMode;
    }

    @Override
    protected boolean isEnableObjectAlias() {
        return true;
    }

    protected String[] getObjectAliases(PSDEFUIMode vt) {
        if (!StringHelper.IsNullOrEmpty((String)vt.getCODENAME())) {
            return new String[]{vt.getCODENAME().toUpperCase()};
        }
        return (String[])super.getObjectAliases(vt);
    }
}

