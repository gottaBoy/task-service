/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 */
package SA.SRFDA.BI.Ctrl;

import SA.SRFDA.BI.Ctrl.BaseBIObject;
import SA.SRFDA.BI.Ctrl.Data.BIRepFI;
import SA.SRFDA.BI.Ctrl.IBIDimensionHelper;
import SA.SRFDA.BI.Ctrl.IBIRepFIHelper;
import SA.SRFDA.BI.Ctrl.IBIRepFIPublishContext;
import SA.SRFDA.BI.Ctrl.IBIRepFITypeHelper;
import SA.SRFDA.BI.Ctrl.IBIRepFilterHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import java.util.Hashtable;

public class BIRepFIHelper
extends BaseBIObject
implements IBIRepFIHelper {
    protected IBIRepFilterHelper iBIRepFilterHelper = null;
    protected BIRepFI biRepFI = null;
    protected IBIRepFITypeHelper iBIRepFITypeHelper = null;
    private String strDMLogicName = "";

    @Override
    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, IBIRepFilterHelper iBIRepFilterHelper, IBIRepFITypeHelper iBIRepFITypeHelper, BIRepFI biRepFI) throws Exception {
        this.iDAGlobalHelper = iDAGlobalHelper;
        this.biRepFI = biRepFI;
        this.iBIRepFilterHelper = iBIRepFilterHelper;
        this.iBIRepFITypeHelper = iBIRepFITypeHelper;
        if (!StringHelper.IsNullOrEmpty((String)this.biRepFI.getBICUBEDIMENSIONID())) {
            IBIDimensionHelper iBIDimensionHelper = this.iBIRepFilterHelper.getBICube().FindBIDimension(this.biRepFI.getBICUBEDIMENSIONID());
            this.strDMLogicName = iBIDimensionHelper.getLogicName();
        }
        this.OnInit();
    }

    protected void OnInit() throws Exception {
    }

    @Override
    public IBIRepFITypeHelper getBIRepFIType() {
        return this.iBIRepFITypeHelper;
    }

    @Override
    public int getColumnSpan() {
        if (!this.biRepFI.isCOLSPANNull()) {
            return this.biRepFI.getCOLSPAN();
        }
        return 1;
    }

    @Override
    public void Publish(IBIRepFIPublishContext iBIRepFIPublishContext) throws Exception {
        this.OnPublish(iBIRepFIPublishContext);
    }

    protected String OnGetNameSpace() {
        return this.iBIRepFITypeHelper.getCtrlNameSpace();
    }

    protected String OnGetCtrlName() {
        return this.iBIRepFITypeHelper.getCtrlObject();
    }

    protected void OnPublish(IBIRepFIPublishContext iBIRepFIPublishContext) throws Exception {
        StringBuilderEx sb = new StringBuilderEx();
        Hashtable<String, String> propertyList = new Hashtable<String, String>();
        if (iBIRepFIPublishContext.isAutoLayout()) {
            if (iBIRepFIPublishContext.getRowIndex() != 0) {
                propertyList.put("Grid.Row", StringHelper.Format((String)"%1$s", (Object)iBIRepFIPublishContext.getRowIndex()));
            }
            if (iBIRepFIPublishContext.getColumnIndex() != 0) {
                propertyList.put("Grid.Column", StringHelper.Format((String)"%1$s", (Object)iBIRepFIPublishContext.getColumnIndex()));
            }
            if (iBIRepFIPublishContext.getColumnSpan() > 1) {
                propertyList.put("Grid.ColumnSpan", StringHelper.Format((String)"%1$s", (Object)iBIRepFIPublishContext.getColumnSpan()));
            }
        }
        if (!this.isShowCaption()) {
            propertyList.put("Style", StringHelper.Format((String)"{StaticResource NoCaption}"));
        }
        sb.Append("<sasrfbi:SRFBIRepFIContainer Caption=\"%1$s\" CaptionWidth=\"%2$s\" IsShowCaption=\"%3$s\" ", (Object)this.getCaption(), (Object)this.getCaptionWidth(), (Object)(this.isShowCaption() ? "True" : "False"));
        for (String strKey : propertyList.keySet()) {
            sb.Append("%1$s=\"%2$s\" ", (Object)strKey, propertyList.get(strKey));
        }
        sb.Append(">\r\n");
        String strShortNSName = iBIRepFIPublishContext.RegisterNS(this.OnGetNameSpace());
        String strCtrlName = this.OnGetCtrlName();
        sb.Append("<%1$s:%2$s ", (Object)strShortNSName, (Object)strCtrlName);
        Hashtable<String, String> propertyList2 = new Hashtable<String, String>();
        this.OnFillCtrlProperties(iBIRepFIPublishContext, propertyList2);
        for (String strKey : propertyList2.keySet()) {
            sb.Append("%1$s=\"%2$s\" ", (Object)strKey, (Object)propertyList2.get(strKey));
        }
        sb.Append(">\r\n");
        Hashtable<String, String> paramList = new Hashtable<String, String>();
        this.OnFillCtrlParams(iBIRepFIPublishContext, propertyList2);
        this.PublishParams(strShortNSName, strCtrlName, sb, paramList);
        sb.Append("</%1$s:%2$s>\r\n", (Object)strShortNSName, (Object)strCtrlName);
        sb.Append("</sasrfbi:SRFBIRepFIContainer>");
        iBIRepFIPublishContext.setBIRepFIModel(sb.toString());
    }

    protected void OnFillCtrlProperties(IBIRepFIPublishContext iBIRepFIPublishContext, Hashtable<String, String> propertyList) throws Exception {
        if (iBIRepFIPublishContext.isAutoLayout()) {
            if (iBIRepFIPublishContext.getRowIndex() != 0) {
                propertyList.put("Grid.Row", StringHelper.Format((String)"%1$s", (Object)iBIRepFIPublishContext.getRowIndex()));
            }
            if (iBIRepFIPublishContext.getColumnIndex() != 0) {
                propertyList.put("Grid.Column", StringHelper.Format((String)"%1$s", (Object)iBIRepFIPublishContext.getColumnIndex()));
            }
            if (iBIRepFIPublishContext.getColumnSpan() > 1) {
                propertyList.put("Grid.ColumnSpan", StringHelper.Format((String)"%1$s", (Object)iBIRepFIPublishContext.getColumnSpan()));
            }
        }
        if (!StringHelper.IsNullOrEmpty((String)this.biRepFI.getBICUBEDIMENSIONID())) {
            IBIDimensionHelper iBIDimensionHelper = this.iBIRepFilterHelper.getBICube().FindBIDimension(this.biRepFI.getBICUBEDIMENSIONID());
            propertyList.put("CubeDM", iBIDimensionHelper.getShortId());
        }
    }

    protected void OnFillCtrlParams(IBIRepFIPublishContext iBIRepFIPublishContext, Hashtable<String, String> paramList) {
    }

    protected void PublishParams(String strShortNSName, String strCtrlName, StringBuilderEx sb, Hashtable<String, String> paramList) {
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

    @Override
    public boolean isShowCaption() {
        if (this.biRepFI.isSHOWCAPTIONNull()) {
            return true;
        }
        return this.biRepFI.getSHOWCAPTION();
    }

    @Override
    public String getCaption() {
        String strCaption = this.biRepFI.getCAPTION();
        if (StringHelper.IsNullOrEmpty((String)strCaption)) {
            strCaption = this.strDMLogicName;
        }
        return strCaption;
    }

    public int getCaptionWidth() {
        return this.iBIRepFilterHelper.getCaptionWidth();
    }
}

