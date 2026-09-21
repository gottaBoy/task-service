/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.IDataEntity
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.util.Inflector
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntityObject;
import SA.SRFDA.PS.Core.DynaModel.IPSSysDynaModel;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemSetting;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelObject3Impl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.Pub.IPSCodePublisherParam;
import SA.SRFDA.PS.Core.Pub.IPSSFPubHelp;
import SA.SRFDA.PS.Core.Pub.IPSSFPubSupportable;
import SA.SRFDA.PS.Core.Pub.PSSFPubHelpImpl;
import SA.SRFDA.PS.Core.Pub.Util.PSTemplHelper;
import java.util.HashMap;
import java.util.Map;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.util.Inflector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSDataEntityObjectImpl
extends PSModelObject3Impl
implements IPSDataEntityObject,
IPSSFPubSupportable {
    private static final Log log = LogFactory.getLog(PSDataEntityObjectImpl.class);
    private IPSSFPubHelp iPSSFPubHelp = null;
    protected IPSDataEntity iPSDataEntity = null;
    private int nExtendMode = 0;
    public static final String MODELREFTYPE_DATAENTITY = "DATAENTITY";
    public static final String CODETYPE_SUBSYS = "SUBSYS_";

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5bf9\u8c61", outputdoc="false")
    public IPSDataEntity getPSDataEntity() {
        return this.iPSDataEntity;
    }

    protected void setPSDataEntity(IPSDataEntity iPSDataEntity) {
        this.iPSDataEntity = iPSDataEntity;
    }

    public IDataEntity getDataEntity() {
        return this.getPSDataEntity();
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSDataEntity().getPSSystem().getPSSysModelInstId();
    }

    @Override
    public int getExtendMode() {
        return this.nExtendMode;
    }

    protected void setExtendMode(int nExtendMode) {
        this.nExtendMode = nExtendMode;
    }

    @PSModelRTMeta(description="\u7cfb\u7edf\u5bf9\u8c61")
    public IPSSystem getPSSystem() {
        return this.getPSDataEntity().getPSSystem();
    }

    protected IPSSystemSetting getPSSystemSetting() {
        return (IPSSystemSetting)((Object)this.getPSSystem());
    }

    @Override
    protected IPSSysDynaModel internalGetPSSysDynaModel(String strPSSysDynaModelId) throws Exception {
        return this.getPSSystem().getPSSysDynaModel(strPSSysDynaModelId);
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSSystem());
    }

    @Override
    public String getFullModelName() {
        if (this.getPSDataEntity() != null) {
            return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSDataEntity().getFullModelName(), (Object)this.getModelName());
        }
        return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSSystem().getFullModelName(), (Object)this.getModelName());
    }

    @Override
    public String getFullName() {
        if (this.getPSDataEntity() != null) {
            return String.format("%1$s|%2$s", this.getPSDataEntity().getFullName(), this.getName());
        }
        return super.getFullName();
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

    public IPSAppDataEntity getPSAppDataEntity() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u52a8\u6001\u6a21\u578b", dump=false)
    public boolean isEnableDynaModel() {
        return this.onGetEnableDynaModel();
    }

    @Override
    protected boolean onGetEnableDynaModel() {
        if (PSDataEntityObjectImpl.isDynaModelCodeGenMode()) {
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
        if (this.getPSAppDataEntity() != null) {
            return this.getPSAppDataEntity().getDynaInstMode();
        }
        if (this.getPSDataEntity() != null) {
            return this.getPSDataEntity().getDynaInstMode();
        }
        return super.getDynaInstMode();
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u5b9e\u4f8b\u6807\u8bb0", dump=false)
    public String getDynaInstTag() {
        if (this.getPSAppDataEntity() != null) {
            return this.getPSAppDataEntity().getDynaInstTag();
        }
        if (this.getPSDataEntity() != null) {
            return this.getPSDataEntity().getDynaInstTag();
        }
        return super.getDynaInstTag();
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u5b9e\u4f8b\u6807\u8bb02", dump=false)
    public String getDynaInstTag2() {
        if (this.getPSAppDataEntity() != null) {
            return this.getPSAppDataEntity().getDynaInstTag2();
        }
        if (this.getPSDataEntity() != null) {
            return this.getPSDataEntity().getDynaInstTag2();
        }
        return super.getDynaInstTag2();
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u6a21\u578b\u76ee\u5f55", hideempty=true, dump=false)
    public String getDynaModelFolder() {
        if (this.getPSAppDataEntity() != null) {
            return null;
        }
        if (!this.isEnableDynaModel()) {
            return null;
        }
        return this.onGetDynaModelFolder();
    }

    @Override
    protected String onGetDynaModelFolder() {
        if (this.getPSAppDataEntity() != null) {
            return String.format("%1$s/%2$s/%3$s", this.getPSAppDataEntity().getDynaModelFolder(), Inflector.getInstance().pluralize((Object)this.getDumpModelType()).toUpperCase(), this.getDynaModelTag());
        }
        if (this.getPSDataEntity() != null) {
            return String.format("%1$s/%2$s/%3$s", this.getPSDataEntity().getDynaModelFolder(), Inflector.getInstance().pluralize((Object)this.getDumpModelType()).toUpperCase(), this.getDynaModelTag());
        }
        return super.onGetDynaModelFolder();
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
    protected String onGetRTMOSFolder() {
        if (this.getParentModel() != null) {
            return String.format("%1$s/%2$s", this.getParentModel().getRTMOSFilePath(), Inflector.getInstance().pluralize((Object)this.getRTMOSModelType()).toLowerCase());
        }
        return super.onGetRTMOSFolder();
    }

    @Override
    protected IPSModelObject onGetParentModel() {
        if (this.getPSAppDataEntity() != null) {
            return this.getPSAppDataEntity();
        }
        return this.getPSDataEntity();
    }
}

