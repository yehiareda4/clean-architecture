package com.coredata.di

//import android.content.Context
//import androidx.room.Room
//import com.coredata.database.AppDatabase
//import dagger.Module
//import dagger.Provides
//import dagger.hilt.InstallIn
//import dagger.hilt.android.qualifiers.ApplicationContext
//import dagger.hilt.components.SingletonComponent
//import javax.inject.Singleton
//
//@Module
//@InstallIn(SingletonComponent::class)
//object DatabaseModule {
//
//
//    @Provides
//    @Singleton
//    fun provideAppDatabase(@ApplicationContext appContext: Context): AppDatabase {
//        return Room
//            .databaseBuilder(
//                appContext,
//                AppDatabase::class.java,
//                "brands"
//            )
//            .build()
//    }
//
//}