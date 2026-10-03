package org.jasig.cas.client.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public final class ErrorRedirectFilter implements Filter {
   private final Log log = LogFactory.getLog(this.getClass());
   private final List<ErrorRedirectFilter.ErrorHolder> errors = new ArrayList<ErrorRedirectFilter.ErrorHolder>();
   private String defaultErrorRedirectPage;

   public void destroy() {
   }

   public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
      HttpServletResponse httpResponse = (HttpServletResponse)response;

      try {
         filterChain.doFilter(request, response);
      } catch (ServletException e) {
         Throwable t = e.getCause();
         ErrorRedirectFilter.ErrorHolder currentMatch = null;

         for (ErrorRedirectFilter.ErrorHolder errorHolder : this.errors) {
            if (errorHolder.exactMatch(t)) {
               currentMatch = errorHolder;
               break;
            }

            if (errorHolder.inheritanceMatch(t)) {
               currentMatch = errorHolder;
            }
         }

         if (currentMatch != null) {
            httpResponse.sendRedirect(currentMatch.getUrl());
         } else {
            httpResponse.sendRedirect(this.defaultErrorRedirectPage);
         }
      }
   }

   public void init(FilterConfig filterConfig) throws ServletException {
      this.defaultErrorRedirectPage = filterConfig.getInitParameter("defaultErrorRedirectPage");
      Enumeration enumeration = filterConfig.getInitParameterNames();

      while (enumeration.hasMoreElements()) {
         String className = (String)enumeration.nextElement();

         try {
            if (!className.equals("defaultErrorRedirectPage")) {
               this.errors.add(new ErrorRedirectFilter.ErrorHolder(className, filterConfig.getInitParameter(className)));
            }
         } catch (ClassNotFoundException e) {
            this.log.warn("Class [" + className + "] cannot be found in ClassLoader.  Ignoring.");
         }
      }
   }

   protected final class ErrorHolder {
      private Class className;
      private String url;

      protected ErrorHolder(String className, String url) throws ClassNotFoundException {
         this.className = Class.forName(className);
         this.url = url;
      }

      public boolean exactMatch(Throwable e) {
         return this.className.equals(e.getClass());
      }

      public boolean inheritanceMatch(Throwable e) {
         return this.className.isAssignableFrom(e.getClass());
      }

      public String getUrl() {
         return this.url;
      }
   }
}
