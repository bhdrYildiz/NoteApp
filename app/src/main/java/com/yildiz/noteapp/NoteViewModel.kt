package com.yildiz.noteapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewModel (application: Application) : AndroidViewModel(application) {
        val allNotes : LiveData<List<Notes>>
        val repository :NoteRepository

        init {
            val dao = NoteDatabase.getNotesDatabase(application).getNoteDao()
            repository = NoteRepository(dao)
            allNotes = repository.allNotes
        }

    fun deleteNote(note : Notes) = viewModelScope.launch(Dispatchers.IO){
        repository.delete(note)
    }
    fun updateNote(note: Notes) = viewModelScope.launch(Dispatchers.IO){
        repository.update(note)
    }
    fun addNote(note : Notes) = viewModelScope.launch(Dispatchers.IO){
        repository.insert(note)
    }
}