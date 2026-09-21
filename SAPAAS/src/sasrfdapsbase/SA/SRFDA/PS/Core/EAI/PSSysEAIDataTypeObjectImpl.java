/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.EAI;

import SA.SRFDA.PS.Core.EAI.IPSEAIDataType;
import SA.SRFDA.PS.Core.EAI.IPSSysEAIDataType;
import SA.SRFDA.PS.Core.EAI.IPSSysEAIDataTypeObject;
import SA.SRFDA.PS.Core.EAI.PSSysEAISchemeObjectImpl;
import net.ibizsys.paas.util.StringHelper;

public abstract class PSSysEAIDataTypeObjectImpl
extends PSSysEAISchemeObjectImpl
implements IPSSysEAIDataTypeObject {
    private IPSSysEAIDataType iPSSysEAIDataType = null;

    @Override
    public IPSEAIDataType getPSEAIDataType() {
        return this.getPSSysEAIDataType();
    }

    @Override
    public IPSSysEAIDataType getPSSysEAIDataType() {
        return this.iPSSysEAIDataType;
    }

    protected void setPSSysEAIDataType(IPSSysEAIDataType iPSSysEAIDataType) {
        this.iPSSysEAIDataType = iPSSysEAIDataType;
        if (this.getPSSysEAIDataType() != null) {
            this.setPSSysEAIScheme(this.getPSSysEAIDataType().getPSSysEAIScheme());
        } else {
            this.setPSSysEAIScheme(null);
        }
    }

    @Override
    public String getModelId() {
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSSysEAIDataType().getModelId(), (Object)this.getId());
    }
}

