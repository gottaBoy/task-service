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
package SA.SRFDA.PS.Core.UML;

import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSSystemObjectImpl;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPub;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Core.UML.IPSSysActor;
import SA.SRFDA.PS.Core.UML.IPSSysUCMap;
import SA.SRFDA.PS.Core.UML.IPSSysUCMapNode;
import SA.SRFDA.PS.Core.UML.IPSSysUseCase;
import SA.SRFDA.PS.Core.UML.IPSSysUseCaseRS;
import SA.SRFDA.PS.Core.UML.PSSysUCMapNodeImpl;
import SA.SRFDA.PS.Data.PSSysUCMap;
import SA.SRFDA.PS.Data.PSSysUCMapNode;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Vector;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysUCMapImpl
extends PSSystemObjectImpl
implements IPSSysUCMap {
    private static final Log log = LogFactory.getLog(PSSysUCMapImpl.class);
    protected PSSysUCMap psSysUCMap = null;
    private ArrayList<IPSSysUCMapNode> psSysUCMapNodeList = new ArrayList();
    private String strCodeName = "";
    private IPSSystemModule iPSSystemModule = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem, PSSysUCMap psSysUCMap) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSystem(iPSSystem);
            this.psSysUCMap = psSysUCMap;
            this.setId(this.psSysUCMap.getPSSYSUCMAPID());
            this.setName(this.psSysUCMap.getPSSYSUCMAPNAME());
            this.setPSObjectData(this.psSysUCMap);
            this.strCodeName = this.psSysUCMap.getCODENAME();
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psSysUCMap.getPSMODULEID())) {
                this.iPSSystemModule = this.getPSSystem().getPSSystemModule(this.psSysUCMap.getPSMODULEID());
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
        this.onPreparePSSysUCMapNodes();
        super.onInit();
    }

    protected void onPreparePSSysUCMapNodes() throws Exception {
        this.psSysUCMapNodeList.clear();
        Vector<PSSysUCMapNode> psSysUCMapNodeList = new Vector<PSSysUCMapNode>();
        CallResult callResult = this.getPSModelHelper().getPSSysUCMapNodes(this.getId(), psSysUCMapNodeList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edfUC\u56fe\u8282\u70b9\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        int nX = 100;
        int nY = 100;
        int nIndex = 0;
        int nRowCount = 4;
        for (PSSysUCMapNode psSysUCMapNode : psSysUCMapNodeList) {
            int nColumn = nIndex % nRowCount;
            int nRow = nIndex / nRowCount;
            psSysUCMapNode.setLEFTPOS(nX + 450 * nColumn);
            psSysUCMapNode.setTOPPOS(nY + 550 * nRow);
            PSSysUCMapNodeImpl iPSSysUCMapNode = new PSSysUCMapNodeImpl();
            iPSSysUCMapNode.init(this.getDAGlobalHelper(), this, psSysUCMapNode);
            this.psSysUCMapNodeList.add(iPSSysUCMapNode);
            ++nIndex;
        }
    }

    @Override
    @PSModelRTMeta(description="UC\u56fe\u8282\u70b9\u5173\u7cfb\u96c6\u5408", child=true)
    public Iterator<? extends IPSSysUCMapNode> getPSSysUCMapNodes() {
        if (this.psSysUCMapNodeList.size() == 0) {
            return null;
        }
        return this.psSysUCMapNodeList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u7528\u4f8b\u5173\u7cfb\u96c6\u5408", child=true)
    public Iterator<? extends IPSSysUseCaseRS> getPSSysUseCaseRSs() throws Exception {
        Iterator<? extends IPSSysUCMapNode> psSysUCMapNodes = this.getPSSysUCMapNodes();
        if (psSysUCMapNodes == null) {
            return null;
        }
        Iterator<IPSSysUseCaseRS> psSysUseCaseRSs = this.getPSSystem().getAllPSSysUseCaseRSs();
        if (psSysUseCaseRSs == null) {
            return null;
        }
        LinkedHashMap<String, IPSSysActor> psSysActorMap = new LinkedHashMap<String, IPSSysActor>();
        LinkedHashMap<String, IPSSysUseCase> psSysUseCaseMap = new LinkedHashMap<String, IPSSysUseCase>();
        ArrayList<IPSSysUseCaseRS> psSysUseCaseRSList = new ArrayList<IPSSysUseCaseRS>();
        while (psSysUCMapNodes.hasNext()) {
            IPSSysUCMapNode iPSSysUCMapNode = psSysUCMapNodes.next();
            if (SA.SRFramework.Utility.StringHelper.Compare((String)iPSSysUCMapNode.getNodeType(), (String)"ACTOR", (boolean)false) == 0) {
                if (iPSSysUCMapNode.getPSSysActor() == null) continue;
                psSysActorMap.put(iPSSysUCMapNode.getPSSysActor().getId(), iPSSysUCMapNode.getPSSysActor());
                continue;
            }
            if (SA.SRFramework.Utility.StringHelper.Compare((String)iPSSysUCMapNode.getNodeType(), (String)"USECASE", (boolean)false) != 0 || iPSSysUCMapNode.getPSSysUseCase() == null) continue;
            psSysUseCaseMap.put(iPSSysUCMapNode.getPSSysUseCase().getId(), iPSSysUCMapNode.getPSSysUseCase());
        }
        while (psSysUseCaseRSs.hasNext()) {
            IPSSysUseCaseRS iPSSysUseCaseRS = psSysUseCaseRSs.next();
            if (iPSSysUseCaseRS.getFromPSSysActor() != null && !psSysActorMap.containsKey(iPSSysUseCaseRS.getFromPSSysActor().getId()) || iPSSysUseCaseRS.getToPSSysActor() != null && !psSysActorMap.containsKey(iPSSysUseCaseRS.getToPSSysActor().getId()) || iPSSysUseCaseRS.getFromPSSysUseCase() != null && !psSysUseCaseMap.containsKey(iPSSysUseCaseRS.getFromPSSysUseCase().getId()) || iPSSysUseCaseRS.getToPSSysUseCase() != null && !psSysUseCaseMap.containsKey(iPSSysUseCaseRS.getToPSSysUseCase().getId())) continue;
            psSysUseCaseRSList.add(iPSSysUseCaseRS);
        }
        if (psSysUseCaseRSList.size() == 0) {
            return null;
        }
        return psSysUseCaseRSList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u7f16\u53f7", group="\u57fa\u672c", order=105)
    public String getUCMapSN() {
        return null;
    }

    @Override
    public String getModelType() {
        return "PSSYSUCMAP";
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
    @PSModelRTMeta(description="\u7cfb\u7edf\u6a21\u5757", hideempty=true, dumpref=true)
    public IPSSystemModule getPSSystemModule() {
        return this.iPSSystemModule;
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

