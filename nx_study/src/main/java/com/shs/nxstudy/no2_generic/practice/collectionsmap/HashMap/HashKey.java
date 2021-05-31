package com.shs.nxstudy.no2_generic.practice.collectionsmap.HashMap;

import java.util.regex.Pattern;


public class HashKey {

    private static final String REG = "[0-9]+";

    private String key;

    public HashKey(String key) {
        this.key = key;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        HashKey mapHashKey = (HashKey) o;

        return !(key != null ? !key.equals(mapHashKey.key) : mapHashKey.key != null);

    }

    @Override
    public int hashCode() {
        if (key == null) {
            return 0;
        }
        Pattern pattern = Pattern.compile(REG);
        //此处是模拟hash碰撞 确保让桶中bin的长度大于8 演示树结构的关键
        if (pattern.matcher(key).matches()) {
            //哈希碰撞后的链表上达到8个节点时要将链表重构为红黑树
            return 1;
//            return super.hashCode();
        } else {
            return 2;
        }
    }

    @Override
    public String toString() {
        return key;
    }
}