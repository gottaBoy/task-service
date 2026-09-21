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

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEAction;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEActionLogic;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDELogic;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEMethod;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEMethodLogic;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEActionLogic;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppDEMethodLogicImpl
extends PSObjectImpl
implements IPSAppDEMethodLogic,
IPSAppDEActionLogic {
    private static final Log log = LogFactory.getLog(PSAppDEMethodLogicImpl.class);
    private IPSDEActionLogic iPSDEActionLogic = null;
    private IPSAppDataEntity iPSAppDataEntity = null;
    private IPSAppDEAction iPSAppDEAction = null;
    private IPSAppDataEntity dstPSAppDataEntity = null;
    private IPSAppDEAction dstPSAppDEAction = null;
    private IPSAppDELogic iPSAppDELogic = null;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSAppDEAction iPSAppDEAction, IPSDEActionLogic iPSDEActionLogic) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSAppDEAction = iPSAppDEAction;
            this.iPSDEActionLogic = iPSDEActionLogic;
            this.iPSAppDataEntity = this.iPSAppDEAction.getPSAppDataEntity();
            this.setId(this.iPSDEActionLogic.getId());
            this.setName(this.iPSDEActionLogic.getName());
            if (!this.isInternalLogic()) {
                if (this.iPSDEActionLogic.getDstPSDE() != null) {
                    this.dstPSAppDataEntity = StringHelper.compare((String)this.getPSAppDataEntity().getId(), (String)this.iPSDEActionLogic.getDstPSDE().getId(), (boolean)false) == 0 ? this.getPSAppDataEntity() : this.getPSAppDataEntity().getPSApplication().getPSAppDataEntity(this.iPSDEActionLogic.getDstPSDE().getId(), false);
                }
                if (this.iPSDEActionLogic.getDstPSDEAction() != null) {
                    this.dstPSAppDEAction = this.getDstPSAppDataEntity().getPSAppDEAction(this.iPSDEActionLogic.getDstPSDEAction().getId(), false);
                }
                if (this.getDstPSAppDEAction() == null) {
                    throw new Exception("\u89e6\u53d1\u5e94\u7528\u5b9e\u4f53\u884c\u4e3a\u65e0\u6548");
                }
            } else {
                if (this.iPSDEActionLogic.getPSDELogic() != null) {
                    this.iPSAppDELogic = this.getPSAppDataEntity().getPSAppDELogic(this.iPSDEActionLogic.getPSDELogic().getId(), false);
                }
                if (this.getPSAppDELogic() == null) {
                    throw new Exception("\u89e6\u53d1\u5e94\u7528\u5b9e\u4f53\u903b\u8f91\u65e0\u6548");
                }
            }
            this.setAutoModel(true);
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
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u65b9\u6cd5")
    public IPSAppDEMethod getPSAppDEMethod() {
        if (this.iPSAppDEAction != null) {
            return this.iPSAppDEAction;
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u884c\u4e3a\u9644\u52a0\u903b\u8f91", hideempty=true)
    public IPSDEActionLogic getPSDEActionLogic() {
        return this.iPSDEActionLogic;
    }

    @Override
    @PSModelRTMeta(description="\u5185\u90e8\u903b\u8f91", ignoredumpvalues="false")
    public boolean isInternalLogic() {
        if (this.getPSDEActionLogic() != null) {
            return this.getPSDEActionLogic().isInternalLogic();
        }
        return false;
    }

    @Override
    @PSModelRTMeta(description="\u514b\u9686\u4f20\u5165\u53c2\u6570", ignoredumpvalues="false")
    public boolean isCloneParam() {
        if (this.getPSDEActionLogic() != null) {
            return this.getPSDEActionLogic().isCloneParam();
        }
        return false;
    }

    @Override
    @PSModelRTMeta(description="\u5ffd\u7565\u5f02\u5e38", ignoredumpvalues="false")
    public boolean isIgnoreException() {
        if (this.getPSDEActionLogic() != null) {
            return this.getPSDEActionLogic().isCloneParam();
        }
        return false;
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u6807\u884c\u4e3a\u6240\u5c5e\u5b9e\u4f53", hideempty=true, dumpref=true)
    public IPSAppDataEntity getDstPSAppDataEntity() {
        return this.dstPSAppDataEntity;
    }

    @Override
    @PSModelRTMeta(description="\u89e6\u53d1\u76ee\u6807\u884c\u4e3a", hideempty=true, dumpref=true, from="__self__", from_method="getDstPSAppDataEntityMust().getPSAppDEAction")
    public IPSAppDEAction getDstPSAppDEAction() {
        return this.dstPSAppDEAction;
    }

    @Override
    @PSModelRTMeta(description="\u884c\u4e3a\u903b\u8f91\u7c7b\u578b", codelist="DEActionLogicType", ignoredumpvalues="-1")
    public int getActionLogicType() {
        if (this.getPSDEActionLogic() != null) {
            return this.getPSDEActionLogic().getActionLogicType();
        }
        return -1;
    }

    @Override
    @PSModelRTMeta(description="\u9644\u52a0\u6a21\u5f0f", codelist="DEActionLogicAttachMode")
    public String getAttachMode() {
        if (this.getPSDEActionLogic() != null) {
            return this.getPSDEActionLogic().getAttachMode();
        }
        return "";
    }

    @Override
    public String getModelType() {
        return "PSAPPDEMETHODLOGIC";
    }

    @Override
    public String getFullModelName() {
        return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSAppDEMethod().getFullModelName(), (Object)this.getModelName());
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSAppDataEntity().getPSDataEntity().getPSSystem());
    }

    @Override
    public String getModelId() {
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSAppDEMethod().getModelId(), (Object)this.getId());
    }

    @Override
    public IPSAppDataEntity getPSAppDataEntity() {
        return this.iPSAppDataEntity;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSAppDataEntity().getPSSysModelInstId();
    }

    @Override
    protected IPSModelObject getProxyPSModelObject() {
        if (this.getPSDEActionLogic() != null) {
            return this.getPSDEActionLogic();
        }
        return super.getProxyPSModelObject();
    }

    public IPSApplication getPSApplication() {
        return this.getPSAppDataEntity().getPSApplication();
    }

    public IPSSystem getPSSystem() {
        return this.getPSApplication().getPSSystem();
    }

    @Override
    @PSModelRTMeta(description="\u811a\u672c\u4ee3\u7801")
    public String getScriptCode() {
        if (this.getPSDEActionLogic() != null) {
            return this.getPSDEActionLogic().getScriptCode();
        }
        return "";
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u903b\u8f91", hideempty=true, dumpref=true, from="IPSAppDataEntity")
    public IPSAppDELogic getPSAppDELogic() {
        return this.iPSAppDELogic;
    }
}

