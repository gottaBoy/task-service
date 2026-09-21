/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.util.IPSModelObject
 *  net.ibizsys.pscore.srv.util.IPSRecursionWork
 *  net.ibizsys.pscore.srv.util.PSRecursionHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Service;

import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEMethodDTO;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEMethodDTOField;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Service.IPSServiceAPIDTO;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIDE;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIDEField;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIDERS;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIDTO;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIDTOField;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.util.IPSRecursionWork;
import net.ibizsys.pscore.srv.util.PSRecursionHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelPFIgnoreMeta
public class PSSubSysServiceAPIDTOFieldImpl
extends PSObjectImpl
implements IPSSubSysServiceAPIDTOField {
    private static final Log log = LogFactory.getLog(PSSubSysServiceAPIDTOFieldImpl.class);
    private IPSSubSysServiceAPIDTO iPSSubSysServiceAPIDTO = null;
    private IPSSubSysServiceAPIDEField iPSSubSysServiceAPIDEField = null;
    private int nOrderValue = 99999;
    private String strCodeName = null;
    private boolean bAllowEmpty = true;
    private IPSCodeList iPSCodeList = null;
    private int nUserInputMode = 0;
    private String strType = null;
    private int nStdDataType = 0;
    private IPSSubSysServiceAPIDTO refPSSubSysServiceAPIDTO = null;
    private IPSSubSysServiceAPIDERS iPSSubSysServiceAPIDERS = null;
    private IPSDEMethodDTOField iPSDEMethodDTOField = null;
    private String strSourceType = null;
    private boolean bCalcRefPSSubSysServiceAPIDTO = false;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSubSysServiceAPIDTO iPSSubSysServiceAPIDTO, Object objField) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSSubSysServiceAPIDTO = iPSSubSysServiceAPIDTO;
            if (objField instanceof IPSSubSysServiceAPIDEField) {
                this.iPSSubSysServiceAPIDEField = (IPSSubSysServiceAPIDEField)objField;
                this.strSourceType = "SUBSYSSERVICEAPIDEFIELD";
            } else if (objField instanceof IPSSubSysServiceAPIDERS) {
                this.iPSSubSysServiceAPIDERS = (IPSSubSysServiceAPIDERS)objField;
                this.strSourceType = "SUBSYSSERVICEAPIDERS";
            } else if (objField instanceof IPSDEMethodDTOField) {
                this.iPSDEMethodDTOField = (IPSDEMethodDTOField)objField;
                this.strSourceType = "DEMETHODDTOFIELD";
            }
            if (this.getPSSubSysServiceAPIDEField() != null) {
                this.setId(this.getPSSubSysServiceAPIDEField().getId());
                this.strCodeName = this.getPSSubSysServiceAPIDEField().getCodeName();
                this.nOrderValue = this.getPSSubSysServiceAPIDEField().getOrderValue();
                this.bAllowEmpty = this.getPSSubSysServiceAPIDEField().isAllowEmpty();
                this.iPSCodeList = this.getPSSubSysServiceAPIDEField().getPSCodeList();
                this.nUserInputMode = 3;
            } else if (this.getPSSubSysServiceAPIDERS() != null) {
                this.setId(this.getPSSubSysServiceAPIDERS().getId());
                this.strCodeName = this.getPSSubSysServiceAPIDERS().getCodeName();
                this.bAllowEmpty = true;
                this.nUserInputMode = 3;
            } else if (this.getPSDEMethodDTOField() != null) {
                this.setId(this.getPSDEMethodDTOField().getId());
                this.strCodeName = this.getPSDEMethodDTOField().getCodeName();
                this.nOrderValue = this.getPSDEMethodDTOField().getOrderValue();
                this.bAllowEmpty = this.getPSDEMethodDTOField().isAllowEmpty();
                this.nUserInputMode = 3;
            } else {
                throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5916\u90e8\u670d\u52a1\u63a5\u53e3\u5b9e\u4f53\u5c5e\u6027\u6216\u5d4c\u5957\u5173\u7cfb\u5bf9\u8c61\u6216\u5b9e\u4f53\u65b9\u6cd5DTO\u5c5e\u6027");
            }
            this.setName(this.getCodeName());
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
        if (this.getPSSubSysServiceAPIDEField() != null) {
            this.strType = "SIMPLE";
            this.nStdDataType = this.getPSSubSysServiceAPIDEField().getStdDataType();
        } else if (this.getPSSubSysServiceAPIDERS() != null) {
            this.strType = this.getPSSubSysServiceAPIDERS().isArray() ? "DTOS" : "DTO";
            this.setCalcRefPSSubSysServiceAPIDTO(true);
        } else if (this.getPSDEMethodDTOField() != null) {
            this.strType = this.getPSDEMethodDTOField().getType();
            this.nStdDataType = this.getPSDEMethodDTOField().getStdDataType();
            if ("DTO".equals(this.getType()) || "DTOS".equals(this.getType())) {
                this.setCalcRefPSSubSysServiceAPIDTO(true);
            }
        }
        super.onInit();
    }

    @Override
    protected int onCheck() throws Exception {
        this.getRefPSSubSysServiceAPIDTO();
        return super.onCheck();
    }

    @Override
    protected IPSModelObject onGetParentModel() {
        return this.getPSSubSysServiceAPIDTO();
    }

    protected IPSSubSysServiceAPIDTO calcRefPSSubSysServiceAPIDTO(IPSSubSysServiceAPIDE refPSSubSysServiceAPIDE) throws Exception {
        if (StringHelper.compare((String)refPSSubSysServiceAPIDE.getId(), (String)this.getPSSubSysServiceAPIDTO().getPSSubSysServiceAPIDE().getId(), (boolean)false) == 0) {
            return this.getPSSubSysServiceAPIDTO();
        }
        return this.getPSSubSysServiceAPIDTO().getPSSubSysServiceAPI().getPSSubSysServiceAPIDTO(refPSSubSysServiceAPIDE);
    }

    protected IPSSubSysServiceAPIDTO calcRefPSSubSysServiceAPIDTO(IPSDEMethodDTO refPSDEMethodDTO) throws Exception {
        if (StringHelper.compare((String)refPSDEMethodDTO.getId(), (String)this.getPSSubSysServiceAPIDTO().getPSDEMethodDTO().getId(), (boolean)false) == 0) {
            return this.getPSSubSysServiceAPIDTO();
        }
        return this.getPSSubSysServiceAPIDTO().getPSSubSysServiceAPI().getPSSubSysServiceAPIDTO(refPSDEMethodDTO);
    }

    @Override
    @PSModelRTMeta(description="\u5916\u90e8\u670d\u52a1\u63a5\u53e3DTO\u5bf9\u8c61")
    public IPSSubSysServiceAPIDTO getPSSubSysServiceAPIDTO() {
        return this.iPSSubSysServiceAPIDTO;
    }

    @Override
    @PSModelRTMeta(description="\u5916\u90e8\u63a5\u53e3\u5b9e\u4f53\u5c5e\u6027")
    public IPSSubSysServiceAPIDEField getPSSubSysServiceAPIDEField() {
        return this.iPSSubSysServiceAPIDEField;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSSubSysServiceAPIDTO().getPSSysModelInstId();
    }

    @Override
    public String getModelType() {
        return "PSSUBSYSSERVICEAPIDTOFIELD";
    }

    @Override
    public String getFullModelName() {
        return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSSubSysServiceAPIDTO().getFullModelName(), (Object)this.getModelName());
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSSubSysServiceAPIDTO().getPSSubSysServiceAPI().getPSSystem());
    }

    @Override
    public String getModelId() {
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSSubSysServiceAPIDTO().getModelId(), (Object)this.getName());
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.strCodeName;
    }

    @Override
    @PSModelRTMeta(description="\u6392\u5e8f\u503c", ignoredumpvalues="99999")
    public int getOrderValue() {
        return this.nOrderValue;
    }

    @Override
    @PSModelRTMeta(description="\u5141\u8bb8\u7a7a\u8f93\u5165", ignoredumpvalues="true")
    public boolean isAllowEmpty() {
        return this.bAllowEmpty;
    }

    @Override
    protected boolean onGetAutoModel() {
        return true;
    }

    @Override
    @PSModelRTMeta(description="\u4e2d\u6587\u540d\u79f0")
    public String getLogicName() {
        if (this.getPSSubSysServiceAPIDEField() != null) {
            return this.getPSSubSysServiceAPIDEField().getLogicName();
        }
        return "";
    }

    @Override
    public String getMemo() {
        if (this.getPSSubSysServiceAPIDEField() != null) {
            return this.getPSSubSysServiceAPIDEField().getMemo();
        }
        return "";
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u8868", dumpref=true)
    public IPSCodeList getPSCodeList() {
        return this.iPSCodeList;
    }

    @Override
    @PSModelRTMeta(description="\u5916\u90e8\u670d\u52a1\u63a5\u53e3DTO\u5c5e\u6027\u7c7b\u578b", codelist="DEDomainFieldType")
    public String getType() {
        return this.strType;
    }

    @Override
    @PSModelRTMeta(description="\u6807\u51c6\u6570\u636e\u7c7b\u578b", codelist="StdDataType", ignoredumpvalues="0")
    public int getStdDataType() {
        return this.nStdDataType;
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u670d\u52a1\u63a5\u53e3DTO\u5bf9\u8c61", dumpref=true, from="IPSSubSysServiceAPI")
    public IPSSubSysServiceAPIDTO getRefPSSubSysServiceAPIDTO() throws Exception {
        if (this.refPSSubSysServiceAPIDTO == null && this.isCalcRefPSSubSysServiceAPIDTO()) {
            if (this.getPSSubSysServiceAPIDERS() != null) {
                this.refPSSubSysServiceAPIDTO = (IPSSubSysServiceAPIDTO)PSRecursionHelper.execute((IPSRecursionWork)new IPSRecursionWork<IPSSubSysServiceAPIDTO>(){

                    public IPSSubSysServiceAPIDTO execute(Object obj) throws Exception {
                        return PSSubSysServiceAPIDTOFieldImpl.this.calcRefPSSubSysServiceAPIDTO(PSSubSysServiceAPIDTOFieldImpl.this.getPSSubSysServiceAPIDERS().getMinorPSSubSysServiceAPIDE());
                    }
                }, (net.ibizsys.pscore.srv.util.IPSModelObject)this, (Object)this.getPSSubSysServiceAPIDERS().getMinorPSSubSysServiceAPIDE());
            } else if (this.getPSDEMethodDTOField() != null) {
                this.refPSSubSysServiceAPIDTO = (IPSSubSysServiceAPIDTO)PSRecursionHelper.execute((IPSRecursionWork)new IPSRecursionWork<IPSSubSysServiceAPIDTO>(){

                    public IPSSubSysServiceAPIDTO execute(Object obj) throws Exception {
                        return PSSubSysServiceAPIDTOFieldImpl.this.calcRefPSSubSysServiceAPIDTO(PSSubSysServiceAPIDTOFieldImpl.this.getPSDEMethodDTOField().getRefPSDEMethodDTO());
                    }
                }, (net.ibizsys.pscore.srv.util.IPSModelObject)this, (Object)this.getPSDEMethodDTOField().getRefPSDEMethodDTO());
            }
        }
        return this.refPSSubSysServiceAPIDTO;
    }

    @Override
    @PSModelRTMeta(description="\u53ea\u8bfb\u5c5e\u6027", ignoredumpvalues="false")
    public boolean isReadOnly() {
        return this.nUserInputMode == 0;
    }

    @Override
    @PSModelRTMeta(description="\u5d4c\u5957\u6570\u636e\u5173\u7cfb", hideempty=true)
    public IPSSubSysServiceAPIDERS getPSSubSysServiceAPIDERS() {
        return this.iPSSubSysServiceAPIDERS;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u65b9\u6cd5DTO\u5c5e\u6027", hideempty=true)
    public IPSDEMethodDTOField getPSDEMethodDTOField() {
        return this.iPSDEMethodDTOField;
    }

    @Override
    @PSModelRTMeta(description="\u5916\u90e8\u670d\u52a1\u63a5\u53e3DTO\u5c5e\u6027\u6765\u6e90\u7c7b\u578b", codelist="SubSysServiceAPIDTOFieldSourceType")
    public String getSourceType() {
        return this.strSourceType;
    }

    @Override
    public IPSServiceAPIDTO getRefPSServiceAPIDTO() throws Exception {
        return this.getRefPSSubSysServiceAPIDTO();
    }

    protected boolean isCalcRefPSSubSysServiceAPIDTO() {
        return this.bCalcRefPSSubSysServiceAPIDTO;
    }

    protected void setCalcRefPSSubSysServiceAPIDTO(boolean bCalcRefPSSubSysServiceAPIDTO) {
        this.bCalcRefPSSubSysServiceAPIDTO = bCalcRefPSSubSysServiceAPIDTO;
    }
}

