/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.PrintForm
 *  SA.SRFDA.Web.SRFDAPageEx
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.SRFExControl
 *  SA.SRFramework.WebEx.SRFExIFrame
 *  SA.SRFramework.WebEx.Utility.URLHelper
 */
package SA.SRFDA.Report.Web;

import SA.SRFDA.Ctrl.Data.PrintForm;
import SA.SRFDA.Web.SRFDAPageEx;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.SRFExIFrame;
import SA.SRFramework.WebEx.Utility.URLHelper;
import java.util.Vector;

public class PrintFormPage
extends SRFDAPageEx {
    protected SRFExIFrame iFrame = null;
    protected boolean bSelectPrintForm = false;
    protected String strPrintFormName = "";

    protected boolean PreparePageEnv() {
        if (!super.PreparePageEnv()) {
            return false;
        }
        this.strPageDataEntityId = this.getWebContext().getSRFDEID();
        this.strPrintFormName = this.OnProcessMutiFormMode();
        if (StringHelper.IsNullOrEmpty((String)this.strPrintFormName)) {
            Vector list = new Vector();
            CallResult callResult = this.getDAModelHelper().GetDEPrintForms(this.strPageDataEntityId, list);
            if (callResult.getRetCode() != 0) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53\u6253\u5370\u8868\u5355\u96c6\u5408\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
                return false;
            }
            boolean bl = this.bSelectPrintForm = list.size() > 1;
            if (list.size() >= 1) {
                this.strPrintFormName = ((PrintForm)list.get(0)).getWFFORMNAME();
            }
        }
        return true;
    }

    protected String OnProcessMutiFormMode() {
        if (StringHelper.Compare((String)this.getDEHelper().GetProperty("MULTIPRINTFORM"), (String)"TRUE", (boolean)true) == 0) {
            String strMultiFormField = this.getDEHelper().GetProperty("MULTIFORMFIELD");
            if (StringHelper.IsNullOrEmpty((String)strMultiFormField)) {
                this.getPage().PageLog((Object)this.page, 1, StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u6ca1\u6709\u6307\u5b9a\u591a\u8868\u5355\u5c5e\u6027", (Object)this.getDEHelper().getId()));
                return "";
            }
            String strKeyValue = this.getPage().getWebContext().GetParamValue(this.getDEHelper().GetKeyDEFHelper().getName());
            String strTestValue = "";
            if (!StringHelper.IsNullOrEmpty((String)strKeyValue)) {
                BaseDataEntity dataEntity = new BaseDataEntity();
                dataEntity.SetParamValue(this.getDEHelper().GetKeyDEFHelper().getName(), (Object)strKeyValue);
                CallResult callResult = this.GetDEDataCtrl().Get(dataEntity);
                if (callResult.IsOk()) {
                    strTestValue = dataEntity.GetParamStringValue(strMultiFormField, "");
                }
            }
            if (StringHelper.IsNullOrEmpty((String)strTestValue)) {
                strTestValue = this.getPage().getWebContext().GetParamValue(strMultiFormField);
            }
            if (!StringHelper.IsNullOrEmpty((String)strTestValue)) {
                String strFormIdFormat = this.getDEHelper().GetProperty("MULTIPRINTFORMFORMAT", "FORM_%1$s_%2$s");
                return StringHelper.Format((String)strFormIdFormat, (Object)this.getDEHelper().getId(), (Object)strTestValue);
            }
        }
        return "";
    }

    public boolean isSelectPrintForm() {
        return this.bSelectPrintForm;
    }

    protected void OnInitComponents() {
        super.OnInitComponents();
        this.LoadIFrame();
    }

    protected void LoadIFrame() {
        if (this.iFrame != null) {
            return;
        }
        this.iFrame = new SRFExIFrame();
        this.iFrame.InitConfig();
        this.iFrame.setID("iframe");
        this.iFrame.getIFrameConfig().setWidth(1);
        this.iFrame.getIFrameConfig().setHeight(1);
        this.iFrame.getIFrameConfig().setScroll("no");
        this.iFrame.getIFrameConfig().SetExtAttribute("onload", "javascript:onreportframeloaded();");
        this.AddControl((SRFExControl)this.iFrame);
    }

    public String GetPrintFormURL() {
        String strURL = "../srfreport/printform.pdf?" + this.getWebContext().GetQueryString();
        strURL = URLHelper.AppendURLSeperator((String)strURL);
        return strURL;
    }

    public String GetDefaultPrintFormName() {
        return this.strPrintFormName;
    }
}

