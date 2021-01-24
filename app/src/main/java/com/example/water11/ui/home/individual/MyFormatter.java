package com.example.water11.ui.home.individual;

import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.formatter.AxisValueFormatter;

import java.text.DecimalFormat;

public class MyFormatter implements AxisValueFormatter {

    private DecimalFormat mFormat;
    String[] strings;

    public MyFormatter() {
        //格式化数字
        mFormat = new DecimalFormat("###,###,##0.0");
    }

    public MyFormatter(String[] strings) {
        this.strings = strings;
    }

    @Override
    public String getFormattedValue(float value, AxisBase axis) {
        if (value == 1) {
            return "个人用水量";
        }
        if (value == 2) {
            return "区域人均用水量";
        }
        if (value == 3) {
            return "个人用水";
        }
        return "";
    }

    @Override
    public int getDecimalDigits() {
        return 0;
    }
}
