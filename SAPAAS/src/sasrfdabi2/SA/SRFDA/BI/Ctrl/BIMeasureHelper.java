/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.BI.Ctrl.Data.BIMeasure
 *  SA.SRFDA.BI.Ctrl.IBICubeDimensionHelper
 *  SA.SRFDA.BI.Ctrl.IBIMeasureHelper
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.BI.Ctrl;

import SA.SRFDA.BI.Ctrl.BICubeMeasureHelper;
import SA.SRFDA.BI.Ctrl.Data.BIMeasure;
import SA.SRFDA.BI.Ctrl.IBICubeDimensionHelper;
import SA.SRFDA.BI.Ctrl.IBIMeasureHelper;
import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;

public class BIMeasureHelper
extends BICubeMeasureHelper
implements IBIMeasureHelper,
IBICubeDimensionHelper {
    protected BIMeasure biMeasure = new BIMeasure();
    protected IDEFHelper iBIMeasureDEFHelper = null;
    protected String strColumnName = "";

    @Override
    protected void OnInit() throws Exception {
        super.OnInit();
        this.biMeasure.setBIMEASUREID(this.biCubeMeasure.getBICUBEMEASUREID());
        IDEDataCtrl dataCtrl = this.iDAGlobalHelper.getDAModelStorage().FindDEDataCtrl("BI0008", "SYSTEM", null);
        if (dataCtrl == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"BI0008"));
        }
        CallResult callResult = dataCtrl.Get((BaseDataEntity)this.biMeasure);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u7acb\u65b9\u4f53\u7ef4\u5ea6[%1$s]\u5931\u8d25\uff0c%2$s", (Object)this.biCubeMeasure.getBICUBEMEASUREID(), (Object)callResult.getErrorInfo()));
        }
        this.iBIMeasureDEFHelper = this.iBICubeHelper.getBICubeDEHelper().GetDEFHelper(this.biMeasure.getMEASUREFIELDID());
        if (this.iBIMeasureDEFHelper == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5206\u6790\u7acb\u65b9\u4f53\u6307\u6807\u7ed1\u5b9a\u5c5e\u6027[%1$s]", (Object)this.biMeasure.getMEASUREFIELDID()));
        }
        this.strColumnName = this.iBIMeasureDEFHelper.GetDTColumn().GetColumnName();
    }

    public String getMeasureType() {
        return "NORMAL";
    }

    public String getAggregator() {
        return this.biMeasure.getAGGREGATOR();
    }

    public String getColumnName() {
        return this.strColumnName;
    }
}

