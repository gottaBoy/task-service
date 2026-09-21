/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDAQueryModelHelper
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFramework.Data.DataRow
 *  SA.SRFramework.Data.DataSet
 *  SA.SRFramework.Data.SelectResult
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.PropertiesHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  freemarker.template.SimpleCollection
 *  freemarker.template.SimpleHash
 */
package SA.SRFDA.WS.Web;

import SA.SRFDA.Ctrl.BaseDAQueryModelHelper;
import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.WS.Ctrl.Data.WSPageWB;
import SA.SRFDA.WS.Ctrl.Data.WSWPInfoList;
import SA.SRFDA.WS.Ctrl.IWSPageHelper;
import SA.SRFDA.WS.Ctrl.IWSWBTypeHelper;
import SA.SRFDA.WS.Ctrl.IWSWebPartHelper;
import SA.SRFDA.WS.Ctrl.IWSWebSiteHelper;
import SA.SRFDA.WS.Ctrl.WSHelper.WSWPInfoListHelper;
import SA.SRFDA.WS.Web.BaseWSMainPage;
import SA.SRFramework.Data.DataRow;
import SA.SRFramework.Data.DataSet;
import SA.SRFramework.Data.SelectResult;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import freemarker.template.SimpleCollection;
import freemarker.template.SimpleHash;
import java.util.Map;
import java.util.Properties;
import java.util.Vector;

public class WSListViewPage
extends BaseWSMainPage {
    String strWSPageWBId = "";
    String strWSWebSiteId = "";
    IWSWBTypeHelper iWSWBTypeHelper = null;
    IWSWebPartHelper iwsWebPartHelper = null;
    IWSWebSiteHelper iwsWebSiteHelper = null;
    IWSPageHelper iwsPageHelper = null;
    WSWPInfoList wsWPInfoList = null;
    WSPageWB wsPageWB = null;
    int nTotalRow = 1;

    public String RenderInfoList(String strWSWebSiteId, String strPageId, String strWBTypeId, String strWebPartId, String strWSPageWBId) {
        this.strWSWebSiteId = strWSWebSiteId;
        this.strWSPageWBId = strWSPageWBId;
        String strInfoList = "";
        try {
            this.iwsWebSiteHelper = this.getWSModelStorage().FindWSWebSiteHelper(strWSWebSiteId);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        if (this.iwsWebSiteHelper == null) {
            strInfoList = StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u7f51\u7ad9\u7ad9\u70b9[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)strWSWebSiteId);
            this.PageLog((Object)this, 0, strInfoList);
            return strInfoList;
        }
        try {
            this.iwsPageHelper = this.iwsWebSiteHelper.FindWSPageHelper(strPageId);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        if (this.iwsPageHelper == null) {
            strInfoList = StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u7f51\u7ad9\u9875\u9762[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)strPageId);
            this.PageLog((Object)this, 0, strInfoList);
            return strInfoList;
        }
        try {
            this.iWSWBTypeHelper = this.getWSModelStorage().FindWSWBTypeHelper(strWBTypeId);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        if (this.iWSWBTypeHelper == null) {
            strInfoList = StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u90e8\u4ef6\u7c7b\u578b[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)strWBTypeId);
            this.PageLog((Object)this, 0, strInfoList);
            return strInfoList;
        }
        this.wsPageWB = this.iwsPageHelper.FindWSPageWB(strWSPageWBId);
        try {
            this.iwsWebPartHelper = this.getWSModelStorage().FindWSWebPartHelper(strWebPartId);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        if (this.iwsWebPartHelper instanceof WSWPInfoListHelper) {
            WSWPInfoListHelper wsWPInfoListHelper = (WSWPInfoListHelper)this.iwsWebPartHelper;
            this.wsWPInfoList = wsWPInfoListHelper.getWSWPInfoList();
        }
        if (this.iwsPageHelper == null) {
            strInfoList = StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u90e8\u4ef6[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)strWebPartId);
            this.PageLog((Object)this, 0, strInfoList);
            return strInfoList;
        }
        strInfoList = this.TemplateProcess(this.iWSWBTypeHelper.getWSWBType().getTEMPLATE());
        return strInfoList;
    }

    @Override
    protected void OnFillTemplateContext(Map<String, Object> pageModellMap) {
        Object objValue = null;
        try {
            objValue = this.SelectAndFillResult(pageModellMap);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        if (objValue == null) {
            Vector sh = new Vector();
            objValue = new SimpleCollection(sh);
        }
        pageModellMap.put("CAPTION", this.iwsWebPartHelper.getWSWebPart().getWSWEBPARTNAME());
        pageModellMap.put(this.iWSWBTypeHelper.getWSWBType().getWSWBTYPENAME(), objValue);
    }

    protected void OnFillInfoDetailUrl(Map<String, Object> pageModellMap, String strWSPageId) {
        String strDetailUrl = "";
        String strDetailTarget = "";
        if (!StringHelper.IsNullOrEmpty((String)strWSPageId)) {
            IWSPageHelper iwsDetailPageHelper = null;
            try {
                iwsDetailPageHelper = this.iwsWebSiteHelper.FindWSPageHelper(strWSPageId);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            if (iwsDetailPageHelper == null) {
                this.PageLog((Object)this, 0, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u7f51\u7ad9\u9875\u9762[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)strWSPageId));
            } else {
                strDetailUrl = iwsDetailPageHelper.getPublishedPageUrl();
                strDetailTarget = iwsDetailPageHelper.getWSPage().getTARGET();
            }
            strDetailUrl = StringHelper.IsNullOrEmpty((String)strDetailUrl) ? "#" : StringHelper.Format((String)"../%1$s?SRFDEID=%2$s&%3$s=", (Object)strDetailUrl, (Object)this.iDEHelper.getDataEntity().getDEID(), (Object)this.iDEHelper.GetKeyDEFHelper().getDEField().getDEFNAME().toUpperCase());
        }
        pageModellMap.put("DETAILURL", strDetailUrl);
        pageModellMap.put("DETAILTARGET", strDetailTarget);
    }

    protected void OnFillInfoMoreUrl(Map<String, Object> pageModellMap, String strWSPageId) {
        String strMoreUrl = "";
        String strMoreTarget = "";
        if (!StringHelper.IsNullOrEmpty((String)strWSPageId)) {
            IWSPageHelper iwsPageHelper = null;
            try {
                iwsPageHelper = this.iwsWebSiteHelper.FindWSPageHelper(strWSPageId);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            if (iwsPageHelper == null) {
                this.PageLog((Object)this, 0, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u7f51\u7ad9\u9875\u9762[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)strWSPageId));
            } else {
                strMoreUrl = iwsPageHelper.getPublishedPageUrl();
                strMoreTarget = iwsPageHelper.getWSPage().getTARGET();
            }
            strMoreUrl = StringHelper.IsNullOrEmpty((String)strMoreUrl) ? "#" : StringHelper.Format((String)"../%1$s", (Object)strMoreUrl);
        }
        pageModellMap.put("MOREURL", strMoreUrl);
        pageModellMap.put("MORETARGET", strMoreTarget);
    }

    protected void OnFillPagingBarContext(Map<String, Object> pageModellMap, int nTotalRow) {
        int nPageSize = this.getPageSize();
        int nTotalPage = (nTotalRow - 1) / nPageSize + 1;
        pageModellMap.put("CURPAGE", this.getCurPageNo());
        pageModellMap.put("PAGESIZE", nPageSize);
        pageModellMap.put("TOTALROW", nTotalRow);
        pageModellMap.put("TOTALPAGE", nTotalPage);
        pageModellMap.put("URI", this.getPage().getRequest().getRequestURI());
    }

    protected Object SelectAndFillResult(Map<String, Object> pageModellMap) throws Exception {
        String strParams = this.iWSWBTypeHelper.getWSWBType().getPARAMS();
        if (StringHelper.IsNullOrEmpty((String)strParams)) {
            throw new Exception("\u4fe1\u606f\u5217\u8868\u90e8\u4ef6\u6ca1\u6709\u914d\u7f6e\u6307\u5b9a\u7684\u53c2\u6570");
        }
        Properties pro = null;
        try {
            pro = PropertiesHelper.Load((String)strParams);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new Exception(StringHelper.Format((String)"\u4fe1\u606f\u5217\u8868\u53c2\u6570[%1$s]\u914d\u7f6e\u4e0d\u6b63\u786e", (Object)strParams));
        }
        if (pro == null) {
            throw new Exception(StringHelper.Format((String)"\u4fe1\u606f\u5217\u8868\u53c2\u6570[%1$s]\u914d\u7f6e\u4e0d\u6b63\u786e", (Object)strParams));
        }
        String strDEId = this.OnGetDEId(pro);
        this.iDEHelper = this.getWebContext().getGlobalHelper().getDAModelStorage().FindDEHelper(strDEId);
        if (this.iDEHelper == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)strDEId));
        }
        String strSql = this.GetQuerySql(pro);
        String strTotalSql = StringHelper.Format((String)"select count(*) as TOTALROW from (%1$s)", (Object)strSql);
        String strOrderSql = this.OnGetOrderSql(pro);
        if (!StringHelper.IsNullOrEmpty((String)strOrderSql)) {
            strSql = String.valueOf(strSql) + StringHelper.Format((String)" %1$s ", (Object)strOrderSql);
        }
        SelectResult selectResult2 = null;
        try {
            selectResult2 = this.iDEHelper.getGlobalHelper().getDBCaller(this.iDEHelper.GetDBStorage()).CallRaw2(strTotalSql);
        }
        catch (Exception e1) {
            e1.printStackTrace();
            throw new Exception(StringHelper.Format((String)"\u6267\u884c[%1$s]\u67e5\u8be2\u8bb0\u5f55\u6570\u5931\u8d25\uff0c%1$s\r\n", (Object)strTotalSql, (Object)selectResult2.getErrorInfo()));
        }
        if (selectResult2.getRetCode() != 0) {
            throw new Exception(StringHelper.Format((String)"\u6267\u884c[%1$s]\u67e5\u8be2\u8bb0\u5f55\u6570\u5931\u8d25\uff0c%1$s\r\n", (Object)strTotalSql, (Object)selectResult2.getErrorInfo()));
        }
        if (selectResult2.getSelectData().getTableCount() != 1) {
            throw new Exception(StringHelper.Format((String)"\u6267\u884c[%1$s]\u67e5\u8be2\u8bb0\u5f55\u6570\u5931\u8d25\uff0c%1$s\r\n", (Object)strTotalSql, (Object)selectResult2.getErrorInfo()));
        }
        DataSet dsCount = selectResult2.getSelectData();
        String strTotalRow = dsCount.getTable(0).GetRow(0).Get("TOTALROW").toString();
        this.nTotalRow = Integer.parseInt(strTotalRow);
        String strPaginSql = this.GetPaingSql(strSql);
        SelectResult selectResult = null;
        selectResult = this.iDEHelper.getGlobalHelper().getDBCaller(this.iDEHelper.GetDBStorage()).CallRaw2(strPaginSql);
        if (selectResult == null) {
            throw new Exception(StringHelper.Format((String)"\u6267\u884c\u547d\u4ee4[%1$s]\uff0c\u67e5\u8be2\u4fe1\u606f\u5217\u8868\u6570\u636e\u8bb0\u5f55\u4e3a\u7a7a", (Object)strPaginSql));
        }
        Vector iDEFHelpers = this.iDEHelper.GetDEFHelpers();
        Vector<SimpleHash> datas = new Vector<SimpleHash>();
        int nRowNumber = 0;
        for (Object obj : selectResult.getMainTable().getRows()) {
            ++nRowNumber;
            DataRow dr = (DataRow)obj;
            BaseDataEntity data = new BaseDataEntity();
            try {
                data.FromDataRow(dr);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            SimpleHash sh = new SimpleHash();
            sh.put("ROWNUMBER", (Object)nRowNumber);
            for (IDEFHelper iDEFHelper : iDEFHelpers) {
                String strDEFName = iDEFHelper.getDEField().getDEFNAME().toUpperCase();
                Object objValue = iDEFHelper.GetDEFValue(data.GetParamStringValue(strDEFName, ""));
                sh.put(strDEFName, objValue);
                if (iDEFHelper.IsKeyDEField()) {
                    sh.put("ID", objValue);
                }
                if (!iDEFHelper.IsMajorDEField()) continue;
                sh.put("NAME", objValue);
            }
            datas.add(sh);
        }
        String strMorePageId = this.OnGetMorePageId(pro);
        this.OnFillInfoMoreUrl(pageModellMap, strMorePageId);
        String strDetailPageId = this.OnGetDetailPageId(pro);
        this.OnFillInfoDetailUrl(pageModellMap, strDetailPageId);
        this.OnFillPagingBarContext(pageModellMap, this.nTotalRow);
        return new SimpleCollection(datas);
    }

    protected int getCurPageNo() {
        String strCurPageNo = this.getWebContext().GetParamValue("curpage");
        int nPageNo = 1;
        if (StringHelper.IsNullOrEmpty((String)strCurPageNo)) {
            return nPageNo;
        }
        try {
            nPageNo = Integer.parseInt(strCurPageNo);
        }
        catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return nPageNo;
    }

    protected int getPageSize() {
        return this.wsWPInfoList.getPAGINGSIZE();
    }

    protected String GetPaingSql(String strSql) {
        int nCurPageNo = this.getCurPageNo();
        int nPagingSize = this.getPageSize();
        int nStartRow = (nCurPageNo - 1) * nPagingSize + 1;
        int nEndRow = nCurPageNo * nPagingSize + 1;
        return StringHelper.Format((String)"select * from (select m1.*, rownum  as SRFROWINDEX from (%1$s) m1) a1 where a1.SRFROWINDEX >= %2$s and a1.SRFROWINDEX < %3$s ", (Object)strSql, (Object)nStartRow, (Object)nEndRow);
    }

    protected String GetQuerySql(Properties pro) {
        String strQueryModelId = this.OnGetQueryModel(pro);
        StringBuilderEx sbEx = new StringBuilderEx();
        BaseDAQueryModelHelper queryModelHelper = null;
        if (!StringHelper.IsNullOrEmpty((String)strQueryModelId)) {
            queryModelHelper = this.getWebContext().getGlobalHelper().getDAModelStorage().FindDAQueryModelHelper(strQueryModelId);
        }
        sbEx.Append(this.OnGetMainSql(queryModelHelper));
        Vector<String> userConditions = new Vector<String>();
        this.OnFillUserConditions(userConditions, queryModelHelper, pro);
        if (userConditions.size() != 0) {
            sbEx.Append(" WHERE ");
            boolean bFirst = true;
            for (String strCondition : userConditions) {
                if (bFirst) {
                    bFirst = false;
                } else {
                    sbEx.Append(" AND ");
                }
                sbEx.Append("(%1$s)", (Object)strCondition);
            }
        }
        String strSql = sbEx.toString();
        return strSql;
    }

    protected String OnGetMainSql(BaseDAQueryModelHelper queryModelHelper) {
        if (queryModelHelper == null) {
            return StringHelper.Format((String)"select * from %1$s ", (Object)this.iDEHelper.getDataEntity().getVIEWNAME());
        }
        return queryModelHelper.GetQueryModelScript();
    }

    protected void OnFillUserConditions(Vector<String> userConditions, BaseDAQueryModelHelper queryModelHelper, Properties pro) {
        String strExtCondition;
        String strKeyword;
        String strInfoType;
        if (queryModelHelper != null) {
            queryModelHelper.FillMajorConditions(userConditions);
        }
        if (!StringHelper.IsNullOrEmpty((String)(strInfoType = this.OnGetInfoFolderField(pro))) && this.wsWPInfoList != null) {
            userConditions.add(StringHelper.Format((String)"%1$s = '%2$s'", (Object)strInfoType, (Object)this.wsWPInfoList.getINFOFOLDER()));
        }
        if (!StringHelper.IsNullOrEmpty((String)(strKeyword = this.getWebContext().GetPostValue("word")))) {
            userConditions.add(StringHelper.Format((String)"and %1$s like '%%%2$s%%'", (Object)this.iDEHelper.GetMajorDEFHelper().getDEField().getDEFNAME(), (Object)strKeyword));
        }
        if (!StringHelper.IsNullOrEmpty((String)(strExtCondition = this.OnGetExtCondition(pro)))) {
            userConditions.add(strExtCondition);
        }
    }

    protected String OnGetDetailPageId(Properties pro) {
        return this.wsWPInfoList.getWSPAGEID();
    }

    protected String OnGetMorePageId(Properties pro) {
        return this.wsWPInfoList.getWSMOREPAGEID();
    }

    protected String OnGetInfoFolderField(Properties pro) {
        return pro.getProperty("INFOFOLDER");
    }

    protected String OnGetQueryModel(Properties pro) {
        return pro.getProperty("QMID");
    }

    protected String OnGetExtCondition(Properties pro) {
        return pro.getProperty("EXCONDITIION");
    }

    protected String OnGetOrderSql(Properties pro) throws Exception {
        return pro.getProperty("ORDERSQL");
    }

    protected String OnGetDEId(Properties pro) throws Exception {
        return pro.getProperty("DEID");
    }
}

