/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.PSApplicationObjectImpl;
import SA.SRFDA.PS.Core.App.View.IPSAppViewMsgGroup;
import SA.SRFDA.PS.Core.App.View.IPSAppViewMsgGroupDetail;
import SA.SRFDA.PS.Core.App.View.PSAppViewMsgGroupDetailImpl;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Core.View.IPSViewMsgGroup;
import SA.SRFDA.PS.Core.View.IPSViewMsgGroupDetail;
import SA.SRFDA.PS.Data.PSViewMsgGroup;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppViewMsgGroupImpl
extends PSApplicationObjectImpl
implements IPSAppViewMsgGroup {
    private static final Log log = LogFactory.getLog(PSAppViewMsgGroupImpl.class);
    private IPSViewMsgGroup iPSViewMsgGroup = null;
    private ArrayList<IPSAppViewMsgGroupDetail> psAppViewMsgGroupDetailList = new ArrayList();

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSApplication iPSApplication, IPSViewMsgGroup iPSViewMsgGroup) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSApplication(iPSApplication);
            this.iPSViewMsgGroup = iPSViewMsgGroup;
            this.setId(iPSViewMsgGroup.getId());
            this.setName(iPSViewMsgGroup.getName());
            this.onInit();
        }
        catch (Exception ex) {
            this.throwCriticalInitException(ex);
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
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem, PSViewMsgGroup psViewMsgGroup) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @Override
    protected void onInit() throws Exception {
        this.onPreparePSAppViewMsgGroupDetails();
        super.onInit();
    }

    /*
     * Unable to fully structure code
     */
    protected void onPreparePSAppViewMsgGroupDetails() throws Exception {
        this.psAppViewMsgGroupDetailList.clear();
        psViewMsgGroupDetails = this.getPSViewMsgGroup().getPSViewMsgGroupDetails();
        if (psViewMsgGroupDetails != null) ** GOTO lbl10
        return;
lbl-1000:
        // 1 sources

        {
            iPSViewMsgGroupDetail = psViewMsgGroupDetails.next();
            psAppViewMsgGroupDetailImpl = new PSAppViewMsgGroupDetailImpl();
            psAppViewMsgGroupDetailImpl.init(this.getDAGlobalHelper(), this, iPSViewMsgGroupDetail);
            this.psAppViewMsgGroupDetailList.add(psAppViewMsgGroupDetailImpl);
lbl10:
            // 2 sources

            ** while (psViewMsgGroupDetails.hasNext())
        }
lbl11:
        // 1 sources

    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.getPSViewMsgGroup().getCodeName();
    }

    @Override
    public Iterator<? extends IPSViewMsgGroupDetail> getPSViewMsgGroupDetails() {
        return this.getPSAppViewMsgGroupDetails();
    }

    @Override
    @PSModelRTMeta(description="\u6d88\u606f\u7ec4\u6210\u5458\u96c6\u5408", child=true, group="\u57fa\u672c", order=120)
    public Iterator<? extends IPSAppViewMsgGroupDetail> getPSAppViewMsgGroupDetails() {
        if (this.psAppViewMsgGroupDetailList == null || this.psAppViewMsgGroupDetailList.size() == 0) {
            return null;
        }
        return this.psAppViewMsgGroupDetailList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u6a21\u5757", hideempty=true)
    public IPSSystemModule getPSSystemModule() {
        return this.getPSViewMsgGroup().getPSSystemModule();
    }

    @Override
    @PSModelRTMeta(description="\u5934\u90e8\u6d88\u606f\u533a\u6837\u5f0f", hideempty=true, codelist="ViewMsgShowMode", fields={"TOPMSGSTYLE"})
    public String getTopStyle() {
        return this.getPSViewMsgGroup().getTopStyle();
    }

    @Override
    @PSModelRTMeta(description="\u5c3e\u90e8\u6d88\u606f\u533a\u6837\u5f0f", hideempty=true, codelist="ViewMsgShowMode", fields={"BOTTOMMSGSTYLE"})
    public String getBottomStyle() {
        return this.getPSViewMsgGroup().getBottomStyle();
    }

    @Override
    @PSModelRTMeta(description="\u5185\u90e8\u6d88\u606f\u533a\u6837\u5f0f", hideempty=true, codelist="ViewMsgShowMode", fields={"BODYMSGSTYLE"})
    public String getBodyStyle() {
        return this.getPSViewMsgGroup().getBodyStyle();
    }

    @Override
    public IPSViewMsgGroup getPSViewMsgGroup() {
        return this.iPSViewMsgGroup;
    }

    @Override
    protected IPSModelObject getProxyPSModelObject() {
        return this.getPSViewMsgGroup();
    }

    @Override
    @PSModelRTMeta(description="\u6d88\u606f\u7ec4\u552f\u4e00\u6807\u8bb0")
    public String getUniqueTag() {
        return this.getPSViewMsgGroup().getUniqueTag();
    }

    @Override
    public String getModelId() {
        if (this.getPSApplication() != null) {
            return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSApplication().getModelId(), (Object)super.getModelId());
        }
        return super.getModelId();
    }

    @Override
    public String getModelType() {
        return "PSAPPVIEWMSGGROUP";
    }

    @Override
    public String getDynaModelFilePath() {
        return null;
    }

    @Override
    public int getOrderValue() {
        return 99999;
    }
}

