package com.coredata.database

//import androidx.room.*
//import com.coredata.entity.UserEntity
//
//@Dao
//interface UserDao {
//
//
//    @Query("SELECT * FROM userentity Limit 1")
//    fun getUserData(): UserEntity
//
//    //    @Query("SELECT * FROM brands WHERE name LIKE :first AND " + "last_name LIKE :last LIMIT 1")
//    @Query("SELECT * FROM userentity WHERE name LIKE :name")
//    fun findByName(name: String): UserEntity
//
//    @Insert
//    fun insertAll(vararg users: UserEntity)
//
//    @Delete
//    fun delete(user: UserEntity)
//
//}