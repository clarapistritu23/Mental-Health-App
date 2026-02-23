package com.texastech.talk.database;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDatabase_Impl extends AppDatabase {
  private volatile MoodDao _moodDao;

  private volatile ResourcesDao _resourcesDao;

  private volatile JournalDao _journalDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `Mood` (`mid` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `date` TEXT, `value` INTEGER NOT NULL, `severity_level` INTEGER NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `Resources` (`rid` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `title` TEXT, `content` TEXT, `hyperlink` TEXT, `mood` INTEGER NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `Journal` (`jid` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `title` TEXT, `body` TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '4a59a9d573b03ff0000d57c9a28b0992')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `Mood`");
        db.execSQL("DROP TABLE IF EXISTS `Resources`");
        db.execSQL("DROP TABLE IF EXISTS `Journal`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsMood = new HashMap<String, TableInfo.Column>(4);
        _columnsMood.put("mid", new TableInfo.Column("mid", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMood.put("date", new TableInfo.Column("date", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMood.put("value", new TableInfo.Column("value", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMood.put("severity_level", new TableInfo.Column("severity_level", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysMood = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesMood = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoMood = new TableInfo("Mood", _columnsMood, _foreignKeysMood, _indicesMood);
        final TableInfo _existingMood = TableInfo.read(db, "Mood");
        if (!_infoMood.equals(_existingMood)) {
          return new RoomOpenHelper.ValidationResult(false, "Mood(com.texastech.talk.database.Mood).\n"
                  + " Expected:\n" + _infoMood + "\n"
                  + " Found:\n" + _existingMood);
        }
        final HashMap<String, TableInfo.Column> _columnsResources = new HashMap<String, TableInfo.Column>(5);
        _columnsResources.put("rid", new TableInfo.Column("rid", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsResources.put("title", new TableInfo.Column("title", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsResources.put("content", new TableInfo.Column("content", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsResources.put("hyperlink", new TableInfo.Column("hyperlink", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsResources.put("mood", new TableInfo.Column("mood", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysResources = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesResources = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoResources = new TableInfo("Resources", _columnsResources, _foreignKeysResources, _indicesResources);
        final TableInfo _existingResources = TableInfo.read(db, "Resources");
        if (!_infoResources.equals(_existingResources)) {
          return new RoomOpenHelper.ValidationResult(false, "Resources(com.texastech.talk.database.Resources).\n"
                  + " Expected:\n" + _infoResources + "\n"
                  + " Found:\n" + _existingResources);
        }
        final HashMap<String, TableInfo.Column> _columnsJournal = new HashMap<String, TableInfo.Column>(3);
        _columnsJournal.put("jid", new TableInfo.Column("jid", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsJournal.put("title", new TableInfo.Column("title", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsJournal.put("body", new TableInfo.Column("body", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysJournal = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesJournal = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoJournal = new TableInfo("Journal", _columnsJournal, _foreignKeysJournal, _indicesJournal);
        final TableInfo _existingJournal = TableInfo.read(db, "Journal");
        if (!_infoJournal.equals(_existingJournal)) {
          return new RoomOpenHelper.ValidationResult(false, "Journal(com.texastech.talk.database.Journal).\n"
                  + " Expected:\n" + _infoJournal + "\n"
                  + " Found:\n" + _existingJournal);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "4a59a9d573b03ff0000d57c9a28b0992", "9f355126901feee12e373c2e2f6fef22");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "Mood","Resources","Journal");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `Mood`");
      _db.execSQL("DELETE FROM `Resources`");
      _db.execSQL("DELETE FROM `Journal`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(MoodDao.class, MoodDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(ResourcesDao.class, ResourcesDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(JournalDao.class, JournalDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public MoodDao moodDao() {
    if (_moodDao != null) {
      return _moodDao;
    } else {
      synchronized(this) {
        if(_moodDao == null) {
          _moodDao = new MoodDao_Impl(this);
        }
        return _moodDao;
      }
    }
  }

  @Override
  public ResourcesDao resourcesDao() {
    if (_resourcesDao != null) {
      return _resourcesDao;
    } else {
      synchronized(this) {
        if(_resourcesDao == null) {
          _resourcesDao = new ResourcesDao_Impl(this);
        }
        return _resourcesDao;
      }
    }
  }

  @Override
  public JournalDao journalDao() {
    if (_journalDao != null) {
      return _journalDao;
    } else {
      synchronized(this) {
        if(_journalDao == null) {
          _journalDao = new JournalDao_Impl(this);
        }
        return _journalDao;
      }
    }
  }
}
