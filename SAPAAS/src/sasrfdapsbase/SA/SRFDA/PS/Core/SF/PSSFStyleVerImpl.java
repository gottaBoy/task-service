/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.SF;

import SA.SRFDA.PS.Core.SF.IPSSFStyle;
import SA.SRFDA.PS.Core.SF.IPSSFStyleVer;
import SA.SRFDA.PS.Core.SF.IPSSFVerCode;
import SA.SRFDA.PS.Core.SF.PSSFObjectImpl;
import SA.SRFDA.PS.Core.SF.PSSFVerCodeImpl;
import SA.SRFDA.PS.Data.PSSFStyleVer;
import SA.SRFDA.PS.Data.PSSFVerCode;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

public class PSSFStyleVerImpl
extends PSSFObjectImpl
implements IPSSFStyleVer {
    private IPSSFStyle iPSSFStyle = null;
    private PSSFStyleVer psSFStyleVer = null;
    protected ArrayList<IPSSFVerCode> psSFVerCodeList = new ArrayList();
    protected HashMap<String, IPSSFVerCode> psSFVerCodeMap = new HashMap();

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSFStyle iPSSFStyle, PSSFStyleVer psSFStyleVer) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.iPSSFStyle = iPSSFStyle;
        this.psSFStyleVer = psSFStyleVer;
        this.setPSSF(this.iPSSFStyle.getPSSF());
        this.setId(this.psSFStyleVer.getPSSFSTYLEVERID());
        this.setName(this.psSFStyleVer.getPSSFSTYLEVERNAME());
        this.setVersion(this.psSFStyleVer.getMAJOR());
        this.setPSObjectData(psSFStyleVer);
        this.onInit();
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.onPreparePSSFVerCodes();
    }

    protected void onPreparePSSFVerCodes() throws Exception {
        this.psSFVerCodeList.clear();
        this.psSFVerCodeMap.clear();
        Vector<PSSFVerCode> psSFVerCodeList = new Vector<PSSFVerCode>();
        CallResult callResult = this.getPSModelHelper().getPSSFVerCodes(this.getId(), psSFVerCodeList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u670d\u52a1\u6846\u67b6\u6837\u5f0f\u7248\u672c\u4ee3\u7801\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSSFVerCode psSFVerCode : psSFVerCodeList) {
            if (!psSFVerCode.isVALIDFLAGNull() && psSFVerCode.getVALIDFLAG() == 0) continue;
            PSSFVerCodeImpl iPSSFVerCode = new PSSFVerCodeImpl();
            iPSSFVerCode.init(this.getDAGlobalHelper(), this, psSFVerCode);
            this.psSFVerCodeMap.put(iPSSFVerCode.getId(), iPSSFVerCode);
            this.psSFVerCodeList.add(iPSSFVerCode);
        }
    }

    @Override
    public IPSSFStyle getPSSFStyle() {
        return this.iPSSFStyle;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSSFStyle().getPSSysModelInstId();
    }

    @Override
    public Iterator<IPSSFVerCode> getPSSFVerCodes() throws Exception {
        return this.psSFVerCodeList.iterator();
    }

    @Override
    public IPSSFVerCode getPSSFVerCode(String strSFVerCodeId) throws Exception {
        IPSSFVerCode iPSSFVerCode = this.psSFVerCodeMap.get(strSFVerCodeId);
        if (iPSSFVerCode == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u7248\u672c\u4ee3\u7801"));
        }
        return iPSSFVerCode;
    }

    @Override
    public void resetPSSFVerCode(String strSFVerCodeId) throws Exception {
        this.psSFVerCodeMap.remove(strSFVerCodeId);
    }
}

