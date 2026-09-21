/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFramework.CommonEx.Errors
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Ctrl.DEDataCtrl;

import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.PS.Core.CodeList.IPSCodeItem;
import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.View.IPSViewType;
import SA.SRFDA.PS.Core.View.IPSViewTypeCtrl;
import SA.SRFDA.PS.Core.View.IPSViewTypeView;
import SA.SRFDA.PS.Core.WF.IPSWorkflow;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.IPSModelInitDataCtrl;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataCtrl;
import SA.SRFDA.PS.Data.PSDEField;
import SA.SRFDA.PS.Data.PSDEViewBase;
import SA.SRFDA.PS.Data.PSDEViewCtrl;
import SA.SRFDA.PS.Data.PSDEViewView;
import SA.SRFDA.PS.Data.PSDataEntity;
import SA.SRFDA.PS.Data.PSSystem;
import SA.SRFDA.PS.Data.PSWFDE;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFramework.CommonEx.Errors;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import java.util.Iterator;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEViewBaseDataCtrl
extends PSDEDataCtrl
implements IPSModelInitDataCtrl {
    public static final String CUSTOMCALL_FIXMODEL = "FIXMODEL";
    private static final Log log = LogFactory.getLog(PSDEViewBaseDataCtrl.class);
    private static String[] initViewTypes = new String[]{"DEEDITVIEW", "DEEDITVIEW2", "DEGRIDVIEW", "DEINDEXPICKUPDATAVIEW", "DEFORMPICKUPDATAVIEW", "DEPICKUPGRIDVIEW", "DEPICKUPVIEW", "DEMPICKUPVIEW"};
    private static String[] initWFViewTypes = new String[]{"DEWFGRIDVIEW", "DEWFEDITVIEW"};

    @Override
    protected CallResult OnBeforeSave(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnBeforeSave(bInsert, strActionMode, dataEntity, lastDataEntity);
        if (callResult.isError()) {
            return callResult;
        }
        return callResult;
    }

    @Override
    protected CallResult OnCustomCall(String strCallName, BaseDataEntity dataEntity) {
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_FIXMODEL, (boolean)true) == 0) {
            return this.fixModel(dataEntity);
        }
        return super.OnCustomCall(strCallName, dataEntity);
    }

    public CallResult fixModel(BaseDataEntity dataEntity) {
        CallResult callResult = this.Get(dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            PSDEViewBase psDEViewBase = new PSDEViewBase();
            psDEViewBase.proxy(dataEntity);
            this.onFixModel(psDEViewBase);
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u4fee\u590d\u89c6\u56fe\u6a21\u578b\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onFixModel(PSDEViewBase psDEViewBase) throws Exception {
        IPSViewType iPSViewType = this.getPSModelStorage().getPSViewType(psDEViewBase.getPSDEVIEWBASETYPE());
        IDEDataCtrl psDEViewViewDataCtrl = this.GetRelatedDataCtrl("DE2301");
        IDEDataCtrl psDEViewCtrlDataCtrl = this.GetRelatedDataCtrl("DE2302");
        Iterator<IPSViewTypeView> psViewTypeViews = iPSViewType.getPSViewTypeViews();
        while (psViewTypeViews.hasNext()) {
            IPSViewTypeView iPSViewTypeView = psViewTypeViews.next();
            PSDEViewView psDEViewView = new PSDEViewView();
            psDEViewView.setMAJORPSDEVIEWID(psDEViewBase.getPSDEVIEWBASEID());
            psDEViewView.setMAJORPSDEVIEWNAME(psDEViewBase.getPSDEVIEWBASENAME());
            psDEViewView.setPSDEVIEWRVNAME(iPSViewTypeView.getName());
            if (psDEViewViewDataCtrl.CheckKeyState2((BaseDataEntity)psDEViewView) != 0) continue;
            psDEViewView.setDEFVIEWTYPE(iPSViewTypeView.getPredefinedView());
            psDEViewView.setMEMO(iPSViewTypeView.getMemo());
            CallResult callResult = psDEViewViewDataCtrl.Save(true, (BaseDataEntity)psDEViewView);
            if (!callResult.isError()) continue;
            throw new Exception(StringHelper.Format((String)"\u4fdd\u5b58\u5b9e\u4f53\u89c6\u56fe\u5173\u8054\u89c6\u56fe\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        Iterator<IPSViewTypeCtrl> psViewTypeCtrls = iPSViewType.getPSViewTypeCtrls();
        while (psViewTypeCtrls.hasNext()) {
            IPSViewTypeCtrl iPSViewTypeCtrl = psViewTypeCtrls.next();
            PSDEViewCtrl psDEViewCtrl = new PSDEViewCtrl();
            psDEViewCtrl.setPSDEVIEWBASEID(psDEViewBase.getPSDEVIEWBASEID());
            psDEViewCtrl.setPSDEVIEWBASENAME(psDEViewBase.getPSDEVIEWBASENAME());
            psDEViewCtrl.setPSDEVIEWCTRLNAME(iPSViewTypeCtrl.getName());
            psDEViewCtrl.setPSDEVIEWCTRLTYPE(iPSViewTypeCtrl.getCtrlType());
            psDEViewCtrl.setPSDEID(psDEViewBase.getPSDEID());
            CallResult callResult = psDEViewCtrlDataCtrl.AutoSave((BaseDataEntity)psDEViewCtrl);
            if (!callResult.isError()) continue;
            throw new Exception(StringHelper.Format((String)"\u4fdd\u5b58\u5b9e\u4f53\u89c6\u56fe\u90e8\u4ef6\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
    }

    public CallResult GetDefault(ISRFDAWebContext webContext, BaseDataEntity dataEntity) {
        CallResult callResult = super.GetDefault(webContext, dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        String strPSViewBaseType = webContext.GetParamValue("PSDEVIEWBASETYPE");
        if (!StringHelper.IsNullOrEmpty((String)strPSViewBaseType)) {
            dataEntity.setParamValue("PSDEVIEWBASETYPE", (Object)strPSViewBaseType);
        }
        return callResult;
    }

    @Override
    public CallResult initModel(String strDEId, BaseDataEntity dataEntity, String strMode) {
        CallResult callResult = new CallResult();
        try {
            if (StringHelper.Compare((String)strDEId, (String)"DE2050", (boolean)true) == 0) {
                PSDataEntity psDataEntity = new PSDataEntity();
                psDataEntity.proxy(dataEntity);
                String[] stringArray = initViewTypes;
                int n = initViewTypes.length;
                int n2 = 0;
                while (n2 < n) {
                    String strViewType = stringArray[n2];
                    IPSViewType iPSViewType = this.getPSModelStorage().getPSViewType(strViewType);
                    this.initDEView(psDataEntity, iPSViewType);
                    ++n2;
                }
                this.initDEWFViews(psDataEntity);
                return callResult;
            }
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)ex.getMessage(), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void initDEView(PSDataEntity psDataEntity, IPSViewType iPSViewType) throws Exception {
        if (StringHelper.Compare((String)iPSViewType.getId(), (String)"DEINDEXPICKUPDATAVIEW", (boolean)true) == 0) {
            String strIndexMode = psDataEntity.getINDEXDETYPE();
            if (!StringHelper.IsNullOrEmpty((String)strIndexMode)) {
                this.initDEView(psDataEntity, iPSViewType, "INDEXDETYPE", strIndexMode, null, null, null);
            }
            return;
        }
        if (StringHelper.Compare((String)iPSViewType.getId(), (String)"DEFORMPICKUPDATAVIEW", (boolean)true) == 0) {
            if (psDataEntity.getENAMULTIFORM() > 0) {
                this.initDEView(psDataEntity, iPSViewType, "FORMTYPE", "", null, null, null);
            }
            return;
        }
        String strPredefineType = "";
        if (StringHelper.Compare((String)iPSViewType.getId(), (String)"DEPICKUPVIEW", (boolean)true) == 0) {
            strPredefineType = "PICKUPVIEW";
        }
        if (StringHelper.Compare((String)iPSViewType.getId(), (String)"DEMPICKUPVIEW", (boolean)true) == 0) {
            strPredefineType = "MPICKUPVIEW";
        }
        this.initDEView(psDataEntity, iPSViewType, "", "", null, strPredefineType, null);
        if (StringHelper.Compare((String)iPSViewType.getId(), (String)"DEPICKUPVIEW", (boolean)true) == 0) {
            PSDEViewBase srcPSDEViewBase;
            String strIndexMode = psDataEntity.getINDEXDETYPE();
            if (!StringHelper.IsNullOrEmpty((String)strIndexMode)) {
                srcPSDEViewBase = new PSDEViewBase();
                srcPSDEViewBase.setPSDEVIEWBASENAME(StringHelper.Format((String)"%1$s(\u7d22\u5f15\u5b9e\u4f53)%2$s", (Object)psDataEntity.getLOGICNAME(), (Object)iPSViewType.getName()));
                srcPSDEViewBase.setCODENAME("Index" + iPSViewType.getCodeName());
                this.initDEView(psDataEntity, iPSViewType, "INDEXDETYPE", strIndexMode, srcPSDEViewBase, "INDEXDEPICKUPVIEW", null);
            }
            if (psDataEntity.getENAMULTIFORM() > 0) {
                srcPSDEViewBase = new PSDEViewBase();
                srcPSDEViewBase.setPSDEVIEWBASENAME(StringHelper.Format((String)"%1$s(\u8868\u5355\u7c7b\u578b)%2$s", (Object)psDataEntity.getLOGICNAME(), (Object)iPSViewType.getName()));
                srcPSDEViewBase.setCODENAME("Form" + iPSViewType.getCodeName());
                this.initDEView(psDataEntity, iPSViewType, "FORMTYPE", "", srcPSDEViewBase, "FORMPICKUPVIEW", null);
            }
        }
    }

    protected void initDEView(PSDataEntity psDataEntity, IPSViewType iPSViewType, String strSubTypeId, String strTag, PSDEViewBase srcPSDEViewBase, String strPredefineType, String strPDTParam) throws Exception {
        String strDEViewId = "";
        strDEViewId = StringHelper.IsNullOrEmpty((String)strSubTypeId) ? Helper.GenUniqueId((String)psDataEntity.getPSDATAENTITYID(), (String)iPSViewType.getId()) : Helper.GenUniqueId((String)psDataEntity.getPSDATAENTITYID(), (String)iPSViewType.getId(), (String)strSubTypeId, (String)strTag);
        PSDEViewBase psDEViewBase = new PSDEViewBase();
        psDEViewBase.setPSDEVIEWBASEID(strDEViewId);
        CallResult callResult = this.Get(psDEViewBase);
        if (Errors.IsSpecialError((int)callResult.getRetCode(), (int)3)) {
            Iterator<IPSViewTypeView> psViewTypeViews;
            psDEViewBase.setPSSYSTEMID(psDataEntity.getPSSYSTEMID());
            psDEViewBase.setPSDEID(psDataEntity.getPSDATAENTITYID());
            psDEViewBase.setPSDENAME(psDataEntity.getPSDATAENTITYNAME());
            psDEViewBase.setPSDEVIEWBASENAME(StringHelper.Format((String)"%1$s%2$s", (Object)psDataEntity.getLOGICNAME(), (Object)iPSViewType.getName()));
            psDEViewBase.setPSDEVIEWBASETYPE(iPSViewType.getId());
            psDEViewBase.setCODENAME(iPSViewType.getCodeName());
            if (srcPSDEViewBase != null) {
                srcPSDEViewBase.CopyTo(psDEViewBase, false);
            }
            if (!StringHelper.IsNullOrEmpty((String)strPredefineType)) {
                PSDEViewBase predefineDEViewBase = new PSDEViewBase();
                predefineDEViewBase.setPSDEID(psDataEntity.getPSDATAENTITYID());
                predefineDEViewBase.setPREDEFINEVIEWTYPE(strPredefineType);
                if (!StringHelper.IsNullOrEmpty((String)strPDTParam)) {
                    predefineDEViewBase.setPDVTPARAM(strPDTParam);
                }
                if ((callResult = this.Select(predefineDEViewBase)).isError()) {
                    psDEViewBase.setPREDEFINEVIEWTYPE(strPredefineType);
                    psDEViewBase.setPDVTPARAM(strPDTParam);
                }
            }
            if ((callResult = this.Save(true, psDEViewBase)).isError()) {
                throw new Exception(StringHelper.Format((String)"\u521d\u59cb\u5316\u5b9e\u4f53\u89c6\u56fe\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            PSSystem psSystem = new PSSystem();
            psSystem.setPSSYSTEMID(psDataEntity.getPSSYSTEMID());
            IDEDataCtrl psSystemDataCtrl = this.GetRelatedDataCtrl("DE2030");
            callResult = psSystemDataCtrl.Get((BaseDataEntity)psSystem);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u7cfb\u7edf\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            Iterator<IPSViewTypeCtrl> psViewTypeCtrls = iPSViewType.getPSViewTypeCtrls();
            if (psViewTypeCtrls != null) {
                while (psViewTypeCtrls.hasNext()) {
                    IPSViewTypeCtrl iPSViewTypeCtrl = psViewTypeCtrls.next();
                    this.initDEViewCtrl(psSystem, psDataEntity, iPSViewType, psDEViewBase, iPSViewTypeCtrl, strSubTypeId, strTag);
                }
            }
            if ((psViewTypeViews = iPSViewType.getPSViewTypeViews()) != null) {
                while (psViewTypeViews.hasNext()) {
                    IPSViewTypeView iPSViewTypeView = psViewTypeViews.next();
                    this.initDEViewView(psSystem, psDataEntity, iPSViewType, psDEViewBase, iPSViewTypeView, strSubTypeId, strTag);
                }
            }
        }
    }

    protected void initDEViewCtrl(PSSystem psSystem, PSDataEntity psDataEntity, IPSViewType iPSViewType, PSDEViewBase psDEViewBase, IPSViewTypeCtrl iPSViewTypeCtrl, String strSubTypeId, String strTag) throws Exception {
        PSDEViewCtrl psDEViewCtrl = new PSDEViewCtrl();
        psDEViewCtrl.setPSDEVIEWBASEID(psDEViewBase.getPSDEVIEWBASEID());
        psDEViewCtrl.setPSDEVIEWBASENAME(psDEViewBase.getPSDEVIEWBASENAME());
        psDEViewCtrl.setPSDEVIEWCTRLNAME(iPSViewTypeCtrl.getName());
        psDEViewCtrl.setPSDEVIEWCTRLTYPE(iPSViewTypeCtrl.getCtrlType());
        psDEViewCtrl.setPSDEID(psDEViewBase.getPSDEID());
        this.fillDEViewCtrl(psDEViewCtrl, psSystem, psDataEntity, iPSViewType, psDEViewBase, iPSViewTypeCtrl, strSubTypeId, strTag);
        IDEDataCtrl psDEViewCtrlDataCtrl = this.GetRelatedDataCtrl("DE2302");
        CallResult callResult = psDEViewCtrlDataCtrl.Save(true, (BaseDataEntity)psDEViewCtrl);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u521d\u59cb\u5316\u5b9e\u4f53\u89c6\u56fe\u90e8\u4ef6\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        callResult = psDEViewCtrlDataCtrl.Save(false, (BaseDataEntity)psDEViewCtrl);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u521d\u59cb\u5316\u5b9e\u4f53\u89c6\u56fe\u90e8\u4ef6\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
    }

    protected void fillDEViewCtrl(PSDEViewCtrl psDEViewCtrl, PSSystem psSystem, PSDataEntity psDataEntity, IPSViewType iPSViewType, PSDEViewBase psDEViewBase, IPSViewTypeCtrl iPSViewTypeCtrl, String strSubTypeId, String strTag) throws Exception {
        if (StringHelper.Compare((String)iPSViewTypeCtrl.getCtrlType(), (String)"FORM", (boolean)true) == 0) {
            String strDefaultEditFormId = Helper.GenUniqueId((String)psDataEntity.getPSDATAENTITYID(), (String)"EDITFORM");
            psDEViewCtrl.setPSDEFORMID(strDefaultEditFormId);
            if (!StringHelper.IsNullOrEmpty((String)iPSViewTypeCtrl.getPSSysACHandlerId())) {
                psDEViewCtrl.setPSACHANDLERID(PSDEViewBaseDataCtrl.getPSACHandlerId(iPSViewTypeCtrl.getPSSysACHandlerId(), psSystem));
            }
            return;
        }
        if (StringHelper.Compare((String)iPSViewTypeCtrl.getCtrlType(), (String)"SEARCHFORM", (boolean)true) == 0) {
            String strDefaultSearchFormId = Helper.GenUniqueId((String)psDataEntity.getPSDATAENTITYID(), (String)"SEARCHFORM");
            psDEViewCtrl.setPSDEFORMID(strDefaultSearchFormId);
            if (!StringHelper.IsNullOrEmpty((String)iPSViewTypeCtrl.getPSSysACHandlerId())) {
                psDEViewCtrl.setPSACHANDLERID(PSDEViewBaseDataCtrl.getPSACHandlerId(iPSViewTypeCtrl.getPSSysACHandlerId(), psSystem));
            }
            return;
        }
        if (StringHelper.Compare((String)iPSViewTypeCtrl.getCtrlType(), (String)"GRID", (boolean)true) == 0) {
            String strDefaultGridId = psDataEntity.getPSDATAENTITYID();
            psDEViewCtrl.setPSDEGRIDID(strDefaultGridId);
            psDEViewCtrl.setPSDEDATASETID(psDataEntity.getPSDATAENTITYID());
            if (!StringHelper.IsNullOrEmpty((String)iPSViewTypeCtrl.getPSSysACHandlerId())) {
                psDEViewCtrl.setPSACHANDLERID(PSDEViewBaseDataCtrl.getPSACHandlerId(iPSViewTypeCtrl.getPSSysACHandlerId(), psSystem));
            }
            return;
        }
        if (StringHelper.Compare((String)iPSViewTypeCtrl.getCtrlType(), (String)"TOOLBAR", (boolean)true) == 0) {
            if (!StringHelper.IsNullOrEmpty((String)iPSViewTypeCtrl.getPSSysToolbarId())) {
                String strPSDEToolbarId = Helper.GenUniqueId((String)psSystem.getPSSYSTEMID(), (String)iPSViewTypeCtrl.getPSSysToolbarId());
                psDEViewCtrl.setPSDETOOLBARID(strPSDEToolbarId);
            }
            return;
        }
        if (StringHelper.Compare((String)iPSViewTypeCtrl.getCtrlType(), (String)"PICKUPVIEWPANEL", (boolean)true) == 0) {
            String strDEViewId = "";
            strDEViewId = StringHelper.Compare((String)strSubTypeId, (String)"INDEXDETYPE", (boolean)true) == 0 ? Helper.GenUniqueId((String)psDataEntity.getPSDATAENTITYID(), (String)"DEINDEXPICKUPDATAVIEW", (String)strSubTypeId, (String)strTag) : (StringHelper.Compare((String)strSubTypeId, (String)"FORMTYPE", (boolean)true) == 0 ? Helper.GenUniqueId((String)psDataEntity.getPSDATAENTITYID(), (String)"DEFORMPICKUPDATAVIEW", (String)strSubTypeId, (String)strTag) : Helper.GenUniqueId((String)psDataEntity.getPSDATAENTITYID(), (String)"DEPICKUPGRIDVIEW"));
            psDEViewCtrl.setPSDEVIEWID(strDEViewId);
            return;
        }
        if (StringHelper.Compare((String)iPSViewTypeCtrl.getCtrlType(), (String)"DRBAR", (boolean)true) == 0) {
            String strDEDRId = psDataEntity.getPSDATAENTITYID();
            psDEViewCtrl.setPSDEDRID(strDEDRId);
            return;
        }
        if (StringHelper.Compare((String)iPSViewTypeCtrl.getCtrlType(), (String)"DATAVIEW", (boolean)true) == 0) {
            String strDefaultDataViewId = "";
            if (StringHelper.IsNullOrEmpty((String)strSubTypeId)) {
                strDefaultDataViewId = psDataEntity.getPSDATAENTITYID();
                psDEViewCtrl.setPSDEDATASETID(psDataEntity.getPSDATAENTITYID());
                if (!StringHelper.IsNullOrEmpty((String)iPSViewTypeCtrl.getPSSysACHandlerId())) {
                    psDEViewCtrl.setPSACHANDLERID(PSDEViewBaseDataCtrl.getPSACHandlerId(iPSViewTypeCtrl.getPSSysACHandlerId(), psSystem));
                }
            } else {
                strDefaultDataViewId = Helper.GenUniqueId((String)psDataEntity.getPSDATAENTITYID(), (String)strSubTypeId, (String)strTag);
                String strPSDEDataSetId = "";
                String strPSSysACHandlerId = "";
                if (StringHelper.Compare((String)strSubTypeId, (String)"INDEXDETYPE", (boolean)true) == 0) {
                    strPSDEDataSetId = Helper.GenUniqueId((String)psDataEntity.getPSDATAENTITYID(), (String)"INDEXDETYPE", (String)strTag);
                    strPSSysACHandlerId = "INDEXPICKUPDATAVIEWHANDLER";
                } else if (StringHelper.Compare((String)strSubTypeId, (String)"FORMTYPE", (boolean)true) == 0) {
                    strPSDEDataSetId = Helper.GenUniqueId((String)psDataEntity.getPSDATAENTITYID(), (String)"FORMTYPE", (String)"");
                    strPSSysACHandlerId = "FORMPICKUPDATAVIEWHANDLER";
                }
                psDEViewCtrl.setPSDEDATASETID(strPSDEDataSetId);
                psDEViewCtrl.setPSACHANDLERID(PSDEViewBaseDataCtrl.getPSACHandlerId(strPSSysACHandlerId, psSystem));
            }
            psDEViewCtrl.setPSDEDATAVIEWID(strDefaultDataViewId);
            return;
        }
    }

    protected static String getPSACHandlerId(String strPSSysACHandlerId, PSSystem psSystem) {
        String strPSSFACHandlerId = Helper.GenUniqueId((String)strPSSysACHandlerId, (String)psSystem.getPSSFID());
        return Helper.GenUniqueId((String)psSystem.getPSSYSTEMID(), (String)strPSSFACHandlerId);
    }

    protected void initDEViewView(PSSystem psSystem, PSDataEntity psDataEntity, IPSViewType iPSViewType, PSDEViewBase psDEViewBase, IPSViewTypeView iPSViewTypeView, String strSubTypeId, String strTag) throws Exception {
        PSDEViewView psDEViewView = new PSDEViewView();
        psDEViewView.setMAJORPSDEVIEWID(psDEViewBase.getPSDEVIEWBASEID());
        psDEViewView.setMAJORPSDEVIEWNAME(psDEViewBase.getPSDEVIEWBASENAME());
        psDEViewView.setPSDEVIEWRVNAME(iPSViewTypeView.getName());
        this.fillDEViewView(psDEViewView, psSystem, psDataEntity, iPSViewType, psDEViewBase, iPSViewTypeView, strSubTypeId, strTag);
        IDEDataCtrl psDEViewViewDataCtrl = this.GetRelatedDataCtrl("DE2301");
        CallResult callResult = psDEViewViewDataCtrl.Save(true, (BaseDataEntity)psDEViewView);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u521d\u59cb\u5316\u5b9e\u4f53\u89c6\u56fe\u5173\u8054\u89c6\u56fe\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
    }

    protected void fillDEViewView(PSDEViewView psDEViewView, PSSystem psSystem, PSDataEntity psDataEntity, IPSViewType iPSViewType, PSDEViewBase psDEViewBase, IPSViewTypeView iPSViewTypeView, String strSubTypeId, String strTag) throws Exception {
        if (StringHelper.Compare((String)iPSViewType.getId(), (String)"DEGRIDVIEW", (boolean)true) == 0) {
            if (StringHelper.Compare((String)iPSViewTypeView.getName(), (String)"NEWDATA", (boolean)true) == 0) {
                String strDEViewId = Helper.GenUniqueId((String)psDataEntity.getPSDATAENTITYID(), (String)"DEEDITVIEW");
                psDEViewView.setMINORPSDEVIEWID(strDEViewId);
                return;
            }
            if (StringHelper.Compare((String)iPSViewTypeView.getName(), (String)"EDITDATA", (boolean)true) == 0) {
                String strDEViewId = Helper.GenUniqueId((String)psDataEntity.getPSDATAENTITYID(), (String)"DEEDITVIEW");
                psDEViewView.setMINORPSDEVIEWID(strDEViewId);
                return;
            }
        }
    }

    protected void initDEWFViews(PSDataEntity psDataEntity) throws Exception {
        Vector<PSWFDE> psWFDEList = new Vector<PSWFDE>();
        CallResult callResult = this.getPSModelHelper().getPSWFDEs(psDataEntity.getPSDATAENTITYID(), psWFDEList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u6d41\u7a0b\u914d\u7f6e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        if (psWFDEList.size() == 0) {
            return;
        }
        IPSSystem iPSSystem = this.getPSModelStorage().getPSSystem(psDataEntity.getPSSYSTEMID());
        for (PSWFDE psWFDE : psWFDEList) {
            PSDEField wfStepDEField = new PSDEField();
            callResult = this.getPSModelHelper().getPSDEField(psWFDE.getWFSTEPPSDEFID(), wfStepDEField);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u6d41\u7a0b\u6b65\u9aa4\u5c5e\u6027\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            IPSCodeList wfStepCodeList = null;
            if (!StringHelper.IsNullOrEmpty((String)wfStepDEField.getPSCODELISTID())) {
                wfStepCodeList = iPSSystem.getPSCodeList(wfStepDEField.getPSCODELISTID());
            }
            String[] stringArray = initWFViewTypes;
            int n = initWFViewTypes.length;
            int n2 = 0;
            while (n2 < n) {
                String strViewType = stringArray[n2];
                IPSViewType iPSViewType = this.getPSModelStorage().getPSViewType(strViewType);
                this.initDEWFView(psDataEntity, iPSViewType, psWFDE, iPSSystem, wfStepCodeList);
                ++n2;
            }
        }
    }

    protected void initDEWFView(PSDataEntity psDataEntity, IPSViewType iPSViewType, PSWFDE psWFDE, IPSSystem iPSSystem, IPSCodeList wfStepCodeList) throws Exception {
        if (StringHelper.Compare((String)iPSViewType.getId(), (String)"DEWFGRIDVIEW", (boolean)true) == 0) {
            IPSWorkflow iPSWorkflow = iPSSystem.getPSWorkflow(psWFDE.getPSWFID());
            String strPDTParam = StringHelper.Format((String)"%1$s:D", (Object)psWFDE.getCODENAME());
            strPDTParam = strPDTParam.toUpperCase();
            PSDEViewBase srcPSDEViewBase = new PSDEViewBase();
            srcPSDEViewBase.setVIEWPARAM5(false);
            srcPSDEViewBase.setPSWFDEID(psWFDE.getPSWFDEID());
            srcPSDEViewBase.setPSDEVIEWBASENAME(StringHelper.Format((String)"%1$s%2$s(%3$s)", (Object)psDataEntity.getLOGICNAME(), (Object)iPSViewType.getName(), (Object)iPSWorkflow.getName()));
            srcPSDEViewBase.setCODENAME(StringHelper.Format((String)"%1$s_D_%2$s", (Object)psWFDE.getCODENAME(), (Object)iPSViewType.getCodeName()));
            this.initDEView(psDataEntity, iPSViewType, iPSWorkflow.getId(), "D", srcPSDEViewBase, "WFMDATAVIEW", strPDTParam);
            strPDTParam = StringHelper.Format((String)"%1$s:W", (Object)psWFDE.getCODENAME());
            strPDTParam = strPDTParam.toUpperCase();
            srcPSDEViewBase = new PSDEViewBase();
            srcPSDEViewBase.setVIEWPARAM5(true);
            srcPSDEViewBase.setPSWFDEID(psWFDE.getPSWFDEID());
            srcPSDEViewBase.setPSDEVIEWBASENAME(StringHelper.Format((String)"%1$s%2$s(%3$s)", (Object)psDataEntity.getLOGICNAME(), (Object)iPSViewType.getName(), (Object)iPSWorkflow.getName()));
            srcPSDEViewBase.setCODENAME(StringHelper.Format((String)"%1$s_W_%2$s", (Object)psWFDE.getCODENAME(), (Object)iPSViewType.getCodeName()));
            this.initDEView(psDataEntity, iPSViewType, iPSWorkflow.getId(), "W", srcPSDEViewBase, "WFMDATAVIEW", strPDTParam);
            if (wfStepCodeList != null && wfStepCodeList.getPSCodeItems() != null) {
                Iterator<IPSCodeItem> psCodeItems = wfStepCodeList.getPSCodeItems();
                while (psCodeItems.hasNext()) {
                    IPSCodeItem ipsCodeItem = psCodeItems.next();
                    String strPDTParam2 = StringHelper.Format((String)"%1$s:W:%2$s", (Object)psWFDE.getCODENAME(), (Object)ipsCodeItem.getValue());
                    strPDTParam2 = strPDTParam2.toUpperCase();
                    PSDEViewBase srcPSDEViewBase2 = new PSDEViewBase();
                    srcPSDEViewBase2.setVIEWPARAM5(true);
                    srcPSDEViewBase2.setVIEWPARAM(ipsCodeItem.getValue());
                    srcPSDEViewBase2.setPSWFDEID(psWFDE.getPSWFDEID());
                    srcPSDEViewBase2.setPSDEVIEWBASENAME(StringHelper.Format((String)"%1$s%2$s(%3$s:%4$s)", (Object)psDataEntity.getLOGICNAME(), (Object)iPSViewType.getName(), (Object)iPSWorkflow.getName(), (Object)ipsCodeItem.getText()));
                    srcPSDEViewBase2.setCODENAME(StringHelper.Format((String)"%1$s_W%2$s_%3$s", (Object)psWFDE.getCODENAME(), (Object)ipsCodeItem.getValue(), (Object)iPSViewType.getCodeName()));
                    this.initDEView(psDataEntity, iPSViewType, iPSWorkflow.getId(), "W:" + ipsCodeItem.getValue(), srcPSDEViewBase2, "WFMDATAVIEW", strPDTParam2);
                }
            }
            return;
        }
        if (StringHelper.Compare((String)iPSViewType.getId(), (String)"DEWFEDITVIEW", (boolean)true) == 0) {
            IPSWorkflow iPSWorkflow = iPSSystem.getPSWorkflow(psWFDE.getPSWFID());
            String strPDTParam = StringHelper.Format((String)"%1$s:D", (Object)psWFDE.getCODENAME());
            strPDTParam = strPDTParam.toUpperCase();
            PSDEViewBase srcPSDEViewBase = new PSDEViewBase();
            srcPSDEViewBase.setVIEWPARAM5(false);
            srcPSDEViewBase.setPSWFDEID(psWFDE.getPSWFDEID());
            srcPSDEViewBase.setPSDEVIEWBASENAME(StringHelper.Format((String)"%1$s%2$s(%3$s)", (Object)psDataEntity.getLOGICNAME(), (Object)iPSViewType.getName(), (Object)iPSWorkflow.getName()));
            srcPSDEViewBase.setCODENAME(StringHelper.Format((String)"%1$s_D_%2$s", (Object)psWFDE.getCODENAME(), (Object)iPSViewType.getCodeName()));
            this.initDEView(psDataEntity, iPSViewType, iPSWorkflow.getId(), "D", srcPSDEViewBase, "WFEDITVIEW", strPDTParam);
            if (wfStepCodeList != null && wfStepCodeList.getPSCodeItems() != null) {
                Iterator<IPSCodeItem> psCodeItems = wfStepCodeList.getPSCodeItems();
                while (psCodeItems.hasNext()) {
                    IPSCodeItem ipsCodeItem = psCodeItems.next();
                    String strPDTParam3 = StringHelper.Format((String)"%1$s:W:%2$s", (Object)psWFDE.getCODENAME(), (Object)ipsCodeItem.getValue());
                    strPDTParam3 = strPDTParam3.toUpperCase();
                    PSDEViewBase srcPSDEViewBase3 = new PSDEViewBase();
                    srcPSDEViewBase3.setVIEWPARAM5(true);
                    srcPSDEViewBase3.setVIEWPARAM(ipsCodeItem.getValue());
                    srcPSDEViewBase3.setPSWFDEID(psWFDE.getPSWFDEID());
                    srcPSDEViewBase3.setPSDEVIEWBASENAME(StringHelper.Format((String)"%1$s%2$s(%3$s:%4$s)", (Object)psDataEntity.getLOGICNAME(), (Object)iPSViewType.getName(), (Object)iPSWorkflow.getName(), (Object)ipsCodeItem.getText()));
                    srcPSDEViewBase3.setCODENAME(StringHelper.Format((String)"%1$s_W%2$s_%3$s", (Object)psWFDE.getCODENAME(), (Object)ipsCodeItem.getValue(), (Object)iPSViewType.getCodeName()));
                    this.initDEView(psDataEntity, iPSViewType, iPSWorkflow.getId(), "W:" + ipsCodeItem.getValue(), srcPSDEViewBase3, "WFEDITVIEW", strPDTParam3);
                }
            }
            return;
        }
    }
}

