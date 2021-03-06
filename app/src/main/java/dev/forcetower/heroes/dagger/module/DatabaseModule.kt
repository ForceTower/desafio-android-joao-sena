package dev.forcetower.heroes.dagger.module

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dev.forcetower.heroes.core.source.local.MarvelDatabase
import javax.inject.Singleton

@Module
object DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(context: Context): MarvelDatabase {
        return Room.inMemoryDatabaseBuilder(context, MarvelDatabase::class.java).build()
    }
}