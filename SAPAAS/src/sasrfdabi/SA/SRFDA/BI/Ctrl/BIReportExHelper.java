/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.BI.Ctrl;

import SA.SRFDA.BI.Ctrl.BICubeCacheCondition;
import SA.SRFDA.BI.Ctrl.BIRepDMHelper;
import SA.SRFDA.BI.Ctrl.BIRepMSHelper;
import SA.SRFDA.BI.Ctrl.BIRepRPHelper;
import SA.SRFDA.BI.Ctrl.BaseBIObject;
import SA.SRFDA.BI.Ctrl.Data.BIRepDM;
import SA.SRFDA.BI.Ctrl.Data.BIRepMS;
import SA.SRFDA.BI.Ctrl.Data.BIRepRP;
import SA.SRFDA.BI.Ctrl.Data.BIReportEx;
import SA.SRFDA.BI.Ctrl.IBICubeCache;
import SA.SRFDA.BI.Ctrl.IBICubeHelper;
import SA.SRFDA.BI.Ctrl.IBIRepDMHelper;
import SA.SRFDA.BI.Ctrl.IBIRepMSHelper;
import SA.SRFDA.BI.Ctrl.IBIRepRPHelper;
import SA.SRFDA.BI.Ctrl.IBIReportExHelper;
import SA.SRFDA.BI.Ctrl.Model.BIReportExModel;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import net.sf.json.JSONObject;

public class BIReportExHelper
extends BaseBIObject
implements IBIReportExHelper {
    protected IBICubeHelper biCubeHelper = null;
    protected BIReportEx biReportEx = null;
    protected JSONObject biReportExModelJson = null;
    protected Vector<IBIRepDMHelper> repDimensions = new Vector();
    protected Vector<IBIRepMSHelper> repMeasures = new Vector();
    protected Vector<IBIRepDMHelper> leftDimensions = new Vector();
    protected Vector<IBIRepDMHelper> topDimensions = new Vector();
    protected Vector<IBIRepRPHelper> repPanels = new Vector();

    @Override
    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, IBICubeHelper biCubeHelper, BIReportEx biReportEx) throws Exception {
        this.iDAGlobalHelper = iDAGlobalHelper;
        this.biCubeHelper = biCubeHelper;
        this.biReportEx = biReportEx;
        this.OnPrepareRepDimensions();
        this.OnPrepareRepMeasures();
        this.OnPrepareRepPanels();
        this.OnInit();
    }

    protected void OnPrepareRepDimensions() throws Exception {
        Vector<BIRepDM> list = new Vector<BIRepDM>();
        CallResult callResult = this.getBIModelHelper().GetBIRepDMs(this.biReportEx.getBIREPORTEXID(), list);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u62a5\u8868\u5f15\u7528\u7ef4\u5ea6\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        for (BIRepDM biRepDM : list) {
            IBIRepDMHelper iBIRepDMHelper = this.OnCreateBIRepDMHelper(biRepDM);
            iBIRepDMHelper.Init(this.iDAGlobalHelper, this, biRepDM);
            this.repDimensions.add(iBIRepDMHelper);
            if (StringHelper.Compare((String)iBIRepDMHelper.getPlacement(), (String)"ROWHEADER", (boolean)true) == 0) {
                this.leftDimensions.add(iBIRepDMHelper);
                continue;
            }
            if (StringHelper.Compare((String)iBIRepDMHelper.getPlacement(), (String)"COLHEADER", (boolean)true) != 0) continue;
            this.topDimensions.add(iBIRepDMHelper);
        }
    }

    protected IBIRepDMHelper OnCreateBIRepDMHelper(BIRepDM biRepDM) throws Exception {
        return new BIRepDMHelper();
    }

    protected void OnPrepareRepMeasures() throws Exception {
        Vector<BIRepMS> list = new Vector<BIRepMS>();
        CallResult callResult = this.getBIModelHelper().GetBIRepMSs(this.biReportEx.getBIREPORTEXID(), list);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u62a5\u8868\u5f15\u7528\u7ef4\u5ea6\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        for (BIRepMS biRepMS : list) {
            IBIRepMSHelper iBIRepMSHelper = this.OnCreateBIRepMSHelper(biRepMS);
            iBIRepMSHelper.Init(this.iDAGlobalHelper, this, biRepMS);
            this.repMeasures.add(iBIRepMSHelper);
        }
    }

    protected IBIRepMSHelper OnCreateBIRepMSHelper(BIRepMS biRepMS) throws Exception {
        return new BIRepMSHelper();
    }

    protected void OnPrepareRepPanels() throws Exception {
        Vector<BIRepRP> list = new Vector<BIRepRP>();
        CallResult callResult = this.getBIModelHelper().GetBIRepRPs(this.biReportEx.getBIREPORTEXID(), list);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u62a5\u8868\u5f15\u7528\u9762\u677f\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        for (BIRepRP biRepRP : list) {
            IBIRepRPHelper iBIRepRPHelper = this.OnCreateBIRepRPHelper(biRepRP);
            iBIRepRPHelper.Init(this.iDAGlobalHelper, this, biRepRP);
            this.repPanels.add(iBIRepRPHelper);
        }
    }

    protected IBIRepRPHelper OnCreateBIRepRPHelper(BIRepRP biRepRP) throws Exception {
        return new BIRepRPHelper();
    }

    protected void OnPrepareRepModel() {
    }

    protected void OnInit() throws Exception {
    }

    @Override
    public BIReportEx getBIReportEx() {
        return this.biReportEx;
    }

    @Override
    public Vector<IBIRepDMHelper> getDimensions() {
        return this.repDimensions;
    }

    @Override
    public Vector<IBIRepMSHelper> getMeasures() {
        return this.repMeasures;
    }

    @Override
    public String getId() {
        return this.biReportEx.getBIREPORTEXID();
    }

    @Override
    public int getVersion() {
        return this.biReportEx.getVERSION();
    }

    @Override
    public String getLogicName(String strLanguage) {
        return this.biReportEx.getBIREPORTEXNAME();
    }

    @Override
    public String getDescription(String strLanguage) {
        return this.biReportEx.getDESCRIPTION();
    }

    @Override
    public IBICubeHelper getBICube() {
        return this.biCubeHelper;
    }

    @Override
    public Vector<IBIRepDMHelper> getLeftDimensions() {
        return this.leftDimensions;
    }

    @Override
    public Vector<IBIRepDMHelper> getTopDimensions() {
        return this.topDimensions;
    }

    @Override
    public Vector<IBIRepRPHelper> getRelatedPanels() {
        return this.repPanels;
    }

    @Override
    public int getPageSize(int nDefault) {
        if (this.biReportEx.getPAGESIZE() <= 0) {
            return nDefault;
        }
        return this.biReportEx.getPAGESIZE();
    }

    @Override
    public boolean isShowMeasureGroup() {
        if (this.biReportEx.isENABLEMSGROUPNull()) {
            return true;
        }
        return this.biReportEx.getENABLEMSGROUP();
    }

    @Override
    public JSONObject getBIReportExModel() throws Exception {
        if (this.biReportExModelJson != null) {
            return this.biReportExModelJson;
        }
        BIReportExModel biReportExModel = new BIReportExModel();
        biReportExModel.Init(this, null, "TABLE", true);
        this.biReportExModelJson = biReportExModel.ToJSONObject();
        return this.biReportExModelJson;
    }

    @Override
    public void GetPovitTableRowDimensionDataInfo(IBICubeCache iBICubeCache, Vector<BaseDataEntity> datas) throws Exception {
        for (IBIRepDMHelper iBIRepDMHelper : this.leftDimensions) {
            if (!iBICubeCache.hasBIHierarchyFilter(iBIRepDMHelper.getBIHierarchy().getUniqueName())) continue;
            Vector<BaseDataEntity> biHierarchyDatas = iBICubeCache.getBIHierarchyDatas(iBIRepDMHelper.getBIHierarchy().getUniqueName());
            BaseDataEntity data = new BaseDataEntity();
            data.SetParamValue("BIHierarchy", (Object)iBIRepDMHelper.getBIHierarchy().getUniqueName());
            data.SetParamValue("Count", (Object)biHierarchyDatas.size());
            datas.add(data);
        }
    }

    @Override
    public void GetChartRowDimensionDataInfo(IBICubeCache iBICubeCache, Vector<BaseDataEntity> datas, BICubeCacheCondition extCondition) throws Exception {
        BaseDataEntity data;
        Vector<BaseDataEntity> biHierarchyDatas;
        String strExtCondition;
        for (IBIRepDMHelper iBIRepDMHelper : this.leftDimensions) {
            if (!iBICubeCache.hasBIHierarchyFilter(iBIRepDMHelper.getBIHierarchy().getUniqueName())) continue;
            strExtCondition = "";
            if (extCondition != null && extCondition.hasCondition(iBIRepDMHelper.getBIHierarchy().getUniqueName())) {
                strExtCondition = extCondition.getCondition(iBIRepDMHelper.getBIHierarchy().getUniqueName());
            }
            biHierarchyDatas = iBICubeCache.getBIHierarchyDatas(iBIRepDMHelper.getBIHierarchy().getUniqueName(), strExtCondition);
            data = new BaseDataEntity();
            data.SetParamValue("BIHierarchy", (Object)iBIRepDMHelper.getBIHierarchy().getUniqueName());
            data.SetParamValue("Count", (Object)biHierarchyDatas.size());
            datas.add(data);
        }
        for (IBIRepDMHelper iBIRepDMHelper : this.topDimensions) {
            if (!iBICubeCache.hasBIHierarchyFilter(iBIRepDMHelper.getBIHierarchy().getUniqueName())) continue;
            strExtCondition = "";
            if (extCondition != null && extCondition.hasCondition(iBIRepDMHelper.getBIHierarchy().getUniqueName())) {
                strExtCondition = extCondition.getCondition(iBIRepDMHelper.getBIHierarchy().getUniqueName());
            }
            biHierarchyDatas = iBICubeCache.getBIHierarchyDatas(iBIRepDMHelper.getBIHierarchy().getUniqueName(), strExtCondition);
            data = new BaseDataEntity();
            data.SetParamValue("BIHierarchy", (Object)iBIRepDMHelper.getBIHierarchy().getUniqueName());
            data.SetParamValue("Count", (Object)biHierarchyDatas.size());
            datas.add(data);
        }
    }
}

