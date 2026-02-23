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
public final class ResourcesDao_Impl implements ResourcesDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Resources> __insertionAdapterOfResources;

  private final EntityDeletionOrUpdateAdapter<Resources> __deletionAdapterOfResources;

  public ResourcesDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfResources = new EntityInsertionAdapter<Resources>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `Resources` (`rid`,`title`,`content`,`hyperlink`,`mood`) VALUES (nullif(?, 0),?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement, final Resources entity) {
        statement.bindLong(1, entity.rid);
        if (entity.title == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.title);
        }
        if (entity.content == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.content);
        }
        if (entity.hyperlink == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.hyperlink);
        }
        statement.bindLong(5, entity.mood);
      }
    };
    this.__deletionAdapterOfResources = new EntityDeletionOrUpdateAdapter<Resources>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `Resources` WHERE `rid` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement, final Resources entity) {
        statement.bindLong(1, entity.rid);
      }
    };
  }

  @Override
  public void insert(final Resources resources) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfResources.insert(resources);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertAll(final Resources... resources) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfResources.insert(resources);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final Resources resource) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfResources.handle(resource);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Resources> getAll() {
    final String _sql = "SELECT * FROM resources";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfRid = CursorUtil.getColumnIndexOrThrow(_cursor, "rid");
      final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
      final int _cursorIndexOfContent = CursorUtil.getColumnIndexOrThrow(_cursor, "content");
      final int _cursorIndexOfHyperlink = CursorUtil.getColumnIndexOrThrow(_cursor, "hyperlink");
      final int _cursorIndexOfMood = CursorUtil.getColumnIndexOrThrow(_cursor, "mood");
      final List<Resources> _result = new ArrayList<Resources>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final Resources _item;
        final String _tmpTitle;
        if (_cursor.isNull(_cursorIndexOfTitle)) {
          _tmpTitle = null;
        } else {
          _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
        }
        final String _tmpContent;
        if (_cursor.isNull(_cursorIndexOfContent)) {
          _tmpContent = null;
        } else {
          _tmpContent = _cursor.getString(_cursorIndexOfContent);
        }
        final String _tmpHyperlink;
        if (_cursor.isNull(_cursorIndexOfHyperlink)) {
          _tmpHyperlink = null;
        } else {
          _tmpHyperlink = _cursor.getString(_cursorIndexOfHyperlink);
        }
        final int _tmpMood;
        _tmpMood = _cursor.getInt(_cursorIndexOfMood);
        _item = new Resources(_tmpTitle,_tmpContent,_tmpHyperlink,_tmpMood);
        _item.rid = _cursor.getInt(_cursorIndexOfRid);
        _result.add(_item);
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
