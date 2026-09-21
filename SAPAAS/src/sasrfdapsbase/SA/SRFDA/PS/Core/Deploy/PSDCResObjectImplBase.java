/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Deploy;

import SA.SRFDA.PS.Core.Deploy.IPSDCResObject;
import SA.SRFDA.PS.Core.Deploy.IPSRemoteResObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.PSTaskServerEnvImpl;
import SA.SRFDA.PS.Core.Pub.Util.PSTemplHelper;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelIgnoreMeta
public abstract class PSDCResObjectImplBase
extends PSObjectImpl
implements IPSDCResObject,
IPSRemoteResObject {
    private static final Log log = LogFactory.getLog(PSDCResObjectImplBase.class);
    private int nResState = 20;
    private int nResPos = 1;
    private String strRemoteAddr = null;
    private String strRemoteUserName = null;
    private String strRemotePassword = null;
    private int nRemotePort = 22;
    private String strResCfgFilePath = null;
    private String strRemoteUploadMode = null;
    private String strRemoteUploadPath = null;
    private Boolean bLocalRes = null;
    private Timestamp expriedTime = null;

    @Override
    protected void onInit() throws Exception {
        if (this.isPrepareResCfgFilePath()) {
            this.prepareResCfgFilePath();
        }
        super.onInit();
    }

    protected void prepareResCfgFilePath() throws Exception {
        String strCodeFolder = this.getDAGlobalHelper().getWebExConfig().GetValue("SRFPS", "CODEFOLDER", null);
        strCodeFolder = String.valueOf(strCodeFolder) + File.separator;
        strCodeFolder = String.valueOf(strCodeFolder) + StringHelper.format((String)"cfg");
        strCodeFolder = String.valueOf(strCodeFolder) + File.separator;
        strCodeFolder = String.valueOf(strCodeFolder) + StringHelper.format((String)"%1$tY-%1$tm-%1$td", (Object)new Date());
        if (!StringHelper.isNullOrEmpty((String)this.getModelType())) {
            strCodeFolder = String.valueOf(strCodeFolder) + File.separator;
            strCodeFolder = String.valueOf(strCodeFolder) + this.getModelType();
        } else {
            strCodeFolder = String.valueOf(strCodeFolder) + File.separator;
            strCodeFolder = String.valueOf(strCodeFolder) + "UNKNOWN";
        }
        strCodeFolder = String.valueOf(strCodeFolder) + File.separator;
        File dir = new File(strCodeFolder);
        dir.mkdirs();
        String strFullPath = String.valueOf(strCodeFolder) + KeyValueHelper.genGuidEx() + ".properties";
        TreeMap<String, String> params = new TreeMap<String, String>();
        this.onFillResCfgParams(params);
        OutputStreamWriter write = new OutputStreamWriter((OutputStream)new FileOutputStream(new File(strFullPath)), "UTF-8");
        BufferedWriter writer = new BufferedWriter(write);
        writer.write(StringHelper.format((String)"#[%1$s][%2$s]\u914d\u7f6e\r\n", (Object)this.getName(), (Object)this.getId()));
        for (String strKey : params.keySet()) {
            String strValue = params.get(strKey);
            if (strValue == null) continue;
            writer.write(StringHelper.format((String)"%1$s=%2$s\r\n", (Object)strKey, (Object)strValue));
        }
        writer.write(StringHelper.format((String)"#\u914d\u7f6e\u7ed3\u675f"));
        writer.flush();
        writer.close();
        this.strResCfgFilePath = strFullPath;
    }

    protected void onFillResCfgParams(Map<String, String> params) throws Exception {
        if (this.getRemoteAddress() != null) {
            params.put("host.addr", this.getRemoteAddress());
        }
        params.put("host.port", StringHelper.format((String)"%1$s", (Object)this.getRemotePort()));
        if (this.getRemoteUserName() != null) {
            params.put("host.user", this.getRemoteUserName());
        }
        if (this.getRemotePassword() != null) {
            params.put("host.pass", this.getRemotePassword());
        }
        if (this.getRemoteUploadMode() != null) {
            params.put("host.uploadmode", this.getRemoteUploadMode());
        }
        if (this.getRemoteUploadPath() != null) {
            params.put("host.uploadpath", this.getRemoteUploadPath());
        }
    }

    @Override
    @PSModelRTMeta(description="\u8d44\u6e90\u72b6\u6001", codelist="DevCenterResState")
    public int getResState() {
        return this.nResState;
    }

    @Override
    @PSModelRTMeta(description="\u8d44\u6e90\u6765\u6e90", codelist="DevCenterResPos")
    public int getResPos() {
        return this.nResPos;
    }

    protected void setResState(int nResState) {
        this.nResState = nResState;
    }

    protected void setResPos(int nResPos) {
        this.nResPos = nResPos;
    }

    @Override
    @PSModelRTMeta(description="\u4e3b\u673a\u5730\u5740")
    public String getRemoteAddress() {
        if (PSTemplHelper.isBusy()) {
            log.warn((Object)StringHelper.format((String)"[\u6a21\u677f\u5b89\u5168]\u8bbf\u95ee[%1$s|%2$s]\u4e3b\u673a\u5730\u5740", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName()));
            if (!PSTemplHelper.isSecurityPub()) {
                return "!!!!\u62d2\u7edd\u8bbf\u95ee\u5f53\u524d\u4fe1\u606f";
            }
        }
        return this.strRemoteAddr;
    }

    @Override
    @PSModelRTMeta(description="\u4e3b\u673a\u7aef\u53e3")
    public int getRemotePort() {
        return this.nRemotePort;
    }

    @Override
    @PSModelRTMeta(description="\u4e3b\u673a\u7528\u6237", debugmode=true)
    public String getRemoteUserName() {
        if (PSTemplHelper.isBusy()) {
            log.warn((Object)StringHelper.format((String)"[\u6a21\u677f\u5b89\u5168]\u8bbf\u95ee[%1$s|%2$s]\u4e3b\u673a\u7528\u6237", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName()));
            if (!PSTemplHelper.isSecurityPub()) {
                return "!!!!\u62d2\u7edd\u8bbf\u95ee\u5f53\u524d\u4fe1\u606f";
            }
        }
        return this.strRemoteUserName;
    }

    @Override
    @PSModelRTMeta(description="\u4e3b\u673a\u5bc6\u7801", debugmode=true, displayvalue="******")
    public String getRemotePassword() {
        if (PSTemplHelper.isBusy()) {
            log.warn((Object)StringHelper.format((String)"[\u6a21\u677f\u5b89\u5168]\u8bbf\u95ee[%1$s|%2$s]\u4e3b\u673a\u5bc6\u7801", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName()));
            if (!PSTemplHelper.isSecurityPub()) {
                return "!!!!\u62d2\u7edd\u8bbf\u95ee\u5f53\u524d\u4fe1\u606f";
            }
        }
        return this.strRemotePassword;
    }

    protected void setRemoteAddress(String strRemoteAddr) {
        this.strRemoteAddr = strRemoteAddr;
    }

    protected void setRemoteUserName(String strRemoteUserName) {
        this.strRemoteUserName = strRemoteUserName;
    }

    protected void setRemotePassword(String strRemotePassword) {
        this.strRemotePassword = strRemotePassword;
    }

    protected void setRemotePort(int nRemotePort) {
        this.nRemotePort = nRemotePort;
    }

    @Override
    @PSModelRTMeta(description="\u914d\u7f6e\u6587\u4ef6", debugmode=true)
    public String getResCfgFilePath() {
        return this.strResCfgFilePath;
    }

    @Override
    @PSModelRTMeta(description="\u4e0a\u4f20\u8def\u5f84", debugmode=true)
    public String getRemoteUploadPath() {
        return this.strRemoteUploadPath;
    }

    @Override
    @PSModelRTMeta(description="\u4e0a\u4f20\u6a21\u5f0f", codelist="ASFileUploadMode")
    public String getRemoteUploadMode() {
        return this.strRemoteUploadMode;
    }

    protected void setRemoteUploadMode(String strRemoteUploadMode) {
        this.strRemoteUploadMode = strRemoteUploadMode;
    }

    protected void setRemoteUploadPath(String strRemoteUploadPath) {
        this.strRemoteUploadPath = strRemoteUploadPath;
    }

    @Override
    @PSModelRTMeta(description="\u672c\u5730\u8d44\u6e90", debugmode=true)
    public boolean isLocalRes() {
        if (this.bLocalRes == null) {
            return this.getResPos() == 1;
        }
        return this.bLocalRes;
    }

    protected void setLocalRes(boolean bLocalRes) {
        this.bLocalRes = bLocalRes;
    }

    @Override
    public Timestamp getExpiredTime() {
        return this.expriedTime;
    }

    protected void setExpiredTime(Timestamp expriedTime) {
        this.expriedTime = expriedTime;
    }

    protected boolean isPrepareResCfgFilePath() {
        return PSTaskServerEnvImpl.getCurrent() == null || !PSTaskServerEnvImpl.getCurrent().isTemplEngineV2Only();
    }
}

