package com.ct.io.serializable;

import java.util.prefs.Preferences;

/**
 * Created by Herdsric-M-003 on 2018/5/24.
 */
class PreferencesDemo {
    public static void main(String[] args) {
        Preferences prefs = Preferences.userNodeForPackage(PreferencesDemo.class);
        prefs.put("Location","Oz");
    }
}
