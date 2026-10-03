/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.App.WF;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.PSApplicationObjectImpl;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.WF.IPSAppWF;
import SA.SRFDA.PS.Core.App.WF.IPSAppWFDE;
import SA.SRFDA.PS.Core.App.WF.IPSAppWFUIAction;
import SA.SRFDA.PS.Core.App.WF.IPSAppWFUIActionGroup;
import SA.SRFDA.PS.Core.App.WF.IPSAppWFUtilUIAction;
import SA.SRFDA.PS.Core.App.WF.IPSAppWFVer;
import SA.SRFDA.PS.Core.App.WF.PSAppWFDEImpl;
import SA.SRFDA.PS.Core.App.WF.PSAppWFUIActionGlobalModel;
import SA.SRFDA.PS.Core.App.WF.PSAppWFUIActionGroupGlobalModel;
import SA.SRFDA.PS.Core.App.WF.PSAppWFUtilUIActionImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.WF.IPSWFDE;
import SA.SRFDA.PS.Core.WF.IPSWFUtilUIAction;
import SA.SRFDA.PS.Core.WF.IPSWorkflow;
import SA.SRFDA.PS.Data.PSAppWF;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppWFImpl
extends PSApplicationObjectImpl
implements IPSAppWF {
    private static final Log log = LogFactory.getLog(PSAppWFImpl.class);
    protected PSAppWF psAppWF = null;
    private IPSWorkflow iPSWorkflow = null;
    private ArrayList<IPSAppWFVer> psAppWFVerList = null;
    protected PSAppWFUIActionGlobalModel psAppWFUIActionGlobalModel = new PSAppWFUIActionGlobalModel();
    protected PSAppWFUIActionGroupGlobalModel psAppWFUIActionGroupGlobalModel = new PSAppWFUIActionGroupGlobalModel();
    private List<IPSAppView> psAppViewList = null;
    private ArrayList<IPSAppWFDE> psAppWFDEList = null;
    private Map<String, IPSAppWFUtilUIAction> psAppWFUtilUIActionMap = new LinkedHashMap<String, IPSAppWFUtilUIAction>();

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSApplication iPSApplication, PSAppWF psAppWF) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSApplication(iPSApplication);
            this.psAppWF = psAppWF;
            this.setId(this.psAppWF.getPSAPPWFID());
            this.setName(this.psAppWF.getPSAPPWFNAME());
            this.setPSObjectData(psAppWF);
            if (StringHelper.IsNullOrEmpty((String)this.psAppWF.getPSWORKFLOWID())) {
                throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5de5\u4f5c\u6d41\u6807\u8bc6");
            }
            this.iPSWorkflow = this.getPSSystem().getPSWorkflow(this.psAppWF.getPSWORKFLOWID());
            this.setName(this.iPSWorkflow.getName());
            this.psAppWFUIActionGlobalModel.Init(iDAGlobalHelper, this);
            this.psAppWFUIActionGroupGlobalModel.Init(iDAGlobalHelper, this);
            this.onInit();
        }
        catch (Exception ex) {
            String strLogName = StringHelper.Format((String)"%1$s[%2$s]", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.Format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.Format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
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

    protected void preparePSAppWFUtilUIActions() throws Exception {
        Iterator<IPSWFUtilUIAction> psWFUtilUIActions;
        if (this.getPSSystem().getPSSysWFSetting() != null && (psWFUtilUIActions = this.getPSSystem().getPSSysWFSetting().getPSWFUtilUIActions()) != null) {
            while (psWFUtilUIActions.hasNext()) {
                IPSWFUtilUIAction iPSWFUtilUIAction = psWFUtilUIActions.next();
                if (StringHelper.IsNullOrEmpty((String)iPSWFUtilUIAction.getPSWorkflowId())) {
                    IPSAppWFUtilUIAction last = this.psAppWFUtilUIActionMap.get(iPSWFUtilUIAction.getUtilType());
                    if (last != null) continue;
                    PSAppWFUtilUIActionImpl psAppWFUtilUIActionImpl = new PSAppWFUtilUIActionImpl();
                    psAppWFUtilUIActionImpl.init(this.getDAGlobalHelper(), this, iPSWFUtilUIAction);
                    this.psAppWFUtilUIActionMap.put(psAppWFUtilUIActionImpl.getUtilType(), psAppWFUtilUIActionImpl);
                    continue;
                }
                if (StringHelper.Compare((String)this.getPSWorkflow().getId(), (String)iPSWFUtilUIAction.getPSWorkflowId(), (boolean)false) != 0) continue;
                PSAppWFUtilUIActionImpl psAppWFUtilUIActionImpl = new PSAppWFUtilUIActionImpl();
                psAppWFUtilUIActionImpl.init(this.getDAGlobalHelper(), this, iPSWFUtilUIAction);
                this.psAppWFUtilUIActionMap.put(psAppWFUtilUIActionImpl.getUtilType(), psAppWFUtilUIActionImpl);
            }
        }
    }

    @Override
    public String getModelType() {
        return "PSAPPWF";
    }

    @Override
    public String getFullModelName() {
        return StringHelper.Format((String)"%1$s|%2$s", (Object)this.getPSApplication().getFullModelName(), (Object)this.getModelName());
    }

    @Override
    @PSModelRTMeta(description="\u5de5\u4f5c\u6d41", dumpref=true, ignorepf=true)
    public IPSWorkflow getPSWorkflow() {
        return this.iPSWorkflow;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5de5\u4f5c\u6d41\u7248\u672c\u96c6\u5408", child=true)
    public Iterator<IPSAppWFVer> getPSAppWFVers() throws Exception {
        if (this.psAppWFVerList == null) {
            ArrayList<IPSAppWFVer> psAppWFVerList2 = new ArrayList<IPSAppWFVer>();
            Iterator<IPSAppWFVer> psAppWFVers = this.getPSApplication().getAllPSAppWFVers();
            if (psAppWFVers != null) {
                while (psAppWFVers.hasNext()) {
                    IPSAppWFVer iPSAppWFVer = psAppWFVers.next();
                    if (StringHelper.Compare((String)iPSAppWFVer.getPSAppWF().getId(), (String)this.getId(), (boolean)false) != 0) continue;
                    psAppWFVerList2.add(iPSAppWFVer);
                }
            }
            PSAppWFImpl pSAppWFImpl = this;
            synchronized (pSAppWFImpl) {
                if (this.psAppWFVerList == null) {
                    this.psAppWFVerList = psAppWFVerList2;
                }
            }
        }
        return this.psAppWFVerList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u6709\u5de5\u4f5c\u6d41\u7248\u672c")
    public boolean hasPSAppWFVer() throws Exception {
        this.getPSAppWFVers();
        return this.psAppWFVerList.size() > 0;
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
    @PSModelRTMeta(description="\u5e94\u7528\u5de5\u4f5c\u6d41\u754c\u9762\u884c\u4e3a\u7ec4\u96c6\u5408")
    public Iterator<IPSAppWFUIActionGroup> getPSAppWFUIActionGroups() throws Exception {
        return this.psAppWFUIActionGroupGlobalModel.getAllModelHelpers();
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.getPSWorkflow().getCodeName();
    }

    @Override
    protected int onCheck() throws Exception {
        this.getAllPSAppViews();
        return super.onCheck();
    }

    @Override
    @PSModelRTMeta(description="\u6d41\u7a0b\u89c6\u56fe\u96c6\u5408")
    public Iterator<IPSAppView> getAllPSAppViews() throws Exception {
        if (this.psAppViewList == null || this.psAppViewList.size() == 0) {
            return null;
        }
        return this.psAppViewList.iterator();
    }

    @Override
    public String getDynaModelFilePath() {
        return null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5de5\u4f5c\u6d41\u5b9e\u4f53\u96c6\u5408", child=true)
    public Iterator<IPSAppWFDE> getPSAppWFDEs() throws Exception {
        if (this.psAppWFDEList == null) {
            ArrayList<IPSAppWFDE> psAppWFDEList2 = new ArrayList<IPSAppWFDE>();
            Iterator<IPSWFDE> psWFDEs = this.getPSWorkflow().getPSWFDEs();
            if (psWFDEs != null) {
                while (psWFDEs.hasNext()) {
                    IPSWFDE iPSWFDE = psWFDEs.next();
                    IPSAppDataEntity iPSAppDataEntity = this.getPSApplication().getPSAppDataEntity(iPSWFDE.getPSDataEntity(), true);
                    if (iPSAppDataEntity == null) continue;
                    PSAppWFDEImpl psAppWFDEImpl = new PSAppWFDEImpl();
                    psAppWFDEImpl.init(this.getDAGlobalHelper(), this, iPSAppDataEntity, iPSWFDE);
                    psAppWFDEList2.add(psAppWFDEImpl);
                }
            }
            PSAppWFImpl pSAppWFImpl = this;
            synchronized (pSAppWFImpl) {
                if (this.psAppWFDEList == null) {
                    this.psAppWFDEList = psAppWFDEList2;
                }
            }
        }
        return this.psAppWFDEList.iterator();
    }
}
