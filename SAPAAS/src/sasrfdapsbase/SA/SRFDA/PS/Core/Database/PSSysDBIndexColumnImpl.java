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
import SA.SRFDA.PS.Core.Database.IPSDEDBIndexField;
import SA.SRFDA.PS.Core.Database.IPSSysDBColumn;
import SA.SRFDA.PS.Core.Database.IPSSysDBIndex;
import SA.SRFDA.PS.Core.Database.IPSSysDBIndexColumn;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelPFIgnoreMeta
public class PSSysDBIndexColumnImpl
extends PSObjectImpl
implements IPSSysDBIndexColumn {
    private static final Log log = LogFactory.getLog(PSSysDBIndexColumnImpl.class);
    private IPSSysDBIndex iPSSysDBIndex = null;
    private boolean bIncludeMode = false;
    private int nLength = -1;
    private String strSortDir = "";
    private IPSDEDBIndexField iPSDEDBIndexField = null;
    private IPSSysDBColumn iPSSysDBColumn = null;
    private IPSDEField iPSDEField = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSysDBIndex iPSSysDBIndex, Object object) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSSysDBIndex = iPSSysDBIndex;
            if (object instanceof IPSDEDBIndexField) {
                this.iPSDEDBIndexField = (IPSDEDBIndexField)object;
                this.setId(this.iPSDEDBIndexField.getId());
                this.setName(this.iPSDEDBIndexField.getName());
                this.bIncludeMode = this.iPSDEDBIndexField.isIncludeMode();
                this.strSortDir = this.iPSDEDBIndexField.getSortDir();
                this.nLength = this.iPSDEDBIndexField.getLength();
                this.iPSSysDBColumn = this.getPSSysDBIndex().getPSSysDBTable().getPSSysDBColumn(this.iPSDEDBIndexField.getPSDEField().getName(), true);
                this.setAutoModel(true);
            } else if (object instanceof IPSDEField) {
                this.iPSDEField = (IPSDEField)object;
                this.setId(this.iPSDEField.getId());
                this.setName(this.iPSDEField.getName());
                this.iPSSysDBColumn = this.getPSSysDBIndex().getPSSysDBTable().getPSSysDBColumn(this.iPSDEField.getName(), true);
                this.setAutoModel(true);
            } else if (object instanceof IPSSysDBColumn) {
                this.iPSSysDBColumn = (IPSSysDBColumn)object;
                this.setId(this.iPSSysDBColumn.getId());
                this.setName(this.iPSSysDBColumn.getName());
                this.setAutoModel(true);
            } else {
                throw new Exception("\u65e0\u6cd5\u8bc6\u522b\u7684\u4f20\u5165\u5bf9\u8c61");
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
    public IPSSysDBIndex getPSSysDBIndex() {
        return this.iPSSysDBIndex;
    }

    @Override
    @PSModelRTMeta(description="\u6392\u5e8f\u65b9\u5411", codelist="SortDir")
    public String getSortDir() {
        return this.strSortDir;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSSysDBIndex.getPSSysModelInstId();
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
        return "PSSYSDBINDEXCOLUMN";
    }

    @Override
    public String getFullModelName() {
        return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSSysDBIndex().getFullModelName(), (Object)this.getModelName());
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSSysDBIndex().getPSSysDBScheme().getPSSystem());
    }

    @Override
    public String getModelId() {
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSSysDBIndex().getModelId(), (Object)this.getId());
    }

    @Override
    protected IPSModelObject onGetParentModel() {
        return this.getPSSysDBIndex();
    }

    @Override
    @PSModelRTMeta(description="\u7d22\u5f15\u5217", dumpref=true, from="IPSSysDBTable")
    public IPSSysDBColumn getPSSysDBColumn() {
        return this.iPSSysDBColumn;
    }

    @Override
    protected String onGetRTMOSFilePath() {
        return null;
    }
}

