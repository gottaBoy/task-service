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
package SA.SRFDA.PS.Core.Testing;

import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DEField.IPSLinkDEField;
import SA.SRFDA.PS.Core.DEField.IPSPickupDEField;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Res.IPSSysSampleValue;
import SA.SRFDA.PS.Core.Testing.IPSSysTestData;
import SA.SRFDA.PS.Core.Testing.IPSSysTestDataInst;
import SA.SRFDA.PS.Core.Testing.IPSSysTestDataItem;
import SA.SRFDA.PS.Data.PSSysTestDataItem;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Random;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.util.IPSModelObject;
import net.ibizsys.pscore.srv.util.IPSRecursionWork;
import net.ibizsys.pscore.srv.util.PSRecursionHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysTestDataItemImpl
extends PSObjectImpl
implements IPSSysTestDataItem {
    private static final Log log = LogFactory.getLog(PSSysTestDataItemImpl.class);
    protected PSSysTestDataItem psSysTestDataItem = null;
    private IPSSysTestData iPSSysTestData = null;
    private IPSDEField iPSDEField = null;
    private String strValueType = "";
    private IPSCodeList iPSCodeList = null;
    private IPSDataEntity refPSDataEntity = null;
    private IPSDEDataSet refPSDEDataSet = null;
    private IPSSysTestData refPSSysTestData = null;
    private IPSSysSampleValue iPSSysSampleValue = null;
    private String[] randomValues = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSysTestData iPSSysTestData, PSSysTestDataItem psSysTestDataItem) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSSysTestData = iPSSysTestData;
            this.psSysTestDataItem = psSysTestDataItem;
            this.setId(this.psSysTestDataItem.getPSSYSTDITEMID());
            this.setName(this.psSysTestDataItem.getPSSYSTDITEMNAME());
            this.setPSObjectData(this.psSysTestDataItem);
            this.strValueType = this.psSysTestDataItem.getVALUETYPE();
            if (this.iPSSysTestData.getPSDataEntity() != null) {
                this.iPSDEField = this.iPSSysTestData.getPSDataEntity().getPSDEField(this.getName(), true);
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysTestDataItem.getPSCODELISTID())) {
                this.iPSCodeList = this.getPSSysTestData().getPSSystem().getPSCodeList(this.psSysTestDataItem.getPSCODELISTID());
            } else if (this.getPSDEField() != null) {
                this.iPSCodeList = this.getPSDEField().getPSCodeList();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysTestDataItem.getREFPSDEID())) {
                this.refPSDataEntity = this.getPSSysTestData().getPSSystem().getPSDataEntity2(this.psSysTestDataItem.getREFPSDEID());
                if (!StringHelper.isNullOrEmpty((String)this.psSysTestDataItem.getREFPSDEDATASETID())) {
                    this.refPSDEDataSet = this.refPSDataEntity.getPSDEDataSet(this.psSysTestDataItem.getREFPSDEDATASETID());
                }
            } else if (this.getPSDEField() != null && this.getPSDEField() instanceof IPSLinkDEField) {
                IPSLinkDEField iPSLinkDEField = (IPSLinkDEField)this.getPSDEField();
                this.refPSDataEntity = iPSLinkDEField.getRealPSDEField().getPSDataEntity();
                if (iPSLinkDEField instanceof IPSPickupDEField) {
                    this.refPSDEDataSet = ((IPSPickupDEField)iPSLinkDEField).getPSDER1N().getRefPSDEDataSet();
                }
            }
            if (this.refPSDataEntity != null && this.refPSDEDataSet == null) {
                this.refPSDEDataSet = this.refPSDataEntity.getDefaultPSDEDataSet();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysTestDataItem.getREFPSSYSTESTDATAID())) {
                this.refPSSysTestData = (IPSSysTestData)PSRecursionHelper.execute((IPSRecursionWork)new IPSRecursionWork<IPSSysTestData>(){

                    public IPSSysTestData execute(Object obj) throws Exception {
                        return PSSysTestDataItemImpl.this.getPSSysTestData().getPSSystem().getPSSysTestData((String)obj);
                    }
                }, (IPSModelObject)this.iPSSysTestData, (Object)this.psSysTestDataItem.getREFPSSYSTESTDATAID());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysTestDataItem.getPSSYSSAMPLEVALUEID())) {
                this.iPSSysSampleValue = this.getPSSysTestData().getPSSystem().getPSSysSampleValue(this.psSysTestDataItem.getPSSYSSAMPLEVALUEID());
            }
            String strRandomValues = this.psSysTestDataItem.getVALUERANGE();
            if (!StringHelper.isNullOrEmpty((String)(strRandomValues = strRandomValues.trim()))) {
                this.randomValues = strRandomValues.split("[;]");
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
    @PSModelRTMeta(description="\u7cfb\u7edf\u6d4b\u8bd5\u503c")
    public IPSSysTestData getPSSysTestData() {
        return this.iPSSysTestData;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSSysTestData().getPSSysModelInstId();
    }

    @Override
    @PSModelRTMeta(description="\u76f8\u5173\u5b9e\u4f53\u5c5e\u6027", dumpref=true, from="IPSSysTestData", from_method="getPSDataEntityMust().getPSDEField")
    public IPSDEField getPSDEField() {
        return this.iPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u503c\u7c7b\u578b", codelist="TestDataItemValueType", fields={"VALUETYPE"})
    public String getValueType() {
        return this.strValueType;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u8868", dumpref=true, fields={"PSCODELISTID"})
    public IPSCodeList getPSCodeList() {
        return this.iPSCodeList;
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u5b9e\u4f53", dumpref=true, fields={"REFPSDEID"})
    public IPSDataEntity getRefPSDataEntity() {
        return this.refPSDataEntity;
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u5b9e\u4f53\u6570\u636e\u96c6", dumpref=true, from="__self__", from_method="getRefPSDataEntityMust().getPSDEDataSet", fields={"REFPSDEDATASETID"})
    public IPSDEDataSet getRefPSDEDataSet() {
        return this.refPSDEDataSet;
    }

    @Override
    public void fillEntity(IPSSysTestDataInst iPSSysTestDataInst) throws Exception {
        if (StringHelper.compare((String)this.getValueType(), (String)"VALUE", (boolean)true) == 0) {
            String strValue = this.getValue();
            if (StringHelper.isNullOrEmpty((String)strValue) && this.getPSSysSampleValue() != null) {
                strValue = this.getPSSysSampleValue().getSampleValue(true);
            }
            iPSSysTestDataInst.getEntity().set(this.getName(), (Object)strValue);
            return;
        }
        if (StringHelper.compare((String)this.getValueType(), (String)"VALUERANGE", (boolean)true) == 0) {
            String strValue = "";
            if (this.randomValues != null && this.randomValues.length > 0) {
                int nPos = new Random().nextInt(10000) % this.randomValues.length;
                strValue = this.randomValues[nPos];
            }
            iPSSysTestDataInst.getEntity().set(this.getName(), (Object)strValue);
            return;
        }
        if (StringHelper.compare((String)this.getValueType(), (String)"NULLVALUE", (boolean)true) == 0) {
            iPSSysTestDataInst.getEntity().set(this.getName(), null);
            return;
        }
        if (StringHelper.compare((String)this.getValueType(), (String)"CODELISTVALUE", (boolean)true) == 0) {
            return;
        }
        if (StringHelper.compare((String)this.getValueType(), (String)"PICKUPVALUE", (boolean)true) == 0) {
            return;
        }
        if (StringHelper.compare((String)this.getValueType(), (String)"REFTESTDATA", (boolean)true) == 0) {
            return;
        }
    }

    @Override
    public IPSSysTestData getRefPSSysTestData() {
        return this.refPSSysTestData;
    }

    @Override
    @PSModelRTMeta(description="\u6807\u51c6\u6570\u636e\u7c7b\u578b", codelist="StdDataType", fields={"STDDATATYPE"})
    public int getStdDataType() {
        if (!this.psSysTestDataItem.isSTDDATATYPENull()) {
            return this.psSysTestDataItem.getSTDDATATYPE();
        }
        if (this.iPSDEField != null) {
            return this.iPSDEField.getStdDataType();
        }
        return 25;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u793a\u4f8b\u503c", dumpref=true)
    public IPSSysSampleValue getPSSysSampleValue() {
        return this.iPSSysSampleValue;
    }

    @Override
    @PSModelRTMeta(description="\u7a7a\u503c", ignoredumpvalues="false")
    public boolean isNullValue() {
        return StringHelper.compare((String)this.getValueType(), (String)"NULLVALUE", (boolean)false) == 0;
    }

    @Override
    @PSModelRTMeta(description="\u503c", fields={"VALUE"})
    public String getValue() {
        String strValue = this.psSysTestDataItem.getVALUE();
        if (StringHelper.isNullOrEmpty((String)strValue) && this.getPSSysSampleValue() != null) {
            return this.getPSSysSampleValue().getValue();
        }
        return strValue;
    }

    @Override
    @PSModelRTMeta(description="\u503c\u96c6\u5408", child=true)
    public String[] getValues() {
        if (this.randomValues == null && this.getPSSysSampleValue() != null) {
            return this.getPSSysSampleValue().getValues();
        }
        return this.randomValues;
    }

    @Override
    @PSModelRTMeta(description="\u5907\u6ce8", hideempty2=true, dynamodelmode=4)
    public String getMemo() {
        return super.getMemo();
    }

    @Override
    public String getModelType() {
        return "PSSYSTDITEM";
    }

    @Override
    public String getModelId() {
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSSysTestData().getModelId(), (Object)super.getModelId());
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSSysTestData().getPSSystem());
    }
}

