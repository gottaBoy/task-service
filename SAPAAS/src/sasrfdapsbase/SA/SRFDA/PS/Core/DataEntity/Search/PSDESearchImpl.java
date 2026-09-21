/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.Search;

import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DEField.Search.IPSDEFSearch;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.PSDataEntityObjectImpl;
import SA.SRFDA.PS.Core.DataEntity.Search.IPSDESearch;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Search.IPSSysSearchDE;
import SA.SRFDA.PS.Core.Search.IPSSysSearchDoc;
import SA.SRFDA.PS.Core.Search.IPSSysSearchScheme;
import SA.SRFDA.PS.Data.PSSysSearchDE;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDESearchImpl
extends PSDataEntityObjectImpl
implements IPSDESearch {
    private static final Log log = LogFactory.getLog(PSDESearchImpl.class);
    protected PSSysSearchDE psSysSearchDE;
    private IPSSysSearchScheme iPSSysSearchScheme = null;
    private IPSSysSearchDE iPSSysSearchDE = null;
    private Map<String, IPSDEFSearch> psDEFSearchMap = null;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDataEntity iPSDataEntity, PSSysSearchDE psSysSearchDE) throws Exception {
        try {
            this.setPSDataEntity(iPSDataEntity);
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.psSysSearchDE = psSysSearchDE;
            this.setId(psSysSearchDE.getPSSYSSEARCHDEID());
            this.setName(psSysSearchDE.getPSSYSSEARCHDENAME());
            this.setPSObjectData(this.psSysSearchDE);
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
        this.getPSSysSearchScheme();
        this.getPSSysSearchDoc();
        return super.onCheck();
    }

    @Override
    public String getModelType() {
        return "PSDESEARCH";
    }

    @Override
    public String getModelId() {
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSDataEntity().getModelId(), (Object)super.getModelId());
    }

    @Override
    @PSModelRTMeta(description="\u5168\u6587\u68c0\u7d22\u4f53\u7cfb", dumpref=true)
    public IPSSysSearchScheme getPSSysSearchScheme() throws Exception {
        if (this.iPSSysSearchScheme == null) {
            this.iPSSysSearchScheme = this.getPSDataEntity().getPSSystem().getPSSysSearchScheme(this.psSysSearchDE.getPSSYSSEARCHSCHEMEID());
        }
        return this.iPSSysSearchScheme;
    }

    @Override
    @PSModelRTMeta(description="\u5168\u6587\u68c0\u7d22\u5b9e\u4f53", dumpref=true, from="IPSSysSearchScheme")
    public IPSSysSearchDE getPSSysSearchDE() throws Exception {
        if (this.iPSSysSearchDE == null) {
            this.iPSSysSearchDE = this.getPSSysSearchScheme().getPSSysSearchDE(this.getId());
        }
        return this.iPSSysSearchDE;
    }

    @Override
    @PSModelRTMeta(description="\u5168\u6587\u68c0\u7d22\u6587\u6863")
    public IPSSysSearchDoc getPSSysSearchDoc() throws Exception {
        return this.getPSSysSearchDE().getPSSysSearchDoc();
    }

    @Override
    @PSModelRTMeta(description="\u5c5e\u6027\u5168\u6587\u68c0\u7d22\u96c6\u5408")
    public Iterator<IPSDEFSearch> getAllPSDEFSearches() throws Exception {
        return this.getAllPSDEFSearchs();
    }

    @Override
    public Iterator<IPSDEFSearch> getAllPSDEFSearchs() throws Exception {
        if (this.psDEFSearchMap == null) {
            LinkedHashMap<String, IPSDEFSearch> psDEFSearchMap = new LinkedHashMap<String, IPSDEFSearch>();
            Iterator<IPSDEField> psDEFields = this.getPSDataEntity().getAllPSDEFields();
            if (psDEFields != null) {
                while (psDEFields.hasNext()) {
                    IPSDEField iPSDEField = psDEFields.next();
                    Iterator<IPSDEFSearch> psDEFSearchs = iPSDEField.getAllPSDEFSearchs();
                    if (psDEFSearchs == null) continue;
                    while (psDEFSearchs.hasNext()) {
                        IPSDEFSearch iPSDEFSearch = psDEFSearchs.next();
                        if (StringHelper.compare((String)iPSDEFSearch.getPSDESearch().getId(), (String)this.getId(), (boolean)false) != 0) continue;
                        psDEFSearchMap.put(iPSDEFSearch.getId(), iPSDEFSearch);
                    }
                }
            }
            if (this.psDEFSearchMap == null) {
                this.psDEFSearchMap = psDEFSearchMap;
            }
        }
        return this.psDEFSearchMap.values().iterator();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u6807\u8bb0", hideempty2=true)
    public String getDETag() {
        try {
            return this.getPSSysSearchDE().getDETag();
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return null;
        }
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u6807\u8bb02", hideempty2=true)
    public String getDETag2() {
        try {
            return this.getPSSysSearchDE().getDETag2();
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return null;
        }
    }

    @Override
    @PSModelRTMeta(description="\u4f5c\u4e3aNoSQL\u5b58\u50a8", ignoredumpvalues="false")
    public boolean isNoSQLStorage() {
        try {
            return this.getPSSysSearchDE().isNoSQLStorage();
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return false;
        }
    }

    @Override
    protected String onGetDynaModelTag() {
        try {
            return String.format("%1$s__%2$s", this.getPSSysSearchScheme().getCodeName(), this.getPSSysSearchDoc().getCodeName());
        }
        catch (Exception e) {
            return null;
        }
    }
}

