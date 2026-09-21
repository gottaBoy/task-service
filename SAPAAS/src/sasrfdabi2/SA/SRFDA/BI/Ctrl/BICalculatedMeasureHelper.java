/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.BI.Ctrl.Data.BICalculatedMeasure
 *  SA.SRFDA.BI.Ctrl.IBICalculatedMeasureHelper
 *  SA.SRFDA.BI.Ctrl.IBICubeDimensionHelper
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.BI.Ctrl;

import SA.SRFDA.BI.Ctrl.BICubeMeasureHelper;
import SA.SRFDA.BI.Ctrl.Data.BICalculatedMeasure;
import SA.SRFDA.BI.Ctrl.IBICalculatedMeasureHelper;
import SA.SRFDA.BI.Ctrl.IBICubeDimensionHelper;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;

public class BICalculatedMeasureHelper
extends BICubeMeasureHelper
implements IBICalculatedMeasureHelper,
IBICubeDimensionHelper {
    protected BICalculatedMeasure biCalculatedMeasure = new BICalculatedMeasure();

    @Override
    protected void OnInit() throws Exception {
        super.OnInit();
        this.biCalculatedMeasure.setBICALCULATEDMEASUREID(this.biCubeMeasure.getBICUBEMEASUREID());
        IDEDataCtrl dataCtrl = this.iDAGlobalHelper.getDAModelStorage().FindDEDataCtrl("BI0009", "SYSTEM", null);
        if (dataCtrl == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"BI0009"));
        }
        CallResult callResult = dataCtrl.Get((BaseDataEntity)this.biCalculatedMeasure);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u7acb\u65b9\u4f53\u7ef4\u5ea6[%1$s]\u5931\u8d25\uff0c%2$s", (Object)this.biCubeMeasure.getBICUBEMEASUREID(), (Object)callResult.getErrorInfo()));
        }
    }

    public String getMeasureType() {
        return "CALCULATED";
    }

    public String getExpression() {
        return this.biCalculatedMeasure.getMEASUREFORMULA();
    }
}

