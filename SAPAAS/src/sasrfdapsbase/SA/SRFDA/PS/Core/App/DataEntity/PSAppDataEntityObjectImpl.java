/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.pscore.srv.util.Inflector
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.App.DataEntity;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntityObject;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSSystemSetting;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Pub.IPSCodePublisherParam;
import SA.SRFDA.PS.Core.Pub.IPSPFPubHelp;
import SA.SRFDA.PS.Core.Pub.IPSPFPubSupportable;
import SA.SRFDA.PS.Core.Pub.IPSSFPubHelp;
import SA.SRFDA.PS.Core.Pub.IPSSFPubSupportable;
import SA.SRFDA.PS.Core.Pub.PSPFPubHelpImpl;
import SA.SRFDA.PS.Core.Pub.PSSFPubHelpImpl;
import SA.SRFDA.PS.Core.Pub.Util.PSTemplHelper;
import java.util.HashMap;
import java.util.Map;
import net.ibizsys.pscore.srv.util.Inflector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSAppDataEntityObjectImpl
extends PSObjectImpl
implements IPSAppDataEntityObject,
IPSSFPubSupportable,
IPSPFPubSupportable {
    private static final Log log = LogFactory.getLog(PSAppDataEntityObjectImpl.class);
    public static final String MODELREFTYPE_APPDATAENTITY = "APPDATAENTITY";
    private IPSSFPubHelp iPSSFPubHelp = null;
    private IPSPFPubHelp iPSPFPubHelp = null;
    private IPSAppDataEntity iPSAppDataEntity = null;

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u5bf9\u8c61")
    public IPSAppDataEntity getPSAppDataEntity() {
        return this.iPSAppDataEntity;
    }

    public IPSDataEntity getPSDataEntity() {
        if (this.getPSAppDataEntity() != null) {
            return this.getPSAppDataEntity().getPSDataEntity();
        }
        return null;
    }

    public IPSDataEntity getPSDE() {
        return this.getPSDataEntity();
    }

    protected void setPSAppDataEntity(IPSAppDataEntity iPSAppDataEntity) {
        this.iPSAppDataEntity = iPSAppDataEntity;
    }

    @Override
    public String getPSSysModelInstId() {
        if (this.getPSAppDataEntity() != null) {
            return this.getPSAppDataEntity().getPSSysModelInstId();
        }
        return null;
    }

    protected IPSSystemSetting getPSSystemSetting() {
        return (IPSSystemSetting)((Object)this.getPSDataEntity().getPSSystem());
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSDataEntity().getPSSystem());
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
        this.fillPSSFCodePublisherParams(publisherParamMap);
        this.iPSSFPubHelp = PSSFPubHelpImpl.createPSSFPubHelp(this.getPSSFPubObjTarget(), this.getPSAppDataEntity().getPSApplication().getPSSystem(), this, publisherParamMap);
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
        HashMap<String, IPSCodePublisherParam> publisherParamMap = new HashMap<String, IPSCodePublisherParam>();
        this.fillPSPFCodePublisherParams(publisherParamMap);
        this.iPSPFPubHelp = PSPFPubHelpImpl.createPSPFPubHelp(this.getPSPFPubObjTarget(), this.getPSAppDataEntity().getPSApplication(), this, publisherParamMap);
        return this.iPSPFPubHelp;
    }

    protected void fillPSPFCodePublisherParams(Map<String, IPSCodePublisherParam> publisherParamMap) {
    }

    protected String getPSPFPubObjTarget() {
        return this.getModelType();
    }

    @Override
    protected String onGetRTMOSFolder() {
        if (this.getPSAppDataEntity() != null) {
            return String.format("%1$s/%2$s", this.getPSAppDataEntity().getRTMOSFilePath(), Inflector.getInstance().pluralize((Object)this.getRTMOSModelType()).toLowerCase());
        }
        return Inflector.getInstance().pluralize((Object)this.getRTMOSModelType()).toLowerCase();
    }

    @Override
    protected IPSModelObject onGetParentModel() {
        return this.getPSAppDataEntity();
    }
}

