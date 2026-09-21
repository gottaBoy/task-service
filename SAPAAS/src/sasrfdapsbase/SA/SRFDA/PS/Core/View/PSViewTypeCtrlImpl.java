/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.DataTypeHelper
 */
package SA.SRFDA.PS.Core.View;

import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.View.IPSViewType;
import SA.SRFDA.PS.Core.View.IPSViewTypeCtrl;
import SA.SRFDA.PS.Data.PSViewTypeCtrl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.DataTypeHelper;

public class PSViewTypeCtrlImpl
extends PSObjectImpl
implements IPSViewTypeCtrl {
    protected IPSViewType iPSViewType = null;
    protected PSViewTypeCtrl psViewTypeCtrl = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSViewType iPSViewType, PSViewTypeCtrl psViewTypeCtrl) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.iPSViewType = iPSViewType;
        this.psViewTypeCtrl = psViewTypeCtrl;
        this.setId(this.psViewTypeCtrl.getPSVTCTRLID());
        this.setName(this.psViewTypeCtrl.getPSVTCTRLNAME());
        this.setPSObjectData(this.psViewTypeCtrl);
        this.onInit();
    }

    @Override
    public String getCtrlType() {
        return this.psViewTypeCtrl.getCTRLTYPE();
    }

    @Override
    public String getPSSysToolbarId() {
        return this.psViewTypeCtrl.getPSSYSTOOLBARID();
    }

    @Override
    public String getPSSysACHandlerId() {
        return this.psViewTypeCtrl.getPSSYSACHANDLERID();
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSViewType.getPSSysModelInstId();
    }

    @Override
    public String getCtrlParam() {
        return this.psViewTypeCtrl.getParamStringValue("CTRLPARAM", null);
    }

    @Override
    public String getCtrlParam2() {
        return this.psViewTypeCtrl.getParamStringValue("CTRLPARAM2", null);
    }

    @Override
    public String getCtrlParam3() {
        return this.psViewTypeCtrl.getParamStringValue("CTRLPARAM3", null);
    }

    @Override
    public String getCtrlParam4() {
        return this.psViewTypeCtrl.getParamStringValue("CTRLPARAM4", null);
    }

    @Override
    public Integer getCtrlParam5() {
        Object objValue = this.psViewTypeCtrl.getParamValue("CTRLPARAM5");
        if (objValue != null) {
            try {
                return DataTypeHelper.getIntegerValue((Object)objValue);
            }
            catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    @Override
    public Integer getCtrlParam6() {
        Object objValue = this.psViewTypeCtrl.getParamValue("CTRLPARAM6");
        if (objValue != null) {
            try {
                return DataTypeHelper.getIntegerValue((Object)objValue);
            }
            catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    @Override
    public Integer getCtrlParam7() {
        Object objValue = this.psViewTypeCtrl.getParamValue("CTRLPARAM7");
        if (objValue != null) {
            try {
                return DataTypeHelper.getIntegerValue((Object)objValue);
            }
            catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    @Override
    public Integer getCtrlParam8() {
        Object objValue = this.psViewTypeCtrl.getParamValue("CTRLPARAM8");
        if (objValue != null) {
            try {
                return DataTypeHelper.getIntegerValue((Object)objValue);
            }
            catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    @Override
    public Double getCtrlParam9() {
        Object objValue = this.psViewTypeCtrl.getParamValue("CTRLPARAM9");
        if (objValue != null) {
            try {
                return DataTypeHelper.getDoubleValue((Object)objValue);
            }
            catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    @Override
    public Double getCtrlParam10() {
        Object objValue = this.psViewTypeCtrl.getParamValue("CTRLPARAM10");
        if (objValue != null) {
            try {
                return DataTypeHelper.getDoubleValue((Object)objValue);
            }
            catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    @Override
    public Integer getCtrlParam11() {
        Object objValue = this.psViewTypeCtrl.getParamValue("CTRLPARAM11");
        if (objValue != null) {
            try {
                return DataTypeHelper.getIntegerValue((Object)objValue);
            }
            catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    @Override
    public Integer getCtrlParam12() {
        Object objValue = this.psViewTypeCtrl.getParamValue("CTRLPARAM12");
        if (objValue != null) {
            try {
                return DataTypeHelper.getIntegerValue((Object)objValue);
            }
            catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }
}

