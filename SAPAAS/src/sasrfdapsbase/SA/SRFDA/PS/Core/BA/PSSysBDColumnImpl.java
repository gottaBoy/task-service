/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.core.IDEField
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.psba.core.IBAColSet
 *  net.ibizsys.psba.core.IBATableDE
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.BA;

import SA.SRFDA.PS.Core.BA.IPSSysBDColSet;
import SA.SRFDA.PS.Core.BA.IPSSysBDColumn;
import SA.SRFDA.PS.Core.BA.IPSSysBDTable;
import SA.SRFDA.PS.Core.BA.IPSSysBDTableDE;
import SA.SRFDA.PS.Core.BA.PSSysBDTableObjectImpl;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Data.PSSysBDColumn;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psba.core.IBAColSet;
import net.ibizsys.psba.core.IBATableDE;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysBDColumnImpl
extends PSSysBDTableObjectImpl
implements IPSSysBDColumn {
    private static final Log log = LogFactory.getLog(PSSysBDColumnImpl.class);
    private PSSysBDColumn psSysBDColumn = null;
    private IPSSysBDTableDE iPSSysBDTableDE = null;
    private IPSSysBDColSet iPSSysBDColSet = null;
    private IPSDEField iPSDEField = null;
    private String strCodeName = null;
    private String strUnionKeyValue = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSysBDTable iPSSysBDTable, PSSysBDColumn psSysBDColumn) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSysBDTable(iPSSysBDTable);
            this.psSysBDColumn = psSysBDColumn;
            this.setId(this.psSysBDColumn.getPSSYSBDCOLUMNID());
            this.setName(this.psSysBDColumn.getPSSYSBDCOLUMNNAME());
            this.setPSObjectData(this.psSysBDColumn);
            this.strUnionKeyValue = this.psSysBDColumn.getUNIONKEYVALUE();
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
        this.iPSSysBDTableDE = this.getPSSysBDTable().getPSSysBDTableDE(this.psSysBDColumn.getPSSYSBDTABLEDEID());
        this.iPSSysBDColSet = !StringHelper.isNullOrEmpty((String)this.psSysBDColumn.getPSSYSBDCOLSETID()) ? this.getPSSysBDTable().getPSSysBDColSet(this.psSysBDColumn.getPSSYSBDCOLSETID()) : this.getPSSysBDTable().getDefaultPSSysBDColSet();
        this.iPSDEField = this.getPSSysBDTableDE().getPSDataEntity().getPSDEField(this.psSysBDColumn.getPSDEFID());
        this.strCodeName = this.psSysBDColumn.getCODENAME();
        if (StringHelper.isNullOrEmpty((String)this.strCodeName)) {
            this.strCodeName = this.iPSDEField.getCodeName();
        }
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.strCodeName;
    }

    @Override
    public String getModelType() {
        return "PSSYSBDCOLUMN";
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u540d\u79f0")
    public String getLogicName() {
        if (StringHelper.isNullOrEmpty((String)this.psSysBDColumn.getLOGICNAME()) && this.getPSDEField() != null) {
            return this.getPSDEField().getLogicName();
        }
        return this.psSysBDColumn.getLOGICNAME();
    }

    @Override
    @PSModelRTMeta(description="\u5927\u6570\u636e\u8868\u5b9e\u4f53\u5bf9\u8c61")
    public IPSSysBDTableDE getPSSysBDTableDE() {
        return this.iPSSysBDTableDE;
    }

    @Override
    @PSModelRTMeta(description="\u5927\u6570\u636e\u8868\u5217\u65cf\u5bf9\u8c61")
    public IPSSysBDColSet getPSSysBDColSet() {
        return this.iPSSysBDColSet;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5c5e\u6027")
    public IPSDEField getPSDEField() {
        return this.iPSDEField;
    }

    public IDEField getDEField() {
        return this.getPSDEField();
    }

    public IBAColSet getBAColSet() {
        return this.getPSSysBDColSet();
    }

    public IBATableDE getBATableDE() {
        return this.getPSSysBDTableDE();
    }

    public String getDBValueFunc() {
        return this.getDEField().getDBValueFunc();
    }

    public String getDEFieldName() {
        return this.getDEField().getName();
    }

    public String getDEName() {
        return this.getBATableDE().getName();
    }

    public String getBAColSetName() {
        return this.getPSSysBDColSet().getName();
    }

    public String getPreDefinedType() {
        return this.getDEField().getPreDefinedType();
    }

    public boolean isEnableTempData() {
        return this.getDEField().isEnableTempData();
    }

    @Override
    @PSModelRTMeta(description="\u6807\u51c6\u6570\u636e\u7c7b\u578b", codelist="StdDataType")
    public int getStdDataType() {
        return this.getDEField().getStdDataType();
    }

    @Override
    @PSModelRTMeta(description="\u8054\u5408\u952e\u503c\u6a21\u5f0f", hideempty2=true)
    public String getUnionKeyValue() {
        return this.strUnionKeyValue;
    }

    public String getBATableDEId() {
        return this.psSysBDColumn.getPSSYSBDTABLEDEID();
    }

    @Override
    public String getModelId() {
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSSysBDTable().getModelId(), (Object)super.getModelId());
    }

    @Override
    @PSModelRTMeta(description="\u9884\u5b9a\u4e49\u7c7b\u578b", hideempty2=true)
    public String getPredefinedType() {
        return this.getPreDefinedType();
    }
}

