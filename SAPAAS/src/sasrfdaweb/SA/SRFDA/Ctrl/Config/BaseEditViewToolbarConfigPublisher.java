/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Ctrl.Config;

import SA.SRFDA.Ctrl.Config.IEditViewToolbarConfigPublishContext;
import SA.SRFDA.Ctrl.Config.IToolbarConfigPublishContext;
import SA.SRFDA.Ctrl.Config.ToolbarConfigPublisher;
import SA.SRFramework.Utility.StringHelper;

public abstract class BaseEditViewToolbarConfigPublisher
extends ToolbarConfigPublisher {
    private boolean bNewButton = true;
    private boolean bUnlockButton = false;
    private boolean bRemoveAndExitButton = false;

    @Override
    protected void OnInit() throws Exception {
        super.OnInit();
        this.bUnlockButton = this.getDAGlobalHelper().getWebExConfig().GetValue("SRFDA", "EDITVIEWENABLEUNLOCK", false);
        this.bNewButton = this.getDAGlobalHelper().getWebExConfig().GetValue("SRFDA", "EDITVIEWENABLENEW", true);
        this.bRemoveAndExitButton = this.getDAGlobalHelper().getWebExConfig().GetValue("SRFDA", "EDITVIEWENABLEREMOVE", false);
    }

    protected boolean getEnableNew() {
        return this.bNewButton;
    }

    protected boolean getEnableUnlock() {
        return this.bUnlockButton;
    }

    protected boolean getEnableRemoveAndExit() {
        return this.bRemoveAndExitButton;
    }

    @Override
    protected String OnGetConfigId(IToolbarConfigPublishContext iDAConfigPublishContext) throws Exception {
        IEditViewToolbarConfigPublishContext iEditViewToolbarConfigPublishContext = this.getEditViewToolbarConfigPublishContext(iDAConfigPublishContext);
        String strConfigId = "";
        strConfigId = StringHelper.Format((String)"DE%1$s.TB_%2$s", (Object)iDAConfigPublishContext.getDEHelper().getId(), (Object)iDAConfigPublishContext.getDEHelper().getVersion());
        if (iEditViewToolbarConfigPublishContext.getDEMainState() != null) {
            strConfigId = String.valueOf(strConfigId) + StringHelper.Format((String)"_MS_%1$s", (Object)iEditViewToolbarConfigPublishContext.getDEMainState().getName());
        }
        if (iEditViewToolbarConfigPublishContext.getDEMainAction() != null) {
            strConfigId = String.valueOf(strConfigId) + StringHelper.Format((String)"_MA_%1$s", (Object)iEditViewToolbarConfigPublishContext.getDEMainAction().getName());
        }
        if (iEditViewToolbarConfigPublishContext.getForm() != null) {
            strConfigId = String.valueOf(strConfigId) + StringHelper.Format((String)"_FM%1$s_%2$s", (Object)iEditViewToolbarConfigPublishContext.getForm().getFORMID(), (Object)iEditViewToolbarConfigPublishContext.getForm().getFMVERSION());
        }
        strConfigId = BaseEditViewToolbarConfigPublisher.AppendPageId(strConfigId, iDAConfigPublishContext);
        if (iEditViewToolbarConfigPublishContext.getReadOnlyMode()) {
            strConfigId = String.valueOf(strConfigId) + "_I";
        }
        if (iEditViewToolbarConfigPublishContext.getEmbedMode()) {
            strConfigId = String.valueOf(strConfigId) + "_E";
        }
        if (iEditViewToolbarConfigPublishContext.getMiniMode()) {
            strConfigId = String.valueOf(strConfigId) + "_M";
        }
        return strConfigId;
    }

    protected IEditViewToolbarConfigPublishContext getEditViewToolbarConfigPublishContext(IToolbarConfigPublishContext iDAConfigPublishContext) throws Exception {
        if (!(iDAConfigPublishContext instanceof IEditViewToolbarConfigPublishContext)) {
            throw new Exception("\u4f20\u5165\u53c2\u6570\u7c7b\u578b\u65e0\u6548");
        }
        return (IEditViewToolbarConfigPublishContext)iDAConfigPublishContext;
    }
}

