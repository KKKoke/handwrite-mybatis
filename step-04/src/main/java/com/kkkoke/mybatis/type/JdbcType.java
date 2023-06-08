package com.kkkoke.mybatis.type;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

/**
 * @author KeyCheung
 * @date 2023/05/26
 * @desc
 */
public enum JdbcType {

    INSERT(Types.INTEGER),

    FLOAT(Types.FLOAT),

    DOUBLE(Types.DOUBLE),

    DECIMAL(Types.DECIMAL),

    VARCHAR(Types.VARCHAR),

    TIMESTAMP(Types.TIMESTAMP);

    public final int TYPE_CODE;

    private static Map<Integer, JdbcType> codeLookup = new HashMap<>();

    static {
        for (JdbcType type : JdbcType.values()) {
            codeLookup.put(type.TYPE_CODE, type);
        }
    }

    JdbcType(int code) {
        this.TYPE_CODE = code;
    }

    public static JdbcType forCode(int code) {
        return codeLookup.get(code);
    }
}
