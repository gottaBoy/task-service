/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.util.Base64Helper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.sf.json.JSONArray
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Ctrl.DEDataCtrl;

import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.JIT.Web.PSJITWebContext;
import SA.SRFDA.PS.Core.PF.IPSPFPubCode;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataCtrl;
import SA.SRFDA.PS.Data.PSAppViewCode;
import SA.SRFDA.PS.Data.PSModelPFCode;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.util.Base64Helper;
import net.ibizsys.paas.util.KeyValueHelper;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSModelPFCodeDataCtrl
extends PSDEDataCtrl {
    private static final Log log = LogFactory.getLog(PSModelPFCodeDataCtrl.class);
    public static final String CUSTOMCALL_LISTCODES = "LISTCODES";
    public static final String CUSTOMCALL_GETCODE = "GETCODE";
    public static final String TAG_MODELLIST = "SRFMODELLIST";

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
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_LISTCODES, (boolean)true) == 0) {
            return this.listCodes(dataEntity);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_GETCODE, (boolean)true) == 0) {
            return this.listCodes(dataEntity);
        }
        return super.OnCustomCall(strCallName, dataEntity);
    }

    public static String toJsonString(ArrayList<PSModelPFCode> psModelPFCodeList) throws Exception {
        return PSModelPFCodeDataCtrl.toJsonString(psModelPFCodeList, false);
    }

    public static String toJsonString(ArrayList<PSModelPFCode> psModelPFCodeList, boolean bConvertTime) throws Exception {
        ArrayList<JSONObject> list = new ArrayList<JSONObject>();
        for (PSModelPFCode baseDataEntity : psModelPFCodeList) {
            JSONObject jo = BaseDataEntity.ToJSONObject((BaseDataEntity)baseDataEntity, (boolean)false);
            if (bConvertTime) {
                jo = DataObject.convertJSONValueTimeFmt((JSONObject)jo, (String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS.%1$tL");
            }
            list.add(jo);
        }
        return JSONArray.fromArray((Object[])list.toArray()).toString();
    }

    public CallResult listCodes(BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            PSModelPFCode psModelPFCode = new PSModelPFCode();
            psModelPFCode.proxy(dataEntity);
            this.onListCodes(psModelPFCode);
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u6a21\u578b\u524d\u53f0\u4ee3\u7801\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onListCodes(PSModelPFCode psModelPFCode) throws Exception {
        if (PSJITWebContext.getInstance() != null) {
            PSJITWebContext.setCurrent(null);
        }
        String strPSSystemId = psModelPFCode.getParamStringValue("PSSYSTEMID", "");
        String strPSDevSlnSysId = psModelPFCode.getParamStringValue("PSDEVSLNSYSID", "");
        String strPSDEId = psModelPFCode.getParamStringValue("srfdeid", "");
        String strKey = psModelPFCode.getParamStringValue("srfkey", "");
        String strPSModelPFCodeId = psModelPFCode.getPSMODELPFCODEID();
        IPSSystem iPSSystem = this.getPSSystem(strPSDevSlnSysId, strPSSystemId, IPSSystem.LOADLEVEL_CODE, true);
        IPSSystemUtil iPSSystemUtil = (IPSSystemUtil)((Object)iPSSystem);
        Iterator<PSAppViewCode> psAppViewCodes = iPSSystemUtil.getPSModelPFCodes(strPSDEId, strKey);
        ArrayList<PSModelPFCode> psModelPFCodeList = new ArrayList<PSModelPFCode>();
        if (psAppViewCodes != null) {
            while (psAppViewCodes.hasNext()) {
                PSAppViewCode psAppViewCode = psAppViewCodes.next();
                PSModelPFCode psModelPFCode2 = new PSModelPFCode();
                IPSApplication iPSApplication = iPSSystem.getPSApplication(psAppViewCode.getPSSYSAPPID());
                if (!StringHelper.IsNullOrEmpty((String)psAppViewCode.getPSPFPUBCODEID())) {
                    IPSPFPubCode iPSPFPubCode = null;
                    iPSPFPubCode = StringHelper.IsNullOrEmpty((String)psAppViewCode.getPSPFSTYLEID()) ? iPSApplication.getPSPFStyle().getPSPFPubCode(psAppViewCode.getPSPFPUBCODEID()) : iPSApplication.getPSPFStyle(psAppViewCode.getPSPFSTYLEID()).getPSPFPubCode(psAppViewCode.getPSPFPUBCODEID());
                    if (iPSPFPubCode != null && iPSPFPubCode.getPSPFCodeFolder() != null && !StringHelper.IsNullOrEmpty((String)iPSPFPubCode.getPSPFCodeFolder().getPrjType())) {
                        psModelPFCode2.setPRJNAME(iPSPFPubCode.getPSPFCodeFolder().getPrjType());
                        psModelPFCode2.setPRJFOLDER(iPSPFPubCode.getPSPFCodeFolder().getPrjFolder());
                    }
                }
                psModelPFCode2.setPSMODELPFCODENAME(psAppViewCode.getPSAPPVIEWCODENAME());
                psModelPFCode2.setCODEPKGNAME(StringHelper.TrimLeft((String)psAppViewCode.getCODEPATH(), (char)'/').replace("/", "."));
                psModelPFCode2.setCODEPATH(String.valueOf(StringHelper.Format((String)psModelPFCode2.getPRJFOLDER(), (Object)iPSApplication.getWorkshopName().toLowerCase())) + psAppViewCode.getCODEPATH().replace("/" + psAppViewCode.getPSAPPVIEWCODENAME(), ""));
                psModelPFCode2.setPSSYSAPPID(psAppViewCode.getPSSYSAPPID());
                psModelPFCode2.setPSSYSAPPNAME(psAppViewCode.getPSSYSAPPNAME());
                psModelPFCode2.setPSMODELPFCODEID(KeyValueHelper.genUniqueId((String)psModelPFCode2.getPSSYSAPPID(), (String)psModelPFCode2.getPRJNAME(), (String)psModelPFCode2.getPSMODELPFCODENAME(), (String)psModelPFCode2.getCODEPATH()));
                if (!StringHelper.IsNullOrEmpty((String)strPSModelPFCodeId)) {
                    if (StringHelper.Compare((String)strPSModelPFCodeId, (String)psModelPFCode2.getPSMODELPFCODEID(), (boolean)false) != 0) continue;
                    psModelPFCode2.setPUBCODE(psAppViewCode.getPUBCODE());
                }
                psModelPFCode2.setPSPFPUBCODEID(psAppViewCode.getPSPFPUBCODEID());
                psModelPFCode2.setPSPFPUBCODENAME(psAppViewCode.getPSPFPUBCODENAME());
                psModelPFCode2.setCUSTOMFLAG(iPSApplication.getPSAppViewCode(psModelPFCode2.getPSMODELPFCODEID(), true) != null);
                psModelPFCodeList.add(psModelPFCode2);
                if (!StringHelper.IsNullOrEmpty((String)strPSModelPFCodeId)) break;
            }
        }
        psModelPFCode.set(TAG_MODELLIST, Base64Helper.encodeBytes((byte[])PSModelPFCodeDataCtrl.toJsonString(psModelPFCodeList).getBytes("GBK")));
    }
}

