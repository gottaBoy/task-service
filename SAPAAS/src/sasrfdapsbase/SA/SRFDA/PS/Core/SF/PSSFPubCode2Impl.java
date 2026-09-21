/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.SF;

import SA.SRFDA.PS.Core.SF.IPSSF;
import SA.SRFDA.PS.Core.SF.IPSSFCodeFolder;
import SA.SRFDA.PS.Core.SF.IPSSFCodeFolder2;
import SA.SRFDA.PS.Core.SF.IPSSFPubCode;
import SA.SRFDA.PS.Core.SF.IPSSFPubCode2;
import SA.SRFDA.PS.Core.SF.IPSSFStyle2;
import SA.SRFDA.PS.Core.SF.PSSFObjectImpl;
import SA.SRFDA.PS.Data.PSSFPubCode;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSFPubCode2Impl
extends PSSFObjectImpl
implements IPSSFPubCode2 {
    protected PSSFPubCode psSFPubCode = null;
    private static final Log log = LogFactory.getLog(PSSFPubCode2Impl.class);
    private IPSSFCodeFolder2 iPSSFCodeFolder = null;
    private boolean bPreviewPubCode = false;
    private String strPreviewCode = "";
    private String strPluginTemplCode = "";
    protected HashMap<String, IPSSFPubCode> psSFPubCodeMap = null;
    private ArrayList<IPSSFPubCode> psSFPubCodeList = null;
    private IPSSFPubCode parentPSSFPubCode = null;
    private IPSSFStyle2 iPSSFStyle2 = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSFStyle2 iPSSFStyle2, IPSSFCodeFolder2 iPSSFCodeFolder, PSSFPubCode psSFPubCode) throws Exception {
        this.psSFPubCode = psSFPubCode;
        this.iPSSFCodeFolder = iPSSFCodeFolder;
        this.iPSSFStyle2 = iPSSFStyle2;
        this.setPSSF(this.iPSSFStyle2.getPSSF());
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(this.psSFPubCode.getPSSFPUBCODEID());
        this.setName(this.psSFPubCode.getPSSFPUBCODENAME());
        this.setPSObjectData(this.psSFPubCode);
        if (!this.psSFPubCode.isPREVIEWFLAGNull()) {
            this.bPreviewPubCode = this.psSFPubCode.getPREVIEWFLAG();
        }
        this.strPluginTemplCode = this.psSFPubCode.getPITEMPLCODE();
        this.strPreviewCode = this.psSFPubCode.getPREVIEWCODE();
        this.onInit();
    }

    @Override
    public String getTargetType() {
        return this.psSFPubCode.getTARGETTYPE();
    }

    @Override
    public String getPKGCodeName() {
        return this.psSFPubCode.getPKGNAME();
    }

    @Override
    public String getClassNameExt() {
        return this.psSFPubCode.getCLASSEXT();
    }

    @Override
    public String getFileNameExt() {
        return this.psSFPubCode.getCODEEXT();
    }

    @Override
    public String getCodeFolder() {
        return this.psSFPubCode.getCODEFOLDER();
    }

    @Override
    public IPSSFCodeFolder getPSSFCodeFolder() {
        return this.iPSSFCodeFolder;
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
    public IPSSFPubCode getParentPSSFPubCode() {
        return this.parentPSSFPubCode;
    }

    @Override
    public Iterator<IPSSFPubCode> getChildPSSFPubCodes() {
        if (this.psSFPubCodeList == null || this.psSFPubCodeList.size() == 0) {
            return null;
        }
        return this.psSFPubCodeList.iterator();
    }

    @Override
    public IPSSFStyle2 getPSSFStyle2() {
        return this.iPSSFStyle2;
    }

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSF iPSSF, IPSSFPubCode parentPSSFPubCode, PSSFPubCode psSFPubCode) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }
}

