/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.Action;

import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEActionInputDTO;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEActionInputDTOField;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEActionParam;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEMethodDTO;
import SA.SRFDA.PS.Core.DataEntity.Service.PSDEMethodDTOFieldImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEActionInputDTOFieldImpl
extends PSDEMethodDTOFieldImpl
implements IPSDEActionInputDTOField {
    private static final Log log = LogFactory.getLog(PSDEActionInputDTOFieldImpl.class);
    private IPSDEActionParam iPSDEActionParam = null;
    private IPSDEActionInputDTO iPSDEActionInputDTO = null;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEActionInputDTO iPSDEActionInputDTO, IPSDEActionParam iPSDEActionParam) throws Exception {
        try {
            boolean bUseServiceCode;
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSDEActionInputDTO = iPSDEActionInputDTO;
            this.setPSDEMethodDTO(iPSDEActionInputDTO);
            this.iPSDEActionParam = iPSDEActionParam;
            this.setSourceType("DEACTIONPARAM");
            String strCodeName = this.getPSDEActionParam().getCodeName();
            if (StringHelper.isNullOrEmpty((String)strCodeName)) {
                strCodeName = this.getPSDEActionParam().getName();
            }
            if (bUseServiceCode = this.iPSDEActionInputDTO.getPSDataEntity().isDTOUseServiceCodeName()) {
                strCodeName = this.iPSDEActionInputDTO.getPSDataEntity().getAPICodeName(null, strCodeName, null);
            }
            this.setCodeName(strCodeName);
            this.setName(this.getCodeName());
            this.setPSDEField(this.getPSDEActionParam().getPSDEField());
            this.setOrderValue(this.getPSDEActionParam().getOrderValue());
            this.setAllowEmpty(true);
            this.setUserInputMode(3);
            this.setStdDataType(this.getPSDEActionParam().getStdDataType());
            this.setJsonFormat(this.getPSDEActionParam().getJsonFormat());
            if (this.getPSDEActionParam().isArray()) {
                this.setType("SIMPLES");
            } else {
                this.setType("SIMPLE");
            }
            this.setFieldTag(iPSDEActionParam.getParamTag());
            this.setFieldTag2(iPSDEActionParam.getParamTag2());
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
    @PSModelRTMeta(description="\u5b9e\u4f53\u884c\u4e3a\u53c2\u6570")
    public IPSDEActionParam getPSDEActionParam() {
        return this.iPSDEActionParam;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u884c\u4e3a\u8f93\u5165DTO")
    public IPSDEActionInputDTO getPSDEActionInputDTO() {
        return this.iPSDEActionInputDTO;
    }
}

