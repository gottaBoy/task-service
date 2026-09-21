/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  freemarker.cache.StringTemplateLoader
 *  freemarker.cache.TemplateLoader
 *  freemarker.template.Configuration
 *  freemarker.template.Template
 */
package SA.SRFDA.BI.Ctrl;

import SA.SRFDA.BI.Ctrl.BIRepChartPublishPIMethod;
import SA.SRFDA.BI.Ctrl.BIRepPDSHelper;
import SA.SRFDA.BI.Ctrl.BIRepPIHelper;
import SA.SRFDA.BI.Ctrl.BIRepPQHelper;
import SA.SRFDA.BI.Ctrl.BIRepPartHelper;
import SA.SRFDA.BI.Ctrl.BIRepPartPublishContext;
import SA.SRFDA.BI.Ctrl.Data.BIRepPDS;
import SA.SRFDA.BI.Ctrl.Data.BIRepPI;
import SA.SRFDA.BI.Ctrl.Data.BIRepPQ;
import SA.SRFDA.BI.Ctrl.Data.BIRepPanel;
import SA.SRFDA.BI.Ctrl.IBIRepPDSHelper;
import SA.SRFDA.BI.Ctrl.IBIRepPIHelper;
import SA.SRFDA.BI.Ctrl.IBIRepPQHelper;
import SA.SRFDA.BI.Ctrl.IBIRepPTHelper;
import SA.SRFDA.BI.Ctrl.IBIRepPanelHelper;
import SA.SRFDA.BI.Ctrl.IBIRepPartHelper;
import SA.SRFDA.BI.Ctrl.IBIRepPartPublishContext;
import SA.SRFDA.BI.Ctrl.IBIRepRPHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import freemarker.cache.StringTemplateLoader;
import freemarker.cache.TemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Hashtable;
import java.util.TreeMap;
import java.util.Vector;

public class BIRepPanelHelper
extends BIRepPartHelper
implements IBIRepPanelHelper {
    protected BIRepPanel biRepPanel = null;
    protected IBIRepPTHelper iBIRepPTHelper = null;
    protected Vector<IBIRepPIHelper> repPanelItems = new Vector();
    protected Vector<IBIRepPQHelper> repPanelQueries = new Vector();
    protected Vector<IBIRepPDSHelper> repPanelDSs = new Vector();
    protected boolean bPublish = false;
    protected String strModel = "";

    @Override
    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, IBIRepPTHelper iBIRepPTHelper, BIRepPanel biRepPanel) throws Exception {
        this.iDAGlobalHelper = iDAGlobalHelper;
        this.biRepPanel = biRepPanel;
        this.biRepPanel.CopyTo(this.biRepPart, false);
        this.biRepPart.setBIREPPARTID(this.biRepPanel.getBIREPPANELID());
        this.iBIRepPTHelper = iBIRepPTHelper;
        this.OnPrepareRepPQs();
        this.OnPrepareRepPDSs();
        this.OnPrepareRepPIs();
        this.OnInit();
    }

    protected void OnPrepareRepPIs() throws Exception {
        Vector<BIRepPI> list = new Vector<BIRepPI>();
        CallResult callResult = this.getBIModelHelper().GetBIRepPIs(this.biRepPanel.getBIREPPANELID(), list);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u9762\u677f\u5b50\u9879\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        for (BIRepPI biRepPI : list) {
            IBIRepPIHelper iBIRepPIHelper = this.OnCreateBIRepPIHelper(biRepPI);
            iBIRepPIHelper.Init(this.iDAGlobalHelper, this, biRepPI);
            this.repPanelItems.add(iBIRepPIHelper);
        }
    }

    protected IBIRepPIHelper OnCreateBIRepPIHelper(BIRepPI biRepPI) throws Exception {
        return new BIRepPIHelper();
    }

    protected void OnPrepareRepPQs() throws Exception {
        Vector<BIRepPQ> list = new Vector<BIRepPQ>();
        CallResult callResult = this.getBIModelHelper().GetBIRepPQs(this.biRepPanel.getBIREPPANELID(), list);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u9762\u677f\u67e5\u8be2\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        for (BIRepPQ biRepPQ : list) {
            IBIRepPQHelper iBIRepPQHelper = this.OnCreateBIRepPQHelper(biRepPQ);
            iBIRepPQHelper.Init(this.iDAGlobalHelper, this, biRepPQ);
            this.repPanelQueries.add(iBIRepPQHelper);
        }
    }

    protected IBIRepPQHelper OnCreateBIRepPQHelper(BIRepPQ biRepPQ) throws Exception {
        return new BIRepPQHelper();
    }

    protected void OnPrepareRepPDSs() throws Exception {
        Vector<BIRepPDS> list = new Vector<BIRepPDS>();
        CallResult callResult = this.getBIModelHelper().GetBIRepPDSs(this.biRepPanel.getBIREPPANELID(), list);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u9762\u677f\u6570\u636e\u6e90\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        for (BIRepPDS biRepPDS : list) {
            IBIRepPDSHelper iBIRepPDSHelper = this.OnCreateBIRepPDSHelper(biRepPDS);
            iBIRepPDSHelper.Init(this.iDAGlobalHelper, this, biRepPDS);
            this.repPanelDSs.add(iBIRepPDSHelper);
        }
    }

    protected IBIRepPDSHelper OnCreateBIRepPDSHelper(BIRepPDS biRepPDS) throws Exception {
        return new BIRepPDSHelper();
    }

    protected void OnInit() throws Exception {
    }

    @Override
    public String getPanelModel() throws Exception {
        if (this.bPublish) {
            return this.strModel;
        }
        this.OnPublish();
        return this.strModel;
    }

    protected void OnPublish() throws Exception {
        String strOriginModel = "";
        if (StringHelper.IsNullOrEmpty((String)this.biRepPanel.getPANELMODEL())) {
            if (this.iBIRepPTHelper != null) {
                strOriginModel = this.iBIRepPTHelper.getPTModel();
            }
        } else {
            strOriginModel = this.biRepPanel.getPANELMODEL();
        }
        BIRepPartPublishContext biRepPartPublishContext = new BIRepPartPublishContext();
        for (IBIRepPIHelper iBIRepPIHelper : this.repPanelItems) {
            biRepPartPublishContext.setBIRepPIHelper(iBIRepPIHelper);
            if (StringHelper.IsNullOrEmpty((String)iBIRepPIHelper.getBIRepPartId())) {
                biRepPartPublishContext.setBIRepPIModel(iBIRepPIHelper.getCustomContent());
                continue;
            }
            IBIRepPartHelper iBIRepPartHelper = this.getBIModelStorage().FindBIRepPart(iBIRepPIHelper.getBIRepPartId());
            iBIRepPartHelper.Publish(biRepPartPublishContext);
        }
        TreeMap<String, Object> templMethodMap = new TreeMap<String, Object>();
        BIRepChartPublishPIMethod piMethod = new BIRepChartPublishPIMethod();
        piMethod.setBIRepPartPublishContext(biRepPartPublishContext);
        templMethodMap.put("pi", piMethod);
        templMethodMap.put("namespace", biRepPartPublishContext.getAllNameSpaces());
        StringTemplateLoader dpTemplateLoader = new StringTemplateLoader();
        dpTemplateLoader.putTemplate("CODE", strOriginModel);
        Configuration config = new Configuration();
        config.setTemplateLoader((TemplateLoader)dpTemplateLoader);
        Template template = config.getTemplate("CODE");
        StringWriter sw = new StringWriter();
        template.process(templMethodMap, (Writer)sw);
        this.strModel = sw.toString();
        this.bPublish = true;
    }

    @Override
    protected String OnGetDefaultCtrlName() {
        return "SRFBIRepPanel";
    }

    @Override
    public String getRepRPModel(IBIRepRPHelper iBIRepRPHelper) throws Exception {
        BIRepPartPublishContext biRepPartPublishContext = new BIRepPartPublishContext();
        String strShortNSName = biRepPartPublishContext.RegisterNS(this.OnGetNameSpace());
        String strCtrlName = this.OnGetCtrlName();
        StringBuilderEx sb = new StringBuilderEx();
        sb.Append("<DataTemplate xmlns=\"http://schemas.microsoft.com/winfx/2006/xaml/presentation\" xmlns:x=\"http://schemas.microsoft.com/winfx/2006/xaml\"\r\n");
        sb.Append(biRepPartPublishContext.getAllNameSpaces());
        sb.Append(">");
        sb.Append("<%1$s:%2$s ", (Object)strShortNSName, (Object)strCtrlName);
        Hashtable<String, String> propertyList = new Hashtable<String, String>();
        this.OnFillCtrlProperties(biRepPartPublishContext, propertyList);
        for (String strKey : propertyList.keySet()) {
            sb.Append("%1$s=\"%2$s\" ", (Object)strKey, (Object)propertyList.get(strKey));
        }
        sb.Append(">\r\n", (Object)strShortNSName, (Object)strCtrlName);
        this.OnPublishPartParams(biRepPartPublishContext, strShortNSName, strCtrlName, sb);
        this.OnPublishPanelQueris(biRepPartPublishContext, strShortNSName, strCtrlName, sb);
        this.OnPublishPanelDataSources(biRepPartPublishContext, strShortNSName, strCtrlName, sb);
        sb.Append("</%1$s:%2$s>\r\n", (Object)strShortNSName, (Object)strCtrlName);
        sb.Append("</DataTemplate>");
        return sb.toString();
    }

    @Override
    protected void OnFillCtrlProperties(IBIRepPartPublishContext iBIRepPartPublishContext, Hashtable<String, String> propertyList) {
        super.OnFillCtrlProperties(iBIRepPartPublishContext, propertyList);
        if (this.biRepPanel.isENABLEFILTERNull()) {
            propertyList.put("IsEnableFilter", "False");
        }
        propertyList.put("IsEnableFilter", this.biRepPanel.getENABLEFILTER() ? "True" : "False");
    }

    protected void OnPublishPanelQueris(IBIRepPartPublishContext iBIRepPartPublishContext, String strShortNSName, String strCtrlName, StringBuilderEx sb) throws Exception {
        sb.Append("<%1$s:%2$s.Queries>\r\n", (Object)strShortNSName, (Object)strCtrlName);
        sb.Append("<sasrfbi:SRFBIRepPanelQueries>\r\n");
        for (IBIRepPQHelper iBIRepPQHelper : this.repPanelQueries) {
            iBIRepPQHelper.Publish(iBIRepPartPublishContext, sb);
        }
        sb.Append("</sasrfbi:SRFBIRepPanelQueries>\r\n");
        sb.Append("</%1$s:%2$s.Queries>\r\n", (Object)strShortNSName, (Object)strCtrlName);
    }

    protected void OnPublishPanelDataSources(IBIRepPartPublishContext iBIRepPartPublishContext, String strShortNSName, String strCtrlName, StringBuilderEx sb) throws Exception {
        sb.Append("<%1$s:%2$s.DataSources>\r\n", (Object)strShortNSName, (Object)strCtrlName);
        sb.Append("<sasrfbi:SRFBIRepPanelDataSources>\r\n");
        for (IBIRepPDSHelper iBIRepPDSHelper : this.repPanelDSs) {
            iBIRepPDSHelper.Publish(iBIRepPartPublishContext, sb);
        }
        sb.Append("</sasrfbi:SRFBIRepPanelDataSources>\r\n");
        sb.Append("</%1$s:%2$s.DataSources>\r\n", (Object)strShortNSName, (Object)strCtrlName);
    }
}

