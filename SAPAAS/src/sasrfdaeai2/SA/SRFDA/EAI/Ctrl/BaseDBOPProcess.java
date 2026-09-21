/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.EAI.Ctrl;

import SA.SRFDA.EAI.Ctrl.IDBOPPKGContext;
import SA.SRFDA.EAI.Ctrl.IDBOPProcess;
import SA.SRFDA.EAI.Ctrl.IDBOPPublishContext;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import java.util.Map;
import java.util.TreeMap;

public abstract class BaseDBOPProcess
implements IDBOPProcess {
    protected IDBOPPKGContext context = null;
    protected BaseDataEntity dbOPProc = null;
    private String strPID = "";
    protected boolean bLogDetailDefault = false;
    protected Map<String, Object> templMethodMap = new TreeMap<String, Object>();

    @Override
    public void Init(IDBOPPKGContext context, BaseDataEntity opProc) throws Exception {
        this.context = context;
        this.dbOPProc = opProc;
        this.strPID = context.GetUniqueProcId();
        if (this.dbOPProc != null) {
            String strProcessName = this.dbOPProc.GetParamStringValue("EAIDBOPPROCNAME", "");
            String strProcessType = this.dbOPProc.GetParamStringValue("EAIDBOPPROCTYPE", "");
            this.templMethodMap.put("curprocname", strProcessName);
            this.templMethodMap.put("curproctype", strProcessType);
        }
        this.OnInit();
    }

    protected void OnInit() throws Exception {
    }

    @Override
    public String getId() {
        return this.strPID;
    }

    @Override
    public void Publish(IDBOPPublishContext context) throws Exception {
        context.AppendNewLine();
        boolean bLogDetail = this.isLogDetail();
        this.OnPublishProcessComment(context);
        if (bLogDetail) {
            context.AppendCodeLine(this.context.ParseMacro(this.templMethodMap, this.context.getDBOPSetting().getLogDetailBeginCode()));
        }
        this.OnPublish(context);
        if (bLogDetail) {
            context.AppendCodeLine(this.context.ParseMacro(this.templMethodMap, this.context.getDBOPSetting().getLogDetailEndCode()));
        }
        context.AppendNewLine();
        context.AppendNewLine();
    }

    @Override
    public boolean isLogDetail() {
        return this.dbOPProc.GetParamIntValue("LOGDETAIL", this.bLogDetailDefault ? 1 : 0) == 1;
    }

    protected abstract void OnPublish(IDBOPPublishContext var1) throws Exception;

    protected void OnPublishProcessComment(IDBOPPublishContext context) throws Exception {
        String strProcessName = this.dbOPProc.GetParamStringValue("EAIDBOPPROCNAME", "");
        if (!StringHelper.IsNullOrEmpty((String)strProcessName)) {
            context.AppendCodeLine(StringHelper.Format((String)"%1$s -------------------------------------------------------------------------------------------", (Object)this.context.getDBOPSetting().getLineComment()));
            context.AppendCodeLine(StringHelper.Format((String)"%1$s %2$s", (Object)this.context.getDBOPSetting().getLineComment(), (Object)strProcessName));
            context.AppendCodeLine(StringHelper.Format((String)"%1$s -------------------------------------------------------------------------------------------", (Object)this.context.getDBOPSetting().getLineComment()));
        }
        if (!StringHelper.IsNullOrEmpty((String)this.dbOPProc.GetParamStringValue("DESCRIPTION", ""))) {
            context.AppendComment(this.context.getDBOPSetting().getLineComment(), this.dbOPProc.GetParamStringValue("DESCRIPTION", ""));
        }
    }
}

