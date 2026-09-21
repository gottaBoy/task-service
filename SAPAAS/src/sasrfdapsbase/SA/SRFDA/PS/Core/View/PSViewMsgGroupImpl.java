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
package SA.SRFDA.PS.Core.View;

import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSSystemObjectImpl;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Core.View.IPSViewMsgGroup;
import SA.SRFDA.PS.Core.View.IPSViewMsgGroupDetail;
import SA.SRFDA.PS.Core.View.PSViewMsgGroupDetailImpl;
import SA.SRFDA.PS.Data.PSViewMsgGroup;
import SA.SRFDA.PS.Data.PSViewMsgGroupDetail;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelPFIgnoreMeta
public class PSViewMsgGroupImpl
extends PSSystemObjectImpl
implements IPSViewMsgGroup {
    private static final Log log = LogFactory.getLog(PSViewMsgGroupImpl.class);
    protected PSViewMsgGroup psViewMsgGroup = null;
    private String strCodeName = null;
    private ArrayList<IPSViewMsgGroupDetail> psViewMsgGroupDetailList = new ArrayList();
    private IPSSystemModule iPSSystemModule = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem, PSViewMsgGroup psViewMsgGroup) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSystem(iPSSystem);
            this.psViewMsgGroup = psViewMsgGroup;
            this.setId(this.psViewMsgGroup.getPSVIEWMSGGROUPID());
            this.setName(this.psViewMsgGroup.getPSVIEWMSGGROUPNAME());
            this.setPSObjectData(this.psViewMsgGroup);
            this.strCodeName = this.psViewMsgGroup.getCODENAME();
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psViewMsgGroup.getPSMODULEID())) {
                this.iPSSystemModule = this.getPSSystem().getPSSystemModule(this.psViewMsgGroup.getPSMODULEID());
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
    protected void onInit() throws Exception {
        super.onInit();
        this.onPreparePSViewMsgGroupDetails();
    }

    protected void onPreparePSViewMsgGroupDetails() throws Exception {
        this.psViewMsgGroupDetailList.clear();
        Vector<PSViewMsgGroupDetail> psViewMsgGroupDetailList = new Vector<PSViewMsgGroupDetail>();
        CallResult callResult = this.getPSModelHelper().getPSViewMsgGroupDetails(this.getId(), psViewMsgGroupDetailList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u89c6\u56fe\u6d88\u606f\u7ec4\u6210\u5458\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSViewMsgGroupDetail psViewMsgGroupDetail : psViewMsgGroupDetailList) {
            if (!psViewMsgGroupDetail.isVALIDFLAGNull() && !psViewMsgGroupDetail.getVALIDFLAG()) continue;
            PSViewMsgGroupDetailImpl iPSViewMsgGroupDetail = new PSViewMsgGroupDetailImpl();
            iPSViewMsgGroupDetail.init(this.getDAGlobalHelper(), this, psViewMsgGroupDetail);
            this.psViewMsgGroupDetailList.add(iPSViewMsgGroupDetail);
        }
    }

    @Override
    public String getModelType() {
        return "PSVIEWMSGGROUP";
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.onGetCodeName();
    }

    protected String onGetCodeName() {
        return this.calcCodeName();
    }

    protected String calcCodeName() {
        return this.strCodeName;
    }

    @Override
    public Iterator<? extends IPSViewMsgGroupDetail> getPSViewMsgGroupDetails() {
        if (this.psViewMsgGroupDetailList == null || this.psViewMsgGroupDetailList.size() == 0) {
            return null;
        }
        return this.psViewMsgGroupDetailList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u6a21\u5757", hideempty=true)
    public IPSSystemModule getPSSystemModule() {
        return this.iPSSystemModule;
    }

    @Override
    @PSModelRTMeta(description="\u5934\u90e8\u6d88\u606f\u533a\u6837\u5f0f", hideempty2=true, codelist="ViewMsgShowMode", fields={"TOPMSGSTYLE"})
    public String getTopStyle() {
        return this.psViewMsgGroup.getTOPMSGSTYLE();
    }

    @Override
    @PSModelRTMeta(description="\u5c3e\u90e8\u6d88\u606f\u533a\u6837\u5f0f", hideempty2=true, codelist="ViewMsgShowMode", fields={"BOTTOMMSGSTYLE"})
    public String getBottomStyle() {
        return this.psViewMsgGroup.getBOTTOMMSGSTYLE();
    }

    @Override
    @PSModelRTMeta(description="\u5185\u90e8\u6d88\u606f\u533a\u6837\u5f0f", hideempty2=true, codelist="ViewMsgShowMode", fields={"BODYMSGSTYLE"})
    public String getBodyStyle() {
        return this.psViewMsgGroup.getBODYMSGSTYLE();
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u6d88\u606f\u7ec4\u552f\u4e00\u6807\u8bb0")
    public String getUniqueTag() {
        if (this.getPSSystemModule() != null) {
            if (this.getPSSystemModule().getPSSysModelGroup() != null) {
                return String.format("%1$s__%2$s__%3$s", this.getPSSystemModule().getPSSysModelGroup().getCodeName(), this.getPSSystemModule().getCodeName(), this.getCodeName());
            }
            if (this.getPSSystemModule().getPSSysRef() != null) {
                return String.format("%1$s__%2$s__%3$s", this.getPSSystemModule().getPSSysRef().getSysRefTag(), this.getPSSystemModule().getCodeName(), this.getCodeName());
            }
            return String.format("%1$s__%2$s", this.getPSSystemModule().getCodeName(), this.getCodeName());
        }
        return this.getCodeName();
    }
}

