/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.SRFDAPage
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.SRFExAjaxListResult
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.BI.Web;

import SA.SRFDA.BI.Ctrl.DEDataCtrl.BIHierarchyDataCtrl;
import SA.SRFDA.BI.Ctrl.Data.BIHierarchy;
import SA.SRFDA.BI.Ctrl.Data.BILevel;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.SRFExAjaxListResult;
import java.util.Vector;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class BIACPage
extends SRFDAPage {
    private static final Log log = LogFactory.getLog(BIACPage.class);

    public BIACPage() {
        this.setResourceId("");
    }

    protected boolean OnCustomAction(String strActionType, String strAction) {
        if (StringHelper.Compare((String)strActionType, (String)"autocompleteaction", (boolean)true) == 0) {
            String strACMode = this.getWebContext().getACMode();
            if (StringHelper.Compare((String)strACMode, (String)"BILEVEL", (boolean)true) == 0) {
                Vector<BILevel> biLevels;
                SRFExAjaxListResult fetchResult = new SRFExAjaxListResult();
                String strBIHierarchyId = this.getWebContext().GetPostValue("bihierarchyid");
                if (StringHelper.IsNullOrEmpty((String)strBIHierarchyId)) {
                    fetchResult.setRetCode(1);
                    fetchResult.setErrorInfo(StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u7ef4\u5ea6\u4f53\u7cfb"));
                    this.Output(fetchResult.ToJSONString());
                    return true;
                }
                BIHierarchyDataCtrl hierarchyDataCtrl = (BIHierarchyDataCtrl)this.getDAModelStorage().FindDEDataCtrl("BI0005", (ISRFDAWebContext)this.getWebContext());
                CallResult callResult = hierarchyDataCtrl.ListBILevels(strBIHierarchyId, biLevels = new Vector<BILevel>());
                if (callResult.IsError()) {
                    fetchResult.setRetCode(1);
                    fetchResult.setErrorInfo(StringHelper.Format((String)"\u67e5\u8be2\u7ef4\u5ea6\u4f53\u7cfb[%1$s]\u7ea7\u522b\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strBIHierarchyId, (Object)callResult.getErrorInfo()));
                    this.Output(fetchResult.ToJSONString());
                    return true;
                }
                BIHierarchy biHierarchy = new BIHierarchy();
                biHierarchy.setBIHIERARCHYID(strBIHierarchyId);
                callResult = hierarchyDataCtrl.Get(biHierarchy);
                if (callResult.IsError()) {
                    fetchResult.setRetCode(1);
                    fetchResult.setErrorInfo(StringHelper.Format((String)"\u83b7\u53d6\u7ef4\u5ea6\u4f53\u7cfb[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strBIHierarchyId, (Object)callResult.getErrorInfo()));
                    this.Output(fetchResult.ToJSONString());
                    return true;
                }
                if (biHierarchy.getHASALL()) {
                    JSONObject jo = new JSONObject();
                    String strAllId = StringHelper.Format((String)"H[%1$s.%2$s].[All %1$s.%2$ss]", (Object)biHierarchy.getBIDIMENSIONNAME(), (Object)biHierarchy.getBIHIERARCHYNAME());
                    String strAllCaption = biHierarchy.getALLCAPTION();
                    if (StringHelper.IsNullOrEmpty((String)strAllCaption)) {
                        strAllCaption = "\u5168\u90e8" + biHierarchy.getCAPTION();
                    }
                    jo.put("text", (Object)strAllCaption);
                    jo.put("realtext", (Object)strAllCaption);
                    jo.put("value", (Object)strAllId);
                    fetchResult.getItems().add(jo);
                }
                for (BILevel biLevel : biLevels) {
                    JSONObject jo = new JSONObject();
                    jo.put("text", (Object)biLevel.getBILEVELNAME());
                    jo.put("realtext", (Object)biLevel.getBILEVELNAME());
                    jo.put("value", (Object)("L" + biLevel.getBILEVELID()));
                    fetchResult.getItems().add(jo);
                }
                this.Output(fetchResult.ToJSONString());
                return true;
            }
            return true;
        }
        return super.OnCustomAction(strActionType, strAction);
    }
}

