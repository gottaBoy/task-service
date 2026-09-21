/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.WS.Web;

import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.WS.Ctrl.IWSWBTypeHelper;
import SA.SRFDA.WS.Web.BaseWSMainPage;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Map;

public class WSInfoViewPage
extends BaseWSMainPage {
    IWSWBTypeHelper iWSWBTypeHelper = null;
    String strWSPageWBId = "";

    protected boolean PreparePageEnv() {
        boolean bOK = super.PreparePageEnv();
        this.strPageDataEntityId = this.getWebContext().getSRFDEID();
        this.iDEHelper = this.getWebContext().getGlobalHelper().getDAModelStorage().FindDEHelper(this.strPageDataEntityId);
        if (this.iDEHelper == null) {
            this.PageLog((Object)this, 0, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)this.strPageDataEntityId));
            bOK = false;
        }
        return bOK;
    }

    public String RenderDetail(String strWSWebSiteId, String strPageId, String strWBTypeId, String strWebPartId, String strWSPageWBId) {
        String strInfoDetail = "";
        try {
            this.iWSWBTypeHelper = this.getWSModelStorage().FindWSWBTypeHelper(strWBTypeId);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        if (this.iWSWBTypeHelper == null) {
            strInfoDetail = StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u90e8\u4ef6\u7c7b\u578b[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)strWBTypeId);
            this.PageLog((Object)this, 3, strInfoDetail);
            return strInfoDetail;
        }
        strInfoDetail = this.TemplateProcess(this.iWSWBTypeHelper.getWSWBType().getTEMPLATE());
        return strInfoDetail;
    }

    @Override
    protected void OnFillTemplateContext(Map<String, Object> pageModellMap) {
        BaseDataEntity baseDataEntity = new BaseDataEntity();
        String strKeyDEFName = this.iDEHelper.GetKeyDEFHelper().getDEField().getDEFNAME().toUpperCase();
        String strKeyValue = this.getWebContext().GetParamValue(strKeyDEFName);
        baseDataEntity.SetParamValue(strKeyDEFName, (Object)strKeyValue);
        CallResult callResult = this.iDEHelper.GetDEDataCtrl("", (ISRFDAWebContext)this.getWebContext()).Get(baseDataEntity);
        if (callResult.IsError()) {
            this.PageLog((Object)this, 1, "");
        }
        for (IDEFHelper iDEFHelper : this.iDEHelper.GetDEFHelpers()) {
            String strDEFName = iDEFHelper.getDEField().getDEFNAME().toUpperCase();
            Object objValue = iDEFHelper.GetDEFValue(baseDataEntity.GetParamStringValue(strDEFName, ""));
            pageModellMap.put(strDEFName, objValue);
            if (iDEFHelper.IsKeyDEField()) {
                pageModellMap.put("ID", objValue);
            }
            if (!iDEFHelper.IsMajorDEField()) continue;
            pageModellMap.put("NAME", objValue);
        }
    }
}

