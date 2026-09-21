/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.App.DataEntity;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEDRGroup;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEDRItem;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.DataEntity.PSAppDataEntityObjectImpl;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.DataEntity.DR.IPSDEDRItem;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelPFIgnoreMeta
public class PSAppDEDRItemImpl
extends PSAppDataEntityObjectImpl
implements IPSAppDEDRItem {
    private static final Log log = LogFactory.getLog(PSAppDEDRItemImpl.class);
    private IPSDEDRItem iPSDEDRItem = null;
    private IPSAppDEDRGroup iPSAppDEDRGroup = null;
    private IPSAppView iPSAppView = null;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSAppDataEntity iPSAppDataEntity, IPSDEDRItem iPSDEDRItem, IPSAppView iPSAppView) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSAppDataEntity(iPSAppDataEntity);
            this.iPSDEDRItem = iPSDEDRItem;
            this.iPSAppView = iPSAppView;
            this.setId(iPSDEDRItem.getId());
            this.setName(iPSDEDRItem.getName());
            this.onInit();
        }
        catch (Exception ex) {
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            if (this.getPSSystemUtil() != null) {
                this.getPSSystemUtil().getPSSysConsole().error(strLogName, strExInfo);
            }
            this.throwInitException(ex);
        }
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5173\u7cfb\u754c\u9762\u5bf9\u8c61")
    public IPSDEDRItem getPSDEDRItem() {
        return this.iPSDEDRItem;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u5173\u7cfb\u754c\u9762\u5206\u7ec4")
    public IPSAppDEDRGroup getPSAppDEDRGroup() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5173\u7cfb\u89c6\u56fe\u5bf9\u8c61")
    public IPSAppView getPSAppView() {
        return this.iPSAppView;
    }

    @Override
    public String getModelId() {
        if (this.getPSAppDataEntity() != null) {
            return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSAppDataEntity().getModelId(), (Object)super.getModelId());
        }
        return super.getModelId();
    }

    @Override
    public String getModelType() {
        return "PSAPPCOUNTER";
    }
}

