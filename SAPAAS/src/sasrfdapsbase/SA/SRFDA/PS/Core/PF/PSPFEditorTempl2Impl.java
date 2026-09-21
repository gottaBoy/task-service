/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.PF;

import SA.SRFDA.PS.Core.Control.IPSEditorType;
import SA.SRFDA.PS.Core.PF.IPSPF;
import SA.SRFDA.PS.Core.PF.IPSPFEditorTempl2;
import SA.SRFDA.PS.Core.PF.IPSPFPubCode;
import SA.SRFDA.PS.Core.PF.IPSPFStyle;
import SA.SRFDA.PS.Core.PF.IPSPFStyle2;
import SA.SRFDA.PS.Core.PF.PSPFStyleObjectImpl;
import SA.SRFDA.PS.Core.Pub.IPSPFEditorCodePublisher;
import SA.SRFDA.PS.Core.Pub.PSPFEditorCodePublisher2Impl;
import SA.SRFDA.PS.Core.Util.TemplFileHelper;
import SA.SRFDA.PS.Data.PSPFEditorTempl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import java.io.File;
import java.util.ArrayList;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSPFEditorTempl2Impl
extends PSPFStyleObjectImpl
implements IPSPFEditorTempl2 {
    protected PSPFEditorTempl psPFEditorTempl = null;
    private static final Log log = LogFactory.getLog(PSPFEditorTempl2Impl.class);
    protected ArrayList<IPSPFEditorCodePublisher> psPFEditorCodePublisher = new ArrayList();
    private IPSEditorType iPSEditorType = null;
    private String strContainerType = null;
    private long nLastResetTime = System.currentTimeMillis();
    private final long RESETTIMER = 600000L;
    private IPSPFPubCode iPSPFPubCode = null;
    private File templFile = null;
    private String strTemplFilePath = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSPF iPSPF, IPSPFStyle iPSPFStyle, IPSPFPubCode iPSPFPubCode, PSPFEditorTempl psPFEditorTempl) throws Exception {
        this.psPFEditorTempl = psPFEditorTempl;
        this.setPSPF(iPSPF);
        this.setPSPFStyle(iPSPFStyle);
        this.iPSPFPubCode = iPSPFPubCode;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(this.psPFEditorTempl.getPSPFEDITORTEMPLID());
        this.setName(this.psPFEditorTempl.getPSPFEDITORTEMPLNAME());
        this.setPSObjectData(this.psPFEditorTempl);
        try {
            this.iPSEditorType = this.getPSModelStorage().getPSEditorType(psPFEditorTempl.getPSEDITORTYPEID());
        }
        catch (Exception ex) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u7f16\u8f91\u5668\u7c7b\u578b[%1$s]", (Object)psPFEditorTempl.getPSEDITORTYPEID()));
        }
        this.strContainerType = psPFEditorTempl.getCONTAINERTYPE();
        if (!StringHelper.IsNullOrEmpty((String)this.psPFEditorTempl.getTEMPLCODE2())) {
            this.templFile = new File(this.psPFEditorTempl.getTEMPLCODE2());
            if (!this.templFile.exists()) {
                throw new Exception(StringHelper.Format((String)"\u6a21\u677f\u6587\u4ef6[%1$s]\u4e0d\u5b58\u5728", (Object)this.getName()));
            }
        }
        this.psPFEditorTempl.setTEMPLCODE2("");
        this.strTemplFilePath = this.psPFEditorTempl.getTEMPLFILEPATH();
        this.onInit();
    }

    @Override
    protected void onInit() throws Exception {
        this.onPreparePSPFEditorTemplDetails();
        super.onInit();
    }

    protected void onPreparePSPFEditorTemplDetails() throws Exception {
        File[] files;
        if (this.templFile == null) {
            return;
        }
        File rootFolder = new File(((IPSPFStyle2)this.getPSPFStyle()).getRealLocalPath());
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
                    this.psPFEditorTempl.setTEMPLCODE2(strContent);
                } else if (StringHelper.Compare((String)strTag, (String)"CODE3", (boolean)true) == 0) {
                    this.psPFEditorTempl.setTEMPLCODE3(strContent);
                } else if (StringHelper.Compare((String)strTag, (String)"CODE4", (boolean)true) == 0) {
                    this.psPFEditorTempl.setTEMPLCODE4(strContent);
                }
            }
            ++n2;
        }
    }

    @Override
    public IPSPFPubCode getPSPFPubCode() throws Exception {
        return this.iPSPFPubCode;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public IPSPFEditorCodePublisher getPSPFEditorCodePublisher() throws Exception {
        ArrayList<IPSPFEditorCodePublisher> arrayList = this.psPFEditorCodePublisher;
        synchronized (arrayList) {
            if (System.currentTimeMillis() - this.nLastResetTime > 600000L) {
                this.nLastResetTime = System.currentTimeMillis();
                this.psPFEditorCodePublisher.clear();
            } else if (this.psPFEditorCodePublisher.size() > 0) {
                return this.psPFEditorCodePublisher.remove(0);
            }
        }
        IPSPFEditorCodePublisher iPSPFEditorCodePublisher = this.createPSPFEditorCodePublisher();
        iPSPFEditorCodePublisher.init(this.getDAGlobalHelper(), this);
        return iPSPFEditorCodePublisher;
    }

    protected IPSPFEditorCodePublisher createPSPFEditorCodePublisher() throws Exception {
        if (!StringHelper.IsNullOrEmpty((String)this.psPFEditorTempl.getPUBOBJ())) {
            return (IPSPFEditorCodePublisher)ObjectHelper.Create((String)this.psPFEditorTempl.getPUBOBJ());
        }
        if (this.getPSPFStyle() != null && this.getPSPFStyle().getPFEngineVer() < 20) {
            return this.getPSPF().createPSPFEditorCodePublisher();
        }
        return new PSPFEditorCodePublisher2Impl();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void releasePSPFEditorCodePublisher(IPSPFEditorCodePublisher iPSPFEditorCodePublisher) {
        ArrayList<IPSPFEditorCodePublisher> arrayList = this.psPFEditorCodePublisher;
        synchronized (arrayList) {
            this.psPFEditorCodePublisher.add(iPSPFEditorCodePublisher);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void resetPSPFEditorCodePublishers() {
        ArrayList<IPSPFEditorCodePublisher> arrayList = this.psPFEditorCodePublisher;
        synchronized (arrayList) {
            this.psPFEditorCodePublisher.clear();
        }
    }

    @Override
    public PSPFEditorTempl getPSPFEditorTemplData() {
        return this.psPFEditorTempl;
    }

    public IPSEditorType getPSEditorType() {
        return this.iPSEditorType;
    }

    public String getContainerType() {
        return this.strContainerType;
    }

    @Override
    public String getTemplDocUrl() {
        return "http://www.ibizsys.net";
    }

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSPF iPSPF, IPSPFStyle iPSPFStyle, PSPFEditorTempl psPFEditorTempl) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @Override
    public String getTemplFilePath() {
        return this.strTemplFilePath;
    }
}

