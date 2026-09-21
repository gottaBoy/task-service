/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DynaModel;

import SA.SRFDA.PS.Core.DynaModel.IPSXmlElement;
import SA.SRFDA.PS.Core.DynaModel.PSXmlNodeImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import java.util.LinkedHashMap;
import java.util.Map;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Attr;
import org.w3c.dom.Node;

public abstract class PSXmlElementImpl
extends PSXmlNodeImpl
implements IPSXmlElement {
    private static final Log log = LogFactory.getLog(PSXmlElementImpl.class);
    private Map<String, Attr> attrMap = new LinkedHashMap<String, Attr>();

    @Override
    protected void onInit() throws Exception {
        if (this.getXmlElement() == null) {
            throw new Exception("Xml\u5143\u7d20\u5bf9\u8c61\u65e0\u6548");
        }
        if (this.getXmlElement().getAttributes() != null) {
            int i = 0;
            while (i < this.getXmlElement().getAttributes().getLength()) {
                Attr attr;
                Node node = this.getXmlElement().getAttributes().item(i);
                if (node instanceof Attr && !StringHelper.isNullOrEmpty((String)(attr = (Attr)node).getName())) {
                    this.attrMap.put(attr.getName().toUpperCase(), attr);
                }
                ++i;
            }
        }
        super.onInit();
    }

    protected Attr getAttr(String strName, boolean bTryMode) throws Exception {
        Attr attr = this.attrMap.get(strName.toUpperCase());
        if (attr == null) {
            if (bTryMode) {
                return null;
            }
            throw new Exception(String.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a[%1$s]\u5c5e\u6027\u5bf9\u8c61", strName));
        }
        return attr;
    }

    protected Boolean getAttrBooleanValue(String strName, Boolean bDefault) {
        Attr attr;
        try {
            attr = this.getAttr(strName, true);
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return bDefault;
        }
        if (attr == null) {
            return bDefault;
        }
        if (StringHelper.compare((String)"TRUE", (String)attr.getValue(), (boolean)true) == 0) {
            return true;
        }
        return false;
    }

    protected String getAttrStringValue(String strName, String strDefault) {
        Attr attr;
        try {
            attr = this.getAttr(strName, true);
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return strDefault;
        }
        if (attr == null) {
            return strDefault;
        }
        return attr.getValue();
    }

    @Override
    @PSModelRTMeta(description="\u5143\u7d20\u6807\u8bc6", hideempty2=true)
    public String getElementId() {
        return this.getAttrStringValue("ID", null);
    }
}

