/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.WF.UIAction;

import SA.SRFDA.PS.Core.App.WF.IPSAppWF;
import SA.SRFDA.PS.Core.App.WF.IPSAppWFUIActionGroup;
import SA.SRFDA.PS.Core.App.WF.IPSAppWFVer;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.View.IPSUIAction;
import SA.SRFDA.PS.Core.View.IPSUIActionGroupDetail;
import SA.SRFDA.PS.Core.WF.IPSWFVersion;
import SA.SRFDA.PS.Core.WF.IPSWorkflow;
import SA.SRFDA.PS.Core.WF.UIAction.IPSWFUIAction;
import SA.SRFDA.PS.Core.WF.UIAction.IPSWFUIActionGroup;
import SA.SRFDA.PS.Core.WF.UIAction.IPSWFUIActionGroupDetail;
import SA.SRFDA.PS.Core.WF.UIAction.PSWFUIActionGroupDetailImpl;
import SA.SRFDA.PS.Data.PSDEUIActionGroup;
import SA.SRFDA.PS.Data.PSDEUIActionGroupDetail;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSWFUIActionGroupImpl
extends PSObjectImpl
implements IPSWFUIActionGroup,
IPSAppWFUIActionGroup {
    private static final Log log = LogFactory.getLog(PSWFUIActionGroupImpl.class);
    protected IPSWFVersion iPSWFVersion = null;
    protected IPSWorkflow iPSWorkflow = null;
    protected PSDEUIActionGroup psDEUIActionGroup = null;
    protected ArrayList<IPSWFUIAction> psDEUIActionList = new ArrayList();
    protected ArrayList<IPSUIAction> psUIActionList = new ArrayList();
    protected ArrayList<IPSWFUIActionGroupDetail> psWFUIActionGroupDetailList = new ArrayList();
    protected ArrayList<IPSUIActionGroupDetail> psUIActionGroupDetailList = new ArrayList();
    private IPSAppWF iPSAppWF = null;
    private IPSAppWFVer iPSAppWFVer = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSAppWF iPSAppWF, IPSAppWFVer iPSAppWFVer, PSDEUIActionGroup psDEUIActionGroup) throws Exception {
        this.iPSAppWF = iPSAppWF;
        this.iPSAppWFVer = iPSAppWFVer;
        if (this.getPSAppWFVer() != null) {
            this.init(iDAGlobalHelper, this.getPSAppWF().getPSWorkflow(), this.getPSAppWFVer().getPSWFVersion(), psDEUIActionGroup);
        } else {
            this.init(iDAGlobalHelper, this.getPSAppWF().getPSWorkflow(), null, psDEUIActionGroup);
        }
    }

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSWorkflow iPSWorkflow, IPSWFVersion iPSWFVersion, PSDEUIActionGroup psDEUIActionGroup) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.psDEUIActionGroup = psDEUIActionGroup;
            this.iPSWorkflow = iPSWorkflow;
            this.iPSWFVersion = iPSWFVersion;
            if (this.iPSWorkflow == null || this.iPSWFVersion != null) {
                this.iPSWorkflow = this.iPSWFVersion.getPSWorkflow();
            }
            this.setId(this.psDEUIActionGroup.getPSDEUAGROUPID());
            this.setName(this.psDEUIActionGroup.getPSDEUAGROUPNAME());
            this.setPSObjectData(this.psDEUIActionGroup);
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
        this.onPreparePSWFUIActions();
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5de5\u4f5c\u6d41", hideempty=true)
    public IPSAppWF getPSAppWF() {
        return this.iPSAppWF;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5de5\u4f5c\u6d41\u7248\u672c", hideempty=true)
    public IPSAppWFVer getPSAppWFVer() {
        return this.iPSAppWFVer;
    }

    protected void onPreparePSWFUIActions() throws Exception {
        this.psDEUIActionList.clear();
        this.psUIActionList.clear();
        this.psWFUIActionGroupDetailList.clear();
        this.psUIActionGroupDetailList.clear();
        Vector<PSDEUIActionGroupDetail> psDEUIActionGroupDetailList = new Vector<PSDEUIActionGroupDetail>();
        CallResult callResult = this.getPSModelHelper().getPSDEUIActionGroupDetails(this.getId(), psDEUIActionGroupDetailList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u6d41\u7a0b\u754c\u9762\u884c\u4e3a\u7ec4\u6210\u5458\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        int nIndex = 0;
        for (PSDEUIActionGroupDetail psDEUIActionGroupDetail : psDEUIActionGroupDetailList) {
            ++nIndex;
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psDEUIActionGroupDetail.getPSDEUAGRPDETAILNAME())) {
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psDEUIActionGroupDetail.getCODENAME())) {
                    psDEUIActionGroupDetail.setPSDEUAGRPDETAILNAME(psDEUIActionGroupDetail.getCODENAME().toLowerCase());
                } else {
                    psDEUIActionGroupDetail.setPSDEUAGRPDETAILNAME("u" + KeyValueHelper.genUniqueId((String)psDEUIActionGroupDetail.getPSDEUAGRPDETAILID()).substring(0, 7));
                }
            }
            if (!psDEUIActionGroupDetail.isVALIDFLAGNull() && !psDEUIActionGroupDetail.getVALIDFLAG()) continue;
            PSWFUIActionGroupDetailImpl iPSWFUIActionGroupDetail = new PSWFUIActionGroupDetailImpl();
            iPSWFUIActionGroupDetail.init(this.getDAGlobalHelper(), this, psDEUIActionGroupDetail);
            this.psWFUIActionGroupDetailList.add(iPSWFUIActionGroupDetail);
            if (iPSWFUIActionGroupDetail.getPSWFUIAction() == null) continue;
            this.psDEUIActionList.add(iPSWFUIActionGroupDetail.getPSWFUIAction());
        }
        this.psUIActionList.addAll(this.psDEUIActionList);
        this.psUIActionGroupDetailList.addAll(this.psWFUIActionGroupDetailList);
    }

    @Override
    public Iterator<IPSWFUIAction> getPSWFUIActions() {
        if (this.psDEUIActionList == null || this.psDEUIActionList.size() == 0) {
            return null;
        }
        return this.psDEUIActionList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u754c\u9762\u884c\u4e3a\u96c6\u5408")
    public Iterator<IPSUIAction> getPSUIActions() {
        if (this.psUIActionList == null || this.psUIActionList.size() == 0) {
            return null;
        }
        return this.psUIActionList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u5de5\u4f5c\u6d41\u5bf9\u8c61")
    public IPSWorkflow getPSWorkflow() {
        return this.iPSWorkflow;
    }

    @Override
    @PSModelRTMeta(description="\u5de5\u4f5c\u6d41\u7248\u672c\u5bf9\u8c61")
    public IPSWFVersion getPSWFVersion() {
        return this.iPSWFVersion;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSWorkflow().getPSSysModelInstId();
    }

    @Override
    @PSModelRTMeta(description="\u754c\u9762\u884c\u4e3a\u7ec4\u6210\u5458\u96c6\u5408", child=true)
    public Iterator<IPSUIActionGroupDetail> getPSUIActionGroupDetails() {
        if (this.psUIActionGroupDetailList == null || this.psUIActionGroupDetailList.size() == 0) {
            return null;
        }
        return this.psUIActionGroupDetailList.iterator();
    }

    @Override
    public Iterator<IPSWFUIActionGroupDetail> getPSWFUIActionGroupDetails() {
        if (this.psWFUIActionGroupDetailList == null || this.psWFUIActionGroupDetailList.size() == 0) {
            return null;
        }
        return this.psWFUIActionGroupDetailList.iterator();
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

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSWorkflow().getPSSystem());
    }

    @Override
    public String getModelType() {
        if (this.getPSAppWFVer() != null) {
            return "PSAPPWFVERUAGROUP";
        }
        if (this.getPSAppWF() != null) {
            return "PSAPPWFUAGROUP";
        }
        return "PSWFUAGROUP";
    }

    @Override
    public String getModelId() {
        if (this.getPSAppWFVer() != null) {
            return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s#%2$s", (Object)this.getPSAppWFVer().getModelId(), (Object)super.getModelId());
        }
        if (this.getPSAppWF() != null) {
            return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s#%2$s", (Object)this.getPSAppWF().getModelId(), (Object)super.getModelId());
        }
        return super.getModelId();
    }
}

