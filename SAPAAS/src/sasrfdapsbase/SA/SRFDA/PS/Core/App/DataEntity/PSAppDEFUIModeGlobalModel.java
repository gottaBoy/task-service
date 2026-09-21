/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.App.DataEntity;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEFUIMode;
import SA.SRFDA.PS.Core.App.DataEntity.PSAppDEFieldGlobalModelBase;
import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.DEField.IPSDEFUIMode;
import SA.SRFDA.PS.Data.PSDEFUIMode;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.Vector;
import net.ibizsys.paas.util.KeyValueHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppDEFUIModeGlobalModel
extends PSAppDEFieldGlobalModelBase<String, PSDEFUIMode, IPSAppDEFUIMode> {
    private static final Log log = LogFactory.getLog(PSAppDEFUIModeGlobalModel.class);

    @Override
    protected PSDEFUIMode GetObject(String strPSDEFUIModeId) {
        if (this.isPrepareModels()) {
            return null;
        }
        log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027\u754c\u9762\u914d\u7f6e[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDEFUIModeId, (Object)"\u4e0d\u652f\u6301\u6307\u5b9a\u83b7\u53d6"));
        return null;
    }

    @Override
    protected IPSAppDEFUIMode OnCreateModelHelper(PSDEFUIMode vt) throws Exception {
        IPSDEFUIMode iPSDEFUIMode = this.getPSDEField().createPSDEFUIMode(vt);
        IPSAppDEFUIMode iPSAppDEFUIMode = null;
        if (iPSDEFUIMode instanceof IPSAppDEFUIMode) {
            iPSAppDEFUIMode = (IPSAppDEFUIMode)iPSDEFUIMode;
        }
        if (iPSAppDEFUIMode == null) {
            throw new Exception(StringHelper.Format((String)"\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u5bf9\u8c61\u65e0\u6548"));
        }
        iPSAppDEFUIMode.init(this.iDAGlobalHelper, this.getPSAppDEField(), vt);
        return iPSAppDEFUIMode;
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
        IPSApplication iPSApplication = this.getPSAppDEField().getPSAppDataEntity().getPSApplication();
        ArrayList<PSDEFUIMode> psDEFUIModeList = this.getPSAppDEField().getPSDEField().getPSDEFieldData().getPSDEFUIModes(false);
        if (psDEFUIModeList != null) {
            for (PSDEFUIMode psDEFUIMode : psDEFUIModeList) {
                if (!iPSApplication.isMobileApp() && StringHelper.Compare((String)psDEFUIMode.getFTMODE(), (String)"DEFAULT", (boolean)true) == 0) {
                    defaultPSDEFUIMode = psDEFUIMode;
                    this.setModel(psDEFUIMode.getPSDEFFORMITEMID(), psDEFUIMode, null);
                    this.setModel(psDEFUIMode.getFTMODE(), psDEFUIMode, null);
                    continue;
                }
                if (iPSApplication.isMobileApp() && StringHelper.Compare((String)psDEFUIMode.getFTMODE(), (String)"MOBILEDEFAULT", (boolean)true) == 0) {
                    mobileDefaultPSDEFUIMode = psDEFUIMode;
                    this.setModel(psDEFUIMode.getPSDEFFORMITEMID(), psDEFUIMode, null);
                    this.setModel(psDEFUIMode.getFTMODE(), psDEFUIMode, null);
                    continue;
                }
                if (StringHelper.Compare((String)psDEFUIMode.getFTMODE(), (String)"APPDEFAULT", (boolean)true) == 0) {
                    this.setModel(psDEFUIMode.getPSDEFFORMITEMID(), psDEFUIMode, null);
                    if (StringHelper.IsNullOrEmpty((String)psDEFUIMode.getPSSYSAPPID()) || StringHelper.Compare((String)psDEFUIMode.getPSSYSAPPID(), (String)iPSApplication.getId(), (boolean)false) != 0) continue;
                    String strUIMode = StringHelper.Format((String)"%1$s:%2$s", (Object)psDEFUIMode.getFTMODE(), (Object)psDEFUIMode.getPSSYSAPPID());
                    this.setModel(strUIMode, psDEFUIMode, null);
                    continue;
                }
                if (StringHelper.Compare((String)psDEFUIMode.getFTMODE(), (String)"CUSTOM", (boolean)true) != 0) {
                    this.setModel(psDEFUIMode.getPSDEFFORMITEMID(), psDEFUIMode, null);
                    this.setModel(psDEFUIMode.getFTMODE(), psDEFUIMode, null);
                    continue;
                }
                this.setModel(psDEFUIMode.getPSDEFFORMITEMID(), psDEFUIMode, null);
            }
        }
        if (!iPSApplication.isMobileApp() && defaultPSDEFUIMode == null) {
            defaultPSDEFUIMode = new PSDEFUIMode();
            defaultPSDEFUIMode.setPSDEFFORMITEMID(KeyValueHelper.genGuidEx());
            defaultPSDEFUIMode.setPSDEFFORMITEMNAME("\u9ed8\u8ba4");
            defaultPSDEFUIMode.setPSDEFID(this.getPSDEField().getId());
            defaultPSDEFUIMode.setPSDEFNAME(this.getPSDEField().getName());
            defaultPSDEFUIMode.setFTMODE("DEFAULT");
            this.setModel(defaultPSDEFUIMode.getFTMODE(), defaultPSDEFUIMode, null);
        }
        if (iPSApplication.isMobileApp() && mobileDefaultPSDEFUIMode == null && defaultPSDEFUIMode != null) {
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
        if (this.getPSAppDEField() != null) {
            return this.getPSAppDEField().getName();
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
    protected IPSAppDEFUIMode registerModel(PSDEFUIMode vt) throws Exception {
        IPSAppDEFUIMode iPSDEFUIMode = (IPSAppDEFUIMode)this.InternalGetModelHelper(vt.getPSDEFFORMITEMID());
        if (iPSDEFUIMode != null) {
            return iPSDEFUIMode;
        }
        this.setModel(vt.getPSDEFFORMITEMID(), vt, null);
        iPSDEFUIMode = (IPSAppDEFUIMode)this.FindModelHelper(vt.getPSDEFFORMITEMID());
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

