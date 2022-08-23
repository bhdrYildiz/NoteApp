package com.yildiz.noteapp

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

abstract class NoteDatabase : RoomDatabase(){

     abstract fun getNoteDao() : NotesDao

     companion object{

      @Volatile
      private var INSTANCE : NoteDatabase? = null

       fun getNotesDatabase(context: Context) : NoteDatabase{
        return INSTANCE ?: synchronized(this){
         val instance = Room.databaseBuilder(
          context.applicationContext,
          NoteDatabase::class.java,
          "note_database"
         ).build()
         INSTANCE = instance
         instance
        }
       }
     }
}