/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.PropertiesHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.EAI.Model;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import java.util.Properties;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class EAIBaseProcessConfig
extends XMLConfig {
    private EAIBaseProcessConfig parentProcessConfig = null;
    private static Log log = LogFactory.getLog(EAIBaseProcessConfig.class);
    public static final String TAG_OBJECT = "OBJECT";
    public static final String TAG_NAME = "NAME";
    public static final String TAG_LOGICNAME = "LOGICNAME";
    public static final String TAG_DESC = "DESC";
    public static final String TAG_PROCESSCONFIGID = "PROCESSCONFIGID";
    public static final String TAG_LEFT = "LEFT";
    public static final String TAG_TOP = "TOP";
    protected String strObject = "";
    protected String strName = "";
    protected String strLogicName = "";
    protected String strDesc = "";
    protected String strProcessConfigId = "";
    protected int nLeft = -1;
    protected int nTop = -1;
    protected Properties properties = new Properties();

    public EAIBaseProcessConfig getParentProcessConfig() {
        return this.parentProcessConfig;
    }

    public void setParentProcessConfig(EAIBaseProcessConfig parentProcessConfig) {
        this.parentProcessConfig = parentProcessConfig;
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
        if (StringHelper.Compare((String)strName, (String)TAG_LEFT, (boolean)true) == 0) {
            this.nLeft = EAIBaseProcessConfig.GetValue((String)strValue, (int)this.nLeft);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_TOP, (boolean)true) == 0) {
            this.nTop = EAIBaseProcessConfig.GetValue((String)strValue, (int)this.nTop);
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

    protected void CloneCopy(Object dst) {
        super.CloneCopy(dst);
        EAIBaseProcessConfig obj = (EAIBaseProcessConfig)((Object)dst);
        obj.setDesc(this.getDesc());
        obj.setLeft(this.getLeft());
        obj.setTop(this.getTop());
        obj.setLogicName(this.getLogicName());
        obj.setName(this.getName());
        obj.setObject(this.getObject());
        obj.setProcessConfigId(this.getProcessConfigId());
    }
}

