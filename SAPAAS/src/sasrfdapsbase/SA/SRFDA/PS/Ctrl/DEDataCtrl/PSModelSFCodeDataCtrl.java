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

import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.JIT.Web.PSJITWebContext;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPub;
import SA.SRFDA.PS.Core.SF.IPSSFCodeFolder;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataCtrl;
import SA.SRFDA.PS.Data.PSModelSFCode;
import SA.SRFDA.PS.Data.PSSysSFCode;
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

public class PSModelSFCodeDataCtrl
extends PSDEDataCtrl {
    private static final Log log = LogFactory.getLog(PSModelSFCodeDataCtrl.class);
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

    public static String toJsonString(ArrayList<PSModelSFCode> psModelSFCodeList) throws Exception {
        return PSModelSFCodeDataCtrl.toJsonString(psModelSFCodeList, false);
    }

    public static String toJsonString(ArrayList<PSModelSFCode> psModelSFCodeList, boolean bConvertTime) throws Exception {
        ArrayList<JSONObject> list = new ArrayList<JSONObject>();
        for (PSModelSFCode baseDataEntity : psModelSFCodeList) {
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
            PSModelSFCode psModelSFCode = new PSModelSFCode();
            psModelSFCode.proxy(dataEntity);
            this.onListCodes(psModelSFCode);
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u6a21\u578b\u540e\u53f0\u4ee3\u7801\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onListCodes(PSModelSFCode psModelSFCode) throws Exception {
        if (PSJITWebContext.getInstance() != null) {
            PSJITWebContext.setCurrent(null);
        }
        String strPSSystemId = psModelSFCode.getParamStringValue("PSSYSTEMID", "");
        String strPSDevSlnSysId = psModelSFCode.getParamStringValue("PSDEVSLNSYSID", "");
        String strPSDEId = psModelSFCode.getParamStringValue("srfdeid", "");
        String strKey = psModelSFCode.getParamStringValue("srfkey", "");
        String strPSModelSFCodeId = psModelSFCode.getPSMODELSFCODEID();
        IPSSystem iPSSystem = this.getPSSystem(strPSDevSlnSysId, strPSSystemId, IPSSystem.LOADLEVEL_CODE, true);
        IPSSystemUtil iPSSystemUtil = (IPSSystemUtil)((Object)iPSSystem);
        Iterator<PSSysSFCode> psSysSFCodes = iPSSystemUtil.getPSModelSFCodes(strPSDEId, strKey);
        ArrayList<PSModelSFCode> psModelSFCodeList = new ArrayList<PSModelSFCode>();
        if (psSysSFCodes != null) {
            while (psSysSFCodes.hasNext()) {
                IPSSFCodeFolder iPSSFCodeFolder;
                PSSysSFCode psSysSFCode = psSysSFCodes.next();
                PSModelSFCode psModelSFCode2 = new PSModelSFCode();
                IPSSysSFPub iPSSysSFPub = null;
                if (StringHelper.IsNullOrEmpty((String)psSysSFCode.getPSSYSSFPUBID())) continue;
                iPSSysSFPub = iPSSystem.getPSSysSFPub(psSysSFCode.getPSSYSSFPUBID());
                if (iPSSysSFPub != null && !StringHelper.IsNullOrEmpty((String)psSysSFCode.getPSSFCODEFOLDERID()) && (iPSSFCodeFolder = iPSSysSFPub.getPSSFStyle().getPSSFCodeFolder(psSysSFCode.getPSSFCODEFOLDERID())).getPSSFStylePrj() != null) {
                    psModelSFCode2.setPRJNAME(iPSSFCodeFolder.getPSSFStylePrj().getPrjType());
                    psModelSFCode2.setPRJFOLDER(iPSSFCodeFolder.getPrjFolder());
                }
                psModelSFCode2.setPSMODELSFCODENAME(psSysSFCode.getPSSYSSFCODENAME());
                psModelSFCode2.setCODEPATH(String.valueOf(psModelSFCode2.getPRJFOLDER()) + psSysSFCode.getCODEPATH());
                psModelSFCode2.setPSSYSSFPUBID(psSysSFCode.getPSSYSSFPUBID());
                psModelSFCode2.setPSSYSSFPUBNAME(psSysSFCode.getPSSYSSFPUBNAME());
                psModelSFCode2.setPSMODELSFCODEID(KeyValueHelper.genUniqueId((String)psModelSFCode2.getPSSYSSFPUBID(), (String)psModelSFCode2.getPRJNAME(), (String)psModelSFCode2.getPSMODELSFCODENAME(), (String)psModelSFCode2.getCODEPATH()));
                if (!StringHelper.IsNullOrEmpty((String)strPSModelSFCodeId)) {
                    if (StringHelper.Compare((String)strPSModelSFCodeId, (String)psModelSFCode2.getPSMODELSFCODEID(), (boolean)false) != 0) continue;
                    psModelSFCode2.setPUBCODE(psSysSFCode.getPUBCODE());
                }
                psModelSFCode2.setCODEPKGNAME(StringHelper.TrimLeft((String)psSysSFCode.getCODEPATH(), (char)'/').replace("/", "."));
                psModelSFCode2.setPSSFCODETYPEID(psSysSFCode.getPSSFCODETYPEID());
                psModelSFCode2.setPSSFCODETYPENAME(psSysSFCode.getPSSFCODETYPENAME());
                if (iPSSysSFPub != null) {
                    psModelSFCode2.setCUSTOMFLAG(iPSSysSFPub.getPSSysSFUserCode(psModelSFCode2.getPSMODELSFCODEID(), true) != null);
                } else {
                    psModelSFCode2.setCUSTOMFLAG(false);
                }
                psModelSFCodeList.add(psModelSFCode2);
                if (!StringHelper.IsNullOrEmpty((String)strPSModelSFCodeId)) break;
            }
        }
        psModelSFCode.set(TAG_MODELLIST, Base64Helper.encodeBytes((byte[])PSModelSFCodeDataCtrl.toJsonString(psModelSFCodeList).getBytes("GBK")));
    }
}

