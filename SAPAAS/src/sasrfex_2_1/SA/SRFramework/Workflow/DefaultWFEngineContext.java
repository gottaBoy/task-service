/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.Workflow;

import SA.SRFramework.DataEx.BaseDBCallerHelperEx;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.Workflow.DefaultWFEngine;
import SA.SRFramework.Workflow.IWFEngine;
import SA.SRFramework.Workflow.IWFEngineContext;
import java.util.Hashtable;

public class DefaultWFEngineContext
implements IWFEngineContext {
    protected BaseDBCallerHelperEx dbCallerHelper = null;
    protected BaseDataEntity value = null;
    protected DefaultWFEngine wfEngine = null;
    protected String strNext = "";
    protected Hashtable userParams = null;
    protected BaseDataEntity globalDataEntity = null;
    protected String strOpPersonId = "";

    public void setWFEngine(IWFEngine iWFEngine) {
        if (iWFEngine instanceof DefaultWFEngine) {
            this.wfEngine = (DefaultWFEngine)iWFEngine;
        }
    }

    @Override
    public void Log(int level, String strInfo) {
        if (this.wfEngine != null) {
            this.wfEngine.Log(level, strInfo);
        }
        System.out.print(StringHelper.Format((String)"[Workflow Engine Log][%1$s][%2$s]\r\n", (Object)level, (Object)strInfo));
    }

    @Override
    public String getExecuteMode() {
        return null;
    }

    @Override
    public void setActiveDataEntity(BaseDataEntity value) {
        this.value = value;
    }

    @Override
    public BaseDataEntity getActiveDataEntity() {
        return this.value;
    }

    @Override
    public void setGlobalDataEntity(BaseDataEntity globalDataEntity) {
        this.globalDataEntity = globalDataEntity;
    }

    @Override
    public BaseDataEntity getGlobalDataEntity() {
        return this.globalDataEntity;
    }

    public void setDBCallerHelper(BaseDBCallerHelperEx dbCallerHelper) {
        this.dbCallerHelper = dbCallerHelper;
    }

    @Override
    public BaseDBCallerHelperEx getDBCallerHelper() {
        return this.dbCallerHelper;
    }

    @Override
    public String getNext() {
        return this.strNext;
    }

    @Override
    public void setNext(String strNext) {
        this.strNext = strNext;
    }

    @Override
    public void setUserParam(String strParamName, Object objParamValue) {
        if (strParamName == null) {
            return;
        }
        if (objParamValue == null) {
            this.RemoveUserParam(strParamName);
            return;
        }
        if (this.userParams == null) {
            this.userParams = new Hashtable();
        }
        strParamName = strParamName.toUpperCase();
        this.userParams.put(strParamName, objParamValue);
    }

    @Override
    public Object getUserParam(String strParamName) {
        if (strParamName == null || this.userParams == null) {
            return null;
        }
        if (this.userParams.containsKey(strParamName = strParamName.toUpperCase())) {
            return this.userParams.get(strParamName);
        }
        return null;
    }

    @Override
    public void RemoveUserParam(String strParamName) {
        if (this.userParams == null || strParamName == null) {
            return;
        }
        if (this.userParams.containsKey(strParamName = strParamName.toUpperCase())) {
            this.userParams.remove(strParamName);
        }
    }

    @Override
    public String getOpPersonId() {
        return this.strOpPersonId;
    }

    public void setOpPersonId(String strOpPersonId) {
        this.strOpPersonId = strOpPersonId;
    }
}

