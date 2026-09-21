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
package SRFWF.Model;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import SRFWF.Model.WFParamConfig;
import SRFWF.Model.WFParamsConfig;
import java.io.StringReader;
import java.util.Iterator;
import java.util.Properties;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

public abstract class WFBaseProcessConfig
extends XMLConfig {
    private WFBaseProcessConfig parentProcessConfig = null;
    private static Log log = LogFactory.getLog(WFBaseProcessConfig.class);
    public static final String TAG_DEFAULTPROCESSOBJECT = "SRFWF.Ctrl.SRFWFDefaultProcess";
    public static final String TAG_OBJECT = "OBJECT";
    public static final String TAG_NAME = "NAME";
    public static final String TAG_LOGICNAME = "LOGICNAME";
    public static final String TAG_DESC = "DESC";
    public static final String TAG_PARAMS = "PARAMS";
    public static final String TAG_PARAMS2 = "PARAMS2";
    public static final String TAG_CODELISTITEMVALUE = "CODELISTITEMVALUE";
    public static final String TAG_ASYNCMODE = "ASYNCMODE";
    public static final String TAG_LEFT = "LEFT";
    public static final String TAG_TOP = "TOP";
    protected String strObject = "";
    protected String strName = "";
    protected String strLogicName = "";
    protected String strDesc = "";
    protected String strParams = "";
    protected String strParams2 = "";
    protected String strCodeListItemValue = "";
    protected boolean bAsyncMode = false;
    protected int nLeft = -1;
    protected int nTop = -1;
    protected WFParamsConfig wpParamsConfig = null;
    protected Properties properties = new Properties();
    protected Properties properties2 = new Properties();

    public WFBaseProcessConfig() {
        this.wpParamsConfig = new WFParamsConfig(this);
    }

    public void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare((String)strName, (String)WFParamsConfig.TAG_WFPARAMS, (boolean)true) == 0) {
            this.wpParamsConfig.LoadConfig(xmlNode);
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    public WFBaseProcessConfig getParentProcessConfig() {
        return this.parentProcessConfig;
    }

    public void setParentProcessConfig(WFBaseProcessConfig parentProcessConfig) {
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
        if (StringHelper.Compare((String)strName, (String)TAG_DESC, (boolean)true) == 0) {
            this.strDesc = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_LEFT, (boolean)true) == 0) {
            this.nLeft = WFBaseProcessConfig.GetValue((String)strValue, (int)this.nLeft);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_TOP, (boolean)true) == 0) {
            this.nTop = WFBaseProcessConfig.GetValue((String)strValue, (int)this.nTop);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_PARAMS, (boolean)true) == 0) {
            this.setParams(strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_PARAMS2, (boolean)true) == 0) {
            this.setParams2(strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_CODELISTITEMVALUE, (boolean)true) == 0) {
            this.strCodeListItemValue = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_ASYNCMODE, (boolean)true) == 0) {
            this.bAsyncMode = WFBaseProcessConfig.GetValue((String)strValue, (boolean)this.bAsyncMode);
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

    public boolean isAsynchronousProcess() {
        return this.bAsyncMode;
    }

    public void setName(String strName) {
        this.strName = strName;
    }

    public boolean isSuspendProcess() {
        return false;
    }

    public boolean isTerminalProcess() {
        return false;
    }

    public boolean isStartProcess() {
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

    public WFParamsConfig getParamsConfig() {
        return this.wpParamsConfig;
    }

    public void setParamsConfig(WFParamsConfig wpParamsConfig) {
        this.wpParamsConfig = wpParamsConfig;
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

    public String getParams() {
        return this.strParams;
    }

    public void setParams(String strParams) {
        this.strParams = strParams;
        try {
            this.properties = PropertiesHelper.Load((Properties)this.properties, (String)strParams);
        }
        catch (Exception ex) {
            return;
        }
    }

    public String getParams2() {
        return this.strParams2;
    }

    public void setParams2(String strParams2) {
        this.strParams2 = strParams2;
        try {
            this.properties2 = PropertiesHelper.Load((Properties)this.properties2, (String)strParams2);
        }
        catch (Exception ex) {
            return;
        }
    }

    public void setProcessParam(String strParam, String strValue) {
        if (this.properties != null) {
            this.properties.setProperty(strParam, strValue);
        }
    }

    public String getProcessParam(String strParam, String defaultValue) {
        return PropertiesHelper.GetProperty((Properties)this.properties, (String)strParam, (String)defaultValue);
    }

    public void setProcessParam2(String strParam, String strValue) {
        if (this.properties2 != null) {
            this.properties2.setProperty(strParam, strValue);
        }
    }

    public String getProcessParam2(String strParam, String defaultValue) {
        return PropertiesHelper.GetProperty((Properties)this.properties2, (String)strParam, (String)defaultValue);
    }

    public String getCodeListItemValue() {
        return this.strCodeListItemValue;
    }

    public void setCodeListItemValue(String strValue) {
        this.strCodeListItemValue = strValue;
    }

    protected void CloneCopy(Object dst) {
        super.CloneCopy(dst);
        WFBaseProcessConfig wfBaseProcessConfig = (WFBaseProcessConfig)((Object)dst);
        if (this.getParamsConfig() != null) {
            Iterator iterator = this.getParamsConfig().iterator();
            while (iterator.hasNext()) {
                WFParamConfig wpParamConfig = (WFParamConfig)((Object)iterator.next());
                wfBaseProcessConfig.getParamsConfig().add((Object)((WFParamConfig)((Object)wpParamConfig.clone())));
            }
        }
        wfBaseProcessConfig.setObject(this.strObject);
        wfBaseProcessConfig.setName(this.strName);
        wfBaseProcessConfig.setLogicName(this.strLogicName);
        wfBaseProcessConfig.setDesc(this.strDesc);
        wfBaseProcessConfig.setLeft(this.nLeft);
        wfBaseProcessConfig.setTop(this.nTop);
        wfBaseProcessConfig.setParams(this.strParams);
        wfBaseProcessConfig.setParams2(this.strParams2);
        wfBaseProcessConfig.setCodeListItemValue(this.strCodeListItemValue);
    }
}

