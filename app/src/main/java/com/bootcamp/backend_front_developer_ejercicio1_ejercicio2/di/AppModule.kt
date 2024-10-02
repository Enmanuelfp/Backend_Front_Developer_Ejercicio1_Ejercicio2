package com.bootcamp.backend_front_developer_ejercicio1_ejercicio2.di

import android.content.Context
import androidx.room.Room
import com.bootcamp.backend_front_developer_ejercicio1_ejercicio2.room.ContactDao
import com.bootcamp.backend_front_developer_ejercicio1_ejercicio2.room.ContactDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providesContactDao(contactDataBase: ContactDataBase): ContactDao {
        return contactDataBase.contactDao()
    }

    @Singleton
    @Provides
    fun providesContactDatabase(@ApplicationContext context: Context): ContactDataBase {
        return Room.databaseBuilder(
            context,
            ContactDataBase::class.java,
            "contacto_db"
        ).fallbackToDestructiveMigration().build()
    }
}
