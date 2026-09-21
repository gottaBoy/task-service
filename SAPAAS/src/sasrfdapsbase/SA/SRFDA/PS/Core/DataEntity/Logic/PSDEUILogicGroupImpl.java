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
package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUILogicGroup;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUILogicGroupDetail;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEUILogicGroup;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEUILogicGroupDetail;
import SA.SRFDA.PS.Core.DataEntity.Logic.PSDEUILogicGroupDetailImpl;
import SA.SRFDA.PS.Core.DataEntity.PSDataEntityObjectImpl;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Data.PSCtrlLogicGroup;
import SA.SRFDA.PS.Data.PSCtrlLogicGroupDetail;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelPFIgnoreMeta
public class PSDEUILogicGroupImpl
extends PSDataEntityObjectImpl
implements IPSDEUILogicGroup,
IPSAppDEUILogicGroup {
    private static final Log log = LogFactory.getLog(PSDEUILogicGroupImpl.class);
    protected PSCtrlLogicGroup psCtrlLogicGroup = null;
    protected ArrayList<PSDEUILogicGroupDetailImpl> psDEUILogicGroupDetailList = new ArrayList();
    private String strCodeName = "";
    private IPSAppDataEntity iPSAppDataEntity = null;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSAppDataEntity iPSAppDataEntity, PSCtrlLogicGroup psCtrlLogicGroup) throws Exception {
        this.iPSAppDataEntity = iPSAppDataEntity;
        this.init(iDAGlobalHelper, iPSAppDataEntity.getPSDataEntity(), psCtrlLogicGroup);
    }

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDataEntity iPSDataEntity, PSCtrlLogicGroup psCtrlLogicGroup) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSDataEntity(iPSDataEntity);
            this.psCtrlLogicGroup = psCtrlLogicGroup;
            this.setId(this.psCtrlLogicGroup.getPSCTRLLOGICGROUPID());
            this.setName(this.psCtrlLogicGroup.getPSCTRLLOGICGROUPNAME());
            this.setPSObjectData(this.psCtrlLogicGroup);
            this.strCodeName = this.psCtrlLogicGroup.getCODENAME();
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
        this.onPreparePSDEUILogicGroupDetails();
    }

    protected void onPreparePSDEUILogicGroupDetails() throws Exception {
        this.psDEUILogicGroupDetailList.clear();
        Vector<PSCtrlLogicGroupDetail> psDEUILogicGroupDetailList = new Vector<PSCtrlLogicGroupDetail>();
        CallResult callResult = this.getPSModelHelper().getPSCtrlLogicGroupDetails(this.getId(), psDEUILogicGroupDetailList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u754c\u9762\u903b\u8f91\u7ec4\u6210\u5458\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSCtrlLogicGroupDetail psCtrlLogicGroupDetail : psDEUILogicGroupDetailList) {
            if (!psCtrlLogicGroupDetail.isVALIDFLAGNull() && !psCtrlLogicGroupDetail.getVALIDFLAG()) continue;
            PSDEUILogicGroupDetailImpl iPSCtrlLogicGroupDetail = new PSDEUILogicGroupDetailImpl();
            iPSCtrlLogicGroupDetail.init(this.getDAGlobalHelper(), this, psCtrlLogicGroupDetail);
            this.psDEUILogicGroupDetailList.add(iPSCtrlLogicGroupDetail);
        }
    }

    @Override
    public Iterator<? extends IPSDEUILogicGroupDetail> getPSDEUILogicGroupDetails() {
        if (this.psDEUILogicGroupDetailList == null || this.psDEUILogicGroupDetailList.size() == 0) {
            return null;
        }
        return this.psDEUILogicGroupDetailList.iterator();
    }

    @Override
    public String getModelType() {
        return "PSCTRLLOGICGROUP";
    }

    @Override
    public String getModelId() {
        if (this.getPSAppDataEntity() != null) {
            return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s#%2$s", (Object)this.getPSAppDataEntity().getModelId(), (Object)super.getModelId());
        }
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
    @PSModelRTMeta(description="\u7cfb\u7edf\u6a21\u5757", outputdoc="false")
    public IPSSystemModule getPSSystemModule() {
        return this.getPSDataEntity().getPSSystemModule();
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u5bf9\u8c61", hideempty=true, outputdoc="false")
    public IPSAppDataEntity getPSAppDataEntity() {
        return this.iPSAppDataEntity;
    }

    @Override
    public IPSApplication getPSApplication() {
        if (this.getPSAppDataEntity() != null) {
            return this.getPSAppDataEntity().getPSApplication();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u7ec4\u6210\u5458\u96c6\u5408", child=true, group="\u57fa\u672c", order=130)
    public Iterator<? extends IPSAppDEUILogicGroupDetail> getPSAppDEUILogicGroupDetails() {
        if (this.psDEUILogicGroupDetailList == null || this.psDEUILogicGroupDetailList.size() == 0) {
            return null;
        }
        return this.psDEUILogicGroupDetailList.iterator();
    }

    @Override
    public String getParentPSDEUILogicGroupId() {
        return this.psCtrlLogicGroup.getPPSCTRLLOGICGROUPID();
    }
}

