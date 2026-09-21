/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.EAI;

import SA.SRFDA.PS.Core.EAI.IPSEAIElement;
import SA.SRFDA.PS.Core.EAI.IPSSysEAIElement;
import SA.SRFDA.PS.Core.EAI.IPSSysEAIElementObject;
import SA.SRFDA.PS.Core.EAI.PSSysEAISchemeObjectImpl;
import net.ibizsys.paas.util.StringHelper;

public abstract class PSSysEAIElementObjectImpl
extends PSSysEAISchemeObjectImpl
implements IPSSysEAIElementObject {
    private IPSSysEAIElement iPSSysEAIElement = null;

    @Override
    public IPSEAIElement getPSEAIElement() {
        return this.getPSSysEAIElement();
    }

    @Override
    public IPSSysEAIElement getPSSysEAIElement() {
        return this.iPSSysEAIElement;
    }

    protected void setPSSysEAIElement(IPSSysEAIElement iPSSysEAIElement) {
        this.iPSSysEAIElement = iPSSysEAIElement;
        if (this.getPSSysEAIElement() != null) {
            this.setPSSysEAIScheme(this.getPSSysEAIElement().getPSSysEAIScheme());
        } else {
            this.setPSSysEAIScheme(null);
        }
    }

    @Override
    public String getModelId() {
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSSysEAIElement().getModelId(), (Object)this.getId());
    }
}

