/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.util.PropertiesHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Search;

import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Search.IPSSysSearchDoc;
import SA.SRFDA.PS.Core.Search.IPSSysSearchField;
import SA.SRFDA.PS.Core.Search.PSSysSearchDocObjectImpl;
import SA.SRFDA.PS.Data.PSSysSearchField;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Properties;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.util.PropertiesHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysSearchFieldImpl
extends PSSysSearchDocObjectImpl
implements IPSSysSearchField {
    private static final Log log = LogFactory.getLog(PSSysSearchFieldImpl.class);
    protected PSSysSearchField psSysSearchField = null;
    private boolean bPKey = false;
    private boolean bIndex = true;
    private String strDateFormat = "";
    private String strPattern = "";
    private boolean bStore = false;
    private boolean bFieldData = false;
    private String strAnalyzer = "";
    private String strSearchAnalyzer = "";
    private String[] ignoreFields = null;
    private boolean bIncludeInParent = false;
    private String strFieldTag = "";
    private String strFieldTag2 = "";
    private int nStdDataType = 0;
    private String strFieldType = "AUTO";
    private Properties fieldParams = null;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSysSearchDoc iPSSysSearchDoc, PSSysSearchField psSysSearchField) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSysSearchDoc(iPSSysSearchDoc);
            this.psSysSearchField = psSysSearchField;
            this.setId(this.psSysSearchField.getPSSYSSEARCHFIELDID());
            this.setName(this.psSysSearchField.getPSSYSSEARCHFIELDNAME());
            this.setPSObjectData(this.psSysSearchField);
            if (!this.psSysSearchField.isINDEXFLAGNull()) {
                this.bIndex = this.psSysSearchField.getINDEXFLAG();
            }
            this.strDateFormat = this.psSysSearchField.getDATEFORMAT();
            this.strPattern = this.psSysSearchField.getPATTERN();
            if (!this.psSysSearchField.isSTOREFLAGNull()) {
                this.bStore = this.psSysSearchField.getSTOREFLAG();
            }
            if (!this.psSysSearchField.isFIELDDATAFLAGNull()) {
                this.bFieldData = this.psSysSearchField.getFIELDDATAFLAG();
            }
            this.strAnalyzer = this.psSysSearchField.getANALYZER();
            this.strSearchAnalyzer = this.psSysSearchField.getSEARCHANALYZER();
            if (!StringHelper.isNullOrEmpty((String)this.psSysSearchField.getIGNOREFIELDS())) {
                this.ignoreFields = this.psSysSearchField.getIGNOREFIELDS().replace(",", ";").split("[;]");
            }
            if (!this.psSysSearchField.isINCINPARENTFLAGNull()) {
                this.bIncludeInParent = this.psSysSearchField.getINCINPARENTFLAG();
            }
            this.strFieldTag = this.psSysSearchField.getFIELDTAG();
            this.strFieldTag2 = this.psSysSearchField.getFIELDTAG2();
            if (!StringHelper.isNullOrEmpty((String)this.psSysSearchField.getFIELDTYPE())) {
                this.strFieldType = this.psSysSearchField.getFIELDTYPE();
            }
            if (!this.psSysSearchField.isSTDDATATYPENull()) {
                this.nStdDataType = this.psSysSearchField.getSTDDATATYPE();
            }
            if (!this.psSysSearchField.isPKEYNull()) {
                this.bPKey = this.psSysSearchField.getPKEY();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysSearchField.getFIELDPARAMS())) {
                this.fieldParams = PropertiesHelper.loadEx((String)this.psSysSearchField.getFIELDPARAMS());
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
        return "PSSYSSEARCHFIELD";
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6", fields={"CODENAME"})
    public String getCodeName() {
        return this.psSysSearchField.getCODENAME();
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u540d\u79f0", fields={"LOGICNAME"})
    public String getLogicName() {
        return this.psSysSearchField.getLOGICNAME();
    }

    @Override
    @PSModelRTMeta(description="\u4e3b\u952e", ignoredumpvalues="false", fields={"PKEY"})
    public boolean isPKey() {
        return this.bPKey;
    }

    @Override
    @PSModelRTMeta(description="\u5c5e\u6027\u7c7b\u578b", fields={"FIELDTYPE"})
    public String getFieldType() {
        return this.strFieldType;
    }

    @Override
    @PSModelRTMeta(description="\u6807\u51c6\u6570\u636e\u7c7b\u578b", codelist="StdDataType", fields={"STDDATATYPE"})
    public int getStdDataType() {
        return this.nStdDataType;
    }

    @Override
    @PSModelRTMeta(description="\u7d22\u5f15", ignoredumpvalues="false", fields={"INDEXFLAG"})
    public boolean isIndex() {
        return this.bIndex;
    }

    @Override
    @PSModelRTMeta(description="\u65f6\u95f4\u683c\u5f0f\u5316", fields={"DATEFORMAT"})
    public String getDateFormat() {
        return this.strDateFormat;
    }

    @Override
    @PSModelRTMeta(description="\u6a21\u5f0f", fields={"PATTERN"})
    public String getPattern() {
        return this.strPattern;
    }

    @Override
    @PSModelRTMeta(description="\u5b58\u50a8", ignoredumpvalues="false", fields={"STOREFLAG"})
    public boolean isStore() {
        return this.bStore;
    }

    @Override
    @PSModelRTMeta(description="\u5c5e\u6027\u6570\u636e", ignoredumpvalues="false", fields={"FIELDDATAFLAG"})
    public boolean isFieldData() {
        return this.bFieldData;
    }

    @Override
    @PSModelRTMeta(description="\u5206\u6790\u5668", fields={"ANALYZER"})
    public String getAnalyzer() {
        return this.strAnalyzer;
    }

    @Override
    @PSModelRTMeta(description="\u641c\u7d22\u5206\u6790\u5668", fields={"SEARCHANALYZER"})
    public String getSearchAnalyzer() {
        return this.strSearchAnalyzer;
    }

    @Override
    @PSModelRTMeta(description="\u5ffd\u7565\u5c5e\u6027\u96c6\u5408", child=true, fields={"IGNOREFIELDS"})
    public String[] getIgnoreFields() {
        return this.ignoreFields;
    }

    @Override
    @PSModelRTMeta(description="\u5305\u62ec\u5728\u7236\u4e2d", ignoredumpvalues="false", fields={"INCINPARENTFLAG"})
    public boolean isIncludeInParent() {
        return this.bIncludeInParent;
    }

    @Override
    @PSModelRTMeta(description="\u5c5e\u6027\u6807\u8bb0", hideempty2=true, fields={"FIELDTAG"})
    public String getFieldTag() {
        return this.strFieldTag;
    }

    @Override
    @PSModelRTMeta(description="\u5c5e\u6027\u6807\u8bb02", hideempty2=true, fields={"FIELDTAG2"})
    public String getFieldTag2() {
        return this.strFieldTag2;
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u53c2\u6570", fields={"FIELDPARAMS"})
    public Properties getFieldParams() {
        return this.fieldParams;
    }
}

