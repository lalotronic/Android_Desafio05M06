package com.desafiolatam.weatherlatamtest1.data.local;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class WeatherDao_Impl implements WeatherDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<WeatherEntity> __insertionAdapterOfWeatherEntity;

  private final SharedSQLiteStatement __preparedStmtOfClearAll;

  private final SharedSQLiteStatement __preparedStmtOfDeleteById;

  public WeatherDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfWeatherEntity = new EntityInsertionAdapter<WeatherEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `weather` (`id`,`currentTemp`,`maxTemp`,`minTemp`,`pressure`,`humidity`,`windSpeed`,`sunrise`,`sunset`,`cityName`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, WeatherEntity value) {
        stmt.bindLong(1, value.getId());
        stmt.bindDouble(2, value.getCurrentTemp());
        stmt.bindDouble(3, value.getMaxTemp());
        stmt.bindDouble(4, value.getMinTemp());
        stmt.bindDouble(5, value.getPressure());
        stmt.bindDouble(6, value.getHumidity());
        stmt.bindDouble(7, value.getWindSpeed());
        stmt.bindLong(8, value.getSunrise());
        stmt.bindLong(9, value.getSunset());
        if (value.getCityName() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getCityName());
        }
      }
    };
    this.__preparedStmtOfClearAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM weather";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteById = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM weather WHERE id =?";
        return _query;
      }
    };
  }

  @Override
  public Object insertData(final WeatherEntity weatherEntity,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfWeatherEntity.insert(weatherEntity);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object clearAll(final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfClearAll.acquire();
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
          __preparedStmtOfClearAll.release(_stmt);
        }
      }
    }, continuation);
  }

  @Override
  public Object deleteById(final int id, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteById.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, id);
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
          __preparedStmtOfDeleteById.release(_stmt);
        }
      }
    }, continuation);
  }

  @Override
  public Flow<List<WeatherEntity>> getWeatherData() {
    final String _sql = "SELECT * FROM weather";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"weather"}, new Callable<List<WeatherEntity>>() {
      @Override
      public List<WeatherEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfCurrentTemp = CursorUtil.getColumnIndexOrThrow(_cursor, "currentTemp");
          final int _cursorIndexOfMaxTemp = CursorUtil.getColumnIndexOrThrow(_cursor, "maxTemp");
          final int _cursorIndexOfMinTemp = CursorUtil.getColumnIndexOrThrow(_cursor, "minTemp");
          final int _cursorIndexOfPressure = CursorUtil.getColumnIndexOrThrow(_cursor, "pressure");
          final int _cursorIndexOfHumidity = CursorUtil.getColumnIndexOrThrow(_cursor, "humidity");
          final int _cursorIndexOfWindSpeed = CursorUtil.getColumnIndexOrThrow(_cursor, "windSpeed");
          final int _cursorIndexOfSunrise = CursorUtil.getColumnIndexOrThrow(_cursor, "sunrise");
          final int _cursorIndexOfSunset = CursorUtil.getColumnIndexOrThrow(_cursor, "sunset");
          final int _cursorIndexOfCityName = CursorUtil.getColumnIndexOrThrow(_cursor, "cityName");
          final List<WeatherEntity> _result = new ArrayList<WeatherEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final WeatherEntity _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final double _tmpCurrentTemp;
            _tmpCurrentTemp = _cursor.getDouble(_cursorIndexOfCurrentTemp);
            final double _tmpMaxTemp;
            _tmpMaxTemp = _cursor.getDouble(_cursorIndexOfMaxTemp);
            final double _tmpMinTemp;
            _tmpMinTemp = _cursor.getDouble(_cursorIndexOfMinTemp);
            final double _tmpPressure;
            _tmpPressure = _cursor.getDouble(_cursorIndexOfPressure);
            final double _tmpHumidity;
            _tmpHumidity = _cursor.getDouble(_cursorIndexOfHumidity);
            final double _tmpWindSpeed;
            _tmpWindSpeed = _cursor.getDouble(_cursorIndexOfWindSpeed);
            final long _tmpSunrise;
            _tmpSunrise = _cursor.getLong(_cursorIndexOfSunrise);
            final long _tmpSunset;
            _tmpSunset = _cursor.getLong(_cursorIndexOfSunset);
            final String _tmpCityName;
            if (_cursor.isNull(_cursorIndexOfCityName)) {
              _tmpCityName = null;
            } else {
              _tmpCityName = _cursor.getString(_cursorIndexOfCityName);
            }
            _item = new WeatherEntity(_tmpId,_tmpCurrentTemp,_tmpMaxTemp,_tmpMinTemp,_tmpPressure,_tmpHumidity,_tmpWindSpeed,_tmpSunrise,_tmpSunset,_tmpCityName);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<WeatherEntity> getWeatherDataById(final int id) {
    final String _sql = "SELECT * FROM weather WHERE id =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"weather"}, new Callable<WeatherEntity>() {
      @Override
      public WeatherEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfCurrentTemp = CursorUtil.getColumnIndexOrThrow(_cursor, "currentTemp");
          final int _cursorIndexOfMaxTemp = CursorUtil.getColumnIndexOrThrow(_cursor, "maxTemp");
          final int _cursorIndexOfMinTemp = CursorUtil.getColumnIndexOrThrow(_cursor, "minTemp");
          final int _cursorIndexOfPressure = CursorUtil.getColumnIndexOrThrow(_cursor, "pressure");
          final int _cursorIndexOfHumidity = CursorUtil.getColumnIndexOrThrow(_cursor, "humidity");
          final int _cursorIndexOfWindSpeed = CursorUtil.getColumnIndexOrThrow(_cursor, "windSpeed");
          final int _cursorIndexOfSunrise = CursorUtil.getColumnIndexOrThrow(_cursor, "sunrise");
          final int _cursorIndexOfSunset = CursorUtil.getColumnIndexOrThrow(_cursor, "sunset");
          final int _cursorIndexOfCityName = CursorUtil.getColumnIndexOrThrow(_cursor, "cityName");
          final WeatherEntity _result;
          if(_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final double _tmpCurrentTemp;
            _tmpCurrentTemp = _cursor.getDouble(_cursorIndexOfCurrentTemp);
            final double _tmpMaxTemp;
            _tmpMaxTemp = _cursor.getDouble(_cursorIndexOfMaxTemp);
            final double _tmpMinTemp;
            _tmpMinTemp = _cursor.getDouble(_cursorIndexOfMinTemp);
            final double _tmpPressure;
            _tmpPressure = _cursor.getDouble(_cursorIndexOfPressure);
            final double _tmpHumidity;
            _tmpHumidity = _cursor.getDouble(_cursorIndexOfHumidity);
            final double _tmpWindSpeed;
            _tmpWindSpeed = _cursor.getDouble(_cursorIndexOfWindSpeed);
            final long _tmpSunrise;
            _tmpSunrise = _cursor.getLong(_cursorIndexOfSunrise);
            final long _tmpSunset;
            _tmpSunset = _cursor.getLong(_cursorIndexOfSunset);
            final String _tmpCityName;
            if (_cursor.isNull(_cursorIndexOfCityName)) {
              _tmpCityName = null;
            } else {
              _tmpCityName = _cursor.getString(_cursorIndexOfCityName);
            }
            _result = new WeatherEntity(_tmpId,_tmpCurrentTemp,_tmpMaxTemp,_tmpMinTemp,_tmpPressure,_tmpHumidity,_tmpWindSpeed,_tmpSunrise,_tmpSunset,_tmpCityName);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
