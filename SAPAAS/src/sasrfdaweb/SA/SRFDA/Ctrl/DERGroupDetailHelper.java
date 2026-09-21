/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDAObjectHelper
 *  SA.SRFDA.Ctrl.Data.DER11
 *  SA.SRFDA.Ctrl.Data.DER1N
 *  SA.SRFDA.Ctrl.Data.DERGroupDetail
 *  SA.SRFDA.Ctrl.Data.Page
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Ctrl.IDERGroupDetailHelper
 *  SA.SRFDA.Ctrl.IDERGroupFolderHelper
 *  SA.SRFDA.Ctrl.IDERGroupHelper
 *  SA.SRFDA.Security.UniResHelper
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.Utility.URLHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.BaseDAObjectHelper;
import SA.SRFDA.Ctrl.Data.DER11;
import SA.SRFDA.Ctrl.Data.DER1N;
import SA.SRFDA.Ctrl.Data.DERGroupDetail;
import SA.SRFDA.Ctrl.Data.Page;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Ctrl.IDERGroupDetailHelper;
import SA.SRFDA.Ctrl.IDERGroupFolderHelper;
import SA.SRFDA.Ctrl.IDERGroupHelper;
import SA.SRFDA.Security.UniResHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.Utility.URLHelper;
import java.util.TreeMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DERGroupDetailHelper
extends BaseDAObjectHelper
implements IDERGroupDetailHelper {
    private static final Log log = LogFactory.getLog(DERGroupDetailHelper.class);
    protected IDERGroupHelper iDERGroupHelper = null;
    protected DERGroupDetail derGroupDetail = null;
    protected IDERGroupFolderHelper iDERGroupFolderHelper;
    private String strResourceId = "NONE";
    private String strRealPagePath = "";
    private String strTabViewVisibleCond = "";
    private String strPageId = "";

    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, IDERGroupHelper iDERGroupHelper, DERGroupDetail derGroupDetail) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.iDERGroupHelper = iDERGroupHelper;
        this.derGroupDetail = derGroupDetail;
        this.setId(derGroupDetail.getDERGROUPDETAILID());
        this.setName(derGroupDetail.getDERGROUPDETAILNAME());
        if (!StringHelper.IsNullOrEmpty((String)this.getDERGroupFolderId())) {
            this.iDERGroupFolderHelper = this.getDAGlobalHelper().getDAModelStorage().FindDERGroupFolder(this.getDERGroupFolderId());
        }
        IDEHelper iDEHelper = iDERGroupHelper.getDEHelper();
        String strDefaultPageParam = "";
        String strDefaultGroup = "\u76f8\u5173\u4fe1\u606f";
        String strCurDEId = "";
        String strTabViewBarCond = "";
        if (StringHelper.Compare((String)derGroupDetail.getDETAILTYPE(), (String)"PAGE", (boolean)true) == 0) {
            this.strPageId = derGroupDetail.getPAGEID();
        } else if (StringHelper.Compare((String)derGroupDetail.getDETAILTYPE(), (String)"PAGEPATH", (boolean)true) == 0) {
            this.strRealPagePath = derGroupDetail.getPAGEPATH();
        } else if (StringHelper.Compare((String)derGroupDetail.getDETAILTYPE(), (String)"WFSTEP", (boolean)true) == 0) {
            this.strPageId = this.OnGetWFStepDataGridViewPage();
            strCurDEId = iDEHelper.getId();
        } else if (StringHelper.Compare((String)derGroupDetail.getDETAILTYPE(), (String)"WFSTEPACTOR", (boolean)true) == 0) {
            this.strPageId = this.OnGetWFStepActorGridViewPage();
            strCurDEId = iDEHelper.getId();
        } else if (StringHelper.Compare((String)derGroupDetail.getDETAILTYPE(), (String)"FILELIST", (boolean)true) == 0) {
            this.strPageId = "PAGE_00015";
            strCurDEId = iDEHelper.getId();
        } else if (StringHelper.Compare((String)derGroupDetail.getDETAILTYPE(), (String)"DATAAUDIT", (boolean)true) == 0) {
            this.strPageId = "PAGE_00016";
            strCurDEId = iDEHelper.getId();
        } else if (StringHelper.Compare((String)derGroupDetail.getDETAILTYPE(), (String)"DER1N", (boolean)true) == 0) {
            DER1N der1n = new DER1N();
            CallResult callResult = this.getDAGlobalHelper().getDAModelHelper().GetDER1N(derGroupDetail.getDER1NID(), der1n);
            if (callResult.getRetCode() != 0) {
                throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f531N\u5173\u7cfb[%1$s]\u5931\u8d25\uff0c%2$s", (Object)derGroupDetail.getDER1NID(), (Object)callResult.getErrorInfo()));
            }
            this.strPageId = der1n.getRELATEDPAGEID();
            if (StringHelper.IsNullOrEmpty((String)this.strPageId)) {
                IDEHelper iMinorDEHelper = this.getDAGlobalHelper().getDAModelStorage().FindDEHelper(der1n.getMINORDEID());
                if (iMinorDEHelper == null) {
                    throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61\u5931\u8d25", (Object)der1n.getMINORDEID()));
                }
                this.strPageId = iMinorDEHelper.GetGridPageId();
            }
            TreeMap<String, String> urlParams = new TreeMap<String, String>();
            urlParams.put("SRFDEID", der1n.getMINORDEID());
            urlParams.put("SRFDERID", der1n.getDERID());
            if ((der1n.getDERSUBTYPE() & 0x10) != 0) {
                urlParams.put("SRFINFOMODE", "TRUE");
            }
            if ((der1n.getDERSUBTYPE() & 0x20) != 0) {
                urlParams.put("SRFFEWDATAMODE", "TRUE");
            }
            strDefaultPageParam = URLHelper.GetQueryString(urlParams);
            strCurDEId = der1n.getMINORDEID();
            strTabViewBarCond = der1n.getTABVIEWBARCOND();
        } else if (StringHelper.Compare((String)derGroupDetail.getDETAILTYPE(), (String)"DER11", (boolean)true) == 0) {
            DER11 der11 = new DER11();
            CallResult callResult = this.getDAGlobalHelper().getDAModelHelper().GetDER11(derGroupDetail.getDER11ID(), der11);
            if (callResult.getRetCode() != 0) {
                throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f5311\u5173\u7cfb[%1$s]\u5931\u8d25\uff0c%2$s", (Object)derGroupDetail.getDER11ID(), (Object)callResult.getErrorInfo()));
            }
            this.strPageId = der11.getEDITPAGEID();
            if (StringHelper.IsNullOrEmpty((String)this.strPageId)) {
                IDEHelper iMinorDEHelper = this.getDAGlobalHelper().getDAModelStorage().FindDEHelper(der11.getMINORDEID());
                if (iMinorDEHelper == null) {
                    throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61\u5931\u8d25", (Object)der11.getMINORDEID()));
                }
                this.strPageId = iMinorDEHelper.GetEditPageId();
            }
            strDefaultPageParam = StringHelper.Format((String)"SRFDEID=%1$s&SRFDERID=%2$s", (Object)der11.getMINORDEID(), (Object)der11.getDERID());
            this.strRealPagePath = "../srfpage/ifformview.jsp?";
            strDefaultGroup = "\u8be6\u7ec6\u4fe1\u606f";
            strCurDEId = der11.getMINORDEID();
        }
        if (!StringHelper.IsNullOrEmpty((String)strCurDEId)) {
            this.strResourceId = UniResHelper.GetDEDataResId((String)strCurDEId);
        }
        if (!StringHelper.IsNullOrEmpty((String)this.strPageId)) {
            Page relatedPage = this.getDAGlobalHelper().getDAModelStorage().FindPage(this.strPageId);
            if (relatedPage == null) {
                throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u9875\u9762\u5bf9\u8c61[%1$s]\u5931\u8d25", (Object)this.strPageId));
            }
            this.strRealPagePath = relatedPage.GetTotalPagePath();
            this.strResourceId = relatedPage.getRESOURCEID(strCurDEId);
        }
        if (!StringHelper.IsNullOrEmpty((String)derGroupDetail.getRESOURCEID())) {
            this.strResourceId = derGroupDetail.getRESOURCEID();
        }
        this.OnInit();
    }

    public String getDetailType() {
        return this.derGroupDetail.getDETAILTYPE();
    }

    public String getPagePath() {
        return this.derGroupDetail.getPAGEPATH();
    }

    public String getPageId() {
        return this.derGroupDetail.getPAGEID();
    }

    public String getUrlParam() {
        return this.derGroupDetail.getURLPARAM();
    }

    public int getShowOrder() {
        return this.derGroupDetail.getSHOWORDER();
    }

    public String getCaption(String strLanguageId) {
        if (StringHelper.IsNullOrEmpty((String)this.derGroupDetail.getCAPTION())) {
            return this.getName();
        }
        return this.derGroupDetail.getCAPTION();
    }

    public String getSmallIcon() {
        return this.derGroupDetail.getSMALLICON();
    }

    public String getDERGroupFolderId() {
        return this.derGroupDetail.getDERGROUPFOLDERID();
    }

    public String getDER1NId() {
        return this.derGroupDetail.getDER1NID();
    }

    public String getDER11Id() {
        return this.derGroupDetail.getDER11ID();
    }

    public String getMemo() {
        return this.derGroupDetail.getMEMO();
    }

    public String getDEId() {
        return this.derGroupDetail.getDEID();
    }

    public String getDERTypeId() {
        return this.derGroupDetail.getDERTYPEID();
    }

    public String getRealPagePath() {
        return this.strRealPagePath;
    }

    public String getResourceId() {
        return this.strResourceId;
    }

    public IDERGroupHelper getDERGroup() {
        return this.iDERGroupHelper;
    }

    public IDERGroupFolderHelper getDERGroupFolder() {
        return this.iDERGroupFolderHelper;
    }

    protected String OnGetWFStepDataGridViewPage() {
        return this.getDAGlobalHelper().getWebExConfig().GetValue("SRFDA.WF", "WFSTEPDATAGRIDPAGE", "PAGE_00010");
    }

    protected String OnGetWFStepActorGridViewPage() {
        return this.getDAGlobalHelper().getWebExConfig().GetValue("SRFDA.WF", "WFSTEPACTORGRIDPAGE", "PAGE_WF0006_G001");
    }
}

