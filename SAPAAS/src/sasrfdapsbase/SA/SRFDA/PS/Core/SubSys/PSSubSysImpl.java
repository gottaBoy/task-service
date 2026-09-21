/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.SubSys;

import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.SubSys.IPSSubApp;
import SA.SRFDA.PS.Core.SubSys.IPSSubDE;
import SA.SRFDA.PS.Core.SubSys.IPSSubDEView;
import SA.SRFDA.PS.Core.SubSys.IPSSubSys;
import SA.SRFDA.PS.Core.SubSys.IPSSubSysSF;
import SA.SRFDA.PS.Core.SubSys.IPSSubSysVer;
import SA.SRFDA.PS.Core.SubSys.PSSubAppGlobalModel;
import SA.SRFDA.PS.Core.SubSys.PSSubDEGlobalModel;
import SA.SRFDA.PS.Core.SubSys.PSSubDEViewGlobalModel;
import SA.SRFDA.PS.Core.SubSys.PSSubSysSFGlobalModel;
import SA.SRFDA.PS.Core.SubSys.PSSubSysVerGlobalModel;
import SA.SRFDA.PS.Data.PSSubSys;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import java.util.Iterator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSubSysImpl
extends PSObjectImpl
implements IPSSubSys {
    private static final Log log = LogFactory.getLog(PSSubSysImpl.class);
    protected PSSubSys psSubSys = null;
    protected PSSubDEViewGlobalModel psSubDEViewGlobalModel = new PSSubDEViewGlobalModel();
    protected PSSubDEGlobalModel psSubDEGlobalModel = new PSSubDEGlobalModel();
    protected PSSubAppGlobalModel psSubAppGlobalModel = new PSSubAppGlobalModel();
    protected PSSubSysSFGlobalModel psSubSysSFGlobalModel = new PSSubSysSFGlobalModel();
    protected PSSubSysVerGlobalModel psSubSysVerGlobalModel = new PSSubSysVerGlobalModel();
    private boolean bLoadAll = false;
    private boolean bDefaultFlag = false;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSSubSys psSubSys) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.psSubSys = psSubSys;
        this.setId(this.psSubSys.getPSSUBSYSID());
        this.setName(this.psSubSys.getPSSUBSYSNAME());
        this.setPSObjectData(this.psSubSys);
        this.psSubDEViewGlobalModel.Init(iDAGlobalHelper, this);
        this.psSubDEGlobalModel.Init(iDAGlobalHelper, this);
        this.psSubSysSFGlobalModel.Init(iDAGlobalHelper, this);
        this.psSubAppGlobalModel.Init(iDAGlobalHelper, this);
        this.psSubSysVerGlobalModel.Init(iDAGlobalHelper, this);
        this.onInit();
    }

    @Override
    public IPSSubDEView getPSSubDEView(String strPSSubDEViewId) throws Exception {
        IPSSubDEView iPSSubDEView = (IPSSubDEView)this.psSubDEViewGlobalModel.FindModelHelper(strPSSubDEViewId, true);
        if (iPSSubDEView == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5b50\u7cfb\u7edf\u5b9e\u4f53\u89c6\u56fe\uff0c\u6807\u8bc6\u4e3a[%1$s]", (Object)strPSSubDEViewId));
        }
        return iPSSubDEView;
    }

    @Override
    public void resetPSSubDEView(String strPSSubDEViewId) {
        this.psSubDEViewGlobalModel.ResetModel(strPSSubDEViewId);
    }

    @Override
    public IPSSubDE getPSSubDE(String strPSSubDEId) throws Exception {
        return (IPSSubDE)this.psSubDEGlobalModel.FindModelHelper(strPSSubDEId);
    }

    @Override
    public void resetPSSubDE(String strPSSubDEId) {
        this.psSubDEGlobalModel.ResetModel(strPSSubDEId);
    }

    @Override
    public IPSSubSysSF getPSSubSysSF(String strPSSubSysSFId) throws Exception {
        return (IPSSubSysSF)this.psSubSysSFGlobalModel.FindModelHelper(strPSSubSysSFId);
    }

    @Override
    public void resetPSSubSysSF(String strPSSubSysSFId) {
        this.psSubSysSFGlobalModel.ResetModel(strPSSubSysSFId);
    }

    @Override
    public Iterator<IPSSubSysSF> getAllPSSubSysSFs() throws Exception {
        return this.psSubSysSFGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSSubSysSF getPSSubSysSFBySFStyle(String strPSSFStyleId, boolean bTryMode) throws Exception {
        return this.psSubSysSFGlobalModel.getPSSubSysSFBySFStyle(strPSSFStyleId, bTryMode);
    }

    @Override
    public IPSSubApp getPSSubApp(String strPSSubAppId) throws Exception {
        return (IPSSubApp)this.psSubAppGlobalModel.FindModelHelper(strPSSubAppId);
    }

    @Override
    public void resetPSSubApp(String strPSSubAppId) {
        this.psSubAppGlobalModel.ResetModel(strPSSubAppId);
    }

    @Override
    public Iterator<IPSSubDEView> getAllPSSubDEViews() throws Exception {
        return this.psSubDEViewGlobalModel.getAllModelHelpers();
    }

    @Override
    public void loadAll() throws Exception {
        this.getAllPSSubSysSFs();
        this.getAllPSSubDEViews();
        this.bLoadAll = true;
    }

    @Override
    public boolean isLoadAll() {
        return this.bLoadAll;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    public IPSSubSysVer getPSSubSysVer(String strPSSubSysVerId) throws Exception {
        return (IPSSubSysVer)this.psSubSysVerGlobalModel.FindModelHelper(strPSSubSysVerId);
    }

    @Override
    public void resetPSSubSysVer(String strPSSubSysVerId) {
        this.psSubSysVerGlobalModel.ResetModel(strPSSubSysVerId);
    }

    @Override
    public Iterator<IPSSubSysVer> getAllPSSubSysVers() throws Exception {
        return this.psSubSysVerGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSSubSysVer getPSSubSysVerByVer(int nVersion) throws Exception {
        return this.psSubSysVerGlobalModel.getPSSubSysVerByVer(nVersion, false);
    }
}

