/*
 * Copyright (C) 2019 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.car.settings.tts;

import android.car.drivingstate.CarUxRestrictions;
import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TtsEngines;

import androidx.preference.Preference;

import com.android.car.settings.common.FragmentController;
import com.android.car.settings.common.PreferenceController;

/** Business logic to set the summary for the preferred engine entry setting. */
public class PreferredEngineEntryPreferenceController extends PreferenceController<Preference> {

    private TtsEngines mEnginesHelper;

    public PreferredEngineEntryPreferenceController(Context context, String preferenceKey,
            FragmentController fragmentController, CarUxRestrictions uxRestrictions) {
        super(context, preferenceKey, fragmentController, uxRestrictions);
        mEnginesHelper = new TtsEngines(context);
    }

    @Override
    protected Class<Preference> getPreferenceType() {
        return Preference.class;
    }

    @Override
    protected void updateState(Preference preference) {
        TextToSpeech.EngineInfo info = mEnginesHelper.getEngineInfo(
                mEnginesHelper.getDefaultEngine());
        preference.setSummary(info.label);
    }
}
