/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Help;

import SA.SRFDA.PS.Core.Help.IPSHelpPublisher;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Pub.Util.PSTemplHelper;
import SA.SRFDA.PS.Core.Util.FileWriterHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import java.io.File;
import java.util.HashMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSHelpPublisherImpl
extends PSObjectImpl
implements IPSHelpPublisher {
    protected String strCodeFolder = null;
    protected String strToolFolder = null;
    protected IPSSystem iPSSystem = null;
    private static final Log log = LogFactory.getLog(PSHelpPublisherImpl.class);

    @Override
    protected void onInit() throws Exception {
        this.strCodeFolder = this.getDAGlobalHelper().getWebExConfig().GetValue("SRFPS", "CODEFOLDER", null);
        this.strToolFolder = this.getDAGlobalHelper().getWebExConfig().GetValue("SRFPS", "TOOLFOLDER", null);
        super.onInit();
    }

    @Override
    public void close() {
        this.onClose();
    }

    protected void onClose() {
        this.iPSSystem = null;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    protected void saveFile(Object obj, String strFileName, String strSubFolder, HashMap<String, Object> params2, BaseDataEntity templDataEntity) throws Exception {
        String strPubFolder2;
        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("publisher", this);
        params.put("item", obj);
        params.put("sys", this.iPSSystem);
        params.put("toolfolder", this.strToolFolder);
        params.put("codefolder", this.strCodeFolder);
        if (params2 != null) {
            params.putAll(params2);
        }
        this.onFillGenerateCodeParams(obj, params);
        String strPubCode = PSTemplHelper.generateCode(templDataEntity, "TEMPLCODE", params);
        String strFolder = this.strCodeFolder;
        if (StringHelper.IsNullOrEmpty((String)strFolder)) {
            throw new Exception("\u6ca1\u6709\u5b9a\u4e49\u4ee3\u7801\u53d1\u5e03\u76ee\u5f55");
        }
        strFolder = String.valueOf(strFolder) + File.separator + this.iPSSystem.getPSDevCenterDomain();
        strFolder = String.valueOf(strFolder) + File.separator + this.iPSSystem.getPubSystemId();
        strFolder = String.valueOf(strFolder) + File.separator + this.iPSSystem.getVCName();
        String strPubFolder = String.valueOf(strFolder) + File.separator + "help";
        String strFullPath = strPubFolder2 = String.valueOf(strPubFolder) + File.separator + strSubFolder;
        File folder = new File(strFullPath = strFullPath.replace("/", File.separator));
        if (!folder.exists()) {
            folder.mkdirs();
        }
        if ((strFullPath = String.valueOf(strFullPath) + File.separator + strFileName).length() >= 250) {
            String strInfo = StringHelper.Format((String)"\u53d1\u5e03\u6587\u4ef6[%1$s]\u8def\u5f84\u8fc7\u957f[%2$s]\uff0c\u53ef\u80fd\u65e0\u6cd5\u5199\u5165", (Object)strFullPath, (Object)strFullPath.length());
            if (obj instanceof IPSModelObject) {
                ((IPSSystemUtil)((Object)this.iPSSystem)).log(4, (IPSModelObject)obj, strInfo);
            }
            log.warn((Object)strInfo);
        }
        FileWriterHelper.write(strFullPath, strPubCode);
    }

    protected void onFillGenerateCodeParams(Object obj, HashMap<String, Object> params) throws Exception {
    }
}

