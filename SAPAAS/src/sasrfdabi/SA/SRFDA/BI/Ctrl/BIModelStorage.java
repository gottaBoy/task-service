/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.BI.Ctrl;

import SA.SRFDA.BI.Ctrl.BICatalogGlobalModel;
import SA.SRFDA.BI.Ctrl.BICatalogHelper;
import SA.SRFDA.BI.Ctrl.BICubeGlobalModel;
import SA.SRFDA.BI.Ctrl.BICubeHelper;
import SA.SRFDA.BI.Ctrl.BIRepChartGlobalModel;
import SA.SRFDA.BI.Ctrl.BIRepChartHelper;
import SA.SRFDA.BI.Ctrl.BIRepFITypeGlobalModel;
import SA.SRFDA.BI.Ctrl.BIRepFITypeHelper;
import SA.SRFDA.BI.Ctrl.BIRepFilterGlobalModel;
import SA.SRFDA.BI.Ctrl.BIRepFilterHelper;
import SA.SRFDA.BI.Ctrl.BIRepPLGlobalModel;
import SA.SRFDA.BI.Ctrl.BIRepPLHelper;
import SA.SRFDA.BI.Ctrl.BIRepPTGlobalModel;
import SA.SRFDA.BI.Ctrl.BIRepPTHelper;
import SA.SRFDA.BI.Ctrl.BIRepPanelGlobalModel;
import SA.SRFDA.BI.Ctrl.BIRepPanelHelper;
import SA.SRFDA.BI.Ctrl.BIRepPartGlobalModel;
import SA.SRFDA.BI.Ctrl.BIReportExGlobalModel;
import SA.SRFDA.BI.Ctrl.Data.BICatalog;
import SA.SRFDA.BI.Ctrl.Data.BICube;
import SA.SRFDA.BI.Ctrl.Data.BIRepChart;
import SA.SRFDA.BI.Ctrl.Data.BIRepFIType;
import SA.SRFDA.BI.Ctrl.Data.BIRepFilter;
import SA.SRFDA.BI.Ctrl.Data.BIRepPL;
import SA.SRFDA.BI.Ctrl.Data.BIRepPT;
import SA.SRFDA.BI.Ctrl.Data.BIRepPanel;
import SA.SRFDA.BI.Ctrl.Data.BIRepPart;
import SA.SRFDA.BI.Ctrl.Data.BIReportEx;
import SA.SRFDA.BI.Ctrl.IBICatalogHelper;
import SA.SRFDA.BI.Ctrl.IBICubeHelper;
import SA.SRFDA.BI.Ctrl.IBIModelStorage;
import SA.SRFDA.BI.Ctrl.IBIRepChartHelper;
import SA.SRFDA.BI.Ctrl.IBIRepFITypeHelper;
import SA.SRFDA.BI.Ctrl.IBIRepFilterHelper;
import SA.SRFDA.BI.Ctrl.IBIRepPLHelper;
import SA.SRFDA.BI.Ctrl.IBIRepPTHelper;
import SA.SRFDA.BI.Ctrl.IBIRepPanelHelper;
import SA.SRFDA.BI.Ctrl.IBIRepPartHelper;
import SA.SRFDA.BI.Ctrl.IBIReportExHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import java.util.Hashtable;

public class BIModelStorage
implements IBIModelStorage {
    protected ISRFDAGlobalHelper iDAGlobalHelper = null;
    protected BICatalogGlobalModel biCatalogGlobalModel = new BICatalogGlobalModel();
    protected BICubeGlobalModel biCubeGlobalModel = new BICubeGlobalModel();
    protected BIReportExGlobalModel biReportExGlobalModel = new BIReportExGlobalModel();
    protected BIRepPanelGlobalModel biRepPanelGlobalModel = new BIRepPanelGlobalModel();
    protected BIRepPTGlobalModel biRepPTGlobalModel = new BIRepPTGlobalModel();
    protected BIRepPartGlobalModel biRepPartGlobalModel = new BIRepPartGlobalModel();
    protected BIRepChartGlobalModel biRepChartGlobalModel = new BIRepChartGlobalModel();
    protected BIRepFilterGlobalModel biRepFilterGlobalModel = new BIRepFilterGlobalModel();
    protected BIRepPLGlobalModel biRepPLGlobalModel = new BIRepPLGlobalModel();
    protected BIRepFITypeGlobalModel biRepFITypeGlobalModel = new BIRepFITypeGlobalModel();
    protected Hashtable<String, IBICubeHelper> biCubeHelperMap = new Hashtable();
    protected Hashtable<String, IBICatalogHelper> biCatalogHelperMap = new Hashtable();
    protected Hashtable<String, IBIRepPTHelper> biRepPTHelperMap = new Hashtable();
    protected Hashtable<String, IBIRepPanelHelper> biRepPanelHelperMap = new Hashtable();
    protected Hashtable<String, IBIRepChartHelper> biRepChartHelperMap = new Hashtable();
    protected Hashtable<String, IBIRepFilterHelper> biRepFilterHelperMap = new Hashtable();
    protected Hashtable<String, IBIRepPLHelper> biRepPLHelperMap = new Hashtable();
    protected Hashtable<String, IBIRepFITypeHelper> biRepFITypeHelperMap = new Hashtable();

    @Override
    public void Init(ISRFDAGlobalHelper iDAGlobalHelper) throws Exception {
        this.iDAGlobalHelper = iDAGlobalHelper;
        this.biCubeGlobalModel.Init(iDAGlobalHelper);
        this.biReportExGlobalModel.Init(iDAGlobalHelper);
        this.biCatalogGlobalModel.Init(iDAGlobalHelper);
        this.biRepPanelGlobalModel.Init(iDAGlobalHelper);
        this.biRepPTGlobalModel.Init(iDAGlobalHelper);
        this.biRepPartGlobalModel.Init(iDAGlobalHelper);
        this.biRepChartGlobalModel.Init(iDAGlobalHelper);
        this.biRepFilterGlobalModel.Init(iDAGlobalHelper);
        this.biRepPLGlobalModel.Init(iDAGlobalHelper);
        this.biRepFITypeGlobalModel.Init(iDAGlobalHelper);
        this.OnInit();
    }

    protected void OnInit() {
    }

    @Override
    public IBICubeHelper FindBICube(String strBICubeId) throws Exception {
        Object objBICube = this.biCubeGlobalModel.FindModel(strBICubeId);
        if (objBICube == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5206\u6790\u7acb\u65b9\u4f53[%1$s]", (Object)strBICubeId));
        }
        BICube biCube = (BICube)((Object)objBICube);
        IBICubeHelper iBICubeHelper = this.biCubeHelperMap.get(strBICubeId);
        if (iBICubeHelper != null && iBICubeHelper.getVersion() == biCube.getVERSION()) {
            return iBICubeHelper;
        }
        iBICubeHelper = this.OnCreateBICubeHelper(biCube);
        iBICubeHelper.Init(this.iDAGlobalHelper, biCube);
        this.biCubeHelperMap.put(strBICubeId, iBICubeHelper);
        return iBICubeHelper;
    }

    protected IBICubeHelper OnCreateBICubeHelper(BICube biCube) throws Exception {
        return new BICubeHelper();
    }

    @Override
    public IBIReportExHelper FindBIReportEx(String strBIReportExId) throws Exception {
        Object objBIReportEx = this.biReportExGlobalModel.FindModel(strBIReportExId);
        if (objBIReportEx == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5206\u6790\u7acb\u65b9\u4f53\u62a5\u8868[%1$s]", (Object)strBIReportExId));
        }
        BIReportEx biReportEx = (BIReportEx)((Object)objBIReportEx);
        IBICubeHelper biCubeHelper = this.FindBICube(biReportEx.getBICUBEID());
        return biCubeHelper.FindBIReportEx(biReportEx);
    }

    @Override
    public IBICatalogHelper FindBICatalog(String strBICatalogId) throws Exception {
        Object objBICatalog = this.biCatalogGlobalModel.FindModel(strBICatalogId);
        if (objBICatalog == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5206\u6790\u6570\u636e\u5e93[%1$s]", (Object)strBICatalogId));
        }
        BICatalog biCatalog = (BICatalog)((Object)objBICatalog);
        IBICatalogHelper iBICatalogHelper = this.biCatalogHelperMap.get(strBICatalogId);
        if (iBICatalogHelper != null && iBICatalogHelper.getVersion() == biCatalog.getVERSION()) {
            return iBICatalogHelper;
        }
        iBICatalogHelper = this.OnCreateBICatalogHelper(biCatalog);
        iBICatalogHelper.Init(this.iDAGlobalHelper, biCatalog);
        this.biCatalogHelperMap.put(strBICatalogId, iBICatalogHelper);
        return iBICatalogHelper;
    }

    protected IBICatalogHelper OnCreateBICatalogHelper(BICatalog biCatalog) throws Exception {
        return new BICatalogHelper();
    }

    @Override
    public IBIRepPanelHelper FindBIRepPanel(String strBIRepPanelId) throws Exception {
        Object objBIRepPanel = this.biRepPanelGlobalModel.FindModel(strBIRepPanelId);
        if (objBIRepPanel == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5206\u6790\u62a5\u8868\u9762\u677f[%1$s]", (Object)strBIRepPanelId));
        }
        BIRepPanel biRepPanel = (BIRepPanel)((Object)objBIRepPanel);
        if (StringHelper.IsNullOrEmpty((String)biRepPanel.getBIREPPTID())) {
            IBIRepPanelHelper iBIRepPanelHelper = this.biRepPanelHelperMap.get(biRepPanel.getBIREPPANELID());
            if (iBIRepPanelHelper != null && iBIRepPanelHelper.getVersion() == biRepPanel.getVERSION()) {
                return iBIRepPanelHelper;
            }
            iBIRepPanelHelper = this.OnCreateBIRepPanelHelper(biRepPanel);
            iBIRepPanelHelper.Init(this.iDAGlobalHelper, null, biRepPanel);
            this.biRepPanelHelperMap.put(biRepPanel.getBIREPPANELID(), iBIRepPanelHelper);
            return iBIRepPanelHelper;
        }
        IBIRepPTHelper biRepPTHelper = this.FindBIRepPT(biRepPanel.getBIREPPTID());
        return biRepPTHelper.FindBIRepPanel(biRepPanel);
    }

    protected IBIRepPanelHelper OnCreateBIRepPanelHelper(BIRepPanel biRepPanel) throws Exception {
        return new BIRepPanelHelper();
    }

    @Override
    public IBIRepPTHelper FindBIRepPT(String strBIRepPTId) throws Exception {
        Object objBIRepPT = this.biRepPTGlobalModel.FindModel(strBIRepPTId);
        if (objBIRepPT == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5206\u6790\u6570\u636e\u5e93[%1$s]", (Object)strBIRepPTId));
        }
        BIRepPT biRepPT = (BIRepPT)((Object)objBIRepPT);
        IBIRepPTHelper iBIRepPTHelper = this.biRepPTHelperMap.get(strBIRepPTId);
        if (iBIRepPTHelper != null && iBIRepPTHelper.getVersion() == biRepPT.getVERSION()) {
            return iBIRepPTHelper;
        }
        iBIRepPTHelper = this.OnCreateBIRepPTHelper(biRepPT);
        iBIRepPTHelper.Init(this.iDAGlobalHelper, biRepPT);
        this.biRepPTHelperMap.put(strBIRepPTId, iBIRepPTHelper);
        return iBIRepPTHelper;
    }

    protected IBIRepPTHelper OnCreateBIRepPTHelper(BIRepPT biRepPT) throws Exception {
        return new BIRepPTHelper();
    }

    @Override
    public IBIRepPartHelper FindBIRepPart(String strBIRepPartId) throws Exception {
        Object objBIRepPart = this.biRepPartGlobalModel.FindModel(strBIRepPartId);
        if (objBIRepPart == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5206\u6790\u62a5\u8868\u90e8\u4ef6[%1$s]", (Object)strBIRepPartId));
        }
        BIRepPart biRepPart = (BIRepPart)((Object)objBIRepPart);
        if (StringHelper.Compare((String)biRepPart.getBIREPPARTTYPE(), (String)"PANEL", (boolean)true) == 0) {
            return this.FindBIRepPanel(biRepPart.getBIREPPARTID());
        }
        if (StringHelper.Compare((String)biRepPart.getBIREPPARTTYPE(), (String)"CHART", (boolean)true) == 0) {
            return this.FindBIRepChart(biRepPart.getBIREPPARTID());
        }
        if (StringHelper.Compare((String)biRepPart.getBIREPPARTTYPE(), (String)"FILTER", (boolean)true) == 0) {
            return this.FindBIRepFilter(biRepPart.getBIREPPARTID());
        }
        throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u8bc6\u522b\u5206\u6790\u62a5\u8868\u90e8\u4ef6[%1$s]\u7c7b\u578b[%2$s]", (Object)strBIRepPartId, (Object)biRepPart.getBIREPPARTTYPE()));
    }

    public IBIRepChartHelper FindBIRepChart(String strBIRepChartId) throws Exception {
        Object objBIRepChart = this.biRepChartGlobalModel.FindModel(strBIRepChartId);
        if (objBIRepChart == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5206\u6790\u62a5\u8868\u56fe\u5f62[%1$s]", (Object)strBIRepChartId));
        }
        BIRepChart biRepChart = (BIRepChart)((Object)objBIRepChart);
        IBIRepChartHelper iBIRepChartHelper = this.biRepChartHelperMap.get(biRepChart.getBIREPCHARTID());
        if (iBIRepChartHelper != null && iBIRepChartHelper.getVersion() == biRepChart.getVERSION()) {
            return iBIRepChartHelper;
        }
        iBIRepChartHelper = this.OnCreateBIRepChartHelper(biRepChart);
        iBIRepChartHelper.Init(this.iDAGlobalHelper, biRepChart);
        this.biRepChartHelperMap.put(biRepChart.getBIREPCHARTID(), iBIRepChartHelper);
        return iBIRepChartHelper;
    }

    protected IBIRepChartHelper OnCreateBIRepChartHelper(BIRepChart biRepChart) throws Exception {
        return new BIRepChartHelper();
    }

    public IBIRepFilterHelper FindBIRepFilter(String strBIRepFilterId) throws Exception {
        Object objBIRepFilter = this.biRepFilterGlobalModel.FindModel(strBIRepFilterId);
        if (objBIRepFilter == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5206\u6790\u62a5\u8868\u8fc7\u6ee4\u5668[%1$s]", (Object)strBIRepFilterId));
        }
        BIRepFilter biRepFilter = (BIRepFilter)((Object)objBIRepFilter);
        IBIRepFilterHelper iBIRepFilterHelper = this.biRepFilterHelperMap.get(biRepFilter.getBIREPFILTERID());
        if (iBIRepFilterHelper != null && iBIRepFilterHelper.getVersion() == biRepFilter.getVERSION()) {
            return iBIRepFilterHelper;
        }
        iBIRepFilterHelper = this.OnCreateBIRepFilterHelper(biRepFilter);
        iBIRepFilterHelper.Init(this.iDAGlobalHelper, biRepFilter);
        this.biRepFilterHelperMap.put(biRepFilter.getBIREPFILTERID(), iBIRepFilterHelper);
        return iBIRepFilterHelper;
    }

    protected IBIRepFilterHelper OnCreateBIRepFilterHelper(BIRepFilter biRepFilter) throws Exception {
        return new BIRepFilterHelper();
    }

    @Override
    public IBIRepPLHelper FindBIRepPL(String strBIRepPLId) throws Exception {
        Object objBIRepPL = this.biRepPLGlobalModel.FindModel(strBIRepPLId);
        if (objBIRepPL == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5206\u6790\u62a5\u8868\u90e8\u4ef6\u903b\u8f91[%1$s]", (Object)strBIRepPLId));
        }
        BIRepPL biRepPL = (BIRepPL)((Object)objBIRepPL);
        IBIRepPLHelper iBIRepPLHelper = this.biRepPLHelperMap.get(biRepPL.getBIREPPLID());
        if (iBIRepPLHelper != null) {
            return iBIRepPLHelper;
        }
        iBIRepPLHelper = this.OnCreateBIRepPLHelper(biRepPL);
        iBIRepPLHelper.Init(this.iDAGlobalHelper, biRepPL);
        this.biRepPLHelperMap.put(biRepPL.getBIREPPLID(), iBIRepPLHelper);
        return iBIRepPLHelper;
    }

    protected IBIRepPLHelper OnCreateBIRepPLHelper(BIRepPL biRepPL) throws Exception {
        return new BIRepPLHelper();
    }

    @Override
    public IBIRepFITypeHelper FindBIRepFIType(String strBIRepFITypeId) throws Exception {
        Object objBIRepFIType = this.biRepFITypeGlobalModel.FindModel(strBIRepFITypeId);
        if (objBIRepFIType == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5206\u6790\u62a5\u8868\u8fc7\u6ee4\u5668\u9879\u7c7b\u578b[%1$s]", (Object)strBIRepFITypeId));
        }
        BIRepFIType biRepFIType = (BIRepFIType)((Object)objBIRepFIType);
        IBIRepFITypeHelper iBIRepFITypeHelper = this.biRepFITypeHelperMap.get(biRepFIType.getBIREPFITYPEID());
        if (iBIRepFITypeHelper != null) {
            return iBIRepFITypeHelper;
        }
        iBIRepFITypeHelper = this.OnCreateBIRepFITypeHelper(biRepFIType);
        iBIRepFITypeHelper.Init(this.iDAGlobalHelper, biRepFIType);
        this.biRepFITypeHelperMap.put(biRepFIType.getBIREPFITYPEID(), iBIRepFITypeHelper);
        return iBIRepFITypeHelper;
    }

    protected IBIRepFITypeHelper OnCreateBIRepFITypeHelper(BIRepFIType biRepFIType) throws Exception {
        return new BIRepFITypeHelper();
    }
}

