/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.jsp.PageContext
 */
package SA.SRFramework.Web;

import SA.SRFramework.Web.INamingContainer;
import SA.SRFramework.Web.SRFCommonEventImpl;
import SA.SRFramework.Web.WebContext;
import javax.servlet.jsp.PageContext;

public class SRFUserControl
extends SRFCommonEventImpl
implements INamingContainer {
    public void Init(PageContext context) {
        WebContext tempContext = WebContext.Current(context, false);
        if (tempContext == null) {
            return;
        }
        tempContext.getPage().AddControl(this);
    }

    public void Load() {
        this.OnInitComponents();
        this.OnLoad();
        if (this.getPage().getIsPostBack() && this.getPage().getIsFinishLoad()) {
            this.RaiseControlEvents();
        }
    }

    protected void OnInitComponents() {
    }

    protected void OnLoad() {
    }
}

