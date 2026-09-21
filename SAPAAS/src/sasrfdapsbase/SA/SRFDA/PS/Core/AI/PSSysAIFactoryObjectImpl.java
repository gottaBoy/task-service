/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.util.Inflector
 */
package SA.SRFDA.PS.Core.AI;

import SA.SRFDA.PS.Core.AI.IPSAIFactory;
import SA.SRFDA.PS.Core.AI.IPSSysAIFactory;
import SA.SRFDA.PS.Core.AI.IPSSysAIFactoryObject;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSObjectImpl;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.util.Inflector;

public abstract class PSSysAIFactoryObjectImpl
extends PSObjectImpl
implements IPSSysAIFactoryObject {
    private IPSSysAIFactory iPSSysAIFactory = null;

    @Override
    public IPSAIFactory getPSAIFactory() {
        return this.getPSSysAIFactory();
    }

    @Override
    public IPSSysAIFactory getPSSysAIFactory() {
        return this.iPSSysAIFactory;
    }

    protected void setPSSysAIFactory(IPSSysAIFactory iPSSysAIFactory) {
        this.iPSSysAIFactory = iPSSysAIFactory;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSSysAIFactory().getPSSysModelInstId();
    }

    @Override
    public String getModelId() {
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSSysAIFactory().getModelId(), (Object)this.getId());
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSSysAIFactory().getPSSystem());
    }

    @Override
    protected IPSModelObject onGetParentModel() {
        return this.getPSSysAIFactory();
    }

    @Override
    protected IPSModelObject onGetScopeModel() {
        return this.getPSSysAIFactory();
    }

    @Override
    protected String onGetDynaModelFolder() {
        return null;
    }

    @Override
    public String getDynaModelFilePath() {
        return null;
    }

    @Override
    protected String onGetMOSFolder() {
        if (this.getPSSysAIFactory() != null) {
            return String.format("%1$s/%2$s", this.getPSSysAIFactory().getMOSFilePath(), Inflector.getInstance().pluralize((Object)this.getModelType()).toLowerCase());
        }
        return Inflector.getInstance().pluralize((Object)this.getModelType()).toLowerCase();
    }

    @Override
    protected String onGetRTMOSFolder() {
        if (this.getPSSysAIFactory() != null) {
            return String.format("%1$s/%2$s", this.getPSSysAIFactory().getRTMOSFilePath(), Inflector.getInstance().pluralize((Object)this.getRTMOSModelType()).toLowerCase());
        }
        return Inflector.getInstance().pluralize((Object)this.getRTMOSModelType()).toLowerCase();
    }
}

