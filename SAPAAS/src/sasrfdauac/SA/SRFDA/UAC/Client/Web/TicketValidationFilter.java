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
package SA.SRFDA.UAC.Client.Web;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jasig.cas.client.proxy.Cas20ProxyRetriever;
import org.jasig.cas.client.proxy.CleanUpTimerTask;
import org.jasig.cas.client.proxy.ProxyGrantingTicketStorage;
import org.jasig.cas.client.proxy.ProxyGrantingTicketStorageImpl;
import org.jasig.cas.client.util.CommonUtils;
import org.jasig.cas.client.validation.AbstractTicketValidationFilter;
import org.jasig.cas.client.validation.Cas20ProxyTicketValidator;
import org.jasig.cas.client.validation.Cas20ServiceTicketValidator;
import org.jasig.cas.client.validation.ProxyList;
import org.jasig.cas.client.validation.ProxyListEditor;
import org.jasig.cas.client.validation.TicketValidator;

public class TicketValidationFilter
extends AbstractTicketValidationFilter {
    private static final String[] RESERVED_INIT_PARAMS = new String[]{"proxyReceptorUrl", "acceptAnyProxy", "allowedProxyChains", "casServerUrlPrefix", "proxyCallbackUrl", "renew", "exceptionOnValidationFailure", "redirectAfterValidation", "useSession", "serverName", "service", "artifactParameterName", "serviceParameterName", "encodeServiceUrl", "millisBetweenCleanUps"};
    private static final int DEFAULT_MILLIS_BETWEEN_CLEANUPS = 60000;
    private String proxyReceptorUrl;
    private Timer timer;
    private TimerTask timerTask;
    private int millisBetweenCleanUps;
    private ProxyGrantingTicketStorage proxyGrantingTicketStorage = new ProxyGrantingTicketStorageImpl();

    @Override
    protected void initInternal(FilterConfig filterConfig) throws ServletException {
        this.setServerName(this.getPropertyFromInitParams(filterConfig, "SERVERNAME", null));
        super.initInternal(filterConfig);
        this.setProxyReceptorUrl(this.getPropertyFromInitParams(filterConfig, "proxyReceptorUrl", null));
        String proxyGrantingTicketStorageClass = this.getPropertyFromInitParams(filterConfig, "proxyGrantingTicketStorageClass", null);
        if (proxyGrantingTicketStorageClass != null) {
            try {
                Class<?> storageClass = Class.forName(proxyGrantingTicketStorageClass);
                this.proxyGrantingTicketStorage = (ProxyGrantingTicketStorage)storageClass.newInstance();
            }
            catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        this.log.trace((Object)("Setting proxyReceptorUrl parameter: " + this.proxyReceptorUrl));
        this.millisBetweenCleanUps = Integer.parseInt(this.getPropertyFromInitParams(filterConfig, "millisBetweenCleanUps", Integer.toString(60000)));
        this.setUseSession(true);
    }

    @Override
    public void init() {
        super.init();
        CommonUtils.assertNotNull(this.proxyGrantingTicketStorage, "proxyGrantingTicketStorage cannot be null.");
        if (this.timer == null) {
            this.timer = new Timer(true);
        }
        if (this.timerTask == null) {
            this.timerTask = new CleanUpTimerTask(this.proxyGrantingTicketStorage);
        }
        this.timer.schedule(this.timerTask, this.millisBetweenCleanUps, (long)this.millisBetweenCleanUps);
    }

    @Override
    protected final TicketValidator getTicketValidator(FilterConfig filterConfig) {
        Cas20ServiceTicketValidator validator;
        String allowAnyProxy = this.getPropertyFromInitParams(filterConfig, "acceptAnyProxy", null);
        String allowedProxyChains = this.getPropertyFromInitParams(filterConfig, "allowedProxyChains", null);
        String casServerUrlPrefix = this.getPropertyFromInitParams(filterConfig, "UACSERVER", null);
        if (CommonUtils.isNotBlank(allowAnyProxy) || CommonUtils.isNotBlank(allowedProxyChains)) {
            Cas20ProxyTicketValidator v = new Cas20ProxyTicketValidator(casServerUrlPrefix);
            v.setAcceptAnyProxy(this.parseBoolean(allowAnyProxy));
            v.setAllowedProxyChains(this.createProxyList(allowedProxyChains));
            validator = v;
        } else {
            validator = new Cas20ServiceTicketValidator(casServerUrlPrefix);
        }
        validator.setProxyCallbackUrl(this.getPropertyFromInitParams(filterConfig, "proxyCallbackUrl", null));
        validator.setProxyGrantingTicketStorage(this.proxyGrantingTicketStorage);
        validator.setProxyRetriever(new Cas20ProxyRetriever(casServerUrlPrefix));
        validator.setRenew(this.parseBoolean(this.getPropertyFromInitParams(filterConfig, "renew", "false")));
        HashMap<String, String> additionalParameters = new HashMap<String, String>();
        List<String> params = Arrays.asList(RESERVED_INIT_PARAMS);
        Enumeration e = filterConfig.getInitParameterNames();
        while (e.hasMoreElements()) {
            String s = (String)e.nextElement();
            if (params.contains(s)) continue;
            additionalParameters.put(s, filterConfig.getInitParameter(s));
        }
        validator.setCustomParameters(additionalParameters);
        return validator;
    }

    protected final ProxyList createProxyList(String proxies) {
        if (CommonUtils.isBlank(proxies)) {
            return new ProxyList();
        }
        ProxyListEditor editor = new ProxyListEditor();
        editor.setAsText(proxies);
        return (ProxyList)editor.getValue();
    }

    @Override
    public void destroy() {
        super.destroy();
        this.timer.cancel();
    }

    @Override
    protected final boolean preFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        String requestUri = request.getRequestURI();
        if (CommonUtils.isEmpty(this.proxyReceptorUrl) || !requestUri.endsWith(this.proxyReceptorUrl)) {
            return true;
        }
        CommonUtils.readAndRespondToProxyReceptorRequest(request, response, this.proxyGrantingTicketStorage);
        return false;
    }

    public final void setProxyReceptorUrl(String proxyReceptorUrl) {
        this.proxyReceptorUrl = proxyReceptorUrl;
    }

    public void setProxyGrantingTicketStorage(ProxyGrantingTicketStorage storage) {
        this.proxyGrantingTicketStorage = storage;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }

    public void setTimerTask(TimerTask timerTask) {
        this.timerTask = timerTask;
    }

    public void setMillisBetweenCleanUps(int millisBetweenCleanUps) {
        this.millisBetweenCleanUps = millisBetweenCleanUps;
    }
}

