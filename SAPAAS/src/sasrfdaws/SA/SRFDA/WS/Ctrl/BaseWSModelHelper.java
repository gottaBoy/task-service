/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Data.DBResult
 *  SA.SRFramework.Data.SelectResult
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 */
package SA.SRFDA.WS.Ctrl;

import SA.SRFDA.WS.Common.SRFWSGlobal;
import SA.SRFDA.WS.Ctrl.Data.WSChannel;
import SA.SRFDA.WS.Ctrl.Data.WSPage;
import SA.SRFDA.WS.Ctrl.Data.WSPageTempl;
import SA.SRFDA.WS.Ctrl.Data.WSPageType;
import SA.SRFDA.WS.Ctrl.Data.WSPageWB;
import SA.SRFDA.WS.Ctrl.Data.WSRuntime;
import SA.SRFDA.WS.Ctrl.Data.WSWBType;
import SA.SRFDA.WS.Ctrl.Data.WSWebPart;
import SA.SRFDA.WS.Ctrl.Data.WSWebSite;
import SA.SRFDA.WS.Ctrl.IWSModelHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Data.DBResult;
import SA.SRFramework.Data.SelectResult;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import java.util.Vector;

public class BaseWSModelHelper
implements IWSModelHelper {
    protected ISRFDAGlobalHelper iDAGlobalHelper = null;

    @Override
    public void Init(ISRFDAGlobalHelper iDAGlobalHelper) throws Exception {
        this.iDAGlobalHelper = iDAGlobalHelper;
        this.OnInit();
    }

    protected void OnInit() throws Exception {
    }

    @Override
    public CallResult GetWSPageType(String strWSPageTypeId, WSPageType wsPageType) {
        return this.SelectSingle(this.GetSQL_GetWSPageType(strWSPageTypeId), wsPageType, "SYSTEM");
    }

    @Override
    public CallResult GetWSPageTempl(String strWSPageTemplId, WSPageTempl wsPageTempl) {
        return this.SelectSingle(this.GetSQL_GetWSPageTempl(strWSPageTemplId), wsPageTempl, "SYSTEM");
    }

    protected String GetSQL_GetWSPageTempl(String strWSPageTemplId) {
        return StringHelper.Format((String)"select t1.* from t_srfwspagetempl t1 where t1.wspagetemplId='%1$s'", (Object)strWSPageTemplId);
    }

    @Override
    public CallResult GetWSPageTempls(String strWSPageTypeId, Vector<WSPageTempl> pageTempls) {
        if (this.iDAGlobalHelper.getDAModelHelper().GetDEModelVersion(SRFWSGlobal.DEID_WSPAGETEMPL) == -1) {
            return new CallResult();
        }
        return this.SelectMulti(this.GetSQL_GetWSPageTempls(strWSPageTypeId), pageTempls, WSPageTempl.class, "SYSTEM");
    }

    protected String GetSQL_GetWSPageTempls(String strWSPageTemplId) {
        return StringHelper.Format((String)"select t1.* from t_srfwspagetempl t1 where t1.wspagetypeid='%1$s'", (Object)strWSPageTemplId);
    }

    @Override
    public CallResult GetWSWBType(String strWSWBTypeId, WSWBType wsWBType) {
        return this.SelectSingle(this.GetSQL_GetWSWBTYpe(strWSWBTypeId), wsWBType, "SYSTEM");
    }

    protected String GetSQL_GetWSPageType(String strWSPageTypeId) {
        return StringHelper.Format((String)"select t1.* from t_srfwspagetype t1 where t1.wspagetypeid='%1$s'", (Object)strWSPageTypeId);
    }

    @Override
    public CallResult GetWSWebPart(String strWSWebPartId, WSWebPart wsWebPart) {
        return this.SelectSingle(this.GetSQL_GetWSWebPart(strWSWebPartId), wsWebPart, "SYSTEM");
    }

    protected String GetSQL_GetWSWebPart(String strWSWebPartId) {
        return StringHelper.Format((String)"select t1.* from v_srfwswebpart t1 where t1.wswebpartid = '%1$s'", (Object)strWSWebPartId);
    }

    protected String GetSQL_GetWSWBTYpe(String strWSWBTypeId) {
        return StringHelper.Format((String)"select t1.* from T_SRFWSWBTYPE t1 where t1.WSWBTYPEID='%1$s'", (Object)strWSWBTypeId);
    }

    @Override
    public CallResult GetWSWebSite(String strWebSiteId, WSWebSite wsWebSite) {
        return this.SelectSingle(this.GetSQL_GetWSWebsite(strWebSiteId), wsWebSite, "SYSTEM");
    }

    protected String GetSQL_GetWSWebsite(String strWSWebsiteId) {
        return StringHelper.Format((String)"select t1.* from v_srfwswebsite t1 where t1.wswebsiteid='%1$s'", (Object)strWSWebsiteId);
    }

    @Override
    public CallResult GetWSChannel(String strWSWebsiteId, Vector<WSChannel> channels) {
        if (this.iDAGlobalHelper.getDAModelHelper().GetDEModelVersion(SRFWSGlobal.DEID_WSCHANNEL) == -1) {
            return new CallResult();
        }
        return this.SelectMulti(this.GetSQL_GetWSWebsiteChannels(strWSWebsiteId), channels, WSChannel.class, "SYSTEM");
    }

    protected String GetSQL_GetWSWebsiteChannels(String strWSWebsiteId) {
        return StringHelper.Format((String)"select t1.* from v_srfwschannel t1 where t1.wswebsiteid='%1$s'", (Object)strWSWebsiteId);
    }

    @Override
    public CallResult GetWSPage(String strWSPageId, WSPage wsPage) {
        return this.SelectSingle(this.GetSQL_GetWSPage(strWSPageId), wsPage, "SYSTEM");
    }

    protected String GetSQL_GetWSPage(String strWSPageId) {
        return StringHelper.Format((String)"select t1.* from v_srfwspage t1 where t1.wspageid='%1$s'", (Object)strWSPageId);
    }

    @Override
    public CallResult GetWSWebSiteRuntimes(String strWSWebsiteId, Vector<WSRuntime> wsRuntimes) {
        if (this.iDAGlobalHelper.getDAModelHelper().GetDEModelVersion(SRFWSGlobal.DEID_WSRUNTIME) == -1) {
            return new CallResult();
        }
        return this.SelectMulti(this.GetSQL_GetWSWebSiteRuntimes(strWSWebsiteId), wsRuntimes, WSRuntime.class, "SYSTEM");
    }

    protected String GetSQL_GetWSWebSiteRuntimes(String strWSWebsiteId) {
        return StringHelper.Format((String)"select t1.* from v_srfwsruntime t1 where t1.wswebsiteid='%1$s'", (Object)strWSWebsiteId);
    }

    @Override
    public CallResult GetWSPages(String strWSWebsiteId, Vector<WSPage> pages) {
        if (this.iDAGlobalHelper.getDAModelHelper().GetDEModelVersion(SRFWSGlobal.DEID_WSPAGE) == -1) {
            return new CallResult();
        }
        return this.SelectMulti(this.GetSQL_GetWSWebsitePages(strWSWebsiteId), pages, WSPage.class, "SYSTEM");
    }

    protected String GetSQL_GetWSWebsitePages(String strWSWebsiteId) {
        return StringHelper.Format((String)"select t1.* from v_srfwspage t1 where t1.wswebsiteid='%1$s'", (Object)strWSWebsiteId);
    }

    @Override
    public CallResult GetWSPageWBs(String strWSPageId, Vector<WSPageWB> pageWBs) {
        if (this.iDAGlobalHelper.getDAModelHelper().GetDEModelVersion(SRFWSGlobal.DEID_WSPAGEWB) == -1) {
            return new CallResult();
        }
        return this.SelectMulti(this.GetSQL_GetWSPageWBs(strWSPageId), pageWBs, WSPageWB.class, "SYSTEM");
    }

    protected String GetSQL_GetWSPageWBs(String strWSPageId) {
        return StringHelper.Format((String)"select t1.* from v_srfwspagewb t1 where t1.wspageid='%1$s'", (Object)strWSPageId);
    }

    @Override
    public CallResult GetWSWebParts(String strWSWebsiteId, Vector<WSWebPart> webparts) {
        if (this.iDAGlobalHelper.getDAModelHelper().GetDEModelVersion(SRFWSGlobal.DEID_WSWEBPART) == -1) {
            return new CallResult();
        }
        return this.SelectMulti(this.GetSQL_GetWSWebsiteWebParts(strWSWebsiteId), webparts, WSWebPart.class, "SYSTEM");
    }

    protected String GetSQL_GetWSWebsiteWebParts(String strWSWebsiteId) {
        return StringHelper.Format((String)"select t1.* from v_srfwswebpart t1 where t1.wswebsiteid='%1$s'", (Object)strWSWebsiteId);
    }

    protected CallResult SelectSingle(String strSQL, BaseDataEntity dataEntity, String strOpPersonId) {
        CallResult callResult = new CallResult();
        try {
            SelectResult selectResult = this.iDAGlobalHelper.getDBCaller().CallRaw2(strSQL);
            if (selectResult == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo("\u4e0d\u660e\u9519\u8bef");
                return callResult;
            }
            if (selectResult.getRetCode() != 0) {
                callResult.From((DBResult)selectResult);
                return callResult;
            }
            if (selectResult.getMainTable() == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo("\u6ca1\u6709\u8fd4\u56de\u6570\u636e\u8868\u5bf9\u8c61");
                return callResult;
            }
            if (selectResult.getMainTable().GetRowCount() == 0) {
                callResult.setRetCode(3);
                return callResult;
            }
            dataEntity.FromDataRow(selectResult.getMainTable().GetRow(0));
            callResult.setRetCode(0);
            return callResult;
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected CallResult SelectMulti(String strSQL, Vector list, Class classType, String strOpPersonId) {
        CallResult callResult = new CallResult();
        try {
            SelectResult selectResult = this.iDAGlobalHelper.getDBCaller().CallRaw2(strSQL);
            if (selectResult == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo("\u4e0d\u660e\u9519\u8bef");
                return callResult;
            }
            if (selectResult.getRetCode() != 0) {
                callResult.From((DBResult)selectResult);
                return callResult;
            }
            if (selectResult.getMainTable() == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo("\u6ca1\u6709\u8fd4\u56de\u6570\u636e\u8868\u5bf9\u8c61");
                return callResult;
            }
            int nRowCount = selectResult.getMainTable().GetRowCount();
            int i = 0;
            while (i < nRowCount) {
                Object obj;
                BaseDataEntity dataEntity = null;
                if (classType != null && (obj = ObjectHelper.Create((Class)classType)) != null && obj instanceof BaseDataEntity) {
                    dataEntity = (BaseDataEntity)obj;
                }
                if (dataEntity == null) {
                    dataEntity = new BaseDataEntity();
                }
                dataEntity.FromDataRow(selectResult.getMainTable().GetRow(i));
                list.add(dataEntity);
                ++i;
            }
            callResult.setRetCode(0);
            return callResult;
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected CallResult SelectMulti(String strSQL, Vector list, String strObjectName, String strOpPersonId) {
        CallResult callResult = new CallResult();
        try {
            SelectResult selectResult = this.iDAGlobalHelper.getDBCaller().CallRaw2(strSQL);
            if (selectResult == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo("\u4e0d\u660e\u9519\u8bef");
                return callResult;
            }
            if (selectResult.getRetCode() != 0) {
                callResult.From((DBResult)selectResult);
                return callResult;
            }
            if (selectResult.getMainTable() == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo("\u6ca1\u6709\u8fd4\u56de\u6570\u636e\u8868\u5bf9\u8c61");
                return callResult;
            }
            int nRowCount = selectResult.getMainTable().GetRowCount();
            int i = 0;
            while (i < nRowCount) {
                Object obj;
                BaseDataEntity dataEntity = null;
                if (!StringHelper.IsNullOrEmpty((String)strObjectName) && (obj = ObjectHelper.Create((String)strObjectName)) != null && obj instanceof BaseDataEntity) {
                    dataEntity = (BaseDataEntity)obj;
                }
                if (dataEntity == null) {
                    dataEntity = new BaseDataEntity();
                }
                dataEntity.FromDataRow(selectResult.getMainTable().GetRow(i));
                list.add(dataEntity);
                ++i;
            }
            callResult.setRetCode(0);
            return callResult;
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }
}

