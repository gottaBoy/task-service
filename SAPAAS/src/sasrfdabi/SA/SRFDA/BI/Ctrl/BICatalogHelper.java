/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.BI.Ctrl;

import SA.SRFDA.BI.Ctrl.BIDimensionHelper;
import SA.SRFDA.BI.Ctrl.BaseBIObject;
import SA.SRFDA.BI.Ctrl.Data.BICatalog;
import SA.SRFDA.BI.Ctrl.Data.BIDimension;
import SA.SRFDA.BI.Ctrl.IBICatalogHelper;
import SA.SRFDA.BI.Ctrl.IBIDimensionHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Hashtable;
import java.util.Vector;

public class BICatalogHelper
extends BaseBIObject
implements IBICatalogHelper {
    protected BICatalog biCataLog = null;
    protected Hashtable<String, IBIDimensionHelper> biDimensionMap = new Hashtable();

    @Override
    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, BICatalog biCataLog) throws Exception {
        this.iDAGlobalHelper = iDAGlobalHelper;
        this.biCataLog = biCataLog;
        this.OnPrepareBIDimensions();
        this.OnInit();
    }

    protected void OnPrepareBIDimensions() throws Exception {
        Vector<BIDimension> biDimensions = new Vector<BIDimension>();
        CallResult callResult = this.getBIModelHelper().GetBIDimensions(this.getId(), biDimensions);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u5206\u6790\u6570\u636e\u5e93\u5168\u5c40\u7ef4\u5ea6\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        int nShortIdIndex = 0;
        for (BIDimension biDimension : biDimensions) {
            IBIDimensionHelper iBIDimensionHelper = this.OnCreateBIDimensionHelper(biDimension);
            iBIDimensionHelper.setShortId(StringHelper.Format((String)"D%1$s", (Object)(++nShortIdIndex)));
            iBIDimensionHelper.Init(this.iDAGlobalHelper, biDimension);
            this.biDimensionMap.put(biDimension.getBIDIMENSIONID(), iBIDimensionHelper);
        }
    }

    protected IBIDimensionHelper OnCreateBIDimensionHelper(BIDimension biDimension) throws Exception {
        return new BIDimensionHelper();
    }

    protected void OnInit() throws Exception {
    }

    @Override
    public String getId() {
        return this.biCataLog.getBICATALOGID();
    }

    @Override
    public IBIDimensionHelper FindBIDimension(String strBIDimensionId) throws Exception {
        if (this.biDimensionMap.containsKey(strBIDimensionId)) {
            return this.biDimensionMap.get(strBIDimensionId);
        }
        throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5206\u6790\u6570\u636e\u5e93[%2$S:%3$S]\u5168\u5c40\u7ef4\u5ea6[%1$s]", (Object)strBIDimensionId, (Object)this.getName(), (Object)this.getVersion()));
    }

    @Override
    public String getName() {
        return this.biCataLog.getBICATALOGNAME();
    }

    @Override
    public int getVersion() {
        return this.biCataLog.getVERSION();
    }
}

