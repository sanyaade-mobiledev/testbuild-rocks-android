package rocks.testbuild.utils;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.rightutils.rightutils.utils.CacheUtils;

import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;

import rocks.testbuild.R;
import rocks.testbuild.entities.Cache;
import rocks.testbuild.entities.ResponseError;

/**
 * Created by nnet on 6/27/15.
 */
public class SystemUtils {
	public static ObjectMapper MAPPER;
	static {
		MAPPER = new org.codehaus.jackson.map.ObjectMapper().configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		MAPPER.setDateFormat(Constants.SERVER_DATE_FORMAT);
	}

	public static void getCache(Context context, CacheUtils.CallBack<Cache> callBack) {
		if (context != null) {
			CacheUtils.getCache(MAPPER, Cache.class, context, callBack, true);
		} else {
			Log.e("getCache", "getCache : null context");
		}
	}

	public static void handleError(Context context, ResponseError error) {
		if (error != null) {
			Toast.makeText(context, error.getMessage(), Toast.LENGTH_LONG).show();
		} else {
			Toast.makeText(context, R.string.unknown_error, Toast.LENGTH_LONG).show();
		}
	}
}
