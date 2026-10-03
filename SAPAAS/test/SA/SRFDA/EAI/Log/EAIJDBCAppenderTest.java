package SA.SRFDA.EAI.Log;

import java.io.File;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import junit.framework.TestCase;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.ErrorCode;
import org.apache.log4j.spi.ErrorHandler;
import org.apache.log4j.spi.LoggingEvent;
import org.mule.api.MuleContext;
import org.mule.api.config.MuleConfiguration;
import org.mule.api.registry.MuleRegistry;
import org.sqlite.SQLiteDataSource;

public class EAIJDBCAppenderTest extends TestCase {
    private static class TrackingSource extends SQLiteDataSource {
        int borrowed;
        int returned;

        @Override
        public Connection getConnection() throws SQLException {
            final Connection connection = super.getConnection();
            borrowed++;
            return (Connection) Proxy.newProxyInstance(getClass().getClassLoader(),
                    new Class<?>[] {Connection.class}, new InvocationHandler() {
                        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                            if ("close".equals(method.getName())) {
                                returned++;
                            }
                            try {
                                return method.invoke(connection, args);
                            } catch (InvocationTargetException ex) {
                                throw ex.getCause();
                            }
                        }
                    });
        }
    }

    private static class Errors implements ErrorHandler {
        int writes;
        int closes;

        public void activateOptions() { }
        public void setLogger(Logger logger) { }
        public void setAppender(org.apache.log4j.Appender appender) { }
        public void setBackupAppender(org.apache.log4j.Appender appender) { }
        public void error(String message) { fail(message); }
        public void error(String message, Exception ex, int code) {
            if (code == ErrorCode.FLUSH_FAILURE) {
                writes++;
            } else if (code == ErrorCode.CLOSE_FAILURE) {
                closes++;
            } else {
                fail(message);
            }
        }
        public void error(String message, Exception ex, int code, LoggingEvent event) {
            error(message, ex, code);
        }
    }

    private static class Appender extends EAIJDBCAppender {
        Connection borrow() throws SQLException {
            return getConnection();
        }

        void release(Connection connection) {
            closeConnection(connection);
        }
    }

    private static Object proxy(Class<?> type, final InvocationHandler handler) {
        return Proxy.newProxyInstance(type.getClassLoader(), new Class<?>[] {type}, handler);
    }

    private static MuleContext context(final Object source, final String id) {
        final MuleRegistry registry = (MuleRegistry) proxy(MuleRegistry.class, new InvocationHandler() {
            public Object invoke(Object instance, Method method, Object[] args) {
                if ("lookupObject".equals(method.getName()) && args != null
                        && ("SRFDADATASOURCE".equals(args[0]) || "auditDS".equals(args[0]))) {
                    if (source instanceof RuntimeException) {
                        throw (RuntimeException) source;
                    }
                    return source;
                }
                return null;
            }
        });
        final MuleConfiguration config = (MuleConfiguration) proxy(MuleConfiguration.class, new InvocationHandler() {
            public Object invoke(Object instance, Method method, Object[] args) {
                return "getId".equals(method.getName()) ? id : null;
            }
        });
        return (MuleContext) proxy(MuleContext.class, new InvocationHandler() {
            public Object invoke(Object instance, Method method, Object[] args) {
                if ("getRegistry".equals(method.getName())) {
                    return registry;
                }
                return "getConfiguration".equals(method.getName()) ? config : null;
            }
        });
    }

    private static LoggingEvent event(String message) {
        return new LoggingEvent(EAIJDBCAppenderTest.class.getName(), Logger.getLogger("audit"),
                org.apache.log4j.Level.INFO, message, null);
    }

    private static int count(TrackingSource source) throws Exception {
        try (Connection connection = source.getConnection();
                Statement statement = connection.createStatement();
                ResultSet rows = statement.executeQuery("SELECT count(*) FROM audit")) {
            rows.next();
            return rows.getInt(1);
        }
    }

    public void testSqlBufferAndConnectionLifecycle() throws Exception {
        File db = Files.createTempFile("eai-jdbc-appender-", ".db").toFile();
        try {
            TrackingSource source = new TrackingSource();
            source.setUrl("jdbc:sqlite:" + db.getAbsolutePath());
            try (Connection connection = source.getConnection();
                    Statement statement = connection.createStatement()) {
                statement.executeUpdate("CREATE TABLE audit (message TEXT)");
            }
            Appender appender = new Appender();
            appender.setMuleContext(context(source, "mule-system"));
            assertEquals("mule-system", appender.getSystemId());
            appender.setSystemId("explicit-system");
            assertEquals("explicit-system", appender.getSystemId());
            appender.setDSN("auditDS");
            assertEquals("auditDS", appender.getDSN());
            appender.setSql("INSERT INTO audit(message) VALUES('%m')");
            appender.setBufferSize(2);
            assertEquals(2, appender.getBufferSize());
            Errors errors = new Errors();
            appender.setErrorHandler(errors);

            appender.doAppend(event("first"));
            assertEquals(0, count(source));
            int borrowed = source.borrowed;
            appender.doAppend(event("second"));
            assertEquals(2, count(source));
            assertEquals(borrowed + 3, source.borrowed);
            assertEquals(source.borrowed, source.returned);

            appender.setDSN(null);
            appender.doAppend(event("third"));
            appender.close();
            assertEquals(3, count(source));
            assertEquals(source.borrowed, source.returned);
            assertEquals(0, errors.writes);
        } finally {
            assertTrue(db.delete());
        }
    }

    public void testMissingOrInvalidDataSourceReportsSqlError() throws Exception {
        Appender appender = new Appender();
        appender.setMuleContext(context(new Object(), "instance"));
        Errors errors = new Errors();
        appender.setErrorHandler(errors);
        appender.setSql("INSERT INTO audit(message) VALUES('%m')");
        try {
            appender.borrow();
            fail("missing DataSource should fail");
        } catch (SQLException expected) {
            assertTrue(expected.getMessage().contains("SRFDADATASOURCE"));
        }
        appender.setDSN("auditDS");
        try {
            appender.borrow();
            fail("wrong registry type should fail");
        } catch (SQLException expected) {
            assertTrue(expected.getMessage().contains("auditDS"));
        }
        appender.doAppend(event("not written"));
        assertEquals(1, errors.writes);
        appender.close();
    }

    public void testFailedSqlReportedAndLaterEventsStillRun() throws Exception {
        File db = Files.createTempFile("eai-jdbc-errors-", ".db").toFile();
        try {
            TrackingSource source = new TrackingSource();
            source.setUrl("jdbc:sqlite:" + db.getAbsolutePath());
            try (Connection connection = source.getConnection();
                    Statement statement = connection.createStatement()) {
                statement.executeUpdate("CREATE TABLE audit (message TEXT)");
            }
            Appender appender = new Appender();
            appender.setMuleContext(context(source, "instance"));
            Errors errors = new Errors();
            appender.setErrorHandler(errors);
            appender.setSql("INSERT INTO missing(message) VALUES('%m')");
            appender.doAppend(event("bad"));
            assertEquals(1, errors.writes);
            appender.setSql("INSERT INTO audit(message) VALUES('%m')");
            appender.doAppend(event("good"));
            assertEquals(1, count(source));
            assertEquals(source.borrowed, source.returned);
            appender.close();
        } finally {
            assertTrue(db.delete());
        }
    }

    public void testInvalidBufferSizeRejected() {
        Appender appender = new Appender();
        try {
            appender.setBufferSize(0);
            fail("zero buffer size should fail");
        } catch (IllegalArgumentException expected) {
            assertEquals(1, appender.getBufferSize());
        }
    }

    public void testReturningConnectionFailureIsReported() {
        Appender appender = new Appender();
        Errors errors = new Errors();
        appender.setErrorHandler(errors);
        Connection broken = (Connection) proxy(Connection.class, new InvocationHandler() {
            public Object invoke(Object instance, Method method, Object[] args) throws SQLException {
                if ("close".equals(method.getName())) {
                    throw new SQLException("connection close failed");
                }
                return null;
            }
        });
        appender.release(broken);
        assertEquals(1, errors.closes);
    }

    public void testRegistryLookupFailureIsReportedByLog4j() {
        Appender appender = new Appender();
        appender.setMuleContext(context(new IllegalStateException("registry failed"), "instance"));
        appender.setSql("INSERT INTO audit(message) VALUES('%m')");
        Errors errors = new Errors();
        appender.setErrorHandler(errors);
        appender.doAppend(event("not written"));
        assertEquals(1, errors.writes);
        appender.close();
    }
}
