/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.PropertiesHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 */
package SA.SRFDA.BI.Ctrl;

import SA.SRFDA.BI.Ctrl.BIRepPDSQHelper;
import SA.SRFDA.BI.Ctrl.BaseBIObject;
import SA.SRFDA.BI.Ctrl.Data.BIRepPDS;
import SA.SRFDA.BI.Ctrl.Data.BIRepPDSQ;
import SA.SRFDA.BI.Ctrl.IBICubeMeasureHelper;
import SA.SRFDA.BI.Ctrl.IBIRepPDSHelper;
import SA.SRFDA.BI.Ctrl.IBIRepPDSQHelper;
import SA.SRFDA.BI.Ctrl.IBIRepPanelHelper;
import SA.SRFDA.BI.Ctrl.IBIRepPartPublishContext;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import java.util.Hashtable;
import java.util.Properties;
import java.util.Vector;

public class BIRepPDSHelper
extends BaseBIObject
implements IBIRepPDSHelper {
    protected IBIRepPanelHelper biRepPanelHelper;
    protected BIRepPDS biRepPDS;
    protected Vector<IBIRepPDSQHelper> repPanelDSQueries = new Vector();

    @Override
    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, IBIRepPanelHelper biRepPanelHelper, BIRepPDS biRepPDS) throws Exception {
        this.iDAGlobalHelper = iDAGlobalHelper;
        this.biRepPanelHelper = biRepPanelHelper;
        this.biRepPDS = biRepPDS;
        this.OnPrepareRepPDSQs();
        this.OnInit();
    }

    protected void OnPrepareRepPDSQs() throws Exception {
        Vector<BIRepPDSQ> list = new Vector<BIRepPDSQ>();
        CallResult callResult = this.getBIModelHelper().GetBIRepPDSQs(this.biRepPDS.getBIREPPDSID(), list);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u9762\u677f\u67e5\u8be2\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        for (BIRepPDSQ biRepPDSQ : list) {
            IBIRepPDSQHelper iBIRepPDSQHelper = this.OnCreateBIRepPDSQHelper(biRepPDSQ);
            iBIRepPDSQHelper.Init(this.iDAGlobalHelper, this, biRepPDSQ);
            this.repPanelDSQueries.add(iBIRepPDSQHelper);
        }
    }

    protected IBIRepPDSQHelper OnCreateBIRepPDSQHelper(BIRepPDSQ biRepPDSQ) throws Exception {
        return new BIRepPDSQHelper();
    }

    protected void OnInit() throws Exception {
    }

    @Override
    public BIRepPDS getBIRepPDS() {
        return this.biRepPDS;
    }

    protected String OnGetNameSpace() {
        return "http://schemas.softanywhere.com/2011/xaml/bi";
    }

    protected String OnGetCtrlName() {
        return "SRFBIRepPanelDataSource";
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
        this.OnPublishPDSQs(iBIRepPartPublishContext, strShortNSName, strCtrlName, sb);
        this.OnPublishStaticConditions(iBIRepPartPublishContext, strShortNSName, strCtrlName, sb);
        sb.Append("</%1$s:%2$s>\r\n", (Object)strShortNSName, (Object)strCtrlName);
    }

    protected void OnFillCtrlProperties(IBIRepPartPublishContext iBIRepPartPublishContext, Hashtable<String, String> propertyList) throws Exception {
        propertyList.put("Id", StringHelper.Format((String)"%1$s", (Object)this.biRepPDS.getBIREPPDSID()));
        propertyList.put("IsEnableSort", StringHelper.Format((String)"%1$s", (Object)(this.isEnableSort() ? "True" : "False")));
        propertyList.put("SortMeasure", this.getSortMeasure());
        propertyList.put("TopCount", StringHelper.Format((String)"%1$s", (Object)this.getTopCount()));
        propertyList.put("SortDir", this.getSortDir());
    }

    protected void OnPublishPDSQs(IBIRepPartPublishContext iBIRepPartPublishContext, String strShortNSName, String strCtrlName, StringBuilderEx sb) throws Exception {
        if (this.repPanelDSQueries.size() == 0) {
            return;
        }
        sb.Append("<%1$s:%2$s.Queries>\r\n", (Object)strShortNSName, (Object)strCtrlName);
        sb.Append("<sasrfbi:SRFBIRepPanelDSQs>\r\n");
        for (IBIRepPDSQHelper iBIRepPDSQHelper : this.repPanelDSQueries) {
            iBIRepPDSQHelper.Publish(iBIRepPartPublishContext, sb);
        }
        sb.Append("</sasrfbi:SRFBIRepPanelDSQs>\r\n");
        sb.Append("</%1$s:%2$s.Queries>\r\n", (Object)strShortNSName, (Object)strCtrlName);
    }

    protected void OnPublishStaticConditions(IBIRepPartPublishContext iBIRepPartPublishContext, String strShortNSName, String strCtrlName, StringBuilderEx sb) throws Exception {
        Properties staticConditions = PropertiesHelper.Load((String)this.biRepPDS.getSTATICCOND());
        if (staticConditions == null || staticConditions.size() == 0) {
            return;
        }
        sb.Append("<%1$s:%2$s.StaticConditions>\r\n", (Object)strShortNSName, (Object)strCtrlName);
        sb.Append("<sasrfbi:SRFBIRepParams>\r\n");
        for (Object objKey : staticConditions.keySet()) {
            String strValue = PropertiesHelper.GetProperty((Properties)staticConditions, (String)((String)objKey), (String)"");
            sb.Append("<sasrfbi:SRFBIRepParam Key=\"%1$s\" Value=\"%2$s\"/>\r\n", objKey, (Object)strValue);
        }
        sb.Append("</sasrfbi:SRFBIRepParams>\r\n");
        sb.Append("</%1$s:%2$s.StaticConditions>\r\n", (Object)strShortNSName, (Object)strCtrlName);
    }

    @Override
    public boolean isEnableSort() {
        if (this.biRepPDS.isENABLESORTNull()) {
            return false;
        }
        return this.biRepPDS.getENABLESORT();
    }

    @Override
    public String getSortMeasure() throws Exception {
        if (StringHelper.IsNullOrEmpty((String)this.biRepPDS.getBICUBEMEASUREID())) {
            return "";
        }
        IBICubeMeasureHelper iBICubeMeasureHelper = this.biRepPanelHelper.getBICube().FindBICubeMeasure(this.biRepPDS.getBICUBEMEASUREID());
        return iBICubeMeasureHelper.getUniqueName();
    }

    @Override
    public String getSortDir() {
        return this.biRepPDS.getSORTDIR();
    }

    @Override
    public int getTopCount() {
        if (this.biRepPDS.isTOPCNTNull()) {
            return 10;
        }
        return this.biRepPDS.getTOPCNT();
    }
}

