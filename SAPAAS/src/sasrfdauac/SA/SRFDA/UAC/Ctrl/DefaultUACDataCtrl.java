/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.UAC.Ctrl;

import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.UAC.Ctrl.Data.UACAuthInt;
import SA.SRFDA.UAC.Ctrl.Data.UACDataSource;
import SA.SRFDA.UAC.Ctrl.Data.UACLDAPSource;
import SA.SRFDA.UAC.Ctrl.Data.UACRadiusSource;
import SA.SRFDA.UAC.Ctrl.Data.UACSecuAudit;
import SA.SRFDA.UAC.Ctrl.Data.UACServer;
import SA.SRFDA.UAC.Ctrl.IUACDataCtrl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;

public class DefaultUACDataCtrl
implements IUACDataCtrl {
    protected ISRFDAGlobalHelper iDAGlobalHelper;
    protected IDEDataCtrl iSecuAuditDataCtlr = null;

    @Override
    public CallResult Init(ISRFDAGlobalHelper iDAGlobalHelper) {
        CallResult callResult = new CallResult();
        this.iDAGlobalHelper = iDAGlobalHelper;
        this.iSecuAuditDataCtlr = this.iDAGlobalHelper.getDAModelStorage().FindDEDataCtrl("UAC0008", "SYSTEM", null);
        if (this.iSecuAuditDataCtlr == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"UAC0008"));
        }
        return callResult;
    }

    @Override
    public CallResult GetUACServer(String strServerId, UACServer uacServer) {
        return BaseDEDataCtrl.SelectSingle((ISRFDAGlobalHelper)this.iDAGlobalHelper, (String)this.GetSQL_GetUACServer(strServerId), (BaseDataEntity)uacServer);
    }

    protected String GetSQL_GetUACServer(String strServerId) {
        return StringHelper.Format((String)"select * from t_SRFUACSERVER where UPPER(UACSERVERID)='%1$s'", (Object)strServerId.toUpperCase());
    }

    @Override
    public CallResult GetUACServerAuthInts(String strServerId, Vector<UACAuthInt> list) {
        return BaseDEDataCtrl.SelectMulti((ISRFDAGlobalHelper)this.iDAGlobalHelper, (String)this.GetSQL_GetUACServerAuthInts(strServerId), list, (String)UACAuthInt.class.getName());
    }

    protected String GetSQL_GetUACServerAuthInts(String strServerId) {
        return StringHelper.Format((String)"select t1.* from T_SRFUACAUTHINT  t1 INNER JOIN T_SRFUACPOLICYDETAIL t2 ON t1.UACAUTHINTID = t2.UACAUTHINTID INNER JOIN T_SRFUACPOLICY t3 ON t2.UACPOLICYID = t3.UACPOLICYID INNER JOIN T_SRFUACSERVER t4 ON t4.UACPOLICYID = t3.UACPOLICYID WHERE UPPER(t4.UACSERVERID)='%1$s' AND t2.ISENABLE  = 1  ORDER BY t2.AUTHORDER", (Object)strServerId.toUpperCase());
    }

    @Override
    public CallResult GetUACDataSource(String strUACDataSourceId, UACDataSource uacDataSource) {
        return BaseDEDataCtrl.SelectSingle((ISRFDAGlobalHelper)this.iDAGlobalHelper, (String)this.GetSQL_GetUACDataSource(strUACDataSourceId), (BaseDataEntity)uacDataSource);
    }

    protected String GetSQL_GetUACDataSource(String strUACDataSourceId) {
        return StringHelper.Format((String)"select * from t_SRFUACDATASOURCE where UPPER(UACDATASOURCEID)='%1$s'", (Object)strUACDataSourceId.toUpperCase());
    }

    @Override
    public CallResult GetUACLDAPSource(String strUACLDAPSourceId, UACLDAPSource uacLDAPSource) {
        return BaseDEDataCtrl.SelectSingle((ISRFDAGlobalHelper)this.iDAGlobalHelper, (String)this.GetSQL_GetUACLDAPSource(strUACLDAPSourceId), (BaseDataEntity)uacLDAPSource);
    }

    protected String GetSQL_GetUACLDAPSource(String strUACLDAPSourceId) {
        return StringHelper.Format((String)"select * from t_SRFUACLDAPSOURCE where UPPER(UACLDAPSOURCEID)='%1$s'", (Object)strUACLDAPSourceId.toUpperCase());
    }

    @Override
    public CallResult GetUACRadiusSource(String strUACRadiusSourceId, UACRadiusSource uacRadiusSource) {
        return BaseDEDataCtrl.SelectSingle((ISRFDAGlobalHelper)this.iDAGlobalHelper, (String)this.GetSQL_GetUACRadiusSource(strUACRadiusSourceId), (BaseDataEntity)uacRadiusSource);
    }

    protected String GetSQL_GetUACRadiusSource(String strUACRadiusSourceId) {
        return StringHelper.Format((String)"select * from T_SRFUACRADIUSSOURCE where UPPER(UACRADIUSSOURCEID)='%1$s'", (Object)strUACRadiusSourceId.toUpperCase());
    }

    @Override
    public CallResult AddUACSecuAudit(UACSecuAudit secuAudit) {
        return this.iSecuAuditDataCtlr.Save(true, (BaseDataEntity)secuAudit);
    }
}

