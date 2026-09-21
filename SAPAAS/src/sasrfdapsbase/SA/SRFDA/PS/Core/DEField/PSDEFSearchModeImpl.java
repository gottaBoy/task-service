/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DEField;

import SA.SRFDA.PS.Core.Control.Form.IPSDEFFormItem;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFSearchFormItem;
import SA.SRFDA.PS.Core.DEField.IPSDEFSearchMode;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DEField.IPSOne2ManyDataDEField;
import SA.SRFDA.PS.Core.DEField.IPSOne2OneDataDEField;
import SA.SRFDA.PS.Core.DEField.PSDEFieldObjectImpl;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDER11;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDER1N;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERBase;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERCustom;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERNN;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataQuery;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataQueryCode;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataQueryCodeExp;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.Database.IPSSysDBValueFunc;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysSFPluginTempl;
import SA.SRFDA.PS.Core.Res.IPSSysTranslator;
import SA.SRFDA.PS.Core.SF.IPSSFXCodeObject;
import SA.SRFDA.PS.Core.SF.PSSFXCodeObjectProxy;
import SA.SRFDA.PS.Data.PSDEFSearchMode;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEFSearchModeImpl
extends PSDEFieldObjectImpl
implements IPSDEFSearchMode {
    private static final Log log = LogFactory.getLog(PSDEFSearchModeImpl.class);
    protected PSDEFSearchMode psDEFSearchMode = null;
    protected IPSDEFSearchFormItem defaultPSDEFSearchFormItem = null;
    protected IPSDEFSearchFormItem mobPSDEFSearchFormItem = null;
    protected IPSSysDBValueFunc iPSSysDBValueFunc = null;
    private int nExtendMode = 0;
    private boolean bDefaultFlag = false;
    private IPSLanguageRes capPSLanguageRes = null;
    private String strCodeName = null;
    private String strServiceCodeName = null;
    private String strPlaceHolder = null;
    private IPSLanguageRes phPSLanguageRes = null;
    private boolean bArray = false;
    private IPSDEFSearchMode dstPSDEFSearchMode = null;
    private IPSSysTranslator iPSSysTranslator = null;
    private IPSSysSFPlugin iPSSysSFPlugin = null;
    private IPSSFXCodeObject iPSSFXCodeObject = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEField iPSDEField, PSDEFSearchMode psDEFSearchMode) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSDEField(iPSDEField);
            this.psDEFSearchMode = psDEFSearchMode;
            this.setId(this.psDEFSearchMode.getPSDEFSFITEMID());
            this.setName(this.psDEFSearchMode.getPSDEFSFITEMNAME());
            this.strCodeName = psDEFSearchMode.getCODENAME();
            this.strServiceCodeName = psDEFSearchMode.getSERVICECODENAME();
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strCodeName)) {
                this.strCodeName = this.getName();
                if (this.strCodeName.indexOf("#") != -1) {
                    this.strCodeName = this.getPSDataEntity().getPSSystem().isEnableModelRT() ? this.getName().replace("#", "_") : this.getName().split("[#]")[0];
                }
                if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strServiceCodeName)) {
                    this.strServiceCodeName = this.getPSDEField().getPSDataEntity().getAPICodeName(null, this.strCodeName, null);
                }
            } else if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strServiceCodeName)) {
                this.strServiceCodeName = this.getPSDEField().getPSDataEntity().getAPICodeName(null, this.strCodeName, null);
            }
            this.setPSObjectData(this.psDEFSearchMode);
            PSDEFSearchMode defaultPSDEFSearchMode = new PSDEFSearchMode();
            psDEFSearchMode.CopyTo(defaultPSDEFSearchMode, false);
            defaultPSDEFSearchMode.set("FTMODE", "DEFAULT");
            this.defaultPSDEFSearchFormItem = this.iPSDEField.getPSDEFieldType().createPSDEFSearchFormItem(defaultPSDEFSearchMode);
            this.defaultPSDEFSearchFormItem.init(iDAGlobalHelper, iPSDEField, this, defaultPSDEFSearchMode);
            PSDEFSearchMode mobPSDEFSearchMode = new PSDEFSearchMode();
            psDEFSearchMode.CopyTo(mobPSDEFSearchMode, false);
            mobPSDEFSearchMode.set("FTMODE", "MOBILEDEFAULT");
            this.mobPSDEFSearchFormItem = this.iPSDEField.getPSDEFieldType().createPSDEFSearchFormItem(mobPSDEFSearchMode);
            this.mobPSDEFSearchFormItem.init(iDAGlobalHelper, iPSDEField, this, mobPSDEFSearchMode);
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEFSearchMode.getPSSYSDBVFID())) {
                this.iPSSysDBValueFunc = this.getPSDataEntity().getPSSystem().getPSSysDBValueFunc(this.psDEFSearchMode.getPSSYSDBVFID());
            }
            if (!psDEFSearchMode.isEXTENDMODENull()) {
                this.nExtendMode = this.psDEFSearchMode.getEXTENDMODE();
            }
            if (!psDEFSearchMode.isDEFAULTFLAGNull()) {
                this.bDefaultFlag = this.psDEFSearchMode.getDEFAULTFLAG();
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEFSearchMode.getCAPPSLANRESID())) {
                this.capPSLanguageRes = this.getPSDataEntity().getPSSystem().getPSLanguageRes(this.psDEFSearchMode.getCAPPSLANRESID());
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEFSearchMode.getPLACEHOLDER())) {
                this.strPlaceHolder = this.psDEFSearchMode.getPLACEHOLDER();
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEFSearchMode.getPHPSLANRESID())) {
                this.phPSLanguageRes = this.getPSDataEntity().getPSSystem().getPSLanguageRes(this.psDEFSearchMode.getPHPSLANRESID());
            }
            if (!this.psDEFSearchMode.isARRAYFLAGNull()) {
                this.bArray = this.psDEFSearchMode.getARRAYFLAG();
            } else if (this.getPSSystemSetting().isEnableDEFSearchModeModelEx() && ("IN".equals(this.getPSDBValueOPId()) || "NOTIN".equals(this.getPSDBValueOPId()) || "EXISTS".equals(this.getPSDBValueOPId()) || "NOTEXISTS".equals(this.getPSDBValueOPId()))) {
                this.bArray = true;
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
        String strPSSysSFPluginId = this.psDEFSearchMode.getPSSYSSFPLUGINID();
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strPSSysSFPluginId)) {
            this.iPSSysSFPlugin = this.getPSDataEntity().getPSSystem().getPSSysSFPlugin(strPSSysSFPluginId);
        }
        if (this.getPSSysSFPlugin() != null) {
            String strPSSysSFPluginTemplId = KeyValueHelper.genUniqueId((String)this.getPSSysSFPlugin().getId(), (String)this.getPSDataEntity().getPSSystem().getPSSFId());
            IPSSysSFPluginTempl iPSSysSFPluginTempl = this.getPSDataEntity().getPSSystem().getPSSysSFPluginTempl(strPSSysSFPluginTemplId, true);
            if (iPSSysSFPluginTempl != null) {
                this.iPSSFXCodeObject = new PSSFXCodeObjectProxy(iPSSysSFPluginTempl, this);
            }
        }
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5c5e\u6027\u5bf9\u8c61", dump=false)
    public IPSDEField getPSDEField() {
        return super.getPSDEField();
    }

    @Override
    public IPSDEFFormItem getPSDEFFormItem(String strUIMode) {
        if (SA.SRFramework.Utility.StringHelper.Compare((String)strUIMode, (String)"MOBILEDEFAULT", (boolean)true) == 0) {
            return this.mobPSDEFSearchFormItem;
        }
        return this.defaultPSDEFSearchFormItem;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.strCodeName;
    }

    @Override
    public String getServiceCodeName() {
        return this.strServiceCodeName;
    }

    @Override
    public String getPSDEFId() {
        return this.getPSDEField().getId();
    }

    @Override
    public String getPSSysDBVFId() {
        return this.psDEFSearchMode.getPSSYSDBVFID();
    }

    @Override
    public String getPSDBValueOPId() {
        return this.psDEFSearchMode.getPSDBVALUEOPID();
    }

    @Override
    @PSModelRTMeta(description="\u503c\u64cd\u4f5c", group="\u57fa\u672c", order=110, fields={"PSDBVALUEOPID"})
    public String getValueOP() {
        return this.getPSDBValueOPId();
    }

    @Override
    @PSModelRTMeta(description="\u503c\u5904\u7406")
    public String getValueFunc() {
        if (this.getPSSysDBValueFunc() == null) {
            return null;
        }
        return this.getPSSysDBValueFunc().getCodeName();
    }

    public String getValueOp() {
        return this.getPSDBValueOPId();
    }

    public String getDEFName() {
        return this.iPSDEField.getName();
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u5e93\u503c\u51fd\u6570\u5bf9\u8c61")
    public IPSSysDBValueFunc getPSSysDBValueFunc() {
        return this.iPSSysDBValueFunc;
    }

    @Override
    public int getExtendMode() {
        return this.nExtendMode;
    }

    @Override
    public String getPSCodeListId() {
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEFSearchMode.getPSCODELISTID())) {
            try {
                if (this.getDstPSDEFSearchMode() != null) {
                    return this.getDstPSDEFSearchMode().getPSCodeListId();
                }
            }
            catch (Exception ex) {
                log.error((Object)ex);
            }
        }
        return this.psDEFSearchMode.getPSCODELISTID();
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u641c\u7d22\u9879", ignoredumpvalues="false", fields={"DEFAULTFLAG"})
    public boolean isDefault() {
        return this.bDefaultFlag;
    }

    @Override
    public String getModelType() {
        return "PSDEFSFITEM";
    }

    @Override
    public String getModelId() {
        return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s#%2$s", (Object)this.getPSDEField().getModelId(), (Object)super.getModelId());
    }

    @Override
    @PSModelRTMeta(description="\u6807\u9898", dump=false)
    public String getCaption() {
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEFSearchMode.getCAPTION())) {
            try {
                if (this.getDstPSDEFSearchMode() != null) {
                    return this.getDstPSDEFSearchMode().getCaption();
                }
            }
            catch (Exception ex) {
                log.error((Object)ex);
            }
        }
        return this.psDEFSearchMode.getCAPTION();
    }

    @Override
    @PSModelRTMeta(description="\u6807\u9898\u8bed\u8a00\u8d44\u6e90\u5bf9\u8c61", dump=false)
    public IPSLanguageRes getCapPSLanguageRes() {
        if (this.capPSLanguageRes == null) {
            try {
                if (this.getDstPSDEFSearchMode() != null) {
                    return this.getDstPSDEFSearchMode().getCapPSLanguageRes();
                }
            }
            catch (Exception ex) {
                log.error((Object)ex);
            }
        }
        return this.capPSLanguageRes;
    }

    @Override
    @PSModelRTMeta(description="\u6807\u9898\u8bed\u8a00\u8d44\u6e90\u6807\u8bc6", dump=false)
    public String getCapLanResTag() {
        if (this.getCapPSLanguageRes() != null) {
            return this.getCapPSLanguageRes().getLanResTag();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u641c\u7d22\u6a21\u5f0f", fields={"SEARCHMODE"})
    public String getMode() {
        return this.psDEFSearchMode.getSEARCHMODE();
    }

    @Override
    public IPSDEDataQueryCodeExp getPSDEDataQueryCodeExp(String strDBType) throws Exception {
        IPSDEDataQuery iPSDEDataQuery = this.getPSDataEntity().getDefaultPSDEDataQuery();
        if (iPSDEDataQuery == null) {
            return null;
        }
        IPSDEDataQueryCode iPSDEDataQueryCode = iPSDEDataQuery.getPSDEDataQueryCode(strDBType, true);
        if (iPSDEDataQueryCode == null) {
            return null;
        }
        return iPSDEDataQueryCode.getPSDEDataQueryCodeExp(this.getPSDEField().getName(), true);
    }

    @Override
    @PSModelRTMeta(description="\u6807\u51c6\u6570\u636e\u7c7b\u578b", codelist="StdDataType", doc="\u6839\u636e\u6761\u4ef6\u64cd\u4f5c\u8f93\u51fa\uff0c\u5982\u5b9a\u4e49\u503c\u51fd\u6570\u5219\u4f7f\u7528\u503c\u51fd\u6570\u7684\u8fd4\u56de\u503c\u7c7b\u578b\uff0c\u9ed8\u8ba4\u4f7f\u7528\u5c5e\u6027\u7684\u6807\u51c6\u6570\u636e\u7c7b\u578b")
    public final int getStdDataType() {
        try {
            if (this.getDstPSDEFSearchMode() != null) {
                return this.getDstPSDEFSearchMode().getStdDataType();
            }
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
        if ("TESTNULL".equals(this.getValueOP())) {
            return 9;
        }
        if (this.getPSSysDBValueFunc() != null) {
            return this.getPSSysDBValueFunc().getOutputStdDataType();
        }
        return this.getPSDEField().getStdDataType();
    }

    @Override
    @PSModelRTMeta(description="\u8f93\u5165\u63d0\u793a\u4fe1\u606f", dump=false)
    public String getPlaceHolder() {
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strPlaceHolder)) {
            try {
                if (this.getDstPSDEFSearchMode() != null) {
                    return this.getDstPSDEFSearchMode().getPlaceHolder();
                }
            }
            catch (Exception ex) {
                log.error((Object)ex);
            }
        }
        return this.strPlaceHolder;
    }

    @Override
    @PSModelRTMeta(description="\u8f93\u5165\u63d0\u793a\u8bed\u8a00\u8d44\u6e90", dump=false)
    public IPSLanguageRes getPHPSLanguageRes() {
        if (this.phPSLanguageRes == null) {
            try {
                if (this.getDstPSDEFSearchMode() != null) {
                    return this.getDstPSDEFSearchMode().getPHPSLanguageRes();
                }
            }
            catch (Exception ex) {
                log.error((Object)ex);
            }
        }
        return this.phPSLanguageRes;
    }

    @Override
    @PSModelRTMeta(description="\u8f93\u5165\u63d0\u793a\u8bed\u8a00\u8d44\u6e90\u6807\u8bc6", dump=false)
    public String getPHLanResTag() {
        if (this.getPHPSLanguageRes() != null) {
            return this.getPHPSLanguageRes().getLanResTag();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u503c\u683c\u5f0f\u5316", fields={"VALUEFORMAT"})
    public String getValueFormat() {
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEFSearchMode.getVALUEFORMAT())) {
            try {
                if (this.getDstPSDEFSearchMode() != null) {
                    return this.getDstPSDEFSearchMode().getValueFormat();
                }
            }
            catch (Exception ex) {
                log.error((Object)ex);
            }
        }
        return this.psDEFSearchMode.getVALUEFORMAT();
    }

    @Override
    @PSModelRTMeta(description="Json\u683c\u5f0f\u5316", fields={"JSONFORMAT"}, dump=false)
    public String getJsonFormat() {
        String strJsonFormat = this.psDEFSearchMode.getJSONFORMAT();
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strJsonFormat)) {
            try {
                if (this.getDstPSDEFSearchMode() != null) {
                    return this.getDstPSDEFSearchMode().getJsonFormat();
                }
            }
            catch (Exception ex) {
                log.error((Object)ex);
            }
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getPSSysDBVFId()) && ("EQ".equals(this.getPSDBValueOPId()) || "NOTEQ".equals(this.getPSDBValueOPId()) || "GT".equals(this.getPSDBValueOPId()) || "GTANDEQ".equals(this.getPSDBValueOPId()) || "LT".equals(this.getPSDBValueOPId()) || "LTANDEQ".equals(this.getPSDBValueOPId()))) {
                return this.getPSDEField().getJsonFormat();
            }
        }
        return strJsonFormat;
    }

    @Override
    public String getRTMOSModelType() {
        return "PSDEFSEARCHMODE";
    }

    @Override
    @PSModelRTMeta(description="\u76f8\u5173\u5b9e\u4f53\u5173\u7cfb\u5bf9\u8c61", ignorepf=true, dumpref=true)
    public IPSDERBase getPSDER() throws Exception {
        if ("EXISTS".equals(this.getPSDBValueOPId()) || "NOTEXISTS".equals(this.getPSDBValueOPId())) {
            if (this.getPSDEField() instanceof IPSOne2ManyDataDEField) {
                return ((IPSOne2ManyDataDEField)this.getPSDEField()).getPSDER();
            }
            if (this.getPSDEField() instanceof IPSOne2OneDataDEField) {
                return ((IPSOne2OneDataDEField)this.getPSDEField()).getPSDER();
            }
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u6807\u5b9e\u4f53\u5bf9\u8c61", ignorepf=true, dumpref=true)
    public IPSDataEntity getDstPSDataEntity() throws Exception {
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEFSearchMode.getDSTPSDEID())) {
            return this.getPSDataEntity().getPSSystem().getPSDataEntity2(this.psDEFSearchMode.getDSTPSDEID());
        }
        IPSDERBase iPSDERBase = this.getPSDER();
        if (iPSDERBase != null && ("EXISTS".equals(this.getPSDBValueOPId()) || "NOTEXISTS".equals(this.getPSDBValueOPId()))) {
            return iPSDERBase.getMinorPSDataEntity();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u6807\u5b9e\u4f53\u5c5e\u6027\u5bf9\u8c61", ignorepf=true, dumpref=true, from="__self__", from_method="getDstPSDataEntityMust().getPSDEField")
    public IPSDEField getDstPSDEField() throws Exception {
        IPSDataEntity dstPSDataEntity = this.getDstPSDataEntity();
        if (dstPSDataEntity != null) {
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEFSearchMode.getDSTPSDEFID())) {
                return dstPSDataEntity.getPSDEField(this.psDEFSearchMode.getDSTPSDEFID());
            }
            if ("EXISTS".equals(this.getPSDBValueOPId()) || "NOTEXISTS".equals(this.getPSDBValueOPId())) {
                String strRefPSDEId = this.psDEFSearchMode.getREFPSDEID();
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strRefPSDEId)) {
                    Iterator<IPSDERBase> psDERs = dstPSDataEntity.getMinorPSDERs();
                    if (psDERs != null) {
                        while (psDERs.hasNext()) {
                            IPSDEField pickupPSDEField;
                            IPSDERBase iPSDERBase = psDERs.next();
                            if (SA.SRFramework.Utility.StringHelper.Compare((String)strRefPSDEId, (String)iPSDERBase.getMajorDEId(), (boolean)false) != 0) continue;
                            if ("DER1N".equals(iPSDERBase.getDERType())) {
                                return ((IPSDER1N)iPSDERBase).getPSPickupDEField();
                            }
                            if ("DER11".equals(iPSDERBase.getDERType())) {
                                return ((IPSDER11)iPSDERBase).getPSPickupDEField();
                            }
                            if (!"DERCUSTOM".equals(iPSDERBase.getDERType()) || (pickupPSDEField = ((IPSDERCustom)iPSDERBase).getPickupPSDEField()) == null) continue;
                            return pickupPSDEField;
                        }
                    }
                } else if (dstPSDataEntity.getDEType() == 3) {
                    IPSDERNN iPSDERNN = dstPSDataEntity.getPSDERNN();
                    if (SA.SRFramework.Utility.StringHelper.Compare((String)iPSDERNN.getFirstPSDER().getMajorDEId(), (String)this.getPSDataEntity().getId(), (boolean)false) == 0) {
                        return iPSDERNN.getSecondPSDER().getPickupPSDEField();
                    }
                    return iPSDERNN.getFirstPSDER().getPickupPSDEField();
                }
            }
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u6807\u5b9e\u4f53\u5c5e\u6027\u641c\u7d22\u6a21\u5f0f", ignorepf=true, dumpref=true, from="__self__", from_method="getDstPSDEFieldMust().getPSDEFSearchMode")
    public IPSDEFSearchMode getDstPSDEFSearchMode() throws Exception {
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEFSearchMode.getDSTPSDEFSFITEMID())) {
            return null;
        }
        if (this.dstPSDEFSearchMode == null) {
            if (this.getDstPSDEField() == null) {
                throw new Exception("\u76ee\u6807\u5c5e\u6027\u65e0\u6548");
            }
            this.dstPSDEFSearchMode = this.getDstPSDEField().getPSDEFSearchMode(this.psDEFSearchMode.getDSTPSDEFSFITEMID());
        }
        return this.dstPSDEFSearchMode;
    }

    @Override
    @PSModelRTMeta(description="\u5c5e\u6027\u4e3a\u6570\u7ec4", ignoredumpvalues="false", ignorert=2)
    public boolean isArray() {
        if (this.psDEFSearchMode.isARRAYFLAGNull() && SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEFSearchMode.getVALUESEPERATOR())) {
            try {
                if (this.getDstPSDEFSearchMode() != null) {
                    return this.getDstPSDEFSearchMode().isArray();
                }
            }
            catch (Exception ex) {
                log.error((Object)ex);
            }
        }
        return this.bArray;
    }

    @Override
    @PSModelRTMeta(description="\u9879\u6807\u8bb0", fields={"ITEMTAG"})
    public String getItemTag() {
        return this.psDEFSearchMode.getITEMTAG();
    }

    @Override
    @PSModelRTMeta(description="\u9879\u6807\u8bb02", fields={"ITEMTAG2"})
    public String getItemTag2() {
        return this.psDEFSearchMode.getITEMTAG2();
    }

    @Override
    @PSModelRTMeta(description="\u503c\u5206\u9694\u7b26", fields={"VALUESEPERATOR"})
    public String getValueSeparator() {
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEFSearchMode.getVALUESEPERATOR())) {
            try {
                if (this.getDstPSDEFSearchMode() != null) {
                    return this.getDstPSDEFSearchMode().getValueSeparator();
                }
            }
            catch (Exception ex) {
                log.error((Object)ex);
            }
        }
        return this.psDEFSearchMode.getVALUESEPERATOR();
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u503c\u8f6c\u6362\u5668", hideempty=true, dumpref=true, fields={"PSSYSTRANSLATORID"})
    public IPSSysTranslator getPSSysTranslator() throws Exception {
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getPSSysTranslatorId())) {
            return null;
        }
        if (this.iPSSysTranslator == null) {
            this.iPSSysTranslator = this.getPSDataEntity().getPSSystem().getPSSysTranslator(this.getPSSysTranslatorId());
        }
        return this.iPSSysTranslator;
    }

    public String getPSSysTranslatorId() {
        return this.psDEFSearchMode.getPSSYSTRANSLATORID();
    }

    @Override
    @PSModelRTMeta(description="\u540e\u53f0\u6269\u5c55\u63d2\u4ef6", hideempty=true)
    public IPSSysSFPlugin getPSSysSFPlugin() {
        return this.iPSSysSFPlugin;
    }

    @Override
    @PSModelRTMeta(description="\u6269\u5c55\u7ed8\u5236\u5668", hideempty=true)
    public IPSSFXCodeObject getRender() {
        return this.iPSSFXCodeObject;
    }
}

