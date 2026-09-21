/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.Chart;

import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartAxes;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartCoordinateSystem;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartCoordinateSystemRuntime;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartDataSet;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartRuntime;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartSeriesEncode;
import SA.SRFDA.PS.Core.Control.Chart.IPSDEChart;
import SA.SRFDA.PS.Core.Control.Chart.IPSDEChartAxes;
import SA.SRFDA.PS.Core.Control.Chart.IPSDEChartSeries;
import SA.SRFDA.PS.Core.Control.Chart.IPSDEChartSeriesEncodeRuntime;
import SA.SRFDA.PS.Core.Control.Chart.PSChartSeriesImpl;
import SA.SRFDA.PS.Core.Control.Chart.PSDEChartDataSetImpl;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.DynaModel.IPSSysDynaModel;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PF.IPSPFCtrlPartCodeObject;
import SA.SRFDA.PS.Core.PF.IPSPFXCodeObject;
import SA.SRFDA.PS.Core.PF.PSPFXCodeObjectProxy;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysPFPluginTempl;
import SA.SRFDA.PS.Data.PSDEChartCS;
import SA.SRFDA.PS.Data.PSDEChartDataSetField;
import SA.SRFDA.PS.Data.PSDEChartSeries;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEChartSeriesImpl
extends PSChartSeriesImpl
implements IPSDEChartSeries,
IPSPFCtrlPartCodeObject {
    private static final Log log = LogFactory.getLog(PSDEChartSeriesImpl.class);
    private PSDEChartSeries psDEChartSeries;
    private String strCatalogField = null;
    private String strValueField = null;
    private String strValue2Field = null;
    private String strValue3Field = null;
    private String strValue4Field = null;
    private String strValue5Field = null;
    private String strValue6Field = null;
    private String strSeriesField = null;
    private String strTimeGroupMode = null;
    private String strDataField = null;
    private String strTagField = null;
    private IPSDEChartAxes xPSDEChartAxes = null;
    private IPSDEChartAxes yPSDEChartAxes = null;
    private IPSCodeList seriesPSCodeList = null;
    private IPSCodeList catalogPSCodeList = null;
    private String strCaption = null;
    private IPSLanguageRes capPSLanguageRes = null;
    private IPSChartCoordinateSystem iPSChartCoordinateSystem = null;
    private IPSSysPFPlugin iPSSysPFPlugin = null;
    private IPSChartDataSet iPSChartDataSet = null;
    private IPSPFXCodeObject iPSPFXCodeObject = null;
    private String strSeriesLayoutBy = "column";
    private IPSChartSeriesEncode iPSChartSeriesEncode = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEChart iPSDEChart, PSDEChartSeries psDEChartSeries) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSDEChart(iPSDEChart);
            this.psDEChartSeries = psDEChartSeries;
            this.setId(this.psDEChartSeries.getPSDECHARTPARAMID());
            this.setName(this.psDEChartSeries.getPSDECHARTPARAMNAME());
            this.setPSObjectData(this.psDEChartSeries);
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEChartSeries.getXFIELD())) {
                this.strCatalogField = this.psDEChartSeries.getXFIELD();
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEChartSeries.getYFIELD())) {
                this.strValueField = this.psDEChartSeries.getYFIELD();
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEChartSeries.getZFIELD())) {
                this.strValue2Field = this.psDEChartSeries.getZFIELD();
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEChartSeries.getEXTFIELD())) {
                this.strValue3Field = this.psDEChartSeries.getEXTFIELD();
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEChartSeries.getEXTFIELD2())) {
                this.strValue4Field = this.psDEChartSeries.getEXTFIELD2();
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEChartSeries.getEXTFIELD3())) {
                this.strValue5Field = this.psDEChartSeries.getEXTFIELD3();
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEChartSeries.getEXTFIELD4())) {
                this.strValue6Field = this.psDEChartSeries.getEXTFIELD4();
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEChartSeries.getSERIESFIELD())) {
                this.strSeriesField = this.psDEChartSeries.getSERIESFIELD();
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEChartSeries.getTAGFIELD())) {
                this.strTagField = this.psDEChartSeries.getTAGFIELD();
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEChartSeries.getDATAFIELD())) {
                this.strDataField = this.psDEChartSeries.getDATAFIELD();
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEChartSeries.getXPSDECHARTAXESID())) {
                this.xPSDEChartAxes = this.getPSDEChart().getPSDEChartAxes(this.psDEChartSeries.getXPSDECHARTAXESID());
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEChartSeries.getYPSDECHARTAXESID())) {
                this.yPSDEChartAxes = this.getPSDEChart().getPSDEChartAxes(this.psDEChartSeries.getYPSDECHARTAXESID());
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEChartSeries.getTIMEGROUP())) {
                this.strTimeGroupMode = this.psDEChartSeries.getTIMEGROUP();
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEChartSeries.getSFPSCODELISTID())) {
                this.seriesPSCodeList = this.getPSDEChart().getPSAppView().getPSApplication().getPSAppCodeList(this.psDEChartSeries.getSFPSCODELISTID(), true);
                if (this.seriesPSCodeList == null) {
                    this.seriesPSCodeList = this.getPSDEChart().getPSDataEntity().getPSSystem().getPSCodeList(this.psDEChartSeries.getSFPSCODELISTID());
                }
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEChartSeries.getXFPSCODELISTID())) {
                this.catalogPSCodeList = this.getPSDEChart().getPSAppView().getPSApplication().getPSAppCodeList(this.psDEChartSeries.getXFPSCODELISTID(), true);
                if (this.catalogPSCodeList == null) {
                    this.catalogPSCodeList = this.getPSDEChart().getPSDataEntity().getPSSystem().getPSCodeList(this.psDEChartSeries.getXFPSCODELISTID());
                }
            }
            this.strCaption = this.psDEChartSeries.getCAPTION();
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEChartSeries.getCAPPSLANRESID())) {
                this.capPSLanguageRes = this.getPSDEChart().getPSAppView().getPSApplication().getPSLanguageRes(this.psDEChartSeries.getCAPPSLANRESID());
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEChartSeries.getSERIESLAYOUTBY())) {
                this.strSeriesLayoutBy = this.psDEChartSeries.getSERIESLAYOUTBY();
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEChartSeries.getPSSYSPFPLUGINID())) {
                this.iPSSysPFPlugin = iPSDEChart.getPSAppView().getPSSystem().getPSSysPFPlugin(this.psDEChartSeries.getPSSYSPFPLUGINID());
                iPSDEChart.getPSAppView().registerPSSysPFPlugin(this.iPSSysPFPlugin);
            }
            if (this.getPSSysPFPlugin() != null) {
                String strPSSysPFPluginTemplId = KeyValueHelper.genUniqueId((String)this.getPSSysPFPlugin().getId(), (String)this.getPSApplication().getPSPF().getId());
                IPSSysPFPluginTempl iPSSysPFPluginTempl = this.getPSApplication().getPSSystem().getPSSysPFPluginTempl(strPSSysPFPluginTemplId, true);
                if (iPSSysPFPluginTempl != null) {
                    HashMap<String, Object> params = new HashMap<String, Object>();
                    params.put("app", this.getPSApplication());
                    this.iPSPFXCodeObject = new PSPFXCodeObjectProxy(iPSSysPFPluginTempl, (Object)this.getPSDEChart().getPSAppView(), (Object)this.getPSDEChart(), (Object)this, params);
                }
            }
            this.onInit();
        }
        catch (Exception ex) {
            this.throwCriticalInitException(ex);
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            if (this.getPSSystemUtil() != null) {
                this.getPSSystemUtil().getPSSysConsole().error(strLogName, strExInfo);
            }
            this.throwInitException(ex);
        }
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.initNavParams(this.psDEChartSeries);
        if (SA.SRFramework.Utility.StringHelper.Compare((String)this.getPSSystemUtil().getTemplEngineVer(), (String)"V2", (boolean)true) == 0) {
            IPSChartSeriesEncode iPSChartSeriesEncode;
            Iterator<? extends IPSChartCoordinateSystem> psChartCoordinateSystem;
            String strCoordinateSystem;
            if (this.isEnableChartDataSet() && this.getPSDEChart().getPSDEDataSet() != null) {
                PSDEChartDataSetField psDEChartDataSetField;
                PSDEChartDataSetImpl psDEChartDataSetImpl = new PSDEChartDataSetImpl();
                psDEChartDataSetImpl.init(this.getDAGlobalHelper(), this, this.getPSDEChart().getPSDEDataSet());
                this.getPSEChartsRuntime().registerPSChartDataSet(psDEChartDataSetImpl);
                this.setPSChartDataSet(psDEChartDataSetImpl);
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getCatalogField())) {
                    psDEChartDataSetField = new PSDEChartDataSetField();
                    psDEChartDataSetField.setPSDECHARTDATASETFIELDID(this.getCatalogField());
                    psDEChartDataSetField.setPSDECHARTDATASETFIELDNAME(this.getCatalogField());
                    psDEChartDataSetField.setPSCODELISTID(this.psDEChartSeries.getXFPSCODELISTID());
                    psDEChartDataSetField.setPSCODELISTNAME(this.psDEChartSeries.getXFPSCODELISTNAME());
                    psDEChartDataSetField.setGROUPFIELD(true);
                    psDEChartDataSetField.setGROUPMODE(this.getGroupMode());
                    psDEChartDataSetImpl.registerPSDEChartDataSetField(psDEChartDataSetField);
                }
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getSeriesField())) {
                    psDEChartDataSetField = new PSDEChartDataSetField();
                    psDEChartDataSetField.setPSDECHARTDATASETFIELDID(this.getSeriesField());
                    psDEChartDataSetField.setPSDECHARTDATASETFIELDNAME(this.getSeriesField());
                    psDEChartDataSetField.setPSCODELISTID(this.psDEChartSeries.getSFPSCODELISTID());
                    psDEChartDataSetField.setPSCODELISTNAME(this.psDEChartSeries.getSFPSCODELISTNAME());
                    psDEChartDataSetField.setGROUPFIELD(true);
                    psDEChartDataSetImpl.registerPSDEChartDataSetField(psDEChartDataSetField);
                }
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getIdField())) {
                    psDEChartDataSetField = new PSDEChartDataSetField();
                    psDEChartDataSetField.setPSDECHARTDATASETFIELDID(this.getIdField());
                    psDEChartDataSetField.setPSDECHARTDATASETFIELDNAME(this.getIdField());
                    psDEChartDataSetField.setGROUPFIELD(true);
                    psDEChartDataSetImpl.registerPSDEChartDataSetField(psDEChartDataSetField);
                }
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getValueField())) {
                    psDEChartDataSetField = new PSDEChartDataSetField();
                    psDEChartDataSetField.setPSDECHARTDATASETFIELDID(this.getValueField());
                    psDEChartDataSetField.setPSDECHARTDATASETFIELDNAME(this.getValueField());
                    psDEChartDataSetImpl.registerPSDEChartDataSetField(psDEChartDataSetField);
                }
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getExtValueField())) {
                    psDEChartDataSetField = new PSDEChartDataSetField();
                    psDEChartDataSetField.setPSDECHARTDATASETFIELDID(this.getExtValueField());
                    psDEChartDataSetField.setPSDECHARTDATASETFIELDNAME(this.getExtValueField());
                    psDEChartDataSetImpl.registerPSDEChartDataSetField(psDEChartDataSetField);
                }
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getExtValue2Field())) {
                    psDEChartDataSetField = new PSDEChartDataSetField();
                    psDEChartDataSetField.setPSDECHARTDATASETFIELDID(this.getExtValue2Field());
                    psDEChartDataSetField.setPSDECHARTDATASETFIELDNAME(this.getExtValue2Field());
                    psDEChartDataSetImpl.registerPSDEChartDataSetField(psDEChartDataSetField);
                }
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getExtValue3Field())) {
                    psDEChartDataSetField = new PSDEChartDataSetField();
                    psDEChartDataSetField.setPSDECHARTDATASETFIELDID(this.getExtValue3Field());
                    psDEChartDataSetField.setPSDECHARTDATASETFIELDNAME(this.getExtValue3Field());
                    psDEChartDataSetImpl.registerPSDEChartDataSetField(psDEChartDataSetField);
                }
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getExtValue4Field())) {
                    psDEChartDataSetField = new PSDEChartDataSetField();
                    psDEChartDataSetField.setPSDECHARTDATASETFIELDID(this.getExtValue4Field());
                    psDEChartDataSetField.setPSDECHARTDATASETFIELDNAME(this.getExtValue4Field());
                    psDEChartDataSetImpl.registerPSDEChartDataSetField(psDEChartDataSetField);
                }
            }
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)(strCoordinateSystem = this.psDEChartSeries.getCOORDINATESYSTEM()))) {
                strCoordinateSystem = this.getDefaultCoordinateSystem();
            }
            int nCoordinateSystem = -1;
            if (SA.SRFramework.Utility.StringHelper.Compare((String)strCoordinateSystem, (String)"NONE", (boolean)false) != 0 && !this.psDEChartSeries.isCOORDINATESYSTEMIDNull()) {
                nCoordinateSystem = this.psDEChartSeries.getCOORDINATESYSTEMID();
            }
            IPSChartCoordinateSystem dstPSChartCoordinateSystem = null;
            if (nCoordinateSystem != -1) {
                psChartCoordinateSystem = this.getPSDEChart().getPSChartCoordinateSystems();
                if (psChartCoordinateSystem != null) {
                    while (psChartCoordinateSystem.hasNext()) {
                        IPSChartCoordinateSystem iPSChartCoordinateSystem = psChartCoordinateSystem.next();
                        if (nCoordinateSystem != iPSChartCoordinateSystem.getIndex()) continue;
                        dstPSChartCoordinateSystem = iPSChartCoordinateSystem;
                        break;
                    }
                }
            } else {
                psChartCoordinateSystem = this.getPSDEChart().getPSChartCoordinateSystems();
                if (psChartCoordinateSystem != null) {
                    while (psChartCoordinateSystem.hasNext()) {
                        IPSChartCoordinateSystem iPSChartCoordinateSystem = psChartCoordinateSystem.next();
                        if (SA.SRFramework.Utility.StringHelper.Compare((String)strCoordinateSystem, (String)iPSChartCoordinateSystem.getType(), (boolean)false) != 0 || !this.testPSChartCoordinateSystem(iPSChartCoordinateSystem) || !((IPSChartCoordinateSystemRuntime)((Object)iPSChartCoordinateSystem)).testPSChartSeries(this)) continue;
                        dstPSChartCoordinateSystem = iPSChartCoordinateSystem;
                        break;
                    }
                }
            }
            if (dstPSChartCoordinateSystem == null) {
                PSDEChartCS csData = new PSDEChartCS();
                csData.set("COORDINATESYSTEM", strCoordinateSystem);
                csData.set("PSDECHARTPARAMNAME", this.getName());
                csData.set("INDEX", nCoordinateSystem);
                csData.set("PSSYSPFPLUGINID", this.psDEChartSeries.getCSPSSYSPFPLUGINID());
                csData.set("PSSYSPFPLUGINNAME", this.psDEChartSeries.getCSPSSYSPFPLUGINNAME());
                csData.set("PSSYSDYNAMODELID", this.psDEChartSeries.getCSPSSYSDYNAMODELID());
                csData.set("PSSYSDYNAMODELNAME", this.psDEChartSeries.getCSPSSYSDYNAMODELNAME());
                csData.set("LEFTPOS", this.psDEChartSeries.getLEFTPOS());
                csData.set("TOPPOS", this.psDEChartSeries.getTOPPOS());
                csData.set("BOTTOMPOS", this.psDEChartSeries.getBOTTOMPOS());
                csData.set("RIGHTPOS", this.psDEChartSeries.getRIGHTPOS());
                csData.set("WIDTH", this.psDEChartSeries.getWIDTH());
                csData.set("HEIGHT", this.psDEChartSeries.getHEIGHT());
                dstPSChartCoordinateSystem = this.getPSChartRuntime().createPSChartCoordinateSystem(csData);
            }
            if (dstPSChartCoordinateSystem != null) {
                if (!this.testPSChartCoordinateSystem(dstPSChartCoordinateSystem)) {
                    throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u56fe\u8868\u5750\u6807\u7cfb\u7edf[%1$s]\u4e0d\u652f\u6301\u5f53\u524d\u5e8f\u5217\u7c7b\u578b[%2$s-%3$s]", (Object)dstPSChartCoordinateSystem.getType(), (Object)this.getSeriesType(), (Object)this.getEChartsType()));
                }
                this.iPSChartCoordinateSystem = dstPSChartCoordinateSystem;
                ((IPSChartCoordinateSystemRuntime)((Object)this.iPSChartCoordinateSystem)).registerPSChartSeries(this);
            }
            if (this.getPSChartCoordinateSystem() != null && (iPSChartSeriesEncode = ((IPSChartCoordinateSystemRuntime)((Object)this.getPSChartCoordinateSystem())).createPSChartSeriesEncode()) != null && iPSChartSeriesEncode instanceof IPSDEChartSeriesEncodeRuntime) {
                ((IPSDEChartSeriesEncodeRuntime)((Object)iPSChartSeriesEncode)).init(this.getDAGlobalHelper(), this);
                this.iPSChartSeriesEncode = iPSChartSeriesEncode;
            }
        }
    }

    protected PSDEChartSeries getPSDEChartSeriesData() {
        return this.psDEChartSeries;
    }

    @Override
    @PSModelRTMeta(description="\u6807\u9898", fields={"CAPTION"})
    public String getCaption() {
        return this.strCaption;
    }

    @Override
    @PSModelRTMeta(description="\u56fe\u5f62\u7c7b\u578b", codelist="ChartType", fields={"CHARTTYPE"})
    public String getSeriesType() {
        return this.psDEChartSeries.getCHARTTYPE();
    }

    @Override
    @PSModelRTMeta(description="\u5206\u7c7b\u5c5e\u6027", fields={"XFIELD"})
    public String getCatalogField() {
        return this.strCatalogField;
    }

    @Override
    @PSModelRTMeta(description="\u503c\u5c5e\u6027", fields={"YFIELD"})
    public String getValueField() {
        return this.strValueField;
    }

    @Override
    @PSModelRTMeta(description="\u5e8f\u5217\u6807\u8bc6\u5c5e\u6027", fields={"ZFIELD"})
    public String getIdField() {
        return this.strValue2Field;
    }

    @Override
    public String getValue2Field() {
        return this.strValue2Field;
    }

    @Override
    public IPSChartAxes getXPSChartAxes() {
        return this.getXPSDEChartAxes();
    }

    @Override
    public IPSChartAxes getYPSChartAxes() {
        return this.getYPSDEChartAxes();
    }

    @Override
    public IPSDEChartAxes getXPSDEChartAxes() {
        return this.xPSDEChartAxes;
    }

    @Override
    public IPSDEChartAxes getYPSDEChartAxes() {
        return this.yPSDEChartAxes;
    }

    @Override
    @PSModelRTMeta(description="\u5e8f\u5217\u540d\u79f0\u5c5e\u6027", fields={"SERIESFIELD"})
    public String getSeriesField() {
        return this.strSeriesField;
    }

    @Override
    public String getTimeGroupMode() {
        return this.strTimeGroupMode;
    }

    @Override
    public String getValue3Field() {
        return this.strValue3Field;
    }

    @Override
    public String getValue4Field() {
        return this.strValue4Field;
    }

    @Override
    public String getValue5Field() {
        return this.strValue5Field;
    }

    @Override
    public String getValue6Field() {
        return this.strValue6Field;
    }

    @Override
    @PSModelRTMeta(description="\u5e8f\u5217\u4ee3\u7801\u8868\u5bf9\u8c61", hideempty2=true, dumpref=true, fields={"SFPSCODELISTID"})
    public IPSCodeList getSeriesPSCodeList() {
        return this.seriesPSCodeList;
    }

    @Override
    @PSModelRTMeta(description="\u5206\u7c7b\u4ee3\u7801\u8868\u5bf9\u8c61", hideempty2=true, dumpref=true, fields={"XFPSCODELISTID"})
    public IPSCodeList getCatalogPSCodeList() {
        return this.catalogPSCodeList;
    }

    @Override
    @PSModelRTMeta(description="\u6807\u9898\u8bed\u8a00\u8d44\u6e90\u5bf9\u8c61", hideempty2=true, fields={"CAPPSLANRESID"})
    public IPSLanguageRes getCapPSLanguageRes() {
        return this.capPSLanguageRes;
    }

    @Override
    public String getCapLanResTag() {
        if (this.getCapPSLanguageRes() == null) {
            return null;
        }
        return this.getCapPSLanguageRes().getLanResTag();
    }

    @Override
    public String getModelType() {
        return "PSDECHARTPARAM";
    }

    @Override
    public String getModelId() {
        return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s#%2$s", (Object)this.getPSDEChart().getModelId(), (Object)this.getName());
    }

    @Override
    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSDEChart().getPSAppView().getPSSystem());
    }

    @Override
    @PSModelRTMeta(description="\u793a\u4f8b\u6570\u636e", fields={"SAMPLEDATA"})
    public String getSampleData() {
        return this.psDEChartSeries.getSAMPLEDATA();
    }

    @Override
    public String getNavDataType() {
        return this.getSeriesType();
    }

    @Override
    public IPSControl getOwnedPSControl() {
        return this.getPSDEChart();
    }

    @Override
    @PSModelRTMeta(description="ECharts\u5e8f\u5217\u7c7b\u578b", codelist="ChartType")
    public String getEChartsType() {
        return this.onGetEChartsType();
    }

    protected String onGetEChartsType() {
        return this.getSeriesType();
    }

    protected IPSChartRuntime getPSChartRuntime() {
        return (IPSChartRuntime)((Object)this.getPSDEChart());
    }

    protected String getDefaultCoordinateSystem() throws Exception {
        return "NONE";
    }

    protected boolean testPSChartCoordinateSystem(IPSChartCoordinateSystem iPSChartCoordinateSystem) throws Exception {
        return true;
    }

    @Override
    @PSModelRTMeta(description="\u56fe\u8868\u5750\u6807\u7cfb\u7edf", dumpref=true, from="IPSDEChart")
    public IPSChartCoordinateSystem getPSChartCoordinateSystem() {
        return this.iPSChartCoordinateSystem;
    }

    @Override
    @PSModelRTMeta(description="\u524d\u7aef\u6210\u5458\u7c7b\u578b", dump=false)
    public String getPFPartCodeType() {
        return SA.SRFramework.Utility.StringHelper.Format((String)"SERIES_%1$s", (Object)this.getEChartsType().toUpperCase());
    }

    @Override
    @PSModelRTMeta(description="\u524d\u7aef\u6269\u5c55\u63d2\u4ef6")
    public IPSSysPFPlugin getPSSysPFPlugin() {
        return this.iPSSysPFPlugin;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u56fe\u8868\u6570\u636e\u96c6")
    public boolean isEnableChartDataSet() {
        return this.onGetEnableChartDataSet();
    }

    protected boolean onGetEnableChartDataSet() {
        return false;
    }

    @Override
    @PSModelRTMeta(description="\u56fe\u8868\u6570\u636e\u96c6\u5bf9\u8c61", hideempty=true, dumpref=true, from="IPSDEChart")
    public IPSChartDataSet getPSChartDataSet() {
        return this.iPSChartDataSet;
    }

    public void setPSChartDataSet(IPSChartDataSet iPSChartDataSet) {
        this.iPSChartDataSet = iPSChartDataSet;
    }

    @Override
    @PSModelRTMeta(description="\u7ed8\u5236\u63d2\u4ef6")
    public IPSPFXCodeObject getRender() {
        return this.iPSPFXCodeObject;
    }

    @Override
    @PSModelRTMeta(description="\u7ed3\u679c\u96c6\u884c\u5217\u6a21\u5f0f", fields={"SERIESLAYOUTBY"})
    public String getSeriesLayoutBy() {
        return this.strSeriesLayoutBy;
    }

    @Override
    @PSModelRTMeta(description="\u56fe\u8868\u5e8f\u5217\u7f16\u7801", child=true)
    public IPSChartSeriesEncode getPSChartSeriesEncode() {
        return this.iPSChartSeriesEncode;
    }

    @Override
    @PSModelRTMeta(description="\u6269\u5c55\u503c\u5c5e\u6027", fields={"EXTFIELD"})
    public String getExtValueField() {
        return this.strValue3Field;
    }

    @Override
    @PSModelRTMeta(description="\u6269\u5c55\u503c2\u5c5e\u6027", fields={"EXTFIELD2"})
    public String getExtValue2Field() {
        return this.strValue4Field;
    }

    @Override
    @PSModelRTMeta(description="\u6269\u5c55\u503c3\u5c5e\u6027", fields={"EXTFIELD3"})
    public String getExtValue3Field() {
        return this.strValue5Field;
    }

    @Override
    @PSModelRTMeta(description="\u6269\u5c55\u503c4\u5c5e\u6027", fields={"EXTFIELD4"})
    public String getExtValue4Field() {
        return this.strValue6Field;
    }

    @Override
    @PSModelRTMeta(description="\u503c\u5c5e\u6027", fields={"DATAFIELD"})
    public String getDataField() {
        return this.strDataField;
    }

    @Override
    @PSModelRTMeta(description="\u6807\u8bb0\u5c5e\u6027", fields={"TAGFIELD"})
    public String getTagField() {
        return this.strTagField;
    }

    @Override
    @PSModelRTMeta(description="\u5206\u7ec4\u6a21\u5f0f", codelist="ChartSeriesGroupMode", fields={"TIMEGROUP"})
    public String getGroupMode() {
        return this.getTimeGroupMode();
    }

    @Override
    @PSModelRTMeta(description="\u57fa\u7840\u914d\u7f6eJson\u5185\u5bb9")
    public String getBaseOptionJOString() {
        if (this.getPSDynaModel() != null) {
            return ((IPSSysDynaModel)this.getPSDynaModel()).getJOString();
        }
        return null;
    }

    @Override
    public String getLogicName() {
        return null;
    }
}

