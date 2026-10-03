/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.Data.Page
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Web.SRFDAPageEx
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Data.CallParamList
 *  SA.SRFramework.Data.DataTypeHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.PropertiesHelper
 *  SA.SRFramework.WebEx.SRFExWebContext
 *  SA.SRFramework.WebEx.Utility.URLHelper
 */
package SA.SRFDA.BI.Web;

import SA.SRFDA.BI.Ctrl.Data.BICubeSrc;
import SA.SRFDA.BI.Ctrl.Data.BICubeSrcMap;
import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.Data.Page;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Web.SRFDAPageEx;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Data.CallParamList;
import SA.SRFramework.Data.DataTypeHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import SA.SRFramework.WebEx.SRFExWebContext;
import SA.SRFramework.WebEx.Utility.URLHelper;
import java.io.IOException;
import java.util.Properties;
import java.util.Vector;

public class BICubeSrcRedirectPage
extends SRFDAPageEx {
    protected boolean PreparePageEnv() {
        if (!super.PreparePageEnv()) {
            return false;
        }
        this.strPageDataEntityId = this.GetDefaultPageDataEntityId();
        if (!this.LoadPageDataEntity()) {
            return false;
        }
        String strKeyValue = this.getWebContext().GetParamValue(this.getDEHelper().GetKeyDEFHelper().getName());
        if (StringHelper.IsNullOrEmpty((String)strKeyValue)) {
            this.OutputAlertMsg("\u6ca1\u6709\u6307\u5b9a\u6c47\u603b\u6570\u636e\u9879", false);
            return false;
        }
        BaseDataEntity groupData = new BaseDataEntity();
        groupData.SetParamValue(this.getDEHelper().GetKeyDEFHelper().getName(), this.getDEHelper().GetKeyDEFHelper().GetDEFValue(strKeyValue));
        IDEDataCtrl deDataCtrl = this.GetDEDataCtrl();
        if (deDataCtrl == null) {
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)this.getDEHelper().getId()));
            return false;
        }
        CallResult callResult = deDataCtrl.Get(groupData);
        if (callResult.IsError()) {
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u67e5\u8be2\u6c47\u603b\u6570\u636e[%1$s]\u5931\u8d25\uff0c%2$s", (Object)strKeyValue, (Object)callResult.getErrorInfo()));
            this.OutputAlertMsg("\u67e5\u8be2\u6c47\u603b\u6570\u636e\u5931\u8d25", false);
            return false;
        }
        String strBICubeSrcId = this.getWebContext().GetParamValue("BICUBESRCID");
        if (StringHelper.IsNullOrEmpty((String)strBICubeSrcId)) {
            this.OutputAlertMsg("\u6ca1\u6709\u6307\u5b9a\u5206\u6790\u7acb\u65b9\u4f53\u6e90\u6570\u636e\u5bf9\u8c61", false);
            return false;
        }
        BICubeSrc biCubeSrc = new BICubeSrc();
        biCubeSrc.setBICUBESRCID(strBICubeSrcId);
        IDEDataCtrl biCubeSrcDataCtrl = this.GetDEDataCtrl("BI0015");
        if (biCubeSrcDataCtrl == null) {
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"BI0015"));
            return false;
        }
        callResult = biCubeSrcDataCtrl.Get((BaseDataEntity)biCubeSrc);
        if (callResult.IsError()) {
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u67e5\u8be2\u5206\u6790\u7acb\u65b9\u4f53\u6e90\u6570\u636e[%1$s]\u5931\u8d25\uff0c%2$s", (Object)strBICubeSrcId, (Object)callResult.getErrorInfo()));
            this.OutputAlertMsg("\u67e5\u8be2\u5206\u6790\u7acb\u65b9\u4f53\u6e90\u6570\u636e\u5931\u8d25", false);
            return false;
        }
        IDEDataCtrl biCubeSrcMapDataCtrl = this.GetDEDataCtrl("BI0016");
        if (biCubeSrcMapDataCtrl == null) {
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"BI0016"));
            return false;
        }
        Vector<BaseDataEntity> biCubeSrcMap = new Vector<BaseDataEntity>();
        BaseDataEntity cond = new BaseDataEntity();
        cond.SetParamValue("BICUBESRCID", (Object)strBICubeSrcId);
        callResult = biCubeSrcMapDataCtrl.Select(cond, biCubeSrcMap);
        if (callResult.IsError()) {
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u67e5\u8be2\u5206\u6790\u7acb\u65b9\u4f53\u6e90\u6570\u636e[%1$s]\u5c5e\u6027\u6620\u5c04\u5931\u8d25\uff0c%2$s", (Object)strBICubeSrcId, (Object)callResult.getErrorInfo()));
            this.OutputAlertMsg("\u67e5\u8be2\u5206\u6790\u7acb\u65b9\u4f53\u6e90\u6570\u636e\u5c5e\u6027\u6620\u5c04\u5931\u8d25", false);
            return false;
        }
        String strQueryParam = "";
        String strMeasure = this.getWebContext().GetParamValue("SRFBIMEASURE");
        if (!StringHelper.IsNullOrEmpty((String)strMeasure) && !StringHelper.IsNullOrEmpty((String)biCubeSrc.getMEASUREMAP())) {
            Properties measureProperties = null;
            try {
                measureProperties = PropertiesHelper.Load((String)biCubeSrc.getMEASUREMAP());
                String strExtCond = PropertiesHelper.GetProperty((Properties)measureProperties, (String)strMeasure);
                if (StringHelper.IsNullOrEmpty((String)strExtCond)) {
                    strMeasure = strMeasure.replace("[Measures].[", "");
                    strMeasure = strMeasure.substring(0, strMeasure.length() - 1);
                    strExtCond = PropertiesHelper.GetProperty((Properties)measureProperties, (String)strMeasure);
                }
                if (!StringHelper.IsNullOrEmpty((String)strExtCond)) {
                    strQueryParam = strExtCond;
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        BICubeSrcMap cubeSrcMap = new BICubeSrcMap();
        for (BaseDataEntity srcMap : biCubeSrcMap) {
            cubeSrcMap.Proxy(srcMap);
            IDEFHelper iDEFHelper = this.getDEHelper().GetDEFHelper(cubeSrcMap.getCUBEDEFID());
            if (iDEFHelper == null) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u5c5e\u6027[%2$s]\u8f85\u52a9\u5bf9\u8c61", (Object)this.getDEHelper().getId(), (Object)cubeSrcMap.getCUBEDEFID()));
                this.OutputAlertMsg("\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53\u5c5e\u6027\u8f85\u52a9\u5bf9\u8c61", false);
                return false;
            }
            String strParamFormat = cubeSrcMap.getQUERYPARAMFMT();
            Properties paramFmtProperties = null;
            try {
                paramFmtProperties = PropertiesHelper.Load((String)strParamFormat);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            String strSql = cubeSrcMap.getDRILLSQL();
            if (StringHelper.IsNullOrEmpty((String)strSql)) {
                String strArg1Format = PropertiesHelper.GetProperty((Properties)paramFmtProperties, (String)"ARG1", (String)"%1$s");
                String strArg1 = StringHelper.Format((String)strArg1Format, (Object)groupData.GetParamValue(iDEFHelper.getName()));
                strArg1 = SRFExWebContext.EncodeURLParamValue((String)strArg1);
                String strCond = StringHelper.Format((String)cubeSrcMap.getQUERYCOND(), (Object)strArg1);
                if (!StringHelper.IsNullOrEmpty((String)strQueryParam)) {
                    strQueryParam = String.valueOf(strQueryParam) + "&";
                }
                strQueryParam = String.valueOf(strQueryParam) + strCond;
                continue;
            }
            CallParamList callParamList = new CallParamList();
            callParamList.Add(groupData.GetParamValue(iDEFHelper.getName()), DataTypeHelper.FromString((String)iDEFHelper.GetDataType()));
            BaseDataEntity ret = new BaseDataEntity();
            callResult = BaseDEDataCtrl.SelectSingleEx((ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper(), (String)this.getDEHelper().GetDBStorage(), (String)strSql, (Vector)callParamList.GetList(), (BaseDataEntity)ret);
            if (callResult.IsError()) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u8fdb\u4e00\u6b65\u67e5\u8be2\u94bb\u53d6\u6761\u4ef6\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                this.OutputAlertMsg("\u8fdb\u4e00\u6b65\u67e5\u8be2\u94bb\u53d6\u6761\u4ef6\u53d1\u751f\u9519\u8bef", false);
                return false;
            }
            int nArgCount = ret.GetParamIntValue("ARGCOUNT", 0);
            if (nArgCount <= 0) continue;
            Object[] params = new String[nArgCount];
            int i = 0;
            while (i < nArgCount) {
                Object objArgX = ret.GetParamValue(StringHelper.Format((String)"ARG%1$s", (Object)(i + 1)));
                String strArgXFormat = PropertiesHelper.GetProperty((Properties)paramFmtProperties, (String)StringHelper.Format((String)"ARG%1$s", (Object)(i + 1)), (String)"%1$s");
                String strArgX = StringHelper.Format((String)strArgXFormat, (Object)objArgX);
                strArgX = SRFExWebContext.EncodeURLParamValue((String)strArgX);
                params[i] = strArgX;
                ++i;
            }
            String strCond = StringHelper.Format((String)cubeSrcMap.getQUERYCOND(), (Object[])params);
            if (!StringHelper.IsNullOrEmpty((String)strQueryParam)) {
                strQueryParam = String.valueOf(strQueryParam) + "&";
            }
            strQueryParam = String.valueOf(strQueryParam) + strCond;
        }
        String strURL = "";
        if (!StringHelper.IsNullOrEmpty((String)biCubeSrc.getPAGEID())) {
            Page page = this.getDAModelStorage().FindPage(biCubeSrc.getPAGEID());
            if (page == null) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u9875\u9762[%1$s]\u5931\u8d25", (Object)biCubeSrc.getPAGEID()));
                this.OutputAlertMsg("\u65e0\u6cd5\u83b7\u53d6\u9875\u9762\u914d\u7f6e", false);
                return false;
            }
            strURL = page.GetTotalPagePath();
        }
        if (StringHelper.IsNullOrEmpty((String)strURL)) {
            strURL = "../srfpage/gridview.jsp?";
        }
        strURL = URLHelper.AppendURLSeperator((String)strURL);
        strURL = String.valueOf(strURL) + strQueryParam;
        strURL = URLHelper.AppendURLSeperator((String)strURL);
        strURL = String.valueOf(strURL) + StringHelper.Format((String)"SRFDEID=%1$s", (Object)biCubeSrc.getDEID());
        try {
            this.getResponse().sendRedirect(strURL);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
}

