/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.dataentity.field.IPSFormulaDEField
 *  net.ibizsys.paas.util.DataTypeHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.dataentity.field;

import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.dataentity.field.IPSFormulaDEField;
import net.ibizsys.model.dataentity.field.PSDEFieldImpl;
import net.ibizsys.paas.util.DataTypeHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSFormulaDEFieldImpl
extends PSDEFieldImpl
implements IPSFormulaDEField {
    private static final Log log = LogFactory.getLog(PSFormulaDEFieldImpl.class);

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
    @PSModelRTMeta(description="\u516c\u5f0f\u5c5e\u6027")
    public boolean isFormulaDEField() {
        return true;
    }

    @Override
    @PSModelRTMeta(description="\u7269\u7406\u5c5e\u6027")
    public boolean isPhisicalDEField() {
        return false;
    }

    @Override
    @PSModelRTMeta(description="\u6807\u51c6\u6570\u636e\u7c7b\u578b", codelist="StdDataType")
    public int getStdDataType() {
        return super.getStdDataType();
    }
}

