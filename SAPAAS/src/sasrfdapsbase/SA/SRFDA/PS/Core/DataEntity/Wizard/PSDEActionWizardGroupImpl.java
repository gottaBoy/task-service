/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.core.IDEActionWizard
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.view.IViewWizard
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.Wizard;

import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.PSDataEntityObjectImpl;
import SA.SRFDA.PS.Core.DataEntity.Wizard.IPSDEActionWizardGroup;
import SA.SRFDA.PS.Core.DataEntity.Wizard.IPSDEActionWizardGroupDetail;
import SA.SRFDA.PS.Core.DataEntity.Wizard.IPSDEDataSetDEAW;
import SA.SRFDA.PS.Core.DataEntity.Wizard.PSDEActionWizardGroupDetailImpl;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Data.PSDEAWGroup;
import SA.SRFDA.PS.Data.PSDEAWGrpDetail;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import net.ibizsys.paas.core.IDEActionWizard;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.view.IViewWizard;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelIgnoreMeta
public class PSDEActionWizardGroupImpl
extends PSDataEntityObjectImpl
implements IPSDEActionWizardGroup {
    private static final Log log = LogFactory.getLog(PSDEActionWizardGroupImpl.class);
    protected PSDEAWGroup psDEAWGroup = null;
    protected ArrayList<IPSDEActionWizardGroupDetail> psDEAWGroupDetailList = new ArrayList();

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDataEntity iPSDataEntity, PSDEAWGroup psDEAWGroup) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSDataEntity(iPSDataEntity);
            this.psDEAWGroup = psDEAWGroup;
            this.setId(this.psDEAWGroup.getPSDEAWGROUPID());
            this.setName(this.psDEAWGroup.getPSDEAWGROUPNAME());
            this.setPSObjectData(this.psDEAWGroup);
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
        this.onPreparePSDEActionWizards();
    }

    protected void onPreparePSDEActionWizards() throws Exception {
        this.psDEAWGroupDetailList.clear();
        Vector<PSDEAWGrpDetail> psDEAWGroupDetailList = new Vector<PSDEAWGrpDetail>();
        CallResult callResult = this.getPSModelHelper().getPSDEActionWizardGroupDetails(this.getId(), psDEAWGroupDetailList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u64cd\u4f5c\u5411\u5bfc\u7ec4\u6210\u5458\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSDEAWGrpDetail psDEAWGroupDetail : psDEAWGroupDetailList) {
            PSDEActionWizardGroupDetailImpl iPSDEActionWizardGroupDetail = new PSDEActionWizardGroupDetailImpl();
            iPSDEActionWizardGroupDetail.init(this.getDAGlobalHelper(), this, psDEAWGroupDetail);
            this.psDEAWGroupDetailList.add(iPSDEActionWizardGroupDetail);
        }
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u64cd\u4f5c\u5411\u5bfc\u7ec4\u6210\u5458\u5bf9\u8c61\u96c6\u5408")
    public Iterator<IPSDEActionWizardGroupDetail> getPSDEActionWizardGroupDetails() {
        if (this.psDEAWGroupDetailList == null || this.psDEAWGroupDetailList.size() == 0) {
            return null;
        }
        return this.psDEAWGroupDetailList.iterator();
    }

    @Override
    public String getModelType() {
        return "PSDEAWGROUP";
    }

    public Iterator<IViewWizard> getViewWizards() {
        return null;
    }

    public Iterator<IDEActionWizard> getDEActionWizards() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u7528\u6237\u6807\u8bb0")
    public String getUserTag() {
        try {
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEAWGroup.getUSERTAG())) {
                for (IPSDEActionWizardGroupDetail iPSDEActionWizardGroupDetail : this.psDEAWGroupDetailList) {
                    if (!(iPSDEActionWizardGroupDetail.getPSDEActionWizard() instanceof IPSDEDataSetDEAW) || SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)iPSDEActionWizardGroupDetail.getPSDEActionWizard().getUserTag())) continue;
                    return iPSDEActionWizardGroupDetail.getPSDEActionWizard().getUserTag();
                }
            }
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
        return this.psDEAWGroup.getUSERTAG();
    }

    @Override
    @PSModelRTMeta(description="\u7528\u6237\u6807\u8bb02")
    public String getUserTag2() {
        return this.psDEAWGroup.getUSERTAG2();
    }
}

