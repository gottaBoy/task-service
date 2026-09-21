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
package SA.SRFDA.PS.Core.DEField.Search;

import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DEField.Search.IPSDEFSearch;
import SA.SRFDA.PS.Core.DEField.ValueRule.IPSDEFVRGroupCondition;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Search.IPSDESearch;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSSystemSetting;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Search.IPSSysSearchDEField;
import SA.SRFDA.PS.Core.Search.IPSSysSearchField;
import SA.SRFDA.PS.Data.PSSysSearchDEField;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelIgnoreMeta
public class PSDEFSearchImpl
extends PSObjectImpl
implements IPSDEFSearch {
    private static final Log log = LogFactory.getLog(PSDEFSearchImpl.class);
    protected PSSysSearchDEField psSysSearchDEField = null;
    protected IPSDEFVRGroupCondition iPSDEFVRGroupCondition = null;
    private String strCodeName = "";
    private IPSDESearch iPSDESearch = null;
    private IPSSysSearchDEField iPSSysSearchDEField = null;
    private IPSDEField iPSDEField = null;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEField iPSDEField, PSSysSearchDEField psSysSearchDEField) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSDEField(iPSDEField);
            this.psSysSearchDEField = psSysSearchDEField;
            this.setId(this.psSysSearchDEField.getPSSYSSEARCHDEFIELDID());
            this.setName(this.psSysSearchDEField.getPSSYSSEARCHDEFIELDNAME());
            this.setPSObjectData(this.psSysSearchDEField);
            this.strCodeName = this.psSysSearchDEField.getCODENAME();
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
        return "PSDEFSEARCH";
    }

    @Override
    public String getModelName() {
        return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s#%2$s", (Object)this.getPSDEField().getName(), (Object)this.getName());
    }

    @Override
    public String getModelId() {
        return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s#%2$s", (Object)this.getPSDEField().getModelId(), (Object)super.getModelId());
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5c5e\u6027", dumpref=true, from="IPSDataEntity", fields={"PSDEFID"})
    public IPSDEField getPSDEField() {
        return this.iPSDEField;
    }

    protected void setPSDEField(IPSDEField iPSDEField) {
        this.iPSDEField = iPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5168\u6587\u68c0\u7d22", from="__parent__", fields={"PSSYSSEARCHDEID"})
    public IPSDESearch getPSDESearch() throws Exception {
        if (this.iPSDESearch == null) {
            this.iPSDESearch = this.getPSDataEntity().getPSDESearch(this.psSysSearchDEField.getPSSYSSEARCHDEID());
        }
        return this.iPSDESearch;
    }

    @Override
    @PSModelRTMeta(description="\u5168\u6587\u68c0\u7d22\u5b9e\u4f53\u5c5e\u6027")
    public IPSSysSearchDEField getPSSysSearchDEField() throws Exception {
        if (this.iPSSysSearchDEField == null) {
            this.iPSSysSearchDEField = this.getPSDESearch().getPSSysSearchDE().getPSSysSearchDEField(this.psSysSearchDEField.getPSSYSSEARCHDEFIELDID());
        }
        return this.iPSSysSearchDEField;
    }

    @Override
    @PSModelRTMeta(description="\u5168\u6587\u68c0\u7d22\u6587\u6863\u5c5e\u6027", dumpref=true, from="__self__", from_method="getPSDESearchMust().getPSSysSearchDocMust().getPSSysSearchField")
    public IPSSysSearchField getPSSysSearchField() throws Exception {
        return this.getPSSysSearchDEField().getPSSysSearchField();
    }

    @Override
    @PSModelRTMeta(description="\u5c5e\u6027\u6807\u8bb0", hideempty2=true)
    public String getFieldTag() {
        return this.psSysSearchDEField.getFIELDTAG();
    }

    @Override
    @PSModelRTMeta(description="\u5c5e\u6027\u6807\u8bb02", hideempty2=true)
    public String getFieldTag2() {
        return this.psSysSearchDEField.getFIELDTAG2();
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSDEField().getPSSysModelInstId();
    }

    public IPSDataEntity getPSDataEntity() {
        return this.getPSDEField().getPSDataEntity();
    }

    protected IPSSystemSetting getPSSystemSetting() {
        return (IPSSystemSetting)((Object)this.getPSDataEntity().getPSSystem());
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSDataEntity().getPSSystem());
    }

    @Override
    public String getFullModelName() {
        return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s|%2$s", (Object)this.getPSDEField().getFullModelName(), (Object)this.getModelName());
    }

    @Override
    protected IPSModelObject onGetParentModel() {
        try {
            return this.getPSDESearch();
        }
        catch (Exception e) {
            return null;
        }
    }

    @Override
    protected IPSModelObject onGetScopeModel() {
        try {
            return this.getPSDESearch();
        }
        catch (Exception e) {
            return null;
        }
    }
}

