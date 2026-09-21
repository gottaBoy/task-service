/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.CommonEx.LogLevels
 *  SA.SRFramework.Utility.DateParser
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl.CodeEngine;

import SA.SRFDA.Ctrl.CodeEngine.IDACodeEngine;
import SA.SRFDA.Ctrl.CodeEngine.IDACodeEngineContext;
import SA.SRFDA.Ctrl.Data.DevCodeEngine;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.CommonEx.LogLevels;
import SA.SRFramework.Utility.DateParser;
import SA.SRFramework.Utility.StringHelper;
import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.util.Date;
import java.util.TreeMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class BaseDACodeEngine
implements IDACodeEngine,
IDACodeEngineContext {
    protected ISRFDAGlobalHelper iDAGlobalHelper = null;
    protected DevCodeEngine devCodeEngine = null;
    protected Writer logWriter = null;
    private int nPreFixCount = 0;
    private String strPreFix = "";
    protected TreeMap<String, Object> attributes = new TreeMap();
    private static final Log log = LogFactory.getLog(BaseDACodeEngine.class);

    @Override
    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, DevCodeEngine devCodeEngine, Writer logWriter) {
        this.iDAGlobalHelper = iDAGlobalHelper;
        this.devCodeEngine = devCodeEngine;
        this.logWriter = logWriter;
    }

    @Override
    public String GetParam(String strName, String strDefault) {
        if (this.devCodeEngine == null) {
            return strDefault;
        }
        return this.devCodeEngine.GetCodeEngineParam(strName, strDefault);
    }

    @Override
    public DevCodeEngine getDevCodeEngine() {
        return this.devCodeEngine;
    }

    protected String GetCodePath(String strFolder, String strCode, String strExt) {
        String strCodePath = "";
        if (StringHelper.IsNullOrEmpty((String)strFolder)) {
            strFolder = this.iDAGlobalHelper.getWebExConfig().GetValue("SRFDA", "SRCCODEFOLDER", "");
        }
        if (StringHelper.IsNullOrEmpty((String)strFolder)) {
            return "";
        }
        strCodePath = strFolder;
        strCodePath = String.valueOf(strCodePath) + strCode.replace(".", File.separator);
        strCodePath = String.valueOf(strCodePath) + strExt;
        return strCodePath;
    }

    @Override
    public void ResetPreFix() {
        this.nPreFixCount = 0;
        this.strPreFix = "";
    }

    @Override
    public void IncreasePreFix() {
        ++this.nPreFixCount;
        this.strPreFix = "";
        int i = 0;
        while (i < this.nPreFixCount) {
            this.strPreFix = String.valueOf(this.strPreFix) + "\t";
            ++i;
        }
    }

    @Override
    public void DecreasePreFix() {
        --this.nPreFixCount;
        if (this.nPreFixCount < 0) {
            this.nPreFixCount = 0;
        }
        this.strPreFix = "";
        int i = 0;
        while (i < this.nPreFixCount) {
            this.strPreFix = String.valueOf(this.strPreFix) + "\t";
            ++i;
        }
    }

    @Override
    public String GetPreFix() {
        return this.strPreFix;
    }

    protected void Log(int nLogLevel, String strLogInfo) {
        switch (nLogLevel) {
            case 0: {
                log.info((Object)strLogInfo);
                break;
            }
            case 1: {
                log.error((Object)strLogInfo);
                break;
            }
            case 5: {
                log.debug((Object)strLogInfo);
                break;
            }
            case 4: {
                log.warn((Object)strLogInfo);
                break;
            }
            case 2: {
                log.fatal((Object)strLogInfo);
            }
        }
        if (this.logWriter == null) {
            return;
        }
        String strInfo = StringHelper.Format((String)"[%3$s]\t[%1$s] %2$s\r\n", (Object)DateParser.toDateTimeString((Date)new Date()), (Object)strLogInfo, (Object)LogLevels.ToString((int)nLogLevel));
        try {
            this.logWriter.write(strInfo);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object GetAttribute(String strKey) {
        return this.attributes.get(strKey);
    }

    @Override
    public void SetAttribute(String strKey, Object objValue) {
        this.attributes.put(strKey, objValue);
    }
}

