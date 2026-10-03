/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.Base64Helper
 *  net.ibizsys.psrt.srv.common.entity.User
 *  net.ibizsys.psrt.srv.common.service.UserService
 *  net.sf.json.JSONArray
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Ctrl.DEDataCtrl;

import SA.SRFDA.PS.Core.Database.PSDBDevInstGlobal;
import SA.SRFDA.PS.Core.Deploy.IPSDBDevInst;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.JIT.Web.PSJITWebContext;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataCtrl;
import SA.SRFDA.PS.Data.PSUAWizard;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.Base64Helper;
import net.ibizsys.psrt.srv.common.entity.User;
import net.ibizsys.psrt.srv.common.service.UserService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class PSUAWizardDataCtrl
extends PSDEDataCtrl {
    private static final Log log = LogFactory.getLog(PSUAWizardDataCtrl.class);
    public static final String CUSTOMCALL_LISTJITUSERS = "LISTJITUSERS";
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
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_LISTJITUSERS, (boolean)true) == 0) {
            return this.listJITUsers(dataEntity);
        }
        return super.OnCustomCall(strCallName, dataEntity);
    }

    public static String toJsonString(ArrayList<PSUAWizard> psUAWizardList) throws Exception {
        return PSUAWizardDataCtrl.toJsonString(psUAWizardList, false);
    }

    public static String toJsonString(ArrayList<PSUAWizard> psUAWizardList, boolean bConvertTime) throws Exception {
        ArrayList<JSONObject> list = new ArrayList<JSONObject>();
        for (PSUAWizard baseDataEntity : psUAWizardList) {
            JSONObject jo = BaseDataEntity.ToJSONObject((BaseDataEntity)baseDataEntity, (boolean)false);
            if (bConvertTime) {
                jo = DataObject.convertJSONValueTimeFmt((JSONObject)jo, (String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS.%1$tL");
            }
            list.add(jo);
        }
        return JSONArray.fromArray((Object[])list.toArray()).toString();
    }

    public CallResult listJITUsers(BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            PSUAWizard psUAWizard = new PSUAWizard();
            psUAWizard.proxy(dataEntity);
            this.onListCodes(psUAWizard);
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edfJIT\u7528\u6237\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onListCodes(PSUAWizard psUAWizard) throws Exception {
        if (PSJITWebContext.getInstance() != null) {
            PSJITWebContext.setCurrent(null);
        }
        String strPSSystemId = psUAWizard.getParamStringValue("PSSYSTEMID", "");
        String strPSDevSlnSysId = psUAWizard.getParamStringValue("PSDEVSLNSYSID", "");
        IPSSystem iPSSystem = this.getPSSystem(strPSDevSlnSysId, strPSSystemId, IPSSystem.LOADLEVEL_CODE, true);
        IPSDBDevInst jitPSDBDevInst = iPSSystem.getJITPSDBDevInst();
        if (jitPSDBDevInst == null) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9aJIT\u6570\u636e\u6e90");
        }
        SessionFactory SessionFactory2 = PSDBDevInstGlobal.getSessionFactory(jitPSDBDevInst.getId());
        UserService userService = (UserService)ServiceGlobal.getService(UserService.class, (SessionFactory)SessionFactory2);
        SelectCond selectCond = new SelectCond();
        selectCond.set("VALIDFLAG", (Object)1);
        ArrayList<User> userList = userService.select((ISelectCond)selectCond);
        ArrayList<PSUAWizard> psUAWizardList = new ArrayList<PSUAWizard>();
        if (userList.size() > 0) {
            for (User user : userList) {
                PSUAWizard psUAWizard2 = new PSUAWizard();
                psUAWizard2.setPSUAWIZARDNAME(user.getUserName());
                psUAWizard2.setPSUAWIZARDID(user.getUserId());
                psUAWizardList.add(psUAWizard2);
            }
        }
        psUAWizard.set(TAG_MODELLIST, Base64Helper.encodeBytes((byte[])PSUAWizardDataCtrl.toJsonString(psUAWizardList).getBytes("GBK")));
    }
}
