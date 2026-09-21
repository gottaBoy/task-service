/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 */
package SA.SRFDA.BI.Ctrl;

import SA.SRFDA.BI.Ctrl.BIRepChartDSHelper;
import SA.SRFDA.BI.Ctrl.BIRepPartHelper;
import SA.SRFDA.BI.Ctrl.Data.BIRepChart;
import SA.SRFDA.BI.Ctrl.Data.BIRepChartDS;
import SA.SRFDA.BI.Ctrl.IBIRepChartDSHelper;
import SA.SRFDA.BI.Ctrl.IBIRepChartHelper;
import SA.SRFDA.BI.Ctrl.IBIRepPartPublishContext;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import java.util.Hashtable;
import java.util.Vector;

public class BIRepChartHelper
extends BIRepPartHelper
implements IBIRepChartHelper {
    protected BIRepChart biRepChart = null;
    protected Vector<IBIRepChartDSHelper> repChartDSHelpers = new Vector();

    @Override
    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, BIRepChart biRepChart) throws Exception {
        this.iDAGlobalHelper = iDAGlobalHelper;
        this.biRepChart = biRepChart;
        this.biRepChart.CopyTo(this.biRepPart, false);
        this.biRepPart.setBIREPPARTID(this.biRepChart.getBIREPCHARTID());
        this.OnPrepareRepChartDSs();
        this.OnInit();
    }

    protected void OnPrepareRepChartDSs() throws Exception {
        Vector<BIRepChartDS> list = new Vector<BIRepChartDS>();
        CallResult callResult = this.getBIModelHelper().GetBIRepChartDSs(this.biRepChart.getBIREPCHARTID(), list);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u56fe\u5f62\u6570\u636e\u96c6\u5408\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        for (BIRepChartDS biRepChartDS : list) {
            IBIRepChartDSHelper iBIRepChartDSHelper = this.OnCreateBIRepChartDSHelper(biRepChartDS);
            iBIRepChartDSHelper.Init(this.iDAGlobalHelper, this, biRepChartDS);
            this.repChartDSHelpers.add(iBIRepChartDSHelper);
        }
    }

    protected IBIRepChartDSHelper OnCreateBIRepChartDSHelper(BIRepChartDS biRepChartDS) throws Exception {
        return new BIRepChartDSHelper();
    }

    protected void OnInit() throws Exception {
    }

    @Override
    protected String OnGetDefaultCtrlName() {
        return "SRFBIRepChart";
    }

    @Override
    protected void OnPublish(IBIRepPartPublishContext iBIRepPartPublishContext) throws Exception {
        String strShortNSName = iBIRepPartPublishContext.RegisterNS(this.OnGetNameSpace());
        String strCtrlName = this.OnGetCtrlName();
        StringBuilderEx sb = new StringBuilderEx();
        sb.Append("<%1$s:%2$s ", (Object)strShortNSName, (Object)strCtrlName);
        Hashtable<String, String> propertyList = new Hashtable<String, String>();
        this.OnFillCtrlProperties(iBIRepPartPublishContext, propertyList);
        for (String strKey : propertyList.keySet()) {
            sb.Append("%1$s=\"%2$s\" ", (Object)strKey, (Object)propertyList.get(strKey));
        }
        sb.Append(">\r\n", (Object)strShortNSName, (Object)strCtrlName);
        this.OnPublishChatDSs(strShortNSName, strCtrlName, sb);
        this.OnPublishPartParams(iBIRepPartPublishContext, strShortNSName, strCtrlName, sb);
        sb.Append("</%1$s:%2$s>\r\n", (Object)strShortNSName, (Object)strCtrlName);
        iBIRepPartPublishContext.setBIRepPIModel(sb.toString());
    }

    protected void OnPublishChatDSs(String strShortNSName, String strCtrlName, StringBuilderEx sb) {
        sb.Append("<%1$s:%2$s.RepChartDSs>\r\n", (Object)strShortNSName, (Object)strCtrlName);
        sb.Append("<sasrfbi:SRFBIRepChartDSs>\r\n");
        for (IBIRepChartDSHelper iBIRepChartDSHelper : this.repChartDSHelpers) {
            sb.Append("<sasrfbi:SRFBIRepChartDS CatalogField=\"%1$s\" AxisXField=\"%2$s\" ValueField=\"%3$s\" Value2Field=\"%4$s\" Value3Field=\"%5$s\" Value4Field=\"%6$s\" ", (Object)iBIRepChartDSHelper.getCatalogField(), (Object)iBIRepChartDSHelper.getAxisXField(), (Object)iBIRepChartDSHelper.getValueField(), (Object)iBIRepChartDSHelper.getValue2Field(), (Object)iBIRepChartDSHelper.getValue3Field(), (Object)iBIRepChartDSHelper.getValue4Field());
            sb.Append(" ValueCaption=\"%1$s\" Value2Caption=\"%2$s\" Value3Caption=\"%3$s\" Value4Caption=\"%4$s\" ChartType=\"%5$s\"/>", (Object)iBIRepChartDSHelper.getValueCaption(), (Object)iBIRepChartDSHelper.getValue2Caption(), (Object)iBIRepChartDSHelper.getValue3Caption(), (Object)iBIRepChartDSHelper.getValue4Caption(), (Object)iBIRepChartDSHelper.getChartType());
        }
        sb.Append("</sasrfbi:SRFBIRepChartDSs>\r\n");
        sb.Append("</%1$s:%2$s.RepChartDSs>\r\n", (Object)strShortNSName, (Object)strCtrlName);
    }
}

