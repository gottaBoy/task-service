/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Database;

import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.Database.IPSDEDBIndex;
import SA.SRFDA.PS.Core.Database.IPSDEDBIndexField;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSDEDBIndexField;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelPFIgnoreMeta
public class PSDEDBIndexFieldImpl
extends PSObjectImpl
implements IPSDEDBIndexField {
    private static final Log log = LogFactory.getLog(PSDEDBIndexFieldImpl.class);
    private IPSDEDBIndex iPSDEDBIndex = null;
    private PSDEDBIndexField psDEDBIndexField = null;
    private IPSDEField iPSDEField = null;
    private boolean bIncludeMode = false;
    private int nLength = -1;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEDBIndex iPSDEDBIndex, PSDEDBIndexField psDEDBIndexField) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSDEDBIndex = iPSDEDBIndex;
            this.psDEDBIndexField = psDEDBIndexField;
            this.setId(this.psDEDBIndexField.getPSDEDBIDXFIELDID());
            this.setName(this.psDEDBIndexField.getPSDEDBIDXFIELDNAME());
            this.setPSObjectData(this.psDEDBIndexField);
            this.iPSDEField = this.iPSDEDBIndex.getPSDataEntity().getPSDEField(this.psDEDBIndexField.getPSDEFID());
            if (!this.psDEDBIndexField.isINCMODENull()) {
                this.bIncludeMode = this.psDEDBIndexField.getINCMODE();
            }
            if (!this.psDEDBIndexField.isINDEXLENGTHNull()) {
                this.nLength = this.psDEDBIndexField.getINDEXLENGTH();
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
    public IPSDEDBIndex getPSDEDBIndex() {
        return this.iPSDEDBIndex;
    }

    @Override
    @PSModelRTMeta(description="\u7d22\u5f15\u5c5e\u6027", dumpref=true, from="IPSDataEntity")
    public IPSDEField getPSDEField() {
        return this.iPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u6392\u5e8f\u65b9\u5411", codelist="SortDir")
    public String getSortDir() {
        return this.psDEDBIndexField.getSORTDIR();
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSDEDBIndex.getPSSysModelInstId();
    }

    @Override
    @PSModelRTMeta(description="\u7d22\u5f15\u6570\u636e\u9644\u52a0", ignoredumpvalues="false")
    public boolean isIncludeMode() {
        return this.bIncludeMode;
    }

    @Override
    @PSModelRTMeta(description="\u7d22\u5f15\u957f\u5ea6", ignoredumpvalues="-1")
    public int getLength() {
        return this.nLength;
    }

    @Override
    public String getModelType() {
        return "PSDEDBIDXFIELD";
    }

    @Override
    public String getFullModelName() {
        return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSDEDBIndex().getFullModelName(), (Object)this.getModelName());
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSDEDBIndex().getPSDataEntity().getPSSystem());
    }

    @Override
    public String getModelId() {
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSDEDBIndex().getModelId(), (Object)this.getId());
    }

    @Override
    protected IPSModelObject onGetParentModel() {
        return this.getPSDEDBIndex();
    }
}

