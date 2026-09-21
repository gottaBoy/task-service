/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.CallParamList
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.XML.XMLNode
 */
package SA.SRFDA.Ctrl.DEDataCtrl;

import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.DEDataCtrl.IPageDataCtrl;
import SA.SRFDA.Ctrl.Data.DERINDEX;
import SA.SRFDA.Ctrl.Data.Page;
import SA.SRFDA.Ctrl.Data.PageParamType;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Ctrl.Utility.MacroHelper;
import SA.SRFramework.Data.CallParamList;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.XML.XMLNode;
import java.util.Vector;

public class PageDataCtrl
extends BaseDEDataCtrl
implements IPageDataCtrl {
    @Override
    public CallResult ListPageParams(String strPageId, Vector<BaseDataEntity> pageParams) {
        String strSQL = " select * from V_SRFPAGEPARAM where PAGEID = ?";
        CallParamList callParamList = new CallParamList();
        callParamList.Add((Object)strPageId);
        Vector list = new Vector();
        CallResult callResult = BaseDEDataCtrl.SelectMultiEx(this.getGlobalHelper(), this.GetDEHelper().GetDBStorage(), strSQL, callParamList.GetList(), list, "");
        if (callResult.IsError()) {
            return callResult;
        }
        if (list.size() == 0) {
            return callResult;
        }
        IDEHelper pageParamDEHelper = this.globalHelperEx.getDAModelStorage().FindDEHelper("DE0066");
        for (BaseDataEntity dataEntity : list) {
            String strParamType = dataEntity.GetParamStringValue("PAGETYPE", "");
            DERINDEX derIndex = pageParamDEHelper.FindDERINDEX(strParamType);
            if (derIndex == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u7d22\u5f15\u5b9e\u4f53[%1$s]\u5bf9\u5e94\u7684\u7d22\u5f15\u7c7b\u578b[%2$s]", (Object)pageParamDEHelper.getId(), (Object)strParamType));
                return callResult;
            }
            IDEHelper minorDEHelper = this.globalHelperEx.getDAModelStorage().FindDEHelper(derIndex.getDEID());
            if (minorDEHelper == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)derIndex.getDEID()));
                return callResult;
            }
            BaseDataEntity realDataEntity = minorDEHelper.CreateDEObject();
            String strPageParamId = dataEntity.GetParamStringValue("PAGEPARAMID", "");
            if (StringHelper.IsNullOrEmpty((String)strPageParamId)) {
                String strPageParamTypeId = dataEntity.GetParamStringValue("PAGEPARAMTYPEID", "");
                PageParamType pageParamType = this.globalHelperEx.getDAModelStorage().FindPageParamType(strPageParamTypeId);
                if (pageParamType == null) {
                    callResult.setRetCode(1);
                    callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u9875\u9762\u53c2\u6570\u7c7b\u578b[%1$s]", (Object)strPageParamTypeId));
                    return callResult;
                }
                callResult = MacroHelper.FillDataEntity(minorDEHelper, pageParamType.getInitParam(), realDataEntity, this.getWebContext(), this.getGlobalHelper(), this.getOPPersonId(), null);
                if (callResult.IsError()) {
                    callResult.setRetCode(1);
                    callResult.setErrorInfo(StringHelper.Format((String)"\u586b\u5145\u9875\u9762\u53c2\u6570\u521d\u59cb\u5316\u503c\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    return callResult;
                }
                realDataEntity.SetParamValue("PAGETYPE", (Object)strParamType);
                realDataEntity.SetParamValue("PAGEPARAMTYPEID", (Object)strPageParamTypeId);
                realDataEntity.SetParamValue("PAGEID", (Object)strPageId);
                realDataEntity.SetParamValue("CTRLID", (Object)dataEntity.GetParamStringValue("CTRLID", ""));
            } else {
                realDataEntity.SetParamValue(minorDEHelper.GetKeyDEFHelper().getName(), (Object)strPageParamId);
                IDEDataCtrl dataCtrl = minorDEHelper.GetDEDataCtrl(this.getOPPersonId(), this.getWebContext());
                if (dataCtrl == null) {
                    callResult.setRetCode(1);
                    callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)minorDEHelper.getId()));
                    return callResult;
                }
                callResult = dataCtrl.Get(realDataEntity);
                if (callResult.IsError()) {
                    callResult.setRetCode(1);
                    callResult.setErrorInfo(StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e[%2$s]\u53d1\u751f\u9519\u8bef\uff0c%3$s", (Object)minorDEHelper.getId(), (Object)strPageParamId, (Object)callResult.getErrorInfo()));
                    return callResult;
                }
                callResult = dataCtrl.FillDetails(realDataEntity);
                if (callResult.IsError()) {
                    callResult.setRetCode(1);
                    callResult.setErrorInfo(StringHelper.Format((String)"\u586b\u5145\u5b9e\u4f53[%1$s]\u6570\u636e[%2$s]\u660e\u7ec6\u53d1\u751f\u9519\u8bef\uff0c%3$s", (Object)minorDEHelper.getId(), (Object)strPageParamId, (Object)callResult.getErrorInfo()));
                    return callResult;
                }
            }
            pageParams.add(realDataEntity);
        }
        return callResult;
    }

    @Override
    protected CallResult OnExport(BaseDataEntity baseDataEntity, Vector<XMLNode> list, boolean bFrameOnly) {
        String strValue;
        CallResult callResult = new CallResult();
        Page page = new Page();
        page.Proxy(baseDataEntity);
        if (!StringHelper.IsNullOrEmpty((String)page.getDEID())) {
            String strDEId = page.getDEID();
            page.RemoveParam("DEID");
            String strValue2 = BaseDataEntity.ToString((BaseDataEntity)baseDataEntity);
            if (StringHelper.IsNullOrEmpty((String)strValue2)) {
                return callResult;
            }
            XMLNode xmlNode = new XMLNode();
            xmlNode.SetValue("SRFDEID", this.iDEHelper.getId());
            xmlNode.SetValue("SRFVALUE", strValue2);
            list.add(xmlNode);
            page.setDEID(strDEId);
        }
        if (StringHelper.IsNullOrEmpty((String)(strValue = BaseDataEntity.ToString((BaseDataEntity)baseDataEntity)))) {
            return callResult;
        }
        XMLNode xmlNode = new XMLNode();
        xmlNode.SetValue("SRFDEID", this.iDEHelper.getId());
        xmlNode.SetValue("SRFVALUE", strValue);
        list.add(xmlNode);
        if (this.globalHelperEx.getDAModelVersion() >= 10121500) {
            IDEDataCtrl pageParamDataCtrl = this.globalHelperEx.getDAModelStorage().FindDEDataCtrlEx("DE0066", this);
            if (pageParamDataCtrl == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"DE0066"));
                return callResult;
            }
            BaseDataEntity cond = new BaseDataEntity();
            cond.SetParamValue("PAGEID", (Object)page.getPAGEID());
            Vector<BaseDataEntity> dataEntities = new Vector<BaseDataEntity>();
            callResult = pageParamDataCtrl.Select(cond, dataEntities);
            if (callResult.IsError()) {
                return callResult;
            }
            for (BaseDataEntity pageParam : dataEntities) {
                pageParamDataCtrl.Export(pageParam, list, false, bFrameOnly);
            }
        }
        return callResult;
    }
}

