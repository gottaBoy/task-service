/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.App.WF;

import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.PSApplicationObjectImpl;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.WF.IPSAppWF;
import SA.SRFDA.PS.Core.App.WF.IPSAppWFUIAction;
import SA.SRFDA.PS.Core.App.WF.IPSAppWFUIActionGroup;
import SA.SRFDA.PS.Core.App.WF.IPSAppWFVer;
import SA.SRFDA.PS.Core.App.WF.PSAppWFUIActionGlobalModel;
import SA.SRFDA.PS.Core.App.WF.PSAppWFUIActionGroupGlobalModel;
import SA.SRFDA.PS.Core.DataEntity.WF.IPSDEWF;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.WF.IPSWFDE;
import SA.SRFDA.PS.Core.WF.IPSWFVersion;
import SA.SRFDA.PS.Data.PSAppWFVer;
import SA.SRFDA.PS.Data.PSDEViewBase;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppWFVerImpl
extends PSApplicationObjectImpl
implements IPSAppWFVer {
    private static final Log log = LogFactory.getLog(PSAppWFVerImpl.class);
    protected PSAppWFVer psAppWFVer = null;
    private IPSAppWF iPSAppWF = null;
    private IPSWFVersion iPSWFVersion = null;
    protected PSAppWFUIActionGlobalModel psAppWFUIActionGlobalModel = new PSAppWFUIActionGlobalModel();
    protected PSAppWFUIActionGroupGlobalModel psAppWFUIActionGroupGlobalModel = new PSAppWFUIActionGroupGlobalModel();
    private List<IPSAppView> psAppViewList = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSApplication iPSApplication, PSAppWFVer psAppWFVer) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSApplication(iPSApplication);
            this.psAppWFVer = psAppWFVer;
            this.setId(this.psAppWFVer.getPSAPPWFID());
            this.setName(this.psAppWFVer.getPSAPPWFNAME());
            this.setPSObjectData(psAppWFVer);
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psAppWFVer.getPSAPPWFID())) {
                throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5e94\u7528\u5de5\u4f5c\u6d41\u6807\u8bc6");
            }
            this.iPSAppWF = this.getPSApplication().getPSAppWF(this.psAppWFVer.getPSAPPWFID());
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psAppWFVer.getPSWFVERSIONID())) {
                throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5de5\u4f5c\u6d41\u7248\u672c\u6807\u8bc6");
            }
            this.iPSWFVersion = this.getPSAppWF().getPSWorkflow().getPSWFVersion(this.psAppWFVer.getPSWFVERSIONID());
            this.setName(this.iPSWFVersion.getName());
            this.psAppWFUIActionGlobalModel.Init(iDAGlobalHelper, this);
            this.psAppWFUIActionGroupGlobalModel.Init(iDAGlobalHelper, this);
            this.onInit();
        }
        catch (Exception ex) {
            String strLogName = SA.SRFramework.Utility.StringHelper.Format((String)"%1$s[%2$s]", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = SA.SRFramework.Utility.StringHelper.Format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)SA.SRFramework.Utility.StringHelper.Format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            if (this.getPSSystemUtil() != null) {
                this.getPSSystemUtil().getPSSysConsole().error(strLogName, strExInfo);
            }
            this.throwInitException(ex);
        }
    }

    @Override
    protected void onInit() throws Exception {
        this.psAppWFUIActionGlobalModel.getAllModelHelpers();
        this.psAppWFUIActionGroupGlobalModel.getAllModelHelpers();
        super.onInit();
    }

    @Override
    public String getModelType() {
        return "PSAPPWFVER";
    }

    @Override
    public String getFullModelName() {
        return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s|%2$s", (Object)this.getPSApplication().getFullModelName(), (Object)this.getModelName());
    }

    @Override
    public String getModelId() {
        return super.getModelId();
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5de5\u4f5c\u6d41", dumpref=true, from="IPSApplication")
    public IPSAppWF getPSAppWF() {
        return this.iPSAppWF;
    }

    @Override
    @PSModelRTMeta(description="\u5de5\u4f5c\u6d41\u7248\u672c", ignorepf=true, dumpref=true, from="__self__", from_method="getPSAppWFMust().getPSWorkflowMust().getPSWFVersion")
    public IPSWFVersion getPSWFVersion() {
        return this.iPSWFVersion;
    }

    @Override
    public IPSAppWFUIAction getPSAppWFUIAction(String strDEUIActionId) throws Exception {
        return (IPSAppWFUIAction)this.psAppWFUIActionGlobalModel.FindModelHelper(strDEUIActionId);
    }

    @Override
    public IPSAppWFUIAction getPSAppWFUIAction(String strDEUIActionId, boolean bTryMode) throws Exception {
        return (IPSAppWFUIAction)this.psAppWFUIActionGlobalModel.FindModelHelper(strDEUIActionId, bTryMode);
    }

    @Override
    public void resetPSAppWFUIAction(String strDEUIActionId) throws Exception {
        this.psAppWFUIActionGlobalModel.ResetModel(strDEUIActionId);
    }

    @Override
    @PSModelRTMeta(description="\u5de5\u4f5c\u6d41\u754c\u9762\u884c\u4e3a\u96c6\u5408", child=true, ignorepf=true, dynamodelmode=8)
    public Iterator<IPSAppWFUIAction> getAllPSAppWFUIActions() throws Exception {
        return this.psAppWFUIActionGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSAppWFUIActionGroup getPSAppWFUIActionGroup(String strDEUIActionGroupId) throws Exception {
        return (IPSAppWFUIActionGroup)this.psAppWFUIActionGroupGlobalModel.FindModelHelper(strDEUIActionGroupId);
    }

    @Override
    public IPSAppWFUIActionGroup getPSAppWFUIActionGroup(String strDEUIActionGroupId, boolean bTryMode) throws Exception {
        return (IPSAppWFUIActionGroup)this.psAppWFUIActionGroupGlobalModel.FindModelHelper(strDEUIActionGroupId, bTryMode);
    }

    @Override
    public void resetPSAppWFUIActionGroup(String strDEUIActionGroupId) throws Exception {
        this.psAppWFUIActionGroupGlobalModel.ResetModel(strDEUIActionGroupId);
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5de5\u4f5c\u6d41\u754c\u9762\u884c\u4e3a\u96c6\u5408")
    public Iterator<IPSAppWFUIAction> getPSAppWFUIActions() throws Exception {
        return this.psAppWFUIActionGlobalModel.getAllModelHelpers();
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5de5\u4f5c\u6d41\u754c\u9762\u884c\u4e3a\u7ec4\u96c6\u5408")
    public Iterator<IPSAppWFUIActionGroup> getPSAppWFUIActionGroups() throws Exception {
        return this.psAppWFUIActionGroupGlobalModel.getAllModelHelpers();
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.getPSWFVersion().getCodeName();
    }

    @Override
    protected int onCheck() throws Exception {
        this.getAllPSAppViews();
        return super.onCheck();
    }

    @Override
    @PSModelRTMeta(description="\u6d41\u7a0b\u89c6\u56fe\u96c6\u5408")
    public Iterator<IPSAppView> getAllPSAppViews() throws Exception {
        if (this.psAppViewList == null) {
            ArrayList<IPSAppView> psAppViewList = new ArrayList<IPSAppView>();
            Iterator<IPSWFDE> psDEWFs = this.getPSAppWF().getPSWorkflow().getPSWFDEs();
            if (psDEWFs != null) {
                while (psDEWFs.hasNext()) {
                    IPSDEWF iPSDEWF = psDEWFs.next();
                    if ((iPSDEWF.getWFProxyMode() & 2) != 2) continue;
                    ArrayList<PSDEViewBase> psDEViewBaseList = iPSDEWF.getPSDataEntity().getSDPSDEViewDataList(true, this.getPSApplication().isMobileApp());
                    for (PSDEViewBase psDEViewBase : psDEViewBaseList) {
                        try {
                            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psDEViewBase.getPSWFVERSIONID())) {
                                if (SA.SRFramework.Utility.StringHelper.Compare((String)psDEViewBase.getPREDEFINEVIEWTYPE(), (String)"EDITVIEW", (boolean)false) != 0 || !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psDEViewBase.getPDVTPARAM())) continue;
                                psAppViewList.add(this.getPSApplication().getPSAppViewByDEViewId(psDEViewBase.getPSDEVIEWBASEID(), false));
                                continue;
                            }
                            if (SA.SRFramework.Utility.StringHelper.Compare((String)psDEViewBase.getPSWFVERSIONID(), (String)this.getPSWFVersion().getId(), (boolean)false) != 0) continue;
                            psAppViewList.add(this.getPSApplication().getPSAppViewByDEViewId(psDEViewBase.getPSDEVIEWBASEID(), false));
                        }
                        catch (Exception ex) {
                            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName());
                            String strExInfo = StringHelper.format((String)"\u8ba1\u7b97\u5f15\u7528\u89c6\u56fe\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
                            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
                            if (this.getPSSystemUtil() != null) {
                                this.getPSSystemUtil().getPSSysConsole().error(strLogName, strExInfo);
                            }
                            throw ex;
                        }
                    }
                }
            }
            if (this.psAppViewList == null) {
                this.psAppViewList = psAppViewList;
            }
        }
        if (this.psAppViewList == null || this.psAppViewList.size() == 0) {
            return null;
        }
        return this.psAppViewList.iterator();
    }

    @Override
    public String getDynaModelFilePath() {
        return null;
    }
}

