/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.ArrayNode
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.core.ISystem
 *  net.ibizsys.paas.service.ActionSessionManager
 *  net.ibizsys.paas.service.IServiceWork
 *  net.ibizsys.paas.service.ITransaction
 *  net.ibizsys.paas.service.ServiceWorkHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.UIAction;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUIActionGroup;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.PSDataEntityObjectImpl;
import SA.SRFDA.PS.Core.DataEntity.UIAction.IPSDEUIAction;
import SA.SRFDA.PS.Core.DataEntity.UIAction.IPSDEUIActionGroup;
import SA.SRFDA.PS.Core.DataEntity.UIAction.IPSDEUIActionGroupDetail;
import SA.SRFDA.PS.Core.DataEntity.UIAction.PSDEUIActionGroupDetailImpl;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.View.IPSUIAction;
import SA.SRFDA.PS.Core.View.IPSUIActionGroupDetail;
import SA.SRFDA.PS.Data.PSDEUIActionGroup;
import SA.SRFDA.PS.Data.PSDEUIActionGroupDetail;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import net.ibizsys.paas.core.ISystem;
import net.ibizsys.paas.service.ActionSessionManager;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceWorkHelper;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEUIActionGroupImpl
extends PSDataEntityObjectImpl
implements IPSDEUIActionGroup,
IPSAppDEUIActionGroup {
    private static final Log log = LogFactory.getLog(PSDEUIActionGroupImpl.class);
    protected PSDEUIActionGroup psDEUIActionGroup = null;
    protected ArrayList<IPSDEUIAction> psDEUIActionList = new ArrayList();
    protected ArrayList<IPSUIAction> psUIActionList = new ArrayList();
    protected ArrayList<IPSDEUIActionGroupDetail> psDEUIActionGroupDetailList = new ArrayList();
    protected ArrayList<IPSUIActionGroupDetail> psUIActionGroupDetailList = new ArrayList();
    private IPSSystem iPSSystem = null;
    private IPSAppDataEntity iPSAppDataEntity = null;
    private IPSApplication iPSApplication = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSApplication iPSApplication, IPSAppDataEntity iPSAppDataEntity, PSDEUIActionGroup psDEUIActionGroup) throws Exception {
        this.iPSAppDataEntity = iPSAppDataEntity;
        this.iPSApplication = iPSApplication;
        if (this.getPSAppDataEntity() != null) {
            this.init(iDAGlobalHelper, this.iPSApplication.getPSSystem(), this.iPSAppDataEntity.getPSDataEntity(), psDEUIActionGroup);
        } else {
            this.init(iDAGlobalHelper, this.iPSApplication.getPSSystem(), null, psDEUIActionGroup);
        }
    }

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem, IPSDataEntity iPSDataEntity, PSDEUIActionGroup psDEUIActionGroup) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSDataEntity(iPSDataEntity);
            this.iPSSystem = iPSSystem;
            if (this.iPSDataEntity != null) {
                this.iPSSystem = this.iPSDataEntity.getPSSystem();
            }
            this.psDEUIActionGroup = psDEUIActionGroup;
            this.setId(this.psDEUIActionGroup.getPSDEUAGROUPID());
            this.setName(this.psDEUIActionGroup.getPSDEUAGROUPNAME());
            this.setPSObjectData(this.psDEUIActionGroup);
            ServiceWorkHelper.getInstance().execute(new IServiceWork(){

                public void execute(ITransaction iTransaction) throws Exception {
                    if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)PSDEUIActionGroupImpl.this.getModelType()) && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)PSDEUIActionGroupImpl.this.getId())) {
                        if (!ActionSessionManager.getCurrentSession().registerRecursion(PSDEUIActionGroupImpl.this.getModelType(), (Object)PSDEUIActionGroupImpl.this.getId())) {
                            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u5b58\u5728\u9012\u5f52\u5f15\u7528"));
                        }
                        try {
                            PSDEUIActionGroupImpl.this.onInit();
                            ActionSessionManager.getCurrentSession().unregisterRecursion(PSDEUIActionGroupImpl.this.getModelType(), (Object)PSDEUIActionGroupImpl.this.getId());
                        }
                        catch (Exception ex) {
                            ActionSessionManager.getCurrentSession().unregisterRecursion(PSDEUIActionGroupImpl.this.getModelType(), (Object)PSDEUIActionGroupImpl.this.getId());
                            throw ex;
                        }
                    } else {
                        PSDEUIActionGroupImpl.this.onInit();
                    }
                }
            });
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
        this.onPreparePSDEUIActions();
    }

    protected void onPreparePSDEUIActions() throws Exception {
        this.psDEUIActionList.clear();
        this.psUIActionList.clear();
        this.psDEUIActionGroupDetailList.clear();
        this.psUIActionGroupDetailList.clear();
        Vector<PSDEUIActionGroupDetail> psDEUIActionGroupDetailList = new Vector<PSDEUIActionGroupDetail>();
        CallResult callResult = this.getPSModelHelper().getPSDEUIActionGroupDetails(this.getId(), psDEUIActionGroupDetailList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u754c\u9762\u884c\u4e3a\u7ec4\u6210\u5458\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        int nIndex = 0;
        for (PSDEUIActionGroupDetail psDEUIActionGroupDetail : psDEUIActionGroupDetailList) {
            ++nIndex;
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psDEUIActionGroupDetail.getPSDEUAGRPDETAILNAME())) {
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psDEUIActionGroupDetail.getCODENAME())) {
                    psDEUIActionGroupDetail.setPSDEUAGRPDETAILNAME(psDEUIActionGroupDetail.getCODENAME().toLowerCase());
                } else if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getPSSystem().getPSDynaInstId())) {
                    psDEUIActionGroupDetail.setPSDEUAGRPDETAILNAME("u" + KeyValueHelper.genUniqueId((String)String.format("0__%1$s__%2$s", this.getId(), nIndex)).substring(0, 7));
                } else {
                    psDEUIActionGroupDetail.setPSDEUAGRPDETAILNAME("u" + KeyValueHelper.genUniqueId((String)psDEUIActionGroupDetail.getPSDEUAGRPDETAILID()).substring(0, 7));
                }
            }
            if (!psDEUIActionGroupDetail.isVALIDFLAGNull() && !psDEUIActionGroupDetail.getVALIDFLAG()) continue;
            PSDEUIActionGroupDetailImpl iPSDEUIActionGroupDetail = new PSDEUIActionGroupDetailImpl();
            iPSDEUIActionGroupDetail.init(this.getDAGlobalHelper(), this, psDEUIActionGroupDetail);
            this.psDEUIActionGroupDetailList.add(iPSDEUIActionGroupDetail);
            if (iPSDEUIActionGroupDetail.getPSDEUIAction() == null) continue;
            this.psDEUIActionList.add(iPSDEUIActionGroupDetail.getPSDEUIAction());
        }
        this.psUIActionGroupDetailList.addAll(this.psDEUIActionGroupDetailList);
        this.psUIActionList.addAll(this.psDEUIActionList);
    }

    @Override
    public Iterator<IPSDEUIAction> getPSDEUIActions() {
        if (this.psDEUIActionList == null || this.psDEUIActionList.size() == 0) {
            return null;
        }
        return this.psDEUIActionList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u754c\u9762\u884c\u4e3a\u5bf9\u8c61\u96c6\u5408", outputdoc="false")
    public Iterator<IPSUIAction> getPSUIActions() {
        if (this.psUIActionList == null || this.psUIActionList.size() == 0) {
            return null;
        }
        return this.psUIActionList.iterator();
    }

    @Override
    public IPSSystem getPSSystem() {
        return this.iPSSystem;
    }

    public ISystem getSystem() {
        return this.getPSSystem();
    }

    @Override
    public String getPSSysModelInstId() {
        if (this.iPSSystem != null) {
            return this.iPSSystem.getPSSysModelInstId();
        }
        return super.getPSSysModelInstId();
    }

    @Override
    public Iterator<IPSDEUIActionGroupDetail> getPSDEUIActionGroupDetails() {
        if (this.psDEUIActionGroupDetailList == null || this.psDEUIActionGroupDetailList.size() == 0) {
            return null;
        }
        return this.psDEUIActionGroupDetailList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u7ec4\u6210\u5458\u5bf9\u8c61\u96c6\u5408", child=true, group="\u57fa\u672c", order=140)
    public Iterator<IPSUIActionGroupDetail> getPSUIActionGroupDetails() {
        if (this.psUIActionGroupDetailList == null || this.psUIActionGroupDetailList.size() == 0) {
            return null;
        }
        return this.psUIActionGroupDetailList.iterator();
    }

    @Override
    public String getModelType() {
        if (this.getPSAppDataEntity() != null) {
            return "PSAPPDEUAGROUP";
        }
        if (this.getPSApplication() != null) {
            return "PSSYSAPPDEUAGROUP";
        }
        return "PSDEUAGROUP";
    }

    @Override
    public String getModelId() {
        if (this.getPSAppDataEntity() != null) {
            return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s#%2$s", (Object)this.getPSAppDataEntity().getModelId(), (Object)super.getModelId());
        }
        if (this.getPSApplication() != null) {
            return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s#%2$s", (Object)this.getPSApplication().getModelId(), (Object)super.getModelId());
        }
        return super.getModelId();
    }

    @Override
    public String getFullModelName() {
        if (this.getPSAppDataEntity() != null) {
            return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSAppDataEntity().getFullModelName(), (Object)this.getModelName());
        }
        if (this.getPSApplication() != null) {
            return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSApplication().getFullModelName(), (Object)this.getModelName());
        }
        return super.getFullModelName();
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53", hideempty=true, dumpref=true, fields={"PSDEID"})
    public IPSAppDataEntity getPSAppDataEntity() {
        return this.iPSAppDataEntity;
    }

    @Override
    @PSModelRTMeta(description="\u524d\u7aef\u5e94\u7528", hideempty=true, outputdoc="false")
    public IPSApplication getPSApplication() {
        return this.iPSApplication;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.onGetCodeName();
    }

    protected String onGetCodeName() {
        return this.psDEUIActionGroup.getCODENAME();
    }

    @Override
    @PSModelRTMeta(description="\u7ec4\u6807\u8bb0", fields={"UAGTAG"})
    public String getGroupTag() {
        return this.psDEUIActionGroup.getUAGTAG();
    }

    @Override
    @PSModelRTMeta(description="\u7ec4\u6807\u8bb02", fields={"UAGTAG2"})
    public String getGroupTag2() {
        return this.psDEUIActionGroup.getUAGTAG2();
    }

    @Override
    @PSModelRTMeta(description="\u7ec4\u6807\u8bb03", fields={"UAGTAG3"})
    public String getGroupTag3() {
        return this.psDEUIActionGroup.getUAGTAG3();
    }

    @Override
    @PSModelRTMeta(description="\u7ec4\u6807\u8bb04", fields={"UAGTAG4"})
    public String getGroupTag4() {
        return this.psDEUIActionGroup.getUAGTAG4();
    }

    @Override
    protected void onFillModelRefNode(ObjectNode objectNode, String strModelRefType) throws Exception {
        if (this.getPSAppDataEntity() != null) {
            objectNode.put("getPSAppDataEntity", (JsonNode)this.getPSAppDataEntity().getModelRef());
        }
        super.onFillModelRefNode(objectNode, strModelRefType);
    }

    @Override
    public boolean isEnableDynaModel() {
        if (this.getPSApplication() != null) {
            return false;
        }
        return super.isEnableDynaModel();
    }

    @Override
    protected IPSModelObject onGetParentModel() {
        if (this.getPSAppDataEntity() != null) {
            return this.getPSAppDataEntity();
        }
        if (this.getPSApplication() != null) {
            return this.getPSApplication();
        }
        return super.onGetParentModel();
    }

    @Override
    public int getOrderValue() {
        return 99999;
    }

    @Override
    @PSModelRTMeta(description="\u552f\u4e00\u6807\u8bb0")
    public String getUniqueTag() {
        if (this.getPSAppDataEntity() != null && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getCodeName())) {
            return String.format("%1$s__%2$s", this.getPSAppDataEntity().getCodeName(), this.getCodeName());
        }
        return null;
    }

    @Override
    protected void onFillModelNode(ObjectNode objectNode, String strModelType) throws Exception {
        Iterator<IPSUIActionGroupDetail> psUIActionGroupDetails;
        super.onFillModelNode(objectNode, strModelType);
        if (("APPLICATION".equals(strModelType) || "APPDATAENTITY".equals(strModelType)) && (psUIActionGroupDetails = this.getPSUIActionGroupDetails()) != null) {
            objectNode.remove("getPSUIActionGroupDetails");
            ArrayNode arrayNode = objectNode.putArray("getPSUIActionGroupDetails");
            while (psUIActionGroupDetails.hasNext()) {
                IPSUIActionGroupDetail iPSUIActionGroupDetail = psUIActionGroupDetails.next();
                arrayNode.add((JsonNode)iPSUIActionGroupDetail.toModel(strModelType));
            }
        }
    }
}

