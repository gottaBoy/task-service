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
package SA.SRFDA.PS.Core.Service;

import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEActionInputDTO;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSSystemSetting;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysSFPluginTempl;
import SA.SRFDA.PS.Core.SF.IPSSFXCodeObject;
import SA.SRFDA.PS.Core.SF.PSSFXCodeObjectProxy;
import SA.SRFDA.PS.Core.Service.IPSDEActionRESTfulAPI;
import SA.SRFDA.PS.Core.Service.IPSRESTfulAPI;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPI;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIDE;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIDEMethod;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIMethod;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIMethodInput;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIMethodReturn;
import SA.SRFDA.PS.Core.Service.OpenAPI.IPSOpenAPI3Operation;
import SA.SRFDA.PS.Core.Service.OpenAPI.IPSOpenAPI3Path;
import SA.SRFDA.PS.Core.Service.OpenAPI.IPSOpenAPI3Paths;
import SA.SRFDA.PS.Core.Service.PSSubSysServiceAPIMethodInputImpl;
import SA.SRFDA.PS.Core.Service.PSSubSysServiceAPIMethodReturnImpl;
import SA.SRFDA.PS.Data.PSSubSysSADetail;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.Iterator;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelPFIgnoreMeta
public class PSSubSysServiceAPIMethodImpl
extends PSObjectImpl
implements IPSSubSysServiceAPIDEMethod,
IPSSubSysServiceAPIMethod,
IPSRESTfulAPI,
IPSDEActionRESTfulAPI {
    private static final Log log = LogFactory.getLog(PSSubSysServiceAPIMethodImpl.class);
    public static final IPSSubSysServiceAPIDEMethod EMPTY = new PSSubSysServiceAPIMethodImpl();
    public static final String TAG_AUTOPATH = "AUTOPATH";
    private IPSSubSysServiceAPI iPSSubSysServiceAPI = null;
    private IPSDataEntity iPSDataEntity = null;
    private PSSubSysSADetail psSubSysSADetail = null;
    private String strMethodType = null;
    private String strRequestMethod = null;
    private String strRequestPath = null;
    private String strUniqueTag = null;
    private String strPSDEId = null;
    private String strPSDEName = null;
    private String strPSDELogicName = null;
    private String strKeyField = null;
    private String strRequestParamType = null;
    private String strPSDECodeName = null;
    private IPSSubSysServiceAPIDE iPSSubSysServiceAPIDE = null;
    private String strReturnValueType = null;
    private boolean bFromDEModel = false;
    private IPSSysSFPlugin iPSSysSFPlugin = null;
    private IPSSFXCodeObject iPSSFXCodeObject = null;
    private boolean bNoServiceCodeName = false;
    private IPSSubSysServiceAPIMethodInput iPSSubSysServiceAPIMethodInput = null;
    private IPSSubSysServiceAPIMethodReturn iPSSubSysServiceAPIMethodReturn = null;
    private IPSDEAction iPSDEAction = null;
    private IPSDEDataSet iPSDEDataSet = null;
    private IPSOpenAPI3Path iPSOpenAPI3Path = null;
    private IPSOpenAPI3Operation iPSOpenAPI3Operation = null;
    private String strCodeName = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSubSysServiceAPI iPSSubSysServiceAPI, IPSDataEntity iPSDataEntity, PSSubSysSADetail psSubSysSADetail, Object source) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSubSysServiceAPI(iPSSubSysServiceAPI);
            this.psSubSysSADetail = psSubSysSADetail;
            this.iPSDataEntity = iPSDataEntity;
            this.setId(this.psSubSysSADetail.getPSSUBSYSSADETAILID());
            this.setName(this.psSubSysSADetail.getPSSUBSYSSADETAILNAME());
            this.setPSObjectData(this.psSubSysSADetail);
            this.strCodeName = this.psSubSysSADetail.getCODENAME();
            if (this.isAutoModel()) {
                this.strCodeName = this.getPSSubSysServiceAPI().getAPICodeName(null, this.strCodeName, null);
            }
            this.strMethodType = psSubSysSADetail.getDETAILTYPE();
            this.strReturnValueType = psSubSysSADetail.getRETVALTYPE();
            if (!StringHelper.isNullOrEmpty((String)this.psSubSysSADetail.getPSSUBSYSSADEID())) {
                this.iPSSubSysServiceAPIDE = this.getPSSubSysServiceAPI().getPSSubSysServiceAPIDE(this.psSubSysSADetail.getPSSUBSYSSADEID(), false);
            } else if (this.iPSDataEntity != null) {
                this.iPSSubSysServiceAPIDE = this.getPSSubSysServiceAPI().getPSSubSysServiceAPIDE(this.iPSDataEntity.getName().toUpperCase(), true);
            }
            if (this.iPSDataEntity != null) {
                if (source instanceof IPSDEAction) {
                    this.iPSDEAction = (IPSDEAction)source;
                } else if (source instanceof IPSDEDataSet) {
                    this.iPSDEDataSet = (IPSDEDataSet)source;
                }
            }
            this.strUniqueTag = this.psSubSysSADetail.getUNIQUETAG();
            if (!StringHelper.isNullOrEmpty((String)this.psSubSysSADetail.getREQUESTMETHOD())) {
                this.strRequestMethod = this.psSubSysSADetail.getREQUESTMETHOD();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSubSysSADetail.getSERVICEURL())) {
                this.strRequestPath = this.psSubSysSADetail.getSERVICEURL();
            }
            this.strPSDEId = this.psSubSysSADetail.getPSDEID();
            this.strPSDEName = this.psSubSysSADetail.getPSDENAME();
            this.strPSDELogicName = this.psSubSysSADetail.getPSDELOGICNAME();
            this.strKeyField = this.psSubSysSADetail.getKEYFIELDNAME();
            this.strRequestParamType = this.psSubSysSADetail.getREQUESTPARAMTYPE();
            if (StringHelper.isNullOrEmpty((String)this.strPSDEId) && this.iPSDataEntity != null) {
                this.strPSDEId = this.iPSDataEntity.getId();
            }
            if (StringHelper.isNullOrEmpty((String)this.strPSDEName) && this.iPSDataEntity != null) {
                this.strPSDEName = this.iPSDataEntity.getName();
            }
            if (StringHelper.isNullOrEmpty((String)this.strPSDELogicName) && this.iPSDataEntity != null) {
                this.strPSDELogicName = this.iPSDataEntity.getLogicName();
            }
            if (StringHelper.isNullOrEmpty((String)this.strKeyField) && this.iPSDataEntity != null && this.iPSDataEntity.getKeyPSDEField() != null) {
                this.strKeyField = this.iPSDataEntity.getKeyPSDEField().getName();
            }
            if (StringHelper.isNullOrEmpty((String)this.strPSDECodeName) && this.iPSDataEntity != null) {
                this.strPSDECodeName = this.iPSDataEntity.getServiceCodeName();
            }
            if (!this.psSubSysSADetail.isNOSERVICECODENAMENull()) {
                this.bNoServiceCodeName = this.psSubSysSADetail.getNOSERVICECODENAME();
            }
            if (StringHelper.isNullOrEmpty((String)this.getRequestMethod())) {
                if (StringHelper.compare((String)this.getMethodType(), (String)"DEACTION", (boolean)false) == 0) {
                    String strPSDEActionName = this.getCodeName().toUpperCase();
                    this.strRequestMethod = strPSDEActionName.indexOf("CREATE") != -1 ? this.getPSSubSysServiceAPI().getCreateReqMethod("POST") : (strPSDEActionName.indexOf("UPDATE") != -1 ? this.getPSSubSysServiceAPI().getUpdateReqMethod("PUT") : (strPSDEActionName.indexOf("GET") != -1 ? this.getPSSubSysServiceAPI().getGetReqMethod("GET") : (strPSDEActionName.indexOf("REMOVE") != -1 ? this.getPSSubSysServiceAPI().getDeleteReqMethod("DELETE") : (!StringHelper.isNullOrEmpty((String)this.getPSSubSysServiceAPI().getDefaultDEActionReqMethod()) ? this.getPSSubSysServiceAPI().getDefaultDEActionReqMethod() : "POST"))));
                } else if (StringHelper.compare((String)this.getMethodType(), (String)"FETCH", (boolean)false) == 0) {
                    this.strRequestMethod = !StringHelper.isNullOrEmpty((String)this.getPSSubSysServiceAPI().getDefaultDEDataSetReqMethod()) ? this.getPSSubSysServiceAPI().getDefaultDEDataSetReqMethod() : "POST";
                } else if (StringHelper.compare((String)this.getMethodType(), (String)"SELECT", (boolean)false) == 0) {
                    this.strRequestMethod = !StringHelper.isNullOrEmpty((String)this.getPSSubSysServiceAPI().getDefaultSelectReqMethod()) ? this.getPSSubSysServiceAPI().getDefaultSelectReqMethod() : "POST";
                }
                if (StringHelper.isNullOrEmpty((String)this.getRequestParamType())) {
                    this.strRequestParamType = StringHelper.compare((String)this.getMethodType(), (String)"DEACTION", (boolean)false) == 0 ? (StringHelper.compare((String)this.getRequestMethod(), (String)"GET", (boolean)false) == 0 || StringHelper.compare((String)this.getRequestMethod(), (String)"DELETE", (boolean)false) == 0 ? "FIELD" : "ENTITY") : (StringHelper.compare((String)this.getRequestMethod(), (String)"GET", (boolean)false) == 0 ? "URIPARAM" : "ENTITY");
                }
            }
            if (StringHelper.compare((String)this.getRequestParamType(), (String)"FIELD", (boolean)false) == 0 && StringHelper.isNullOrEmpty((String)this.getKeyField()) && this.getPSSubSysServiceAPIDE() != null && this.getPSSubSysServiceAPIDE().getKeyDEField() != null) {
                this.strKeyField = this.getPSSubSysServiceAPIDE().getKeyDEField().getName();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSubSysSADetail.getPSSYSSFPLUGINID())) {
                this.iPSSysSFPlugin = this.getPSSubSysServiceAPIDE().getPSSubSysServiceAPI().getPSSystem().getPSSysSFPlugin(this.psSubSysSADetail.getPSSYSSFPLUGINID());
            }
            if (this.getPSSysSFPlugin() != null) {
                String strPSSysSFPluginTemplId = KeyValueHelper.genUniqueId((String)this.getPSSysSFPlugin().getId(), (String)this.getPSSubSysServiceAPIDE().getPSSubSysServiceAPI().getPSSystem().getPSSFId());
                IPSSysSFPluginTempl iPSSysSFPluginTempl = this.getPSSubSysServiceAPIDE().getPSSubSysServiceAPI().getPSSystem().getPSSysSFPluginTempl(strPSSysSFPluginTemplId, true);
                if (iPSSysSFPluginTempl != null) {
                    this.iPSSFXCodeObject = new PSSFXCodeObjectProxy(iPSSysSFPluginTempl, this);
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
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    protected int onCheck() throws Exception {
        int nCount = 0;
        if (this.getPSSubSysServiceAPIMethodInput() != null) {
            nCount += this.getPSSubSysServiceAPIMethodInput().check();
        }
        if (this.getPSSubSysServiceAPIMethodReturn() != null) {
            nCount += this.getPSSubSysServiceAPIMethodReturn().check();
        }
        return nCount += super.onCheck();
    }

    @Override
    @PSModelRTMeta(description="\u5916\u90e8\u63a5\u53e3\u5bf9\u8c61", hideempty2=true)
    public IPSSubSysServiceAPI getPSSubSysServiceAPI() {
        return this.iPSSubSysServiceAPI;
    }

    protected void setPSSubSysServiceAPI(IPSSubSysServiceAPI iPSSubSysServiceAPI) {
        this.iPSSubSysServiceAPI = iPSSubSysServiceAPI;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSSubSysServiceAPI.getPSSysModelInstId();
    }

    @Override
    @PSModelRTMeta(description="\u65b9\u6cd5\u7c7b\u578b", codelist="DESADetailType", fields={"DETAILTYPE"})
    public String getMethodType() {
        return this.strMethodType;
    }

    @PSModelRTMeta(description="\u884c\u4e3a\u7c7b\u578b", doc="\u7b49\u540c{@link #getMethodType}")
    public String getActionType() {
        return this.getMethodType();
    }

    @PSModelRTMeta(description="\u63a5\u53e3\u6807\u8bc6")
    public String getUniqueTag() {
        return this.strUniqueTag;
    }

    @Override
    public IPSRESTfulAPI getPSRESTfulAPI() {
        return this;
    }

    @Override
    @PSModelRTMeta(description="\u8bf7\u6c42\u8def\u5f84", fields={"SERVICEURL"})
    public String getRequestPath() {
        return this.strRequestPath;
    }

    @Override
    @PSModelRTMeta(description="\u8bf7\u6c42\u65b9\u5f0f", codelist="RequestMethod", fields={"REQUESTMETHOD"})
    public String getRequestMethod() {
        return this.strRequestMethod;
    }

    @Override
    public String getPSDEId() {
        return this.strPSDEId;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u540d\u79f0")
    public String getPSDEName() {
        return this.strPSDEName;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u903b\u8f91\u540d\u79f0")
    public String getPSDELogicName() {
        return this.strPSDELogicName;
    }

    public String getActionPath() {
        return this.getRequestPath();
    }

    @PSModelRTMeta(description="\u4e3b\u952e\u5c5e\u6027")
    public String getKeyField() {
        return this.strKeyField;
    }

    public String getDEName() {
        return this.getPSDEName();
    }

    @Override
    @PSModelRTMeta(description="\u53c2\u6570\u7c7b\u578b", codelist="ServiceReqParamType", fields={"REQUESTPARAMTYPE"})
    public String getRequestParamType() {
        return this.strRequestParamType;
    }

    @Override
    @PSModelRTMeta(description="\u8bf7\u6c42\u5c5e\u6027")
    public String getRequestField() {
        return this.getKeyField();
    }

    @Override
    public String getModelType() {
        return "PSSUBSYSSADETAIL";
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u4ee3\u7801\u540d\u79f0")
    public String getPSDECodeName() {
        if (StringHelper.isNullOrEmpty((String)this.strPSDECodeName)) {
            return this.getPSDEName();
        }
        return this.strPSDECodeName;
    }

    @Override
    public String getModelName() {
        if (!StringHelper.isNullOrEmpty((String)this.getUniqueTag())) {
            return this.getUniqueTag();
        }
        return super.getModelName();
    }

    @Override
    public String getFullModelName() {
        return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSSubSysServiceAPI().getFullModelName(), (Object)this.getModelName());
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSSubSysServiceAPI().getPSSystem());
    }

    @Override
    public String getModelId() {
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSSubSysServiceAPI().getModelId(), (Object)super.getModelId());
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u540d\u79f02", hideempty2=true)
    public String getCodeName2() {
        return this.psSubSysSADetail.getCODENAME2();
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.strCodeName;
    }

    @Override
    @PSModelRTMeta(description="\u65b9\u6cd5\u53c2\u6570", hideempty2=true, fields={"DETAILPARAM"})
    public String getMethodParam() {
        return this.psSubSysSADetail.getDETAILPARAM();
    }

    @Override
    @PSModelRTMeta(description="\u65b9\u6cd5\u53c2\u65702", hideempty2=true, fields={"DETAILPARAM2"})
    public String getMethodParam2() {
        return this.psSubSysSADetail.getDETAILPARAM2();
    }

    @Override
    @PSModelRTMeta(description="\u5916\u90e8\u63a5\u53e3\u5b9e\u4f53\u5bf9\u8c61", hideempty2=true, dumpref=true, from="IPSSubSysServiceAPI", fields={"PSSUBSYSSADEID"})
    public IPSSubSysServiceAPIDE getPSSubSysServiceAPIDE() {
        return this.iPSSubSysServiceAPIDE;
    }

    @Override
    @PSModelRTMeta(description="\u65b9\u6cd5\u6807\u8bb0", hideempty2=true, fields={"DETAILTAG"})
    public String getMethodTag() {
        return this.psSubSysSADetail.getDETAILTAG();
    }

    @Override
    @PSModelRTMeta(description="\u65b9\u6cd5\u6807\u8bb02", hideempty2=true, fields={"DETAILTAG2"})
    public String getMethodTag2() {
        return this.psSubSysSADetail.getDETAILTAG2();
    }

    @Override
    @PSModelRTMeta(description="\u8fd4\u56de\u503c\u7c7b\u578b", codelist="DEActionRetValType", fields={"RETVALTYPE"})
    public String getReturnValueType() {
        return this.strReturnValueType;
    }

    @Override
    @PSModelRTMeta(description="\u540e\u7aef\u6269\u5c55\u63d2\u4ef6", hideempty=true)
    public IPSSysSFPlugin getPSSysSFPlugin() {
        return this.iPSSysSFPlugin;
    }

    @Override
    @PSModelRTMeta(description="\u7ed8\u5236\u5668", hideempty=true)
    public IPSSFXCodeObject getRender() {
        return this.iPSSFXCodeObject;
    }

    @Override
    @PSModelRTMeta(description="\u8f93\u5165\u5bf9\u8c61", hideempty=true, dumpref=true, from="IPSSubSysServiceAPI")
    public IPSSubSysServiceAPIDE getInPSSubSysServiceAPIDE() throws Exception {
        if (StringHelper.isNullOrEmpty((String)this.psSubSysSADetail.getINPSSUBSYSSADEID())) {
            return null;
        }
        return this.getPSSubSysServiceAPI().getPSSubSysServiceAPIDE(this.psSubSysSADetail.getINPSSUBSYSSADEID(), false);
    }

    @Override
    @PSModelRTMeta(description="\u8f93\u51fa\u5bf9\u8c61", hideempty=true, dumpref=true, from="IPSSubSysServiceAPI")
    public IPSSubSysServiceAPIDE getOutPSSubSysServiceAPIDE() throws Exception {
        if (StringHelper.isNullOrEmpty((String)this.psSubSysSADetail.getOUTPSSUBSYSSADEID())) {
            return null;
        }
        return this.getPSSubSysServiceAPI().getPSSubSysServiceAPIDE(this.psSubSysSADetail.getOUTPSSUBSYSSADEID(), false);
    }

    @Override
    public int getReturnStdDataType() {
        if (this.psSubSysSADetail.isRETSTDDATATYPENull()) {
            return 0;
        }
        return this.psSubSysSADetail.getRETSTDDATATYPE();
    }

    @Override
    public String getInputParamType() {
        return this.psSubSysSADetail.getREQUESTPARAMTYPE();
    }

    @Override
    @PSModelRTMeta(description="\u65e0\u670d\u52a1\u4ee3\u7801\u6807\u8bc6", ignoredumpvalues="false", fields={"NOSERVICECODENAME"})
    public boolean isNoServiceCodeName() {
        return this.bNoServiceCodeName;
    }

    @Override
    @PSModelRTMeta(description="\u72ec\u7acb\u8f93\u51fa\u8d44\u6e90\u952e\u503c", ignoredumpvalues="false", fields={"NEEDRESOURCEKEY"})
    public boolean isNeedResourceKey() {
        if (!this.psSubSysSADetail.isNEEDRESOURCEKEYNull()) {
            return this.psSubSysSADetail.getNEEDRESOURCEKEY();
        }
        if (StringHelper.compare((String)this.getMethodType(), (String)"DEACTION", (boolean)false) == 0) {
            if (this.getSourcePSDEAction() != null) {
                if ("CREATE".equals(this.getSourcePSDEAction().getActionMode()) || "GETDRAFT".equals(this.getSourcePSDEAction().getActionMode()) || "CHECKKEY".equals(this.getSourcePSDEAction().getActionMode()) || "SAVE".equals(this.getSourcePSDEAction().getActionMode())) {
                    return false;
                }
                if ("NONE".equals(this.getSourcePSDEAction().getPSDEActionInput().getType())) {
                    return false;
                }
                if (this.getPSSubSysServiceAPI().isEnableAPIModelEx() && "DTO".equals(this.getSourcePSDEAction().getPSDEActionInput().getType())) {
                    try {
                        if (this.getSourcePSDEAction().getPSDEActionInput().getPSDEMethodDTO() instanceof IPSDEActionInputDTO) {
                            IPSDEActionInputDTO iPSDEActionInputDTO = (IPSDEActionInputDTO)this.getSourcePSDEAction().getPSDEActionInput().getPSDEMethodDTO();
                            return iPSDEActionInputDTO.containsKeyField();
                        }
                    }
                    catch (Exception ex) {
                        log.error((Object)ex);
                    }
                }
            }
            return true;
        }
        return false;
    }

    @Override
    @PSModelRTMeta(description="\u65b9\u6cd5\u8f93\u5165\u5bf9\u8c61", hideempty=true, child=true, rtname="getInput", doctype="item", group="\u903b\u8f91", order=215)
    public IPSSubSysServiceAPIMethodInput getPSSubSysServiceAPIMethodInput() throws Exception {
        if (!this.getPSSubSysServiceAPI().isEnableServiceAPIDTO() || this.getPSSubSysServiceAPIDE() == null) {
            return null;
        }
        if (this.iPSSubSysServiceAPIMethodInput == null) {
            this.iPSSubSysServiceAPIMethodInput = this.createPSSubSysServiceAPIMethodInput();
        }
        return this.iPSSubSysServiceAPIMethodInput;
    }

    @Override
    @PSModelRTMeta(description="\u65b9\u6cd5\u8fd4\u56de\u5bf9\u8c61", hideempty=true, child=true, rtname="getReturn", doctype="item", group="\u903b\u8f91", order=216)
    public IPSSubSysServiceAPIMethodReturn getPSSubSysServiceAPIMethodReturn() throws Exception {
        if (!this.getPSSubSysServiceAPI().isEnableServiceAPIDTO() || this.getPSSubSysServiceAPIDE() == null) {
            return null;
        }
        if (this.iPSSubSysServiceAPIMethodReturn == null) {
            this.iPSSubSysServiceAPIMethodReturn = this.createPSSubSysServiceAPIMethodReturn();
        }
        return this.iPSSubSysServiceAPIMethodReturn;
    }

    @Override
    @PSModelRTMeta(description="\u6765\u6e90\u5b9e\u4f53", hideempty=true)
    public IPSDataEntity getSourcePSDataEntity() {
        return this.iPSDataEntity;
    }

    @Override
    @PSModelRTMeta(description="\u6765\u6e90\u5b9e\u4f53\u884c\u4e3a", hideempty=true)
    public IPSDEAction getSourcePSDEAction() {
        return this.iPSDEAction;
    }

    @Override
    @PSModelRTMeta(description="\u6765\u6e90\u5b9e\u4f53\u6570\u636e\u96c6", hideempty=true)
    public IPSDEDataSet getSourcePSDEDataSet() {
        return this.iPSDEDataSet;
    }

    protected IPSSubSysServiceAPIMethodInput createPSSubSysServiceAPIMethodInput() throws Exception {
        PSSubSysServiceAPIMethodInputImpl psSubSysServiceAPIMethodInputImpl = new PSSubSysServiceAPIMethodInputImpl();
        psSubSysServiceAPIMethodInputImpl.init(this.getDAGlobalHelper(), this);
        return psSubSysServiceAPIMethodInputImpl;
    }

    protected IPSSubSysServiceAPIMethodReturn createPSSubSysServiceAPIMethodReturn() throws Exception {
        PSSubSysServiceAPIMethodReturnImpl psSubSysServiceAPIMethodReturnImpl = new PSSubSysServiceAPIMethodReturnImpl();
        psSubSysServiceAPIMethodReturnImpl.init(this.getDAGlobalHelper(), this);
        return psSubSysServiceAPIMethodReturnImpl;
    }

    @Override
    @PSModelRTMeta(description="OpenAPI3 Path")
    public IPSOpenAPI3Path getPSOpenAPI3Path() {
        if (this.iPSOpenAPI3Path != null) {
            return this.iPSOpenAPI3Path;
        }
        if (this.getPSSubSysServiceAPI().getPSOpenAPI3Schema() == null) {
            return null;
        }
        if (StringHelper.isNullOrEmpty((String)this.getRequestPath())) {
            return null;
        }
        IPSOpenAPI3Paths iPSOpenAPI3Paths = this.getPSSubSysServiceAPI().getPSOpenAPI3Schema().getPSOpenAPI3Paths();
        if (iPSOpenAPI3Paths != null) {
            try {
                this.iPSOpenAPI3Path = (IPSOpenAPI3Path)iPSOpenAPI3Paths.getItem(this.getRequestPath(), true);
            }
            catch (Exception e) {
                log.error((Object)e);
            }
        }
        return this.iPSOpenAPI3Path;
    }

    protected void setPSOpenAPI3Path(IPSOpenAPI3Path iPSOpenAPI3Path) {
        this.iPSOpenAPI3Path = iPSOpenAPI3Path;
    }

    @Override
    @PSModelRTMeta(description="OpenAPI3 Operation")
    public IPSOpenAPI3Operation getPSOpenAPI3Operation() {
        if (this.iPSOpenAPI3Operation != null) {
            return this.iPSOpenAPI3Operation;
        }
        if (this.getPSOpenAPI3Path() == null) {
            return null;
        }
        String strMethod = this.getRequestMethod();
        if (!StringHelper.isNullOrEmpty((String)strMethod)) {
            strMethod = strMethod.toLowerCase();
            try {
                this.iPSOpenAPI3Operation = this.getPSOpenAPI3Path().getPSOpenAPI3Operation(strMethod, true);
            }
            catch (Exception e) {
                log.error((Object)e);
            }
        } else {
            Iterator psOpenAPI3Operations = this.getPSOpenAPI3Path().getPSOpenAPI3Operations();
            if (psOpenAPI3Operations != null && psOpenAPI3Operations.hasNext()) {
                this.iPSOpenAPI3Operation = (IPSOpenAPI3Operation)psOpenAPI3Operations.next();
            }
        }
        return this.iPSOpenAPI3Operation;
    }

    protected void setPSOpenAPI3Operation(IPSOpenAPI3Operation iPSOpenAPI3Operation) {
        this.iPSOpenAPI3Operation = iPSOpenAPI3Operation;
    }

    @Override
    protected IPSModelObject onGetParentModel() {
        if (this.getPSSubSysServiceAPIDE() != null) {
            return this.getPSSubSysServiceAPIDE();
        }
        return this.getPSSubSysServiceAPI();
    }

    @Override
    protected IPSModelObject onGetScopeModel() {
        if (this.getPSSubSysServiceAPIDE() != null) {
            return this.getPSSubSysServiceAPIDE();
        }
        return this.getPSSubSysServiceAPI();
    }

    @Override
    @PSModelRTMeta(description="\u6267\u884c\u4e4b\u540e\u8c03\u7528\u811a\u672c", hideempty2=true, fields={"AFTERCODE"})
    public String getAfterCode() {
        return this.psSubSysSADetail.getAFTERCODE();
    }

    @Override
    @PSModelRTMeta(description="\u65b9\u6cd5\u8c03\u7528\u811a\u672c\u4ee3\u7801", hideempty2=true, fields={"METHODCODE"})
    public String getMethodScriptCode() {
        return this.psSubSysSADetail.getMETHODCODE();
    }

    @Override
    @PSModelRTMeta(description="\u81ea\u52a8\u8ba1\u7b97\u8def\u5f84", ignoredumpvalues="false")
    public boolean isAutoPath() {
        return this.psSubSysSADetail.GetParamIntValue(TAG_AUTOPATH, 0) == 1;
    }

    @Override
    @PSModelRTMeta(description="\u8bf7\u6c42\u5185\u5bb9\u7c7b\u578b", codelist="ServiceReqContentType", fields={"REQUESTCONTENTTYPE"})
    public String getBodyContentType() {
        return this.psSubSysSADetail.getREQUESTCONTENTTYPE();
    }

    protected IPSSystemSetting getPSSystemSetting() {
        return (IPSSystemSetting)((Object)this.getPSSubSysServiceAPI().getPSSystem());
    }

    @Override
    protected void onFillModelNode(ObjectNode objectNode, String strModelType) throws Exception {
        super.onFillModelNode(objectNode, strModelType);
        if (this.isAutoPath()) {
            objectNode.remove("requestPath");
            objectNode.remove("autoPath");
        }
    }
}

