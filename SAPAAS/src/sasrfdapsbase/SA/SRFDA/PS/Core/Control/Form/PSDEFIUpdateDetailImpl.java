/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.Control.Form;

import SA.SRFDA.PS.Core.Control.Form.IPSDEFIUpdateDetail;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormItemUpdate;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSDEFIUDetail;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;

public class PSDEFIUpdateDetailImpl
extends PSObjectImpl
implements IPSDEFIUpdateDetail {
    protected IPSDEFormItemUpdate iPSDEFormItemUpdate;
    protected PSDEFIUDetail psDEFIUDetail;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEFormItemUpdate iPSDEFormItemUpdate, PSDEFIUDetail psDEFIUDetail) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.iPSDEFormItemUpdate = iPSDEFormItemUpdate;
        this.psDEFIUDetail = psDEFIUDetail;
        this.setPSObjectData(psDEFIUDetail);
        this.setId(psDEFIUDetail.getPSDEFIUDETAILID());
        this.setName(psDEFIUDetail.getPSDEFIUDETAILNAME());
        this.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u66f4\u65b0\u8868\u5355\u9879", fields={"PSDEFORMDETAILNAME"})
    public String getName() {
        return this.getPSDEFormDetailName();
    }

    @Override
    public String getPSDEFormDetailName() {
        return this.psDEFIUDetail.getPSDEFORMDETAILNAME();
    }

    @Override
    public String getPSDEFormDetailId() {
        return this.psDEFIUDetail.getPSDEFORMDETAILID();
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSDEFormItemUpdate.getPSSysModelInstId();
    }

    @Override
    public String getModelType() {
        return "PSDEFIUDETAIL";
    }

    public IPSDEFormItemUpdate getPSDEFormItemUpdate() {
        return this.iPSDEFormItemUpdate;
    }

    @Override
    public String getModelId() {
        return StringHelper.Format((String)"%1$s#%2$s", (Object)this.getPSDEFormItemUpdate().getModelId(), (Object)this.getName());
    }

    @Override
    public String getModelRefId() {
        return null;
    }
}

