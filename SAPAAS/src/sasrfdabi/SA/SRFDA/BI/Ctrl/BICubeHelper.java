/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 */
package SA.SRFDA.BI.Ctrl;

import SA.SRFDA.BI.Ctrl.BIDimensionHelper;
import SA.SRFDA.BI.Ctrl.BIReportExHelper;
import SA.SRFDA.BI.Ctrl.BaseBIObject;
import SA.SRFDA.BI.Ctrl.Data.BICube;
import SA.SRFDA.BI.Ctrl.Data.BICubeDimension;
import SA.SRFDA.BI.Ctrl.Data.BICubeMeasure;
import SA.SRFDA.BI.Ctrl.Data.BIDimension;
import SA.SRFDA.BI.Ctrl.Data.BIDimensionRef;
import SA.SRFDA.BI.Ctrl.Data.BIHierarchyFilter;
import SA.SRFDA.BI.Ctrl.Data.BIReportEx;
import SA.SRFDA.BI.Ctrl.IBICatalogHelper;
import SA.SRFDA.BI.Ctrl.IBICubeHelper;
import SA.SRFDA.BI.Ctrl.IBICubeMeasureHelper;
import SA.SRFDA.BI.Ctrl.IBIDimensionHelper;
import SA.SRFDA.BI.Ctrl.IBIHierarchyHelper;
import SA.SRFDA.BI.Ctrl.IBIReportExHelper;
import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import java.util.Hashtable;
import java.util.Vector;

public class BICubeHelper
extends BaseBIObject
implements IBICubeHelper {
    protected BICube biCube = null;
    protected Hashtable<String, IBIReportExHelper> biReportExHelperMap = new Hashtable();
    protected Vector<IBIDimensionHelper> biDimensionHelpers = new Vector();
    protected Vector<IBICubeMeasureHelper> biCubeMeasureHelpers = new Vector();
    protected Hashtable<String, IBICubeMeasureHelper> biCubeMeasureMap = new Hashtable();
    protected Hashtable<String, IBIDimensionHelper> biCubeDimensionMap = new Hashtable();
    protected Hashtable<String, IDEFHelper> biCubeDMJoinDEFMap = new Hashtable();
    protected IBICatalogHelper iBICataLogHelper = null;
    protected IDEHelper iBICubeDEHelper = null;

    @Override
    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, BICube biCube) throws Exception {
        this.iDAGlobalHelper = iDAGlobalHelper;
        this.biCube = biCube;
        this.iBICataLogHelper = this.getBIModelStorage().FindBICatalog(this.biCube.getBICATALOGID());
        this.iBICubeDEHelper = iDAGlobalHelper.getDAModelStorage().FindDEHelper(biCube.getDEID());
        if (this.iBICubeDEHelper == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5206\u6790\u7acb\u65b9\u4f53\u7ed1\u5b9a\u5b9e\u4f53[%1$s]", (Object)biCube.getDEID()));
        }
        this.OnPrepareDimensions();
        this.OnPrepareMeasures();
        this.OnInit();
    }

    protected void OnPrepareDimensions() throws Exception {
        Vector<BICubeDimension> biCubeDimensions = new Vector<BICubeDimension>();
        CallResult callResult = this.getBIModelHelper().GetBICubeDimensions(this.getId(), biCubeDimensions);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u5206\u6790\u7acb\u65b9\u4f53\u7ef4\u5ea6\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        IDEDataCtrl biDimensionDataCtrl = this.iDAGlobalHelper.getDAModelStorage().FindDEDataCtrl("BI0003", "SYSTEM", null);
        if (biDimensionDataCtrl == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"BI0003"));
        }
        IDEDataCtrl biDimensionRefDataCtrl = this.iDAGlobalHelper.getDAModelStorage().FindDEDataCtrl("BI0004", "SYSTEM", null);
        if (biDimensionRefDataCtrl == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"BI0004"));
        }
        int nShortIdIndex = 100;
        for (BICubeDimension biCubeDimension : biCubeDimensions) {
            IDEFHelper iDEFHelper;
            String strDEFHelperId;
            IBIDimensionHelper iBIDimensionHelper;
            if (StringHelper.Compare((String)biCubeDimension.getBICUBEDIMENSIONTYPE(), (String)"REF", (boolean)true) == 0) {
                BIDimensionRef biDimensionRef = new BIDimensionRef();
                biDimensionRef.setBIDIMENSIONREFID(biCubeDimension.getBICUBEDIMENSIONID());
                callResult = biDimensionRefDataCtrl.Get((BaseDataEntity)biDimensionRef);
                if (callResult.IsError()) {
                    throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u591a\u7ef4\u5206\u6790\u7acb\u65b9\u4f53\u5f15\u7528\u7ef4\u5ea6[%1$s]\u5931\u8d25\uff0c%2$s", (Object)biCubeDimension.getBICUBEDIMENSIONID(), (Object)callResult.getErrorInfo()));
                }
                iBIDimensionHelper = this.iBICataLogHelper.FindBIDimension(biDimensionRef.getBIDIMENSIONID());
                this.biDimensionHelpers.add(iBIDimensionHelper);
                this.biCubeDimensionMap.put(biCubeDimension.getBICUBEDIMENSIONID(), iBIDimensionHelper);
                strDEFHelperId = biDimensionRef.getJOINDEFID();
                if (StringHelper.IsNullOrEmpty((String)strDEFHelperId)) continue;
                iDEFHelper = this.iBICubeDEHelper.GetDEFHelper(strDEFHelperId);
                if (iDEFHelper == null) {
                    throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u7ef4\u5ea6\u94fe\u63a5\u5c5e\u6027[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)strDEFHelperId));
                }
                this.biCubeDMJoinDEFMap.put(biCubeDimension.getBICUBEDIMENSIONID(), iDEFHelper);
                this.biCubeDMJoinDEFMap.put(biDimensionRef.getBIDIMENSIONID(), iDEFHelper);
                continue;
            }
            ++nShortIdIndex;
            BIDimension biDimension = new BIDimension();
            biDimension.setBIDIMENSIONID(biCubeDimension.getBICUBEDIMENSIONID());
            callResult = biDimensionDataCtrl.Get((BaseDataEntity)biDimension);
            if (callResult.IsError()) {
                throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u591a\u7ef4\u5206\u6790\u7acb\u65b9\u4f53\u7ef4\u5ea6[%1$s]\u5931\u8d25\uff0c%2$s", (Object)biCubeDimension.getBICUBEDIMENSIONID(), (Object)callResult.getErrorInfo()));
            }
            iBIDimensionHelper = this.OnCreateBIDimensionHelper(biDimension);
            iBIDimensionHelper.setShortId(StringHelper.Format((String)"D%1$s", (Object)nShortIdIndex));
            iBIDimensionHelper.Init(this.iDAGlobalHelper, biDimension);
            this.biDimensionHelpers.add(iBIDimensionHelper);
            this.biCubeDimensionMap.put(biCubeDimension.getBICUBEDIMENSIONID(), iBIDimensionHelper);
            strDEFHelperId = biDimension.getJOINDEFID();
            if (StringHelper.IsNullOrEmpty((String)strDEFHelperId)) continue;
            iDEFHelper = this.iBICubeDEHelper.GetDEFHelper(strDEFHelperId);
            if (iDEFHelper == null) {
                throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u7ef4\u5ea6\u94fe\u63a5\u5c5e\u6027[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)strDEFHelperId));
            }
            this.biCubeDMJoinDEFMap.put(biCubeDimension.getBICUBEDIMENSIONID(), iDEFHelper);
        }
    }

    protected IBIDimensionHelper OnCreateBIDimensionHelper(BIDimension biDimension) throws Exception {
        return new BIDimensionHelper();
    }

    protected void OnPrepareMeasures() throws Exception {
        IBICubeMeasureHelper iBICubeMeasureHelper;
        Vector<BICubeMeasure> biCubeMeasures = new Vector<BICubeMeasure>();
        CallResult callResult = this.getBIModelHelper().GetBICubeMeasures(this.getId(), biCubeMeasures);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u5206\u6790\u7acb\u65b9\u4f53\u7ef4\u5ea6\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        int nShortIdIndex = 0;
        for (BICubeMeasure biCubeMeasure : biCubeMeasures) {
            if (StringHelper.Compare((String)biCubeMeasure.getBICUBEMEASURETYPE(), (String)"NORMAL", (boolean)true) != 0) continue;
            iBICubeMeasureHelper = this.OnCreateBICubeMeasureHelper(biCubeMeasure);
            iBICubeMeasureHelper.setShortId(StringHelper.Format((String)"M%1$s", (Object)(++nShortIdIndex)));
            iBICubeMeasureHelper.Init(this.iDAGlobalHelper, this, biCubeMeasure);
            this.biCubeMeasureHelpers.add(iBICubeMeasureHelper);
            this.biCubeMeasureMap.put(biCubeMeasure.getBICUBEMEASUREID(), iBICubeMeasureHelper);
            this.biCubeMeasureMap.put(iBICubeMeasureHelper.getUniqueName(), iBICubeMeasureHelper);
        }
        for (BICubeMeasure biCubeMeasure : biCubeMeasures) {
            if (StringHelper.Compare((String)biCubeMeasure.getBICUBEMEASURETYPE(), (String)"CALCULATED", (boolean)true) != 0) continue;
            iBICubeMeasureHelper = this.OnCreateBICubeMeasureHelper(biCubeMeasure);
            iBICubeMeasureHelper.setShortId(StringHelper.Format((String)"M%1$s", (Object)(++nShortIdIndex)));
            iBICubeMeasureHelper.Init(this.iDAGlobalHelper, this, biCubeMeasure);
            this.biCubeMeasureHelpers.add(iBICubeMeasureHelper);
            this.biCubeMeasureMap.put(biCubeMeasure.getBICUBEMEASUREID(), iBICubeMeasureHelper);
            this.biCubeMeasureMap.put(iBICubeMeasureHelper.getUniqueName(), iBICubeMeasureHelper);
        }
    }

    protected IBICubeMeasureHelper OnCreateBICubeMeasureHelper(BICubeMeasure biCubeMeasure) throws Exception {
        if (StringHelper.Compare((String)biCubeMeasure.getBICUBEMEASURETYPE(), (String)"NORMAL", (boolean)true) == 0) {
            return (IBICubeMeasureHelper)ObjectHelper.Create((String)"SA.SRFDA.BI.Ctrl.BIMeasureHelper");
        }
        if (StringHelper.Compare((String)biCubeMeasure.getBICUBEMEASURETYPE(), (String)"CALCULATED", (boolean)true) == 0) {
            return (IBICubeMeasureHelper)ObjectHelper.Create((String)"SA.SRFDA.BI.Ctrl.BICalculatedMeasureHelper");
        }
        throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u6307\u6807\u7c7b\u578b[%1$s]", (Object)biCubeMeasure.getBICUBEMEASURETYPE()));
    }

    protected void OnInit() throws Exception {
    }

    @Override
    public IBIReportExHelper FindBIReportEx(BIReportEx biReportEx) throws Exception {
        IBIReportExHelper iBIReportExHelper = this.biReportExHelperMap.get(biReportEx.getBIREPORTEXID());
        if (iBIReportExHelper != null && iBIReportExHelper.getVersion() == biReportEx.getVERSION()) {
            return iBIReportExHelper;
        }
        iBIReportExHelper = this.OnCreateBIReportExHelper(biReportEx);
        iBIReportExHelper.Init(this.iDAGlobalHelper, this, biReportEx);
        this.biReportExHelperMap.put(biReportEx.getBIREPORTEXID(), iBIReportExHelper);
        return iBIReportExHelper;
    }

    @Override
    public IDEHelper getBICubeDEHelper() {
        return this.iBICubeDEHelper;
    }

    protected IBIReportExHelper OnCreateBIReportExHelper(BIReportEx biReportEx) throws Exception {
        return new BIReportExHelper();
    }

    @Override
    public int getVersion() {
        return this.biCube.getVERSION();
    }

    @Override
    public String getId() {
        return this.biCube.getBICUBEID();
    }

    @Override
    public String getName() {
        return this.biCube.getBICUBENAME();
    }

    @Override
    public BICube getBICube() {
        return this.biCube;
    }

    @Override
    public Vector<IBIDimensionHelper> getBIDimensions() {
        return this.biDimensionHelpers;
    }

    @Override
    public IBIDimensionHelper FindBIDimension(String strBICubeDimensionId) throws Exception {
        if (this.biCubeDimensionMap.containsKey(strBICubeDimensionId)) {
            return this.biCubeDimensionMap.get(strBICubeDimensionId);
        }
        throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5206\u6790\u7acb\u65b9\u4f53[%2$s:%3$s]\u7ef4\u5ea6[%1$s]", (Object)strBICubeDimensionId, (Object)this.getName(), (Object)this.getVersion()));
    }

    @Override
    public IBICubeMeasureHelper FindBICubeMeasure(String strBICubeMeasureId) throws Exception {
        if (this.biCubeMeasureMap.containsKey(strBICubeMeasureId)) {
            return this.biCubeMeasureMap.get(strBICubeMeasureId);
        }
        throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5206\u6790\u7acb\u65b9\u4f53[%2$s:%3$s]\u6307\u6807[%1$s]", (Object)strBICubeMeasureId, (Object)this.getName(), (Object)this.getVersion()));
    }

    @Override
    public IBIHierarchyHelper FindBIHierarchy(String strBIHierarchyId) throws Exception {
        for (IBIDimensionHelper iBIDimensionHelper : this.biDimensionHelpers) {
            if (!iBIDimensionHelper.hasBIHierarchy(strBIHierarchyId)) continue;
            return iBIDimensionHelper.FindBIHierarchy(strBIHierarchyId);
        }
        throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5206\u6790\u7acb\u65b9\u4f53[%2$s:%3$s]\u7ef4\u5ea6\u4f53\u7cfb[%1$s]", (Object)strBIHierarchyId, (Object)this.getName(), (Object)this.getVersion()));
    }

    @Override
    public Vector<String> CalcBICubeTables(Vector<BIHierarchyFilter> filters) throws Exception {
        Vector<String> tables = new Vector<String>();
        if (this.isUseView()) {
            tables.add(this.getBICubeDEHelper().GetDEViewName());
        } else {
            tables.add(this.getBICubeDEHelper().GetMainTable());
        }
        return tables;
    }

    @Override
    public Vector<IBICubeMeasureHelper> getBICubeMeasures() {
        return this.biCubeMeasureHelpers;
    }

    @Override
    public IDEFHelper FindBIDMJoinDEFHelper(String strBICubeDimensionId) {
        return this.biCubeDMJoinDEFMap.get(strBICubeDimensionId);
    }

    @Override
    public boolean isUseView() {
        return this.biCube.getUSEVIEW();
    }
}

