package greeng00se.effectivejava.chapter03.item18;

import java.util.Collection;
import java.util.HashSet;

public class CountHashSet<E> extends HashSet<E> {

    // 추가된 원소의 수
    private int addCount = 0;

    public CountHashSet() {
    }

    public CountHashSet(int initCap, float loadFactor) {
        super(initCap, loadFactor);
    }

    @Override
    public boolean add(E e) {
        addCount++;
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        addCount += c.size();
        return super.addAll(c);
    }

    public int getAddCount() {
        return addCount;
    }
}
