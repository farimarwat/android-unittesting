package com.example.androidunittesting.di

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.androidunittesting.data.DatabaseHelper
import com.example.androidunittesting.data.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class AppModule {

    @Provides
    @Singleton
    fun providesDatabaseHelper(context:Application):DatabaseHelper{
        return Room.databaseBuilder(
            context,
            DatabaseHelper::class.java,
            "users"
        ).build()
    }

    @Provides
    @Singleton
    fun providesUserDao(databaseHelper:DatabaseHelper):UserDao{
        return databaseHelper.getUserDao()
    }
}