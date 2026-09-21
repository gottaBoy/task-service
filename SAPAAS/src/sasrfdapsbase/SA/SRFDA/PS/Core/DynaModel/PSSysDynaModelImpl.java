/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.service.ActionSessionManager
 *  net.ibizsys.paas.service.IServiceWork
 *  net.ibizsys.paas.service.ITransaction
 *  net.ibizsys.paas.service.ServiceWorkHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DynaModel;

import SA.SRFDA.PS.Core.DynaModel.IPSDynaModel;
import SA.SRFDA.PS.Core.DynaModel.IPSDynaModelAttr;
import SA.SRFDA.PS.Core.DynaModel.IPSSysDynaModel;
import SA.SRFDA.PS.Core.DynaModel.IPSSysDynaModelAttr;
import SA.SRFDA.PS.Core.DynaModel.PSSysDynaModelAttrImpl;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSSystemObjectImpl;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Data.PSSysDynaModel;
import SA.SRFDA.PS.Data.PSSysDynaModelAttr;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Vector;
import net.ibizsys.paas.service.ActionSessionManager;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceWorkHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysDynaModelImpl
extends PSSystemObjectImpl
implements IPSSysDynaModel {
    private static final Log log = LogFactory.getLog(PSSysDynaModelImpl.class);
    protected PSSysDynaModel psSysDynaModel = null;
    private ArrayList<IPSSysDynaModelAttr> psSysDynaModelAttrList = new ArrayList();
    private Map<String, IPSDynaModelAttr> psDynaModelAttrMap = new LinkedHashMap<String, IPSDynaModelAttr>();
    private boolean bSystemDefault = false;
    private boolean bModuleDefault = false;
    private String strDynaModel = null;
    private IPSSystemModule iPSSystemModule = null;
    private String strDynaModelUsage = "DATA";

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem, PSSysDynaModel psSysDynaModel) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSystem(iPSSystem);
            this.psSysDynaModel = psSysDynaModel;
            this.setId(this.psSysDynaModel.getPSSYSDYNAMODELID());
            this.setName(this.psSysDynaModel.getPSSYSDYNAMODELNAME());
            this.setPSObjectData(this.psSysDynaModel);
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psSysDynaModel.getPSMODULEID())) {
                this.iPSSystemModule = this.getPSSystem().getPSSystemModule(this.psSysDynaModel.getPSMODULEID());
            }
            if (!this.psSysDynaModel.isDEFAULTFLAGNull() && this.psSysDynaModel.getDEFAULTFLAG()) {
                if (this.getPSSystemModule() == null) {
                    this.bSystemDefault = true;
                } else {
                    this.bModuleDefault = true;
                }
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psSysDynaModel.getDYNAMODEL())) {
                this.strDynaModel = this.psSysDynaModel.getDYNAMODEL();
            } else if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psSysDynaModel.getDYNAMODEL2())) {
                this.strDynaModel = this.psSysDynaModel.getDYNAMODEL2();
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psSysDynaModel.getDYNAMODELUSAGE())) {
                this.strDynaModelUsage = this.psSysDynaModel.getDYNAMODELUSAGE();
            }
            ServiceWorkHelper.getInstance().execute(new IServiceWork(){

                public void execute(ITransaction iTransaction) throws Exception {
                    if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)PSSysDynaModelImpl.this.getModelType()) && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)PSSysDynaModelImpl.this.getId())) {
                        if (!ActionSessionManager.getCurrentSession().registerRecursion(PSSysDynaModelImpl.this.getModelType(), (Object)PSSysDynaModelImpl.this.getId())) {
                            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u5b58\u5728\u9012\u5f52\u5f15\u7528"));
                        }
                        try {
                            PSSysDynaModelImpl.this.onInit();
                            ActionSessionManager.getCurrentSession().unregisterRecursion(PSSysDynaModelImpl.this.getModelType(), (Object)PSSysDynaModelImpl.this.getId());
                        }
                        catch (Exception ex) {
                            ActionSessionManager.getCurrentSession().unregisterRecursion(PSSysDynaModelImpl.this.getModelType(), (Object)PSSysDynaModelImpl.this.getId());
                            throw ex;
                        }
                    } else {
                        PSSysDynaModelImpl.this.onInit();
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
        this.onPreparePSSysDynaModelAttrs();
        super.onInit();
    }

    protected void onPreparePSSysDynaModelAttrs() throws Exception {
        this.psSysDynaModelAttrList.clear();
        this.psDynaModelAttrMap.clear();
        Vector<PSSysDynaModelAttr> psSysDynaModelAttrList = new Vector<PSSysDynaModelAttr>();
        CallResult callResult = this.getPSModelHelper().getPSSysDynaModelAttrs(this.getId(), psSysDynaModelAttrList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u52a8\u6001\u6a21\u578b\u5c5e\u6027\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSSysDynaModelAttr psSysDynaModelAttr : psSysDynaModelAttrList) {
            PSSysDynaModelAttrImpl iPSSysDynaModelAttr = new PSSysDynaModelAttrImpl();
            iPSSysDynaModelAttr.init(this.getDAGlobalHelper(), this, psSysDynaModelAttr);
            this.psSysDynaModelAttrList.add(iPSSysDynaModelAttr);
            this.psDynaModelAttrMap.put(iPSSysDynaModelAttr.getName().toUpperCase(), iPSSysDynaModelAttr);
        }
    }

    @Override
    public Iterator<? extends IPSSysDynaModelAttr> getPSSysDynaModelAttrs() {
        if (this.psSysDynaModelAttrList.size() == 0) {
            return null;
        }
        return this.psSysDynaModelAttrList.iterator();
    }

    @Override
    public String getModelType() {
        return "PSSYSDYNAMODEL";
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u9ed8\u8ba4\u6a21\u578b", dump=false)
    public boolean isSystemDefault() {
        return this.bSystemDefault;
    }

    @Override
    protected boolean hasPSSysDynaModel() {
        return false;
    }

    @Override
    @PSModelRTMeta(description="\u5c5e\u6027\u96c6\u5408", child=true)
    public Iterator<? extends IPSDynaModelAttr> getPSDynaModelAttrs() {
        return this.psSysDynaModelAttrList.iterator();
    }

    @Override
    public IPSDynaModelAttr getPSDynaModelAttr(String strName, boolean bTryMode) throws Exception {
        IPSDynaModelAttr iPSDynaModelAttr = this.psDynaModelAttrMap.get(strName.toUpperCase());
        if (iPSDynaModelAttr == null && !bTryMode) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u52a8\u6001\u6a21\u578b\u5c5e\u6027[%1$s]", (Object)strName));
        }
        return iPSDynaModelAttr;
    }

    @Override
    public Object get(String strName, Object objDefault) throws Exception {
        IPSDynaModelAttr iPSDynaModelAttr = this.getPSDynaModelAttr(strName, true);
        if (iPSDynaModelAttr != null) {
            if (SA.SRFramework.Utility.StringHelper.Compare((String)iPSDynaModelAttr.getValueType(), (String)"VALUE", (boolean)true) == 0) {
                return iPSDynaModelAttr.getValue();
            }
            return iPSDynaModelAttr.getRefPSDynaModel();
        }
        return objDefault;
    }

    @Override
    public Object get(String strName) throws Exception {
        return this.get(strName, null);
    }

    @Override
    public boolean has(String strName) throws Exception {
        return this.psDynaModelAttrMap.containsKey(strName.toUpperCase());
    }

    @Override
    public IPSDynaModel getPSDynaModel() {
        return super.getPSDynaModel();
    }

    @Override
    @PSModelRTMeta(description="\u6a21\u578b\u5185\u5bb9", doctype="code", group="\u57fa\u672c", order=135)
    public String getContent() {
        return this.getJOString();
    }

    @Override
    public String getJOString() {
        return this.strDynaModel;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.psSysDynaModel.getCODENAME();
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u6a21\u5757")
    public IPSSystemModule getPSSystemModule() {
        return this.iPSSystemModule;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u6a21\u5757\u9ed8\u8ba4\u6a21\u578b", dump=false)
    public boolean isModuleDefault() {
        return this.bModuleDefault;
    }

    @Override
    @PSModelRTMeta(description="\u5c5e\u6027\u6570\u91cf", dump=false, outputdoc="false")
    public int getPSDynaModelAttrCount() {
        if (this.psSysDynaModelAttrList == null || this.psSysDynaModelAttrList.size() == 0) {
            return 0;
        }
        return this.psSysDynaModelAttrList.size();
    }

    @Override
    @PSModelRTMeta(description="\u6a21\u578b\u7528\u9014", codelist="DynaModelUsage", ignoredumpvalues="DATA", group="\u57fa\u672c", order=125)
    public String getUsage() {
        return this.strDynaModelUsage;
    }

    @Override
    @PSModelRTMeta(description="DTO\u4ee3\u7801\u6807\u8bc6", dump=false, fields={"DTOCODENAME"})
    public String getDTOCodeName() {
        return this.psSysDynaModel.getDTOCODENAME();
    }

    @Override
    public String getDumpModelType() {
        return "PSSYSDYNAMODEL";
    }

    @Override
    @PSModelRTMeta(description="\u6a21\u578b\u6807\u8bb0", fields={"MODELTAG"})
    public String getModelTag() {
        return this.psSysDynaModel.getMODELTAG();
    }

    @Override
    @PSModelRTMeta(description="\u6a21\u578b\u6807\u8bb02", fields={"MODELTAG2"})
    public String getModelTag2() {
        return this.psSysDynaModel.getMODELTAG2();
    }

    @Override
    @PSModelRTMeta(description="\u6a21\u578b\u6807\u8bb03", fields={"MODELTAG3"})
    public String getModelTag3() {
        return this.psSysDynaModel.getMODELTAG3();
    }

    @Override
    @PSModelRTMeta(description="\u6a21\u578b\u6807\u8bb04", fields={"MODELTAG4"})
    public String getModelTag4() {
        return this.psSysDynaModel.getMODELTAG4();
    }

    @Override
    protected void onFillModelNode(ObjectNode objectNode, String strModelType) throws Exception {
        super.onFillModelNode(objectNode, strModelType);
        if (("OPENAPI3SCHEMA".equals(this.getUsage()) || "LIQUIBASECHANGELOG".equals(this.getUsage()) || "JSONSCHEMA".equals(this.getUsage())) && objectNode.has("getContent")) {
            objectNode.remove("getContent");
        }
    }
}

