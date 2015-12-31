package com.ehsy.lua.simplemvp.presenter;

import com.ehsy.lua.simplemvp.model.entity.Weather;

/**
 * Created by Lua on 2015/12/22 11:36.
 */
public interface OnWeatherListener {
    void onSuccess(Weather weather);
    void onError();
}
