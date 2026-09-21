/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  com.fasterxml.jackson.databind.node.ObjectNode
 */
package SA.SRFDA.PS.Core.Control.Form;

import SA.SRFDA.PS.Core.Control.Form.IPSDEFDLogic;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormDetail;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSDEFDLogic;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public abstract class PSDEFDLogicImpl
extends PSObjectImpl
implements IPSDEFDLogic {
    protected IPSDEFormDetail iPSDEFormDetail = null;
    protected PSDEFDLogic psDEFDLogic = null;
    protected IPSDEFDLogic parentPSDEFDLogic = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEFormDetail iPSDEFormDetail, IPSDEFDLogic parentPSDEFDLogic, PSDEFDLogic psDEFDLogic) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.iPSDEFormDetail = iPSDEFormDetail;
        this.psDEFDLogic = psDEFDLogic;
        this.parentPSDEFDLogic = parentPSDEFDLogic;
        this.setId(this.psDEFDLogic.getPSDEFDLOGICID());
        this.setName(this.psDEFDLogic.getPSDEFDLOGICNAME());
        this.onInit();
    }

    @Override
    public String getLogicCat() {
        return this.psDEFDLogic.getLOGICCAT();
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u7c7b\u578b", fields={"LOGICTYPE"})
    public String getLogicType() {
        return this.psDEFDLogic.getLOGICTYPE();
    }

    @Override
    public IPSDEFormDetail getPSDEFormDetail() {
        return this.iPSDEFormDetail;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSDEFormDetail.getPSSysModelInstId();
    }

    @Override
    public String getModelId() {
        if (this.getPSDEFormDetail() != null) {
            return StringHelper.Format((String)"%1$s#%2$s", (Object)this.getPSDEFormDetail().getModelId(), (Object)this.getId());
        }
        return super.getModelId();
    }

    @Override
    public String getModelType() {
        return "PSDEFDLOGIC";
    }

    @Override
    public String getModelRefId() {
        return null;
    }

    @Override
    protected void onFillModelNode(ObjectNode objectNode, String strModelType) throws Exception {
        super.onFillModelNode(objectNode, strModelType);
    }
}

