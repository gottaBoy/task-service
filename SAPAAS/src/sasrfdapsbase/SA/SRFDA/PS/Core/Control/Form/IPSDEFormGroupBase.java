/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Form;

import SA.SRFDA.PS.Core.Control.Form.IPSDEFormDetail;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import java.util.Iterator;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u8868\u5355\u5206\u7ec4\u9762\u677f\u6210\u5458\u6a21\u578b\u57fa\u7840\u5bf9\u8c61\u63a5\u53e3", model="PSDEFormDetail")
public interface IPSDEFormGroupBase
extends IPSDEFormDetail {
    public static final int TITLEBARCLOSEMODE_NONE = 0;
    public static final int TITLEBARCLOSEMODE_OPENDEFAULT = 1;
    public static final int TITLEBARCLOSEMODE_CLOSEDEFAULT = 2;

    public String getLayoutMode();

    public double[] getColumnWidths();

    public int getItemRowId(IPSDEFormDetail var1) throws Exception;

    public int getItemRowSpan(IPSDEFormDetail var1) throws Exception;

    public int getItemColId(IPSDEFormDetail var1) throws Exception;

    public int getItemColSpan(IPSDEFormDetail var1) throws Exception;

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

    public int getTitleBarCloseMode();

    public boolean isEnableAnchor();

    public String getCaptionItemName();

    public int getItemIgnoreInput();

    public boolean isItemIgnoreInputDefined();
}

