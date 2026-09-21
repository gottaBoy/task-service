/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.core.IDEActionCaller
 *  net.ibizsys.paas.core.IDataEntity
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.Service;

import SA.SRFDA.PS.Core.DEField.IPSDEFGroup;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEActionInput;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEActionLogic;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEActionParam;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEActionReturn;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEActionTempl;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEActionVR;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDELogicAction;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogic;
import SA.SRFDA.PS.Core.DataEntity.Priv.IPSDEOPPriv;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEActionMethod;
import SA.SRFDA.PS.Core.DataEntity.Service.PSDEMethodImplBase;
import SA.SRFDA.PS.Core.DynaModel.IPSSysDynaModel;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysSFPluginTempl;
import SA.SRFDA.PS.Core.Res.IPSSysUniState;
import SA.SRFDA.PS.Core.SF.IPSSFXCodeObject;
import SA.SRFDA.PS.Core.SF.PSSFXCodeObjectProxy;
import SA.SRFDA.PS.Core.Service.IPSRESTfulAPI;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIDEMethod;
import SA.SRFDA.PS.Core.Testing.IPSSysTestCase;
import SA.SRFDA.PS.Data.PSDEAction;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;
import java.util.Properties;
import net.ibizsys.paas.core.IDEActionCaller;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelIgnoreMeta
public class PSDEActionMethodImpl
extends PSDEMethodImplBase
implements IPSDEActionMethod {
    private static final Log log = LogFactory.getLog(PSDEActionMethodImpl.class);
    private IPSDEAction iPSDEAction = null;
    private IPSSFXCodeObject iPSSFXCodeObject = null;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEAction iPSDEAction) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSDEAction(iPSDEAction);
            if (this.getDAGlobalHelper() == null || this.getPSDEAction() == null) {
                throw new Exception("\u4f20\u5165\u53c2\u6570\u65e0\u6548");
            }
            this.setPSDataEntity(this.getPSDEAction().getPSDataEntity());
            this.setId(this.getPSDEAction().getId());
            this.setName(this.getPSDEAction().getName());
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
        if (this.getPSDEAction().getPSSysSFPlugin() != null) {
            String strPSSysSFPluginTemplId = KeyValueHelper.genUniqueId((String)this.getPSDEAction().getPSSysSFPlugin().getId(), (String)this.getPSSystem().getPSSFId());
            IPSSysSFPluginTempl iPSSysSFPluginTempl = this.getPSSystem().getPSSysSFPluginTempl(strPSSysSFPluginTemplId, true);
            if (iPSSysSFPluginTempl != null) {
                this.iPSSFXCodeObject = new PSSFXCodeObjectProxy(iPSSysSFPluginTempl, this);
            }
        }
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u65b9\u6cd5\u7c7b\u578b", codelist="DESADetailType")
    public String getMethodType() {
        return "DEACTION";
    }

    @Override
    public String getModelType() {
        return "PSDEACTIONMETHOD";
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.getPSDEAction().getCodeName();
    }

    @Override
    @PSModelRTMeta(description="\u6269\u5c55\u7ed8\u5236\u5668", hideempty=true)
    public IPSSFXCodeObject getRender() {
        return this.iPSSFXCodeObject;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u884c\u4e3a")
    public IPSDEAction getPSDEAction() {
        return this.iPSDEAction;
    }

    protected void setPSDEAction(IPSDEAction iPSDEAction) {
        this.iPSDEAction = iPSDEAction;
    }

    @Override
    protected IPSModelObject getProxyPSModelObject() {
        return this.getPSDEAction();
    }

    @Override
    @PSModelRTMeta(description="\u884c\u4e3a\u7c7b\u578b", codelist="DEActionType2")
    public String getActionType() {
        return this.getPSDEAction().getActionType();
    }

    @Override
    public IDataEntity getDataEntity() {
        return this.getPSDEAction().getDataEntity();
    }

    public IDEActionCaller getDEActionCaller() throws Exception {
        return this.getPSDEAction().getDEActionCaller();
    }

    public void releaseDEActionCaller(IDEActionCaller iDEActionCaller) {
    }

    public String getCallerObject() {
        return this.getPSDEAction().getCallerObject();
    }

    @Override
    public int getTimeOut() {
        return this.getPSDEAction().getTimeOut();
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u540d\u79f0")
    public String getLogicName() {
        return this.getPSDEAction().getLogicName();
    }

    @Override
    public Iterator<IPSDEActionLogic> getPSDEActionLogics(String strAttachMode) {
        return this.getPSDEAction().getPSDEActionLogics(strAttachMode);
    }

    @Override
    @PSModelRTMeta(description="\u884c\u4e3a\u9644\u52a0\u903b\u8f91\u96c6\u5408")
    public Iterator<IPSDEActionLogic> getPSDEActionLogics() {
        return this.getPSDEAction().getPSDEActionLogics();
    }

    @Override
    @PSModelRTMeta(description="\u884c\u4e3a\u53c2\u6570\u96c6\u5408")
    public Iterator<IPSDEActionParam> getPSDEActionParams() {
        return this.getPSDEAction().getPSDEActionParams();
    }

    @Override
    @PSModelRTMeta(description="\u884c\u4e3a\u9644\u52a0\u503c\u89c4\u5219\u96c6\u5408")
    public Iterator<IPSDEActionVR> getPSDEActionVRs() {
        return this.getPSDEAction().getPSDEActionVRs();
    }

    @Override
    @PSModelRTMeta(description="\u4ea7\u751f\u6d4b\u8bd5\u5355\u5143", dump=false)
    public boolean isGenerateTestUnit() {
        return this.getPSDEAction().isGenerateTestUnit();
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u53d1\u5e03\u670d\u52a1", dump=false)
    public boolean isPubServiceDefault() {
        return this.getPSDEAction().isPubServiceDefault();
    }

    @Override
    public IPSRESTfulAPI getPSRESTfulAPI() {
        return (IPSRESTfulAPI)((Object)this.getPSDEAction());
    }

    @Override
    @PSModelRTMeta(description="\u884c\u4e3a\u53c2\u6570\u6a21\u5f0f", codelist="DEActionParamMode")
    public int getParamMode() {
        return this.getPSDEAction().getParamMode();
    }

    @Override
    @PSModelRTMeta(description="\u81ea\u5b9a\u4e49\u884c\u4e3a\u53c2\u6570")
    public boolean isCustomParam() {
        return this.getPSDEAction().isCustomParam();
    }

    @Override
    @PSModelRTMeta(description="\u884c\u4e3a\u6a21\u677f\u5bf9\u8c61", hideempty=true)
    public IPSDEActionTempl getPSDEActionTempl() {
        return this.getPSDEAction().getPSDEActionTempl();
    }

    @Override
    @PSModelRTMeta(description="\u5b50\u7cfb\u7edf\u6269\u5c55", codelist="DEExtendMode")
    public int getExtendMode() {
        return this.getPSDEAction().getExtendMode();
    }

    @Override
    public int getDevTaskState() {
        return this.getPSDEAction().getDevTaskState();
    }

    @Override
    public String getDevTaskToDo() {
        return this.getPSDEAction().getDevTaskToDo();
    }

    @Override
    public String getDevTaskLink() {
        return this.getPSDEAction().getDevTaskLink();
    }

    @Override
    @PSModelRTMeta(description="\u64cd\u4f5c\u7c7b\u578b", codelist="DEActionMode")
    public String getActionMode() {
        return this.getPSDEAction().getActionMode();
    }

    @Override
    public boolean isEnableBatchAction() {
        return this.getPSDEAction().isEnableBatchAction();
    }

    @Override
    public boolean isBatchAction() {
        return this.getPSDEAction().isBatchAction();
    }

    @Override
    @PSModelRTMeta(description="\u6279\u64cd\u4f5c\u6a21\u5f0f", ignoredumpvalues="0", codelist="DEActionBatchMode")
    public int getBatchActionMode() {
        return this.getPSDEAction().getBatchActionMode();
    }

    @Override
    @PSModelRTMeta(description="\u5b50\u7cfb\u7edf\u5b9e\u4f53\u63a5\u53e3\u65b9\u6cd5", hideempty=true)
    public IPSSubSysServiceAPIDEMethod getPSSubSysServiceAPIDEMethod() throws Exception {
        return this.getPSDEAction().getPSSubSysServiceAPIDEMethod();
    }

    @Override
    @PSModelRTMeta(description="\u884c\u4e3a\u6301\u6709\u8005", codelist="DELogicHolder", dump=false)
    public int getActionHolder() {
        return this.getPSDEAction().getActionHolder();
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u540e\u53f0\u6267\u884c", dump=false)
    public boolean isEnableBackend() {
        return this.getPSDEAction().isEnableBackend();
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u524d\u53f0\u6267\u884c", dump=false)
    public boolean isEnableFront() {
        return this.getPSDEAction().isEnableFront();
    }

    @Override
    @PSModelRTMeta(description="\u524d\u7aef\u6269\u5c55\u63d2\u4ef6", hideempty=true)
    public IPSSysPFPlugin getPSSysPFPlugin() {
        return this.getPSDEAction().getPSSysPFPlugin();
    }

    @Override
    @PSModelRTMeta(description="\u540e\u53f0\u6269\u5c55\u63d2\u4ef6", hideempty=true)
    public IPSSysSFPlugin getPSSysSFPlugin() {
        return this.getPSDEAction().getPSSysSFPlugin();
    }

    @Override
    public String getPSSubSysServiceAPIDEMethodId() {
        return this.getPSDEAction().getPSSubSysServiceAPIDEMethodId();
    }

    @Override
    @PSModelRTMeta(description="\u9884\u7f6e\u884c\u4e3a")
    public boolean isBuiltinAction() {
        return this.getPSDEAction().isBuiltinAction();
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u4e34\u65f6\u6570\u636e", ignoredumpvalues="false")
    public boolean isEnableTempData() {
        return this.getPSDEAction().isEnableTempData();
    }

    @Override
    @PSModelRTMeta(description="\u4e34\u65f6\u6570\u636e\u6a21\u5f0f", codelist="TempDataMode", ignoredumpvalues="0")
    public int getTempDataMode() {
        return this.getPSDEAction().getTempDataMode();
    }

    @Override
    @PSModelRTMeta(description="\u670d\u52a1\u8bbf\u95ee\u64cd\u4f5c\u6807\u8bc6")
    public IPSDEOPPriv getPSDEOPPriv() {
        return this.getPSDEAction().getPSDEOPPriv();
    }

    @Override
    @PSModelRTMeta(description="\u6d4b\u8bd5\u884c\u4e3a\u6a21\u5f0f")
    public int getTestActionMode() {
        return this.getPSDEAction().getTestActionMode();
    }

    @Override
    @PSModelRTMeta(description="\u51c6\u5907\u9644\u52a0\u903b\u8f91\u96c6\u5408")
    public Iterator<IPSDEActionLogic> getPreparePSDEActionLogics() {
        return this.getPSDEAction().getPreparePSDEActionLogics();
    }

    @Override
    @PSModelRTMeta(description="\u68c0\u67e5\u9644\u52a0\u903b\u8f91\u96c6\u5408")
    public Iterator<IPSDEActionLogic> getCheckPSDEActionLogics() {
        return this.getPSDEAction().getCheckPSDEActionLogics();
    }

    @Override
    @PSModelRTMeta(description="\u6267\u884c\u524d\u9644\u52a0\u903b\u8f91\u96c6\u5408")
    public Iterator<IPSDEActionLogic> getBeforePSDEActionLogics() {
        return this.getPSDEAction().getBeforePSDEActionLogics();
    }

    @Override
    @PSModelRTMeta(description="\u6267\u884c\u540e\u9644\u52a0\u903b\u8f91\u96c6\u5408")
    public Iterator<IPSDEActionLogic> getAfterPSDEActionLogics() {
        return this.getPSDEAction().getAfterPSDEActionLogics();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5904\u7406\u903b\u8f91", hideempty=true)
    public IPSDELogic getPSDELogic() throws Exception {
        if (this.getPSDEAction() instanceof IPSDELogicAction) {
            return ((IPSDELogicAction)this.getPSDEAction()).getPSDELogic();
        }
        return null;
    }

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDataEntity iPSDataEntity, PSDEAction psDEAction) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @Override
    @PSModelRTMeta(description="\u884c\u4e3a\u6b21\u5e8f")
    public int getOrderValue() {
        return this.getPSDEAction().getOrderValue();
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528")
    public boolean isValid() {
        return this.getPSDEAction().isValid();
    }

    @Override
    @PSModelRTMeta(description="\u4e8b\u52a1\u6a21\u5f0f")
    public String getTransactionMode() {
        return this.getPSDEAction().getTransactionMode();
    }

    @Override
    @PSModelRTMeta(description="\u7ee7\u627f\u884c\u4e3a", hideempty=true)
    public IPSDEAction getInheritPSDEAction() throws Exception {
        return this.getPSDEAction().getInheritPSDEAction();
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u8bbf\u95ee\u5ba1\u8ba1", ignoredumpvalues="false")
    public boolean isEnableAudit() {
        return this.getPSDEAction().isEnableAudit();
    }

    @Override
    @PSModelRTMeta(description="\u51c6\u5907\u64cd\u4f5c\u4e4b\u524d\u6570\u636e", ignoredumpvalues="false")
    public boolean isPrepareLast() {
        return this.getPSDEAction().isPrepareLast();
    }

    @Override
    @PSModelRTMeta(description="\u51c6\u5907\u64cd\u4f5c\u4e4b\u524d\u6570\u636e\u6a21\u5f0f", ignoredumpvalues="0", codelist="DEActionPrepareLastMode")
    public int getPrepareLastMode() {
        return this.getPSDEAction().getPrepareLastMode();
    }

    @Override
    @PSModelRTMeta(description="\u8f93\u5165\u5c5e\u6027\u7ec4\u5bf9\u8c61", hideempty=true, dump=false)
    public IPSDEFGroup getInPSDEFGroup() {
        return this.getPSDEAction().getInPSDEFGroup();
    }

    @Override
    @PSModelRTMeta(description="\u8f93\u51fa\u5c5e\u6027\u7ec4\u5bf9\u8c61", hideempty=true, dump=false)
    public IPSDEFGroup getOutPSDEFGroup() {
        return this.getPSDEAction().getOutPSDEFGroup();
    }

    @Override
    @PSModelRTMeta(description="\u8c03\u7528\u8f93\u5165\u5bf9\u8c61", child=true, ignorepf=true, doctype="item", group="\u57fa\u672c", order=135)
    public IPSDEActionInput getPSDEActionInput() {
        return this.getPSDEAction().getPSDEActionInput();
    }

    @Override
    @PSModelRTMeta(description="\u8c03\u7528\u8fd4\u56de\u5bf9\u8c61", child=true, ignorepf=true, doctype="item", group="\u57fa\u672c", order=136)
    public IPSDEActionReturn getPSDEActionReturn() {
        return this.getPSDEAction().getPSDEActionReturn();
    }

    @Override
    public String getReturnValueType() {
        return this.getPSDEAction().getReturnValueType();
    }

    @Override
    public int getReturnStdDataType() {
        return this.getPSDEAction().getReturnStdDataType();
    }

    @Override
    @PSModelRTMeta(description="\u8f93\u5165\u52a8\u6001\u5bf9\u8c61\u6a21\u578b", hideempty=true, dump=false)
    public IPSSysDynaModel getInPSSysDynaModel() {
        return this.getPSDEAction().getInPSSysDynaModel();
    }

    @Override
    @PSModelRTMeta(description="\u8f93\u51fa\u52a8\u6001\u5bf9\u8c61\u6a21\u578b", hideempty=true, dump=false)
    public IPSSysDynaModel getOutPSSysDynaModel() {
        return this.getPSDEAction().getOutPSSysDynaModel();
    }

    @Override
    @PSModelRTMeta(description="\u6d4b\u8bd5\u7528\u4f8b\u96c6\u5408")
    public Iterator<IPSSysTestCase> getPSSysTestCases() throws Exception {
        return this.getPSDEAction().getPSSysTestCases();
    }

    @Override
    public String getBeforeCode() {
        return this.getPSDEAction().getBeforeCode();
    }

    @Override
    public String getAfterCode() {
        return this.getPSDEAction().getAfterCode();
    }

    @Override
    @PSModelRTMeta(description="\u6027\u80fd\u4f18\u5316\u9884\u8b66\u65f6\u957f\uff08ms\uff09", ignorepf=true, ignoredumpvalues="-1")
    public int getPOTime() {
        return this.getPSDEAction().getPOTime();
    }

    @Override
    @PSModelRTMeta(description="\u884c\u4e3a\u6807\u8bb0", fields={"ACTIONTAG"})
    public String getActionTag() {
        return this.getPSDEAction().getActionTag();
    }

    @Override
    @PSModelRTMeta(description="\u884c\u4e3a\u6807\u8bb02", fields={"ACTIONTAG2"})
    public String getActionTag2() {
        return this.getPSDEAction().getActionTag2();
    }

    @Override
    @PSModelRTMeta(description="\u884c\u4e3a\u6807\u8bb03", fields={"ACTIONTAG3"})
    public String getActionTag3() {
        return this.getPSDEAction().getActionTag3();
    }

    @Override
    @PSModelRTMeta(description="\u884c\u4e3a\u6807\u8bb04", fields={"ACTIONTAG4"})
    public String getActionTag4() {
        return this.getPSDEAction().getActionTag4();
    }

    @Override
    @PSModelRTMeta(description="\u8f93\u51fa\u5f15\u7528\u5b9e\u4f53\u5bf9\u8c61", fields={"OUTREFPSDEID"})
    public IPSDataEntity getOutRefPSDataEntity() throws Exception {
        return this.getPSDEAction().getOutRefPSDataEntity();
    }

    @Override
    @PSModelRTMeta(description="\u8f93\u51fa\u5f15\u7528\u5b9e\u4f53\u5c5e\u6027\u7ec4\u5bf9\u8c61", fields={"OUTREFPSDEFGROUPID"})
    public IPSDEFGroup getOutRefPSDEFGroup() throws Exception {
        return this.getPSDEAction().getOutRefPSDEFGroup();
    }

    @Override
    @PSModelRTMeta(description="\u5f02\u6b65\u64cd\u4f5c\u884c\u4e3a", ignoredumpvalues="false")
    public boolean isAsyncAction() {
        return this.getPSDEAction().isAsyncAction();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u9645\u6267\u884c\u884c\u4e3a", hideempty=true)
    public IPSDEAction getRealPSDEAction() throws Exception {
        return this.getPSDEAction().getRealPSDEAction();
    }

    @Override
    @PSModelRTMeta(description="\u5916\u90e8\u63a5\u53e3\u5b9e\u4f53\u65b9\u6cd5\u7ed1\u5b9a\u6a21\u5f0f", codelist="SubSysSADEMethodBindingMode", dump=false)
    public int getSubSysServiceAPIDEMethodBindingMode() {
        return this.getPSDEAction().getSubSysServiceAPIDEMethodBindingMode();
    }

    @Override
    public String getServiceCodeName() {
        return this.getPSDEAction().getServiceCodeName();
    }

    @Override
    public int getOption() {
        return this.getPSDEAction().getOption();
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u7f13\u5b58", ignoredumpvalues="false", fields={"ENABLECACHE"})
    public boolean isEnableCache() {
        return this.getPSDEAction().isEnableCache();
    }

    @Override
    @PSModelRTMeta(description="\u7f13\u5b58\u8d85\u65f6", ignoredumpvalues="-1", fields={"CACHETIMEOUT"})
    public int getCacheTimeout() {
        return this.getPSDEAction().getCacheTimeout();
    }

    @Override
    @PSModelRTMeta(description="\u7f13\u5b58\u7edf\u4e00\u72b6\u6001\u5bf9\u8c61", hideempty2=true, dumpref=true, fields={"PSSYSUNISTATEID"})
    public IPSSysUniState getPSSysUniState() {
        return this.getPSDEAction().getPSSysUniState();
    }

    @Override
    @PSModelRTMeta(description="\u9884\u5b9a\u4e49\u7c7b\u578b", hideempty2=true, ignorepf=true, fields={"PREDEFINEDTYPE"})
    public String getPredefinedType() {
        return this.getPSDEAction().getPredefinedType();
    }

    @Override
    @PSModelRTMeta(description="\u9884\u5b9a\u4e49\u7c7b\u578b\u53c2\u6570", hideempty2=true, ignorepf=true, fields={"PREDEFINEDTYPEPARAM"})
    public String getPredefinedTypeParam() {
        return this.getPSDEAction().getPredefinedTypeParam();
    }

    @Override
    @PSModelRTMeta(description="\u884c\u4e3a\u52a8\u6001\u53c2\u6570", hideempty2=true, ignorepf=true, fields={"ACTIONPARAMS"})
    public Properties getActionParams() {
        return this.getPSDEAction().getActionParams();
    }

    @Override
    @PSModelRTMeta(description="\u540c\u6b65\u4e8b\u4ef6", codelist="DEActionSyncEvent", ignoredumpvalues="-1", ignorepf=true, fields={"SYNCEVENT"})
    public int getSyncEvent() {
        return this.getPSDEAction().getSyncEvent();
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u8bbf\u95ee\u6807\u8bc6", hideempty2=true)
    public String getDataAccessAction() {
        return this.getPSDEAction().getDataAccessAction();
    }

    @Override
    @PSModelRTMeta(description="\u8bf7\u6c42\u9700\u8981\u72ec\u7acb\u8d44\u6e90\u952e\u503c", ignoredumpvalues="false", dump=false)
    public boolean isNeedResourceKey() {
        return this.getPSDEAction().isNeedResourceKey();
    }

    @Override
    @PSModelRTMeta(description="\u5b9a\u4e49\u8bf7\u6c42\u9700\u8981\u72ec\u7acb\u8d44\u6e90\u952e\u503c", ignoredumpvalues="false", dump=false)
    public boolean isNeedResourceKeyDefined() {
        return this.getPSDEAction().isNeedResourceKeyDefined();
    }
}

