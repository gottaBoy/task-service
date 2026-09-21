/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Form;

import SA.SRFDA.PS.Core.Control.Form.IPSDEFormDetail;
import SA.SRFDA.PS.Core.PSModelExtendMeta;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import java.util.Properties;

@PSModelExtendMeta(title="\u5b9e\u4f53\u8868\u5355\u81ea\u5b9a\u4e49\u90e8\u4ef6\u6210\u5458\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"USERCONTROL"})
public interface IPSDEFormUserControl
extends IPSDEFormDetail {
    public String getRawContent();

    public IPSSysPFPlugin getRenderPSSysPFPlugin();

    public String getPredefinedType();

    public Properties getCtrlParams();
}

