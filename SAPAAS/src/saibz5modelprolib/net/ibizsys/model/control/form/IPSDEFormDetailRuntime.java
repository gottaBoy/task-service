/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.IPSModelJsonExporter
 *  net.ibizsys.model.app.view.IPSAppView
 *  net.ibizsys.model.app.view.IPSAppViewRef
 *  net.ibizsys.model.control.form.IPSDEForm
 *  net.ibizsys.model.control.form.IPSDEFormDRUIPart
 *  net.ibizsys.model.control.form.IPSDEFormDetail
 *  net.ibizsys.model.control.form.IPSDEFormItem
 */
package net.ibizsys.model.control.form;

import java.util.ArrayList;
import net.ibizsys.model.IPSModelJsonExporter;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.app.view.IPSAppViewRef;
import net.ibizsys.model.control.form.IPSDEForm;
import net.ibizsys.model.control.form.IPSDEFormDRUIPart;
import net.ibizsys.model.control.form.IPSDEFormDetail;
import net.ibizsys.model.control.form.IPSDEFormItem;
import net.ibizsys.model.entity.PSDEFormDetail;
import net.ibizsys.model.res.IPSSysPFPlugin;

public interface IPSDEFormDetailRuntime
extends IPSDEFormDetail,
IPSModelJsonExporter {
    public void init(IPSModelStorageContext var1, IPSDEForm var2, IPSDEFormDetail var3, PSDEFormDetail var4) throws Exception;

    public void fillPSDEFormDetails(ArrayList<IPSDEFormDetail> var1);

    public void layout() throws Exception;

    public void fillRelatedPSAppViews(ArrayList<IPSAppView> var1) throws Exception;

    public void fillEmbeddedPSAppViewRefs(String var1, ArrayList<IPSAppViewRef> var2) throws Exception;

    public void fillPSDEFormDRUIParts(ArrayList<IPSDEFormDRUIPart> var1);

    public void fillPSDEFormItems(ArrayList<IPSDEFormItem> var1);

    public IPSSysPFPlugin getPSSysPFPlugin();
}

