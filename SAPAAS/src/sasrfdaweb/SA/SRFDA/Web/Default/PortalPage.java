/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Ctrl.Data.PPMWebPart
 *  SA.SRFDA.Ctrl.Data.PPModel
 *  SA.SRFDA.Ctrl.Data.PortalPage
 *  SA.SRFDA.Ctrl.Data.WebPart
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.SRFDAWebUtil
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Data.DataTypeParse
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.ReportEx.Model.ChartConfig
 *  SA.SRFramework.ReportEx.SRFExChart
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.Builder.StyleBuilder
 *  SA.SRFramework.WebEx.SRFExControl
 *  SA.SRFramework.WebEx.SRFExDropDownList
 *  SA.SRFramework.WebEx.SRFExIFrame
 *  SA.SRFramework.WebEx.SRFExRaw
 *  SA.SRFramework.WebEx.SRFExRemotePanel
 *  SA.SRFramework.WebEx.Utility.URLHelper
 *  javax.servlet.jsp.PageContext
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.Web.Default;

import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.Data.PPMWebPart;
import SA.SRFDA.Ctrl.Data.PPModel;
import SA.SRFDA.Ctrl.Data.WebPart;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.SRFDAPageEx;
import SA.SRFDA.Web.SRFDAWebUtil;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Data.DataTypeParse;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.ReportEx.Model.ChartConfig;
import SA.SRFramework.ReportEx.SRFExChart;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.Builder.StyleBuilder;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.SRFExDropDownList;
import SA.SRFramework.WebEx.SRFExIFrame;
import SA.SRFramework.WebEx.SRFExRaw;
import SA.SRFramework.WebEx.SRFExRemotePanel;
import SA.SRFramework.WebEx.Utility.URLHelper;
import java.util.TreeMap;
import java.util.Vector;
import javax.servlet.jsp.PageContext;
import net.sf.json.JSONObject;

public class PortalPage
extends SRFDAPageEx {
    protected PPModel ppmodel = new PPModel();
    protected Vector<WebPart> webParts = null;
    protected SRFExDropDownList ddlPortalPageStyle = new SRFExDropDownList();
    protected TreeMap<String, SRFExControl> webPartMap = null;
    protected String strPPName = "";
    protected TreeMap<Integer, Integer> ppmodelMap = new TreeMap();
    protected TreeMap<Integer, Vector<WebPart>> ppmWebPartMap = new TreeMap();
    protected String strDIVVisibleCode = "";
    protected String strPPModel = "";
    protected boolean bEnableCTX = false;
    protected boolean bLockedFlag = false;

    public String OutputPageCaption() {
        return this.OnGetPageCaption();
    }

    protected String OnGetPageCaption() {
        return "";
    }

    @Override
    protected boolean PreparePageEnv() {
        IDEDataCtrl ppmDataCtrl;
        if (!super.PreparePageEnv()) {
            return false;
        }
        this.strPPName = this.getWebContext().getSRFPPNAME();
        if (StringHelper.IsNullOrEmpty((String)this.strPPName)) {
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u95e8\u6237\u9875\u9762\u540d\u79f0"));
            return false;
        }
        boolean bCreateNew = false;
        this.strPPModel = this.getWebContext().GetParamValue("PPMODEL");
        String strLockedFlag = this.getWebContext().GetParamValue("LOCKED");
        this.bLockedFlag = StringHelper.Compare((String)strLockedFlag, (String)"TRUE", (boolean)true) == 0;
        CallResult callResult = this.getWebContext().getGlobalHelper().getDAModelHelper().GetUserPPModel(this.strPPName, this.getWebContext().getCurUserId(), this.ppmodel);
        if (callResult.getRetCode() != 0) {
            if (callResult.getRetCode() != 3) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u7528\u6237\u95e8\u6237\u9875\u9762[%1$s]\u6a21\u578b", (Object)this.strPPName));
                return false;
            }
            String strSQL = StringHelper.Format((String)"select * from t_SRFPORTALPAGE where UPPER(PORTALPAGENAME)='%1$s'", (Object)this.strPPName);
            SA.SRFDA.Ctrl.Data.PortalPage portalPage = new SA.SRFDA.Ctrl.Data.PortalPage();
            callResult = BaseDEDataCtrl.SelectSingle((ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper(), (String)strSQL, (BaseDataEntity)portalPage);
            if (callResult.IsError()) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u7528\u6237\u95e8\u6237\u9875\u9762[%1$s]\u6a21\u578b", (Object)this.strPPName));
                return false;
            }
            this.ppmodel.setPORTALPAGEID(portalPage.getPORTALPAGEID());
            bCreateNew = true;
            this.bEnableCTX = portalPage.getENABLECTX();
            this.ppmodel.setENABLECTX(this.bEnableCTX);
        }
        this.webParts = new Vector();
        if (!bCreateNew && (callResult = this.getWebContext().getGlobalHelper().getDAModelHelper().GetPPMWebParts(this.ppmodel.getPPMODELID(), this.webParts)).getRetCode() != 0) {
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u7528\u6237\u95e8\u6237\u9875\u9762[%1$s]\u6a21\u578b\u7684\u90e8\u4ef6", (Object)this.strPPName));
            return false;
        }
        if (bCreateNew || StringHelper.Compare((String)this.ppmodel.getOWNERID(), (String)this.getWebContext().getCurUserId(), (boolean)true) != 0) {
            this.ppmodel.setPPMODELID("");
            this.ppmodel.setOWNERID(this.getWebContext().getCurUserId());
            ppmDataCtrl = this.getDAModelStorage().FindDEDataCtrl("DE0025", (ISRFDAWebContext)this.getWebContext());
            if (ppmDataCtrl == null) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"DE0025"));
                return false;
            }
            callResult = ppmDataCtrl.Save(true, (BaseDataEntity)this.ppmodel);
            if (callResult.getRetCode() != 0) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u4fdd\u5b58\u7528\u6237\u95e8\u6237\u9875\u9762\u6a21\u578b\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
                return false;
            }
            IDEDataCtrl ppmwebpartDataCtrl = this.getDAModelStorage().FindDEDataCtrl("DE0026", (ISRFDAWebContext)this.getWebContext());
            if (ppmwebpartDataCtrl == null) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"DE0026"));
                return false;
            }
            for (WebPart webPart : this.webParts) {
                PPMWebPart ppmWebPart = new PPMWebPart();
                webPart.CopyTo((BaseDataEntity)ppmWebPart, true);
                ppmWebPart.setPPMWEBPARTID("");
                ppmWebPart.setPPMODELID(this.ppmodel.getPPMODELID());
                callResult = ppmwebpartDataCtrl.Save(true, (BaseDataEntity)ppmWebPart);
                if (callResult.getRetCode() == 0) continue;
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u4fdd\u5b58\u7528\u6237\u95e8\u6237\u9875\u9762\u6a21\u578b\u660e\u7ec6\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
        }
        if (!StringHelper.IsNullOrEmpty((String)this.strPPModel)) {
            if (StringHelper.Compare((String)this.strPPModel, (String)this.ppmodel.getPPMODEL(), (boolean)true) != 0) {
                ppmDataCtrl = this.getDAModelStorage().FindDEDataCtrl("DE0025", (ISRFDAWebContext)this.getWebContext());
                if (ppmDataCtrl == null) {
                    this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"DE0025"));
                    return false;
                }
                this.ppmodel.setPPMODEL(this.strPPModel);
                callResult = ppmDataCtrl.Save(false, (BaseDataEntity)this.ppmodel);
                if (callResult.getRetCode() != 0) {
                    this.PageLog((Object)this, 1, StringHelper.Format((String)"\u4fdd\u5b58\u7528\u6237\u95e8\u6237\u9875\u9762\u6a21\u578b\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    return false;
                }
            }
        } else {
            this.strPPModel = this.ppmodel.getPPMODEL();
        }
        if (StringHelper.IsNullOrEmpty((String)this.strPPModel)) {
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u95e8\u6237\u9875\u9762\u6a21\u578b\u914d\u7f6e\u65e0\u6548"));
            return false;
        }
        int nIndex = 0;
        String[] ppmodels = this.strPPModel.split("[;]");
        int i = 0;
        while (i < ppmodels.length) {
            if (!StringHelper.IsNullOrEmpty((String)ppmodels[i])) {
                String strValue = ppmodels[i];
                Object objValue = DataTypeParse.TestInteger((String)(strValue = strValue.replaceAll("[%]", "")));
                if (objValue != null) {
                    this.ppmodelMap.put(nIndex, (Integer)objValue);
                    this.ppmWebPartMap.put(nIndex, new Vector());
                    ++nIndex;
                }
            }
            ++i;
        }
        if (this.ppmodelMap.size() == 0) {
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u95e8\u6237\u9875\u9762\u6a21\u578b\u914d\u7f6e\u65e0\u6548\uff0c\u65e0\u6cd5\u5206\u6790\u51fa\u6a21\u578b\u4fe1\u606f"));
            return false;
        }
        for (WebPart webPart : this.webParts) {
            int nColumnId = webPart.getCOLUMNID();
            Vector<WebPart> columnWebParts = null;
            columnWebParts = this.ppmWebPartMap.containsKey(nColumnId) ? this.ppmWebPartMap.get(nColumnId) : this.ppmWebPartMap.get(0);
            columnWebParts.add(webPart);
        }
        return true;
    }

    public String GetPPModelId() {
        return this.ppmodel.getPPMODELID();
    }

    public String GetAddWebPartLink() {
        String strLink = SRFDAWebUtil.OutputPageLink((PageContext)this.pageContext, (String)"PAGE_00008");
        strLink = URLHelper.AppendURLSeperator((String)strLink);
        TreeMap<String, String> params = new TreeMap<String, String>();
        params.put("SRFPPNAME", this.getWebContext().getSRFPPNAME());
        params.put("PPMODELID", this.GetPPModelId());
        strLink = String.valueOf(strLink) + URLHelper.GetQueryString(params);
        return strLink;
    }

    protected void OnInitComponents() {
        super.OnInitComponents();
        this.LoadPPStyleDDL();
        this.webPartMap = new TreeMap();
        for (WebPart webPart : this.webParts) {
            if (this.webPartMap.containsKey(webPart.getWEBPARTID())) continue;
            String strType = webPart.getWEBPARTTYPE();
            SRFExControl webPartControl = null;
            if (StringHelper.Compare((String)strType, (String)"CHART", (boolean)true) == 0) {
                webPartControl = this.GetChartWebPart(webPart);
                if (webPartControl == null) {
                    this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u5efa\u7acb\u56fe\u50cf\u90e8\u4ef6[%1$s]", (Object)webPart.getWEBPARTID()));
                    continue;
                }
                this.webPartMap.put(webPart.getWEBPARTID(), (SRFExControl)webPartControl);
                continue;
            }
            if (StringHelper.Compare((String)strType, (String)"LIST", (boolean)true) == 0) {
                webPartControl = this.GetListWebPart(webPart);
                if (webPartControl == null) {
                    this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u5efa\u7acb\u5217\u8868\u90e8\u4ef6[%1$s]", (Object)webPart.getWEBPARTID()));
                    continue;
                }
                this.webPartMap.put(webPart.getWEBPARTID(), (SRFExControl)webPartControl);
            }
            if (StringHelper.Compare((String)strType, (String)"CUSTOMWP", (boolean)true) != 0) continue;
            webPartControl = this.GetCustomWP(webPart);
            if (webPartControl == null) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u5efa\u7acb\u81ea\u5b9a\u4e49\u7f51\u9875\u90e8\u4ef6[%1$s]", (Object)webPart.getWEBPARTID()));
                continue;
            }
            this.webPartMap.put(webPart.getWEBPARTID(), (SRFExControl)webPartControl);
        }
    }

    protected void LoadPPStyleDDL() {
        this.ddlPortalPageStyle.InitConfig();
        this.ddlPortalPageStyle.setID("ddlPortalPageStyle");
        this.ddlPortalPageStyle.getDropDownListConfig().setWidth(125);
        this.ddlPortalPageStyle.getListControlConfig().getListFillerConfig().setCodeList("SRFWEB.CODELIST_PORTALPAGESTYLE");
        this.AddControl((SRFExControl)this.ddlPortalPageStyle);
        this.ddlPortalPageStyle.getDropDownListConfig().setSelectedValue(this.strPPModel);
        String strURL = ".." + this.getCurPagePath() + "?" + this.getWebContext().GetQueryStringWithout("PPMODEL");
        strURL = URLHelper.AppendURLSeperator((String)strURL);
        strURL = String.valueOf(strURL) + "PPMODEL";
        strURL = String.valueOf(strURL) + "=";
        StringBuilderEx script = new StringBuilderEx();
        script.Append("var _V=Ext.getDom('%1$s').value;\r\n", (Object)this.ddlPortalPageStyle.getUniqueID());
        script.Append("if(_V==undefined || _V=='')return;\r\n");
        script.Append("window.location.href='%1$s'+encodeURIComponent(_V);\r\n", (Object)strURL);
        this.getPage().RegisterOnReadyScript(3, StringHelper.Format((String)"Ext.get('%1$s').on('change',function(){%2$s});", (Object)this.ddlPortalPageStyle.getUniqueID(), (Object)script.toString()));
    }

    public String RenderWebParts() {
        StringBuilderEx output = new StringBuilderEx();
        StringBuilderEx output2 = new StringBuilderEx();
        for (WebPart webPart : this.webParts) {
            String strWebPartId = webPart.getWEBPARTID();
            SRFExControl webPartControl = this.webPartMap.get(strWebPartId);
            if (webPartControl == null) continue;
            StyleBuilder styleBuilder = new StyleBuilder();
            if (webPartControl instanceof SRFExRemotePanel) {
                if (webPart.getHEIGHT() > 0) {
                    styleBuilder.AddStyle("height", StringHelper.Format((String)"%1$spx", (Object)webPart.getHEIGHT()));
                    styleBuilder.AddStyle("overflow", "auto");
                }
            } else if (webPartControl instanceof SRFExChart) {
                styleBuilder.AddStyle("overflow", "auto");
            }
            styleBuilder.AddStyle("display", "none");
            styleBuilder.AddStyle("text-align", "center");
            output.Append("<DIV id='C_%1$s' style='%2$s'>", (Object)webPartControl.getUniqueID(), (Object)styleBuilder.ToStyleList());
            webPartControl.Render(output.getWriter());
            output.Append("</DIV>");
            output2.Append("Ext.getDom('C_%1$s').style.display='';\r\n", (Object)webPartControl.getUniqueID());
        }
        this.strDIVVisibleCode = output2.toString();
        return output.toString();
    }

    public String RenderWebPartsVisble() {
        return this.strDIVVisibleCode;
    }

    protected SRFExChart GetChartWebPart(WebPart webPart) {
        SRFExChart chart = new SRFExChart();
        ChartConfig chartConfig = new ChartConfig();
        chartConfig.setChartStyle(webPart.getPARAM());
        chartConfig.setWidth(webPart.getWIDTH());
        chartConfig.setHeight(webPart.getHEIGHT());
        chartConfig.setGridPos(webPart.getUSERDATA7());
        chartConfig.setGridHeight(webPart.getUSERDATA5());
        chartConfig.setGridWidth(webPart.getUSERDATA6());
        chartConfig.setSPExConfigId(webPart.getUSERDATA8());
        String strDataURL = StringHelper.Format((String)"../srfpage/chartdatabackend.jsp?SRFCHARTID=%1$s&SRFCHARTTYPE=%2$s", (Object)webPart.getWEBPARTID(), (Object)webPart.getPARAM());
        if (this.bEnableCTX) {
            strDataURL = URLHelper.AppendURLSeperator((String)strDataURL);
            strDataURL = String.valueOf(strDataURL) + this.getWebContext().GetQueryStringWithout("SRFCHARTID|SRFCHARTTYPE");
        }
        chartConfig.setDataURL(strDataURL);
        chart.setConfig((XMLConfig)chartConfig);
        chart.setID(webPart.getWEBPARTID());
        this.AddControl((SRFExControl)chart);
        chart.getChartConfig().setContainer("C_" + chart.getUniqueID());
        return chart;
    }

    protected SRFExControl GetCustomWP(WebPart webPart) {
        if (StringHelper.IsNullOrEmpty((String)webPart.getPARAM())) {
            SRFExRaw raw = new SRFExRaw();
            raw.InitConfig();
            raw.setID(webPart.getWEBPARTID());
            raw.setValue(webPart.getPARAM3());
            this.AddControl((SRFExControl)raw);
            return raw;
        }
        if (webPart.getPARAM4() == 1) {
            SRFExIFrame iFrame = new SRFExIFrame();
            iFrame.InitConfig();
            iFrame.setID(webPart.getWEBPARTID());
            if (webPart.getWIDTH() > 0) {
                iFrame.getIFrameConfig().setWidth(webPart.getWIDTH());
            } else {
                iFrame.getIFrameConfig().setWidth(1);
            }
            if (webPart.getHEIGHT() > 0) {
                iFrame.getIFrameConfig().setHeight(webPart.getHEIGHT());
            } else {
                iFrame.getIFrameConfig().setHeight(1);
            }
            iFrame.getIFrameConfig().setScroll("no");
            String strDataURL = webPart.getPARAM();
            if (this.bEnableCTX) {
                strDataURL = URLHelper.AppendURLSeperator((String)strDataURL);
                strDataURL = String.valueOf(strDataURL) + this.getWebContext().GetQueryString();
            }
            iFrame.getIFrameConfig().setURL(strDataURL);
            this.AddControl((SRFExControl)iFrame);
            this.RegisterOnReadyScript(2, StringHelper.Format((String)"$P.iframe['%1$s']='%1$s';", (Object)iFrame.getUniqueID()));
            return iFrame;
        }
        SRFExRemotePanel list = new SRFExRemotePanel();
        list.InitConfig();
        list.setID(webPart.getWEBPARTID());
        list.getRemotePanelConfig().setWidth(webPart.getWIDTH());
        list.getRemotePanelConfig().setHeight(webPart.getHEIGHT());
        String strDataURL = webPart.getPARAM();
        if (this.bEnableCTX) {
            strDataURL = URLHelper.AppendURLSeperator((String)strDataURL);
            strDataURL = String.valueOf(strDataURL) + this.getWebContext().GetQueryString();
        }
        list.getRemotePanelConfig().setRemoteURL(strDataURL);
        if (webPart.getREFRESHTIME() != 0) {
            list.getRemotePanelConfig().setAutoRefresh(webPart.getREFRESHTIME());
        }
        this.AddControl((SRFExControl)list);
        list.getRemotePanelConfig().setContainer("C_" + list.getUniqueID());
        return list;
    }

    protected SRFExRemotePanel GetListWebPart(WebPart webPart) {
        SRFExRemotePanel list = new SRFExRemotePanel();
        list.InitConfig();
        list.setID(webPart.getWEBPARTID());
        list.getRemotePanelConfig().setWidth(webPart.getWIDTH());
        list.getRemotePanelConfig().setHeight(webPart.getHEIGHT());
        list.getRemotePanelConfig().setScripts(false);
        if (webPart.getREFRESHTIME() != 0) {
            list.getRemotePanelConfig().setAutoRefresh(webPart.getREFRESHTIME());
        }
        String strDataURL = StringHelper.Format((String)"../srfpage/listdatabackend.jsp?SRFLISTID=%1$s&SRFLISTTYPE=%2$s", (Object)webPart.getWEBPARTID(), (Object)webPart.getPARAM());
        if (this.bEnableCTX) {
            strDataURL = URLHelper.AppendURLSeperator((String)strDataURL);
            strDataURL = String.valueOf(strDataURL) + this.getWebContext().GetQueryStringWithout("SRFLISTID|SRFLISTTYPE");
        }
        list.getRemotePanelConfig().setRemoteURL(strDataURL);
        this.AddControl((SRFExControl)list);
        list.getRemotePanelConfig().setContainer("C_" + list.getUniqueID());
        return list;
    }

    public String RenderPortlets(int nColumn) {
        StringBuilderEx output = new StringBuilderEx();
        boolean bFirst = true;
        Vector<WebPart> columnWebParts = null;
        if (!this.ppmWebPartMap.containsKey(nColumn)) {
            return "";
        }
        columnWebParts = this.ppmWebPartMap.get(nColumn);
        for (WebPart webPart : columnWebParts) {
            String strWebPartId = webPart.getWEBPARTID();
            SRFExControl webPartControl = this.webPartMap.get(strWebPartId);
            if (webPartControl == null) continue;
            if (bFirst) {
                bFirst = false;
            } else {
                output.Append(",");
            }
            output.Append("{");
            output.Append("id:'%1$s',", (Object)strWebPartId);
            output.Append("title:'%1$s',", (Object)this.GetLocalization(webPart.getCAPLANRESID(), webPart.getWEBPARTNAME()));
            output.Append("tools:tools,");
            output.Append("contentEl:'C_%1$s'", (Object)webPartControl.getUniqueID());
            output.Append("}");
            this.webPartMap.remove(strWebPartId);
        }
        return output.toString();
    }

    public int GetPPMColumnCount() {
        return this.ppmodelMap.size();
    }

    public int GetPPMColumnWidth(int nIndex) {
        return this.ppmodelMap.get(nIndex);
    }

    @Override
    protected boolean OnFillPageModel(JSONObject jsonObject) {
        if (!super.OnFillPageModel(jsonObject)) {
            return false;
        }
        jsonObject.put("addwebpartlink", (Object)this.GetAddWebPartLink());
        jsonObject.put("ppmodelid", (Object)this.ppmodel.getPPMODELID());
        jsonObject.put("ppmodeldetail", (Object)this.ppmodel.getPPMODELDETAIL());
        jsonObject.put("enablectx", this.ppmodel.getENABLECTX());
        jsonObject.put("lockedflag", this.bLockedFlag);
        return true;
    }
}
