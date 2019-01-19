package com.trychen.bytedatastream;

import java.io.IOException;
import java.util.Date;
import java.util.UUID;

@lombok.Data
public class SimpleData implements ByteSteamSerializable, ByteSteamDeserializable {
    private final int i;
    private final long l;
    private final double d;
    private final float f;
    private final short s;
    private final byte b;
    private final boolean bool;
    private final byte[] bytes;
    private final String message;
    private final Date date;
    private final Type type;
    private final UUID uuid;

    public enum Type {
        HELLO,
        WORLD;
    }

    @Override
    public void serialize(DataOutput out) throws IOException {
        out.write(i, l, d, f, s, b, bool, bytes, message, date, type, uuid);
    }

    public static SimpleData deserialize(DataInput in) throws IOException {
        return new SimpleData(in.readInt(), in.readLong(), in.readDouble(), in.readFloat(), in.readShort(), in.readByte(), in.readBoolean(), in.readBytes(), in.readUTF(), in.readDate(), in.readEnum(Type.class), in.readUUID());
    }
}