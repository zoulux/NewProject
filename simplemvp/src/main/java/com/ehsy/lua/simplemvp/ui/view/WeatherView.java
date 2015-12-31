package com.ehsy.lua.simplemvp.ui.view;

/**
 * Created by Lua on 2015/12/22 11:38.
 */
public interface WeatherView {
    void showLoading();
    void hidenLoading();
    void showError();
    void setWeatherInfo();
}
