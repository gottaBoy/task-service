package net.ibizsys.model.util;

import java.lang.reflect.Field;
import java.util.Map;
import junit.framework.TestCase;

public class ThreadLockCheckerTest extends TestCase {
    public void testCheckDeadLockRemovesIdleLockByKey() throws Exception {
        ThreadLockChecker checker = new ThreadLockChecker();
        Object lock = new Object();
        checker.enterAndLeave(lock, "work");

        Field activeTime = checker.getLockInfo(lock).getClass().getDeclaredField("nActiveTime");
        activeTime.setAccessible(true);
        activeTime.setLong(checker.getLockInfo(lock), System.currentTimeMillis() - 300001L);

        Field infoMap = ThreadLockChecker.class.getDeclaredField("lockInfoMap");
        infoMap.setAccessible(true);
        Map<?, ?> locks = (Map<?, ?>)infoMap.get(checker);
        assertTrue(locks.containsKey(lock));

        assertEquals(0L, checker.checkDeadLock());
        assertFalse(locks.containsKey(lock));
    }
}
