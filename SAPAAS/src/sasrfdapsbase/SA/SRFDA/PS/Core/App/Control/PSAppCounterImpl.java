/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.App.Control;

import SA.SRFDA.PS.Core.App.Control.IPSAppCounter;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEAction;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEDataSet;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEMethod;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.PSApplicationObjectImpl;
import SA.SRFDA.PS.Core.Control.Counter.IPSCounter;
import SA.SRFDA.PS.Core.Control.Counter.IPSCounterType;
import SA.SRFDA.PS.Core.Control.Counter.IPSSysCounter;
import SA.SRFDA.PS.Core.Control.Counter.IPSSysCounterItem;
import SA.SRFDA.PS.Core.Control.IPSNavigateContext;
import SA.SRFDA.PS.Core.Control.IPSNavigateParam;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PF.IPSPFLogicCodeObject;
import SA.SRFDA.PS.Core.PF.IPSPFPlugin;
import SA.SRFDA.PS.Core.PF.PSPFXCodeObjectProxy;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPub;
import SA.SRFDA.PS.Core.Pub.IPSXCodeObject;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysPFPluginTempl;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Data.PSSysCounter;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppCounterImpl
extends PSApplicationObjectImpl
implements IPSAppCounter,
IPSPFLogicCodeObject {
    private static final Log log = LogFactory.getLog(PSAppCounterImpl.class);
    private IPSSysCounter iPSSysCounter = null;
    private IPSAppDataEntity iPSAppDataEntity = null;
    private IPSAppDEMethod iPSAppDEMethod = null;
    private IPSXCodeObject iPSXCodeObject = null;
    private IPSSysPFPlugin iPSSysPFPlugin = null;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSApplication iPSApplication, IPSSysCounter iPSSysCounter) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSApplication(iPSApplication);
            this.iPSSysCounter = iPSSysCounter;
            this.setId(iPSSysCounter.getId());
            this.setName(iPSSysCounter.getName());
            if (this.getPSDataEntity() != null) {
                this.iPSAppDataEntity = this.getPSApplication().getPSAppDataEntity(this.getPSDataEntity(), true);
            }
            if (this.getPSAppDataEntity() != null) {
                if (this.getPSDEAction() != null) {
                    this.iPSAppDEMethod = this.getPSAppDataEntity().getPSAppDEMethod(this.getPSDEAction(), true);
                } else if (this.getPSDEDataSet() != null) {
                    this.iPSAppDEMethod = this.getPSAppDataEntity().getPSAppDEMethod(this.getPSDEDataSet(), true);
                }
            }
            if (this.iPSSysCounter.getPSSysPFPlugin() != null) {
                this.iPSSysPFPlugin = this.getPSApplication().getPSSysPFPlugin(this.iPSSysCounter.getPSSysPFPlugin().getId(), "UICOUNTER", null, null);
            }
            if (this.getPSSysPFPlugin() != null) {
                String strPSSysPFPluginTemplId = KeyValueHelper.genUniqueId((String)this.getPSSysPFPlugin().getId(), (String)this.getPSApplication().getPSPF().getId());
                IPSSysPFPluginTempl iPSSysPFPluginTempl = this.getPSApplication().getPSSystem().getPSSysPFPluginTempl(strPSSysPFPluginTemplId, true);
                if (iPSSysPFPluginTempl != null) {
                    HashMap<String, Object> params = new HashMap<String, Object>();
                    params.put("app", this.getPSApplication());
                    this.iPSXCodeObject = new PSPFXCodeObjectProxy(iPSSysPFPluginTempl, null, null, (Object)this, params);
                }
            }
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
    public String getModelId() {
        if (this.getPSApplication() != null) {
            return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSApplication().getModelId(), (Object)super.getModelId());
        }
        return super.getModelId();
    }

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem, PSSysCounter psSysCounter) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u8ba1\u6570\u5668", outputdoc="false")
    public IPSSysCounter getPSSysCounter() {
        return this.iPSSysCounter;
    }

    @Override
    @PSModelRTMeta(description="\u8ba1\u6570\u5668\u7c7b\u578b", codelist="CounterType", group="\u57fa\u672c", order=125, fields={"PSCOUNTERID"})
    public String getCounterType() {
        return this.getPSSysCounter().getCounterType();
    }

    @Override
    public IPSCounterType getPSCounterType() {
        return this.getPSSysCounter().getPSCounterType();
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.onGetCodeName();
    }

    protected String onGetCodeName() {
        return this.calcCodeName();
    }

    protected String calcCodeName() {
        if (this.getPSApplication().isEnableUIModelEx()) {
            return this.getPSSysCounter().getUniqueTag();
        }
        return this.getPSSysCounter().getCodeName();
    }

    @Override
    public String getBaseClass(String strPSSFStyleId) throws Exception {
        return this.getPSSysCounter().getBaseClass(strPSSFStyleId);
    }

    @Override
    @PSModelRTMeta(description="\u5237\u65b0\u95f4\u9694\uff08ms\uff09", ignoredumpvalues="0;-1", fields={"RELOADTIMER"})
    public int getTimer() {
        return this.getPSSysCounter().getTimer();
    }

    @Override
    public boolean getRefFlag() {
        return this.getPSSysCounter().getRefFlag();
    }

    @Override
    public String getClassOrPkgName(String strCodeType, IPSSysSFPub iPSSysSFPub) throws Exception {
        return this.getPSSysCounter().getClassOrPkgName(strCodeType, iPSSysSFPub);
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u6a21\u5757")
    public IPSSystemModule getPSSystemModule() {
        return this.getPSSysCounter().getPSSystemModule();
    }

    @Override
    public boolean isSubSysCounter() {
        return this.getPSSysCounter().isSubSysCounter();
    }

    @Override
    public String getModelType() {
        return "PSAPPCOUNTER";
    }

    @Override
    public Iterator<IPSSysCounterItem> getPSSysCounterItems() {
        return this.getPSSysCounter().getPSSysCounterItems();
    }

    @Override
    public IPSCounter getPSCounter() {
        return this.getPSSysCounter().getPSCounter();
    }

    @Override
    @PSModelRTMeta(description="\u540e\u53f0\u670d\u52a1\u53d1\u5e03\u5bf9\u8c61", hideempty=true)
    public IPSSysSFPub getPSSysSFPub() {
        return this.getPSSysCounter().getPSSysSFPub();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5bf9\u8c61", hideempty=true, outputdoc="false")
    public IPSDataEntity getPSDataEntity() {
        return this.getPSSysCounter().getPSDataEntity();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u884c\u4e3a\u5bf9\u8c61", hideempty=true, outputdoc="false", ignorert=3)
    public IPSDEAction getPSDEAction() throws Exception {
        return this.getPSSysCounter().getPSDEAction();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u6570\u636e\u96c6\u5bf9\u8c61", hideempty=true, outputdoc="false", ignorert=3)
    public IPSDEDataSet getPSDEDataSet() throws Exception {
        return this.getPSSysCounter().getPSDEDataSet();
    }

    @Override
    @PSModelRTMeta(description="\u81ea\u5b9a\u4e49\u67e5\u8be2\u6761\u4ef6", hideempty2=true, fields={"CUSTOMCOND"})
    public String getCustomCond() {
        return this.getPSSysCounter().getCustomCond();
    }

    @Override
    public IPSAppDEMethod getPSAppDEMethod() {
        return this.iPSAppDEMethod;
    }

    @Override
    @PSModelRTMeta(description="\u8ba1\u7b97\u5e94\u7528\u5b9e\u4f53\u884c\u4e3a", hideempty=true, from="IPSAppDataEntity", dumpref=true, fields={"PSDEACTIONID"})
    public IPSAppDEAction getGetPSAppDEAction() {
        if (this.iPSAppDEMethod instanceof IPSAppDEAction && StringHelper.compare((String)this.iPSAppDEMethod.getMethodType(), (String)"DEACTION", (boolean)false) == 0) {
            return (IPSAppDEAction)this.iPSAppDEMethod;
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u8ba1\u7b97\u5e94\u7528\u5b9e\u4f53\u6570\u636e\u96c6", hideempty=true, from="IPSAppDataEntity", dumpref=true, fields={"PSDEDATASETID"})
    public IPSAppDEDataSet getGetPSAppDEDataSet() {
        if (this.iPSAppDEMethod instanceof IPSAppDEDataSet && StringHelper.compare((String)this.iPSAppDEMethod.getMethodType(), (String)"FETCH", (boolean)false) == 0) {
            return (IPSAppDEDataSet)this.iPSAppDEMethod;
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u5bf9\u8c61", hideempty=true, dumpref=true, fields={"PSDEID"})
    public IPSAppDataEntity getPSAppDataEntity() {
        return this.iPSAppDataEntity;
    }

    @Override
    @PSModelRTMeta(description="\u6269\u5c55\u7ed8\u5236\u5668", hideempty=true)
    public IPSXCodeObject getRender() {
        return this.iPSXCodeObject;
    }

    @Override
    @PSModelRTMeta(description="\u8ba1\u6570\u5668\u6570\u636e", hideempty2=true, fields={"COUNTERDATA"})
    public String getCounterData() {
        return this.getPSSysCounter().getCounterData();
    }

    @Override
    @PSModelRTMeta(description="\u8ba1\u6570\u5668\u6570\u636e2", hideempty2=true, fields={"COUNTERDATA2"})
    public String getCounterData2() {
        return this.getPSSysCounter().getCounterData2();
    }

    @Override
    @PSModelRTMeta(description="\u524d\u7aef\u6a21\u677f\u63d2\u4ef6\u5bf9\u8c61", hideempty=true)
    public IPSSysPFPlugin getPSSysPFPlugin() {
        if (this.iPSSysPFPlugin != null) {
            return this.iPSSysPFPlugin;
        }
        return this.getPSSysCounter().getPSSysPFPlugin();
    }

    @Override
    @PSModelRTMeta(description="\u540e\u7aef\u6a21\u677f\u63d2\u4ef6\u5bf9\u8c61", hideempty=true)
    public IPSSysSFPlugin getPSSysSFPlugin() {
        return this.getPSSysCounter().getPSSysSFPlugin();
    }

    @Override
    protected IPSModelObject getProxyPSModelObject() {
        return this.getPSSysCounter();
    }

    @Override
    @PSModelRTMeta(description="\u524d\u7aef\u6a21\u677f\u903b\u8f91\u7c7b\u522b", dump=false)
    public String getPFLogicCodeCat() {
        return "COUNTER";
    }

    @Override
    @PSModelRTMeta(description="\u524d\u7aef\u6a21\u677f\u903b\u8f91\u7c7b\u578b", dump=false)
    public String getPFLogicCodeType() {
        if (StringHelper.isNullOrEmpty((String)this.getPSCounterId())) {
            return this.getCounterType();
        }
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getCounterType(), (Object)this.getPSCounterId());
    }

    @Override
    public IPSPFPlugin getPSPFPlugin() {
        return this.getPSSysPFPlugin();
    }

    @Override
    @PSModelRTMeta(description="\u9884\u7f6e\u8ba1\u6570\u5668\u6807\u8bc6", hideempty2=true)
    public String getPSCounterId() {
        return this.getPSSysCounter().getPSCounterId();
    }

    @Override
    @PSModelRTMeta(description="\u8ba1\u6570\u5668\u6807\u8bb0")
    public String getUniqueTag() {
        return this.getPSSysCounter().getUniqueTag();
    }

    @Override
    @PSModelRTMeta(description="\u5bfc\u822a\u53c2\u6570\u96c6\u5408", child=true, group="\u903b\u8f91", order=216)
    public Iterator<? extends IPSNavigateParam> getPSNavigateParams() throws Exception {
        return this.getPSSysCounter().getPSNavigateParams();
    }

    @Override
    @PSModelRTMeta(description="\u5bfc\u822a\u4e0a\u4e0b\u6587\u96c6\u5408", child=true, group="\u903b\u8f91", order=215)
    public Iterator<? extends IPSNavigateContext> getPSNavigateContexts() throws Exception {
        return this.getPSSysCounter().getPSNavigateContexts();
    }

    @Override
    public int getOrderValue() {
        return 99999;
    }

    @Override
    protected void onFillModelNode(ObjectNode objectNode, String strModelType) throws Exception {
        super.onFillModelNode(objectNode, strModelType);
    }
}

