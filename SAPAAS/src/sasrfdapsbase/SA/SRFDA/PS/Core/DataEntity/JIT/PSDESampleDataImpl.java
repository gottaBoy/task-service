/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.util.DateHelper
 *  net.ibizsys.paas.util.JSONObjectHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.sf.json.JSONNull
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.JIT;

import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DEField.IPSInheritDEField;
import SA.SRFDA.PS.Core.DEField.IPSPickupDEField;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.JIT.IPSDESampleData;
import SA.SRFDA.PS.Core.DataEntity.MainState.IPSDEMainState;
import SA.SRFDA.PS.Core.DataEntity.PSDataEntityObjectImpl;
import SA.SRFDA.PS.Core.IPSModelSortable;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Res.IPSSysSampleValue;
import SA.SRFDA.PS.Data.PSDESampleData;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.util.DateHelper;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.sf.json.JSONNull;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDESampleDataImpl
extends PSDataEntityObjectImpl
implements IPSDESampleData,
IPSModelSortable {
    private static final Log log = LogFactory.getLog(PSDESampleDataImpl.class);
    protected PSDESampleData psDESampleData = null;
    private JSONObject dataJO = null;
    private String strRandomMode = "DEFAULT";
    private int nRandomCount = 1;
    private IPSDEMainState iPSDEMainState = null;
    private String strDataType = "JSON";

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDataEntity iPSDataEntity, PSDESampleData psDESampleData) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSDataEntity(iPSDataEntity);
            this.psDESampleData = psDESampleData;
            this.setId(this.psDESampleData.getPSDESAMPLEDATAID());
            this.setName(this.psDESampleData.getPSDESAMPLEDATANAME());
            this.setPSObjectData(this.psDESampleData);
            if (!StringHelper.isNullOrEmpty((String)this.psDESampleData.getDATATYPE())) {
                this.strDataType = this.psDESampleData.getDATATYPE();
            }
            if (!StringHelper.isNullOrEmpty((String)psDESampleData.getRANDOMMODE())) {
                this.strRandomMode = this.psDESampleData.getRANDOMMODE();
            }
            if (DataObject.getIntegerValue((Object)psDESampleData.getRANDOMECNT(), (Integer)1) > 1) {
                this.nRandomCount = DataObject.getIntegerValue((Object)psDESampleData.getRANDOMECNT(), (Integer)1);
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDESampleData.getPSDEMAINSTATEID())) {
                this.iPSDEMainState = this.getPSDataEntity().getPSDEMainState(this.psDESampleData.getPSDEMAINSTATEID());
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
    public String getModelType() {
        return "PSDESAMPLEDATA";
    }

    @Override
    public String getFullModelName() {
        return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSDataEntity().getFullModelName(), (Object)this.getModelName());
    }

    @Override
    public String getModelId() {
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSDataEntity().getModelId(), (Object)super.getModelId());
    }

    @Override
    @PSModelRTMeta(description="\u793a\u4f8b\u6570\u636eJSON\u5bf9\u8c61", fields={"DATA"})
    public JSONObject getDataJO() throws Exception {
        if (this.dataJO == null) {
            try {
                Iterator<IPSDEField> psDEFields;
                String strFieldName;
                Object objValue;
                IPSDEField iPSDEField;
                String strFieldName2;
                Object objValue2;
                JSONObject dataJO = null;
                dataJO = StringHelper.isNullOrEmpty((String)this.psDESampleData.getDATA()) ? new JSONObject() : JSONObjectHelper.fromString2((String)this.psDESampleData.getDATA());
                Object objKey = this.iPSDataEntity.getKeyPSDEField().getDEFValue(StringHelper.format((String)"%1$s", (Object)this.getPSSystemUtil().getSampleDataId()));
                JSONObjectHelper.put((JSONObject)dataJO, (String)"srfkey", (Object)objKey.toString());
                if (this.iPSDataEntity.getKeyPSDEField() != null) {
                    JSONObjectHelper.putRaw((JSONObject)dataJO, (String)this.iPSDataEntity.getKeyPSDEField().getName().toLowerCase(), (Object)objKey);
                }
                if (this.iPSDataEntity.getMajorPSDEField() != null && ((objValue2 = dataJO.opt(strFieldName2 = this.iPSDataEntity.getMajorPSDEField().getName().toLowerCase())) == null || objValue2 == JSONNull.getInstance())) {
                    JSONObjectHelper.putRaw((JSONObject)dataJO, (String)strFieldName2, (Object)this.getName());
                }
                if (this.iPSDataEntity.getLogicValidPSDEField() != null) {
                    strFieldName2 = this.iPSDataEntity.getLogicValidPSDEField().getName().toLowerCase();
                    objValue2 = this.iPSDataEntity.getLogicValidValue(true);
                    JSONObjectHelper.putRaw((JSONObject)dataJO, (String)strFieldName2, (Object)objValue2);
                }
                if ((iPSDEField = this.iPSDataEntity.getPSDEFieldByPDT("CREATEDATE", true)) != null && ((objValue = dataJO.opt(strFieldName = iPSDEField.getName().toLowerCase())) == null || objValue == JSONNull.getInstance())) {
                    JSONObjectHelper.putRaw((JSONObject)dataJO, (String)strFieldName, (Object)DateHelper.getCurTimeString());
                }
                if ((iPSDEField = this.iPSDataEntity.getPSDEFieldByPDT("UPDATEDATE", true)) != null && ((objValue = dataJO.opt(strFieldName = iPSDEField.getName().toLowerCase())) == null || objValue == JSONNull.getInstance())) {
                    JSONObjectHelper.putRaw((JSONObject)dataJO, (String)strFieldName, (Object)DateHelper.getCurTimeString());
                }
                if ((iPSDEField = this.iPSDataEntity.getPSDEFieldByPDT("CREATEMAN", true)) != null && ((objValue = dataJO.opt(strFieldName = iPSDEField.getName().toLowerCase())) == null || objValue == JSONNull.getInstance())) {
                    JSONObjectHelper.putRaw((JSONObject)dataJO, (String)strFieldName, (Object)"\u793a\u4f8b\u64cd\u4f5c\u8005");
                }
                if ((iPSDEField = this.iPSDataEntity.getPSDEFieldByPDT("UPDATEMAN", true)) != null && ((objValue = dataJO.opt(strFieldName = iPSDEField.getName().toLowerCase())) == null || objValue == JSONNull.getInstance())) {
                    JSONObjectHelper.putRaw((JSONObject)dataJO, (String)strFieldName, (Object)"\u793a\u4f8b\u64cd\u4f5c\u8005");
                }
                if ((psDEFields = this.getPSDataEntity().getAllPSDEFields()) != null) {
                    while (psDEFields.hasNext()) {
                        Object objValue3;
                        String strValue;
                        IPSInheritDEField iPSInheritDEField;
                        iPSDEField = psDEFields.next();
                        String strFieldName3 = iPSDEField.getName().toLowerCase();
                        if (dataJO.has(strFieldName3) || !iPSDEField.isPhisicalDEField()) continue;
                        if (iPSDEField instanceof IPSInheritDEField && (iPSInheritDEField = (IPSInheritDEField)iPSDEField).getRelatedPSDEField() instanceof IPSPickupDEField) {
                            iPSDEField = iPSInheritDEField.getRelatedPSDEField();
                        }
                        if (iPSDEField instanceof IPSPickupDEField) {
                            IPSDESampleData iPSDESampleData;
                            IPSPickupDEField iPSPickupDEField = (IPSPickupDEField)iPSDEField;
                            IPSDataEntity majorPSDataEntity = iPSPickupDEField.getPSDER1N().getMajorPSDataEntity();
                            if (StringHelper.compare((String)iPSPickupDEField.getPSDER1N().getMajorDEId(), (String)this.getPSDataEntity().getId(), (boolean)true) == 0 || (iPSDESampleData = majorPSDataEntity.getPSDESampleData(false)) == null || iPSDESampleData.getDataJO() == null) continue;
                            JSONObject parentData = iPSDESampleData.getDataJO();
                            Object objParentKey = parentData.opt(majorPSDataEntity.getKeyPSDEField().getName().toLowerCase());
                            JSONObjectHelper.putRaw((JSONObject)dataJO, (String)majorPSDataEntity.getKeyPSDEField().getName().toLowerCase(), (Object)objParentKey);
                            if (iPSPickupDEField.getPSPickupTextDEField() == null || majorPSDataEntity.getMajorPSDEField() == null) continue;
                            Object objParentText = parentData.opt(majorPSDataEntity.getMajorPSDEField().getName().toLowerCase());
                            JSONObjectHelper.putRaw((JSONObject)dataJO, (String)majorPSDataEntity.getMajorPSDEField().getName().toLowerCase(), (Object)objParentText);
                            continue;
                        }
                        IPSSysSampleValue iPSSysSampleValue = iPSDEField.getPSSysSampleValue();
                        if (iPSSysSampleValue != null) {
                            if (iPSSysSampleValue.isNullValue() || StringHelper.isNullOrEmpty((String)(strValue = iPSSysSampleValue.getRandomValue()))) continue;
                            objValue3 = iPSDEField.getDEFValue(strValue);
                            JSONObjectHelper.putRaw((JSONObject)dataJO, (String)strFieldName3, (Object)objValue3);
                            continue;
                        }
                        strValue = iPSDEField.getDefaultValue();
                        if (StringHelper.isNullOrEmpty((String)strValue)) continue;
                        objValue3 = iPSDEField.getDEFValue(strValue);
                        JSONObjectHelper.putRaw((JSONObject)dataJO, (String)strFieldName3, (Object)objValue3);
                    }
                }
                this.dataJO = dataJO;
            }
            catch (Exception ex) {
                log.error((Object)ex.getMessage());
                throw ex;
            }
        }
        return this.dataJO;
    }

    @Override
    public String getJOString() {
        return this.psDESampleData.getDATA();
    }

    @Override
    @PSModelRTMeta(description="\u793a\u4f8b\u6570\u636e", fields={"DATA"})
    public String getData() {
        return this.getJOString();
    }

    @Override
    @PSModelRTMeta(description="\u968f\u673a\u6a21\u5f0f", codelist="SampleDataRandomMode", fields={"RANDOMMODE"})
    public String getRandomMode() {
        return this.strRandomMode;
    }

    @Override
    @PSModelRTMeta(description="\u968f\u673a\u53c2\u6570", fields={"RANDOMPARAM"})
    public String getRandomParam() {
        return this.psDESampleData.getRANDOMPARAM();
    }

    @Override
    @PSModelRTMeta(description="\u968f\u673a\u53c2\u65702", fields={"RANDOMPARAM2"})
    public String getRandomParam2() {
        return this.psDESampleData.getRANDOMPARAM2();
    }

    @Override
    @PSModelRTMeta(description="\u968f\u673a\u53c2\u65703", fields={"RANDOMPARAM3"})
    public int getRandomParam3() {
        return this.psDESampleData.getRANDOMPARAM3();
    }

    @Override
    @PSModelRTMeta(description="\u968f\u673a\u53c2\u65704", fields={"RANDOMPARAM4"})
    public int getRandomParam4() {
        return this.psDESampleData.getRANDOMPARAM4();
    }

    @Override
    @PSModelRTMeta(description="\u968f\u673a\u6570\u91cf", fields={"RANDOMCNT"})
    public int getRandomCount() {
        return this.nRandomCount;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.psDESampleData.getCODENAME();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u4e3b\u72b6\u6001")
    public IPSDEMainState getPSDEMainState() {
        return this.iPSDEMainState;
    }

    @Override
    public int getOrderValue() {
        return 99999;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u7c7b\u578b", hideempty2=true, codelist="SampleDataType", fields={"DATATYPE"})
    public String getDataType() {
        return this.strDataType;
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u6a21\u5f0f", hideempty2=true, codelist="SampleDataLogicMode", fields={"LOGICMODE"})
    public String getLogicMode() {
        return this.psDESampleData.getLOGICMODE();
    }
}

