/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.DS;

import SA.SRFDA.PS.Core.DEField.IPSDEFSearchMode;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DEField.IPSDEFieldBase;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSetInputDTOField;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSetParam;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEFilterDTO;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEFilterDTOField;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEMethodDTO;
import SA.SRFDA.PS.Core.DataEntity.Service.PSDEMethodDTOFieldImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEFilterDTOFieldImpl
extends PSDEMethodDTOFieldImpl
implements IPSDEFilterDTOField,
IPSDEDataSetInputDTOField {
    private static final Log log = LogFactory.getLog(PSDEFilterDTOFieldImpl.class);
    private IPSDEFSearchMode iPSDEFSearchMode = null;
    private IPSDEFilterDTO iPSDEFilterDTO = null;
    private IPSDEDataSetParam iPSDEDataSetParam = null;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEFilterDTO iPSDEFilterDTO, IPSDEFSearchMode iPSDEFSearchMode) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSDEFilterDTO = iPSDEFilterDTO;
            this.setPSDEMethodDTO(iPSDEFilterDTO);
            this.iPSDEFSearchMode = iPSDEFSearchMode;
            this.setSourceType("DEFSEARCHMODE");
            boolean bUseServiceCode = this.iPSDEFilterDTO.getPSDataEntity().isDTOUseServiceCodeName();
            if (bUseServiceCode) {
                String strCodeName = this.getPSDEFSearchMode().getServiceCodeName();
                if (StringHelper.isNullOrEmpty((String)strCodeName)) {
                    strCodeName = this.getPSDEFSearchMode().getName();
                }
                this.setCodeName(strCodeName);
            } else {
                String strCodeName = this.getPSDEFSearchMode().getCodeName();
                if (StringHelper.isNullOrEmpty((String)strCodeName)) {
                    strCodeName = this.getPSDEFSearchMode().getName();
                }
                this.setCodeName(strCodeName);
            }
            this.setAllowEmpty(true);
            this.setUserInputMode(3);
            this.setStdDataType(this.getPSDEFSearchMode().getStdDataType());
            this.setJsonFormat(this.getPSDEFSearchMode().getJsonFormat());
            if (this.getPSDEFSearchMode().isArray()) {
                this.setType("SIMPLES");
            } else {
                this.setType("SIMPLE");
            }
            this.setFieldTag(this.getPSDEFSearchMode().getItemTag());
            this.setFieldTag2(this.getPSDEFSearchMode().getItemTag2());
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

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEFilterDTO iPSDEFilterDTO, IPSDEDataSetParam iPSDEDataSetParam) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSDEFilterDTO = iPSDEFilterDTO;
            this.setPSDEMethodDTO(iPSDEFilterDTO);
            this.iPSDEDataSetParam = iPSDEDataSetParam;
            this.iPSDEFSearchMode = this.iPSDEDataSetParam.getPSDEFSearchMode();
            this.setSourceType("DEDATASETPARAM");
            String strCodeName = this.getPSDEDataSetParam().getCodeName();
            if (StringHelper.isNullOrEmpty((String)strCodeName)) {
                strCodeName = this.getPSDEDataSetParam().getName();
            }
            this.setCodeName(strCodeName);
            this.setName(this.getCodeName());
            this.setPSDEField(this.getPSDEDataSetParam().getPSDEField());
            this.setOrderValue(this.getPSDEDataSetParam().getOrderValue());
            this.setAllowEmpty(true);
            this.setUserInputMode(3);
            this.setStdDataType(this.getPSDEDataSetParam().getStdDataType());
            this.setJsonFormat(this.getPSDEDataSetParam().getJsonFormat());
            if (this.getPSDEDataSetParam().isArray()) {
                this.setType("SIMPLES");
            } else {
                this.setType("SIMPLE");
            }
            this.setFieldTag(iPSDEDataSetParam.getParamTag());
            this.setFieldTag2(iPSDEDataSetParam.getParamTag2());
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
    public IPSDEMethodDTO getPSDEMethodDTO() {
        return super.getPSDEMethodDTO();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5c5e\u6027\u641c\u7d22\u6a21\u5f0f", dumpref=true, from="IPSDEField")
    public IPSDEFSearchMode getPSDEFSearchMode() {
        return this.iPSDEFSearchMode;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5c5e\u6027", hideempty=true, dumpref=true, from="IPSDataEntity")
    public IPSDEField getPSDEField() {
        if (this.getPSDEFSearchMode() != null) {
            return this.getPSDEFSearchMode().getPSDEField();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u8fc7\u6ee4\u5668DTO")
    public IPSDEFilterDTO getPSDEFilterDTO() {
        return this.iPSDEFilterDTO;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u6570\u636e\u96c6\u53c2\u6570")
    public IPSDEDataSetParam getPSDEDataSetParam() {
        return this.iPSDEDataSetParam;
    }

    @Override
    protected IPSDEFieldBase getProxyPSDEFieldBase() {
        return null;
    }
}

