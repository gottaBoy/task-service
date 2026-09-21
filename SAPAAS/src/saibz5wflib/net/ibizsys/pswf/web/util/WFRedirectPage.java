/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.appmodel.IAppDEViewModel
 *  net.ibizsys.paas.appmodel.IAppViewModel
 *  net.ibizsys.paas.core.IDERIndex
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.demodel.IDEWFModel
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.util.WebUtility
 *  net.ibizsys.paas.web.AjaxActionResult
 *  net.ibizsys.paas.web.Page
 *  net.sf.json.JSONObject
 */
package net.ibizsys.pswf.web.util;

import net.ibizsys.paas.appmodel.IAppDEViewModel;
import net.ibizsys.paas.appmodel.IAppViewModel;
import net.ibizsys.paas.core.IDERIndex;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDEWFModel;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.util.WebUtility;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.Page;
import net.sf.json.JSONObject;

public class WFRedirectPage
extends Page {
    protected void onInit() throws Exception {
        super.onInit();
        String strDEId = this.getDEId();
        String strKeyValue = this.getKeyValue();
        IAppViewModel iAppViewModel = this.getRDAppViewModel(strDEId, strKeyValue);
        this.sendBackAppViewModel(iAppViewModel);
    }

    protected String getDEId() throws Exception {
        String strDEId = this.getWebContext().getPostOrParamValue("srfdeid");
        if (StringHelper.isNullOrEmpty((String)strDEId)) {
            throw new Exception(StringHelper.format((String)"\u6ca1\u6709\u6307\u5b9a\u89c6\u56fe\u5b9e\u4f53\u6807\u8bc6"));
        }
        return strDEId;
    }

    protected String getKeyValue() throws Exception {
        String strKeyValue = this.getWebContext().getPostOrParamValue("srfkey");
        if (StringHelper.isNullOrEmpty((String)strKeyValue)) {
            strKeyValue = this.getWebContext().getPostOrParamValue("srfkeys");
        }
        if (StringHelper.isNullOrEmpty((String)strKeyValue)) {
            throw new Exception(StringHelper.format((String)"\u6ca1\u6709\u6307\u5b9a\u89c6\u56fe\u6570\u636e\u4e3b\u952e"));
        }
        return strKeyValue;
    }

    protected void sendBackAppViewModel(IAppViewModel iAppViewModel) throws Exception {
        JSONObject rdview = this.getApplicationModel().getAppPFHelper().getAppViewJSONObject(iAppViewModel);
        if (StringHelper.compare((String)this.getRequest().getMethod(), (String)"POST", (boolean)true) == 0) {
            AjaxActionResult ajaxActionResult = new AjaxActionResult();
            ajaxActionResult.setExtAttr("rdview", (Object)rdview);
            this.getWriter().write(ajaxActionResult.toJSONString());
            return;
        }
        String strViewUrl = rdview.optString("viewurl");
        if (strViewUrl.charAt(0) == '/') {
            strViewUrl = ".." + strViewUrl;
        }
        strViewUrl = WebUtility.appendURLSeperator((String)strViewUrl);
        strViewUrl = String.valueOf(strViewUrl) + this.getWebContext().getQueryString();
        this.getResponse().sendRedirect(strViewUrl);
    }

    public IAppViewModel getRDAppViewModel(String strDEName, String strKeyValue) throws Exception {
        String strPDTViewParam;
        IDEWFModel iDEWF;
        IEntity iEntity;
        IDataEntityModel iDEModel = DEModelGlobal.getDEModel((String)strDEName);
        IDataEntityModel iRealDEModel = this.getRealDEModel(iDEModel, iEntity = this.getActiveEntity(iDEModel, strKeyValue));
        if (iRealDEModel != iDEModel) {
            iEntity = this.getActiveEntity(iRealDEModel, strKeyValue);
        }
        boolean bDataInWF = false;
        boolean bWFMode = false;
        if (this.isEnableWorkflow() && (iDEWF = iRealDEModel.testDataInWF(iEntity)) != null) {
            bDataInWF = true;
            bWFMode = iDEWF.testUserWFSubmit(iEntity, this.getWebContext().getCurUserId(), this.getSessionFactory());
        }
        String strRDMode = strPDTViewParam = iRealDEModel.getSDDEViewPDTParam(iEntity, bDataInWF, bWFMode);
        if (iRealDEModel != this.getDEModel()) {
            strRDMode = String.valueOf(iRealDEModel.getName()) + ":" + strPDTViewParam;
        }
        IAppDEViewModel iAppViewModel = null;
        String strDEViewId = iRealDEModel.getDEViewIdByPDT(strPDTViewParam, false);
        iAppViewModel = this.getApplicationModel().getAppViewByDEViewId(strDEViewId, false);
        return iAppViewModel;
    }

    protected IDataEntityModel getRealDEModel(IDataEntityModel iDEModel, IEntity iEntity) throws Exception {
        IDataEntityModel curDEModel = iDEModel;
        if (StringHelper.isNullOrEmpty((String)curDEModel.getIndexDEType())) {
            return curDEModel;
        }
        Object objKeyValue = iEntity.get(iDEModel.getKeyDEField().getName());
        while (true) {
            String strIndexType;
            if (StringHelper.isNullOrEmpty((String)(strIndexType = DataObject.getStringValue((IDataObject)iEntity, (String)curDEModel.getIndexTypeDEField().getName(), null)))) {
                throw new Exception(StringHelper.format((String)"\u5f53\u524d\u6570\u636e\u672a\u63d0\u4f9b\u7d22\u5f15\u7c7b\u578b\u503c"));
            }
            IDERIndex iDERIndex = curDEModel.getDERIndex(true, strIndexType);
            if (StringHelper.isNullOrEmpty((String)(curDEModel = DEModelGlobal.getDEModel((String)iDERIndex.getMinorDEId())).getIndexDEType())) {
                return curDEModel;
            }
            iEntity = this.getActiveEntity(curDEModel, objKeyValue);
        }
    }

    protected IEntity getActiveEntity(IDataEntityModel iRealDEModel, Object strKeyValue) throws Exception {
        IEntity iEntity = iRealDEModel.createEntity();
        iEntity.set(iRealDEModel.getKeyDEField().getName(), strKeyValue);
        iRealDEModel.getService(this.getSessionFactory()).get(iEntity);
        return iEntity;
    }

    protected boolean isEnableWorkflow() {
        return true;
    }
}

