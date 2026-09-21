/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.ISystem
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.util.Inflector
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core;

import SA.SRFDA.PS.Core.DynaModel.IPSSysDynaModel;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemObject;
import SA.SRFDA.PS.Core.IPSSystemSetting;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSObjectImpl3;
import SA.SRFDA.PS.Core.Pub.IPSCodePublisherParam;
import SA.SRFDA.PS.Core.Pub.IPSSFPubHelp;
import SA.SRFDA.PS.Core.Pub.IPSSFPubSupportable;
import SA.SRFDA.PS.Core.Pub.PSSFPubHelpImpl;
import SA.SRFDA.PS.Core.Pub.Util.PSTemplHelper;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import java.util.HashMap;
import java.util.Map;
import net.ibizsys.paas.core.ISystem;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.util.Inflector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSSystemObjectImplBase
extends PSObjectImpl3
implements IPSSystemObject,
IPSSFPubSupportable {
    private static final Log log = LogFactory.getLog(PSSystemObjectImplBase.class);
    private IPSSFPubHelp iPSSFPubHelp = null;

    @Override
    public abstract IPSSystem getPSSystem();

    public ISystem getSystem() {
        return this.getPSSystem();
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSSystem().getPSSysModelInstId();
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSSystem());
    }

    protected IPSSystemSetting getPSSystemSetting() {
        return (IPSSystemSetting)((Object)this.getPSSystem());
    }

    @Override
    protected IPSSysDynaModel internalGetPSSysDynaModel(String strPSSysDynaModelId) throws Exception {
        return this.getPSSystem().getPSSysDynaModel(strPSSysDynaModelId);
    }

    @Override
    @PSModelRTMeta(name="[H]\u540e\u53f0\u6a21\u677f\u53d1\u5e03\u5e2e\u52a9", hideempty=true)
    public IPSSFPubHelp getPSSFPubHelp() {
        block4: {
            try {
                if (!PSTemplHelper.isBusy()) break block4;
                return null;
            }
            catch (Exception ex) {
                log.error((Object)ex);
                return null;
            }
        }
        if (this.iPSSFPubHelp != null) {
            return this.iPSSFPubHelp;
        }
        HashMap<String, IPSCodePublisherParam> publisherParamMap = new HashMap<String, IPSCodePublisherParam>();
        this.fillPSCodePublisherParams(publisherParamMap);
        this.iPSSFPubHelp = PSSFPubHelpImpl.createPSSFPubHelp(this.getPSSFPubObjTarget(), this.getPSSystem(), this, publisherParamMap);
        return this.iPSSFPubHelp;
    }

    protected void fillPSCodePublisherParams(Map<String, IPSCodePublisherParam> publisherParamMap) {
    }

    protected String getPSSFPubObjTarget() {
        return this.getModelType();
    }

    public IPSSystemModule getPSSystemModule() {
        return null;
    }

    @Override
    protected String onGetDynaInstTag() {
        String strDynaInstTag = super.onGetDynaInstTag();
        if (StringHelper.isNullOrEmpty((String)strDynaInstTag) && this.getDynaInstMode() == 2 && this.getPSSystemModule() != null) {
            return this.getPSSystemModule().getDynaInstTag();
        }
        return strDynaInstTag;
    }

    @Override
    protected String onGetDynaModelFolder() {
        if (this.getPSSystemModule() != null) {
            return String.format("%1$s/%2$s/%3$s", this.getPSSystemModule().getDynaModelFolder(), Inflector.getInstance().pluralize((Object)this.getDumpModelType()).toUpperCase(), this.getDynaModelTag());
        }
        return super.onGetDynaModelFolder();
    }

    @Override
    protected boolean onGetEnableDynaModel() {
        if (this.getPSSystem() != null) {
            return this.getPSSystem().isEnableDynaSys();
        }
        return super.onGetEnableDynaModel();
    }

    @Override
    public String getModelRefId() {
        String strModelRefId = this.getDynaModelFilePath();
        if (!StringHelper.isNullOrEmpty((String)strModelRefId)) {
            return strModelRefId;
        }
        if (this.getPSSystemModule() != null) {
            if (this.getPSSystemModule().getPSSysModelGroup() != null) {
                return String.format("%1$s__%2$s__%3$s", this.getPSSystemModule().getPSSysModelGroup().getCodeName(), this.getPSSystemModule().getCodeName(), super.getModelRefId());
            }
            return String.format("%1$s__%2$s", this.getPSSystemModule().getCodeName(), super.getModelRefId());
        }
        return super.getModelRefId();
    }

    @Override
    protected IPSModelObject onGetParentModel() {
        if (this.getPSSystemModule() != null) {
            return this.getPSSystemModule();
        }
        return this.getPSSystem();
    }

    @Override
    protected IPSModelObject onGetScopeModel() {
        if (this.getPSSystemModule() != null) {
            return this.getPSSystemModule().getScopeModel();
        }
        return this.getPSSystem();
    }
}

