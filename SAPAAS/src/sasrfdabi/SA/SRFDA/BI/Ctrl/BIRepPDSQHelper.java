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
import SA.SRFDA.BI.Ctrl.Data.BIRepPDSQ;
import SA.SRFDA.BI.Ctrl.IBIRepPDSHelper;
import SA.SRFDA.BI.Ctrl.IBIRepPDSQHelper;
import SA.SRFDA.BI.Ctrl.IBIRepPartPublishContext;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import java.util.Hashtable;

public class BIRepPDSQHelper
extends BaseBIObject
implements IBIRepPDSQHelper {
    protected IBIRepPDSHelper biRepPDSHelper = null;
    protected BIRepPDSQ biRepPDSQ = null;

    @Override
    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, IBIRepPDSHelper biRepPDSHelper, BIRepPDSQ biRepPDSQ) throws Exception {
        this.iDAGlobalHelper = iDAGlobalHelper;
        this.biRepPDSHelper = biRepPDSHelper;
        this.biRepPDSQ = biRepPDSQ;
        this.OnInit();
    }

    protected void OnInit() throws Exception {
    }

    @Override
    public BIRepPDSQ getBIRepPDSQ() {
        return this.biRepPDSQ;
    }

    protected String OnGetNameSpace() {
        return "http://schemas.softanywhere.com/2011/xaml/bi";
    }

    protected String OnGetCtrlName() {
        return "SRFBIRepPanelDSQ";
    }

    @Override
    public void Publish(IBIRepPartPublishContext iBIRepPartPublishContext, StringBuilderEx sb) throws Exception {
        String strShortNSName = iBIRepPartPublishContext.RegisterNS(this.OnGetNameSpace());
        String strCtrlName = this.OnGetCtrlName();
        sb.Append("<%1$s:%2$s ", (Object)strShortNSName, (Object)strCtrlName);
        Hashtable<String, String> propertyList = new Hashtable<String, String>();
        this.OnFillCtrlProperties(iBIRepPartPublishContext, propertyList);
        for (String strKey : propertyList.keySet()) {
            sb.Append("%1$s=\"%2$s\" ", (Object)strKey, (Object)propertyList.get(strKey));
        }
        sb.Append(">\r\n", (Object)strShortNSName, (Object)strCtrlName);
        sb.Append("</%1$s:%2$s>\r\n", (Object)strShortNSName, (Object)strCtrlName);
    }

    protected void OnFillCtrlProperties(IBIRepPartPublishContext iBIRepPartPublishContext, Hashtable<String, String> propertyList) {
        propertyList.put("QueryId", StringHelper.Format((String)"%1$s", (Object)this.biRepPDSQ.getBIREPPQID()));
    }
}

