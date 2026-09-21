/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.Action;

import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEActionGroup;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEActionGroupDetail;
import SA.SRFDA.PS.Core.DataEntity.Action.PSDEActionGroupDetailImpl;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.PSDataEntityObjectImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Data.PSDEAGDetail;
import SA.SRFDA.PS.Data.PSDEActionGroup;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEActionGroupImpl
extends PSDataEntityObjectImpl
implements IPSDEActionGroup {
    private static final Log log = LogFactory.getLog(PSDEActionGroupImpl.class);
    private PSDEActionGroup psDEActionGroup = null;
    private ArrayList<IPSDEAction> psDEActionList = new ArrayList();
    private ArrayList<IPSDEDataSet> psDEDataSetList = new ArrayList();
    private ArrayList<IPSDEActionGroupDetail> psDEActionGroupDetailList = new ArrayList();
    private String strCodeName = "";

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDataEntity iPSDataEntity, PSDEActionGroup psDEActionGroup) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSDataEntity(iPSDataEntity);
            this.psDEActionGroup = psDEActionGroup;
            this.setId(this.psDEActionGroup.getPSDEACTIONGROUPID());
            this.setName(this.psDEActionGroup.getPSDEACTIONGROUPNAME());
            this.setPSObjectData(this.psDEActionGroup);
            this.strCodeName = this.psDEActionGroup.getCODENAME();
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
        this.onPreparePSDEActions();
    }

    protected void onPreparePSDEActions() throws Exception {
        this.psDEActionList.clear();
        this.psDEDataSetList.clear();
        this.psDEActionGroupDetailList.clear();
        Vector<PSDEAGDetail> psDEActionGroupDetailList = new Vector<PSDEAGDetail>();
        CallResult callResult = this.getPSModelHelper().getPSDEActionGroupDetails(this.getId(), psDEActionGroupDetailList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u884c\u4e3a\u7ec4\u6210\u5458\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSDEAGDetail psDEActionGroupDetail : psDEActionGroupDetailList) {
            if (!psDEActionGroupDetail.isVALIDFLAGNull() && !psDEActionGroupDetail.getVALIDFLAG()) continue;
            PSDEActionGroupDetailImpl iPSDEActionGroupDetail = new PSDEActionGroupDetailImpl();
            iPSDEActionGroupDetail.init(this.getDAGlobalHelper(), this, psDEActionGroupDetail);
            this.psDEActionGroupDetailList.add(iPSDEActionGroupDetail);
            if (SA.SRFramework.Utility.StringHelper.Compare((String)iPSDEActionGroupDetail.getDetailType(), (String)"DEACTION", (boolean)false) == 0) {
                if (iPSDEActionGroupDetail.getPSDEAction() == null) continue;
                this.psDEActionList.add(iPSDEActionGroupDetail.getPSDEAction());
                continue;
            }
            if (SA.SRFramework.Utility.StringHelper.Compare((String)iPSDEActionGroupDetail.getDetailType(), (String)"DEDATASET", (boolean)false) != 0 || iPSDEActionGroupDetail.getPSDEDataSet() == null) continue;
            this.psDEDataSetList.add(iPSDEActionGroupDetail.getPSDEDataSet());
        }
    }

    @Override
    @PSModelRTMeta(description="\u884c\u4e3a\u96c6\u5408")
    public Iterator<IPSDEAction> getPSDEActions() {
        if (this.psDEActionList == null || this.psDEActionList.size() == 0) {
            return null;
        }
        return this.psDEActionList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u96c6\u96c6\u5408")
    public Iterator<IPSDEDataSet> getPSDEDataSets() {
        if (this.psDEDataSetList == null || this.psDEDataSetList.size() == 0) {
            return null;
        }
        return this.psDEDataSetList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u884c\u4e3a\u7ec4\u6210\u5458\u96c6\u5408", child=true)
    public Iterator<IPSDEActionGroupDetail> getPSDEActionGroupDetails() {
        if (this.psDEActionGroupDetailList == null || this.psDEActionGroupDetailList.size() == 0) {
            return null;
        }
        return this.psDEActionGroupDetailList.iterator();
    }

    @Override
    public String getModelType() {
        return "PSDEACTIONGROUP";
    }

    @Override
    public String getModelId() {
        return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s#%2$s", (Object)this.getPSDataEntity().getModelId(), (Object)super.getModelId());
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.onGetCodeName();
    }

    protected String onGetCodeName() {
        return this.strCodeName;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u540d\u79f02", hideempty2=true)
    public String getCodeName2() {
        return this.psDEActionGroup.getCODENAME2();
    }

    @Override
    public boolean contains(IPSDEAction iPSDEAction) {
        if (iPSDEAction == null) {
            return false;
        }
        if (this.psDEActionList == null || this.psDEActionList.size() == 0) {
            return false;
        }
        for (IPSDEAction iPSDEAction2 : this.psDEActionList) {
            if (SA.SRFramework.Utility.StringHelper.Compare((String)iPSDEAction2.getId(), (String)iPSDEAction.getId(), (boolean)false) != 0) continue;
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(IPSDEDataSet iPSDEDataSet) {
        if (iPSDEDataSet == null) {
            return false;
        }
        if (this.psDEDataSetList == null || this.psDEDataSetList.size() == 0) {
            return false;
        }
        for (IPSDEDataSet iPSDEDataSet2 : this.psDEDataSetList) {
            if (SA.SRFramework.Utility.StringHelper.Compare((String)iPSDEDataSet2.getId(), (String)iPSDEDataSet.getId(), (boolean)false) != 0) continue;
            return true;
        }
        return false;
    }

    @Override
    @PSModelRTMeta(description="\u5206\u7ec4\u6807\u8bb0", fields={"GROUPTAG"})
    public String getGroupTag() {
        return this.psDEActionGroup.getGROUPTAG();
    }

    @Override
    @PSModelRTMeta(description="\u5206\u7ec4\u6807\u8bb02", fields={"GROUPTAG2"})
    public String getGroupTag2() {
        return this.psDEActionGroup.getGROUPTAG2();
    }
}

