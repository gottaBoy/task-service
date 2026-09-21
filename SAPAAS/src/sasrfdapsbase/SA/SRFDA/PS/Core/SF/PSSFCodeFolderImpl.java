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
package SA.SRFDA.PS.Core.SF;

import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.SF.IPSSFCodeFolder;
import SA.SRFDA.PS.Core.SF.IPSSFCodeType;
import SA.SRFDA.PS.Core.SF.IPSSFStyle;
import SA.SRFDA.PS.Core.SF.IPSSFStylePrj;
import SA.SRFDA.PS.Core.SF.PSSFCodeTypeImpl;
import SA.SRFDA.PS.Data.PSSFCodeFolder;
import SA.SRFDA.PS.Data.PSSFCodeType;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSFCodeFolderImpl
extends PSObjectImpl
implements IPSSFCodeFolder {
    private static final Log log = LogFactory.getLog(PSSFCodeFolderImpl.class);
    protected IPSSFStyle iPSSFStyle = null;
    protected PSSFCodeFolder psSFCodeFolder = null;
    protected ArrayList<IPSSFCodeType> psSFCodeTypeList = new ArrayList();
    protected HashMap<String, IPSSFCodeType> psSFCodeTypeMap = new HashMap();
    private String strHeaderCode = null;
    private String strBottomCode = null;
    private int nModelLevel = IPSSystem.LOADLEVEL_PREVIEW;
    private String strPrjFolder = null;
    private IPSSFStylePrj iPSSFStylePrj = null;
    private String strFolderCode = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSFStyle iPSSFStyle, PSSFCodeFolder psSFCodeFolder) throws Exception {
        this.psSFCodeFolder = psSFCodeFolder;
        this.iPSSFStyle = iPSSFStyle;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(this.psSFCodeFolder.getPSSFCODEFOLDERID());
        this.setName(this.psSFCodeFolder.getPSSFCODEFOLDERNAME());
        this.setPSObjectData(this.psSFCodeFolder);
        this.strFolderCode = this.psSFCodeFolder.getFOLDERNAME();
        this.strHeaderCode = this.psSFCodeFolder.getHEADERCODE();
        this.strBottomCode = this.psSFCodeFolder.getBOTTOMCODE();
        if (!StringHelper.IsNullOrEmpty((String)this.psSFCodeFolder.getPSSFSTYLEPRJID())) {
            this.iPSSFStylePrj = iPSSFStyle.getPSSFStylePrj(this.psSFCodeFolder.getPSSFSTYLEPRJID(), false);
            this.strPrjFolder = this.psSFCodeFolder.getPRJFOLDER();
        }
        if (!this.psSFCodeFolder.isMODELLEVELNull()) {
            this.nModelLevel = this.psSFCodeFolder.getMODELLEVEL();
        }
        this.onInit();
    }

    @Override
    public String getFolderCode() {
        return this.strFolderCode;
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.onPreparePSSFCodeTypes();
    }

    protected void onPreparePSSFCodeTypes() throws Exception {
        this.psSFCodeTypeList.clear();
        this.psSFCodeTypeMap.clear();
        Vector<PSSFCodeType> psSFCodeTypeList = new Vector<PSSFCodeType>();
        CallResult callResult = this.getPSModelHelper().getPSSFCodeTypes(this.getId(), psSFCodeTypeList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u670d\u52a1\u6846\u67b6\u4ee3\u7801\u76ee\u5f55\u4ee3\u7801\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSSFCodeType psSFCodeType : psSFCodeTypeList) {
            if (!psSFCodeType.isVALIDFLAGNull() && psSFCodeType.getVALIDFLAG() == 0) continue;
            PSSFCodeTypeImpl iPSSFCodeType = new PSSFCodeTypeImpl();
            iPSSFCodeType.init(this.getDAGlobalHelper(), this, psSFCodeType);
            this.psSFCodeTypeMap.put(iPSSFCodeType.getId(), iPSSFCodeType);
            if (!StringHelper.IsNullOrEmpty((String)iPSSFCodeType.getTypeCode())) {
                this.psSFCodeTypeMap.put(iPSSFCodeType.getTypeCode(), iPSSFCodeType);
            }
            this.psSFCodeTypeList.add(iPSSFCodeType);
        }
    }

    @Override
    public Iterator<IPSSFCodeType> getPSSFCodeTypes() throws Exception {
        return this.psSFCodeTypeList.iterator();
    }

    @Override
    public IPSSFCodeType getPSSFCodeType(String strSFCodeTypeId) throws Exception {
        IPSSFCodeType iPSSFCodeType = this.psSFCodeTypeMap.get(strSFCodeTypeId);
        if (iPSSFCodeType == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u4ee3\u7801\u7c7b\u578b[%1$s]", (Object)strSFCodeTypeId));
        }
        return iPSSFCodeType;
    }

    @Override
    public IPSSFCodeType getPSSFCodeType(String strSFCodeTypeId, boolean bTryMode) throws Exception {
        IPSSFCodeType iPSSFCodeType = this.psSFCodeTypeMap.get(strSFCodeTypeId);
        if (iPSSFCodeType == null && !bTryMode) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u4ee3\u7801\u7c7b\u578b"));
        }
        return iPSSFCodeType;
    }

    @Override
    public void resetPSSFCodeType(String strSFCodeTypeId) throws Exception {
        IPSSFCodeType iPSSFCodeType = this.psSFCodeTypeMap.remove(strSFCodeTypeId);
        if (iPSSFCodeType != null) {
            this.psSFCodeTypeMap.remove(iPSSFCodeType.getId());
            if (!StringHelper.IsNullOrEmpty((String)iPSSFCodeType.getTypeCode())) {
                this.psSFCodeTypeMap.remove(iPSSFCodeType.getTypeCode());
            }
        }
    }

    @Override
    public IPSSFStyle getPSSFStyle() {
        return this.iPSSFStyle;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    public String getHeaderCode() {
        return this.strHeaderCode;
    }

    @Override
    public String getBottomCode() {
        return this.strBottomCode;
    }

    @Override
    public int getModelLevel() {
        return this.nModelLevel;
    }

    @Override
    public IPSSFStylePrj getPSSFStylePrj() {
        return this.iPSSFStylePrj;
    }

    @Override
    public String getPrjFolder() {
        return this.strPrjFolder;
    }
}

