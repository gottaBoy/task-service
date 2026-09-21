/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.util.Inflector
 */
package SA.SRFDA.PS.Core.AI;

import SA.SRFDA.PS.Core.AI.IPSAIPipelineAgent;
import SA.SRFDA.PS.Core.AI.IPSSysAIPipelineAgent;
import SA.SRFDA.PS.Core.AI.IPSSysAIPipelineObject;
import SA.SRFDA.PS.Core.AI.PSSysAIFactoryObjectImpl;
import SA.SRFDA.PS.Core.IPSModelObject;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.util.Inflector;

public abstract class PSSysAIPipelineObjectImpl
extends PSSysAIFactoryObjectImpl
implements IPSSysAIPipelineObject {
    private IPSSysAIPipelineAgent iPSSysAIPipelineAgent = null;

    @Override
    public IPSAIPipelineAgent getPSAIPipelineAgent() {
        return this.getPSSysAIPipelineAgent();
    }

    @Override
    public IPSSysAIPipelineAgent getPSSysAIPipelineAgent() {
        return this.iPSSysAIPipelineAgent;
    }

    protected void setPSSysAIPipelineAgent(IPSSysAIPipelineAgent iPSSysAIPipelineAgent) {
        this.iPSSysAIPipelineAgent = iPSSysAIPipelineAgent;
        if (this.getPSSysAIPipelineAgent() != null) {
            this.setPSSysAIFactory(this.getPSSysAIPipelineAgent().getPSSysAIFactory());
        } else {
            this.setPSSysAIFactory(null);
        }
    }

    @Override
    public String getModelId() {
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSSysAIPipelineAgent().getModelId(), (Object)this.getId());
    }

    @Override
    protected IPSModelObject onGetParentModel() {
        return this.getPSSysAIPipelineAgent();
    }

    @Override
    protected IPSModelObject onGetScopeModel() {
        return this.getPSSysAIPipelineAgent();
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
        if (this.getPSSysAIPipelineAgent() != null) {
            return String.format("%1$s/%2$s", this.getPSSysAIPipelineAgent().getMOSFilePath(), Inflector.getInstance().pluralize((Object)this.getModelType()).toLowerCase());
        }
        return Inflector.getInstance().pluralize((Object)this.getModelType()).toLowerCase();
    }

    @Override
    protected String onGetRTMOSFolder() {
        if (this.getPSSysAIPipelineAgent() != null) {
            return String.format("%1$s/%2$s", this.getPSSysAIPipelineAgent().getRTMOSFilePath(), Inflector.getInstance().pluralize((Object)this.getRTMOSModelType()).toLowerCase());
        }
        return Inflector.getInstance().pluralize((Object)this.getRTMOSModelType()).toLowerCase();
    }
}

