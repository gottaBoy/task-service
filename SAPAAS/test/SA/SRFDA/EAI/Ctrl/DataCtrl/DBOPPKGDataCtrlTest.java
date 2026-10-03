package SA.SRFDA.EAI.Ctrl.DataCtrl;

import SA.SRFDA.Ctrl.Data.DERINDEX;
import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.IDAModelStorage;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.EAI.Data.DBOPPKG;
import SA.SRFDA.EAI.Data.DBOPProc;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.XML.XMLNode;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Vector;
import junit.framework.TestCase;

public class DBOPPKGDataCtrlTest extends TestCase {
    private static final String MODEL = "<SRFDBOPPKG><SRFDBOPPROCS>"
            + "<SRFDBOPPROC ID=\"one\" PROCESSCONFIG=\"old\"/>"
            + "<SRFDBOPPROC ID=\"two\" PROCESSCONFIG=\"old\"/>"
            + "<SRFDBOPEND ID=\"end\"/>"
            + "</SRFDBOPPROCS></SRFDBOPPKG>";

    public void testCustomPublishDispatchAndUnknownCall() {
        final ArrayList<String> published = new ArrayList<String>();
        DBOPPKGDataCtrl ctrl = new DBOPPKGDataCtrl() {
            @Override
            public CallResult Publish(String id, boolean force) {
                published.add(id + ":" + force);
                return new CallResult();
            }
        };
        DBOPPKG pkg = new DBOPPKG();
        pkg.setEAIDBOPPKGID("pkg");
        assertFalse(ctrl.CustomCall("publish", pkg).IsError());
        assertEquals("pkg:true", published.get(0));
        ctrl.Init(helper("EAI0050", "EAIDBOPPKGID"), null, "", null);
        assertEquals(20, ctrl.CustomCall("OTHER", pkg).getRetCode());
        assertTrue(ctrl.Publish("direct", false).IsOk());
        assertEquals("direct:false", published.get(1));
    }

    public void testPublishReportsFactoryFailure() {
        final IDAModelStorage storage = proxy(IDAModelStorage.class, new InvocationHandler() {
            public Object invoke(Object target, Method method, Object[] args) {
                return defaultValue(method.getReturnType());
            }
        });
        ISRFDAGlobalHelper global = proxy(ISRFDAGlobalHelper.class, new InvocationHandler() {
            public Object invoke(Object target, Method method, Object[] args) {
                if (method.getName().equals("getDAModelStorage")) return storage;
                return defaultValue(method.getReturnType());
            }
        });
        DBOPPKGDataCtrl ctrl = new DBOPPKGDataCtrl();
        ctrl.Init(helper("EAI0050", "EAIDBOPPKGID"), global, "", null);
        CallResult result = ctrl.Publish("missing", false);
        assertTrue(result.IsError());
        assertTrue(result.getErrorInfo().contains("EAI0050"));
    }

    public void testCloneRewritesRepeatedReferencesAndCopiesDetails() throws Exception {
        Fixture fixture = new Fixture();
        String clone = DBOPPKGDataCtrl.ClonePkgProcModel(MODEL, fixture.packageCtrl);
        XMLNode processes = XMLNode.LoadFromXML(clone).GetChildNodeByNodeName("SRFDBOPPROCS");
        assertEquals("new", processes.getChildNodes().get(0).GetExtValue("PROCESSCONFIG", ""));
        assertEquals("new", processes.getChildNodes().get(1).GetExtValue("PROCESSCONFIG", ""));
        assertEquals("one", processes.getChildNodes().get(0).getID());
        assertEquals(1, fixture.saves);
        assertEquals(1, fixture.details);
        assertEquals("old", fixture.detailSource);
        assertEquals("new", fixture.detailRecord.GetParamStringValue("ID", ""));
        assertEquals("source-pkg", fixture.savedProcessPkg);
    }

    public void testClonePropagatesFailuresAndDoesNotChangeEmptyModel() throws Exception {
        Fixture fixture = new Fixture();
        assertEquals("", DBOPPKGDataCtrl.ClonePkgProcModel("", fixture.packageCtrl));
        assertEquals("<SRFDBOPPKG/>", DBOPPKGDataCtrl.ClonePkgProcModel("<SRFDBOPPKG/>", fixture.packageCtrl));
        fixture.failSave = true;
        try {
            DBOPPKGDataCtrl.ClonePkgProcModel(MODEL, fixture.packageCtrl);
            fail("Expected save failure");
        } catch (Exception expected) {
            assertTrue(expected.getMessage().contains("copy failed"));
        }
        assertEquals(0, fixture.details);
    }

    public void testCloneFailsWhenProcessControllerIsMissing() throws Exception {
        IDEDataCtrl pkgCtrl = proxy(IDEDataCtrl.class, new InvocationHandler() {
            public Object invoke(Object target, Method method, Object[] args) {
                return defaultValue(method.getReturnType());
            }
        });
        try {
            DBOPPKGDataCtrl.ClonePkgProcModel(MODEL, pkgCtrl);
            fail("Expected missing process controller");
        } catch (Exception expected) {
            assertTrue(expected.getMessage().contains("EAI0060"));
        }
    }

    public void testCopyDetailPersistsClonedModel() {
        final Fixture fixture = new Fixture();
        fixture.resetPackageOnCopy = true;
        DBOPPKGDataCtrl ctrl = new DBOPPKGDataCtrl() {
            @Override
            public IDEDataCtrl GetRelatedDataCtrl(String id) {
                return fixture.related(id);
            }

            @Override
            public CallResult Save(boolean insert, BaseDataEntity value) {
                assertFalse(insert);
                assertEquals("copied", value.GetParamStringValue(DBOPPKG.TAG_EAIDBOPPKGID, ""));
                fixture.savedModel = value.GetParamStringValue(DBOPPKG.TAG_PROCMODEL, "");
                return new CallResult();
            }
        };
        ctrl.Init(helper("EAI0050", "EAIDBOPPKGID"), null, "", null);
        DBOPPKG pkg = new DBOPPKG();
        pkg.setEAIDBOPPKGID("copied");
        pkg.setPROCMODEL(MODEL);
        assertFalse(ctrl.CopyDetail(pkg, "source").IsError());
        assertEquals(fixture.savedModel, pkg.getPROCMODEL());
        assertEquals(1, fixture.saves);
        assertEquals("copied", fixture.savedProcessPkg);
    }

    public void testExportIncludesReferencedProcessAndReturnsFailures() {
        final Fixture fixture = new Fixture();
        DBOPPKGDataCtrl ctrl = new DBOPPKGDataCtrl() {
            @Override
            public IDEDataCtrl GetRelatedDataCtrl(String id) {
                return fixture.related(id);
            }
        };
        ctrl.Init(helper("EAI0050", "EAIDBOPPKGID"), null, "", null);
        DBOPPKG pkg = new DBOPPKG();
        pkg.setEAIDBOPPKGID("pkg");
        pkg.setPROCMODEL(MODEL);
        Vector<XMLNode> exported = new Vector<XMLNode>();
        assertFalse(ctrl.OnExport(pkg, exported, false).IsError());
        assertEquals(3, exported.size());
        assertEquals(2, fixture.exports);
        fixture.failExport = true;
        assertTrue(ctrl.OnExport(pkg, new Vector<XMLNode>(), true).IsError());
    }

    private static IDEHelper helper(final String id, final String key) {
        final IDEFHelper keyField = proxy(IDEFHelper.class, new InvocationHandler() {
            public Object invoke(Object target, Method method, Object[] args) {
                if (method.getName().equals("getName")) {
                    return key;
                }
                return defaultValue(method.getReturnType());
            }
        });
        return proxy(IDEHelper.class, new InvocationHandler() {
            public Object invoke(Object target, Method method, Object[] args) {
                String name = method.getName();
                if (name.equals("getId")) return id;
                if (name.equals("GetKeyDEFHelper") || name.equals("GetMajorDEFHelper")) return keyField;
                if (name.equals("GetDER1Ns")) return new Vector<Object>();
                if (name.equals("GetDEDC")) return new Vector<Object>();
                if (name.equals("GetProperty")) return args.length > 1 ? args[1] : null;
                if (name.equals("GetDBType")) return "";
                return defaultValue(method.getReturnType());
            }
        });
    }

    private static <T> T proxy(Class<T> type, InvocationHandler handler) {
        return type.cast(Proxy.newProxyInstance(type.getClassLoader(), new Class<?>[] {type}, handler));
    }

    private static Object defaultValue(Class<?> type) {
        if (type == boolean.class) return false;
        if (type == int.class) return 0;
        if (type == long.class) return 0L;
        return null;
    }

    private static final class Fixture {
        private final IDEDataCtrl packageCtrl;
        private final IDEDataCtrl processCtrl;
        private final IDEDataCtrl realCtrl;
        private String savedModel;
        private String savedProcessPkg;
        private Object detailSource;
        private BaseDataEntity detailRecord;
        private int saves;
        private int details;
        private int exports;
        private boolean failSave;
        private boolean failExport;
        private boolean resetPackageOnCopy;

        private Fixture() {
            DERINDEX index = new DERINDEX();
            index.SetParamValue("TYPEVALUE", "TYPE");
            index.SetParamValue("DEID", "REAL");
            final Vector<DERINDEX> indexes = new Vector<DERINDEX>();
            indexes.add(index);
            final IDEHelper processHelper = proxy(IDEHelper.class, new InvocationHandler() {
                public Object invoke(Object target, Method method, Object[] args) {
                    if (method.getName().equals("GetDERINDEXs")) return indexes;
                    return defaultValue(method.getReturnType());
                }
            });
            processCtrl = proxy(IDEDataCtrl.class, new InvocationHandler() {
                public Object invoke(Object target, Method method, Object[] args) {
                    if (method.getName().equals("GetDEHelper")) return processHelper;
                    if (method.getName().equals("Get")) {
                        ((DBOPProc) args[0]).setEAIDBOPPROCTYPE("TYPE");
                        return new CallResult();
                    }
                    return defaultValue(method.getReturnType());
                }
            });
            realCtrl = proxy(IDEDataCtrl.class, new InvocationHandler() {
                public Object invoke(Object target, Method method, Object[] args) {
                    String name = method.getName();
                    if (name.equals("GetDEHelper")) return helper("REAL", "ID");
                    if (name.equals("Get")) {
                        ((BaseDataEntity) args[0]).SetParamValue("NAME", "original");
                        ((BaseDataEntity) args[0]).SetParamValue(DBOPProc.TAG_EAIDBOPPKGID, "source-pkg");
                        return new CallResult();
                    }
                    if (name.equals("RemoveUncopyValue")) {
                        ((BaseDataEntity) args[0]).SetParamValue("ID", null);
                        if (resetPackageOnCopy) {
                            ((BaseDataEntity) args[0]).RemoveParam(DBOPProc.TAG_EAIDBOPPKGID);
                        }
                        return null;
                    }
                    if (name.equals("Save")) {
                        saves++;
                        if (failSave) return error("copy failed");
                        savedProcessPkg = ((BaseDataEntity) args[1]).GetParamStringValue(DBOPProc.TAG_EAIDBOPPKGID, "");
                        ((BaseDataEntity) args[1]).SetParamValue("ID", "new");
                        return new CallResult();
                    }
                    if (name.equals("CopyDetail")) {
                        details++;
                        detailRecord = (BaseDataEntity) args[0];
                        detailSource = args[1];
                        return new CallResult();
                    }
                    if (name.equals("Export")) {
                        exports++;
                        if (failExport) return error("export failed");
                        ((Vector<XMLNode>) args[1]).add(new XMLNode());
                        return new CallResult();
                    }
                    return defaultValue(method.getReturnType());
                }
            });
            packageCtrl = proxy(IDEDataCtrl.class, new InvocationHandler() {
                public Object invoke(Object target, Method method, Object[] args) {
                    if (method.getName().equals("GetRelatedDataCtrl")) return related((String) args[0]);
                    return defaultValue(method.getReturnType());
                }
            });
        }

        private IDEDataCtrl related(String id) {
            return "EAI0060".equals(id) ? processCtrl : "REAL".equals(id) ? realCtrl : null;
        }
    }

    private static CallResult error(String message) {
        CallResult result = new CallResult();
        result.setRetCode(1);
        result.setErrorInfo(message);
        return result;
    }
}
