/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.App.Util;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEAction;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.Util.IPSAppDynaUtilBase;
import SA.SRFDA.PS.Core.App.Util.PSAppUtilImpl;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppDynaUtilImplBase
extends PSAppUtilImpl
implements IPSAppDynaUtilBase {
    private static final Log log = LogFactory.getLog(PSAppDynaUtilImplBase.class);
    private IPSAppDataEntity iPSAppDataEntity = null;
    private IPSAppDEAction createPSAppDEAction = null;
    private IPSAppDEAction updatePSAppDEAction = null;
    private IPSAppDEAction getPSAppDEAction = null;
    private IPSAppDEAction removePSAppDEAction = null;
    private IPSAppDEField appIdPSAppDEField = null;
    private IPSAppDEField userIdPSAppDEField = null;
    private IPSAppDEField modelPSAppDEField = null;
    private IPSAppDEField modelIdPSAppDEField = null;

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        IPSDataEntity iPSDataEntity = null;
        if (!StringHelper.isNullOrEmpty((String)this.getUtilPSDEId())) {
            iPSDataEntity = this.getPSSystem().getPSDataEntity2(this.getUtilPSDEId());
            this.iPSAppDataEntity = this.getPSApplication().getPSAppDataEntity(iPSDataEntity, true);
        }
        if (this.getStoragePSAppDataEntity() == null) {
            if (iPSDataEntity == null) {
                this.getPSSystemUtil().getPSSysConsole().warn(this.getLogName(), StringHelper.format((String)"\u529f\u80fd\u5b58\u50a8\u5e94\u7528\u5b9e\u4f53\u65e0\u6548"));
            } else {
                this.getPSSystemUtil().getPSSysConsole().warn(this.getLogName(), StringHelper.format((String)"\u529f\u80fd\u5b58\u50a8\u5e94\u7528\u5b9e\u4f53\u65e0\u6548\uff0c\u5b9e\u4f53[%1$s]\u672a\u52a0\u5165\u5230\u5e94\u7528", (Object)iPSDataEntity.getName()));
            }
        } else {
            IPSDEField iPSDEField;
            IPSDEAction iPSDEAction;
            if (this.getCreatePSAppDEAction() == null && (iPSDEAction = this.getStoragePSAppDataEntity().getPSDE().getPSDEAction(this.getCreateDEActionName(), true)) != null) {
                this.createPSAppDEAction = this.getStoragePSAppDataEntity().getPSAppDEAction(iPSDEAction, true);
            }
            if (this.getUpdatePSAppDEAction() == null && (iPSDEAction = this.getStoragePSAppDataEntity().getPSDE().getPSDEAction(this.getUpdateDEActionName(), true)) != null) {
                this.updatePSAppDEAction = this.getStoragePSAppDataEntity().getPSAppDEAction(iPSDEAction, true);
            }
            if (this.getGetPSAppDEAction() == null && (iPSDEAction = this.getStoragePSAppDataEntity().getPSDE().getPSDEAction(this.getGetDEActionName(), true)) != null) {
                this.getPSAppDEAction = this.getStoragePSAppDataEntity().getPSAppDEAction(iPSDEAction, true);
            }
            if (this.getRemovePSAppDEAction() == null && (iPSDEAction = this.getStoragePSAppDataEntity().getPSDE().getPSDEAction(this.getRemoveDEActionName(), true)) != null) {
                this.removePSAppDEAction = this.getStoragePSAppDataEntity().getPSAppDEAction(iPSDEAction, true);
            }
            if (!StringHelper.isNullOrEmpty((String)this.getAppIdDEFieldName()) && this.getAppIdPSAppDEField() == null && (iPSDEField = this.getStoragePSAppDataEntity().getPSDE().getPSDEField(this.getAppIdDEFieldName(), true)) != null) {
                this.appIdPSAppDEField = this.getStoragePSAppDataEntity().getPSAppDEField(iPSDEField, true);
            }
            if (!StringHelper.isNullOrEmpty((String)this.getUserIdDEFieldName()) && this.getUserIdPSAppDEField() == null && (iPSDEField = this.getStoragePSAppDataEntity().getPSDE().getPSDEField(this.getUserIdDEFieldName(), true)) != null) {
                this.userIdPSAppDEField = this.getStoragePSAppDataEntity().getPSAppDEField(iPSDEField, true);
            }
            if (!StringHelper.isNullOrEmpty((String)this.getModelIdDEFieldName()) && this.getModelIdPSAppDEField() == null && (iPSDEField = this.getStoragePSAppDataEntity().getPSDE().getPSDEField(this.getModelIdDEFieldName(), true)) != null) {
                this.modelIdPSAppDEField = this.getStoragePSAppDataEntity().getPSAppDEField(iPSDEField, true);
            }
            if (!StringHelper.isNullOrEmpty((String)this.getModelDEFieldName()) && this.getModelPSAppDEField() == null && (iPSDEField = this.getStoragePSAppDataEntity().getPSDE().getPSDEField(this.getModelDEFieldName(), true)) != null) {
                this.modelPSAppDEField = this.getStoragePSAppDataEntity().getPSAppDEField(iPSDEField, true);
            }
        }
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd\u6570\u636e\u5b58\u50a8\u5b9e\u4f53", dumpref=true, outputdoc="false")
    public IPSAppDataEntity getStoagePSAppDataEntity() {
        return this.iPSAppDataEntity;
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd\u6570\u636e\u5b58\u50a8\u5b9e\u4f53", dumpref=true)
    public IPSAppDataEntity getStoragePSAppDataEntity() {
        return this.iPSAppDataEntity;
    }

    @Override
    @PSModelRTMeta(description="\u5efa\u7acb\u6570\u636e\u884c\u4e3a", dumpref=true, from="__self__", from_method="getStoragePSAppDataEntityMust().getPSAppDEAction")
    public IPSAppDEAction getCreatePSAppDEAction() {
        return this.createPSAppDEAction;
    }

    @Override
    @PSModelRTMeta(description="\u66f4\u65b0\u6570\u636e\u884c\u4e3a", dumpref=true, from="__self__", from_method="getStoragePSAppDataEntityMust().getPSAppDEAction")
    public IPSAppDEAction getUpdatePSAppDEAction() {
        return this.updatePSAppDEAction;
    }

    @Override
    @PSModelRTMeta(description="\u5220\u9664\u6570\u636e\u884c\u4e3a", dumpref=true, from="__self__", from_method="getStoragePSAppDataEntityMust().getPSAppDEAction")
    public IPSAppDEAction getRemovePSAppDEAction() {
        return this.removePSAppDEAction;
    }

    @Override
    @PSModelRTMeta(description="\u83b7\u53d6\u6570\u636e\u884c\u4e3a", dumpref=true, from="__self__", from_method="getStoragePSAppDataEntityMust().getPSAppDEAction")
    public IPSAppDEAction getGetPSAppDEAction() {
        return this.getPSAppDEAction;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u6807\u8bc6\u5b58\u50a8\u5c5e\u6027", dumpref=true, from="__self__", from_method="getStoragePSAppDataEntityMust().getPSAppDEField")
    public IPSAppDEField getAppIdPSAppDEField() {
        return this.appIdPSAppDEField;
    }

    @Override
    @PSModelRTMeta(description="\u7528\u6237\u6807\u8bc6\u5b58\u50a8\u5c5e\u6027", dumpref=true, from="__self__", from_method="getStoragePSAppDataEntityMust().getPSAppDEField")
    public IPSAppDEField getUserIdPSAppDEField() {
        return this.userIdPSAppDEField;
    }

    @Override
    @PSModelRTMeta(description="\u6a21\u578b\u5b58\u50a8\u5c5e\u6027", dumpref=true, from="__self__", from_method="getStoragePSAppDataEntityMust().getPSAppDEField")
    public IPSAppDEField getModelPSAppDEField() {
        return this.modelPSAppDEField;
    }

    @Override
    @PSModelRTMeta(description="\u6a21\u578b\u6807\u8bc6\u5b58\u50a8\u5c5e\u6027", dumpref=true, from="__self__", from_method="getStoragePSAppDataEntityMust().getPSAppDEField")
    public IPSAppDEField getModelIdPSAppDEField() {
        return this.modelIdPSAppDEField;
    }

    public String getCreateDEActionName() {
        return "CREATE";
    }

    public String getUpdateDEActionName() {
        return "UPDATE";
    }

    public String getGetDEActionName() {
        return "GET";
    }

    public String getRemoveDEActionName() {
        return "REMOVE";
    }

    public String getAppIdDEFieldName() {
        return "APPID";
    }

    public String getUserIdDEFieldName() {
        return "USERID";
    }

    public String getModelDEFieldName() {
        return "MODEL";
    }

    public String getModelIdDEFieldName() {
        return "MODELID";
    }
}

