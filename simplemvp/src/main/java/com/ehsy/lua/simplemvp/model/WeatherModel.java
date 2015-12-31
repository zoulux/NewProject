package com.ehsy.lua.simplemvp.model;

import com.ehsy.lua.simplemvp.presenter.OnWeatherListener;

/**
 * Created by Lua on 2015/12/22 11:34.
 */
public interface WeatherModel {
    void loadWeather(String cityNo,OnWeatherListener listener);
}
