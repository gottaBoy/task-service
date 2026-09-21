/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.core.IDEActionWizardItem
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.Wizard;

import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.PSDataEntityObjectImpl;
import SA.SRFDA.PS.Core.DataEntity.Wizard.IPSDEActionWizard;
import SA.SRFDA.PS.Core.DataEntity.Wizard.IPSDEActionWizardItem;
import SA.SRFDA.PS.Core.DataEntity.Wizard.PSDEActionWizardItemImpl;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPub;
import SA.SRFDA.PS.Data.PSDEAWItem;
import SA.SRFDA.PS.Data.PSDEActionWizard;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import net.ibizsys.paas.core.IDEActionWizardItem;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelIgnoreMeta
public class PSDEActionWizardImpl
extends PSDataEntityObjectImpl
implements IPSDEActionWizard {
    private static final Log log = LogFactory.getLog(PSDEActionWizardImpl.class);
    protected PSDEActionWizard psDEActionWizard;
    protected ArrayList<IPSDEActionWizardItem> psDEActionWizardItemList = new ArrayList();
    protected ArrayList<IDEActionWizardItem> deActionWizardItemList = new ArrayList();
    protected String strCodeName = "";
    private int nDynamicMode = 0;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDataEntity iPSDataEntity, PSDEActionWizard psDEActionWizard) throws Exception {
        try {
            this.setPSDataEntity(iPSDataEntity);
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.psDEActionWizard = psDEActionWizard;
            this.setId(psDEActionWizard.getPSDEACTIONWIZARDID());
            this.setName(psDEActionWizard.getPSDEACTIONWIZARDNAME());
            this.setPSObjectData(this.psDEActionWizard);
            this.strCodeName = this.psDEActionWizard.getCODENAME();
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strCodeName)) {
                this.strCodeName = this.getName();
            }
            if (!this.psDEActionWizard.isDYNAMICMODENull()) {
                this.nDynamicMode = this.psDEActionWizard.getDYNAMICMODE();
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
        this.onPreparePSDEActionWizardItems();
    }

    protected void onPreparePSDEActionWizardItems() throws Exception {
        this.psDEActionWizardItemList.clear();
        this.deActionWizardItemList.clear();
        Vector<PSDEAWItem> psDEActionWizardItemList = new Vector<PSDEAWItem>();
        CallResult callResult = this.getPSModelHelper().getPSDEActionWizardItems(this.getId(), psDEActionWizardItemList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u5411\u5bfc\u6b65\u9aa4\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSDEAWItem psDEActionWizardItem : psDEActionWizardItemList) {
            PSDEActionWizardItemImpl iPSDEActionWizardItem = new PSDEActionWizardItemImpl();
            iPSDEActionWizardItem.init(this.getDAGlobalHelper(), this, psDEActionWizardItem);
            this.psDEActionWizardItemList.add(iPSDEActionWizardItem);
        }
        this.deActionWizardItemList.addAll(this.psDEActionWizardItemList);
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u64cd\u4f5c\u5411\u5bfc\u9879\u96c6\u5408")
    public Iterator<IPSDEActionWizardItem> getPSDEActionWizardItems() {
        return this.psDEActionWizardItemList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.strCodeName;
    }

    protected String onGetCodeName() {
        return this.strCodeName;
    }

    @Override
    public String getModelType() {
        return "PSDEACTIONWIZARD";
    }

    @Override
    public String getClassOrPkgName(String strCodeType, IPSSysSFPub iPSSysSFPub) throws Exception {
        return null;
    }

    @PSModelRTMeta(description="\u5b9e\u4f53\u884c\u4e3a\u5411\u5bfc\u9879\u5bf9\u8c61\u96c6\u5408")
    public Iterator<IDEActionWizardItem> getDEActionWizardItems() {
        return this.deActionWizardItemList.iterator();
    }

    @PSModelRTMeta(description="\u5173\u952e\u5b57")
    public String getKeywords() {
        return this.psDEActionWizard.getKEYWORDS();
    }

    public String getWizardUrl() {
        return "";
    }

    @Override
    public int getDynamicMode() {
        return this.nDynamicMode;
    }
}

