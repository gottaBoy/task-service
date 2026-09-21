/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 */
package SA.SRFDA.BI.Ctrl;

import SA.SRFDA.BI.Ctrl.BaseBIObject;
import SA.SRFDA.BI.Ctrl.Data.BIRepPart;
import SA.SRFDA.BI.Ctrl.IBICubeHelper;
import SA.SRFDA.BI.Ctrl.IBIRepPLHelper;
import SA.SRFDA.BI.Ctrl.IBIRepPartHelper;
import SA.SRFDA.BI.Ctrl.IBIRepPartPublishContext;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import java.util.Hashtable;

public abstract class BIRepPartHelper
extends BaseBIObject
implements IBIRepPartHelper {
    protected BIRepPart biRepPart = new BIRepPart();
    protected IBICubeHelper iBICubeHelper = null;

    @Override
    public int getVersion() {
        return this.biRepPart.getVERSION();
    }

    @Override
    public String getId() {
        return this.biRepPart.getBIREPPARTID();
    }

    @Override
    public IBICubeHelper getBICube() throws Exception {
        if (StringHelper.IsNullOrEmpty((String)this.biRepPart.getBICUBEID())) {
            return null;
        }
        if (this.iBICubeHelper != null) {
            return this.iBICubeHelper;
        }
        this.iBICubeHelper = this.getBIModelStorage().FindBICube(this.biRepPart.getBICUBEID());
        return this.iBICubeHelper;
    }

    @Override
    public String getCustomObject() {
        return this.biRepPart.getCUSTOMOBJECT();
    }

    @Override
    public void Publish(IBIRepPartPublishContext iBIRepPartPublishContext) throws Exception {
        this.OnPublish(iBIRepPartPublishContext);
    }

    protected void OnPublish(IBIRepPartPublishContext iBIRepPartPublishContext) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0OnPublish\u65b9\u6cd5");
    }

    protected String OnGetNameSpace() {
        return "http://schemas.softanywhere.com/2011/xaml/bi";
    }

    protected String OnGetCtrlName() {
        return this.OnGetDefaultCtrlName();
    }

    protected abstract String OnGetDefaultCtrlName();

    protected String OnGetCustomStyle() {
        return "";
    }

    protected String OnGetCaption(IBIRepPartPublishContext iBIRepPartPublishContext) {
        if (iBIRepPartPublishContext.getBIRepPIHelper() != null && !StringHelper.IsNullOrEmpty((String)iBIRepPartPublishContext.getBIRepPIHelper().getCustomCaption())) {
            return iBIRepPartPublishContext.getBIRepPIHelper().getCustomCaption();
        }
        return this.biRepPart.getBIREPPARTNAME();
    }

    protected void OnFillCtrlProperties(IBIRepPartPublishContext iBIRepPartPublishContext, Hashtable<String, String> propertyList) {
        propertyList.put("RepPartId", StringHelper.Format((String)"%1$s", (Object)this.biRepPart.getBIREPPARTID()));
        String strCaption = this.OnGetCaption(iBIRepPartPublishContext);
        propertyList.put("Caption", StringHelper.Format((String)"%1$s", (Object)strCaption));
        if (iBIRepPartPublishContext.getBIRepPIHelper() != null) {
            propertyList.put("IsShowCaption", iBIRepPartPublishContext.getBIRepPIHelper().isShowCaption() ? "True" : "False");
            propertyList.put("IsShowBorder", iBIRepPartPublishContext.getBIRepPIHelper().isShowBorder() ? "True" : "False");
        } else {
            propertyList.put("IsShowCaption", "True");
            propertyList.put("IsShowBorder", "True");
        }
        String strStyle = this.OnGetCustomStyle();
        if (!StringHelper.IsNullOrEmpty((String)strStyle)) {
            propertyList.put("Style", StringHelper.Format((String)"{StaticResource %1$s}", (Object)strStyle));
        }
    }

    protected void OnPublishPartParams(IBIRepPartPublishContext iBIRepPartPublishContext, String strShortNSName, String strCtrlName, StringBuilderEx sb) throws Exception {
        Hashtable<String, String> paramList = new Hashtable<String, String>();
        this.OnFillPartParams(iBIRepPartPublishContext, paramList);
        sb.Append("<%1$s:%2$s.Params>\r\n", (Object)strShortNSName, (Object)strCtrlName);
        sb.Append("<sasrfbi:SRFBIRepParams>\r\n");
        if (paramList != null && paramList.size() > 0) {
            for (String strKey : paramList.keySet()) {
                String strValue = paramList.get(strKey);
                sb.Append("<sasrfbi:SRFBIRepParam Key=\"%1$s\" Value=\"%2$s\"/>\r\n", (Object)strKey, (Object)strValue);
            }
        }
        sb.Append("</sasrfbi:SRFBIRepParams>\r\n");
        sb.Append("</%1$s:%2$s.Params>\r\n", (Object)strShortNSName, (Object)strCtrlName);
    }

    protected void OnFillPartParams(IBIRepPartPublishContext iBIRepPartPublishContext, Hashtable<String, String> paramList) throws Exception {
        if (iBIRepPartPublishContext.getBIRepPIHelper() != null) {
            if (!StringHelper.IsNullOrEmpty((String)iBIRepPartPublishContext.getBIRepPIHelper().getBIRepPDSId())) {
                paramList.put("DATASOURCEID", iBIRepPartPublishContext.getBIRepPIHelper().getBIRepPDSId());
            }
            if (!StringHelper.IsNullOrEmpty((String)iBIRepPartPublishContext.getBIRepPIHelper().getBIRepPQId())) {
                paramList.put("QUERYID", iBIRepPartPublishContext.getBIRepPIHelper().getBIRepPQId());
            }
        }
    }

    protected void OnPublishPartLogic(IBIRepPartPublishContext iBIRepPartPublishContext, String strShortNSName, String strCtrlName, StringBuilderEx sb, Hashtable<String, String> paramList) throws Exception {
        if (StringHelper.IsNullOrEmpty((String)this.biRepPart.getBIREPPLID())) {
            return;
        }
        IBIRepPLHelper iBIRepPLHelper = this.getBIModelStorage().FindBIRepPL(this.biRepPart.getBIREPPLID());
        String strLogicNSName = iBIRepPartPublishContext.RegisterNS(iBIRepPLHelper.getNamespace());
        sb.Append("<%1$s:%2$s.PartLogic>\r\n", (Object)strShortNSName, (Object)strCtrlName);
        sb.Append("<%1$s:%2$s>\r\n", (Object)strLogicNSName, (Object)iBIRepPLHelper.getCtrlName());
        sb.Append("<%1$s:%2$s.Params>\r\n", (Object)strLogicNSName, (Object)iBIRepPLHelper.getCtrlName());
        sb.Append("<sasrfbi:SRFBIRepParams>\r\n");
        if (paramList != null && paramList.size() > 0) {
            for (String strKey : paramList.keySet()) {
                String strValue = paramList.get(strKey);
                sb.Append("<sasrfbi:SRFBIRepParam Key=\"%1$s\" Value=\"%2$s\"/>\r\n", (Object)strKey, (Object)strValue);
            }
        }
        sb.Append("</sasrfbi:SRFBIRepParams>\r\n");
        sb.Append("</%1$s:%2$s.Params>\r\n", (Object)strLogicNSName, (Object)iBIRepPLHelper.getCtrlName());
        sb.Append("</%1$s:%2$s>\r\n", (Object)strLogicNSName, (Object)iBIRepPLHelper.getCtrlName());
        sb.Append("</%1$s:%2$s.PartLogic>\r\n", (Object)strShortNSName, (Object)strCtrlName);
    }
}

