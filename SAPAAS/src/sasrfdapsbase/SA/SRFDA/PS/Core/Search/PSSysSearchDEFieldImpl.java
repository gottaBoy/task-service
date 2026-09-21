/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Search;

import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Res.IPSSysTranslator;
import SA.SRFDA.PS.Core.Search.IPSSearchField;
import SA.SRFDA.PS.Core.Search.IPSSysSearchDE;
import SA.SRFDA.PS.Core.Search.IPSSysSearchDEField;
import SA.SRFDA.PS.Core.Search.IPSSysSearchField;
import SA.SRFDA.PS.Core.Search.PSSysSearchDEObjectImpl;
import SA.SRFDA.PS.Data.PSSysSearchDEField;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysSearchDEFieldImpl
extends PSSysSearchDEObjectImpl
implements IPSSysSearchDEField {
    private static final Log log = LogFactory.getLog(PSSysSearchDEFieldImpl.class);
    protected PSSysSearchDEField psSysSearchDEField = null;
    private String strCodeName = null;
    private IPSDEField iPSDEField = null;
    private IPSSysSearchField iPSSysSearchField = null;
    private IPSSysTranslator iPSSysTranslator = null;
    private String[] fields = null;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSysSearchDE iPSSysSearchDE, PSSysSearchDEField psSysSearchDEField) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSysSearchDE(iPSSysSearchDE);
            this.psSysSearchDEField = psSysSearchDEField;
            this.setId(this.psSysSearchDEField.getPSSYSSEARCHDEFIELDID());
            this.setName(this.psSysSearchDEField.getPSSYSSEARCHDEFIELDNAME());
            this.setPSObjectData(this.psSysSearchDEField);
            this.strCodeName = this.psSysSearchDEField.getCODENAME();
            this.iPSSysSearchField = !StringHelper.isNullOrEmpty((String)this.psSysSearchDEField.getPSSYSSEARCHFIELDID()) ? this.getPSSysSearchDE().getPSSysSearchDoc().getPSSysSearchField(this.psSysSearchDEField.getPSSYSSEARCHFIELDID()) : this.getPSSysSearchDE().getPSSysSearchDoc().getPSSysSearchField(this);
            if (StringHelper.isNullOrEmpty((String)this.strCodeName)) {
                this.strCodeName = this.iPSSysSearchField.getCodeName();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysSearchDEField.getPSDEFID())) {
                this.iPSDEField = this.getPSSysSearchDE().getPSDataEntity().getPSDEField(this.psSysSearchDEField.getPSDEFID());
                if (StringHelper.isNullOrEmpty((String)this.strCodeName)) {
                    this.strCodeName = this.iPSDEField.getCodeName();
                }
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysSearchDEField.getFIELDS())) {
                this.fields = this.psSysSearchDEField.getFIELDS().replace(",", ";").split("[;]");
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
    public String getModelType() {
        return "PSSYSSEARCHDEFIELD";
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.strCodeName;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5c5e\u6027", dumpref=true, from="IPSSysSearchDE", from_method="getPSDataEntityMust().getPSDEField", fields={"PSDEFID"})
    public IPSDEField getPSDEField() {
        return this.iPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u68c0\u7d22\u6587\u6863\u5b9e\u4f53", fields={"PSSYSSEARCHDEID"})
    public IPSSysSearchDE getPSSysSearchDE() {
        return super.getPSSysSearchDE();
    }

    @Override
    public IPSSearchField getPSSearchField() {
        return this.getPSSysSearchField();
    }

    @Override
    @PSModelRTMeta(description="\u68c0\u7d22\u6587\u6863\u5c5e\u6027", dumpref=true, from="IPSSysSearchDE", from_method="getPSSysSearchDocMust().getPSSysSearchField", fields={"PSSYSSEARCHFIELDID"})
    public IPSSysSearchField getPSSysSearchField() {
        return this.iPSSysSearchField;
    }

    @Override
    @PSModelRTMeta(description="\u5c5e\u6027\u6807\u8bb0", hideempty2=true, fields={"FIELDTAG"})
    public String getFieldTag() {
        return this.psSysSearchDEField.getFIELDTAG();
    }

    @Override
    @PSModelRTMeta(description="\u5c5e\u6027\u6807\u8bb02", hideempty2=true, fields={"FIELDTAG2"})
    public String getFieldTag2() {
        return this.psSysSearchDEField.getFIELDTAG2();
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u503c\u7c7b\u578b", codelist="DEFDefaultValueType", fields={"DEFAULTVALUETYPE"})
    public String getDefaultValueType() {
        return this.psSysSearchDEField.getDEFAULTVALUETYPE();
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u503c", fields={"DEFAULTVALUE"})
    public String getDefaultValue() {
        return this.psSysSearchDEField.getDEFAULTVALUE();
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u503c\u8f6c\u6362\u5668", hideempty=true, dumpref=true, fields={"PSSYSTRANSLATORID"})
    public IPSSysTranslator getPSSysTranslator() throws Exception {
        if (StringHelper.isNullOrEmpty((String)this.getPSSysTranslatorId())) {
            return null;
        }
        if (this.iPSSysTranslator == null) {
            this.iPSSysTranslator = this.getPSSysSearchScheme().getPSSystem().getPSSysTranslator(this.getPSSysTranslatorId());
        }
        return this.iPSSysTranslator;
    }

    public String getPSSysTranslatorId() {
        return this.psSysSearchDEField.getPSSYSTRANSLATORID();
    }

    @Override
    @PSModelRTMeta(description="\u66f4\u591a\u5c5e\u6027\u96c6\u5408", child=true, fields={"FIELDS"})
    public String[] getFields() {
        return this.fields;
    }
}

