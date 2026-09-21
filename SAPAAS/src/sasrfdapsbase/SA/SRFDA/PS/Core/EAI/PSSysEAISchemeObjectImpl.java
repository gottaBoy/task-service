/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.EAI;

import SA.SRFDA.PS.Core.EAI.IPSEAIScheme;
import SA.SRFDA.PS.Core.EAI.IPSSysEAIScheme;
import SA.SRFDA.PS.Core.EAI.IPSSysEAISchemeObject;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSObjectImpl;
import net.ibizsys.paas.util.StringHelper;

public abstract class PSSysEAISchemeObjectImpl
extends PSObjectImpl
implements IPSSysEAISchemeObject {
    private IPSSysEAIScheme iPSSysEAIScheme = null;

    @Override
    public IPSEAIScheme getPSEAIScheme() {
        return this.getPSSysEAIScheme();
    }

    @Override
    public IPSSysEAIScheme getPSSysEAIScheme() {
        return this.iPSSysEAIScheme;
    }

    protected void setPSSysEAIScheme(IPSSysEAIScheme iPSSysEAIScheme) {
        this.iPSSysEAIScheme = iPSSysEAIScheme;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSSysEAIScheme().getPSSysModelInstId();
    }

    @Override
    public String getModelId() {
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSSysEAIScheme().getModelId(), (Object)this.getId());
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSSysEAIScheme().getPSSystem());
    }
}

