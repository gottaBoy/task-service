/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.dataentity.field.IPSDEField
 *  net.ibizsys.model.dataentity.field.IPSInheritDEField
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.dataentity.field;

import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.dataentity.field.IPSDEField;
import net.ibizsys.model.dataentity.field.IPSInheritDEField;
import net.ibizsys.model.dataentity.field.PSLinkDEFieldImpl;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSInheritDEFieldImpl
extends PSLinkDEFieldImpl
implements IPSInheritDEField {
    private static final Log log = LogFactory.getLog(PSInheritDEFieldImpl.class);
    private IPSDEField realInheritPSDEField = null;

    @Override
    @PSModelRTMeta(description="\u7ee7\u627f\u5c5e\u6027")
    public boolean isInheritDEField() {
        return true;
    }

    @Override
    @PSModelRTMeta(description="\u7269\u7406\u5c5e\u6027")
    public boolean isPhisicalDEField() {
        return false;
    }

    @PSModelRTMeta(description="\u5b9e\u9645\u7ee7\u627f\u5c5e\u6027\u5bf9\u8c61")
    public IPSDEField getRealInheritPSDEField() throws Exception {
        this.prepareRealInheritPSDEField();
        return this.realInheritPSDEField;
    }

    protected synchronized void prepareRealInheritPSDEField() throws Exception {
        if (this.realInheritPSDEField != null) {
            return;
        }
        if (this.getRelatedPSDEField().isInheritDEField()) {
            IPSInheritDEField iInheritDEFHelper = null;
            if (this.getRelatedPSDEField() instanceof IPSInheritDEField) {
                iInheritDEFHelper = (IPSInheritDEField)this.getRelatedPSDEField();
            }
            if (iInheritDEFHelper == null) {
                log.error((Object)StringHelper.format((String)"\u5c5e\u6027[%1$s]\u8f85\u52a9\u5bf9\u8c61\u6ca1\u6709\u5b9e\u73b0\u63a5\u53e3[IPSInheritDEField]", (Object)this.getRelatedPSDEField().getFullName()));
            }
            this.realInheritPSDEField = iInheritDEFHelper.getRealInheritPSDEField();
            if (this.realInheritPSDEField == null) {
                log.error((Object)StringHelper.format((String)"\u5c5e\u6027[%1$s]\u5b9e\u9645\u5173\u7cfb\u5c5e\u6027\u65e0\u6548", (Object)this.getRelatedPSDEField().getFullName()));
            }
        } else {
            this.realInheritPSDEField = this.getRelatedPSDEField();
        }
    }
}

