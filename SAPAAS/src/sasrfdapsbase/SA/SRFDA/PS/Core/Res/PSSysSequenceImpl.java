/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.PropertiesHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Res;

import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSSystemObjectImpl;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPub;
import SA.SRFDA.PS.Core.Pub.IPSXCodeObject;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysSFPluginTempl;
import SA.SRFDA.PS.Core.Res.IPSSysSequence;
import SA.SRFDA.PS.Core.SF.PSSFXCodeObjectProxy;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Data.PSSysSequence;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.math.BigInteger;
import java.util.Properties;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.PropertiesHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysSequenceImpl
extends PSSystemObjectImpl
implements IPSSysSequence {
    private static final Log log = LogFactory.getLog(PSSysSequenceImpl.class);
    protected PSSysSequence psSysSequence = null;
    private String strCodeName = "";
    private IPSSystemModule iPSSystemModule = null;
    private IPSDataEntity iPSDataEntity = null;
    private IPSSysSFPlugin iPSSysSFPlugin = null;
    private IPSXCodeObject iPSXCodeObject = null;
    private IPSDEField keyPSDEField = null;
    private IPSDEField valuePSDEField = null;
    private IPSDEField typePSDEField = null;
    private IPSDEField timePSDEField = null;
    private BigInteger minValue = null;
    private BigInteger maxValue = null;
    private String[] extFormatParams = null;
    private Properties sequenceParams = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem, PSSysSequence psSysSequence) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSystem(iPSSystem);
            this.psSysSequence = psSysSequence;
            this.setId(this.psSysSequence.getPSSYSSEQUENCEID());
            this.setName(this.psSysSequence.getPSSYSSEQUENCENAME());
            this.setPSObjectData(this.psSysSequence);
            this.strCodeName = this.psSysSequence.getCODENAME();
            if (!StringHelper.isNullOrEmpty((String)this.psSysSequence.getPSMODULEID())) {
                this.iPSSystemModule = this.getPSSystem().getPSSystemModule(this.psSysSequence.getPSMODULEID());
            }
            if (StringHelper.compare((String)this.getSequenceType(), (String)"DE", (boolean)false) == 0) {
                if (this.getPSDataEntity() == null && !StringHelper.isNullOrEmpty((String)this.psSysSequence.getPSDEID())) {
                    this.iPSDataEntity = this.getPSSystem().getPSDataEntity2(this.psSysSequence.getPSDEID());
                }
                if (this.getPSDataEntity() == null) {
                    throw new Exception(String.format("\u7cfb\u7edf\u503c\u5e8f\u5217\u7c7b\u578b\u4e3a\u3010\u5b9e\u4f53\u3011\uff0c\u9700\u8981\u6307\u5b9a\u5b9e\u4f53\u5bf9\u8c61", new Object[0]));
                }
                if (this.getKeyPSDEField() == null) {
                    this.keyPSDEField = !StringHelper.isNullOrEmpty((String)this.psSysSequence.getKEYPSDEFID()) ? this.getPSDataEntity().getPSDEField(this.psSysSequence.getKEYPSDEFID()) : this.getPSDataEntity().getKeyPSDEField();
                }
                if (this.getValuePSDEField() == null) {
                    if (!StringHelper.isNullOrEmpty((String)this.psSysSequence.getVALUEPSDEFID())) {
                        this.valuePSDEField = this.getPSDataEntity().getPSDEField(this.psSysSequence.getVALUEPSDEFID());
                    }
                    if (this.getValuePSDEField() == null) {
                        throw new Exception(String.format("\u7cfb\u7edf\u503c\u5e8f\u5217\u7c7b\u578b\u4e3a\u3010\u5b9e\u4f53\u3011\uff0c\u9700\u8981\u6307\u5b9a\u5b58\u50a8\u5e8f\u5217\u503c\u7684\u5c5e\u6027\u5bf9\u8c61", new Object[0]));
                    }
                }
                if (this.getTimePSDEField() == null && !StringHelper.isNullOrEmpty((String)this.psSysSequence.getTIMEPSDEFID())) {
                    this.timePSDEField = this.getPSDataEntity().getPSDEField(this.psSysSequence.getTIMEPSDEFID());
                }
                if (this.getTypePSDEField() == null && !StringHelper.isNullOrEmpty((String)this.psSysSequence.getTYPEPSDEFID())) {
                    this.typePSDEField = this.getPSDataEntity().getPSDEField(this.psSysSequence.getTYPEPSDEFID());
                }
                if (this.getKeyPSDEField() != null) {
                    this.getKeyPSDEField().getPSDEFSearchMode(String.format("N_%1$s_EQ", this.getKeyPSDEField().getName()), false);
                }
                if (this.getValuePSDEField() != null) {
                    this.getValuePSDEField().getPSDEFSearchMode(String.format("N_%1$s_EQ", this.getValuePSDEField().getName()), false);
                }
                if (this.getTimePSDEField() != null) {
                    this.getTimePSDEField().getPSDEFSearchMode(String.format("N_%1$s_EQ", this.getTimePSDEField().getName()), false);
                }
                if (this.getTypePSDEField() != null) {
                    this.getTypePSDEField().getPSDEFSearchMode(String.format("N_%1$s_EQ", this.getTypePSDEField().getName()), false);
                }
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysSequence.getEXTFORMATPARAMS())) {
                this.extFormatParams = StringHelper.splitEx((String)this.psSysSequence.getEXTFORMATPARAMS());
            }
            if (!this.psSysSequence.isMINVALUENull()) {
                this.minValue = BigInteger.valueOf(this.psSysSequence.getMINVALUE());
            }
            if (!this.psSysSequence.isMAXVALUENull()) {
                this.maxValue = BigInteger.valueOf(this.psSysSequence.getMAXVALUE());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysSequence.getSEQUENCEPARAMS())) {
                this.sequenceParams = PropertiesHelper.load((String)this.psSysSequence.getSEQUENCEPARAMS());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysSequence.getPSSYSSFPLUGINID())) {
                this.iPSSysSFPlugin = this.getPSSystem().getPSSysSFPlugin(this.psSysSequence.getPSSYSSFPLUGINID());
            }
            if (this.getPSSysSFPlugin() != null) {
                String strPSSysSFPluginTemplId = KeyValueHelper.genUniqueId((String)this.getPSSysSFPlugin().getId(), (String)this.getPSSystem().getPSSFId());
                IPSSysSFPluginTempl iPSSysSFPluginTempl = this.getPSSystem().getPSSysSFPluginTempl(strPSSysSFPluginTemplId, true);
                if (iPSSysSFPluginTempl != null) {
                    this.iPSXCodeObject = new PSSFXCodeObjectProxy(iPSSysSFPluginTempl, this);
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
    @PSModelRTMeta(description="\u503c\u5e8f\u5217\u7c7b\u578b", codelist="SequenceType", group="\u57fa\u672c", order=125, fields={"SEQUENCETYPE"})
    public String getSequenceType() {
        return this.psSysSequence.getSEQUENCETYPE();
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.onGetCodeName();
    }

    protected String onGetCodeName() {
        return this.calcCodeName();
    }

    protected String calcCodeName() {
        return this.strCodeName;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u6a21\u5757", dumpref=true, dynamodelmode=4, fields={"PSMODULEID"})
    public IPSSystemModule getPSSystemModule() {
        return this.iPSSystemModule;
    }

    @Override
    public String getModelType() {
        return "PSSYSSEQUENCE";
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5bf9\u8c61", hideempty=true, dumpref=true, fields={"PSDEID"})
    public IPSDataEntity getPSDataEntity() {
        return this.iPSDataEntity;
    }

    @Override
    @PSModelRTMeta(description="\u6269\u5c55\u7ed8\u5236\u5668", hideempty=true)
    public IPSXCodeObject getRender() {
        return this.iPSXCodeObject;
    }

    @Override
    @PSModelRTMeta(description="\u503c\u5e8f\u5217\u6807\u8bb0", hideempty2=true, fields={"SEQUENCETAG"})
    public String getSequenceTag() {
        return this.psSysSequence.getSEQUENCETAG();
    }

    @Override
    @PSModelRTMeta(description="\u503c\u5e8f\u5217\u6807\u8bb02", hideempty2=true, fields={"SEQUENCETAG2"})
    public String getSequenceTag2() {
        return this.psSysSequence.getSEQUENCETAG2();
    }

    @Override
    @PSModelRTMeta(description="\u540e\u7aef\u6a21\u677f\u63d2\u4ef6\u5bf9\u8c61", hideempty=true, fields={"PSSYSSFPLUGINID"})
    public IPSSysSFPlugin getPSSysSFPlugin() {
        return this.iPSSysSFPlugin;
    }

    @Override
    @PSModelRTMeta(description="\u503c\u5e8f\u5217\u683c\u5f0f\u5316", hideempty2=true, fields={"SEQUENCEFORMAT"})
    public String getSequenceFormat() {
        return this.psSysSequence.getSEQUENCEFORMAT();
    }

    @Override
    @PSModelRTMeta(description="\u503c\u5e8f\u5217\u6700\u5927\u503c", hideempty2=true, fields={"MAXVALUE"})
    public BigInteger getMaxValue() {
        return this.maxValue;
    }

    @Override
    @PSModelRTMeta(description="\u503c\u5e8f\u5217\u6700\u5c0f\u503c", hideempty2=true, fields={"MINVALUE"})
    public BigInteger getMinValue() {
        return this.minValue;
    }

    @Override
    @PSModelRTMeta(description="\u6807\u8bc6\u5b58\u50a8\u5c5e\u6027", hideempty2=true, dumpref=true, from="IPSDataEntity", fields={"KEYPSDEFID"})
    public IPSDEField getKeyPSDEField() {
        return this.keyPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u503c\u5b58\u50a8\u5c5e\u6027", hideempty2=true, dumpref=true, from="IPSDataEntity", fields={"VALUEPSDEFID"})
    public IPSDEField getValuePSDEField() {
        return this.valuePSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u6269\u5c55\u683c\u5f0f\u5316\u53c2\u6570\u96c6\u5408", hideempty2=true, child=true, fields={"EXTFORMATPARAMS"})
    public String[] getExtFormatParams() {
        return this.extFormatParams;
    }

    @Override
    @PSModelRTMeta(description="\u65f6\u95f4\u5b58\u50a8\u5c5e\u6027", hideempty2=true, dumpref=true, from="IPSDataEntity", fields={"TIMEPSDEFID"})
    public IPSDEField getTimePSDEField() {
        return this.timePSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u7c7b\u578b\u5b58\u50a8\u5c5e\u6027", hideempty2=true, dumpref=true, from="IPSDataEntity", fields={"TYPEPSDEFID"})
    public IPSDEField getTypePSDEField() {
        return this.typePSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u65f6\u95f4\u683c\u5f0f\u5316", hideempty2=true, fields={"TIMEFORMAT"})
    public String getTimeFormat() {
        return this.psSysSequence.getTIMEFORMAT();
    }

    @Override
    @PSModelRTMeta(description="\u5e8f\u5217\u52a8\u6001\u53c2\u6570", hideempty=true, ignorepf=true, fields={"SEQUENCEPARAMS"})
    public Properties getSequenceParams() {
        return this.sequenceParams;
    }

    @Override
    @PSModelRTMeta(description="\u540e\u53f0\u670d\u52a1\u53d1\u5e03\u5bf9\u8c61", hideempty=true)
    public IPSSysSFPub getPSSysSFPub() {
        if (this.getPSSystemModule() != null) {
            return this.getPSSystemModule().getPSSysSFPub();
        }
        return this.getPSSystem().getDefaultPSSysSFPub();
    }
}

