/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.service.ActionSessionManager
 *  net.ibizsys.paas.service.IServiceWork
 *  net.ibizsys.paas.service.ITransaction
 *  net.ibizsys.paas.service.ServiceWorkHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DynaSys;

import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DynaSys.IPSDynaDEFormTempl;
import SA.SRFDA.PS.Core.DynaSys.IPSDynaDETempl;
import SA.SRFDA.PS.Core.DynaSys.IPSDynaDEViewTempl;
import SA.SRFDA.PS.Core.DynaSys.PSDynaDEFormTemplImpl;
import SA.SRFDA.PS.Core.DynaSys.PSDynaDEViewTemplImpl;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSSystemObjectImpl;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Data.PSDynaDEFormTempl;
import SA.SRFDA.PS.Data.PSDynaDETempl;
import SA.SRFDA.PS.Data.PSDynaDEViewTempl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import net.ibizsys.paas.service.ActionSessionManager;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceWorkHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelIgnoreMeta
public class PSDynaDETemplImpl
extends PSSystemObjectImpl
implements IPSDynaDETempl {
    private static final Log log = LogFactory.getLog(PSDynaDETemplImpl.class);
    protected PSDynaDETempl psDynaDETempl = null;
    private IPSDataEntity templPSDE = null;
    private IPSDEField typePSDEF = null;
    private ArrayList<IPSDynaDEViewTempl> psDynaDEViewTemplList = new ArrayList();
    private ArrayList<IPSDynaDEFormTempl> psDynaDEFormTemplList = new ArrayList();

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem, PSDynaDETempl psDynaDETempl) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSystem(iPSSystem);
            this.psDynaDETempl = psDynaDETempl;
            this.setId(this.psDynaDETempl.getPSDYNADETEMPLID());
            this.setName(this.psDynaDETempl.getPSDYNADETEMPLNAME());
            this.setPSObjectData(this.psDynaDETempl);
            ServiceWorkHelper.getInstance().execute(new IServiceWork(){

                public void execute(ITransaction iTransaction) throws Exception {
                    if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)PSDynaDETemplImpl.this.getModelType()) && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)PSDynaDETemplImpl.this.getId())) {
                        if (!ActionSessionManager.getCurrentSession().registerRecursion(PSDynaDETemplImpl.this.getModelType(), (Object)PSDynaDETemplImpl.this.getId())) {
                            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u5b58\u5728\u9012\u5f52\u5f15\u7528"));
                        }
                        PSDynaDETemplImpl.this.onInit();
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
        this.templPSDE = this.getPSSystem().getPSDataEntity2(this.psDynaDETempl.getTEMPLPSDEID());
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDynaDETempl.getTYPEPSDEFID())) {
            throw new Exception("\u6ca1\u6709\u4e3a\u52a8\u6001\u5b9e\u4f53\u6a21\u677f\u6307\u5b9a\u7c7b\u578b\u5c5e\u6027");
        }
        this.typePSDEF = this.getTemplPSDE().getPSDEField(this.psDynaDETempl.getTYPEPSDEFID());
        this.onPreparePSDynaDEFormTempls();
        this.onPreparePSDynaDEViewTempls();
        super.onInit();
    }

    @Override
    public String getModelType() {
        return "PSDYNADETEMPL";
    }

    @Override
    @PSModelRTMeta(description="\u6a21\u677f\u5b9e\u4f53")
    public IPSDataEntity getTemplPSDE() {
        return this.templPSDE;
    }

    @Override
    @PSModelRTMeta(description="\u7c7b\u578b\u5c5e\u6027")
    public IPSDEField getTypePSDEF() {
        return this.typePSDEF;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u6a21\u5757")
    public IPSSystemModule getPSSystemModule() {
        return this.getTemplPSDE().getPSSystemModule();
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.getTemplPSDE().getCodeName();
    }

    protected void onPreparePSDynaDEViewTempls() throws Exception {
        this.psDynaDEViewTemplList.clear();
        Vector<PSDynaDEViewTempl> psDynaDEViewTemplList = new Vector<PSDynaDEViewTempl>();
        CallResult callResult = this.getPSModelHelper().getPSDynaDEViewTempls(this.getId(), psDynaDEViewTemplList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u52a8\u6001\u5b9e\u4f53\u89c6\u56fe\u6a21\u677f\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSDynaDEViewTempl psDynaDEViewTempl : psDynaDEViewTemplList) {
            PSDynaDEViewTemplImpl iPSDynaDEViewTempl = new PSDynaDEViewTemplImpl();
            iPSDynaDEViewTempl.init(this.getDAGlobalHelper(), this, psDynaDEViewTempl);
            this.psDynaDEViewTemplList.add(iPSDynaDEViewTempl);
        }
    }

    protected void onPreparePSDynaDEFormTempls() throws Exception {
        this.psDynaDEFormTemplList.clear();
        Vector<PSDynaDEFormTempl> psDynaDEFormTemplList = new Vector<PSDynaDEFormTempl>();
        CallResult callResult = this.getPSModelHelper().getPSDynaDEFormTempls(this.getId(), psDynaDEFormTemplList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u52a8\u6001\u5b9e\u4f53\u8868\u5355\u6a21\u677f\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSDynaDEFormTempl psDynaDEFormTempl : psDynaDEFormTemplList) {
            PSDynaDEFormTemplImpl iPSDynaDEFormTempl = new PSDynaDEFormTemplImpl();
            iPSDynaDEFormTempl.init(this.getDAGlobalHelper(), this, psDynaDEFormTempl);
            this.psDynaDEFormTemplList.add(iPSDynaDEFormTempl);
        }
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u89c6\u56fe\u6a21\u677f\u96c6\u5408")
    public Iterator<IPSDynaDEViewTempl> getPSDynaDEViewTempls() {
        if (this.psDynaDEViewTemplList.size() == 0) {
            return null;
        }
        return this.psDynaDEViewTemplList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u8868\u5355\u6a21\u677f\u96c6\u5408")
    public Iterator<IPSDynaDEFormTempl> getPSDynaDEFormTempls() {
        if (this.psDynaDEFormTemplList.size() == 0) {
            return null;
        }
        return this.psDynaDEFormTemplList.iterator();
    }
}

