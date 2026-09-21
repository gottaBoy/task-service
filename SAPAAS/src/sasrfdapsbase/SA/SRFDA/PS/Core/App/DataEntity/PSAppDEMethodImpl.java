/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.util.Inflector
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.App.DataEntity;

import SA.SRFDA.PS.Core.App.CodeList.IPSAppCodeList;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEAction;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEDataSet;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDELogic;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEMethod;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEMethodInput;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEMethodReturn;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.DataEntity.PSAppDEMethodInputImpl;
import SA.SRFDA.PS.Core.App.DataEntity.PSAppDEMethodReturnImpl;
import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDELogicAction;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEScriptAction;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDQCondition;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDQGroupCondition;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataQuery;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogic;
import SA.SRFDA.PS.Core.DataEntity.Priv.IPSDEOPPriv;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEMethodInput;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEMethodReturn;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEServiceAPIMethod;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PF.IPSPFXCodeObject;
import SA.SRFDA.PS.Core.PF.PSPFXCodeObjectProxy;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysPFPluginTempl;
import SA.SRFDA.PS.Core.Util.PSModelCodeNameUtils;
import SA.SRFDA.PS.Data.PSDESADetail;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.util.Inflector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppDEMethodImpl
extends PSObjectImpl
implements IPSAppDEMethod,
IPSAppDEAction,
IPSAppDEDataSet {
    private static final Log log = LogFactory.getLog(PSAppDEMethodImpl.class);
    private IPSAppDataEntity iPSAppDataEntity = null;
    private IPSDEServiceAPIMethod iPSDEServiceAPIMethod = null;
    private IPSDEAction iPSDEAction = null;
    private IPSDEDataSet iPSDEDataSet = null;
    private IPSPFXCodeObject iPSPFXCodeObject = null;
    private boolean bTempMode = false;
    private boolean bBuiltinMethod = false;
    private PSDESADetail psDESADetail = null;
    private IPSAppCodeList iPSAppCodeList = null;
    private IPSAppDELogic iPSAppDELogic = null;
    private IPSDELogic iPSDELogic = null;
    private IPSSysPFPlugin iPSSysPFPlugin = null;
    private IPSAppDEMethodInput iPSAppDEMethodInput = null;
    private IPSAppDEMethodReturn iPSAppDEMethodReturn = null;

    public void initBuiltinMode(ISRFDAGlobalHelper iDAGlobalHelper, IPSAppDataEntity iPSAppDataEntity, Object objMethod) throws Exception {
        this.bBuiltinMethod = true;
        this.init(iDAGlobalHelper, iPSAppDataEntity, objMethod);
    }

    public void initTempMode(ISRFDAGlobalHelper iDAGlobalHelper, IPSAppDataEntity iPSAppDataEntity, Object objMethod) throws Exception {
        this.bTempMode = true;
        this.init(iDAGlobalHelper, iPSAppDataEntity, objMethod);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSAppDataEntity iPSAppDataEntity, Object objMethod) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSAppDataEntity = iPSAppDataEntity;
            if (objMethod instanceof IPSDEServiceAPIMethod) {
                this.iPSDEServiceAPIMethod = (IPSDEServiceAPIMethod)objMethod;
            } else if (objMethod instanceof IPSDEAction) {
                this.iPSDEAction = (IPSDEAction)objMethod;
            } else if (objMethod instanceof IPSDEDataSet) {
                this.iPSDEDataSet = (IPSDEDataSet)objMethod;
            } else if (objMethod instanceof PSDESADetail) {
                this.psDESADetail = (PSDESADetail)((Object)objMethod);
            }
            if (this.getPSDEServiceAPIMethod() != null) {
                this.setId(this.getPSDEServiceAPIMethod().getId());
                this.setName(this.getPSDEServiceAPIMethod().getName());
            } else if (this.getPSDEAction() != null) {
                this.setId(this.getPSDEAction().getId());
                this.setName(this.getPSDEAction().getName());
                if (this.getPSDEAction() instanceof IPSDELogicAction) {
                    IPSDELogicAction iPSDELogicAction = (IPSDELogicAction)this.getPSDEAction();
                    if (!iPSDELogicAction.getPSDELogic().isEnableFront()) throw new Exception(String.format("\u5b9e\u4f53\u5904\u7406\u903b\u8f91[%1$s]\u4e0d\u652f\u6301\u5728\u524d\u7aef\u6267\u884c", iPSDELogicAction.getPSDELogic().getName()));
                    this.iPSDELogic = iPSDELogicAction.getPSDELogic();
                }
            } else if (this.getPSDEDataSet() != null) {
                if (this.bTempMode) {
                    this.setId("TEMPMODE_" + this.getPSDEDataSet().getId());
                } else {
                    this.setId(this.getPSDEDataSet().getId());
                }
                this.setName(this.getPSDEDataSet().getName());
                if (this.getPSDEDataSet().getPSCodeList() != null) {
                    this.iPSAppCodeList = this.getPSApplication().getPSAppCodeList(this.getPSDEDataSet().getPSCodeList(), false);
                }
                if (StringHelper.compare((String)this.getPSDEDataSet().getDataSetType(), (String)"DELOGIC", (boolean)false) == 0) {
                    if (!this.getPSDEDataSet().getPSDELogic().isEnableFront()) throw new Exception(String.format("\u5b9e\u4f53\u5904\u7406\u903b\u8f91[%1$s]\u4e0d\u652f\u6301\u5728\u524d\u7aef\u6267\u884c", this.getPSDEDataSet().getPSDELogic().getName()));
                    this.iPSDELogic = this.getPSDEDataSet().getPSDELogic();
                }
            } else {
                if (this.psDESADetail == null) throw new Exception("\u65b9\u6cd5\u65e0\u6548");
                this.setId(this.psDESADetail.getPSDESADETAILID());
                this.setName(this.psDESADetail.getPSDESADETAILNAME());
            }
            this.setAutoModel(true);
            this.onInit();
            return;
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
        if (this.internalGetPSSysPFPlugin() != null) {
            this.iPSSysPFPlugin = this.getPSAppDataEntity().getPSApplication().getPSSysPFPlugin(this.internalGetPSSysPFPlugin().getId(), "DEMETHOD", this.getMethodType(), null);
        }
        if (this.getPSSysPFPlugin() != null) {
            String strPSSysPFPluginTemplId = KeyValueHelper.genUniqueId((String)this.getPSSysPFPlugin().getId(), (String)this.getPSAppDataEntity().getPSApplication().getPSPF().getId());
            IPSSysPFPluginTempl iPSSysPFPluginTempl = this.getPSAppDataEntity().getPSApplication().getPSSystem().getPSSysPFPluginTempl(strPSSysPFPluginTemplId, true);
            if (iPSSysPFPluginTempl != null) {
                this.iPSPFXCodeObject = new PSPFXCodeObjectProxy(iPSSysPFPluginTempl, null, null, (Object)this);
            }
        }
        super.onInit();
        if (this.getPSApplication().isEnableServiceAPIDTO()) {
            this.iPSAppDEMethodInput = this.createPSAppDEMethodInput();
            this.iPSAppDEMethodReturn = this.createPSAppDEMethodReturn();
        }
    }

    @Override
    protected int onCheck() throws Exception {
        if (this.getPSApplication().isEnableServiceAPIDTO()) {
            if (this.getPSAppDEMethodInput() != null) {
                this.getPSAppDEMethodInput().check();
            }
            if (this.getPSAppDEMethodReturn() != null) {
                this.getPSAppDEMethodReturn().check();
            }
        }
        return super.onCheck();
    }

    protected IPSAppDEMethodInput createPSAppDEMethodInput() throws Exception {
        PSAppDEMethodInputImpl psAppDEMethodInputImpl = new PSAppDEMethodInputImpl();
        IPSDEMethodInput iPSDEMethodInput = null;
        if (this.getPSDEServiceAPIMethod() != null) {
            iPSDEMethodInput = this.getPSDEServiceAPIMethod().getPSDEServiceAPIMethodInput();
        } else if (this.getPSDEAction() != null) {
            iPSDEMethodInput = this.getPSDEAction().getPSDEActionInput();
        } else if (this.getPSDEDataSet() != null) {
            iPSDEMethodInput = this.getPSDEDataSet().getPSDEDataSetInput();
        }
        if (iPSDEMethodInput == null) {
            return null;
        }
        psAppDEMethodInputImpl.init(this.getDAGlobalHelper(), this, iPSDEMethodInput);
        return psAppDEMethodInputImpl;
    }

    protected IPSAppDEMethodReturn createPSAppDEMethodReturn() throws Exception {
        PSAppDEMethodReturnImpl psAppDEMethodReturnImpl = new PSAppDEMethodReturnImpl();
        IPSDEMethodReturn iPSDEMethodReturn = null;
        if (this.getPSDEServiceAPIMethod() != null) {
            iPSDEMethodReturn = this.getPSDEServiceAPIMethod().getPSDEServiceAPIMethodReturn();
        } else if (this.getPSDEAction() != null) {
            iPSDEMethodReturn = this.getPSDEAction().getPSDEActionReturn();
        } else if (this.getPSDEDataSet() != null) {
            iPSDEMethodReturn = this.getPSDEDataSet().getPSDEDataSetReturn();
        }
        if (iPSDEMethodReturn == null) {
            return null;
        }
        psAppDEMethodReturnImpl.init(this.getDAGlobalHelper(), this, iPSDEMethodReturn);
        return psAppDEMethodReturnImpl;
    }

    @Override
    public IPSAppDataEntity getPSAppDataEntity() {
        return this.iPSAppDataEntity;
    }

    @Override
    @PSModelRTMeta(description="\u670d\u52a1\u63a5\u53e3\u65b9\u6cd5", dumpref=true, ignorepf=true, from="IPSAppDataEntity", from_method="getPSDEServiceAPIMust().getPSDEServiceAPIMethod", group="\u57fa\u672c", order=125)
    public IPSDEServiceAPIMethod getPSDEServiceAPIMethod() {
        return this.iPSDEServiceAPIMethod;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSAppDataEntity().getPSSysModelInstId();
    }

    @Override
    public String getModelType() {
        return "PSAPPDEMETHOD";
    }

    @Override
    public String getFullModelName() {
        return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSAppDataEntity().getFullModelName(), (Object)this.getModelName());
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSAppDataEntity().getPSDataEntity().getPSSystem());
    }

    @Override
    public String getModelId() {
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSAppDataEntity().getModelId(), (Object)this.getId());
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
        if (this.getPSDEServiceAPIMethod() != null) {
            if (!StringHelper.isNullOrEmpty((String)this.getPSDEServiceAPIMethod().getCodeName())) {
                return this.getPSDEServiceAPIMethod().getCodeName();
            }
            if (this.getPSDEServiceAPIMethod().getPSDEAction() != null) {
                return this.getPSDEServiceAPIMethod().getPSDEAction().getServiceCodeName();
            }
            if (this.getPSDEServiceAPIMethod().getPSDEDataSet() != null) {
                if (this.getPSDEServiceAPIMethod().getTempDataMode() == 0) {
                    return this.getPSDEServiceAPIMethod().getPSDEDataSet().getServiceCodeName();
                }
                return "FetchTemp" + PSModelCodeNameUtils.capitalize(this.getPSDEServiceAPIMethod().getPSDEDataSet().getCodeName());
            }
        }
        if (this.getPSDEAction() != null) {
            return this.getPSDEAction().getCodeName();
        }
        if (this.getPSDEDataSet() != null) {
            if (this.bTempMode) {
                return "FetchTemp" + PSModelCodeNameUtils.capitalize(this.getPSDEDataSet().getCodeName());
            }
            return "Fetch" + PSModelCodeNameUtils.capitalize(this.getPSDEDataSet().getCodeName());
        }
        if (this.psDESADetail != null) {
            return this.psDESADetail.getCODENAME();
        }
        return "";
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u540d\u79f02", hideempty2=true)
    public String getCodeName2() {
        if (this.getPSDEServiceAPIMethod() != null) {
            return this.getPSDEServiceAPIMethod().getCodeName2();
        }
        if (this.psDESADetail != null) {
            return this.psDESADetail.getCODENAME2();
        }
        return "";
    }

    @Override
    @PSModelRTMeta(description="\u65b9\u6cd5\u7c7b\u578b", codelist="DESADetailType3", group="\u57fa\u672c", order=125)
    public String getMethodType() {
        if (this.getPSDEServiceAPIMethod() != null) {
            return this.getPSDEServiceAPIMethod().getMethodType();
        }
        if (this.getPSDEAction() != null) {
            return "DEACTION";
        }
        if (this.getPSDEDataSet() != null) {
            if (this.bTempMode) {
                return "FETCHTEMP";
            }
            return "FETCH";
        }
        if (this.psDESADetail != null) {
            return this.psDESADetail.getDETAILTYPE();
        }
        return "UNKNOWN";
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u884c\u4e3a", hideempty=true, dumpref=true, ignorepf=true, from="IPSAppDataEntity", from_method="getPSDataEntityMust().getPSDEAction")
    public IPSDEAction getPSDEAction() {
        if (this.getPSDEServiceAPIMethod() != null) {
            return this.getPSDEServiceAPIMethod().getPSDEAction();
        }
        return this.iPSDEAction;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u6570\u636e\u96c6\u5408", hideempty=true, dumpref=true, ignorepf=true, from="IPSAppDataEntity", from_method="getPSDataEntityMust().getPSDEDataSet")
    public IPSDEDataSet getPSDEDataSet() {
        if (this.getPSDEServiceAPIMethod() != null) {
            return this.getPSDEServiceAPIMethod().getPSDEDataSet();
        }
        return this.iPSDEDataSet;
    }

    @Override
    protected IPSModelObject getProxyPSModelObject() {
        if (this.getPSDEServiceAPIMethod() != null) {
            return this.getPSDEServiceAPIMethod();
        }
        if (this.getPSDEAction() != null) {
            return this.getPSDEAction();
        }
        if (this.getPSDEDataSet() != null) {
            return this.getPSDEDataSet();
        }
        return super.getProxyPSModelObject();
    }

    @Override
    @PSModelRTMeta(description="\u7ed8\u5236\u63d2\u4ef6")
    public IPSPFXCodeObject getRender() {
        return this.iPSPFXCodeObject;
    }

    @Override
    @PSModelRTMeta(description="\u524d\u7aef\u6269\u5c55\u63d2\u4ef6")
    public IPSSysPFPlugin getPSSysPFPlugin() {
        return this.iPSSysPFPlugin;
    }

    private IPSSysPFPlugin internalGetPSSysPFPlugin() {
        if (this.getPSDEAction() != null) {
            return this.getPSDEAction().getPSSysPFPlugin();
        }
        if (this.getPSDEDataSet() != null) {
            return this.getPSDEDataSet().getPSSysPFPlugin();
        }
        return null;
    }

    @Override
    public String getModelName() {
        if (this.getPSDEServiceAPIMethod() != null) {
            return StringHelper.format((String)"[\u63a5\u53e3]%1$s", (Object)this.getCodeName());
        }
        return StringHelper.format((String)"[\u672c\u5730]%1$s", (Object)this.getCodeName());
    }

    public IPSApplication getPSApplication() {
        return this.getPSAppDataEntity().getPSApplication();
    }

    public IPSSystem getPSSystem() {
        return this.getPSApplication().getPSSystem();
    }

    @Override
    @PSModelRTMeta(description="\u9884\u7f6e\u65b9\u6cd5")
    public boolean isBuiltinMethod() {
        if (this.getPSDEServiceAPIMethod() != null) {
            return false;
        }
        if (this.getPSDEAction() != null) {
            return this.getPSDEAction().isBuiltinAction();
        }
        return this.bBuiltinMethod;
    }

    @Override
    @PSModelRTMeta(description="\u4e34\u65f6\u6570\u636e\u6a21\u5f0f", codelist="TempDataMode", ignoredumpvalues="0")
    public int getTempDataMode() {
        if (this.getPSDEServiceAPIMethod() != null) {
            return this.getPSDEServiceAPIMethod().getTempDataMode();
        }
        if (this.getPSDEAction() != null) {
            return this.getPSDEAction().getTempDataMode();
        }
        if (this.bTempMode) {
            return 2;
        }
        return 0;
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u5224\u65ad\u6267\u884c\u65b9\u6cd5", ignoredumpvalues="false")
    public boolean isEnableTestMethod() {
        if (this.getPSDEServiceAPIMethod() != null) {
            return this.getPSDEServiceAPIMethod().isEnableTestMethod();
        }
        if (this.getPSDEAction() != null) {
            return this.getPSDEAction().getTestActionMode() == 3;
        }
        return false;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u4ee3\u7801\u8868", hideempty2=true, dumpref=true)
    public IPSAppCodeList getPSAppCodeList() {
        return this.iPSAppCodeList;
    }

    @Override
    @PSModelRTMeta(description="\u9884\u5b9a\u4e49\u7c7b\u578b", codelist="DEDSPDT", hideempty2=true)
    public String getPredefinedType() {
        if (this.getPSDEServiceAPIMethod() != null) {
            return "";
        }
        if (this.getPSDEDataSet() != null) {
            return this.getPSDEDataSet().getPredefinedType();
        }
        return "";
    }

    @Override
    public Class<?> getModelClass(String strModelType) {
        if (this.getPSDEDataSet() != null) {
            return IPSAppDEDataSet.class;
        }
        if (this.getPSDEAction() != null) {
            return IPSAppDEAction.class;
        }
        return super.getModelClass(strModelType);
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5904\u7406\u903b\u8f91", hideempty=true, dumpref=true, from="IPSAppDataEntity")
    public IPSAppDELogic getPSAppDELogic() throws Exception {
        if (this.iPSAppDELogic == null && this.iPSDELogic != null) {
            this.iPSAppDELogic = this.getPSAppDataEntity().getPSAppDELogic(this.iPSDELogic.getId(), true);
        }
        return this.iPSAppDELogic;
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u64cd\u4f5c\u6807\u8bc6", hideempty=true, ignorepf=true)
    public IPSDEOPPriv getPSDEOPPriv() {
        if (this.getPSDEServiceAPIMethod() != null) {
            return this.getPSDEServiceAPIMethod().getPSDEOPPriv();
        }
        if (this.getPSDEAction() != null) {
            return this.getPSDEAction().getPSDEOPPriv();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u6279\u64cd\u4f5c\u6a21\u5f0f", ignoredumpvalues="0", codelist="DEActionBatchMode")
    public int getBatchActionMode() {
        if (this.getPSDEAction() != null) {
            return this.getPSDEAction().getBatchActionMode();
        }
        return 0;
    }

    @Override
    @PSModelRTMeta(description="\u6279\u64cd\u4f5c\u884c\u4e3a", ignoredumpvalues="false")
    public boolean isEnableBatchAction() {
        if (this.getPSDEAction() != null) {
            return this.getPSDEAction().isEnableBatchAction();
        }
        return false;
    }

    @Override
    @PSModelRTMeta(description="\u884c\u4e3a\u6a21\u5f0f", codelist="DEActionMode")
    public String getActionMode() {
        if (this.getPSDEAction() != null) {
            return this.getPSDEAction().getActionMode();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u81ea\u5b9a\u4e49\u4ee3\u7801", ignoredumpvalues="false")
    public boolean isCustomCode() {
        if (this.getPSDEServiceAPIMethod() == null) {
            if (this.getPSDEAction() != null && this.getPSDEAction().isEnableFront() && StringHelper.compare((String)"SCRIPT", (String)this.getPSDEAction().getActionType(), (boolean)false) == 0) {
                return true;
            }
            if (this.getPSDEDataSet() != null && this.getPSDEDataSet().isEnableFront() && StringHelper.compare((String)"SCRIPT", (String)this.getPSDEDataSet().getDataSetType(), (boolean)false) == 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    @PSModelRTMeta(description="\u811a\u672c\u4ee3\u7801")
    public String getScriptCode() {
        if (this.isCustomCode()) {
            if (this.getPSDEAction() != null && this.getPSDEAction() instanceof IPSDEScriptAction) {
                return ((IPSDEScriptAction)this.getPSDEAction()).getScriptCode();
            }
            if (this.getPSDEDataSet() != null) {
                return this.getPSDEDataSet().getScriptCode();
            }
        }
        return "";
    }

    @Override
    @PSModelRTMeta(description="\u7ed3\u679c\u96c6\u7c7b\u578b", codelist="DEDataSetType", ignoredumpvalues="REMOTE", hideempty2=true)
    public String getDataSetType() {
        if (this.getPSDEDataSet() != null) {
            if (this.getPSDEServiceAPIMethod() != null) {
                return "REMOTE";
            }
            return this.getPSDEDataSet().getDataSetType();
        }
        return "";
    }

    @Override
    @PSModelRTMeta(description="\u884c\u4e3a\u7c7b\u578b", codelist="DEActionType2", ignoredumpvalues="REMOTE", hideempty2=true)
    public String getActionType() {
        if (this.getPSDEAction() != null) {
            if (this.getPSDEServiceAPIMethod() != null) {
                return "REMOTE";
            }
            return this.getPSDEAction().getActionType();
        }
        return "";
    }

    @Override
    @PSModelRTMeta(description="\u65b9\u6cd5\u8f93\u5165\u5bf9\u8c61", hideempty=true, child=true, doctype="item", group="\u903b\u8f91", order=215)
    public IPSAppDEMethodInput getPSAppDEMethodInput() {
        return this.iPSAppDEMethodInput;
    }

    @Override
    @PSModelRTMeta(description="\u65b9\u6cd5\u8fd4\u56de\u5bf9\u8c61", hideempty=true, child=true, doctype="item", group="\u903b\u8f91", order=216)
    public IPSAppDEMethodReturn getPSAppDEMethodReturn() {
        return this.iPSAppDEMethodReturn;
    }

    @Override
    @PSModelRTMeta(description="\u4e0a\u4e0b\u6587\u6570\u636e\u6761\u4ef6", child=true, group="\u903b\u8f91", order=225, outputdoc="%1$s.getMethodType()=='FETCH'")
    public Iterator<IPSDEDQCondition> getADPSDEDQConditions() {
        if (this.getPSDEDataSet() != null) {
            return this.getPSDEDataSet().getADPSDEDQConditions();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u672c\u5730\u8fc7\u6ee4\u6761\u4ef6", child=true, group="\u903b\u8f91", order=226, outputdoc="%1$s.getMethodType()=='FETCH'")
    public Iterator<IPSDEDQGroupCondition> getPSDEDQGroupConditions() {
        if (this.getPSDEDataSet() == null) {
            return null;
        }
        if (this.getPSDEServiceAPIMethod() != null) {
            return null;
        }
        Iterator<IPSDEDataQuery> psDEDataQueries = this.getPSDEDataSet().getPSDEDataQueries();
        if (psDEDataQueries == null) {
            return null;
        }
        ArrayList<IPSDEDQGroupCondition> psDEDQGroupConditionList = new ArrayList<IPSDEDQGroupCondition>();
        while (psDEDataQueries.hasNext()) {
            IPSDEDQGroupCondition iPSDEDQGroupCondition;
            IPSDEDataQuery iPSDEDataQuery = psDEDataQueries.next();
            if (iPSDEDataQuery.getPSDEDQMain() == null || (iPSDEDQGroupCondition = iPSDEDataQuery.getPSDEDQMain().getPSDEDQGroupCondition()) == null) continue;
            psDEDQGroupConditionList.add(iPSDEDQGroupCondition);
        }
        if (psDEDQGroupConditionList.size() != 0) {
            return psDEDQGroupConditionList.iterator();
        }
        return null;
    }

    @Override
    protected String onGetMOSFilePath() {
        return null;
    }

    @Override
    protected String onGetRTMOSFolder() {
        if (this.getPSAppDataEntity() != null) {
            return String.format("%1$s/%2$s", this.getPSAppDataEntity().getRTMOSFilePath(), Inflector.getInstance().pluralize((Object)this.getModelType()).toLowerCase());
        }
        return Inflector.getInstance().pluralize((Object)this.getModelType()).toLowerCase();
    }

    @Override
    protected IPSModelObject onGetParentModel() {
        return this.getPSAppDataEntity();
    }

    @Override
    @PSModelRTMeta(description="\u6267\u884c\u4e4b\u524d\u4ee3\u7801", fields={"BEFORECODE"})
    public String getBeforeCode() {
        if (this.getPSDEAction() != null) {
            return this.getPSDEAction().getBeforeCode();
        }
        if (this.getPSDEDataSet() != null) {
            return this.getPSDEDataSet().getBeforeCode();
        }
        return "";
    }

    @Override
    @PSModelRTMeta(description="\u6267\u884c\u4e4b\u540e\u4ee3\u7801", fields={"AFTERCODE"})
    public String getAfterCode() {
        if (this.getPSDEAction() != null) {
            return this.getPSDEAction().getAfterCode();
        }
        if (this.getPSDEDataSet() != null) {
            return this.getPSDEDataSet().getAfterCode();
        }
        return "";
    }

    @Override
    @PSModelRTMeta(description="\u53c2\u6570\u7c7b\u578b", codelist="ServiceReqParamType")
    public String getRequestParamType() {
        if (this.getPSDEServiceAPIMethod() != null) {
            return this.getPSDEServiceAPIMethod().getRequestParamType();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u8bf7\u6c42\u5c5e\u6027")
    public String getRequestField() {
        if (this.getPSDEServiceAPIMethod() != null) {
            return this.getPSDEServiceAPIMethod().getRequestField();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u8bf7\u6c42\u65b9\u5f0f", codelist="RequestMethod")
    public String getRequestMethod() {
        if (this.getPSDEServiceAPIMethod() != null) {
            return this.getPSDEServiceAPIMethod().getRequestMethod();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u9700\u8981\u63d0\u4f9b\u8d44\u6e90\u952e\u503c", ignoredumpvalues="false")
    public boolean isNeedResourceKey() {
        if (this.getPSDEServiceAPIMethod() != null) {
            return this.getPSDEServiceAPIMethod().isNeedResourceKey();
        }
        return false;
    }

    @Override
    @PSModelRTMeta(description="\u65e0\u670d\u52a1\u4ee3\u7801\u6807\u8bc6", ignoredumpvalues="false")
    public boolean isNoServiceCodeName() {
        if (this.getPSDEServiceAPIMethod() != null) {
            return this.getPSDEServiceAPIMethod().isNoServiceCodeName();
        }
        return false;
    }

    @Override
    @PSModelRTMeta(description="\u8bf7\u6c42\u8def\u5f84")
    public String getRequestPath() {
        if (this.getPSDEServiceAPIMethod() != null) {
            return this.getPSDEServiceAPIMethod().getRequestPath();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5b8c\u6574\u8bf7\u6c42\u8def\u5f84\u96c6\u5408", child=true)
    public String[] getRequestFullPaths() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5f02\u6b65\u64cd\u4f5c\u884c\u4e3a", ignoredumpvalues="false")
    public boolean isAsyncAction() {
        if (this.getPSDEAction() != null) {
            return this.getPSDEAction().isAsyncAction();
        }
        return false;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u96c6\u6807\u8bc6")
    public String getDataSetName() {
        if (this.getPSDEDataSet() != null && StringHelper.compare((String)this.getName(), (String)this.getPSDEDataSet().getName(), (boolean)false) != 0) {
            return this.getPSDEDataSet().getName();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u96c6\u6807\u8bb0")
    public String getDataSetTag() {
        if (this.getPSDEDataSet() != null && StringHelper.compare((String)this.getCodeName(), (String)this.getPSDEDataSet().getCodeName(), (boolean)false) != 0) {
            return this.getPSDEDataSet().getCodeName();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u884c\u4e3a\u6807\u8bc6")
    public String getActionName() {
        if (this.getPSDEAction() != null && StringHelper.compare((String)this.getName(), (String)this.getPSDEAction().getName(), (boolean)false) != 0) {
            return this.getPSDEAction().getName();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u884c\u4e3a\u6807\u8bc6")
    public String getActionTag() {
        if (this.getPSDEAction() != null && StringHelper.compare((String)this.getCodeName(), (String)this.getPSDEAction().getCodeName(), (boolean)false) != 0) {
            return this.getPSDEAction().getCodeName();
        }
        return null;
    }
}

