/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Ctrl.Data.HelpDoc
 *  SA.SRFDA.Ctrl.Data.HelpDocItem
 *  SA.SRFDA.Ctrl.Data.Page
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Web.Default;

import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.Data.HelpDoc;
import SA.SRFDA.Ctrl.Data.HelpDocItem;
import SA.SRFDA.Ctrl.Data.Page;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;

public class HelpDocPage
extends SRFDAPage {
    protected String strDocPath = "";
    protected String strDocPath2 = "";
    protected String strDocName = "";

    public HelpDocPage() {
        this.setMainPage(true);
        this.setOutputDebug(false);
    }

    protected void OnInit() {
        super.OnInit();
        HelpDocItem docHelpItem = this.GetHelpDocItem();
        HelpDoc helpDoc = new HelpDoc();
        if (docHelpItem == null) {
            String strSQL = StringHelper.Format((String)"SELECT * FROM T_SRFHELPDOC WHERE ISDEFAULT=1");
            CallResult callResult = BaseDEDataCtrl.SelectSingle((ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper(), (String)strSQL, (BaseDataEntity)helpDoc);
            if (callResult.IsError()) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u9ed8\u8ba4\u5e2e\u52a9\u6587\u6863\uff0c%1$s", (Object)callResult.getErrorInfo()));
                return;
            }
        } else {
            helpDoc.setHELPDOCID(docHelpItem.getHELPDOCID());
            IDEDataCtrl iDEDataCtrl = this.getDAModelStorage().FindDEDataCtrl("DE0150", (ISRFDAWebContext)this.getWebContext());
            if (iDEDataCtrl == null) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"DE0150"));
                return;
            }
            CallResult callResult = iDEDataCtrl.Get((BaseDataEntity)helpDoc);
            if (callResult.IsError()) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5e2e\u52a9\u6587\u6863[%1$s],%2$s", (Object)docHelpItem.getHELPDOCID(), (Object)callResult.getErrorInfo()));
                return;
            }
        }
        this.strDocPath = helpDoc.getMAINPATH();
        this.strDocPath2 = helpDoc.getCONTENTPATH();
        this.strDocName = helpDoc.getHELPDOCNAME();
        String strLink = this.getWebContext().GetParamValue("LINK");
        if (!StringHelper.IsNullOrEmpty((String)strLink)) {
            this.strDocPath2 = String.valueOf(this.strDocPath2) + "#" + strLink;
        } else if (docHelpItem != null) {
            this.strDocPath2 = String.valueOf(this.strDocPath2) + docHelpItem.getLINK();
        }
    }

    protected HelpDocItem GetHelpDocItem() {
        String strDEId = this.getWebContext().GetParamValue("DEID");
        String strPageId = this.getWebContext().GetParamValue("PAGEID");
        String strPAGESTYLE = this.getWebContext().GetParamValue("PAGETYPE");
        String strHelpItemId = this.getWebContext().GetParamValue("HELPITEMID");
        HelpDocItem docHelpItem = new HelpDocItem();
        CallResult callResult = null;
        if (!StringHelper.IsNullOrEmpty((String)strHelpItemId)) {
            IDEDataCtrl iDEDataCtrl = this.getDAModelStorage().FindDEDataCtrl("DE0151", (ISRFDAWebContext)this.getWebContext());
            if (iDEDataCtrl == null) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"DE0151"));
                return null;
            }
            docHelpItem.setHELPDOCITEMID(strHelpItemId);
            callResult = iDEDataCtrl.Get((BaseDataEntity)docHelpItem);
            if (callResult.IsError()) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5e2e\u52a9\u6587\u6863\u9879[%1$s],%2$s", (Object)strHelpItemId, (Object)callResult.getErrorInfo()));
                return null;
            }
            return docHelpItem;
        }
        if (!StringHelper.IsNullOrEmpty((String)strPageId)) {
            String strSQL;
            if (!StringHelper.IsNullOrEmpty((String)strDEId)) {
                strSQL = StringHelper.Format((String)"SELECT * FROM T_SRFHELPDOCITEM WHERE UPPER(DEID) ='%1$s' AND UPPER(PAGEID) = '%2$s'", (Object)strDEId.toUpperCase(), (Object)strPageId.toUpperCase());
                callResult = BaseDEDataCtrl.SelectSingle((ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper(), (String)strSQL, (BaseDataEntity)docHelpItem);
                if (callResult.IsOk()) {
                    return docHelpItem;
                }
            }
            strSQL = StringHelper.Format((String)"SELECT * FROM T_SRFHELPDOCITEM WHERE DEID IS NULL AND UPPER(PAGEID) = '%1$s'", (Object)strPageId.toUpperCase());
            callResult = BaseDEDataCtrl.SelectSingle((ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper(), (String)strSQL, (BaseDataEntity)docHelpItem);
            if (callResult.IsOk()) {
                return docHelpItem;
            }
        }
        if (!StringHelper.IsNullOrEmpty((String)strDEId)) {
            if (!StringHelper.IsNullOrEmpty((String)strPAGESTYLE)) {
                int nPAGESTYLE = Page.ParsePageType((String)strPAGESTYLE);
                String strSQL = StringHelper.Format((String)"SELECT * FROM T_SRFHELPDOCITEM WHERE UPPER(DEID) ='%1$s' AND PAGESTYLE = %2$s", (Object)strDEId.toUpperCase(), (Object)nPAGESTYLE);
                callResult = BaseDEDataCtrl.SelectSingle((ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper(), (String)strSQL, (BaseDataEntity)docHelpItem);
                if (callResult.IsOk()) {
                    return docHelpItem;
                }
            }
            String strSQL = StringHelper.Format((String)"SELECT * FROM T_SRFHELPDOCITEM WHERE UPPER(DEID) ='%1$s' AND PAGESTYLE IS NULL", (Object)strDEId.toUpperCase());
            callResult = BaseDEDataCtrl.SelectSingle((ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper(), (String)strSQL, (BaseDataEntity)docHelpItem);
            if (callResult.IsOk()) {
                return docHelpItem;
            }
        }
        return null;
    }

    public String GetHelpDocPath() {
        return this.strDocPath;
    }

    public String GetHelpDocPath2() {
        return this.strDocPath2;
    }

    public String GetHelpDocName() {
        return this.strDocName;
    }
}

