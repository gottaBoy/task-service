/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.util.Base64Helper
 *  net.sf.json.JSONArray
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Ctrl.DEDataCtrl;

import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.JIT.Web.PSJITWebContext;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataCtrl;
import SA.SRFDA.PS.Data.PSDCCodeSnippet;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.util.Base64Helper;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDCCodeSnippetDataCtrl
extends PSDEDataCtrl {
    private static final Log log = LogFactory.getLog(PSDCCodeSnippetDataCtrl.class);
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
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_GETCODE, (boolean)true) == 0) {
            return this.listCodes(dataEntity);
        }
        return super.OnCustomCall(strCallName, dataEntity);
    }

    public static String toJsonString(ArrayList<PSDCCodeSnippet> psDCCodeSnippetList) throws Exception {
        return PSDCCodeSnippetDataCtrl.toJsonString(psDCCodeSnippetList, false);
    }

    public static String toJsonString(ArrayList<PSDCCodeSnippet> psDCCodeSnippetList, boolean bConvertTime) throws Exception {
        ArrayList<JSONObject> list = new ArrayList<JSONObject>();
        for (PSDCCodeSnippet baseDataEntity : psDCCodeSnippetList) {
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
            PSDCCodeSnippet psDCCodeSnippet = new PSDCCodeSnippet();
            psDCCodeSnippet.proxy(dataEntity);
            this.onListCodes(psDCCodeSnippet);
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u6a21\u578b\u4ee3\u7801\u7247\u6bb5\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onListCodes(PSDCCodeSnippet psDCCodeSnippet) throws Exception {
        if (PSJITWebContext.getInstance() != null) {
            PSJITWebContext.setCurrent(null);
        }
        String strPSSystemId = psDCCodeSnippet.getParamStringValue("PSSYSTEMID", "");
        String strPSDevSlnSysId = psDCCodeSnippet.getParamStringValue("PSDEVSLNSYSID", "");
        String strPSDEId = psDCCodeSnippet.getParamStringValue("srfdeid", "");
        String strKey = psDCCodeSnippet.getParamStringValue("srfkey", "");
        String strPSDCCodeSnippetId = psDCCodeSnippet.getPSDCCODESNIPPETID();
        IPSSystem iPSSystem = this.getPSSystem(strPSDevSlnSysId, strPSSystemId, IPSSystem.LOADLEVEL_CODE, true);
        IPSSystemUtil iPSSystemUtil = (IPSSystemUtil)((Object)iPSSystem);
        ArrayList<PSDCCodeSnippet> psDCCodeSnippetList = new ArrayList<PSDCCodeSnippet>();
        IPSGenerateCodeResult iPSGenerateCodeResult = iPSSystemUtil.getPSModelCodeSnippet(strPSDEId, strKey, strPSDCCodeSnippetId);
        PSDCCodeSnippet psDCCodeSnippet2 = new PSDCCodeSnippet();
        psDCCodeSnippet2.setPSDCCODESNIPPETID(strPSDCCodeSnippetId);
        if (iPSGenerateCodeResult != null) {
            psDCCodeSnippet2.setTEMPLCODE(iPSGenerateCodeResult.getCode());
            psDCCodeSnippet2.setTEMPLCODE2(iPSGenerateCodeResult.getCode2());
        }
        psDCCodeSnippetList.add(psDCCodeSnippet2);
        psDCCodeSnippet.set(TAG_MODELLIST, Base64Helper.encodeBytes((byte[])PSDCCodeSnippetDataCtrl.toJsonString(psDCCodeSnippetList).getBytes("GBK")));
    }

    @Override
    protected void onReloadModel(BaseDataEntity dataEntity) throws Exception {
        try {
            PSDCCodeSnippet psDCCodeSnippet = new PSDCCodeSnippet();
            psDCCodeSnippet.proxy(dataEntity);
            this.getPSModelStorage().resetPSDCCodeSnippet(psDCCodeSnippet.getPSDCCODESNIPPETID());
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u5237\u65b0\u5e94\u7528\u4e2d\u5fc3\u4ee3\u7801\u7247\u6bb5\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            throw ex;
        }
    }
}

