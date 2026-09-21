/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.Service;

import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Priv.IPSDEOPPriv;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEMethod;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEServiceAPI;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEServiceAPIMethod;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEServiceAPIMethodInput;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEServiceAPIMethodReturn;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEServiceAPIRS;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysSFPluginTempl;
import SA.SRFDA.PS.Core.SF.IPSSFXCodeObject;
import SA.SRFDA.PS.Core.SF.PSSFXCodeObjectProxy;
import SA.SRFDA.PS.Core.Service.IPSDEActionRESTfulAPI;
import SA.SRFDA.PS.Core.Service.IPSRESTfulAPI;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIDEMethod;
import SA.SRFDA.PS.Data.PSDESADetail;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelIgnoreMeta
public class PSDEServiceAPIMethodProxy
extends PSObjectImpl
implements IPSDEServiceAPIMethod,
IPSRESTfulAPI,
IPSDEActionRESTfulAPI {
    private static final Log log = LogFactory.getLog(PSDEServiceAPIMethodProxy.class);
    private IPSDEServiceAPIRS iPSDEServiceAPIRS = null;
    private IPSDEServiceAPIMethod iPSDEServiceAPIMethod = null;
    private IPSDEMethod iPSDEMethod = null;
    private IPSSFXCodeObject iPSSFXCodeObject = null;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEServiceAPIRS iPSDEServiceAPIRS, IPSDEServiceAPIMethod iPSDEServiceAPIMethod) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSDEServiceAPIMethod = iPSDEServiceAPIMethod;
            this.iPSDEServiceAPIRS = iPSDEServiceAPIRS;
            this.setId(this.getPSDEServiceAPIMethod().getId());
            this.setName(this.getPSDEServiceAPIMethod().getName());
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
        if (this.getPSSysSFPlugin() != null) {
            String strPSSysSFPluginTemplId = KeyValueHelper.genUniqueId((String)this.getPSSysSFPlugin().getId(), (String)this.getPSDEServiceAPI().getPSSysServiceAPI().getPSSystem().getPSSFId());
            IPSSysSFPluginTempl iPSSysSFPluginTempl = this.getPSDEServiceAPI().getPSSysServiceAPI().getPSSystem().getPSSysSFPluginTempl(strPSSysSFPluginTemplId, true);
            if (iPSSysSFPluginTempl != null) {
                this.iPSSFXCodeObject = new PSSFXCodeObjectProxy(iPSSysSFPluginTempl, this);
            }
        }
        super.onInit();
    }

    @Override
    protected IPSModelObject getProxyPSModelObject() {
        return this.getPSDEServiceAPIMethod();
    }

    @Override
    protected boolean onGetAutoModel() {
        return true;
    }

    protected IPSDEServiceAPIMethod getPSDEServiceAPIMethod() {
        return this.iPSDEServiceAPIMethod;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u670d\u52a1\u63a5\u53e3")
    public IPSDEServiceAPI getPSDEServiceAPI() {
        return this.getPSDEServiceAPIMethod().getPSDEServiceAPI();
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSDEServiceAPI().getPSSysModelInstId();
    }

    @Override
    @PSModelRTMeta(description="\u65b9\u6cd5\u7c7b\u578b", codelist="DESADetailType")
    public String getMethodType() {
        return this.getPSDEServiceAPIMethod().getMethodType();
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.getPSDEServiceAPIMethod().getCodeName();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u884c\u4e3a", hideempty=true, dumpref=true, from="IPSDEServiceAPI", from_method="getPSDataEntityMust().getPSDEAction")
    public IPSDEAction getPSDEAction() {
        return this.getPSDEServiceAPIMethod().getPSDEAction();
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u96c6\u5408", hideempty=true, dumpref=true, from="IPSDEServiceAPI", from_method="getPSDataEntityMust().getPSDEDataSet")
    public IPSDEDataSet getPSDEDataSet() {
        return this.getPSDEServiceAPIMethod().getPSDEDataSet();
    }

    @Override
    @PSModelRTMeta(description="\u8bf7\u6c42\u65b9\u5f0f", codelist="RequestMethod")
    public String getRequestMethod() {
        return ((IPSRESTfulAPI)((Object)this.getPSDEServiceAPIMethod())).getRequestMethod();
    }

    @PSModelRTMeta(description="\u884c\u4e3a\u7c7b\u578b")
    public String getActionType() {
        return this.getPSDEServiceAPIMethod().getActionType();
    }

    @PSModelRTMeta(description="\u63a5\u53e3\u6807\u8bb0")
    public String getUniqueTag() {
        return this.getPSDEServiceAPIMethod().getUniqueTag();
    }

    @Override
    @PSModelRTMeta(description="\u8bf7\u6c42\u8def\u5f84", ignorepf=true, dynamodelmode=8)
    public String getRequestPath() {
        return ((IPSRESTfulAPI)((Object)this.getPSDEServiceAPIMethod())).getRequestPath();
    }

    @Override
    public IPSRESTfulAPI getPSRESTfulAPI() {
        return this;
    }

    public String getDEName() {
        return this.getPSDEServiceAPI().getPSDataEntity().getName();
    }

    @Override
    @PSModelRTMeta(description="\u53c2\u6570\u7c7b\u578b", codelist="ServiceReqParamType", ignorepf=true, dynamodelmode=8)
    public String getRequestParamType() {
        return ((IPSDEActionRESTfulAPI)((Object)this.getPSDEServiceAPIMethod())).getRequestParamType();
    }

    @Override
    @PSModelRTMeta(description="\u8bf7\u6c42\u5c5e\u6027", ignorepf=true, dynamodelmode=8)
    public String getRequestField() {
        return ((IPSDEActionRESTfulAPI)((Object)this.getPSDEServiceAPIMethod())).getRequestField();
    }

    @Override
    public String getModelType() {
        if (this.getPSDEServiceAPIRS() != null) {
            return "PSDESARSDETAIL";
        }
        return "PSDESADETAIL";
    }

    @Override
    public String getModelId() {
        if (this.getPSDEServiceAPIRS() != null) {
            return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSDEServiceAPIRS().getModelId(), (Object)super.getModelId());
        }
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSDEServiceAPI().getModelId(), (Object)super.getModelId());
    }

    @Override
    public String getModelName() {
        return this.getUniqueTag();
    }

    @Override
    public String getFullModelName() {
        return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSDEServiceAPI().getFullModelName(), (Object)this.getModelName());
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSDEServiceAPI().getPSDataEntity().getPSSystem());
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u540d\u79f02", hideempty2=true)
    public String getCodeName2() {
        return this.getPSDEServiceAPIMethod().getCodeName2();
    }

    @Override
    @PSModelRTMeta(description="\u65b9\u6cd5\u53c2\u6570", hideempty2=true)
    public String getMethodParam() {
        return this.getPSDEServiceAPIMethod().getMethodParam();
    }

    @Override
    @PSModelRTMeta(description="\u65b9\u6cd5\u53c2\u65702", hideempty2=true)
    public String getMethodParam2() {
        return this.getPSDEServiceAPIMethod().getMethodParam2();
    }

    @Override
    @PSModelRTMeta(description="\u8fd4\u56de\u503c\u7c7b\u578b", codelist="DEActionRetValType")
    public String getReturnValueType() {
        return this.getPSDEServiceAPIMethod().getReturnValueType();
    }

    @Override
    @PSModelRTMeta(description="\u4e34\u65f6\u6570\u636e\u6a21\u5f0f", codelist="TempDataMode")
    public int getTempDataMode() {
        return this.getPSDEServiceAPIMethod().getTempDataMode();
    }

    @Override
    @PSModelRTMeta(description="\u540e\u7aef\u6269\u5c55\u63d2\u4ef6", hideempty=true)
    public IPSSysSFPlugin getPSSysSFPlugin() {
        return this.getPSDEServiceAPIMethod().getPSSysSFPlugin();
    }

    @Override
    @PSModelRTMeta(description="\u7ed8\u5236\u5668", hideempty=true)
    public IPSSFXCodeObject getRender() {
        return this.iPSSFXCodeObject;
    }

    @Override
    @PSModelRTMeta(description="\u8bbf\u95ee\u64cd\u4f5c\u6807\u8bc6", dump=false)
    public IPSDEOPPriv getPSDEOPPriv() {
        return this.getPSDEServiceAPIMethod().getPSDEOPPriv();
    }

    @Override
    @PSModelRTMeta(description="\u670d\u52a1\u63a5\u53e3\u5173\u7cfb", hideempty=true)
    public IPSDEServiceAPIRS getPSDEServiceAPIRS() {
        return this.iPSDEServiceAPIRS;
    }

    @Override
    public String getPSDEServiceAPIRSId() {
        return this.getPSDEServiceAPIRS().getId();
    }

    @Override
    @PSModelRTMeta(description="\u7236\u503c\u5904\u7406\u6a21\u5f0f", codelist="DESAMethodParentKeyMode")
    public String getParentKeyMode() {
        return this.getPSDEServiceAPIMethod().getParentKeyMode();
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u5224\u65ad\u6267\u884c\u65b9\u6cd5")
    public boolean isEnableTestMethod() {
        if (this.getPSDEAction() != null) {
            return this.getPSDEAction().getTestActionMode() == 3;
        }
        return false;
    }

    @Override
    public IPSDataEntity getPSDataEntity() {
        return this.getPSDEServiceAPI().getPSDataEntity();
    }

    @Override
    public int getExtendMode() {
        return 0;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u65b9\u6cd5\u5bf9\u8c61")
    public IPSDEMethod getPSDEMethod() throws Exception {
        if (this.getTempDataMode() != 0) {
            return null;
        }
        if (this.iPSDEMethod == null) {
            if (this.getPSDEAction() != null) {
                this.iPSDEMethod = this.getPSDataEntity().getPSDEActionMethod(this.getPSDEAction(), true);
            } else if (this.getPSDEDataSet() != null) {
                if (this.getPSDEServiceAPIRS() != null) {
                    if (this.getPSDEServiceAPIRS().getPSDER1N() != null) {
                        this.iPSDEMethod = this.getPSDataEntity().getPSDEDataSetMethod(this.getPSDEDataSet(), this.getPSDEServiceAPIRS().getPSDER1N(), this.getParentKeyMode(), true);
                    }
                } else {
                    this.iPSDEMethod = this.getPSDataEntity().getPSDEDataSetMethod(this.getPSDEDataSet(), true);
                }
            }
        }
        return this.iPSDEMethod;
    }

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEServiceAPI iPSDEServiceAPI, PSDESADetail psDESADetail) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @Override
    public IPSDEOPPriv getMapPSDEOPPriv(int nPathIndex) {
        try {
            if (this.getPSDEOPPriv() == null) {
                return this.getPSDEServiceAPI().getPSSysServiceAPI().getDefaultPSDEOPPriv();
            }
            if ("DENY".equals(this.getPSDEOPPriv().getName()) || "NONE".equals(this.getPSDEOPPriv().getName())) {
                return this.getPSDEOPPriv();
            }
            if (this.getPSDEServiceAPIRS() == null) {
                return this.getPSDEServiceAPI().getPSSysServiceAPI().getDefaultPSDEOPPriv();
            }
            if (this.getPSDEServiceAPIRS().getDataAccCtrlMode() == 1) {
                return this.getPSDEOPPriv();
            }
            Iterator<? extends IPSDEServiceAPIRS> psDEServiceAPIRSs = this.getPSDEServiceAPI().getPSDEServiceAPIRSPath(nPathIndex);
            if (psDEServiceAPIRSs == null) {
                return this.getPSDEServiceAPI().getPSSysServiceAPI().getDefaultPSDEOPPriv();
            }
            boolean bContains = false;
            ArrayList<IPSDEServiceAPIRS> list = new ArrayList<IPSDEServiceAPIRS>();
            while (psDEServiceAPIRSs.hasNext()) {
                IPSDEServiceAPIRS iPSDEServiceAPIRS = psDEServiceAPIRSs.next();
                list.add(0, iPSDEServiceAPIRS);
                if (this.getPSDEServiceAPIRS() != iPSDEServiceAPIRS) continue;
                bContains = true;
                break;
            }
            if (!bContains || list.size() == 0) {
                return this.getPSDEServiceAPI().getPSSysServiceAPI().getDefaultPSDEOPPriv();
            }
            String strLastAction = this.getPSDEOPPriv().getName();
            IPSDataEntity lastPSDataEntity = this.getPSDEServiceAPI().getPSDataEntity();
            int i = 0;
            while (i < list.size()) {
                IPSDEServiceAPIRS iPSDEServiceAPIRS = (IPSDEServiceAPIRS)list.get(i);
                if (i != 0 && iPSDEServiceAPIRS.getDataAccCtrlMode() == 1) break;
                Iterator<IPSDEOPPriv> psDEOPPrivs = lastPSDataEntity.getAllPSDEOPPrivs();
                if (psDEOPPrivs == null) {
                    return this.getPSDEServiceAPI().getPSSysServiceAPI().getDefaultPSDEOPPriv();
                }
                IPSDEOPPriv mapPSDEOPPriv = null;
                while (psDEOPPrivs.hasNext()) {
                    IPSDEOPPriv iPSDEOPPriv = psDEOPPrivs.next();
                    if (StringHelper.compare((String)iPSDEOPPriv.getName(), (String)strLastAction, (boolean)false) != 0 || iPSDEOPPriv.getMapPSDataEntity() == null || !iPSDEOPPriv.getMapPSDataEntity().getId().equals(iPSDEServiceAPIRS.getMajorPSDEServiceAPI().getPSDataEntity().getId())) continue;
                    mapPSDEOPPriv = iPSDEOPPriv;
                    break;
                }
                if (mapPSDEOPPriv == null) {
                    return this.getPSDEServiceAPI().getPSSysServiceAPI().getDefaultPSDEOPPriv();
                }
                strLastAction = mapPSDEOPPriv.getMapPSDEOPPrivName();
                lastPSDataEntity = mapPSDEOPPriv.getMapPSDataEntity();
                ++i;
            }
            if (lastPSDataEntity == null || StringHelper.isNullOrEmpty((String)strLastAction)) {
                return this.getPSDEServiceAPI().getPSSysServiceAPI().getDefaultPSDEOPPriv();
            }
            Iterator<IPSDEOPPriv> psDEOPPrivs = lastPSDataEntity.getAllPSDEOPPrivs();
            while (psDEOPPrivs.hasNext()) {
                IPSDEOPPriv iPSDEOPPriv = psDEOPPrivs.next();
                if (StringHelper.compare((String)iPSDEOPPriv.getName(), (String)strLastAction, (boolean)false) != 0 || iPSDEOPPriv.getMapPSDataEntity() != null) continue;
                return iPSDEOPPriv;
            }
            return this.getPSDEServiceAPI().getPSSysServiceAPI().getDefaultPSDEOPPriv();
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return null;
        }
    }

    @Override
    @PSModelRTMeta(description="\u6620\u5c04\u64cd\u4f5c\u6807\u8bc6\u8def\u5f84[0]", hideempty=true, dump=false, ignorepf=true, outputdoc="false")
    public IPSDEOPPriv getMapPSDEOPPrivPath0() {
        return this.getMapPSDEOPPriv(0);
    }

    @Override
    @PSModelRTMeta(description="\u6620\u5c04\u64cd\u4f5c\u6807\u8bc6\u8def\u5f84[1]", hideempty=true, dump=false, ignorepf=true, outputdoc="false")
    public IPSDEOPPriv getMapPSDEOPPrivPath1() {
        return this.getMapPSDEOPPriv(1);
    }

    @Override
    @PSModelRTMeta(description="\u6620\u5c04\u64cd\u4f5c\u6807\u8bc6\u8def\u5f84[2]", hideempty=true, dump=false, ignorepf=true, outputdoc="false")
    public IPSDEOPPriv getMapPSDEOPPrivPath2() {
        return this.getMapPSDEOPPriv(2);
    }

    @Override
    @PSModelRTMeta(description="\u6620\u5c04\u64cd\u4f5c\u6807\u8bc6\u8def\u5f84[3]", hideempty=true, dump=false, ignorepf=true, outputdoc="false")
    public IPSDEOPPriv getMapPSDEOPPrivPath3() {
        return this.getMapPSDEOPPriv(3);
    }

    @Override
    @PSModelRTMeta(description="\u6620\u5c04\u64cd\u4f5c\u6807\u8bc6\u8def\u5f84[4]", hideempty=true, dump=false, ignorepf=true, outputdoc="false")
    public IPSDEOPPriv getMapPSDEOPPrivPath4() {
        return this.getMapPSDEOPPriv(4);
    }

    @Override
    public IPSDEServiceAPI getInPSDEServiceAPI() throws Exception {
        return this.getPSDEServiceAPIMethod().getInPSDEServiceAPI();
    }

    @Override
    public IPSDEServiceAPI getOutPSDEServiceAPI() throws Exception {
        return this.getPSDEServiceAPIMethod().getOutPSDEServiceAPI();
    }

    @Override
    @PSModelRTMeta(description="\u65b9\u6cd5\u8f93\u5165\u5bf9\u8c61", hideempty=true, child=true)
    public IPSDEServiceAPIMethodInput getPSDEServiceAPIMethodInput() {
        return this.getPSDEServiceAPIMethod().getPSDEServiceAPIMethodInput();
    }

    @Override
    @PSModelRTMeta(description="\u65b9\u6cd5\u8fd4\u56de\u5bf9\u8c61", hideempty=true, child=true)
    public IPSDEServiceAPIMethodReturn getPSDEServiceAPIMethodReturn() {
        return this.getPSDEServiceAPIMethod().getPSDEServiceAPIMethodReturn();
    }

    @Override
    @PSModelRTMeta(description="\u65e0\u670d\u52a1\u4ee3\u7801\u6807\u8bc6", ignoredumpvalues="false")
    public boolean isNoServiceCodeName() {
        return this.getPSDEServiceAPIMethod().isNoServiceCodeName();
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u8bbf\u95ee\u6807\u8bc6", hideempty2=true)
    public String getDataAccessAction() {
        return this.getPSDEServiceAPIMethod().getDataAccessAction();
    }

    @Override
    @PSModelRTMeta(description="\u9700\u8981\u63d0\u4f9b\u8d44\u6e90\u952e\u503c", ignoredumpvalues="false")
    public boolean isNeedResourceKey() {
        return this.getPSDEServiceAPIMethod().isNeedResourceKey();
    }

    @Override
    @PSModelRTMeta(description="\u91cd\u5b9a\u5411\u5916\u90e8\u670d\u52a1\u63a5\u53e3\u5b9e\u4f53\u65b9\u6cd5", hideempty=true)
    public IPSSubSysServiceAPIDEMethod getPSSubSysServiceAPIDEMethod() throws Exception {
        return this.getPSDEServiceAPIMethod().getPSSubSysServiceAPIDEMethod();
    }

    @Override
    protected IPSModelObject onGetParentModel() {
        if (this.getPSDEServiceAPIRS() != null) {
            return this.getPSDEServiceAPIRS();
        }
        return this.getPSDEServiceAPI();
    }

    @Override
    protected String onGetRTMOSFileName() {
        if (StringHelper.isNullOrEmpty((String)this.getCodeName())) {
            if (this.getPSDEAction() != null) {
                return this.getPSDEAction().getCodeName();
            }
            if (this.getPSDEDataSet() != null) {
                return this.getPSDEDataSet().getCodeName();
            }
        }
        return super.onGetRTMOSFileName();
    }
}

