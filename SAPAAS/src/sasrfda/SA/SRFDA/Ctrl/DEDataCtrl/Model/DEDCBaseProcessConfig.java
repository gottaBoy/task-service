/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.PropertiesHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.apache.xerces.parsers.DOMParser
 */
package SA.SRFDA.Ctrl.DEDataCtrl.Model;

import SA.SRFDA.Ctrl.Data.DEDCProcess;
import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import java.io.StringReader;
import java.util.Properties;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

public abstract class DEDCBaseProcessConfig
extends XMLConfig {
    private DEDCBaseProcessConfig parentProcessConfig = null;
    private static Log log = LogFactory.getLog(DEDCBaseProcessConfig.class);
    public static final String TAG_OBJECT = "OBJECT";
    public static final String TAG_NAME = "NAME";
    public static final String TAG_LOGICNAME = "LOGICNAME";
    public static final String TAG_DESC = "DESC";
    public static final String TAG_PROCESSCONFIGID = "PROCESSCONFIGID";
    public static final String TAG_PROCESSTYPE = "PROCESSTYPE";
    public static final String TAG_LEFT = "LEFT";
    public static final String TAG_TOP = "TOP";
    protected String strObject = "";
    protected String strName = "";
    protected String strLogicName = "";
    protected String strDesc = "";
    protected String strProcessConfigId = "";
    protected String strProcessType = "";
    protected int nLeft = -1;
    protected int nTop = -1;
    protected DEDCProcess dedcProcess = null;
    protected Properties properties = new Properties();

    public void OnLoadNode(String strName, Node xmlNode) {
        super.OnLoadNode(strName, xmlNode);
    }

    public DEDCBaseProcessConfig getParentProcessConfig() {
        return this.parentProcessConfig;
    }

    public void setParentProcessConfig(DEDCBaseProcessConfig parentProcessConfig) {
        this.parentProcessConfig = parentProcessConfig;
    }

    public boolean LoadFromXML(String strXML) {
        try {
            InputSource is = new InputSource(new StringReader(strXML));
            DOMParser parser = new DOMParser();
            parser.parse(is);
            Document doc = parser.getDocument();
            this.LoadConfig(doc.getDocumentElement());
            return true;
        }
        catch (Exception ex) {
            log.error((Object)"\u4eceXML\u52a0\u8f7d\u914d\u7f6e\u5931\u8d25", (Throwable)ex);
            return false;
        }
    }

    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_OBJECT, (boolean)true) == 0) {
            this.strObject = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_NAME, (boolean)true) == 0) {
            this.strName = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_LOGICNAME, (boolean)true) == 0) {
            this.strLogicName = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_PROCESSCONFIGID, (boolean)true) == 0) {
            this.strProcessConfigId = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_DESC, (boolean)true) == 0) {
            this.strDesc = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_PROCESSTYPE, (boolean)true) == 0) {
            this.strProcessType = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_LEFT, (boolean)true) == 0) {
            this.nLeft = DEDCBaseProcessConfig.GetValue((String)strValue, (int)this.nLeft);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_TOP, (boolean)true) == 0) {
            this.nTop = DEDCBaseProcessConfig.GetValue((String)strValue, (int)this.nTop);
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public String getObject() {
        return this.strObject;
    }

    public void setObject(String strObject) {
        this.strObject = strObject;
    }

    public String getName() {
        if (StringHelper.IsNullOrEmpty((String)this.strName)) {
            return this.getID();
        }
        return this.strName;
    }

    public void setName(String strName) {
        this.strName = strName;
    }

    public boolean isStartProcess() {
        return false;
    }

    public boolean isTerminalProcess() {
        return false;
    }

    public String getLogicName() {
        if (StringHelper.IsNullOrEmpty((String)this.strLogicName)) {
            return this.getName();
        }
        return this.strLogicName;
    }

    public void setLogicName(String strLogicName) {
        this.strLogicName = strLogicName;
    }

    public String getDesc() {
        return this.strDesc;
    }

    public void setDesc(String strDesc) {
        this.strDesc = strDesc;
    }

    public int getLeft() {
        return this.nLeft;
    }

    public void setLeft(int left) {
        this.nLeft = left;
    }

    public int getTop() {
        return this.nTop;
    }

    public void setTop(int top) {
        this.nTop = top;
    }

    public void setProcessParam(String strParam, String strValue) {
        this.properties.setProperty(strParam, strValue);
    }

    public String getProcessParam(String strParam, String defaultValue) {
        return PropertiesHelper.GetProperty((Properties)this.properties, (String)strParam, (String)defaultValue);
    }

    public String getProcessConfigId() {
        return this.strProcessConfigId;
    }

    public void setProcessConfigId(String strProcessConfigId) {
        this.strProcessConfigId = strProcessConfigId;
    }

    public String getProcessType() {
        return this.strProcessType;
    }

    public void setProcessType(String strProcessType) {
        this.strProcessType = strProcessType;
    }

    public DEDCProcess getDEDCProcess() {
        return this.dedcProcess;
    }

    public void setDEDCProcess(DEDCProcess dedcProcess) {
        this.dedcProcess = dedcProcess;
    }
}

