package SA.SRFramework.WebEx.Utility.Jsp;

import javax.servlet.DispatcherType;
import javax.servlet.ServletException;
import javax.servlet.jsp.PageContext;
import junit.framework.TestCase;

public class SimpleServletAdaptersTest extends TestCase {
    public void testHeadersAreReadableAndCaseInsensitive() {
        SimpleServletResponse response = new SimpleServletResponse();
        assertEquals(200, response.getStatus());
        response.addHeader("Cache-Control", "no-cache");
        response.addHeader("cache-control", "no-store");
        assertEquals(1, response.getHeaderNames().size());
        assertEquals("no-cache", response.getHeader("CACHE-CONTROL"));
        assertEquals(2, response.getHeaders("cache-control").size());
        response.setHeader("CACHE-CONTROL", "private");
        assertEquals(1, response.getHeaders("cache-control").size());
        assertEquals("private", response.getHeader("cache-control"));
        response.setContentLengthLong(3000000000L);
        assertEquals("3000000000", response.getHeader("content-length"));
        response.setStatus(201);
        assertEquals(201, response.getStatus());
        response.reset();
        assertEquals(200, response.getStatus());
        assertTrue(response.getHeaderNames().isEmpty());
    }

    public void testSimulatedRequestRejectsUnsupportedOperations() throws Exception {
        SimpleServletRequest request = new SimpleServletRequest();
        assertEquals(DispatcherType.REQUEST, request.getDispatcherType());
        assertFalse(request.isAsyncSupported());
        assertFalse(request.isAsyncStarted());
        try {
            request.startAsync();
            fail("Expected simulated request to reject async processing");
        } catch (IllegalStateException expected) {
            assertNotNull(expected.getMessage());
        }
        try {
            request.getParts();
            fail("Expected simulated request to reject multipart uploads");
        } catch (ServletException expected) {
            assertNotNull(expected.getMessage());
        }
    }

    public void testSimulatedPageELReadsAndWritesPageAttributes() {
        SimplePageContext page = new SimplePageContext();
        page.setAttribute("name", "initial", PageContext.PAGE_SCOPE);
        assertEquals(PageContext.PAGE_SCOPE, page.getAttributesScope("name"));
        assertTrue(page.getAttributeNamesInScope(PageContext.PAGE_SCOPE).hasMoreElements());
        assertEquals("initial", page.getELContext().getELResolver().getValue(page.getELContext(), null, "name"));
        page.getELContext().getELResolver().setValue(page.getELContext(), null, "name", "updated");
        assertEquals("updated", page.getAttribute("name", PageContext.PAGE_SCOPE));
        page.release();
        assertNull(page.getAttribute("name"));
    }
}
