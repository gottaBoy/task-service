/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.core.DataTypes
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Service;

import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSModelSortable;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIDE;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIDEField;
import SA.SRFDA.PS.Data.PSSubSysSADEField;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.core.DataTypes;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSubSysServiceAPIDEFieldImpl
extends PSObjectImpl
implements IPSSubSysServiceAPIDEField,
IPSModelSortable {
    private static final Log log = LogFactory.getLog(PSSubSysServiceAPIDEFieldImpl.class);
    public static final IPSSubSysServiceAPIDEField EMPTY = new PSSubSysServiceAPIDEFieldImpl();
    private IPSSubSysServiceAPIDE iPSSubSysServiceAPIDE = null;
    private PSSubSysSADEField psSubSysSADEField = null;
    private int nStdDataType = 25;
    private IPSCodeList iPSCodeList = null;
    private boolean bAllowEmpty = true;
    private int nLength = 0;
    private int nPrecision = 0;
    private boolean bMajor = false;
    private boolean bKey = false;
    private int nOrderValue = 99999;
    private String strFieldType = "SIMPLE";
    private boolean bArray = false;
    private String strCodeName = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSubSysServiceAPIDE iPSSubSysServiceAPIDE, PSSubSysSADEField psSubSysSADEField) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSSubSysServiceAPIDE = iPSSubSysServiceAPIDE;
            this.psSubSysSADEField = psSubSysSADEField;
            this.setId(this.psSubSysSADEField.getPSSUBSYSSADEFIELDID());
            this.setName(this.psSubSysSADEField.getPSSUBSYSSADEFIELDNAME());
            this.setPSObjectData(this.psSubSysSADEField);
            this.strCodeName = this.psSubSysSADEField.getCODENAME();
            if (this.isAutoModel()) {
                this.strCodeName = this.getPSSubSysServiceAPIDE().getPSSubSysServiceAPI().getAPICodeName(null, this.strCodeName, null);
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSubSysSADEField.getFIELDTYPE())) {
                this.strFieldType = this.psSubSysSADEField.getFIELDTYPE();
            }
            if ("SUBSYSSADE".equals(this.getFieldType()) && StringHelper.isNullOrEmpty((String)this.psSubSysSADEField.getREFPSSUBSYSSADEID())) {
                throw new Exception(String.format("\u672a\u6307\u5b9a\u5f15\u7528\u7684\u5916\u90e8\u670d\u52a1\u63a5\u53e3\u5b9e\u4f53\u5bf9\u8c61", new Object[0]));
            }
            if ("SIMPLE".equals(this.getFieldType())) {
                this.nStdDataType = !this.psSubSysSADEField.isSTDDATATYPENull() ? this.psSubSysSADEField.getSTDDATATYPE() : DataTypes.fromString((String)this.psSubSysSADEField.getPSDATATYPEID());
                if (psSubSysSADEField.getLENGTH() > 0) {
                    this.nLength = this.psSubSysSADEField.getLENGTH();
                }
                if (psSubSysSADEField.getPRECISION2() > 0) {
                    this.nPrecision = this.psSubSysSADEField.getPRECISION2();
                }
                if (!this.psSubSysSADEField.isPKEYNull()) {
                    boolean bl = this.bKey = this.psSubSysSADEField.getPKEY() == 1;
                }
                if (!this.psSubSysSADEField.isMAJORFIELDNull()) {
                    this.bMajor = this.psSubSysSADEField.getMAJORFIELD();
                }
                if (!StringHelper.isNullOrEmpty((String)this.psSubSysSADEField.getPSCODELISTID())) {
                    this.iPSCodeList = this.getPSSubSysServiceAPIDE().getPSSubSysServiceAPI().getPSSystem().getPSCodeList(this.psSubSysSADEField.getPSCODELISTID());
                }
            }
            if (!this.psSubSysSADEField.isARRAYFLAGNull()) {
                this.bArray = this.psSubSysSADEField.getARRAYFLAG();
            }
            if (!this.psSubSysSADEField.isALLOWEMPTYNull()) {
                this.bAllowEmpty = this.psSubSysSADEField.getALLOWEMPTY();
            }
            if (!this.psSubSysSADEField.isORDERVALUENull() && this.psSubSysSADEField.getORDERVALUE() >= 0) {
                this.nOrderValue = this.psSubSysSADEField.getORDERVALUE();
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
    protected int onCheck() throws Exception {
        this.getRefPSSubSysServiceAPIDE();
        return super.onCheck();
    }

    @Override
    public IPSSubSysServiceAPIDE getPSSubSysServiceAPIDE() {
        return this.iPSSubSysServiceAPIDE;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSSubSysServiceAPIDE().getPSSysModelInstId();
    }

    @Override
    public String getModelType() {
        return "PSSUBSYSSADEFIELD";
    }

    @Override
    public String getFullModelName() {
        return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSSubSysServiceAPIDE().getFullModelName(), (Object)this.getModelName());
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSSubSysServiceAPIDE().getPSSubSysServiceAPI().getPSSystem());
    }

    @Override
    public String getModelId() {
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSSubSysServiceAPIDE().getModelId(), (Object)this.getName());
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.strCodeName;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u540d\u79f02", hideempty2=true, fields={"CODENAME2"})
    public String getCodeName2() {
        return this.psSubSysSADEField.getCODENAME2();
    }

    @Override
    @PSModelRTMeta(description="\u6392\u5e8f\u503c", dump=false, ignoredumpvalues="99999", fields={"ORDERVALUE"})
    public int getOrderValue() {
        return this.nOrderValue;
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u540d\u79f0", fields={"LOGICNAME"})
    public String getLogicName() {
        return this.psSubSysSADEField.getLOGICNAME();
    }

    @Override
    @PSModelRTMeta(description="\u6807\u51c6\u6570\u636e\u7c7b\u578b", codelist="StdDataType", fields={"STDDATATYPE"})
    public int getStdDataType() {
        return this.nStdDataType;
    }

    @Override
    @PSModelRTMeta(description="\u4e3b\u952e\u5c5e\u6027", ignoredumpvalues="false", fields={"PKEY"})
    public boolean isKeyDEField() {
        return this.bKey;
    }

    @Override
    @PSModelRTMeta(description="\u4e3b\u4fe1\u606f\u5c5e\u6027", ignoredumpvalues="false", fields={"MAJORFIELD"})
    public boolean isMajorDEField() {
        return this.bMajor;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u7c7b\u578b", codelist="DEFDataType", fields={"PSDATATYPEID"})
    public String getDataType() {
        return this.psSubSysSADEField.getPSDATATYPEID();
    }

    @Override
    @PSModelRTMeta(description="\u5c5e\u6027\u957f\u5ea6", ignoredumpvalues="0", fields={"LENGTH"})
    public int getLength() {
        return this.nLength;
    }

    @Override
    @PSModelRTMeta(description="\u5c5e\u6027\u7cbe\u5ea6", ignoredumpvalues="0", fields={"PRECISION"})
    public int getPrecision() {
        return this.nPrecision;
    }

    @Override
    @PSModelRTMeta(description="\u5141\u8bb8\u7a7a\u8f93\u5165", ignoredumpvalues="true", fields={"ALLOWEMPTY"})
    public boolean isAllowEmpty() {
        return this.bAllowEmpty;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u8868", hideempty=true, dumpref=true)
    public IPSCodeList getPSCodeList() {
        return this.iPSCodeList;
    }

    @Override
    @PSModelRTMeta(description="\u5c5e\u6027\u6807\u8bb0", hideempty2=true, fields={"FIELDTAG"})
    public String getFieldTag() {
        return this.psSubSysSADEField.getFIELDTAG();
    }

    @Override
    @PSModelRTMeta(description="\u5c5e\u6027\u6807\u8bb02", hideempty2=true, fields={"FIELDTAG2"})
    public String getFieldTag2() {
        return this.psSubSysSADEField.getFIELDTAG2();
    }

    @Override
    @PSModelRTMeta(description="\u5c5e\u6027\u7c7b\u578b", hideempty2=true, fields={"FIELDTYPE"}, ignoredumpvalues="SIMPLE", codelist="SubSysSADEFieldType")
    public String getFieldType() {
        return this.strFieldType;
    }

    @Override
    @PSModelRTMeta(description="\u5c5e\u6027\u4e3a\u6570\u7ec4", ignoredumpvalues="false", fields={"ARRAYFLAG"})
    public boolean isArray() {
        return this.bArray;
    }

    @Override
    @PSModelRTMeta(description="\u9884\u5b9a\u4e49\u7c7b\u578b", hideempty2=true, fields={"PREDEFINEDTYPE"}, codelist="SubSysSADEFieldPredefinedType")
    public String getPredefinedType() {
        return this.psSubSysSADEField.getPREDEFINEDTYPE();
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u5916\u90e8\u670d\u52a1\u63a5\u53e3\u5b9e\u4f53\u5bf9\u8c61", fields={"REFPSSUBSYSSADEID"}, dumpref=true, from="IPSSubSysServiceAPI")
    public IPSSubSysServiceAPIDE getRefPSSubSysServiceAPIDE() throws Exception {
        if (!"SUBSYSSADE".equals(this.getFieldType())) {
            return null;
        }
        return this.getPSSubSysServiceAPIDE().getPSSubSysServiceAPI().getPSSubSysServiceAPIDE(this.psSubSysSADEField.getREFPSSUBSYSSADEID(), false);
    }

    @Override
    protected IPSModelObject onGetParentModel() {
        return this.getPSSubSysServiceAPIDE();
    }

    @Override
    protected IPSModelObject onGetScopeModel() {
        return this.getPSSubSysServiceAPIDE();
    }
}

