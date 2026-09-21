/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.core.IDataEntity
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.util.Inflector
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.WF;

import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.MainState.IPSDEMainState;
import SA.SRFDA.PS.Core.DataEntity.PSDataEntityObjectImpl;
import SA.SRFDA.PS.Core.DataEntity.WF.IPSDEWF;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSSystemUtil;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.WF.IPSWorkflow;
import SA.SRFDA.PS.Data.PSDEViewBase;
import SA.SRFDA.PS.Data.PSWFDE;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.util.Inflector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelPFIgnoreMeta
public class PSDEWFImpl
extends PSDataEntityObjectImpl
implements IPSDEWF {
    private static final Log log = LogFactory.getLog(PSDEWFImpl.class);
    protected PSWFDE psWFDE = null;
    private boolean bValidFlag = true;
    private IPSWorkflow iPSWorkflow = null;
    private String strCodeName = "";
    private IPSDEField wfStepPSDEField = null;
    private IPSDEField wfStatePSDEField = null;
    private IPSDEField udStatePSDEField = null;
    private IPSDEField wfInstPSDEField = null;
    private IPSDEField pwfInstPSDEField = null;
    private IPSDEField wfActorsPSDEField = null;
    private IPSDEField wfRetPSDEField = null;
    private boolean bEnableUserStart = true;
    private IPSDEAction initPSDEAction = null;
    private IPSDEAction finishPSDEAction = null;
    private boolean bDefaultMode = true;
    private IPSDEField wfVerPSDEField = null;
    private IPSDEField workflowPSDEField = null;
    private String strWFMode = "";
    private String strWFStartName = "";
    private String strMyWFWorkCaption = "";
    private String strMyWFDataCaption = "";
    private IPSLanguageRes myWFWorkCapPSLanguageRes = null;
    private IPSLanguageRes myWFDataCapPSLanguageRes = null;
    private boolean bUseWFProxyApp = false;
    private int nWFProxyMode = 0;
    private IPSDEField proxyModulePSDEField = null;
    private IPSDEField proxyDataPSDEField = null;
    private String strProxyDataPSDEViewId = "";
    private String strMobProxyDataPSDEViewId = "";
    private String strEditProxyDataPSDEViewId = "";
    private String strMobEditProxyDataPSDEViewId = "";
    private IPSDEMainState processPSDEMainState = null;
    private IPSDEMainState finishPSDEMainState = null;
    private IPSDEMainState errorPSDEMainState = null;
    private PSDEViewBase startPSDEViewBase = null;
    private PSDEViewBase mobStartPSDEViewBase = null;
    private PSDEViewBase actionPSDEViewBase = null;
    private PSDEViewBase mobActionPSDEViewBase = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDataEntity iPSDataEntity, PSWFDE psWFDE) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSDataEntity(iPSDataEntity);
            this.psWFDE = psWFDE;
            this.setId(this.psWFDE.getPSWFDEID());
            this.setName(this.psWFDE.getPSWFDENAME());
            this.setPSObjectData(this.psWFDE);
            if (!psWFDE.isVALIDFLAGNull()) {
                this.bValidFlag = psWFDE.getVALIDFLAG();
            }
            this.strCodeName = psWFDE.getCODENAME();
            if (!this.psWFDE.isUSERSTARTNull()) {
                this.bEnableUserStart = this.psWFDE.getUSERSTART();
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psWFDE.getINITPSDEACTIONID())) {
                this.initPSDEAction = this.getPSDataEntity().getPSDEAction(this.psWFDE.getINITPSDEACTIONID());
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psWFDE.getFINISHPSDEACTIONID())) {
                this.finishPSDEAction = this.getPSDataEntity().getPSDEAction(this.psWFDE.getFINISHPSDEACTIONID());
            }
            if (!this.psWFDE.isDEFAULTMODENull()) {
                this.bDefaultMode = this.psWFDE.getDEFAULTMODE();
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psWFDE.getWFMODE())) {
                this.strWFMode = this.psWFDE.getWFMODE();
            }
            this.strMyWFDataCaption = this.psWFDE.getMYWFDATA();
            this.strMyWFWorkCaption = this.psWFDE.getMYWFWORK();
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psWFDE.getMYWFWORKPSLANRESID())) {
                this.myWFWorkCapPSLanguageRes = this.getPSDataEntity().getPSSystem().getPSLanguageRes(this.psWFDE.getMYWFWORKPSLANRESID());
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psWFDE.getMYWFDATAPSLANRESID())) {
                this.myWFDataCapPSLanguageRes = this.getPSDataEntity().getPSSystem().getPSLanguageRes(this.psWFDE.getMYWFDATAPSLANRESID());
            }
            this.strProxyDataPSDEViewId = this.psWFDE.getPROXYDATAPSDEVIEWID();
            this.strMobProxyDataPSDEViewId = this.psWFDE.getMOBPROXYDATAPSDEVIEWID();
            this.strEditProxyDataPSDEViewId = this.psWFDE.getPROXYDATA2PSDEVIEWID();
            this.strMobEditProxyDataPSDEViewId = this.psWFDE.getMOBPROXYDATA2PSDEVIEWID();
            Iterator<PSDEViewBase> psDEViewDatas = this.getPSDataEntity().getPDTPSDEViewDatas();
            if (psDEViewDatas != null) {
                while (psDEViewDatas.hasNext()) {
                    PSDEViewBase psDEViewBase = psDEViewDatas.next();
                    if (SA.SRFramework.Utility.StringHelper.Compare((String)psDEViewBase.getPSWFDEID(), (String)this.getId(), (boolean)false) != 0) continue;
                    if (SA.SRFramework.Utility.StringHelper.Compare((String)psDEViewBase.getPREDEFINEVIEWTYPE(), (String)"WFSTARTVIEW", (boolean)false) == 0) {
                        this.startPSDEViewBase = psDEViewBase;
                        continue;
                    }
                    if (SA.SRFramework.Utility.StringHelper.Compare((String)psDEViewBase.getPREDEFINEVIEWTYPE(), (String)"MOBWFSTARTVIEW", (boolean)false) == 0) {
                        this.mobStartPSDEViewBase = psDEViewBase;
                        continue;
                    }
                    if (SA.SRFramework.Utility.StringHelper.Compare((String)psDEViewBase.getPREDEFINEVIEWTYPE(), (String)"WFACTIONVIEW", (boolean)false) == 0) {
                        this.actionPSDEViewBase = psDEViewBase;
                        continue;
                    }
                    if (SA.SRFramework.Utility.StringHelper.Compare((String)psDEViewBase.getPREDEFINEVIEWTYPE(), (String)"MOBWFACTIONVIEW", (boolean)false) != 0) continue;
                    this.mobActionPSDEViewBase = psDEViewBase;
                }
            }
            this.onInit();
        }
        catch (Exception ex) {
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            if (this.getPSSystemUtil() != null) {
                this.getPSSystemUtil().getPSSysConsole().error(strLogName, strExInfo);
            }
            this.throwInitException(ex);
        }
    }

    @Override
    protected void onInit() throws Exception {
        Iterator<IPSDEMainState> psDEMainStates;
        this.iPSWorkflow = this.getPSDataEntity().getPSSystem().getPSWorkflow(this.psWFDE.getPSWFID());
        if (!this.psWFDE.isWFPROXYMODENull()) {
            this.nWFProxyMode = this.psWFDE.getWFPROXYMODE();
            this.bUseWFProxyApp = (this.getWFProxyMode() & 1) == 1;
        } else {
            this.bUseWFProxyApp = this.iPSWorkflow.isUseWFProxyApp();
            this.nWFProxyMode = this.iPSWorkflow.getWFProxyMode();
        }
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psWFDE.getWFSTEPPSDEFID())) {
            this.wfStepPSDEField = this.getPSDataEntity().getPSDEField(this.psWFDE.getWFSTEPPSDEFID());
        }
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psWFDE.getWFSTATEPSDEFID())) {
            this.wfStatePSDEField = this.getPSDataEntity().getPSDEField(this.psWFDE.getWFSTATEPSDEFID());
        }
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psWFDE.getSTATEPSDEFID())) {
            this.udStatePSDEField = this.getPSDataEntity().getPSDEField(this.psWFDE.getSTATEPSDEFID());
        }
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psWFDE.getWFINSTPSDEFID())) {
            this.wfInstPSDEField = this.getPSDataEntity().getPSDEField(this.psWFDE.getWFINSTPSDEFID());
        }
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psWFDE.getPWFINSTPSDEFID())) {
            this.pwfInstPSDEField = this.getPSDataEntity().getPSDEField(this.psWFDE.getPWFINSTPSDEFID());
        }
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psWFDE.getWFACTORPSDEFID())) {
            this.wfActorsPSDEField = this.getPSDataEntity().getPSDEField(this.psWFDE.getWFACTORPSDEFID());
        }
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psWFDE.getWFRETPSDEFID())) {
            this.wfRetPSDEField = this.getPSDataEntity().getPSDEField(this.psWFDE.getWFRETPSDEFID());
        }
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psWFDE.getWFVERPSDEFID())) {
            this.wfVerPSDEField = this.getPSDataEntity().getPSDEField(this.psWFDE.getWFVERPSDEFID());
        }
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psWFDE.getWFIDPSDEFID())) {
            this.workflowPSDEField = this.getPSDataEntity().getPSDEField(this.psWFDE.getWFIDPSDEFID());
        }
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psWFDE.getPROXYMODULEPSDEFID())) {
            this.proxyModulePSDEField = this.getPSDataEntity().getPSDEField(this.psWFDE.getPROXYMODULEPSDEFID());
        }
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psWFDE.getPROXYDATAPSDEFID())) {
            this.proxyDataPSDEField = this.getPSDataEntity().getPSDEField(this.psWFDE.getPROXYDATAPSDEFID());
        }
        if (this.getUDStatePSDEField() != null && SA.SRFramework.Utility.StringHelper.Compare((String)this.getUDStatePSDEField().getDEMSFieldMode(), (String)"STATE1", (boolean)false) == 0 && (psDEMainStates = this.getPSDataEntity().getAllPSDEMainStates()) != null) {
            while (psDEMainStates.hasNext()) {
                IPSDEMainState iPSDEMainState = psDEMainStates.next();
                if (iPSDEMainState.getParentPSDEMainState() != null) continue;
                if (iPSDEMainState.getWFStateMode() == 1) {
                    this.processPSDEMainState = iPSDEMainState;
                    continue;
                }
                if (iPSDEMainState.getWFStateMode() == 2) {
                    this.finishPSDEMainState = iPSDEMainState;
                    continue;
                }
                if (iPSDEMainState.getWFStateMode() != 3) continue;
                this.errorPSDEMainState = iPSDEMainState;
            }
        }
        super.onInit();
    }

    @Override
    public boolean isValid() {
        return this.bValidFlag;
    }

    @Override
    @PSModelRTMeta(description="\u5de5\u4f5c\u6d41\u5bf9\u8c61", dumpref=true, group="\u57fa\u672c", order=110)
    public IPSWorkflow getPSWorkflow() {
        return this.iPSWorkflow;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.strCodeName;
    }

    protected String onGetCodeName() {
        return this.strCodeName;
    }

    @Override
    @PSModelRTMeta(description="\u6d41\u7a0b\u6b65\u9aa4\u5c5e\u6027", dumpref=true, from="IPSDataEntity", fields={"WFSTEPPSDEFID"})
    public IPSDEField getWFStepPSDEField() {
        return this.wfStepPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u6d41\u7a0b\u72b6\u6001\u5c5e\u6027", dumpref=true, from="IPSDataEntity", fields={"WFSTATEPSDEFID"})
    public IPSDEField getWFStatePSDEField() {
        return this.wfStatePSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u7528\u6237\u72b6\u6001\u5c5e\u6027", dumpref=true, from="IPSDataEntity", fields={"STATEPSDEFID"})
    public IPSDEField getUDStatePSDEField() {
        return this.udStatePSDEField;
    }

    public String getWorkflowId() {
        return this.psWFDE.getPSWFID();
    }

    @Override
    public String getWFStepField() {
        return this.psWFDE.getWFSTEPPSDEFNAME();
    }

    @Override
    public String getWFStateField() {
        return this.psWFDE.getWFSTATEPSDEFNAME();
    }

    @Override
    public String getUDStateField() {
        return this.psWFDE.getSTATEPSDEFNAME();
    }

    @Override
    public String getWFInstField() {
        if (this.getWFInstPSDEField() != null) {
            return this.getWFInstPSDEField().getName();
        }
        return "";
    }

    @Override
    @PSModelRTMeta(description="\u6d41\u7a0b\u72b6\u6001\u503c")
    public String getEntityWFState() {
        return this.getPSWorkflow().getEntityWFState();
    }

    @Override
    @PSModelRTMeta(description="\u6d41\u7a0b\u7ed3\u675f\u72b6\u6001\u503c")
    public String getEntityWFFinishState() {
        return this.getPSWorkflow().getEntityWFFinishState();
    }

    @Override
    @PSModelRTMeta(description="\u6d41\u7a0b\u9519\u8bef\u72b6\u6001\u503c")
    public String getEntityWFErrorState() {
        return this.getPSWorkflow().getEntityWFErrorState();
    }

    @Override
    @PSModelRTMeta(description="\u6d41\u7a0b\u53d6\u6d88\u72b6\u6001\u503c")
    public String getEntityWFCancelState() {
        return this.getPSWorkflow().getEntityWFCancelState();
    }

    @Override
    @PSModelRTMeta(description="\u6d41\u7a0b\u5b9e\u4f8b\u5c5e\u6027", dumpref=true, from="IPSDataEntity", fields={"WFINSTPSDEFID"})
    public IPSDEField getWFInstPSDEField() {
        return this.wfInstPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u7236\u6d41\u7a0b\u5b9e\u4f8b\u5c5e\u6027", dumpref=true, from="IPSDataEntity", fields={"PWFINSTPSDEFID"})
    public IPSDEField getPWFInstPSDEField() {
        return this.pwfInstPSDEField;
    }

    @Override
    public String getWFActorsField() {
        if (this.getWFActorsPSDEField() == null) {
            return "";
        }
        return this.getWFActorsPSDEField().getName();
    }

    @Override
    @PSModelRTMeta(description="\u6d41\u7a0b\u64cd\u4f5c\u8005\u5c5e\u6027", dumpref=true, from="IPSDataEntity", fields={"WFACTORPSDEFID"})
    public IPSDEField getWFActorsPSDEField() {
        return this.wfActorsPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u6d41\u7a0b\u6b65\u9aa4\u4ee3\u7801\u8868", dumpref=true)
    public IPSCodeList getWFStepPSCodeList() throws Exception {
        if (this.getWFStepPSDEField() != null && this.getWFStepPSDEField().getPSCodeList() != null) {
            return this.getWFStepPSDEField().getPSCodeList();
        }
        return this.getPSWorkflow().getWFStepPSCodeList();
    }

    @Override
    @PSModelRTMeta(description="\u7528\u6237\u6570\u636e\u72b6\u6001\u4ee3\u7801\u8868", dumpref=true)
    public IPSCodeList getEntityStatePSCodeList() throws Exception {
        if (this.getUDStatePSDEField() != null && this.getUDStatePSDEField().getPSCodeList() != null) {
            return this.getUDStatePSDEField().getPSCodeList();
        }
        return this.getPSWorkflow().getEntityStatePSCodeList();
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u7528\u6237\u542f\u52a8", fields={"USERSTART"})
    public boolean isEnableUserStart() {
        return this.bEnableUserStart;
    }

    @Override
    @PSModelRTMeta(description="\u6d41\u7a0b\u521d\u59cb\u5316\u5b9e\u4f53\u884c\u4e3a", dumpref=true, from="IPSDataEntity", fields={"INITPSDEACTIONID"})
    public IPSDEAction getInitPSDEAction() {
        return this.initPSDEAction;
    }

    @Override
    @PSModelRTMeta(description="\u6d41\u7a0b\u5b8c\u6210\u5b9e\u4f53\u884c\u4e3a", dumpref=true, from="IPSDataEntity", fields={"FINISHPSDEACTIONID"})
    public IPSDEAction getFinishPSDEAction() {
        return this.finishPSDEAction;
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u6d41\u7a0b\u5b9e\u4f53")
    public boolean isDefaultMode() {
        return this.bDefaultMode;
    }

    @Override
    @PSModelRTMeta(description="\u5d4c\u5165\u6d41\u7a0b\u8fd4\u56de\u503c\u5b58\u653e\u5c5e\u6027", dumpref=true, from="IPSDataEntity", fields={"WFRETPSDEFID"})
    public IPSDEField getWFRetPSDEField() {
        return this.wfRetPSDEField;
    }

    @Override
    public String getWFRetField() {
        if (this.getWFRetPSDEField() != null) {
            return this.getWFRetPSDEField().getName();
        }
        return "";
    }

    public boolean testDataInWF(IEntity iEntity) throws Exception {
        String strValue = DataObject.getStringValue((IDataObject)iEntity, (String)this.getUDStateField(), null);
        return SA.SRFramework.Utility.StringHelper.Compare((String)strValue, (String)this.getEntityWFState(), (boolean)false) == 0;
    }

    public String getWFEditViewPDTParam(IEntity iEntity, boolean bWorkMode) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    public String getWFEditViewPDTParam(IEntity iEntity, boolean bWorkMode, int nAppType) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @Override
    @PSModelRTMeta(description="\u5f00\u59cb\u6d41\u7a0b\u540d\u79f0")
    public String getWFStartName() {
        return this.strWFStartName;
    }

    @Override
    @PSModelRTMeta(description="\u6d41\u7a0b\u7248\u672c\u5b58\u653e\u5c5e\u6027", dumpref=true, from="IPSDataEntity", fields={"WFVERPSDEFID"})
    public IPSDEField getWFVerPSDEField() {
        return this.wfVerPSDEField;
    }

    @Override
    public String getWFVerField() {
        if (this.getWFVerPSDEField() != null) {
            return this.getWFVerPSDEField().getName();
        }
        return "";
    }

    @Override
    @PSModelRTMeta(description="\u5de5\u4f5c\u6d41\u5b58\u653e\u5c5e\u6027", dumpref=true, from="IPSDataEntity", fields={"WFIDPSDEFID"})
    public IPSDEField getWorkflowPSDEField() {
        return this.workflowPSDEField;
    }

    @Override
    public String getWorkflowField() {
        if (this.getWorkflowPSDEField() != null) {
            return this.getWorkflowPSDEField().getName();
        }
        return "";
    }

    @Override
    @PSModelRTMeta(description="\u6d41\u7a0b\u6a21\u5f0f", fields={"WFMODE"})
    public String getWFMode() {
        return this.strWFMode;
    }

    @Override
    public String getModelType() {
        return "PSWFDE";
    }

    public void init(IDataEntity iDataEntity) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @Override
    @PSModelRTMeta(description="\u6211\u7684\u5de5\u4f5c\u6807\u9898", fields={"MYWFWORK"})
    public String getMyWFWorkCaption() {
        return this.strMyWFWorkCaption;
    }

    @Override
    @PSModelRTMeta(description="\u6211\u7684\u5de5\u4f5c\u6807\u9898\u8bed\u8a00\u8d44\u6e90", fields={"MYWFWORKPSLANRESID"})
    public IPSLanguageRes getMyWFWorkCapPSLanguageRes() {
        return this.myWFWorkCapPSLanguageRes;
    }

    @Override
    @PSModelRTMeta(description="\u6211\u7684\u6570\u636e\u6807\u9898", fields={"MYWFDATA"})
    public String getMyWFDataCaption() {
        return this.strMyWFDataCaption;
    }

    @Override
    @PSModelRTMeta(description="\u6211\u7684\u6570\u636e\u6807\u9898\u8bed\u8a00\u8d44\u6e90", fields={"MYWFDATAPSLANRESID"})
    public IPSLanguageRes getMyWFDataCapPSLanguageRes() {
        return this.myWFDataCapPSLanguageRes;
    }

    @Override
    @PSModelRTMeta(description="\u4f7f\u7528\u5de5\u4f5c\u6d41\u4ee3\u7406\u5e94\u7528")
    public boolean isUseWFProxyApp() {
        return this.bUseWFProxyApp;
    }

    @Override
    @PSModelRTMeta(description="\u5de5\u4f5c\u6d41\u4ee3\u7406\u6a21\u5f0f", codelist="WFDEProxyMode", fields={"WFPROXYMODE"})
    public int getWFProxyMode() {
        return this.nWFProxyMode;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7406\u6a21\u5757\u5b58\u50a8\u5c5e\u6027", hideempty=true, dumpref=true)
    public IPSDEField getProxyModulePSDEField() {
        return this.proxyModulePSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7406\u6570\u636e\u5b58\u50a8\u5c5e\u6027", hideempty=true, dumpref=true, from="IPSDataEntity", fields={"PROXYDATAPSDEFID"})
    public IPSDEField getProxyDataPSDEField() {
        return this.proxyDataPSDEField;
    }

    @Override
    public Iterator<IPSAppView> getDataRedirectPSAppViews() throws Exception {
        return this.getPSDataEntity().getDataRedirectPSAppViews();
    }

    @Override
    public Iterator<IPSAppView> getMobDataRedirectPSAppViews() throws Exception {
        return this.getPSDataEntity().getMobDataRedirectPSAppViews();
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7406\u6570\u636e\u5b9e\u4f53\u89c6\u56fe\u6807\u8bc6", dump=false)
    public String getProxyDataPSDEViewId() {
        return this.strProxyDataPSDEViewId;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7406\u6570\u636e\u79fb\u52a8\u7aef\u5b9e\u4f53\u89c6\u56fe\u6807\u8bc6", dump=false)
    public String getMobProxyDataPSDEViewId() {
        return this.strMobProxyDataPSDEViewId;
    }

    @Override
    public Iterator<IPSAppView> getProxyDataPSAppViews() throws Exception {
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getProxyDataPSDEViewId())) {
            return null;
        }
        return PSSystemUtil.getPSAppDEViews(this.getPSSystem(), this.getProxyDataPSDEViewId());
    }

    @Override
    public Iterator<IPSAppView> getMobProxyDataPSAppViews() throws Exception {
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getMobProxyDataPSDEViewId())) {
            return null;
        }
        return PSSystemUtil.getPSAppDEViews(this.getPSSystem(), this.getMobProxyDataPSDEViewId());
    }

    @Override
    @PSModelRTMeta(description="\u7f16\u8f91\u4ee3\u7406\u6570\u636e\u5b9e\u4f53\u89c6\u56fe\u6807\u8bc6", dump=false)
    public String getEditProxyDataPSDEViewId() {
        return this.strEditProxyDataPSDEViewId;
    }

    @Override
    @PSModelRTMeta(description="\u7f16\u8f91\u4ee3\u7406\u6570\u636e\u79fb\u52a8\u7aef\u5b9e\u4f53\u89c6\u56fe\u6807\u8bc6", dump=false)
    public String getMobEditProxyDataPSDEViewId() {
        return this.strMobEditProxyDataPSDEViewId;
    }

    @Override
    public Iterator<IPSAppView> getEditProxyDataPSAppViews() throws Exception {
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getEditProxyDataPSDEViewId())) {
            return null;
        }
        return PSSystemUtil.getPSAppDEViews(this.getPSSystem(), this.getEditProxyDataPSDEViewId());
    }

    @Override
    public Iterator<IPSAppView> getMobEditProxyDataPSAppViews() throws Exception {
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getMobEditProxyDataPSDEViewId())) {
            return null;
        }
        return PSSystemUtil.getPSAppDEViews(this.getPSSystem(), this.getMobEditProxyDataPSDEViewId());
    }

    @Override
    @PSModelRTMeta(description="\u90e8\u7f72\u6570\u636e\u6807\u8bc6", dump=false)
    public String getDeployId() {
        return KeyValueHelper.genUniqueId((String)this.getPSDataEntity().getDeployId(), (String)this.getCodeName());
    }

    @Override
    @PSModelRTMeta(description="\u5904\u7406\u4e2d\u4e3b\u72b6\u6001", dumpref=true, from="IPSDataEntity", doc="\u4ece\u5b9e\u4f53\u4e3b\u72b6\u6001\u8ba1\u7b97")
    public IPSDEMainState getProcessPSDEMainState() {
        return this.processPSDEMainState;
    }

    @Override
    @PSModelRTMeta(description="\u5b8c\u6210\u8df3\u8f6c\u4e3b\u72b6\u6001", dumpref=true, from="IPSDataEntity", doc="\u4ece\u5b9e\u4f53\u4e3b\u72b6\u6001\u8ba1\u7b97")
    public IPSDEMainState getFinishPSDEMainState() {
        return this.finishPSDEMainState;
    }

    @Override
    @PSModelRTMeta(description="\u9519\u8bef\u8df3\u8f6c\u4e3b\u72b6\u6001", dumpref=true, from="IPSDataEntity", doc="\u4ece\u5b9e\u4f53\u4e3b\u72b6\u6001\u8ba1\u7b97")
    public IPSDEMainState getErrorPSDEMainState() {
        return this.errorPSDEMainState;
    }

    @Override
    public String getStartPSDEViewId() {
        if (this.startPSDEViewBase != null) {
            return this.startPSDEViewBase.getPSDEVIEWBASEID();
        }
        return this.psWFDE.getSTARTPSDEVIEWID();
    }

    @Override
    public String getMobStartPSDEViewId() {
        if (this.mobStartPSDEViewBase != null) {
            return this.mobStartPSDEViewBase.getPSDEVIEWBASEID();
        }
        return this.psWFDE.getSTARTMOBPSDEVIEWID();
    }

    @Override
    public String getActionPSDEViewId() {
        if (this.actionPSDEViewBase != null) {
            return this.actionPSDEViewBase.getPSDEVIEWBASEID();
        }
        return this.psWFDE.getACTIONPSDEVIEWID();
    }

    @Override
    public String getMobActionPSDEViewId() {
        if (this.mobActionPSDEViewBase != null) {
            return this.mobActionPSDEViewBase.getPSDEVIEWBASEID();
        }
        return this.psWFDE.getACTIONMOBPSDEVIEWID();
    }

    @Override
    public String getStartViewCodeName() {
        if (this.startPSDEViewBase != null) {
            return this.startPSDEViewBase.getCODENAME();
        }
        return this.psWFDE.getSTARTVIEWCODENAME();
    }

    @Override
    public String getMobStartViewCodeName() {
        if (this.mobStartPSDEViewBase != null) {
            return this.mobStartPSDEViewBase.getCODENAME();
        }
        return this.psWFDE.getSTARTMOBVIEWCODENAME();
    }

    @Override
    public String getActionViewCodeName() {
        if (this.actionPSDEViewBase != null) {
            return this.actionPSDEViewBase.getCODENAME();
        }
        return this.psWFDE.getACTIONVIEWCODENAME();
    }

    @Override
    public String getMobActionViewCodeName() {
        if (this.mobActionPSDEViewBase != null) {
            return this.mobActionPSDEViewBase.getCODENAME();
        }
        return this.psWFDE.getACTIONMOBVIEWCODENAME();
    }

    @Override
    protected IPSModelObject onGetParentModel() {
        return this.getPSWorkflow();
    }

    @Override
    protected String onGetMOSFolder() {
        if (this.getPSWorkflow() != null) {
            return String.format("%1$s/%2$s", this.getPSWorkflow().getMOSFilePath(), Inflector.getInstance().pluralize((Object)this.getModelType()).toLowerCase());
        }
        return Inflector.getInstance().pluralize((Object)this.getModelType()).toLowerCase();
    }

    @Override
    protected String onGetRTMOSFolder() {
        if (this.getPSWorkflow() != null) {
            return String.format("%1$s/%2$s", this.getPSWorkflow().getRTMOSFilePath(), Inflector.getInstance().pluralize((Object)this.getRTMOSModelType()).toLowerCase());
        }
        return Inflector.getInstance().pluralize((Object)this.getRTMOSModelType()).toLowerCase();
    }

    @Override
    public String getWFCatCode() {
        return null;
    }
}

