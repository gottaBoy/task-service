/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.jsp.JspException
 *  org.springframework.context.NoSuchMessageException
 *  org.springframework.web.servlet.tags.MessageTag
 */
package net.ibizsys.paas.web.tags;

import javax.servlet.jsp.JspException;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebContext;
import org.springframework.context.NoSuchMessageException;

public class MessageTag
extends org.springframework.web.servlet.tags.MessageTag {
    private String strCode = null;
    private String strText = null;

    public void setCode(String code) {
        this.strCode = code;
        super.setCode(code);
    }

    public void setText(String text) {
        this.strText = text;
        super.setText(text);
    }

    protected String resolveMessage() throws JspException, NoSuchMessageException {
        IWebContext iWebContext = WebContext.getCurrent();
        if (iWebContext != null) {
            return iWebContext.getLocalization(this.strCode, this.strText);
        }
        return super.resolveMessage();
    }
}

