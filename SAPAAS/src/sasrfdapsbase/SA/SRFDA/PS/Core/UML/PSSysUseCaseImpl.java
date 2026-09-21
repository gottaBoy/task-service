/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.data.IDEFieldDiffItem
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.UML;

import SA.SRFDA.PS.Core.IPSModelDiffActionContext;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSSystemObjectImpl;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPub;
import SA.SRFDA.PS.Core.Requirement.IPSSysReqItem;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Core.UML.IPSSysUseCase;
import SA.SRFDA.PS.Core.UML.IPSSysUseCaseRS;
import SA.SRFDA.PS.Core.Util.PSModelDiffHelper;
import SA.SRFDA.PS.Data.PSSysUserCase;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.data.IDEFieldDiffItem;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysUseCaseImpl
extends PSSystemObjectImpl
implements IPSSysUseCase {
    private static final Log log = LogFactory.getLog(PSSysUseCaseImpl.class);
    protected PSSysUserCase psSysUserCase = null;
    private IPSSystemModule iPSSystemModule = null;
    private ArrayList<IPSSysUseCaseRS> fromPSSysUseCaseRSList = null;
    private ArrayList<IPSSysUseCaseRS> toPSSysUseCaseRSList = null;
    private ArrayList<IPSSysReqItem> psSysReqItemList = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem, PSSysUserCase psSysUserCase) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSystem(iPSSystem);
            this.psSysUserCase = psSysUserCase;
            this.setId(this.psSysUserCase.getPSSYSUSERCASEID());
            this.setName(this.psSysUserCase.getPSSYSUSERCASENAME());
            this.setPSObjectData(this.psSysUserCase);
            if (!StringHelper.isNullOrEmpty((String)this.psSysUserCase.getPSMODULEID())) {
                this.iPSSystemModule = this.getPSSystem().getPSSystemModule(this.psSysUserCase.getPSMODULEID());
            }
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
        this.onInit();
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u7528\u4f8b\u7f16\u53f7", group="\u57fa\u672c", order=105)
    public String getUseCaseSN() {
        return this.psSysUserCase.getUSERCASESN();
    }

    @Override
    @PSModelRTMeta(description="\u7528\u4f8b\u6807\u8bb0")
    public String getUseCaseTag() {
        return this.psSysUserCase.getUSERCASETAG();
    }

    @Override
    @PSModelRTMeta(description="\u7528\u4f8b\u6807\u8bb02")
    public String getUseCaseTag2() {
        return this.psSysUserCase.getUSERCASETAG2();
    }

    @Override
    public int diff(IPSModelDiffActionContext iPSModelDiffActionContext, Object dstModel) throws Exception {
        IPSSysUseCase dstPSSysUserCase = (IPSSysUseCase)dstModel;
        ArrayList<IDEFieldDiffItem> list = PSModelDiffHelper.getDEDataDiffItems(DEModelGlobal.getDEModel((String)this.getModelType()), this.getModelData(), dstPSSysUserCase.getModelData(), false);
        if (list == null || list.size() == 0) {
            return 0;
        }
        iPSModelDiffActionContext.addDiffItem(null, this, list);
        return 1;
    }

    @Override
    public String getModelType() {
        return "PSSYSUSECASE";
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
        return this.psSysUserCase.getCODENAME();
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u6a21\u5757")
    public IPSSystemModule getPSSystemModule() {
        return this.iPSSystemModule;
    }

    @Override
    @PSModelRTMeta(description="\u5185\u5bb9", doctype="md", group="\u57fa\u672c", order=240)
    public String getContent() {
        return this.psSysUserCase.getCONTENT();
    }

    @Override
    @PSModelRTMeta(description="\u8fde\u5165\u7528\u4f8b\u5173\u7cfb\u96c6\u5408", child=true)
    public Iterator<IPSSysUseCaseRS> getFromPSSysUseCaseRSs() throws Exception {
        if (this.fromPSSysUseCaseRSList == null) {
            Iterator<IPSSysUseCaseRS> psSysUseCaseRSs = this.getPSSystem().getAllPSSysUseCaseRSs();
            ArrayList<IPSSysUseCaseRS> psSysUseCaseRSList = new ArrayList<IPSSysUseCaseRS>();
            if (psSysUseCaseRSs != null) {
                while (psSysUseCaseRSs.hasNext()) {
                    IPSSysUseCaseRS iPSSysUseCaseRS = psSysUseCaseRSs.next();
                    if (iPSSysUseCaseRS.getToPSSysUseCase() == null || StringHelper.compare((String)iPSSysUseCaseRS.getToPSSysUseCase().getId(), (String)this.getId(), (boolean)false) != 0) continue;
                    psSysUseCaseRSList.add(iPSSysUseCaseRS);
                }
            }
            if (this.fromPSSysUseCaseRSList == null) {
                this.fromPSSysUseCaseRSList = psSysUseCaseRSList;
            }
        }
        if (this.fromPSSysUseCaseRSList == null || this.fromPSSysUseCaseRSList.size() == 0) {
            return null;
        }
        return this.fromPSSysUseCaseRSList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u8fde\u51fa\u7528\u4f8b\u5173\u7cfb\u96c6\u5408", child=true)
    public Iterator<IPSSysUseCaseRS> getToPSSysUseCaseRSs() throws Exception {
        if (this.toPSSysUseCaseRSList == null) {
            Iterator<IPSSysUseCaseRS> psSysUseCaseRSs = this.getPSSystem().getAllPSSysUseCaseRSs();
            ArrayList<IPSSysUseCaseRS> psSysUseCaseRSList = new ArrayList<IPSSysUseCaseRS>();
            if (psSysUseCaseRSs != null) {
                while (psSysUseCaseRSs.hasNext()) {
                    IPSSysUseCaseRS iPSSysUseCaseRS = psSysUseCaseRSs.next();
                    if (iPSSysUseCaseRS.getFromPSSysUseCase() == null || StringHelper.compare((String)iPSSysUseCaseRS.getFromPSSysUseCase().getId(), (String)this.getId(), (boolean)false) != 0) continue;
                    psSysUseCaseRSList.add(iPSSysUseCaseRS);
                }
            }
            if (this.toPSSysUseCaseRSList == null) {
                this.toPSSysUseCaseRSList = psSysUseCaseRSList;
            }
        }
        if (this.toPSSysUseCaseRSList == null || this.toPSSysUseCaseRSList.size() == 0) {
            return null;
        }
        return this.toPSSysUseCaseRSList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u7528\u4f8b\u9700\u6c42\u9879\u96c6\u5408")
    public Iterator<IPSSysReqItem> getPSSysReqItems() throws Exception {
        if (this.psSysReqItemList == null) {
            Iterator<IPSSysReqItem> psSysReqItems = this.getPSSystem().getAllPSSysReqItems();
            ArrayList<IPSSysReqItem> psSysReqItemList = new ArrayList<IPSSysReqItem>();
            if (psSysReqItems != null) {
                while (psSysReqItems.hasNext()) {
                    IPSSysReqItem iPSSysReqItem = psSysReqItems.next();
                    if (iPSSysReqItem.getPSSysUseCase() == null || StringHelper.compare((String)iPSSysReqItem.getPSSysUseCase().getId(), (String)this.getId(), (boolean)false) != 0) continue;
                    psSysReqItemList.add(iPSSysReqItem);
                }
            }
            if (this.psSysReqItemList == null) {
                this.psSysReqItemList = psSysReqItemList;
            }
        }
        if (this.psSysReqItemList == null || this.psSysReqItemList.size() == 0) {
            return null;
        }
        return this.psSysReqItemList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u540e\u53f0\u670d\u52a1\u53d1\u5e03\u5bf9\u8c61", hideempty=true)
    public IPSSysSFPub getPSSysSFPub() {
        if (this.getPSSystemModule() != null) {
            return this.getPSSystemModule().getPSSysSFPub();
        }
        return this.getPSSystem().getDefaultPSSysSFPub();
    }
}

