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

import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
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
import SA.SRFDA.PS.Core.Res.IPSSysTranslator;
import SA.SRFDA.PS.Core.SF.PSSFXCodeObjectProxy;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Data.PSSysTranslator;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Properties;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.PropertiesHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysTranslatorImpl
extends PSSystemObjectImpl
implements IPSSysTranslator {
    private static final Log log = LogFactory.getLog(PSSysTranslatorImpl.class);
    protected PSSysTranslator psSysTranslator = null;
    private String strCodeName = "";
    private IPSSystemModule iPSSystemModule = null;
    private IPSDataEntity iPSDataEntity = null;
    private IPSSysSFPlugin iPSSysSFPlugin = null;
    private IPSXCodeObject iPSXCodeObject = null;
    private IPSDEField keyPSDEField = null;
    private IPSDEField valuePSDEField = null;
    private IPSDEField userPSDEField = null;
    private IPSDEField user2PSDEField = null;
    private IPSCodeList iPSCodeList = null;
    private Properties translatorParams = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem, PSSysTranslator psSysTranslator) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSystem(iPSSystem);
            this.psSysTranslator = psSysTranslator;
            this.setId(this.psSysTranslator.getPSSYSTRANSLATORID());
            this.setName(this.psSysTranslator.getPSSYSTRANSLATORNAME());
            this.setPSObjectData(this.psSysTranslator);
            this.strCodeName = this.psSysTranslator.getCODENAME();
            if (!StringHelper.isNullOrEmpty((String)this.psSysTranslator.getPSMODULEID())) {
                this.iPSSystemModule = this.getPSSystem().getPSSystemModule(this.psSysTranslator.getPSMODULEID());
            }
            if (StringHelper.compare((String)this.getTranslatorType(), (String)"DESTORAGE", (boolean)false) == 0) {
                if (this.getPSDataEntity() == null && !StringHelper.isNullOrEmpty((String)this.psSysTranslator.getPSDEID())) {
                    this.iPSDataEntity = this.getPSSystem().getPSDataEntity2(this.psSysTranslator.getPSDEID());
                }
                if (this.getPSDataEntity() == null) {
                    throw new Exception(String.format("\u7cfb\u7edf\u503c\u8f6c\u6362\u5668\u7c7b\u578b\u4e3a\u3010\u5b9e\u4f53\u6269\u5c55\u5b58\u50a8\u3011\uff0c\u9700\u8981\u6307\u5b9a\u5b9e\u4f53\u5bf9\u8c61", new Object[0]));
                }
                if (this.getKeyPSDEField() == null) {
                    this.keyPSDEField = !StringHelper.isNullOrEmpty((String)this.psSysTranslator.getKEYPSDEFID()) ? this.getPSDataEntity().getPSDEField(this.psSysTranslator.getKEYPSDEFID()) : this.getPSDataEntity().getKeyPSDEField();
                }
                if (this.getValuePSDEField() == null) {
                    if (!StringHelper.isNullOrEmpty((String)this.psSysTranslator.getVALUEPSDEFID())) {
                        this.valuePSDEField = this.getPSDataEntity().getPSDEField(this.psSysTranslator.getVALUEPSDEFID());
                    }
                    if (this.getValuePSDEField() == null) {
                        throw new Exception(String.format("\u7cfb\u7edf\u503c\u8f6c\u6362\u5668\u7c7b\u578b\u4e3a\u3010\u5b9e\u4f53\u3011\uff0c\u9700\u8981\u6307\u5b9a\u5b58\u50a8\u8f6c\u6362\u5668\u503c\u7684\u5c5e\u6027\u5bf9\u8c61", new Object[0]));
                    }
                }
                if (!StringHelper.isNullOrEmpty((String)this.psSysTranslator.getUSERPSDEFID())) {
                    this.userPSDEField = this.getPSDataEntity().getPSDEField(this.psSysTranslator.getUSERPSDEFID());
                }
                if (!StringHelper.isNullOrEmpty((String)this.psSysTranslator.getUSER2PSDEFID())) {
                    this.user2PSDEField = this.getPSDataEntity().getPSDEField(this.psSysTranslator.getUSER2PSDEFID());
                }
            }
            if (StringHelper.compare((String)this.getTranslatorType(), (String)"CODELIST", (boolean)false) == 0 && StringHelper.isNullOrEmpty((String)this.psSysTranslator.getPSCODELISTID())) {
                throw new Exception(String.format("\u7cfb\u7edf\u503c\u8f6c\u6362\u5668\u7c7b\u578b\u4e3a\u3010\u4ee3\u7801\u8868\u3011\uff0c\u9700\u8981\u6307\u5b9a\u4ee3\u7801\u8868\u5bf9\u8c61", new Object[0]));
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysTranslator.getTRANSLATORPARAMS())) {
                this.translatorParams = PropertiesHelper.load((String)this.psSysTranslator.getTRANSLATORPARAMS());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysTranslator.getPSSYSSFPLUGINID())) {
                this.iPSSysSFPlugin = this.getPSSystem().getPSSysSFPlugin(this.psSysTranslator.getPSSYSSFPLUGINID());
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
    protected int onCheck() throws Exception {
        this.getPSCodeList();
        return super.onCheck();
    }

    @Override
    @PSModelRTMeta(description="\u503c\u8f6c\u6362\u5668\u7c7b\u578b", codelist="TranslatorType", group="\u57fa\u672c", order=125, fields={"TRANSLATORTYPE"})
    public String getTranslatorType() {
        return this.psSysTranslator.getTRANSLATORTYPE();
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
        return "PSSYSTRANSLATOR";
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
    @PSModelRTMeta(description="\u503c\u8f6c\u6362\u5668\u6807\u8bb0", hideempty2=true, fields={"TRANSLATORTAG"})
    public String getTranslatorTag() {
        return this.psSysTranslator.getTRANSLATORTAG();
    }

    @Override
    @PSModelRTMeta(description="\u503c\u8f6c\u6362\u5668\u6807\u8bb02", hideempty2=true, fields={"TRANSLATORTAG2"})
    public String getTranslatorTag2() {
        return this.psSysTranslator.getTRANSLATORTAG2();
    }

    @Override
    @PSModelRTMeta(description="\u540e\u7aef\u6a21\u677f\u63d2\u4ef6\u5bf9\u8c61", hideempty=true, fields={"PSSYSSFPLUGINID"})
    public IPSSysSFPlugin getPSSysSFPlugin() {
        return this.iPSSysSFPlugin;
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
    @PSModelRTMeta(description="\u81ea\u5b9a\u4e49\u5c5e\u6027", hideempty2=true, dumpref=true, from="IPSDataEntity", fields={"USERPSDEFID"})
    public IPSDEField getUserPSDEField() {
        return this.userPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u81ea\u5b9a\u4e49\u5c5e\u60272", hideempty2=true, dumpref=true, from="IPSDataEntity", fields={"USER2PSDEFID"})
    public IPSDEField getUser2PSDEField() {
        return this.user2PSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u8868\u5bf9\u8c61", hideempty2=true, dumpref=true, fields={"PSCODELISTID"})
    public IPSCodeList getPSCodeList() throws Exception {
        if (StringHelper.compare((String)this.getTranslatorType(), (String)"CODELIST", (boolean)false) == 0) {
            if (this.iPSCodeList == null) {
                this.iPSCodeList = this.getPSSystem().getPSCodeList(this.psSysTranslator.getPSCODELISTID());
            }
            return this.iPSCodeList;
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u8f6c\u6362\u5668\u52a8\u6001\u53c2\u6570", hideempty=true, ignorepf=true, fields={"TRANSLATORPARAMS"})
    public Properties getTranslatorParams() {
        return this.translatorParams;
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

