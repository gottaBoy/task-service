/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.FilterChain
 *  javax.servlet.FilterConfig
 *  javax.servlet.ServletException
 *  javax.servlet.ServletRequest
 *  javax.servlet.ServletResponse
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 */
package org.jasig.cas.client.validation;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jasig.cas.client.util.AbstractCasFilter;
import org.jasig.cas.client.util.CommonUtils;
import org.jasig.cas.client.validation.Assertion;
import org.jasig.cas.client.validation.TicketValidationException;
import org.jasig.cas.client.validation.TicketValidator;

public abstract class AbstractTicketValidationFilter
extends AbstractCasFilter {
    private TicketValidator ticketValidator;
    private boolean redirectAfterValidation = false;
    private boolean exceptionOnValidationFailure = true;
    private boolean useSession = true;

    protected TicketValidator getTicketValidator(FilterConfig filterConfig) {
        return this.ticketValidator;
    }

    @Override
    protected void initInternal(FilterConfig filterConfig) throws ServletException {
        this.setExceptionOnValidationFailure(this.parseBoolean(this.getPropertyFromInitParams(filterConfig, "exceptionOnValidationFailure", "true")));
        this.log.trace((Object)("Setting exceptionOnValidationFailure parameter: " + this.exceptionOnValidationFailure));
        this.setRedirectAfterValidation(this.parseBoolean(this.getPropertyFromInitParams(filterConfig, "redirectAfterValidation", "true")));
        this.log.trace((Object)("Setting redirectAfterValidation parameter: " + this.redirectAfterValidation));
        this.setUseSession(this.parseBoolean(this.getPropertyFromInitParams(filterConfig, "useSession", "true")));
        this.log.trace((Object)("Setting useSession parameter: " + this.useSession));
        this.setTicketValidator(this.getTicketValidator(filterConfig));
        super.initInternal(filterConfig);
    }

    @Override
    public void init() {
        super.init();
        CommonUtils.assertNotNull(this.ticketValidator, "ticketValidator cannot be null.");
    }

    protected boolean preFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        return true;
    }

    protected void onSuccessfulValidation(HttpServletRequest request, HttpServletResponse response, Assertion assertion) {
    }

    protected void onFailedValidation(HttpServletRequest request, HttpServletResponse response) {
    }

    public final void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (!this.preFilter(servletRequest, servletResponse, filterChain)) {
            return;
        }
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        String ticket = CommonUtils.safeGetParameter(request, this.getArtifactParameterName());
        if (CommonUtils.isNotBlank(ticket)) {
            block8: {
                if (this.log.isDebugEnabled()) {
                    this.log.debug((Object)("Attempting to validate ticket: " + ticket));
                }
                try {
                    Assertion assertion = this.ticketValidator.validate(ticket, this.constructServiceUrl(request, response));
                    if (this.log.isDebugEnabled()) {
                        this.log.debug((Object)("Successfully authenticated user: " + assertion.getPrincipal().getName()));
                    }
                    request.setAttribute("_const_cas_assertion_", (Object)assertion);
                    if (this.useSession) {
                        request.getSession().setAttribute("_const_cas_assertion_", (Object)assertion);
                    }
                    this.onSuccessfulValidation(request, response, assertion);
                }
                catch (TicketValidationException e) {
                    response.setStatus(403);
                    this.log.warn((Object)e, (Throwable)e);
                    this.onFailedValidation(request, response);
                    if (!this.exceptionOnValidationFailure) break block8;
                    throw new ServletException((Throwable)e);
                }
            }
            if (this.redirectAfterValidation) {
                this.log.debug((Object)"Redirecting after successful ticket validation.");
                response.sendRedirect(response.encodeRedirectURL(this.constructServiceUrl(request, response)));
                return;
            }
        }
        filterChain.doFilter((ServletRequest)request, (ServletResponse)response);
    }

    public final void setTicketValidator(TicketValidator ticketValidator) {
        this.ticketValidator = ticketValidator;
    }

    public final void setRedirectAfterValidation(boolean redirectAfterValidation) {
        this.redirectAfterValidation = redirectAfterValidation;
    }

    public final void setExceptionOnValidationFailure(boolean exceptionOnValidationFailure) {
        this.exceptionOnValidationFailure = exceptionOnValidationFailure;
    }

    public final void setUseSession(boolean useSession) {
        this.useSession = useSession;
    }
}

