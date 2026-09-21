/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.core.IDataEntity
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.MainState;

import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataQuery;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.MainState.IPSDEMainState;
import SA.SRFDA.PS.Core.DataEntity.MainState.IPSDEMainStateAction;
import SA.SRFDA.PS.Core.DataEntity.MainState.IPSDEMainStateField;
import SA.SRFDA.PS.Core.DataEntity.MainState.IPSDEMainStateOPPriv;
import SA.SRFDA.PS.Core.DataEntity.MainState.IPSDEMainStateRS;
import SA.SRFDA.PS.Core.DataEntity.MainState.PSDEMainStateActionImpl;
import SA.SRFDA.PS.Core.DataEntity.MainState.PSDEMainStateFieldImpl;
import SA.SRFDA.PS.Core.DataEntity.MainState.PSDEMainStateOPPrivImpl;
import SA.SRFDA.PS.Core.DataEntity.PSDataEntityObjectImpl;
import SA.SRFDA.PS.Core.IPSModelSortable;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Data.PSDEMainState;
import SA.SRFDA.PS.Data.PSDEMainStateAction;
import SA.SRFDA.PS.Data.PSDEMainStateField;
import SA.SRFDA.PS.Data.PSDEMainStateOPPriv;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEMainStateImpl
extends PSDataEntityObjectImpl
implements IPSDEMainState,
IPSModelSortable {
    private static final Log log = LogFactory.getLog(PSDEMainStateImpl.class);
    protected PSDEMainState psDEMainState;
    protected ArrayList<IPSDEMainStateAction> psDEMainStateActionList = new ArrayList();
    protected ArrayList<IPSDEMainStateOPPriv> psDEMainStateOPPrivList = new ArrayList();
    protected ArrayList<IPSDEMainStateField> psDEMainStateFieldList = new ArrayList();
    protected String strCodeName = "";
    private String strPSDEDataQueryId = "";
    private IPSDEDataQuery iPSDEDataQuery = null;
    private boolean bAllowMode = false;
    private boolean bOPPrivAllowMode = false;
    private boolean bFieldAllowMode = false;
    private boolean bDefaultMode = false;
    private String strMSTag = null;
    private boolean bEnableViewActions = false;
    private long nViewActions = 0L;
    private int nWFStateMode = -1;
    private String strStateValue = null;
    private String strState2Value = null;
    private String strState3Value = null;
    private IPSDEMainState parentPSDEMainState = null;
    private List<IPSDEMainState> childPSDEMainStateList = null;
    private List<IPSDEMainState> prevPSDEMainStateList = null;
    private IPSDEAction enterPSDEAction = null;
    private String strEnterStateMode = "ANY";
    private int nOrderValue = 99999;
    private int nMainStateType = 0;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDataEntity iPSDataEntity, PSDEMainState psDEMainState) throws Exception {
        try {
            this.setPSDataEntity(iPSDataEntity);
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.psDEMainState = psDEMainState;
            this.setId(psDEMainState.getPSDEMAINSTATEID());
            this.setName(psDEMainState.getPSDEMAINSTATENAME());
            this.setPSObjectData(this.psDEMainState);
            this.strCodeName = this.psDEMainState.getCODENAME();
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strCodeName)) {
                this.strCodeName = this.getName();
            }
            this.strPSDEDataQueryId = this.psDEMainState.getPSDEDQID();
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strPSDEDataQueryId)) {
                this.iPSDEDataQuery = this.getPSDataEntity().getPSDEDataQuery(this.strPSDEDataQueryId);
            }
            if (!this.psDEMainState.isDEFAULTMODENull()) {
                this.bDefaultMode = this.psDEMainState.getDEFAULTMODE() == 1;
                this.nMainStateType = this.psDEMainState.getDEFAULTMODE();
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEMainState.getMSTAG())) {
                this.strMSTag = this.psDEMainState.getMSTAG();
            }
            if (!this.psDEMainState.isENABLEVIEWACTIONSNull()) {
                this.bEnableViewActions = this.psDEMainState.getENABLEVIEWACTIONS();
            }
            if (this.bEnableViewActions) {
                this.nViewActions = this.psDEMainState.getVIEWACTIONS();
            }
            this.bAllowMode = SA.SRFramework.Utility.StringHelper.Compare((String)this.psDEMainState.getALLOWMODE(), (String)"ALLOW", (boolean)true) == 0;
            this.bOPPrivAllowMode = SA.SRFramework.Utility.StringHelper.Compare((String)this.psDEMainState.getOPPRIVALLOWMODE(), (String)"ALLOW", (boolean)true) == 0;
            if (!psDEMainState.isWFSTATEMODENull()) {
                this.nWFStateMode = this.psDEMainState.getWFSTATEMODE();
            }
            this.bFieldAllowMode = SA.SRFramework.Utility.StringHelper.Compare((String)this.psDEMainState.getFIELDALLOWMODE(), (String)"ALLOW", (boolean)true) == 0;
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEMainState.getENTERSTATEMODE())) {
                this.strEnterStateMode = this.psDEMainState.getENTERSTATEMODE();
            }
            if (!this.psDEMainState.isORDERVALUENull() && this.psDEMainState.getORDERVALUE() >= 0) {
                this.nOrderValue = this.psDEMainState.getORDERVALUE();
            }
            this.strStateValue = this.psDEMainState.getMSVALUE();
            this.strState2Value = this.psDEMainState.getMSVALUE2();
            this.strState3Value = this.psDEMainState.getMSVALUE3();
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
        super.onInit();
        this.onPreparePSDEMainStateActions();
    }

    protected void onPreparePSDEMainStateActions() throws Exception {
        this.psDEMainStateActionList.clear();
        this.psDEMainStateOPPrivList.clear();
        Vector<PSDEMainStateAction> psDEMainStateActionList = new Vector<PSDEMainStateAction>();
        CallResult callResult = this.getPSModelHelper().getPSDEMainStateActions(this.getId(), psDEMainStateActionList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u4e3b\u72b6\u6001\u5b9e\u4f53\u884c\u4e3a\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSDEMainStateAction psDEMainStateAction : psDEMainStateActionList) {
            if (!psDEMainStateAction.isVALIDFLAGNull() && !psDEMainStateAction.getVALIDFLAG()) continue;
            PSDEMainStateActionImpl iPSDEMainStateAction = new PSDEMainStateActionImpl();
            iPSDEMainStateAction.init(this.getDAGlobalHelper(), this, psDEMainStateAction);
            this.psDEMainStateActionList.add(iPSDEMainStateAction);
        }
        Vector<PSDEMainStateOPPriv> psDEMainStateOPPrivList = new Vector<PSDEMainStateOPPriv>();
        callResult = this.getPSModelHelper().getPSDEMainStateOPPrivs(this.getId(), psDEMainStateOPPrivList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u4e3b\u72b6\u6001\u64cd\u4f5c\u6807\u8bc6\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSDEMainStateOPPriv psDEMainStateOPPriv : psDEMainStateOPPrivList) {
            if (!psDEMainStateOPPriv.isVALIDFLAGNull() && !psDEMainStateOPPriv.getVALIDFLAG()) continue;
            PSDEMainStateOPPrivImpl iPSDEMainStateOPPriv = new PSDEMainStateOPPrivImpl();
            iPSDEMainStateOPPriv.init(this.getDAGlobalHelper(), this, psDEMainStateOPPriv);
            this.psDEMainStateOPPrivList.add(iPSDEMainStateOPPriv);
        }
        Vector<PSDEMainStateField> psDEMainStateFieldList = new Vector<PSDEMainStateField>();
        callResult = this.getPSModelHelper().getPSDEMainStateFields(this.getId(), psDEMainStateFieldList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u4e3b\u72b6\u6001\u5b9e\u4f53\u5c5e\u6027\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSDEMainStateField psDEMainStateField : psDEMainStateFieldList) {
            if (!psDEMainStateField.isVALIDFLAGNull() && !psDEMainStateField.getVALIDFLAG()) continue;
            PSDEMainStateFieldImpl iPSDEMainStateField = new PSDEMainStateFieldImpl();
            iPSDEMainStateField.init(this.getDAGlobalHelper(), this, psDEMainStateField);
            this.psDEMainStateFieldList.add(iPSDEMainStateField);
        }
    }

    @Override
    @PSModelRTMeta(description="\u4e3b\u72b6\u6001\u63a7\u5236\u884c\u4e3a\u96c6\u5408", child=true, ignorepf=true, group="\u903b\u8f91", order=220)
    public Iterator<IPSDEMainStateAction> getPSDEMainStateActions() {
        return this.psDEMainStateActionList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u4e3b\u72b6\u6001\u63a7\u5236\u64cd\u4f5c\u6807\u8bc6\u96c6\u5408", child=true, group="\u903b\u8f91", order=222)
    public Iterator<IPSDEMainStateOPPriv> getPSDEMainStateOPPrivs() {
        return this.psDEMainStateOPPrivList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u4e3b\u72b6\u6001\u63a7\u5236\u5c5e\u6027\u96c6\u5408", child=true, ignorepf=true, group="\u903b\u8f91", order=224)
    public Iterator<IPSDEMainStateField> getPSDEMainStateFields() {
        return this.psDEMainStateFieldList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.strCodeName;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u6570\u636e\u67e5\u8be2\u5bf9\u8c61")
    public IPSDEDataQuery getPSDEDataQuery() {
        return this.iPSDEDataQuery;
    }

    @Override
    public String getPSDEDataQueryId() {
        return this.strPSDEDataQueryId;
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u540d\u79f0", fields={"PSDEMAINSTATENAME"})
    public String getLogicName() {
        return this.psDEMainState.getPSDEMAINSTATENAME();
    }

    @PSModelRTMeta(description="\u5141\u8bb8\u6a21\u5f0f", outputdoc="false", fields={"ALLOWMODE"})
    public boolean isAllowMode() {
        return this.bAllowMode;
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u4e3b\u72b6\u6001", fields={"DEFAULTMODE"})
    public boolean isDefault() {
        return this.bDefaultMode;
    }

    @Override
    @PSModelRTMeta(description="\u4e3b\u72b6\u6001\u6807\u8bb0", fields={"MSTAG"})
    public String getMSTag() {
        return this.strMSTag;
    }

    public boolean testDEAction(String strDEActionName) throws Exception {
        return false;
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u89c6\u56fe\u64cd\u4f5c\u63a7\u5236", fields={"ENABLEVIEWACTIONS"})
    public boolean isEnableViewActions() {
        return this.bEnableViewActions;
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u64cd\u4f5c\u63a7\u5236", codelist="DEViewActions", fields={"VIEWACTIONS"})
    public long getViewActions() {
        return this.nViewActions;
    }

    @Override
    public String getModelType() {
        return "PSDEMAINSTATE";
    }

    public void init(IDataEntity iDataEntity) throws Exception {
    }

    @Override
    @PSModelRTMeta(description="\u884c\u4e3a\u5141\u8bb8\u6a21\u5f0f", group="\u903b\u8f91", order=204, fields={"ALLOWMODE"})
    public boolean isActionAllowMode() {
        return this.isAllowMode();
    }

    @Override
    @PSModelRTMeta(description="\u64cd\u4f5c\u6807\u8bc6\u5141\u8bb8\u6a21\u5f0f", group="\u903b\u8f91", order=206, fields={"OPPRIVALLOWMODE"})
    public boolean isOPPrivAllowMode() {
        return this.bOPPrivAllowMode;
    }

    public boolean testDEOPPriv(String strDEOPPrivName) throws Exception {
        return false;
    }

    @Override
    @PSModelRTMeta(description="\u6d41\u7a0b\u72b6\u6001\u6a21\u5f0f", codelist="DEMSWFStateMode")
    public int getWFStateMode() throws Exception {
        if (this.nWFStateMode == -1) {
            if (this.getParentPSDEMainState() != null) {
                return this.getParentPSDEMainState().getWFStateMode();
            }
            return 0;
        }
        return this.nWFStateMode;
    }

    @Override
    @PSModelRTMeta(description="\u72b6\u6001\u503c", fields={"MSVALUE"})
    public String getStateValue() {
        return this.strStateValue;
    }

    @Override
    @PSModelRTMeta(description="\u72b6\u60012\u503c", fields={"MSVALUE2"})
    public String getState2Value() {
        return this.strState2Value;
    }

    @Override
    @PSModelRTMeta(description="\u72b6\u60013\u503c", fields={"MSVALUE3"})
    public String getState3Value() {
        return this.strState3Value;
    }

    @Override
    @PSModelRTMeta(description="\u7236\u72b6\u6001")
    public IPSDEMainState getParentPSDEMainState() throws Exception {
        block3: {
            Iterator<IPSDEMainState> psDEMainStates;
            block4: {
                Iterator<IPSDEMainState> psDEMainStates2;
                if (this.parentPSDEMainState != null) break block3;
                if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getState3Value())) break block4;
                if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getState2Value()) || (psDEMainStates2 = this.getPSDataEntity().getAllPSDEMainStates()) == null) break block3;
                while (psDEMainStates2.hasNext()) {
                    IPSDEMainState iPSDEMainState = psDEMainStates2.next();
                    if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)iPSDEMainState.getState3Value()) || SA.SRFramework.Utility.StringHelper.Compare((String)this.getStateValue(), (String)iPSDEMainState.getStateValue(), (boolean)false) != 0 || SA.SRFramework.Utility.StringHelper.Compare((String)this.getState2Value(), (String)iPSDEMainState.getState2Value(), (boolean)false) != 0) continue;
                    this.parentPSDEMainState = iPSDEMainState;
                    break block3;
                }
                break block3;
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getState2Value()) && (psDEMainStates = this.getPSDataEntity().getAllPSDEMainStates()) != null) {
                while (psDEMainStates.hasNext()) {
                    IPSDEMainState iPSDEMainState = psDEMainStates.next();
                    if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)iPSDEMainState.getState3Value()) || !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)iPSDEMainState.getState2Value()) || SA.SRFramework.Utility.StringHelper.Compare((String)this.getStateValue(), (String)iPSDEMainState.getStateValue(), (boolean)false) != 0) continue;
                    this.parentPSDEMainState = iPSDEMainState;
                    break;
                }
            }
        }
        return this.parentPSDEMainState;
    }

    @Override
    @PSModelRTMeta(description="\u5b50\u72b6\u6001\u96c6\u5408")
    public Iterator<IPSDEMainState> getPSDEMainStates() throws Exception {
        if (this.childPSDEMainStateList == null) {
            ArrayList<IPSDEMainState> psDEMainStateList = new ArrayList<IPSDEMainState>();
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getState3Value())) {
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getState2Value())) {
                    Iterator<IPSDEMainState> psDEMainStates = this.getPSDataEntity().getAllPSDEMainStates();
                    if (psDEMainStates != null) {
                        while (psDEMainStates.hasNext()) {
                            IPSDEMainState iPSDEMainState = psDEMainStates.next();
                            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)iPSDEMainState.getState3Value()) || SA.SRFramework.Utility.StringHelper.Compare((String)this.getStateValue(), (String)iPSDEMainState.getStateValue(), (boolean)false) != 0 || SA.SRFramework.Utility.StringHelper.Compare((String)this.getState2Value(), (String)iPSDEMainState.getState2Value(), (boolean)false) != 0) continue;
                            psDEMainStateList.add(iPSDEMainState);
                        }
                    }
                } else {
                    Iterator<IPSDEMainState> psDEMainStates = this.getPSDataEntity().getAllPSDEMainStates();
                    if (psDEMainStates != null) {
                        while (psDEMainStates.hasNext()) {
                            IPSDEMainState iPSDEMainState = psDEMainStates.next();
                            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)iPSDEMainState.getState3Value()) || SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)iPSDEMainState.getState2Value()) || SA.SRFramework.Utility.StringHelper.Compare((String)this.getStateValue(), (String)iPSDEMainState.getStateValue(), (boolean)false) != 0) continue;
                            psDEMainStateList.add(iPSDEMainState);
                        }
                    }
                }
            }
            if (this.childPSDEMainStateList == null) {
                this.childPSDEMainStateList = psDEMainStateList;
            }
        }
        if (this.childPSDEMainStateList == null || this.childPSDEMainStateList.size() == 0) {
            return null;
        }
        return this.childPSDEMainStateList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u524d\u5e8f\u72b6\u6001\u96c6\u5408", child=true, dumpref=true, rtdump=3, from="IPSDataEntity", outputdoc="false")
    public Iterator<IPSDEMainState> getPrevPSDEMainStates() throws Exception {
        if (SA.SRFramework.Utility.StringHelper.Compare((String)this.getEnterStateMode(), (String)"SOME", (boolean)false) != 0) {
            return null;
        }
        if (this.prevPSDEMainStateList == null) {
            ArrayList<IPSDEMainState> psDEMainStateList = new ArrayList<IPSDEMainState>();
            Iterator<IPSDEMainStateRS> psDEMainStateRSs = this.getPSDataEntity().getAllPSDEMainStateRSs();
            if (psDEMainStateRSs != null) {
                while (psDEMainStateRSs.hasNext()) {
                    IPSDEMainStateRS iPSDEMainStateRS = psDEMainStateRSs.next();
                    if (SA.SRFramework.Utility.StringHelper.Compare((String)iPSDEMainStateRS.getNextPSDEMainState().getId(), (String)this.getId(), (boolean)false) != 0) continue;
                    psDEMainStateList.add(iPSDEMainStateRS.getPrevPSDEMainState());
                }
            }
            if (this.prevPSDEMainStateList == null) {
                this.prevPSDEMainStateList = psDEMainStateList;
            }
        }
        if (this.prevPSDEMainStateList == null || this.prevPSDEMainStateList.size() == 0) {
            return null;
        }
        return this.prevPSDEMainStateList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u8fdb\u5165\u5b9e\u4f53\u884c\u4e3a", dumpref=true, from="IPSDataEntity", ignorepf=true, fields={"ENTERPSDEACTIONID"})
    public IPSDEAction getEnterPSDEAction() throws Exception {
        if (this.enterPSDEAction == null && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEMainState.getENTERPSDEACTIONID())) {
            this.enterPSDEAction = this.getPSDataEntity().getPSDEAction(this.psDEMainState.getENTERPSDEACTIONID());
        }
        return this.enterPSDEAction;
    }

    @Override
    @PSModelRTMeta(description="\u884c\u4e3a\u62d2\u7edd\u6d88\u606f", fields={"DEACTIONDENYMSG"})
    public String getActionDenyMsg() {
        return this.psDEMainState.getDEACTIONDENYMSG();
    }

    @Override
    @PSModelRTMeta(description="\u64cd\u4f5c\u6807\u8bc6\u62d2\u7edd\u6d88\u606f", fields={"DEOPPRIVDENYMSG"})
    public String getOPPrivDenyMsg() {
        return this.psDEMainState.getDEOPPRIVDENYMSG();
    }

    @Override
    @PSModelRTMeta(description="\u6392\u5e8f\u503c", ignoredumpvalues="99999")
    public int getOrderValue() {
        return this.nOrderValue;
    }

    @Override
    @PSModelRTMeta(description="\u8fdb\u5165\u72b6\u6001\u6a21\u5f0f", codelist="DEMSEnterMode", group="\u903b\u8f91", order=210)
    public String getEnterStateMode() {
        return this.strEnterStateMode;
    }

    @Override
    @PSModelRTMeta(description="\u5c5e\u6027\u5141\u8bb8\u6a21\u5f0f", group="\u903b\u8f91", order=208, fields={"FIELDALLOWMODE"})
    public boolean isFieldAllowMode() {
        return this.bFieldAllowMode;
    }

    @Override
    public String getDynaModelFilePath() {
        return null;
    }

    @Override
    public String getPSDEFormId() {
        return this.psDEMainState.getPSDEFORMID();
    }

    @Override
    public String getFormCodeName() {
        return this.psDEMainState.getFORMCODENAME();
    }

    @Override
    public String getMobPSDEFormId() {
        return this.psDEMainState.getMOBPSDEFORMID();
    }

    @Override
    public String getMobFormCodeName() {
        return this.psDEMainState.getMOBFORMCODENAME();
    }

    @Override
    public String getUtilPSDEFormId() {
        return this.psDEMainState.getUTILPSDEFORMID();
    }

    @Override
    public String getUtilFormCodeName() {
        return this.psDEMainState.getUTILFORMCODENAME();
    }

    @Override
    public String getMobUtilPSDEFormId() {
        return this.psDEMainState.getMOBUTILPSDEFORMID();
    }

    @Override
    public String getMobUtilFormCodeName() {
        return this.psDEMainState.getMOBUTILFORMCODENAME();
    }

    @Override
    public String getQuickPSDEFormId() {
        return this.psDEMainState.getQUICKPSDEFORMID();
    }

    @Override
    public String getQuickFormCodeName() {
        return this.psDEMainState.getQUICKFORMCODENAME();
    }

    @Override
    public String getMobQuickPSDEFormId() {
        return this.psDEMainState.getMOBQUICKPSDEFORMID();
    }

    @Override
    public String getMobQuickFormCodeName() {
        return this.psDEMainState.getMOBQUICKFORMCODENAME();
    }

    @Override
    @PSModelRTMeta(description="\u4e3b\u72b6\u6001\u7c7b\u578b", codelist="DEMainStateType", ignoredumpvalues="0", group="\u903b\u8f91", order=207)
    public int getMSType() {
        return this.nMainStateType;
    }
}

