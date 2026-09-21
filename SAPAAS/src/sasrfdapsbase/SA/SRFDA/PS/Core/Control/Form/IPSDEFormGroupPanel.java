/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Form;

import SA.SRFDA.PS.Core.Control.Form.IPSDEFormDetail;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormGroupBase;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormItem;
import SA.SRFDA.PS.Core.PSModelExtendMeta;
import SA.SRFDA.PS.Core.View.IPSUIActionGroup;
import java.util.Iterator;

@PSModelExtendMeta(title="\u5b9e\u4f53\u8868\u5355\u5206\u7ec4\u9762\u677f\u6210\u5458\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"GROUPPANEL"})
public interface IPSDEFormGroupPanel
extends IPSDEFormDetail,
IPSDEFormGroupBase {
    public static final int BUILDINACTION_NEW = 1;
    public static final int BUILDINACTION_MORE = 2;

    public String getSubCaption();

    public int getBuildInActions();

    public boolean isEnableBuildInAction(int var1);

    public IPSUIActionGroup getPSUIActionGroup();

    public String getActionGroupExtractMode();

    public boolean isInfoGroupMode();

    public boolean isInfoGroupConvertPickerToLink();

    public boolean isInfoGroupReadOnlyMode();

    public boolean isHideEmptyItems();

    public Iterator<IPSDEFormItem> getAnchorablePSDEFormItems();
}

