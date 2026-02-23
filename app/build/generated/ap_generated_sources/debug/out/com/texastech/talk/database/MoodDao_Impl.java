package com.texastech.talk.database;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class MoodDao_Impl implements MoodDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Mood> __insertionAdapterOfMood;

  private final EntityDeletionOrUpdateAdapter<Mood> __deletionAdapterOfMood;

  public MoodDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfMood = new EntityInsertionAdapter<Mood>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `Mood` (`mid`,`date`,`value`,`severity_level`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement, final Mood entity) {
        statement.bindLong(1, entity.mid);
        if (entity.date == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.date);
        }
        statement.bindLong(3, entity.value);
        statement.bindLong(4, entity.severityLevel);
      }
    };
    this.__deletionAdapterOfMood = new EntityDeletionOrUpdateAdapter<Mood>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `Mood` WHERE `mid` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement, final Mood entity) {
        statement.bindLong(1, entity.mid);
      }
    };
  }

  @Override
  public void insert(final Mood mood) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfMood.insert(mood);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertAll(final Mood... moods) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfMood.insert(moods);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final Mood mood) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfMood.handle(mood);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Mood> getAll() {
    final String _sql = "SELECT * FROM Mood";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfMid = CursorUtil.getColumnIndexOrThrow(_cursor, "mid");
      final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
      final int _cursorIndexOfValue = CursorUtil.getColumnIndexOrThrow(_cursor, "value");
      final int _cursorIndexOfSeverityLevel = CursorUtil.getColumnIndexOrThrow(_cursor, "severity_level");
      final List<Mood> _result = new ArrayList<Mood>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final Mood _item;
        final String _tmpDate;
        if (_cursor.isNull(_cursorIndexOfDate)) {
          _tmpDate = null;
        } else {
          _tmpDate = _cursor.getString(_cursorIndexOfDate);
        }
        final int _tmpValue;
        _tmpValue = _cursor.getInt(_cursorIndexOfValue);
        final int _tmpSeverityLevel;
        _tmpSeverityLevel = _cursor.getInt(_cursorIndexOfSeverityLevel);
        _item = new Mood(_tmpDate,_tmpValue,_tmpSeverityLevel);
        _item.mid = _cursor.getInt(_cursorIndexOfMid);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Mood getMoodByDate(final String dateStr) {
    final String _sql = "SELECT * FROM Mood WHERE date = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (dateStr == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, dateStr);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfMid = CursorUtil.getColumnIndexOrThrow(_cursor, "mid");
      final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
      final int _cursorIndexOfValue = CursorUtil.getColumnIndexOrThrow(_cursor, "value");
      final int _cursorIndexOfSeverityLevel = CursorUtil.getColumnIndexOrThrow(_cursor, "severity_level");
      final Mood _result;
      if (_cursor.moveToFirst()) {
        final String _tmpDate;
        if (_cursor.isNull(_cursorIndexOfDate)) {
          _tmpDate = null;
        } else {
          _tmpDate = _cursor.getString(_cursorIndexOfDate);
        }
        final int _tmpValue;
        _tmpValue = _cursor.getInt(_cursorIndexOfValue);
        final int _tmpSeverityLevel;
        _tmpSeverityLevel = _cursor.getInt(_cursorIndexOfSeverityLevel);
        _result = new Mood(_tmpDate,_tmpValue,_tmpSeverityLevel);
        _result.mid = _cursor.getInt(_cursorIndexOfMid);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
