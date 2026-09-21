/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.DataTypeHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DEField;

import SA.SRFDA.PS.Core.DEField.IPSFormulaDEField;
import SA.SRFDA.PS.Core.DEField.PSDEFieldImpl;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import net.ibizsys.paas.util.DataTypeHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelPFIgnoreMeta
public class PSFormulaDEFieldImpl
extends PSDEFieldImpl
implements IPSFormulaDEField {
    private static final Log log = LogFactory.getLog(PSFormulaDEFieldImpl.class);

    @Override
    @PSModelRTMeta(description="\u516c\u5f0f\u5217\u683c\u5f0f", fields={"FORMULAFORMAT"})
    public String getFormulaFormat() {
        return this.getPSDEFieldData().getFORMULAFORMAT();
    }

    @Override
    @PSModelRTMeta(description="\u516c\u5f0f\u5217\u53c2\u6570", fields={"FORMULAFIELDS"})
    public String getFormulaColumns() {
        return this.getPSDEFieldData().getFORMULAFIELDS();
    }

    @Override
    protected int onGetStdDataType() throws Exception {
        int nStdDataType = super.onGetStdDataType();
        if (nStdDataType != 0) {
            return nStdDataType;
        }
        if (DataTypeHelper.isContainsDataType((String)this.getDataType())) {
            return DataTypeHelper.fromString((String)this.getDataType());
        }
        return 25;
    }

    @Override
    @PSModelRTMeta(description="\u516c\u5f0f\u5c5e\u6027", doc="\u6052\u4e3atrue")
    public boolean isFormulaDEField() {
        return true;
    }

    @Override
    @PSModelRTMeta(description="\u7269\u7406\u5c5e\u6027", ignoredumpvalues="true", doc="\u6052\u4e3afalse")
    public boolean isPhisicalDEField() {
        return false;
    }
}

