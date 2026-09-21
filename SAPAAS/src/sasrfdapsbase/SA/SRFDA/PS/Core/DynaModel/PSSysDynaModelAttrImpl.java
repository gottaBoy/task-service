/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DynaModel;

import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.DEField.IPSDEFGroup;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DynaModel.IPSDynaModel;
import SA.SRFDA.PS.Core.DynaModel.IPSSysDynaModel;
import SA.SRFDA.PS.Core.DynaModel.IPSSysDynaModelAttr;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSSysDynaModelAttr;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysDynaModelAttrImpl
extends PSObjectImpl
implements IPSSysDynaModelAttr {
    private static final Log log = LogFactory.getLog(PSSysDynaModelAttrImpl.class);
    protected PSSysDynaModelAttr psSysDynaModelAttr = null;
    private IPSSysDynaModel iPSSysDynaModel = null;
    private String strValueType = null;
    private String strValue = null;
    private IPSSysDynaModel refPSSysDynaModel = null;
    private int nOrderValue = 99999;
    private IPSCodeList iPSCodeList = null;
    private IPSDataEntity refPSDataEntity = null;
    private IPSDEFGroup refPSDEFGroup = null;
    private int nStdDataType = 0;
    private boolean bArray = false;
    private boolean bAllowEmpty = true;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSysDynaModel iPSSysDynaModel, PSSysDynaModelAttr psSysDynaModelAttr) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSSysDynaModel = iPSSysDynaModel;
            this.psSysDynaModelAttr = psSysDynaModelAttr;
            this.setId(this.psSysDynaModelAttr.getPSSYSDYNAMODELATTRID());
            this.setName(this.psSysDynaModelAttr.getPSSYSDYNAMODELATTRNAME());
            this.setPSObjectData(this.psSysDynaModelAttr);
            this.strValueType = this.psSysDynaModelAttr.getVALUETYPE();
            this.strValue = this.psSysDynaModelAttr.getATTRVALUE();
            if (!this.psSysDynaModelAttr.isORDERVALUENull() && this.psSysDynaModelAttr.getORDERVALUE() >= 0) {
                this.nOrderValue = this.psSysDynaModelAttr.getORDERVALUE();
            }
            if (!this.psSysDynaModelAttr.isSTDDATATYPENull()) {
                this.nStdDataType = this.psSysDynaModelAttr.getSTDDATATYPE();
            }
            if (!this.psSysDynaModelAttr.isARRAYFLAGNull()) {
                this.bArray = this.psSysDynaModelAttr.getARRAYFLAG();
            }
            if (!this.psSysDynaModelAttr.isALLOWEMPTYNull()) {
                this.bAllowEmpty = this.psSysDynaModelAttr.getALLOWEMPTY();
            }
            if (StringHelper.Compare((String)this.getValueType(), (String)"OBJECT", (boolean)true) == 0) {
                if (StringHelper.IsNullOrEmpty((String)this.psSysDynaModelAttr.getREFPSSYSDYNAMODELID())) {
                    throw new Exception(StringHelper.Format((String)"\u52a8\u6001\u6a21\u578b\u5c5e\u6027[%1$s]\u6ca1\u6709\u6307\u5b9a\u5f15\u7528\u7684\u6a21\u578b\u5bf9\u8c61", (Object)this.getName()));
                }
                if (StringHelper.Compare((String)this.getPSSysDynaModel().getId(), (String)this.psSysDynaModelAttr.getREFPSSYSDYNAMODELID(), (boolean)false) == 0) {
                    throw new Exception(StringHelper.Format((String)"\u52a8\u6001\u6a21\u578b\u5c5e\u6027[%1$s]\u5f15\u7528\u6a21\u578b\u5bf9\u8c61\u4e0d\u80fd\u4e3a\u5f53\u524d\u6a21\u578b\u5bf9\u8c61", (Object)this.getName()));
                }
            } else if (StringHelper.Compare((String)this.getValueType(), (String)"DE", (boolean)true) == 0 && StringHelper.IsNullOrEmpty((String)this.psSysDynaModelAttr.getREFPSDEID())) {
                throw new Exception(StringHelper.Format((String)"\u52a8\u6001\u6a21\u578b\u5c5e\u6027[%1$s]\u6ca1\u6709\u6307\u5b9a\u5f15\u7528\u7684\u5b9e\u4f53\u5bf9\u8c61", (Object)this.getName()));
            }
            this.onInit();
        }
        catch (Exception ex) {
            String strLogName = net.ibizsys.paas.util.StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = net.ibizsys.paas.util.StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)net.ibizsys.paas.util.StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            if (this.getPSSystemUtil() != null) {
                this.getPSSystemUtil().getPSSysConsole().error(strLogName, strExInfo);
            }
            this.throwInitException(ex);
        }
    }

    @Override
    protected int onCheck() throws Exception {
        return super.onCheck();
    }

    @Override
    public IPSSysDynaModel getPSSysDynaModel() {
        return this.iPSSysDynaModel;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSSysDynaModel().getPSSysModelInstId();
    }

    @Override
    @PSModelRTMeta(description="\u503c\u7c7b\u578b", codelist="DynaModelAttrValueType")
    public String getValueType() {
        return this.strValueType;
    }

    @Override
    @PSModelRTMeta(description="\u5c5e\u6027\u503c", hideempty=true)
    public String getValue() {
        if (StringHelper.Compare((String)this.getValueType(), (String)"VALUE", (boolean)true) != 0) {
            return null;
        }
        return this.strValue;
    }

    @Override
    public IPSDynaModel getRefPSDynaModel() throws Exception {
        return this.getRefPSSysDynaModel();
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u6a21\u578b\u5bf9\u8c61", hideempty=true)
    public IPSSysDynaModel getRefPSSysDynaModel() throws Exception {
        if (StringHelper.Compare((String)this.getValueType(), (String)"OBJECT", (boolean)true) != 0) {
            return null;
        }
        if (this.refPSSysDynaModel == null) {
            this.refPSSysDynaModel = this.getPSSysDynaModel().getPSSystem().getPSSysDynaModel(this.psSysDynaModelAttr.getREFPSSYSDYNAMODELID());
        }
        return this.refPSSysDynaModel;
    }

    @Override
    protected boolean hasPSSysDynaModel() {
        return false;
    }

    @Override
    public String getModelType() {
        return "PSSYSDYNAMODELATTR";
    }

    @Override
    public String getFullModelName() {
        return net.ibizsys.paas.util.StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSSysDynaModel().getFullModelName(), (Object)this.getModelName());
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSSysDynaModel().getPSSystem());
    }

    @Override
    public String getModelId() {
        return StringHelper.Format((String)"%1$s#%2$s", (Object)this.getPSSysDynaModel().getModelId(), (Object)this.getName());
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6", hideempty2=true)
    public String getCodeName() {
        return this.psSysDynaModelAttr.getCODENAME();
    }

    @Override
    @PSModelRTMeta(description="\u5c5e\u6027\u6807\u8bb0", hideempty2=true)
    public String getAttrTag() {
        return this.psSysDynaModelAttr.getATTRTAG();
    }

    @Override
    @PSModelRTMeta(description="\u5c5e\u6027\u6807\u8bb02", hideempty2=true)
    public String getAttrTag2() {
        return this.psSysDynaModelAttr.getATTRTAG2();
    }

    @Override
    @PSModelRTMeta(description="\u6392\u5e8f\u503c", ignoredumpvalues="99999")
    public int getOrderValue() {
        return this.nOrderValue;
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u5b9e\u4f53\u5bf9\u8c61", hideempty=true)
    public IPSDataEntity getRefPSDataEntity() throws Exception {
        if (StringHelper.Compare((String)this.getValueType(), (String)"DE", (boolean)true) != 0) {
            return null;
        }
        if (this.refPSDataEntity == null) {
            this.refPSDataEntity = this.getPSSysDynaModel().getPSSystem().getPSDataEntity2(this.psSysDynaModelAttr.getREFPSDEID());
        }
        return this.refPSDataEntity;
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u5b9e\u4f53\u5c5e\u6027\u7ec4\u5bf9\u8c61", hideempty=true)
    public IPSDEFGroup getRefPSDEFGroup() throws Exception {
        if (this.getRefPSDataEntity() == null) {
            return null;
        }
        if (this.refPSDEFGroup == null && !StringHelper.IsNullOrEmpty((String)this.psSysDynaModelAttr.getREFPSDEFGROUPID())) {
            this.refPSDEFGroup = this.getRefPSDataEntity().getPSDEFGroup(this.psSysDynaModelAttr.getREFPSDEFGROUPID());
        }
        return this.refPSDEFGroup;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u8868\u5bf9\u8c61", hideempty=true)
    public IPSCodeList getPSCodeList() throws Exception {
        if (this.iPSCodeList == null && !StringHelper.IsNullOrEmpty((String)this.psSysDynaModelAttr.getPSCODELISTID())) {
            this.iPSCodeList = this.getPSSysDynaModel().getPSSystem().getPSCodeList(this.psSysDynaModelAttr.getPSCODELISTID());
        }
        return this.iPSCodeList;
    }

    @Override
    @PSModelRTMeta(description="\u6807\u51c6\u503c\u7c7b\u578b", ignoredumpvalues="0", fields={"STDDATATYPE"})
    public int getStdDataType() {
        return this.nStdDataType;
    }

    @Override
    @PSModelRTMeta(description="\u5c5e\u6027\u4e3a\u6570\u7ec4", ignoredumpvalues="false", fields={"ARRAYFLAG"})
    public boolean isArray() {
        return this.bArray;
    }

    @Override
    @PSModelRTMeta(description="\u5141\u8bb8\u7a7a\u503c", ignoredumpvalues="true", fields={"ALLOWEMPTY"}, dump=false)
    public boolean isAllowEmpty() {
        return this.bAllowEmpty;
    }

    @Override
    @PSModelRTMeta(description="Json\u683c\u5f0f\u5316", fields={"JSONFORMAT"}, dump=false)
    public String getJsonFormat() {
        return this.psSysDynaModelAttr.getJSONFORMAT();
    }
}

