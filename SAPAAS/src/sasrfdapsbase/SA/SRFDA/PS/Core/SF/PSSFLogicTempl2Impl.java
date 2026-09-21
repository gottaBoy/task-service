/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.SF;

import SA.SRFDA.PS.Core.Pub.IPSSFLogicCodePublisher;
import SA.SRFDA.PS.Core.Pub.PSSFLogicCodePublisher2Impl;
import SA.SRFDA.PS.Core.SF.IPSSF;
import SA.SRFDA.PS.Core.SF.IPSSFLogicTempl2;
import SA.SRFDA.PS.Core.SF.IPSSFLogicTemplDetail;
import SA.SRFDA.PS.Core.SF.IPSSFPubCode;
import SA.SRFDA.PS.Core.SF.IPSSFPubCode2;
import SA.SRFDA.PS.Core.SF.IPSSFStyle;
import SA.SRFDA.PS.Core.SF.IPSSFStyle2;
import SA.SRFDA.PS.Core.SF.PSSFLogicTemplDetailImpl;
import SA.SRFDA.PS.Core.SF.PSSFStyleObjectImpl;
import SA.SRFDA.PS.Core.Util.TemplFileHelper;
import SA.SRFDA.PS.Data.PSSFLogicTempl;
import SA.SRFDA.PS.Data.PSSFLogicTemplDetail;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import net.ibizsys.paas.util.KeyValueHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSFLogicTempl2Impl
extends PSSFStyleObjectImpl
implements IPSSFLogicTempl2 {
    protected PSSFLogicTempl psPFLogicTempl = null;
    private static final Log log = LogFactory.getLog(PSSFLogicTempl2Impl.class);
    protected ArrayList<IPSSFLogicCodePublisher> psPFLogicCodePublisher = new ArrayList();
    private long nLastResetTime = System.currentTimeMillis();
    private final long RESETTIMER = 600000L;
    private IPSSFPubCode2 iPSSFPubCode2 = null;
    private File templFile = null;
    private String strTemplFilePath = null;
    private boolean bCheckModelOnly = false;
    protected HashMap<String, IPSSFLogicTemplDetail> psSFLogicTemplDetailMap = new HashMap();

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSFPubCode2 iPSSFPubCode2, PSSFLogicTempl psPFLogicTempl) throws Exception {
        this.psPFLogicTempl = psPFLogicTempl;
        this.iPSSFPubCode2 = iPSSFPubCode2;
        this.setPSSF(this.iPSSFPubCode2.getPSSF());
        this.setPSSFStyle(this.iPSSFPubCode2.getPSSFStyle2());
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(this.psPFLogicTempl.getPSSFLOGICTEMPLID());
        this.setName(this.psPFLogicTempl.getPSSFLOGICTEMPLNAME());
        this.setPSObjectData(this.psPFLogicTempl);
        this.templFile = new File(this.psPFLogicTempl.getTEMPLCODE2());
        if (!this.templFile.exists()) {
            throw new Exception(StringHelper.Format((String)"\u6a21\u677f\u6587\u4ef6[%1$s]\u4e0d\u5b58\u5728", (Object)this.getName()));
        }
        this.psPFLogicTempl.setTEMPLCODE2("");
        this.strTemplFilePath = this.psPFLogicTempl.getTEMPLFILEPATH();
        this.bCheckModelOnly = this.psPFLogicTempl.getCHECKMODELONLY();
        this.onInit();
    }

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSF iPSSF, IPSSFStyle iPSSFStyle, PSSFLogicTempl psPFLogicTempl) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @Override
    protected void onInit() throws Exception {
        this.onPreparePSSFLogicTemplDetails();
        super.onInit();
    }

    protected void onPreparePSSFLogicTemplDetails() throws Exception {
        File[] files;
        File rootFolder = new File(((IPSSFStyle2)this.getPSSFStyle()).getRealLocalPath());
        String strTemplFilePath = this.templFile.getCanonicalPath();
        strTemplFilePath = String.valueOf(strTemplFilePath.substring(0, strTemplFilePath.length() - 4)) + "#";
        File[] fileArray = files = this.templFile.getParentFile().listFiles();
        int n = files.length;
        int n2 = 0;
        while (n2 < n) {
            String strSuffix;
            String strFilePath2;
            int nPos;
            String strFilePath;
            File file = fileArray[n2];
            if (!file.isDirectory() && (strFilePath = file.getCanonicalPath()).indexOf(strTemplFilePath) == 0 && (nPos = (strFilePath2 = strFilePath.substring(strTemplFilePath.length())).lastIndexOf(".")) > 0 && (strSuffix = strFilePath2.substring(nPos + 1)).compareToIgnoreCase("ftl") == 0) {
                String strTag = strFilePath2.substring(0, strFilePath2.length() - 4);
                TemplFileHelper templFileHelper = new TemplFileHelper();
                BaseDataEntity baseDataEntity = templFileHelper.getTemplData(file, rootFolder);
                String strTemplate = baseDataEntity.getParamStringValue("TEMPLATE", "");
                String strContent = baseDataEntity.getParamStringValue("CONTENT", "");
                if (StringHelper.Compare((String)(strTag = strTag.toUpperCase()), (String)"CODE2", (boolean)true) == 0) {
                    this.psPFLogicTempl.setTEMPLCODE2(strContent);
                } else if (StringHelper.Compare((String)strTag, (String)"CODE3", (boolean)true) == 0) {
                    this.psPFLogicTempl.setTEMPLCODE3(strContent);
                } else if (StringHelper.Compare((String)strTag, (String)"CODE4", (boolean)true) == 0) {
                    this.psPFLogicTempl.setTEMPLCODE4(strContent);
                } else {
                    PSSFLogicTemplDetail psSFLogicTemplDetail = new PSSFLogicTemplDetail();
                    psSFLogicTemplDetail.setTEMPLCODE(strContent);
                    psSFLogicTemplDetail.setPSSFLOGICDETAILID(KeyValueHelper.genUniqueId((String)this.getId(), (String)strTag));
                    psSFLogicTemplDetail.setPSSFLOGICDETAILNAME(strTag);
                    PSSFLogicTemplDetailImpl psSFLogicTemplDetailImpl = new PSSFLogicTemplDetailImpl();
                    psSFLogicTemplDetailImpl.init(this.getDAGlobalHelper(), this, psSFLogicTemplDetail);
                    this.psSFLogicTemplDetailMap.put(strTag, psSFLogicTemplDetailImpl);
                }
            }
            ++n2;
        }
    }

    @Override
    public IPSSFPubCode getPSSFPubCode() throws Exception {
        return this.iPSSFPubCode2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public IPSSFLogicCodePublisher getPSSFLogicCodePublisher() throws Exception {
        ArrayList<IPSSFLogicCodePublisher> arrayList = this.psPFLogicCodePublisher;
        synchronized (arrayList) {
            if (System.currentTimeMillis() - this.nLastResetTime > 600000L) {
                this.nLastResetTime = System.currentTimeMillis();
                this.psPFLogicCodePublisher.clear();
            } else if (this.psPFLogicCodePublisher.size() > 0) {
                return this.psPFLogicCodePublisher.remove(0);
            }
        }
        IPSSFLogicCodePublisher iPSSFLogicCodePublisher = this.createPSSFLogicCodePublisher();
        iPSSFLogicCodePublisher.init(this.getDAGlobalHelper(), this);
        return iPSSFLogicCodePublisher;
    }

    protected IPSSFLogicCodePublisher createPSSFLogicCodePublisher() throws Exception {
        if (!StringHelper.IsNullOrEmpty((String)this.psPFLogicTempl.getPUBOBJ())) {
            return (IPSSFLogicCodePublisher)ObjectHelper.Create((String)this.psPFLogicTempl.getPUBOBJ());
        }
        return new PSSFLogicCodePublisher2Impl();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void releasePSSFLogicCodePublisher(IPSSFLogicCodePublisher iPSSFLogicCodePublisher) {
        ArrayList<IPSSFLogicCodePublisher> arrayList = this.psPFLogicCodePublisher;
        synchronized (arrayList) {
            this.psPFLogicCodePublisher.add(iPSSFLogicCodePublisher);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void resetPSSFLogicCodePublishers() {
        ArrayList<IPSSFLogicCodePublisher> arrayList = this.psPFLogicCodePublisher;
        synchronized (arrayList) {
            this.psPFLogicCodePublisher.clear();
        }
    }

    @Override
    public PSSFLogicTempl getPSSFLogicTemplData() {
        return this.psPFLogicTempl;
    }

    @Override
    public String getTemplDocUrl() {
        return "http://www.ibizsys.net";
    }

    @Override
    public String getTemplFilePath() {
        return this.strTemplFilePath;
    }

    @Override
    public IPSSFLogicTemplDetail getPSSFLogicTemplDetail(String strName) throws Exception {
        return this.getPSSFLogicTemplDetail(strName, false);
    }

    @Override
    public IPSSFLogicTemplDetail getPSSFLogicTemplDetail(String strName, boolean bTryMode) throws Exception {
        IPSSFLogicTemplDetail iPSSFLogicTemplDetail = this.psSFLogicTemplDetailMap.get(strName);
        if (iPSSFLogicTemplDetail == null && !bTryMode) {
            throw new Exception(StringHelper.Format((String)"\u90e8\u4ef6\u6a21\u677f[%1$s]\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6210\u5458[%2$s][%3$s]\u6a21\u677f", (Object)this.getName(), (Object)strName, (Object)this.getPSSFPubCode().getName()));
        }
        return iPSSFLogicTemplDetail;
    }

    @Override
    public IPSSFLogicTemplDetail getPSSFLogicTemplDetail2(String strName, boolean bTryMode) throws Exception {
        return this.getPSSFLogicTemplDetail(strName, bTryMode);
    }

    @Override
    public IPSSFLogicTemplDetail getPSSFLogicTemplDetail2(String strName) throws Exception {
        return this.getPSSFLogicTemplDetail(strName, false);
    }

    @Override
    public boolean isCheckModelOnly() {
        return this.bCheckModelOnly;
    }
}

