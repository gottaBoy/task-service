/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Control.Form;

import SA.SRFDA.PS.Core.Control.Form.IPSDEFDSingleLogic;
import SA.SRFDA.PS.Core.Control.Form.PSDEFDLogicImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import net.ibizsys.paas.util.StringHelper;

public class PSDEFDSingleLogicImpl
extends PSDEFDLogicImpl
implements IPSDEFDSingleLogic {
    @Override
    protected void onInit() throws Exception {
        if (this.getPSDEFormDetail() != null && this.getPSDEFormDetail().getPSDEForm() != null && !StringHelper.isNullOrEmpty((String)this.getDEFDName())) {
            this.getPSDEFormDetail().getPSDEForm().hookPSDEFormItem(this.getDEFDName(), this);
        }
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u8868\u5355\u9879\u540d\u79f0", fields={"FDNAME"})
    public String getDEFDName() {
        return this.psDEFDLogic.getFDNAME();
    }

    @Override
    public String getPSDBValueOPId() {
        return this.psDEFDLogic.getPSDBVALUEOPID();
    }

    @Override
    @PSModelRTMeta(description="\u6761\u4ef6\u64cd\u4f5c", fields={"PSDBVALUEOPID"})
    public String getCondOP() {
        return this.getPSDBValueOPId();
    }

    @Override
    @PSModelRTMeta(description="\u6761\u4ef6\u503c", fields={"CONDVALUE"})
    public String getValue() {
        return this.psDEFDLogic.getCONDVALUE();
    }
}

