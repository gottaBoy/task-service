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
package SA.SRFDA.PS.Core.App;

import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.IPSApplicationObject;
import SA.SRFDA.PS.Core.App.IPSApplicationRuntime;
import SA.SRFDA.PS.Core.DynaModel.IPSSysDynaModel;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelObject3Impl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.Pub.IPSCodePublisherParam;
import SA.SRFDA.PS.Core.Pub.IPSPFPubHelp;
import SA.SRFDA.PS.Core.Pub.IPSPFPubSupportable;
import SA.SRFDA.PS.Core.Pub.IPSSFPubHelp;
import SA.SRFDA.PS.Core.Pub.IPSSFPubSupportable;
import SA.SRFDA.PS.Core.Pub.PSPFPubHelpImpl;
import SA.SRFDA.PS.Core.Pub.PSSFPubHelpImpl;
import SA.SRFDA.PS.Core.Pub.Util.PSTemplHelper;
import SA.SRFDA.PS.Data.PSSysIssue;
import java.util.HashMap;
import java.util.Map;
import net.ibizsys.paas.core.ISystem;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.util.Inflector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSApplicationObjectImpl
extends PSModelObject3Impl
implements IPSApplicationObject,
IPSSFPubSupportable,
IPSPFPubSupportable {
    private static final Log log = LogFactory.getLog(PSApplicationObjectImpl.class);
    public static final String MODELREFTYPE_APPLICATION = "APPLICATION";
    private IPSSFPubHelp iPSSFPubHelp = null;
    private IPSPFPubHelp iPSPFPubHelp = null;
    protected IPSApplication iPSApplication = null;

    @Override
    @PSModelRTMeta(description="\u524d\u7aef\u5e94\u7528", outputdoc="false")
    public IPSApplication getPSApplication() {
        return this.iPSApplication;
    }

    protected void setPSApplication(IPSApplication iPSApplication) {
        this.iPSApplication = iPSApplication;
    }

    @Override
    public String getFullName() {
        if (this.getPSApplication() != null) {
            return String.format("%1$s|%2$s", this.getPSApplication().getFullName(), this.getName());
        }
        return super.getFullName();
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSApplication().getPSSysModelInstId();
    }

    public IPSSystem getPSSystem() {
        return this.getPSApplication().getPSSystem();
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSSystem());
    }

    protected IPSApplicationRuntime getPSApplicationRuntime() {
        return (IPSApplicationRuntime)((Object)this.getPSApplication());
    }

    protected void logPSModelIssue(PSSysIssue psSysIssueV3) throws Exception {
        psSysIssueV3.setOBJTYPE(this.getModelType());
        psSysIssueV3.setPSOBJID(this.getId());
        psSysIssueV3.setPSOBJNAME(this.getName());
        psSysIssueV3.setPSSYSAPPID(this.getPSApplication().getId());
        psSysIssueV3.setPSSYSAPPNAME(this.getPSApplication().getName());
        this.getPSSystemUtil().logPSSysIssue(this, psSysIssueV3);
    }

    @Override
    protected IPSSysDynaModel internalGetPSSysDynaModel(String strPSSysDynaModelId) throws Exception {
        return this.getPSSystem().getPSSysDynaModel(strPSSysDynaModelId);
    }

    public ISystem getSystem() {
        return this.getPSSystem();
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
        try {
            HashMap<String, IPSCodePublisherParam> publisherParamMap = new HashMap<String, IPSCodePublisherParam>();
            this.fillPSSFCodePublisherParams(publisherParamMap);
            this.iPSSFPubHelp = PSSFPubHelpImpl.createPSSFPubHelp(this.getPSSFPubObjTarget(), this.getPSSystem(), this, publisherParamMap);
        }
        catch (Exception exception) {
            log.error((Object)exception);
            return null;
        }
        return this.iPSSFPubHelp;
    }

    protected void fillPSSFCodePublisherParams(Map<String, IPSCodePublisherParam> publisherParamMap) {
    }

    protected String getPSSFPubObjTarget() {
        return this.getModelType();
    }

    @Override
    @PSModelRTMeta(name="[H]\u524d\u7aef\u6a21\u677f\u53d1\u5e03\u5e2e\u52a9", hideempty=true)
    public IPSPFPubHelp getPSPFPubHelp() {
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
        if (this.iPSPFPubHelp != null) {
            return this.iPSPFPubHelp;
        }
        try {
            HashMap<String, IPSCodePublisherParam> publisherParamMap = new HashMap<String, IPSCodePublisherParam>();
            this.fillPSPFCodePublisherParams(publisherParamMap);
            this.iPSPFPubHelp = PSPFPubHelpImpl.createPSPFPubHelp(this.getPSPFPubObjTarget(), this.getPSApplication(), this, publisherParamMap);
        }
        catch (Exception exception) {
            log.error((Object)exception);
            return null;
        }
        return this.iPSPFPubHelp;
    }

    protected void fillPSPFCodePublisherParams(Map<String, IPSCodePublisherParam> publisherParamMap) {
    }

    protected String getPSPFPubObjTarget() {
        return this.getModelType();
    }

    @Override
    protected IPSModelObject onGetParentModel() {
        return this.getPSApplication();
    }

    @Override
    protected IPSModelObject onGetScopeModel() {
        return this.getPSApplication();
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u52a8\u6001\u6a21\u578b", dump=false)
    public boolean isEnableDynaModel() {
        if (this.getPSApplication() != null && !this.getPSApplication().isEnableDynaSys()) {
            return false;
        }
        return this.onGetEnableDynaModel();
    }

    @Override
    protected boolean onGetEnableDynaModel() {
        return true;
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u5b9e\u4f8b\u6a21\u5f0f", dump=false, codelist="DynaInstMode3")
    public int getDynaInstMode() {
        if (this.getPSApplication() != null && !this.getPSApplication().isEnableDynaModel()) {
            return 0;
        }
        return this.onGetDynaInstMode();
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u5b9e\u4f8b\u6807\u8bb0", dump=false, hideempty2=true)
    public String getDynaInstTag() {
        if (this.getDynaInstMode() == 0) {
            return "";
        }
        return this.onGetDynaInstTag();
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u5b9e\u4f8b\u6807\u8bb02", dump=false, hideempty2=true)
    public String getDynaInstTag2() {
        if (this.getDynaInstMode() == 0) {
            return "";
        }
        return this.onGetDynaInstTag2();
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u6a21\u578b\u76ee\u5f55", hideempty2=true, dump=false)
    public String getDynaModelFolder() {
        if (!this.isEnableDynaModel()) {
            return null;
        }
        return this.onGetDynaModelFolder();
    }

    @Override
    protected String onGetDynaModelFolder() {
        if (this.getPSApplication() != null) {
            return String.format("%1$s/%2$s/%3$s", this.getPSApplication().getDynaModelFolder(), Inflector.getInstance().pluralize((Object)this.getDumpModelType()).toUpperCase(), this.getDynaModelTag());
        }
        return super.onGetDynaModelFolder();
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u6a21\u578b\u6587\u4ef6\u8def\u5f84", hideempty=true)
    public String getDynaModelFilePath() {
        if (!this.isEnableDynaModel()) {
            return null;
        }
        String strDynaModelPath = this.getDynaModelFolder();
        if (StringHelper.isNullOrEmpty((String)strDynaModelPath)) {
            return null;
        }
        return String.format("%1$s.json", strDynaModelPath, this.getDumpModelType());
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u5b9e\u4f8b\u6a21\u578b", ignoredumpvalues="false")
    public boolean isDynaInstModel() {
        return !StringHelper.isNullOrEmpty((String)this.getPSDynaInstId());
    }

    @Override
    protected String onGetRTMOSFolder() {
        if (this.getPSApplication() != null) {
            return String.format("%1$s/%2$s", this.getPSApplication().getRTMOSFilePath(), Inflector.getInstance().pluralize((Object)this.getRTMOSModelType()).toLowerCase());
        }
        return Inflector.getInstance().pluralize((Object)this.getRTMOSModelType()).toLowerCase();
    }
}

