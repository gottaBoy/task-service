/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.CodeSnippet;

import SA.SRFDA.PS.Core.CodeSnippet.IPSCodeSnippetType;
import SA.SRFDA.PS.Core.CodeSnippet.IPSDCCodeSnippet;
import SA.SRFDA.PS.Core.CodeSnippet.IPSDCCodeSnippetRef;
import SA.SRFDA.PS.Core.CodeSnippet.PSDCCodeSnippetRefImpl;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Pub.IPSCodeSnippetPublisher;
import SA.SRFDA.PS.Data.PSDCCodeSnippet;
import SA.SRFDA.PS.Data.PSDCCodeSnippetRef;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

public class PSDCCodeSnippetImpl
extends PSObjectImpl
implements IPSDCCodeSnippet {
    private PSDCCodeSnippet psDCCodeSnippet = null;
    protected ArrayList<IPSDCCodeSnippetRef> psDCCodeSnippetRefList = new ArrayList();
    protected HashMap<String, IPSDCCodeSnippetRef> psDCCodeSnippetRefMap = new HashMap();
    protected ArrayList<IPSCodeSnippetPublisher> psCodeSnippetPublisher = new ArrayList();
    private IPSCodeSnippetType iPSCodeSnippetType = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSDCCodeSnippet psDCCodeSnippet) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.psDCCodeSnippet = psDCCodeSnippet;
        this.setId(this.psDCCodeSnippet.getPSDCCODESNIPPETID());
        this.setName(this.psDCCodeSnippet.getPSDCCODESNIPPETNAME());
        this.setPSObjectData(psDCCodeSnippet);
        this.iPSCodeSnippetType = this.getPSModelStorage().getPSCodeSnippetType(this.psDCCodeSnippet.getCODETARGET());
        this.onInit();
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.onPreparePSDCCodeSnippetRefs();
    }

    protected void onPreparePSDCCodeSnippetRefs() throws Exception {
        this.psDCCodeSnippetRefList.clear();
        this.psDCCodeSnippetRefMap.clear();
        Vector<PSDCCodeSnippetRef> psDCCodeSnippetRefList = new Vector<PSDCCodeSnippetRef>();
        CallResult callResult = this.getPSModelHelper().getPSDCCodeSnippetRefs(this.getId(), psDCCodeSnippetRefList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5e94\u7528\u4e2d\u5fc3\u4ee3\u7801\u7247\u6bb5\u5f15\u7528\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSDCCodeSnippetRef psDCCodeSnippetRef : psDCCodeSnippetRefList) {
            PSDCCodeSnippetRefImpl iPSDCCodeSnippetRef = new PSDCCodeSnippetRefImpl();
            iPSDCCodeSnippetRef.init(this.getDAGlobalHelper(), this, psDCCodeSnippetRef);
            this.psDCCodeSnippetRefMap.put(iPSDCCodeSnippetRef.getId(), iPSDCCodeSnippetRef);
            this.psDCCodeSnippetRefMap.put(iPSDCCodeSnippetRef.getRefMode(), iPSDCCodeSnippetRef);
            this.psDCCodeSnippetRefList.add(iPSDCCodeSnippetRef);
        }
    }

    @Override
    public Iterator<IPSDCCodeSnippetRef> getPSDCCodeSnippetRefs() throws Exception {
        return this.psDCCodeSnippetRefList.iterator();
    }

    @Override
    public IPSDCCodeSnippetRef getPSDCCodeSnippetRef(String strDCCodeSnippetRefId) throws Exception {
        return this.getPSDCCodeSnippetRef(strDCCodeSnippetRefId, false);
    }

    @Override
    public IPSDCCodeSnippetRef getPSDCCodeSnippetRef(String strDCCodeSnippetRefId, boolean bTryMode) throws Exception {
        IPSDCCodeSnippetRef iPSDCCodeSnippetRef = this.psDCCodeSnippetRefMap.get(strDCCodeSnippetRefId);
        if (iPSDCCodeSnippetRef == null && !bTryMode) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5e94\u7528\u4e2d\u5fc3\u4ee3\u7801\u7247\u6bb5\u5f15\u7528"));
        }
        return iPSDCCodeSnippetRef;
    }

    @Override
    public void resetPSDCCodeSnippetRef(String strDCCodeSnippetRefId) throws Exception {
        this.psDCCodeSnippetRefMap.remove(strDCCodeSnippetRefId);
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    public IPSCodeSnippetType getPSCodeSnippetType() {
        return this.iPSCodeSnippetType;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public IPSCodeSnippetPublisher getPSCodeSnippetPublisher() throws Exception {
        ArrayList<IPSCodeSnippetPublisher> arrayList = this.psCodeSnippetPublisher;
        synchronized (arrayList) {
            if (this.psCodeSnippetPublisher.size() > 0) {
                return this.psCodeSnippetPublisher.remove(0);
            }
        }
        IPSCodeSnippetPublisher iPSCodeSnippetPublisher = this.getPSCodeSnippetType().createPSCodeSnippetPublisher(this);
        iPSCodeSnippetPublisher.init(this.getDAGlobalHelper(), this);
        return iPSCodeSnippetPublisher;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void releasePSCodeSnippetPublisher(IPSCodeSnippetPublisher iPSCodeSnippetPublisher) {
        ArrayList<IPSCodeSnippetPublisher> arrayList = this.psCodeSnippetPublisher;
        synchronized (arrayList) {
            this.psCodeSnippetPublisher.add(iPSCodeSnippetPublisher);
        }
    }

    @Override
    public PSDCCodeSnippet getPSDCCodeSnippetData() {
        return this.psDCCodeSnippet;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void resetPSCodeSnippetPublishers() {
        ArrayList<IPSCodeSnippetPublisher> arrayList = this.psCodeSnippetPublisher;
        synchronized (arrayList) {
            this.psCodeSnippetPublisher.clear();
        }
    }
}

