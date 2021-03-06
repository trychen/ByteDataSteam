package com.trychen.bytedatastream;

import org.junit.Assert;
import org.junit.Test;

public class ArrayTest {
    @Test
    public void test() throws Exception {
        String[] objects = {"Hello", "Why", "Array"};
        byte[] serialize = ByteSerialization.serialize((Object) objects);

        Object deserialize = ByteSerialization.deserialize(serialize, objects.getClass());
        Assert.assertArrayEquals(objects, (String[]) deserialize);
    }
}
