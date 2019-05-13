package com.ming.dao.typeHandler;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * TypeHandler Sex
 * @author ming
 */
public class SexEnumTypeHandler implements TypeHandler<Sex> {
    /**
     * 保存数据库执行该方法
     * @param ps
     * @param i
     * @param parameter
     * @param jdbcType
     * @throws SQLException
     */
    @Override
    public void setParameter(PreparedStatement ps, int i, Sex parameter, JdbcType jdbcType) throws SQLException {
        ps.setInt(i, parameter.getId());
    }

    /**
     * 获取列名称
     * @param rs
     * @param columnName
     * @return
     * @throws SQLException
     */
    @Override
    public Sex getResult(ResultSet rs, String columnName) throws SQLException {
        // 根据列明获取保存的数据库
        int id = rs.getInt(columnName);
        return Sex.getSex(id);
    }

    /**
     * @param rs
     * @param columnIndex
     * @return
     * @throws SQLException
     */
    @Override
    public Sex getResult(ResultSet rs, int columnIndex) throws SQLException {
        int id = rs.getInt(columnIndex);
        return Sex.getSex(id);
    }

    /**
     * 根据获取的字符串,获取id
     * @param cs
     * @param columnIndex
     * @return
     * @throws SQLException
     */
    @Override
    public Sex getResult(CallableStatement cs, int columnIndex) throws SQLException {
        int id = cs.getInt(columnIndex);
        return Sex.getSex(id);
    }
}
