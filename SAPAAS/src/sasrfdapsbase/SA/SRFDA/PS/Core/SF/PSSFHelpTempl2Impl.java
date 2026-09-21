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

import SA.SRFDA.PS.Core.Pub.IPSSFHelpCodePublisher;
import SA.SRFDA.PS.Core.Pub.PSSFHelpCodePublisher2Impl;
import SA.SRFDA.PS.Core.SF.IPSSF;
import SA.SRFDA.PS.Core.SF.IPSSFHelpTempl2;
import SA.SRFDA.PS.Core.SF.IPSSFHelpTemplDetail;
import SA.SRFDA.PS.Core.SF.IPSSFPubCode;
import SA.SRFDA.PS.Core.SF.IPSSFPubCode2;
import SA.SRFDA.PS.Core.SF.IPSSFStyle;
import SA.SRFDA.PS.Core.SF.IPSSFStyle2;
import SA.SRFDA.PS.Core.SF.PSSFHelpTemplDetailImpl;
import SA.SRFDA.PS.Core.SF.PSSFStyleObjectImpl;
import SA.SRFDA.PS.Core.Util.TemplFileHelper;
import SA.SRFDA.PS.Data.PSSFHelpTempl;
import SA.SRFDA.PS.Data.PSSFHelpTemplDetail;
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

public class PSSFHelpTempl2Impl
extends PSSFStyleObjectImpl
implements IPSSFHelpTempl2 {
    protected PSSFHelpTempl psPFDBTempl = null;
    private static final Log log = LogFactory.getLog(PSSFHelpTempl2Impl.class);
    protected ArrayList<IPSSFHelpCodePublisher> psPFDBCodePublisher = new ArrayList();
    private long nLastResetTime = System.currentTimeMillis();
    private final long RESETTIMER = 600000L;
    private IPSSFPubCode2 iPSSFPubCode2 = null;
    private File templFile = null;
    private String strTemplFilePath = null;
    protected HashMap<String, IPSSFHelpTemplDetail> psSFHelpTemplDetailMap = new HashMap();

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSFPubCode2 iPSSFPubCode2, PSSFHelpTempl psPFDBTempl) throws Exception {
        this.psPFDBTempl = psPFDBTempl;
        this.iPSSFPubCode2 = iPSSFPubCode2;
        this.setPSSF(this.iPSSFPubCode2.getPSSF());
        this.setPSSFStyle(this.iPSSFPubCode2.getPSSFStyle2());
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(this.psPFDBTempl.getPSSFHELPTEMPLID());
        this.setName(this.psPFDBTempl.getPSSFHELPTEMPLNAME());
        this.setPSObjectData(this.psPFDBTempl);
        this.templFile = new File(this.psPFDBTempl.getTEMPLCODE2());
        if (!this.templFile.exists()) {
            throw new Exception(StringHelper.Format((String)"\u6a21\u677f\u6587\u4ef6[%1$s]\u4e0d\u5b58\u5728", (Object)this.getName()));
        }
        this.psPFDBTempl.setTEMPLCODE2("");
        this.strTemplFilePath = this.psPFDBTempl.getTEMPLFILEPATH();
        this.onInit();
    }

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSF iPSSF, IPSSFStyle iPSSFStyle, PSSFHelpTempl psPFDBTempl) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @Override
    protected void onInit() throws Exception {
        this.onPreparePSSFHelpTemplDetails();
        super.onInit();
    }

    protected void onPreparePSSFHelpTemplDetails() throws Exception {
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
                    this.psPFDBTempl.setTEMPLCODE2(strContent);
                } else if (StringHelper.Compare((String)strTag, (String)"CODE3", (boolean)true) == 0) {
                    this.psPFDBTempl.setTEMPLCODE3(strContent);
                } else if (StringHelper.Compare((String)strTag, (String)"CODE4", (boolean)true) == 0) {
                    this.psPFDBTempl.setTEMPLCODE4(strContent);
                } else {
                    PSSFHelpTemplDetail psSFHelpTemplDetail = new PSSFHelpTemplDetail();
                    psSFHelpTemplDetail.setTEMPLCODE(strContent);
                    psSFHelpTemplDetail.setPSSFHELPDETAILID(KeyValueHelper.genUniqueId((String)this.getId(), (String)strTag));
                    psSFHelpTemplDetail.setPSSFHELPDETAILNAME(strTag);
                    PSSFHelpTemplDetailImpl psSFHelpTemplDetailImpl = new PSSFHelpTemplDetailImpl();
                    psSFHelpTemplDetailImpl.init(this.getDAGlobalHelper(), this, psSFHelpTemplDetail);
                    this.psSFHelpTemplDetailMap.put(strTag, psSFHelpTemplDetailImpl);
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
    public IPSSFHelpCodePublisher getPSSFHelpCodePublisher() throws Exception {
        ArrayList<IPSSFHelpCodePublisher> arrayList = this.psPFDBCodePublisher;
        synchronized (arrayList) {
            if (System.currentTimeMillis() - this.nLastResetTime > 600000L) {
                this.nLastResetTime = System.currentTimeMillis();
                this.psPFDBCodePublisher.clear();
            } else if (this.psPFDBCodePublisher.size() > 0) {
                return this.psPFDBCodePublisher.remove(0);
            }
        }
        IPSSFHelpCodePublisher iPSSFHelpCodePublisher = this.createPSSFHelpCodePublisher();
        iPSSFHelpCodePublisher.init(this.getDAGlobalHelper(), this);
        return iPSSFHelpCodePublisher;
    }

    protected IPSSFHelpCodePublisher createPSSFHelpCodePublisher() throws Exception {
        if (!StringHelper.IsNullOrEmpty((String)this.psPFDBTempl.getPUBOBJ())) {
            return (IPSSFHelpCodePublisher)ObjectHelper.Create((String)this.psPFDBTempl.getPUBOBJ());
        }
        return new PSSFHelpCodePublisher2Impl();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void releasePSSFHelpCodePublisher(IPSSFHelpCodePublisher iPSSFHelpCodePublisher) {
        ArrayList<IPSSFHelpCodePublisher> arrayList = this.psPFDBCodePublisher;
        synchronized (arrayList) {
            this.psPFDBCodePublisher.add(iPSSFHelpCodePublisher);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void resetPSSFHelpCodePublishers() {
        ArrayList<IPSSFHelpCodePublisher> arrayList = this.psPFDBCodePublisher;
        synchronized (arrayList) {
            this.psPFDBCodePublisher.clear();
        }
    }

    @Override
    public PSSFHelpTempl getPSSFHelpTemplData() {
        return this.psPFDBTempl;
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
    public IPSSFHelpTemplDetail getPSSFHelpTemplDetail(String strName) throws Exception {
        return this.getPSSFHelpTemplDetail(strName, false);
    }

    @Override
    public IPSSFHelpTemplDetail getPSSFHelpTemplDetail(String strName, boolean bTryMode) throws Exception {
        IPSSFHelpTemplDetail iPSSFHelpTemplDetail = this.psSFHelpTemplDetailMap.get(strName);
        if (iPSSFHelpTemplDetail == null && !bTryMode) {
            throw new Exception(StringHelper.Format((String)"\u90e8\u4ef6\u6a21\u677f[%1$s]\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6210\u5458[%2$s][%3$s]\u6a21\u677f", (Object)this.getName(), (Object)strName, (Object)this.getPSSFPubCode().getName()));
        }
        return iPSSFHelpTemplDetail;
    }

    @Override
    public IPSSFHelpTemplDetail getPSSFHelpTemplDetail2(String strName, boolean bTryMode) throws Exception {
        return this.getPSSFHelpTemplDetail(strName, bTryMode);
    }

    @Override
    public IPSSFHelpTemplDetail getPSSFHelpTemplDetail2(String strName) throws Exception {
        return this.getPSSFHelpTemplDetail(strName, false);
    }
}

