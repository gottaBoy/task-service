/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.hibernate.Cache
 *  org.hibernate.HibernateException
 *  org.hibernate.Session
 *  org.hibernate.SessionBuilder
 *  org.hibernate.SessionFactory
 *  org.hibernate.SessionFactory$SessionFactoryOptions
 *  org.hibernate.StatelessSession
 *  org.hibernate.StatelessSessionBuilder
 *  org.hibernate.TypeHelper
 *  org.hibernate.engine.spi.FilterDefinition
 *  org.hibernate.metadata.ClassMetadata
 *  org.hibernate.metadata.CollectionMetadata
 *  org.hibernate.stat.Statistics
 */
package net.ibizsys.pscore.srv.util.modelinst;

import java.io.Serializable;
import java.sql.Connection;
import java.util.Map;
import java.util.Set;
import javax.naming.NamingException;
import javax.naming.Reference;
import net.ibizsys.pscore.srv.paasmgr.entity.PSDBServer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSysModelInst;
import net.ibizsys.pscore.srv.util.modelinst.IPSDBServerSessionFactory;
import org.hibernate.Cache;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionBuilder;
import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;
import org.hibernate.StatelessSessionBuilder;
import org.hibernate.TypeHelper;
import org.hibernate.engine.spi.FilterDefinition;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.metadata.CollectionMetadata;
import org.hibernate.stat.Statistics;

public class PSDBServerSessionFactoryImpl
implements IPSDBServerSessionFactory {
    private ThreadLocal<PSSysModelInst> psSysModelInst = new ThreadLocal();
    private SessionFactory sessionFactory = null;
    private PSDBServer psDBServer = null;

    public PSDBServerSessionFactoryImpl(PSDBServer pSDBServer, SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        this.psDBServer = pSDBServer;
    }

    public void setPSSysModelInst(PSSysModelInst pSSysModelInst) {
        this.psSysModelInst.set(pSSysModelInst);
    }

    @Override
    public String getRealDBName() {
        PSSysModelInst pSSysModelInst = this.psSysModelInst.get();
        if (pSSysModelInst == null) {
            return null;
        }
        return pSSysModelInst.getDBName();
    }

    @Override
    public SessionFactory getRealSessionFactory() {
        return this.sessionFactory;
    }

    public void close() throws HibernateException {
        this.getRealSessionFactory().close();
    }

    public boolean containsFetchProfileDefinition(String string) {
        return this.getRealSessionFactory().containsFetchProfileDefinition(string);
    }

    public void evict(Class clazz) throws HibernateException {
        this.getRealSessionFactory().evict(clazz);
    }

    public void evict(Class clazz, Serializable serializable) throws HibernateException {
        this.getRealSessionFactory().evict(clazz, serializable);
    }

    public void evictCollection(String string) throws HibernateException {
        this.getRealSessionFactory().evictCollection(string);
    }

    public void evictCollection(String string, Serializable serializable) throws HibernateException {
        this.getRealSessionFactory().evictCollection(string, serializable);
    }

    public void evictEntity(String string) throws HibernateException {
        this.getRealSessionFactory().evictEntity(string);
    }

    public void evictEntity(String string, Serializable serializable) throws HibernateException {
        this.getRealSessionFactory().evictEntity(string, serializable);
    }

    public void evictQueries() throws HibernateException {
        this.getRealSessionFactory().evictQueries();
    }

    public void evictQueries(String string) throws HibernateException {
        this.getRealSessionFactory().evictQueries(string);
    }

    public Map<String, ClassMetadata> getAllClassMetadata() {
        return this.getRealSessionFactory().getAllClassMetadata();
    }

    public Map getAllCollectionMetadata() {
        return this.getRealSessionFactory().getAllCollectionMetadata();
    }

    public Cache getCache() {
        return this.getRealSessionFactory().getCache();
    }

    public ClassMetadata getClassMetadata(Class clazz) {
        return this.getRealSessionFactory().getClassMetadata(clazz);
    }

    public ClassMetadata getClassMetadata(String string) {
        return this.getRealSessionFactory().getClassMetadata(string);
    }

    public CollectionMetadata getCollectionMetadata(String string) {
        return this.getRealSessionFactory().getCollectionMetadata(string);
    }

    public Session getCurrentSession() throws HibernateException {
        return this.getRealSessionFactory().getCurrentSession();
    }

    public Set getDefinedFilterNames() {
        return this.getRealSessionFactory().getDefinedFilterNames();
    }

    public FilterDefinition getFilterDefinition(String string) throws HibernateException {
        return this.getRealSessionFactory().getFilterDefinition(string);
    }

    public SessionFactory.SessionFactoryOptions getSessionFactoryOptions() {
        return this.getRealSessionFactory().getSessionFactoryOptions();
    }

    public Statistics getStatistics() {
        return this.getRealSessionFactory().getStatistics();
    }

    public TypeHelper getTypeHelper() {
        return this.getRealSessionFactory().getTypeHelper();
    }

    public boolean isClosed() {
        return this.getRealSessionFactory().isClosed();
    }

    public Session openSession() throws HibernateException {
        return this.getRealSessionFactory().openSession();
    }

    public StatelessSession openStatelessSession() {
        return this.getRealSessionFactory().openStatelessSession();
    }

    public StatelessSession openStatelessSession(Connection connection) {
        return this.getRealSessionFactory().openStatelessSession(connection);
    }

    public SessionBuilder withOptions() {
        return this.getRealSessionFactory().withOptions();
    }

    public StatelessSessionBuilder withStatelessOptions() {
        return this.getRealSessionFactory().withStatelessOptions();
    }

    public Reference getReference() throws NamingException {
        return this.getRealSessionFactory().getReference();
    }
}

