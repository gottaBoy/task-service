/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.BI.Ctrl;

import SA.SRFDA.BI.Ctrl.BaseBIObject;
import SA.SRFDA.BI.Ctrl.Data.BILevel;
import SA.SRFDA.BI.Ctrl.IBIHierarchyHelper;
import SA.SRFDA.BI.Ctrl.IBILevelHelper;
import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;

public class BILevelHelper
extends BaseBIObject
implements IBILevelHelper {
    private String strShortId = "";
    protected IBIHierarchyHelper iBIHierarchyHelper = null;
    protected BILevel biLevel = null;
    protected String strColumnName = "";
    protected String strSortColumnName = "";
    protected IDEFHelper iBILevelDEFHelper = null;
    protected IDEFHelper iBILevelSortDEFHelper = null;
    private boolean bUniqueMembers = false;

    @Override
    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, IBIHierarchyHelper iBIHierarchyHelper, BILevel biLevel) throws Exception {
        this.iDAGlobalHelper = iDAGlobalHelper;
        this.iBIHierarchyHelper = iBIHierarchyHelper;
        this.biLevel = biLevel;
        this.bUniqueMembers = this.biLevel.getUNIQUEMEMBERS();
        String strDEFId = biLevel.getCAPDEFID();
        if (StringHelper.IsNullOrEmpty((String)strDEFId)) {
            strDEFId = biLevel.getDEFID();
        }
        this.iBILevelDEFHelper = iBIHierarchyHelper.getBIHierarchyDEHelper().GetDEFHelper(strDEFId);
        if (this.iBILevelDEFHelper == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5206\u6790\u7ef4\u5ea6\u4f53\u7cfb\u5c42\u7ea7\u7ed1\u5b9a\u5c5e\u6027[%1$s]", (Object)strDEFId));
        }
        this.iBILevelSortDEFHelper = iBIHierarchyHelper.getBIHierarchyDEHelper().GetDEFHelper(biLevel.getDEFID());
        if (this.iBILevelSortDEFHelper == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5206\u6790\u7ef4\u5ea6\u4f53\u7cfb\u5c42\u7ea7\u7ed1\u5b9a\u5c5e\u6027[%1$s]", (Object)biLevel.getDEFID()));
        }
        this.OnInit();
    }

    protected void OnInit() throws Exception {
    }

    @Override
    public IBIHierarchyHelper getBIHierarchy() {
        return this.iBIHierarchyHelper;
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
    public String getId() {
        return this.biLevel.getBILEVELID();
    }

    @Override
    public String getUniqueName() {
        return this.biLevel.getBILEVELNAME();
    }

    @Override
    public String getName() {
        return this.biLevel.getBILEVELNAME();
    }

    @Override
    public String getLogicName() {
        if (StringHelper.IsNullOrEmpty((String)this.biLevel.getCAPTION())) {
            return this.getName();
        }
        return this.biLevel.getCAPTION();
    }

    @Override
    public BILevel getBILevel() {
        return this.biLevel;
    }

    @Override
    public String getColumnName() {
        return this.iBILevelDEFHelper.GetDTColumn().GetColumnName();
    }

    @Override
    public String getSortColumnName() {
        return this.iBILevelSortDEFHelper.GetDTColumn().GetColumnName();
    }

    @Override
    public boolean isUniqueMembers() {
        return this.bUniqueMembers;
    }

    @Override
    public String getAggCaption() {
        if (StringHelper.IsNullOrEmpty((String)this.biLevel.getAGGCAPTION())) {
            return "\u5408\u8ba1";
        }
        return this.biLevel.getAGGCAPTION();
    }

    @Override
    public String getLevelType() {
        return this.biLevel.getLEVELTYPE();
    }
}

