/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.EAI;

import SA.SRFDA.PS.Core.EAI.IPSEAIDE;
import SA.SRFDA.PS.Core.EAI.IPSSysEAIDE;
import SA.SRFDA.PS.Core.EAI.IPSSysEAIDEObject;
import SA.SRFDA.PS.Core.EAI.PSSysEAISchemeObjectImpl;
import net.ibizsys.paas.util.StringHelper;

public abstract class PSSysEAIDEObjectImpl
extends PSSysEAISchemeObjectImpl
implements IPSSysEAIDEObject {
    private IPSSysEAIDE iPSSysEAIDE = null;

    @Override
    public IPSEAIDE getPSEAIDE() {
        return this.getPSSysEAIDE();
    }

    @Override
    public IPSSysEAIDE getPSSysEAIDE() {
        return this.iPSSysEAIDE;
    }

    protected void setPSSysEAIDE(IPSSysEAIDE iPSSysEAIDE) {
        this.iPSSysEAIDE = iPSSysEAIDE;
        if (this.getPSSysEAIDE() != null) {
            this.setPSSysEAIScheme(this.getPSSysEAIDE().getPSSysEAIScheme());
        } else {
            this.setPSSysEAIScheme(null);
        }
    }

    @Override
    public String getModelId() {
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSSysEAIDE().getModelId(), (Object)this.getId());
    }
}

