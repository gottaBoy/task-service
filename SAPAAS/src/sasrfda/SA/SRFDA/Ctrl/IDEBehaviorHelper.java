/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.Data.DEBehavior;
import SA.SRFDA.Ctrl.IDAObjectHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IDEBehaviorHelper
extends IDAObjectHelper {
    public void Init(ISRFDAGlobalHelper var1, DEBehavior var2) throws Exception;

    public DEBehavior getData();

    public String getActionTarget();

    public String getBHCode();

    public String getImportance();

    public String getProcessType();

    public int getOrderFlag();

    public String getDescription();

    @Override
    public int getVersion();

    public String getTooltip();

    public String getCaption();

    public String getDEId();

    public String getDevImageId();

    public String getCapLanResId();

    public String getTipLanResId();

    public String getResourceId();

    public String getDEActionId();

    public int getTimeout();

    public String getConfirmInfo();

    public boolean isReloadData();

    public String getDataAction();

    public String getSuccessInfo();

    public String getBeforeCode();

    public String getSuccessCode();

    public String getDEWizardId();

    public String getExtParams();

    public String getFrontProType();

    public String getPageId();

    public String getUrlAppendParam();

    public boolean isHtmlMode();

    public boolean isUserConfirm();
}

