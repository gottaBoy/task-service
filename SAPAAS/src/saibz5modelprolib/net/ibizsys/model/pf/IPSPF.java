/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.app.view.IPSAppView
 *  net.ibizsys.model.core.IPSModelObject
 */
package net.ibizsys.model.pf;

import java.util.Iterator;
import java.util.Map;
import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.pf.IPSPFEditorTempl;
import net.ibizsys.model.pf.IPSPFPubCode;
import net.ibizsys.model.pf.IPSPFStyle;
import net.ibizsys.model.pub.IPSPFEditorCodePublisher;

public interface IPSPF
extends IPSModelObject {
    public String getFormLayoutMode();

    public IPSPFPubCode getPSPFPubCode(String var1) throws Exception;

    public IPSPFPubCode getPSPFPubCode(String var1, boolean var2) throws Exception;

    public Iterator<IPSPFPubCode> getPSPFPubCodes(String var1) throws Exception;

    public Iterator<IPSPFPubCode> getPSPFPubCodes(String var1, boolean var2) throws Exception;

    public IPSPFEditorTempl getPSPFEditorTempl(String var1) throws Exception;

    public IPSPFEditorTempl getPSPFEditorTempl(String var1, boolean var2) throws Exception;

    public String getPSAppViewPageUrl(IPSAppView var1) throws Exception;

    public String getPSAppViewBackendUrl(IPSAppView var1) throws Exception;

    public String getPSAppViewPageUrl(IPSAppView var1, Map<String, String> var2) throws Exception;

    public String getPSAppViewBackendUrl(IPSAppView var1, Map<String, String> var2) throws Exception;

    public IPSPFStyle getPSPFStyle(String var1) throws Exception;

    public IPSPFEditorCodePublisher createPSPFEditorCodePublisher() throws Exception;

    public IPSPFPubCode getDynaViewPSPFPubCode();

    public IPSPFPubCode getDynaModelPSPFPubCode();
}

