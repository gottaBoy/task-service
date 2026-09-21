/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DEField;

import SA.SRFDA.PS.Core.DEField.IPSOne2OneObjDEField;
import SA.SRFDA.PS.Core.DEField.PSFormulaDEFieldImpl;
import SA.SRFDA.PS.Core.DynaModel.IPSSysDynaModel;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelPFIgnoreMeta
public class PSFormulaOne2OneObjDEFieldImpl
extends PSFormulaDEFieldImpl
implements IPSOne2OneObjDEField {
    private static final Log log = LogFactory.getLog(PSFormulaOne2OneObjDEFieldImpl.class);
    private IPSSysDynaModel refPSSysDynaModel = null;

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u52a8\u6001\u6a21\u578b", dumpref=true, fields={"REFPSSYSDYNAMODELID"})
    public IPSSysDynaModel getRefPSSysDynaModel() throws Exception {
        if (this.refPSSysDynaModel != null) {
            return this.refPSSysDynaModel;
        }
        if (StringHelper.IsNullOrEmpty((String)this.getPSDEFieldData().getREFPSSYSDYNAMODELID())) {
            return null;
        }
        this.refPSSysDynaModel = this.getPSDataEntity().getPSSystem().getPSSysDynaModel(this.getPSDEFieldData().getREFPSSYSDYNAMODELID());
        return this.refPSSysDynaModel;
    }

    @Override
    protected boolean onCalcQueryColumn() {
        return false;
    }
}

