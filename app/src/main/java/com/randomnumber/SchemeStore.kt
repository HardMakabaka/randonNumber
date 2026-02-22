package com.randomnumber

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "schemes")

class SchemeStore(private val context: Context) {

    companion object {
        private val SCHEMES_KEY = stringPreferencesKey("schemes_json")
        private val json = Json { ignoreUnknownKeys = true }
    }

    val schemes: Flow<List<Scheme>> = context.dataStore.data.map { prefs ->
        val raw = prefs[SCHEMES_KEY]
        if (raw.isNullOrBlank()) emptyList()
        else runCatching { json.decodeFromString<List<Scheme>>(raw) }.getOrDefault(emptyList())
    }

    suspend fun addScheme(scheme: Scheme) {
        context.dataStore.edit { prefs ->
            val current = currentList(prefs)
            prefs[SCHEMES_KEY] = json.encodeToString(current + scheme)
        }
    }

    suspend fun removeScheme(scheme: Scheme) {
        context.dataStore.edit { prefs ->
            val current = currentList(prefs)
            prefs[SCHEMES_KEY] = json.encodeToString(current.filter { it != scheme })
        }
    }

    private fun currentList(prefs: Preferences): List<Scheme> {
        val raw = prefs[SCHEMES_KEY]
        if (raw.isNullOrBlank()) return emptyList()
        return runCatching { json.decodeFromString<List<Scheme>>(raw) }.getOrDefault(emptyList())
    }
}
