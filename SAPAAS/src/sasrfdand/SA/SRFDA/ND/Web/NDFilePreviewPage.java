/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Web.Default.BaseMainPage
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.SRFExControl
 *  SA.SRFramework.WebEx.SRFExIFrame
 */
package SA.SRFDA.ND.Web;

import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.ND.Data.NDFile;
import SA.SRFDA.ND.Data.NDFileHis;
import SA.SRFDA.Web.Default.BaseMainPage;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.SRFExIFrame;
import java.util.HashMap;

public class NDFilePreviewPage
extends BaseMainPage {
    protected NDFile ndFile = new NDFile();
    protected NDFileHis ndFileHis = null;
    protected SRFExIFrame iFrame = null;
    String strPreviewPath = "";
    protected static HashMap<String, String> supportPreviewFileMap = new HashMap();

    static {
        supportPreviewFileMap.put("pdf", "../srfnd/ndpreview.pdf");
        supportPreviewFileMap.put("txt", "../srfnd/ndpreview.txt");
        supportPreviewFileMap.put("png", "../srfnd/ndpreview.png");
        supportPreviewFileMap.put("gif", "../srfnd/ndpreview.gif");
        supportPreviewFileMap.put("jpg", "../srfnd/ndpreview.jpg");
        supportPreviewFileMap.put("jpeg", "../srfnd/ndpreview.jpeg");
    }

    protected boolean PreparePageEnv() {
        String strFileExt;
        String strFileId;
        block11: {
            block12: {
                CallResult callResult;
                block10: {
                    if (!super.PreparePageEnv()) {
                        return false;
                    }
                    try {
                        strFileId = this.webContext.GetParamValue("NDFILEID");
                        this.ndFile.setNDFILEID(strFileId);
                        IDEDataCtrl ndFileDataCtrl = this.GetDEDataCtrl("ND0013");
                        callResult = ndFileDataCtrl.Get((BaseDataEntity)this.ndFile);
                        if (!callResult.IsError()) break block10;
                        this.PageLog((Object)this, 1, StringHelper.Format((String)"\u83b7\u53d6[%1$s]\u7f51\u76d8\u6587\u4ef6\u5bf9\u8c61\u53d1\u751f\u9519\u8bef,%2$s", (Object)strFileId, (Object)callResult.getErrorInfo()));
                        return false;
                    }
                    catch (Exception ex) {
                        this.PageLog((Object)this, 1, StringHelper.Format((String)"\u51c6\u5907\u9875\u9762\u73af\u5883\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()));
                        return false;
                    }
                }
                String strFileHisId = this.webContext.GetParamValue("NDFILEHISID");
                if (StringHelper.IsNullOrEmpty((String)strFileHisId)) break block11;
                this.ndFileHis = new NDFileHis();
                this.ndFileHis.setNDFILEHISID(strFileHisId);
                IDEDataCtrl ndFileHisDataCtrl = this.GetDEDataCtrl("ND0020");
                callResult = ndFileHisDataCtrl.Get((BaseDataEntity)this.ndFileHis);
                if (!callResult.IsError()) break block12;
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u83b7\u53d6[%1$s]\u7f51\u76d8\u6587\u4ef6\u5386\u53f2\u5bf9\u8c61\u53d1\u751f\u9519\u8bef,%2$s", (Object)strFileHisId, (Object)callResult.getErrorInfo()));
                return false;
            }
            if (StringHelper.Compare((String)this.ndFile.getNDFILEID(), (String)this.ndFileHis.getNDFILEID(), (boolean)false) == 0) break block11;
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u7f51\u76d8\u6587\u4ef6\u5386\u53f2\u53ca\u6587\u4ef6\u5bf9\u8c61\u4e0d\u4e00\u81f4"));
            return false;
        }
        String[] parts = this.ndFile.getNDFILENAME().split("[.]");
        if (parts.length >= 2 && supportPreviewFileMap.containsKey(strFileExt = parts[parts.length - 1])) {
            this.strPreviewPath = StringHelper.Format((String)"%1$s?NDFILEID=%2$s", (Object)supportPreviewFileMap.get(strFileExt), (Object)strFileId);
            if (this.ndFileHis != null) {
                this.strPreviewPath = String.valueOf(this.strPreviewPath) + StringHelper.Format((String)"&NDFILEHISID=%1$s", (Object)this.ndFileHis.getNDFILEHISID());
            }
        }
        if (StringHelper.IsNullOrEmpty((String)this.strPreviewPath)) {
            String strUrl = StringHelper.Format((String)"../srfnd/ndexportfile.jsp?NDFILEID=%1$s", (Object)strFileId);
            if (this.ndFileHis != null) {
                strUrl = String.valueOf(strUrl) + StringHelper.Format((String)"&NDFILEHISID=%1$s", (Object)this.ndFileHis.getNDFILEHISID());
            }
            try {
                this.getResponse().sendRedirect(strUrl);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
            return false;
        }
        return true;
    }

    public String GetDownloadUrl() {
        String strDownloadUrl = StringHelper.Format((String)"../srfnd/ndexportfile.jsp?NDFILEID=%1$s", (Object)this.ndFile.getNDFILEID());
        if (this.ndFileHis != null) {
            strDownloadUrl = String.valueOf(strDownloadUrl) + StringHelper.Format((String)"&NDFILEHISID=%1$s", (Object)this.ndFileHis.getNDFILEHISID());
        }
        return strDownloadUrl;
    }

    protected String OnGetPageCaption() {
        return this.ndFile.getNDFILENAME();
    }

    protected String OnGetPageTitle() {
        return this.ndFile.getNDFILENAME();
    }

    protected void OnInitComponents() {
        super.OnInitComponents();
        this.LoadIFrame();
    }

    protected void OnInitBackEnd() {
        super.OnInitBackEnd();
    }

    protected void OnInit() {
        super.OnInit();
    }

    public int GetCaptionWidth() {
        return this.OnGetCaptionWidth();
    }

    protected int OnGetCaptionWidth() {
        return this.getPageParam("PAGE.CAPTIONWIDTH", 60);
    }

    protected void LoadIFrame() {
        if (this.iFrame != null) {
            return;
        }
        this.iFrame = new SRFExIFrame();
        this.iFrame.InitConfig();
        this.iFrame.setID("iframe");
        this.iFrame.getIFrameConfig().setWidth(0);
        this.iFrame.getIFrameConfig().setHeight(0);
        this.iFrame.getIFrameConfig().setScroll("auto");
        this.iFrame.getIFrameConfig().setURL(this.strPreviewPath);
        this.AddControl((SRFExControl)this.iFrame);
    }
}

