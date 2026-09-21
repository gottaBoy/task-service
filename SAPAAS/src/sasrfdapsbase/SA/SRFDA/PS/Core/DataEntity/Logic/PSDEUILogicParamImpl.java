/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUILogic;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUILogicParam;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEUILogic;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEUILogicParam;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSDELogicParam;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEUILogicParamImpl
extends PSObjectImpl
implements IPSDEUILogicParam,
IPSAppDEUILogicParam {
    private static final Log log = LogFactory.getLog(PSDEUILogicParamImpl.class);
    protected IPSDEUILogic iPSDEUILogic;
    protected PSDELogicParam psDELogicParam;
    private boolean bDefaultParam = false;
    private IPSAppDEUILogic iPSAppDELogic = null;
    private int nParamType = 0;
    private String strFieldName = "";
    private int nStdDataType = 0;
    private String strDefaultValue = null;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEUILogic iPSDEUILogic, PSDELogicParam psDELogicParam) throws Exception {
        try {
            IPSAppDEUILogic iPSAppDELogic;
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSDEUILogic = iPSDEUILogic;
            this.psDELogicParam = psDELogicParam;
            this.setId(this.psDELogicParam.getPSDELOGICPARAMID());
            this.setName(this.psDELogicParam.getLOGICNAME());
            this.setPSObjectData(this.psDELogicParam);
            if (iPSDEUILogic instanceof IPSAppDEUILogic && (iPSAppDELogic = (IPSAppDEUILogic)iPSDEUILogic).getPSAppDataEntity() != null) {
                this.iPSAppDELogic = iPSAppDELogic;
            }
            if (!psDELogicParam.isDEFAULTPARAMNull()) {
                this.bDefaultParam = psDELogicParam.getDEFAULTPARAM();
            }
            if (!this.psDELogicParam.isGLOBALPARAMNull()) {
                this.nParamType = this.psDELogicParam.getGLOBALPARAM();
            }
            if (this.isParamSubParam()) {
                if (StringHelper.isNullOrEmpty((String)this.psDELogicParam.getREFPARAMNAME())) {
                    throw new Exception(StringHelper.format((String)"\u53c2\u6570\u5b50\u53c2\u6570[%1$s]\u6ca1\u6709\u6307\u5b9a\u5f15\u7528\u7684\u53c2\u6570", (Object)this.getName()));
                }
                if (StringHelper.compare((String)this.psDELogicParam.getREFPARAMNAME(), (String)this.getName(), (boolean)true) == 0) {
                    throw new Exception(StringHelper.format((String)"\u53c2\u6570\u5b50\u53c2\u6570[%1$s]\u5f15\u7528\u7684\u53c2\u6570\u4e0d\u80fd\u4e3a\u81ea\u8eab", (Object)this.getName()));
                }
            }
            if (this.isAppGlobalParam() || this.isViewSessionParam() || this.isRouteViewSessionParam() || this.isParamSubParam()) {
                if (StringHelper.isNullOrEmpty((String)this.psDELogicParam.getREFFIELDNAME())) {
                    throw new Exception(StringHelper.format((String)"\u53c2\u6570[%1$s]\u6ca1\u6709\u6307\u5b9a\u53c2\u6570\u5c5e\u6027\u540d\u79f0", (Object)this.getName()));
                }
                this.strFieldName = this.psDELogicParam.getREFFIELDNAME();
            }
            if ((this.isSimpleParam() || this.isSimpleListParam()) && !this.psDELogicParam.isSTDDATATYPENull()) {
                this.nStdDataType = this.psDELogicParam.getSTDDATATYPE();
            }
            if (this.isSimpleParam() && !StringHelper.isNullOrEmpty((String)this.psDELogicParam.getDEFAULTVALUE())) {
                this.strDefaultValue = this.psDELogicParam.getDEFAULTVALUE();
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
        this.getRefPSDEUILogicParam();
        return super.onCheck();
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.psDELogicParam.getPSDELOGICPARAMNAME();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u754c\u9762\u903b\u8f91\u5bf9\u8c61")
    public IPSDEUILogic getPSDEUILogic() {
        return this.iPSDEUILogic;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSDEUILogic().getPSSysModelInstId();
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u53c2\u6570", ignoredumpvalues="false", fields={"DEFAULTPARAM"})
    public boolean isDefault() {
        return this.bDefaultParam;
    }

    @Override
    public String getModelType() {
        if (this.getPSAppDEUILogic() != null) {
            return "PSAPPDEUILOGICPARAM";
        }
        return "PSDEUILOGICPARAM";
    }

    @Override
    public String getModelId() {
        if (this.getPSAppDEUILogic() != null) {
            return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSAppDEUILogic().getModelId(), (Object)super.getModelId());
        }
        return super.getModelId();
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSDEUILogic().getPSDataEntity().getPSSystem());
    }

    @Override
    public IPSAppDEUILogic getPSAppDEUILogic() {
        return this.iPSAppDELogic;
    }

    @Override
    @PSModelRTMeta(description="\u5f53\u524d\u89c6\u56fe\u5bf9\u8c61", ignoredumpvalues="false")
    public boolean isActiveViewParam() {
        return this.getParamType() == 20;
    }

    @Override
    @PSModelRTMeta(description="\u5f53\u524d\u5bb9\u5668\u5bf9\u8c61", ignoredumpvalues="false")
    public boolean isActiveContainerParam() {
        return this.getParamType() == 21;
    }

    @Override
    @PSModelRTMeta(description="\u5f53\u524d\u90e8\u4ef6\u5bf9\u8c61", ignoredumpvalues="false")
    public boolean isActiveCtrlParam() {
        return this.getParamType() == 22;
    }

    @Override
    @PSModelRTMeta(description="\u6307\u5b9a\u90e8\u4ef6\u5bf9\u8c61", ignoredumpvalues="false")
    public boolean isCtrlParam() {
        return this.getParamType() == 22 || this.getParamType() == 23;
    }

    public int getParamType() {
        return this.nParamType;
    }

    @Override
    @PSModelRTMeta(description="\u5bfc\u822a\u4e0a\u4e0b\u6587\u7ed1\u5b9a\u53c2\u6570", ignoredumpvalues="false")
    public boolean isNavContextParam() {
        return this.getParamType() == 24;
    }

    @Override
    @PSModelRTMeta(description="\u5bfc\u822a\u89c6\u56fe\u53c2\u6570\u7ed1\u5b9a\u53c2\u6570", ignoredumpvalues="false")
    public boolean isNavViewParamParam() {
        return this.getParamType() == 25;
    }

    @Override
    @PSModelRTMeta(description="\u5bfc\u822a\u6570\u636e\u53c2\u6570\u7ed1\u5b9a\u53c2\u6570", ignoredumpvalues="false")
    public boolean isViewNavDataParam() {
        return this.getParamType() == 26;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5168\u5c40\u53c2\u6570\u7ed1\u5b9a\u53c2\u6570", ignoredumpvalues="false")
    public boolean isAppGlobalParam() {
        return this.getParamType() == 27;
    }

    @Override
    @PSModelRTMeta(description="\u9876\u7ea7\u89c6\u56fe\u4f1a\u8bdd\u5171\u4eab\u53c2\u6570\u7ed1\u5b9a\u53c2\u6570", ignoredumpvalues="false")
    public boolean isRouteViewSessionParam() {
        return this.getParamType() == 28;
    }

    @Override
    @PSModelRTMeta(description="\u5f53\u524d\u89c6\u56fe\u4f1a\u8bdd\u5171\u4eab\u53c2\u6570\u7ed1\u5b9a\u53c2\u6570", ignoredumpvalues="false")
    public boolean isViewSessionParam() {
        return this.getParamType() == 29;
    }

    public boolean isParamSubParam() {
        return this.getParamType() == 99;
    }

    public IPSDEUILogicParam getRefPSDEUILogicParam() throws Exception {
        if (!this.isParamSubParam()) {
            return null;
        }
        IPSDEUILogicParam iPSDEUILogicParam = null;
        Iterator<? extends IPSDEUILogicParam> psDEUILogicParams = this.getPSAppDEUILogic().getPSDEUILogicParams();
        if (psDEUILogicParams != null) {
            while (psDEUILogicParams.hasNext()) {
                IPSDEUILogicParam item = psDEUILogicParams.next();
                if (StringHelper.compare((String)this.psDELogicParam.getREFPARAMNAME(), (String)item.getName(), (boolean)true) != 0) continue;
                iPSDEUILogicParam = item;
                break;
            }
        }
        if (iPSDEUILogicParam == null) {
            throw new Exception(String.format("\u754c\u9762\u5904\u7406\u903b\u8f91\u4e0d\u5b58\u5728\u6307\u5b9a\u53c2\u6570[%1$s]", this.psDELogicParam.getREFPARAMNAME()));
        }
        return iPSDEUILogicParam;
    }

    @Override
    @PSModelRTMeta(description="\u53c2\u6570\u5c5e\u6027\u540d\u79f0", fields={"REFFIELDNAME"})
    public String getParamFieldName() {
        return this.strFieldName;
    }

    @Override
    @PSModelRTMeta(description="\u53c2\u6570\u6807\u8bb0", fields={"PARAMTAG"})
    public String getParamTag() {
        return this.psDELogicParam.getPARAMTAG();
    }

    @Override
    @PSModelRTMeta(description="\u53c2\u6570\u6807\u8bb02", fields={"PARAMTAG2"})
    public String getParamTag2() {
        return this.psDELogicParam.getPARAMTAG2();
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u5bf9\u8c61\u53d8\u91cf", ignoredumpvalues="false")
    public boolean isEntityParam() {
        return this.getParamType() == 0;
    }

    @Override
    @PSModelRTMeta(description="\u8fc7\u6ee4\u5668\u5bf9\u8c61\u53d8\u91cf", ignoredumpvalues="false")
    public boolean isFilterParam() {
        return this.getParamType() == 5;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u5bf9\u8c61\u5217\u8868\u53d8\u91cf", ignoredumpvalues="false")
    public boolean isEntityListParam() {
        return this.getParamType() == 6;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u5bf9\u8c61\u5b57\u5178\u53d8\u91cf", ignoredumpvalues="false")
    public boolean isEntityMapParam() {
        return this.getParamType() == 12;
    }

    @Override
    @PSModelRTMeta(description="\u4e0a\u4e00\u6b21\u8c03\u7528\u8fd4\u56de\u53d8\u91cf", ignoredumpvalues="false")
    public boolean isLastReturnParam() {
        return this.getParamType() == 4;
    }

    @Override
    @PSModelRTMeta(description="\u5206\u9875\u67e5\u8be2\u7ed3\u679c\u53d8\u91cf", ignoredumpvalues="false")
    public boolean isEntityPageParam() {
        return this.getParamType() == 7;
    }

    @Override
    @PSModelRTMeta(description="\u7b80\u5355\u6570\u636e\u5217\u8868\u53d8\u91cf", ignoredumpvalues="false")
    public boolean isSimpleListParam() {
        return this.getParamType() == 11;
    }

    @Override
    @PSModelRTMeta(description="\u7b80\u5355\u6570\u636e\u53d8\u91cf", ignoredumpvalues="false")
    public boolean isSimpleParam() {
        return this.getParamType() == 10;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u7a0b\u5e8f\u53d8\u91cf", ignoredumpvalues="false")
    public boolean isApplicationParam() {
        return this.getParamType() == 30;
    }

    @Override
    @PSModelRTMeta(description="\u7b80\u5355\u6570\u636e\u7c7b\u578b", codelist="StdDataType", ignoredumpvalues="0", fields={"STDDATATYPE"})
    public int getStdDataType() {
        return this.nStdDataType;
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u540d\u79f0", hideempty2=true, fields={"LOGICNAME"})
    public String getLogicName() {
        return this.psDELogicParam.getLOGICNAME();
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u503c\u7c7b\u578b", hideempty2=true)
    public String getDefaultValueType() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u503c", hideempty2=true, fields={"DEFAULTVALUE"})
    public String getDefaultValue() {
        return this.strDefaultValue;
    }

    @Override
    @PSModelRTMeta(description="\u64cd\u4f5c\u4f1a\u8bdd\u53d8\u91cf", ignoredumpvalues="false")
    public boolean isSessionParam() {
        return this.getParamType() == 1;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u73af\u5883\u53d8\u91cf", ignoredumpvalues="false")
    public boolean isEnvParam() {
        return this.getParamType() == 2;
    }
}

