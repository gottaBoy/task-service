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
package SA.SRFDA.PS.Core.ER;

import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERBase;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.ER.IPSERMapNode;
import SA.SRFDA.PS.Core.ER.IPSSysERMap;
import SA.SRFDA.PS.Core.ER.IPSSysERMapNode;
import SA.SRFDA.PS.Core.ER.PSSysERMapNodeImpl;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSSystemObjectImpl;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPub;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Data.PSSysERMap;
import SA.SRFDA.PS.Data.PSSysERMapNode;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Vector;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysERMapImpl
extends PSSystemObjectImpl
implements IPSSysERMap {
    private static final Log log = LogFactory.getLog(PSSysERMapImpl.class);
    protected PSSysERMap psSysERMap = null;
    private ArrayList<IPSSysERMapNode> psSysERMapNodeList = new ArrayList();
    private String strCodeName = "";
    private IPSSystemModule iPSSystemModule = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem, PSSysERMap psSysERMap) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSystem(iPSSystem);
            this.psSysERMap = psSysERMap;
            this.setId(this.psSysERMap.getPSSYSERMAPID());
            this.setName(this.psSysERMap.getPSSYSERMAPNAME());
            this.setPSObjectData(this.psSysERMap);
            this.strCodeName = this.psSysERMap.getCODENAME();
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psSysERMap.getPSMODULEID())) {
                this.iPSSystemModule = this.getPSSystem().getPSSystemModule(this.psSysERMap.getPSMODULEID());
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
        this.onPreparePSSysERMapNodes();
        super.onInit();
    }

    protected void onPreparePSSysERMapNodes() throws Exception {
        this.psSysERMapNodeList.clear();
        Vector<PSSysERMapNode> psSysERMapNodeList = new Vector<PSSysERMapNode>();
        CallResult callResult = this.getPSModelHelper().getPSSysERMapNodes(this.getId(), psSysERMapNodeList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edfER\u56fe\u8282\u70b9\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        int nX = 100;
        int nY = 100;
        int nIndex = 0;
        int nRowCount = 4;
        for (PSSysERMapNode psSysERMapNode : psSysERMapNodeList) {
            int nColumn = nIndex % nRowCount;
            int nRow = nIndex / nRowCount;
            psSysERMapNode.setLEFTPOS(nX + 450 * nColumn);
            psSysERMapNode.setTOPPOS(nY + 550 * nRow);
            PSSysERMapNodeImpl iPSSysERMapNode = new PSSysERMapNodeImpl();
            iPSSysERMapNode.init(this.getDAGlobalHelper(), this, psSysERMapNode);
            this.psSysERMapNodeList.add(iPSSysERMapNode);
            ++nIndex;
        }
    }

    @Override
    @PSModelRTMeta(description="ER\u56fe\u8282\u70b9\u96c6\u5408", outputdoc="false", child=true)
    public Iterator<? extends IPSSysERMapNode> getPSSysERMapNodes() {
        if (this.psSysERMapNodeList.size() == 0) {
            return null;
        }
        return this.psSysERMapNodeList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u7f16\u53f7", group="\u57fa\u672c", order=105)
    public String getERMapSN() {
        return null;
    }

    @Override
    public String getModelType() {
        return "PSSYSERMAP";
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
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

    @Override
    public Iterator<? extends IPSERMapNode> getPSERMapNodes() {
        return this.getPSSysERMapNodes();
    }

    /*
     * Unable to fully structure code
     */
    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5173\u7cfb\u96c6\u5408", hideempty=true, group="\u57fa\u672c", order=140)
    public Iterator<? extends IPSDERBase> getPSDERs() throws Exception {
        map = new LinkedHashMap<String, IPSDataEntity>();
        psSysERMapNodes = this.getPSSysERMapNodes();
        if (psSysERMapNodes != null) ** GOTO lbl9
        return null;
lbl-1000:
        // 1 sources

        {
            iPSSysERMapNode = psSysERMapNodes.next();
            if (iPSSysERMapNode.getPSDataEntity() == null) continue;
            map.put(iPSSysERMapNode.getPSDataEntity().getId(), iPSSysERMapNode.getPSDataEntity());
lbl9:
            // 3 sources

            ** while (psSysERMapNodes.hasNext())
        }
lbl10:
        // 1 sources

        if (map.size() == 0) {
            return null;
        }
        psDERs = this.getPSSystem().getAllPSDERs();
        if (psDERs == null) {
            return null;
        }
        list = new ArrayList<IPSDERBase>();
        while (psDERs.hasNext()) {
            iPSDERBase = psDERs.next();
            if (!map.containsKey(iPSDERBase.getMajorPSDataEntity().getId()) || !map.containsKey(iPSDERBase.getMinorPSDataEntity().getId())) continue;
            list.add(iPSDERBase);
        }
        if (list.size() == 0) {
            return null;
        }
        return list.iterator();
    }
}

