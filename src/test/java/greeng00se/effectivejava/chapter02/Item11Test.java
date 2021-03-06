package greeng00se.effectivejava.chapter02;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class Item11Test {

    @Test
    @DisplayName("hashCode를 재정의하지 않을 경우 논리적으로 같은 값을 가지더라도 다른값을 반환한다.")
    void defaultHashCodeTree() {
        // given
        Map<DefaultHashCodeTree, Integer> map = new HashMap<>();
        DefaultHashCodeTree treeA = new DefaultHashCodeTree(150, "은행나무");
        DefaultHashCodeTree treeB = new DefaultHashCodeTree(150, "은행나무");

        // when
        map.put(treeA, 5000);
        Integer value = map.get(treeB);

        // then
        assertThat(value).isNull();
        assertThat(treeA.hashCode()).isNotEqualTo(treeB.hashCode());
    }

    static class DefaultHashCodeTree {
        int age;
        String name;

        public DefaultHashCodeTree(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof DefaultHashCodeTree)) return false;

            DefaultHashCodeTree that = (DefaultHashCodeTree) o;

            if (age != that.age) return false;
            return name != null ? name.equals(that.name) : that.name == null;
        }
    }

    static class Tree extends DefaultHashCodeTree {

        public Tree(int age, String name) {
            super(age, name);
        }

        @Override
        public int hashCode() {
            return 404;
        }
    }
}
