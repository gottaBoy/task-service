/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.PF;

import SA.SRFDA.PS.Core.PF.IPSPF;
import SA.SRFDA.PS.Core.PF.IPSPFCodeFolder;
import SA.SRFDA.PS.Core.PF.IPSPFCodeFolder2;
import SA.SRFDA.PS.Core.PF.IPSPFPubCode;
import SA.SRFDA.PS.Core.PF.IPSPFPubCode2;
import SA.SRFDA.PS.Core.PF.IPSPFStyle2;
import SA.SRFDA.PS.Core.PF.PSPFObjectImpl;
import SA.SRFDA.PS.Data.PSPFPubCode;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSPFPubCode2Impl
extends PSPFObjectImpl
implements IPSPFPubCode2 {
    protected PSPFPubCode psPFPubCode = null;
    private static final Log log = LogFactory.getLog(PSPFPubCode2Impl.class);
    private IPSPFCodeFolder2 iPSPFCodeFolder = null;
    private boolean bPreviewPubCode = false;
    private String strPreviewCode = "";
    private String strPluginTemplCode = "";
    protected HashMap<String, IPSPFPubCode> psPFPubCodeMap = null;
    private ArrayList<IPSPFPubCode> psPFPubCodeList = null;
    private IPSPFPubCode parentPSPFPubCode = null;
    private IPSPFStyle2 iPSPFStyle2 = null;
    private IPSPFPubCode originPSPFPubCode = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSPFStyle2 iPSPFStyle2, IPSPFCodeFolder2 iPSPFCodeFolder, PSPFPubCode psPFPubCode) throws Exception {
        this.psPFPubCode = psPFPubCode;
        this.iPSPFCodeFolder = iPSPFCodeFolder;
        this.iPSPFStyle2 = iPSPFStyle2;
        this.setPSPF(this.iPSPFStyle2.getPSPF());
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(this.psPFPubCode.getPSPFPUBCODEID());
        this.setName(this.psPFPubCode.getPSPFPUBCODENAME());
        this.setPSObjectData(this.psPFPubCode);
        if (!this.psPFPubCode.isPREVIEWFLAGNull()) {
            this.bPreviewPubCode = this.psPFPubCode.getPREVIEWFLAG();
        }
        this.strPluginTemplCode = this.psPFPubCode.getPITEMPLCODE();
        this.strPreviewCode = this.psPFPubCode.getPREVIEWCODE();
        if (iPSPFStyle2.getPFEngineVer() < 20) {
            Iterator<IPSPFPubCode> psPFPubCodes;
            String[] items = this.getName().split("[.]");
            String strOldName = items[0];
            if ((StringHelper.compare((String)this.getTargetType(), (String)"APP", (boolean)true) == 0 || StringHelper.compare((String)this.getTargetType(), (String)"VIEW", (boolean)true) == 0 || StringHelper.compare((String)this.getTargetType(), (String)"VIEWCTRL", (boolean)true) == 0) && (psPFPubCodes = this.iPSPFStyle2.getPSPF().getPSPFPubCodes(this.getTargetType(), true)) != null) {
                while (psPFPubCodes.hasNext()) {
                    IPSPFPubCode iPSPFPubCode = psPFPubCodes.next();
                    if (StringHelper.compare((String)iPSPFPubCode.getName(), (String)strOldName, (boolean)true) != 0) continue;
                    this.originPSPFPubCode = iPSPFPubCode;
                    break;
                }
            }
        }
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

    @Override
    public String getClassNameExt() {
        if (this.originPSPFPubCode != null) {
            return this.originPSPFPubCode.getClassNameExt();
        }
        return this.psPFPubCode.getCLASSEXT();
    }

    @Override
    public String getFileNameExt() {
        if (this.originPSPFPubCode != null) {
            return this.originPSPFPubCode.getFileNameExt();
        }
        return this.psPFPubCode.getCODEEXT();
    }

    @Override
    public String getCodeFolder() {
        if (this.originPSPFPubCode != null) {
            return this.originPSPFPubCode.getCodeFolder();
        }
        if (!StringHelper.isNullOrEmpty((String)this.psPFPubCode.getCODEFOLDER())) {
            return this.psPFPubCode.getCODEFOLDER();
        }
        return "";
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
        if (this.originPSPFPubCode != null) {
            return this.originPSPFPubCode.getPluginTemplCode();
        }
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

    @Override
    public IPSPFStyle2 getPSPFStyle2() {
        return this.iPSPFStyle2;
    }

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSPF iPSPF, IPSPFPubCode parentPSPFPubCode, PSPFPubCode psPFPubCode) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @Override
    public IPSPFPubCode getOriginPSPFPubCode() {
        return this.originPSPFPubCode;
    }
}

