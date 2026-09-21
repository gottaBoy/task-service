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
import SA.SRFDA.PS.Core.IPSDynaInstSupportable;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemObject;
import SA.SRFDA.PS.Core.IPSSystemRuntime;
import SA.SRFDA.PS.Core.IPSSystemSetting;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelObject2Impl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.Pub.IPSCodePublisherParam;
import SA.SRFDA.PS.Core.Pub.IPSSFPubHelp;
import SA.SRFDA.PS.Core.Pub.IPSSFPubSupportable;
import SA.SRFDA.PS.Core.Pub.PSSFPubHelpImpl;
import SA.SRFDA.PS.Core.Pub.Util.PSTemplHelper;
import SA.SRFDA.PS.Core.Requirement.IPSSysReqItem;
import SA.SRFDA.PS.Core.System.IPSSysModelGroup;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import java.util.HashMap;
import java.util.Map;
import net.ibizsys.paas.core.ISystem;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.util.Inflector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSSystemObjectImpl
extends PSModelObject2Impl
implements IPSSystemObject,
IPSSFPubSupportable,
IPSDynaInstSupportable {
    private static final Log log = LogFactory.getLog(PSSystemObjectImpl.class);
    public static final String MODELREFTYPE_SYSTEM = "SYSTEM";
    private IPSSFPubHelp iPSSFPubHelp = null;
    protected IPSSystem iPSSystem = null;

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf")
    public IPSSystem getPSSystem() {
        return this.iPSSystem;
    }

    protected void setPSSystem(IPSSystem iPSSystem) {
        this.iPSSystem = iPSSystem;
    }

    public ISystem getSystem() {
        return this.getPSSystem();
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSSystem().getPSSysModelInstId();
    }

    public String getRuntimePSSysModelInstId() {
        return this.getPSSystemUtil().getRuntimePSSysModelInstId();
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSSystem());
    }

    protected IPSSystemSetting getPSSystemSetting() {
        return (IPSSystemSetting)((Object)this.getPSSystem());
    }

    protected IPSSystemRuntime getPSSystemRuntime() {
        return (IPSSystemRuntime)((Object)this.getPSSystem());
    }

    @Override
    protected IPSSysDynaModel internalGetPSSysDynaModel(String strPSSysDynaModelId) throws Exception {
        return this.getPSSystem().getPSSysDynaModel(strPSSysDynaModelId);
    }

    @Override
    protected IPSSysReqItem internalGetPSSysReqItem(String strPSSysReqItemId) throws Exception {
        return this.getPSSystem().getPSSysReqItem(strPSSysReqItemId);
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

    @Override
    protected IPSModelObject onGetParentModel() {
        if (this.getPSSystemModule() != null) {
            return this.getPSSystemModule();
        }
        if (this.getPSSysModelGroup() != null) {
            return this.getPSSysModelGroup();
        }
        return this.getPSSystem();
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u52a8\u6001\u6a21\u578b", dump=false)
    public boolean isEnableDynaModel() {
        return this.onGetEnableDynaModel();
    }

    @Override
    protected boolean onGetEnableDynaModel() {
        if (PSSystemObjectImpl.isDynaModelCodeGenMode()) {
            return true;
        }
        if (this.getPSSystem() != null) {
            return this.getPSSystem().isEnableDynaSys();
        }
        return super.onGetEnableDynaModel();
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u5b9e\u4f8b\u6a21\u578b", ignoredumpvalues="false")
    public boolean isDynaInstModel() {
        return !StringHelper.isNullOrEmpty((String)this.getPSDynaInstId());
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u5b9e\u4f8b\u6a21\u5f0f", dump=false, codelist="DynaInstMode3")
    public int getDynaInstMode() {
        return this.onGetDynaInstMode();
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u5b9e\u4f8b\u6807\u8bb0", dump=false)
    public String getDynaInstTag() {
        if (this.getDynaInstMode() == 0) {
            return "";
        }
        return this.onGetDynaInstTag();
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u5b9e\u4f8b\u6807\u8bb02", dump=false)
    public String getDynaInstTag2() {
        if (this.getDynaInstMode() == 0) {
            return "";
        }
        return this.onGetDynaInstTag2();
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u6a21\u578b\u76ee\u5f55", hideempty=true, dump=false)
    public String getDynaModelFolder() {
        if (!this.isEnableDynaModel()) {
            return null;
        }
        return this.onGetDynaModelFolder();
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u6a21\u578b\u6587\u4ef6\u8def\u5f84", hideempty=true)
    public String getDynaModelFilePath() {
        if (!this.isEnableDynaModel()) {
            return null;
        }
        if (this.isExportModelAlways()) {
            return null;
        }
        String strDynaModelPath = this.getDynaModelFolder();
        if (StringHelper.isNullOrEmpty((String)strDynaModelPath)) {
            return null;
        }
        return String.format("%1$s.json", strDynaModelPath, this.getDumpModelType());
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u6a21\u578b\u6807\u8bb0", hideempty=true, dump=false)
    public String getDynaModelTag() {
        if (!this.isEnableDynaModel()) {
            return null;
        }
        return this.onGetDynaModelTag();
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

    public IPSSystemModule getPSSystemModule() {
        return null;
    }

    public IPSSysModelGroup getPSSysModelGroup() {
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
        if (this.getPSSysModelGroup() != null) {
            return String.format("%1$s/%2$s/%3$s", this.getPSSysModelGroup().getDynaModelFolder(), Inflector.getInstance().pluralize((Object)this.getDumpModelType()).toUpperCase(), this.getDynaModelTag());
        }
        return super.onGetDynaModelFolder();
    }

    protected int getPSSystemDynaInstMode() {
        IPSSystemRuntime iPSSystemRuntime = (IPSSystemRuntime)((Object)this.getPSSystem());
        return iPSSystemRuntime.getDynaInstMode();
    }
}

