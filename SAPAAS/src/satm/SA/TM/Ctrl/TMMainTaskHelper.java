/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.TM.Ctrl;

import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.TM.Ctrl.Data.TMTaskBase;
import SA.TM.Ctrl.ITMActionContext;
import SA.TM.Ctrl.ITMMainTaskHelper;
import SA.TM.Ctrl.ITMTaskBaseHelper;
import SA.TM.Ctrl.TMGroupTaskHelper;
import java.util.Hashtable;
import java.util.Vector;

public class TMMainTaskHelper
extends TMGroupTaskHelper
implements ITMMainTaskHelper {
    protected Vector<ITMTaskBaseHelper> childTaskHelperList = new Vector();
    protected Hashtable<String, ITMTaskBaseHelper> childTaskHelperMap = new Hashtable();

    protected void OnInit() throws Exception {
        super.OnInit();
        this.OnPrepareChildTasks();
    }

    protected void OnPrepareChildTasks() throws Exception {
        Vector<TMTaskBase> childTasks = new Vector<TMTaskBase>();
        CallResult callResult = this.getTMModelHelper().GetTMTasksByMainTask(this.getId(), childTasks);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u5b50\u4efb\u52a1\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        for (TMTaskBase tmTaskBase : childTasks) {
            ITMTaskBaseHelper iTMTaskBaseHelper = this.iTMUserSessionStorage.FindTMTask(tmTaskBase);
            this.childTaskHelperList.add(iTMTaskBaseHelper);
            this.childTaskHelperMap.put(iTMTaskBaseHelper.getId(), iTMTaskBaseHelper);
        }
    }

    public void ExtractTasks(ITMActionContext iTMActionContext) throws Exception {
        if (this.isExtracted()) {
            return;
        }
        this.OnExtractTasks(iTMActionContext);
    }

    protected void OnExtractTasks(ITMActionContext iTMActionContext) throws Exception {
    }

    public boolean isExtracted() {
        return false;
    }

    public boolean isMainTask() {
        return true;
    }
}

