/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.DERINDEX
 *  SA.SRFDA.Ctrl.Data.Page
 *  SA.SRFDA.Ctrl.Data.PageParam
 *  SA.SRFDA.Ctrl.Data.PageParamType
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Ctrl.Utility.MacroHelper
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.Utility.URLHelper
 */
package SA.SRFDA.Web.DS;

import SA.SRFDA.Ctrl.Data.DERINDEX;
import SA.SRFDA.Ctrl.Data.Page;
import SA.SRFDA.Ctrl.Data.PageParam;
import SA.SRFDA.Ctrl.Data.PageParamType;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Ctrl.Utility.MacroHelper;
import SA.SRFDA.Web.Default.BaseMainPage;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.Utility.URLHelper;
import java.io.IOException;
import java.util.Properties;

public class PageParamRedirectViewPage
extends BaseMainPage {
    @Override
    protected boolean PreparePageEnv() {
        if (!super.PreparePageEnv()) {
            return false;
        }
        this.strPageDataEntityId = this.getWebContext().getSRFDEID();
        if (!this.LoadPageDataEntity()) {
            return false;
        }
        if (!this.IsBackEndMode()) {
            CallResult callResult = null;
            IDEHelper minorDEHelper = null;
            String strPageParamId = this.getWebContext().GetParamValue("PAGEPARAMID");
            if (StringHelper.IsNullOrEmpty((String)strPageParamId)) {
                String strPageId = this.getWebContext().GetParamValue("PAGEID");
                if (StringHelper.IsNullOrEmpty((String)strPageId)) {
                    this.PageLog(this, 1, StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u9875\u9762\u7f16\u53f7"));
                    return false;
                }
                String strPageParamTypeId = this.getWebContext().GetParamValue("PAGEPARAMTYPEID");
                if (StringHelper.IsNullOrEmpty((String)strPageParamTypeId)) {
                    this.PageLog(this, 1, StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u9875\u9762\u53c2\u6570\u7c7b\u578b"));
                    return false;
                }
                PageParamType pageParamType = this.getDAModelStorage().FindPageParamType(strPageParamTypeId);
                if (pageParamType == null) {
                    this.PageLog(this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u9875\u9762\u53c2\u6570\u7c7b\u578b[%1$s]", (Object)strPageParamTypeId));
                    return false;
                }
                String strParamType = pageParamType.getPARAMTYPE();
                DERINDEX derIndex = this.getDEHelper().FindDERINDEX(strParamType);
                if (derIndex == null) {
                    this.PageLog(this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u7d22\u5f15\u5b9e\u4f53[%1$s]\u5bf9\u5e94\u7684\u7d22\u5f15\u7c7b\u578b[%2$s]", (Object)this.getDEHelper().getId(), (Object)strParamType));
                    return false;
                }
                minorDEHelper = this.getDAModelStorage().FindDEHelper(derIndex.getDEID());
                if (minorDEHelper == null) {
                    this.PageLog(this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)derIndex.getDEID()));
                    return false;
                }
                PageParam pageParam = new PageParam();
                callResult = MacroHelper.FillDataEntity((IDEHelper)minorDEHelper, (Properties)pageParamType.getInitParam(), (BaseDataEntity)pageParam, (ISRFDAWebContext)this.getWebContext(), (ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper(), (String)this.getWebContext().getCurUserId(), null);
                if (callResult.IsError()) {
                    this.PageLog(this, 1, StringHelper.Format((String)"\u586b\u5145\u9875\u9762\u53c2\u6570\u521d\u59cb\u5316\u503c\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    return false;
                }
                pageParam.setPAGETYPE(strParamType);
                pageParam.setPAGEPARAMTYPEID(strPageParamTypeId);
                pageParam.setPAGEID(strPageId);
                IDEDataCtrl pageParamDataCtrl = this.GetDEDataCtrl(minorDEHelper.getId());
                strPageParamId = String.valueOf(strPageId) + "_" + pageParamType.getCTRLID() + "_" + pageParamType.getPARAMTYPE();
                pageParam.SetParamValue(minorDEHelper.GetKeyDEFHelper().getName(), (Object)strPageParamId);
                callResult = pageParamDataCtrl.Save(true, (BaseDataEntity)pageParam);
                if (callResult.IsError() && callResult.getRetCode() != 7 && callResult.getRetCode() != 1007) {
                    this.PageLog(this, 1, StringHelper.Format((String)"\u4fdd\u5b58\u9875\u9762\u53c2\u6570\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    return false;
                }
                strPageParamId = pageParam.GetParamStringValue(minorDEHelper.GetKeyDEFHelper().getName(), "");
            } else {
                PageParam pageParam = new PageParam();
                pageParam.setPAGEPARAMID(strPageParamId);
                callResult = this.GetDEDataCtrl().Get((BaseDataEntity)pageParam);
                if (callResult.IsError()) {
                    this.PageLog(this, 1, StringHelper.Format((String)"\u4fdd\u5b58\u9875\u9762\u53c2\u6570[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPageParamId, (Object)callResult.getErrorInfo()));
                    return false;
                }
                String strParamType = pageParam.getPAGETYPE();
                DERINDEX derIndex = this.getDEHelper().FindDERINDEX(strParamType);
                if (derIndex == null) {
                    this.PageLog(this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u7d22\u5f15\u5b9e\u4f53[%1$s]\u5bf9\u5e94\u7684\u7d22\u5f15\u7c7b\u578b[%2$s]", (Object)this.getDEHelper().getId(), (Object)strParamType));
                    return false;
                }
                minorDEHelper = this.getDAModelStorage().FindDEHelper(derIndex.getDEID());
                if (minorDEHelper == null) {
                    this.PageLog(this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)derIndex.getDEID()));
                    return false;
                }
            }
            String strEditPage = "../srfpage/editview2.jsp";
            String strEditPageId = minorDEHelper.GetEditPageId();
            if (!StringHelper.IsNullOrEmpty((String)strEditPageId)) {
                Page editPage = this.getDAModelStorage().FindPage(strEditPageId);
                if (editPage == null) {
                    this.PageLog(this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u9875\u9762[%1$s]", (Object)strEditPageId));
                    return false;
                }
                strEditPage = editPage.GetTotalPagePath();
            }
            strEditPage = URLHelper.AppendURLSeperator((String)strEditPage);
            strEditPage = String.valueOf(strEditPage) + StringHelper.Format((String)"SRFDEID=%1$s&%2$s=%3$s", (Object)minorDEHelper.getId(), (Object)minorDEHelper.GetKeyDEFHelper().getName(), (Object)strPageParamId);
            try {
                if (StringHelper.IsNullOrEmpty((String)this.getPageModel())) {
                    this.getResponse().sendRedirect(strEditPage);
                } else {
                    this.getResponse().getWriter().write(PageParamRedirectViewPage.OutputRedirectModel(strEditPage));
                }
                return false;
            }
            catch (IOException e) {
                return false;
            }
        }
        return true;
    }
}

