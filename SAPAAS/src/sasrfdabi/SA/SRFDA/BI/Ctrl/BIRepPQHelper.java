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
import SA.SRFDA.BI.Ctrl.Data.BIRepPQ;
import SA.SRFDA.BI.Ctrl.IBIRepPQHelper;
import SA.SRFDA.BI.Ctrl.IBIRepPanelHelper;
import SA.SRFDA.BI.Ctrl.IBIRepPartPublishContext;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import java.util.Hashtable;

public class BIRepPQHelper
extends BaseBIObject
implements IBIRepPQHelper {
    protected IBIRepPanelHelper biRepPanelHelper;
    protected BIRepPQ biRepPQ;

    @Override
    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, IBIRepPanelHelper biRepPanelHelper, BIRepPQ biRepPQ) throws Exception {
        this.iDAGlobalHelper = iDAGlobalHelper;
        this.biRepPanelHelper = biRepPanelHelper;
        this.biRepPQ = biRepPQ;
        this.OnInit();
    }

    protected void OnInit() throws Exception {
    }

    @Override
    public BIRepPQ getBIRepPQ() {
        return this.biRepPQ;
    }

    protected String OnGetNameSpace() {
        return "http://schemas.softanywhere.com/2011/xaml/bi";
    }

    protected String OnGetCtrlName() {
        return "SRFBIRepPanelQuery";
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
        propertyList.put("Id", StringHelper.Format((String)"%1$s", (Object)this.biRepPQ.getBIREPPQID()));
    }
}

