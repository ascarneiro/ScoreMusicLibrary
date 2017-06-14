package br.metodista.dao;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Date;
import java.sql.NClob;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

public class ResultSetDAO implements ResultSet {

    private ResultSet rs;
    private List<String> columnsIndex = null;

    public ResultSetDAO(ResultSet rs) {
        this.rs = rs;
    }

    public Object getObject(String columnName) throws SQLException {
        ResultSetMetaData metaData = getMetaData();
        if (this.columnsIndex == null) {
            this.columnsIndex = new ArrayList();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                this.columnsIndex.add(metaData.getColumnName(i).toUpperCase());
            }
        }
        return getObject(this.columnsIndex.indexOf(columnName.toUpperCase()) + 1);
    }

    public Object getObject(int columnIndex) throws SQLException {
        ResultSetMetaData metaData = getMetaData();
        if ((metaData.getColumnType(columnIndex) == 93) || (metaData.getColumnType(columnIndex) == 91)) {
            return this.rs.getTimestamp(columnIndex);
        }
        return this.rs.getObject(columnIndex);
    }

    public boolean wasNull() throws SQLException {
        return this.rs.wasNull();
    }

    public void updateTimestamp(String columnName, Timestamp x) throws SQLException {
        this.rs.updateTimestamp(columnName, x);
    }

    public void updateTimestamp(int columnIndex, Timestamp x) throws SQLException {
        this.rs.updateTimestamp(columnIndex, x);
    }

    public void updateTime(String columnName, Time x) throws SQLException {
        this.rs.updateTime(columnName, x);
    }

    public void updateTime(int columnIndex, Time x) throws SQLException {
        this.rs.updateTime(columnIndex, x);
    }

    public void updateString(String columnName, String x) throws SQLException {
        this.rs.updateString(columnName, x);
    }

    public void updateString(int columnIndex, String x) throws SQLException {
        this.rs.updateString(columnIndex, x);
    }

    public void updateShort(String columnName, short x) throws SQLException {
        this.rs.updateShort(columnName, x);
    }

    public void updateShort(int columnIndex, short x) throws SQLException {
        this.rs.updateShort(columnIndex, x);
    }

    public void updateRow() throws SQLException {
        this.rs.updateRow();
    }

    public void updateRef(String columnName, Ref x) throws SQLException {
        this.rs.updateRef(columnName, x);
    }

    public void updateRef(int columnIndex, Ref x) throws SQLException {
        this.rs.updateRef(columnIndex, x);
    }

    public void updateObject(String columnName, Object x) throws SQLException {
        this.rs.updateObject(columnName, x);
    }

    public void updateObject(String columnName, Object x, int scale) throws SQLException {
        this.rs.updateObject(columnName, x, scale);
    }

    public void updateObject(int columnIndex, Object x) throws SQLException {
        this.rs.updateObject(columnIndex, x);
    }

    public void updateObject(int columnIndex, Object x, int scale) throws SQLException {
        this.rs.updateObject(columnIndex, x, scale);
    }

    public void updateNull(String columnName) throws SQLException {
        this.rs.updateNull(columnName);
    }

    public void updateNull(int columnIndex) throws SQLException {
        this.rs.updateNull(columnIndex);
    }

    public void updateLong(String columnName, long x) throws SQLException {
        this.rs.updateLong(columnName, x);
    }

    public void updateLong(int columnIndex, long x) throws SQLException {
        this.rs.updateLong(columnIndex, x);
    }

    public void updateInt(String columnName, int x) throws SQLException {
        this.rs.updateInt(columnName, x);
    }

    public void updateInt(int columnIndex, int x) throws SQLException {
        this.rs.updateInt(columnIndex, x);
    }

    public void updateFloat(String columnName, float x) throws SQLException {
        this.rs.updateFloat(columnName, x);
    }

    public void updateFloat(int columnIndex, float x) throws SQLException {
        this.rs.updateFloat(columnIndex, x);
    }

    public void updateDouble(String columnName, double x) throws SQLException {
        this.rs.updateDouble(columnName, x);
    }

    public void updateDouble(int columnIndex, double x) throws SQLException {
        this.rs.updateDouble(columnIndex, x);
    }

    public void updateDate(String columnName, Date x) throws SQLException {
        this.rs.updateDate(columnName, x);
    }

    public void updateDate(int columnIndex, Date x) throws SQLException {
        this.rs.updateDate(columnIndex, x);
    }

    public void updateClob(String columnName, Clob x) throws SQLException {
        this.rs.updateClob(columnName, x);
    }

    public void updateClob(int columnIndex, Clob x) throws SQLException {
        this.rs.updateClob(columnIndex, x);
    }

    public void updateCharacterStream(String columnName, Reader reader, int length) throws SQLException {
        this.rs.updateCharacterStream(columnName, reader, length);
    }

    public void updateCharacterStream(int columnIndex, Reader x, int length) throws SQLException {
        this.rs.updateCharacterStream(columnIndex, x, length);
    }

    public void updateBytes(String columnName, byte[] x) throws SQLException {
        this.rs.updateBytes(columnName, x);
    }

    public void updateBytes(int columnIndex, byte[] x) throws SQLException {
        this.rs.updateBytes(columnIndex, x);
    }

    public void updateByte(String columnName, byte x) throws SQLException {
        this.rs.updateByte(columnName, x);
    }

    public void updateByte(int columnIndex, byte x) throws SQLException {
        this.rs.updateByte(columnIndex, x);
    }

    public void updateBoolean(String columnName, boolean x) throws SQLException {
        this.rs.updateBoolean(columnName, x);
    }

    public void updateBoolean(int columnIndex, boolean x) throws SQLException {
        this.rs.updateBoolean(columnIndex, x);
    }

    public void updateBlob(String columnName, Blob x) throws SQLException {
        this.rs.updateBlob(columnName, x);
    }

    public void updateBlob(int columnIndex, Blob x) throws SQLException {
        this.rs.updateBlob(columnIndex, x);
    }

    public void updateBinaryStream(String columnName, InputStream x, int length) throws SQLException {
        this.rs.updateBinaryStream(columnName, x, length);
    }

    public void updateBinaryStream(int columnIndex, InputStream x, int length) throws SQLException {
        this.rs.updateBinaryStream(columnIndex, x, length);
    }

    public void updateBigDecimal(String columnName, BigDecimal x) throws SQLException {
        this.rs.updateBigDecimal(columnName, x);
    }

    public void updateBigDecimal(int columnIndex, BigDecimal x) throws SQLException {
        this.rs.updateBigDecimal(columnIndex, x);
    }

    public void updateAsciiStream(String columnName, InputStream x, int length) throws SQLException {
        this.rs.updateAsciiStream(columnName, x, length);
    }

    public void updateAsciiStream(int columnIndex, InputStream x, int length) throws SQLException {
        this.rs.updateAsciiStream(columnIndex, x, length);
    }

    public void updateArray(String columnName, Array x) throws SQLException {
        this.rs.updateArray(columnName, x);
    }

    public void updateArray(int columnIndex, Array x) throws SQLException {
        this.rs.updateArray(columnIndex, x);
    }

    public void setFetchSize(int rows) throws SQLException {
        this.rs.setFetchSize(rows);
    }

    public void setFetchDirection(int direction) throws SQLException {
        this.rs.setFetchDirection(direction);
    }

    public boolean rowUpdated() throws SQLException {
        return this.rs.rowUpdated();
    }

    public boolean rowInserted() throws SQLException {
        return this.rs.rowInserted();
    }

    public boolean rowDeleted() throws SQLException {
        return this.rs.rowDeleted();
    }

    public boolean relative(int rows) throws SQLException {
        return this.rs.relative(rows);
    }

    public void refreshRow() throws SQLException {
        this.rs.refreshRow();
    }

    public boolean previous() throws SQLException {
        return this.rs.previous();
    }

    public boolean next() throws SQLException {
        return this.rs.next();
    }

    public void moveToInsertRow() throws SQLException {
        this.rs.moveToInsertRow();
    }

    public void moveToCurrentRow() throws SQLException {
        this.rs.moveToCurrentRow();
    }

    public boolean last() throws SQLException {
        return this.rs.last();
    }

    public boolean isLast() throws SQLException {
        return this.rs.isLast();
    }

    public boolean isFirst() throws SQLException {
        return this.rs.isFirst();
    }

    public boolean isBeforeFirst() throws SQLException {
        return this.rs.isBeforeFirst();
    }

    public boolean isAfterLast() throws SQLException {
        return this.rs.isAfterLast();
    }

    public void insertRow() throws SQLException {
        this.rs.insertRow();
    }

    public SQLWarning getWarnings() throws SQLException {
        return this.rs.getWarnings();
    }

    public InputStream getUnicodeStream(String columnName) throws SQLException {
        return this.rs.getUnicodeStream(columnName);
    }

    public InputStream getUnicodeStream(int columnIndex) throws SQLException {
        return this.rs.getUnicodeStream(columnIndex);
    }

    public URL getURL(String columnName) throws SQLException {
        return this.rs.getURL(columnName);
    }

    public URL getURL(int columnIndex) throws SQLException {
        return this.rs.getURL(columnIndex);
    }

    public int getType() throws SQLException {
        return this.rs.getType();
    }

    public Timestamp getTimestamp(String columnName, Calendar cal) throws SQLException {
        return this.rs.getTimestamp(columnName, cal);
    }

    public Timestamp getTimestamp(int columnIndex, Calendar cal) throws SQLException {
        return this.rs.getTimestamp(columnIndex, cal);
    }

    public Timestamp getTimestamp(String columnName) throws SQLException {
        return this.rs.getTimestamp(columnName);
    }

    public Timestamp getTimestamp(int columnIndex) throws SQLException {
        return this.rs.getTimestamp(columnIndex);
    }

    public Time getTime(String columnName, Calendar cal) throws SQLException {
        return this.rs.getTime(columnName, cal);
    }

    public Time getTime(int columnIndex, Calendar cal) throws SQLException {
        return this.rs.getTime(columnIndex, cal);
    }

    public Time getTime(String columnName) throws SQLException {
        return this.rs.getTime(columnName);
    }

    public Time getTime(int columnIndex) throws SQLException {
        return this.rs.getTime(columnIndex);
    }

    public String getString(String columnName) throws SQLException {
        return this.rs.getString(columnName);
    }

    public String getString(int columnIndex) throws SQLException {
        return this.rs.getString(columnIndex);
    }

    public Statement getStatement() throws SQLException {
        return this.rs.getStatement();
    }

    public short getShort(String columnName) throws SQLException {
        return this.rs.getShort(columnName);
    }

    public short getShort(int columnIndex) throws SQLException {
        return this.rs.getShort(columnIndex);
    }

    public int getRow() throws SQLException {
        return this.rs.getRow();
    }

    public Ref getRef(String colName) throws SQLException {
        return this.rs.getRef(colName);
    }

    public Ref getRef(int i) throws SQLException {
        return this.rs.getRef(i);
    }

    public Object getObject(String colName, Map<String, Class<?>> map) throws SQLException {
        return this.rs.getObject(colName, map);
    }

    public Object getObject(int i, Map<String, Class<?>> map) throws SQLException {
        return this.rs.getObject(i, map);
    }

    public ResultSetMetaData getMetaData() throws SQLException {
        return this.rs.getMetaData();
    }

    public long getLong(String columnName) throws SQLException {
        return this.rs.getLong(columnName);
    }

    public long getLong(int columnIndex) throws SQLException {
        return this.rs.getLong(columnIndex);
    }

    public int getInt(String columnName) throws SQLException {
        return this.rs.getInt(columnName);
    }

    public int getInt(int columnIndex) throws SQLException {
        return this.rs.getInt(columnIndex);
    }

    public float getFloat(String columnName) throws SQLException {
        return this.rs.getFloat(columnName);
    }

    public float getFloat(int columnIndex) throws SQLException {
        return this.rs.getFloat(columnIndex);
    }

    public int getFetchSize() throws SQLException {
        return this.rs.getFetchSize();
    }

    public int getFetchDirection() throws SQLException {
        return this.rs.getFetchDirection();
    }

    public double getDouble(String columnName) throws SQLException {
        return this.rs.getDouble(columnName);
    }

    public double getDouble(int columnIndex) throws SQLException {
        return this.rs.getDouble(columnIndex);
    }

    public Date getDate(String columnName, Calendar cal) throws SQLException {
        return this.rs.getDate(columnName, cal);
    }

    public Date getDate(int columnIndex, Calendar cal) throws SQLException {
        return this.rs.getDate(columnIndex, cal);
    }

    public Date getDate(String columnName) throws SQLException {
        return this.rs.getDate(columnName);
    }

    public Date getDate(int columnIndex) throws SQLException {
        return this.rs.getDate(columnIndex);
    }

    public String getCursorName() throws SQLException {
        return this.rs.getCursorName();
    }

    public int getConcurrency() throws SQLException {
        return this.rs.getConcurrency();
    }

    public Clob getClob(String colName) throws SQLException {
        return this.rs.getClob(colName);
    }

    public Clob getClob(int i) throws SQLException {
        return this.rs.getClob(i);
    }

    public Reader getCharacterStream(String columnName) throws SQLException {
        return this.rs.getCharacterStream(columnName);
    }

    public Reader getCharacterStream(int columnIndex) throws SQLException {
        return this.rs.getCharacterStream(columnIndex);
    }

    public byte[] getBytes(String columnName) throws SQLException {
        return this.rs.getBytes(columnName);
    }

    public byte[] getBytes(int columnIndex) throws SQLException {
        return this.rs.getBytes(columnIndex);
    }

    public byte getByte(String columnName) throws SQLException {
        return this.rs.getByte(columnName);
    }

    public byte getByte(int columnIndex) throws SQLException {
        return this.rs.getByte(columnIndex);
    }

    public boolean getBoolean(String columnName) throws SQLException {
        return this.rs.getBoolean(columnName);
    }

    public boolean getBoolean(int columnIndex) throws SQLException {
        return this.rs.getBoolean(columnIndex);
    }

    public Blob getBlob(String colName) throws SQLException {
        return this.rs.getBlob(colName);
    }

    public Blob getBlob(int i) throws SQLException {
        return this.rs.getBlob(i);
    }

    public InputStream getBinaryStream(String columnName) throws SQLException {
        return this.rs.getBinaryStream(columnName);
    }

    public InputStream getBinaryStream(int columnIndex) throws SQLException {
        return this.rs.getBinaryStream(columnIndex);
    }

    public BigDecimal getBigDecimal(String columnName) throws SQLException {
        return this.rs.getBigDecimal(columnName);
    }

    public BigDecimal getBigDecimal(int columnIndex) throws SQLException {
        return this.rs.getBigDecimal(columnIndex);
    }

    public BigDecimal getBigDecimal(String columnName, int scale) throws SQLException {
        return this.rs.getBigDecimal(columnName, scale);
    }

    public BigDecimal getBigDecimal(int columnIndex, int scale) throws SQLException {
        return this.rs.getBigDecimal(columnIndex, scale);
    }

    public InputStream getAsciiStream(String columnName) throws SQLException {
        return this.rs.getAsciiStream(columnName);
    }

    public InputStream getAsciiStream(int columnIndex) throws SQLException {
        return this.rs.getAsciiStream(columnIndex);
    }

    public Array getArray(String colName) throws SQLException {
        return this.rs.getArray(colName);
    }

    public Array getArray(int i) throws SQLException {
        return this.rs.getArray(i);
    }

    public boolean first() throws SQLException {
        return this.rs.first();
    }

    public int findColumn(String columnName) throws SQLException {
        return this.rs.findColumn(columnName);
    }

    public void deleteRow() throws SQLException {
        this.rs.deleteRow();
    }

    public void close() throws SQLException {
        this.rs.close();
    }

    public void clearWarnings() throws SQLException {
        this.rs.clearWarnings();
    }

    public void cancelRowUpdates() throws SQLException {
        this.rs.cancelRowUpdates();
    }

    public void beforeFirst() throws SQLException {
        this.rs.beforeFirst();
    }

    public void afterLast() throws SQLException {
        this.rs.afterLast();
    }

    public boolean absolute(int row) throws SQLException {
        return this.rs.absolute(row);
    }

    public <T> T unwrap(Class<T> iface) throws SQLException {
        return this.rs.unwrap(iface);
    }

    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return this.rs.isWrapperFor(iface);
    }

    public void updateSQLXML(String columnLabel, SQLXML xmlObject) throws SQLException {
        this.rs.updateSQLXML(columnLabel, xmlObject);
    }

    public void updateSQLXML(int columnIndex, SQLXML xmlObject) throws SQLException {
        this.rs.updateSQLXML(columnIndex, xmlObject);
    }

    public void updateRowId(String columnLabel, RowId x) throws SQLException {
        this.rs.updateRowId(columnLabel, x);
    }

    public void updateRowId(int columnIndex, RowId x) throws SQLException {
        this.rs.updateRowId(columnIndex, x);
    }

    public void updateNString(String columnLabel, String nString) throws SQLException {
        this.rs.updateNString(columnLabel, nString);
    }

    public void updateNString(int columnIndex, String nString) throws SQLException {
        this.rs.updateNString(columnIndex, nString);
    }

    public void updateNClob(String columnLabel, Reader reader) throws SQLException {
        this.rs.updateNClob(columnLabel, reader);
    }

    public void updateNClob(int columnIndex, Reader reader) throws SQLException {
        this.rs.updateNClob(columnIndex, reader);
    }

    public void updateNClob(String columnLabel, Reader reader, long length) throws SQLException {
        this.rs.updateNClob(columnLabel, reader, length);
    }

    public void updateNClob(int columnIndex, Reader reader, long length) throws SQLException {
        this.rs.updateNClob(columnIndex, reader, length);
    }

    public void updateNClob(String columnLabel, NClob nClob) throws SQLException {
        this.rs.updateNClob(columnLabel, nClob);
    }

    public void updateNClob(int columnIndex, NClob nClob) throws SQLException {
        this.rs.updateNClob(columnIndex, nClob);
    }

    public void updateNCharacterStream(String columnLabel, Reader reader) throws SQLException {
        this.rs.updateNCharacterStream(columnLabel, reader);
    }

    public void updateNCharacterStream(int columnIndex, Reader x) throws SQLException {
        this.rs.updateNCharacterStream(columnIndex, x);
    }

    public void updateNCharacterStream(String columnLabel, Reader reader, long length) throws SQLException {
        this.rs.updateNCharacterStream(columnLabel, reader, length);
    }

    public void updateNCharacterStream(int columnIndex, Reader x, long length) throws SQLException {
        this.rs.updateNCharacterStream(columnIndex, x, length);
    }

    public void updateClob(String columnLabel, Reader reader) throws SQLException {
        this.rs.updateClob(columnLabel, reader);
    }

    public void updateClob(int columnIndex, Reader reader) throws SQLException {
        this.rs.updateClob(columnIndex, reader);
    }

    public void updateClob(String columnLabel, Reader reader, long length) throws SQLException {
        this.rs.updateClob(columnLabel, reader, length);
    }

    public void updateClob(int columnIndex, Reader reader, long length) throws SQLException {
        this.rs.updateClob(columnIndex, reader, length);
    }

    public void updateCharacterStream(String columnLabel, Reader reader) throws SQLException {
        this.rs.updateCharacterStream(columnLabel, reader);
    }

    public void updateCharacterStream(int columnIndex, Reader x) throws SQLException {
        this.rs.updateCharacterStream(columnIndex, x);
    }

    public void updateCharacterStream(String columnLabel, Reader reader, long length) throws SQLException {
        this.rs.updateCharacterStream(columnLabel, reader, length);
    }

    public void updateCharacterStream(int columnIndex, Reader x, long length) throws SQLException {
        this.rs.updateCharacterStream(columnIndex, x, length);
    }

    public void updateBlob(String columnLabel, InputStream inputStream) throws SQLException {
        this.rs.updateBlob(columnLabel, inputStream);
    }

    public void updateBlob(int columnIndex, InputStream inputStream) throws SQLException {
        this.rs.updateBlob(columnIndex, inputStream);
    }

    public void updateBlob(String columnLabel, InputStream inputStream, long length) throws SQLException {
        this.rs.updateBlob(columnLabel, inputStream, length);
    }

    public void updateBlob(int columnIndex, InputStream inputStream, long length) throws SQLException {
        this.rs.updateBlob(columnIndex, inputStream, length);
    }

    public void updateBinaryStream(String columnLabel, InputStream x) throws SQLException {
        this.rs.updateBinaryStream(columnLabel, x);
    }

    public void updateBinaryStream(int columnIndex, InputStream x) throws SQLException {
        this.rs.updateBinaryStream(columnIndex, x);
    }

    public void updateBinaryStream(String columnLabel, InputStream x, long length) throws SQLException {
        this.rs.updateBinaryStream(columnLabel, x, length);
    }

    public void updateBinaryStream(int columnIndex, InputStream x, long length) throws SQLException {
        this.rs.updateBinaryStream(columnIndex, x, length);
    }

    public void updateAsciiStream(String columnLabel, InputStream x) throws SQLException {
        this.rs.updateAsciiStream(columnLabel, x);
    }

    public void updateAsciiStream(int columnIndex, InputStream x) throws SQLException {
        this.rs.updateAsciiStream(columnIndex, x);
    }

    public void updateAsciiStream(String columnLabel, InputStream x, long length) throws SQLException {
        this.rs.updateAsciiStream(columnLabel, x, length);
    }

    public void updateAsciiStream(int columnIndex, InputStream x, long length) throws SQLException {
        this.rs.updateAsciiStream(columnIndex, x, length);
    }

    public boolean isClosed() throws SQLException {
        return this.rs.isClosed();
    }

    public SQLXML getSQLXML(String columnLabel) throws SQLException {
        return this.rs.getSQLXML(columnLabel);
    }

    public SQLXML getSQLXML(int columnIndex) throws SQLException {
        return this.rs.getSQLXML(columnIndex);
    }

    public RowId getRowId(String columnLabel) throws SQLException {
        return this.rs.getRowId(columnLabel);
    }

    public RowId getRowId(int columnIndex) throws SQLException {
        return this.rs.getRowId(columnIndex);
    }

    public String getNString(String columnLabel) throws SQLException {
        return this.rs.getNString(columnLabel);
    }

    public String getNString(int columnIndex) throws SQLException {
        return this.rs.getNString(columnIndex);
    }

    public NClob getNClob(String columnLabel) throws SQLException {
        return this.rs.getNClob(columnLabel);
    }

    public NClob getNClob(int columnIndex) throws SQLException {
        return this.rs.getNClob(columnIndex);
    }

    public Reader getNCharacterStream(String columnLabel) throws SQLException {
        return this.rs.getNCharacterStream(columnLabel);
    }

    public Reader getNCharacterStream(int columnIndex) throws SQLException {
        return this.rs.getNCharacterStream(columnIndex);
    }

    public int getHoldability() throws SQLException {
        return this.rs.getHoldability();
    }

    @Override
    public <T> T getObject(int columnIndex, Class<T> type) throws SQLException {
        return this.rs.getObject(null, type);
    }

    @Override
    public <T> T getObject(String columnLabel, Class<T> type) throws SQLException {
        return this.rs.getObject(columnLabel, type);
    }
}