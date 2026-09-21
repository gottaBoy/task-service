/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.BI.Ctrl;

import SA.SRFDA.BI.Ctrl.BIHierarchyHelper;
import SA.SRFDA.BI.Ctrl.BaseBIObject;
import SA.SRFDA.BI.Ctrl.Data.BIDimension;
import SA.SRFDA.BI.Ctrl.Data.BIHierarchy;
import SA.SRFDA.BI.Ctrl.IBIDimensionHelper;
import SA.SRFDA.BI.Ctrl.IBIHierarchyHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;

public class BIDimensionHelper
extends BaseBIObject
implements IBIDimensionHelper {
    private String strShortId = "";
    protected BIDimension biDimension = null;
    protected Vector<IBIHierarchyHelper> biHierarchies = new Vector();

    @Override
    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, BIDimension biDimension) throws Exception {
        this.iDAGlobalHelper = iDAGlobalHelper;
        this.biDimension = biDimension;
        this.OnPrepareBIHierarchies();
        this.OnInit();
    }

    protected void OnPrepareBIHierarchies() throws Exception {
        Vector<BIHierarchy> list = new Vector<BIHierarchy>();
        CallResult callResult = this.getBIModelHelper().GetBIHierarchies(this.biDimension.getBIDIMENSIONID(), list);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u7ef4\u5ea6\u4f53\u7cfb\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        int nShortIdIndex = 0;
        for (BIHierarchy biHierarchy : list) {
            IBIHierarchyHelper iBIHierarchyHelper = this.OnCreateBIHierarchyHelper(biHierarchy);
            String strHierarchyShortId = StringHelper.Format((String)"%1$sH%2$s", (Object)this.getShortId(), (Object)(++nShortIdIndex));
            iBIHierarchyHelper.setShortId(strHierarchyShortId);
            iBIHierarchyHelper.Init(this.iDAGlobalHelper, this, biHierarchy);
            this.biHierarchies.add(iBIHierarchyHelper);
        }
    }

    protected IBIHierarchyHelper OnCreateBIHierarchyHelper(BIHierarchy biHierarchy) throws Exception {
        return new BIHierarchyHelper();
    }

    protected void OnInit() throws Exception {
    }

    @Override
    public String getId() {
        return this.biDimension.getBIDIMENSIONID();
    }

    @Override
    public String getShortId() {
        return this.strShortId;
    }

    @Override
    public void setShortId(String strShortId) {
        this.strShortId = strShortId;
    }

    @Override
    public String getUniqueName() {
        return this.biDimension.getBIDIMENSIONNAME();
    }

    @Override
    public String getLogicName() {
        if (StringHelper.IsNullOrEmpty((String)this.biDimension.getCAPTION())) {
            return this.biDimension.getBIDIMENSIONNAME();
        }
        return this.biDimension.getCAPTION();
    }

    @Override
    public IBIHierarchyHelper FindBIHierarchy(String strBIHierarchyId) throws Exception {
        for (IBIHierarchyHelper iBIHierarchyHelper : this.biHierarchies) {
            if (StringHelper.Compare((String)iBIHierarchyHelper.getId(), (String)strBIHierarchyId, (boolean)false) == 0) {
                return iBIHierarchyHelper;
            }
            if (StringHelper.Compare((String)iBIHierarchyHelper.getUniqueName(), (String)strBIHierarchyId, (boolean)false) != 0) continue;
            return iBIHierarchyHelper;
        }
        throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u7ef4\u5ea6\u4f53\u7cfb[%1$s]", (Object)strBIHierarchyId));
    }

    @Override
    public boolean hasBIHierarchy(String strBIHierarchyId) {
        for (IBIHierarchyHelper iBIHierarchyHelper : this.biHierarchies) {
            if (StringHelper.Compare((String)iBIHierarchyHelper.getId(), (String)strBIHierarchyId, (boolean)false) == 0) {
                return true;
            }
            if (StringHelper.Compare((String)iBIHierarchyHelper.getUniqueName(), (String)strBIHierarchyId, (boolean)false) != 0) continue;
            return true;
        }
        return false;
    }

    @Override
    public BIDimension getBIDimension() {
        return this.biDimension;
    }

    @Override
    public String getDimensionType() {
        String strDMType = this.biDimension.getDIMENSIONTYPE();
        if (StringHelper.IsNullOrEmpty((String)strDMType)) {
            return "STANDARDDIMENSION";
        }
        return strDMType;
    }
}

