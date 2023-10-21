package com.github.mcgalanes.groomr.core.data.local.entity.converter

import androidx.room.TypeConverter
import com.github.mcgalanes.groomr.core.data.local.entity.GherkinLineEntity.GherkinKey

class Converter {
    @TypeConverter fun toGherkinKey(value: String): GherkinKey = enumValueOf<GherkinKey>(value)
    @TypeConverter fun fromGherkinKey(key: GherkinKey): String = key.name
}
