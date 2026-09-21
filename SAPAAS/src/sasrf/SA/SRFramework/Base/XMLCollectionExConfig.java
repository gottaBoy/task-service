/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFramework.Base;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class XMLCollectionExConfig<E>
extends XMLConfig
implements List<E> {
    protected ArrayList<E> arr = new ArrayList();
    private static final Log log = LogFactory.getLog(XMLCollectionExConfig.class);

    @Override
    public boolean add(E e) {
        return this.arr.add(e);
    }

    @Override
    public void add(int index, E element) {
        this.arr.add(index, element);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return this.arr.addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return this.arr.addAll(index, c);
    }

    @Override
    public void clear() {
        this.arr.clear();
    }

    @Override
    public boolean contains(Object o) {
        return this.arr.contains(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return this.arr.containsAll(c);
    }

    @Override
    public E get(int index) {
        return this.arr.get(index);
    }

    @Override
    public int indexOf(Object o) {
        return this.arr.indexOf(o);
    }

    @Override
    public boolean isEmpty() {
        return this.arr.isEmpty();
    }

    @Override
    public Iterator<E> iterator() {
        return this.arr.iterator();
    }

    @Override
    public int lastIndexOf(Object o) {
        return this.arr.lastIndexOf(o);
    }

    @Override
    public ListIterator<E> listIterator() {
        return this.arr.listIterator();
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return this.arr.listIterator(index);
    }

    @Override
    public E remove(int index) {
        return this.arr.remove(index);
    }

    @Override
    public boolean remove(Object o) {
        return this.arr.remove(o);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return this.arr.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return this.arr.retainAll(c);
    }

    @Override
    public E set(int index, E element) {
        return this.arr.set(index, element);
    }

    @Override
    public int size() {
        return this.arr.size();
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return this.arr.subList(fromIndex, toIndex);
    }

    @Override
    public Object[] toArray() {
        return this.arr.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return this.arr.toArray(a);
    }

    public E findById(String strId) {
        for (E e : this.arr) {
            XMLConfig item = (XMLConfig)e;
            if (StringHelper.Compare(item.getID(), strId, true) != 0) continue;
            return e;
        }
        return null;
    }

    protected boolean OnChildNodeLoaded(E childNode) {
        return true;
    }

    public static XMLConfig CreateChildNode(String strType) {
        try {
            Object obj = Class.forName(strType).newInstance();
            if (obj != null && obj instanceof XMLConfig) {
                return (XMLConfig)obj;
            }
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format("\u65e0\u6cd5\u5efa\u7acb\u5b50\u8282\u70b9\u5bf9\u8c61[%1$s]", strType), (Throwable)ex);
            return null;
        }
        log.error((Object)StringHelper.Format("\u65e0\u6cd5\u5efa\u7acb\u6216\u5b50\u8282\u70b9\u5bf9\u8c61\u6216\u5b50\u8282\u70b9\u5bf9\u8c61\u7c7b\u578b\u4e0d\u662fXMLConfig[%1$s]", strType));
        return null;
    }

    @Override
    protected void CloneCopy(Object dst) {
        super.CloneCopy(dst);
        XMLCollectionExConfig obj = (XMLCollectionExConfig)dst;
        for (E objItem : this.arr) {
            if (!(objItem instanceof XMLConfig)) continue;
            obj.add(((XMLConfig)objItem).clone());
        }
    }

    @Override
    protected Object CreateCloneObject() {
        return new XMLCollectionExConfig<E>();
    }
}

