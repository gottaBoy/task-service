/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.codelist.CodeItem
 *  net.ibizsys.paas.codelist.CodeItems
 *  net.ibizsys.paas.codelist.CodeList
 *  net.ibizsys.paas.codelist.ICodeList
 *  net.ibizsys.paas.sysmodel.CodeListGlobal
 *  net.ibizsys.paas.sysmodel.ICodeListModel
 *  net.ibizsys.paas.sysmodel.StaticCodeListModelBase
 */
package net.ibizsys.pscore.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.ICodeListModel;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="49A81F9C-F667-4F2B-AC47-B77C78B55199", name="Pipeline\u9636\u6bb5\u540e\u7eed\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="NONE", text="\u672a\u6307\u5b9a", realtext="\u672a\u6307\u5b9a"), @CodeItem(value="ALWAYS", text="\u59cb\u7ec8\uff08Always\uff09", realtext="\u59cb\u7ec8\uff08Always\uff09"), @CodeItem(value="CHANGED", text="\u6784\u5efa\u72b6\u6001\u53d8\u5316\uff08Changed\uff09", realtext="\u6784\u5efa\u72b6\u6001\u53d8\u5316\uff08Changed\uff09"), @CodeItem(value="FIXED", text="\u6784\u5efa\u72b6\u6001\u4fee\u590d\uff08Fixed\uff09", realtext="\u6784\u5efa\u72b6\u6001\u4fee\u590d\uff08Fixed\uff09", userdata="Only run the steps in post if the current Pipeline\u2019s run is successful and the previous run failed or was unstable."), @CodeItem(value="REGRESSION", text="\u6784\u5efa\u72b6\u6001\u5012\u9000\uff08Regression\uff09", realtext="\u6784\u5efa\u72b6\u6001\u5012\u9000\uff08Regression\uff09", userdata="Only run the steps in post if the current Pipeline\u2019s or status is failure, unstable, or aborted and the previous run was successful."), @CodeItem(value="ABORTED", text="\u6784\u5efa\u88ab\u4e2d\u6b62\uff08Aborted\uff09", realtext="\u6784\u5efa\u88ab\u4e2d\u6b62\uff08Aborted\uff09", userdata="Only run the steps in post if the current Pipeline\u2019s run has an \"aborted\" status, usually due to the Pipeline being manually aborted. This is typically denoted by gray in the web UI."), @CodeItem(value="FAILURE", text="\u6784\u5efa\u72b6\u6001\u4e3a\u5931\u8d25\uff08Failure\uff09", realtext="\u6784\u5efa\u72b6\u6001\u4e3a\u5931\u8d25\uff08Failure\uff09", userdata="Only run the steps in post if the current Pipeline\u2019s or stage\u2019s run has a \"failed\" status, typically denoted by red in the web UI."), @CodeItem(value="SUCCESS", text="\u6784\u5efa\u72b6\u6001\u4e3a\u6210\u529f\uff08Success\uff09", realtext="\u6784\u5efa\u72b6\u6001\u4e3a\u6210\u529f\uff08Success\uff09", userdata="Only run the steps in post if the current Pipeline\u2019s or stage\u2019s run has a \"success\" status, typically denoted by blue or green in the web UI."), @CodeItem(value="UNSTABLE", text="\u6784\u5efa\u72b6\u6001\u4e3a\u4e0d\u7a33\u5b9a\uff08Unstable\uff09", realtext="\u6784\u5efa\u72b6\u6001\u4e3a\u4e0d\u7a33\u5b9a\uff08Unstable\uff09", userdata="Only run the steps in post if the current Pipeline\u2019s run has an \"unstable\" status, usually caused by test failures, code violations, etc. This is typically denoted by yellow in the web UI."), @CodeItem(value="UNSUCCESSFUL", text="\u6784\u5efa\u72b6\u6001\u4e0d\u4e3a\u6210\u529f\uff08Unsuccessful\uff09", realtext="\u6784\u5efa\u72b6\u6001\u4e0d\u4e3a\u6210\u529f\uff08Unsuccessful\uff09", userdata="Only run the steps in post if the current Pipeline\u2019s or stage\u2019s run has not a \"success\" status. This is typically denoted in the web UI depending on the status previously mentioned (for stages this may fire if the build itself is unstable)."), @CodeItem(value="CLEANUP", text="\u6e05\u7406\uff08Cleanup\uff09", realtext="\u6e05\u7406\uff08Cleanup\uff09", userdata="Run the steps in this post condition after every other post condition has been evaluated, regardless of the Pipeline or stage\u2019s status.")})
public class PipelineStagePostTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String NONE = "NONE";
    public static final String ALWAYS = "ALWAYS";
    public static final String CHANGED = "CHANGED";
    public static final String FIXED = "FIXED";
    public static final String REGRESSION = "REGRESSION";
    public static final String ABORTED = "ABORTED";
    public static final String FAILURE = "FAILURE";
    public static final String SUCCESS = "SUCCESS";
    public static final String UNSTABLE = "UNSTABLE";
    public static final String UNSUCCESSFUL = "UNSUCCESSFUL";
    public static final String CLEANUP = "CLEANUP";

    public PipelineStagePostTypeCodeListModel() {
        this.initAnnotation(PipelineStagePostTypeCodeListModel.class);
        this.setUserData2("PipelineStagePostType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.PipelineStagePostTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.PipelineStagePostTypeCodeListModel");
    }
}

