/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.IPSControl
 *  net.ibizsys.model.control.IPSControlType
 *  net.ibizsys.model.control.IPSEditorType
 */
package net.ibizsys.model.pf;

import java.util.Iterator;
import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.IPSControlType;
import net.ibizsys.model.control.IPSEditorType;
import net.ibizsys.model.pf.IPSPFCtrlTempl;
import net.ibizsys.model.pf.IPSPFCtrlTemplDetail;
import net.ibizsys.model.pf.IPSPFEditorTempl;
import net.ibizsys.model.pf.IPSPFObject;
import net.ibizsys.model.pf.IPSPFPubCode;

public interface IPSPFStyle
extends IPSPFObject {
    public Iterator<IPSPFCtrlTempl> getPSPFCtrlTempls(IPSControl var1) throws Exception;

    public boolean hasPSPFCtrlTempls(IPSControl var1) throws Exception;

    public boolean hasPSPFCtrlTempls(IPSControl var1, String var2) throws Exception;

    public IPSPFCtrlTempl getPSPFCtrlTempl(IPSControlType var1, IPSPFPubCode var2) throws Exception;

    public IPSPFCtrlTemplDetail getPSPFCtrlTemplDetail(IPSControlType var1, IPSPFPubCode var2, String var3) throws Exception;

    public IPSPFCtrlTemplDetail getPSPFCtrlTemplDetail(IPSControlType var1, IPSPFPubCode var2, String var3, boolean var4) throws Exception;

    public String getPFStyleParams();

    public IPSPFCtrlTempl getPSPFCtrlTempl(String var1) throws Exception;

    public IPSPFCtrlTempl getPSPFCtrlTempl(String var1, boolean var2) throws Exception;

    public IPSPFEditorTempl getPSPFEditorTempl(String var1) throws Exception;

    public IPSPFEditorTempl getPSPFEditorTempl(String var1, boolean var2) throws Exception;

    public IPSPFEditorTempl getPSPFEditorTempl(IPSEditorType var1, String var2, IPSPFPubCode var3) throws Exception;

    public IPSPFStyle getTemplPSPFStyle() throws Exception;

    public String getVersionString();

    public String getStyleParam(String var1, String var2);

    public int getStyleParam(String var1, int var2);

    public int getVersion();

    public String getPSDevCenterId();
}

