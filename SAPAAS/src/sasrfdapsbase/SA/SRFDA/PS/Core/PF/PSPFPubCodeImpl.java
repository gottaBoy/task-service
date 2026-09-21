/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.PF;

import SA.SRFDA.PS.Core.PF.IPSPF;
import SA.SRFDA.PS.Core.PF.IPSPFCodeFolder;
import SA.SRFDA.PS.Core.PF.IPSPFPubCode;
import SA.SRFDA.PS.Core.PF.PSPFObjectImpl;
import SA.SRFDA.PS.Data.PSPFPubCode;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSPFPubCodeImpl
extends PSPFObjectImpl
implements IPSPFPubCode {
    protected PSPFPubCode psPFPubCode = null;
    private static final Log log = LogFactory.getLog(PSPFPubCodeImpl.class);
    private IPSPFCodeFolder iPSPFCodeFolder = null;
    private boolean bPreviewPubCode = false;
    private String strPreviewCode = "";
    private String strPluginTemplCode = "";
    protected HashMap<String, IPSPFPubCode> psPFPubCodeMap = null;
    private ArrayList<IPSPFPubCode> psPFPubCodeList = null;
    private IPSPFPubCode parentPSPFPubCode = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSPF iPSPF, IPSPFPubCode parentPSPFPubCode, PSPFPubCode psPFPubCode) throws Exception {
        this.psPFPubCode = psPFPubCode;
        this.setPSPF(iPSPF);
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(this.psPFPubCode.getPSPFPUBCODEID());
        this.setName(this.psPFPubCode.getPSPFPUBCODENAME());
        this.setPSObjectData(this.psPFPubCode);
        this.parentPSPFPubCode = parentPSPFPubCode;
        if (!this.psPFPubCode.isPREVIEWFLAGNull()) {
            this.bPreviewPubCode = this.psPFPubCode.getPREVIEWFLAG();
        }
        this.strPluginTemplCode = this.psPFPubCode.getPITEMPLCODE();
        this.strPreviewCode = this.psPFPubCode.getPREVIEWCODE();
        this.iPSPFCodeFolder = this.getPSPF().getPSPFCodeFolder(psPFPubCode.getPSPFCODEFOLDERID());
        this.onInit();
    }

    @Override
    public String getTargetType() {
        return this.psPFPubCode.getTARGETTYPE();
    }

    @Override
    public String getPKGCodeName() {
        return this.psPFPubCode.getPKGNAME();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void onPreparePSPFPubCodes() throws Exception {
        if (this.parentPSPFPubCode != null || this.psPFPubCode.isHASPSPFPUBCODENull() || !this.psPFPubCode.getHASPSPFPUBCODE()) {
            return;
        }
        if (this.psPFPubCodeMap == null) {
            this.psPFPubCodeMap = new HashMap();
            this.psPFPubCodeList = new ArrayList();
        }
        HashMap<String, IPSPFPubCode> hashMap = this.psPFPubCodeMap;
        synchronized (hashMap) {
            this.psPFPubCodeMap.clear();
            this.psPFPubCodeList.clear();
            Vector<PSPFPubCode> psPFPubCodeList = new Vector<PSPFPubCode>();
            CallResult callResullt = this.getPSModelHelper().getPSPFPubCodesByPPSPFPubCode(this.getId(), psPFPubCodeList);
            if (callResullt.isError()) {
                throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u524d\u7aef\u53d1\u5e03\u4ee3\u7801\u5b50\u4ee3\u7801\u6e05\u5355\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResullt.getErrorInfo()));
            }
            for (PSPFPubCode psPFPubCode : psPFPubCodeList) {
                if (!psPFPubCode.isVALIDFLAGNull() && !psPFPubCode.getVALIDFLAG() || !StringHelper.IsNullOrEmpty((String)psPFPubCode.getPPSPFPUBCODEID())) continue;
                PSPFPubCodeImpl iPSPFPubCode = new PSPFPubCodeImpl();
                iPSPFPubCode.init(this.getDAGlobalHelper(), this.getPSPF(), this, psPFPubCode);
                this.psPFPubCodeMap.put(iPSPFPubCode.getId(), iPSPFPubCode);
                if (!StringHelper.IsNullOrEmpty((String)iPSPFPubCode.getName())) {
                    this.psPFPubCodeMap.put(iPSPFPubCode.getName(), iPSPFPubCode);
                }
                this.psPFPubCodeList.add(iPSPFPubCode);
            }
        }
    }

    @Override
    public String getClassNameExt() {
        return this.psPFPubCode.getCLASSEXT();
    }

    @Override
    public String getFileNameExt() {
        return this.psPFPubCode.getCODEEXT();
    }

    @Override
    public String getCodeFolder() {
        return this.psPFPubCode.getCODEFOLDER();
    }

    @Override
    public IPSPFCodeFolder getPSPFCodeFolder() {
        return this.iPSPFCodeFolder;
    }

    @Override
    public String getPreviewCode() {
        return this.strPreviewCode;
    }

    @Override
    public String getPluginTemplCode() {
        return this.strPluginTemplCode;
    }

    @Override
    public IPSPFPubCode getParentPSPFPubCode() {
        return this.parentPSPFPubCode;
    }

    @Override
    public Iterator<IPSPFPubCode> getChildPSPFPubCodes() {
        if (this.psPFPubCodeList == null || this.psPFPubCodeList.size() == 0) {
            return null;
        }
        return this.psPFPubCodeList.iterator();
    }
}

