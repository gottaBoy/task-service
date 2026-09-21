/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.psba.core.IBAColumn
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.BA;

import SA.SRFDA.PS.Core.BA.IPSBDColumn;
import SA.SRFDA.PS.Core.BA.IPSSysBDColSet;
import SA.SRFDA.PS.Core.BA.IPSSysBDColumn;
import SA.SRFDA.PS.Core.BA.IPSSysBDTable;
import SA.SRFDA.PS.Core.BA.PSSysBDTableObjectImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Data.PSSysBDColSet;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.psba.core.IBAColumn;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysBDColSetImpl
extends PSSysBDTableObjectImpl
implements IPSSysBDColSet {
    private static final Log log = LogFactory.getLog(PSSysBDColSetImpl.class);
    protected PSSysBDColSet psSysBDColSet = null;
    private boolean bDefaultFlag = false;
    private ArrayList<IPSSysBDColumn> psSysBDColumnList = null;
    private ArrayList<IBAColumn> baColumnList = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSysBDTable iPSSysBDTable, PSSysBDColSet psSysBDColSet) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSysBDTable(iPSSysBDTable);
            this.psSysBDColSet = psSysBDColSet;
            this.setId(this.psSysBDColSet.getPSSYSBDCOLSETID());
            this.setName(this.psSysBDColSet.getPSSYSBDCOLSETNAME());
            this.setPSObjectData(this.psSysBDColSet);
            if (!this.psSysBDColSet.isDEFAULTFLAGNull()) {
                this.bDefaultFlag = this.psSysBDColSet.getDEFAULTFLAG();
            }
            this.onInit();
        }
        catch (Exception ex) {
            String strLogName = net.ibizsys.paas.util.StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = net.ibizsys.paas.util.StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)net.ibizsys.paas.util.StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            if (this.getPSSystemUtil() != null) {
                this.getPSSystemUtil().getPSSysConsole().error(strLogName, strExInfo);
            }
            this.throwInitException(ex);
        }
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.psSysBDColSet.getCODENAME();
    }

    @Override
    public String getModelType() {
        return "PSSYSBDCOLSET";
    }

    @Override
    public String getModelId() {
        return StringHelper.Format((String)"%1$s#%2$s", (Object)this.getPSSysBDTable().getModelId(), (Object)super.getModelId());
    }

    @Override
    public String getFullModelName() {
        return StringHelper.Format((String)"%1$s|%2$s", (Object)this.getPSSysBDTable().getFullModelName(), (Object)super.getFullModelName());
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u540d\u79f0")
    public String getLogicName() {
        return this.psSysBDColSet.getLOGICNAME();
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u5217\u65cf")
    public boolean isDefault() {
        return this.bDefaultFlag;
    }

    public Iterator<IBAColumn> getBAColumns() {
        this.preparePSSysBDColumns();
        return this.baColumnList.iterator();
    }

    public IBAColumn getBAColumn(String strBAColumnName) throws Exception {
        return this.getPSSysBDTable().getBAColumn(strBAColumnName);
    }

    @Override
    @PSModelRTMeta(description="\u5927\u6570\u636e\u5217\u96c6\u5408", dumpref=true, from="IPSSysBDTable")
    public Iterator<? extends IPSSysBDColumn> getAllPSSysBDColumns() {
        this.preparePSSysBDColumns();
        return this.psSysBDColumnList.iterator();
    }

    protected synchronized void preparePSSysBDColumns() {
        try {
            if (this.psSysBDColumnList == null) {
                this.psSysBDColumnList = new ArrayList();
                this.baColumnList = new ArrayList();
                Iterator<? extends IPSSysBDColumn> psSysBDColumns = this.getPSSysBDTable().getAllPSSysBDColumns();
                while (psSysBDColumns.hasNext()) {
                    IPSSysBDColumn iPSSysBDColumn = psSysBDColumns.next();
                    if (StringHelper.Compare((String)this.getId(), (String)iPSSysBDColumn.getPSSysBDColSet().getId(), (boolean)false) != 0) continue;
                    this.psSysBDColumnList.add(iPSSysBDColumn);
                }
                this.baColumnList.addAll(this.psSysBDColumnList);
            }
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
    }

    @Override
    public Iterator<? extends IPSBDColumn> getAllPSBDColumns() {
        return this.getAllPSSysBDColumns();
    }
}

