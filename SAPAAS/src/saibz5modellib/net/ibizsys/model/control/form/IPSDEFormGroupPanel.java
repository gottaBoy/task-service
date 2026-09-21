/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.control.form;

import java.util.Iterator;
import net.ibizsys.model.control.form.IPSDEFormDetail;

public interface IPSDEFormGroupPanel
extends IPSDEFormDetail {
    public static final int TITLEBARCLOSEMODE_NONE = 0;
    public static final int TITLEBARCLOSEMODE_OPENDEFAULT = 1;
    public static final int TITLEBARCLOSEMODE_CLOSEDEFAULT = 2;
    public static final int BUILDINACTION_NEW = 1;
    public static final int BUILDINACTION_MORE = 2;

    public String getLayoutMode();

    public double[] getColumnWidths();

    public Iterator<IPSDEFormDetail> getPSDEFormDetails();

    public int getPSDEFormDetailCount();

    public IPSDEFormDetail getPSDEFormDetail(int var1) throws Exception;

    public int getLabelColSpan();

    public int getCtrlColSpan();

    public int getColumnCount();

    public int getChildColXS();

    public int getChildColSM();

    public int getChildColMD();

    public int getChildColLG();

    public String getCaptionItemName();

    public String getSubCaption();

    public int getTitleBarCloseMode();

    public boolean isEnableAnchor();

    public int getBuildInActions();

    public boolean isEnableBuildInAction(int var1);
}

