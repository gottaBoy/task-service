/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DAHelperActionResult
 *  SA.SRFDA.Ctrl.IDBModelHelper
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.SRFExGridFetchResult
 *  SA.SRFramework.XML.XMLNode
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.Web.Default;

import SA.SRFDA.Ctrl.DAHelperActionResult;
import SA.SRFDA.Ctrl.IDBModelHelper;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.SRFExGridFetchResult;
import SA.SRFramework.XML.XMLNode;
import net.sf.json.JSONObject;

public class XML2JSONPage
extends SRFDAPage {
    private IDBModelHelper iDBModelHelper = null;
    public static final String TAG_ACTION_SEARCHITEM = "SEARCHITEM";
    public static final String TAG_ACTION_QUERYGROUPITEM = "QUERYGROUPITEM";

    public XML2JSONPage() {
        this.setMainPage(true);
        this.setOutputDebug(false);
    }

    protected void OnLoadBackEnd() {
        DAHelperActionResult actionResult = new DAHelperActionResult();
        String strMajorAction = this.getWebContext().GetParamValue("MAJORACTION");
        if (StringHelper.Compare((String)strMajorAction, (String)TAG_ACTION_SEARCHITEM, (boolean)true) == 0) {
            XMLNode xmlNode;
            String strXML = this.getWebContext().GetPostValue("xmlcontent");
            SRFExGridFetchResult fetchResult = new SRFExGridFetchResult();
            if (!StringHelper.IsNullOrEmpty((String)strXML) && (xmlNode = XMLNode.LoadFromXML((String)strXML)) != null && xmlNode.getChildNodes() != null) {
                fetchResult.setTotalRow(xmlNode.getChildNodes().size());
                for (XMLNode childNode : xmlNode.getChildNodes()) {
                    JSONObject objJSON = new JSONObject();
                    objJSON.put("cond", (Object)childNode.GetExtValue("ACTION", ""));
                    objJSON.put("caption", (Object)childNode.GetExtValue("CAPTION", ""));
                    objJSON.put("group", (Object)childNode.GetExtValue("GROUP", ""));
                    objJSON.put("showorder", (Object)childNode.GetExtValue("SHOWORDER", ""));
                    objJSON.put("colspan", (Object)childNode.GetExtValue("COLSPAN", ""));
                    objJSON.put("func", (Object)childNode.GetExtValue("FUNC", ""));
                    objJSON.put("formitem", (Object)childNode.GetExtValue("FORMITEM", ""));
                    objJSON.put("formitemparam", (Object)childNode.GetExtValue("FORMITEMPARAM", ""));
                    objJSON.put("formitemparams", (Object)childNode.GetExtValue("FORMITEMPARAMS", ""));
                    objJSON.put("ctrlparams", (Object)childNode.GetExtValue("CTRLPARAMS", ""));
                    fetchResult.getItems().add(objJSON);
                }
            }
            this.Output(fetchResult.ToJSONString());
            return;
        }
        if (StringHelper.Compare((String)strMajorAction, (String)TAG_ACTION_QUERYGROUPITEM, (boolean)true) == 0) {
            XMLNode xmlNode;
            String strXML = this.getWebContext().GetPostValue("xmlcontent");
            SRFExGridFetchResult fetchResult = new SRFExGridFetchResult();
            if (!StringHelper.IsNullOrEmpty((String)strXML) && (xmlNode = XMLNode.LoadFromXML((String)strXML)) != null && xmlNode.getChildNodes() != null) {
                fetchResult.setTotalRow(xmlNode.getChildNodes().size());
                for (XMLNode childNode : xmlNode.getChildNodes()) {
                    JSONObject objJSON = new JSONObject();
                    objJSON.put("alias", (Object)childNode.GetExtValue("ALIAS", ""));
                    objJSON.put("formular", (Object)childNode.GetExtValue("FORMULAR", ""));
                    objJSON.put("defields", (Object)childNode.GetExtValue("DEFIELDS", ""));
                    objJSON.put("isgroup", (Object)childNode.GetExtValue("ISGROUP", ""));
                    objJSON.put("order", (Object)childNode.GetExtValue("ORDER", ""));
                    objJSON.put("orderdirection", (Object)childNode.GetExtValue("ORDERDIRECTION", ""));
                    objJSON.put("usertag", (Object)childNode.GetExtValue("USERTAG", ""));
                    objJSON.put("usertag2", (Object)childNode.GetExtValue("USERTAG2", ""));
                    fetchResult.getItems().add(objJSON);
                }
            }
            this.Output(fetchResult.ToJSONString());
            return;
        }
    }
}

